package com.android.dex;

import java.util.List;

public final class Annotation
  implements Comparable<Annotation>
{
  private final Dex dex;
  private final EncodedValue encodedAnnotation;
  private final byte visibility;
  
  public Annotation(Dex paramDex, byte paramByte, EncodedValue paramEncodedValue)
  {
    this.dex = paramDex;
    this.visibility = paramByte;
    this.encodedAnnotation = paramEncodedValue;
  }
  
  public int compareTo(Annotation paramAnnotation)
  {
    return this.encodedAnnotation.compareTo(paramAnnotation.encodedAnnotation);
  }
  
  public EncodedValueReader getReader()
  {
    return new EncodedValueReader(this.encodedAnnotation, 29);
  }
  
  public int getTypeIndex()
  {
    EncodedValueReader localEncodedValueReader = getReader();
    localEncodedValueReader.readAnnotation();
    return localEncodedValueReader.getAnnotationType();
  }
  
  public byte getVisibility()
  {
    return this.visibility;
  }
  
  public String toString()
  {
    if (this.dex == null) {
      return this.visibility + " " + getTypeIndex();
    }
    return this.visibility + " " + (String)this.dex.typeNames().get(getTypeIndex());
  }
  
  public void writeTo(Dex.Section paramSection)
  {
    paramSection.writeByte(this.visibility);
    this.encodedAnnotation.writeTo(paramSection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Annotation
 * JD-Core Version:    0.7.0.1
 */