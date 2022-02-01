package com.android.dx.cf.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMemberRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.Bits;
import com.android.dx.util.IntList;
import java.util.ArrayList;

public final class BasicBlocker
  implements BytecodeArray.Visitor
{
  private final int[] blockSet;
  private final ByteCatchList[] catchLists;
  private final int[] liveSet;
  private final ConcreteMethod method;
  private int previousOffset;
  private final IntList[] targetLists;
  private final int[] workSet;
  
  private BasicBlocker(ConcreteMethod paramConcreteMethod)
  {
    if (paramConcreteMethod == null) {
      throw new NullPointerException("method == null");
    }
    this.method = paramConcreteMethod;
    int i = paramConcreteMethod.getCode().size() + 1;
    this.workSet = Bits.makeBitSet(i);
    this.liveSet = Bits.makeBitSet(i);
    this.blockSet = Bits.makeBitSet(i);
    this.targetLists = new IntList[i];
    this.catchLists = new ByteCatchList[i];
    this.previousOffset = -1;
  }
  
  private void addWorkIfNecessary(int paramInt, boolean paramBoolean)
  {
    if (!Bits.get(this.liveSet, paramInt)) {
      Bits.set(this.workSet, paramInt);
    }
    if (paramBoolean) {
      Bits.set(this.blockSet, paramInt);
    }
  }
  
  private void doit()
  {
    BytecodeArray localBytecodeArray = this.method.getCode();
    ByteCatchList localByteCatchList = this.method.getCatches();
    int j = localByteCatchList.size();
    Bits.set(this.workSet, 0);
    Bits.set(this.blockSet, 0);
    while (!Bits.isEmpty(this.workSet)) {
      try
      {
        localBytecodeArray.processWorkSet(this.workSet, this);
        int i = 0;
        while (i < j)
        {
          ByteCatchList.Item localItem = localByteCatchList.get(i);
          int k = localItem.getStartPc();
          int m = localItem.getEndPc();
          if (Bits.anyInRange(this.liveSet, k, m))
          {
            Bits.set(this.blockSet, k);
            Bits.set(this.blockSet, m);
            addWorkIfNecessary(localItem.getHandlerPc(), true);
          }
          i += 1;
        }
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new SimException("flow of control falls off end of method", localIllegalArgumentException);
      }
    }
  }
  
  private ByteBlockList getBlockList()
  {
    int m = 0;
    ByteBlock[] arrayOfByteBlock = new ByteBlock[this.method.getCode().size()];
    int k = 0;
    int i = 0;
    int n = Bits.findFirst(this.blockSet, k + 1);
    Object localObject1;
    int j;
    if (n < 0)
    {
      localObject1 = new ByteBlockList(i);
      j = m;
      while (j < i)
      {
        ((ByteBlockList)localObject1).set(j, arrayOfByteBlock[j]);
        j += 1;
      }
    }
    label93:
    label111:
    Object localObject3;
    Object localObject2;
    if (Bits.get(this.liveSet, k))
    {
      localObject1 = null;
      j = n - 1;
      if (j >= k)
      {
        localObject1 = this.targetLists[j];
        if (localObject1 != null)
        {
          if (localObject1 != null) {
            break label164;
          }
          localObject3 = IntList.makeImmutable(n);
          localObject2 = ByteCatchList.EMPTY;
          label128:
          arrayOfByteBlock[i] = new ByteBlock(k, k, n, (IntList)localObject3, (ByteCatchList)localObject2);
          i += 1;
        }
      }
    }
    for (;;)
    {
      k = n;
      break;
      j -= 1;
      break label93;
      label164:
      ByteCatchList localByteCatchList = this.catchLists[j];
      localObject3 = localObject1;
      localObject2 = localByteCatchList;
      if (localByteCatchList != null) {
        break label128;
      }
      localObject2 = ByteCatchList.EMPTY;
      localObject3 = localObject1;
      break label128;
      return localObject1;
      j = -1;
      break label111;
    }
  }
  
  public static ByteBlockList identifyBlocks(ConcreteMethod paramConcreteMethod)
  {
    paramConcreteMethod = new BasicBlocker(paramConcreteMethod);
    paramConcreteMethod.doit();
    return paramConcreteMethod.getBlockList();
  }
  
  private void visitCommon(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Bits.set(this.liveSet, paramInt1);
    if (paramBoolean)
    {
      addWorkIfNecessary(paramInt1 + paramInt2, false);
      return;
    }
    Bits.set(this.blockSet, paramInt1 + paramInt2);
  }
  
  private void visitThrowing(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = paramInt1 + paramInt2;
    if (paramBoolean) {
      addWorkIfNecessary(paramInt2, true);
    }
    ByteCatchList localByteCatchList = this.method.getCatches().listFor(paramInt1);
    this.catchLists[paramInt1] = localByteCatchList;
    IntList[] arrayOfIntList = this.targetLists;
    if (paramBoolean) {}
    for (;;)
    {
      arrayOfIntList[paramInt1] = localByteCatchList.toTargetList(paramInt2);
      return;
      paramInt2 = -1;
    }
  }
  
  public int getPreviousOffset()
  {
    return this.previousOffset;
  }
  
  public void setPreviousOffset(int paramInt)
  {
    this.previousOffset = paramInt;
  }
  
  public void visitBranch(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramInt1 = paramInt2 + paramInt3;
      visitCommon(paramInt2, paramInt3, true);
      addWorkIfNecessary(paramInt1, true);
      this.targetLists[paramInt2] = IntList.makeImmutable(paramInt1, paramInt4);
      for (;;)
      {
        addWorkIfNecessary(paramInt4, true);
        return;
        visitCommon(paramInt2, paramInt3, false);
        this.targetLists[paramInt2] = IntList.makeImmutable(paramInt4);
      }
      addWorkIfNecessary(paramInt2, true);
    }
  }
  
  public void visitConstant(int paramInt1, int paramInt2, int paramInt3, Constant paramConstant, int paramInt4)
  {
    visitCommon(paramInt2, paramInt3, true);
    if (((paramConstant instanceof CstMemberRef)) || ((paramConstant instanceof CstType)) || ((paramConstant instanceof CstString))) {
      visitThrowing(paramInt2, paramInt3, true);
    }
  }
  
  public void visitInvalid(int paramInt1, int paramInt2, int paramInt3)
  {
    visitCommon(paramInt2, paramInt3, true);
  }
  
  public void visitLocal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Type paramType, int paramInt5)
  {
    if (paramInt1 == 169)
    {
      visitCommon(paramInt2, paramInt3, false);
      this.targetLists[paramInt2] = IntList.EMPTY;
      return;
    }
    visitCommon(paramInt2, paramInt3, true);
  }
  
  public void visitNewarray(int paramInt1, int paramInt2, CstType paramCstType, ArrayList<Constant> paramArrayList)
  {
    visitCommon(paramInt1, paramInt2, true);
    visitThrowing(paramInt1, paramInt2, true);
  }
  
  public void visitNoArgs(int paramInt1, int paramInt2, int paramInt3, Type paramType)
  {
    switch (paramInt1)
    {
    default: 
      visitCommon(paramInt2, paramInt3, true);
    }
    do
    {
      return;
      visitCommon(paramInt2, paramInt3, false);
      this.targetLists[paramInt2] = IntList.EMPTY;
      return;
      visitCommon(paramInt2, paramInt3, false);
      visitThrowing(paramInt2, paramInt3, false);
      return;
      visitCommon(paramInt2, paramInt3, true);
      visitThrowing(paramInt2, paramInt3, true);
      return;
      visitCommon(paramInt2, paramInt3, true);
    } while ((paramType != Type.INT) && (paramType != Type.LONG));
    visitThrowing(paramInt2, paramInt3, true);
  }
  
  public void visitSwitch(int paramInt1, int paramInt2, int paramInt3, SwitchList paramSwitchList, int paramInt4)
  {
    paramInt1 = 0;
    visitCommon(paramInt2, paramInt3, false);
    addWorkIfNecessary(paramSwitchList.getDefaultTarget(), true);
    paramInt3 = paramSwitchList.size();
    while (paramInt1 < paramInt3)
    {
      addWorkIfNecessary(paramSwitchList.getTarget(paramInt1), true);
      paramInt1 += 1;
    }
    this.targetLists[paramInt2] = paramSwitchList.getTargets();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.BasicBlocker
 * JD-Core Version:    0.7.0.1
 */