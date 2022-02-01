package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.dex.code.TargetInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form22t
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form22t();
  
  public boolean branchFits(TargetInsn paramTargetInsn)
  {
    int i = paramTargetInsn.getTargetOffset();
    return (i != 0) && (signedFitsInShort(i));
  }
  
  public int codeSize()
  {
    return 2;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    BitSet localBitSet = new BitSet(2);
    localBitSet.set(0, unsignedFitsInNibble(paramDalvInsn.get(0).getReg()));
    localBitSet.set(1, unsignedFitsInNibble(paramDalvInsn.get(1).getReg()));
    return localBitSet;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    return localRegisterSpecList.get(0).regString() + ", " + localRegisterSpecList.get(1).regString() + ", " + branchString(paramDalvInsn);
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return branchComment(paramDalvInsn);
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    boolean bool = true;
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    if ((!(paramDalvInsn instanceof TargetInsn)) || (localRegisterSpecList.size() != 2) || (!unsignedFitsInNibble(localRegisterSpecList.get(0).getReg())) || (!unsignedFitsInNibble(localRegisterSpecList.get(1).getReg()))) {
      bool = false;
    }
    do
    {
      return bool;
      paramDalvInsn = (TargetInsn)paramDalvInsn;
    } while (!paramDalvInsn.hasTargetOffset());
    return branchFits(paramDalvInsn);
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    int i = ((TargetInsn)paramDalvInsn).getTargetOffset();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, makeByte(localRegisterSpecList.get(0).getReg(), localRegisterSpecList.get(1).getReg())), (short)i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form22t
 * JD-Core Version:    0.7.0.1
 */