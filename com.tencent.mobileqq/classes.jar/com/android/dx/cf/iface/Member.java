package com.android.dx.cf.iface;

import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;

public abstract interface Member
  extends HasAttribute
{
  public abstract int getAccessFlags();
  
  public abstract AttributeList getAttributes();
  
  public abstract CstType getDefiningClass();
  
  public abstract CstString getDescriptor();
  
  public abstract CstString getName();
  
  public abstract CstNat getNat();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.Member
 * JD-Core Version:    0.7.0.1
 */