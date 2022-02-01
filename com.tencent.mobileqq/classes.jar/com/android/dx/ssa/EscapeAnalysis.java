package com.android.dx.ssa;

import com.android.dx.rop.code.Exceptions;
import com.android.dx.rop.code.FillArrayDataInsn;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.code.ThrowingInsn;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;
import com.android.dx.rop.cst.Zeroes;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class EscapeAnalysis
{
  private ArrayList<EscapeAnalysis.EscapeSet> latticeValues;
  private int regCount;
  private SsaMethod ssaMeth;
  
  private EscapeAnalysis(SsaMethod paramSsaMethod)
  {
    this.ssaMeth = paramSsaMethod;
    this.regCount = paramSsaMethod.getRegCount();
    this.latticeValues = new ArrayList();
  }
  
  private void addEdge(EscapeAnalysis.EscapeSet paramEscapeSet1, EscapeAnalysis.EscapeSet paramEscapeSet2)
  {
    if (!paramEscapeSet2.parentSets.contains(paramEscapeSet1)) {
      paramEscapeSet2.parentSets.add(paramEscapeSet1);
    }
    if (!paramEscapeSet1.childSets.contains(paramEscapeSet2)) {
      paramEscapeSet1.childSets.add(paramEscapeSet2);
    }
  }
  
  private int findSetIndex(RegisterSpec paramRegisterSpec)
  {
    int i = 0;
    for (;;)
    {
      if ((i >= this.latticeValues.size()) || (((EscapeAnalysis.EscapeSet)this.latticeValues.get(i)).regSet.get(paramRegisterSpec.getReg()))) {
        return i;
      }
      i += 1;
    }
  }
  
  private SsaInsn getInsnForMove(SsaInsn paramSsaInsn)
  {
    int i = paramSsaInsn.getBlock().getPredecessors().nextSetBit(0);
    paramSsaInsn = ((SsaBasicBlock)this.ssaMeth.getBlocks().get(i)).getInsns();
    return (SsaInsn)paramSsaInsn.get(paramSsaInsn.size() - 1);
  }
  
  private SsaInsn getMoveForInsn(SsaInsn paramSsaInsn)
  {
    int i = paramSsaInsn.getBlock().getSuccessors().nextSetBit(0);
    return (SsaInsn)((SsaBasicBlock)this.ssaMeth.getBlocks().get(i)).getInsns().get(0);
  }
  
  private void insertExceptionThrow(SsaInsn paramSsaInsn, RegisterSpec paramRegisterSpec, HashSet<SsaInsn> paramHashSet)
  {
    Object localObject = new CstType(Exceptions.TYPE_ArrayIndexOutOfBoundsException);
    insertThrowingInsnBefore(paramSsaInsn, RegisterSpecList.EMPTY, null, 40, (Constant)localObject);
    paramSsaInsn = paramSsaInsn.getBlock();
    SsaBasicBlock localSsaBasicBlock = paramSsaInsn.insertNewSuccessor(paramSsaInsn.getPrimarySuccessor());
    SsaInsn localSsaInsn = (SsaInsn)localSsaBasicBlock.getInsns().get(0);
    paramSsaInsn = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), (TypeBearer)localObject);
    insertPlainInsnBefore(localSsaInsn, RegisterSpecList.EMPTY, paramSsaInsn, 56, null);
    localSsaBasicBlock = localSsaBasicBlock.insertNewSuccessor(localSsaBasicBlock.getPrimarySuccessor());
    localSsaInsn = (SsaInsn)localSsaBasicBlock.getInsns().get(0);
    localObject = new CstMethodRef((CstType)localObject, new CstNat(new CstString("<init>"), new CstString("(I)V")));
    insertThrowingInsnBefore(localSsaInsn, RegisterSpecList.make(paramSsaInsn, paramRegisterSpec), null, 52, (Constant)localObject);
    paramHashSet.add(localSsaInsn);
    paramRegisterSpec = localSsaBasicBlock.insertNewSuccessor(localSsaBasicBlock.getPrimarySuccessor());
    localObject = (SsaInsn)paramRegisterSpec.getInsns().get(0);
    insertThrowingInsnBefore((SsaInsn)localObject, RegisterSpecList.make(paramSsaInsn), null, 35, null);
    paramRegisterSpec.replaceSuccessor(paramRegisterSpec.getPrimarySuccessorIndex(), this.ssaMeth.getExitBlock().getIndex());
    paramHashSet.add(localObject);
  }
  
  private void insertPlainInsnBefore(SsaInsn paramSsaInsn, RegisterSpecList paramRegisterSpecList, RegisterSpec paramRegisterSpec, int paramInt, Constant paramConstant)
  {
    Insn localInsn = paramSsaInsn.getOriginalRopInsn();
    Rop localRop;
    if (paramInt == 56)
    {
      localRop = Rops.opMoveResultPseudo(paramRegisterSpec.getType());
      if (paramConstant != null) {
        break label102;
      }
    }
    label102:
    for (paramRegisterSpecList = new PlainInsn(localRop, localInsn.getPosition(), paramRegisterSpec, paramRegisterSpecList);; paramRegisterSpecList = new PlainCstInsn(localRop, localInsn.getPosition(), paramRegisterSpec, paramRegisterSpecList, paramConstant))
    {
      paramRegisterSpecList = new NormalSsaInsn(paramRegisterSpecList, paramSsaInsn.getBlock());
      paramRegisterSpec = paramSsaInsn.getBlock().getInsns();
      paramRegisterSpec.add(paramRegisterSpec.lastIndexOf(paramSsaInsn), paramRegisterSpecList);
      this.ssaMeth.onInsnAdded(paramRegisterSpecList);
      return;
      localRop = Rops.ropFor(paramInt, paramRegisterSpec, paramRegisterSpecList, paramConstant);
      break;
    }
  }
  
  private void insertThrowingInsnBefore(SsaInsn paramSsaInsn, RegisterSpecList paramRegisterSpecList, RegisterSpec paramRegisterSpec, int paramInt, Constant paramConstant)
  {
    Insn localInsn = paramSsaInsn.getOriginalRopInsn();
    paramRegisterSpec = Rops.ropFor(paramInt, paramRegisterSpec, paramRegisterSpecList, paramConstant);
    if (paramConstant == null) {}
    for (paramRegisterSpecList = new ThrowingInsn(paramRegisterSpec, localInsn.getPosition(), paramRegisterSpecList, StdTypeList.EMPTY);; paramRegisterSpecList = new ThrowingCstInsn(paramRegisterSpec, localInsn.getPosition(), paramRegisterSpecList, StdTypeList.EMPTY, paramConstant))
    {
      paramRegisterSpecList = new NormalSsaInsn(paramRegisterSpecList, paramSsaInsn.getBlock());
      paramRegisterSpec = paramSsaInsn.getBlock().getInsns();
      paramRegisterSpec.add(paramRegisterSpec.lastIndexOf(paramSsaInsn), paramRegisterSpecList);
      this.ssaMeth.onInsnAdded(paramRegisterSpecList);
      return;
    }
  }
  
  private void movePropagate()
  {
    int i = 0;
    if (i < this.ssaMeth.getRegCount())
    {
      Object localObject3 = this.ssaMeth.getDefinitionForRegister(i);
      if ((localObject3 == null) || (((SsaInsn)localObject3).getOpcode() == null) || (((SsaInsn)localObject3).getOpcode().getOpcode() != 2)) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject1 = this.ssaMeth.getUseListCopy();
        Object localObject2 = ((SsaInsn)localObject3).getSources().get(0);
        localObject3 = ((SsaInsn)localObject3).getResult();
        if ((((RegisterSpec)localObject2).getReg() >= this.regCount) || (((RegisterSpec)localObject3).getReg() >= this.regCount))
        {
          localObject2 = new EscapeAnalysis.1(this, (RegisterSpec)localObject3, (RegisterSpec)localObject2);
          localObject1 = localObject1[localObject3.getReg()].iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((SsaInsn)((Iterator)localObject1).next()).mapSourceRegisters((RegisterMapper)localObject2);
          }
        }
      }
    }
  }
  
  public static void process(SsaMethod paramSsaMethod)
  {
    new EscapeAnalysis(paramSsaMethod).run();
  }
  
  private void processInsn(SsaInsn paramSsaInsn)
  {
    int i = paramSsaInsn.getOpcode().getOpcode();
    RegisterSpec localRegisterSpec = paramSsaInsn.getResult();
    if ((i == 56) && (localRegisterSpec.getTypeBearer().getBasicType() == 9)) {
      processRegister(localRegisterSpec, processMoveResultPseudoInsn(paramSsaInsn));
    }
    do
    {
      return;
      if ((i == 3) && (localRegisterSpec.getTypeBearer().getBasicType() == 9))
      {
        paramSsaInsn = new EscapeAnalysis.EscapeSet(localRegisterSpec.getReg(), this.regCount, EscapeAnalysis.EscapeState.NONE);
        this.latticeValues.add(paramSsaInsn);
        processRegister(localRegisterSpec, paramSsaInsn);
        return;
      }
    } while ((i != 55) || (localRegisterSpec.getTypeBearer().getBasicType() != 9));
    paramSsaInsn = new EscapeAnalysis.EscapeSet(localRegisterSpec.getReg(), this.regCount, EscapeAnalysis.EscapeState.NONE);
    this.latticeValues.add(paramSsaInsn);
    processRegister(localRegisterSpec, paramSsaInsn);
  }
  
  private EscapeAnalysis.EscapeSet processMoveResultPseudoInsn(SsaInsn paramSsaInsn)
  {
    RegisterSpec localRegisterSpec = paramSsaInsn.getResult();
    paramSsaInsn = getInsnForMove(paramSsaInsn);
    switch (paramSsaInsn.getOpcode().getOpcode())
    {
    default: 
      return null;
    case 5: 
    case 40: 
      paramSsaInsn = new EscapeAnalysis.EscapeSet(localRegisterSpec.getReg(), this.regCount, EscapeAnalysis.EscapeState.NONE);
    }
    for (;;)
    {
      this.latticeValues.add(paramSsaInsn);
      return paramSsaInsn;
      if (paramSsaInsn.getSources().get(0).getTypeBearer().isConstant())
      {
        paramSsaInsn = new EscapeAnalysis.EscapeSet(localRegisterSpec.getReg(), this.regCount, EscapeAnalysis.EscapeState.NONE);
        paramSsaInsn.replaceableArray = true;
      }
      else
      {
        paramSsaInsn = new EscapeAnalysis.EscapeSet(localRegisterSpec.getReg(), this.regCount, EscapeAnalysis.EscapeState.GLOBAL);
        continue;
        paramSsaInsn = new EscapeAnalysis.EscapeSet(localRegisterSpec.getReg(), this.regCount, EscapeAnalysis.EscapeState.GLOBAL);
        continue;
        paramSsaInsn = paramSsaInsn.getSources().get(0);
        int i = findSetIndex(paramSsaInsn);
        if (i != this.latticeValues.size())
        {
          paramSsaInsn = (EscapeAnalysis.EscapeSet)this.latticeValues.get(i);
          paramSsaInsn.regSet.set(localRegisterSpec.getReg());
          return paramSsaInsn;
        }
        if (paramSsaInsn.getType() == Type.KNOWN_NULL) {
          paramSsaInsn = new EscapeAnalysis.EscapeSet(localRegisterSpec.getReg(), this.regCount, EscapeAnalysis.EscapeState.NONE);
        } else {
          paramSsaInsn = new EscapeAnalysis.EscapeSet(localRegisterSpec.getReg(), this.regCount, EscapeAnalysis.EscapeState.GLOBAL);
        }
      }
    }
  }
  
  private void processPhiUse(SsaInsn paramSsaInsn, EscapeAnalysis.EscapeSet paramEscapeSet, ArrayList<RegisterSpec> paramArrayList)
  {
    int i = findSetIndex(paramSsaInsn.getResult());
    if (i != this.latticeValues.size())
    {
      paramSsaInsn = (EscapeAnalysis.EscapeSet)this.latticeValues.get(i);
      if (paramSsaInsn != paramEscapeSet)
      {
        paramEscapeSet.replaceableArray = false;
        paramEscapeSet.regSet.or(paramSsaInsn.regSet);
        if (paramEscapeSet.escape.compareTo(paramSsaInsn.escape) < 0) {
          paramEscapeSet.escape = paramSsaInsn.escape;
        }
        replaceNode(paramEscapeSet, paramSsaInsn);
        this.latticeValues.remove(i);
      }
      return;
    }
    paramEscapeSet.regSet.set(paramSsaInsn.getResult().getReg());
    paramArrayList.add(paramSsaInsn.getResult());
  }
  
  private void processRegister(RegisterSpec paramRegisterSpec, EscapeAnalysis.EscapeSet paramEscapeSet)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramRegisterSpec);
    while (!localArrayList.isEmpty())
    {
      paramRegisterSpec = (RegisterSpec)localArrayList.remove(localArrayList.size() - 1);
      Iterator localIterator = this.ssaMeth.getUseListForRegister(paramRegisterSpec.getReg()).iterator();
      while (localIterator.hasNext())
      {
        SsaInsn localSsaInsn = (SsaInsn)localIterator.next();
        if (localSsaInsn.getOpcode() == null) {
          processPhiUse(localSsaInsn, paramEscapeSet, localArrayList);
        } else {
          processUse(paramRegisterSpec, localSsaInsn, paramEscapeSet, localArrayList);
        }
      }
    }
  }
  
  private void processUse(RegisterSpec paramRegisterSpec, SsaInsn paramSsaInsn, EscapeAnalysis.EscapeSet paramEscapeSet, ArrayList<RegisterSpec> paramArrayList)
  {
    switch (paramSsaInsn.getOpcode().getOpcode())
    {
    default: 
    case 2: 
    case 7: 
    case 8: 
    case 43: 
    case 39: 
    case 47: 
    case 38: 
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    paramEscapeSet.regSet.set(paramSsaInsn.getResult().getReg());
                    paramArrayList.add(paramSsaInsn.getResult());
                    return;
                  } while (paramEscapeSet.escape.compareTo(EscapeAnalysis.EscapeState.METHOD) >= 0);
                  paramEscapeSet.escape = EscapeAnalysis.EscapeState.METHOD;
                  return;
                  if (!paramSsaInsn.getSources().get(2).getTypeBearer().isConstant()) {
                    paramEscapeSet.replaceableArray = false;
                  }
                } while (paramSsaInsn.getSources().get(0).getTypeBearer().getBasicType() != 9);
                paramEscapeSet.replaceableArray = false;
                paramSsaInsn = paramSsaInsn.getSources();
                if (paramSsaInsn.get(0).getReg() != paramRegisterSpec.getReg()) {
                  break;
                }
                i = findSetIndex(paramSsaInsn.get(1));
              } while (i == this.latticeValues.size());
              paramRegisterSpec = (EscapeAnalysis.EscapeSet)this.latticeValues.get(i);
              addEdge(paramRegisterSpec, paramEscapeSet);
            } while (paramEscapeSet.escape.compareTo(paramRegisterSpec.escape) >= 0);
            paramEscapeSet.escape = paramRegisterSpec.escape;
            return;
            i = findSetIndex(paramSsaInsn.get(0));
          } while (i == this.latticeValues.size());
          paramRegisterSpec = (EscapeAnalysis.EscapeSet)this.latticeValues.get(i);
          addEdge(paramEscapeSet, paramRegisterSpec);
        } while (paramRegisterSpec.escape.compareTo(paramEscapeSet.escape) >= 0);
        paramRegisterSpec.escape = paramEscapeSet.escape;
        return;
      } while (paramSsaInsn.getSources().get(1).getTypeBearer().isConstant());
      paramEscapeSet.replaceableArray = false;
      return;
    case 48: 
      paramEscapeSet.escape = EscapeAnalysis.EscapeState.GLOBAL;
      return;
    }
    paramEscapeSet.escape = EscapeAnalysis.EscapeState.INTER;
  }
  
  private void replaceDef(SsaInsn paramSsaInsn1, SsaInsn paramSsaInsn2, int paramInt, ArrayList<RegisterSpec> paramArrayList)
  {
    paramSsaInsn2 = paramSsaInsn1.getResult().getType();
    int i = 0;
    while (i < paramInt)
    {
      Constant localConstant = Zeroes.zeroFor(paramSsaInsn2.getComponentType());
      Object localObject = (TypedConstant)localConstant;
      localObject = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), (TypeBearer)localObject);
      paramArrayList.add(localObject);
      insertPlainInsnBefore(paramSsaInsn1, RegisterSpecList.EMPTY, (RegisterSpec)localObject, 5, localConstant);
      i += 1;
    }
  }
  
  private void replaceNode(EscapeAnalysis.EscapeSet paramEscapeSet1, EscapeAnalysis.EscapeSet paramEscapeSet2)
  {
    Iterator localIterator = paramEscapeSet2.parentSets.iterator();
    EscapeAnalysis.EscapeSet localEscapeSet;
    while (localIterator.hasNext())
    {
      localEscapeSet = (EscapeAnalysis.EscapeSet)localIterator.next();
      localEscapeSet.childSets.remove(paramEscapeSet2);
      localEscapeSet.childSets.add(paramEscapeSet1);
      paramEscapeSet1.parentSets.add(localEscapeSet);
    }
    localIterator = paramEscapeSet2.childSets.iterator();
    while (localIterator.hasNext())
    {
      localEscapeSet = (EscapeAnalysis.EscapeSet)localIterator.next();
      localEscapeSet.parentSets.remove(paramEscapeSet2);
      localEscapeSet.parentSets.add(paramEscapeSet1);
      paramEscapeSet1.childSets.add(localEscapeSet);
    }
  }
  
  private void replaceUse(SsaInsn paramSsaInsn1, SsaInsn paramSsaInsn2, ArrayList<RegisterSpec> paramArrayList, HashSet<SsaInsn> paramHashSet)
  {
    int j = paramArrayList.size();
    switch (paramSsaInsn1.getOpcode().getOpcode())
    {
    }
    for (;;)
    {
      return;
      paramSsaInsn2 = getMoveForInsn(paramSsaInsn1);
      paramSsaInsn1 = paramSsaInsn1.getSources();
      int i = ((CstLiteralBits)paramSsaInsn1.get(1).getTypeBearer()).getIntBits();
      if (i < j)
      {
        paramSsaInsn1 = (RegisterSpec)paramArrayList.get(i);
        paramArrayList = paramSsaInsn1.withReg(paramSsaInsn2.getResult().getReg());
        insertPlainInsnBefore(paramSsaInsn2, RegisterSpecList.make(paramSsaInsn1), paramArrayList, 2, null);
      }
      for (;;)
      {
        paramHashSet.add(paramSsaInsn2);
        return;
        insertExceptionThrow(paramSsaInsn2, paramSsaInsn1.get(1), paramHashSet);
        paramHashSet.add(paramSsaInsn2.getBlock().getInsns().get(2));
      }
      paramSsaInsn2 = paramSsaInsn1.getSources();
      i = ((CstLiteralBits)paramSsaInsn2.get(2).getTypeBearer()).getIntBits();
      if (i < j)
      {
        paramSsaInsn2 = paramSsaInsn2.get(0);
        paramHashSet = paramSsaInsn2.withReg(((RegisterSpec)paramArrayList.get(i)).getReg());
        insertPlainInsnBefore(paramSsaInsn1, RegisterSpecList.make(paramSsaInsn2), paramHashSet, 2, null);
        paramArrayList.set(i, paramHashSet.withSimpleType());
        return;
      }
      insertExceptionThrow(paramSsaInsn1, paramSsaInsn2.get(2), paramHashSet);
      return;
      paramSsaInsn2 = paramSsaInsn2.getSources().get(0).getTypeBearer();
      paramSsaInsn1 = getMoveForInsn(paramSsaInsn1);
      insertPlainInsnBefore(paramSsaInsn1, RegisterSpecList.EMPTY, paramSsaInsn1.getResult(), 5, (Constant)paramSsaInsn2);
      paramHashSet.add(paramSsaInsn1);
      return;
      paramSsaInsn2 = ((FillArrayDataInsn)paramSsaInsn1.getOriginalRopInsn()).getInitValues();
      i = 0;
      while (i < j)
      {
        paramHashSet = RegisterSpec.make(((RegisterSpec)paramArrayList.get(i)).getReg(), (TypeBearer)paramSsaInsn2.get(i));
        insertPlainInsnBefore(paramSsaInsn1, RegisterSpecList.EMPTY, paramHashSet, 5, (Constant)paramSsaInsn2.get(i));
        paramArrayList.set(i, paramHashSet);
        i += 1;
      }
    }
  }
  
  private void run()
  {
    this.ssaMeth.forEachBlockDepthFirstDom(new EscapeAnalysis.2(this));
    Iterator localIterator1 = this.latticeValues.iterator();
    while (localIterator1.hasNext())
    {
      EscapeAnalysis.EscapeSet localEscapeSet1 = (EscapeAnalysis.EscapeSet)localIterator1.next();
      if (localEscapeSet1.escape != EscapeAnalysis.EscapeState.NONE)
      {
        Iterator localIterator2 = localEscapeSet1.childSets.iterator();
        while (localIterator2.hasNext())
        {
          EscapeAnalysis.EscapeSet localEscapeSet2 = (EscapeAnalysis.EscapeSet)localIterator2.next();
          if (localEscapeSet1.escape.compareTo(localEscapeSet2.escape) > 0) {
            localEscapeSet2.escape = localEscapeSet1.escape;
          }
        }
      }
    }
    scalarReplacement();
  }
  
  private void scalarReplacement()
  {
    Iterator localIterator = this.latticeValues.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (EscapeAnalysis.EscapeSet)localIterator.next();
      if ((((EscapeAnalysis.EscapeSet)localObject1).replaceableArray) && (((EscapeAnalysis.EscapeSet)localObject1).escape == EscapeAnalysis.EscapeState.NONE))
      {
        int i = ((EscapeAnalysis.EscapeSet)localObject1).regSet.nextSetBit(0);
        Object localObject2 = this.ssaMeth.getDefinitionForRegister(i);
        localObject1 = getInsnForMove((SsaInsn)localObject2);
        int j = ((CstLiteralBits)((SsaInsn)localObject1).getSources().get(0).getTypeBearer()).getIntBits();
        ArrayList localArrayList = new ArrayList(j);
        HashSet localHashSet = new HashSet();
        replaceDef((SsaInsn)localObject2, (SsaInsn)localObject1, j, localArrayList);
        localHashSet.add(localObject1);
        localHashSet.add(localObject2);
        localObject2 = this.ssaMeth.getUseListForRegister(i).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          SsaInsn localSsaInsn = (SsaInsn)((Iterator)localObject2).next();
          replaceUse(localSsaInsn, (SsaInsn)localObject1, localArrayList, localHashSet);
          localHashSet.add(localSsaInsn);
        }
        this.ssaMeth.deleteInsns(localHashSet);
        this.ssaMeth.onInsnsChanged();
        SsaConverter.updateSsaMethod(this.ssaMeth, this.regCount);
        movePropagate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.EscapeAnalysis
 * JD-Core Version:    0.7.0.1
 */