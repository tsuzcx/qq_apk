package com.android.dx.dex.file;

import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.android.dx.util.Writers;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

public final class ClassDefItem
  extends IndexedItem
{
  private final int accessFlags;
  private AnnotationsDirectoryItem annotationsDirectory;
  private final ClassDataItem classData;
  private TypeListItem interfaces;
  private final CstString sourceFile;
  private EncodedArrayItem staticValuesItem;
  private final CstType superclass;
  private final CstType thisClass;
  
  public ClassDefItem(CstType paramCstType1, int paramInt, CstType paramCstType2, TypeList paramTypeList, CstString paramCstString)
  {
    if (paramCstType1 == null) {
      throw new NullPointerException("thisClass == null");
    }
    if (paramTypeList == null) {
      throw new NullPointerException("interfaces == null");
    }
    this.thisClass = paramCstType1;
    this.accessFlags = paramInt;
    this.superclass = paramCstType2;
    if (paramTypeList.size() == 0) {}
    for (paramCstType2 = null;; paramCstType2 = new TypeListItem(paramTypeList))
    {
      this.interfaces = paramCstType2;
      this.sourceFile = paramCstString;
      this.classData = new ClassDataItem(paramCstType1);
      this.staticValuesItem = null;
      this.annotationsDirectory = new AnnotationsDirectoryItem();
      return;
    }
  }
  
  public void addContents(DexFile paramDexFile)
  {
    TypeIdsSection localTypeIdsSection = paramDexFile.getTypeIds();
    MixedItemSection localMixedItemSection1 = paramDexFile.getByteData();
    MixedItemSection localMixedItemSection2 = paramDexFile.getWordData();
    MixedItemSection localMixedItemSection3 = paramDexFile.getTypeLists();
    StringIdsSection localStringIdsSection = paramDexFile.getStringIds();
    localTypeIdsSection.intern(this.thisClass);
    if (!this.classData.isEmpty())
    {
      paramDexFile.getClassData().add(this.classData);
      paramDexFile = this.classData.getStaticValuesConstant();
      if (paramDexFile != null) {
        this.staticValuesItem = ((EncodedArrayItem)localMixedItemSection1.intern(new EncodedArrayItem(paramDexFile)));
      }
    }
    if (this.superclass != null) {
      localTypeIdsSection.intern(this.superclass);
    }
    if (this.interfaces != null) {
      this.interfaces = ((TypeListItem)localMixedItemSection3.intern(this.interfaces));
    }
    if (this.sourceFile != null) {
      localStringIdsSection.intern(this.sourceFile);
    }
    if (!this.annotationsDirectory.isEmpty())
    {
      if (this.annotationsDirectory.isInternable()) {
        this.annotationsDirectory = ((AnnotationsDirectoryItem)localMixedItemSection2.intern(this.annotationsDirectory));
      }
    }
    else {
      return;
    }
    localMixedItemSection2.add(this.annotationsDirectory);
  }
  
  public void addDirectMethod(EncodedMethod paramEncodedMethod)
  {
    this.classData.addDirectMethod(paramEncodedMethod);
  }
  
  public void addFieldAnnotations(CstFieldRef paramCstFieldRef, Annotations paramAnnotations, DexFile paramDexFile)
  {
    this.annotationsDirectory.addFieldAnnotations(paramCstFieldRef, paramAnnotations, paramDexFile);
  }
  
  public void addInstanceField(EncodedField paramEncodedField)
  {
    this.classData.addInstanceField(paramEncodedField);
  }
  
  public void addMethodAnnotations(CstMethodRef paramCstMethodRef, Annotations paramAnnotations, DexFile paramDexFile)
  {
    this.annotationsDirectory.addMethodAnnotations(paramCstMethodRef, paramAnnotations, paramDexFile);
  }
  
  public void addParameterAnnotations(CstMethodRef paramCstMethodRef, AnnotationsList paramAnnotationsList, DexFile paramDexFile)
  {
    this.annotationsDirectory.addParameterAnnotations(paramCstMethodRef, paramAnnotationsList, paramDexFile);
  }
  
  public void addStaticField(EncodedField paramEncodedField, Constant paramConstant)
  {
    this.classData.addStaticField(paramEncodedField, paramConstant);
  }
  
  public void addVirtualMethod(EncodedMethod paramEncodedMethod)
  {
    this.classData.addVirtualMethod(paramEncodedMethod);
  }
  
  public void debugPrint(Writer paramWriter, boolean paramBoolean)
  {
    PrintWriter localPrintWriter = Writers.printWriterFor(paramWriter);
    localPrintWriter.println(getClass().getName() + " {");
    localPrintWriter.println("  accessFlags: " + Hex.u2(this.accessFlags));
    localPrintWriter.println("  superclass: " + this.superclass);
    StringBuilder localStringBuilder = new StringBuilder().append("  interfaces: ");
    if (this.interfaces == null)
    {
      localObject = "<none>";
      localPrintWriter.println(localObject);
      localStringBuilder = new StringBuilder().append("  sourceFile: ");
      if (this.sourceFile != null) {
        break label203;
      }
    }
    label203:
    for (Object localObject = "<none>";; localObject = this.sourceFile.toQuoted())
    {
      localPrintWriter.println((String)localObject);
      this.classData.debugPrint(paramWriter, paramBoolean);
      this.annotationsDirectory.debugPrint(localPrintWriter);
      localPrintWriter.println("}");
      return;
      localObject = this.interfaces;
      break;
    }
  }
  
  public int getAccessFlags()
  {
    return this.accessFlags;
  }
  
  public TypeList getInterfaces()
  {
    if (this.interfaces == null) {
      return StdTypeList.EMPTY;
    }
    return this.interfaces.getList();
  }
  
  public Annotations getMethodAnnotations(CstMethodRef paramCstMethodRef)
  {
    return this.annotationsDirectory.getMethodAnnotations(paramCstMethodRef);
  }
  
  public ArrayList<EncodedMethod> getMethods()
  {
    return this.classData.getMethods();
  }
  
  public AnnotationsList getParameterAnnotations(CstMethodRef paramCstMethodRef)
  {
    return this.annotationsDirectory.getParameterAnnotations(paramCstMethodRef);
  }
  
  public CstString getSourceFile()
  {
    return this.sourceFile;
  }
  
  public CstType getSuperclass()
  {
    return this.superclass;
  }
  
  public CstType getThisClass()
  {
    return this.thisClass;
  }
  
  public ItemType itemType()
  {
    return ItemType.TYPE_CLASS_DEF_ITEM;
  }
  
  public void setClassAnnotations(Annotations paramAnnotations, DexFile paramDexFile)
  {
    this.annotationsDirectory.setClassAnnotations(paramAnnotations, paramDexFile);
  }
  
  public int writeSize()
  {
    return 32;
  }
  
  public void writeTo(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput)
  {
    boolean bool = paramAnnotatedOutput.annotates();
    Object localObject = paramDexFile.getTypeIds();
    int i1 = ((TypeIdsSection)localObject).indexOf(this.thisClass);
    int i;
    int i2;
    int j;
    label56:
    int k;
    label66:
    int m;
    label79:
    int i3;
    if (this.superclass == null)
    {
      i = -1;
      i2 = OffsettedItem.getAbsoluteOffsetOr0(this.interfaces);
      if (!this.annotationsDirectory.isEmpty()) {
        break label371;
      }
      j = 0;
      if (this.sourceFile != null) {
        break label383;
      }
      k = -1;
      if (!this.classData.isEmpty()) {
        break label399;
      }
      m = 0;
      i3 = OffsettedItem.getAbsoluteOffsetOr0(this.staticValuesItem);
      if (!bool) {
        break label570;
      }
      paramAnnotatedOutput.annotate(0, indexString() + ' ' + this.thisClass.toHuman());
      paramAnnotatedOutput.annotate(4, "  class_idx:           " + Hex.u4(i1));
      paramAnnotatedOutput.annotate(4, "  access_flags:        " + AccessFlags.classString(this.accessFlags));
      localObject = new StringBuilder().append("  superclass_idx:      ").append(Hex.u4(i)).append(" // ");
      if (this.superclass != null) {
        break label411;
      }
    }
    label399:
    label411:
    for (paramDexFile = "<none>";; paramDexFile = this.superclass.toHuman())
    {
      paramAnnotatedOutput.annotate(4, paramDexFile);
      paramAnnotatedOutput.annotate(4, "  interfaces_off:      " + Hex.u4(i2));
      if (i2 == 0) {
        break label422;
      }
      paramDexFile = this.interfaces.getList();
      int i4 = paramDexFile.size();
      int n = 0;
      while (n < i4)
      {
        paramAnnotatedOutput.annotate(0, "    " + paramDexFile.getType(n).toHuman());
        n += 1;
      }
      i = ((TypeIdsSection)localObject).indexOf(this.superclass);
      break;
      label371:
      j = this.annotationsDirectory.getAbsoluteOffset();
      break label56;
      label383:
      k = paramDexFile.getStringIds().indexOf(this.sourceFile);
      break label66;
      m = this.classData.getAbsoluteOffset();
      break label79;
    }
    label422:
    localObject = new StringBuilder().append("  source_file_idx:     ").append(Hex.u4(k)).append(" // ");
    if (this.sourceFile == null) {}
    for (paramDexFile = "<none>";; paramDexFile = this.sourceFile.toHuman())
    {
      paramAnnotatedOutput.annotate(4, paramDexFile);
      paramAnnotatedOutput.annotate(4, "  annotations_off:     " + Hex.u4(j));
      paramAnnotatedOutput.annotate(4, "  class_data_off:      " + Hex.u4(m));
      paramAnnotatedOutput.annotate(4, "  static_values_off:   " + Hex.u4(i3));
      label570:
      paramAnnotatedOutput.writeInt(i1);
      paramAnnotatedOutput.writeInt(this.accessFlags);
      paramAnnotatedOutput.writeInt(i);
      paramAnnotatedOutput.writeInt(i2);
      paramAnnotatedOutput.writeInt(k);
      paramAnnotatedOutput.writeInt(j);
      paramAnnotatedOutput.writeInt(m);
      paramAnnotatedOutput.writeInt(i3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.ClassDefItem
 * JD-Core Version:    0.7.0.1
 */