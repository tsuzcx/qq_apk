package com.android.dx.merge;

import com.android.dex.ClassData;
import com.android.dex.ClassData.Field;
import com.android.dex.ClassData.Method;
import com.android.dex.ClassDef;
import com.android.dex.Code;
import com.android.dex.Code.CatchHandler;
import com.android.dex.Code.Try;
import com.android.dex.Dex;
import com.android.dex.Dex.Section;
import com.android.dex.DexException;
import com.android.dex.EncodedValue;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class DexMerger
{
  private static final byte DBG_ADVANCE_LINE = 2;
  private static final byte DBG_ADVANCE_PC = 1;
  private static final byte DBG_END_LOCAL = 5;
  private static final byte DBG_END_SEQUENCE = 0;
  private static final byte DBG_RESTART_LOCAL = 6;
  private static final byte DBG_SET_EPILOGUE_BEGIN = 8;
  private static final byte DBG_SET_FILE = 9;
  private static final byte DBG_SET_PROLOGUE_END = 7;
  private static final byte DBG_START_LOCAL = 3;
  private static final byte DBG_START_LOCAL_EXTENDED = 4;
  private final Dex.Section annotationOut;
  private final Dex.Section annotationSetOut;
  private final Dex.Section annotationSetRefListOut;
  private final Dex.Section annotationsDirectoryOut;
  private final Dex.Section classDataOut;
  private final Dex.Section codeOut;
  private final CollisionPolicy collisionPolicy;
  private int compactWasteThreshold = 1048576;
  private final TableOfContents contentsOut;
  private final Dex.Section debugInfoOut;
  private final Dex dexOut;
  private final Dex[] dexes;
  private final Dex.Section encodedArrayOut;
  private final Dex.Section headerOut;
  private final Dex.Section idsDefsOut;
  private final IndexMap[] indexMaps;
  private final InstructionTransformer instructionTransformer;
  private final Dex.Section mapListOut;
  private final Dex.Section stringDataOut;
  private final Dex.Section typeListOut;
  private final DexMerger.WriterSizes writerSizes;
  
  public DexMerger(Dex[] paramArrayOfDex, CollisionPolicy paramCollisionPolicy)
  {
    this(paramArrayOfDex, paramCollisionPolicy, new DexMerger.WriterSizes(paramArrayOfDex));
  }
  
  private DexMerger(Dex[] paramArrayOfDex, CollisionPolicy paramCollisionPolicy, DexMerger.WriterSizes paramWriterSizes)
  {
    this.dexes = paramArrayOfDex;
    this.collisionPolicy = paramCollisionPolicy;
    this.writerSizes = paramWriterSizes;
    this.dexOut = new Dex(paramWriterSizes.size());
    this.indexMaps = new IndexMap[paramArrayOfDex.length];
    int i = 0;
    while (i < paramArrayOfDex.length)
    {
      this.indexMaps[i] = new IndexMap(this.dexOut, paramArrayOfDex[i].getTableOfContents());
      i += 1;
    }
    this.instructionTransformer = new InstructionTransformer();
    this.headerOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$000(paramWriterSizes), "header");
    this.idsDefsOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$100(paramWriterSizes), "ids defs");
    this.contentsOut = this.dexOut.getTableOfContents();
    this.contentsOut.dataOff = this.dexOut.getNextSectionStart();
    this.contentsOut.mapList.off = this.dexOut.getNextSectionStart();
    this.contentsOut.mapList.size = 1;
    this.mapListOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$200(paramWriterSizes), "map list");
    this.contentsOut.typeLists.off = this.dexOut.getNextSectionStart();
    this.typeListOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$300(paramWriterSizes), "type list");
    this.contentsOut.annotationSetRefLists.off = this.dexOut.getNextSectionStart();
    this.annotationSetRefListOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$400(paramWriterSizes), "annotation set ref list");
    this.contentsOut.annotationSets.off = this.dexOut.getNextSectionStart();
    this.annotationSetOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$500(paramWriterSizes), "annotation sets");
    this.contentsOut.classDatas.off = this.dexOut.getNextSectionStart();
    this.classDataOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$600(paramWriterSizes), "class data");
    this.contentsOut.codes.off = this.dexOut.getNextSectionStart();
    this.codeOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$700(paramWriterSizes), "code");
    this.contentsOut.stringDatas.off = this.dexOut.getNextSectionStart();
    this.stringDataOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$800(paramWriterSizes), "string data");
    this.contentsOut.debugInfos.off = this.dexOut.getNextSectionStart();
    this.debugInfoOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$900(paramWriterSizes), "debug info");
    this.contentsOut.annotations.off = this.dexOut.getNextSectionStart();
    this.annotationOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$1000(paramWriterSizes), "annotation");
    this.contentsOut.encodedArrays.off = this.dexOut.getNextSectionStart();
    this.encodedArrayOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$1100(paramWriterSizes), "encoded array");
    this.contentsOut.annotationsDirectories.off = this.dexOut.getNextSectionStart();
    this.annotationsDirectoryOut = this.dexOut.appendSection(DexMerger.WriterSizes.access$1200(paramWriterSizes), "annotations directory");
    this.contentsOut.dataSize = (this.dexOut.getNextSectionStart() - this.contentsOut.dataOff);
  }
  
  private SortableType[] getSortedTypes()
  {
    SortableType[] arrayOfSortableType = new SortableType[this.contentsOut.typeIds.size];
    int i = 0;
    while (i < this.dexes.length)
    {
      readSortableTypes(arrayOfSortableType, this.dexes[i], this.indexMaps[i]);
      i += 1;
    }
    boolean bool1;
    do
    {
      bool1 = true;
      int j = arrayOfSortableType.length;
      i = 0;
      while (i < j)
      {
        SortableType localSortableType = arrayOfSortableType[i];
        boolean bool2 = bool1;
        if (localSortableType != null)
        {
          bool2 = bool1;
          if (!localSortableType.isDepthAssigned()) {
            bool2 = bool1 & localSortableType.tryAssignDepth(arrayOfSortableType);
          }
        }
        i += 1;
        bool1 = bool2;
      }
    } while (!bool1);
    Arrays.sort(arrayOfSortableType, SortableType.NULLS_LAST_ORDER);
    i = Arrays.asList(arrayOfSortableType).indexOf(null);
    if (i != -1) {
      return (SortableType[])Arrays.copyOfRange(arrayOfSortableType, 0, i);
    }
    return arrayOfSortableType;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 2)
    {
      printUsage();
      return;
    }
    Dex[] arrayOfDex = new Dex[paramArrayOfString.length - 1];
    int i = 1;
    while (i < paramArrayOfString.length)
    {
      arrayOfDex[(i - 1)] = new Dex(new File(paramArrayOfString[i]));
      i += 1;
    }
    new DexMerger(arrayOfDex, CollisionPolicy.KEEP_FIRST).merge().writeTo(new File(paramArrayOfString[0]));
  }
  
  private void mergeAnnotations()
  {
    new DexMerger.7(this, this.annotationOut).mergeUnsorted();
  }
  
  private int mergeApiLevels()
  {
    int j = -1;
    int i = 0;
    while (i < this.dexes.length)
    {
      int m = this.dexes[i].getTableOfContents().apiLevel;
      int k = j;
      if (j < m) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private void mergeClassDefs()
  {
    SortableType[] arrayOfSortableType = getSortedTypes();
    this.contentsOut.classDefs.off = this.idsDefsOut.getPosition();
    this.contentsOut.classDefs.size = arrayOfSortableType.length;
    int j = arrayOfSortableType.length;
    int i = 0;
    while (i < j)
    {
      SortableType localSortableType = arrayOfSortableType[i];
      transformClassDef(localSortableType.getDex(), localSortableType.getClassDef(), localSortableType.getIndexMap());
      i += 1;
    }
  }
  
  private Dex mergeDexes()
  {
    mergeStringIds();
    mergeTypeIds();
    mergeTypeLists();
    mergeProtoIds();
    mergeFieldIds();
    mergeMethodIds();
    mergeAnnotations();
    unionAnnotationSetsAndDirectories();
    mergeClassDefs();
    this.contentsOut.header.off = 0;
    this.contentsOut.header.size = 1;
    this.contentsOut.fileSize = this.dexOut.getLength();
    this.contentsOut.computeSizesFromOffsets();
    this.contentsOut.writeHeader(this.headerOut, mergeApiLevels());
    this.contentsOut.writeMap(this.mapListOut);
    this.dexOut.writeHashes();
    return this.dexOut;
  }
  
  private void mergeFieldIds()
  {
    new DexMerger.5(this, this.idsDefsOut).mergeSorted();
  }
  
  private void mergeMethodIds()
  {
    new DexMerger.6(this, this.idsDefsOut).mergeSorted();
  }
  
  private void mergeProtoIds()
  {
    new DexMerger.4(this, this.idsDefsOut).mergeSorted();
  }
  
  private void mergeStringIds()
  {
    new DexMerger.1(this, this.idsDefsOut).mergeSorted();
  }
  
  private void mergeTypeIds()
  {
    new DexMerger.2(this, this.idsDefsOut).mergeSorted();
  }
  
  private void mergeTypeLists()
  {
    new DexMerger.3(this, this.typeListOut).mergeUnsorted();
  }
  
  private static void printUsage()
  {
    System.out.println("Usage: DexMerger <out.dex> <a.dex> <b.dex> ...");
    System.out.println();
    System.out.println("If a class is defined in several dex, the class found in the first dex will be used.");
  }
  
  private void readSortableTypes(SortableType[] paramArrayOfSortableType, Dex paramDex, IndexMap paramIndexMap)
  {
    Iterator localIterator = paramDex.classDefs().iterator();
    while (localIterator.hasNext())
    {
      ClassDef localClassDef = (ClassDef)localIterator.next();
      SortableType localSortableType = paramIndexMap.adjust(new SortableType(paramDex, paramIndexMap, localClassDef));
      int i = localSortableType.getTypeIndex();
      if (paramArrayOfSortableType[i] == null) {
        paramArrayOfSortableType[i] = localSortableType;
      } else if (this.collisionPolicy != CollisionPolicy.KEEP_FIRST) {
        throw new DexException("Multiple dex files define " + (String)paramDex.typeNames().get(localClassDef.getTypeIndex()));
      }
    }
  }
  
  private void transformAnnotationDirectories(Dex paramDex, IndexMap paramIndexMap)
  {
    TableOfContents.Section localSection = paramDex.getTableOfContents().annotationsDirectories;
    if (localSection.exists())
    {
      paramDex = paramDex.open(localSection.off);
      int i = 0;
      while (i < localSection.size)
      {
        transformAnnotationDirectory(paramDex, paramIndexMap);
        i += 1;
      }
    }
  }
  
  private void transformAnnotationDirectory(Dex.Section paramSection, IndexMap paramIndexMap)
  {
    int k = 0;
    TableOfContents.Section localSection = this.contentsOut.annotationsDirectories;
    localSection.size += 1;
    this.annotationsDirectoryOut.assertFourByteAligned();
    paramIndexMap.putAnnotationDirectoryOffset(paramSection.getPosition(), this.annotationsDirectoryOut.getPosition());
    int i = paramIndexMap.adjustAnnotationSet(paramSection.readInt());
    this.annotationsDirectoryOut.writeInt(i);
    int j = paramSection.readInt();
    this.annotationsDirectoryOut.writeInt(j);
    int n = paramSection.readInt();
    this.annotationsDirectoryOut.writeInt(n);
    int m = paramSection.readInt();
    this.annotationsDirectoryOut.writeInt(m);
    i = 0;
    while (i < j)
    {
      this.annotationsDirectoryOut.writeInt(paramIndexMap.adjustField(paramSection.readInt()));
      this.annotationsDirectoryOut.writeInt(paramIndexMap.adjustAnnotationSet(paramSection.readInt()));
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= n) {
        break;
      }
      this.annotationsDirectoryOut.writeInt(paramIndexMap.adjustMethod(paramSection.readInt()));
      this.annotationsDirectoryOut.writeInt(paramIndexMap.adjustAnnotationSet(paramSection.readInt()));
      i += 1;
    }
    while (j < m)
    {
      this.annotationsDirectoryOut.writeInt(paramIndexMap.adjustMethod(paramSection.readInt()));
      this.annotationsDirectoryOut.writeInt(paramIndexMap.adjustAnnotationSetRefList(paramSection.readInt()));
      j += 1;
    }
  }
  
  private void transformAnnotationSet(IndexMap paramIndexMap, Dex.Section paramSection)
  {
    TableOfContents.Section localSection = this.contentsOut.annotationSets;
    localSection.size += 1;
    this.annotationSetOut.assertFourByteAligned();
    paramIndexMap.putAnnotationSetOffset(paramSection.getPosition(), this.annotationSetOut.getPosition());
    int j = paramSection.readInt();
    this.annotationSetOut.writeInt(j);
    int i = 0;
    while (i < j)
    {
      this.annotationSetOut.writeInt(paramIndexMap.adjustAnnotation(paramSection.readInt()));
      i += 1;
    }
  }
  
  private void transformAnnotationSetRefList(IndexMap paramIndexMap, Dex.Section paramSection)
  {
    TableOfContents.Section localSection = this.contentsOut.annotationSetRefLists;
    localSection.size += 1;
    this.annotationSetRefListOut.assertFourByteAligned();
    paramIndexMap.putAnnotationSetRefListOffset(paramSection.getPosition(), this.annotationSetRefListOut.getPosition());
    int j = paramSection.readInt();
    this.annotationSetRefListOut.writeInt(j);
    int i = 0;
    while (i < j)
    {
      this.annotationSetRefListOut.writeInt(paramIndexMap.adjustAnnotationSet(paramSection.readInt()));
      i += 1;
    }
  }
  
  private void transformAnnotationSetRefLists(Dex paramDex, IndexMap paramIndexMap)
  {
    TableOfContents.Section localSection = paramDex.getTableOfContents().annotationSetRefLists;
    if (localSection.exists())
    {
      paramDex = paramDex.open(localSection.off);
      int i = 0;
      while (i < localSection.size)
      {
        transformAnnotationSetRefList(paramIndexMap, paramDex);
        i += 1;
      }
    }
  }
  
  private void transformAnnotationSets(Dex paramDex, IndexMap paramIndexMap)
  {
    TableOfContents.Section localSection = paramDex.getTableOfContents().annotationSets;
    if (localSection.exists())
    {
      paramDex = paramDex.open(localSection.off);
      int i = 0;
      while (i < localSection.size)
      {
        transformAnnotationSet(paramIndexMap, paramDex);
        i += 1;
      }
    }
  }
  
  private int[] transformCatchHandlers(IndexMap paramIndexMap, Code.CatchHandler[] paramArrayOfCatchHandler)
  {
    int j = this.codeOut.getPosition();
    this.codeOut.writeUleb128(paramArrayOfCatchHandler.length);
    int[] arrayOfInt = new int[paramArrayOfCatchHandler.length];
    int i = 0;
    while (i < paramArrayOfCatchHandler.length)
    {
      arrayOfInt[i] = (this.codeOut.getPosition() - j);
      transformEncodedCatchHandler(paramArrayOfCatchHandler[i], paramIndexMap);
      i += 1;
    }
    return arrayOfInt;
  }
  
  private void transformClassData(Dex paramDex, ClassData paramClassData, IndexMap paramIndexMap)
  {
    Object localObject = this.contentsOut.classDatas;
    ((TableOfContents.Section)localObject).size += 1;
    localObject = paramClassData.getStaticFields();
    ClassData.Field[] arrayOfField = paramClassData.getInstanceFields();
    ClassData.Method[] arrayOfMethod = paramClassData.getDirectMethods();
    paramClassData = paramClassData.getVirtualMethods();
    this.classDataOut.writeUleb128(localObject.length);
    this.classDataOut.writeUleb128(arrayOfField.length);
    this.classDataOut.writeUleb128(arrayOfMethod.length);
    this.classDataOut.writeUleb128(paramClassData.length);
    transformFields(paramIndexMap, (ClassData.Field[])localObject);
    transformFields(paramIndexMap, arrayOfField);
    transformMethods(paramDex, paramIndexMap, arrayOfMethod);
    transformMethods(paramDex, paramIndexMap, paramClassData);
  }
  
  private void transformClassDef(Dex paramDex, ClassDef paramClassDef, IndexMap paramIndexMap)
  {
    this.idsDefsOut.assertFourByteAligned();
    this.idsDefsOut.writeInt(paramClassDef.getTypeIndex());
    this.idsDefsOut.writeInt(paramClassDef.getAccessFlags());
    this.idsDefsOut.writeInt(paramClassDef.getSupertypeIndex());
    this.idsDefsOut.writeInt(paramClassDef.getInterfacesOffset());
    int i = paramIndexMap.adjustString(paramClassDef.getSourceFileIndex());
    this.idsDefsOut.writeInt(i);
    i = paramClassDef.getAnnotationsOffset();
    this.idsDefsOut.writeInt(paramIndexMap.adjustAnnotationDirectory(i));
    if (paramClassDef.getClassDataOffset() == 0) {
      this.idsDefsOut.writeInt(0);
    }
    for (;;)
    {
      i = paramClassDef.getStaticValuesOffset();
      this.idsDefsOut.writeInt(paramIndexMap.adjustStaticValues(i));
      return;
      this.idsDefsOut.writeInt(this.classDataOut.getPosition());
      transformClassData(paramDex, paramDex.readClassData(paramClassDef), paramIndexMap);
    }
  }
  
  private void transformCode(Dex paramDex, Code paramCode, IndexMap paramIndexMap)
  {
    Object localObject = this.contentsOut.codes;
    ((TableOfContents.Section)localObject).size += 1;
    this.codeOut.assertFourByteAligned();
    this.codeOut.writeUnsignedShort(paramCode.getRegistersSize());
    this.codeOut.writeUnsignedShort(paramCode.getInsSize());
    this.codeOut.writeUnsignedShort(paramCode.getOutsSize());
    localObject = paramCode.getTries();
    Code.CatchHandler[] arrayOfCatchHandler = paramCode.getCatchHandlers();
    this.codeOut.writeUnsignedShort(localObject.length);
    int i = paramCode.getDebugInfoOffset();
    if (i != 0)
    {
      this.codeOut.writeInt(this.debugInfoOut.getPosition());
      transformDebugInfoItem(paramDex.open(i), paramIndexMap);
    }
    for (;;)
    {
      paramDex = paramCode.getInstructions();
      paramDex = this.instructionTransformer.transform(paramIndexMap, paramDex);
      this.codeOut.writeInt(paramDex.length);
      this.codeOut.write(paramDex);
      if (localObject.length > 0)
      {
        if (paramDex.length % 2 == 1) {
          this.codeOut.writeShort((short)0);
        }
        paramDex = this.dexOut.open(this.codeOut.getPosition());
        this.codeOut.skip(localObject.length * 8);
        transformTries(paramDex, (Code.Try[])localObject, transformCatchHandlers(paramIndexMap, arrayOfCatchHandler));
      }
      return;
      this.codeOut.writeInt(0);
    }
  }
  
  private void transformDebugInfoItem(Dex.Section paramSection, IndexMap paramIndexMap)
  {
    TableOfContents.Section localSection = this.contentsOut.debugInfos;
    localSection.size += 1;
    int i = paramSection.readUleb128();
    this.debugInfoOut.writeUleb128(i);
    int j = paramSection.readUleb128();
    this.debugInfoOut.writeUleb128(j);
    i = 0;
    while (i < j)
    {
      int k = paramSection.readUleb128p1();
      this.debugInfoOut.writeUleb128p1(paramIndexMap.adjustString(k));
      i += 1;
    }
    for (;;)
    {
      i = paramSection.readByte();
      this.debugInfoOut.writeByte(i);
      switch (i)
      {
      case 7: 
      case 8: 
      default: 
        break;
      case 0: 
        return;
      case 1: 
        i = paramSection.readUleb128();
        this.debugInfoOut.writeUleb128(i);
        break;
      case 2: 
        i = paramSection.readSleb128();
        this.debugInfoOut.writeSleb128(i);
        break;
      case 3: 
      case 4: 
        j = paramSection.readUleb128();
        this.debugInfoOut.writeUleb128(j);
        j = paramSection.readUleb128p1();
        this.debugInfoOut.writeUleb128p1(paramIndexMap.adjustString(j));
        j = paramSection.readUleb128p1();
        this.debugInfoOut.writeUleb128p1(paramIndexMap.adjustType(j));
        if (i == 4)
        {
          i = paramSection.readUleb128p1();
          this.debugInfoOut.writeUleb128p1(paramIndexMap.adjustString(i));
        }
        break;
      case 5: 
      case 6: 
        i = paramSection.readUleb128();
        this.debugInfoOut.writeUleb128(i);
        break;
      case 9: 
        i = paramSection.readUleb128p1();
        this.debugInfoOut.writeUleb128p1(paramIndexMap.adjustString(i));
      }
    }
  }
  
  private void transformEncodedCatchHandler(Code.CatchHandler paramCatchHandler, IndexMap paramIndexMap)
  {
    int j = paramCatchHandler.getCatchAllAddress();
    int[] arrayOfInt = paramCatchHandler.getTypeIndexes();
    paramCatchHandler = paramCatchHandler.getAddresses();
    if (j != -1) {
      this.codeOut.writeSleb128(-arrayOfInt.length);
    }
    for (;;)
    {
      int i = 0;
      while (i < arrayOfInt.length)
      {
        this.codeOut.writeUleb128(paramIndexMap.adjustType(arrayOfInt[i]));
        this.codeOut.writeUleb128(paramCatchHandler[i]);
        i += 1;
      }
      this.codeOut.writeSleb128(arrayOfInt.length);
    }
    if (j != -1) {
      this.codeOut.writeUleb128(j);
    }
  }
  
  private void transformFields(IndexMap paramIndexMap, ClassData.Field[] paramArrayOfField)
  {
    int i = 0;
    int m = paramArrayOfField.length;
    int k;
    for (int j = 0; i < m; j = k)
    {
      ClassData.Field localField = paramArrayOfField[i];
      k = paramIndexMap.adjustField(localField.getFieldIndex());
      this.classDataOut.writeUleb128(k - j);
      this.classDataOut.writeUleb128(localField.getAccessFlags());
      i += 1;
    }
  }
  
  private void transformMethods(Dex paramDex, IndexMap paramIndexMap, ClassData.Method[] paramArrayOfMethod)
  {
    int m = paramArrayOfMethod.length;
    int i = 0;
    int j = 0;
    if (i < m)
    {
      ClassData.Method localMethod = paramArrayOfMethod[i];
      int k = paramIndexMap.adjustMethod(localMethod.getMethodIndex());
      this.classDataOut.writeUleb128(k - j);
      this.classDataOut.writeUleb128(localMethod.getAccessFlags());
      if (localMethod.getCodeOffset() == 0) {
        this.classDataOut.writeUleb128(0);
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        this.codeOut.alignToFourBytesWithZeroFill();
        this.classDataOut.writeUleb128(this.codeOut.getPosition());
        transformCode(paramDex, paramDex.readCode(localMethod), paramIndexMap);
      }
    }
  }
  
  private void transformStaticValues(Dex.Section paramSection, IndexMap paramIndexMap)
  {
    TableOfContents.Section localSection = this.contentsOut.encodedArrays;
    localSection.size += 1;
    paramIndexMap.putStaticValuesOffset(paramSection.getPosition(), this.encodedArrayOut.getPosition());
    paramIndexMap.adjustEncodedArray(paramSection.readEncodedArray()).writeTo(this.encodedArrayOut);
  }
  
  private void transformStaticValues(Dex paramDex, IndexMap paramIndexMap)
  {
    TableOfContents.Section localSection = paramDex.getTableOfContents().encodedArrays;
    if (localSection.exists())
    {
      paramDex = paramDex.open(localSection.off);
      int i = 0;
      while (i < localSection.size)
      {
        transformStaticValues(paramDex, paramIndexMap);
        i += 1;
      }
    }
  }
  
  private void transformTries(Dex.Section paramSection, Code.Try[] paramArrayOfTry, int[] paramArrayOfInt)
  {
    int j = paramArrayOfTry.length;
    int i = 0;
    while (i < j)
    {
      Code.Try localTry = paramArrayOfTry[i];
      paramSection.writeInt(localTry.getStartAddress());
      paramSection.writeUnsignedShort(localTry.getInstructionCount());
      paramSection.writeUnsignedShort(paramArrayOfInt[localTry.getCatchHandlerIndex()]);
      i += 1;
    }
  }
  
  private void unionAnnotationSetsAndDirectories()
  {
    int k = 0;
    int i = 0;
    while (i < this.dexes.length)
    {
      transformAnnotationSets(this.dexes[i], this.indexMaps[i]);
      i += 1;
    }
    i = 0;
    while (i < this.dexes.length)
    {
      transformAnnotationSetRefLists(this.dexes[i], this.indexMaps[i]);
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.dexes.length) {
        break;
      }
      transformAnnotationDirectories(this.dexes[i], this.indexMaps[i]);
      i += 1;
    }
    while (j < this.dexes.length)
    {
      transformStaticValues(this.dexes[j], this.indexMaps[j]);
      j += 1;
    }
  }
  
  public Dex merge()
  {
    if (this.dexes.length == 1) {
      return this.dexes[0];
    }
    if (this.dexes.length == 0) {
      return null;
    }
    long l1 = System.nanoTime();
    Dex localDex1 = mergeDexes();
    DexMerger.WriterSizes localWriterSizes = new DexMerger.WriterSizes(this);
    int i = this.writerSizes.size() - localWriterSizes.size();
    if (i > this.compactWasteThreshold)
    {
      localDex1 = this.dexOut;
      Dex localDex2 = new Dex(0);
      CollisionPolicy localCollisionPolicy = CollisionPolicy.FAIL;
      localDex1 = new DexMerger(new Dex[] { localDex1, localDex2 }, localCollisionPolicy, localWriterSizes).mergeDexes();
      System.out.printf("Result compacted from %.1fKiB to %.1fKiB to save %.1fKiB%n", new Object[] { Float.valueOf(this.dexOut.getLength() / 1024.0F), Float.valueOf(localDex1.getLength() / 1024.0F), Float.valueOf(i / 1024.0F) });
    }
    long l2 = System.nanoTime();
    i = 0;
    while (i < this.dexes.length)
    {
      System.out.printf("Merged dex #%d (%d defs/%.1fKiB)%n", new Object[] { Integer.valueOf(i + 1), Integer.valueOf(this.dexes[i].getTableOfContents().classDefs.size), Float.valueOf(this.dexes[i].getLength() / 1024.0F) });
      i += 1;
    }
    System.out.printf("Result is %d defs/%.1fKiB. Took %.1fs%n", new Object[] { Integer.valueOf(localDex1.getTableOfContents().classDefs.size), Float.valueOf(localDex1.getLength() / 1024.0F), Float.valueOf((float)(l2 - l1) / 1.0E+009F) });
    return localDex1;
  }
  
  public void setCompactWasteThreshold(int paramInt)
  {
    this.compactWasteThreshold = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.DexMerger
 * JD-Core Version:    0.7.0.1
 */