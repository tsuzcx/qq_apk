package com.android.dx.ssa;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class LocalVariableExtractor
{
  private final ArrayList<SsaBasicBlock> blocks;
  private final SsaMethod method;
  private final LocalVariableInfo resultInfo;
  private final BitSet workSet;
  
  private LocalVariableExtractor(SsaMethod paramSsaMethod)
  {
    if (paramSsaMethod == null) {
      throw new NullPointerException("method == null");
    }
    ArrayList localArrayList = paramSsaMethod.getBlocks();
    this.method = paramSsaMethod;
    this.blocks = localArrayList;
    this.resultInfo = new LocalVariableInfo(paramSsaMethod);
    this.workSet = new BitSet(localArrayList.size());
  }
  
  private LocalVariableInfo doit()
  {
    if (this.method.getRegCount() > 0) {
      for (int i = this.method.getEntryBlockIndex(); i >= 0; i = this.workSet.nextSetBit(0))
      {
        this.workSet.clear(i);
        processBlock(i);
      }
    }
    this.resultInfo.setImmutable();
    return this.resultInfo;
  }
  
  public static LocalVariableInfo extract(SsaMethod paramSsaMethod)
  {
    return new LocalVariableExtractor(paramSsaMethod).doit();
  }
  
  private void processBlock(int paramInt)
  {
    int i = 1;
    int j = 0;
    RegisterSpecSet localRegisterSpecSet = this.resultInfo.mutableCopyOfStarts(paramInt);
    Object localObject2 = (SsaBasicBlock)this.blocks.get(paramInt);
    Object localObject3 = ((SsaBasicBlock)localObject2).getInsns();
    int k = ((List)localObject3).size();
    if (paramInt == this.method.getExitBlockIndex()) {
      return;
    }
    Object localObject1 = (SsaInsn)((List)localObject3).get(k - 1);
    if (((SsaInsn)localObject1).getOriginalRopInsn().getCatches().size() != 0)
    {
      paramInt = 1;
      if ((paramInt == 0) || (((SsaInsn)localObject1).getResult() == null)) {
        break label216;
      }
      paramInt = i;
      label103:
      i = 0;
      localObject1 = localRegisterSpecSet;
      label109:
      if (i >= k) {
        break label301;
      }
      if ((paramInt == 0) || (i != k - 1)) {
        break label385;
      }
      ((RegisterSpecSet)localObject1).setImmutable();
      localObject1 = ((RegisterSpecSet)localObject1).mutableCopy();
    }
    label385:
    for (;;)
    {
      Object localObject4 = (SsaInsn)((List)localObject3).get(i);
      RegisterSpec localRegisterSpec1 = ((SsaInsn)localObject4).getLocalAssignment();
      if (localRegisterSpec1 == null)
      {
        localObject4 = ((SsaInsn)localObject4).getResult();
        if ((localObject4 != null) && (((RegisterSpecSet)localObject1).get(((RegisterSpec)localObject4).getReg()) != null)) {
          ((RegisterSpecSet)localObject1).remove(((RegisterSpecSet)localObject1).get(((RegisterSpec)localObject4).getReg()));
        }
      }
      for (;;)
      {
        i += 1;
        break label109;
        paramInt = 0;
        break;
        label216:
        paramInt = 0;
        break label103;
        localRegisterSpec1 = localRegisterSpec1.withSimpleType();
        if (!localRegisterSpec1.equals(((RegisterSpecSet)localObject1).get(localRegisterSpec1)))
        {
          RegisterSpec localRegisterSpec2 = ((RegisterSpecSet)localObject1).localItemToSpec(localRegisterSpec1.getLocalItem());
          if ((localRegisterSpec2 != null) && (localRegisterSpec2.getReg() != localRegisterSpec1.getReg())) {
            ((RegisterSpecSet)localObject1).remove(localRegisterSpec2);
          }
          this.resultInfo.addAssignment((SsaInsn)localObject4, localRegisterSpec1);
          ((RegisterSpecSet)localObject1).put(localRegisterSpec1);
        }
      }
      label301:
      ((RegisterSpecSet)localObject1).setImmutable();
      localObject3 = ((SsaBasicBlock)localObject2).getSuccessorList();
      i = ((IntList)localObject3).size();
      k = ((SsaBasicBlock)localObject2).getPrimarySuccessorIndex();
      paramInt = j;
      label328:
      if (paramInt < i)
      {
        j = ((IntList)localObject3).get(paramInt);
        if (j != k) {
          break label378;
        }
      }
      label378:
      for (localObject2 = localObject1;; localObject2 = localRegisterSpecSet)
      {
        if (this.resultInfo.mergeStarts(j, (RegisterSpecSet)localObject2)) {
          this.workSet.set(j);
        }
        paramInt += 1;
        break label328;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.LocalVariableExtractor
 * JD-Core Version:    0.7.0.1
 */