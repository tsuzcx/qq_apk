package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;

public final class CstNat
  extends Constant
{
  public static final CstNat PRIMITIVE_TYPE_NAT = new CstNat(new CstString("TYPE"), new CstString("Ljava/lang/Class;"));
  private final CstString descriptor;
  private final CstString name;
  
  public CstNat(CstString paramCstString1, CstString paramCstString2)
  {
    if (paramCstString1 == null) {
      throw new NullPointerException("name == null");
    }
    if (paramCstString2 == null) {
      throw new NullPointerException("descriptor == null");
    }
    this.name = paramCstString1;
    this.descriptor = paramCstString2;
  }
  
  protected int compareTo0(Constant paramConstant)
  {
    paramConstant = (CstNat)paramConstant;
    int i = this.name.compareTo(paramConstant.name);
    if (i != 0) {
      return i;
    }
    return this.descriptor.compareTo(paramConstant.descriptor);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CstNat)) {}
    do
    {
      return false;
      paramObject = (CstNat)paramObject;
    } while ((!this.name.equals(paramObject.name)) || (!this.descriptor.equals(paramObject.descriptor)));
    return true;
  }
  
  public CstString getDescriptor()
  {
    return this.descriptor;
  }
  
  public Type getFieldType()
  {
    return Type.intern(this.descriptor.getString());
  }
  
  public CstString getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return this.name.hashCode() * 31 ^ this.descriptor.hashCode();
  }
  
  public boolean isCategory2()
  {
    return false;
  }
  
  public final boolean isClassInit()
  {
    return this.name.getString().equals("<clinit>");
  }
  
  public final boolean isInstanceInit()
  {
    return this.name.getString().equals("<init>");
  }
  
  public String toHuman()
  {
    return this.name.toHuman() + ':' + this.descriptor.toHuman();
  }
  
  public String toString()
  {
    return "nat{" + toHuman() + '}';
  }
  
  public String typeName()
  {
    return "nat";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstNat
 * JD-Core Version:    0.7.0.1
 */