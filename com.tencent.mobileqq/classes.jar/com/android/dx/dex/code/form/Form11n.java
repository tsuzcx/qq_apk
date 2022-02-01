package com.android.dx.dex.code.form;

import com.android.dx.dex.code.CstInsn;
import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form11n
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form11n();
  
  public int codeSize()
  {
    return 1;
  }
  
  public BitSet compatibleRegs(DalvInsn paramDalvInsn)
  {
    paramDalvInsn = paramDalvInsn.getRegisters();
    BitSet localBitSet = new BitSet(1);
    localBitSet.set(0, unsignedFitsInNibble(paramDalvInsn.get(0).getReg()));
    return localBitSet;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    paramDalvInsn = (CstLiteralBits)((CstInsn)paramDalvInsn).getConstant();
    return localRegisterSpecList.get(0).regString() + ", " + literalBitsString(paramDalvInsn);
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return literalBitsComment((CstLiteralBits)((CstInsn)paramDalvInsn).getConstant(), 4);
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    if ((!(paramDalvInsn instanceof CstInsn)) || (localRegisterSpecList.size() != 1) || (!unsignedFitsInNibble(localRegisterSpecList.get(0).getReg()))) {}
    do
    {
      return false;
      paramDalvInsn = ((CstInsn)paramDalvInsn).getConstant();
    } while (!(paramDalvInsn instanceof CstLiteralBits));
    paramDalvInsn = (CstLiteralBits)paramDalvInsn;
    if ((paramDalvInsn.fitsInInt()) && (signedFitsInNibble(paramDalvInsn.getIntBits()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    int i = ((CstLiteralBits)((CstInsn)paramDalvInsn).getConstant()).getIntBits();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, makeByte(localRegisterSpecList.get(0).getReg(), i & 0xF)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form11n
 * JD-Core Version:    0.7.0.1
 */