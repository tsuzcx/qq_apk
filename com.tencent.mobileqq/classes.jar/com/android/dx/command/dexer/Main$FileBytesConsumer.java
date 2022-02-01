package com.android.dx.command.dexer;

import com.android.dx.cf.code.SimException;
import com.android.dx.cf.direct.ClassPathOpener.Consumer;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.command.DxConsole;
import java.io.File;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;

class Main$FileBytesConsumer
  implements ClassPathOpener.Consumer
{
  public void onException(Exception paramException)
  {
    if ((paramException instanceof Main.StopProcessing)) {
      throw ((Main.StopProcessing)paramException);
    }
    if ((paramException instanceof SimException))
    {
      DxConsole.err.println("\nEXCEPTION FROM SIMULATION:");
      DxConsole.err.println(paramException.getMessage() + "\n");
      DxConsole.err.println(((SimException)paramException).getContext());
    }
    for (;;)
    {
      Main.access$1400().incrementAndGet();
      return;
      if ((paramException instanceof ParseException))
      {
        DxConsole.err.println("\nPARSE ERROR:");
        paramException = (ParseException)paramException;
        if (Main.access$1300().debug) {
          paramException.printStackTrace(DxConsole.err);
        } else {
          paramException.printContext(DxConsole.err);
        }
      }
      else
      {
        DxConsole.err.println("\nUNEXPECTED TOP-LEVEL EXCEPTION:");
        paramException.printStackTrace(DxConsole.err);
      }
    }
  }
  
  public void onProcessArchiveStart(File paramFile)
  {
    if (Main.access$1300().verbose) {
      DxConsole.out.println("processing archive " + paramFile + "...");
    }
  }
  
  public boolean processFileBytes(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    return Main.access$1200(paramString, paramLong, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.FileBytesConsumer
 * JD-Core Version:    0.7.0.1
 */