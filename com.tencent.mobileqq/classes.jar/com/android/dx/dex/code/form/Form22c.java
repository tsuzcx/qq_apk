package com.android.dx.dex.code.form;

import com.android.dx.dex.code.CstInsn;
import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.AnnotatedOutput;
import java.util.BitSet;

public final class Form22c
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form22c();
  
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
    return localRegisterSpecList.get(0).regString() + ", " + localRegisterSpecList.get(1).regString() + ", " + cstString(paramDalvInsn);
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
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    if ((!(paramDalvInsn instanceof CstInsn)) || (localRegisterSpecList.size() != 2) || (!unsignedFitsInNibble(localRegisterSpecList.get(0).getReg())) || (!unsignedFitsInNibble(localRegisterSpecList.get(1).getReg()))) {}
    do
    {
      do
      {
        return false;
        paramDalvInsn = (CstInsn)paramDalvInsn;
      } while (!unsignedFitsInShort(paramDalvInsn.getIndex()));
      paramDalvInsn = paramDalvInsn.getConstant();
    } while ((!(paramDalvInsn instanceof CstType)) && (!(paramDalvInsn instanceof CstFieldRef)));
    return true;
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    int i = ((CstInsn)paramDalvInsn).getIndex();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, makeByte(localRegisterSpecList.get(0).getReg(), localRegisterSpecList.get(1).getReg())), (short)i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form22c
 * JD-Core Version:    0.7.0.1
 */