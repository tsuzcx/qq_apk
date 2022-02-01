package com.tencent.luggage.wxa.su;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.util.BSpatch;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class g
{
  private int a = -1;
  
  public g()
  {
    g();
  }
  
  private void g()
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(a(), "loadVer, context is null");
      return;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(a());
    if (localObject == null)
    {
      Log.e(a(), "loadVer, sp is null");
      return;
    }
    int i = this.a;
    this.a = ((SharedPreferences)localObject).getInt("availableVersion", -1);
    if (this.a != i)
    {
      if (i == -1)
      {
        localObject = a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadVer, version = ");
        localStringBuilder.append(this.a);
        Log.i((String)localObject, localStringBuilder.toString());
        return;
      }
      localObject = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadVer, old version = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", new version = ");
      localStringBuilder.append(this.a);
      Log.i((String)localObject, localStringBuilder.toString());
    }
  }
  
  public abstract boolean C_();
  
  public abstract int a(com.tencent.xweb.xwalk.updater.c paramc);
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      g();
    }
    return this.a;
  }
  
  public abstract String a();
  
  public String a(int paramInt, String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      String str = d(paramInt);
      if (str.isEmpty())
      {
        Log.e(a(), "getExtractFile, extractDir is empty");
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    Log.e(a(), "getExtractFile, fileName is empty");
    return "";
  }
  
  public abstract String a(int paramInt, boolean paramBoolean);
  
  public String b(int paramInt)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(a(), "getVersionDir, context is null");
      return "";
    }
    String str = XWalkEnvironment.getPluginBaseDir();
    if (str.isEmpty())
    {
      Log.e(a(), "getVersionDir, pluginBaseDir is null");
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    str = ((StringBuilder)localObject).toString();
    localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return str;
  }
  
  public String b(int paramInt, String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      String str = e(paramInt);
      if (str.isEmpty())
      {
        Log.e(a(), "getPatchFile, patchDir is null");
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    Log.e(a(), "getPatchFile, fileName is empty");
    return "";
  }
  
  public abstract boolean b();
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(a(), "setVer, context is null");
      return false;
    }
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(a());
    if (localObject == null)
    {
      Log.e(a(), "setVer, sp is null");
      return false;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("availableVersion", paramInt);
    boolean bool = ((SharedPreferences.Editor)localObject).commit();
    if ((bool) && (paramBoolean)) {
      this.a = paramInt;
    }
    localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVer, version = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", isNow = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ret = ");
    localStringBuilder.append(bool);
    Log.i((String)localObject, localStringBuilder.toString());
    return bool;
  }
  
  /* Error */
  protected boolean b(com.tencent.xweb.xwalk.updater.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   4: astore_2
    //   5: new 49	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: ldc 153
    //   16: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_3
    //   21: aload_1
    //   22: getfield 158	com/tencent/xweb/xwalk/updater/c:l	I
    //   25: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: aload_3
    //   31: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 65	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: new 89	java/io/File
    //   40: dup
    //   41: aload_1
    //   42: getfield 161	com/tencent/xweb/xwalk/updater/c:y	Ljava/lang/String;
    //   45: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore 5
    //   50: aconst_null
    //   51: astore 4
    //   53: aconst_null
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_1
    //   58: getfield 161	com/tencent/xweb/xwalk/updater/c:y	Ljava/lang/String;
    //   61: aload_1
    //   62: getfield 163	com/tencent/xweb/xwalk/updater/c:d	Ljava/lang/String;
    //   65: invokestatic 168	com/tencent/xweb/util/d:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   68: ifne +34 -> 102
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   77: ldc 170
    //   79: invokestatic 65	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aconst_null
    //   83: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   86: aload 5
    //   88: invokevirtual 112	java/io/File:exists	()Z
    //   91: ifeq +9 -> 100
    //   94: aload 5
    //   96: invokevirtual 178	java/io/File:delete	()Z
    //   99: pop
    //   100: iconst_0
    //   101: ireturn
    //   102: aload_3
    //   103: astore_2
    //   104: new 180	java/util/zip/ZipFile
    //   107: dup
    //   108: aload_1
    //   109: getfield 161	com/tencent/xweb/xwalk/updater/c:y	Ljava/lang/String;
    //   112: invokespecial 181	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 185	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   120: astore 4
    //   122: aload 4
    //   124: invokeinterface 190 1 0
    //   129: ifeq +145 -> 274
    //   132: aload 4
    //   134: invokeinterface 194 1 0
    //   139: checkcast 196	java/util/zip/ZipEntry
    //   142: astore 6
    //   144: aload 6
    //   146: invokevirtual 199	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   149: ldc 201
    //   151: invokestatic 207	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_2
    //   155: aload_2
    //   156: ldc 209
    //   158: invokevirtual 213	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   161: ifne -39 -> 122
    //   164: aload_2
    //   165: ldc 215
    //   167: invokevirtual 213	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   170: ifne -48 -> 122
    //   173: aload 6
    //   175: invokevirtual 218	java/util/zip/ZipEntry:isDirectory	()Z
    //   178: ifeq +6 -> 184
    //   181: goto -59 -> 122
    //   184: aload_3
    //   185: aload 6
    //   187: invokevirtual 222	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   190: astore 6
    //   192: aload_1
    //   193: getfield 226	com/tencent/xweb/xwalk/updater/c:f	Z
    //   196: ifeq +23 -> 219
    //   199: new 89	java/io/File
    //   202: dup
    //   203: aload_0
    //   204: aload_1
    //   205: getfield 158	com/tencent/xweb/xwalk/updater/c:l	I
    //   208: aload_2
    //   209: invokevirtual 228	com/tencent/luggage/wxa/su/g:b	(ILjava/lang/String;)Ljava/lang/String;
    //   212: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   215: astore_2
    //   216: goto +20 -> 236
    //   219: new 89	java/io/File
    //   222: dup
    //   223: aload_0
    //   224: aload_1
    //   225: getfield 158	com/tencent/xweb/xwalk/updater/c:l	I
    //   228: aload_2
    //   229: invokevirtual 230	com/tencent/luggage/wxa/su/g:a	(ILjava/lang/String;)Ljava/lang/String;
    //   232: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   235: astore_2
    //   236: aload 6
    //   238: aload_2
    //   239: invokestatic 233	com/tencent/xweb/util/c:a	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   242: ifne -120 -> 122
    //   245: aload_0
    //   246: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   249: ldc 235
    //   251: invokestatic 33	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_3
    //   255: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   258: aload 5
    //   260: invokevirtual 112	java/io/File:exists	()Z
    //   263: ifeq +9 -> 272
    //   266: aload 5
    //   268: invokevirtual 178	java/io/File:delete	()Z
    //   271: pop
    //   272: iconst_0
    //   273: ireturn
    //   274: aload_1
    //   275: getfield 238	com/tencent/xweb/xwalk/updater/c:x	Z
    //   278: ifne +74 -> 352
    //   281: aload_1
    //   282: getfield 226	com/tencent/xweb/xwalk/updater/c:f	Z
    //   285: ifeq +6 -> 291
    //   288: goto +64 -> 352
    //   291: aload_0
    //   292: aload_1
    //   293: getfield 158	com/tencent/xweb/xwalk/updater/c:l	I
    //   296: iconst_0
    //   297: invokevirtual 241	com/tencent/luggage/wxa/su/g:c	(IZ)Z
    //   300: ifne +32 -> 332
    //   303: aload_0
    //   304: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   307: ldc 243
    //   309: invokestatic 33	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload_3
    //   313: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   316: aload 5
    //   318: invokevirtual 112	java/io/File:exists	()Z
    //   321: ifeq +9 -> 330
    //   324: aload 5
    //   326: invokevirtual 178	java/io/File:delete	()Z
    //   329: pop
    //   330: iconst_0
    //   331: ireturn
    //   332: aload_3
    //   333: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   336: aload 5
    //   338: invokevirtual 112	java/io/File:exists	()Z
    //   341: ifeq +9 -> 350
    //   344: aload 5
    //   346: invokevirtual 178	java/io/File:delete	()Z
    //   349: pop
    //   350: iconst_1
    //   351: ireturn
    //   352: aload_3
    //   353: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   356: aload 5
    //   358: invokevirtual 112	java/io/File:exists	()Z
    //   361: ifeq +9 -> 370
    //   364: aload 5
    //   366: invokevirtual 178	java/io/File:delete	()Z
    //   369: pop
    //   370: iconst_1
    //   371: ireturn
    //   372: astore_1
    //   373: goto +94 -> 467
    //   376: astore_2
    //   377: aload_3
    //   378: astore_1
    //   379: aload_2
    //   380: astore_3
    //   381: goto +13 -> 394
    //   384: astore_1
    //   385: aload_2
    //   386: astore_3
    //   387: goto +80 -> 467
    //   390: astore_3
    //   391: aload 4
    //   393: astore_1
    //   394: aload_1
    //   395: astore_2
    //   396: aload_0
    //   397: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   400: astore 4
    //   402: aload_1
    //   403: astore_2
    //   404: new 49	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   411: astore 6
    //   413: aload_1
    //   414: astore_2
    //   415: aload 6
    //   417: ldc 245
    //   419: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload_1
    //   424: astore_2
    //   425: aload 6
    //   427: aload_3
    //   428: invokevirtual 248	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload_1
    //   436: astore_2
    //   437: aload 4
    //   439: aload 6
    //   441: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 33	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload_1
    //   448: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   451: aload 5
    //   453: invokevirtual 112	java/io/File:exists	()Z
    //   456: ifeq +9 -> 465
    //   459: aload 5
    //   461: invokevirtual 178	java/io/File:delete	()Z
    //   464: pop
    //   465: iconst_0
    //   466: ireturn
    //   467: aload_3
    //   468: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   471: aload 5
    //   473: invokevirtual 112	java/io/File:exists	()Z
    //   476: ifeq +9 -> 485
    //   479: aload 5
    //   481: invokevirtual 178	java/io/File:delete	()Z
    //   484: pop
    //   485: goto +5 -> 490
    //   488: aload_1
    //   489: athrow
    //   490: goto -2 -> 488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	g
    //   0	493	1	paramc	com.tencent.xweb.xwalk.updater.c
    //   4	235	2	localObject1	Object
    //   376	10	2	localException1	java.lang.Exception
    //   395	42	2	localc	com.tencent.xweb.xwalk.updater.c
    //   12	375	3	localObject2	Object
    //   390	78	3	localException2	java.lang.Exception
    //   51	387	4	localObject3	Object
    //   48	432	5	localFile	File
    //   142	298	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   116	122	372	finally
    //   122	181	372	finally
    //   184	216	372	finally
    //   219	236	372	finally
    //   236	254	372	finally
    //   274	288	372	finally
    //   291	312	372	finally
    //   116	122	376	java/lang/Exception
    //   122	181	376	java/lang/Exception
    //   184	216	376	java/lang/Exception
    //   219	236	376	java/lang/Exception
    //   236	254	376	java/lang/Exception
    //   274	288	376	java/lang/Exception
    //   291	312	376	java/lang/Exception
    //   57	71	384	finally
    //   73	82	384	finally
    //   104	116	384	finally
    //   396	402	384	finally
    //   404	413	384	finally
    //   415	423	384	finally
    //   425	435	384	finally
    //   437	447	384	finally
    //   57	71	390	java/lang/Exception
    //   73	82	390	java/lang/Exception
    //   104	116	390	java/lang/Exception
  }
  
  public String c(int paramInt)
  {
    String str = b(paramInt);
    if ((str != null) && (!str.isEmpty()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("cache");
      str = ((StringBuilder)localObject).toString();
      localObject = new File(str);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      return str;
    }
    Log.e(a(), "getPrivateCacheDir, versionDir is empty");
    return "";
  }
  
  /* Error */
  public boolean c(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   4: astore_3
    //   5: new 49	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: ldc_w 256
    //   19: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 4
    //   25: iload_1
    //   26: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_3
    //   31: aload 4
    //   33: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 65	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: iload_1
    //   40: ifge +15 -> 55
    //   43: aload_0
    //   44: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   47: ldc_w 258
    //   50: invokestatic 65	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: iconst_0
    //   54: ireturn
    //   55: new 89	java/io/File
    //   58: dup
    //   59: aload_0
    //   60: iload_1
    //   61: ldc_w 260
    //   64: invokevirtual 230	com/tencent/luggage/wxa/su/g:a	(ILjava/lang/String;)Ljava/lang/String;
    //   67: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore 4
    //   72: aload 4
    //   74: invokevirtual 112	java/io/File:exists	()Z
    //   77: ifne +31 -> 108
    //   80: iload_2
    //   81: ifeq +15 -> 96
    //   84: aload_0
    //   85: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   88: ldc_w 262
    //   91: invokestatic 65	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_0
    //   97: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   100: ldc_w 264
    //   103: invokestatic 33	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: iconst_0
    //   107: ireturn
    //   108: aconst_null
    //   109: astore 5
    //   111: aconst_null
    //   112: astore_3
    //   113: new 266	java/io/BufferedReader
    //   116: dup
    //   117: new 268	java/io/FileReader
    //   120: dup
    //   121: aload 4
    //   123: invokespecial 271	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   126: invokespecial 274	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   129: astore 4
    //   131: aload 4
    //   133: invokevirtual 277	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   136: astore_3
    //   137: aload_3
    //   138: ifnull +136 -> 274
    //   141: aload_3
    //   142: invokevirtual 79	java/lang/String:isEmpty	()Z
    //   145: ifeq +6 -> 151
    //   148: goto -17 -> 131
    //   151: aload_3
    //   152: ldc_w 279
    //   155: invokevirtual 283	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   158: astore 5
    //   160: aload 5
    //   162: arraylength
    //   163: iconst_2
    //   164: if_icmpne -33 -> 131
    //   167: aload 5
    //   169: iconst_0
    //   170: aaload
    //   171: ifnull -40 -> 131
    //   174: aload 5
    //   176: iconst_0
    //   177: aaload
    //   178: invokevirtual 79	java/lang/String:isEmpty	()Z
    //   181: ifne -50 -> 131
    //   184: aload 5
    //   186: iconst_1
    //   187: aaload
    //   188: ifnull -57 -> 131
    //   191: aload 5
    //   193: iconst_1
    //   194: aaload
    //   195: invokevirtual 79	java/lang/String:isEmpty	()Z
    //   198: ifne -67 -> 131
    //   201: aload 5
    //   203: iconst_0
    //   204: aaload
    //   205: astore_3
    //   206: aload 5
    //   208: iconst_1
    //   209: aaload
    //   210: astore 5
    //   212: aload_0
    //   213: iload_1
    //   214: aload_3
    //   215: invokevirtual 230	com/tencent/luggage/wxa/su/g:a	(ILjava/lang/String;)Ljava/lang/String;
    //   218: aload 5
    //   220: invokestatic 168	com/tencent/xweb/util/d:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   223: ifne -92 -> 131
    //   226: aload_0
    //   227: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   230: astore 5
    //   232: new 49	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   239: astore 6
    //   241: aload 6
    //   243: ldc_w 285
    //   246: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 6
    //   252: aload_3
    //   253: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 5
    //   259: aload 6
    //   261: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 33	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload 4
    //   269: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   272: iconst_0
    //   273: ireturn
    //   274: aload_0
    //   275: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   278: ldc_w 287
    //   281: invokestatic 65	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 4
    //   286: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   289: iconst_1
    //   290: ireturn
    //   291: astore_3
    //   292: goto +94 -> 386
    //   295: astore 5
    //   297: goto +22 -> 319
    //   300: astore 5
    //   302: aload_3
    //   303: astore 4
    //   305: aload 5
    //   307: astore_3
    //   308: goto +78 -> 386
    //   311: astore_3
    //   312: aload 5
    //   314: astore 4
    //   316: aload_3
    //   317: astore 5
    //   319: aload 4
    //   321: astore_3
    //   322: aload_0
    //   323: invokevirtual 25	com/tencent/luggage/wxa/su/g:a	()Ljava/lang/String;
    //   326: astore 6
    //   328: aload 4
    //   330: astore_3
    //   331: new 49	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   338: astore 7
    //   340: aload 4
    //   342: astore_3
    //   343: aload 7
    //   345: ldc_w 289
    //   348: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 4
    //   354: astore_3
    //   355: aload 7
    //   357: aload 5
    //   359: invokevirtual 248	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   362: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 4
    //   368: astore_3
    //   369: aload 6
    //   371: aload 7
    //   373: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 33	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload 4
    //   381: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   384: iconst_0
    //   385: ireturn
    //   386: aload 4
    //   388: invokestatic 175	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   391: goto +5 -> 396
    //   394: aload_3
    //   395: athrow
    //   396: goto -2 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	g
    //   0	399	1	paramInt	int
    //   0	399	2	paramBoolean	boolean
    //   4	249	3	str	String
    //   291	12	3	localObject1	Object
    //   307	1	3	localObject2	Object
    //   311	6	3	localException1	java.lang.Exception
    //   321	74	3	localObject3	Object
    //   12	375	4	localObject4	Object
    //   109	149	5	localObject5	Object
    //   295	1	5	localException2	java.lang.Exception
    //   300	13	5	localObject6	Object
    //   317	41	5	localException3	java.lang.Exception
    //   239	131	6	localObject7	Object
    //   338	34	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   131	137	291	finally
    //   141	148	291	finally
    //   151	167	291	finally
    //   174	184	291	finally
    //   191	201	291	finally
    //   212	267	291	finally
    //   274	284	291	finally
    //   131	137	295	java/lang/Exception
    //   141	148	295	java/lang/Exception
    //   151	167	295	java/lang/Exception
    //   174	184	295	java/lang/Exception
    //   191	201	295	java/lang/Exception
    //   212	267	295	java/lang/Exception
    //   274	284	295	java/lang/Exception
    //   113	131	300	finally
    //   322	328	300	finally
    //   331	340	300	finally
    //   343	352	300	finally
    //   355	366	300	finally
    //   369	379	300	finally
    //   113	131	311	java/lang/Exception
  }
  
  protected boolean c(com.tencent.xweb.xwalk.updater.c paramc)
  {
    int i = e();
    Object localObject1 = a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doPatch current version = ");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", new version = ");
    ((StringBuilder)localObject2).append(paramc.l);
    Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
    if (i < 0)
    {
      Log.e(a(), "doPatch, current version invalid");
      return false;
    }
    if (!paramc.f)
    {
      Log.e(a(), "doPatch, current download config is not patch");
      return false;
    }
    localObject1 = new File(b(paramc.l, "patch.config"));
    if (!((File)localObject1).exists())
    {
      Log.e(a(), "doPatch, can not find patch config file");
      return false;
    }
    localObject1 = i.a((File)localObject1);
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      if (!com.tencent.xweb.util.c.c(d(i), d(paramc.l)))
      {
        Log.e(a(), "doPatch, copy files failed");
        return false;
      }
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (i.a)((Iterator)localObject2).next();
        String str;
        StringBuilder localStringBuilder;
        if (((i.a)localObject1).a())
        {
          if (!com.tencent.xweb.util.c.a(b(paramc.l, ((i.a)localObject1).c), a(paramc.l, ((i.a)localObject1).c)))
          {
            paramc = a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doPatch, add file error: ");
            ((StringBuilder)localObject2).append(localObject1);
            Log.e(paramc, ((StringBuilder)localObject2).toString());
            return false;
          }
          str = a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doPatch, add file:");
          localStringBuilder.append(localObject1);
          Log.i(str, localStringBuilder.toString());
        }
        else if (((i.a)localObject1).c())
        {
          if (!com.tencent.xweb.util.c.a(a(paramc.l, ((i.a)localObject1).c)))
          {
            str = a();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("doPatch, delete file error:");
            localStringBuilder.append(localObject1);
            Log.e(str, localStringBuilder.toString());
          }
          else
          {
            str = a();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("doPatch, delete file:");
            localStringBuilder.append(localObject1);
            Log.i(str, localStringBuilder.toString());
          }
        }
        else if (((i.a)localObject1).b())
        {
          if (BSpatch.a(a(paramc.l, ((i.a)localObject1).c), b(paramc.l, ((i.a)localObject1).b), a(paramc.l, ((i.a)localObject1).c)) < 0)
          {
            paramc = a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("doPatch, patch file error:");
            ((StringBuilder)localObject2).append(localObject1);
            Log.e(paramc, ((StringBuilder)localObject2).toString());
            return false;
          }
          str = a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doPatch, patch file:");
          localStringBuilder.append(localObject1);
          Log.i(str, localStringBuilder.toString());
        }
        else
        {
          paramc = a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doPatch, unknown op");
          ((StringBuilder)localObject2).append(localObject1);
          Log.e(paramc, ((StringBuilder)localObject2).toString());
          return false;
        }
      }
      com.tencent.xweb.util.c.a(a(paramc.l, "filelist.config"));
      if (!com.tencent.xweb.util.c.a(b(paramc.l, "filelist.config"), a(paramc.l, "filelist.config")))
      {
        Log.e(a(), "doPatch, copy filelist.config error");
        return false;
      }
      if (!c(paramc.l, false))
      {
        Log.e(a(), "doPatch, check md5 failed");
        return false;
      }
      paramc = e(paramc.l);
      if (!paramc.isEmpty()) {
        com.tencent.xweb.util.c.b(paramc);
      }
      return true;
    }
    Log.e(a(), "doPatch, patchConfigList = null");
    return false;
  }
  
  public String d(int paramInt)
  {
    String str = b(paramInt);
    if (str.isEmpty())
    {
      Log.e(a(), "getExtractDir, versionDir is empty");
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("extracted");
    str = ((StringBuilder)localObject).toString();
    localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return str;
  }
  
  public abstract void d();
  
  public int e()
  {
    return this.a;
  }
  
  public String e(int paramInt)
  {
    String str = b(paramInt);
    if (str.isEmpty())
    {
      Log.e(a(), "getPatchDir, versionDir is empty");
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("patch_temp");
    str = ((StringBuilder)localObject).toString();
    localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return str;
  }
  
  public boolean f()
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(a(), "clearPatchDownloadInfo, context is null");
      return false;
    }
    Object localObject1 = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(a());
    if (localObject1 == null)
    {
      Log.e(a(), "clearPatchDownloadInfo, sp is null");
      return false;
    }
    Object localObject2 = ((SharedPreferences)localObject1).getAll();
    if ((localObject2 != null) && (((Map)localObject2).size() != 0))
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Iterator)localObject2).next();
        if ((str1 != null) && (str1.startsWith("patchDownloadCount_")))
        {
          String str2 = a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clearPatchDownloadInfo, remove key ");
          localStringBuilder.append(str1);
          Log.i(str2, localStringBuilder.toString());
          ((SharedPreferences.Editor)localObject1).remove(str1);
        }
      }
      return ((SharedPreferences.Editor)localObject1).commit();
    }
    return true;
  }
  
  public boolean f(int paramInt)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(a(), "recordPatchDownloadInfo, context is null");
      return false;
    }
    Object localObject1 = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(a());
    if (localObject1 == null)
    {
      Log.e(a(), "recordPatchDownloadInfo, sp is null");
      return false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("patchDownloadCount_");
    ((StringBuilder)localObject2).append(paramInt);
    localObject2 = ((StringBuilder)localObject2).toString();
    paramInt = ((SharedPreferences)localObject1).getInt((String)localObject2, 0);
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, paramInt + 1);
    return ((SharedPreferences.Editor)localObject1).commit();
  }
  
  public boolean g(int paramInt)
  {
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e(a(), "canDownloadPatch, context is null");
      return false;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(a());
    if (localSharedPreferences == null)
    {
      Log.e(a(), "canDownloadPatch, sp is null");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("patchDownloadCount_");
    localStringBuilder.append(paramInt);
    if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) <= 1)
    {
      Log.i(a(), "canDownloadPatch, ret = true");
      return true;
    }
    Log.i(a(), "canDownloadPatch, ret = false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.g
 * JD-Core Version:    0.7.0.1
 */