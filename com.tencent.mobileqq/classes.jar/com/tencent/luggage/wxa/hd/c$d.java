package com.tencent.luggage.wxa.hd;

import android.content.Context;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

class c$d
  extends c.a
{
  private static final Set<String> a = new HashSet();
  private final String b;
  private final int c;
  private final File d;
  private final c.e e;
  private final boolean f;
  
  c$d(String paramString, int paramInt)
  {
    super(null);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (paramInt > 0)
      {
        StringBuilder localStringBuilder;
        if (!a.contains(paramString))
        {
          a.add(paramString);
          this.b = UUID.nameUUIDFromBytes(paramString.getBytes(Charset.forName("UTF-8"))).toString();
          this.c = paramInt;
          this.e = new c.e(paramString);
          try
          {
            this.e.b();
            paramString = r.a().getFilesDir().getParentFile();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(".auth_cache/");
            localStringBuilder.append(this.b);
            this.d = new File(paramString, localStringBuilder.toString());
            if (this.d.exists())
            {
              this.f = false;
            }
            else
            {
              this.f = true;
              if (!this.d.mkdirs()) {
                o.b("MicroMsg.DeviceInfo", "[-] Fail to make base dir: %s", new Object[] { this.d.getAbsolutePath() });
              }
            }
            localStringBuilder = new StringBuilder();
          }
          finally
          {
            try
            {
              this.e.c();
              return;
            }
            finally {}
            paramString = finally;
            this.e.c();
          }
        }
        localStringBuilder.append("name: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" is duplicated.");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      throw new IllegalArgumentException("cacheFileCount is less or equal than zero.");
    }
    throw new IllegalArgumentException("id is null or empty.");
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: new 152	java/io/BufferedReader
    //   3: dup
    //   4: new 154	java/io/FileReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 157	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   12: invokespecial 160	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_1
    //   18: aload_3
    //   19: invokevirtual 163	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   22: astore 5
    //   24: aload_3
    //   25: astore_1
    //   26: aload 5
    //   28: bipush 44
    //   30: invokevirtual 167	java/lang/String:lastIndexOf	(I)I
    //   33: istore_2
    //   34: iload_2
    //   35: ifge +18 -> 53
    //   38: aload_3
    //   39: astore_1
    //   40: ldc 122
    //   42: ldc 169
    //   44: invokestatic 172	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_3
    //   48: invokestatic 177	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   51: aconst_null
    //   52: areturn
    //   53: aload_3
    //   54: astore_1
    //   55: aload 5
    //   57: iconst_0
    //   58: iload_2
    //   59: invokevirtual 181	java/lang/String:substring	(II)Ljava/lang/String;
    //   62: astore 4
    //   64: aload_3
    //   65: astore_1
    //   66: aload 5
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: invokevirtual 184	java/lang/String:substring	(I)Ljava/lang/String;
    //   74: astore 5
    //   76: aload_3
    //   77: astore_1
    //   78: new 186	java/util/zip/CRC32
    //   81: dup
    //   82: invokespecial 187	java/util/zip/CRC32:<init>	()V
    //   85: astore 6
    //   87: aload_3
    //   88: astore_1
    //   89: aload 6
    //   91: aload 4
    //   93: ldc 48
    //   95: invokestatic 54	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   98: invokevirtual 58	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   101: invokevirtual 191	java/util/zip/CRC32:update	([B)V
    //   104: aload_3
    //   105: astore_1
    //   106: aload 6
    //   108: invokevirtual 195	java/util/zip/CRC32:getValue	()J
    //   111: aload 5
    //   113: invokestatic 201	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   116: lcmp
    //   117: ifeq +18 -> 135
    //   120: aload_3
    //   121: astore_1
    //   122: ldc 122
    //   124: ldc 203
    //   126: invokestatic 172	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_3
    //   130: invokestatic 177	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   133: aconst_null
    //   134: areturn
    //   135: aload_3
    //   136: invokestatic 177	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   139: aload 4
    //   141: areturn
    //   142: astore 4
    //   144: goto +13 -> 157
    //   147: astore_3
    //   148: aconst_null
    //   149: astore_1
    //   150: goto +29 -> 179
    //   153: astore 4
    //   155: aconst_null
    //   156: astore_3
    //   157: aload_3
    //   158: astore_1
    //   159: ldc 122
    //   161: aload 4
    //   163: ldc 205
    //   165: iconst_0
    //   166: anewarray 126	java/lang/Object
    //   169: invokestatic 208	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_3
    //   173: invokestatic 177	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_3
    //   179: aload_1
    //   180: invokestatic 177	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   183: aload_3
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	d
    //   0	185	1	paramFile	File
    //   33	38	2	i	int
    //   15	121	3	localBufferedReader	java.io.BufferedReader
    //   147	1	3	localObject1	Object
    //   156	17	3	localCloseable	java.io.Closeable
    //   178	6	3	localObject2	Object
    //   62	78	4	str1	String
    //   142	1	4	localThrowable1	java.lang.Throwable
    //   153	9	4	localThrowable2	java.lang.Throwable
    //   22	90	5	str2	String
    //   85	22	6	localCRC32	java.util.zip.CRC32
    // Exception table:
    //   from	to	target	type
    //   18	24	142	java/lang/Throwable
    //   26	34	142	java/lang/Throwable
    //   40	47	142	java/lang/Throwable
    //   55	64	142	java/lang/Throwable
    //   66	76	142	java/lang/Throwable
    //   78	87	142	java/lang/Throwable
    //   89	104	142	java/lang/Throwable
    //   106	120	142	java/lang/Throwable
    //   122	129	142	java/lang/Throwable
    //   0	16	147	finally
    //   0	16	153	java/lang/Throwable
    //   18	24	178	finally
    //   26	34	178	finally
    //   40	47	178	finally
    //   55	64	178	finally
    //   66	76	178	finally
    //   78	87	178	finally
    //   89	104	178	finally
    //   106	120	178	finally
    //   122	129	178	finally
    //   159	172	178	finally
  }
  
  /* Error */
  private boolean a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_2
    //   7: ifnonnull +36 -> 43
    //   10: aload 4
    //   12: astore_3
    //   13: aload_1
    //   14: invokevirtual 115	java/io/File:exists	()Z
    //   17: ifeq +20 -> 37
    //   20: aload 4
    //   22: astore_3
    //   23: new 211	java/io/PrintWriter
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 212	java/io/PrintWriter:<init>	(Ljava/io/File;)V
    //   31: invokevirtual 215	java/io/PrintWriter:close	()V
    //   34: goto +9 -> 43
    //   37: aconst_null
    //   38: invokestatic 177	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   41: iconst_1
    //   42: ireturn
    //   43: aload 4
    //   45: astore_3
    //   46: new 211	java/io/PrintWriter
    //   49: dup
    //   50: new 217	java/io/FileWriter
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 218	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   58: invokespecial 221	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   61: astore 4
    //   63: new 186	java/util/zip/CRC32
    //   66: dup
    //   67: invokespecial 187	java/util/zip/CRC32:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: aload_2
    //   73: ldc 48
    //   75: invokestatic 54	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   78: invokevirtual 58	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   81: invokevirtual 191	java/util/zip/CRC32:update	([B)V
    //   84: new 99	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   91: astore 5
    //   93: aload 5
    //   95: aload_2
    //   96: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 5
    //   102: ldc 223
    //   104: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 5
    //   110: aload_3
    //   111: invokevirtual 195	java/util/zip/CRC32:getValue	()J
    //   114: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 4
    //   120: aload 5
    //   122: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokevirtual 229	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   128: aload 4
    //   130: invokestatic 177	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   133: iconst_1
    //   134: ireturn
    //   135: astore_1
    //   136: goto +53 -> 189
    //   139: astore_3
    //   140: aload 4
    //   142: astore_2
    //   143: aload_3
    //   144: astore 4
    //   146: goto +15 -> 161
    //   149: astore_1
    //   150: aload_3
    //   151: astore 4
    //   153: goto +36 -> 189
    //   156: astore 4
    //   158: aload 5
    //   160: astore_2
    //   161: aload_2
    //   162: astore_3
    //   163: ldc 122
    //   165: aload 4
    //   167: ldc 231
    //   169: iconst_1
    //   170: anewarray 126	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_1
    //   176: invokevirtual 129	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   179: aastore
    //   180: invokestatic 208	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_2
    //   184: invokestatic 177	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   187: iconst_0
    //   188: ireturn
    //   189: aload 4
    //   191: invokestatic 177	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   194: aload_1
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	d
    //   0	196	1	paramFile	File
    //   0	196	2	paramString	String
    //   12	99	3	localObject1	Object
    //   139	12	3	localThrowable1	java.lang.Throwable
    //   162	1	3	str	String
    //   4	148	4	localObject2	Object
    //   156	34	4	localThrowable2	java.lang.Throwable
    //   1	158	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   63	128	135	finally
    //   63	128	139	java/lang/Throwable
    //   13	20	149	finally
    //   23	34	149	finally
    //   46	63	149	finally
    //   163	183	149	finally
    //   13	20	156	java/lang/Throwable
    //   23	34	156	java/lang/Throwable
    //   46	63	156	java/lang/Throwable
  }
  
  void a() {}
  
  void a(boolean paramBoolean) {}
  
  protected boolean b()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public String c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/tencent/luggage/wxa/hd/c$d:e	Lcom/tencent/luggage/wxa/hd/c$e;
    //   6: invokevirtual 81	com/tencent/luggage/wxa/hd/c$e:b	()V
    //   9: aload_0
    //   10: getfield 112	com/tencent/luggage/wxa/hd/c$d:d	Ljava/io/File;
    //   13: invokevirtual 115	java/io/File:exists	()Z
    //   16: ifne +21 -> 37
    //   19: ldc 122
    //   21: ldc 234
    //   23: invokestatic 172	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 79	com/tencent/luggage/wxa/hd/c$d:e	Lcom/tencent/luggage/wxa/hd/c$e;
    //   30: invokevirtual 136	com/tencent/luggage/wxa/hd/c$e:c	()V
    //   33: aload_0
    //   34: monitorexit
    //   35: aconst_null
    //   36: areturn
    //   37: aload_0
    //   38: getfield 72	com/tencent/luggage/wxa/hd/c$d:c	I
    //   41: istore_3
    //   42: iconst_0
    //   43: istore_1
    //   44: iconst_0
    //   45: istore_2
    //   46: iload_1
    //   47: aload_0
    //   48: getfield 72	com/tencent/luggage/wxa/hd/c$d:c	I
    //   51: if_icmpge +71 -> 122
    //   54: new 94	java/io/File
    //   57: dup
    //   58: aload_0
    //   59: getfield 112	com/tencent/luggage/wxa/hd/c$d:d	Ljava/io/File;
    //   62: iload_1
    //   63: invokestatic 237	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   66: invokespecial 110	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   69: astore 5
    //   71: aload 5
    //   73: invokevirtual 115	java/io/File:exists	()Z
    //   76: ifne +10 -> 86
    //   79: iload_3
    //   80: iconst_1
    //   81: isub
    //   82: istore_3
    //   83: goto +32 -> 115
    //   86: aload_0
    //   87: aload 5
    //   89: invokespecial 239	com/tencent/luggage/wxa/hd/c$d:a	(Ljava/io/File;)Ljava/lang/String;
    //   92: astore 5
    //   94: aload 5
    //   96: ifnull +15 -> 111
    //   99: aload_0
    //   100: getfield 79	com/tencent/luggage/wxa/hd/c$d:e	Lcom/tencent/luggage/wxa/hd/c$e;
    //   103: invokevirtual 136	com/tencent/luggage/wxa/hd/c$e:c	()V
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 5
    //   110: areturn
    //   111: iload_2
    //   112: iconst_1
    //   113: iadd
    //   114: istore_2
    //   115: iload_1
    //   116: iconst_1
    //   117: iadd
    //   118: istore_1
    //   119: goto -73 -> 46
    //   122: iload_2
    //   123: ifle +23 -> 146
    //   126: iload_2
    //   127: iload_3
    //   128: if_icmpne +9 -> 137
    //   131: iconst_1
    //   132: istore 4
    //   134: goto +6 -> 140
    //   137: iconst_0
    //   138: istore 4
    //   140: aload_0
    //   141: iload 4
    //   143: invokevirtual 241	com/tencent/luggage/wxa/hd/c$d:a	(Z)V
    //   146: ldc 122
    //   148: ldc 243
    //   150: invokestatic 245	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_0
    //   154: getfield 79	com/tencent/luggage/wxa/hd/c$d:e	Lcom/tencent/luggage/wxa/hd/c$e;
    //   157: invokevirtual 136	com/tencent/luggage/wxa/hd/c$e:c	()V
    //   160: aload_0
    //   161: monitorexit
    //   162: aconst_null
    //   163: areturn
    //   164: astore 5
    //   166: goto +29 -> 195
    //   169: astore 5
    //   171: ldc 122
    //   173: aload 5
    //   175: ldc 247
    //   177: iconst_0
    //   178: anewarray 126	java/lang/Object
    //   181: invokestatic 208	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_0
    //   185: getfield 79	com/tencent/luggage/wxa/hd/c$d:e	Lcom/tencent/luggage/wxa/hd/c$e;
    //   188: invokevirtual 136	com/tencent/luggage/wxa/hd/c$e:c	()V
    //   191: aload_0
    //   192: monitorexit
    //   193: aconst_null
    //   194: areturn
    //   195: aload_0
    //   196: getfield 79	com/tencent/luggage/wxa/hd/c$d:e	Lcom/tencent/luggage/wxa/hd/c$e;
    //   199: invokevirtual 136	com/tencent/luggage/wxa/hd/c$e:c	()V
    //   202: aload 5
    //   204: athrow
    //   205: astore 5
    //   207: aload_0
    //   208: monitorexit
    //   209: goto +6 -> 215
    //   212: aload 5
    //   214: athrow
    //   215: goto -3 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	d
    //   43	76	1	i	int
    //   45	84	2	j	int
    //   41	88	3	k	int
    //   132	10	4	bool	boolean
    //   69	40	5	localObject1	Object
    //   164	1	5	localObject2	Object
    //   169	34	5	localThrowable	java.lang.Throwable
    //   205	8	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	164	finally
    //   37	42	164	finally
    //   46	79	164	finally
    //   86	94	164	finally
    //   140	146	164	finally
    //   146	153	164	finally
    //   171	184	164	finally
    //   2	26	169	java/lang/Throwable
    //   37	42	169	java/lang/Throwable
    //   46	79	169	java/lang/Throwable
    //   86	94	169	java/lang/Throwable
    //   140	146	169	java/lang/Throwable
    //   146	153	169	java/lang/Throwable
    //   26	33	205	finally
    //   99	106	205	finally
    //   153	160	205	finally
    //   184	191	205	finally
    //   195	205	205	finally
  }
  
  public void c(String paramString)
  {
    try
    {
      this.e.b();
      if (!this.d.exists())
      {
        o.b("MicroMsg.DeviceInfo", "[-] Base dir does not exist, skip rest logic.");
        a();
      }
    }
    finally
    {
      label44:
      File localFile;
      this.e.c();
    }
    try
    {
      this.e.c();
      return;
    }
    finally
    {
      for (;;)
      {
        throw paramString;
      }
      i += 1;
      j = k;
      break label44;
    }
    i = 0;
    j = 0;
    if (i < this.c)
    {
      localFile = new File(this.d, String.valueOf(i));
      if (localFile.isDirectory())
      {
        o.c("MicroMsg.DeviceInfo", "[!] Cache file %s is occupied by a directory, try to delete it first.");
        localFile.delete();
      }
      k = j;
      if (!a(localFile, paramString)) {
        k = j + 1;
      }
    }
    else
    {
      if (j == this.c) {
        a();
      }
      this.e.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.d
 * JD-Core Version:    0.7.0.1
 */