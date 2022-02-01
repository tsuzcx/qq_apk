package com.android.dx.ssa;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.TypedConstant;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.TypeBearer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ConstCollector
{
  private static boolean COLLECT_ONE_LOCAL = false;
  private static boolean COLLECT_STRINGS = false;
  private static final int MAX_COLLECTED_CONSTANTS = 5;
  private final SsaMethod ssaMeth;
  
  private ConstCollector(SsaMethod paramSsaMethod)
  {
    this.ssaMeth = paramSsaMethod;
  }
  
  private void fixLocalAssignment(RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2)
  {
    paramRegisterSpec1 = this.ssaMeth.getUseListForRegister(paramRegisterSpec1.getReg()).iterator();
    while (paramRegisterSpec1.hasNext())
    {
      SsaInsn localSsaInsn = (SsaInsn)paramRegisterSpec1.next();
      Object localObject = localSsaInsn.getLocalAssignment();
      if ((localObject != null) && (localSsaInsn.getResult() != null))
      {
        localObject = ((RegisterSpec)localObject).getLocalItem();
        localSsaInsn.setResultLocal(null);
        paramRegisterSpec2 = paramRegisterSpec2.withLocalItem((LocalItem)localObject);
        localObject = SsaInsn.makeFromRop(new PlainInsn(Rops.opMarkLocal(paramRegisterSpec2), SourcePosition.NO_INFO, null, RegisterSpecList.make(paramRegisterSpec2)), localSsaInsn.getBlock());
        ArrayList localArrayList = localSsaInsn.getBlock().getInsns();
        localArrayList.add(localArrayList.indexOf(localSsaInsn) + 1, localObject);
      }
    }
  }
  
  private ArrayList<TypedConstant> getConstsSortedByCountUse()
  {
    int j = this.ssaMeth.getRegCount();
    HashMap localHashMap = new HashMap();
    Object localObject3 = new HashSet();
    int i = 0;
    if (i < j)
    {
      localObject2 = this.ssaMeth.getDefinitionForRegister(i);
      if ((localObject2 == null) || (((SsaInsn)localObject2).getOpcode() == null)) {}
      for (;;)
      {
        i += 1;
        break;
        RegisterSpec localRegisterSpec = ((SsaInsn)localObject2).getResult();
        localObject1 = localRegisterSpec.getTypeBearer();
        if (((TypeBearer)localObject1).isConstant())
        {
          TypedConstant localTypedConstant = (TypedConstant)localObject1;
          localObject1 = localObject2;
          if (((SsaInsn)localObject2).getOpcode().getOpcode() == 56)
          {
            int k = ((SsaInsn)localObject2).getBlock().getPredecessors().nextSetBit(0);
            localObject1 = ((SsaBasicBlock)this.ssaMeth.getBlocks().get(k)).getInsns();
            localObject1 = (SsaInsn)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1);
          }
          if ((!((SsaInsn)localObject1).canThrow()) || (((localTypedConstant instanceof CstString)) && (COLLECT_STRINGS) && (((SsaInsn)localObject1).getBlock().getSuccessors().cardinality() <= 1))) {
            if (this.ssaMeth.isRegALocal(localRegisterSpec))
            {
              if ((COLLECT_ONE_LOCAL) && (!((HashSet)localObject3).contains(localTypedConstant))) {
                ((HashSet)localObject3).add(localTypedConstant);
              }
            }
            else
            {
              localObject1 = (Integer)localHashMap.get(localTypedConstant);
              if (localObject1 == null) {
                localHashMap.put(localTypedConstant, Integer.valueOf(1));
              } else {
                localHashMap.put(localTypedConstant, Integer.valueOf(((Integer)localObject1).intValue() + 1));
              }
            }
          }
        }
      }
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = localHashMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      if (((Integer)((Map.Entry)localObject3).getValue()).intValue() > 1) {
        ((ArrayList)localObject1).add(((Map.Entry)localObject3).getKey());
      }
    }
    Collections.sort((List)localObject1, new ConstCollector.1(this, localHashMap));
    return localObject1;
  }
  
  public static void process(SsaMethod paramSsaMethod)
  {
    new ConstCollector(paramSsaMethod).run();
  }
  
  private void run()
  {
    int j = this.ssaMeth.getRegCount();
    ArrayList localArrayList = getConstsSortedByCountUse();
    int k = Math.min(localArrayList.size(), 5);
    SsaBasicBlock localSsaBasicBlock1 = this.ssaMeth.getEntryBlock();
    HashMap localHashMap = new HashMap(k);
    int i = 0;
    if (i < k)
    {
      TypedConstant localTypedConstant = (TypedConstant)localArrayList.get(i);
      RegisterSpec localRegisterSpec = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), localTypedConstant);
      Rop localRop = Rops.opConst(localTypedConstant);
      if (localRop.getBranchingness() == 1) {
        localSsaBasicBlock1.addInsnToHead(new PlainCstInsn(Rops.opConst(localTypedConstant), SourcePosition.NO_INFO, localRegisterSpec, RegisterSpecList.EMPTY, localTypedConstant));
      }
      for (;;)
      {
        localHashMap.put(localTypedConstant, localRegisterSpec);
        i += 1;
        break;
        SsaBasicBlock localSsaBasicBlock3 = this.ssaMeth.getEntryBlock();
        SsaBasicBlock localSsaBasicBlock2 = localSsaBasicBlock3.getPrimarySuccessor();
        localSsaBasicBlock3 = localSsaBasicBlock3.insertNewSuccessor(localSsaBasicBlock2);
        localSsaBasicBlock3.replaceLastInsn(new ThrowingCstInsn(localRop, SourcePosition.NO_INFO, RegisterSpecList.EMPTY, StdTypeList.EMPTY, localTypedConstant));
        localSsaBasicBlock3.insertNewSuccessor(localSsaBasicBlock2).addInsnToHead(new PlainInsn(Rops.opMoveResultPseudo(localRegisterSpec.getTypeBearer()), SourcePosition.NO_INFO, localRegisterSpec, RegisterSpecList.EMPTY));
      }
    }
    updateConstUses(localHashMap, j);
  }
  
  private void updateConstUses(HashMap<TypedConstant, RegisterSpec> paramHashMap, int paramInt)
  {
    HashSet localHashSet = new HashSet();
    ArrayList[] arrayOfArrayList = this.ssaMeth.getUseListCopy();
    int i = 0;
    if (i < paramInt)
    {
      Object localObject2 = this.ssaMeth.getDefinitionForRegister(i);
      if (localObject2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject1 = ((SsaInsn)localObject2).getResult();
        localObject2 = ((SsaInsn)localObject2).getResult().getTypeBearer();
        if (((TypeBearer)localObject2).isConstant())
        {
          localObject2 = (TypedConstant)localObject2;
          Object localObject3 = (RegisterSpec)paramHashMap.get(localObject2);
          if (localObject3 != null) {
            if (this.ssaMeth.isRegALocal((RegisterSpec)localObject1))
            {
              if ((COLLECT_ONE_LOCAL) && (!localHashSet.contains(localObject2)))
              {
                localHashSet.add(localObject2);
                fixLocalAssignment((RegisterSpec)localObject1, (RegisterSpec)paramHashMap.get(localObject2));
              }
            }
            else
            {
              localObject2 = new ConstCollector.2(this, (RegisterSpec)localObject1, (RegisterSpec)localObject3);
              localObject1 = arrayOfArrayList[localObject1.getReg()].iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (SsaInsn)((Iterator)localObject1).next();
                if ((!((SsaInsn)localObject3).canThrow()) || (((SsaInsn)localObject3).getBlock().getSuccessors().cardinality() <= 1)) {
                  ((SsaInsn)localObject3).mapSourceRegisters((RegisterMapper)localObject2);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.ConstCollector
 * JD-Core Version:    0.7.0.1
 */