package com.android.dx.command.dexer;

import com.android.dx.dex.file.DexFile;
import java.util.concurrent.Callable;

class Main$DexWriter
  implements Callable<byte[]>
{
  private DexFile dexFile;
  
  private Main$DexWriter(DexFile paramDexFile)
  {
    this.dexFile = paramDexFile;
  }
  
  public byte[] call()
  {
    return Main.access$3000(this.dexFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.DexWriter
 * JD-Core Version:    0.7.0.1
 */