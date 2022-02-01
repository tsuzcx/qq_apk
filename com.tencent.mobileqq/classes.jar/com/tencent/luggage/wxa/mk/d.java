package com.tencent.luggage.wxa.mk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.am.g.a;
import com.tencent.luggage.wxa.am.n;
import com.tencent.luggage.wxa.am.p;
import com.tencent.luggage.wxa.am.s.b;
import com.tencent.luggage.wxa.mj.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.u.b.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d
{
  private static String a;
  private static final a b = new a();
  
  public static g.a a(Context paramContext)
  {
    a locala = b;
    return new n(paramContext, locala, a(locala, c(paramContext)));
  }
  
  public static g.a a(Context paramContext, @Nullable Map<String, String> paramMap)
  {
    a locala = b;
    return new n(paramContext, locala, a(locala, c(paramContext), paramMap));
  }
  
  public static s.b a(a parama, String paramString)
  {
    return new p(paramString, parama, 8000, 8000, true);
  }
  
  public static s.b a(a parama, String paramString, @Nullable Map<String, String> paramMap)
  {
    parama = new p(paramString, parama, 8000, 8000, true);
    if (paramMap != null)
    {
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        o.d("MicroMsg.SameLayer.ExoMediaPlayerUtils", "buildDefaultHttpDataSourceFactory, header: %s: %s", new Object[] { paramMap.getKey(), paramMap.getValue() });
        parama.a((String)paramMap.getKey(), (String)paramMap.getValue());
      }
    }
    return parama;
  }
  
  public static String a()
  {
    return a(0, null, 10);
  }
  
  /* Error */
  public static String a(int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: ldc 104
    //   2: astore 12
    //   4: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   7: lstore 5
    //   9: iload_2
    //   10: sipush 1000
    //   13: imul
    //   14: i2l
    //   15: lstore 7
    //   17: invokestatic 116	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   20: iconst_1
    //   21: invokevirtual 120	java/util/Calendar:get	(I)I
    //   24: istore 4
    //   26: new 122	java/text/SimpleDateFormat
    //   29: dup
    //   30: ldc 124
    //   32: invokestatic 130	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   35: invokespecial 133	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   38: astore 19
    //   40: ldc 135
    //   42: astore 16
    //   44: aload_1
    //   45: ifnonnull +31 -> 76
    //   48: iconst_4
    //   49: anewarray 86	java/lang/String
    //   52: astore_1
    //   53: aload_1
    //   54: iconst_0
    //   55: ldc 137
    //   57: aastore
    //   58: aload_1
    //   59: iconst_1
    //   60: ldc 139
    //   62: aastore
    //   63: aload_1
    //   64: iconst_2
    //   65: ldc 141
    //   67: aastore
    //   68: aload_1
    //   69: iconst_3
    //   70: ldc 143
    //   72: aastore
    //   73: goto +48 -> 121
    //   76: bipush 6
    //   78: anewarray 86	java/lang/String
    //   81: astore 13
    //   83: aload 13
    //   85: iconst_0
    //   86: ldc 137
    //   88: aastore
    //   89: aload 13
    //   91: iconst_1
    //   92: ldc 139
    //   94: aastore
    //   95: aload 13
    //   97: iconst_2
    //   98: ldc 141
    //   100: aastore
    //   101: aload 13
    //   103: iconst_3
    //   104: ldc 143
    //   106: aastore
    //   107: aload 13
    //   109: iconst_4
    //   110: ldc 145
    //   112: aastore
    //   113: aload 13
    //   115: iconst_5
    //   116: aload_1
    //   117: aastore
    //   118: aload 13
    //   120: astore_1
    //   121: new 147	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   128: astore 18
    //   130: invokestatic 154	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   133: aload_1
    //   134: invokevirtual 158	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   137: astore 14
    //   139: aload 12
    //   141: astore 13
    //   143: aload 12
    //   145: astore 15
    //   147: new 160	java/io/BufferedReader
    //   150: dup
    //   151: new 162	java/io/InputStreamReader
    //   154: dup
    //   155: aload 14
    //   157: invokevirtual 168	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   160: invokespecial 171	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   163: invokespecial 174	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   166: astore 17
    //   168: iconst_0
    //   169: istore_2
    //   170: aload 12
    //   172: astore_1
    //   173: aload_1
    //   174: astore 13
    //   176: aload_1
    //   177: astore 15
    //   179: aload 17
    //   181: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   184: astore 20
    //   186: aload 20
    //   188: ifnull +191 -> 379
    //   191: aload_1
    //   192: astore 15
    //   194: aload 20
    //   196: aload 16
    //   198: invokevirtual 181	java/lang/String:matches	(Ljava/lang/String;)Z
    //   201: istore 11
    //   203: iload 11
    //   205: ifeq -32 -> 173
    //   208: aload_1
    //   209: astore 12
    //   211: aload 20
    //   213: iconst_0
    //   214: bipush 18
    //   216: invokevirtual 185	java/lang/String:substring	(II)Ljava/lang/String;
    //   219: astore 13
    //   221: new 147	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   228: astore 15
    //   230: aload 15
    //   232: iload 4
    //   234: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 15
    //   240: ldc 191
    //   242: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 15
    //   248: aload 13
    //   250: iconst_0
    //   251: bipush 18
    //   253: invokevirtual 185	java/lang/String:substring	(II)Ljava/lang/String;
    //   256: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 19
    //   262: aload 15
    //   264: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokevirtual 201	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   270: invokevirtual 206	java/util/Date:getTime	()J
    //   273: lstore 9
    //   275: lload 9
    //   277: lload 5
    //   279: lcmp
    //   280: ifle +6 -> 286
    //   283: goto +96 -> 379
    //   286: iload_2
    //   287: istore_3
    //   288: lload 9
    //   290: lload 5
    //   292: lload 7
    //   294: lsub
    //   295: lcmp
    //   296: ifle +35 -> 331
    //   299: iload_2
    //   300: istore_3
    //   301: iload_2
    //   302: ifne +13 -> 315
    //   305: aload 18
    //   307: ldc 208
    //   309: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: iconst_1
    //   314: istore_3
    //   315: aload 18
    //   317: aload 20
    //   319: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 18
    //   325: ldc 210
    //   327: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: iload_0
    //   332: ifle +26 -> 358
    //   335: aload 18
    //   337: invokevirtual 214	java/lang/StringBuilder:length	()I
    //   340: iload_0
    //   341: if_icmple +17 -> 358
    //   344: aload 18
    //   346: iconst_0
    //   347: aload 18
    //   349: invokevirtual 214	java/lang/StringBuilder:length	()I
    //   352: iload_0
    //   353: isub
    //   354: invokevirtual 218	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 12
    //   360: astore_1
    //   361: iload_3
    //   362: istore_2
    //   363: goto -190 -> 173
    //   366: astore 13
    //   368: aload 12
    //   370: astore_1
    //   371: goto +317 -> 688
    //   374: astore 13
    //   376: goto +312 -> 688
    //   379: aload_1
    //   380: astore 12
    //   382: aload 18
    //   384: ldc 220
    //   386: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 18
    //   392: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: astore 13
    //   397: aload 14
    //   399: ifnull +75 -> 474
    //   402: aload 14
    //   404: invokevirtual 224	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   407: invokevirtual 229	java/io/OutputStream:close	()V
    //   410: goto +16 -> 426
    //   413: astore_1
    //   414: ldc 70
    //   416: aload_1
    //   417: ldc 231
    //   419: iconst_0
    //   420: anewarray 4	java/lang/Object
    //   423: invokestatic 234	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: aload 14
    //   428: invokevirtual 168	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   431: invokevirtual 237	java/io/InputStream:close	()V
    //   434: goto +16 -> 450
    //   437: astore_1
    //   438: ldc 70
    //   440: aload_1
    //   441: aload 12
    //   443: iconst_0
    //   444: anewarray 4	java/lang/Object
    //   447: invokestatic 234	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   450: aload 14
    //   452: invokevirtual 240	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   455: invokevirtual 237	java/io/InputStream:close	()V
    //   458: aload 13
    //   460: areturn
    //   461: astore_1
    //   462: ldc 70
    //   464: aload_1
    //   465: ldc 242
    //   467: iconst_0
    //   468: anewarray 4	java/lang/Object
    //   471: invokestatic 234	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   474: aload 13
    //   476: areturn
    //   477: astore 13
    //   479: aload 12
    //   481: astore_1
    //   482: aload 13
    //   484: astore 12
    //   486: goto +198 -> 684
    //   489: astore 13
    //   491: aload_1
    //   492: astore 12
    //   494: aload 13
    //   496: astore_1
    //   497: goto +42 -> 539
    //   500: astore 12
    //   502: aload 13
    //   504: astore_1
    //   505: goto +179 -> 684
    //   508: astore_1
    //   509: aload 15
    //   511: astore 12
    //   513: goto +26 -> 539
    //   516: astore_1
    //   517: goto +167 -> 684
    //   520: astore_1
    //   521: goto +18 -> 539
    //   524: astore 13
    //   526: aconst_null
    //   527: astore 14
    //   529: aload 12
    //   531: astore_1
    //   532: goto +156 -> 688
    //   535: astore_1
    //   536: aconst_null
    //   537: astore 14
    //   539: new 147	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   546: astore 13
    //   548: aload 13
    //   550: ldc 244
    //   552: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload 13
    //   558: aload_1
    //   559: invokevirtual 245	java/lang/Throwable:toString	()Ljava/lang/String;
    //   562: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 13
    //   568: ldc 247
    //   570: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 18
    //   576: aload 13
    //   578: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 18
    //   587: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: astore_1
    //   591: aload 14
    //   593: ifnull +80 -> 673
    //   596: aload 14
    //   598: invokevirtual 224	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   601: invokevirtual 229	java/io/OutputStream:close	()V
    //   604: goto +18 -> 622
    //   607: astore 13
    //   609: ldc 70
    //   611: aload 13
    //   613: ldc 231
    //   615: iconst_0
    //   616: anewarray 4	java/lang/Object
    //   619: invokestatic 234	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   622: aload 14
    //   624: invokevirtual 168	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   627: invokevirtual 237	java/io/InputStream:close	()V
    //   630: goto +18 -> 648
    //   633: astore 13
    //   635: ldc 70
    //   637: aload 13
    //   639: aload 12
    //   641: iconst_0
    //   642: anewarray 4	java/lang/Object
    //   645: invokestatic 234	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   648: aload 14
    //   650: invokevirtual 240	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   653: invokevirtual 237	java/io/InputStream:close	()V
    //   656: aload_1
    //   657: areturn
    //   658: astore 12
    //   660: ldc 70
    //   662: aload 12
    //   664: ldc 242
    //   666: iconst_0
    //   667: anewarray 4	java/lang/Object
    //   670: invokestatic 234	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   673: aload_1
    //   674: areturn
    //   675: astore 13
    //   677: aload 12
    //   679: astore_1
    //   680: aload 13
    //   682: astore 12
    //   684: aload 12
    //   686: astore 13
    //   688: aload 14
    //   690: ifnull +78 -> 768
    //   693: aload 14
    //   695: invokevirtual 224	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   698: invokevirtual 229	java/io/OutputStream:close	()V
    //   701: goto +18 -> 719
    //   704: astore 12
    //   706: ldc 70
    //   708: aload 12
    //   710: ldc 231
    //   712: iconst_0
    //   713: anewarray 4	java/lang/Object
    //   716: invokestatic 234	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   719: aload 14
    //   721: invokevirtual 168	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   724: invokevirtual 237	java/io/InputStream:close	()V
    //   727: goto +17 -> 744
    //   730: astore 12
    //   732: ldc 70
    //   734: aload 12
    //   736: aload_1
    //   737: iconst_0
    //   738: anewarray 4	java/lang/Object
    //   741: invokestatic 234	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   744: aload 14
    //   746: invokevirtual 240	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   749: invokevirtual 237	java/io/InputStream:close	()V
    //   752: goto +16 -> 768
    //   755: astore_1
    //   756: ldc 70
    //   758: aload_1
    //   759: ldc 242
    //   761: iconst_0
    //   762: anewarray 4	java/lang/Object
    //   765: invokestatic 234	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   768: goto +6 -> 774
    //   771: aload 13
    //   773: athrow
    //   774: goto -3 -> 771
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	777	0	paramInt1	int
    //   0	777	1	paramString	String
    //   0	777	2	paramInt2	int
    //   287	75	3	i	int
    //   24	209	4	j	int
    //   7	284	5	l1	long
    //   15	278	7	l2	long
    //   273	16	9	l3	long
    //   201	3	11	bool	boolean
    //   2	491	12	localObject1	Object
    //   500	1	12	localObject2	Object
    //   511	1	12	localObject3	Object
    //   81	168	13	localObject4	Object
    //   366	1	13	localObject5	Object
    //   374	1	13	localObject6	Object
    //   395	80	13	str1	String
    //   477	6	13	localObject7	Object
    //   489	14	13	localThrowable	Throwable
    //   137	314	14	localProcess	java.lang.Process
    //   145	365	15	localObject8	Object
    //   42	155	16	str2	String
    //   166	14	17	localBufferedReader	java.io.BufferedReader
    //   128	263	18	localStringBuilder	StringBuilder
    //   38	223	19	localSimpleDateFormat	java.text.SimpleDateFormat
    //   184	134	20	str3	String
    // Exception table:
    //   from	to	target	type
    //   211	275	366	finally
    //   305	313	366	finally
    //   315	331	366	finally
    //   335	358	366	finally
    //   194	203	374	finally
    //   402	410	413	java/io/IOException
    //   426	434	437	java/lang/Exception
    //   450	458	461	java/io/IOException
    //   382	397	477	finally
    //   211	275	489	java/lang/Throwable
    //   305	313	489	java/lang/Throwable
    //   315	331	489	java/lang/Throwable
    //   335	358	489	java/lang/Throwable
    //   382	397	489	java/lang/Throwable
    //   147	168	500	finally
    //   179	186	500	finally
    //   147	168	508	java/lang/Throwable
    //   179	186	508	java/lang/Throwable
    //   194	203	508	java/lang/Throwable
    //   130	139	524	finally
    //   130	139	535	java/lang/Throwable
    //   596	604	607	java/io/IOException
    //   622	630	633	java/lang/Exception
    //   648	656	658	java/io/IOException
    //   539	591	675	finally
    //   693	701	704	java/io/IOException
    //   719	727	730	java/lang/Exception
    //   744	752	755	java/io/IOException
  }
  
  @NonNull
  public static String a(@Nullable Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return String.valueOf(null);
    }
    if ((paramThrowable instanceof b.a))
    {
      paramThrowable = (b.a)paramThrowable;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DecoderInitializationException{message='");
      localStringBuilder.append(paramThrowable.getLocalizedMessage());
      localStringBuilder.append('\'');
      localStringBuilder.append(", mimeType='");
      localStringBuilder.append(paramThrowable.a);
      localStringBuilder.append('\'');
      localStringBuilder.append(", secureDecoderRequired=");
      localStringBuilder.append(paramThrowable.b);
      localStringBuilder.append(", decoderName='");
      localStringBuilder.append(paramThrowable.c);
      localStringBuilder.append('\'');
      localStringBuilder.append(", diagnosticInfo='");
      localStringBuilder.append(paramThrowable.d);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    return paramThrowable.toString();
  }
  
  public static a b()
  {
    return b;
  }
  
  public static boolean b(Context paramContext)
  {
    return com.tencent.luggage.wxa.qz.x.k(paramContext);
  }
  
  private static String c(Context paramContext)
  {
    if (!af.c(a)) {
      return a;
    }
    a = paramContext.getPackageName();
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(a, 0);
      if ((localPackageInfo != null) && (localPackageInfo.applicationInfo != null) && (!af.c(localPackageInfo.applicationInfo.name))) {
        a = localPackageInfo.applicationInfo.name;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      o.a("MicroMsg.SameLayer.ExoMediaPlayerUtils", localRuntimeException, "getUserAgent exception", new Object[0]);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      o.a("MicroMsg.SameLayer.ExoMediaPlayerUtils", localNameNotFoundException, "getUserAgent exception", new Object[0]);
    }
    return com.tencent.luggage.wxa.ao.x.a(paramContext, a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.d
 * JD-Core Version:    0.7.0.1
 */