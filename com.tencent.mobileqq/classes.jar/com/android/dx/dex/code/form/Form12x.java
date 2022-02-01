package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.dex.code.SimpleInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form12x
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form12x();
  
  public int codeSize()
  {
    return 1;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    BitSet localBitSet = new BitSet(2);
    int i = paramDalvInsn.get(0).getReg();
    int j = paramDalvInsn.get(1).getReg();
    switch (paramDalvInsn.size())
    {
    default: 
      throw new AssertionError();
    case 2: 
      localBitSet.set(0, unsignedFitsInNibble(i));
      localBitSet.set(1, unsignedFitsInNibble(j));
      return localBitSet;
    }
    if (i != j)
    {
      localBitSet.set(0, false);
      localBitSet.set(1, false);
    }
    for (;;)
    {
      localBitSet.set(2, unsignedFitsInNibble(paramDalvInsn.get(2).getReg()));
      return localBitSet;
      boolean bool = unsignedFitsInNibble(j);
      localBitSet.set(0, bool);
      localBitSet.set(1, bool);
    }
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    int i = paramDalvInsn.size();
    return paramDalvInsn.get(i - 2).regString() + ", " + paramDalvInsn.get(i - 1).regString();
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return "";
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    if (!(paramDalvInsn instanceof SimpleInsn)) {
      return false;
    }
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    RegisterSpec localRegisterSpec1;
    switch (localRegisterSpecList.size())
    {
    default: 
      return false;
    case 2: 
      paramDalvInsn = localRegisterSpecList.get(0);
      localRegisterSpec1 = localRegisterSpecList.get(1);
      if ((!unsignedFitsInNibble(paramDalvInsn.getReg())) || (!unsignedFitsInNibble(localRegisterSpec1.getReg()))) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      RegisterSpec localRegisterSpec2 = localRegisterSpecList.get(1);
      localRegisterSpec1 = localRegisterSpecList.get(2);
      paramDalvInsn = localRegisterSpec2;
      if (localRegisterSpec2.getReg() == localRegisterSpecList.get(0).getReg()) {
        break;
      }
      return false;
    }
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    int i = localRegisterSpecList.size();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, makeByte(localRegisterSpecList.get(i - 2).getReg(), localRegisterSpecList.get(i - 1).getReg())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form12x
 * JD-Core Version:    0.7.0.1
 */