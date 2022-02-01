package com.android.dx.merge;

import com.android.dex.Annotation;
import com.android.dex.ClassDef;
import com.android.dex.Dex;
import com.android.dex.EncodedValue;
import com.android.dex.EncodedValueReader;
import com.android.dex.FieldId;
import com.android.dex.MethodId;
import com.android.dex.ProtoId;
import com.android.dex.TableOfContents;
import com.android.dex.TableOfContents.Section;
import com.android.dex.TypeList;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import java.util.HashMap;

public final class IndexMap
{
  private final HashMap<Integer, Integer> annotationDirectoryOffsets;
  private final HashMap<Integer, Integer> annotationOffsets;
  private final HashMap<Integer, Integer> annotationSetOffsets;
  private final HashMap<Integer, Integer> annotationSetRefListOffsets;
  public final short[] fieldIds;
  public final short[] methodIds;
  public final short[] protoIds;
  private final HashMap<Integer, Integer> staticValuesOffsets;
  public final int[] stringIds;
  private final Dex target;
  public final short[] typeIds;
  private final HashMap<Integer, Integer> typeListOffsets;
  
  public IndexMap(Dex paramDex, TableOfContents paramTableOfContents)
  {
    this.target = paramDex;
    this.stringIds = new int[paramTableOfContents.stringIds.size];
    this.typeIds = new short[paramTableOfContents.typeIds.size];
    this.protoIds = new short[paramTableOfContents.protoIds.size];
    this.fieldIds = new short[paramTableOfContents.fieldIds.size];
    this.methodIds = new short[paramTableOfContents.methodIds.size];
    this.typeListOffsets = new HashMap();
    this.annotationOffsets = new HashMap();
    this.annotationSetOffsets = new HashMap();
    this.annotationSetRefListOffsets = new HashMap();
    this.annotationDirectoryOffsets = new HashMap();
    this.staticValuesOffsets = new HashMap();
    this.typeListOffsets.put(Integer.valueOf(0), Integer.valueOf(0));
    this.annotationSetOffsets.put(Integer.valueOf(0), Integer.valueOf(0));
    this.annotationDirectoryOffsets.put(Integer.valueOf(0), Integer.valueOf(0));
    this.staticValuesOffsets.put(Integer.valueOf(0), Integer.valueOf(0));
  }
  
  public Annotation adjust(Annotation paramAnnotation)
  {
    ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
    IndexMap.EncodedValueTransformer.access$100(new IndexMap.EncodedValueTransformer(this, localByteArrayAnnotatedOutput), paramAnnotation.getReader());
    return new Annotation(this.target, paramAnnotation.getVisibility(), new EncodedValue(localByteArrayAnnotatedOutput.toByteArray()));
  }
  
  public ClassDef adjust(ClassDef paramClassDef)
  {
    return new ClassDef(this.target, paramClassDef.getOffset(), adjustType(paramClassDef.getTypeIndex()), paramClassDef.getAccessFlags(), adjustType(paramClassDef.getSupertypeIndex()), adjustTypeListOffset(paramClassDef.getInterfacesOffset()), paramClassDef.getSourceFileIndex(), paramClassDef.getAnnotationsOffset(), paramClassDef.getClassDataOffset(), paramClassDef.getStaticValuesOffset());
  }
  
  public FieldId adjust(FieldId paramFieldId)
  {
    return new FieldId(this.target, adjustType(paramFieldId.getDeclaringClassIndex()), adjustType(paramFieldId.getTypeIndex()), adjustString(paramFieldId.getNameIndex()));
  }
  
  public MethodId adjust(MethodId paramMethodId)
  {
    return new MethodId(this.target, adjustType(paramMethodId.getDeclaringClassIndex()), adjustProto(paramMethodId.getProtoIndex()), adjustString(paramMethodId.getNameIndex()));
  }
  
  public ProtoId adjust(ProtoId paramProtoId)
  {
    return new ProtoId(this.target, adjustString(paramProtoId.getShortyIndex()), adjustType(paramProtoId.getReturnTypeIndex()), adjustTypeListOffset(paramProtoId.getParametersOffset()));
  }
  
  public SortableType adjust(SortableType paramSortableType)
  {
    return new SortableType(paramSortableType.getDex(), paramSortableType.getIndexMap(), adjust(paramSortableType.getClassDef()));
  }
  
  public int adjustAnnotation(int paramInt)
  {
    return ((Integer)this.annotationOffsets.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public int adjustAnnotationDirectory(int paramInt)
  {
    return ((Integer)this.annotationDirectoryOffsets.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public int adjustAnnotationSet(int paramInt)
  {
    return ((Integer)this.annotationSetOffsets.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public int adjustAnnotationSetRefList(int paramInt)
  {
    return ((Integer)this.annotationSetRefListOffsets.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public EncodedValue adjustEncodedArray(EncodedValue paramEncodedValue)
  {
    ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
    IndexMap.EncodedValueTransformer.access$000(new IndexMap.EncodedValueTransformer(this, localByteArrayAnnotatedOutput), new EncodedValueReader(paramEncodedValue, 28));
    return new EncodedValue(localByteArrayAnnotatedOutput.toByteArray());
  }
  
  public EncodedValue adjustEncodedValue(EncodedValue paramEncodedValue)
  {
    ByteArrayAnnotatedOutput localByteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
    new IndexMap.EncodedValueTransformer(this, localByteArrayAnnotatedOutput).transform(new EncodedValueReader(paramEncodedValue));
    return new EncodedValue(localByteArrayAnnotatedOutput.toByteArray());
  }
  
  public int adjustField(int paramInt)
  {
    return this.fieldIds[paramInt] & 0xFFFF;
  }
  
  public int adjustMethod(int paramInt)
  {
    return this.methodIds[paramInt] & 0xFFFF;
  }
  
  public int adjustProto(int paramInt)
  {
    return this.protoIds[paramInt] & 0xFFFF;
  }
  
  public int adjustStaticValues(int paramInt)
  {
    return ((Integer)this.staticValuesOffsets.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public int adjustString(int paramInt)
  {
    if (paramInt == -1) {
      return -1;
    }
    return this.stringIds[paramInt];
  }
  
  public int adjustType(int paramInt)
  {
    if (paramInt == -1) {
      return -1;
    }
    return this.typeIds[paramInt] & 0xFFFF;
  }
  
  public TypeList adjustTypeList(TypeList paramTypeList)
  {
    if (paramTypeList == TypeList.EMPTY) {
      return paramTypeList;
    }
    paramTypeList = (short[])paramTypeList.getTypes().clone();
    int i = 0;
    while (i < paramTypeList.length)
    {
      paramTypeList[i] = ((short)adjustType(paramTypeList[i]));
      i += 1;
    }
    return new TypeList(this.target, paramTypeList);
  }
  
  public int adjustTypeListOffset(int paramInt)
  {
    return ((Integer)this.typeListOffsets.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public void putAnnotationDirectoryOffset(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.annotationDirectoryOffsets.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void putAnnotationOffset(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.annotationOffsets.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void putAnnotationSetOffset(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.annotationSetOffsets.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void putAnnotationSetRefListOffset(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.annotationSetRefListOffsets.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void putStaticValuesOffset(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.staticValuesOffsets.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void putTypeListOffset(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    this.typeListOffsets.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.merge.IndexMap
 * JD-Core Version:    0.7.0.1
 */