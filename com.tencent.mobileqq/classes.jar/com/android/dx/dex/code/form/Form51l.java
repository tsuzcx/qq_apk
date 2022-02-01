package com.android.dx.dex.code.form;

import com.android.dx.dex.code.CstInsn;
import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.CstLiteral64;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form51l
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form51l();
  
  public int codeSize()
  {
    return 5;
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
    paramDalvInsn = (CstLiteralBits)((CstInsn)paramDalvInsn).getConstant();
    return localRegisterSpecList.get(0).regString() + ", " + literalBitsString(paramDalvInsn);
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return literalBitsComment((CstLiteralBits)((CstInsn)paramDalvInsn).getConstant(), 64);
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    if ((!(paramDalvInsn instanceof CstInsn)) || (localRegisterSpecList.size() != 1) || (!unsignedFitsInByte(localRegisterSpecList.get(0).getReg()))) {
      return false;
    }
    return ((CstInsn)paramDalvInsn).getConstant() instanceof CstLiteral64;
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    long l = ((CstLiteral64)((CstInsn)paramDalvInsn).getConstant()).getLongBits();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, localRegisterSpecList.get(0).getReg()), l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form51l
 * JD-Core Version:    0.7.0.1
 */