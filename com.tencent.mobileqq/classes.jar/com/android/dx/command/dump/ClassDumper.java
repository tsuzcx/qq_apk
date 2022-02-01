package com.android.dx.command.dump;

import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.util.ByteArray;
import java.io.PrintStream;

public final class ClassDumper
  extends BaseDumper
{
  private ClassDumper(byte[] paramArrayOfByte, PrintStream paramPrintStream, String paramString, Args paramArgs)
  {
    super(paramArrayOfByte, paramPrintStream, paramString, paramArgs);
  }
  
  public static void dump(byte[] paramArrayOfByte, PrintStream paramPrintStream, String paramString, Args paramArgs)
  {
    new ClassDumper(paramArrayOfByte, paramPrintStream, paramString, paramArgs).dump();
  }
  
  public void dump()
  {
    byte[] arrayOfByte = getBytes();
    ByteArray localByteArray = new ByteArray(arrayOfByte);
    DirectClassFile localDirectClassFile = new DirectClassFile(localByteArray, getFilePath(), getStrictParse());
    localDirectClassFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
    localDirectClassFile.setObserver(this);
    localDirectClassFile.getMagic();
    int i = getAt();
    if (i != arrayOfByte.length) {
      parsed(localByteArray, i, arrayOfByte.length - i, "<extra data at end of file>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dump.ClassDumper
 * JD-Core Version:    0.7.0.1
 */