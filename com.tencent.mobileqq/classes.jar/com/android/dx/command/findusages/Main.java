package com.android.dx.command.findusages;

import com.android.dex.Dex;
import java.io.File;
import java.io.PrintWriter;

public final class Main
{
  public static void main(String[] paramArrayOfString)
  {
    Object localObject = paramArrayOfString[0];
    String str = paramArrayOfString[1];
    paramArrayOfString = paramArrayOfString[2];
    localObject = new Dex(new File((String)localObject));
    PrintWriter localPrintWriter = new PrintWriter(System.out);
    new FindUsages((Dex)localObject, str, paramArrayOfString, localPrintWriter).findUsages();
    localPrintWriter.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.findusages.Main
 * JD-Core Version:    0.7.0.1
 */