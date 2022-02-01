package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;

public abstract class TypedConstant
  extends Constant
  implements TypeBearer
{
  public final int getBasicFrameType()
  {
    return getType().getBasicFrameType();
  }
  
  public final int getBasicType()
  {
    return getType().getBasicType();
  }
  
  public final TypeBearer getFrameType()
  {
    return this;
  }
  
  public final boolean isConstant()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.TypedConstant
 * JD-Core Version:    0.7.0.1
 */