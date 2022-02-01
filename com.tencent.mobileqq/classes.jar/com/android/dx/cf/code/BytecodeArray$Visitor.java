package com.android.dx.cf.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import java.util.ArrayList;

public abstract interface BytecodeArray$Visitor
{
  public abstract int getPreviousOffset();
  
  public abstract void setPreviousOffset(int paramInt);
  
  public abstract void visitBranch(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void visitConstant(int paramInt1, int paramInt2, int paramInt3, Constant paramConstant, int paramInt4);
  
  public abstract void visitInvalid(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void visitLocal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Type paramType, int paramInt5);
  
  public abstract void visitNewarray(int paramInt1, int paramInt2, CstType paramCstType, ArrayList<Constant> paramArrayList);
  
  public abstract void visitNoArgs(int paramInt1, int paramInt2, int paramInt3, Type paramType);
  
  public abstract void visitSwitch(int paramInt1, int paramInt2, int paramInt3, SwitchList paramSwitchList, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.BytecodeArray.Visitor
 * JD-Core Version:    0.7.0.1
 */