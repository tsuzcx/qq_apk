package com.android.dx.cf.direct;

import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.StdField;
import com.android.dx.cf.iface.StdFieldList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;

final class FieldListParser
  extends MemberListParser
{
  private final StdFieldList fields = new StdFieldList(getCount());
  
  public FieldListParser(DirectClassFile paramDirectClassFile, CstType paramCstType, int paramInt, AttributeFactory paramAttributeFactory)
  {
    super(paramDirectClassFile, paramCstType, paramInt, paramAttributeFactory);
  }
  
  protected int getAttributeContext()
  {
    return 1;
  }
  
  public StdFieldList getList()
  {
    parseIfNecessary();
    return this.fields;
  }
  
  protected String humanAccessFlags(int paramInt)
  {
    return AccessFlags.fieldString(paramInt);
  }
  
  protected String humanName()
  {
    return "field";
  }
  
  protected Member set(int paramInt1, int paramInt2, CstNat paramCstNat, AttributeList paramAttributeList)
  {
    paramCstNat = new StdField(getDefiner(), paramInt2, paramCstNat, paramAttributeList);
    this.fields.set(paramInt1, paramCstNat);
    return paramCstNat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.FieldListParser
 * JD-Core Version:    0.7.0.1
 */