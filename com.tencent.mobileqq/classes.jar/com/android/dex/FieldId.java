package com.android.dex;

import com.android.dex.util.Unsigned;
import java.util.List;

public final class FieldId
  implements Comparable<FieldId>
{
  private final int declaringClassIndex;
  private final Dex dex;
  private final int nameIndex;
  private final int typeIndex;
  
  public FieldId(Dex paramDex, int paramInt1, int paramInt2, int paramInt3)
  {
    this.dex = paramDex;
    this.declaringClassIndex = paramInt1;
    this.typeIndex = paramInt2;
    this.nameIndex = paramInt3;
  }
  
  public int compareTo(FieldId paramFieldId)
  {
    if (this.declaringClassIndex != paramFieldId.declaringClassIndex) {
      return Unsigned.compare(this.declaringClassIndex, paramFieldId.declaringClassIndex);
    }
    if (this.nameIndex != paramFieldId.nameIndex) {
      return Unsigned.compare(this.nameIndex, paramFieldId.nameIndex);
    }
    return Unsigned.compare(this.typeIndex, paramFieldId.typeIndex);
  }
  
  public int getDeclaringClassIndex()
  {
    return this.declaringClassIndex;
  }
  
  public int getNameIndex()
  {
    return this.nameIndex;
  }
  
  public int getTypeIndex()
  {
    return this.typeIndex;
  }
  
  public String toString()
  {
    if (this.dex == null) {
      return this.declaringClassIndex + " " + this.typeIndex + " " + this.nameIndex;
    }
    return (String)this.dex.typeNames().get(this.typeIndex) + "." + (String)this.dex.strings().get(this.nameIndex);
  }
  
  public void writeTo(Dex.Section paramSection)
  {
    paramSection.writeUnsignedShort(this.declaringClassIndex);
    paramSection.writeUnsignedShort(this.typeIndex);
    paramSection.writeInt(this.nameIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.FieldId
 * JD-Core Version:    0.7.0.1
 */