package com.android.dx;

import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Prototype;
import java.util.List;

public final class MethodId<D, R>
{
  final CstMethodRef constant;
  final TypeId<D> declaringType;
  final String name;
  final CstNat nat;
  final TypeList parameters;
  final TypeId<R> returnType;
  
  MethodId(TypeId<D> paramTypeId, TypeId<R> paramTypeId1, String paramString, TypeList paramTypeList)
  {
    if ((paramTypeId == null) || (paramTypeId1 == null) || (paramString == null) || (paramTypeList == null)) {
      throw new NullPointerException();
    }
    this.declaringType = paramTypeId;
    this.returnType = paramTypeId1;
    this.name = paramString;
    this.parameters = paramTypeList;
    this.nat = new CstNat(new CstString(paramString), new CstString(descriptor(false)));
    this.constant = new CstMethodRef(paramTypeId.constant, this.nat);
  }
  
  String descriptor(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    if (paramBoolean) {
      localStringBuilder.append(this.declaringType.name);
    }
    TypeId[] arrayOfTypeId = this.parameters.types;
    int j = arrayOfTypeId.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(arrayOfTypeId[i].name);
      i += 1;
    }
    localStringBuilder.append(")");
    localStringBuilder.append(this.returnType.name);
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof MethodId)) && (((MethodId)paramObject).declaringType.equals(this.declaringType)) && (((MethodId)paramObject).name.equals(this.name)) && (((MethodId)paramObject).parameters.equals(this.parameters)) && (((MethodId)paramObject).returnType.equals(this.returnType));
  }
  
  public TypeId<D> getDeclaringType()
  {
    return this.declaringType;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public List<TypeId<?>> getParameters()
  {
    return this.parameters.asList();
  }
  
  public TypeId<R> getReturnType()
  {
    return this.returnType;
  }
  
  public int hashCode()
  {
    return (((this.declaringType.hashCode() + 527) * 31 + this.name.hashCode()) * 31 + this.parameters.hashCode()) * 31 + this.returnType.hashCode();
  }
  
  public boolean isConstructor()
  {
    return this.name.equals("<init>");
  }
  
  public boolean isStaticInitializer()
  {
    return this.name.equals("<clinit>");
  }
  
  Prototype prototype(boolean paramBoolean)
  {
    return Prototype.intern(descriptor(paramBoolean));
  }
  
  public String toString()
  {
    return this.declaringType + "." + this.name + "(" + this.parameters + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.MethodId
 * JD-Core Version:    0.7.0.1
 */