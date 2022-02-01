package com.android.dx.cf.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import java.util.ArrayList;

public class BytecodeArray$BaseVisitor
  implements BytecodeArray.Visitor
{
  private int previousOffset = -1;
  
  public int getPreviousOffset()
  {
    return this.previousOffset;
  }
  
  public void setPreviousOffset(int paramInt)
  {
    this.previousOffset = paramInt;
  }
  
  public void visitBranch(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void visitConstant(int paramInt1, int paramInt2, int paramInt3, Constant paramConstant, int paramInt4) {}
  
  public void visitInvalid(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void visitLocal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Type paramType, int paramInt5) {}
  
  public void visitNewarray(int paramInt1, int paramInt2, CstType paramCstType, ArrayList<Constant> paramArrayList) {}
  
  public void visitNoArgs(int paramInt1, int paramInt2, int paramInt3, Type paramType) {}
  
  public void visitSwitch(int paramInt1, int paramInt2, int paramInt3, SwitchList paramSwitchList, int paramInt4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.BytecodeArray.BaseVisitor
 * JD-Core Version:    0.7.0.1
 */