package com.android.dx.dex.code;

import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.HashSet;

public final class StdCatchBuilder
  implements CatchBuilder
{
  private static final int MAX_CATCH_RANGE = 65535;
  private final BlockAddresses addresses;
  private final RopMethod method;
  private final int[] order;
  
  public StdCatchBuilder(RopMethod paramRopMethod, int[] paramArrayOfInt, BlockAddresses paramBlockAddresses)
  {
    if (paramRopMethod == null) {
      throw new NullPointerException("method == null");
    }
    if (paramArrayOfInt == null) {
      throw new NullPointerException("order == null");
    }
    if (paramBlockAddresses == null) {
      throw new NullPointerException("addresses == null");
    }
    this.method = paramRopMethod;
    this.order = paramArrayOfInt;
    this.addresses = paramBlockAddresses;
  }
  
  public static CatchTable build(RopMethod paramRopMethod, int[] paramArrayOfInt, BlockAddresses paramBlockAddresses)
  {
    Object localObject3 = null;
    int j = paramArrayOfInt.length;
    BasicBlockList localBasicBlockList = paramRopMethod.getBlocks();
    ArrayList localArrayList = new ArrayList(j);
    paramRopMethod = CatchHandlerList.EMPTY;
    int i = 0;
    Object localObject2 = null;
    if (i < j)
    {
      Object localObject1 = localBasicBlockList.labelToBlock(paramArrayOfInt[i]);
      if (!((BasicBlock)localObject1).canThrow())
      {
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      for (;;)
      {
        i += 1;
        localObject3 = localObject2;
        localObject2 = localObject1;
        break;
        CatchHandlerList localCatchHandlerList = handlersFor((BasicBlock)localObject1, paramBlockAddresses);
        if (paramRopMethod.size() == 0)
        {
          localObject2 = localObject1;
          paramRopMethod = localCatchHandlerList;
        }
        else if ((paramRopMethod.equals(localCatchHandlerList)) && (rangeIsValid(localObject2, (BasicBlock)localObject1, paramBlockAddresses)))
        {
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
        else
        {
          if (paramRopMethod.size() != 0) {
            localArrayList.add(makeEntry(localObject2, localObject3, paramRopMethod, paramBlockAddresses));
          }
          localObject2 = localObject1;
          paramRopMethod = localCatchHandlerList;
        }
      }
    }
    if (paramRopMethod.size() != 0) {
      localArrayList.add(makeEntry(localObject2, localObject3, paramRopMethod, paramBlockAddresses));
    }
    j = localArrayList.size();
    if (j == 0) {
      return CatchTable.EMPTY;
    }
    paramRopMethod = new CatchTable(j);
    i = 0;
    while (i < j)
    {
      paramRopMethod.set(i, (CatchTable.Entry)localArrayList.get(i));
      i += 1;
    }
    paramRopMethod.setImmutable();
    return paramRopMethod;
  }
  
  private static CatchHandlerList handlersFor(BasicBlock paramBasicBlock, BlockAddresses paramBlockAddresses)
  {
    int k = 0;
    IntList localIntList = paramBasicBlock.getSuccessors();
    int i = localIntList.size();
    int j = paramBasicBlock.getPrimarySuccessor();
    paramBasicBlock = paramBasicBlock.getLastInsn().getCatches();
    int m = paramBasicBlock.size();
    if (m == 0) {
      return CatchHandlerList.EMPTY;
    }
    if (((j == -1) && (i != m)) || ((j != -1) && ((i != m + 1) || (j != localIntList.get(m))))) {
      throw new RuntimeException("shouldn't happen: weird successors list");
    }
    j = 0;
    CatchHandlerList localCatchHandlerList;
    for (;;)
    {
      i = m;
      if (j < m)
      {
        if (paramBasicBlock.getType(j).equals(Type.OBJECT)) {
          i = j + 1;
        }
      }
      else
      {
        localCatchHandlerList = new CatchHandlerList(i);
        j = k;
        while (j < i)
        {
          localCatchHandlerList.set(j, new CstType(paramBasicBlock.getType(j)), paramBlockAddresses.getStart(localIntList.get(j)).getAddress());
          j += 1;
        }
      }
      j += 1;
    }
    localCatchHandlerList.setImmutable();
    return localCatchHandlerList;
  }
  
  private static CatchTable.Entry makeEntry(BasicBlock paramBasicBlock1, BasicBlock paramBasicBlock2, CatchHandlerList paramCatchHandlerList, BlockAddresses paramBlockAddresses)
  {
    paramBasicBlock1 = paramBlockAddresses.getLast(paramBasicBlock1);
    paramBasicBlock2 = paramBlockAddresses.getEnd(paramBasicBlock2);
    return new CatchTable.Entry(paramBasicBlock1.getAddress(), paramBasicBlock2.getAddress(), paramCatchHandlerList);
  }
  
  private static boolean rangeIsValid(BasicBlock paramBasicBlock1, BasicBlock paramBasicBlock2, BlockAddresses paramBlockAddresses)
  {
    if (paramBasicBlock1 == null) {
      throw new NullPointerException("start == null");
    }
    if (paramBasicBlock2 == null) {
      throw new NullPointerException("end == null");
    }
    int i = paramBlockAddresses.getLast(paramBasicBlock1).getAddress();
    return paramBlockAddresses.getEnd(paramBasicBlock2).getAddress() - i <= 65535;
  }
  
  public CatchTable build()
  {
    return build(this.method, this.order, this.addresses);
  }
  
  public HashSet<Type> getCatchTypes()
  {
    HashSet localHashSet = new HashSet(20);
    BasicBlockList localBasicBlockList = this.method.getBlocks();
    int k = localBasicBlockList.size();
    int i = 0;
    while (i < k)
    {
      TypeList localTypeList = localBasicBlockList.get(i).getLastInsn().getCatches();
      int m = localTypeList.size();
      int j = 0;
      while (j < m)
      {
        localHashSet.add(localTypeList.getType(j));
        j += 1;
      }
      i += 1;
    }
    return localHashSet;
  }
  
  public boolean hasAnyCatches()
  {
    boolean bool2 = false;
    BasicBlockList localBasicBlockList = this.method.getBlocks();
    int j = localBasicBlockList.size();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (localBasicBlockList.get(i).getLastInsn().getCatches().size() != 0) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.StdCatchBuilder
 * JD-Core Version:    0.7.0.1
 */