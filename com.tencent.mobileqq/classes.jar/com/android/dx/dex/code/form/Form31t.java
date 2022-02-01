package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.dex.code.TargetInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form31t
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form31t();
  
  public boolean branchFits(TargetInsn paramTargetInsn)
  {
    return true;
  }
  
  public int codeSize()
  {
    return 3;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    BitSet localBitSet = new BitSet(1);
    localBitSet.set(0, unsignedFitsInByte(paramDalvInsn.get(0).getReg()));
    return localBitSet;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    return localRegisterSpecList.get(0).regString() + ", " + branchString(paramDalvInsn);
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return branchComment(paramDalvInsn);
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    boolean bool = true;
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    if ((!(paramDalvInsn instanceof TargetInsn)) || (localRegisterSpecList.size() != 1) || (!unsignedFitsInByte(localRegisterSpecList.get(0).getReg()))) {
      bool = false;
    }
    return bool;
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    int i = ((TargetInsn)paramDalvInsn).getTargetOffset();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, localRegisterSpecList.get(0).getReg()), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form31t
 * JD-Core Version:    0.7.0.1
 */