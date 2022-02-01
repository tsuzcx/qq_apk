package com.android.dx;

import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;

public final class FieldId<D, V>
{
  final CstFieldRef constant;
  final TypeId<D> declaringType;
  final String name;
  final CstNat nat;
  final TypeId<V> type;
  
  FieldId(TypeId<D> paramTypeId, TypeId<V> paramTypeId1, String paramString)
  {
    if ((paramTypeId == null) || (paramTypeId1 == null) || (paramString == null)) {
      throw new NullPointerException();
    }
    this.declaringType = paramTypeId;
    this.type = paramTypeId1;
    this.name = paramString;
    this.nat = new CstNat(new CstString(paramString), new CstString(paramTypeId1.name));
    this.constant = new CstFieldRef(paramTypeId.constant, this.nat);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof FieldId)) && (((FieldId)paramObject).declaringType.equals(this.declaringType)) && (((FieldId)paramObject).name.equals(this.name));
  }
  
  public TypeId<D> getDeclaringType()
  {
    return this.declaringType;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public TypeId<V> getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return this.declaringType.hashCode() + this.name.hashCode() * 37;
  }
  
  public String toString()
  {
    return this.declaringType + "." + this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.FieldId
 * JD-Core Version:    0.7.0.1
 */