package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class z
{
  private static Map<String, String> a;
  
  public static Context a(Context paramContext)
  {
    if (paramContext == null) {
      return paramContext;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return paramContext;
    }
    return localContext;
  }
  
  public static SharedPreferences a(String paramString, Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences(paramString, 0);
    }
    return null;
  }
  
  private static BufferedReader a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.canRead()) {
        return null;
      }
      try
      {
        paramFile = new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), "utf-8"));
        return paramFile;
      }
      catch (Throwable paramFile)
      {
        x.a(paramFile);
      }
    }
    return null;
  }
  
  public static BufferedReader a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString1 = new File(paramString1, paramString2);
      if (paramString1.exists())
      {
        if (!paramString1.canRead()) {
          return null;
        }
        paramString1 = a(paramString1);
        return paramString1;
      }
      return null;
    }
    catch (NullPointerException paramString1)
    {
      x.a(paramString1);
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
      paramString1.setAccessible(true);
      paramString1 = paramString1.invoke(null, paramArrayOfObject);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  /* Error */
  public static <T> T a(byte[] paramArrayOfByte, android.os.Parcelable.Creator<T> paramCreator)
  {
    // Byte code:
    //   0: invokestatic 99	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: aload_0
    //   6: iconst_0
    //   7: aload_0
    //   8: arraylength
    //   9: invokevirtual 103	android/os/Parcel:unmarshall	([BII)V
    //   12: aload_2
    //   13: iconst_0
    //   14: invokevirtual 107	android/os/Parcel:setDataPosition	(I)V
    //   17: aload_1
    //   18: aload_2
    //   19: invokeinterface 113 2 0
    //   24: astore_0
    //   25: aload_2
    //   26: ifnull +7 -> 33
    //   29: aload_2
    //   30: invokevirtual 116	android/os/Parcel:recycle	()V
    //   33: aload_0
    //   34: areturn
    //   35: astore_0
    //   36: goto +18 -> 54
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 116	android/os/Parcel:recycle	()V
    //   52: aconst_null
    //   53: areturn
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 116	android/os/Parcel:recycle	()V
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramArrayOfByte	byte[]
    //   0	64	1	paramCreator	android.os.Parcelable.Creator<T>
    //   3	56	2	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   17	25	35	finally
    //   40	44	35	finally
    //   17	25	39	java/lang/Throwable
  }
  
  public static String a()
  {
    return a(System.currentTimeMillis());
  }
  
  public static String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    return new Date().toString();
  }
  
  /* Error */
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 161
    //   3: invokestatic 166	com/tencent/bugly/crashreport/common/info/AppInfo:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   6: istore_3
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore_0
    //   12: iload_3
    //   13: ifne +15 -> 28
    //   16: ldc 168
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 172	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   25: pop
    //   26: aconst_null
    //   27: areturn
    //   28: aload_2
    //   29: ifnonnull +36 -> 65
    //   32: iconst_4
    //   33: anewarray 174	java/lang/String
    //   36: astore 4
    //   38: aload 4
    //   40: iconst_0
    //   41: ldc 176
    //   43: aastore
    //   44: aload 4
    //   46: iconst_1
    //   47: ldc 178
    //   49: aastore
    //   50: aload 4
    //   52: iconst_2
    //   53: ldc 180
    //   55: aastore
    //   56: aload 4
    //   58: iconst_3
    //   59: ldc 182
    //   61: aastore
    //   62: goto +39 -> 101
    //   65: bipush 6
    //   67: anewarray 174	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: ldc 176
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: ldc 178
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: ldc 180
    //   84: aastore
    //   85: dup
    //   86: iconst_3
    //   87: ldc 182
    //   89: aastore
    //   90: dup
    //   91: iconst_4
    //   92: ldc 184
    //   94: aastore
    //   95: dup
    //   96: iconst_5
    //   97: aload_2
    //   98: aastore
    //   99: astore 4
    //   101: new 186	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   108: astore 6
    //   110: aload 5
    //   112: astore_2
    //   113: invokestatic 193	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   116: aload 4
    //   118: invokevirtual 197	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   121: astore 4
    //   123: aload 4
    //   125: astore_0
    //   126: aload 4
    //   128: astore_2
    //   129: new 39	java/io/BufferedReader
    //   132: dup
    //   133: new 41	java/io/InputStreamReader
    //   136: dup
    //   137: aload 4
    //   139: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   142: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   145: invokespecial 54	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   148: astore 5
    //   150: aload 4
    //   152: astore_0
    //   153: aload 4
    //   155: astore_2
    //   156: aload 5
    //   158: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   161: astore 7
    //   163: aload 7
    //   165: ifnull +73 -> 238
    //   168: aload 4
    //   170: astore_0
    //   171: aload 4
    //   173: astore_2
    //   174: aload 6
    //   176: aload 7
    //   178: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 4
    //   184: astore_0
    //   185: aload 4
    //   187: astore_2
    //   188: aload 6
    //   190: ldc 215
    //   192: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: iload_1
    //   197: ifle -47 -> 150
    //   200: aload 4
    //   202: astore_0
    //   203: aload 4
    //   205: astore_2
    //   206: aload 6
    //   208: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   211: iload_1
    //   212: if_icmple -62 -> 150
    //   215: aload 4
    //   217: astore_0
    //   218: aload 4
    //   220: astore_2
    //   221: aload 6
    //   223: iconst_0
    //   224: aload 6
    //   226: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   229: iload_1
    //   230: isub
    //   231: invokevirtual 223	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: goto -85 -> 150
    //   238: aload 4
    //   240: astore_0
    //   241: aload 4
    //   243: astore_2
    //   244: aload 6
    //   246: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: astore 5
    //   251: aload 4
    //   253: ifnull +51 -> 304
    //   256: aload 4
    //   258: invokevirtual 228	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   261: invokevirtual 233	java/io/OutputStream:close	()V
    //   264: goto +8 -> 272
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   272: aload 4
    //   274: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   277: invokevirtual 237	java/io/InputStream:close	()V
    //   280: goto +8 -> 288
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   288: aload 4
    //   290: invokevirtual 240	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   293: invokevirtual 237	java/io/InputStream:close	()V
    //   296: aload 5
    //   298: areturn
    //   299: astore_0
    //   300: aload_0
    //   301: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   304: aload 5
    //   306: areturn
    //   307: astore_2
    //   308: goto +132 -> 440
    //   311: astore 4
    //   313: aload_2
    //   314: astore_0
    //   315: aload 4
    //   317: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   320: ifne +10 -> 330
    //   323: aload_2
    //   324: astore_0
    //   325: aload 4
    //   327: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   330: aload_2
    //   331: astore_0
    //   332: new 186	java/lang/StringBuilder
    //   335: dup
    //   336: ldc 242
    //   338: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   341: astore 5
    //   343: aload_2
    //   344: astore_0
    //   345: aload 5
    //   347: aload 4
    //   349: invokevirtual 246	java/lang/Throwable:toString	()Ljava/lang/String;
    //   352: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_2
    //   357: astore_0
    //   358: aload 5
    //   360: ldc 248
    //   362: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_2
    //   367: astore_0
    //   368: aload 6
    //   370: aload 5
    //   372: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_2
    //   380: astore_0
    //   381: aload 6
    //   383: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: astore 4
    //   388: aload_2
    //   389: ifnull +48 -> 437
    //   392: aload_2
    //   393: invokevirtual 228	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   396: invokevirtual 233	java/io/OutputStream:close	()V
    //   399: goto +8 -> 407
    //   402: astore_0
    //   403: aload_0
    //   404: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   407: aload_2
    //   408: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   411: invokevirtual 237	java/io/InputStream:close	()V
    //   414: goto +8 -> 422
    //   417: astore_0
    //   418: aload_0
    //   419: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   422: aload_2
    //   423: invokevirtual 240	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   426: invokevirtual 237	java/io/InputStream:close	()V
    //   429: aload 4
    //   431: areturn
    //   432: astore_0
    //   433: aload_0
    //   434: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   437: aload 4
    //   439: areturn
    //   440: aload_0
    //   441: ifnull +52 -> 493
    //   444: aload_0
    //   445: invokevirtual 228	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   448: invokevirtual 233	java/io/OutputStream:close	()V
    //   451: goto +10 -> 461
    //   454: astore 4
    //   456: aload 4
    //   458: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   461: aload_0
    //   462: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   465: invokevirtual 237	java/io/InputStream:close	()V
    //   468: goto +10 -> 478
    //   471: astore 4
    //   473: aload 4
    //   475: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   478: aload_0
    //   479: invokevirtual 240	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   482: invokevirtual 237	java/io/InputStream:close	()V
    //   485: goto +8 -> 493
    //   488: astore_0
    //   489: aload_0
    //   490: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   493: goto +5 -> 498
    //   496: aload_2
    //   497: athrow
    //   498: goto -2 -> 496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	paramContext	Context
    //   0	501	1	paramInt	int
    //   0	501	2	paramString	String
    //   6	7	3	bool	boolean
    //   36	253	4	localObject1	Object
    //   311	37	4	localThrowable	Throwable
    //   386	52	4	str1	String
    //   454	3	4	localIOException1	java.io.IOException
    //   471	3	4	localIOException2	java.io.IOException
    //   8	363	5	localObject2	Object
    //   108	274	6	localStringBuilder	StringBuilder
    //   161	16	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   256	264	267	java/io/IOException
    //   272	280	283	java/io/IOException
    //   288	296	299	java/io/IOException
    //   113	123	307	finally
    //   129	150	307	finally
    //   156	163	307	finally
    //   174	182	307	finally
    //   188	196	307	finally
    //   206	215	307	finally
    //   221	235	307	finally
    //   244	251	307	finally
    //   315	323	307	finally
    //   325	330	307	finally
    //   332	343	307	finally
    //   345	356	307	finally
    //   358	366	307	finally
    //   368	379	307	finally
    //   381	388	307	finally
    //   113	123	311	java/lang/Throwable
    //   129	150	311	java/lang/Throwable
    //   156	163	311	java/lang/Throwable
    //   174	182	311	java/lang/Throwable
    //   188	196	311	java/lang/Throwable
    //   206	215	311	java/lang/Throwable
    //   221	235	311	java/lang/Throwable
    //   244	251	311	java/lang/Throwable
    //   392	399	402	java/io/IOException
    //   407	414	417	java/io/IOException
    //   422	429	432	java/io/IOException
    //   444	451	454	java/io/IOException
    //   461	468	471	java/io/IOException
    //   478	485	488	java/io/IOException
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().equals("")) {
        return "";
      }
      if (a == null)
      {
        a = new HashMap();
        Object localObject = c(paramContext, "getprop");
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          x.b(z.class, "Successfully get 'getprop' list.", new Object[0]);
          paramContext = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Matcher localMatcher = paramContext.matcher((String)((Iterator)localObject).next());
            if (localMatcher.find()) {
              a.put(localMatcher.group(1), localMatcher.group(2));
            }
          }
          x.b(z.class, "System properties number: %d.", new Object[] { Integer.valueOf(a.size()) });
        }
      }
      if (a.containsKey(paramString)) {
        return (String)a.get(paramString);
      }
      return "fail";
    }
    return "";
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +227 -> 228
    //   4: aload_0
    //   5: invokevirtual 34	java/io/File:exists	()Z
    //   8: ifeq +220 -> 228
    //   11: aload_0
    //   12: invokevirtual 37	java/io/File:canRead	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 186	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: new 39	java/io/BufferedReader
    //   32: dup
    //   33: new 41	java/io/InputStreamReader
    //   36: dup
    //   37: new 43	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: ldc 48
    //   47: invokespecial 51	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: invokespecial 54	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_3
    //   54: aload_3
    //   55: astore_0
    //   56: aload_3
    //   57: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload 5
    //   64: ifnull +78 -> 142
    //   67: aload_3
    //   68: astore_0
    //   69: aload 4
    //   71: aload 5
    //   73: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: astore_0
    //   79: aload 4
    //   81: ldc 215
    //   83: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: iload_1
    //   88: ifle -34 -> 54
    //   91: aload_3
    //   92: astore_0
    //   93: aload 4
    //   95: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   98: iload_1
    //   99: if_icmple -45 -> 54
    //   102: iload_2
    //   103: ifeq +20 -> 123
    //   106: aload_3
    //   107: astore_0
    //   108: aload 4
    //   110: iload_1
    //   111: aload 4
    //   113: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   116: invokevirtual 223	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: goto +22 -> 142
    //   123: aload_3
    //   124: astore_0
    //   125: aload 4
    //   127: iconst_0
    //   128: aload 4
    //   130: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   133: iload_1
    //   134: isub
    //   135: invokevirtual 223	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: goto -85 -> 54
    //   142: aload_3
    //   143: astore_0
    //   144: aload 4
    //   146: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: astore 4
    //   151: aload_3
    //   152: invokevirtual 340	java/io/BufferedReader:close	()V
    //   155: aload 4
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   163: pop
    //   164: aload 4
    //   166: areturn
    //   167: astore 4
    //   169: goto +13 -> 182
    //   172: astore_3
    //   173: aconst_null
    //   174: astore_0
    //   175: goto +34 -> 209
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_3
    //   183: astore_0
    //   184: aload 4
    //   186: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   189: pop
    //   190: aload_3
    //   191: ifnull +15 -> 206
    //   194: aload_3
    //   195: invokevirtual 340	java/io/BufferedReader:close	()V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_0
    //   201: aload_0
    //   202: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   205: pop
    //   206: aconst_null
    //   207: areturn
    //   208: astore_3
    //   209: aload_0
    //   210: ifnull +16 -> 226
    //   213: aload_0
    //   214: invokevirtual 340	java/io/BufferedReader:close	()V
    //   217: goto +9 -> 226
    //   220: astore_0
    //   221: aload_0
    //   222: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   225: pop
    //   226: aload_3
    //   227: athrow
    //   228: aconst_null
    //   229: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramFile	File
    //   0	230	1	paramInt	int
    //   0	230	2	paramBoolean	boolean
    //   53	99	3	localBufferedReader	BufferedReader
    //   172	1	3	localObject1	Object
    //   181	14	3	localObject2	Object
    //   208	19	3	localObject3	Object
    //   27	138	4	localObject4	Object
    //   167	1	4	localThrowable1	Throwable
    //   178	7	4	localThrowable2	Throwable
    //   60	12	5	str	String
    // Exception table:
    //   from	to	target	type
    //   151	155	158	java/lang/Exception
    //   56	62	167	java/lang/Throwable
    //   69	77	167	java/lang/Throwable
    //   79	87	167	java/lang/Throwable
    //   93	102	167	java/lang/Throwable
    //   108	120	167	java/lang/Throwable
    //   125	139	167	java/lang/Throwable
    //   144	151	167	java/lang/Throwable
    //   20	54	172	finally
    //   20	54	178	java/lang/Throwable
    //   194	198	200	java/lang/Exception
    //   56	62	208	finally
    //   69	77	208	finally
    //   79	87	208	finally
    //   93	102	208	finally
    //   108	120	208	finally
    //   125	139	208	finally
    //   144	151	208	finally
    //   184	190	208	finally
    //   213	217	220	java/lang/Exception
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      paramThrowable = localStringWriter.getBuffer().toString();
      return paramThrowable;
    }
    catch (Throwable paramThrowable)
    {
      if (!x.a(paramThrowable)) {
        paramThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String a(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    try
    {
      paramDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate)
    {
      label25:
      break label25;
    }
    return new Date().toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString().toUpperCase();
  }
  
  public static Thread a(Runnable paramRunnable, String paramString)
  {
    try
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setName(paramString);
      paramRunnable.start();
      return paramRunnable;
    }
    catch (Throwable paramRunnable)
    {
      x.e("[Util] Failed to start a thread to execute task with message: %s", new Object[] { paramRunnable.getMessage() });
    }
    return null;
  }
  
  public static Map<String, String> a(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap(12);
    Object localObject2 = Thread.getAllStackTraces();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = Looper.getMainLooper().getThread();
    if (!((Map)localObject2).containsKey(localObject1)) {
      ((Map)localObject2).put(localObject1, ((Thread)localObject1).getStackTrace());
    }
    Thread.currentThread().getId();
    localObject1 = new StringBuilder();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      int i = 0;
      ((StringBuilder)localObject1).setLength(0);
      if ((localEntry.getValue() != null) && (((StackTraceElement[])localEntry.getValue()).length != 0))
      {
        Object localObject3 = (StackTraceElement[])localEntry.getValue();
        int j = localObject3.length;
        while (i < j)
        {
          Object localObject4 = localObject3[i];
          if ((paramInt > 0) && (((StringBuilder)localObject1).length() >= paramInt))
          {
            localObject3 = new StringBuilder("\n[Stack over limit size :");
            ((StringBuilder)localObject3).append(paramInt);
            ((StringBuilder)localObject3).append(" , has been cut!]");
            ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
            break;
          }
          ((StringBuilder)localObject1).append(localObject4.toString());
          ((StringBuilder)localObject1).append("\n");
          i += 1;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((Thread)localEntry.getKey()).getName());
        ((StringBuilder)localObject3).append("(");
        ((StringBuilder)localObject3).append(((Thread)localEntry.getKey()).getId());
        ((StringBuilder)localObject3).append(")");
        localHashMap.put(((StringBuilder)localObject3).toString(), ((StringBuilder)localObject1).toString());
      }
    }
    return localHashMap;
  }
  
  public static Map<String, PlugInBean> a(Parcel paramParcel)
  {
    Object localObject1 = paramParcel.readBundle();
    paramParcel = null;
    if (localObject1 == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = ((Integer)((Bundle)localObject1).get("pluginNum")).intValue();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (i < k)
    {
      localObject2 = new StringBuilder("pluginKey");
      ((StringBuilder)localObject2).append(i);
      localArrayList1.add(((Bundle)localObject1).getString(((StringBuilder)localObject2).toString()));
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      localObject2 = new StringBuilder("pluginVal");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("plugInId");
      localObject2 = ((Bundle)localObject1).getString(((StringBuilder)localObject2).toString());
      Object localObject3 = new StringBuilder("pluginVal");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("plugInUUID");
      localObject3 = ((Bundle)localObject1).getString(((StringBuilder)localObject3).toString());
      StringBuilder localStringBuilder = new StringBuilder("pluginVal");
      localStringBuilder.append(i);
      localStringBuilder.append("plugInVersion");
      localArrayList2.add(new PlugInBean((String)localObject2, ((Bundle)localObject1).getString(localStringBuilder.toString()), (String)localObject3));
      i += 1;
    }
    if (localArrayList1.size() == localArrayList2.size())
    {
      localObject1 = new HashMap(localArrayList1.size());
      i = j;
      for (;;)
      {
        paramParcel = (Parcel)localObject1;
        if (i >= localArrayList1.size()) {
          break;
        }
        ((HashMap)localObject1).put(localArrayList1.get(i), PlugInBean.class.cast(localArrayList2.get(i)));
        i += 1;
      }
    }
    x.e("map plugin parcel error!", new Object[0]);
    return paramParcel;
  }
  
  public static void a(Parcel paramParcel, Map<String, PlugInBean> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      int i = paramMap.size();
      ArrayList localArrayList1 = new ArrayList(i);
      ArrayList localArrayList2 = new ArrayList(i);
      paramMap = paramMap.entrySet().iterator();
      Object localObject;
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        localArrayList1.add(((Map.Entry)localObject).getKey());
        localArrayList2.add(((Map.Entry)localObject).getValue());
      }
      paramMap = new Bundle();
      paramMap.putInt("pluginNum", localArrayList1.size());
      int k = 0;
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= localArrayList1.size()) {
          break;
        }
        localObject = new StringBuilder("pluginKey");
        ((StringBuilder)localObject).append(i);
        paramMap.putString(((StringBuilder)localObject).toString(), (String)localArrayList1.get(i));
        i += 1;
      }
      while (j < localArrayList1.size())
      {
        localObject = new StringBuilder("pluginVal");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("plugInId");
        paramMap.putString(((StringBuilder)localObject).toString(), ((PlugInBean)localArrayList2.get(j)).a);
        localObject = new StringBuilder("pluginVal");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("plugInUUID");
        paramMap.putString(((StringBuilder)localObject).toString(), ((PlugInBean)localArrayList2.get(j)).c);
        localObject = new StringBuilder("pluginVal");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("plugInVersion");
        paramMap.putString(((StringBuilder)localObject).toString(), ((PlugInBean)localArrayList2.get(j)).b);
        j += 1;
      }
      paramParcel.writeBundle(paramMap);
      return;
    }
    paramParcel.writeBundle(null);
  }
  
  public static void a(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass.set(null, paramObject1);
      return;
    }
    catch (Exception paramClass) {}
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 552
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: aload_0
    //   10: aastore
    //   11: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   14: pop
    //   15: aload_1
    //   16: ifnull +218 -> 234
    //   19: aload_1
    //   20: invokevirtual 252	java/lang/String:trim	()Ljava/lang/String;
    //   23: invokevirtual 365	java/lang/String:length	()I
    //   26: ifgt +4 -> 30
    //   29: return
    //   30: new 30	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 555	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 6
    //   40: aload 6
    //   42: invokevirtual 34	java/io/File:exists	()Z
    //   45: ifne +26 -> 71
    //   48: aload 6
    //   50: invokevirtual 559	java/io/File:getParentFile	()Ljava/io/File;
    //   53: ifnull +12 -> 65
    //   56: aload 6
    //   58: invokevirtual 559	java/io/File:getParentFile	()Ljava/io/File;
    //   61: invokevirtual 562	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload 6
    //   67: invokevirtual 565	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: aconst_null
    //   72: astore 5
    //   74: aconst_null
    //   75: astore 4
    //   77: aload 4
    //   79: astore_0
    //   80: aload 5
    //   82: astore_3
    //   83: aload 6
    //   85: invokevirtual 567	java/io/File:length	()J
    //   88: iload_2
    //   89: i2l
    //   90: lcmp
    //   91: iflt +24 -> 115
    //   94: aload 4
    //   96: astore_0
    //   97: aload 5
    //   99: astore_3
    //   100: new 569	java/io/FileOutputStream
    //   103: dup
    //   104: aload 6
    //   106: iconst_0
    //   107: invokespecial 572	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   110: astore 4
    //   112: goto +21 -> 133
    //   115: aload 4
    //   117: astore_0
    //   118: aload 5
    //   120: astore_3
    //   121: new 569	java/io/FileOutputStream
    //   124: dup
    //   125: aload 6
    //   127: iconst_1
    //   128: invokespecial 572	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   131: astore 4
    //   133: aload 4
    //   135: astore_0
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: aload_1
    //   142: ldc_w 574
    //   145: invokevirtual 578	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   148: invokevirtual 582	java/io/FileOutputStream:write	([B)V
    //   151: aload 4
    //   153: astore_0
    //   154: aload 4
    //   156: astore_3
    //   157: aload 4
    //   159: invokevirtual 585	java/io/FileOutputStream:flush	()V
    //   162: aload 4
    //   164: invokevirtual 586	java/io/FileOutputStream:close	()V
    //   167: goto +56 -> 223
    //   170: astore_1
    //   171: goto +30 -> 201
    //   174: astore_1
    //   175: aload_3
    //   176: astore_0
    //   177: aload_1
    //   178: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   181: ifne +9 -> 190
    //   184: aload_3
    //   185: astore_0
    //   186: aload_1
    //   187: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   190: aload_3
    //   191: ifnull +32 -> 223
    //   194: aload_3
    //   195: invokevirtual 586	java/io/FileOutputStream:close	()V
    //   198: goto +25 -> 223
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 586	java/io/FileOutputStream:close	()V
    //   209: aload_1
    //   210: athrow
    //   211: astore_0
    //   212: aload_0
    //   213: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   216: ifne +7 -> 223
    //   219: aload_0
    //   220: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   223: ldc_w 588
    //   226: iconst_0
    //   227: anewarray 4	java/lang/Object
    //   230: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   233: pop
    //   234: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramString1	String
    //   0	235	1	paramString2	String
    //   0	235	2	paramInt	int
    //   82	113	3	localObject1	Object
    //   75	88	4	localFileOutputStream	java.io.FileOutputStream
    //   72	47	5	localObject2	Object
    //   38	88	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   83	94	170	finally
    //   100	112	170	finally
    //   121	133	170	finally
    //   139	151	170	finally
    //   157	162	170	finally
    //   177	184	170	finally
    //   186	190	170	finally
    //   83	94	174	java/lang/Throwable
    //   100	112	174	java/lang/Throwable
    //   121	133	174	java/lang/Throwable
    //   139	151	174	java/lang/Throwable
    //   157	162	174	java/lang/Throwable
    //   40	65	211	java/lang/Throwable
    //   65	71	211	java/lang/Throwable
    //   162	167	211	java/lang/Throwable
    //   194	198	211	java/lang/Throwable
    //   205	209	211	java/lang/Throwable
    //   209	211	211	java/lang/Throwable
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    x.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getFilesDir());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString);
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists())
      {
        if (System.currentTimeMillis() - ((File)localObject).lastModified() < 10000L) {
          return false;
        }
        x.c("[Util] Lock file (%s) is expired, unlock it.", new Object[] { paramString });
        b(paramContext, paramString);
      }
      if (((File)localObject).createNewFile())
      {
        x.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        return true;
      }
      x.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return false;
    }
    catch (Throwable paramContext)
    {
      x.a(paramContext);
    }
    return false;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 624
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +393 -> 405
    //   15: aload_1
    //   16: ifnull +389 -> 405
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 625	java/io/File:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +6 -> 30
    //   27: goto +378 -> 405
    //   30: aload_0
    //   31: invokevirtual 34	java/io/File:exists	()Z
    //   34: ifeq +358 -> 392
    //   37: aload_0
    //   38: invokevirtual 37	java/io/File:canRead	()Z
    //   41: ifne +6 -> 47
    //   44: goto +348 -> 392
    //   47: aload_1
    //   48: invokevirtual 559	java/io/File:getParentFile	()Ljava/io/File;
    //   51: ifnull +21 -> 72
    //   54: aload_1
    //   55: invokevirtual 559	java/io/File:getParentFile	()Ljava/io/File;
    //   58: invokevirtual 34	java/io/File:exists	()Z
    //   61: ifne +11 -> 72
    //   64: aload_1
    //   65: invokevirtual 559	java/io/File:getParentFile	()Ljava/io/File;
    //   68: invokevirtual 562	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: aload_1
    //   73: invokevirtual 34	java/io/File:exists	()Z
    //   76: ifne +23 -> 99
    //   79: aload_1
    //   80: invokevirtual 565	java/io/File:createNewFile	()Z
    //   83: pop
    //   84: goto +15 -> 99
    //   87: astore_3
    //   88: aload_3
    //   89: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   92: ifne +7 -> 99
    //   95: aload_3
    //   96: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   99: aload_1
    //   100: invokevirtual 34	java/io/File:exists	()Z
    //   103: ifeq +287 -> 390
    //   106: aload_1
    //   107: invokevirtual 37	java/io/File:canRead	()Z
    //   110: ifne +5 -> 115
    //   113: iconst_0
    //   114: ireturn
    //   115: aconst_null
    //   116: astore 4
    //   118: new 43	java/io/FileInputStream
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: astore_3
    //   127: new 627	java/util/zip/ZipOutputStream
    //   130: dup
    //   131: new 629	java/io/BufferedOutputStream
    //   134: dup
    //   135: new 569	java/io/FileOutputStream
    //   138: dup
    //   139: aload_1
    //   140: invokespecial 630	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: invokespecial 633	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   146: invokespecial 634	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   149: astore_1
    //   150: aload_1
    //   151: bipush 8
    //   153: invokevirtual 637	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   156: aload_1
    //   157: new 639	java/util/zip/ZipEntry
    //   160: dup
    //   161: aload_0
    //   162: invokevirtual 640	java/io/File:getName	()Ljava/lang/String;
    //   165: invokespecial 641	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   168: invokevirtual 645	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   171: sipush 5000
    //   174: newarray byte
    //   176: astore_0
    //   177: aload_3
    //   178: aload_0
    //   179: invokevirtual 649	java/io/FileInputStream:read	([B)I
    //   182: istore_2
    //   183: iload_2
    //   184: ifle +13 -> 197
    //   187: aload_1
    //   188: aload_0
    //   189: iconst_0
    //   190: iload_2
    //   191: invokevirtual 651	java/util/zip/ZipOutputStream:write	([BII)V
    //   194: goto -17 -> 177
    //   197: aload_1
    //   198: invokevirtual 652	java/util/zip/ZipOutputStream:flush	()V
    //   201: aload_1
    //   202: invokevirtual 655	java/util/zip/ZipOutputStream:closeEntry	()V
    //   205: aload_3
    //   206: invokevirtual 656	java/io/FileInputStream:close	()V
    //   209: goto +8 -> 217
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   217: aload_1
    //   218: invokevirtual 657	java/util/zip/ZipOutputStream:close	()V
    //   221: goto +8 -> 229
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   229: ldc_w 659
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   239: pop
    //   240: iconst_1
    //   241: ireturn
    //   242: astore 4
    //   244: aload_1
    //   245: astore_0
    //   246: aload 4
    //   248: astore_1
    //   249: goto +96 -> 345
    //   252: astore 4
    //   254: aload_1
    //   255: astore_0
    //   256: aload 4
    //   258: astore_1
    //   259: goto +12 -> 271
    //   262: astore_1
    //   263: aconst_null
    //   264: astore_0
    //   265: goto +80 -> 345
    //   268: astore_1
    //   269: aconst_null
    //   270: astore_0
    //   271: goto +17 -> 288
    //   274: astore_1
    //   275: aconst_null
    //   276: astore_3
    //   277: aload_3
    //   278: astore_0
    //   279: goto +66 -> 345
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_0
    //   285: aload 4
    //   287: astore_3
    //   288: aload_1
    //   289: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   292: ifne +7 -> 299
    //   295: aload_1
    //   296: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   299: aload_3
    //   300: ifnull +15 -> 315
    //   303: aload_3
    //   304: invokevirtual 656	java/io/FileInputStream:close	()V
    //   307: goto +8 -> 315
    //   310: astore_1
    //   311: aload_1
    //   312: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   315: aload_0
    //   316: ifnull +15 -> 331
    //   319: aload_0
    //   320: invokevirtual 657	java/util/zip/ZipOutputStream:close	()V
    //   323: goto +8 -> 331
    //   326: astore_0
    //   327: aload_0
    //   328: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   331: ldc_w 659
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   341: pop
    //   342: iconst_0
    //   343: ireturn
    //   344: astore_1
    //   345: aload_3
    //   346: ifnull +15 -> 361
    //   349: aload_3
    //   350: invokevirtual 656	java/io/FileInputStream:close	()V
    //   353: goto +8 -> 361
    //   356: astore_3
    //   357: aload_3
    //   358: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   361: aload_0
    //   362: ifnull +15 -> 377
    //   365: aload_0
    //   366: invokevirtual 657	java/util/zip/ZipOutputStream:close	()V
    //   369: goto +8 -> 377
    //   372: astore_0
    //   373: aload_0
    //   374: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   377: ldc_w 659
    //   380: iconst_0
    //   381: anewarray 4	java/lang/Object
    //   384: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   387: pop
    //   388: aload_1
    //   389: athrow
    //   390: iconst_0
    //   391: ireturn
    //   392: ldc_w 661
    //   395: iconst_0
    //   396: anewarray 4	java/lang/Object
    //   399: invokestatic 172	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   402: pop
    //   403: iconst_0
    //   404: ireturn
    //   405: ldc_w 663
    //   408: iconst_0
    //   409: anewarray 4	java/lang/Object
    //   412: invokestatic 172	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   415: pop
    //   416: iconst_0
    //   417: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramFile1	File
    //   0	418	1	paramFile2	File
    //   0	418	2	paramInt	int
    //   87	9	3	localThrowable1	Throwable
    //   126	224	3	localObject1	Object
    //   356	2	3	localIOException	java.io.IOException
    //   116	1	4	localObject2	Object
    //   242	5	4	localObject3	Object
    //   252	34	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   47	72	87	java/lang/Throwable
    //   72	84	87	java/lang/Throwable
    //   205	209	212	java/io/IOException
    //   217	221	224	java/io/IOException
    //   150	177	242	finally
    //   177	183	242	finally
    //   187	194	242	finally
    //   197	205	242	finally
    //   150	177	252	java/lang/Throwable
    //   177	183	252	java/lang/Throwable
    //   187	194	252	java/lang/Throwable
    //   197	205	252	java/lang/Throwable
    //   127	150	262	finally
    //   127	150	268	java/lang/Throwable
    //   118	127	274	finally
    //   118	127	282	java/lang/Throwable
    //   303	307	310	java/io/IOException
    //   319	323	326	java/io/IOException
    //   288	299	344	finally
    //   349	353	356	java/io/IOException
    //   365	369	372	java/io/IOException
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Object localObject = w.a();
      if (localObject != null) {
        return ((w)localObject).a(paramRunnable);
      }
      localObject = paramRunnable.getClass().getName().split("\\.");
      if (a(paramRunnable, localObject[(localObject.length - 1)]) != null) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() <= 0);
  }
  
  public static byte[] a(Parcelable paramParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return paramParcelable;
  }
  
  /* Error */
  public static byte[] a(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +251 -> 252
    //   4: aload_1
    //   5: invokevirtual 365	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: ldc_w 624
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: new 699	java/io/ByteArrayInputStream
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 574
    //   32: invokevirtual 578	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   35: invokespecial 701	java/io/ByteArrayInputStream:<init>	([B)V
    //   38: astore 4
    //   40: new 703	java/io/ByteArrayOutputStream
    //   43: dup
    //   44: invokespecial 704	java/io/ByteArrayOutputStream:<init>	()V
    //   47: astore 5
    //   49: new 627	java/util/zip/ZipOutputStream
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 634	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: aload_1
    //   62: bipush 8
    //   64: invokevirtual 637	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   67: aload_1
    //   68: astore_0
    //   69: aload_1
    //   70: new 639	java/util/zip/ZipEntry
    //   73: dup
    //   74: aload_2
    //   75: invokespecial 641	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 645	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   81: aload_1
    //   82: astore_0
    //   83: sipush 1024
    //   86: newarray byte
    //   88: astore_2
    //   89: aload_1
    //   90: astore_0
    //   91: aload 4
    //   93: aload_2
    //   94: invokevirtual 705	java/io/ByteArrayInputStream:read	([B)I
    //   97: istore_3
    //   98: iload_3
    //   99: ifle +15 -> 114
    //   102: aload_1
    //   103: astore_0
    //   104: aload_1
    //   105: aload_2
    //   106: iconst_0
    //   107: iload_3
    //   108: invokevirtual 651	java/util/zip/ZipOutputStream:write	([BII)V
    //   111: goto -22 -> 89
    //   114: aload_1
    //   115: astore_0
    //   116: aload_1
    //   117: invokevirtual 655	java/util/zip/ZipOutputStream:closeEntry	()V
    //   120: aload_1
    //   121: astore_0
    //   122: aload_1
    //   123: invokevirtual 652	java/util/zip/ZipOutputStream:flush	()V
    //   126: aload_1
    //   127: astore_0
    //   128: aload_1
    //   129: invokevirtual 708	java/util/zip/ZipOutputStream:finish	()V
    //   132: aload_1
    //   133: astore_0
    //   134: aload 5
    //   136: invokevirtual 711	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   139: astore_2
    //   140: aload_1
    //   141: invokevirtual 657	java/util/zip/ZipOutputStream:close	()V
    //   144: goto +8 -> 152
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   152: ldc_w 659
    //   155: iconst_0
    //   156: anewarray 4	java/lang/Object
    //   159: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   162: pop
    //   163: aload_2
    //   164: areturn
    //   165: astore_2
    //   166: goto +12 -> 178
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_0
    //   172: goto +51 -> 223
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_1
    //   178: aload_1
    //   179: astore_0
    //   180: aload_2
    //   181: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   184: ifne +9 -> 193
    //   187: aload_1
    //   188: astore_0
    //   189: aload_2
    //   190: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   193: aload_1
    //   194: ifnull +15 -> 209
    //   197: aload_1
    //   198: invokevirtual 657	java/util/zip/ZipOutputStream:close	()V
    //   201: goto +8 -> 209
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   209: ldc_w 659
    //   212: iconst_0
    //   213: anewarray 4	java/lang/Object
    //   216: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   219: pop
    //   220: aconst_null
    //   221: areturn
    //   222: astore_1
    //   223: aload_0
    //   224: ifnull +15 -> 239
    //   227: aload_0
    //   228: invokevirtual 657	java/util/zip/ZipOutputStream:close	()V
    //   231: goto +8 -> 239
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   239: ldc_w 659
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokestatic 554	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   249: pop
    //   250: aload_1
    //   251: athrow
    //   252: aconst_null
    //   253: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramFile	File
    //   0	254	1	paramString1	String
    //   0	254	2	paramString2	String
    //   97	11	3	i	int
    //   38	54	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   47	88	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   140	144	147	java/io/IOException
    //   61	67	165	java/lang/Throwable
    //   69	81	165	java/lang/Throwable
    //   83	89	165	java/lang/Throwable
    //   91	98	165	java/lang/Throwable
    //   104	111	165	java/lang/Throwable
    //   116	120	165	java/lang/Throwable
    //   122	126	165	java/lang/Throwable
    //   128	132	165	java/lang/Throwable
    //   134	140	165	java/lang/Throwable
    //   24	59	169	finally
    //   24	59	175	java/lang/Throwable
    //   197	201	204	java/io/IOException
    //   61	67	222	finally
    //   69	81	222	finally
    //   83	89	222	finally
    //   91	98	222	finally
    //   104	111	222	finally
    //   116	120	222	finally
    //   122	126	222	finally
    //   128	132	222	finally
    //   134	140	222	finally
    //   180	187	222	finally
    //   189	193	222	finally
    //   227	231	234	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    x.c("[Util] Zip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), "Gzip" });
    try
    {
      ae localae = ad.a(2);
      if (localae == null) {
        return null;
      }
      paramArrayOfByte = localae.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!x.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static long b()
  {
    try
    {
      long l = (System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000L;
      int i = TimeZone.getDefault().getRawOffset();
      return l * 86400000L - i;
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if ((a.b() != null) && (a.b().G != null)) {
      return a.b().G.getString(paramString1, paramString2);
    }
    return "";
  }
  
  public static String b(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return localStringWriter.toString();
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
        localMessageDigest.update(paramArrayOfByte);
        paramArrayOfByte = a(localMessageDigest.digest());
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!x.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
        return null;
      }
    }
    return "NULL";
  }
  
  public static Map<String, String> b(Parcel paramParcel)
  {
    Object localObject = paramParcel.readBundle();
    paramParcel = null;
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList1 = ((Bundle)localObject).getStringArrayList("keys");
    ArrayList localArrayList2 = ((Bundle)localObject).getStringArrayList("values");
    int i = 0;
    if ((localArrayList1 != null) && (localArrayList2 != null) && (localArrayList1.size() == localArrayList2.size()))
    {
      localObject = new HashMap(localArrayList1.size());
      for (;;)
      {
        paramParcel = (Parcel)localObject;
        if (i >= localArrayList1.size()) {
          break;
        }
        ((HashMap)localObject).put(localArrayList1.get(i), localArrayList2.get(i));
        i += 1;
      }
    }
    x.e("map parcel error!", new Object[0]);
    return paramParcel;
  }
  
  public static void b(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public static void b(Parcel paramParcel, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      int i = paramMap.size();
      ArrayList localArrayList1 = new ArrayList(i);
      ArrayList localArrayList2 = new ArrayList(i);
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localArrayList1.add(localEntry.getKey());
        localArrayList2.add(localEntry.getValue());
      }
      paramMap = new Bundle();
      paramMap.putStringArrayList("keys", localArrayList1);
      paramMap.putStringArrayList("values", localArrayList2);
      paramParcel.writeBundle(paramMap);
      return;
    }
    paramParcel.writeBundle(null);
  }
  
  public static void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if ((paramString.isFile()) && (paramString.exists()) && (paramString.canWrite())) {
      paramString.delete();
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    x.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      paramContext = new File(localStringBuilder.toString());
      if (paramContext.exists())
      {
        if (paramContext.delete())
        {
          x.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
          return true;
        }
        return false;
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      x.a(paramContext);
    }
    return false;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    x.c("[Util] Unzip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), "Gzip" });
    try
    {
      ae localae = ad.a(2);
      if (localae == null) {
        return null;
      }
      paramArrayOfByte = localae.b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!x.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static long c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(new String(paramArrayOfByte, "utf-8"));
      return l;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1L;
  }
  
  /* Error */
  private static ArrayList<String> c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 828	com/tencent/bugly/crashreport/common/info/AppInfo:f	(Landroid/content/Context;)Z
    //   4: ifeq +24 -> 28
    //   7: new 468	java/util/ArrayList
    //   10: dup
    //   11: iconst_1
    //   12: anewarray 174	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 830
    //   20: aastore
    //   21: invokestatic 836	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   24: invokespecial 839	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   27: areturn
    //   28: new 468	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 469	java/util/ArrayList:<init>	()V
    //   35: astore 5
    //   37: aconst_null
    //   38: astore_3
    //   39: ldc_w 841
    //   42: astore_0
    //   43: new 30	java/io/File
    //   46: dup
    //   47: ldc_w 841
    //   50: invokespecial 555	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: invokevirtual 34	java/io/File:exists	()Z
    //   56: ifeq +333 -> 389
    //   59: new 30	java/io/File
    //   62: dup
    //   63: ldc_w 841
    //   66: invokespecial 555	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: invokevirtual 844	java/io/File:canExecute	()Z
    //   72: ifne +6 -> 78
    //   75: goto +314 -> 389
    //   78: new 468	java/util/ArrayList
    //   81: dup
    //   82: iconst_2
    //   83: anewarray 174	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: aload_0
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: ldc_w 846
    //   95: aastore
    //   96: invokestatic 836	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   99: invokespecial 839	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   102: astore_0
    //   103: aload_0
    //   104: aload_1
    //   105: invokeinterface 488 2 0
    //   110: pop
    //   111: invokestatic 193	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   114: aload_0
    //   115: iconst_3
    //   116: anewarray 174	java/lang/String
    //   119: invokeinterface 850 2 0
    //   124: checkcast 852	[Ljava/lang/String;
    //   127: invokevirtual 197	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   130: astore_1
    //   131: new 39	java/io/BufferedReader
    //   134: dup
    //   135: new 41	java/io/InputStreamReader
    //   138: dup
    //   139: aload_1
    //   140: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   143: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   146: invokespecial 54	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   154: astore_2
    //   155: aload_2
    //   156: ifnull +13 -> 169
    //   159: aload 5
    //   161: aload_2
    //   162: invokevirtual 514	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   165: pop
    //   166: goto -16 -> 150
    //   169: new 39	java/io/BufferedReader
    //   172: dup
    //   173: new 41	java/io/InputStreamReader
    //   176: dup
    //   177: aload_1
    //   178: invokevirtual 240	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   181: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   184: invokespecial 54	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   187: astore 4
    //   189: aload_0
    //   190: astore_1
    //   191: aload 4
    //   193: astore_2
    //   194: aload 4
    //   196: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   199: astore_3
    //   200: aload_3
    //   201: ifnull +18 -> 219
    //   204: aload_0
    //   205: astore_1
    //   206: aload 4
    //   208: astore_2
    //   209: aload 5
    //   211: aload_3
    //   212: invokevirtual 514	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   215: pop
    //   216: goto -27 -> 189
    //   219: aload_0
    //   220: invokevirtual 340	java/io/BufferedReader:close	()V
    //   223: goto +8 -> 231
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   231: aload 4
    //   233: invokevirtual 340	java/io/BufferedReader:close	()V
    //   236: aload 5
    //   238: areturn
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   244: aload 5
    //   246: areturn
    //   247: astore_1
    //   248: aload_0
    //   249: astore_3
    //   250: aload 4
    //   252: astore_0
    //   253: aload_1
    //   254: astore 4
    //   256: goto +38 -> 294
    //   259: astore_3
    //   260: aconst_null
    //   261: astore_2
    //   262: aload_0
    //   263: astore_1
    //   264: aload_3
    //   265: astore_0
    //   266: goto +83 -> 349
    //   269: astore 4
    //   271: aconst_null
    //   272: astore_1
    //   273: aload_0
    //   274: astore_3
    //   275: aload_1
    //   276: astore_0
    //   277: goto +17 -> 294
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_2
    //   283: aload_3
    //   284: astore_1
    //   285: goto +64 -> 349
    //   288: astore 4
    //   290: aconst_null
    //   291: astore_3
    //   292: aload_3
    //   293: astore_0
    //   294: aload_3
    //   295: astore_1
    //   296: aload_0
    //   297: astore_2
    //   298: aload 4
    //   300: invokestatic 59	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   303: ifne +12 -> 315
    //   306: aload_3
    //   307: astore_1
    //   308: aload_0
    //   309: astore_2
    //   310: aload 4
    //   312: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   315: aload_3
    //   316: ifnull +15 -> 331
    //   319: aload_3
    //   320: invokevirtual 340	java/io/BufferedReader:close	()V
    //   323: goto +8 -> 331
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   331: aload_0
    //   332: ifnull +14 -> 346
    //   335: aload_0
    //   336: invokevirtual 340	java/io/BufferedReader:close	()V
    //   339: aconst_null
    //   340: areturn
    //   341: astore_0
    //   342: aload_0
    //   343: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   346: aconst_null
    //   347: areturn
    //   348: astore_0
    //   349: aload_1
    //   350: ifnull +15 -> 365
    //   353: aload_1
    //   354: invokevirtual 340	java/io/BufferedReader:close	()V
    //   357: goto +8 -> 365
    //   360: astore_1
    //   361: aload_1
    //   362: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   365: aload_2
    //   366: ifnull +15 -> 381
    //   369: aload_2
    //   370: invokevirtual 340	java/io/BufferedReader:close	()V
    //   373: goto +8 -> 381
    //   376: astore_1
    //   377: aload_1
    //   378: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   381: goto +5 -> 386
    //   384: aload_0
    //   385: athrow
    //   386: goto -2 -> 384
    //   389: ldc_w 854
    //   392: astore_0
    //   393: goto -315 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramContext	Context
    //   0	396	1	paramString	String
    //   154	216	2	localObject1	Object
    //   38	212	3	localObject2	Object
    //   259	6	3	localObject3	Object
    //   274	46	3	localContext	Context
    //   187	68	4	localObject4	Object
    //   269	1	4	localThrowable1	Throwable
    //   288	23	4	localThrowable2	Throwable
    //   35	210	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   219	223	226	java/io/IOException
    //   231	236	239	java/io/IOException
    //   194	200	247	java/lang/Throwable
    //   209	216	247	java/lang/Throwable
    //   150	155	259	finally
    //   159	166	259	finally
    //   169	189	259	finally
    //   150	155	269	java/lang/Throwable
    //   159	166	269	java/lang/Throwable
    //   169	189	269	java/lang/Throwable
    //   43	59	280	finally
    //   59	75	280	finally
    //   78	150	280	finally
    //   43	59	288	java/lang/Throwable
    //   59	75	288	java/lang/Throwable
    //   78	150	288	java/lang/Throwable
    //   319	323	326	java/io/IOException
    //   335	339	341	java/io/IOException
    //   194	200	348	finally
    //   209	216	348	finally
    //   298	306	348	finally
    //   310	315	348	finally
    //   353	357	360	java/io/IOException
    //   369	373	376	java/io/IOException
  }
  
  public static boolean c(String paramString)
  {
    int i;
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    if (paramString.length() > 255)
    {
      x.a("URL(%s)'s length is larger than 255.", new Object[] { paramString });
      return false;
    }
    if (!paramString.toLowerCase().startsWith("http"))
    {
      x.a("URL(%s) is not start with \"http\".", new Object[] { paramString });
      return false;
    }
    return true;
  }
  
  public static byte[] c(long paramLong)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      localObject = ((StringBuilder)localObject).toString().getBytes("utf-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.proguard.z
 * JD-Core Version:    0.7.0.1
 */