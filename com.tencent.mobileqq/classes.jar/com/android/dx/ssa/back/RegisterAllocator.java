package com.android.dx.ssa.back;

import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.ssa.NormalSsaInsn;
import com.android.dx.ssa.RegisterMapper;
import com.android.dx.ssa.SsaBasicBlock;
import com.android.dx.ssa.SsaInsn;
import com.android.dx.ssa.SsaMethod;
import com.android.dx.util.IntIterator;
import com.android.dx.util.IntSet;
import java.util.ArrayList;

public abstract class RegisterAllocator
{
  protected final InterferenceGraph interference;
  protected final SsaMethod ssaMeth;
  
  public RegisterAllocator(SsaMethod paramSsaMethod, InterferenceGraph paramInterferenceGraph)
  {
    this.ssaMeth = paramSsaMethod;
    this.interference = paramInterferenceGraph;
  }
  
  public abstract RegisterMapper allocateRegisters();
  
  protected final int getCategoryForSsaReg(int paramInt)
  {
    SsaInsn localSsaInsn = this.ssaMeth.getDefinitionForRegister(paramInt);
    if (localSsaInsn == null) {
      return 1;
    }
    return localSsaInsn.getResult().getCategory();
  }
  
  protected final RegisterSpec getDefinitionSpecForSsaReg(int paramInt)
  {
    SsaInsn localSsaInsn = this.ssaMeth.getDefinitionForRegister(paramInt);
    if (localSsaInsn == null) {
      return null;
    }
    return localSsaInsn.getResult();
  }
  
  protected final RegisterSpec insertMoveBefore(SsaInsn paramSsaInsn, RegisterSpec paramRegisterSpec)
  {
    SsaBasicBlock localSsaBasicBlock = paramSsaInsn.getBlock();
    ArrayList localArrayList = localSsaBasicBlock.getInsns();
    int i = localArrayList.indexOf(paramSsaInsn);
    if (i < 0) {
      throw new IllegalArgumentException("specified insn is not in this block");
    }
    if (i != localArrayList.size() - 1) {
      throw new IllegalArgumentException("Adding move here not supported:" + paramSsaInsn.toHuman());
    }
    RegisterSpec localRegisterSpec = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), paramRegisterSpec.getTypeBearer());
    localArrayList.add(i, SsaInsn.makeFromRop(new PlainInsn(Rops.opMove(localRegisterSpec.getType()), SourcePosition.NO_INFO, localRegisterSpec, RegisterSpecList.make(paramRegisterSpec)), localSsaBasicBlock));
    int j = localRegisterSpec.getReg();
    paramRegisterSpec = localSsaBasicBlock.getLiveOutRegs().iterator();
    while (paramRegisterSpec.hasNext()) {
      this.interference.add(j, paramRegisterSpec.next());
    }
    paramSsaInsn = paramSsaInsn.getSources();
    int k = paramSsaInsn.size();
    i = 0;
    while (i < k)
    {
      this.interference.add(j, paramSsaInsn.get(i).getReg());
      i += 1;
    }
    this.ssaMeth.onInsnsChanged();
    return localRegisterSpec;
  }
  
  protected boolean isDefinitionMoveParam(int paramInt)
  {
    SsaInsn localSsaInsn = this.ssaMeth.getDefinitionForRegister(paramInt);
    if ((localSsaInsn instanceof NormalSsaInsn)) {
      return ((NormalSsaInsn)localSsaInsn).getOpcode().getOpcode() == 3;
    }
    return false;
  }
  
  public abstract boolean wantsParamsMovedHigh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.back.RegisterAllocator
 * JD-Core Version:    0.7.0.1
 */