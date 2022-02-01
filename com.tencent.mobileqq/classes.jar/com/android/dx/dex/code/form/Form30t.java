package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.dex.code.TargetInsn;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;

public final class Form30t
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form30t();
  
  public boolean branchFits(TargetInsn paramTargetInsn)
  {
    return true;
  }
  
  public int codeSize()
  {
    return 3;
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    return branchString(paramDalvInsn);
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    return branchComment(paramDalvInsn);
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    return ((paramDalvInsn instanceof TargetInsn)) && (paramDalvInsn.getRegisters().size() == 0);
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    int i = ((TargetInsn)paramDalvInsn).getTargetOffset();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, 0), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form30t
 * JD-Core Version:    0.7.0.1
 */