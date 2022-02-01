package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BksUtil
{
  private static final String a = "BksUtil";
  private static final String b = "com.huawei.hwid";
  private static final String c = "com.huawei.hwid";
  private static final String d = "com.huawei.hms";
  private static final String e = "com.huawei.hwid.tv";
  private static final Uri f = Uri.parse("content://com.huawei.hwid");
  private static final String g = "files/hmsrootcas.bks";
  private static final String h = "4.0.2.300";
  private static final String i = "aegis";
  private static final String j = "hmsrootcas.bks";
  private static final long k = 604800000L;
  private static final String l = "last_update_time";
  private static final String m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
  private static final String n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
  private static final String o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";
  private static final String[] p = { "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539" };
  private static final String q = "";
  private static final String r = "bks_hash";
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      g.e("BksUtil", "The directory  has already exists");
      return 1;
    }
    if (paramString.mkdirs())
    {
      g.a("BksUtil", "create directory  success");
      return 0;
    }
    g.b("BksUtil", "create directory  failed");
    return -1;
  }
  
  private static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.createDeviceProtectedStorageContext().getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("aegis");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getApplicationContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("aegis");
    return localStringBuilder.toString();
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i2 = paramArrayOfByte.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = Integer.toHexString(paramArrayOfByte[i1] & 0xFF);
        if (str.length() == 1) {
          localStringBuilder.append('0');
        }
        localStringBuilder.append(str);
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  /* Error */
  private static void a(InputStream paramInputStream, Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +157 -> 158
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: invokestatic 166	com/huawei/secure/android/common/ssl/util/BksUtil:a	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore_1
    //   14: new 85	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 92	java/io/File:exists	()Z
    //   25: ifne +8 -> 33
    //   28: aload_1
    //   29: invokestatic 168	com/huawei/secure/android/common/ssl/util/BksUtil:a	(Ljava/lang/String;)I
    //   32: pop
    //   33: new 85	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: ldc 32
    //   40: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: astore 5
    //   45: aload 5
    //   47: invokevirtual 92	java/io/File:exists	()Z
    //   50: ifeq +9 -> 59
    //   53: aload 5
    //   55: invokevirtual 173	java/io/File:delete	()Z
    //   58: pop
    //   59: aconst_null
    //   60: astore_3
    //   61: aconst_null
    //   62: astore 4
    //   64: aload_3
    //   65: astore_1
    //   66: ldc 8
    //   68: ldc 175
    //   70: invokestatic 177	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_3
    //   74: astore_1
    //   75: new 179	java/io/FileOutputStream
    //   78: dup
    //   79: aload 5
    //   81: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   84: astore_3
    //   85: sipush 2048
    //   88: newarray byte
    //   90: astore_1
    //   91: aload_0
    //   92: aload_1
    //   93: iconst_0
    //   94: aload_1
    //   95: arraylength
    //   96: invokevirtual 188	java/io/InputStream:read	([BII)I
    //   99: istore_2
    //   100: iload_2
    //   101: iconst_m1
    //   102: if_icmpeq +13 -> 115
    //   105: aload_3
    //   106: aload_1
    //   107: iconst_0
    //   108: iload_2
    //   109: invokevirtual 194	java/io/OutputStream:write	([BII)V
    //   112: goto -21 -> 91
    //   115: aload_3
    //   116: invokestatic 199	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/OutputStream;)V
    //   119: return
    //   120: astore_0
    //   121: goto +31 -> 152
    //   124: aload_3
    //   125: astore_0
    //   126: goto +8 -> 134
    //   129: aload_1
    //   130: astore_3
    //   131: goto +21 -> 152
    //   134: aload_0
    //   135: astore_1
    //   136: ldc 8
    //   138: ldc 201
    //   140: invokestatic 110	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: invokestatic 199	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/OutputStream;)V
    //   147: return
    //   148: astore_0
    //   149: goto -20 -> 129
    //   152: aload_3
    //   153: invokestatic 199	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/OutputStream;)V
    //   156: aload_0
    //   157: athrow
    //   158: return
    //   159: astore_0
    //   160: aload 4
    //   162: astore_0
    //   163: goto -29 -> 134
    //   166: astore_0
    //   167: goto -43 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramInputStream	InputStream
    //   0	170	1	paramContext	Context
    //   99	10	2	i1	int
    //   60	93	3	localObject1	Object
    //   62	99	4	localObject2	Object
    //   43	37	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   85	91	120	finally
    //   91	100	120	finally
    //   105	112	120	finally
    //   66	73	148	finally
    //   75	85	148	finally
    //   136	143	148	finally
    //   66	73	159	java/io/IOException
    //   75	85	159	java/io/IOException
    //   85	91	166	java/io/IOException
    //   91	100	166	java/io/IOException
    //   105	112	166	java/io/IOException
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt >= 40002300;
  }
  
  private static byte[] a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      try
      {
        paramContext = paramContext.getPackageManager();
        if (paramContext != null)
        {
          paramContext = paramContext.getPackageInfo(paramString, 64);
          if (paramContext != null)
          {
            paramContext = paramContext.signatures[0].toByteArray();
            return paramContext;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("get pm exception : ");
        paramString.append(paramContext.getMessage());
        Log.e("BksUtil", paramString.toString());
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("PackageManager.NameNotFoundException : ");
        paramString.append(paramContext.getMessage());
        Log.e("BksUtil", paramString.toString());
      }
      return new byte[0];
    }
    Log.e("BksUtil", "packageName is null or context is null");
    return new byte[0];
  }
  
  private static String b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramContext));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("hmsrootcas.bks");
    return localStringBuilder.toString();
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = a(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      label28:
      break label28;
    }
    g.b("BksUtil", "inputstraem exception");
    return "";
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(c(a(paramContext, paramString)));
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hms version code is : ");
    ((StringBuilder)localObject).append(paramString);
    g.c("BksUtil", ((StringBuilder)localObject).toString());
    paramString = paramString.split("\\.");
    localObject = "4.0.2.300".split("\\.");
    int i4 = paramString.length;
    int i5 = localObject.length;
    int i6 = Math.max(i4, i5);
    int i1 = 0;
    if ((i1 >= i6) || (i1 < i4)) {}
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(paramString[i1]);
        if (i1 >= i5) {
          continue;
        }
        i3 = Integer.parseInt(localObject[i1]);
      }
      catch (Exception localException)
      {
        int i3;
        continue;
      }
      paramString = new StringBuilder();
      paramString.append(" exception : ");
      paramString.append(((Exception)localObject).getMessage());
      g.b("BksUtil", paramString.toString());
      if (i1 >= i5) {
        bool1 = true;
      }
      return bool1;
      i3 = 0;
      if (i2 < i3) {
        return false;
      }
      if (i2 > i3) {
        return true;
      }
      i1 += 1;
      break;
      return true;
      int i2 = 0;
    }
  }
  
  private static String c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return "";
      }
      try
      {
        paramArrayOfByte = a(MessageDigest.getInstance("SHA-256").digest(paramArrayOfByte));
        return paramArrayOfByte;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("NoSuchAlgorithmException");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        Log.e("BksUtil", localStringBuilder.toString());
      }
    }
    return "";
  }
  
  private static boolean c(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramContext));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("hmsrootcas.bks");
    return new File(localStringBuilder.toString()).exists();
  }
  
  private static boolean c(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    paramString = p;
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramString[i1].equalsIgnoreCase(c(paramContext))) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  /* Error */
  public static InputStream getBksFromTss(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 8
    //   5: ldc_w 305
    //   8: invokestatic 177	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: ifnull +7 -> 19
    //   15: aload_0
    //   16: invokestatic 310	com/huawei/secure/android/common/ssl/util/c:a	(Landroid/content/Context;)V
    //   19: invokestatic 312	com/huawei/secure/android/common/ssl/util/c:a	()Landroid/content/Context;
    //   22: astore 7
    //   24: aconst_null
    //   25: astore 5
    //   27: aconst_null
    //   28: astore 4
    //   30: aconst_null
    //   31: astore_3
    //   32: aload 7
    //   34: ifnonnull +16 -> 50
    //   37: ldc 8
    //   39: ldc_w 314
    //   42: invokestatic 110	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc 2
    //   47: monitorexit
    //   48: aconst_null
    //   49: areturn
    //   50: ldc 11
    //   52: invokestatic 319	com/huawei/secure/android/common/ssl/util/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokestatic 321	com/huawei/secure/android/common/ssl/util/BksUtil:b	(Ljava/lang/String;)Z
    //   58: ifne +54 -> 112
    //   61: ldc 15
    //   63: invokestatic 319	com/huawei/secure/android/common/ssl/util/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   66: invokestatic 321	com/huawei/secure/android/common/ssl/util/BksUtil:b	(Ljava/lang/String;)Z
    //   69: ifne +43 -> 112
    //   72: new 119	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   79: astore_0
    //   80: aload_0
    //   81: ldc_w 323
    //   84: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_0
    //   89: ldc 11
    //   91: invokestatic 319	com/huawei/secure/android/common/ssl/util/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: ldc 8
    //   100: aload_0
    //   101: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 110	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: ldc 2
    //   109: monitorexit
    //   110: aconst_null
    //   111: areturn
    //   112: aload 7
    //   114: ldc 11
    //   116: invokestatic 325	com/huawei/secure/android/common/ssl/util/BksUtil:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   119: ifne +26 -> 145
    //   122: aload 7
    //   124: ldc 15
    //   126: invokestatic 327	com/huawei/secure/android/common/ssl/util/BksUtil:b	(Landroid/content/Context;Ljava/lang/String;)Z
    //   129: ifne +16 -> 145
    //   132: ldc 8
    //   134: ldc_w 329
    //   137: invokestatic 110	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 2
    //   142: monitorexit
    //   143: aconst_null
    //   144: areturn
    //   145: new 331	java/io/ByteArrayOutputStream
    //   148: dup
    //   149: invokespecial 332	java/io/ByteArrayOutputStream:<init>	()V
    //   152: astore 6
    //   154: getstatic 68	com/huawei/secure/android/common/ssl/util/BksUtil:f	Landroid/net/Uri;
    //   157: ldc 23
    //   159: invokestatic 336	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   162: astore_0
    //   163: aload 7
    //   165: invokevirtual 340	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   168: aload_0
    //   169: invokevirtual 346	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   172: astore_0
    //   173: aload 4
    //   175: astore_3
    //   176: aload_0
    //   177: astore_2
    //   178: sipush 1024
    //   181: newarray byte
    //   183: astore 8
    //   185: aload 4
    //   187: astore_3
    //   188: aload_0
    //   189: astore_2
    //   190: aload_0
    //   191: aload 8
    //   193: invokevirtual 349	java/io/InputStream:read	([B)I
    //   196: istore_1
    //   197: iload_1
    //   198: iconst_m1
    //   199: if_icmple +20 -> 219
    //   202: aload 4
    //   204: astore_3
    //   205: aload_0
    //   206: astore_2
    //   207: aload 6
    //   209: aload 8
    //   211: iconst_0
    //   212: iload_1
    //   213: invokevirtual 350	java/io/ByteArrayOutputStream:write	([BII)V
    //   216: goto -31 -> 185
    //   219: aload 4
    //   221: astore_3
    //   222: aload_0
    //   223: astore_2
    //   224: aload 6
    //   226: invokevirtual 353	java/io/ByteArrayOutputStream:flush	()V
    //   229: aload 4
    //   231: astore_3
    //   232: aload_0
    //   233: astore_2
    //   234: new 355	java/io/ByteArrayInputStream
    //   237: dup
    //   238: aload 6
    //   240: invokevirtual 356	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   243: invokespecial 358	java/io/ByteArrayInputStream:<init>	([B)V
    //   246: astore 4
    //   248: ldc 56
    //   250: ldc 53
    //   252: aload 7
    //   254: invokestatic 363	com/huawei/secure/android/common/ssl/util/i:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   257: astore_2
    //   258: aload 6
    //   260: invokevirtual 356	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   263: invokestatic 365	com/huawei/secure/android/common/ssl/util/BksUtil:b	([B)Ljava/lang/String;
    //   266: astore_3
    //   267: aload 7
    //   269: invokestatic 367	com/huawei/secure/android/common/ssl/util/BksUtil:c	(Landroid/content/Context;)Z
    //   272: ifeq +25 -> 297
    //   275: aload_2
    //   276: aload_3
    //   277: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   280: ifne +6 -> 286
    //   283: goto +14 -> 297
    //   286: ldc 8
    //   288: ldc_w 373
    //   291: invokestatic 177	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: goto +26 -> 320
    //   297: ldc 8
    //   299: ldc_w 375
    //   302: invokestatic 177	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload 4
    //   307: aload 7
    //   309: invokestatic 377	com/huawei/secure/android/common/ssl/util/BksUtil:a	(Ljava/io/InputStream;Landroid/content/Context;)V
    //   312: ldc 56
    //   314: aload_3
    //   315: aload 7
    //   317: invokestatic 380	com/huawei/secure/android/common/ssl/util/i:b	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   320: aload_0
    //   321: invokestatic 383	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   324: aload 6
    //   326: invokestatic 199	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/OutputStream;)V
    //   329: aload 4
    //   331: invokestatic 383	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   334: goto +56 -> 390
    //   337: astore_3
    //   338: aload_0
    //   339: astore_2
    //   340: aload_3
    //   341: astore_0
    //   342: goto +63 -> 405
    //   345: goto +18 -> 363
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_2
    //   351: aload_3
    //   352: astore 4
    //   354: goto +51 -> 405
    //   357: aconst_null
    //   358: astore_0
    //   359: aload 5
    //   361: astore 4
    //   363: aload 4
    //   365: astore_3
    //   366: aload_0
    //   367: astore_2
    //   368: ldc 8
    //   370: ldc_w 385
    //   373: invokestatic 110	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload_0
    //   377: invokestatic 383	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   380: aload 6
    //   382: invokestatic 199	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/OutputStream;)V
    //   385: aload 4
    //   387: invokestatic 383	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   390: aload 7
    //   392: invokestatic 388	com/huawei/secure/android/common/ssl/util/BksUtil:getFilesBksIS	(Landroid/content/Context;)Ljava/io/InputStream;
    //   395: astore_0
    //   396: ldc 2
    //   398: monitorexit
    //   399: aload_0
    //   400: areturn
    //   401: astore_0
    //   402: goto -51 -> 351
    //   405: aload_2
    //   406: invokestatic 383	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   409: aload 6
    //   411: invokestatic 199	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/OutputStream;)V
    //   414: aload 4
    //   416: invokestatic 383	com/huawei/secure/android/common/ssl/util/f:a	(Ljava/io/InputStream;)V
    //   419: aload_0
    //   420: athrow
    //   421: astore_0
    //   422: ldc 2
    //   424: monitorexit
    //   425: goto +5 -> 430
    //   428: aload_0
    //   429: athrow
    //   430: goto -2 -> 428
    //   433: astore_0
    //   434: goto -77 -> 357
    //   437: astore_2
    //   438: aload 5
    //   440: astore 4
    //   442: goto -79 -> 363
    //   445: astore_2
    //   446: goto -101 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	paramContext	Context
    //   196	17	1	i1	int
    //   177	229	2	localObject1	Object
    //   437	1	2	localException1	Exception
    //   445	1	2	localException2	Exception
    //   31	284	3	localObject2	Object
    //   337	15	3	localObject3	Object
    //   365	1	3	localObject4	Object
    //   28	413	4	localObject5	Object
    //   25	414	5	localObject6	Object
    //   152	258	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   22	369	7	localContext	Context
    //   183	27	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   248	283	337	finally
    //   286	294	337	finally
    //   297	320	337	finally
    //   154	173	348	finally
    //   178	185	401	finally
    //   190	197	401	finally
    //   207	216	401	finally
    //   224	229	401	finally
    //   234	248	401	finally
    //   368	376	401	finally
    //   3	11	421	finally
    //   15	19	421	finally
    //   19	24	421	finally
    //   37	45	421	finally
    //   50	107	421	finally
    //   112	140	421	finally
    //   145	154	421	finally
    //   320	334	421	finally
    //   376	390	421	finally
    //   390	396	421	finally
    //   405	421	421	finally
    //   154	173	433	java/lang/Exception
    //   178	185	437	java/lang/Exception
    //   190	197	437	java/lang/Exception
    //   207	216	437	java/lang/Exception
    //   224	229	437	java/lang/Exception
    //   234	248	437	java/lang/Exception
    //   248	283	445	java/lang/Exception
    //   286	294	445	java/lang/Exception
    //   297	320	445	java/lang/Exception
  }
  
  public static InputStream getFilesBksIS(Context paramContext)
  {
    if (c(paramContext)) {
      g.c("BksUtil", "getFilesBksIS ");
    }
    try
    {
      paramContext = new FileInputStream(b(paramContext));
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
      label29:
      break label29;
    }
    g.b("BksUtil", "FileNotFoundExceptio: ");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.BksUtil
 * JD-Core Version:    0.7.0.1
 */