package com.android.dx.ssa.back;

import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.ssa.BasicRegisterMapper;
import com.android.dx.ssa.NormalSsaInsn;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.BitIntSet;
import com.android.dx.util.IntSet;
import java.util.BitSet;

public class FirstFitAllocator
  extends RegisterAllocator
{
  private static final boolean PRESLOT_PARAMS = true;
  private final BitSet mapped;
  
  public FirstFitAllocator(SsaMethod paramSsaMethod, InterferenceGraph paramInterferenceGraph)
  {
    super(paramSsaMethod, paramInterferenceGraph);
    this.mapped = new BitSet(paramSsaMethod.getRegCount());
  }
  
  private int paramNumberFromMoveParam(NormalSsaInsn paramNormalSsaInsn)
  {
    return ((CstInteger)((CstInsn)paramNormalSsaInsn.getOriginalRopInsn()).getConstant()).getValue();
  }
  
  public RegisterMapper allocateRegisters()
  {
    int i3 = this.ssaMeth.getRegCount();
    BasicRegisterMapper localBasicRegisterMapper = new BasicRegisterMapper(i3);
    int i = this.ssaMeth.getParamWidth();
    int j = 0;
    if (j < i3)
    {
      int m;
      if (this.mapped.get(j)) {
        m = i;
      }
      for (;;)
      {
        j += 1;
        i = m;
        break;
        int n = getCategoryForSsaReg(j);
        BitIntSet localBitIntSet = new BitIntSet(i3);
        this.interference.mergeInterferenceSet(j, localBitIntSet);
        int k;
        int i1;
        label130:
        int i2;
        if (isDefinitionMoveParam(j))
        {
          m = paramNumberFromMoveParam((NormalSsaInsn)this.ssaMeth.getDefinitionForRegister(j));
          localBasicRegisterMapper.addMapping(j, m, n);
          k = 1;
          i1 = j + 1;
          if (i1 >= i3) {
            break label278;
          }
          i2 = n;
          if (!this.mapped.get(i1))
          {
            if (!isDefinitionMoveParam(i1)) {
              break label196;
            }
            i2 = n;
          }
        }
        for (;;)
        {
          i1 += 1;
          n = i2;
          break label130;
          localBasicRegisterMapper.addMapping(j, i, n);
          m = i;
          k = 0;
          break;
          label196:
          i2 = n;
          if (!localBitIntSet.has(i1)) {
            if (k != 0)
            {
              i2 = n;
              if (n < getCategoryForSsaReg(i1)) {}
            }
            else
            {
              this.interference.mergeInterferenceSet(i1, localBitIntSet);
              i2 = Math.max(n, getCategoryForSsaReg(i1));
              localBasicRegisterMapper.addMapping(i1, m, i2);
              this.mapped.set(i1);
            }
          }
        }
        label278:
        this.mapped.set(j);
        m = i;
        if (k == 0) {
          m = i + n;
        }
      }
    }
    return localBasicRegisterMapper;
  }
  
  public boolean wantsParamsMovedHigh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.FirstFitAllocator
 * JD-Core Version:    0.7.0.1
 */