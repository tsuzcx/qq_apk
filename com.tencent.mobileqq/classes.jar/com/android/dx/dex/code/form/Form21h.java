package com.android.dx.dex.code.form;

import com.android.dx.dex.code.CstInsn;
import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form21h
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form21h();
  
  public int codeSize()
  {
    return 2;
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
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    paramDalvInsn = (CstLiteralBits)((CstInsn)paramDalvInsn).getConstant();
    if (localRegisterSpecList.get(0).getCategory() == 1) {}
    for (int i = 32;; i = 64) {
      return literalBitsComment(paramDalvInsn, i);
    }
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    boolean bool = true;
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    if ((!(paramDalvInsn instanceof CstInsn)) || (localRegisterSpecList.size() != 1) || (!unsignedFitsInByte(localRegisterSpecList.get(0).getReg()))) {}
    do
    {
      return false;
      paramDalvInsn = ((CstInsn)paramDalvInsn).getConstant();
    } while (!(paramDalvInsn instanceof CstLiteralBits));
    paramDalvInsn = (CstLiteralBits)paramDalvInsn;
    if (localRegisterSpecList.get(0).getCategory() == 1)
    {
      if ((paramDalvInsn.getIntBits() & 0xFFFF) == 0) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    if ((paramDalvInsn.getLongBits() & 0xFFFFFFFF) == 0L) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    CstLiteralBits localCstLiteralBits = (CstLiteralBits)((CstInsn)paramDalvInsn).getConstant();
    if (localRegisterSpecList.get(0).getCategory() == 1) {}
    for (short s = (short)(localCstLiteralBits.getIntBits() >>> 16);; s = (short)(int)(localCstLiteralBits.getLongBits() >>> 48))
    {
      write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, localRegisterSpecList.get(0).getReg()), s);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form21h
 * JD-Core Version:    0.7.0.1
 */