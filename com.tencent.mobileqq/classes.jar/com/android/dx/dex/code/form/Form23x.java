package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.dex.code.SimpleInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form23x
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form23x();
  
  public int codeSize()
  {
    return 2;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    BitSet localBitSet = new BitSet(3);
    localBitSet.set(0, unsignedFitsInByte(paramDalvInsn.get(0).getReg()));
    localBitSet.set(1, unsignedFitsInByte(paramDalvInsn.get(1).getReg()));
    localBitSet.set(2, unsignedFitsInByte(paramDalvInsn.get(2).getReg()));
    return localBitSet;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    return paramDalvInsn.get(0).regString() + ", " + paramDalvInsn.get(1).regString() + ", " + paramDalvInsn.get(2).regString();
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return "";
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    return ((paramDalvInsn instanceof SimpleInsn)) && (localRegisterSpecList.size() == 3) && (unsignedFitsInByte(localRegisterSpecList.get(0).getReg())) && (unsignedFitsInByte(localRegisterSpecList.get(1).getReg())) && (unsignedFitsInByte(localRegisterSpecList.get(2).getReg()));
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, localRegisterSpecList.get(0).getReg()), codeUnit(localRegisterSpecList.get(1).getReg(), localRegisterSpecList.get(2).getReg()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form23x
 * JD-Core Version:    0.7.0.1
 */