package com.android.dx.dex.code;

import com.android.dx.dex.DexOptions;
import com.android.dx.rop.code.BasicBlock;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.InsnList;
import com.android.dx.rop.code.LocalVariableInfo;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.util.Bits;
import com.android.dx.util.IntList;

public final class RopTranslator
{
  private final BlockAddresses addresses;
  private final DexOptions dexOptions;
  private final LocalVariableInfo locals;
  private final RopMethod method;
  private int[] order;
  private final OutputCollector output;
  private final int paramSize;
  private boolean paramsAreInOrder;
  private final int positionInfo;
  private final int regCount;
  private final RopTranslator.TranslationVisitor translationVisitor;
  
  private RopTranslator(RopMethod paramRopMethod, int paramInt1, LocalVariableInfo paramLocalVariableInfo, int paramInt2, DexOptions paramDexOptions)
  {
    this.dexOptions = paramDexOptions;
    this.method = paramRopMethod;
    this.positionInfo = paramInt1;
    this.locals = paramLocalVariableInfo;
    this.addresses = new BlockAddresses(paramRopMethod);
    this.paramSize = paramInt2;
    this.order = null;
    this.paramsAreInOrder = calculateParamsAreInOrder(paramRopMethod, paramInt2);
    paramRopMethod = paramRopMethod.getBlocks();
    int j = paramRopMethod.size();
    int i = j * 3 + paramRopMethod.getInstructionCount();
    paramInt1 = i;
    if (paramLocalVariableInfo != null) {
      paramInt1 = i + (paramLocalVariableInfo.getAssignmentCount() + j);
    }
    int k = paramRopMethod.getRegCount();
    if (this.paramsAreInOrder) {}
    for (i = 0;; i = this.paramSize)
    {
      this.regCount = (i + k);
      this.output = new OutputCollector(paramDexOptions, paramInt1, j * 3, this.regCount, paramInt2);
      if (paramLocalVariableInfo == null) {
        break;
      }
      this.translationVisitor = new RopTranslator.LocalVariableAwareTranslationVisitor(this, this.output, paramLocalVariableInfo);
      return;
    }
    this.translationVisitor = new RopTranslator.TranslationVisitor(this, this.output);
  }
  
  private static boolean calculateParamsAreInOrder(RopMethod paramRopMethod, int paramInt)
  {
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = true;
    int i = paramRopMethod.getBlocks().getRegCount();
    paramRopMethod.getBlocks().forEachInsn(new RopTranslator.1(arrayOfBoolean, i, paramInt));
    return arrayOfBoolean[0];
  }
  
  private static RegisterSpecList getRegs(Insn paramInsn)
  {
    return getRegs(paramInsn, paramInsn.getResult());
  }
  
  private static RegisterSpecList getRegs(Insn paramInsn, RegisterSpec paramRegisterSpec)
  {
    RegisterSpecList localRegisterSpecList2 = paramInsn.getSources();
    RegisterSpecList localRegisterSpecList1 = localRegisterSpecList2;
    if (paramInsn.getOpcode().isCommutative())
    {
      localRegisterSpecList1 = localRegisterSpecList2;
      if (localRegisterSpecList2.size() == 2)
      {
        localRegisterSpecList1 = localRegisterSpecList2;
        if (paramRegisterSpec.getReg() == localRegisterSpecList2.get(1).getReg()) {
          localRegisterSpecList1 = RegisterSpecList.make(localRegisterSpecList2.get(1), localRegisterSpecList2.get(0));
        }
      }
    }
    if (paramRegisterSpec == null) {
      return localRegisterSpecList1;
    }
    return localRegisterSpecList1.withFirst(paramRegisterSpec);
  }
  
  private void outputBlock(BasicBlock paramBasicBlock, int paramInt)
  {
    Object localObject = this.addresses.getStart(paramBasicBlock);
    this.output.add((DalvInsn)localObject);
    if (this.locals != null)
    {
      RegisterSpecSet localRegisterSpecSet = this.locals.getStarts(paramBasicBlock);
      this.output.add(new LocalSnapshot(((CodeAddress)localObject).getPosition(), localRegisterSpecSet));
    }
    this.translationVisitor.setBlock(paramBasicBlock, this.addresses.getLast(paramBasicBlock));
    paramBasicBlock.getInsns().forEach(this.translationVisitor);
    this.output.add(this.addresses.getEnd(paramBasicBlock));
    int i = paramBasicBlock.getPrimarySuccessor();
    localObject = paramBasicBlock.getLastInsn();
    if ((i >= 0) && (i != paramInt))
    {
      if ((((Insn)localObject).getOpcode().getBranchingness() == 4) && (paramBasicBlock.getSecondarySuccessor() == paramInt)) {
        this.output.reverseBranch(1, this.addresses.getStart(i));
      }
    }
    else {
      return;
    }
    paramBasicBlock = new TargetInsn(Dops.GOTO, ((Insn)localObject).getPosition(), RegisterSpecList.EMPTY, this.addresses.getStart(i));
    this.output.add(paramBasicBlock);
  }
  
  private void outputInstructions()
  {
    BasicBlockList localBasicBlockList = this.method.getBlocks();
    int[] arrayOfInt = this.order;
    int k = arrayOfInt.length;
    int i = 0;
    if (i < k)
    {
      int j = i + 1;
      if (j == arrayOfInt.length) {}
      for (j = -1;; j = arrayOfInt[j])
      {
        outputBlock(localBasicBlockList.labelToBlock(arrayOfInt[i]), j);
        i += 1;
        break;
      }
    }
  }
  
  private void pickOrder()
  {
    BasicBlockList localBasicBlockList = this.method.getBlocks();
    int n = localBasicBlockList.size();
    int i = localBasicBlockList.getMaxLabel();
    int[] arrayOfInt1 = Bits.makeBitSet(i);
    int[] arrayOfInt2 = Bits.makeBitSet(i);
    i = 0;
    while (i < n)
    {
      Bits.set(arrayOfInt1, localBasicBlockList.get(i).getLabel());
      i += 1;
    }
    int[] arrayOfInt3 = new int[n];
    int j = this.method.getFirstLabel();
    i = 0;
    Object localObject;
    int i1;
    int k;
    int m;
    if (j != -1)
    {
      BasicBlock localBasicBlock;
      for (;;)
      {
        localObject = this.method.labelToPredecessors(j);
        i1 = ((IntList)localObject).size();
        k = 0;
        if (k < i1)
        {
          m = ((IntList)localObject).get(k);
          if (!Bits.get(arrayOfInt2, m)) {}
        }
        else
        {
          k = j;
          j = i;
          if (k != -1)
          {
            Bits.clear(arrayOfInt1, k);
            Bits.clear(arrayOfInt2, k);
            arrayOfInt3[i] = k;
            j = i + 1;
            localObject = localBasicBlockList.labelToBlock(k);
            localBasicBlock = localBasicBlockList.preferredSuccessorOf((BasicBlock)localObject);
            if (localBasicBlock != null) {
              break label237;
            }
          }
          k = Bits.findFirst(arrayOfInt1, 0);
          i = j;
          j = k;
          break;
        }
        if (!Bits.get(arrayOfInt1, m)) {}
        while (localBasicBlockList.labelToBlock(m).getPrimarySuccessor() != j)
        {
          k += 1;
          break;
        }
        Bits.set(arrayOfInt2, m);
        j = m;
      }
      label237:
      i = localBasicBlock.getLabel();
      k = ((BasicBlock)localObject).getPrimarySuccessor();
      if (!Bits.get(arrayOfInt1, i)) {}
    }
    for (;;)
    {
      k = i;
      i = j;
      break;
      if ((k != i) && (k >= 0) && (Bits.get(arrayOfInt1, k)))
      {
        i = k;
      }
      else
      {
        localObject = ((BasicBlock)localObject).getSuccessors();
        i1 = ((IntList)localObject).size();
        k = 0;
        for (;;)
        {
          if (k < i1)
          {
            m = ((IntList)localObject).get(k);
            i = m;
            if (Bits.get(arrayOfInt1, m)) {
              break;
            }
            k += 1;
            continue;
            if (i != n) {
              throw new RuntimeException("shouldn't happen");
            }
            this.order = arrayOfInt3;
            return;
          }
        }
        i = -1;
      }
    }
  }
  
  public static DalvCode translate(RopMethod paramRopMethod, int paramInt1, LocalVariableInfo paramLocalVariableInfo, int paramInt2, DexOptions paramDexOptions)
  {
    return new RopTranslator(paramRopMethod, paramInt1, paramLocalVariableInfo, paramInt2, paramDexOptions).translateAndGetResult();
  }
  
  private DalvCode translateAndGetResult()
  {
    pickOrder();
    outputInstructions();
    StdCatchBuilder localStdCatchBuilder = new StdCatchBuilder(this.method, this.order, this.addresses);
    return new DalvCode(this.positionInfo, this.output.getFinisher(), localStdCatchBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.RopTranslator
 * JD-Core Version:    0.7.0.1
 */