package com.android.dx.dex.code.form;

import com.android.dx.dex.code.CstInsn;
import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.AnnotatedOutput;

public final class Form3rc
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form3rc();
  
  public int codeSize()
  {
    return 3;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    return regRangeString(paramDalvInsn.getRegisters()) + ", " + cstString(paramDalvInsn);
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
    if (!(paramDalvInsn instanceof CstInsn)) {}
    do
    {
      int i;
      Constant localConstant;
      do
      {
        return false;
        paramDalvInsn = (CstInsn)paramDalvInsn;
        i = paramDalvInsn.getIndex();
        localConstant = paramDalvInsn.getConstant();
      } while ((!unsignedFitsInShort(i)) || ((!(localConstant instanceof CstMethodRef)) && (!(localConstant instanceof CstType))));
      paramDalvInsn = paramDalvInsn.getRegisters();
      paramDalvInsn.size();
    } while ((paramDalvInsn.size() != 0) && ((!isRegListSequential(paramDalvInsn)) || (!unsignedFitsInShort(paramDalvInsn.get(0).getReg())) || (!unsignedFitsInByte(paramDalvInsn.getWordCount()))));
    return true;
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    RegisterSpecList localRegisterSpecList = paramDalvInsn.getRegisters();
    int j = ((CstInsn)paramDalvInsn).getIndex();
    if (localRegisterSpecList.size() == 0) {}
    for (int i = 0;; i = localRegisterSpecList.get(0).getReg())
    {
      write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, localRegisterSpecList.getWordCount()), (short)j, (short)i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form3rc
 * JD-Core Version:    0.7.0.1
 */