package com.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.b.a.a.b;
import com.b.a.a.g;
import com.qq.a.a.a.a;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b$a
{
  public static n h;
  private static String i;
  public byte[] a;
  public String b;
  public long c;
  public long d;
  public long e;
  public long f;
  public Map<String, String> g = Collections.emptyMap();
  
  public static Bitmap a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(i)) {
      return i;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      i = paramContext;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 70
    //   2: astore 5
    //   4: ldc 70
    //   6: astore_3
    //   7: ldc 70
    //   9: astore 4
    //   11: aload_3
    //   12: astore_1
    //   13: aload 5
    //   15: astore_2
    //   16: new 77	org/json/JSONObject
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 80	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore 6
    //   26: aload_3
    //   27: astore_1
    //   28: aload 5
    //   30: astore_2
    //   31: aload 6
    //   33: ldc 82
    //   35: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_0
    //   39: aload_3
    //   40: astore_1
    //   41: aload_0
    //   42: astore_2
    //   43: aload 6
    //   45: ldc 87
    //   47: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: astore_1
    //   53: aload_0
    //   54: astore_2
    //   55: aload 6
    //   57: ldc 89
    //   59: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 5
    //   64: aload 5
    //   66: astore_1
    //   67: aload 6
    //   69: ldc 91
    //   71: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 5
    //   76: aload_3
    //   77: astore 4
    //   79: aload_1
    //   80: astore_2
    //   81: aload 5
    //   83: astore_3
    //   84: new 77	org/json/JSONObject
    //   87: dup
    //   88: invokespecial 92	org/json/JSONObject:<init>	()V
    //   91: astore_1
    //   92: aload_1
    //   93: ldc 94
    //   95: aload_0
    //   96: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload_1
    //   101: invokevirtual 101	org/json/JSONObject:toString	()Ljava/lang/String;
    //   104: astore_0
    //   105: new 103	com/qq/a/a/a/d
    //   108: dup
    //   109: invokestatic 107	com/b/a/j:e	()Ljava/lang/String;
    //   112: invokestatic 109	com/b/a/j:a	()Ljava/lang/String;
    //   115: invokestatic 111	com/b/a/j:b	()Ljava/lang/String;
    //   118: invokespecial 114	com/qq/a/a/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload 4
    //   123: aload_2
    //   124: aload_3
    //   125: aload_0
    //   126: invokevirtual 117	com/qq/a/a/a/d:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_0
    //   130: aload_0
    //   131: areturn
    //   132: astore_3
    //   133: ldc 70
    //   135: astore 5
    //   137: aload_2
    //   138: astore_0
    //   139: aload 5
    //   141: astore_2
    //   142: aload_3
    //   143: invokevirtual 118	org/json/JSONException:printStackTrace	()V
    //   146: aload 4
    //   148: astore_3
    //   149: aload_1
    //   150: astore 4
    //   152: goto -68 -> 84
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 118	org/json/JSONException:printStackTrace	()V
    //   160: goto -60 -> 100
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 119	com/qq/a/a/a/a:printStackTrace	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore 5
    //   172: aload_1
    //   173: astore_2
    //   174: aload_3
    //   175: astore_1
    //   176: aload 5
    //   178: astore_3
    //   179: goto -37 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   12	164	1	localObject1	Object
    //   15	159	2	localObject2	Object
    //   6	119	3	str1	String
    //   132	11	3	localJSONException1	JSONException
    //   148	31	3	localObject3	Object
    //   9	142	4	localObject4	Object
    //   2	138	5	str2	String
    //   170	7	5	localJSONException2	JSONException
    //   24	44	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   16	26	132	org/json/JSONException
    //   31	39	132	org/json/JSONException
    //   43	51	132	org/json/JSONException
    //   55	64	132	org/json/JSONException
    //   92	100	155	org/json/JSONException
    //   105	130	163	com/qq/a/a/a/a
    //   67	76	170	org/json/JSONException
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = new com.qq.a.a.a.d(j.e(), j.a(), paramString1).a(paramString1, paramString3, String.valueOf(System.currentTimeMillis() / 1000L), paramString2);
      return paramString1;
    }
    catch (a paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("app_id", paramString1);
      localJSONObject.put("message", paramString2);
      localJSONObject.put("signature", paramString3);
      localJSONObject.put("timestamp", paramString4);
      localJSONObject.put("nonce", paramString5);
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static void a(m<?> paramm) {}
  
  public static void a(m<?> paramm, o<?> paramo) {}
  
  public static void a(m<?> paramm, t paramt) {}
  
  public static n b()
  {
    try
    {
      if (h == null)
      {
        localObject1 = new File(j.c().getCacheDir(), "volley");
        b localb = new b(new g());
        localObject1 = new n(new com.b.a.a.d((File)localObject1), localb, false);
        ((n)localObject1).a();
        h = (n)localObject1;
      }
      Object localObject1 = h;
      return localObject1;
    }
    finally {}
  }
  
  public static String b(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int j = 0;
      if (j < paramString.length)
      {
        if (Integer.toHexString(paramString[j] & 0xFF).length() == 1) {
          ((StringBuffer)localObject).append("0").append(Integer.toHexString(paramString[j] & 0xFF));
        }
        for (;;)
        {
          j += 1;
          break;
          ((StringBuffer)localObject).append(Integer.toHexString(paramString[j] & 0xFF));
        }
      }
      return ((StringBuffer)localObject).toString();
    }
    catch (UnsupportedEncodingException paramString)
    {
      return null;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
  
  public static Object[] c(String paramString)
  {
    Object[] arrayOfObject = new Object[3];
    try
    {
      paramString = new JSONObject(paramString);
      arrayOfObject[0] = Integer.valueOf(0);
      arrayOfObject[1] = paramString.get("encrypt");
      return arrayOfObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return arrayOfObject;
  }
  
  public final boolean a()
  {
    return this.e < System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */