package com.android.dx.command.dexer;

import com.android.dx.cf.direct.DirectClassFile;
import java.util.concurrent.Callable;

class Main$ClassParserTask
  implements Callable<DirectClassFile>
{
  byte[] bytes;
  String name;
  
  private Main$ClassParserTask(String paramString, byte[] paramArrayOfByte)
  {
    this.name = paramString;
    this.bytes = paramArrayOfByte;
  }
  
  public DirectClassFile call()
  {
    return Main.access$1500(this.name, this.bytes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.ClassParserTask
 * JD-Core Version:    0.7.0.1
 */