package com.android.dx.rop.cst;

public abstract class CstMemberRef
  extends TypedConstant
{
  private final CstType definingClass;
  private final CstNat nat;
  
  CstMemberRef(CstType paramCstType, CstNat paramCstNat)
  {
    if (paramCstType == null) {
      throw new NullPointerException("definingClass == null");
    }
    if (paramCstNat == null) {
      throw new NullPointerException("nat == null");
    }
    this.definingClass = paramCstType;
    this.nat = paramCstNat;
  }
  
  protected int compareTo0(Constant paramConstant)
  {
    paramConstant = (CstMemberRef)paramConstant;
    int i = this.definingClass.compareTo(paramConstant.definingClass);
    if (i != 0) {
      return i;
    }
    return this.nat.getName().compareTo(paramConstant.nat.getName());
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {}
    do
    {
      return false;
      paramObject = (CstMemberRef)paramObject;
    } while ((!this.definingClass.equals(paramObject.definingClass)) || (!this.nat.equals(paramObject.nat)));
    return true;
  }
  
  public final CstType getDefiningClass()
  {
    return this.definingClass;
  }
  
  public final CstNat getNat()
  {
    return this.nat;
  }
  
  public final int hashCode()
  {
    return this.definingClass.hashCode() * 31 ^ this.nat.hashCode();
  }
  
  public final boolean isCategory2()
  {
    return false;
  }
  
  public final String toHuman()
  {
    return this.definingClass.toHuman() + '.' + this.nat.toHuman();
  }
  
  public final String toString()
  {
    return typeName() + '{' + toHuman() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstMemberRef
 * JD-Core Version:    0.7.0.1
 */