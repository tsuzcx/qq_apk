package com.android.dx.dex.code.form;

import com.android.dx.dex.code.CstInsn;
import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form22b
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form22b();
  
  public int codeSize()
  {
    return 2;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    BitSet localBitSet = new BitSet(2);
    localBitSet.set(0, unsignedFitsInByte(paramDalvInsn.get(0).getReg()));
    localBitSet.set(1, unsignedFitsInByte(paramDalvInsn.get(1).getReg()));
    return localBitSet;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    paramDalvInsn = (CstLiteralBits)((CstInsn)paramDalvInsn).getConstant();
    return localRegisterSpecList.get(0).regString() + ", " + localRegisterSpecList.get(1).regString() + ", " + literalBitsString(paramDalvInsn);
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return literalBitsComment((CstLiteralBits)((CstInsn)paramDalvInsn).getConstant(), 8);
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    if ((!(paramDalvInsn instanceof CstInsn)) || (localRegisterSpecList.size() != 2) || (!unsignedFitsInByte(localRegisterSpecList.get(0).getReg())) || (!unsignedFitsInByte(localRegisterSpecList.get(1).getReg()))) {}
    do
    {
      return false;
      paramDalvInsn = ((CstInsn)paramDalvInsn).getConstant();
    } while (!(paramDalvInsn instanceof CstLiteralBits));
    paramDalvInsn = (CstLiteralBits)paramDalvInsn;
    if ((paramDalvInsn.fitsInInt()) && (signedFitsInByte(paramDalvInsn.getIntBits()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    int i = ((CstLiteralBits)((CstInsn)paramDalvInsn).getConstant()).getIntBits();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, localRegisterSpecList.get(0).getReg()), codeUnit(localRegisterSpecList.get(1).getReg(), i & 0xFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form22b
 * JD-Core Version:    0.7.0.1
 */