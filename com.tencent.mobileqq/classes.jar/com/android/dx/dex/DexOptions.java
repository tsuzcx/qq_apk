package com.android.dx.dex;

import com.android.dex.DexFormat;

public class DexOptions
{
  public static final boolean ALIGN_64BIT_REGS_SUPPORT = true;
  public boolean ALIGN_64BIT_REGS_IN_OUTPUT_FINISHER = true;
  public boolean forceJumbo = false;
  public int targetApiLevel = 13;
  
  public String getMagic()
  {
    return DexFormat.apiToMagic(this.targetApiLevel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.DexOptions
 * JD-Core Version:    0.7.0.1
 */