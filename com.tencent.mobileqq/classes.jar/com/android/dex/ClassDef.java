package com.android.dex;

import java.util.List;

public final class ClassDef
{
  public static final int NO_INDEX = -1;
  private final int accessFlags;
  private final int annotationsOffset;
  private final Dex buffer;
  private final int classDataOffset;
  private final int interfacesOffset;
  private final int offset;
  private final int sourceFileIndex;
  private final int staticValuesOffset;
  private final int supertypeIndex;
  private final int typeIndex;
  
  public ClassDef(Dex paramDex, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.buffer = paramDex;
    this.offset = paramInt1;
    this.typeIndex = paramInt2;
    this.accessFlags = paramInt3;
    this.supertypeIndex = paramInt4;
    this.interfacesOffset = paramInt5;
    this.sourceFileIndex = paramInt6;
    this.annotationsOffset = paramInt7;
    this.classDataOffset = paramInt8;
    this.staticValuesOffset = paramInt9;
  }
  
  public int getAccessFlags()
  {
    return this.accessFlags;
  }
  
  public int getAnnotationsOffset()
  {
    return this.annotationsOffset;
  }
  
  public int getClassDataOffset()
  {
    return this.classDataOffset;
  }
  
  public short[] getInterfaces()
  {
    return this.buffer.readTypeList(this.interfacesOffset).getTypes();
  }
  
  public int getInterfacesOffset()
  {
    return this.interfacesOffset;
  }
  
  public int getOffset()
  {
    return this.offset;
  }
  
  public int getSourceFileIndex()
  {
    return this.sourceFileIndex;
  }
  
  public int getStaticValuesOffset()
  {
    return this.staticValuesOffset;
  }
  
  public int getSupertypeIndex()
  {
    return this.supertypeIndex;
  }
  
  public int getTypeIndex()
  {
    return this.typeIndex;
  }
  
  public String toString()
  {
    if (this.buffer == null) {
      return this.typeIndex + " " + this.supertypeIndex;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)this.buffer.typeNames().get(this.typeIndex));
    if (this.supertypeIndex != -1) {
      localStringBuilder.append(" extends ").append((String)this.buffer.typeNames().get(this.supertypeIndex));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.ClassDef
 * JD-Core Version:    0.7.0.1
 */