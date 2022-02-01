package com.tencent.biz.pubaccount.util;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;

public class PreloadManager
{
  private static PreloadManager i;
  public final String a = "ReadInJoyArticleDetailPreloadManager";
  volatile boolean b;
  volatile boolean c;
  public Object d = new Object();
  ArrayList<PreloadManager.ImgStruct> e = new ArrayList();
  Object f = new Object();
  Object g = new Object();
  Handler h = new Handler(Looper.getMainLooper());
  private List<String> j = new CopyOnWriteArrayList();
  private List<String> k = new CopyOnWriteArrayList();
  private MQLruCache<String, byte[]> l = new MQLruCache(30);
  private volatile HashMap<String, ArrayList<PreloadManager.ImgStruct>> m = new HashMap();
  
  public static PreloadManager a()
  {
    if (i == null) {
      i = new PreloadManager();
    }
    return i;
  }
  
  /* Error */
  private ArrayList<PreloadManager.ImgStruct> a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 8
    //   9: iload 5
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 49	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 50	java/util/ArrayList:<init>	()V
    //   23: pop
    //   24: new 49	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 50	java/util/ArrayList:<init>	()V
    //   31: pop
    //   32: new 49	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 50	java/util/ArrayList:<init>	()V
    //   39: astore 9
    //   41: ldc 101
    //   43: invokestatic 107	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   46: aload_1
    //   47: invokevirtual 111	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 117	java/util/regex/Matcher:find	()Z
    //   55: ifeq +385 -> 440
    //   58: ldc 119
    //   60: invokestatic 107	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   63: aload_1
    //   64: invokevirtual 123	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   67: invokevirtual 111	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   70: astore 10
    //   72: aconst_null
    //   73: astore 6
    //   75: aload 10
    //   77: invokevirtual 117	java/util/regex/Matcher:find	()Z
    //   80: ifeq +360 -> 440
    //   83: ldc 36
    //   85: iconst_2
    //   86: aload 10
    //   88: invokevirtual 123	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   91: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: ldc 130
    //   96: invokestatic 107	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   99: aload 10
    //   101: invokevirtual 123	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   104: invokevirtual 111	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   107: invokevirtual 117	java/util/regex/Matcher:find	()Z
    //   110: ifeq -35 -> 75
    //   113: ldc 132
    //   115: invokestatic 107	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   118: aload 10
    //   120: invokevirtual 123	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   123: invokevirtual 111	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   126: astore 7
    //   128: aload 8
    //   130: astore_1
    //   131: aload 7
    //   133: invokevirtual 117	java/util/regex/Matcher:find	()Z
    //   136: ifeq +10 -> 146
    //   139: aload 7
    //   141: iconst_1
    //   142: invokevirtual 135	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   145: astore_1
    //   146: ldc 137
    //   148: invokestatic 107	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   151: aload 10
    //   153: invokevirtual 123	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   156: invokevirtual 111	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   159: astore 8
    //   161: aload 6
    //   163: astore 7
    //   165: aload 8
    //   167: invokevirtual 117	java/util/regex/Matcher:find	()Z
    //   170: ifeq +11 -> 181
    //   173: aload 8
    //   175: iconst_1
    //   176: invokevirtual 135	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   179: astore 7
    //   181: aload_1
    //   182: astore 8
    //   184: aload 7
    //   186: astore 6
    //   188: aload_1
    //   189: ifnull -114 -> 75
    //   192: aload_1
    //   193: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +13 -> 209
    //   199: aload_1
    //   200: astore 8
    //   202: aload 7
    //   204: astore 6
    //   206: goto -131 -> 75
    //   209: aload_0
    //   210: aload_1
    //   211: iconst_1
    //   212: iload_2
    //   213: invokevirtual 140	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;ZZ)Ljava/util/List;
    //   216: astore 11
    //   218: aload_0
    //   219: aload 7
    //   221: iconst_0
    //   222: iload_2
    //   223: invokevirtual 140	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;ZZ)Ljava/util/List;
    //   226: astore 12
    //   228: aload 11
    //   230: invokeinterface 146 1 0
    //   235: istore_3
    //   236: aload 12
    //   238: invokeinterface 146 1 0
    //   243: istore 4
    //   245: iload 4
    //   247: ifeq +127 -> 374
    //   250: iload 4
    //   252: iload_3
    //   253: if_icmplt +121 -> 374
    //   256: iload 4
    //   258: iload_3
    //   259: if_icmple +6 -> 265
    //   262: goto +112 -> 374
    //   265: iconst_0
    //   266: istore_3
    //   267: aload_1
    //   268: astore 8
    //   270: aload 7
    //   272: astore 6
    //   274: iload_3
    //   275: aload 11
    //   277: invokeinterface 146 1 0
    //   282: if_icmpge -207 -> 75
    //   285: new 148	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct
    //   288: dup
    //   289: invokespecial 149	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:<init>	()V
    //   292: astore 6
    //   294: aload 6
    //   296: aload 11
    //   298: iload_3
    //   299: invokeinterface 153 2 0
    //   304: checkcast 155	java/lang/String
    //   307: putfield 156	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:a	Ljava/lang/String;
    //   310: aload 6
    //   312: aload 12
    //   314: iload_3
    //   315: invokeinterface 153 2 0
    //   320: checkcast 155	java/lang/String
    //   323: invokestatic 162	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   326: putfield 165	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:b	I
    //   329: goto +20 -> 349
    //   332: astore_1
    //   333: goto +31 -> 364
    //   336: astore 8
    //   338: aload 6
    //   340: iconst_0
    //   341: putfield 165	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:b	I
    //   344: aload 8
    //   346: invokevirtual 168	java/lang/NumberFormatException:printStackTrace	()V
    //   349: aload 9
    //   351: aload 6
    //   353: invokevirtual 172	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   356: pop
    //   357: iload_3
    //   358: iconst_1
    //   359: iadd
    //   360: istore_3
    //   361: goto -94 -> 267
    //   364: aload 9
    //   366: aload 6
    //   368: invokevirtual 172	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload_1
    //   373: athrow
    //   374: iconst_0
    //   375: istore_3
    //   376: aload_1
    //   377: astore 8
    //   379: aload 7
    //   381: astore 6
    //   383: iload_3
    //   384: aload 11
    //   386: invokeinterface 146 1 0
    //   391: if_icmpge -316 -> 75
    //   394: new 148	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct
    //   397: dup
    //   398: invokespecial 149	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:<init>	()V
    //   401: astore 6
    //   403: aload 6
    //   405: aload 11
    //   407: iload_3
    //   408: invokeinterface 153 2 0
    //   413: checkcast 155	java/lang/String
    //   416: putfield 156	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:a	Ljava/lang/String;
    //   419: aload 6
    //   421: iconst_0
    //   422: putfield 165	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:b	I
    //   425: aload 9
    //   427: aload 6
    //   429: invokevirtual 172	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   432: pop
    //   433: iload_3
    //   434: iconst_1
    //   435: iadd
    //   436: istore_3
    //   437: goto -61 -> 376
    //   440: aload 9
    //   442: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	PreloadManager
    //   0	443	1	paramString	String
    //   0	443	2	paramBoolean	boolean
    //   235	202	3	n	int
    //   243	17	4	i1	int
    //   4	6	5	bool	boolean
    //   73	355	6	localObject1	Object
    //   126	254	7	localObject2	Object
    //   7	262	8	localObject3	Object
    //   336	9	8	localNumberFormatException	java.lang.NumberFormatException
    //   377	1	8	str	String
    //   39	402	9	localArrayList	ArrayList
    //   70	82	10	localMatcher	java.util.regex.Matcher
    //   216	190	11	localList1	List
    //   226	87	12	localList2	List
    // Exception table:
    //   from	to	target	type
    //   310	329	332	finally
    //   338	349	332	finally
    //   310	329	336	java/lang/NumberFormatException
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!i()) {
      return;
    }
    Object localObject = new HashMap();
    String str = "1";
    ((HashMap)localObject).put("param_dataSource", "1");
    if (!((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect()) {
      str = "0";
    }
    ((HashMap)localObject).put("param_enableIpConnect", str);
    ((HashMap)localObject).put("param_connType", String.valueOf(paramInt));
    ((HashMap)localObject).put("param_host", paramString1);
    ((HashMap)localObject).put("param_ipAddr", paramString2);
    ((HashMap)localObject).put("param_ipConnResult", paramString3);
    ((HashMap)localObject).put("param_hostConnResult", paramString4);
    paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyIpConnect", paramBoolean, paramLong, 0L, (HashMap)localObject, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doStatisticReport-->success:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", costTime:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", param_dataSource:1, param_enableIpConnect:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", param_connType:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", param_host:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", param_ipAddr:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", param_ipConnResult:");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", param_hostConnResult:");
      ((StringBuilder)localObject).append(paramString4);
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 == null) {
      return null;
    }
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1, "AES");
    try
    {
      paramArrayOfByte1 = Cipher.getInstance("AES");
    }
    catch (NoSuchPaddingException paramArrayOfByte1) {}catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      break label43;
    }
    paramArrayOfByte1.printStackTrace();
    break label47;
    label43:
    paramArrayOfByte1.printStackTrace();
    label47:
    paramArrayOfByte1 = null;
    try
    {
      paramArrayOfByte1.init(2, localSecretKeySpec);
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      localInvalidKeyException.printStackTrace();
    }
    try
    {
      paramArrayOfByte1 = paramArrayOfByte1.doFinal(paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (OutOfMemoryError paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (BadPaddingException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (IllegalBlockSizeException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return null;
  }
  
  private String b(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("http:"))
    {
      if (paramString.startsWith("https")) {
        return paramString;
      }
      if (paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https:");
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("http:");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  /* Error */
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: new 311	javax/crypto/spec/SecretKeySpec
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 313
    //   8: invokespecial 316	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   11: astore_0
    //   12: ldc_w 313
    //   15: invokestatic 321	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_1
    //   21: aload_0
    //   22: invokevirtual 327	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 332	javax/crypto/Cipher:doFinal	([B)[B
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 334	javax/crypto/BadPaddingException:printStackTrace	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 335	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 328	java/security/InvalidKeyException:printStackTrace	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: goto +11 -> 66
    //   58: astore_0
    //   59: goto +13 -> 72
    //   62: astore_0
    //   63: goto +15 -> 78
    //   66: aload_0
    //   67: invokevirtual 333	java/lang/OutOfMemoryError:printStackTrace	()V
    //   70: aconst_null
    //   71: areturn
    //   72: aload_0
    //   73: invokevirtual 322	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   76: aconst_null
    //   77: areturn
    //   78: aload_0
    //   79: invokevirtual 323	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   82: aconst_null
    //   83: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramArrayOfByte1	byte[]
    //   0	84	1	paramArrayOfByte2	byte[]
    //   18	8	2	localCipher	Cipher
    // Exception table:
    //   from	to	target	type
    //   25	31	33	javax/crypto/BadPaddingException
    //   25	31	40	javax/crypto/IllegalBlockSizeException
    //   19	25	47	java/security/InvalidKeyException
    //   25	31	47	java/security/InvalidKeyException
    //   34	38	47	java/security/InvalidKeyException
    //   41	45	47	java/security/InvalidKeyException
    //   12	19	54	java/lang/OutOfMemoryError
    //   19	25	54	java/lang/OutOfMemoryError
    //   25	31	54	java/lang/OutOfMemoryError
    //   34	38	54	java/lang/OutOfMemoryError
    //   41	45	54	java/lang/OutOfMemoryError
    //   48	52	54	java/lang/OutOfMemoryError
    //   12	19	58	javax/crypto/NoSuchPaddingException
    //   19	25	58	javax/crypto/NoSuchPaddingException
    //   25	31	58	javax/crypto/NoSuchPaddingException
    //   34	38	58	javax/crypto/NoSuchPaddingException
    //   41	45	58	javax/crypto/NoSuchPaddingException
    //   48	52	58	javax/crypto/NoSuchPaddingException
    //   12	19	62	java/security/NoSuchAlgorithmException
    //   19	25	62	java/security/NoSuchAlgorithmException
    //   25	31	62	java/security/NoSuchAlgorithmException
    //   34	38	62	java/security/NoSuchAlgorithmException
    //   41	45	62	java/security/NoSuchAlgorithmException
    //   48	52	62	java/security/NoSuchAlgorithmException
  }
  
  static int c(String paramString)
  {
    paramString = MD5Utils.toMD5(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".temp");
    localObject = ((StringBuilder)localObject).toString();
    paramString = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE, paramString);
    localObject = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE, (String)localObject);
    if (paramString.exists()) {
      return 2;
    }
    if (((File)localObject).exists()) {
      return 1;
    }
    return 0;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("article_id");
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static byte[] e(String paramString)
  {
    SecureRandom localSecureRandom = new SecureRandom();
    Object localObject = new byte[32];
    localSecureRandom.nextBytes((byte[])localObject);
    localObject = new PBEKeySpec(paramString.toCharArray(), (byte[])localObject, 1000, 256);
    localSecureRandom = null;
    try
    {
      paramString = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    try
    {
      paramString = paramString.generateSecret((KeySpec)localObject).getEncoded();
    }
    catch (InvalidKeySpecException paramString)
    {
      paramString.printStackTrace();
      paramString = localSecureRandom;
    }
    return new SecretKeySpec(paramString, "AES").getEncoded();
  }
  
  /* Error */
  private void h(String paramString)
  {
    // Byte code:
    //   0: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 8
    //   11: aload 8
    //   13: astore 6
    //   15: lload 4
    //   17: lstore_2
    //   18: aload_1
    //   19: invokestatic 428	com/tencent/biz/pubaccount/util/PreloadManager:d	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 9
    //   24: aload 9
    //   26: ifnonnull +4 -> 30
    //   29: return
    //   30: aload 8
    //   32: astore 6
    //   34: lload 4
    //   36: lstore_2
    //   37: invokestatic 241	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   40: invokevirtual 245	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   43: checkcast 430	com/tencent/mobileqq/app/QQAppInterface
    //   46: invokevirtual 433	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   49: astore 11
    //   51: aload 8
    //   53: astore 6
    //   55: lload 4
    //   57: lstore_2
    //   58: new 263	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   65: astore 10
    //   67: aload 8
    //   69: astore 6
    //   71: lload 4
    //   73: lstore_2
    //   74: aload 10
    //   76: getstatic 436	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   79: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 8
    //   85: astore 6
    //   87: lload 4
    //   89: lstore_2
    //   90: aload 10
    //   92: aload 9
    //   94: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 8
    //   100: astore 6
    //   102: lload 4
    //   104: lstore_2
    //   105: aload 10
    //   107: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 10
    //   112: aload 8
    //   114: astore 6
    //   116: lload 4
    //   118: lstore_2
    //   119: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +99 -> 221
    //   125: aload 8
    //   127: astore 6
    //   129: lload 4
    //   131: lstore_2
    //   132: new 263	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   139: astore 12
    //   141: aload 8
    //   143: astore 6
    //   145: lload 4
    //   147: lstore_2
    //   148: aload 12
    //   150: ldc_w 438
    //   153: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 8
    //   159: astore 6
    //   161: lload 4
    //   163: lstore_2
    //   164: aload 12
    //   166: aload 10
    //   168: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 8
    //   174: astore 6
    //   176: lload 4
    //   178: lstore_2
    //   179: aload 12
    //   181: ldc_w 440
    //   184: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 8
    //   190: astore 6
    //   192: lload 4
    //   194: lstore_2
    //   195: aload 12
    //   197: aload_1
    //   198: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 8
    //   204: astore 6
    //   206: lload 4
    //   208: lstore_2
    //   209: ldc_w 442
    //   212: iconst_2
    //   213: aload 12
    //   215: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 444	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload 8
    //   223: astore 6
    //   225: lload 4
    //   227: lstore_2
    //   228: aload 10
    //   230: invokestatic 449	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   233: ifeq +47 -> 280
    //   236: aload 8
    //   238: astore 6
    //   240: lload 4
    //   242: lstore_2
    //   243: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +19 -> 265
    //   249: aload 8
    //   251: astore 6
    //   253: lload 4
    //   255: lstore_2
    //   256: ldc 36
    //   258: iconst_2
    //   259: ldc_w 451
    //   262: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload 8
    //   267: astore 6
    //   269: lload 4
    //   271: lstore_2
    //   272: aload_0
    //   273: aload_1
    //   274: aload 11
    //   276: invokevirtual 453	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: return
    //   280: aload 8
    //   282: astore 6
    //   284: lload 4
    //   286: lstore_2
    //   287: aload_0
    //   288: aload_1
    //   289: invokespecial 455	com/tencent/biz/pubaccount/util/PreloadManager:i	(Ljava/lang/String;)Ljava/lang/String;
    //   292: astore 12
    //   294: aload 12
    //   296: ifnonnull +4 -> 300
    //   299: return
    //   300: aload 8
    //   302: astore 6
    //   304: lload 4
    //   306: lstore_2
    //   307: aload_0
    //   308: aload_0
    //   309: aload 12
    //   311: aload_1
    //   312: ldc_w 344
    //   315: invokevirtual 342	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   318: invokespecial 91	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;Z)Ljava/util/ArrayList;
    //   321: putfield 52	com/tencent/biz/pubaccount/util/PreloadManager:e	Ljava/util/ArrayList;
    //   324: aload 8
    //   326: astore 6
    //   328: lload 4
    //   330: lstore_2
    //   331: aload_0
    //   332: getfield 47	com/tencent/biz/pubaccount/util/PreloadManager:d	Ljava/lang/Object;
    //   335: astore_1
    //   336: aload 8
    //   338: astore 6
    //   340: lload 4
    //   342: lstore_2
    //   343: aload_1
    //   344: monitorenter
    //   345: aload_0
    //   346: getfield 68	com/tencent/biz/pubaccount/util/PreloadManager:m	Ljava/util/HashMap;
    //   349: aload 9
    //   351: aload_0
    //   352: getfield 52	com/tencent/biz/pubaccount/util/PreloadManager:e	Ljava/util/ArrayList;
    //   355: invokevirtual 189	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: pop
    //   359: new 263	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   366: astore 6
    //   368: aload 6
    //   370: ldc_w 457
    //   373: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 6
    //   379: aload 9
    //   381: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: ldc 36
    //   387: iconst_2
    //   388: aload 6
    //   390: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload_1
    //   397: monitorexit
    //   398: aload 8
    //   400: astore 6
    //   402: lload 4
    //   404: lstore_2
    //   405: aload_0
    //   406: getfield 459	com/tencent/biz/pubaccount/util/PreloadManager:c	Z
    //   409: ifne +42 -> 451
    //   412: aload 8
    //   414: astore 6
    //   416: lload 4
    //   418: lstore_2
    //   419: invokestatic 464	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   422: iconst_1
    //   423: if_icmpne +28 -> 451
    //   426: aload 8
    //   428: astore 6
    //   430: lload 4
    //   432: lstore_2
    //   433: aload_0
    //   434: invokevirtual 466	com/tencent/biz/pubaccount/util/PreloadManager:g	()Z
    //   437: ifeq +14 -> 451
    //   440: aload 8
    //   442: astore 6
    //   444: lload 4
    //   446: lstore_2
    //   447: aload_0
    //   448: invokevirtual 468	com/tencent/biz/pubaccount/util/PreloadManager:e	()V
    //   451: aload 8
    //   453: astore 6
    //   455: lload 4
    //   457: lstore_2
    //   458: aload_0
    //   459: getfield 63	com/tencent/biz/pubaccount/util/PreloadManager:l	Landroid/support/v4/util/MQLruCache;
    //   462: aload 9
    //   464: aload 12
    //   466: invokevirtual 471	java/lang/String:getBytes	()[B
    //   469: invokevirtual 472	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   472: pop
    //   473: aload 8
    //   475: astore 6
    //   477: lload 4
    //   479: lstore_2
    //   480: aload 12
    //   482: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   485: ifeq +118 -> 603
    //   488: aload 8
    //   490: astore 6
    //   492: lload 4
    //   494: lstore_2
    //   495: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   498: lload 4
    //   500: lsub
    //   501: lstore 4
    //   503: aload 8
    //   505: astore 6
    //   507: lload 4
    //   509: lstore_2
    //   510: ldc_w 474
    //   513: invokestatic 197	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   516: checkcast 474	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   519: astore_1
    //   520: aload 8
    //   522: astore 6
    //   524: lload 4
    //   526: lstore_2
    //   527: new 263	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   534: astore 9
    //   536: aload 8
    //   538: astore 6
    //   540: lload 4
    //   542: lstore_2
    //   543: aload 9
    //   545: ldc 254
    //   547: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 8
    //   553: astore 6
    //   555: lload 4
    //   557: lstore_2
    //   558: aload 9
    //   560: lload 4
    //   562: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 8
    //   568: astore 6
    //   570: lload 4
    //   572: lstore_2
    //   573: aload_1
    //   574: aconst_null
    //   575: ldc 254
    //   577: ldc_w 476
    //   580: ldc_w 476
    //   583: iconst_0
    //   584: iconst_0
    //   585: ldc 202
    //   587: aload 9
    //   589: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: ldc_w 478
    //   595: ldc 254
    //   597: invokeinterface 482 11 0
    //   602: return
    //   603: aload 8
    //   605: astore 6
    //   607: lload 4
    //   609: lstore_2
    //   610: new 263	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   617: astore_1
    //   618: aload 8
    //   620: astore 6
    //   622: lload 4
    //   624: lstore_2
    //   625: aload_1
    //   626: aload 12
    //   628: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 8
    //   634: astore 6
    //   636: lload 4
    //   638: lstore_2
    //   639: aload_1
    //   640: ldc_w 484
    //   643: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload 8
    //   649: astore 6
    //   651: lload 4
    //   653: lstore_2
    //   654: aload_1
    //   655: aload 9
    //   657: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload 8
    //   663: astore 6
    //   665: lload 4
    //   667: lstore_2
    //   668: aload_1
    //   669: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokevirtual 471	java/lang/String:getBytes	()[B
    //   675: astore_1
    //   676: aload 8
    //   678: astore 6
    //   680: lload 4
    //   682: lstore_2
    //   683: aload 11
    //   685: invokestatic 486	com/tencent/biz/pubaccount/util/PreloadManager:e	(Ljava/lang/String;)[B
    //   688: astore 11
    //   690: aload 11
    //   692: ifnonnull +718 -> 1410
    //   695: return
    //   696: aload 8
    //   698: astore 6
    //   700: lload 4
    //   702: lstore_2
    //   703: aload 11
    //   705: aload_1
    //   706: invokestatic 488	com/tencent/biz/pubaccount/util/PreloadManager:b	([B[B)[B
    //   709: astore 11
    //   711: aload 8
    //   713: astore 6
    //   715: lload 4
    //   717: lstore_2
    //   718: new 357	java/io/File
    //   721: dup
    //   722: getstatic 436	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   725: invokespecial 490	java/io/File:<init>	(Ljava/lang/String;)V
    //   728: astore_1
    //   729: aload 8
    //   731: astore 6
    //   733: lload 4
    //   735: lstore_2
    //   736: aload_1
    //   737: invokevirtual 368	java/io/File:exists	()Z
    //   740: ifne +18 -> 758
    //   743: aload 8
    //   745: astore 6
    //   747: lload 4
    //   749: lstore_2
    //   750: aload_1
    //   751: invokevirtual 493	java/io/File:mkdirs	()Z
    //   754: ifne +4 -> 758
    //   757: return
    //   758: aload 8
    //   760: astore 6
    //   762: lload 4
    //   764: lstore_2
    //   765: new 263	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   772: astore 12
    //   774: aload 8
    //   776: astore 6
    //   778: lload 4
    //   780: lstore_2
    //   781: aload 12
    //   783: aload 9
    //   785: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload 8
    //   791: astore 6
    //   793: lload 4
    //   795: lstore_2
    //   796: aload 12
    //   798: ldc_w 495
    //   801: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 8
    //   807: astore 6
    //   809: lload 4
    //   811: lstore_2
    //   812: new 497	java/io/FileOutputStream
    //   815: dup
    //   816: new 357	java/io/File
    //   819: dup
    //   820: aload_1
    //   821: aload 12
    //   823: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokespecial 500	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   829: invokespecial 503	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   832: astore_1
    //   833: aload 11
    //   835: ifnonnull +134 -> 969
    //   838: lload 4
    //   840: lstore_2
    //   841: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   844: ifeq +15 -> 859
    //   847: lload 4
    //   849: lstore_2
    //   850: ldc 36
    //   852: iconst_2
    //   853: ldc_w 505
    //   856: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   859: lload 4
    //   861: lstore_2
    //   862: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   865: lload 4
    //   867: lsub
    //   868: lstore 4
    //   870: lload 4
    //   872: lstore_2
    //   873: ldc_w 474
    //   876: invokestatic 197	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   879: checkcast 474	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   882: astore 6
    //   884: lload 4
    //   886: lstore_2
    //   887: new 263	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   894: astore 7
    //   896: lload 4
    //   898: lstore_2
    //   899: aload 7
    //   901: ldc 254
    //   903: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: lload 4
    //   909: lstore_2
    //   910: aload 7
    //   912: lload 4
    //   914: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: lload 4
    //   920: lstore_2
    //   921: aload 6
    //   923: aconst_null
    //   924: ldc 254
    //   926: ldc_w 476
    //   929: ldc_w 476
    //   932: iconst_0
    //   933: iconst_0
    //   934: ldc 202
    //   936: aload 7
    //   938: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: ldc_w 478
    //   944: ldc 254
    //   946: invokeinterface 482 11 0
    //   951: lload 4
    //   953: lstore_2
    //   954: aload_1
    //   955: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   958: aload_1
    //   959: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   962: return
    //   963: astore_1
    //   964: aload_1
    //   965: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   968: return
    //   969: lload 4
    //   971: lstore_2
    //   972: aload_1
    //   973: aload 11
    //   975: invokevirtual 512	java/io/FileOutputStream:write	([B)V
    //   978: lload 4
    //   980: lstore_2
    //   981: aload_1
    //   982: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   985: lload 4
    //   987: lstore_2
    //   988: new 263	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   995: astore 6
    //   997: lload 4
    //   999: lstore_2
    //   1000: aload 6
    //   1002: getstatic 436	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   1005: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: pop
    //   1009: lload 4
    //   1011: lstore_2
    //   1012: aload 6
    //   1014: aload 9
    //   1016: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: lload 4
    //   1022: lstore_2
    //   1023: aload 6
    //   1025: ldc_w 495
    //   1028: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: lload 4
    //   1034: lstore_2
    //   1035: new 357	java/io/File
    //   1038: dup
    //   1039: aload 6
    //   1041: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: invokespecial 490	java/io/File:<init>	(Ljava/lang/String;)V
    //   1047: new 357	java/io/File
    //   1050: dup
    //   1051: aload 10
    //   1053: invokespecial 490	java/io/File:<init>	(Ljava/lang/String;)V
    //   1056: invokevirtual 516	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1059: pop
    //   1060: lload 4
    //   1062: lstore_2
    //   1063: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   1066: lload 4
    //   1068: lsub
    //   1069: lstore 4
    //   1071: lload 4
    //   1073: lstore_2
    //   1074: ldc_w 474
    //   1077: invokestatic 197	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1080: checkcast 474	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   1083: astore 6
    //   1085: lload 4
    //   1087: lstore_2
    //   1088: new 263	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1095: astore 7
    //   1097: lload 4
    //   1099: lstore_2
    //   1100: aload 7
    //   1102: ldc 254
    //   1104: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: pop
    //   1108: lload 4
    //   1110: lstore_2
    //   1111: aload 7
    //   1113: lload 4
    //   1115: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: lload 4
    //   1121: lstore_2
    //   1122: aload 6
    //   1124: aconst_null
    //   1125: ldc 254
    //   1127: ldc_w 476
    //   1130: ldc_w 476
    //   1133: iconst_0
    //   1134: iconst_0
    //   1135: ldc 183
    //   1137: aload 7
    //   1139: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1142: ldc_w 478
    //   1145: ldc 254
    //   1147: invokeinterface 482 11 0
    //   1152: aload_1
    //   1153: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   1156: return
    //   1157: astore 6
    //   1159: aload_1
    //   1160: astore 7
    //   1162: aload 6
    //   1164: astore_1
    //   1165: aload 7
    //   1167: astore 6
    //   1169: goto +211 -> 1380
    //   1172: astore 7
    //   1174: goto +90 -> 1264
    //   1177: aload 8
    //   1179: astore 6
    //   1181: lload 4
    //   1183: lstore_2
    //   1184: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1187: ifeq +228 -> 1415
    //   1190: aload 8
    //   1192: astore 6
    //   1194: lload 4
    //   1196: lstore_2
    //   1197: ldc 36
    //   1199: iconst_2
    //   1200: ldc_w 518
    //   1203: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1206: return
    //   1207: aload 8
    //   1209: astore 6
    //   1211: lload 4
    //   1213: lstore_2
    //   1214: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1217: ifeq +19 -> 1236
    //   1220: aload 8
    //   1222: astore 6
    //   1224: lload 4
    //   1226: lstore_2
    //   1227: ldc 36
    //   1229: iconst_2
    //   1230: ldc_w 518
    //   1233: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1236: return
    //   1237: astore 9
    //   1239: aload_1
    //   1240: monitorexit
    //   1241: aload 8
    //   1243: astore 6
    //   1245: lload 4
    //   1247: lstore_2
    //   1248: aload 9
    //   1250: athrow
    //   1251: astore_1
    //   1252: goto +128 -> 1380
    //   1255: astore 6
    //   1257: aload 7
    //   1259: astore_1
    //   1260: aload 6
    //   1262: astore 7
    //   1264: aload_1
    //   1265: astore 6
    //   1267: aload 7
    //   1269: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   1272: aload_1
    //   1273: astore 6
    //   1275: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   1278: lstore 4
    //   1280: aload_1
    //   1281: astore 6
    //   1283: ldc_w 474
    //   1286: invokestatic 197	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1289: checkcast 474	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   1292: astore 8
    //   1294: aload_1
    //   1295: astore 6
    //   1297: new 263	java/lang/StringBuilder
    //   1300: dup
    //   1301: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   1304: astore 9
    //   1306: aload_1
    //   1307: astore 6
    //   1309: aload 9
    //   1311: ldc 254
    //   1313: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: pop
    //   1317: aload_1
    //   1318: astore 6
    //   1320: aload 9
    //   1322: lload 4
    //   1324: lload_2
    //   1325: lsub
    //   1326: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1329: pop
    //   1330: aload_1
    //   1331: astore 6
    //   1333: aload 8
    //   1335: aconst_null
    //   1336: ldc 254
    //   1338: ldc_w 476
    //   1341: ldc_w 476
    //   1344: iconst_0
    //   1345: iconst_0
    //   1346: ldc 202
    //   1348: aload 9
    //   1350: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1353: aload 7
    //   1355: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1358: ldc 254
    //   1360: invokeinterface 482 11 0
    //   1365: aload_1
    //   1366: ifnull +13 -> 1379
    //   1369: aload_1
    //   1370: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   1373: return
    //   1374: astore_1
    //   1375: aload_1
    //   1376: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   1379: return
    //   1380: aload 6
    //   1382: ifnull +18 -> 1400
    //   1385: aload 6
    //   1387: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   1390: goto +10 -> 1400
    //   1393: astore 6
    //   1395: aload 6
    //   1397: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   1400: aload_1
    //   1401: athrow
    //   1402: astore_1
    //   1403: goto -196 -> 1207
    //   1406: astore_1
    //   1407: goto -230 -> 1177
    //   1410: aload_1
    //   1411: ifnonnull -715 -> 696
    //   1414: return
    //   1415: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1416	0	this	PreloadManager
    //   0	1416	1	paramString	String
    //   17	1308	2	l1	long
    //   3	1320	4	l2	long
    //   13	1110	6	localObject1	Object
    //   1157	6	6	localObject2	Object
    //   1167	77	6	localObject3	Object
    //   1255	6	6	localIOException1	IOException
    //   1265	121	6	str	String
    //   1393	3	6	localIOException2	IOException
    //   6	1160	7	localObject4	Object
    //   1172	86	7	localIOException3	IOException
    //   1262	92	7	localObject5	Object
    //   9	1325	8	localIPublicAccountReportUtils	com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    //   22	993	9	localObject6	Object
    //   1237	12	9	localObject7	Object
    //   1304	45	9	localStringBuilder	StringBuilder
    //   65	987	10	localObject8	Object
    //   49	925	11	localObject9	Object
    //   139	683	12	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   958	962	963	java/io/IOException
    //   841	847	1157	finally
    //   850	859	1157	finally
    //   862	870	1157	finally
    //   873	884	1157	finally
    //   887	896	1157	finally
    //   899	907	1157	finally
    //   910	918	1157	finally
    //   921	951	1157	finally
    //   954	958	1157	finally
    //   972	978	1157	finally
    //   981	985	1157	finally
    //   988	997	1157	finally
    //   1000	1009	1157	finally
    //   1012	1020	1157	finally
    //   1023	1032	1157	finally
    //   1035	1060	1157	finally
    //   1063	1071	1157	finally
    //   1074	1085	1157	finally
    //   1088	1097	1157	finally
    //   1100	1108	1157	finally
    //   1111	1119	1157	finally
    //   1122	1152	1157	finally
    //   841	847	1172	java/io/IOException
    //   850	859	1172	java/io/IOException
    //   862	870	1172	java/io/IOException
    //   873	884	1172	java/io/IOException
    //   887	896	1172	java/io/IOException
    //   899	907	1172	java/io/IOException
    //   910	918	1172	java/io/IOException
    //   921	951	1172	java/io/IOException
    //   954	958	1172	java/io/IOException
    //   972	978	1172	java/io/IOException
    //   981	985	1172	java/io/IOException
    //   988	997	1172	java/io/IOException
    //   1000	1009	1172	java/io/IOException
    //   1012	1020	1172	java/io/IOException
    //   1023	1032	1172	java/io/IOException
    //   1035	1060	1172	java/io/IOException
    //   1063	1071	1172	java/io/IOException
    //   1074	1085	1172	java/io/IOException
    //   1088	1097	1172	java/io/IOException
    //   1100	1108	1172	java/io/IOException
    //   1111	1119	1172	java/io/IOException
    //   1122	1152	1172	java/io/IOException
    //   345	398	1237	finally
    //   1239	1241	1237	finally
    //   18	24	1251	finally
    //   37	51	1251	finally
    //   58	67	1251	finally
    //   74	83	1251	finally
    //   90	98	1251	finally
    //   105	112	1251	finally
    //   119	125	1251	finally
    //   132	141	1251	finally
    //   148	157	1251	finally
    //   164	172	1251	finally
    //   179	188	1251	finally
    //   195	202	1251	finally
    //   209	221	1251	finally
    //   228	236	1251	finally
    //   243	249	1251	finally
    //   256	265	1251	finally
    //   272	279	1251	finally
    //   287	294	1251	finally
    //   307	324	1251	finally
    //   331	336	1251	finally
    //   343	345	1251	finally
    //   405	412	1251	finally
    //   419	426	1251	finally
    //   433	440	1251	finally
    //   447	451	1251	finally
    //   458	473	1251	finally
    //   480	488	1251	finally
    //   495	503	1251	finally
    //   510	520	1251	finally
    //   527	536	1251	finally
    //   543	551	1251	finally
    //   558	566	1251	finally
    //   573	602	1251	finally
    //   610	618	1251	finally
    //   625	632	1251	finally
    //   639	647	1251	finally
    //   654	661	1251	finally
    //   668	676	1251	finally
    //   683	690	1251	finally
    //   703	711	1251	finally
    //   718	729	1251	finally
    //   736	743	1251	finally
    //   750	757	1251	finally
    //   765	774	1251	finally
    //   781	789	1251	finally
    //   796	805	1251	finally
    //   812	833	1251	finally
    //   1184	1190	1251	finally
    //   1197	1206	1251	finally
    //   1214	1220	1251	finally
    //   1227	1236	1251	finally
    //   1248	1251	1251	finally
    //   1267	1272	1251	finally
    //   1275	1280	1251	finally
    //   1283	1294	1251	finally
    //   1297	1306	1251	finally
    //   1309	1317	1251	finally
    //   1320	1330	1251	finally
    //   1333	1365	1251	finally
    //   18	24	1255	java/io/IOException
    //   37	51	1255	java/io/IOException
    //   58	67	1255	java/io/IOException
    //   74	83	1255	java/io/IOException
    //   90	98	1255	java/io/IOException
    //   105	112	1255	java/io/IOException
    //   119	125	1255	java/io/IOException
    //   132	141	1255	java/io/IOException
    //   148	157	1255	java/io/IOException
    //   164	172	1255	java/io/IOException
    //   179	188	1255	java/io/IOException
    //   195	202	1255	java/io/IOException
    //   209	221	1255	java/io/IOException
    //   228	236	1255	java/io/IOException
    //   243	249	1255	java/io/IOException
    //   256	265	1255	java/io/IOException
    //   272	279	1255	java/io/IOException
    //   287	294	1255	java/io/IOException
    //   307	324	1255	java/io/IOException
    //   331	336	1255	java/io/IOException
    //   343	345	1255	java/io/IOException
    //   405	412	1255	java/io/IOException
    //   419	426	1255	java/io/IOException
    //   433	440	1255	java/io/IOException
    //   447	451	1255	java/io/IOException
    //   458	473	1255	java/io/IOException
    //   480	488	1255	java/io/IOException
    //   495	503	1255	java/io/IOException
    //   510	520	1255	java/io/IOException
    //   527	536	1255	java/io/IOException
    //   543	551	1255	java/io/IOException
    //   558	566	1255	java/io/IOException
    //   573	602	1255	java/io/IOException
    //   610	618	1255	java/io/IOException
    //   625	632	1255	java/io/IOException
    //   639	647	1255	java/io/IOException
    //   654	661	1255	java/io/IOException
    //   668	676	1255	java/io/IOException
    //   683	690	1255	java/io/IOException
    //   703	711	1255	java/io/IOException
    //   718	729	1255	java/io/IOException
    //   736	743	1255	java/io/IOException
    //   750	757	1255	java/io/IOException
    //   765	774	1255	java/io/IOException
    //   781	789	1255	java/io/IOException
    //   796	805	1255	java/io/IOException
    //   812	833	1255	java/io/IOException
    //   1184	1190	1255	java/io/IOException
    //   1197	1206	1255	java/io/IOException
    //   1214	1220	1255	java/io/IOException
    //   1227	1236	1255	java/io/IOException
    //   1248	1251	1255	java/io/IOException
    //   1152	1156	1374	java/io/IOException
    //   1369	1373	1374	java/io/IOException
    //   1385	1390	1393	java/io/IOException
    //   458	473	1402	java/lang/OutOfMemoryError
    //   610	618	1406	java/lang/OutOfMemoryError
    //   625	632	1406	java/lang/OutOfMemoryError
    //   639	647	1406	java/lang/OutOfMemoryError
    //   654	661	1406	java/lang/OutOfMemoryError
    //   668	676	1406	java/lang/OutOfMemoryError
  }
  
  private String i(String paramString)
  {
    Object localObject2 = "";
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadHtmlWithCondition:");
      ((StringBuilder)localObject1).append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect());
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect()) {
      return k(paramString);
    }
    if (i()) {}
    try
    {
      localObject1 = new URL(paramString).getHost();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label103:
      label121:
      break label103;
    }
    Object localObject1 = "";
    try
    {
      String str = InetAddress.getByName((String)localObject1).getHostAddress();
      localObject2 = str;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      long l1;
      break label121;
    }
    l1 = NetConnInfoCenter.getServerTimeMillis();
    try
    {
      paramString = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
      a(true, l1, 0, (String)localObject1, (String)localObject2, "-1", "0");
      return paramString;
    }
    catch (IOException paramString)
    {
      a(false, l1, 1, (String)localObject1, (String)localObject2, "-1", paramString.getMessage());
      throw paramString;
    }
    return HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  private boolean i()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int n = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnectReportSwitch();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (n != 0) {
      if (n != 1)
      {
        if (n != 2)
        {
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(str))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnectReportTail()))
            {
              bool1 = bool2;
              if (!str.endsWith(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnectReportTail())) {}
            }
          }
        }
      }
      else {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldDoStatisticReport->uin:");
      localStringBuilder.append(str);
      localStringBuilder.append(", result:");
      localStringBuilder.append(bool1);
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  private byte[] j(String paramString)
  {
    Object localObject2 = "";
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("downloadImageWithCondition:");
      ((StringBuilder)localObject1).append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect());
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnect()) {
      return l(paramString);
    }
    if (i()) {}
    try
    {
      localObject1 = new URL(paramString).getHost();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label103:
      label121:
      break label103;
    }
    Object localObject1 = "";
    try
    {
      String str = InetAddress.getByName((String)localObject1).getHostAddress();
      localObject2 = str;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      long l1;
      break label121;
    }
    l1 = NetConnInfoCenter.getServerTimeMillis();
    try
    {
      paramString = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
      a(true, l1, 0, (String)localObject1, (String)localObject2, "-1", "0");
      return paramString;
    }
    catch (IOException paramString)
    {
      a(false, l1, 1, (String)localObject1, (String)localObject2, "-1", paramString.getMessage());
      throw paramString;
    }
    return HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  /* Error */
  private String k(String paramString)
  {
    // Byte code:
    //   0: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 36
    //   8: iconst_2
    //   9: ldc_w 579
    //   12: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +47 -> 66
    //   22: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +39 -> 64
    //   28: new 263	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   35: astore 5
    //   37: aload 5
    //   39: ldc_w 581
    //   42: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 36
    //   55: iconst_2
    //   56: aload 5
    //   58: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aconst_null
    //   65: areturn
    //   66: invokestatic 223	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   69: lstore_2
    //   70: new 531	java/net/URL
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 532	java/net/URL:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 535	java/net/URL:getHost	()Ljava/lang/String;
    //   81: astore 7
    //   83: invokestatic 586	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/BaseInnerDns;
    //   86: aload 7
    //   88: sipush 1008
    //   91: invokevirtual 592	com/tencent/mobileqq/transfile/dns/BaseInnerDns:reqDns	(Ljava/lang/String;I)Ljava/lang/String;
    //   94: astore 8
    //   96: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +57 -> 156
    //   102: new 263	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   109: astore 5
    //   111: aload 5
    //   113: ldc_w 594
    //   116: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 5
    //   122: aload 7
    //   124: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 5
    //   130: ldc_w 596
    //   133: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 5
    //   139: aload 8
    //   141: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 36
    //   147: iconst_2
    //   148: aload 5
    //   150: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload 8
    //   158: ifnonnull +176 -> 334
    //   161: aload 7
    //   163: invokestatic 541	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   166: invokevirtual 544	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   169: astore 5
    //   171: goto +10 -> 181
    //   174: ldc 254
    //   176: astore 5
    //   178: goto -7 -> 171
    //   181: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +39 -> 223
    //   187: new 263	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   194: astore 6
    //   196: aload 6
    //   198: ldc_w 598
    //   201: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 6
    //   207: aload_1
    //   208: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: ldc 36
    //   214: iconst_2
    //   215: aload 6
    //   217: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: invokestatic 229	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   226: aload_1
    //   227: ldc_w 546
    //   230: aconst_null
    //   231: aconst_null
    //   232: aconst_null
    //   233: invokestatic 552	com/tencent/biz/common/util/HttpUtil:openUrlForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   236: astore 6
    //   238: aload_0
    //   239: iconst_1
    //   240: lload_2
    //   241: iconst_0
    //   242: aload 7
    //   244: aload 5
    //   246: ldc_w 554
    //   249: ldc 202
    //   251: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload 6
    //   256: areturn
    //   257: astore 6
    //   259: goto +5 -> 264
    //   262: astore 6
    //   264: aload 6
    //   266: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   269: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +40 -> 312
    //   275: new 263	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   282: astore 8
    //   284: aload 8
    //   286: ldc_w 600
    //   289: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 8
    //   295: aload 6
    //   297: invokevirtual 603	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc 36
    //   303: iconst_2
    //   304: aload 8
    //   306: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload_0
    //   313: iconst_0
    //   314: lload_2
    //   315: iconst_1
    //   316: aload 7
    //   318: aload 5
    //   320: ldc_w 554
    //   323: aload 6
    //   325: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   328: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 6
    //   333: athrow
    //   334: aload_1
    //   335: aload 7
    //   337: aload 8
    //   339: invokevirtual 607	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   342: astore 5
    //   344: new 609	android/os/Bundle
    //   347: dup
    //   348: invokespecial 610	android/os/Bundle:<init>	()V
    //   351: astore 6
    //   353: aload 6
    //   355: ldc_w 612
    //   358: aload 7
    //   360: invokevirtual 615	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: istore 4
    //   368: iload 4
    //   370: ifeq +48 -> 418
    //   373: new 263	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   380: astore 9
    //   382: aload 9
    //   384: ldc_w 617
    //   387: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 9
    //   393: aload 5
    //   395: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: ldc 36
    //   401: iconst_2
    //   402: aload 9
    //   404: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: goto +8 -> 418
    //   413: astore 6
    //   415: goto +60 -> 475
    //   418: invokestatic 229	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   421: astore 9
    //   423: aload 9
    //   425: aload 5
    //   427: ldc_w 546
    //   430: aconst_null
    //   431: aload 6
    //   433: aload 7
    //   435: invokestatic 552	com/tencent/biz/common/util/HttpUtil:openUrlForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   438: astore 5
    //   440: aload_0
    //   441: iconst_1
    //   442: lload_2
    //   443: iconst_2
    //   444: aload 7
    //   446: aload 8
    //   448: ldc 202
    //   450: ldc_w 554
    //   453: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload 5
    //   458: areturn
    //   459: astore 5
    //   461: goto +10 -> 471
    //   464: astore 5
    //   466: goto +5 -> 471
    //   469: astore 5
    //   471: aload 5
    //   473: astore 6
    //   475: aload 6
    //   477: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   480: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +40 -> 523
    //   486: new 263	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   493: astore 5
    //   495: aload 5
    //   497: ldc_w 619
    //   500: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 5
    //   506: aload 6
    //   508: invokevirtual 603	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: ldc 36
    //   514: iconst_2
    //   515: aload 5
    //   517: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +39 -> 565
    //   529: new 263	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   536: astore 5
    //   538: aload 5
    //   540: ldc_w 621
    //   543: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 5
    //   549: aload_1
    //   550: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: ldc 36
    //   556: iconst_2
    //   557: aload 5
    //   559: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: invokestatic 229	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   568: astore 5
    //   570: aload 5
    //   572: aload_1
    //   573: ldc_w 546
    //   576: aconst_null
    //   577: aconst_null
    //   578: aconst_null
    //   579: invokestatic 552	com/tencent/biz/common/util/HttpUtil:openUrlForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   582: astore 5
    //   584: invokestatic 586	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/BaseInnerDns;
    //   587: aload 7
    //   589: aload 8
    //   591: sipush 1008
    //   594: invokevirtual 625	com/tencent/mobileqq/transfile/dns/BaseInnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   597: aload 6
    //   599: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   602: astore 9
    //   604: aload_0
    //   605: iconst_1
    //   606: lload_2
    //   607: iconst_3
    //   608: aload 7
    //   610: aload 8
    //   612: aload 9
    //   614: ldc 202
    //   616: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   619: aload 5
    //   621: areturn
    //   622: astore 5
    //   624: goto +10 -> 634
    //   627: astore 5
    //   629: goto +5 -> 634
    //   632: astore 5
    //   634: aload 5
    //   636: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   639: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +40 -> 682
    //   645: new 263	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   652: astore 9
    //   654: aload 9
    //   656: ldc_w 627
    //   659: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 9
    //   665: aload 5
    //   667: invokevirtual 603	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: ldc 36
    //   673: iconst_2
    //   674: aload 9
    //   676: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: aload_0
    //   683: iconst_0
    //   684: lload_2
    //   685: iconst_4
    //   686: aload 7
    //   688: aload 8
    //   690: aload 6
    //   692: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   695: aload 5
    //   697: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   700: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   703: aload 5
    //   705: athrow
    //   706: astore 5
    //   708: aload 5
    //   710: invokevirtual 628	java/net/MalformedURLException:printStackTrace	()V
    //   713: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +39 -> 755
    //   719: new 263	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   726: astore 5
    //   728: aload 5
    //   730: ldc_w 630
    //   733: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 5
    //   739: aload_1
    //   740: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: ldc 36
    //   746: iconst_2
    //   747: aload 5
    //   749: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   755: aconst_null
    //   756: areturn
    //   757: astore 5
    //   759: goto -585 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	PreloadManager
    //   0	762	1	paramString	String
    //   69	616	2	l1	long
    //   366	3	4	bool	boolean
    //   35	422	5	localObject1	Object
    //   459	1	5	localIOException1	IOException
    //   464	1	5	localIOException2	IOException
    //   469	3	5	localIOException3	IOException
    //   493	127	5	localObject2	Object
    //   622	1	5	localIOException4	IOException
    //   627	1	5	localIOException5	IOException
    //   632	72	5	localIOException6	IOException
    //   706	3	5	localMalformedURLException	MalformedURLException
    //   726	22	5	localStringBuilder	StringBuilder
    //   757	1	5	localUnknownHostException	UnknownHostException
    //   194	61	6	localObject3	Object
    //   257	1	6	localIOException7	IOException
    //   262	70	6	localIOException8	IOException
    //   351	3	6	localBundle	android.os.Bundle
    //   413	19	6	localIOException9	IOException
    //   473	218	6	localIOException10	IOException
    //   81	606	7	str	String
    //   94	595	8	localObject4	Object
    //   380	295	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   238	254	257	java/io/IOException
    //   181	223	262	java/io/IOException
    //   223	238	262	java/io/IOException
    //   373	410	413	java/io/IOException
    //   440	456	459	java/io/IOException
    //   423	440	464	java/io/IOException
    //   363	368	469	java/io/IOException
    //   418	423	469	java/io/IOException
    //   604	619	622	java/io/IOException
    //   570	604	627	java/io/IOException
    //   523	565	632	java/io/IOException
    //   565	570	632	java/io/IOException
    //   70	156	706	java/net/MalformedURLException
    //   161	171	706	java/net/MalformedURLException
    //   181	223	706	java/net/MalformedURLException
    //   223	238	706	java/net/MalformedURLException
    //   238	254	706	java/net/MalformedURLException
    //   264	312	706	java/net/MalformedURLException
    //   312	334	706	java/net/MalformedURLException
    //   334	363	706	java/net/MalformedURLException
    //   363	368	706	java/net/MalformedURLException
    //   373	410	706	java/net/MalformedURLException
    //   418	423	706	java/net/MalformedURLException
    //   423	440	706	java/net/MalformedURLException
    //   440	456	706	java/net/MalformedURLException
    //   475	523	706	java/net/MalformedURLException
    //   523	565	706	java/net/MalformedURLException
    //   565	570	706	java/net/MalformedURLException
    //   570	604	706	java/net/MalformedURLException
    //   604	619	706	java/net/MalformedURLException
    //   634	682	706	java/net/MalformedURLException
    //   682	706	706	java/net/MalformedURLException
    //   161	171	757	java/net/UnknownHostException
  }
  
  /* Error */
  private byte[] l(String paramString)
  {
    // Byte code:
    //   0: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 36
    //   8: iconst_2
    //   9: ldc_w 632
    //   12: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: invokestatic 99	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +47 -> 66
    //   22: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +39 -> 64
    //   28: new 263	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   35: astore 5
    //   37: aload 5
    //   39: ldc_w 634
    //   42: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 36
    //   55: iconst_2
    //   56: aload 5
    //   58: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aconst_null
    //   65: areturn
    //   66: invokestatic 223	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   69: lstore_2
    //   70: new 531	java/net/URL
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 532	java/net/URL:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 535	java/net/URL:getHost	()Ljava/lang/String;
    //   81: astore 7
    //   83: invokestatic 586	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/BaseInnerDns;
    //   86: aload 7
    //   88: sipush 1009
    //   91: invokevirtual 592	com/tencent/mobileqq/transfile/dns/BaseInnerDns:reqDns	(Ljava/lang/String;I)Ljava/lang/String;
    //   94: astore 8
    //   96: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +57 -> 156
    //   102: new 263	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   109: astore 5
    //   111: aload 5
    //   113: ldc_w 636
    //   116: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 5
    //   122: aload 7
    //   124: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 5
    //   130: ldc_w 596
    //   133: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 5
    //   139: aload 8
    //   141: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 36
    //   147: iconst_2
    //   148: aload 5
    //   150: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload 8
    //   158: ifnonnull +176 -> 334
    //   161: aload 7
    //   163: invokestatic 541	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   166: invokevirtual 544	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   169: astore 5
    //   171: goto +10 -> 181
    //   174: ldc 254
    //   176: astore 5
    //   178: goto -7 -> 171
    //   181: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +39 -> 223
    //   187: new 263	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   194: astore 6
    //   196: aload 6
    //   198: ldc_w 638
    //   201: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 6
    //   207: aload_1
    //   208: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: ldc 36
    //   214: iconst_2
    //   215: aload 6
    //   217: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: invokestatic 229	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   226: aload_1
    //   227: ldc_w 546
    //   230: aconst_null
    //   231: aconst_null
    //   232: aconst_null
    //   233: invokestatic 577	com/tencent/biz/common/util/HttpUtil:openUrlForByteForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)[B
    //   236: astore 6
    //   238: aload_0
    //   239: iconst_1
    //   240: lload_2
    //   241: iconst_0
    //   242: aload 7
    //   244: aload 5
    //   246: ldc_w 554
    //   249: ldc 202
    //   251: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload 6
    //   256: areturn
    //   257: astore 6
    //   259: goto +5 -> 264
    //   262: astore 6
    //   264: aload 6
    //   266: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   269: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +40 -> 312
    //   275: new 263	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   282: astore 8
    //   284: aload 8
    //   286: ldc_w 640
    //   289: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 8
    //   295: aload 6
    //   297: invokevirtual 603	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc 36
    //   303: iconst_2
    //   304: aload 8
    //   306: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload_0
    //   313: iconst_0
    //   314: lload_2
    //   315: iconst_1
    //   316: aload 7
    //   318: aload 5
    //   320: ldc_w 554
    //   323: aload 6
    //   325: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   328: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 6
    //   333: athrow
    //   334: aload_1
    //   335: aload 7
    //   337: aload 8
    //   339: invokevirtual 607	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   342: astore 5
    //   344: new 609	android/os/Bundle
    //   347: dup
    //   348: invokespecial 610	android/os/Bundle:<init>	()V
    //   351: astore 6
    //   353: aload 6
    //   355: ldc_w 612
    //   358: aload 7
    //   360: invokevirtual 615	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: istore 4
    //   368: iload 4
    //   370: ifeq +48 -> 418
    //   373: new 263	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   380: astore 9
    //   382: aload 9
    //   384: ldc_w 642
    //   387: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 9
    //   393: aload 5
    //   395: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: ldc 36
    //   401: iconst_2
    //   402: aload 9
    //   404: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: goto +8 -> 418
    //   413: astore 6
    //   415: goto +60 -> 475
    //   418: invokestatic 229	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   421: astore 9
    //   423: aload 9
    //   425: aload 5
    //   427: ldc_w 546
    //   430: aconst_null
    //   431: aload 6
    //   433: aload 7
    //   435: invokestatic 577	com/tencent/biz/common/util/HttpUtil:openUrlForByteForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)[B
    //   438: astore 5
    //   440: aload_0
    //   441: iconst_1
    //   442: lload_2
    //   443: iconst_2
    //   444: aload 7
    //   446: aload 8
    //   448: ldc 202
    //   450: ldc_w 554
    //   453: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload 5
    //   458: areturn
    //   459: astore 5
    //   461: goto +10 -> 471
    //   464: astore 5
    //   466: goto +5 -> 471
    //   469: astore 5
    //   471: aload 5
    //   473: astore 6
    //   475: aload 6
    //   477: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   480: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +40 -> 523
    //   486: new 263	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   493: astore 5
    //   495: aload 5
    //   497: ldc_w 644
    //   500: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 5
    //   506: aload 6
    //   508: invokevirtual 603	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: ldc 36
    //   514: iconst_2
    //   515: aload 5
    //   517: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +39 -> 565
    //   529: new 263	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   536: astore 5
    //   538: aload 5
    //   540: ldc_w 646
    //   543: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 5
    //   549: aload_1
    //   550: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: ldc 36
    //   556: iconst_2
    //   557: aload 5
    //   559: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: invokestatic 229	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   568: astore 5
    //   570: aload 5
    //   572: aload_1
    //   573: ldc_w 546
    //   576: aconst_null
    //   577: aconst_null
    //   578: aconst_null
    //   579: invokestatic 577	com/tencent/biz/common/util/HttpUtil:openUrlForByteForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)[B
    //   582: astore 5
    //   584: invokestatic 586	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/BaseInnerDns;
    //   587: aload 7
    //   589: aload 8
    //   591: sipush 1009
    //   594: invokevirtual 625	com/tencent/mobileqq/transfile/dns/BaseInnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   597: aload 6
    //   599: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   602: astore 9
    //   604: aload_0
    //   605: iconst_1
    //   606: lload_2
    //   607: iconst_3
    //   608: aload 7
    //   610: aload 8
    //   612: aload 9
    //   614: ldc 202
    //   616: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   619: aload 5
    //   621: areturn
    //   622: astore 5
    //   624: goto +10 -> 634
    //   627: astore 5
    //   629: goto +5 -> 634
    //   632: astore 5
    //   634: aload 5
    //   636: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   639: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +40 -> 682
    //   645: new 263	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   652: astore 9
    //   654: aload 9
    //   656: ldc_w 648
    //   659: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 9
    //   665: aload 5
    //   667: invokevirtual 603	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: ldc 36
    //   673: iconst_2
    //   674: aload 9
    //   676: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: aload_0
    //   683: iconst_0
    //   684: lload_2
    //   685: iconst_4
    //   686: aload 7
    //   688: aload 8
    //   690: aload 6
    //   692: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   695: aload 5
    //   697: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   700: invokespecial 556	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   703: aload 5
    //   705: athrow
    //   706: astore 5
    //   708: aload 5
    //   710: invokevirtual 628	java/net/MalformedURLException:printStackTrace	()V
    //   713: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +39 -> 755
    //   719: new 263	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   726: astore 5
    //   728: aload 5
    //   730: ldc_w 650
    //   733: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 5
    //   739: aload_1
    //   740: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: ldc 36
    //   746: iconst_2
    //   747: aload 5
    //   749: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   755: aconst_null
    //   756: areturn
    //   757: astore 5
    //   759: goto -585 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	PreloadManager
    //   0	762	1	paramString	String
    //   69	616	2	l1	long
    //   366	3	4	bool	boolean
    //   35	422	5	localObject1	Object
    //   459	1	5	localIOException1	IOException
    //   464	1	5	localIOException2	IOException
    //   469	3	5	localIOException3	IOException
    //   493	127	5	localObject2	Object
    //   622	1	5	localIOException4	IOException
    //   627	1	5	localIOException5	IOException
    //   632	72	5	localIOException6	IOException
    //   706	3	5	localMalformedURLException	MalformedURLException
    //   726	22	5	localStringBuilder	StringBuilder
    //   757	1	5	localUnknownHostException	UnknownHostException
    //   194	61	6	localObject3	Object
    //   257	1	6	localIOException7	IOException
    //   262	70	6	localIOException8	IOException
    //   351	3	6	localBundle	android.os.Bundle
    //   413	19	6	localIOException9	IOException
    //   473	218	6	localIOException10	IOException
    //   81	606	7	str	String
    //   94	595	8	localObject4	Object
    //   380	295	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   238	254	257	java/io/IOException
    //   181	223	262	java/io/IOException
    //   223	238	262	java/io/IOException
    //   373	410	413	java/io/IOException
    //   440	456	459	java/io/IOException
    //   423	440	464	java/io/IOException
    //   363	368	469	java/io/IOException
    //   418	423	469	java/io/IOException
    //   604	619	622	java/io/IOException
    //   570	604	627	java/io/IOException
    //   523	565	632	java/io/IOException
    //   565	570	632	java/io/IOException
    //   70	156	706	java/net/MalformedURLException
    //   161	171	706	java/net/MalformedURLException
    //   181	223	706	java/net/MalformedURLException
    //   223	238	706	java/net/MalformedURLException
    //   238	254	706	java/net/MalformedURLException
    //   264	312	706	java/net/MalformedURLException
    //   312	334	706	java/net/MalformedURLException
    //   334	363	706	java/net/MalformedURLException
    //   363	368	706	java/net/MalformedURLException
    //   373	410	706	java/net/MalformedURLException
    //   418	423	706	java/net/MalformedURLException
    //   423	440	706	java/net/MalformedURLException
    //   440	456	706	java/net/MalformedURLException
    //   475	523	706	java/net/MalformedURLException
    //   523	565	706	java/net/MalformedURLException
    //   565	570	706	java/net/MalformedURLException
    //   570	604	706	java/net/MalformedURLException
    //   604	619	706	java/net/MalformedURLException
    //   634	682	706	java/net/MalformedURLException
    //   682	706	706	java/net/MalformedURLException
    //   161	171	757	java/net/UnknownHostException
  }
  
  public ArrayList<PreloadManager.ImgStruct> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.d)
    {
      paramString = (ArrayList)this.m.get(paramString);
      if (paramString != null)
      {
        Collections.sort(paramString, new PreloadManager.ImgStructComparator());
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          PreloadManager.ImgStruct localImgStruct = (PreloadManager.ImgStruct)paramString.next();
          if (c(localImgStruct.a) == 0) {
            localArrayList.add(localImgStruct);
          }
        }
        return localArrayList;
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public List<String> a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    int n = 0;
    int i1 = 0;
    while (n < paramString.length())
    {
      if ((paramString.charAt(n) != ';') && (n != paramString.length() - 1)) {}
      int i2;
      do
      {
        n += 1;
        break;
        if (n == paramString.length() - 1) {
          i2 = paramString.length();
        } else {
          i2 = n;
        }
      } while (i2 <= i1);
      Object localObject2 = paramString.substring(i1, i2);
      Object localObject1 = localObject2;
      if (paramBoolean1) {
        localObject1 = b((String)localObject2, paramBoolean2);
      }
      if (localObject1 != null)
      {
        localArrayList.add(localObject1);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("预下载图片url = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, ((StringBuilder)localObject2).toString());
        }
      }
      i1 = i2 + 1;
      n = i1;
    }
    return localArrayList;
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManager.executeOnFileThread(new PreloadManager.ReadFileThread(this, paramString1, paramString2));
  }
  
  public void b()
  {
    this.j.addAll(this.k);
    this.k.clear();
    this.b = true;
    d();
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("add Task url:");
      ((StringBuilder)???).append(paramString);
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.f)
    {
      if (!this.k.contains(paramString))
      {
        this.k.add(paramString);
        if (!this.b) {
          b();
        }
      }
      return;
    }
  }
  
  public void c()
  {
    ThreadManager.post(new PreloadManager.1(this), 5, null, false);
  }
  
  public void d()
  {
    ThreadManager.executeOnNetWorkThread(new PreloadManager.PreloadThread(this));
  }
  
  public void e()
  {
    if (NetworkState.getNetworkType() != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "current network is not wifi");
      }
      return;
    }
    ThreadManager.executeOnNetWorkThread(new PreloadManager.FeedslistDownlaodImageThread(this));
  }
  
  public boolean f()
  {
    return false;
  }
  
  public byte[] f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (byte[])this.l.get(paramString);
  }
  
  public boolean g()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("kandian_feeds_image_preload", false);
  }
  
  /* Error */
  public boolean g(String paramString)
  {
    // Byte code:
    //   0: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_1
    //   6: invokestatic 353	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 9
    //   17: aconst_null
    //   18: astore 6
    //   20: aload 6
    //   22: astore 7
    //   24: new 357	java/io/File
    //   27: dup
    //   28: getstatic 362	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE	Ljava/lang/String;
    //   31: invokespecial 490	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 11
    //   36: aload 6
    //   38: astore 7
    //   40: aload 11
    //   42: invokevirtual 368	java/io/File:exists	()Z
    //   45: ifne +17 -> 62
    //   48: aload 6
    //   50: astore 7
    //   52: aload 11
    //   54: invokevirtual 493	java/io/File:mkdirs	()Z
    //   57: ifne +5 -> 62
    //   60: iconst_0
    //   61: ireturn
    //   62: aload 6
    //   64: astore 7
    //   66: new 263	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   73: astore 12
    //   75: aload 6
    //   77: astore 7
    //   79: aload 12
    //   81: aload 10
    //   83: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 6
    //   89: astore 7
    //   91: aload 12
    //   93: ldc_w 355
    //   96: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 6
    //   102: astore 7
    //   104: new 357	java/io/File
    //   107: dup
    //   108: aload 11
    //   110: aload 12
    //   112: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokespecial 500	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   118: astore 12
    //   120: aload 6
    //   122: astore 7
    //   124: new 497	java/io/FileOutputStream
    //   127: dup
    //   128: aload 12
    //   130: invokespecial 503	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   133: astore 6
    //   135: lload 4
    //   137: lstore_2
    //   138: aload_0
    //   139: aload_1
    //   140: invokespecial 769	com/tencent/biz/pubaccount/util/PreloadManager:j	(Ljava/lang/String;)[B
    //   143: astore 7
    //   145: aload 7
    //   147: ifnull +218 -> 365
    //   150: lload 4
    //   152: lstore_2
    //   153: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +75 -> 231
    //   159: lload 4
    //   161: lstore_2
    //   162: new 263	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   169: astore 8
    //   171: lload 4
    //   173: lstore_2
    //   174: aload 8
    //   176: ldc_w 771
    //   179: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: lload 4
    //   185: lstore_2
    //   186: aload 8
    //   188: aload_1
    //   189: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: lload 4
    //   195: lstore_2
    //   196: aload 8
    //   198: ldc_w 773
    //   201: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: lload 4
    //   207: lstore_2
    //   208: aload 8
    //   210: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   213: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: lload 4
    //   219: lstore_2
    //   220: ldc 36
    //   222: iconst_2
    //   223: aload 8
    //   225: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: lload 4
    //   233: lstore_2
    //   234: aload 6
    //   236: aload 7
    //   238: invokevirtual 512	java/io/FileOutputStream:write	([B)V
    //   241: lload 4
    //   243: lstore_2
    //   244: aload 12
    //   246: new 357	java/io/File
    //   249: dup
    //   250: aload 11
    //   252: aload 10
    //   254: invokespecial 500	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   257: invokevirtual 516	java/io/File:renameTo	(Ljava/io/File;)Z
    //   260: pop
    //   261: lload 4
    //   263: lstore_2
    //   264: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   267: lload 4
    //   269: lsub
    //   270: lstore 4
    //   272: lload 4
    //   274: lstore_2
    //   275: ldc_w 474
    //   278: invokestatic 197	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   281: checkcast 474	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   284: astore_1
    //   285: lload 4
    //   287: lstore_2
    //   288: new 263	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   295: astore 7
    //   297: lload 4
    //   299: lstore_2
    //   300: aload 7
    //   302: ldc 254
    //   304: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: lload 4
    //   310: lstore_2
    //   311: aload 7
    //   313: lload 4
    //   315: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: lload 4
    //   321: lstore_2
    //   322: aload_1
    //   323: aconst_null
    //   324: ldc 254
    //   326: ldc_w 775
    //   329: ldc_w 775
    //   332: iconst_0
    //   333: iconst_0
    //   334: ldc 183
    //   336: aload 7
    //   338: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: ldc_w 478
    //   344: ldc 202
    //   346: invokeinterface 482 11 0
    //   351: aload 6
    //   353: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   356: iconst_1
    //   357: ireturn
    //   358: astore_1
    //   359: aload_1
    //   360: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   363: iconst_1
    //   364: ireturn
    //   365: lload 4
    //   367: lstore_2
    //   368: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +15 -> 386
    //   374: lload 4
    //   376: lstore_2
    //   377: ldc 36
    //   379: iconst_2
    //   380: ldc_w 777
    //   383: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: lload 4
    //   388: lstore_2
    //   389: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   392: lload 4
    //   394: lsub
    //   395: lstore 4
    //   397: lload 4
    //   399: lstore_2
    //   400: ldc_w 474
    //   403: invokestatic 197	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   406: checkcast 474	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   409: astore_1
    //   410: lload 4
    //   412: lstore_2
    //   413: new 263	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   420: astore 7
    //   422: lload 4
    //   424: lstore_2
    //   425: aload 7
    //   427: ldc 254
    //   429: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: lload 4
    //   435: lstore_2
    //   436: aload 7
    //   438: lload 4
    //   440: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: lload 4
    //   446: lstore_2
    //   447: aload_1
    //   448: aconst_null
    //   449: ldc 254
    //   451: ldc_w 775
    //   454: ldc_w 775
    //   457: iconst_0
    //   458: iconst_0
    //   459: ldc 202
    //   461: aload 7
    //   463: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: ldc_w 478
    //   469: ldc 202
    //   471: invokeinterface 482 11 0
    //   476: aload 6
    //   478: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   481: iconst_0
    //   482: ireturn
    //   483: astore_1
    //   484: aload_1
    //   485: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   488: iconst_0
    //   489: ireturn
    //   490: astore_1
    //   491: goto +191 -> 682
    //   494: astore 7
    //   496: aload 6
    //   498: astore_1
    //   499: aload 7
    //   501: astore 6
    //   503: goto +31 -> 534
    //   506: goto +46 -> 552
    //   509: astore 7
    //   511: aload 6
    //   513: astore_1
    //   514: aload 7
    //   516: astore 6
    //   518: goto +61 -> 579
    //   521: astore_1
    //   522: aload 7
    //   524: astore 6
    //   526: goto +156 -> 682
    //   529: astore 6
    //   531: aload 8
    //   533: astore_1
    //   534: aload_1
    //   535: astore 7
    //   537: aload 6
    //   539: invokevirtual 778	java/lang/IllegalArgumentException:printStackTrace	()V
    //   542: aload_1
    //   543: ifnull +137 -> 680
    //   546: aload_1
    //   547: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   550: iconst_0
    //   551: ireturn
    //   552: aload 6
    //   554: ifnull +126 -> 680
    //   557: aload 6
    //   559: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   562: iconst_0
    //   563: ireturn
    //   564: astore_1
    //   565: aload_1
    //   566: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   569: iconst_0
    //   570: ireturn
    //   571: astore 6
    //   573: aload 9
    //   575: astore_1
    //   576: lload 4
    //   578: lstore_2
    //   579: aload_1
    //   580: astore 7
    //   582: invokestatic 426	java/lang/System:currentTimeMillis	()J
    //   585: lstore 4
    //   587: aload_1
    //   588: astore 7
    //   590: ldc_w 474
    //   593: invokestatic 197	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   596: checkcast 474	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   599: astore 8
    //   601: aload_1
    //   602: astore 7
    //   604: new 263	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   611: astore 9
    //   613: aload_1
    //   614: astore 7
    //   616: aload 9
    //   618: ldc 254
    //   620: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload_1
    //   625: astore 7
    //   627: aload 9
    //   629: lload 4
    //   631: lload_2
    //   632: lsub
    //   633: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload_1
    //   638: astore 7
    //   640: aload 8
    //   642: aconst_null
    //   643: ldc 254
    //   645: ldc_w 775
    //   648: ldc_w 775
    //   651: iconst_0
    //   652: iconst_0
    //   653: ldc 202
    //   655: aload 9
    //   657: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: aload 6
    //   662: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   665: ldc 202
    //   667: invokeinterface 482 11 0
    //   672: aload_1
    //   673: ifnull +7 -> 680
    //   676: aload_1
    //   677: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   680: iconst_0
    //   681: ireturn
    //   682: aload 6
    //   684: ifnull +18 -> 702
    //   687: aload 6
    //   689: invokevirtual 508	java/io/FileOutputStream:close	()V
    //   692: goto +10 -> 702
    //   695: astore 6
    //   697: aload 6
    //   699: invokevirtual 509	java/io/IOException:printStackTrace	()V
    //   702: aload_1
    //   703: athrow
    //   704: astore_1
    //   705: goto +7 -> 712
    //   708: astore_1
    //   709: goto -203 -> 506
    //   712: aconst_null
    //   713: astore 6
    //   715: goto -163 -> 552
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	PreloadManager
    //   0	718	1	paramString	String
    //   137	495	2	l1	long
    //   3	627	4	l2	long
    //   18	507	6	localObject1	Object
    //   529	29	6	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   571	117	6	localIOException1	IOException
    //   695	3	6	localIOException2	IOException
    //   713	1	6	localObject2	Object
    //   22	440	7	localObject3	Object
    //   494	6	7	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   509	14	7	localIOException3	IOException
    //   535	104	7	str1	String
    //   12	629	8	localObject4	Object
    //   15	641	9	localStringBuilder	StringBuilder
    //   9	244	10	str2	String
    //   34	217	11	localFile	File
    //   73	172	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   351	356	358	java/io/IOException
    //   476	481	483	java/io/IOException
    //   138	145	490	finally
    //   153	159	490	finally
    //   162	171	490	finally
    //   174	183	490	finally
    //   186	193	490	finally
    //   196	205	490	finally
    //   208	217	490	finally
    //   220	231	490	finally
    //   234	241	490	finally
    //   244	261	490	finally
    //   264	272	490	finally
    //   275	285	490	finally
    //   288	297	490	finally
    //   300	308	490	finally
    //   311	319	490	finally
    //   322	351	490	finally
    //   368	374	490	finally
    //   377	386	490	finally
    //   389	397	490	finally
    //   400	410	490	finally
    //   413	422	490	finally
    //   425	433	490	finally
    //   436	444	490	finally
    //   447	476	490	finally
    //   138	145	494	java/lang/IllegalArgumentException
    //   153	159	494	java/lang/IllegalArgumentException
    //   162	171	494	java/lang/IllegalArgumentException
    //   174	183	494	java/lang/IllegalArgumentException
    //   186	193	494	java/lang/IllegalArgumentException
    //   196	205	494	java/lang/IllegalArgumentException
    //   208	217	494	java/lang/IllegalArgumentException
    //   220	231	494	java/lang/IllegalArgumentException
    //   234	241	494	java/lang/IllegalArgumentException
    //   244	261	494	java/lang/IllegalArgumentException
    //   264	272	494	java/lang/IllegalArgumentException
    //   275	285	494	java/lang/IllegalArgumentException
    //   288	297	494	java/lang/IllegalArgumentException
    //   300	308	494	java/lang/IllegalArgumentException
    //   311	319	494	java/lang/IllegalArgumentException
    //   322	351	494	java/lang/IllegalArgumentException
    //   368	374	494	java/lang/IllegalArgumentException
    //   377	386	494	java/lang/IllegalArgumentException
    //   389	397	494	java/lang/IllegalArgumentException
    //   400	410	494	java/lang/IllegalArgumentException
    //   413	422	494	java/lang/IllegalArgumentException
    //   425	433	494	java/lang/IllegalArgumentException
    //   436	444	494	java/lang/IllegalArgumentException
    //   447	476	494	java/lang/IllegalArgumentException
    //   138	145	509	java/io/IOException
    //   153	159	509	java/io/IOException
    //   162	171	509	java/io/IOException
    //   174	183	509	java/io/IOException
    //   186	193	509	java/io/IOException
    //   196	205	509	java/io/IOException
    //   208	217	509	java/io/IOException
    //   220	231	509	java/io/IOException
    //   234	241	509	java/io/IOException
    //   244	261	509	java/io/IOException
    //   264	272	509	java/io/IOException
    //   275	285	509	java/io/IOException
    //   288	297	509	java/io/IOException
    //   300	308	509	java/io/IOException
    //   311	319	509	java/io/IOException
    //   322	351	509	java/io/IOException
    //   368	374	509	java/io/IOException
    //   377	386	509	java/io/IOException
    //   389	397	509	java/io/IOException
    //   400	410	509	java/io/IOException
    //   413	422	509	java/io/IOException
    //   425	433	509	java/io/IOException
    //   436	444	509	java/io/IOException
    //   447	476	509	java/io/IOException
    //   24	36	521	finally
    //   40	48	521	finally
    //   52	60	521	finally
    //   66	75	521	finally
    //   79	87	521	finally
    //   91	100	521	finally
    //   104	120	521	finally
    //   124	135	521	finally
    //   537	542	521	finally
    //   582	587	521	finally
    //   590	601	521	finally
    //   604	613	521	finally
    //   616	624	521	finally
    //   627	637	521	finally
    //   640	672	521	finally
    //   24	36	529	java/lang/IllegalArgumentException
    //   40	48	529	java/lang/IllegalArgumentException
    //   52	60	529	java/lang/IllegalArgumentException
    //   66	75	529	java/lang/IllegalArgumentException
    //   79	87	529	java/lang/IllegalArgumentException
    //   91	100	529	java/lang/IllegalArgumentException
    //   104	120	529	java/lang/IllegalArgumentException
    //   124	135	529	java/lang/IllegalArgumentException
    //   546	550	564	java/io/IOException
    //   557	562	564	java/io/IOException
    //   676	680	564	java/io/IOException
    //   24	36	571	java/io/IOException
    //   40	48	571	java/io/IOException
    //   52	60	571	java/io/IOException
    //   66	75	571	java/io/IOException
    //   79	87	571	java/io/IOException
    //   91	100	571	java/io/IOException
    //   104	120	571	java/io/IOException
    //   124	135	571	java/io/IOException
    //   687	692	695	java/io/IOException
    //   24	36	704	java/lang/OutOfMemoryError
    //   40	48	704	java/lang/OutOfMemoryError
    //   52	60	704	java/lang/OutOfMemoryError
    //   66	75	704	java/lang/OutOfMemoryError
    //   79	87	704	java/lang/OutOfMemoryError
    //   91	100	704	java/lang/OutOfMemoryError
    //   104	120	704	java/lang/OutOfMemoryError
    //   124	135	704	java/lang/OutOfMemoryError
    //   138	145	708	java/lang/OutOfMemoryError
    //   153	159	708	java/lang/OutOfMemoryError
    //   162	171	708	java/lang/OutOfMemoryError
    //   174	183	708	java/lang/OutOfMemoryError
    //   186	193	708	java/lang/OutOfMemoryError
    //   196	205	708	java/lang/OutOfMemoryError
    //   208	217	708	java/lang/OutOfMemoryError
    //   220	231	708	java/lang/OutOfMemoryError
    //   234	241	708	java/lang/OutOfMemoryError
    //   244	261	708	java/lang/OutOfMemoryError
    //   264	272	708	java/lang/OutOfMemoryError
    //   275	285	708	java/lang/OutOfMemoryError
    //   288	297	708	java/lang/OutOfMemoryError
    //   300	308	708	java/lang/OutOfMemoryError
    //   311	319	708	java/lang/OutOfMemoryError
    //   322	351	708	java/lang/OutOfMemoryError
    //   368	374	708	java/lang/OutOfMemoryError
    //   377	386	708	java/lang/OutOfMemoryError
    //   389	397	708	java/lang/OutOfMemoryError
    //   400	410	708	java/lang/OutOfMemoryError
    //   413	422	708	java/lang/OutOfMemoryError
    //   425	433	708	java/lang/OutOfMemoryError
    //   436	444	708	java/lang/OutOfMemoryError
    //   447	476	708	java/lang/OutOfMemoryError
  }
  
  public void h()
  {
    synchronized (this.d)
    {
      this.k.clear();
      this.j.clear();
      this.m.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager
 * JD-Core Version:    0.7.0.1
 */