package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.security.MessageDigest;

public class a
{
  public static Object a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      break;
    }
    try
    {
      return Double.valueOf(paramString);
    }
    catch (Exception localException)
    {
      Object localObject;
      break label78;
    }
    return Float.valueOf(paramString);
    return Boolean.valueOf(paramString);
    return Long.valueOf(paramString);
    return Integer.valueOf(paramString);
    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
    break label111;
    label78:
    paramString = new StringBuilder();
    paramString.append("resolveObj exception:");
    paramString.append(localObject.getMessage());
    Log.e("MicroMsg.SDK.PluginProvider.Resolver", paramString.toString());
    label111:
    return null;
    return paramString;
  }
  
  public static String a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      paramString = new StringBuilder();
      paramString.append("getStringExtra exception:");
      paramString.append(paramBundle.getMessage());
      Log.e("MicroMsg.IntentUtil", paramString.toString());
    }
    return null;
  }
  
  public static boolean a(Context paramContext, a.a parama)
  {
    if ((paramContext != null) && (parama != null)) {
      if (!b.b(parama.b)) {}
    }
    for (paramContext = "send fail, action is null";; paramContext = "send fail, invalid argument")
    {
      Log.e("MicroMsg.SDK.MMessage", paramContext);
      return false;
      Object localObject1 = null;
      if (!b.b(parama.a))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(parama.a);
        ((StringBuilder)localObject1).append(".permission.MM_MESSAGE");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      Intent localIntent = new Intent(parama.b);
      Object localObject2 = parama.e;
      if (localObject2 != null) {
        localIntent.putExtras((Bundle)localObject2);
      }
      localObject2 = paramContext.getPackageName();
      localIntent.putExtra("_mmessage_sdkVersion", 637992960);
      localIntent.putExtra("_mmessage_appPackage", (String)localObject2);
      localIntent.putExtra("_mmessage_content", parama.c);
      localIntent.putExtra("_mmessage_support_content_type", parama.d);
      localIntent.putExtra("_mmessage_checksum", a(parama.c, 637992960, (String)localObject2));
      paramContext.sendBroadcast(localIntent, (String)localObject1);
      paramContext = new StringBuilder();
      paramContext.append("send mm message, intent=");
      paramContext.append(localIntent);
      paramContext.append(", perm=");
      paramContext.append((String)localObject1);
      Log.d("MicroMsg.SDK.MMessage", paramContext.toString());
      return true;
    }
  }
  
  /* Error */
  public static byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +814 -> 818
    //   7: aload_0
    //   8: invokevirtual 172	java/lang/String:length	()I
    //   11: ifne +6 -> 17
    //   14: goto +804 -> 818
    //   17: new 174	java/net/URL
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 175	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 179	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   28: checkcast 181	java/net/HttpURLConnection
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +35 -> 68
    //   36: ldc 183
    //   38: ldc 185
    //   40: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: ifnull +7 -> 51
    //   47: aload_0
    //   48: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   51: aconst_null
    //   52: areturn
    //   53: astore 7
    //   55: goto +64 -> 119
    //   58: astore 7
    //   60: goto +72 -> 132
    //   63: astore 7
    //   65: goto +80 -> 145
    //   68: aload_0
    //   69: ldc 190
    //   71: invokevirtual 193	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: iload_1
    //   76: invokevirtual 197	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   79: aload_0
    //   80: iload_1
    //   81: invokevirtual 200	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   84: aload_0
    //   85: invokevirtual 203	java/net/HttpURLConnection:getResponseCode	()I
    //   88: istore_1
    //   89: iload_1
    //   90: sipush 300
    //   93: if_icmplt +65 -> 158
    //   96: ldc 183
    //   98: ldc 205
    //   100: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   107: aconst_null
    //   108: areturn
    //   109: aconst_null
    //   110: astore_2
    //   111: aload_0
    //   112: astore_3
    //   113: aload 5
    //   115: astore_0
    //   116: goto +668 -> 784
    //   119: aconst_null
    //   120: astore 4
    //   122: aload 4
    //   124: astore 5
    //   126: aload_0
    //   127: astore 6
    //   129: goto +269 -> 398
    //   132: aconst_null
    //   133: astore 4
    //   135: aload 4
    //   137: astore 5
    //   139: aload_0
    //   140: astore 6
    //   142: goto +382 -> 524
    //   145: aconst_null
    //   146: astore 4
    //   148: aload 4
    //   150: astore 5
    //   152: aload_0
    //   153: astore 6
    //   155: goto +495 -> 650
    //   158: aload_0
    //   159: invokevirtual 209	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   162: astore_2
    //   163: new 211	java/io/ByteArrayOutputStream
    //   166: dup
    //   167: invokespecial 212	java/io/ByteArrayOutputStream:<init>	()V
    //   170: astore_3
    //   171: sipush 1024
    //   174: newarray byte
    //   176: astore 4
    //   178: aload_2
    //   179: aload 4
    //   181: invokevirtual 218	java/io/InputStream:read	([B)I
    //   184: istore_1
    //   185: iload_1
    //   186: iconst_m1
    //   187: if_icmpeq +14 -> 201
    //   190: aload_3
    //   191: aload 4
    //   193: iconst_0
    //   194: iload_1
    //   195: invokevirtual 222	java/io/ByteArrayOutputStream:write	([BII)V
    //   198: goto -20 -> 178
    //   201: aload_3
    //   202: invokevirtual 226	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   205: astore 4
    //   207: ldc 183
    //   209: ldc 228
    //   211: invokestatic 159	com/tencent/mm/opensdk/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_0
    //   215: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   218: aload_2
    //   219: invokevirtual 231	java/io/InputStream:close	()V
    //   222: aload_3
    //   223: invokevirtual 232	java/io/ByteArrayOutputStream:close	()V
    //   226: aload 4
    //   228: areturn
    //   229: astore 4
    //   231: aload_2
    //   232: astore 5
    //   234: aload_3
    //   235: astore_2
    //   236: aload_0
    //   237: astore_3
    //   238: goto +537 -> 775
    //   241: astore 7
    //   243: aload_2
    //   244: astore 4
    //   246: aload_3
    //   247: astore 5
    //   249: aload_0
    //   250: astore 6
    //   252: goto +146 -> 398
    //   255: astore 7
    //   257: aload_2
    //   258: astore 4
    //   260: aload_3
    //   261: astore 5
    //   263: aload_0
    //   264: astore 6
    //   266: goto +258 -> 524
    //   269: astore 7
    //   271: aload_2
    //   272: astore 4
    //   274: aload_3
    //   275: astore 5
    //   277: aload_0
    //   278: astore 6
    //   280: goto +370 -> 650
    //   283: astore 5
    //   285: aload_0
    //   286: astore_3
    //   287: aload 5
    //   289: astore_0
    //   290: goto +494 -> 784
    //   293: astore_3
    //   294: aload_2
    //   295: astore 4
    //   297: aload_3
    //   298: astore_2
    //   299: aload_0
    //   300: astore 6
    //   302: aload_2
    //   303: astore_0
    //   304: goto +88 -> 392
    //   307: astore_3
    //   308: aload_2
    //   309: astore 4
    //   311: aload_3
    //   312: astore_2
    //   313: aload_0
    //   314: astore 6
    //   316: aload_2
    //   317: astore_0
    //   318: goto +200 -> 518
    //   321: astore_3
    //   322: aload_2
    //   323: astore 4
    //   325: aload_3
    //   326: astore_2
    //   327: aload_0
    //   328: astore 6
    //   330: aload_2
    //   331: astore_0
    //   332: goto +312 -> 644
    //   335: astore 5
    //   337: goto -228 -> 109
    //   340: astore_2
    //   341: aconst_null
    //   342: astore 4
    //   344: aload_0
    //   345: astore 6
    //   347: aload_2
    //   348: astore_0
    //   349: goto +43 -> 392
    //   352: astore_2
    //   353: aconst_null
    //   354: astore 4
    //   356: aload_0
    //   357: astore 6
    //   359: aload_2
    //   360: astore_0
    //   361: goto +157 -> 518
    //   364: astore_2
    //   365: aconst_null
    //   366: astore 4
    //   368: aload_0
    //   369: astore 6
    //   371: aload_2
    //   372: astore_0
    //   373: goto +271 -> 644
    //   376: astore_0
    //   377: aconst_null
    //   378: astore_3
    //   379: aload_3
    //   380: astore_2
    //   381: goto +403 -> 784
    //   384: astore_0
    //   385: aconst_null
    //   386: astore 6
    //   388: aload 6
    //   390: astore 4
    //   392: aconst_null
    //   393: astore 5
    //   395: aload_0
    //   396: astore 7
    //   398: aload 4
    //   400: astore_0
    //   401: aload 5
    //   403: astore_3
    //   404: aload 6
    //   406: astore_2
    //   407: new 46	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   414: astore 8
    //   416: aload 4
    //   418: astore_0
    //   419: aload 5
    //   421: astore_3
    //   422: aload 6
    //   424: astore_2
    //   425: aload 8
    //   427: ldc 234
    //   429: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 4
    //   435: astore_0
    //   436: aload 5
    //   438: astore_3
    //   439: aload 6
    //   441: astore_2
    //   442: aload 8
    //   444: aload 7
    //   446: invokevirtual 60	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 4
    //   455: astore_0
    //   456: aload 5
    //   458: astore_3
    //   459: aload 6
    //   461: astore_2
    //   462: ldc 183
    //   464: aload 8
    //   466: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload 6
    //   474: ifnull +11 -> 485
    //   477: aload 6
    //   479: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   482: goto +3 -> 485
    //   485: aload 4
    //   487: ifnull +11 -> 498
    //   490: aload 4
    //   492: invokevirtual 231	java/io/InputStream:close	()V
    //   495: goto +3 -> 498
    //   498: aload 5
    //   500: ifnull +8 -> 508
    //   503: aload 5
    //   505: invokevirtual 232	java/io/ByteArrayOutputStream:close	()V
    //   508: aconst_null
    //   509: areturn
    //   510: astore_0
    //   511: aconst_null
    //   512: astore 6
    //   514: aload 6
    //   516: astore 4
    //   518: aconst_null
    //   519: astore 5
    //   521: aload_0
    //   522: astore 7
    //   524: aload 4
    //   526: astore_0
    //   527: aload 5
    //   529: astore_3
    //   530: aload 6
    //   532: astore_2
    //   533: new 46	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   540: astore 8
    //   542: aload 4
    //   544: astore_0
    //   545: aload 5
    //   547: astore_3
    //   548: aload 6
    //   550: astore_2
    //   551: aload 8
    //   553: ldc 234
    //   555: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 4
    //   561: astore_0
    //   562: aload 5
    //   564: astore_3
    //   565: aload 6
    //   567: astore_2
    //   568: aload 8
    //   570: aload 7
    //   572: invokevirtual 235	java/io/IOException:getMessage	()Ljava/lang/String;
    //   575: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload 4
    //   581: astore_0
    //   582: aload 5
    //   584: astore_3
    //   585: aload 6
    //   587: astore_2
    //   588: ldc 183
    //   590: aload 8
    //   592: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload 6
    //   600: ifnull +11 -> 611
    //   603: aload 6
    //   605: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   608: goto +3 -> 611
    //   611: aload 4
    //   613: ifnull +11 -> 624
    //   616: aload 4
    //   618: invokevirtual 231	java/io/InputStream:close	()V
    //   621: goto +3 -> 624
    //   624: aload 5
    //   626: ifnull +8 -> 634
    //   629: aload 5
    //   631: invokevirtual 232	java/io/ByteArrayOutputStream:close	()V
    //   634: aconst_null
    //   635: areturn
    //   636: astore_0
    //   637: aconst_null
    //   638: astore 6
    //   640: aload 6
    //   642: astore 4
    //   644: aconst_null
    //   645: astore 5
    //   647: aload_0
    //   648: astore 7
    //   650: aload 4
    //   652: astore_0
    //   653: aload 5
    //   655: astore_3
    //   656: aload 6
    //   658: astore_2
    //   659: new 46	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   666: astore 8
    //   668: aload 4
    //   670: astore_0
    //   671: aload 5
    //   673: astore_3
    //   674: aload 6
    //   676: astore_2
    //   677: aload 8
    //   679: ldc 234
    //   681: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 4
    //   687: astore_0
    //   688: aload 5
    //   690: astore_3
    //   691: aload 6
    //   693: astore_2
    //   694: aload 8
    //   696: aload 7
    //   698: invokevirtual 236	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   701: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload 4
    //   707: astore_0
    //   708: aload 5
    //   710: astore_3
    //   711: aload 6
    //   713: astore_2
    //   714: ldc 183
    //   716: aload 8
    //   718: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload 6
    //   726: ifnull +11 -> 737
    //   729: aload 6
    //   731: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   734: goto +3 -> 737
    //   737: aload 4
    //   739: ifnull +11 -> 750
    //   742: aload 4
    //   744: invokevirtual 231	java/io/InputStream:close	()V
    //   747: goto +3 -> 750
    //   750: aload 5
    //   752: ifnull +8 -> 760
    //   755: aload 5
    //   757: invokevirtual 232	java/io/ByteArrayOutputStream:close	()V
    //   760: aconst_null
    //   761: areturn
    //   762: astore 4
    //   764: aload_3
    //   765: astore 6
    //   767: aload_2
    //   768: astore_3
    //   769: aload_0
    //   770: astore 5
    //   772: aload 6
    //   774: astore_2
    //   775: aload 4
    //   777: astore_0
    //   778: aload_2
    //   779: astore 4
    //   781: aload 5
    //   783: astore_2
    //   784: aload_3
    //   785: ifnull +10 -> 795
    //   788: aload_3
    //   789: invokevirtual 188	java/net/HttpURLConnection:disconnect	()V
    //   792: goto +3 -> 795
    //   795: aload_2
    //   796: ifnull +10 -> 806
    //   799: aload_2
    //   800: invokevirtual 231	java/io/InputStream:close	()V
    //   803: goto +3 -> 806
    //   806: aload 4
    //   808: ifnull +8 -> 816
    //   811: aload 4
    //   813: invokevirtual 232	java/io/ByteArrayOutputStream:close	()V
    //   816: aload_0
    //   817: athrow
    //   818: ldc 183
    //   820: ldc 238
    //   822: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: aconst_null
    //   826: areturn
    //   827: astore_0
    //   828: aconst_null
    //   829: areturn
    //   830: astore_0
    //   831: aconst_null
    //   832: areturn
    //   833: astore_0
    //   834: goto -616 -> 218
    //   837: astore_0
    //   838: goto -616 -> 222
    //   841: astore_0
    //   842: aload 4
    //   844: areturn
    //   845: astore_0
    //   846: goto -361 -> 485
    //   849: astore_0
    //   850: goto -352 -> 498
    //   853: astore_0
    //   854: aconst_null
    //   855: areturn
    //   856: astore_0
    //   857: goto -246 -> 611
    //   860: astore_0
    //   861: goto -237 -> 624
    //   864: astore_0
    //   865: aconst_null
    //   866: areturn
    //   867: astore_0
    //   868: goto -131 -> 737
    //   871: astore_0
    //   872: goto -122 -> 750
    //   875: astore_0
    //   876: aconst_null
    //   877: areturn
    //   878: astore_3
    //   879: goto -84 -> 795
    //   882: astore_2
    //   883: goto -77 -> 806
    //   886: astore_2
    //   887: goto -71 -> 816
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	890	0	paramString	String
    //   0	890	1	paramInt	int
    //   110	221	2	localObject1	Object
    //   340	8	2	localException1	Exception
    //   352	8	2	localIOException1	java.io.IOException
    //   364	8	2	localMalformedURLException1	java.net.MalformedURLException
    //   380	420	2	localObject2	Object
    //   882	1	2	localObject3	Object
    //   886	1	2	localObject4	Object
    //   112	175	3	localObject5	Object
    //   293	5	3	localException2	Exception
    //   307	5	3	localIOException2	java.io.IOException
    //   321	5	3	localMalformedURLException2	java.net.MalformedURLException
    //   378	411	3	localObject6	Object
    //   878	1	3	localObject7	Object
    //   1	226	4	arrayOfByte	byte[]
    //   229	1	4	localObject8	Object
    //   244	499	4	localObject9	Object
    //   762	14	4	localObject10	Object
    //   779	64	4	localObject11	Object
    //   113	163	5	localObject12	Object
    //   283	5	5	localObject13	Object
    //   335	1	5	localObject14	Object
    //   393	389	5	str1	String
    //   127	646	6	localObject15	Object
    //   53	1	7	localException3	Exception
    //   58	1	7	localIOException3	java.io.IOException
    //   63	1	7	localMalformedURLException3	java.net.MalformedURLException
    //   241	1	7	localException4	Exception
    //   255	1	7	localIOException4	java.io.IOException
    //   269	1	7	localMalformedURLException4	java.net.MalformedURLException
    //   396	301	7	str2	String
    //   414	303	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	43	53	java/lang/Exception
    //   96	103	53	java/lang/Exception
    //   36	43	58	java/io/IOException
    //   96	103	58	java/io/IOException
    //   36	43	63	java/net/MalformedURLException
    //   96	103	63	java/net/MalformedURLException
    //   171	178	229	finally
    //   178	185	229	finally
    //   190	198	229	finally
    //   201	214	229	finally
    //   171	178	241	java/lang/Exception
    //   178	185	241	java/lang/Exception
    //   190	198	241	java/lang/Exception
    //   201	214	241	java/lang/Exception
    //   171	178	255	java/io/IOException
    //   178	185	255	java/io/IOException
    //   190	198	255	java/io/IOException
    //   201	214	255	java/io/IOException
    //   171	178	269	java/net/MalformedURLException
    //   178	185	269	java/net/MalformedURLException
    //   190	198	269	java/net/MalformedURLException
    //   201	214	269	java/net/MalformedURLException
    //   163	171	283	finally
    //   163	171	293	java/lang/Exception
    //   163	171	307	java/io/IOException
    //   163	171	321	java/net/MalformedURLException
    //   36	43	335	finally
    //   68	89	335	finally
    //   96	103	335	finally
    //   158	163	335	finally
    //   68	89	340	java/lang/Exception
    //   158	163	340	java/lang/Exception
    //   68	89	352	java/io/IOException
    //   158	163	352	java/io/IOException
    //   68	89	364	java/net/MalformedURLException
    //   158	163	364	java/net/MalformedURLException
    //   17	32	376	finally
    //   17	32	384	java/lang/Exception
    //   17	32	510	java/io/IOException
    //   17	32	636	java/net/MalformedURLException
    //   407	416	762	finally
    //   425	433	762	finally
    //   442	453	762	finally
    //   462	472	762	finally
    //   533	542	762	finally
    //   551	559	762	finally
    //   568	579	762	finally
    //   588	598	762	finally
    //   659	668	762	finally
    //   677	685	762	finally
    //   694	705	762	finally
    //   714	724	762	finally
    //   47	51	827	finally
    //   103	107	830	finally
    //   214	218	833	finally
    //   218	222	837	finally
    //   222	226	841	finally
    //   477	482	845	finally
    //   490	495	849	finally
    //   503	508	853	finally
    //   603	608	856	finally
    //   616	621	860	finally
    //   629	634	864	finally
    //   729	734	867	finally
    //   742	747	871	finally
    //   755	760	875	finally
    //   788	792	878	finally
    //   799	803	882	finally
    //   811	816	886	finally
  }
  
  public static byte[] a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = new StringBuffer();
    if (paramString1 != null) {
      ((StringBuffer)localObject).append(paramString1);
    }
    ((StringBuffer)localObject).append(paramInt);
    ((StringBuffer)localObject).append(paramString2);
    ((StringBuffer)localObject).append("mMcShCsTr");
    paramString2 = ((StringBuffer)localObject).toString().substring(1, 9).getBytes();
    paramString1 = new char[16];
    paramString1[0] = 48;
    paramString1[1] = 49;
    paramString1[2] = 50;
    paramString1[3] = 51;
    paramString1[4] = 52;
    paramString1[5] = 53;
    paramString1[6] = 54;
    paramString1[7] = 55;
    paramString1[8] = 56;
    paramString1[9] = 57;
    paramString1[10] = 97;
    paramString1[11] = 98;
    paramString1[12] = 99;
    paramString1[13] = 100;
    paramString1[14] = 101;
    paramString1[15] = 102;
    paramString1;
    for (;;)
    {
      int j;
      int i;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString2);
        paramString2 = ((MessageDigest)localObject).digest();
        j = paramString2.length;
        localObject = new char[j * 2];
        paramInt = 0;
        i = 0;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      paramString1 = new String((char[])localObject);
      continue;
      paramString1 = null;
      return paramString1.getBytes();
      while (paramInt < j)
      {
        int k = paramString2[paramInt];
        int m = i + 1;
        localObject[i] = paramString1[(k >>> 4 & 0xF)];
        i = m + 1;
        localObject[m] = paramString1[(k & 0xF)];
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.a.a
 * JD-Core Version:    0.7.0.1
 */