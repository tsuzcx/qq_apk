package com.android.dx.cf.code;

import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;

public final class ReturnAddress
  implements TypeBearer
{
  private final int subroutineAddress;
  
  public ReturnAddress(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("subroutineAddress < 0");
    }
    this.subroutineAddress = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ReturnAddress)) {}
    while (this.subroutineAddress != ((ReturnAddress)paramObject).subroutineAddress) {
      return false;
    }
    return true;
  }
  
  public int getBasicFrameType()
  {
    return Type.RETURN_ADDRESS.getBasicFrameType();
  }
  
  public int getBasicType()
  {
    return Type.RETURN_ADDRESS.getBasicType();
  }
  
  public TypeBearer getFrameType()
  {
    return this;
  }
  
  public int getSubroutineAddress()
  {
    return this.subroutineAddress;
  }
  
  public Type getType()
  {
    return Type.RETURN_ADDRESS;
  }
  
  public int hashCode()
  {
    return this.subroutineAddress;
  }
  
  public boolean isConstant()
  {
    return false;
  }
  
  public String toHuman()
  {
    return toString();
  }
  
  public String toString()
  {
    return "<addr:" + Hex.u2(this.subroutineAddress) + ">";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.ReturnAddress
 * JD-Core Version:    0.7.0.1
 */