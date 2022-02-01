package com.android.dex;

import com.android.dex.util.Unsigned;
import java.util.List;

public final class ProtoId
  implements Comparable<ProtoId>
{
  private final Dex dex;
  private final int parametersOffset;
  private final int returnTypeIndex;
  private final int shortyIndex;
  
  public ProtoId(Dex paramDex, int paramInt1, int paramInt2, int paramInt3)
  {
    this.dex = paramDex;
    this.shortyIndex = paramInt1;
    this.returnTypeIndex = paramInt2;
    this.parametersOffset = paramInt3;
  }
  
  public int compareTo(ProtoId paramProtoId)
  {
    if (this.returnTypeIndex != paramProtoId.returnTypeIndex) {
      return Unsigned.compare(this.returnTypeIndex, paramProtoId.returnTypeIndex);
    }
    return Unsigned.compare(this.parametersOffset, paramProtoId.parametersOffset);
  }
  
  public int getParametersOffset()
  {
    return this.parametersOffset;
  }
  
  public int getReturnTypeIndex()
  {
    return this.returnTypeIndex;
  }
  
  public int getShortyIndex()
  {
    return this.shortyIndex;
  }
  
  public String toString()
  {
    if (this.dex == null) {
      return this.shortyIndex + " " + this.returnTypeIndex + " " + this.parametersOffset;
    }
    return (String)this.dex.strings().get(this.shortyIndex) + ": " + (String)this.dex.typeNames().get(this.returnTypeIndex) + " " + this.dex.readTypeList(this.parametersOffset);
  }
  
  public void writeTo(Dex.Section paramSection)
  {
    paramSection.writeInt(this.shortyIndex);
    paramSection.writeInt(this.returnTypeIndex);
    paramSection.writeInt(this.parametersOffset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.ProtoId
 * JD-Core Version:    0.7.0.1
 */