package com.android.dx.dex.code.form;

import com.android.dx.dex.code.CstInsn;
import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form21c
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form21c();
  
  public int codeSize()
  {
    return 2;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    int i = paramDalvInsn.size();
    BitSet localBitSet = new BitSet(i);
    boolean bool = unsignedFitsInByte(paramDalvInsn.get(0).getReg());
    if (i == 1) {
      localBitSet.set(0, bool);
    }
    while (paramDalvInsn.get(0).getReg() != paramDalvInsn.get(1).getReg()) {
      return localBitSet;
    }
    localBitSet.set(0, bool);
    localBitSet.set(1, bool);
    return localBitSet;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    return localRegisterSpecList.get(0).regString() + ", " + cstString(paramDalvInsn);
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
    RegisterSpecList localRegisterSpecList;
    Object localObject;
    int i;
    do
    {
      do
      {
        return false;
        localRegisterSpecList = paramDalvInsn.getRegisters();
        switch (localRegisterSpecList.size())
        {
        default: 
          return false;
        case 1: 
          localObject = localRegisterSpecList.get(0);
        }
      } while (!unsignedFitsInByte(((RegisterSpec)localObject).getReg()));
      paramDalvInsn = (CstInsn)paramDalvInsn;
      i = paramDalvInsn.getIndex();
      paramDalvInsn = paramDalvInsn.getConstant();
    } while (!unsignedFitsInShort(i));
    if (((paramDalvInsn instanceof CstType)) || ((paramDalvInsn instanceof CstFieldRef)) || ((paramDalvInsn instanceof CstString))) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      RegisterSpec localRegisterSpec = localRegisterSpecList.get(0);
      localObject = localRegisterSpec;
      if (localRegisterSpec.getReg() == localRegisterSpecList.get(1).getReg()) {
        break;
      }
      return false;
    }
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    int i = ((CstInsn)paramDalvInsn).getIndex();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, localRegisterSpecList.get(0).getReg()), (short)i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form21c
 * JD-Core Version:    0.7.0.1
 */