package com.android.dx.ssa;

import com.android.dx.rop.code.CstInsn;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.TypedConstant;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.IntList;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class SCCP
{
  private static final int CONSTANT = 1;
  private static final int TOP = 0;
  private static final int VARYING = 2;
  private ArrayList<SsaInsn> branchWorklist;
  private ArrayList<SsaBasicBlock> cfgPhiWorklist;
  private ArrayList<SsaBasicBlock> cfgWorklist;
  private BitSet executableBlocks;
  private Constant[] latticeConstants;
  private int[] latticeValues;
  private int regCount;
  private SsaMethod ssaMeth;
  private ArrayList<SsaInsn> ssaWorklist;
  private ArrayList<SsaInsn> varyingWorklist;
  
  private SCCP(SsaMethod paramSsaMethod)
  {
    this.ssaMeth = paramSsaMethod;
    this.regCount = paramSsaMethod.getRegCount();
    this.latticeValues = new int[this.regCount];
    this.latticeConstants = new Constant[this.regCount];
    this.cfgWorklist = new ArrayList();
    this.cfgPhiWorklist = new ArrayList();
    this.executableBlocks = new BitSet(paramSsaMethod.getBlocks().size());
    this.ssaWorklist = new ArrayList();
    this.varyingWorklist = new ArrayList();
    this.branchWorklist = new ArrayList();
    int i = 0;
    while (i < this.regCount)
    {
      this.latticeValues[i] = 0;
      this.latticeConstants[i] = null;
      i += 1;
    }
  }
  
  private void addBlockToWorklist(SsaBasicBlock paramSsaBasicBlock)
  {
    if (!this.executableBlocks.get(paramSsaBasicBlock.getIndex()))
    {
      this.cfgWorklist.add(paramSsaBasicBlock);
      this.executableBlocks.set(paramSsaBasicBlock.getIndex());
      return;
    }
    this.cfgPhiWorklist.add(paramSsaBasicBlock);
  }
  
  private void addUsersToWorklist(int paramInt1, int paramInt2)
  {
    SsaInsn localSsaInsn;
    if (paramInt2 == 2)
    {
      localIterator = this.ssaMeth.getUseListForRegister(paramInt1).iterator();
      while (localIterator.hasNext())
      {
        localSsaInsn = (SsaInsn)localIterator.next();
        this.varyingWorklist.add(localSsaInsn);
      }
    }
    Iterator localIterator = this.ssaMeth.getUseListForRegister(paramInt1).iterator();
    while (localIterator.hasNext())
    {
      localSsaInsn = (SsaInsn)localIterator.next();
      this.ssaWorklist.add(localSsaInsn);
    }
  }
  
  private static String latticeValName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "TOP";
    case 1: 
      return "CONSTANT";
    }
    return "VARYING";
  }
  
  public static void process(SsaMethod paramSsaMethod)
  {
    new SCCP(paramSsaMethod).run();
  }
  
  private void replaceBranches()
  {
    Iterator localIterator = this.branchWorklist.iterator();
    Object localObject;
    SsaBasicBlock localSsaBasicBlock;
    int m;
    int j;
    int i;
    if (localIterator.hasNext())
    {
      localObject = (SsaInsn)localIterator.next();
      localSsaBasicBlock = ((SsaInsn)localObject).getBlock();
      m = localSsaBasicBlock.getSuccessorList().size();
      j = 0;
      i = -1;
      label52:
      if (j < m)
      {
        int k = localSsaBasicBlock.getSuccessorList().get(j);
        if (this.executableBlocks.get(k)) {
          break label140;
        }
        i = k;
      }
    }
    label140:
    for (;;)
    {
      j += 1;
      break label52;
      if ((m != 2) || (i == -1)) {
        break;
      }
      localObject = ((SsaInsn)localObject).getOriginalRopInsn();
      localSsaBasicBlock.replaceLastInsn(new PlainInsn(Rops.GOTO, ((Insn)localObject).getPosition(), null, RegisterSpecList.EMPTY));
      localSsaBasicBlock.removeSuccessor(i);
      break;
      return;
    }
  }
  
  private void replaceConstants()
  {
    int i = 0;
    if (i < this.regCount)
    {
      if (this.latticeValues[i] != 1) {}
      for (;;)
      {
        i += 1;
        break;
        if ((this.latticeConstants[i] instanceof TypedConstant))
        {
          Object localObject1 = this.ssaMeth.getDefinitionForRegister(i);
          if (!((SsaInsn)localObject1).getResult().getTypeBearer().isConstant())
          {
            ((SsaInsn)localObject1).setResult(((SsaInsn)localObject1).getResult().withType((TypedConstant)this.latticeConstants[i]));
            localObject1 = this.ssaMeth.getUseListForRegister(i).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (SsaInsn)((Iterator)localObject1).next();
              if (!((SsaInsn)localObject2).isPhiOrMove())
              {
                NormalSsaInsn localNormalSsaInsn = (NormalSsaInsn)localObject2;
                localObject2 = ((SsaInsn)localObject2).getSources();
                int j = ((RegisterSpecList)localObject2).indexOfRegister(i);
                localNormalSsaInsn.changeOneSource(j, ((RegisterSpecList)localObject2).get(j).withType((TypedConstant)this.latticeConstants[i]));
              }
            }
          }
        }
      }
    }
  }
  
  private void run()
  {
    addBlockToWorklist(this.ssaMeth.getEntryBlock());
    while ((!this.cfgWorklist.isEmpty()) || (!this.cfgPhiWorklist.isEmpty()) || (!this.ssaWorklist.isEmpty()) || (!this.varyingWorklist.isEmpty()))
    {
      int i;
      while (!this.cfgWorklist.isEmpty())
      {
        i = this.cfgWorklist.size();
        simulateBlock((SsaBasicBlock)this.cfgWorklist.remove(i - 1));
      }
      while (!this.cfgPhiWorklist.isEmpty())
      {
        i = this.cfgPhiWorklist.size();
        simulatePhiBlock((SsaBasicBlock)this.cfgPhiWorklist.remove(i - 1));
      }
      SsaInsn localSsaInsn;
      while (!this.varyingWorklist.isEmpty())
      {
        i = this.varyingWorklist.size();
        localSsaInsn = (SsaInsn)this.varyingWorklist.remove(i - 1);
        if (this.executableBlocks.get(localSsaInsn.getBlock().getIndex())) {
          if ((localSsaInsn instanceof PhiInsn)) {
            simulatePhi((PhiInsn)localSsaInsn);
          } else {
            simulateStmt(localSsaInsn);
          }
        }
      }
      while (!this.ssaWorklist.isEmpty())
      {
        i = this.ssaWorklist.size();
        localSsaInsn = (SsaInsn)this.ssaWorklist.remove(i - 1);
        if (this.executableBlocks.get(localSsaInsn.getBlock().getIndex())) {
          if ((localSsaInsn instanceof PhiInsn)) {
            simulatePhi((PhiInsn)localSsaInsn);
          } else {
            simulateStmt(localSsaInsn);
          }
        }
      }
    }
    replaceConstants();
    replaceBranches();
  }
  
  private boolean setLatticeValueTo(int paramInt1, int paramInt2, Constant paramConstant)
  {
    if (paramInt2 != 1)
    {
      if (this.latticeValues[paramInt1] != paramInt2)
      {
        this.latticeValues[paramInt1] = paramInt2;
        return true;
      }
      return false;
    }
    if ((this.latticeValues[paramInt1] != paramInt2) || (!this.latticeConstants[paramInt1].equals(paramConstant)))
    {
      this.latticeValues[paramInt1] = paramInt2;
      this.latticeConstants[paramInt1] = paramConstant;
      return true;
    }
    return false;
  }
  
  private void simulateBlock(SsaBasicBlock paramSsaBasicBlock)
  {
    paramSsaBasicBlock = paramSsaBasicBlock.getInsns().iterator();
    while (paramSsaBasicBlock.hasNext())
    {
      SsaInsn localSsaInsn = (SsaInsn)paramSsaBasicBlock.next();
      if ((localSsaInsn instanceof PhiInsn)) {
        simulatePhi((PhiInsn)localSsaInsn);
      } else {
        simulateStmt(localSsaInsn);
      }
    }
  }
  
  private void simulateBranch(SsaInsn paramSsaInsn)
  {
    int k = 0;
    Rop localRop = paramSsaInsn.getOpcode();
    RegisterSpecList localRegisterSpecList = paramSsaInsn.getSources();
    int i;
    if (localRop.getBranchingness() == 4)
    {
      localObject1 = localRegisterSpecList.get(0);
      i = ((RegisterSpec)localObject1).getReg();
      if ((this.ssaMeth.isRegALocal((RegisterSpec)localObject1)) || (this.latticeValues[i] != 1)) {
        break label663;
      }
    }
    label663:
    for (Object localObject1 = this.latticeConstants[i];; localObject1 = null)
    {
      if (localRegisterSpecList.size() == 2)
      {
        localObject2 = localRegisterSpecList.get(1);
        i = ((RegisterSpec)localObject2).getReg();
        if ((this.ssaMeth.isRegALocal((RegisterSpec)localObject2)) || (this.latticeValues[i] != 1)) {}
      }
      for (Object localObject2 = this.latticeConstants[i];; localObject2 = null)
      {
        int j;
        if ((localObject1 != null) && (localRegisterSpecList.size() == 1)) {
          switch (((TypedConstant)localObject1).getBasicType())
          {
          default: 
            i = 0;
            j = 0;
            localObject1 = paramSsaInsn.getBlock();
            if (j != 0) {
              if (i != 0)
              {
                i = ((SsaBasicBlock)localObject1).getSuccessorList().get(1);
                label188:
                addBlockToWorklist((SsaBasicBlock)this.ssaMeth.getBlocks().get(i));
                this.branchWorklist.add(paramSsaInsn);
              }
            }
            break;
          }
        }
        for (;;)
        {
          return;
          i = ((CstInteger)localObject1).getValue();
          switch (localRop.getOpcode())
          {
          default: 
            throw new RuntimeException("Unexpected op");
          case 7: 
            if (i == 0) {}
            for (i = 1;; i = 0)
            {
              j = 1;
              break;
            }
          case 8: 
            if (i != 0) {}
            for (i = 1;; i = 0)
            {
              j = 1;
              break;
            }
          case 9: 
            if (i < 0) {}
            for (i = 1;; i = 0)
            {
              j = 1;
              break;
            }
          case 10: 
            if (i >= 0) {}
            for (i = 1;; i = 0)
            {
              j = 1;
              break;
            }
          case 11: 
            if (i <= 0) {}
            for (i = 1;; i = 0)
            {
              j = 1;
              break;
            }
          }
          if (i > 0) {}
          for (i = 1;; i = 0)
          {
            j = 1;
            break;
          }
          if ((localObject1 != null) && (localObject2 != null)) {}
          switch (((TypedConstant)localObject1).getBasicType())
          {
          default: 
            i = 0;
            j = 0;
            break;
          case 6: 
            i = ((CstInteger)localObject1).getValue();
            j = ((CstInteger)localObject2).getValue();
            switch (localRop.getOpcode())
            {
            default: 
              throw new RuntimeException("Unexpected op");
            case 7: 
              if (i == j) {}
              for (i = 1;; i = 0)
              {
                j = 1;
                break;
              }
            case 8: 
              if (i != j) {}
              for (i = 1;; i = 0)
              {
                j = 1;
                break;
              }
            case 9: 
              if (i < j) {}
              for (i = 1;; i = 0)
              {
                j = 1;
                break;
              }
            case 10: 
              if (i >= j) {}
              for (i = 1;; i = 0)
              {
                j = 1;
                break;
              }
            case 11: 
              if (i <= j) {}
              for (i = 1;; i = 0)
              {
                j = 1;
                break;
              }
            }
            if (i > j) {}
            for (i = 1;; i = 0)
            {
              j = 1;
              break;
            }
            i = ((SsaBasicBlock)localObject1).getSuccessorList().get(0);
            break label188;
            while (k < ((SsaBasicBlock)localObject1).getSuccessorList().size())
            {
              i = ((SsaBasicBlock)localObject1).getSuccessorList().get(k);
              addBlockToWorklist((SsaBasicBlock)this.ssaMeth.getBlocks().get(i));
              k += 1;
            }
          }
        }
      }
    }
  }
  
  private Constant simulateMath(SsaInsn paramSsaInsn, int paramInt)
  {
    int i = 0;
    Insn localInsn = paramSsaInsn.getOriginalRopInsn();
    int j = paramSsaInsn.getOpcode().getOpcode();
    RegisterSpecList localRegisterSpecList = paramSsaInsn.getSources();
    int k = localRegisterSpecList.get(0).getReg();
    Constant localConstant;
    if (this.latticeValues[k] != 1)
    {
      localConstant = null;
      if (localRegisterSpecList.size() != 1) {
        break label89;
      }
      paramSsaInsn = ((CstInsn)localInsn).getConstant();
    }
    for (;;)
    {
      if ((localConstant != null) && (paramSsaInsn != null)) {
        break label127;
      }
      return null;
      localConstant = this.latticeConstants[k];
      break;
      label89:
      k = localRegisterSpecList.get(1).getReg();
      if (this.latticeValues[k] != 1) {
        paramSsaInsn = null;
      } else {
        paramSsaInsn = this.latticeConstants[k];
      }
    }
    switch (paramInt)
    {
    default: 
      label127:
      return null;
    }
    paramInt = ((CstInteger)localConstant).getValue();
    k = ((CstInteger)paramSsaInsn).getValue();
    switch (j)
    {
    case 19: 
    default: 
      throw new RuntimeException("Unexpected op");
    case 14: 
      i = k + paramInt;
      paramInt = 0;
    }
    while (paramInt == 0)
    {
      return CstInteger.make(i);
      if (localRegisterSpecList.size() == 1)
      {
        i = k - paramInt;
        paramInt = 0;
      }
      else
      {
        i = paramInt - k;
        paramInt = 0;
        continue;
        i = k * paramInt;
        paramInt = 0;
        continue;
        if (k == 0)
        {
          paramInt = 1;
        }
        else
        {
          i = paramInt / k;
          paramInt = 0;
          continue;
          i = k & paramInt;
          paramInt = 0;
          continue;
          i = k | paramInt;
          paramInt = 0;
          continue;
          i = k ^ paramInt;
          paramInt = 0;
          continue;
          i = paramInt << k;
          paramInt = 0;
          continue;
          i = paramInt >> k;
          paramInt = 0;
          continue;
          i = paramInt >>> k;
          paramInt = 0;
          continue;
          if (k == 0)
          {
            paramInt = 1;
          }
          else
          {
            i = paramInt % k;
            paramInt = 0;
          }
        }
      }
    }
  }
  
  private void simulatePhi(PhiInsn paramPhiInsn)
  {
    int m = paramPhiInsn.getResult().getReg();
    if (this.latticeValues[m] == 2) {}
    for (;;)
    {
      return;
      RegisterSpecList localRegisterSpecList = paramPhiInsn.getSources();
      int n = localRegisterSpecList.size();
      int k = 0;
      int i = 0;
      Object localObject1 = null;
      int j = i;
      if (k < n)
      {
        int i2 = paramPhiInsn.predBlockIndexForSourcesIndex(k);
        int i1 = localRegisterSpecList.get(k).getReg();
        j = this.latticeValues[i1];
        Object localObject2;
        if (!this.executableBlocks.get(i2)) {
          localObject2 = localObject1;
        }
        label132:
        do
        {
          for (;;)
          {
            k += 1;
            localObject1 = localObject2;
            break;
            if (j != 1) {
              break label173;
            }
            if (localObject1 != null) {
              break label132;
            }
            localObject2 = this.latticeConstants[i1];
            i = 1;
          }
          localObject2 = localObject1;
        } while (this.latticeConstants[i1].equals(localObject1));
        j = 2;
      }
      label173:
      while (setLatticeValueTo(m, j, localObject1))
      {
        addUsersToWorklist(m, j);
        return;
      }
    }
  }
  
  private void simulatePhiBlock(SsaBasicBlock paramSsaBasicBlock)
  {
    paramSsaBasicBlock = paramSsaBasicBlock.getInsns().iterator();
    while (paramSsaBasicBlock.hasNext())
    {
      SsaInsn localSsaInsn = (SsaInsn)paramSsaBasicBlock.next();
      if (!(localSsaInsn instanceof PhiInsn)) {
        break;
      }
      simulatePhi((PhiInsn)localSsaInsn);
    }
  }
  
  private void simulateStmt(SsaInsn paramSsaInsn)
  {
    Insn localInsn = paramSsaInsn.getOriginalRopInsn();
    if ((localInsn.getOpcode().getBranchingness() != 1) || (localInsn.getOpcode().isCallLike())) {
      simulateBranch(paramSsaInsn);
    }
    int i = paramSsaInsn.getOpcode().getOpcode();
    RegisterSpec localRegisterSpec2 = paramSsaInsn.getResult();
    RegisterSpec localRegisterSpec1 = localRegisterSpec2;
    int j;
    if (localRegisterSpec2 == null)
    {
      if ((i == 17) || (i == 18)) {
        localRegisterSpec1 = ((SsaInsn)paramSsaInsn.getBlock().getPrimarySuccessor().getInsns().get(0)).getResult();
      }
    }
    else
    {
      j = localRegisterSpec1.getReg();
      switch (i)
      {
      default: 
        paramSsaInsn = null;
        i = 2;
      }
    }
    for (;;)
    {
      if (setLatticeValueTo(j, i, paramSsaInsn)) {
        addUsersToWorklist(j, i);
      }
      return;
      paramSsaInsn = ((CstInsn)localInsn).getConstant();
      i = 1;
      continue;
      if (paramSsaInsn.getSources().size() != 1) {
        break;
      }
      int k = paramSsaInsn.getSources().get(0).getReg();
      i = this.latticeValues[k];
      paramSsaInsn = this.latticeConstants[k];
      continue;
      paramSsaInsn = simulateMath(paramSsaInsn, localRegisterSpec1.getBasicType());
      if (paramSsaInsn != null)
      {
        i = 1;
        continue;
        if (this.latticeValues[j] != 1) {
          break;
        }
        i = this.latticeValues[j];
        paramSsaInsn = this.latticeConstants[j];
        continue;
      }
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SCCP
 * JD-Core Version:    0.7.0.1
 */