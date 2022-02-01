package com.android.dx.ssa;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.rop.type.TypeBearer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class LiteralOpUpgrader
{
  private final SsaMethod ssaMeth;
  
  private LiteralOpUpgrader(SsaMethod paramSsaMethod)
  {
    this.ssaMeth = paramSsaMethod;
  }
  
  private static boolean isConstIntZeroOrKnownNull(RegisterSpec paramRegisterSpec)
  {
    paramRegisterSpec = paramRegisterSpec.getTypeBearer();
    if ((paramRegisterSpec instanceof CstLiteralBits)) {
      return ((CstLiteralBits)paramRegisterSpec).getLongBits() == 0L;
    }
    return false;
  }
  
  public static void process(SsaMethod paramSsaMethod)
  {
    new LiteralOpUpgrader(paramSsaMethod).run();
  }
  
  private void replacePlainInsn(NormalSsaInsn paramNormalSsaInsn, RegisterSpecList paramRegisterSpecList, int paramInt, Constant paramConstant)
  {
    Insn localInsn = paramNormalSsaInsn.getOriginalRopInsn();
    Rop localRop = Rops.ropFor(paramInt, paramNormalSsaInsn.getResult(), paramRegisterSpecList, paramConstant);
    if (paramConstant == null) {}
    for (paramRegisterSpecList = new PlainInsn(localRop, localInsn.getPosition(), paramNormalSsaInsn.getResult(), paramRegisterSpecList);; paramRegisterSpecList = new PlainCstInsn(localRop, localInsn.getPosition(), paramNormalSsaInsn.getResult(), paramRegisterSpecList, paramConstant))
    {
      paramRegisterSpecList = new NormalSsaInsn(paramRegisterSpecList, paramNormalSsaInsn.getBlock());
      paramConstant = paramNormalSsaInsn.getBlock().getInsns();
      this.ssaMeth.onInsnRemoved(paramNormalSsaInsn);
      paramConstant.set(paramConstant.lastIndexOf(paramNormalSsaInsn), paramRegisterSpecList);
      this.ssaMeth.onInsnAdded(paramRegisterSpecList);
      return;
    }
  }
  
  private void run()
  {
    TranslationAdvice localTranslationAdvice = Optimizer.getAdvice();
    this.ssaMeth.forEachInsn(new LiteralOpUpgrader.1(this, localTranslationAdvice));
  }
  
  private boolean tryReplacingWithConstant(NormalSsaInsn paramNormalSsaInsn)
  {
    Rop localRop = paramNormalSsaInsn.getOriginalRopInsn().getOpcode();
    Object localObject = paramNormalSsaInsn.getResult();
    if ((localObject != null) && (!this.ssaMeth.isRegALocal((RegisterSpec)localObject)) && (localRop.getOpcode() != 5))
    {
      localObject = paramNormalSsaInsn.getResult().getTypeBearer();
      if ((((TypeBearer)localObject).isConstant()) && (((TypeBearer)localObject).getBasicType() == 6))
      {
        replacePlainInsn(paramNormalSsaInsn, RegisterSpecList.EMPTY, 5, (Constant)localObject);
        if (localRop.getOpcode() == 56)
        {
          int i = paramNormalSsaInsn.getBlock().getPredecessors().nextSetBit(0);
          paramNormalSsaInsn = ((SsaBasicBlock)this.ssaMeth.getBlocks().get(i)).getInsns();
          replacePlainInsn((NormalSsaInsn)paramNormalSsaInsn.get(paramNormalSsaInsn.size() - 1), RegisterSpecList.EMPTY, 6, null);
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.LiteralOpUpgrader
 * JD-Core Version:    0.7.0.1
 */