package com.android.dx.command.dexer;

import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.dex.file.ClassDefItem;
import java.util.concurrent.Callable;

class Main$ClassTranslatorTask
  implements Callable<ClassDefItem>
{
  byte[] bytes;
  DirectClassFile classFile;
  String name;
  
  private Main$ClassTranslatorTask(String paramString, byte[] paramArrayOfByte, DirectClassFile paramDirectClassFile)
  {
    this.name = paramString;
    this.bytes = paramArrayOfByte;
    this.classFile = paramDirectClassFile;
  }
  
  public ClassDefItem call()
  {
    return Main.access$2700(this.bytes, this.classFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.ClassTranslatorTask
 * JD-Core Version:    0.7.0.1
 */