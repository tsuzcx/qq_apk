package com.android.dx.cf.direct;

import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.StdMethod;
import com.android.dx.cf.iface.StdMethodList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;

final class MethodListParser
  extends MemberListParser
{
  private final StdMethodList methods = new StdMethodList(getCount());
  
  public MethodListParser(DirectClassFile paramDirectClassFile, CstType paramCstType, int paramInt, AttributeFactory paramAttributeFactory)
  {
    super(paramDirectClassFile, paramCstType, paramInt, paramAttributeFactory);
  }
  
  protected int getAttributeContext()
  {
    return 2;
  }
  
  public StdMethodList getList()
  {
    parseIfNecessary();
    return this.methods;
  }
  
  protected String humanAccessFlags(int paramInt)
  {
    return AccessFlags.methodString(paramInt);
  }
  
  protected String humanName()
  {
    return "method";
  }
  
  protected Member set(int paramInt1, int paramInt2, CstNat paramCstNat, AttributeList paramAttributeList)
  {
    paramCstNat = new StdMethod(getDefiner(), paramInt2, paramCstNat, paramAttributeList);
    this.methods.set(paramInt1, paramCstNat);
    return paramCstNat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.MethodListParser
 * JD-Core Version:    0.7.0.1
 */