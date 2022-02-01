package c.t.m.g;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.TimerTask;
import org.json.JSONObject;

final class cz$a
  extends TimerTask
{
  private final JSONObject a = new JSONObject();
  private da b = null;
  private db c = null;
  
  public cz$a(cz paramcz) {}
  
  private JSONObject a()
  {
    if (cz.c(this.d) == null) {
      return this.a;
    }
    Object localObject1 = "https://cc.map.qq.com/?get_c3";
    if (!cz.d(this.d)) {
      localObject1 = "https://cc.map.qq.com/?get_c3".replace("https:", "http:");
    }
    co.a("cc_url:".concat(String.valueOf(localObject1)));
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cc_version", this.b.e("cc_version"));
      ((JSONObject)localObject2).put("m_module", da.a);
      ((JSONObject)localObject2).put("m_channel", da.b);
      ((JSONObject)localObject2).put("m_version", da.c);
      ((JSONObject)localObject2).put("imei", dz.a());
      localObject2 = dr.a(((JSONObject)localObject2).toString(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
      co.a("req:".concat(String.valueOf(localObject2)));
      localObject1 = cz.c(this.d).a((String)localObject1, ((String)localObject2).getBytes(), null);
      localObject2 = ((Bundle)localObject1).getString("msg_suc", "");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = ((Bundle)localObject1).getString("msg_fail", "");
        localObject2 = new StringBuilder("net work error! res = [");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        co.a(((StringBuilder)localObject2).toString());
        return this.a;
      }
      co.a("res:".concat(String.valueOf(localObject2)));
      localObject1 = this.a.toString();
      if (((String)localObject1).equals(localObject2))
      {
        co.a("network or server error,response empty json");
      }
      else
      {
        co.a("start dec");
        localObject1 = dr.b((String)localObject2, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
        co.a("end dec");
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return this.a;
      }
      localObject1 = new JSONObject((String)localObject1);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      co.a(localThrowable.getMessage(), localThrowable);
    }
    return this.a;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	c/t/m/g/cz$a:b	Lc/t/m/g/da;
    //   4: ldc 183
    //   6: invokevirtual 186	c/t/m/g/da:c	(Ljava/lang/String;)J
    //   9: lstore_3
    //   10: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   13: lload_3
    //   14: lsub
    //   15: invokestatic 198	java/lang/Math:abs	(J)J
    //   18: invokestatic 200	c/t/m/g/cz:d	()J
    //   21: lcmp
    //   22: iflt +495 -> 517
    //   25: aload_0
    //   26: getfield 16	c/t/m/g/cz$a:d	Lc/t/m/g/cz;
    //   29: invokestatic 202	c/t/m/g/cz:a	(Lc/t/m/g/cz;)Z
    //   32: istore 7
    //   34: iload 7
    //   36: ifeq +10 -> 46
    //   39: aload_0
    //   40: getfield 28	c/t/m/g/cz$a:c	Lc/t/m/g/db;
    //   43: invokevirtual 204	c/t/m/g/db:c	()V
    //   46: invokestatic 210	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   49: iconst_1
    //   50: invokevirtual 214	java/lang/Thread:setPriority	(I)V
    //   53: aload_0
    //   54: invokespecial 216	c/t/m/g/cz$a:a	()Lorg/json/JSONObject;
    //   57: astore 8
    //   59: aload 8
    //   61: aload_0
    //   62: getfield 24	c/t/m/g/cz$a:a	Lorg/json/JSONObject;
    //   65: if_acmpeq +366 -> 431
    //   68: aload 8
    //   70: ldc 218
    //   72: ldc 220
    //   74: invokevirtual 223	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 229	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: istore_1
    //   81: ldc 231
    //   83: iload_1
    //   84: invokestatic 234	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   87: invokevirtual 72	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokestatic 77	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   93: iload_1
    //   94: ifeq +6 -> 100
    //   97: goto +274 -> 371
    //   100: aload 8
    //   102: ldc 236
    //   104: invokevirtual 240	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   107: ifeq +264 -> 371
    //   110: aload_0
    //   111: getfield 28	c/t/m/g/cz$a:c	Lc/t/m/g/db;
    //   114: invokevirtual 243	c/t/m/g/db:b	()Landroid/content/SharedPreferences;
    //   117: astore 10
    //   119: aload 10
    //   121: ifnull +250 -> 371
    //   124: aload_0
    //   125: getfield 26	c/t/m/g/cz$a:b	Lc/t/m/g/da;
    //   128: ldc 79
    //   130: invokevirtual 245	c/t/m/g/da:b	(Ljava/lang/String;)I
    //   133: istore_2
    //   134: aload 8
    //   136: ldc 236
    //   138: aload_0
    //   139: getfield 26	c/t/m/g/cz$a:b	Lc/t/m/g/da;
    //   142: ldc 79
    //   144: invokevirtual 82	c/t/m/g/da:e	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokevirtual 223	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: invokestatic 229	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   153: istore_1
    //   154: goto +5 -> 159
    //   157: iload_2
    //   158: istore_1
    //   159: iload_1
    //   160: iload_2
    //   161: if_icmpne +11 -> 172
    //   164: ldc 247
    //   166: invokestatic 77	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   169: goto +202 -> 371
    //   172: aload 8
    //   174: ldc 249
    //   176: invokevirtual 253	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   179: astore 9
    //   181: aload 9
    //   183: astore 8
    //   185: aload 9
    //   187: ifnonnull +9 -> 196
    //   190: aload_0
    //   191: getfield 24	c/t/m/g/cz$a:a	Lorg/json/JSONObject;
    //   194: astore 8
    //   196: aload 10
    //   198: invokeinterface 259 1 0
    //   203: astore 9
    //   205: aload 8
    //   207: invokevirtual 263	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   210: astore 10
    //   212: aload 10
    //   214: invokeinterface 269 1 0
    //   219: ifeq +77 -> 296
    //   222: aload 10
    //   224: invokeinterface 273 1 0
    //   229: checkcast 58	java/lang/String
    //   232: astore 11
    //   234: aload_0
    //   235: getfield 26	c/t/m/g/cz$a:b	Lc/t/m/g/da;
    //   238: aload 11
    //   240: invokevirtual 82	c/t/m/g/da:e	(Ljava/lang/String;)Ljava/lang/String;
    //   243: astore 12
    //   245: aload 12
    //   247: ifnull -35 -> 212
    //   250: aload 12
    //   252: invokevirtual 277	java/lang/String:length	()I
    //   255: ifne +6 -> 261
    //   258: goto -46 -> 212
    //   261: aload 9
    //   263: aload 11
    //   265: aload 8
    //   267: aload 11
    //   269: aload 12
    //   271: invokevirtual 223	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   274: invokeinterface 283 3 0
    //   279: pop
    //   280: goto -68 -> 212
    //   283: astore 11
    //   285: aload 11
    //   287: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   290: invokestatic 286	c/t/m/g/co:b	(Ljava/lang/String;)V
    //   293: goto -81 -> 212
    //   296: aload 9
    //   298: ldc 79
    //   300: iload_1
    //   301: invokestatic 234	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   304: invokeinterface 283 3 0
    //   309: pop
    //   310: aload 8
    //   312: ldc_w 288
    //   315: aload_0
    //   316: getfield 26	c/t/m/g/cz$a:b	Lc/t/m/g/da;
    //   319: ldc_w 288
    //   322: invokevirtual 82	c/t/m/g/da:e	(Ljava/lang/String;)Ljava/lang/String;
    //   325: invokevirtual 223	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   328: invokestatic 293	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   331: lstore 5
    //   333: lload 5
    //   335: ldc2_w 294
    //   338: lcmp
    //   339: ifge +225 -> 564
    //   342: ldc2_w 294
    //   345: lstore_3
    //   346: goto +3 -> 349
    //   349: aload 9
    //   351: ldc_w 288
    //   354: lload_3
    //   355: invokestatic 298	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   358: invokeinterface 283 3 0
    //   363: pop
    //   364: aload 9
    //   366: invokeinterface 301 1 0
    //   371: invokestatic 192	java/lang/System:currentTimeMillis	()J
    //   374: lstore_3
    //   375: aload_0
    //   376: getfield 28	c/t/m/g/cz$a:c	Lc/t/m/g/db;
    //   379: invokevirtual 243	c/t/m/g/db:b	()Landroid/content/SharedPreferences;
    //   382: astore 8
    //   384: aload 8
    //   386: ifnull +33 -> 419
    //   389: aload 8
    //   391: invokeinterface 259 1 0
    //   396: astore 8
    //   398: aload 8
    //   400: ldc 183
    //   402: lload_3
    //   403: invokestatic 298	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   406: invokeinterface 283 3 0
    //   411: pop
    //   412: aload 8
    //   414: invokeinterface 301 1 0
    //   419: ldc2_w 302
    //   422: invokestatic 307	java/lang/Thread:sleep	(J)V
    //   425: ldc_w 309
    //   428: invokestatic 77	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 26	c/t/m/g/cz$a:b	Lc/t/m/g/da;
    //   435: invokevirtual 311	c/t/m/g/da:b	()V
    //   438: iload 7
    //   440: ifeq +83 -> 523
    //   443: aload_0
    //   444: getfield 28	c/t/m/g/cz$a:c	Lc/t/m/g/db;
    //   447: astore 8
    //   449: aload 8
    //   451: invokevirtual 313	c/t/m/g/db:d	()V
    //   454: goto +69 -> 523
    //   457: astore 8
    //   459: goto +36 -> 495
    //   462: astore 8
    //   464: aload 8
    //   466: invokevirtual 175	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   469: aload 8
    //   471: invokestatic 178	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   474: aload_0
    //   475: getfield 26	c/t/m/g/cz$a:b	Lc/t/m/g/da;
    //   478: invokevirtual 311	c/t/m/g/da:b	()V
    //   481: iload 7
    //   483: ifeq +40 -> 523
    //   486: aload_0
    //   487: getfield 28	c/t/m/g/cz$a:c	Lc/t/m/g/db;
    //   490: astore 8
    //   492: goto -43 -> 449
    //   495: aload_0
    //   496: getfield 26	c/t/m/g/cz$a:b	Lc/t/m/g/da;
    //   499: invokevirtual 311	c/t/m/g/da:b	()V
    //   502: iload 7
    //   504: ifeq +10 -> 514
    //   507: aload_0
    //   508: getfield 28	c/t/m/g/cz$a:c	Lc/t/m/g/db;
    //   511: invokevirtual 313	c/t/m/g/db:d	()V
    //   514: aload 8
    //   516: athrow
    //   517: ldc_w 315
    //   520: invokestatic 77	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   523: aload_0
    //   524: getfield 16	c/t/m/g/cz$a:d	Lc/t/m/g/cz;
    //   527: invokestatic 202	c/t/m/g/cz:a	(Lc/t/m/g/cz;)Z
    //   530: ifeq +10 -> 540
    //   533: aload_0
    //   534: getfield 16	c/t/m/g/cz$a:d	Lc/t/m/g/cz;
    //   537: invokestatic 317	c/t/m/g/cz:b	(Lc/t/m/g/cz;)V
    //   540: return
    //   541: astore 8
    //   543: aload 8
    //   545: invokevirtual 175	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   548: aload 8
    //   550: invokestatic 178	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   553: return
    //   554: astore 9
    //   556: goto -399 -> 157
    //   559: astore 8
    //   561: goto -197 -> 364
    //   564: lload 5
    //   566: lstore_3
    //   567: lload 5
    //   569: ldc2_w 318
    //   572: lcmp
    //   573: ifle -224 -> 349
    //   576: ldc2_w 318
    //   579: lstore_3
    //   580: goto -231 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	a
    //   80	221	1	i	int
    //   133	29	2	j	int
    //   9	571	3	l1	long
    //   331	237	5	l2	long
    //   32	471	7	bool	boolean
    //   57	393	8	localObject1	Object
    //   457	1	8	localObject2	Object
    //   462	8	8	localThrowable1	Throwable
    //   490	25	8	localdb	db
    //   541	8	8	localThrowable2	Throwable
    //   559	1	8	localThrowable3	Throwable
    //   179	186	9	localObject3	Object
    //   554	1	9	localThrowable4	Throwable
    //   117	106	10	localObject4	Object
    //   232	36	11	str1	String
    //   283	3	11	localException	java.lang.Exception
    //   243	27	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   234	245	283	java/lang/Exception
    //   250	258	283	java/lang/Exception
    //   261	280	283	java/lang/Exception
    //   39	46	457	finally
    //   46	93	457	finally
    //   100	119	457	finally
    //   124	134	457	finally
    //   134	154	457	finally
    //   164	169	457	finally
    //   172	181	457	finally
    //   190	196	457	finally
    //   196	212	457	finally
    //   212	234	457	finally
    //   234	245	457	finally
    //   250	258	457	finally
    //   261	280	457	finally
    //   285	293	457	finally
    //   296	310	457	finally
    //   310	333	457	finally
    //   349	364	457	finally
    //   364	371	457	finally
    //   371	384	457	finally
    //   389	419	457	finally
    //   419	431	457	finally
    //   464	474	457	finally
    //   39	46	462	java/lang/Throwable
    //   46	93	462	java/lang/Throwable
    //   100	119	462	java/lang/Throwable
    //   124	134	462	java/lang/Throwable
    //   164	169	462	java/lang/Throwable
    //   172	181	462	java/lang/Throwable
    //   190	196	462	java/lang/Throwable
    //   196	212	462	java/lang/Throwable
    //   212	234	462	java/lang/Throwable
    //   234	245	462	java/lang/Throwable
    //   250	258	462	java/lang/Throwable
    //   261	280	462	java/lang/Throwable
    //   285	293	462	java/lang/Throwable
    //   296	310	462	java/lang/Throwable
    //   364	371	462	java/lang/Throwable
    //   371	384	462	java/lang/Throwable
    //   389	419	462	java/lang/Throwable
    //   419	431	462	java/lang/Throwable
    //   0	34	541	java/lang/Throwable
    //   431	438	541	java/lang/Throwable
    //   443	449	541	java/lang/Throwable
    //   449	454	541	java/lang/Throwable
    //   474	481	541	java/lang/Throwable
    //   486	492	541	java/lang/Throwable
    //   495	502	541	java/lang/Throwable
    //   507	514	541	java/lang/Throwable
    //   514	517	541	java/lang/Throwable
    //   517	523	541	java/lang/Throwable
    //   523	540	541	java/lang/Throwable
    //   134	154	554	java/lang/Throwable
    //   310	333	559	java/lang/Throwable
    //   349	364	559	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cz.a
 * JD-Core Version:    0.7.0.1
 */