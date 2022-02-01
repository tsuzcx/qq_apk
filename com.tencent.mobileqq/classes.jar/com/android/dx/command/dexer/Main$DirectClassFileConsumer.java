package com.android.dx.command.dexer;

import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.FieldList;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.dex.file.ClassDefsSection;
import com.android.dx.dex.file.DexFile;
import com.android.dx.dex.file.FieldIdsSection;
import com.android.dx.dex.file.MethodIdsSection;
import com.android.dx.rop.cst.ConstantPool;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class Main$DirectClassFileConsumer
  implements Callable<Boolean>
{
  byte[] bytes;
  Future<DirectClassFile> dcff;
  String name;
  
  private Main$DirectClassFileConsumer(String paramString, byte[] paramArrayOfByte, Future<DirectClassFile> paramFuture)
  {
    this.name = paramString;
    this.bytes = paramArrayOfByte;
    this.dcff = paramFuture;
  }
  
  private Boolean call(DirectClassFile paramDirectClassFile)
  {
    int j = 0;
    int i;
    int k;
    int m;
    if (Main.access$1300().multiDex)
    {
      i = paramDirectClassFile.getConstantPool().size();
      k = paramDirectClassFile.getMethods().size() + i + 2;
      m = i + paramDirectClassFile.getFields().size() + 9;
      synchronized (Main.access$1600())
      {
        synchronized (Main.access$1700())
        {
          j = Main.access$1700().getMethodIds().items().size();
          i = Main.access$1700().getFieldIds().items().size();
          if ((j + k + Main.access$1800() > Main.Arguments.access$1900(Main.access$1300())) || (i + m + Main.access$2000() > Main.Arguments.access$1900(Main.access$1300()))) {
            if (Main.access$1800() <= 0)
            {
              i = Main.access$2000();
              if (i <= 0) {
                break label217;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          Main.access$1600().wait();
          synchronized (Main.access$1700())
          {
            j = Main.access$1700().getMethodIds().items().size();
            i = Main.access$1700().getFieldIds().items().size();
          }
        }
        paramDirectClassFile = finally;
        throw paramDirectClassFile;
        paramDirectClassFile = finally;
        throw paramDirectClassFile;
        label217:
        if (Main.access$1700().getClassDefs().items().size() > 0)
        {
          Main.access$2100();
          continue;
        }
        Main.access$1802(Main.access$1800() + k);
        Main.access$2002(Main.access$2000() + m);
        j = m;
        i = k;
        paramDirectClassFile = Main.access$2300().submit(new Main.ClassTranslatorTask(this.name, this.bytes, paramDirectClassFile, null));
        paramDirectClassFile = Main.access$2500().submit(new Main.ClassDefItemConsumer(this.name, paramDirectClassFile, i, j, null));
        Main.access$2600().add(paramDirectClassFile);
        return Boolean.valueOf(true);
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
      }
      i = 0;
    }
  }
  
  public Boolean call()
  {
    return call((DirectClassFile)this.dcff.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.DirectClassFileConsumer
 * JD-Core Version:    0.7.0.1
 */