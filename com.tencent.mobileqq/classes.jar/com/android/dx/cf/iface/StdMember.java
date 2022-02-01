package com.android.dx.cf.iface;

import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;

public abstract class StdMember
  implements Member
{
  private final int accessFlags;
  private final AttributeList attributes;
  private final CstType definingClass;
  private final CstNat nat;
  
  public StdMember(CstType paramCstType, int paramInt, CstNat paramCstNat, AttributeList paramAttributeList)
  {
    if (paramCstType == null) {
      throw new NullPointerException("definingClass == null");
    }
    if (paramCstNat == null) {
      throw new NullPointerException("nat == null");
    }
    if (paramAttributeList == null) {
      throw new NullPointerException("attributes == null");
    }
    this.definingClass = paramCstType;
    this.accessFlags = paramInt;
    this.nat = paramCstNat;
    this.attributes = paramAttributeList;
  }
  
  public final int getAccessFlags()
  {
    return this.accessFlags;
  }
  
  public final AttributeList getAttributes()
  {
    return this.attributes;
  }
  
  public final CstType getDefiningClass()
  {
    return this.definingClass;
  }
  
  public final CstString getDescriptor()
  {
    return this.nat.getDescriptor();
  }
  
  public final CstString getName()
  {
    return this.nat.getName();
  }
  
  public final CstNat getNat()
  {
    return this.nat;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append('{');
    localStringBuffer.append(this.nat.toHuman());
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.StdMember
 * JD-Core Version:    0.7.0.1
 */