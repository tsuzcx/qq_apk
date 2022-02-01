package com.android.dx.ssa;

import com.android.dx.cf.code.Merger;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.type.TypeBearer;
import java.util.BitSet;
import java.util.List;

public class PhiTypeResolver
{
  SsaMethod ssaMeth;
  private final BitSet worklist;
  
  private PhiTypeResolver(SsaMethod paramSsaMethod)
  {
    this.ssaMeth = paramSsaMethod;
    this.worklist = new BitSet(paramSsaMethod.getRegCount());
  }
  
  private static boolean equalsHandlesNulls(LocalItem paramLocalItem1, LocalItem paramLocalItem2)
  {
    return (paramLocalItem1 == paramLocalItem2) || ((paramLocalItem1 != null) && (paramLocalItem1.equals(paramLocalItem2)));
  }
  
  public static void process(SsaMethod paramSsaMethod)
  {
    new PhiTypeResolver(paramSsaMethod).run();
  }
  
  private void run()
  {
    int j = this.ssaMeth.getRegCount();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = this.ssaMeth.getDefinitionForRegister(i);
      if ((localObject != null) && (((SsaInsn)localObject).getResult().getBasicType() == 0)) {
        this.worklist.set(i);
      }
      i += 1;
    }
    for (;;)
    {
      i = this.worklist.nextSetBit(0);
      if (i < 0) {
        break;
      }
      this.worklist.clear(i);
      if (resolveResultType((PhiInsn)this.ssaMeth.getDefinitionForRegister(i)))
      {
        localObject = this.ssaMeth.getUseListForRegister(i);
        j = ((List)localObject).size();
        i = 0;
        while (i < j)
        {
          SsaInsn localSsaInsn = (SsaInsn)((List)localObject).get(i);
          RegisterSpec localRegisterSpec = localSsaInsn.getResult();
          if ((localRegisterSpec != null) && ((localSsaInsn instanceof PhiInsn))) {
            this.worklist.set(localRegisterSpec.getReg());
          }
          i += 1;
        }
      }
    }
  }
  
  boolean resolveResultType(PhiInsn paramPhiInsn)
  {
    int n = 0;
    paramPhiInsn.updateSourcesToDefinitions(this.ssaMeth);
    RegisterSpecList localRegisterSpecList = paramPhiInsn.getSources();
    int j = -1;
    int i1 = localRegisterSpecList.size();
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    if (i < i1)
    {
      localObject2 = localRegisterSpecList.get(i);
      if (((RegisterSpec)localObject2).getBasicType() == 0) {
        break label324;
      }
      j = i;
      localObject1 = localObject2;
    }
    label318:
    label324:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 == null) {
        return false;
      }
      Object localObject3 = ((RegisterSpec)localObject1).getLocalItem();
      localObject1 = ((RegisterSpec)localObject1).getType();
      int k = 0;
      i = 1;
      if (k < i1)
      {
        int m;
        if (k == j)
        {
          localObject2 = localObject1;
          m = i;
        }
        RegisterSpec localRegisterSpec;
        do
        {
          k += 1;
          i = m;
          localObject1 = localObject2;
          break;
          localRegisterSpec = localRegisterSpecList.get(k);
          m = i;
          localObject2 = localObject1;
        } while (localRegisterSpec.getBasicType() == 0);
        if ((i != 0) && (equalsHandlesNulls((LocalItem)localObject3, localRegisterSpec.getLocalItem()))) {}
        for (i = 1;; i = 0)
        {
          localObject2 = Merger.mergeType((TypeBearer)localObject1, localRegisterSpec.getType());
          m = i;
          break;
        }
      }
      if (localObject1 != null) {
        if (i == 0) {
          break label318;
        }
      }
      for (localObject2 = localObject3;; localObject2 = null)
      {
        localObject3 = paramPhiInsn.getResult();
        if ((((RegisterSpec)localObject3).getTypeBearer() == localObject1) && (equalsHandlesNulls((LocalItem)localObject2, ((RegisterSpec)localObject3).getLocalItem()))) {
          break;
        }
        paramPhiInsn.changeResultType((TypeBearer)localObject1, (LocalItem)localObject2);
        return true;
        paramPhiInsn = new StringBuilder();
        i = n;
        while (i < i1)
        {
          paramPhiInsn.append(localRegisterSpecList.get(i).toString());
          paramPhiInsn.append(' ');
          i += 1;
        }
        throw new RuntimeException("Couldn't map types in phi insn:" + paramPhiInsn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.PhiTypeResolver
 * JD-Core Version:    0.7.0.1
 */