package com.android.dx.rop.code;

import com.android.dx.util.Bits;
import com.android.dx.util.IntList;

public final class LocalVariableExtractor
{
  private final BasicBlockList blocks;
  private final RopMethod method;
  private final LocalVariableInfo resultInfo;
  private final int[] workSet;
  
  private LocalVariableExtractor(RopMethod paramRopMethod)
  {
    if (paramRopMethod == null) {
      throw new NullPointerException("method == null");
    }
    BasicBlockList localBasicBlockList = paramRopMethod.getBlocks();
    int i = localBasicBlockList.getMaxLabel();
    this.method = paramRopMethod;
    this.blocks = localBasicBlockList;
    this.resultInfo = new LocalVariableInfo(paramRopMethod);
    this.workSet = Bits.makeBitSet(i);
  }
  
  private LocalVariableInfo doit()
  {
    for (int i = this.method.getFirstLabel(); i >= 0; i = Bits.findFirst(this.workSet, 0))
    {
      Bits.clear(this.workSet, i);
      processBlock(i);
    }
    this.resultInfo.setImmutable();
    return this.resultInfo;
  }
  
  public static LocalVariableInfo extract(RopMethod paramRopMethod)
  {
    return new LocalVariableExtractor(paramRopMethod).doit();
  }
  
  private void processBlock(int paramInt)
  {
    int j = 0;
    RegisterSpecSet localRegisterSpecSet = this.resultInfo.mutableCopyOfStarts(paramInt);
    BasicBlock localBasicBlock = this.blocks.labelToBlock(paramInt);
    Object localObject3 = localBasicBlock.getInsns();
    int k = ((InsnList)localObject3).size();
    Object localObject1;
    label63:
    Object localObject2;
    RegisterSpec localRegisterSpec1;
    if ((localBasicBlock.hasExceptionHandlers()) && (((InsnList)localObject3).getLast().getResult() != null))
    {
      paramInt = 1;
      i = 0;
      localObject1 = localRegisterSpecSet;
      if (i >= k) {
        break label257;
      }
      localObject2 = localObject1;
      if (paramInt != 0)
      {
        localObject2 = localObject1;
        if (i == k - 1)
        {
          ((RegisterSpecSet)localObject1).setImmutable();
          localObject2 = ((RegisterSpecSet)localObject1).mutableCopy();
        }
      }
      localObject1 = ((InsnList)localObject3).get(i);
      localRegisterSpec1 = ((Insn)localObject1).getLocalAssignment();
      if (localRegisterSpec1 != null) {
        break label177;
      }
      localObject1 = ((Insn)localObject1).getResult();
      if ((localObject1 != null) && (((RegisterSpecSet)localObject2).get(((RegisterSpec)localObject1).getReg()) != null)) {
        ((RegisterSpecSet)localObject2).remove(((RegisterSpecSet)localObject2).get(((RegisterSpec)localObject1).getReg()));
      }
    }
    for (;;)
    {
      i += 1;
      localObject1 = localObject2;
      break label63;
      paramInt = 0;
      break;
      label177:
      localRegisterSpec1 = localRegisterSpec1.withSimpleType();
      if (!localRegisterSpec1.equals(((RegisterSpecSet)localObject2).get(localRegisterSpec1)))
      {
        RegisterSpec localRegisterSpec2 = ((RegisterSpecSet)localObject2).localItemToSpec(localRegisterSpec1.getLocalItem());
        if ((localRegisterSpec2 != null) && (localRegisterSpec2.getReg() != localRegisterSpec1.getReg())) {
          ((RegisterSpecSet)localObject2).remove(localRegisterSpec2);
        }
        this.resultInfo.addAssignment((Insn)localObject1, localRegisterSpec1);
        ((RegisterSpecSet)localObject2).put(localRegisterSpec1);
      }
    }
    label257:
    ((RegisterSpecSet)localObject1).setImmutable();
    localObject3 = localBasicBlock.getSuccessors();
    int i = ((IntList)localObject3).size();
    k = localBasicBlock.getPrimarySuccessor();
    paramInt = j;
    if (paramInt < i)
    {
      j = ((IntList)localObject3).get(paramInt);
      if (j == k) {}
      for (localObject2 = localObject1;; localObject2 = localRegisterSpecSet)
      {
        if (this.resultInfo.mergeStarts(j, (RegisterSpecSet)localObject2)) {
          Bits.set(this.workSet, j);
        }
        paramInt += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.LocalVariableExtractor
 * JD-Core Version:    0.7.0.1
 */