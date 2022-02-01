package com.android.dx.ssa;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.util.IntIterator;
import com.android.dx.util.IntSet;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

public class SsaConverter
{
  public static final boolean DEBUG = false;
  
  public static SsaMethod convertToSsaMethod(RopMethod paramRopMethod, int paramInt, boolean paramBoolean)
  {
    paramRopMethod = SsaMethod.newFromRopMethod(paramRopMethod, paramInt, paramBoolean);
    edgeSplit(paramRopMethod);
    placePhiFunctions(paramRopMethod, LocalVariableExtractor.extract(paramRopMethod), 0);
    new SsaRenamer(paramRopMethod).run();
    paramRopMethod.makeExitBlock();
    return paramRopMethod;
  }
  
  private static void edgeSplit(SsaMethod paramSsaMethod)
  {
    edgeSplitPredecessors(paramSsaMethod);
    edgeSplitMoveExceptionsAndResults(paramSsaMethod);
    edgeSplitSuccessors(paramSsaMethod);
  }
  
  private static void edgeSplitMoveExceptionsAndResults(SsaMethod paramSsaMethod)
  {
    paramSsaMethod = paramSsaMethod.getBlocks();
    int i = paramSsaMethod.size() - 1;
    while (i >= 0)
    {
      SsaBasicBlock localSsaBasicBlock = (SsaBasicBlock)paramSsaMethod.get(i);
      if ((!localSsaBasicBlock.isExitBlock()) && (localSsaBasicBlock.getPredecessors().cardinality() > 1) && (((SsaInsn)localSsaBasicBlock.getInsns().get(0)).isMoveException()))
      {
        BitSet localBitSet = (BitSet)localSsaBasicBlock.getPredecessors().clone();
        for (int j = localBitSet.nextSetBit(0); j >= 0; j = localBitSet.nextSetBit(j + 1)) {
          ((SsaBasicBlock)paramSsaMethod.get(j)).insertNewSuccessor(localSsaBasicBlock).getInsns().add(0, ((SsaInsn)localSsaBasicBlock.getInsns().get(0)).clone());
        }
        localSsaBasicBlock.getInsns().remove(0);
      }
      i -= 1;
    }
  }
  
  private static void edgeSplitPredecessors(SsaMethod paramSsaMethod)
  {
    paramSsaMethod = paramSsaMethod.getBlocks();
    int i = paramSsaMethod.size() - 1;
    while (i >= 0)
    {
      SsaBasicBlock localSsaBasicBlock = (SsaBasicBlock)paramSsaMethod.get(i);
      if (nodeNeedsUniquePredecessor(localSsaBasicBlock)) {
        localSsaBasicBlock.insertNewPredecessor();
      }
      i -= 1;
    }
  }
  
  private static void edgeSplitSuccessors(SsaMethod paramSsaMethod)
  {
    paramSsaMethod = paramSsaMethod.getBlocks();
    int i = paramSsaMethod.size() - 1;
    while (i >= 0)
    {
      SsaBasicBlock localSsaBasicBlock1 = (SsaBasicBlock)paramSsaMethod.get(i);
      BitSet localBitSet = (BitSet)localSsaBasicBlock1.getSuccessors().clone();
      for (int j = localBitSet.nextSetBit(0); j >= 0; j = localBitSet.nextSetBit(j + 1))
      {
        SsaBasicBlock localSsaBasicBlock2 = (SsaBasicBlock)paramSsaMethod.get(j);
        if (needsNewSuccessor(localSsaBasicBlock1, localSsaBasicBlock2)) {
          localSsaBasicBlock1.insertNewSuccessor(localSsaBasicBlock2);
        }
      }
      i -= 1;
    }
  }
  
  private static boolean needsNewSuccessor(SsaBasicBlock paramSsaBasicBlock1, SsaBasicBlock paramSsaBasicBlock2)
  {
    paramSsaBasicBlock1 = paramSsaBasicBlock1.getInsns();
    paramSsaBasicBlock1 = (SsaInsn)paramSsaBasicBlock1.get(paramSsaBasicBlock1.size() - 1);
    return ((paramSsaBasicBlock1.getResult() != null) || (paramSsaBasicBlock1.getSources().size() > 0)) && (paramSsaBasicBlock2.getPredecessors().cardinality() > 1);
  }
  
  private static boolean nodeNeedsUniquePredecessor(SsaBasicBlock paramSsaBasicBlock)
  {
    int i = paramSsaBasicBlock.getPredecessors().cardinality();
    int j = paramSsaBasicBlock.getSuccessors().cardinality();
    return (i > 1) && (j > 1);
  }
  
  private static void placePhiFunctions(SsaMethod paramSsaMethod, LocalVariableInfo paramLocalVariableInfo, int paramInt)
  {
    ArrayList localArrayList = paramSsaMethod.getBlocks();
    int k = localArrayList.size();
    int j = paramSsaMethod.getRegCount() - paramInt;
    paramSsaMethod = new DomFront(paramSsaMethod).run();
    BitSet[] arrayOfBitSet1 = new BitSet[j];
    BitSet[] arrayOfBitSet2 = new BitSet[j];
    int i = 0;
    while (i < j)
    {
      arrayOfBitSet1[i] = new BitSet(k);
      arrayOfBitSet2[i] = new BitSet(k);
      i += 1;
    }
    k = localArrayList.size();
    i = 0;
    Object localObject1;
    Object localObject2;
    while (i < k)
    {
      localObject1 = ((SsaBasicBlock)localArrayList.get(i)).getInsns().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((SsaInsn)((Iterator)localObject1).next()).getResult();
        if ((localObject2 != null) && (((RegisterSpec)localObject2).getReg() - paramInt >= 0)) {
          arrayOfBitSet1[(localObject2.getReg() - paramInt)].set(i);
        }
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      localObject1 = (BitSet)arrayOfBitSet1[i].clone();
      k = ((BitSet)localObject1).nextSetBit(0);
      if (k >= 0)
      {
        ((BitSet)localObject1).clear(k);
        localObject2 = paramSsaMethod[k].dominanceFrontiers.iterator();
        label341:
        label357:
        for (;;)
        {
          label241:
          RegisterSpec localRegisterSpec;
          if (((IntIterator)localObject2).hasNext())
          {
            k = ((IntIterator)localObject2).next();
            if (arrayOfBitSet2[i].get(k)) {
              continue;
            }
            arrayOfBitSet2[i].set(k);
            int m = i + paramInt;
            localRegisterSpec = paramLocalVariableInfo.getStarts(k).get(m);
            if (localRegisterSpec != null) {
              break label341;
            }
            ((SsaBasicBlock)localArrayList.get(k)).addPhiInsnForReg(m);
          }
          for (;;)
          {
            if (arrayOfBitSet1[i].get(k)) {
              break label357;
            }
            ((BitSet)localObject1).set(k);
            break label241;
            break;
            ((SsaBasicBlock)localArrayList.get(k)).addPhiInsnForReg(localRegisterSpec);
          }
        }
      }
      i += 1;
    }
  }
  
  public static SsaMethod testEdgeSplit(RopMethod paramRopMethod, int paramInt, boolean paramBoolean)
  {
    paramRopMethod = SsaMethod.newFromRopMethod(paramRopMethod, paramInt, paramBoolean);
    edgeSplit(paramRopMethod);
    return paramRopMethod;
  }
  
  public static SsaMethod testPhiPlacement(RopMethod paramRopMethod, int paramInt, boolean paramBoolean)
  {
    paramRopMethod = SsaMethod.newFromRopMethod(paramRopMethod, paramInt, paramBoolean);
    edgeSplit(paramRopMethod);
    placePhiFunctions(paramRopMethod, LocalVariableExtractor.extract(paramRopMethod), 0);
    return paramRopMethod;
  }
  
  public static void updateSsaMethod(SsaMethod paramSsaMethod, int paramInt)
  {
    placePhiFunctions(paramSsaMethod, LocalVariableExtractor.extract(paramSsaMethod), paramInt);
    new SsaRenamer(paramSsaMethod, paramInt).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SsaConverter
 * JD-Core Version:    0.7.0.1
 */