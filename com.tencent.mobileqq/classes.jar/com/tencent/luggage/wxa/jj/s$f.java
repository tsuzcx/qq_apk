package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class s$f
  implements Parcelable
{
  public static final Parcelable.Creator<f> CREATOR = new s.f.1();
  public int a;
  public int b;
  public String c;
  public String d;
  public s.e e;
  public List<s.d> f;
  public int g;
  public List<s.g> h;
  public boolean i;
  public String j;
  public String k;
  public String l;
  public List<s.h> m;
  public long n;
  @Nullable
  public String o = "";
  @Nullable
  public String p = "";
  @Nullable
  public String q = "";
  @Nullable
  public String r = "";
  public boolean s = false;
  private JSONObject t;
  
  public s$f() {}
  
  protected s$f(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = ((s.e)paramParcel.readParcelable(s.e.class.getClassLoader()));
    this.f = paramParcel.createTypedArrayList(s.d.CREATOR);
    this.g = paramParcel.readInt();
    this.h = paramParcel.createTypedArrayList(s.g.CREATOR);
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.i = bool;
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.createTypedArrayList(s.h.CREATOR);
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    boolean[] arrayOfBoolean = new boolean[1];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.s = arrayOfBoolean[0];
  }
  
  /* Error */
  public static f a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 141	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: invokestatic 144	com/tencent/luggage/wxa/qz/af:b	()J
    //   12: lstore_1
    //   13: new 146	org/json/JSONObject
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 149	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   21: astore_3
    //   22: new 2	com/tencent/luggage/wxa/jj/s$f
    //   25: dup
    //   26: invokespecial 150	com/tencent/luggage/wxa/jj/s$f:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: aload_3
    //   34: putfield 152	com/tencent/luggage/wxa/jj/s$f:t	Lorg/json/JSONObject;
    //   37: aload 4
    //   39: aload_3
    //   40: ldc 154
    //   42: iconst_0
    //   43: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   46: putfield 72	com/tencent/luggage/wxa/jj/s$f:a	I
    //   49: aload 4
    //   51: aload_3
    //   52: ldc 160
    //   54: iconst_m1
    //   55: invokevirtual 158	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   58: putfield 74	com/tencent/luggage/wxa/jj/s$f:b	I
    //   61: aload 4
    //   63: aload_3
    //   64: ldc 162
    //   66: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: putfield 80	com/tencent/luggage/wxa/jj/s$f:c	Ljava/lang/String;
    //   72: aload 4
    //   74: aload_3
    //   75: ldc 168
    //   77: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: putfield 82	com/tencent/luggage/wxa/jj/s$f:d	Ljava/lang/String;
    //   83: aload 4
    //   85: aload_3
    //   86: ldc 170
    //   88: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: putfield 122	com/tencent/luggage/wxa/jj/s$f:k	Ljava/lang/String;
    //   94: aload 4
    //   96: aload_3
    //   97: ldc 172
    //   99: invokevirtual 175	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   102: putfield 107	com/tencent/luggage/wxa/jj/s$f:g	I
    //   105: aload_3
    //   106: ldc 177
    //   108: invokevirtual 181	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   111: astore 5
    //   113: aload 5
    //   115: ifnull +45 -> 160
    //   118: aload 4
    //   120: new 84	com/tencent/luggage/wxa/jj/s$e
    //   123: dup
    //   124: invokespecial 182	com/tencent/luggage/wxa/jj/s$e:<init>	()V
    //   127: putfield 96	com/tencent/luggage/wxa/jj/s$f:e	Lcom/tencent/luggage/wxa/jj/s$e;
    //   130: aload 4
    //   132: getfield 96	com/tencent/luggage/wxa/jj/s$f:e	Lcom/tencent/luggage/wxa/jj/s$e;
    //   135: aload 5
    //   137: ldc 184
    //   139: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: putfield 186	com/tencent/luggage/wxa/jj/s$e:a	Ljava/lang/String;
    //   145: aload 4
    //   147: getfield 96	com/tencent/luggage/wxa/jj/s$f:e	Lcom/tencent/luggage/wxa/jj/s$e;
    //   150: aload 5
    //   152: ldc 188
    //   154: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: putfield 190	com/tencent/luggage/wxa/jj/s$e:b	Ljava/lang/String;
    //   160: aload_3
    //   161: ldc 192
    //   163: invokevirtual 181	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   166: astore 6
    //   168: aload 6
    //   170: ifnull +119 -> 289
    //   173: aload 6
    //   175: ldc 194
    //   177: invokevirtual 181	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   180: astore 5
    //   182: aload 6
    //   184: ldc 196
    //   186: invokevirtual 181	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   189: astore 6
    //   191: aload 5
    //   193: ifnull +47 -> 240
    //   196: aload 5
    //   198: ldc 198
    //   200: invokevirtual 201	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   203: ifeq +15 -> 218
    //   206: aload 4
    //   208: aload 5
    //   210: ldc 198
    //   212: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   215: putfield 55	com/tencent/luggage/wxa/jj/s$f:o	Ljava/lang/String;
    //   218: aload 5
    //   220: ldc 203
    //   222: invokevirtual 201	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   225: ifeq +15 -> 240
    //   228: aload 4
    //   230: aload 5
    //   232: ldc 203
    //   234: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   237: putfield 57	com/tencent/luggage/wxa/jj/s$f:p	Ljava/lang/String;
    //   240: aload 6
    //   242: ifnull +47 -> 289
    //   245: aload 6
    //   247: ldc 198
    //   249: invokevirtual 201	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   252: ifeq +15 -> 267
    //   255: aload 4
    //   257: aload 6
    //   259: ldc 198
    //   261: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   264: putfield 59	com/tencent/luggage/wxa/jj/s$f:q	Ljava/lang/String;
    //   267: aload 6
    //   269: ldc 203
    //   271: invokevirtual 201	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   274: ifeq +15 -> 289
    //   277: aload 4
    //   279: aload 6
    //   281: ldc 203
    //   283: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: putfield 61	com/tencent/luggage/wxa/jj/s$f:r	Ljava/lang/String;
    //   289: aload 4
    //   291: aload_3
    //   292: ldc 205
    //   294: invokevirtual 209	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   297: invokestatic 212	com/tencent/luggage/wxa/jj/s$g:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   300: putfield 112	com/tencent/luggage/wxa/jj/s$f:h	Ljava/util/List;
    //   303: aload 4
    //   305: aload_3
    //   306: ldc 214
    //   308: iconst_0
    //   309: invokevirtual 218	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   312: putfield 118	com/tencent/luggage/wxa/jj/s$f:i	Z
    //   315: aload 4
    //   317: aload_3
    //   318: ldc 220
    //   320: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   323: putfield 120	com/tencent/luggage/wxa/jj/s$f:j	Ljava/lang/String;
    //   326: aload 4
    //   328: aload_3
    //   329: ldc 222
    //   331: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: putfield 124	com/tencent/luggage/wxa/jj/s$f:l	Ljava/lang/String;
    //   337: aload 4
    //   339: aload_3
    //   340: ldc 224
    //   342: invokevirtual 209	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   345: invokestatic 225	com/tencent/luggage/wxa/jj/s$h:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   348: putfield 129	com/tencent/luggage/wxa/jj/s$f:m	Ljava/util/List;
    //   351: aload 4
    //   353: aload 4
    //   355: getfield 129	com/tencent/luggage/wxa/jj/s$f:m	Ljava/util/List;
    //   358: aload_3
    //   359: ldc 227
    //   361: invokevirtual 231	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   364: bipush 22
    //   366: invokestatic 234	com/tencent/luggage/wxa/jj/s$d:a	(Ljava/util/List;Ljava/lang/Object;I)Ljava/util/List;
    //   369: putfield 105	com/tencent/luggage/wxa/jj/s$f:f	Ljava/util/List;
    //   372: aload 4
    //   374: aload_3
    //   375: ldc 236
    //   377: ldc2_w 237
    //   380: invokevirtual 242	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   383: putfield 244	com/tencent/luggage/wxa/jj/s$f:n	J
    //   386: aload 4
    //   388: aload_3
    //   389: ldc 246
    //   391: iconst_0
    //   392: invokevirtual 218	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   395: putfield 63	com/tencent/luggage/wxa/jj/s$f:s	Z
    //   398: ldc 248
    //   400: ldc 250
    //   402: iconst_2
    //   403: anewarray 4	java/lang/Object
    //   406: dup
    //   407: iconst_0
    //   408: invokestatic 144	com/tencent/luggage/wxa/qz/af:b	()J
    //   411: lload_1
    //   412: lsub
    //   413: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   416: aastore
    //   417: dup
    //   418: iconst_1
    //   419: aload_0
    //   420: invokevirtual 261	java/lang/String:length	()I
    //   423: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: aastore
    //   427: invokestatic 271	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: aload 4
    //   432: areturn
    //   433: astore_3
    //   434: ldc 248
    //   436: ldc 250
    //   438: iconst_2
    //   439: anewarray 4	java/lang/Object
    //   442: dup
    //   443: iconst_0
    //   444: invokestatic 144	com/tencent/luggage/wxa/qz/af:b	()J
    //   447: lload_1
    //   448: lsub
    //   449: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   452: aastore
    //   453: dup
    //   454: iconst_1
    //   455: aload_0
    //   456: invokevirtual 261	java/lang/String:length	()I
    //   459: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: aastore
    //   463: invokestatic 271	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: aload_3
    //   467: athrow
    //   468: ldc 248
    //   470: ldc 250
    //   472: iconst_2
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: invokestatic 144	com/tencent/luggage/wxa/qz/af:b	()J
    //   481: lload_1
    //   482: lsub
    //   483: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: aload_0
    //   490: invokevirtual 261	java/lang/String:length	()I
    //   493: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   496: aastore
    //   497: invokestatic 271	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aconst_null
    //   501: areturn
    //   502: astore_3
    //   503: goto -35 -> 468
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramString	String
    //   12	470	1	l1	long
    //   21	368	3	localJSONObject1	JSONObject
    //   433	34	3	localObject	Object
    //   502	1	3	localException	java.lang.Exception
    //   29	402	4	localf	f
    //   111	120	5	localJSONObject2	JSONObject
    //   166	114	6	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   13	113	433	finally
    //   118	160	433	finally
    //   160	168	433	finally
    //   173	191	433	finally
    //   196	218	433	finally
    //   218	240	433	finally
    //   245	267	433	finally
    //   267	289	433	finally
    //   289	398	433	finally
    //   13	113	502	java/lang/Exception
    //   118	160	502	java/lang/Exception
    //   160	168	502	java/lang/Exception
    //   173	191	502	java/lang/Exception
    //   196	218	502	java/lang/Exception
    //   218	240	502	java/lang/Exception
    //   245	267	502	java/lang/Exception
    //   267	289	502	java/lang/Exception
    //   289	398	502	java/lang/Exception
  }
  
  public String a()
  {
    try
    {
      String str = this.t.toString(0);
      return str;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.AppBrand.WxaAttributes", "WxaVersionInfo.toJson exception:%s", new Object[] { localJSONException });
    }
    return "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.s.f
 * JD-Core Version:    0.7.0.1
 */