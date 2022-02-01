package com.tencent.luggage.wxa.dc;

import android.os.Build.VERSION;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dd.g;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.ob.a;
import com.tencent.luggage.wxa.ob.a.a;
import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qw.z;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;
import java.io.IOException;

public class r
{
  private static <RES extends gu> RES a(Class<RES> paramClass, String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 2);
      gu localgu = (gu)paramClass.newInstance();
      localgu.a(paramString);
      o.e("Luggage.WxaRuntimeCgiProxy", "RespData decode done for response class %s", new Object[] { paramClass });
      return localgu;
    }
    catch (Exception paramString)
    {
      label37:
      break label37;
    }
    o.b("Luggage.WxaRuntimeCgiProxy", "RespData decode failed for response class %s", new Object[] { paramClass });
    return null;
  }
  
  private static z a()
  {
    z localz = new z();
    int i;
    if (i.a.g()) {
      i = i.a.f().c();
    } else {
      i = 0;
    }
    localz.b = i;
    localz.d = 654316592;
    localz.a = new b("xx".getBytes());
    localz.c = new b(i.a.c().getBytes());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android-");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localz.e = new b(localStringBuilder.toString().getBytes());
    return localz;
  }
  
  static <RES extends gu> com.tencent.luggage.wxa.ro.d<RES> a(String paramString1, @Nullable String paramString2, gt paramgt, Class<RES> paramClass)
  {
    return h.a().b(h.a(new r.2(), new r.3())).c(new r.1(paramString1, paramString2, paramgt, paramClass));
  }
  
  static <RES extends gu> void a(String paramString1, @Nullable String paramString2, gt paramgt, Class<RES> paramClass, p<RES> paramp)
  {
    try
    {
      if (!com.tencent.luggage.wxa.dg.d.a.k())
      {
        paramp.a(a.a.h, a.a.h.j, a.a.h.l);
        return;
      }
      if (com.tencent.luggage.wxa.dg.d.a.l())
      {
        o.d("Luggage.WxaRuntimeCgiProxy", "runSync url:%s expired token:%s", new Object[] { paramString1, com.tencent.luggage.wxa.dg.d.a.b() });
        if (!com.tencent.luggage.wxa.dg.d.a.i())
        {
          o.b("Luggage.WxaRuntimeCgiProxy", "runSync url:%s fail", new Object[] { paramString1 });
          paramp.a(a.a.h, a.a.h.j, a.a.h.l);
          return;
        }
        o.d("Luggage.WxaRuntimeCgiProxy", "runSync refreshDevcie token:%s", new Object[] { com.tencent.luggage.wxa.dg.d.a.b() });
      }
      i.a.h();
      paramp.a(c(paramString1, paramString2, paramgt, paramClass));
      return;
    }
    catch (IOException paramString1)
    {
      paramp.a(a.a.g, -1, paramString1.getMessage());
      throw paramString1;
    }
    catch (a paramString1)
    {
      paramp.a(paramString1.b, paramString1.c, paramString1.d);
      throw paramString1;
    }
  }
  
  /* Error */
  private static <RES extends gu> RES c(String paramString1, @Nullable String paramString2, gt paramgt, Class<RES> paramClass)
  {
    // Byte code:
    //   0: ldc 27
    //   2: ldc 217
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: aload_2
    //   15: invokevirtual 221	java/lang/Object:getClass	()Ljava/lang/Class;
    //   18: aastore
    //   19: invokestatic 35	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_2
    //   23: invokestatic 223	com/tencent/luggage/wxa/dc/r:a	()Lcom/tencent/luggage/wxa/qw/z;
    //   26: putfield 229	com/tencent/luggage/wxa/qw/gt:B	Lcom/tencent/luggage/wxa/qw/z;
    //   29: new 231	org/json/JSONObject
    //   32: dup
    //   33: invokespecial 232	org/json/JSONObject:<init>	()V
    //   36: astore 5
    //   38: aload 5
    //   40: ldc 234
    //   42: aload_0
    //   43: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload 5
    //   49: ldc 240
    //   51: aload_1
    //   52: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload 5
    //   58: ldc 242
    //   60: aload_2
    //   61: invokevirtual 244	com/tencent/luggage/wxa/qw/gt:b	()[B
    //   64: iconst_2
    //   65: invokestatic 248	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   68: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   71: pop
    //   72: ldc 250
    //   74: aload_0
    //   75: invokevirtual 254	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +19 -> 97
    //   81: aload 5
    //   83: ldc_w 256
    //   86: aload_2
    //   87: checkcast 258	com/tencent/luggage/wxa/qw/fa
    //   90: getfield 260	com/tencent/luggage/wxa/qw/fa:a	Ljava/lang/String;
    //   93: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload_0
    //   98: invokestatic 265	com/tencent/luggage/wxa/dc/u:a	(Ljava/lang/String;)Z
    //   101: ifeq +10 -> 111
    //   104: ldc_w 267
    //   107: astore_1
    //   108: goto +7 -> 115
    //   111: ldc_w 269
    //   114: astore_1
    //   115: new 271	okhttp3/Request$Builder
    //   118: dup
    //   119: invokespecial 272	okhttp3/Request$Builder:<init>	()V
    //   122: aload_1
    //   123: invokevirtual 275	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   126: getstatic 280	com/tencent/luggage/wxa/dc/g:a	Lokhttp3/MediaType;
    //   129: aload 5
    //   131: invokevirtual 281	org/json/JSONObject:toString	()Ljava/lang/String;
    //   134: invokestatic 287	okhttp3/RequestBody:create	(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;
    //   137: invokevirtual 291	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   140: invokevirtual 295	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   143: astore_2
    //   144: invokestatic 299	com/tencent/luggage/wxa/dc/g:cgiClient	()Lokhttp3/OkHttpClient;
    //   147: aload_2
    //   148: invokevirtual 305	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   151: invokeinterface 311 1 0
    //   156: astore_2
    //   157: new 231	org/json/JSONObject
    //   160: dup
    //   161: aload_2
    //   162: invokevirtual 317	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   165: invokevirtual 322	okhttp3/ResponseBody:string	()Ljava/lang/String;
    //   168: invokespecial 325	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   171: astore 5
    //   173: aload_2
    //   174: ifnull +7 -> 181
    //   177: aload_2
    //   178: invokevirtual 328	okhttp3/Response:close	()V
    //   181: aload 5
    //   183: ldc_w 330
    //   186: iconst_m1
    //   187: invokevirtual 334	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   190: istore 4
    //   192: aload 5
    //   194: ldc_w 336
    //   197: invokevirtual 340	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore_2
    //   201: iload 4
    //   203: ifeq +95 -> 298
    //   206: ldc 27
    //   208: ldc_w 342
    //   211: iconst_2
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload 5
    //   219: invokevirtual 281	org/json/JSONObject:toString	()Ljava/lang/String;
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: aload_0
    //   226: aastore
    //   227: invokestatic 40	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: ldc 27
    //   232: ldc_w 344
    //   235: iconst_2
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload 5
    //   243: invokevirtual 281	org/json/JSONObject:toString	()Ljava/lang/String;
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: aload_1
    //   250: aastore
    //   251: invokestatic 40	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: iload 4
    //   256: bipush 250
    //   258: if_icmpeq +20 -> 278
    //   261: iload 4
    //   263: bipush 251
    //   265: if_icmpeq +13 -> 278
    //   268: iload 4
    //   270: bipush 252
    //   272: if_icmpeq +6 -> 278
    //   275: goto +9 -> 284
    //   278: getstatic 55	com/tencent/luggage/wxa/dd/i:a	Lcom/tencent/luggage/wxa/dd/i;
    //   281: invokevirtual 346	com/tencent/luggage/wxa/dd/i:b	()V
    //   284: new 152	com/tencent/luggage/wxa/ob/a
    //   287: dup
    //   288: getstatic 348	com/tencent/luggage/wxa/ob/a$a:f	Lcom/tencent/luggage/wxa/ob/a$a;
    //   291: iload 4
    //   293: aload_2
    //   294: invokespecial 350	com/tencent/luggage/wxa/ob/a:<init>	(Lcom/tencent/luggage/wxa/ob/a$a;ILjava/lang/String;)V
    //   297: athrow
    //   298: aload_3
    //   299: aload 5
    //   301: ldc_w 352
    //   304: ldc_w 354
    //   307: invokevirtual 357	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   310: invokestatic 359	com/tencent/luggage/wxa/dc/r:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/luggage/wxa/qw/gu;
    //   313: astore_0
    //   314: aload_0
    //   315: ifnull +5 -> 320
    //   318: aload_0
    //   319: areturn
    //   320: ldc 27
    //   322: ldc_w 361
    //   325: invokestatic 364	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: new 152	com/tencent/luggage/wxa/ob/a
    //   331: dup
    //   332: getstatic 366	com/tencent/luggage/wxa/ob/a$a:c	Lcom/tencent/luggage/wxa/ob/a$a;
    //   335: iconst_0
    //   336: aconst_null
    //   337: invokespecial 350	com/tencent/luggage/wxa/ob/a:<init>	(Lcom/tencent/luggage/wxa/ob/a$a;ILjava/lang/String;)V
    //   340: athrow
    //   341: astore_0
    //   342: goto +30 -> 372
    //   345: astore_0
    //   346: ldc 27
    //   348: aload_0
    //   349: ldc_w 368
    //   352: iconst_0
    //   353: anewarray 4	java/lang/Object
    //   356: invokestatic 371	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: new 152	com/tencent/luggage/wxa/ob/a
    //   362: dup
    //   363: getstatic 373	com/tencent/luggage/wxa/ob/a$a:e	Lcom/tencent/luggage/wxa/ob/a$a;
    //   366: iconst_0
    //   367: aconst_null
    //   368: invokespecial 350	com/tencent/luggage/wxa/ob/a:<init>	(Lcom/tencent/luggage/wxa/ob/a$a;ILjava/lang/String;)V
    //   371: athrow
    //   372: aload_2
    //   373: ifnull +7 -> 380
    //   376: aload_2
    //   377: invokevirtual 328	okhttp3/Response:close	()V
    //   380: aload_0
    //   381: athrow
    //   382: astore_0
    //   383: ldc 27
    //   385: aload_0
    //   386: ldc_w 375
    //   389: iconst_0
    //   390: anewarray 4	java/lang/Object
    //   393: invokestatic 371	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: new 152	com/tencent/luggage/wxa/ob/a
    //   399: dup
    //   400: getstatic 376	com/tencent/luggage/wxa/ob/a$a:b	Lcom/tencent/luggage/wxa/ob/a$a;
    //   403: iconst_0
    //   404: aconst_null
    //   405: invokespecial 350	com/tencent/luggage/wxa/ob/a:<init>	(Lcom/tencent/luggage/wxa/ob/a$a;ILjava/lang/String;)V
    //   408: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	paramString1	String
    //   0	409	1	paramString2	String
    //   0	409	2	paramgt	gt
    //   0	409	3	paramClass	Class<RES>
    //   190	102	4	i	int
    //   36	264	5	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   157	173	341	finally
    //   346	372	341	finally
    //   157	173	345	java/lang/Exception
    //   38	97	382	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.r
 * JD-Core Version:    0.7.0.1
 */