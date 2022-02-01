package com.android.dx.ssa;

import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.cst.CstInteger;
import java.util.HashSet;

public class MoveParamCombiner
{
  private final SsaMethod ssaMeth;
  
  private MoveParamCombiner(SsaMethod paramSsaMethod)
  {
    this.ssaMeth = paramSsaMethod;
  }
  
  private int getParamIndex(NormalSsaInsn paramNormalSsaInsn)
  {
    return ((CstInteger)((CstInsn)paramNormalSsaInsn.getOriginalRopInsn()).getConstant()).getValue();
  }
  
  public static void process(SsaMethod paramSsaMethod)
  {
    new MoveParamCombiner(paramSsaMethod).run();
  }
  
  private void run()
  {
    RegisterSpec[] arrayOfRegisterSpec = new RegisterSpec[this.ssaMeth.getParamWidth()];
    HashSet localHashSet = new HashSet();
    this.ssaMeth.forEachInsn(new MoveParamCombiner.1(this, arrayOfRegisterSpec, localHashSet));
    this.ssaMeth.deleteInsns(localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.MoveParamCombiner
 * JD-Core Version:    0.7.0.1
 */