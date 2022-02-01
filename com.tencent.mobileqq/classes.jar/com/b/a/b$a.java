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
    //   2: astore 4
    //   4: new 77	org/json/JSONObject
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 80	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12: astore_3
    //   13: aload_3
    //   14: ldc 82
    //   16: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_1
    //   20: aload_3
    //   21: ldc 87
    //   23: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_2
    //   27: aload_3
    //   28: ldc 89
    //   30: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_0
    //   34: aload_3
    //   35: ldc 91
    //   37: invokevirtual 85	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore_3
    //   41: goto +35 -> 76
    //   44: astore_3
    //   45: goto +24 -> 69
    //   48: astore_3
    //   49: ldc 70
    //   51: astore_0
    //   52: goto +17 -> 69
    //   55: astore_3
    //   56: goto +7 -> 63
    //   59: astore_3
    //   60: ldc 70
    //   62: astore_1
    //   63: ldc 70
    //   65: astore_2
    //   66: ldc 70
    //   68: astore_0
    //   69: aload_3
    //   70: invokevirtual 92	org/json/JSONException:printStackTrace	()V
    //   73: aload 4
    //   75: astore_3
    //   76: new 77	org/json/JSONObject
    //   79: dup
    //   80: invokespecial 93	org/json/JSONObject:<init>	()V
    //   83: astore 4
    //   85: aload 4
    //   87: ldc 95
    //   89: aload_1
    //   90: invokevirtual 99	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   93: pop
    //   94: goto +8 -> 102
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 92	org/json/JSONException:printStackTrace	()V
    //   102: aload 4
    //   104: invokevirtual 102	org/json/JSONObject:toString	()Ljava/lang/String;
    //   107: astore_1
    //   108: new 104	com/qq/a/a/a/d
    //   111: dup
    //   112: invokestatic 108	com/b/a/j:e	()Ljava/lang/String;
    //   115: invokestatic 110	com/b/a/j:a	()Ljava/lang/String;
    //   118: invokestatic 112	com/b/a/j:b	()Ljava/lang/String;
    //   121: invokespecial 115	com/qq/a/a/a/d:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_2
    //   125: aload_0
    //   126: aload_3
    //   127: aload_1
    //   128: invokevirtual 118	com/qq/a/a/a/d:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_0
    //   132: aload_0
    //   133: areturn
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 119	com/qq/a/a/a/a:printStackTrace	()V
    //   139: aconst_null
    //   140: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   19	71	1	str1	String
    //   97	2	1	localJSONException1	JSONException
    //   107	21	1	str2	String
    //   26	99	2	str3	String
    //   12	29	3	localObject1	Object
    //   44	1	3	localJSONException2	JSONException
    //   48	1	3	localJSONException3	JSONException
    //   55	1	3	localJSONException4	JSONException
    //   59	11	3	localJSONException5	JSONException
    //   75	52	3	localObject2	Object
    //   2	101	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   34	41	44	org/json/JSONException
    //   27	34	48	org/json/JSONException
    //   20	27	55	org/json/JSONException
    //   4	20	59	org/json/JSONException
    //   85	94	97	org/json/JSONException
    //   108	132	134	com/qq/a/a/a/a
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
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject.toString();
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
      while (j < paramString.length)
      {
        int k;
        if (Integer.toHexString(paramString[j] & 0xFF).length() == 1)
        {
          ((StringBuffer)localObject).append("0");
          k = paramString[j];
        }
        else
        {
          k = paramString[j];
        }
        ((StringBuffer)localObject).append(Integer.toHexString(k & 0xFF));
        j += 1;
      }
      return ((StringBuffer)localObject).toString();
    }
    catch (NoSuchAlgorithmException|UnsupportedEncodingException paramString) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */