package com.android.dx.dex.code.form;

import com.android.dx.dex.code.CstInsn;
import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form35c
  extends InsnFormat
{
  private static final int MAX_NUM_OPS = 5;
  public static final InsnFormat THE_ONE = new Form35c();
  
  private static RegisterSpecList explicitize(RegisterSpecList paramRegisterSpecList)
  {
    int i = 0;
    int j = wordCount(paramRegisterSpecList);
    int k = paramRegisterSpecList.size();
    if (j == k) {
      return paramRegisterSpecList;
    }
    RegisterSpecList localRegisterSpecList = new RegisterSpecList(j);
    j = 0;
    if (j < k)
    {
      RegisterSpec localRegisterSpec = paramRegisterSpecList.get(j);
      localRegisterSpecList.set(i, localRegisterSpec);
      if (localRegisterSpec.getCategory() == 2)
      {
        localRegisterSpecList.set(i + 1, RegisterSpec.make(localRegisterSpec.getReg() + 1, Type.VOID));
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    localRegisterSpecList.setImmutable();
    return localRegisterSpecList;
  }
  
  private static int wordCount(RegisterSpecList paramRegisterSpecList)
  {
    int i = 0;
    int k = paramRegisterSpecList.size();
    if (k > 5) {
      return -1;
    }
    int j = 0;
    for (;;)
    {
      if (j >= k) {
        break label66;
      }
      RegisterSpec localRegisterSpec = paramRegisterSpecList.get(j);
      int m = localRegisterSpec.getCategory();
      if (!unsignedFitsInNibble(localRegisterSpec.getReg() + localRegisterSpec.getCategory() - 1)) {
        break;
      }
      j += 1;
      i = m + i;
    }
    label66:
    if (i <= 5) {}
    for (;;)
    {
      return i;
      i = -1;
    }
  }
  
  public int codeSize()
  {
    return 3;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    int j = paramDalvInsn.size();
    BitSet localBitSet = new BitSet(j);
    int i = 0;
    while (i < j)
    {
      RegisterSpec localRegisterSpec = paramDalvInsn.get(i);
      int k = localRegisterSpec.getReg();
      localBitSet.set(i, unsignedFitsInNibble(localRegisterSpec.getCategory() + k - 1));
      i += 1;
    }
    return localBitSet;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = explicitize(paramDalvInsn.getRegisters());
    return regListString(localRegisterSpecList) + ", " + cstString(paramDalvInsn);
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    if (paramBoolean) {
      return cstComment(paramDalvInsn);
    }
    return "";
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    if (!(paramDalvInsn instanceof CstInsn)) {}
    Constant localConstant;
    do
    {
      do
      {
        return false;
        paramDalvInsn = (CstInsn)paramDalvInsn;
      } while (!unsignedFitsInShort(paramDalvInsn.getIndex()));
      localConstant = paramDalvInsn.getConstant();
    } while (((!(localConstant instanceof CstMethodRef)) && (!(localConstant instanceof CstType))) || (wordCount(paramDalvInsn.getRegisters()) < 0));
    return true;
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    int i1 = ((CstInsn)paramDalvInsn).getIndex();
    RegisterSpecList localRegisterSpecList = explicitize(paramDalvInsn.getRegisters());
    int i2 = localRegisterSpecList.size();
    int i;
    int j;
    label57:
    int k;
    label74:
    int m;
    if (i2 > 0)
    {
      i = localRegisterSpecList.get(0).getReg();
      if (i2 <= 1) {
        break label142;
      }
      j = localRegisterSpecList.get(1).getReg();
      if (i2 <= 2) {
        break label148;
      }
      k = localRegisterSpecList.get(2).getReg();
      if (i2 <= 3) {
        break label154;
      }
      m = localRegisterSpecList.get(3).getReg();
      label91:
      if (i2 <= 4) {
        break label160;
      }
    }
    label142:
    label148:
    label154:
    label160:
    for (int n = localRegisterSpecList.get(4).getReg();; n = 0)
    {
      write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, makeByte(n, i2)), (short)i1, codeUnit(i, j, k, m));
      return;
      i = 0;
      break;
      j = 0;
      break label57;
      k = 0;
      break label74;
      m = 0;
      break label91;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form35c
 * JD-Core Version:    0.7.0.1
 */