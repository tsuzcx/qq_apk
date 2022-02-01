package com.tencent.luggage.wxa.gn;

import android.text.TextUtils;
import com.tencent.luggage.wxa.go.d;
import com.tencent.luggage.wxa.go.e;
import com.tencent.luggage.wxa.gq.k;
import com.tencent.luggage.wxa.gw.b;
import com.tencent.luggage.wxa.gw.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  private static a a;
  private ArrayList<String> b = new ArrayList();
  private Object c = new Object();
  private final String d = "audio_cache_path_file.txt";
  private String e = "";
  private String f;
  
  public static a a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a;
  }
  
  private File d()
  {
    File localFile = new File(this.f);
    if (!localFile.exists()) {
      try
      {
        localFile.createNewFile();
        return localFile;
      }
      catch (IOException localIOException)
      {
        b.a("MicroMsg.Mix.AudioCachePathMgr", localIOException, "getCacheFile", new Object[0]);
      }
    }
    return localFile;
  }
  
  private void e()
  {
    try
    {
      if (this.b.isEmpty())
      {
        b.b("MicroMsg.Mix.AudioCachePathMgr", "data is empty");
        return;
      }
      try
      {
        new File(this.f).delete();
        BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(d()));
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBufferedWriter.newLine();
          localBufferedWriter.write(str);
        }
        b.b("MicroMsg.Mix.AudioCachePathMgr", "line count:%s", new Object[] { Integer.valueOf(this.b.size()) });
        localBufferedWriter.flush();
        localBufferedWriter.close();
      }
      catch (IOException localIOException)
      {
        b.a("MicroMsg.Mix.AudioCachePathMgr", localIOException, "asyncRead", new Object[0]);
      }
      b.b("MicroMsg.Mix.AudioCachePathMgr", "save end");
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/luggage/wxa/gn/a:b	Ljava/util/ArrayList;
    //   6: invokevirtual 143	java/util/ArrayList:clear	()V
    //   9: new 145	java/io/BufferedReader
    //   12: dup
    //   13: new 147	java/io/FileReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 88	com/tencent/luggage/wxa/gn/a:d	()Ljava/io/File;
    //   21: invokespecial 148	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   24: invokespecial 151	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 155	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +22 -> 56
    //   37: aload_2
    //   38: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne -13 -> 28
    //   44: aload_0
    //   45: getfield 24	com/tencent/luggage/wxa/gn/a:b	Ljava/util/ArrayList;
    //   48: aload_2
    //   49: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   52: pop
    //   53: goto -25 -> 28
    //   56: ldc 64
    //   58: ldc 117
    //   60: iconst_1
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_0
    //   67: getfield 24	com/tencent/luggage/wxa/gn/a:b	Ljava/util/ArrayList;
    //   70: invokevirtual 121	java/util/ArrayList:size	()I
    //   73: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: invokestatic 130	com/tencent/luggage/wxa/gw/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_1
    //   81: invokevirtual 165	java/io/BufferedReader:close	()V
    //   84: goto +20 -> 104
    //   87: astore_1
    //   88: goto +19 -> 107
    //   91: astore_1
    //   92: ldc 64
    //   94: aload_1
    //   95: ldc 138
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 71	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: aload_0
    //   108: monitorexit
    //   109: goto +5 -> 114
    //   112: aload_1
    //   113: athrow
    //   114: goto -2 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	a
    //   27	54	1	localBufferedReader	java.io.BufferedReader
    //   87	1	1	localObject	Object
    //   91	22	1	localIOException	IOException
    //   32	17	2	str	String
    // Exception table:
    //   from	to	target	type
    //   2	28	87	finally
    //   28	33	87	finally
    //   37	53	87	finally
    //   56	84	87	finally
    //   92	104	87	finally
    //   2	28	91	java/io/IOException
    //   28	33	91	java/io/IOException
    //   37	53	91	java/io/IOException
    //   56	84	91	java/io/IOException
  }
  
  protected void a(e parame, String paramString)
  {
    parame = new d(parame, paramString, 5);
    k.a();
    k.a(parame);
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(this.e)) && (!paramString.equals(this.e)))
    {
      b.b("MicroMsg.Mix.AudioCachePathMgr", "init");
      String str = this.e;
      this.e = paramString;
      paramString = new a.1(this, str, paramString);
    }
    else if (TextUtils.isEmpty(this.e))
    {
      this.e = paramString;
      b.b("MicroMsg.Mix.AudioCachePathMgr", "init");
      paramString = new a.2(this, paramString);
    }
    else
    {
      paramString = null;
    }
    if (paramString != null) {
      a(paramString, "init cache path");
    }
  }
  
  public void b()
  {
    b.b("MicroMsg.Mix.AudioCachePathMgr", "saveData");
    a(new a.3(this), "saveData");
  }
  
  public boolean b(String paramString)
  {
    try
    {
      b.b("MicroMsg.Mix.AudioCachePathMgr", "append path:%s", new Object[] { paramString });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString.hashCode());
      paramString = c.a(localStringBuilder.toString());
      if (!this.b.contains(paramString)) {
        this.b.add(paramString);
      }
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c()
  {
    b.b("MicroMsg.Mix.AudioCachePathMgr", "readData");
    a(new a.4(this), "readData");
  }
  
  public boolean c(String paramString)
  {
    try
    {
      b.b("MicroMsg.Mix.AudioCachePathMgr", "delete path:%s", new Object[] { paramString });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString.hashCode());
      paramString = c.a(localStringBuilder.toString());
      if (!this.b.contains(paramString)) {
        this.b.remove(paramString);
      }
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean d(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString.hashCode());
      paramString = c.a(localStringBuilder.toString());
      boolean bool = this.b.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gn.a
 * JD-Core Version:    0.7.0.1
 */