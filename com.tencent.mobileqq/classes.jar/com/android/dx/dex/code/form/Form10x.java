package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.dex.code.SimpleInsn;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;

public final class Form10x
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form10x();
  
  public int codeSize()
  {
    return 1;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    return "";
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return "";
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    return ((paramDalvInsn instanceof SimpleInsn)) && (paramDalvInsn.getRegisters().size() == 0);
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form10x
 * JD-Core Version:    0.7.0.1
 */