package com.android.dx.cf.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import java.util.ArrayList;

class BytecodeArray$ConstantParserVisitor
  extends BytecodeArray.BaseVisitor
{
  Constant cst;
  int length;
  int value;
  
  BytecodeArray$ConstantParserVisitor(BytecodeArray paramBytecodeArray) {}
  
  private void clear()
  {
    this.length = 0;
  }
  
  public int getPreviousOffset()
  {
    return -1;
  }
  
  public void setPreviousOffset(int paramInt) {}
  
  public void visitBranch(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    clear();
  }
  
  public void visitConstant(int paramInt1, int paramInt2, int paramInt3, Constant paramConstant, int paramInt4)
  {
    this.cst = paramConstant;
    this.length = paramInt3;
    this.value = paramInt4;
  }
  
  public void visitInvalid(int paramInt1, int paramInt2, int paramInt3)
  {
    clear();
  }
  
  public void visitLocal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Type paramType, int paramInt5)
  {
    clear();
  }
  
  public void visitNewarray(int paramInt1, int paramInt2, CstType paramCstType, ArrayList<Constant> paramArrayList)
  {
    clear();
  }
  
  public void visitNoArgs(int paramInt1, int paramInt2, int paramInt3, Type paramType)
  {
    clear();
  }
  
  public void visitSwitch(int paramInt1, int paramInt2, int paramInt3, SwitchList paramSwitchList, int paramInt4)
  {
    clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.BytecodeArray.ConstantParserVisitor
 * JD-Core Version:    0.7.0.1
 */