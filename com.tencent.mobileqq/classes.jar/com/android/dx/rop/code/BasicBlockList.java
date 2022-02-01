package com.android.dx.rop.code;

import com.android.dx.rop.type.StdTypeList;
import com.android.dx.util.Hex;
import com.android.dx.util.IntList;
import com.android.dx.util.LabeledList;

public final class BasicBlockList
  extends LabeledList
{
  private int regCount;
  
  public BasicBlockList(int paramInt)
  {
    super(paramInt);
    this.regCount = -1;
  }
  
  private BasicBlockList(BasicBlockList paramBasicBlockList)
  {
    super(paramBasicBlockList);
    this.regCount = paramBasicBlockList.regCount;
  }
  
  public boolean catchesEqual(BasicBlock paramBasicBlock1, BasicBlock paramBasicBlock2)
  {
    if (!StdTypeList.equalContents(paramBasicBlock1.getExceptionHandlerTypes(), paramBasicBlock2.getExceptionHandlerTypes())) {}
    int m;
    int i;
    int n;
    int i1;
    do
    {
      IntList localIntList1;
      IntList localIntList2;
      int j;
      int k;
      do
      {
        return false;
        localIntList1 = paramBasicBlock1.getSuccessors();
        localIntList2 = paramBasicBlock2.getSuccessors();
        j = localIntList1.size();
        k = paramBasicBlock1.getPrimarySuccessor();
        m = paramBasicBlock2.getPrimarySuccessor();
      } while (((k == -1) || (m == -1)) && (k != m));
      i = 0;
      if (i >= j) {
        break label120;
      }
      n = localIntList1.get(i);
      i1 = localIntList2.get(i);
      if (n != k) {
        break;
      }
    } while (i1 != m);
    while (n == i1)
    {
      i += 1;
      break;
    }
    return false;
    label120:
    return true;
  }
  
  public void forEachInsn(Insn.Visitor paramVisitor)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      get(i).getInsns().forEach(paramVisitor);
      i += 1;
    }
  }
  
  public BasicBlock get(int paramInt)
  {
    return (BasicBlock)get0(paramInt);
  }
  
  public int getEffectiveInstructionCount()
  {
    int n = size();
    int k = 0;
    int j;
    for (int i = 0; k < n; i = j)
    {
      Object localObject = (BasicBlock)getOrNull0(k);
      if (localObject != null)
      {
        localObject = ((BasicBlock)localObject).getInsns();
        int i1 = ((InsnList)localObject).size();
        int m = 0;
        for (;;)
        {
          j = i;
          if (m >= i1) {
            break;
          }
          j = i;
          if (((InsnList)localObject).get(m).getOpcode().getOpcode() != 54) {
            j = i + 1;
          }
          m += 1;
          i = j;
        }
      }
      j = i;
      k += 1;
    }
    return i;
  }
  
  public int getInstructionCount()
  {
    int k = size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      BasicBlock localBasicBlock = (BasicBlock)getOrNull0(j);
      if (localBasicBlock == null) {
        break label49;
      }
      i = localBasicBlock.getInsns().size() + i;
    }
    label49:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  public BasicBlockList getMutableCopy()
  {
    return new BasicBlockList(this);
  }
  
  public int getRegCount()
  {
    if (this.regCount == -1)
    {
      BasicBlockList.RegCountVisitor localRegCountVisitor = new BasicBlockList.RegCountVisitor();
      forEachInsn(localRegCountVisitor);
      this.regCount = localRegCountVisitor.getRegCount();
    }
    return this.regCount;
  }
  
  public BasicBlock labelToBlock(int paramInt)
  {
    int i = indexOfLabel(paramInt);
    if (i < 0) {
      throw new IllegalArgumentException("no such label: " + Hex.u2(paramInt));
    }
    return get(i);
  }
  
  public BasicBlock preferredSuccessorOf(BasicBlock paramBasicBlock)
  {
    int i = paramBasicBlock.getPrimarySuccessor();
    paramBasicBlock = paramBasicBlock.getSuccessors();
    switch (paramBasicBlock.size())
    {
    default: 
      if (i != -1) {
        return labelToBlock(i);
      }
      break;
    case 0: 
      return null;
    case 1: 
      return labelToBlock(paramBasicBlock.get(0));
    }
    return labelToBlock(paramBasicBlock.get(0));
  }
  
  public void set(int paramInt, BasicBlock paramBasicBlock)
  {
    super.set(paramInt, paramBasicBlock);
    this.regCount = -1;
  }
  
  public BasicBlockList withRegisterOffset(int paramInt)
  {
    int j = size();
    BasicBlockList localBasicBlockList = new BasicBlockList(j);
    int i = 0;
    while (i < j)
    {
      BasicBlock localBasicBlock = (BasicBlock)get0(i);
      if (localBasicBlock != null) {
        localBasicBlockList.set(i, localBasicBlock.withRegisterOffset(paramInt));
      }
      i += 1;
    }
    if (isImmutable()) {
      localBasicBlockList.setImmutable();
    }
    return localBasicBlockList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.BasicBlockList
 * JD-Core Version:    0.7.0.1
 */