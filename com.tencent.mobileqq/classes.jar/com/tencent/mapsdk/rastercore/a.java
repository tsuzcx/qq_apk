package com.tencent.mapsdk.rastercore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mapsdk.rastercore.d.e;
import java.lang.ref.WeakReference;

public class a
{
  public static StringBuffer a = new StringBuffer(300);
  private static final String b = a.class.getSimpleName();
  private static boolean c = false;
  private static WeakReference<e> d = null;
  
  @SuppressLint({"NewApi"})
  public static String a()
  {
    Object localObject2 = "";
    Object localObject3 = e.a();
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Context)localObject3).checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {}
      }
    }
    else
    {
      localObject1 = ((TelephonyManager)((Context)localObject3).getSystemService("phone")).getDeviceId();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "noIMEI";
    }
    localObject3 = c();
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = "noMac";
    }
    localObject3 = ((String)localObject2).getBytes();
    byte[] arrayOfByte = ((String)localObject1).getBytes();
    new StringBuilder().append((String)localObject2).append("::::").append((String)localObject1);
    a((byte[])localObject3, arrayOfByte);
    return a((byte[])localObject3, arrayOfByte);
  }
  
  private static String a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = 0;
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + 2];
    arrayOfByte[0] = ((byte)paramArrayOfByte1.length);
    arrayOfByte[1] = ((byte)paramArrayOfByte2.length);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayOfByte1.length) {
        break;
      }
      arrayOfByte[(i + 2)] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(i % paramArrayOfByte2.length)] ^ 0x25));
      i += 1;
    }
    while (j < paramArrayOfByte2.length)
    {
      arrayOfByte[(j + 2 + paramArrayOfByte1.length)] = ((byte)(paramArrayOfByte2[j] ^ 0x36));
      j += 1;
    }
    return Base64.encodeToString(arrayOfByte, 3);
  }
  
  public static void a(e parame)
  {
    d = new WeakReference(parame);
    if (c) {
      return;
    }
    new Thread()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: iconst_1
        //   1: invokestatic 20	com/tencent/mapsdk/rastercore/a:a	(Z)Z
        //   4: pop
        //   5: getstatic 25	com/tencent/mapsdk/rastercore/d$a$a:a	Lcom/tencent/mapsdk/rastercore/d$a;
        //   8: astore 5
        //   10: invokestatic 31	com/tencent/mapsdk/rastercore/d$a:b	()I
        //   13: putstatic 37	com/tencent/mapsdk/rastercore/b:d	I
        //   16: invokestatic 42	com/tencent/mapsdk/rastercore/d/e:a	()Landroid/content/Context;
        //   19: invokestatic 47	com/tencent/mapsdk/rastercore/f/b:a	(Landroid/content/Context;)Ljava/lang/String;
        //   22: astore 5
        //   24: aload 5
        //   26: ldc 49
        //   28: invokestatic 55	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   31: astore 5
        //   33: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   36: ldc 60
        //   38: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   41: pop
        //   42: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   45: aload 5
        //   47: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   50: pop
        //   51: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   54: ldc 68
        //   56: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   59: pop
        //   60: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   63: ldc 70
        //   65: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   68: pop
        //   69: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   72: ldc 72
        //   74: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   77: pop
        //   78: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   81: ldc 74
        //   83: ldc 49
        //   85: invokestatic 55	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   88: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   91: pop
        //   92: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   95: ldc 76
        //   97: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   100: pop
        //   101: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   104: getstatic 82	android/os/Build:MODEL	Ljava/lang/String;
        //   107: ldc 49
        //   109: invokestatic 55	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   112: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   115: pop
        //   116: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   119: ldc 84
        //   121: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   124: pop
        //   125: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   128: getstatic 89	android/os/Build$VERSION:SDK_INT	I
        //   131: invokevirtual 92	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
        //   134: pop
        //   135: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   138: ldc 94
        //   140: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   143: pop
        //   144: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   147: invokestatic 42	com/tencent/mapsdk/rastercore/d/e:a	()Landroid/content/Context;
        //   150: invokevirtual 100	android/content/Context:getPackageName	()Ljava/lang/String;
        //   153: ldc 49
        //   155: invokestatic 55	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   158: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   161: pop
        //   162: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   165: ldc 102
        //   167: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   170: pop
        //   171: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   174: invokestatic 104	com/tencent/mapsdk/rastercore/a:b	()Ljava/lang/String;
        //   177: invokestatic 107	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
        //   180: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   183: pop
        //   184: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   187: ldc 109
        //   189: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   192: pop
        //   193: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   196: invokestatic 111	com/tencent/mapsdk/rastercore/a:a	()Ljava/lang/String;
        //   199: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   202: pop
        //   203: invokestatic 42	com/tencent/mapsdk/rastercore/d/e:a	()Landroid/content/Context;
        //   206: invokevirtual 115	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
        //   209: astore 5
        //   211: aload 5
        //   213: invokestatic 42	com/tencent/mapsdk/rastercore/d/e:a	()Landroid/content/Context;
        //   216: invokevirtual 100	android/content/Context:getPackageName	()Ljava/lang/String;
        //   219: iconst_0
        //   220: invokevirtual 121	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   223: astore 6
        //   225: aload 6
        //   227: getfield 127	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
        //   230: aload 5
        //   232: invokevirtual 133	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
        //   235: invokeinterface 138 1 0
        //   240: astore 5
        //   242: aload 6
        //   244: getfield 141	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
        //   247: astore 6
        //   249: aload 6
        //   251: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   254: istore 4
        //   256: iload 4
        //   258: ifne +375 -> 633
        //   261: aload 5
        //   263: ifnull +26 -> 289
        //   266: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   269: ldc 149
        //   271: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   274: pop
        //   275: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   278: aload 5
        //   280: ldc 49
        //   282: invokestatic 55	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   285: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   288: pop
        //   289: aload 6
        //   291: ifnull +26 -> 317
        //   294: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   297: ldc 151
        //   299: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   302: pop
        //   303: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   306: aload 6
        //   308: ldc 49
        //   310: invokestatic 55	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   313: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   316: pop
        //   317: invokestatic 42	com/tencent/mapsdk/rastercore/d/e:a	()Landroid/content/Context;
        //   320: invokevirtual 155	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   323: invokevirtual 161	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
        //   326: astore 5
        //   328: aload 5
        //   330: getfield 166	android/util/DisplayMetrics:densityDpi	I
        //   333: istore_1
        //   334: aload 5
        //   336: getfield 169	android/util/DisplayMetrics:widthPixels	I
        //   339: istore_2
        //   340: aload 5
        //   342: getfield 172	android/util/DisplayMetrics:heightPixels	I
        //   345: istore_3
        //   346: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   349: ldc 174
        //   351: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   354: pop
        //   355: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   358: iload_1
        //   359: invokevirtual 92	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
        //   362: pop
        //   363: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   366: ldc 176
        //   368: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   371: pop
        //   372: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   375: iload_2
        //   376: invokevirtual 92	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
        //   379: pop
        //   380: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   383: ldc 178
        //   385: invokevirtual 66	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   388: pop
        //   389: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   392: iload_3
        //   393: invokevirtual 92	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
        //   396: pop
        //   397: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   400: astore 5
        //   402: iconst_0
        //   403: istore_1
        //   404: iload_1
        //   405: iconst_2
        //   406: if_icmpge +139 -> 545
        //   409: new 180	java/net/URL
        //   412: dup
        //   413: new 182	java/lang/StringBuilder
        //   416: dup
        //   417: invokespecial 183	java/lang/StringBuilder:<init>	()V
        //   420: ldc 185
        //   422: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   425: getstatic 58	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   428: invokevirtual 189	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   431: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   434: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   437: invokespecial 193	java/net/URL:<init>	(Ljava/lang/String;)V
        //   440: invokevirtual 197	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   443: checkcast 199	java/net/HttpURLConnection
        //   446: astore 5
        //   448: aload 5
        //   450: ldc 201
        //   452: ldc 203
        //   454: invokevirtual 207	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   457: aload 5
        //   459: invokevirtual 210	java/net/HttpURLConnection:getResponseCode	()I
        //   462: sipush 200
        //   465: if_icmpne +126 -> 591
        //   468: aload 5
        //   470: ldc 212
        //   472: invokevirtual 215	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   475: astore 6
        //   477: aload 6
        //   479: ifnull +83 -> 562
        //   482: aload 6
        //   484: invokevirtual 220	java/lang/String:length	()I
        //   487: ifle +75 -> 562
        //   490: aload 6
        //   492: invokevirtual 223	java/lang/String:toLowerCase	()Ljava/lang/String;
        //   495: ldc 203
        //   497: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   500: ifeq +62 -> 562
        //   503: iconst_1
        //   504: istore_2
        //   505: iload_2
        //   506: ifeq +61 -> 567
        //   509: new 228	java/io/BufferedInputStream
        //   512: dup
        //   513: new 230	java/util/zip/GZIPInputStream
        //   516: dup
        //   517: aload 5
        //   519: invokevirtual 234	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   522: invokespecial 237	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
        //   525: invokespecial 238	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   528: astore 5
        //   530: new 217	java/lang/String
        //   533: dup
        //   534: aload 5
        //   536: invokestatic 241	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/InputStream;)[B
        //   539: invokespecial 244	java/lang/String:<init>	([B)V
        //   542: invokestatic 246	com/tencent/mapsdk/rastercore/a:a	(Ljava/lang/String;)V
        //   545: iconst_0
        //   546: invokestatic 20	com/tencent/mapsdk/rastercore/a:a	(Z)Z
        //   549: pop
        //   550: return
        //   551: astore 5
        //   553: aconst_null
        //   554: astore 5
        //   556: aconst_null
        //   557: astore 6
        //   559: goto -298 -> 261
        //   562: iconst_0
        //   563: istore_2
        //   564: goto -59 -> 505
        //   567: new 228	java/io/BufferedInputStream
        //   570: dup
        //   571: aload 5
        //   573: invokevirtual 234	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   576: invokespecial 238	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   579: astore 5
        //   581: goto -51 -> 530
        //   584: astore 5
        //   586: aload 5
        //   588: invokevirtual 249	java/lang/Exception:printStackTrace	()V
        //   591: iload_1
        //   592: iconst_1
        //   593: iadd
        //   594: istore_1
        //   595: goto -191 -> 404
        //   598: astore 5
        //   600: goto -203 -> 397
        //   603: astore 5
        //   605: goto -288 -> 317
        //   608: astore 5
        //   610: goto -321 -> 289
        //   613: astore 6
        //   615: goto -59 -> 556
        //   618: astore 5
        //   620: goto -436 -> 184
        //   623: astore 5
        //   625: goto -533 -> 92
        //   628: astore 5
        //   630: goto -579 -> 51
        //   633: aconst_null
        //   634: astore 6
        //   636: goto -375 -> 261
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	639	0	this	1
        //   333	262	1	i	int
        //   339	225	2	j	int
        //   345	48	3	k	int
        //   254	3	4	bool	boolean
        //   8	527	5	localObject1	Object
        //   551	1	5	localException1	Exception
        //   554	26	5	localBufferedInputStream	java.io.BufferedInputStream
        //   584	3	5	localException2	Exception
        //   598	1	5	localException3	Exception
        //   603	1	5	localException4	Exception
        //   608	1	5	localException5	Exception
        //   618	1	5	localException6	Exception
        //   623	1	5	localException7	Exception
        //   628	1	5	localException8	Exception
        //   223	335	6	localObject2	Object
        //   613	1	6	localException9	Exception
        //   634	1	6	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   203	242	551	java/lang/Exception
        //   409	477	584	java/lang/Exception
        //   482	503	584	java/lang/Exception
        //   509	530	584	java/lang/Exception
        //   530	545	584	java/lang/Exception
        //   567	581	584	java/lang/Exception
        //   317	397	598	java/lang/Exception
        //   303	317	603	java/lang/Exception
        //   275	289	608	java/lang/Exception
        //   242	256	613	java/lang/Exception
        //   92	184	618	java/lang/Exception
        //   78	92	623	java/lang/Exception
        //   24	51	628	java/lang/Exception
      }
    }.start();
  }
  
  private static String c()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = ((WifiManager)e.a().getSystemService("wifi")).getConnectionInfo();
        if (localObject1 == null) {
          return null;
        }
        localObject1 = ((WifiInfo)localObject1).getBSSID();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).replace(":", "");
          if ("000000000000".equals(localObject1)) {
            break;
          }
          boolean bool = "".equals(localObject1);
          if (bool) {
            break;
          }
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      Object localObject2 = null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.a
 * JD-Core Version:    0.7.0.1
 */