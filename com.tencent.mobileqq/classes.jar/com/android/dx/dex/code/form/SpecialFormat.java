package com.android.dx.dex.code.form;

import com.android.dx.dex.code.DalvInsn;
import com.android.dx.dex.code.InsnFormat;
import com.android.dx.util.AnnotatedOutput;

public final class SpecialFormat
  extends InsnFormat
{
  public static final InsnFormat THE_ONE = new SpecialFormat();
  
  public int codeSize()
  {
    throw new RuntimeException("unsupported");
  }
  
  public String insnArgString(DalvInsn paramDalvInsn)
  {
    throw new RuntimeException("unsupported");
  }
  
  public String insnCommentString(DalvInsn paramDalvInsn, boolean paramBoolean)
  {
    throw new RuntimeException("unsupported");
  }
  
  public boolean isCompatible(DalvInsn paramDalvInsn)
  {
    return true;
  }
  
  public void writeTo(AnnotatedOutput paramAnnotatedOutput, DalvInsn paramDalvInsn)
  {
    throw new RuntimeException("unsupported");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.code.form.SpecialFormat
 * JD-Core Version:    0.7.0.1
 */