package com.android.dx.rop.cst;

import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;

public abstract class CstBaseMethodRef
  extends CstMemberRef
{
  private Prototype instancePrototype = null;
  private final Prototype prototype = Prototype.intern(getNat().getDescriptor().getString());
  
  CstBaseMethodRef(CstType paramCstType, CstNat paramCstNat)
  {
    super(paramCstType, paramCstNat);
  }
  
  protected final int compareTo0(Constant paramConstant)
  {
    int i = super.compareTo0(paramConstant);
    if (i != 0) {
      return i;
    }
    paramConstant = (CstBaseMethodRef)paramConstant;
    return this.prototype.compareTo(paramConstant.prototype);
  }
  
  public final int getParameterWordCount(boolean paramBoolean)
  {
    return getPrototype(paramBoolean).getParameterTypes().getWordCount();
  }
  
  public final Prototype getPrototype()
  {
    return this.prototype;
  }
  
  public final Prototype getPrototype(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.prototype;
    }
    if (this.instancePrototype == null)
    {
      Type localType = getDefiningClass().getClassType();
      this.instancePrototype = this.prototype.withFirstParameter(localType);
    }
    return this.instancePrototype;
  }
  
  public final Type getType()
  {
    return this.prototype.getReturnType();
  }
  
  public final boolean isClassInit()
  {
    return getNat().isClassInit();
  }
  
  public final boolean isInstanceInit()
  {
    return getNat().isInstanceInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.cst.CstBaseMethodRef
 * JD-Core Version:    0.7.0.1
 */