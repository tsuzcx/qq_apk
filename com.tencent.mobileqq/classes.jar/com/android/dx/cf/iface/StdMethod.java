package com.android.dx.cf.iface;

import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;

public final class StdMethod
  extends StdMember
  implements Method
{
  private final Prototype effectiveDescriptor;
  
  public StdMethod(CstType paramCstType, int paramInt, CstNat paramCstNat, AttributeList paramAttributeList)
  {
    super(paramCstType, paramInt, paramCstNat, paramAttributeList);
    this.effectiveDescriptor = Prototype.intern(getDescriptor().getString(), paramCstType.getClassType(), AccessFlags.isStatic(paramInt), paramCstNat.isInstanceInit());
  }
  
  public Prototype getEffectiveDescriptor()
  {
    return this.effectiveDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.StdMethod
 * JD-Core Version:    0.7.0.1
 */