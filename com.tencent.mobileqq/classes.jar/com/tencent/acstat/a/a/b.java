package com.tencent.acstat.a.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class b
  extends g
{
  b(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  protected void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 15
    //   4: invokestatic 19	com/tencent/acstat/a/a/i:a	(Ljava/lang/String;)V
    //   7: new 21	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   14: invokestatic 30	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   17: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: ldc 36
    //   22: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokestatic 43	com/tencent/acstat/a/a/b:c	()Ljava/lang/String;
    //   28: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 51	com/tencent/acstat/a/a/a:a	(Ljava/lang/String;)Ljava/io/File;
    //   37: pop
    //   38: new 53	java/io/File
    //   41: dup
    //   42: invokestatic 30	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   45: invokestatic 56	com/tencent/acstat/a/a/b:d	()Ljava/lang/String;
    //   48: invokespecial 59	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore_2
    //   52: new 61	java/io/BufferedWriter
    //   55: dup
    //   56: new 63	java/io/FileWriter
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 66	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   64: invokespecial 69	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   67: astore_2
    //   68: aload_2
    //   69: new 21	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   76: aload_0
    //   77: invokevirtual 72	com/tencent/acstat/a/a/b:f	()Ljava/lang/String;
    //   80: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 74
    //   85: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokevirtual 77	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   98: aload_2
    //   99: ldc 79
    //   101: invokevirtual 77	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   104: aload_2
    //   105: invokevirtual 82	java/io/BufferedWriter:close	()V
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: astore_1
    //   112: aload_1
    //   113: invokestatic 85	com/tencent/acstat/a/a/i:a	(Ljava/lang/Throwable;)V
    //   116: goto -8 -> 108
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	b
    //   0	124	1	paramString	String
    //   51	54	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	108	111	java/io/IOException
    //   2	52	119	finally
    //   52	108	119	finally
    //   108	110	119	finally
    //   112	116	119	finally
    //   120	122	119	finally
  }
  
  protected boolean a()
  {
    return (i.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) && (Environment.getExternalStorageState().equals("mounted"));
  }
  
  protected String b()
  {
    for (;;)
    {
      try
      {
        i.a("read mid from InternalStorage");
        Object localObject1 = new File(Environment.getExternalStorageDirectory(), d());
        try
        {
          localObject1 = a.a((File)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label118;
          }
          String[] arrayOfString = ((String)((Iterator)localObject1).next()).split(",");
          if ((arrayOfString.length != 2) || (!arrayOfString[0].equals(f()))) {
            continue;
          }
          i.a("read mid from InternalStorage:" + arrayOfString[1]);
          localObject1 = arrayOfString[1];
        }
        catch (IOException localIOException)
        {
          i.a(localIOException);
          Object localObject2 = null;
          continue;
        }
        return localObject1;
      }
      finally {}
      label118:
      Object localObject4 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.acstat.a.a.b
 * JD-Core Version:    0.7.0.1
 */