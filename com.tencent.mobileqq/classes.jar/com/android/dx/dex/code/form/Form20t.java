package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.dex.code.TargetInsn;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.util.AnnotatedOutput;

public final class Form20t
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new Form20t();
  
  public boolean branchFits(TargetInsn paramTargetInsn)
  {
    int i = paramTargetInsn.getTargetOffset();
    return (i != 0) && (signedFitsInShort(i));
  }
  
  public int codeSize()
  {
    return 2;
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
    if ((!(paramDalvInsn instanceof TargetInsn)) || (paramDalvInsn.getRegisters().size() != 0)) {
      return false;
    }
    paramDalvInsn = (TargetInsn)paramDalvInsn;
    if (paramDalvInsn.hasTargetOffset()) {
      return branchFits(paramDalvInsn);
    }
    return true;
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    int i = ((TargetInsn)paramDalvInsn).getTargetOffset();
    write(paramAnnotatedOutput, opcodeUnit(paramDalvInsn, 0), (short)i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.Form20t
 * JD-Core Version:    0.7.0.1
 */