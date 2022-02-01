package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

public class DeadCodeRemover
{
  private final int regCount;
  private final SsaMethod ssaMeth;
  private final ArrayList<SsaInsn>[] useList;
  private final BitSet worklist;
  
  private DeadCodeRemover(SsaMethod paramSsaMethod)
  {
    this.ssaMeth = paramSsaMethod;
    this.regCount = paramSsaMethod.getRegCount();
    this.worklist = new BitSet(this.regCount);
    this.useList = this.ssaMeth.getUseListCopy();
  }
  
  private static boolean hasSideEffect(SsaInsn paramSsaInsn)
  {
    if (paramSsaInsn == null) {
      return true;
    }
    return paramSsaInsn.hasSideEffect();
  }
  
  private boolean isCircularNoSideEffect(int paramInt, BitSet paramBitSet)
  {
    if ((paramBitSet != null) && (paramBitSet.get(paramInt))) {
      return true;
    }
    Object localObject = this.useList[paramInt].iterator();
    while (((Iterator)localObject).hasNext()) {
      if (hasSideEffect((SsaInsn)((Iterator)localObject).next())) {
        return false;
      }
    }
    localObject = paramBitSet;
    if (paramBitSet == null) {
      localObject = new BitSet(this.regCount);
    }
    ((BitSet)localObject).set(paramInt);
    paramBitSet = this.useList[paramInt].iterator();
    while (paramBitSet.hasNext())
    {
      RegisterSpec localRegisterSpec = ((SsaInsn)paramBitSet.next()).getResult();
      if ((localRegisterSpec == null) || (!isCircularNoSideEffect(localRegisterSpec.getReg(), (BitSet)localObject))) {
        return false;
      }
    }
    return true;
  }
  
  public static void process(SsaMethod paramSsaMethod)
  {
    new DeadCodeRemover(paramSsaMethod).run();
  }
  
  private void pruneDeadInstructions()
  {
    HashSet localHashSet = new HashSet();
    this.ssaMeth.computeReachability();
    Iterator localIterator = this.ssaMeth.getBlocks().iterator();
    while (localIterator.hasNext())
    {
      SsaBasicBlock localSsaBasicBlock = (SsaBasicBlock)localIterator.next();
      if (!localSsaBasicBlock.isReachable())
      {
        int i = 0;
        label60:
        Object localObject1;
        Object localObject2;
        Object localObject3;
        if (i < localSsaBasicBlock.getInsns().size())
        {
          localObject1 = (SsaInsn)localSsaBasicBlock.getInsns().get(i);
          localObject2 = ((SsaInsn)localObject1).getSources();
          int k = ((RegisterSpecList)localObject2).size();
          if (k != 0) {
            localHashSet.add(localObject1);
          }
          int j = 0;
          while (j < k)
          {
            localObject3 = ((RegisterSpecList)localObject2).get(j);
            this.useList[localObject3.getReg()].remove(localObject1);
            j += 1;
          }
          localObject1 = ((SsaInsn)localObject1).getResult();
          if (localObject1 != null) {
            break label168;
          }
        }
        for (;;)
        {
          i += 1;
          break label60;
          break;
          label168:
          localObject2 = this.useList[localObject1.getReg()].iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SsaInsn)((Iterator)localObject2).next();
            if ((localObject3 instanceof PhiInsn)) {
              ((PhiInsn)localObject3).removePhiRegister((RegisterSpec)localObject1);
            }
          }
        }
      }
    }
    this.ssaMeth.deleteInsns(localHashSet);
  }
  
  private void run()
  {
    pruneDeadInstructions();
    HashSet localHashSet = new HashSet();
    this.ssaMeth.forEachInsn(new DeadCodeRemover.NoSideEffectVisitor(this.worklist));
    for (;;)
    {
      int i = this.worklist.nextSetBit(0);
      if (i < 0) {
        break;
      }
      this.worklist.clear(i);
      if ((this.useList[i].size() == 0) || (isCircularNoSideEffect(i, null)))
      {
        SsaInsn localSsaInsn = this.ssaMeth.getDefinitionForRegister(i);
        if (!localHashSet.contains(localSsaInsn))
        {
          RegisterSpecList localRegisterSpecList = localSsaInsn.getSources();
          int j = localRegisterSpecList.size();
          i = 0;
          while (i < j)
          {
            RegisterSpec localRegisterSpec = localRegisterSpecList.get(i);
            this.useList[localRegisterSpec.getReg()].remove(localSsaInsn);
            if (!hasSideEffect(this.ssaMeth.getDefinitionForRegister(localRegisterSpec.getReg()))) {
              this.worklist.set(localRegisterSpec.getReg());
            }
            i += 1;
          }
          localHashSet.add(localSsaInsn);
        }
      }
    }
    this.ssaMeth.deleteInsns(localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.DeadCodeRemover
 * JD-Core Version:    0.7.0.1
 */