package com.android.dex;

import com.android.dex.util.Unsigned;
import java.util.List;

public final class MethodId
  implements Comparable<MethodId>
{
  private final int declaringClassIndex;
  private final Dex dex;
  private final int nameIndex;
  private final int protoIndex;
  
  public MethodId(Dex paramDex, int paramInt1, int paramInt2, int paramInt3)
  {
    this.dex = paramDex;
    this.declaringClassIndex = paramInt1;
    this.protoIndex = paramInt2;
    this.nameIndex = paramInt3;
  }
  
  public int compareTo(MethodId paramMethodId)
  {
    if (this.declaringClassIndex != paramMethodId.declaringClassIndex) {
      return Unsigned.compare(this.declaringClassIndex, paramMethodId.declaringClassIndex);
    }
    if (this.nameIndex != paramMethodId.nameIndex) {
      return Unsigned.compare(this.nameIndex, paramMethodId.nameIndex);
    }
    return Unsigned.compare(this.protoIndex, paramMethodId.protoIndex);
  }
  
  public int getDeclaringClassIndex()
  {
    return this.declaringClassIndex;
  }
  
  public int getNameIndex()
  {
    return this.nameIndex;
  }
  
  public int getProtoIndex()
  {
    return this.protoIndex;
  }
  
  public String toString()
  {
    if (this.dex == null) {
      return this.declaringClassIndex + " " + this.protoIndex + " " + this.nameIndex;
    }
    return (String)this.dex.typeNames().get(this.declaringClassIndex) + "." + (String)this.dex.strings().get(this.nameIndex) + this.dex.readTypeList(((ProtoId)this.dex.protoIds().get(this.protoIndex)).getParametersOffset());
  }
  
  public void writeTo(Dex.Section paramSection)
  {
    paramSection.writeUnsignedShort(this.declaringClassIndex);
    paramSection.writeUnsignedShort(this.protoIndex);
    paramSection.writeInt(this.nameIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.MethodId
 * JD-Core Version:    0.7.0.1
 */