package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ToHuman;
import java.io.PrintWriter;

public abstract class EncodedMember
  implements ToHuman
{
  private final int accessFlags;
  
  public EncodedMember(int paramInt)
  {
    this.accessFlags = paramInt;
  }
  
  public abstract void addContents(DexFile paramDexFile);
  
  public abstract void debugPrint(PrintWriter paramPrintWriter, boolean paramBoolean);
  
  public abstract int encode(DexFile paramDexFile, AnnotatedOutput paramAnnotatedOutput, int paramInt1, int paramInt2);
  
  public final int getAccessFlags()
  {
    return this.accessFlags;
  }
  
  public abstract CstString getName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.EncodedMember
 * JD-Core Version:    0.7.0.1
 */