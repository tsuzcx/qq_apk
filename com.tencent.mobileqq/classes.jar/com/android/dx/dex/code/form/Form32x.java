package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.dex.code.SimpleInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form32x
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form32x();
  
  public int codeSize()
  {
    return 3;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    BitSet localBitSet = new BitSet(2);
    localBitSet.set(0, unsignedFitsInShort(paramDalvInsn.get(0).getReg()));
    localBitSet.set(1, unsignedFitsInShort(paramDalvInsn.get(1).getReg()));
    return localBitSet;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    return paramDalvInsn.get(0).regString() + ", " + paramDalvInsn.get(1).regString();
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return "";
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    return ((paramDalvInsn instanceof SimpleInsn)) && (localRegisterSpecList.size() == 2) && (unsignedFitsInShort(localRegisterSpecList.get(0).getReg())) && (unsignedFitsInShort(localRegisterSpecList.get(1).getReg()));
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, 0), (short)localRegisterSpecList.get(0).getReg(), (short)localRegisterSpecList.get(1).getReg());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form32x
 * JD-Core Version:    0.7.0.1
 */