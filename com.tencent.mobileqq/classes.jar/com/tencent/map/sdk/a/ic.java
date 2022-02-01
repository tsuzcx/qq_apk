package com.tencent.map.sdk.a;

import android.graphics.Rect;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class ic
  extends Thread
  implements id
{
  private long a;
  private lw b;
  private qe c;
  private boolean d;
  private boolean e;
  private boolean f;
  private List<Integer> g;
  
  public ic(lw paramlw, qe paramqe)
  {
    this.b = paramlw;
    this.c = paramqe;
    this.a = 0L;
    this.f = false;
    this.d = false;
    this.e = false;
  }
  
  private static long a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return paramArrayOfByte[3] << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
  }
  
  private File a(String paramString)
  {
    Object localObject = f();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        if (localObject.length == 0) {
          return null;
        }
        int i = 0;
        while (i < localObject.length)
        {
          String[] arrayOfString = localObject[i].getName().split("_|\\.");
          if ((arrayOfString.length > 1) && (paramString.equals(arrayOfString[0]))) {
            return localObject[i];
          }
          i += 1;
        }
      }
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".kml");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +226 -> 227
    //   4: aload_3
    //   5: arraylength
    //   6: bipush 10
    //   8: if_icmpge +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: invokespecial 47	com/tencent/map/sdk/a/ic:f	()Ljava/io/File;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnonnull +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: new 72	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   33: astore 5
    //   35: aload 5
    //   37: aload 4
    //   39: invokevirtual 92	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 5
    //   48: getstatic 96	java/io/File:separator	Ljava/lang/String;
    //   51: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 5
    //   57: iload_1
    //   58: invokestatic 101	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   61: iload_2
    //   62: invokestatic 101	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   65: invokestatic 103	com/tencent/map/sdk/a/ic:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: new 49	java/io/File
    //   75: dup
    //   76: aload 5
    //   78: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore 8
    //   86: aload 8
    //   88: invokevirtual 110	java/io/File:exists	()Z
    //   91: ifeq +16 -> 107
    //   94: aload 8
    //   96: invokevirtual 113	java/io/File:delete	()Z
    //   99: ifne +8 -> 107
    //   102: aload 8
    //   104: invokevirtual 116	java/io/File:deleteOnExit	()V
    //   107: aload 8
    //   109: invokevirtual 119	java/io/File:createNewFile	()Z
    //   112: pop
    //   113: aconst_null
    //   114: astore 4
    //   116: aconst_null
    //   117: astore 6
    //   119: aconst_null
    //   120: astore 7
    //   122: aconst_null
    //   123: astore 5
    //   125: aload_3
    //   126: aload_3
    //   127: arraylength
    //   128: bipush 10
    //   130: isub
    //   131: invokestatic 124	com/tencent/map/sdk/a/oo:a	([BI)[B
    //   134: astore 9
    //   136: aload 9
    //   138: ifnonnull +5 -> 143
    //   141: iconst_0
    //   142: ireturn
    //   143: new 126	java/io/FileOutputStream
    //   146: dup
    //   147: aload 8
    //   149: invokespecial 129	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   152: astore_3
    //   153: aload_3
    //   154: aload 9
    //   156: invokevirtual 133	java/io/FileOutputStream:write	([B)V
    //   159: aload_3
    //   160: invokevirtual 136	java/io/FileOutputStream:flush	()V
    //   163: aload_3
    //   164: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   167: iconst_1
    //   168: ireturn
    //   169: astore 4
    //   171: goto +17 -> 188
    //   174: goto +25 -> 199
    //   177: goto +32 -> 209
    //   180: goto +39 -> 219
    //   183: astore 4
    //   185: aload 5
    //   187: astore_3
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   196: aload 4
    //   198: athrow
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   207: iconst_0
    //   208: ireturn
    //   209: aload_3
    //   210: ifnull +7 -> 217
    //   213: aload_3
    //   214: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   217: iconst_0
    //   218: ireturn
    //   219: aload_3
    //   220: ifnull +7 -> 227
    //   223: aload_3
    //   224: invokevirtual 139	java/io/FileOutputStream:close	()V
    //   227: iconst_0
    //   228: ireturn
    //   229: astore_3
    //   230: iconst_0
    //   231: ireturn
    //   232: astore_3
    //   233: aload 7
    //   235: astore_3
    //   236: goto -17 -> 219
    //   239: astore_3
    //   240: aload 6
    //   242: astore_3
    //   243: goto -34 -> 209
    //   246: astore_3
    //   247: aload 4
    //   249: astore_3
    //   250: goto -51 -> 199
    //   253: astore 4
    //   255: goto -75 -> 180
    //   258: astore 4
    //   260: goto -83 -> 177
    //   263: astore 4
    //   265: goto -91 -> 174
    //   268: astore_3
    //   269: goto -102 -> 167
    //   272: astore_3
    //   273: goto -77 -> 196
    //   276: astore_3
    //   277: iconst_0
    //   278: ireturn
    //   279: astore_3
    //   280: iconst_0
    //   281: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	ic
    //   0	282	1	paramInt1	int
    //   0	282	2	paramInt2	int
    //   0	282	3	paramArrayOfByte	byte[]
    //   17	98	4	localFile1	File
    //   169	1	4	localObject1	Object
    //   183	65	4	localObject2	Object
    //   253	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   258	1	4	localIOException	java.io.IOException
    //   263	1	4	localException	Exception
    //   33	153	5	localStringBuilder	StringBuilder
    //   117	124	6	localObject3	Object
    //   120	114	7	localObject4	Object
    //   84	64	8	localFile2	File
    //   134	21	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   153	163	169	finally
    //   125	136	183	finally
    //   143	153	183	finally
    //   107	113	229	java/io/IOException
    //   223	227	229	java/io/IOException
    //   125	136	232	java/io/FileNotFoundException
    //   143	153	232	java/io/FileNotFoundException
    //   125	136	239	java/io/IOException
    //   143	153	239	java/io/IOException
    //   125	136	246	java/lang/Exception
    //   143	153	246	java/lang/Exception
    //   153	163	253	java/io/FileNotFoundException
    //   153	163	258	java/io/IOException
    //   153	163	263	java/lang/Exception
    //   163	167	268	java/io/IOException
    //   192	196	272	java/io/IOException
    //   203	207	276	java/io/IOException
    //   213	217	279	java/io/IOException
  }
  
  private boolean a(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      if (this.g == null) {
        return true;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (!this.g.contains(paramList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private File f()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((lw)localObject).o == null) {
        return null;
      }
      localObject = this.b.o.e();
      if (localObject == null) {
        return null;
      }
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {}
    }
    try
    {
      ((File)localObject).mkdirs();
      return localObject;
    }
    catch (Exception localException) {}
    return localObject;
    return null;
    return null;
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload 4
    //   14: getfield 174	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 179	com/tencent/map/sdk/a/pf:y	()V
    //   24: aload 4
    //   26: getfield 181	com/tencent/map/sdk/a/pf:b	J
    //   29: lstore_2
    //   30: aload 4
    //   32: invokevirtual 184	com/tencent/map/sdk/a/pf:z	()V
    //   35: aload_0
    //   36: iload_1
    //   37: putfield 34	com/tencent/map/sdk/a/ic:d	Z
    //   40: iload_1
    //   41: ifeq +7 -> 48
    //   44: aload_0
    //   45: invokevirtual 187	com/tencent/map/sdk/a/ic:start	()V
    //   48: aload_0
    //   49: getfield 26	com/tencent/map/sdk/a/ic:b	Lcom/tencent/map/sdk/a/lw;
    //   52: invokevirtual 190	com/tencent/map/sdk/a/lw:k	()V
    //   55: return
    //   56: astore 5
    //   58: aload 4
    //   60: invokevirtual 184	com/tencent/map/sdk/a/pf:z	()V
    //   63: aload 5
    //   65: athrow
    //   66: astore 4
    //   68: goto -20 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	ic
    //   0	71	1	paramBoolean	boolean
    //   29	1	2	l	long
    //   4	55	4	localObject1	Object
    //   66	1	4	localException	Exception
    //   56	8	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	30	56	finally
    //   44	48	66	java/lang/Exception
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public final void b()
  {
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public final void c()
  {
    this.e = false;
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public final void d()
  {
    this.e = true;
    try
    {
      notifyAll();
      return;
    }
    finally {}
  }
  
  public final void e()
  {
    this.f = true;
    this.e = true;
    this.d = false;
    try
    {
      notifyAll();
      interrupt();
      return;
    }
    finally {}
  }
  
  public final void run()
  {
    super.run();
    for (;;)
    {
      if (this.f) {
        break label791;
      }
      Object localObject1;
      if ((!this.e) && (this.d))
      {
        localObject1 = this.b;
        if ((localObject1 != null) && (((lw)localObject1).c != null))
        {
          this.b.c.p();
          if (this.b.c.i.b.f >= 11)
          {
            localObject1 = this.b.c;
            Object localObject3 = this.b;
            Object localObject4 = ((kl)localObject1).p();
            int i = ((kl)localObject1).i.b.f;
            localObject4 = ((lw)localObject3).a.a((Rect)localObject4, i);
            if ((localObject4 != null) && (((List)localObject4).size() != 0) && (this.c != null))
            {
              ArrayList localArrayList = new ArrayList();
              boolean bool = a((List)localObject4);
              if ((bool) || (System.currentTimeMillis() - this.a >= 300000L))
              {
                this.g = ((List)localObject4);
                i = ((List)localObject4).size() - 1;
                for (int j = 0; i >= 0; j = k)
                {
                  int m = ((Integer)((List)localObject4).get(i)).intValue();
                  String str = Integer.toString(m);
                  Object localObject5 = a(str);
                  if (localObject5 != null)
                  {
                    localObject1 = ((File)localObject5).getName().split("_|\\.");
                    if ((localObject1.length > 1) && (str.equals(localObject1[0])))
                    {
                      localObject1 = localObject1[1];
                      break label290;
                    }
                  }
                  localObject1 = "0";
                  label290:
                  if ((localObject5 != null) && (System.currentTimeMillis() - ((File)localObject5).lastModified() < 300000L)) {}
                  try
                  {
                    k = Integer.parseInt((String)localObject1);
                  }
                  catch (Exception localException1)
                  {
                    int k;
                    label320:
                    qe localqe;
                    break label320;
                  }
                  k = 0;
                  localArrayList.add(new ia(m, k));
                  k = j;
                  break label719;
                  localqe = this.c;
                  localObject3 = this.b;
                  if ((localObject3 != null) && (((lw)localObject3).w != null))
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append(this.b.w);
                    ((StringBuilder)localObject3).append("&citycode=".concat(String.valueOf(str)));
                    ((StringBuilder)localObject3).append("&version=".concat(String.valueOf(localObject1)));
                    localObject3 = ((StringBuilder)localObject3).toString();
                  }
                  else
                  {
                    localObject3 = null;
                  }
                  localObject3 = localqe.a((String)localObject3);
                  k = j;
                  if (localObject3 != null)
                  {
                    k = j;
                    if ((localObject3.length >= 10) && (localObject3[4] != 0)) {}
                  }
                  try
                  {
                    k = Integer.parseInt((String)localObject1);
                  }
                  catch (Exception localException2)
                  {
                    label484:
                    int n;
                    break label484;
                  }
                  k = 0;
                  localArrayList.add(new ia(m, k));
                  k = j;
                  if (localObject5 != null)
                  {
                    ((File)localObject5).setLastModified(System.currentTimeMillis());
                    k = j;
                    break label719;
                    localObject5 = new byte[4];
                    System.arraycopy(localObject3, 0, localObject5, 0, 4);
                    k = (int)a((byte[])localObject5);
                    System.arraycopy(localObject3, 5, localObject5, 0, 4);
                    n = (int)a((byte[])localObject5);
                    if (a(k, n, (byte[])localObject3))
                    {
                      localObject3 = f();
                      if (localObject3 != null)
                      {
                        localObject5 = new StringBuilder();
                        ((StringBuilder)localObject5).append(((File)localObject3).getAbsolutePath());
                        ((StringBuilder)localObject5).append(File.separator);
                        ((StringBuilder)localObject5).append(a(str, (String)localObject1));
                        localObject1 = new File(((StringBuilder)localObject5).toString());
                        if ((((File)localObject1).exists()) && (!((File)localObject1).delete())) {
                          ((File)localObject1).deleteOnExit();
                        }
                      }
                      localArrayList.add(new ia(k, n));
                      k = 1;
                    }
                  }
                  try
                  {
                    k = Integer.parseInt((String)localObject1);
                  }
                  catch (Exception localException3)
                  {
                    label697:
                    break label697;
                  }
                  k = 0;
                  localArrayList.add(new ia(m, k));
                  k = j;
                  label719:
                  i -= 1;
                }
                if ((bool) || (j != 0))
                {
                  this.b.a.a(localArrayList);
                  this.b.k();
                }
                this.a = System.currentTimeMillis();
              }
            }
          }
        }
      }
      try
      {
        wait(300000L);
      }
      catch (InterruptedException localInterruptedException) {}finally
      {
        break label786;
      }
    }
    Thread.currentThread().interrupt();
    return;
    label786:
    throw ((Throwable)localObject1);
    label791:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ic
 * JD-Core Version:    0.7.0.1
 */