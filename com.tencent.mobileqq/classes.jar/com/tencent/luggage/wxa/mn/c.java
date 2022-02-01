package com.tencent.luggage.wxa.mn;

import android.os.Build;
import android.text.TextUtils.TruncateAt;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.kz.b;
import com.tencent.luggage.wxa.kz.b.a;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.af;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static int a()
  {
    if ("HUAWEI".equals(Build.MANUFACTURER)) {}
    return 8388608;
  }
  
  public static InputStream a(InputStream paramInputStream)
  {
    if (paramInputStream.markSupported()) {
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream)) {
      return new c.c((FileInputStream)paramInputStream);
    }
    return new BufferedInputStream(paramInputStream);
  }
  
  /* Error */
  public static void a(com.tencent.luggage.wxa.jx.e parame, int paramInt, com.tencent.luggage.wxa.po.a parama, JSONObject paramJSONObject, c.b paramb)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +346 -> 347
    //   4: aload_3
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: aload_2
    //   11: aload_3
    //   12: invokestatic 54	com/tencent/luggage/wxa/lr/d:a	(Lcom/tencent/luggage/wxa/jx/c;Lcom/tencent/luggage/wxa/lr/b;Lorg/json/JSONObject;)Ljava/lang/String;
    //   15: astore 5
    //   17: aload_3
    //   18: ldc 56
    //   20: invokevirtual 62	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_3
    //   24: aload_3
    //   25: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +319 -> 347
    //   31: aload_3
    //   32: ldc 70
    //   34: invokevirtual 74	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   37: ifeq +229 -> 266
    //   40: aload_3
    //   41: ldc 76
    //   43: invokevirtual 79	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +220 -> 266
    //   49: ldc 81
    //   51: ldc 83
    //   53: iconst_1
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_3
    //   60: aastore
    //   61: invokestatic 89	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_3
    //   65: aload_3
    //   66: ldc 91
    //   68: invokevirtual 95	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   71: bipush 7
    //   73: iadd
    //   74: invokevirtual 99	java/lang/String:substring	(I)Ljava/lang/String;
    //   77: invokevirtual 103	java/lang/String:trim	()Ljava/lang/String;
    //   80: iconst_0
    //   81: invokestatic 109	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   84: astore 7
    //   86: aload 7
    //   88: ifnull +157 -> 245
    //   91: aload 7
    //   93: arraylength
    //   94: ifne +6 -> 100
    //   97: goto +148 -> 245
    //   100: aload 4
    //   102: ifnull +134 -> 236
    //   105: new 111	android/graphics/BitmapFactory$Options
    //   108: dup
    //   109: invokespecial 114	android/graphics/BitmapFactory$Options:<init>	()V
    //   112: astore_3
    //   113: aload_3
    //   114: iconst_1
    //   115: putfield 118	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   118: new 120	java/io/ByteArrayInputStream
    //   121: dup
    //   122: aload 7
    //   124: invokespecial 123	java/io/ByteArrayInputStream:<init>	([B)V
    //   127: astore 8
    //   129: invokestatic 127	com/tencent/luggage/wxa/mn/c:c	()Lcom/tencent/luggage/wxa/kz/b;
    //   132: aload 8
    //   134: aconst_null
    //   135: aload_3
    //   136: invokeinterface 132 4 0
    //   141: pop
    //   142: aload 4
    //   144: aload_3
    //   145: invokeinterface 137 2 0
    //   150: aload 8
    //   152: invokevirtual 140	java/io/ByteArrayInputStream:close	()V
    //   155: goto +81 -> 236
    //   158: astore_3
    //   159: aconst_null
    //   160: astore 6
    //   162: goto +14 -> 176
    //   165: astore_3
    //   166: aload_3
    //   167: athrow
    //   168: astore 5
    //   170: aload_3
    //   171: astore 6
    //   173: aload 5
    //   175: astore_3
    //   176: aload 6
    //   178: ifnull +11 -> 189
    //   181: aload 8
    //   183: invokevirtual 140	java/io/ByteArrayInputStream:close	()V
    //   186: goto +8 -> 194
    //   189: aload 8
    //   191: invokevirtual 140	java/io/ByteArrayInputStream:close	()V
    //   194: aload_3
    //   195: athrow
    //   196: astore_3
    //   197: ldc 81
    //   199: ldc 142
    //   201: iconst_3
    //   202: anewarray 4	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: aload_0
    //   208: invokeinterface 147 1 0
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: iload_1
    //   217: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   220: aastore
    //   221: dup
    //   222: iconst_2
    //   223: aload_3
    //   224: aastore
    //   225: invokestatic 156	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: aload 4
    //   230: aconst_null
    //   231: invokeinterface 137 2 0
    //   236: aload_2
    //   237: aload 7
    //   239: invokeinterface 161 2 0
    //   244: return
    //   245: ldc 81
    //   247: ldc 163
    //   249: invokestatic 166	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 4
    //   254: ifnull +99 -> 353
    //   257: aload 4
    //   259: aconst_null
    //   260: invokeinterface 137 2 0
    //   265: return
    //   266: aload_0
    //   267: ldc 168
    //   269: invokeinterface 171 2 0
    //   274: checkcast 168	com/tencent/luggage/wxa/jl/b
    //   277: aload_0
    //   278: aload_3
    //   279: invokeinterface 174 3 0
    //   284: astore_3
    //   285: aload_0
    //   286: ldc 176
    //   288: invokeinterface 171 2 0
    //   293: checkcast 176	com/tencent/luggage/wxa/jl/a
    //   296: aload_3
    //   297: aload 5
    //   299: invokestatic 179	com/tencent/luggage/wxa/lr/d:a	(Ljava/lang/String;)Ljava/util/Map;
    //   302: new 181	com/tencent/luggage/wxa/mn/c$1
    //   305: dup
    //   306: aload_3
    //   307: aload 4
    //   309: new 183	java/lang/ref/WeakReference
    //   312: dup
    //   313: aload_0
    //   314: invokespecial 186	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   317: new 183	java/lang/ref/WeakReference
    //   320: dup
    //   321: aload_2
    //   322: invokespecial 186	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   325: invokespecial 189	com/tencent/luggage/wxa/mn/c$1:<init>	(Ljava/lang/String;Lcom/tencent/luggage/wxa/mn/c$b;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V
    //   328: invokeinterface 192 4 0
    //   333: return
    //   334: astore_0
    //   335: ldc 81
    //   337: aload_0
    //   338: ldc 194
    //   340: iconst_0
    //   341: anewarray 4	java/lang/Object
    //   344: invokestatic 197	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   347: return
    //   348: astore 5
    //   350: goto -156 -> 194
    //   353: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	parame	com.tencent.luggage.wxa.jx.e
    //   0	354	1	paramInt	int
    //   0	354	2	parama	com.tencent.luggage.wxa.po.a
    //   0	354	3	paramJSONObject	JSONObject
    //   0	354	4	paramb	c.b
    //   15	1	5	str1	String
    //   168	130	5	str2	String
    //   348	1	5	localThrowable	java.lang.Throwable
    //   160	17	6	localJSONObject	JSONObject
    //   84	154	7	arrayOfByte	byte[]
    //   127	63	8	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   129	150	158	finally
    //   129	150	165	java/lang/Throwable
    //   166	168	168	finally
    //   118	129	196	java/lang/Exception
    //   150	155	196	java/lang/Exception
    //   181	186	196	java/lang/Exception
    //   189	194	196	java/lang/Exception
    //   194	196	196	java/lang/Exception
    //   9	86	334	java/lang/NullPointerException
    //   91	97	334	java/lang/NullPointerException
    //   105	118	334	java/lang/NullPointerException
    //   118	129	334	java/lang/NullPointerException
    //   150	155	334	java/lang/NullPointerException
    //   181	186	334	java/lang/NullPointerException
    //   189	194	334	java/lang/NullPointerException
    //   194	196	334	java/lang/NullPointerException
    //   197	236	334	java/lang/NullPointerException
    //   236	244	334	java/lang/NullPointerException
    //   245	252	334	java/lang/NullPointerException
    //   257	265	334	java/lang/NullPointerException
    //   266	333	334	java/lang/NullPointerException
    //   181	186	348	java/lang/Throwable
  }
  
  public static void a(c.a parama, JSONObject paramJSONObject)
  {
    if (parama != null) {
      if (paramJSONObject == null) {
        return;
      }
    }
    try
    {
      str = paramJSONObject.getString("color");
      if (!af.c(str)) {
        parama.setTextColor(g.a(str));
      }
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        for (;;)
        {
          String str;
          parama.setTextSize(0, g.b((float)paramJSONObject.getDouble("fontSize")));
          label153:
          try
          {
            label50:
            str = paramJSONObject.getString("textAlign");
            if ("left".equals(str)) {
              parama.setGravity(3);
            } else if ("center".equals(str)) {
              parama.setGravity(1);
            } else if ("right".equals(str)) {
              parama.setGravity(5);
            }
          }
          catch (JSONException localJSONException3)
          {
            label111:
            break label111;
          }
          try
          {
            str = paramJSONObject.getString("fontWeight");
            if ("bold".equals(str)) {
              parama.setFakeBoldText(true);
            } else if ("normal".equals(str)) {
              parama.setFakeBoldText(false);
            }
          }
          catch (JSONException localJSONException4)
          {
            label272:
            break label153;
          }
          parama.setLineHeight(g.a(paramJSONObject, "lineHeight", Math.round(parama.getTextSize() * 1.2F)));
          try
          {
            str = paramJSONObject.getString("lineBreak");
            if ("ellipsis".equals(str))
            {
              parama.setEllipsize(TextUtils.TruncateAt.END);
              parama.setSingleLine(true);
            }
            else if ("clip".equals(str))
            {
              parama.setSingleLine(true);
            }
            else if ("break-word".equals(str))
            {
              parama.setSingleLine(false);
            }
            else if ("break-all".equals(str))
            {
              parama.setSingleLine(false);
            }
          }
          catch (JSONException localJSONException5)
          {
            break label272;
          }
          try
          {
            parama.setText(paramJSONObject.getString("content"));
            return;
          }
          catch (JSONException parama) {}
          localJSONException1 = localJSONException1;
        }
      }
      catch (JSONException localJSONException2)
      {
        break label50;
      }
    }
  }
  
  private static b c()
  {
    return b.a.a((b)e.a(b.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.c
 * JD-Core Version:    0.7.0.1
 */