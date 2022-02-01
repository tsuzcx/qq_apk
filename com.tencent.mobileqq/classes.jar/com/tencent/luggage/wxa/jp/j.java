package com.tencent.luggage.wxa.jp;

import android.util.Log;
import android.util.Xml;
import com.tencent.luggage.wxa.jr.a;
import com.tencent.luggage.wxa.jr.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class j
{
  private XmlPullParser a = Xml.newPullParser();
  
  public static j a()
  {
    return new j();
  }
  
  public b a(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      return null;
    }
    if ((paramString.startsWith("NOTIFY")) || (paramString.startsWith("HTTP")))
    {
      b localb = new b();
      paramString = paramString.split("\r\n");
      if (paramString.length > 0)
      {
        localObject = paramString[0].split(" ");
        if (localObject[0].startsWith("HTTP"))
        {
          localb.a("VERSION", localObject[0]);
          localb.a("RESPONSE_CODE", localObject[1]);
          localb.a("RESPONSE_DESCRIPTION", localObject[2]);
        }
        else
        {
          localb.a("METHOD", localObject[0]);
          localb.a("PATH", localObject[1]);
          localb.a("VERSION", localObject[2]);
        }
      }
      int i = 1;
      for (;;)
      {
        localObject = localb;
        if (i >= paramString.length) {
          break;
        }
        localObject = paramString[i];
        int j = ((String)localObject).indexOf(":");
        localb.a(((String)localObject).substring(0, j).toUpperCase(), ((String)localObject).substring(j + 1, ((String)localObject).length()).trim());
        i += 1;
      }
    }
    return localObject;
  }
  
  public HashMap<String, a> a(InputStream paramInputStream)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      int i;
      try
      {
        this.a.setInput(paramInputStream, "utf-8");
        this.a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        i = this.a.getEventType();
        if (i != 1)
        {
          paramInputStream = this.a.getName();
          if (paramInputStream != null) {
            break label348;
          }
          i = this.a.next();
          continue;
          Object localObject = new a();
          int j = this.a.getAttributeCount();
          i = 0;
          String str1;
          if (i < j)
          {
            str1 = this.a.getAttributeName(i);
            String str2 = this.a.getAttributeValue(i);
            ((a)localObject).a(str1, str2);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("attrName=");
            localStringBuilder.append(str1);
            localStringBuilder.append(", attrVal=");
            localStringBuilder.append(str2);
            Log.d("UpnpParser", localStringBuilder.toString());
            i += 1;
            continue;
          }
          i = this.a.next();
          if (i == 2)
          {
            localHashMap.put(paramInputStream, localObject);
            continue;
          }
          if (i == 4)
          {
            str1 = this.a.getText().trim();
            ((a)localObject).a(str1);
            localHashMap.put(paramInputStream, localObject);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("name=");
            ((StringBuilder)localObject).append(paramInputStream);
            ((StringBuilder)localObject).append(", value=");
            ((StringBuilder)localObject).append(str1);
            Log.d("UpnpParser", ((StringBuilder)localObject).toString());
          }
          else if (i == 3)
          {
            localHashMap.put(paramInputStream, localObject);
          }
          i = this.a.next();
          continue;
          paramInputStream.printStackTrace();
        }
      }
      catch (IOException paramInputStream) {}catch (XmlPullParserException paramInputStream) {}
      return localHashMap;
      label348:
      if (i == 2) {}
    }
  }
  
  /* Error */
  public com.tencent.luggage.wxa.jo.b b(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   7: aload_1
    //   8: ldc 87
    //   10: invokeinterface 93 3 0
    //   15: aload_0
    //   16: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   19: invokeinterface 102 1 0
    //   24: istore_2
    //   25: new 169	com/tencent/luggage/wxa/jo/b
    //   28: dup
    //   29: invokespecial 170	com/tencent/luggage/wxa/jo/b:<init>	()V
    //   32: astore_3
    //   33: aconst_null
    //   34: astore 4
    //   36: aload_3
    //   37: astore_1
    //   38: iload_2
    //   39: iconst_1
    //   40: if_icmpeq +545 -> 585
    //   43: iload_2
    //   44: iconst_2
    //   45: if_icmpeq +57 -> 102
    //   48: iload_2
    //   49: iconst_3
    //   50: if_icmpeq +9 -> 59
    //   53: aload 4
    //   55: astore_1
    //   56: goto +478 -> 534
    //   59: aload 4
    //   61: astore_1
    //   62: ldc 172
    //   64: aload_0
    //   65: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   68: invokeinterface 105 1 0
    //   73: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   76: ifeq +458 -> 534
    //   79: aload 4
    //   81: astore_1
    //   82: aload 4
    //   84: ifnull +450 -> 534
    //   87: aload_3
    //   88: getfield 179	com/tencent/luggage/wxa/jo/b:l	Ljava/util/ArrayList;
    //   91: aload 4
    //   93: invokevirtual 185	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   96: pop
    //   97: aconst_null
    //   98: astore_1
    //   99: goto +435 -> 534
    //   102: aload_0
    //   103: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   106: invokeinterface 105 1 0
    //   111: astore 5
    //   113: ldc 187
    //   115: aload 5
    //   117: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   120: ifeq +40 -> 160
    //   123: aload_0
    //   124: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   127: invokeinterface 190 1 0
    //   132: astore 5
    //   134: aload 4
    //   136: astore_1
    //   137: aload 5
    //   139: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne +392 -> 534
    //   145: aload_3
    //   146: aload 5
    //   148: invokestatic 201	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   151: putfield 204	com/tencent/luggage/wxa/jo/b:d	I
    //   154: aload 4
    //   156: astore_1
    //   157: goto +377 -> 534
    //   160: ldc 206
    //   162: aload 5
    //   164: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   167: ifeq +40 -> 207
    //   170: aload_0
    //   171: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   174: invokeinterface 190 1 0
    //   179: astore 5
    //   181: aload 4
    //   183: astore_1
    //   184: aload 5
    //   186: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +345 -> 534
    //   192: aload_3
    //   193: aload 5
    //   195: invokestatic 201	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   198: putfield 209	com/tencent/luggage/wxa/jo/b:e	I
    //   201: aload 4
    //   203: astore_1
    //   204: goto +330 -> 534
    //   207: ldc 211
    //   209: aload 5
    //   211: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   214: ifeq +22 -> 236
    //   217: aload_3
    //   218: aload_0
    //   219: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   222: invokeinterface 190 1 0
    //   227: putfield 215	com/tencent/luggage/wxa/jo/b:f	Ljava/lang/String;
    //   230: aload 4
    //   232: astore_1
    //   233: goto +301 -> 534
    //   236: ldc 217
    //   238: aload 5
    //   240: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   243: ifeq +22 -> 265
    //   246: aload_3
    //   247: aload_0
    //   248: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   251: invokeinterface 190 1 0
    //   256: putfield 220	com/tencent/luggage/wxa/jo/b:g	Ljava/lang/String;
    //   259: aload 4
    //   261: astore_1
    //   262: goto +272 -> 534
    //   265: ldc 222
    //   267: aload 5
    //   269: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   272: ifeq +22 -> 294
    //   275: aload_3
    //   276: aload_0
    //   277: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   280: invokeinterface 190 1 0
    //   285: putfield 225	com/tencent/luggage/wxa/jo/b:j	Ljava/lang/String;
    //   288: aload 4
    //   290: astore_1
    //   291: goto +243 -> 534
    //   294: ldc 227
    //   296: aload 5
    //   298: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   301: ifeq +22 -> 323
    //   304: aload_3
    //   305: aload_0
    //   306: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   309: invokeinterface 190 1 0
    //   314: putfield 230	com/tencent/luggage/wxa/jo/b:h	Ljava/lang/String;
    //   317: aload 4
    //   319: astore_1
    //   320: goto +214 -> 534
    //   323: ldc 172
    //   325: aload 5
    //   327: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   330: ifeq +14 -> 344
    //   333: new 232	com/tencent/luggage/wxa/jo/f
    //   336: dup
    //   337: invokespecial 233	com/tencent/luggage/wxa/jo/f:<init>	()V
    //   340: astore_1
    //   341: goto +193 -> 534
    //   344: ldc 235
    //   346: aload 5
    //   348: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   351: ifeq +31 -> 382
    //   354: aload 4
    //   356: astore_1
    //   357: aload 4
    //   359: ifnull +175 -> 534
    //   362: aload 4
    //   364: aload_0
    //   365: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   368: invokeinterface 190 1 0
    //   373: putfield 237	com/tencent/luggage/wxa/jo/f:a	Ljava/lang/String;
    //   376: aload 4
    //   378: astore_1
    //   379: goto +155 -> 534
    //   382: ldc 239
    //   384: aload 5
    //   386: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   389: ifeq +31 -> 420
    //   392: aload 4
    //   394: astore_1
    //   395: aload 4
    //   397: ifnull +137 -> 534
    //   400: aload 4
    //   402: aload_0
    //   403: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   406: invokeinterface 190 1 0
    //   411: putfield 241	com/tencent/luggage/wxa/jo/f:b	Ljava/lang/String;
    //   414: aload 4
    //   416: astore_1
    //   417: goto +117 -> 534
    //   420: ldc 243
    //   422: aload 5
    //   424: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   427: ifeq +31 -> 458
    //   430: aload 4
    //   432: astore_1
    //   433: aload 4
    //   435: ifnull +99 -> 534
    //   438: aload 4
    //   440: aload_0
    //   441: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   444: invokeinterface 190 1 0
    //   449: putfield 245	com/tencent/luggage/wxa/jo/f:d	Ljava/lang/String;
    //   452: aload 4
    //   454: astore_1
    //   455: goto +79 -> 534
    //   458: ldc 247
    //   460: aload 5
    //   462: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   465: ifeq +31 -> 496
    //   468: aload 4
    //   470: astore_1
    //   471: aload 4
    //   473: ifnull +61 -> 534
    //   476: aload 4
    //   478: aload_0
    //   479: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   482: invokeinterface 190 1 0
    //   487: putfield 249	com/tencent/luggage/wxa/jo/f:e	Ljava/lang/String;
    //   490: aload 4
    //   492: astore_1
    //   493: goto +41 -> 534
    //   496: aload 4
    //   498: astore_1
    //   499: ldc 251
    //   501: aload 5
    //   503: invokevirtual 175	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   506: ifeq +28 -> 534
    //   509: aload 4
    //   511: astore_1
    //   512: aload 4
    //   514: ifnull +20 -> 534
    //   517: aload 4
    //   519: aload_0
    //   520: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   523: invokeinterface 190 1 0
    //   528: putfield 254	com/tencent/luggage/wxa/jo/f:c	Ljava/lang/String;
    //   531: aload 4
    //   533: astore_1
    //   534: aload_0
    //   535: getfield 18	com/tencent/luggage/wxa/jp/j:a	Lorg/xmlpull/v1/XmlPullParser;
    //   538: invokeinterface 108 1 0
    //   543: istore_2
    //   544: aload_1
    //   545: astore 4
    //   547: goto -511 -> 36
    //   550: astore 4
    //   552: aload_3
    //   553: astore_1
    //   554: aload 4
    //   556: astore_3
    //   557: goto +24 -> 581
    //   560: astore 4
    //   562: aload_3
    //   563: astore_1
    //   564: aload 4
    //   566: astore_3
    //   567: goto +14 -> 581
    //   570: astore_1
    //   571: goto +19 -> 590
    //   574: astore_3
    //   575: goto +4 -> 579
    //   578: astore_3
    //   579: aconst_null
    //   580: astore_1
    //   581: aload_3
    //   582: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   585: ldc 2
    //   587: monitorexit
    //   588: aload_1
    //   589: areturn
    //   590: ldc 2
    //   592: monitorexit
    //   593: goto +5 -> 598
    //   596: aload_1
    //   597: athrow
    //   598: goto -2 -> 596
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	j
    //   0	601	1	paramInputStream	InputStream
    //   24	520	2	i	int
    //   32	535	3	localObject1	Object
    //   574	1	3	localIOException1	IOException
    //   578	4	3	localXmlPullParserException1	XmlPullParserException
    //   34	512	4	localObject2	Object
    //   550	5	4	localIOException2	IOException
    //   560	5	4	localXmlPullParserException2	XmlPullParserException
    //   111	391	5	str	String
    // Exception table:
    //   from	to	target	type
    //   62	79	550	java/io/IOException
    //   87	97	550	java/io/IOException
    //   102	134	550	java/io/IOException
    //   137	154	550	java/io/IOException
    //   160	181	550	java/io/IOException
    //   184	201	550	java/io/IOException
    //   207	230	550	java/io/IOException
    //   236	259	550	java/io/IOException
    //   265	288	550	java/io/IOException
    //   294	317	550	java/io/IOException
    //   323	341	550	java/io/IOException
    //   344	354	550	java/io/IOException
    //   362	376	550	java/io/IOException
    //   382	392	550	java/io/IOException
    //   400	414	550	java/io/IOException
    //   420	430	550	java/io/IOException
    //   438	452	550	java/io/IOException
    //   458	468	550	java/io/IOException
    //   476	490	550	java/io/IOException
    //   499	509	550	java/io/IOException
    //   517	531	550	java/io/IOException
    //   534	544	550	java/io/IOException
    //   62	79	560	org/xmlpull/v1/XmlPullParserException
    //   87	97	560	org/xmlpull/v1/XmlPullParserException
    //   102	134	560	org/xmlpull/v1/XmlPullParserException
    //   137	154	560	org/xmlpull/v1/XmlPullParserException
    //   160	181	560	org/xmlpull/v1/XmlPullParserException
    //   184	201	560	org/xmlpull/v1/XmlPullParserException
    //   207	230	560	org/xmlpull/v1/XmlPullParserException
    //   236	259	560	org/xmlpull/v1/XmlPullParserException
    //   265	288	560	org/xmlpull/v1/XmlPullParserException
    //   294	317	560	org/xmlpull/v1/XmlPullParserException
    //   323	341	560	org/xmlpull/v1/XmlPullParserException
    //   344	354	560	org/xmlpull/v1/XmlPullParserException
    //   362	376	560	org/xmlpull/v1/XmlPullParserException
    //   382	392	560	org/xmlpull/v1/XmlPullParserException
    //   400	414	560	org/xmlpull/v1/XmlPullParserException
    //   420	430	560	org/xmlpull/v1/XmlPullParserException
    //   438	452	560	org/xmlpull/v1/XmlPullParserException
    //   458	468	560	org/xmlpull/v1/XmlPullParserException
    //   476	490	560	org/xmlpull/v1/XmlPullParserException
    //   499	509	560	org/xmlpull/v1/XmlPullParserException
    //   517	531	560	org/xmlpull/v1/XmlPullParserException
    //   534	544	560	org/xmlpull/v1/XmlPullParserException
    //   3	33	570	finally
    //   62	79	570	finally
    //   87	97	570	finally
    //   102	134	570	finally
    //   137	154	570	finally
    //   160	181	570	finally
    //   184	201	570	finally
    //   207	230	570	finally
    //   236	259	570	finally
    //   265	288	570	finally
    //   294	317	570	finally
    //   323	341	570	finally
    //   344	354	570	finally
    //   362	376	570	finally
    //   382	392	570	finally
    //   400	414	570	finally
    //   420	430	570	finally
    //   438	452	570	finally
    //   458	468	570	finally
    //   476	490	570	finally
    //   499	509	570	finally
    //   517	531	570	finally
    //   534	544	570	finally
    //   581	585	570	finally
    //   585	588	570	finally
    //   590	593	570	finally
    //   3	33	574	java/io/IOException
    //   3	33	578	org/xmlpull/v1/XmlPullParserException
  }
  
  public HashMap<String, a> b(String paramString)
  {
    return a(new ByteArrayInputStream(paramString.getBytes()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.j
 * JD-Core Version:    0.7.0.1
 */