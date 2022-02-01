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
  private static PreloadManager jdField_a_of_type_ComTencentBizPubaccountUtilPreloadManager;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MQLruCache<String, byte[]> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(30);
  public Object a;
  public final String a;
  ArrayList<PreloadManager.ImgStruct> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile HashMap<String, ArrayList<PreloadManager.ImgStruct>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  volatile boolean jdField_a_of_type_Boolean;
  Object jdField_b_of_type_JavaLangObject = new Object();
  private List<String> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  volatile boolean jdField_b_of_type_Boolean;
  Object c = new Object();
  
  private PreloadManager()
  {
    this.jdField_a_of_type_JavaLangString = "ReadInJoyArticleDetailPreloadManager";
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  static int a(String paramString)
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
  
  public static PreloadManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountUtilPreloadManager == null) {
      jdField_a_of_type_ComTencentBizPubaccountUtilPreloadManager = new PreloadManager();
    }
    return jdField_a_of_type_ComTencentBizPubaccountUtilPreloadManager;
  }
  
  public static String a(String paramString)
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
  
  private String a(String paramString, boolean paramBoolean)
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
  private ArrayList<PreloadManager.ImgStruct> a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 8
    //   9: iload 5
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 39	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 40	java/util/ArrayList:<init>	()V
    //   23: pop
    //   24: new 39	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 40	java/util/ArrayList:<init>	()V
    //   31: pop
    //   32: new 39	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 40	java/util/ArrayList:<init>	()V
    //   39: astore 9
    //   41: ldc 151
    //   43: invokestatic 157	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   46: aload_1
    //   47: invokevirtual 161	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 166	java/util/regex/Matcher:find	()Z
    //   55: ifeq +385 -> 440
    //   58: ldc 168
    //   60: invokestatic 157	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   63: aload_1
    //   64: invokevirtual 171	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   67: invokevirtual 161	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   70: astore 10
    //   72: aconst_null
    //   73: astore 6
    //   75: aload 10
    //   77: invokevirtual 166	java/util/regex/Matcher:find	()Z
    //   80: ifeq +360 -> 440
    //   83: ldc 26
    //   85: iconst_2
    //   86: aload 10
    //   88: invokevirtual 171	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   91: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: ldc 179
    //   96: invokestatic 157	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   99: aload 10
    //   101: invokevirtual 171	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   104: invokevirtual 161	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   107: invokevirtual 166	java/util/regex/Matcher:find	()Z
    //   110: ifeq -35 -> 75
    //   113: ldc 181
    //   115: invokestatic 157	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   118: aload 10
    //   120: invokevirtual 171	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   123: invokevirtual 161	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   126: astore 7
    //   128: aload 8
    //   130: astore_1
    //   131: aload 7
    //   133: invokevirtual 166	java/util/regex/Matcher:find	()Z
    //   136: ifeq +10 -> 146
    //   139: aload 7
    //   141: iconst_1
    //   142: invokevirtual 184	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   145: astore_1
    //   146: ldc 186
    //   148: invokestatic 157	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   151: aload 10
    //   153: invokevirtual 171	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   156: invokevirtual 161	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   159: astore 8
    //   161: aload 6
    //   163: astore 7
    //   165: aload 8
    //   167: invokevirtual 166	java/util/regex/Matcher:find	()Z
    //   170: ifeq +11 -> 181
    //   173: aload 8
    //   175: iconst_1
    //   176: invokevirtual 184	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   179: astore 7
    //   181: aload_1
    //   182: astore 8
    //   184: aload 7
    //   186: astore 6
    //   188: aload_1
    //   189: ifnull -114 -> 75
    //   192: aload_1
    //   193: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   213: invokevirtual 189	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;ZZ)Ljava/util/List;
    //   216: astore 11
    //   218: aload_0
    //   219: aload 7
    //   221: iconst_0
    //   222: iload_2
    //   223: invokevirtual 189	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;ZZ)Ljava/util/List;
    //   226: astore 12
    //   228: aload 11
    //   230: invokeinterface 195 1 0
    //   235: istore_3
    //   236: aload 12
    //   238: invokeinterface 195 1 0
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
    //   277: invokeinterface 195 1 0
    //   282: if_icmpge -207 -> 75
    //   285: new 197	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct
    //   288: dup
    //   289: invokespecial 198	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:<init>	()V
    //   292: astore 6
    //   294: aload 6
    //   296: aload 11
    //   298: iload_3
    //   299: invokeinterface 202 2 0
    //   304: checkcast 135	java/lang/String
    //   307: putfield 203	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   310: aload 6
    //   312: aload 12
    //   314: iload_3
    //   315: invokeinterface 202 2 0
    //   320: checkcast 135	java/lang/String
    //   323: invokestatic 208	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   326: putfield 211	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:jdField_a_of_type_Int	I
    //   329: goto +20 -> 349
    //   332: astore_1
    //   333: goto +31 -> 364
    //   336: astore 8
    //   338: aload 6
    //   340: iconst_0
    //   341: putfield 211	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:jdField_a_of_type_Int	I
    //   344: aload 8
    //   346: invokevirtual 214	java/lang/NumberFormatException:printStackTrace	()V
    //   349: aload 9
    //   351: aload 6
    //   353: invokevirtual 218	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   356: pop
    //   357: iload_3
    //   358: iconst_1
    //   359: iadd
    //   360: istore_3
    //   361: goto -94 -> 267
    //   364: aload 9
    //   366: aload 6
    //   368: invokevirtual 218	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   386: invokeinterface 195 1 0
    //   391: if_icmpge -316 -> 75
    //   394: new 197	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct
    //   397: dup
    //   398: invokespecial 198	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:<init>	()V
    //   401: astore 6
    //   403: aload 6
    //   405: aload 11
    //   407: iload_3
    //   408: invokeinterface 202 2 0
    //   413: checkcast 135	java/lang/String
    //   416: putfield 203	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   419: aload 6
    //   421: iconst_0
    //   422: putfield 211	com/tencent/biz/pubaccount/util/PreloadManager$ImgStruct:jdField_a_of_type_Int	I
    //   425: aload 9
    //   427: aload 6
    //   429: invokevirtual 218	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   235	202	3	i	int
    //   243	17	4	j	int
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
    if (!c()) {
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
  
  public static byte[] a(String paramString)
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
  
  private String b(String paramString)
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
      return c(paramString);
    }
    if (c()) {}
    try
    {
      localObject1 = new URL(paramString).getHost();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label104:
      label123:
      break label104;
    }
    Object localObject1 = "";
    try
    {
      String str = InetAddress.getByName((String)localObject1).getHostAddress();
      localObject2 = str;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      long l;
      break label123;
    }
    l = NetConnInfoCenter.getServerTimeMillis();
    try
    {
      paramString = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
      a(true, l, 0, (String)localObject1, (String)localObject2, "-1", "0");
      return paramString;
    }
    catch (IOException paramString)
    {
      a(false, l, 1, (String)localObject1, (String)localObject2, "-1", paramString.getMessage());
      throw paramString;
    }
    return HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 456	java/lang/System:currentTimeMillis	()J
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
    //   19: invokestatic 458	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 9
    //   24: aload 9
    //   26: ifnonnull +4 -> 30
    //   29: return
    //   30: aload 8
    //   32: astore 6
    //   34: lload 4
    //   36: lstore_2
    //   37: invokestatic 289	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   40: invokevirtual 293	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   43: checkcast 460	com/tencent/mobileqq/app/QQAppInterface
    //   46: invokevirtual 463	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   49: astore 11
    //   51: aload 8
    //   53: astore 6
    //   55: lload 4
    //   57: lstore_2
    //   58: new 81	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   65: astore 10
    //   67: aload 8
    //   69: astore 6
    //   71: lload 4
    //   73: lstore_2
    //   74: aload 10
    //   76: getstatic 466	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   79: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 8
    //   85: astore 6
    //   87: lload 4
    //   89: lstore_2
    //   90: aload 10
    //   92: aload 9
    //   94: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 8
    //   100: astore 6
    //   102: lload 4
    //   104: lstore_2
    //   105: aload 10
    //   107: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 10
    //   112: aload 8
    //   114: astore 6
    //   116: lload 4
    //   118: lstore_2
    //   119: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +99 -> 221
    //   125: aload 8
    //   127: astore 6
    //   129: lload 4
    //   131: lstore_2
    //   132: new 81	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   139: astore 12
    //   141: aload 8
    //   143: astore 6
    //   145: lload 4
    //   147: lstore_2
    //   148: aload 12
    //   150: ldc_w 468
    //   153: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 8
    //   159: astore 6
    //   161: lload 4
    //   163: lstore_2
    //   164: aload 12
    //   166: aload 10
    //   168: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 8
    //   174: astore 6
    //   176: lload 4
    //   178: lstore_2
    //   179: aload 12
    //   181: ldc_w 470
    //   184: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 8
    //   190: astore 6
    //   192: lload 4
    //   194: lstore_2
    //   195: aload 12
    //   197: aload_1
    //   198: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 8
    //   204: astore 6
    //   206: lload 4
    //   208: lstore_2
    //   209: ldc_w 472
    //   212: iconst_2
    //   213: aload 12
    //   215: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 475	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload 8
    //   223: astore 6
    //   225: lload 4
    //   227: lstore_2
    //   228: aload 10
    //   230: invokestatic 480	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   233: ifeq +47 -> 280
    //   236: aload 8
    //   238: astore 6
    //   240: lload 4
    //   242: lstore_2
    //   243: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +19 -> 265
    //   249: aload 8
    //   251: astore 6
    //   253: lload 4
    //   255: lstore_2
    //   256: ldc 26
    //   258: iconst_2
    //   259: ldc_w 482
    //   262: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload 8
    //   267: astore 6
    //   269: lload 4
    //   271: lstore_2
    //   272: aload_0
    //   273: aload_1
    //   274: aload 11
    //   276: invokevirtual 484	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: return
    //   280: aload 8
    //   282: astore 6
    //   284: lload 4
    //   286: lstore_2
    //   287: aload_0
    //   288: aload_1
    //   289: invokespecial 486	com/tencent/biz/pubaccount/util/PreloadManager:b	(Ljava/lang/String;)Ljava/lang/String;
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
    //   312: ldc 141
    //   314: invokevirtual 139	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   317: invokespecial 147	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;Z)Ljava/util/ArrayList;
    //   320: putfield 42	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   323: aload 8
    //   325: astore 6
    //   327: lload 4
    //   329: lstore_2
    //   330: aload_0
    //   331: getfield 37	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   334: astore_1
    //   335: aload 8
    //   337: astore 6
    //   339: lload 4
    //   341: lstore_2
    //   342: aload_1
    //   343: monitorenter
    //   344: aload_0
    //   345: getfield 58	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   348: aload 9
    //   350: aload_0
    //   351: getfield 42	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   354: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   357: pop
    //   358: new 81	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   365: astore 6
    //   367: aload 6
    //   369: ldc_w 488
    //   372: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 6
    //   378: aload 9
    //   380: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: ldc 26
    //   386: iconst_2
    //   387: aload 6
    //   389: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload_1
    //   396: monitorexit
    //   397: aload 8
    //   399: astore 6
    //   401: lload 4
    //   403: lstore_2
    //   404: aload_0
    //   405: getfield 490	com/tencent/biz/pubaccount/util/PreloadManager:jdField_b_of_type_Boolean	Z
    //   408: ifne +42 -> 450
    //   411: aload 8
    //   413: astore 6
    //   415: lload 4
    //   417: lstore_2
    //   418: invokestatic 495	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   421: iconst_1
    //   422: if_icmpne +28 -> 450
    //   425: aload 8
    //   427: astore 6
    //   429: lload 4
    //   431: lstore_2
    //   432: aload_0
    //   433: invokevirtual 497	com/tencent/biz/pubaccount/util/PreloadManager:b	()Z
    //   436: ifeq +14 -> 450
    //   439: aload 8
    //   441: astore 6
    //   443: lload 4
    //   445: lstore_2
    //   446: aload_0
    //   447: invokevirtual 499	com/tencent/biz/pubaccount/util/PreloadManager:d	()V
    //   450: aload 8
    //   452: astore 6
    //   454: lload 4
    //   456: lstore_2
    //   457: aload_0
    //   458: getfield 53	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   461: aload 9
    //   463: aload 12
    //   465: invokevirtual 502	java/lang/String:getBytes	()[B
    //   468: invokevirtual 503	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: aload 8
    //   474: astore 6
    //   476: lload 4
    //   478: lstore_2
    //   479: aload 12
    //   481: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   484: ifeq +121 -> 605
    //   487: aload 8
    //   489: astore 6
    //   491: lload 4
    //   493: lstore_2
    //   494: invokestatic 456	java/lang/System:currentTimeMillis	()J
    //   497: lload 4
    //   499: lsub
    //   500: lstore 4
    //   502: aload 8
    //   504: astore 6
    //   506: lload 4
    //   508: lstore_2
    //   509: ldc_w 505
    //   512: invokestatic 245	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   515: checkcast 505	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   518: astore_1
    //   519: aload 8
    //   521: astore 6
    //   523: lload 4
    //   525: lstore_2
    //   526: new 81	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   533: astore 9
    //   535: aload 8
    //   537: astore 6
    //   539: lload 4
    //   541: lstore_2
    //   542: aload 9
    //   544: ldc_w 302
    //   547: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 8
    //   553: astore 6
    //   555: lload 4
    //   557: lstore_2
    //   558: aload 9
    //   560: lload 4
    //   562: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 8
    //   568: astore 6
    //   570: lload 4
    //   572: lstore_2
    //   573: aload_1
    //   574: aconst_null
    //   575: ldc_w 302
    //   578: ldc_w 507
    //   581: ldc_w 507
    //   584: iconst_0
    //   585: iconst_0
    //   586: ldc 250
    //   588: aload 9
    //   590: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: ldc_w 509
    //   596: ldc_w 302
    //   599: invokeinterface 513 11 0
    //   604: return
    //   605: aload 8
    //   607: astore 6
    //   609: lload 4
    //   611: lstore_2
    //   612: new 81	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   619: astore_1
    //   620: aload 8
    //   622: astore 6
    //   624: lload 4
    //   626: lstore_2
    //   627: aload_1
    //   628: aload 12
    //   630: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload 8
    //   636: astore 6
    //   638: lload 4
    //   640: lstore_2
    //   641: aload_1
    //   642: ldc_w 515
    //   645: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 8
    //   651: astore 6
    //   653: lload 4
    //   655: lstore_2
    //   656: aload_1
    //   657: aload 9
    //   659: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 8
    //   665: astore 6
    //   667: lload 4
    //   669: lstore_2
    //   670: aload_1
    //   671: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokevirtual 502	java/lang/String:getBytes	()[B
    //   677: astore_1
    //   678: aload 8
    //   680: astore 6
    //   682: lload 4
    //   684: lstore_2
    //   685: aload 11
    //   687: invokestatic 517	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)[B
    //   690: astore 11
    //   692: aload 11
    //   694: ifnonnull +727 -> 1421
    //   697: return
    //   698: aload 8
    //   700: astore 6
    //   702: lload 4
    //   704: lstore_2
    //   705: aload 11
    //   707: aload_1
    //   708: invokestatic 519	com/tencent/biz/pubaccount/util/PreloadManager:b	([B[B)[B
    //   711: astore 11
    //   713: aload 8
    //   715: astore 6
    //   717: lload 4
    //   719: lstore_2
    //   720: new 94	java/io/File
    //   723: dup
    //   724: getstatic 466	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   727: invokespecial 520	java/io/File:<init>	(Ljava/lang/String;)V
    //   730: astore_1
    //   731: aload 8
    //   733: astore 6
    //   735: lload 4
    //   737: lstore_2
    //   738: aload_1
    //   739: invokevirtual 106	java/io/File:exists	()Z
    //   742: ifne +18 -> 760
    //   745: aload 8
    //   747: astore 6
    //   749: lload 4
    //   751: lstore_2
    //   752: aload_1
    //   753: invokevirtual 523	java/io/File:mkdirs	()Z
    //   756: ifne +4 -> 760
    //   759: return
    //   760: aload 8
    //   762: astore 6
    //   764: lload 4
    //   766: lstore_2
    //   767: new 81	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   774: astore 12
    //   776: aload 8
    //   778: astore 6
    //   780: lload 4
    //   782: lstore_2
    //   783: aload 12
    //   785: aload 9
    //   787: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 8
    //   793: astore 6
    //   795: lload 4
    //   797: lstore_2
    //   798: aload 12
    //   800: ldc_w 525
    //   803: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload 8
    //   809: astore 6
    //   811: lload 4
    //   813: lstore_2
    //   814: new 527	java/io/FileOutputStream
    //   817: dup
    //   818: new 94	java/io/File
    //   821: dup
    //   822: aload_1
    //   823: aload 12
    //   825: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokespecial 530	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   831: invokespecial 533	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   834: astore_1
    //   835: aload 11
    //   837: ifnonnull +137 -> 974
    //   840: lload 4
    //   842: lstore_2
    //   843: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   846: ifeq +15 -> 861
    //   849: lload 4
    //   851: lstore_2
    //   852: ldc 26
    //   854: iconst_2
    //   855: ldc_w 535
    //   858: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   861: lload 4
    //   863: lstore_2
    //   864: invokestatic 456	java/lang/System:currentTimeMillis	()J
    //   867: lload 4
    //   869: lsub
    //   870: lstore 4
    //   872: lload 4
    //   874: lstore_2
    //   875: ldc_w 505
    //   878: invokestatic 245	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   881: checkcast 505	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   884: astore 6
    //   886: lload 4
    //   888: lstore_2
    //   889: new 81	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   896: astore 7
    //   898: lload 4
    //   900: lstore_2
    //   901: aload 7
    //   903: ldc_w 302
    //   906: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: lload 4
    //   912: lstore_2
    //   913: aload 7
    //   915: lload 4
    //   917: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: lload 4
    //   923: lstore_2
    //   924: aload 6
    //   926: aconst_null
    //   927: ldc_w 302
    //   930: ldc_w 507
    //   933: ldc_w 507
    //   936: iconst_0
    //   937: iconst_0
    //   938: ldc 250
    //   940: aload 7
    //   942: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   945: ldc_w 509
    //   948: ldc_w 302
    //   951: invokeinterface 513 11 0
    //   956: lload 4
    //   958: lstore_2
    //   959: aload_1
    //   960: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   963: aload_1
    //   964: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   967: return
    //   968: astore_1
    //   969: aload_1
    //   970: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   973: return
    //   974: lload 4
    //   976: lstore_2
    //   977: aload_1
    //   978: aload 11
    //   980: invokevirtual 542	java/io/FileOutputStream:write	([B)V
    //   983: lload 4
    //   985: lstore_2
    //   986: aload_1
    //   987: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   990: lload 4
    //   992: lstore_2
    //   993: new 81	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1000: astore 6
    //   1002: lload 4
    //   1004: lstore_2
    //   1005: aload 6
    //   1007: getstatic 466	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   1010: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: pop
    //   1014: lload 4
    //   1016: lstore_2
    //   1017: aload 6
    //   1019: aload 9
    //   1021: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: pop
    //   1025: lload 4
    //   1027: lstore_2
    //   1028: aload 6
    //   1030: ldc_w 525
    //   1033: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: pop
    //   1037: lload 4
    //   1039: lstore_2
    //   1040: new 94	java/io/File
    //   1043: dup
    //   1044: aload 6
    //   1046: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: invokespecial 520	java/io/File:<init>	(Ljava/lang/String;)V
    //   1052: new 94	java/io/File
    //   1055: dup
    //   1056: aload 10
    //   1058: invokespecial 520	java/io/File:<init>	(Ljava/lang/String;)V
    //   1061: invokevirtual 546	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1064: pop
    //   1065: lload 4
    //   1067: lstore_2
    //   1068: invokestatic 456	java/lang/System:currentTimeMillis	()J
    //   1071: lload 4
    //   1073: lsub
    //   1074: lstore 4
    //   1076: lload 4
    //   1078: lstore_2
    //   1079: ldc_w 505
    //   1082: invokestatic 245	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1085: checkcast 505	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   1088: astore 6
    //   1090: lload 4
    //   1092: lstore_2
    //   1093: new 81	java/lang/StringBuilder
    //   1096: dup
    //   1097: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1100: astore 7
    //   1102: lload 4
    //   1104: lstore_2
    //   1105: aload 7
    //   1107: ldc_w 302
    //   1110: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: pop
    //   1114: lload 4
    //   1116: lstore_2
    //   1117: aload 7
    //   1119: lload 4
    //   1121: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1124: pop
    //   1125: lload 4
    //   1127: lstore_2
    //   1128: aload 6
    //   1130: aconst_null
    //   1131: ldc_w 302
    //   1134: ldc_w 507
    //   1137: ldc_w 507
    //   1140: iconst_0
    //   1141: iconst_0
    //   1142: ldc 231
    //   1144: aload 7
    //   1146: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: ldc_w 509
    //   1152: ldc_w 302
    //   1155: invokeinterface 513 11 0
    //   1160: aload_1
    //   1161: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   1164: return
    //   1165: astore 6
    //   1167: aload_1
    //   1168: astore 7
    //   1170: aload 6
    //   1172: astore_1
    //   1173: aload 7
    //   1175: astore 6
    //   1177: goto +214 -> 1391
    //   1180: astore 7
    //   1182: goto +90 -> 1272
    //   1185: aload 8
    //   1187: astore 6
    //   1189: lload 4
    //   1191: lstore_2
    //   1192: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1195: ifeq +231 -> 1426
    //   1198: aload 8
    //   1200: astore 6
    //   1202: lload 4
    //   1204: lstore_2
    //   1205: ldc 26
    //   1207: iconst_2
    //   1208: ldc_w 548
    //   1211: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: return
    //   1215: aload 8
    //   1217: astore 6
    //   1219: lload 4
    //   1221: lstore_2
    //   1222: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1225: ifeq +19 -> 1244
    //   1228: aload 8
    //   1230: astore 6
    //   1232: lload 4
    //   1234: lstore_2
    //   1235: ldc 26
    //   1237: iconst_2
    //   1238: ldc_w 548
    //   1241: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1244: return
    //   1245: astore 9
    //   1247: aload_1
    //   1248: monitorexit
    //   1249: aload 8
    //   1251: astore 6
    //   1253: lload 4
    //   1255: lstore_2
    //   1256: aload 9
    //   1258: athrow
    //   1259: astore_1
    //   1260: goto +131 -> 1391
    //   1263: astore 6
    //   1265: aload 7
    //   1267: astore_1
    //   1268: aload 6
    //   1270: astore 7
    //   1272: aload_1
    //   1273: astore 6
    //   1275: aload 7
    //   1277: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   1280: aload_1
    //   1281: astore 6
    //   1283: invokestatic 456	java/lang/System:currentTimeMillis	()J
    //   1286: lstore 4
    //   1288: aload_1
    //   1289: astore 6
    //   1291: ldc_w 505
    //   1294: invokestatic 245	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1297: checkcast 505	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   1300: astore 8
    //   1302: aload_1
    //   1303: astore 6
    //   1305: new 81	java/lang/StringBuilder
    //   1308: dup
    //   1309: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1312: astore 9
    //   1314: aload_1
    //   1315: astore 6
    //   1317: aload 9
    //   1319: ldc_w 302
    //   1322: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload_1
    //   1327: astore 6
    //   1329: aload 9
    //   1331: lload 4
    //   1333: lload_2
    //   1334: lsub
    //   1335: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload_1
    //   1340: astore 6
    //   1342: aload 8
    //   1344: aconst_null
    //   1345: ldc_w 302
    //   1348: ldc_w 507
    //   1351: ldc_w 507
    //   1354: iconst_0
    //   1355: iconst_0
    //   1356: ldc 250
    //   1358: aload 9
    //   1360: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1363: aload 7
    //   1365: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1368: ldc_w 302
    //   1371: invokeinterface 513 11 0
    //   1376: aload_1
    //   1377: ifnull +13 -> 1390
    //   1380: aload_1
    //   1381: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   1384: return
    //   1385: astore_1
    //   1386: aload_1
    //   1387: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   1390: return
    //   1391: aload 6
    //   1393: ifnull +18 -> 1411
    //   1396: aload 6
    //   1398: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   1401: goto +10 -> 1411
    //   1404: astore 6
    //   1406: aload 6
    //   1408: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   1411: aload_1
    //   1412: athrow
    //   1413: astore_1
    //   1414: goto -199 -> 1215
    //   1417: astore_1
    //   1418: goto -233 -> 1185
    //   1421: aload_1
    //   1422: ifnonnull -724 -> 698
    //   1425: return
    //   1426: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1427	0	this	PreloadManager
    //   0	1427	1	paramString	String
    //   17	1317	2	l1	long
    //   3	1329	4	l2	long
    //   13	1116	6	localObject1	Object
    //   1165	6	6	localObject2	Object
    //   1175	77	6	localObject3	Object
    //   1263	6	6	localIOException1	IOException
    //   1273	124	6	str	String
    //   1404	3	6	localIOException2	IOException
    //   6	1168	7	localObject4	Object
    //   1180	86	7	localIOException3	IOException
    //   1270	94	7	localObject5	Object
    //   9	1334	8	localIPublicAccountReportUtils	com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils
    //   22	998	9	localObject6	Object
    //   1245	12	9	localObject7	Object
    //   1312	47	9	localStringBuilder	StringBuilder
    //   65	992	10	localObject8	Object
    //   49	930	11	localObject9	Object
    //   139	685	12	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   963	967	968	java/io/IOException
    //   843	849	1165	finally
    //   852	861	1165	finally
    //   864	872	1165	finally
    //   875	886	1165	finally
    //   889	898	1165	finally
    //   901	910	1165	finally
    //   913	921	1165	finally
    //   924	956	1165	finally
    //   959	963	1165	finally
    //   977	983	1165	finally
    //   986	990	1165	finally
    //   993	1002	1165	finally
    //   1005	1014	1165	finally
    //   1017	1025	1165	finally
    //   1028	1037	1165	finally
    //   1040	1065	1165	finally
    //   1068	1076	1165	finally
    //   1079	1090	1165	finally
    //   1093	1102	1165	finally
    //   1105	1114	1165	finally
    //   1117	1125	1165	finally
    //   1128	1160	1165	finally
    //   843	849	1180	java/io/IOException
    //   852	861	1180	java/io/IOException
    //   864	872	1180	java/io/IOException
    //   875	886	1180	java/io/IOException
    //   889	898	1180	java/io/IOException
    //   901	910	1180	java/io/IOException
    //   913	921	1180	java/io/IOException
    //   924	956	1180	java/io/IOException
    //   959	963	1180	java/io/IOException
    //   977	983	1180	java/io/IOException
    //   986	990	1180	java/io/IOException
    //   993	1002	1180	java/io/IOException
    //   1005	1014	1180	java/io/IOException
    //   1017	1025	1180	java/io/IOException
    //   1028	1037	1180	java/io/IOException
    //   1040	1065	1180	java/io/IOException
    //   1068	1076	1180	java/io/IOException
    //   1079	1090	1180	java/io/IOException
    //   1093	1102	1180	java/io/IOException
    //   1105	1114	1180	java/io/IOException
    //   1117	1125	1180	java/io/IOException
    //   1128	1160	1180	java/io/IOException
    //   344	397	1245	finally
    //   1247	1249	1245	finally
    //   18	24	1259	finally
    //   37	51	1259	finally
    //   58	67	1259	finally
    //   74	83	1259	finally
    //   90	98	1259	finally
    //   105	112	1259	finally
    //   119	125	1259	finally
    //   132	141	1259	finally
    //   148	157	1259	finally
    //   164	172	1259	finally
    //   179	188	1259	finally
    //   195	202	1259	finally
    //   209	221	1259	finally
    //   228	236	1259	finally
    //   243	249	1259	finally
    //   256	265	1259	finally
    //   272	279	1259	finally
    //   287	294	1259	finally
    //   307	323	1259	finally
    //   330	335	1259	finally
    //   342	344	1259	finally
    //   404	411	1259	finally
    //   418	425	1259	finally
    //   432	439	1259	finally
    //   446	450	1259	finally
    //   457	472	1259	finally
    //   479	487	1259	finally
    //   494	502	1259	finally
    //   509	519	1259	finally
    //   526	535	1259	finally
    //   542	551	1259	finally
    //   558	566	1259	finally
    //   573	604	1259	finally
    //   612	620	1259	finally
    //   627	634	1259	finally
    //   641	649	1259	finally
    //   656	663	1259	finally
    //   670	678	1259	finally
    //   685	692	1259	finally
    //   705	713	1259	finally
    //   720	731	1259	finally
    //   738	745	1259	finally
    //   752	759	1259	finally
    //   767	776	1259	finally
    //   783	791	1259	finally
    //   798	807	1259	finally
    //   814	835	1259	finally
    //   1192	1198	1259	finally
    //   1205	1214	1259	finally
    //   1222	1228	1259	finally
    //   1235	1244	1259	finally
    //   1256	1259	1259	finally
    //   1275	1280	1259	finally
    //   1283	1288	1259	finally
    //   1291	1302	1259	finally
    //   1305	1314	1259	finally
    //   1317	1326	1259	finally
    //   1329	1339	1259	finally
    //   1342	1376	1259	finally
    //   18	24	1263	java/io/IOException
    //   37	51	1263	java/io/IOException
    //   58	67	1263	java/io/IOException
    //   74	83	1263	java/io/IOException
    //   90	98	1263	java/io/IOException
    //   105	112	1263	java/io/IOException
    //   119	125	1263	java/io/IOException
    //   132	141	1263	java/io/IOException
    //   148	157	1263	java/io/IOException
    //   164	172	1263	java/io/IOException
    //   179	188	1263	java/io/IOException
    //   195	202	1263	java/io/IOException
    //   209	221	1263	java/io/IOException
    //   228	236	1263	java/io/IOException
    //   243	249	1263	java/io/IOException
    //   256	265	1263	java/io/IOException
    //   272	279	1263	java/io/IOException
    //   287	294	1263	java/io/IOException
    //   307	323	1263	java/io/IOException
    //   330	335	1263	java/io/IOException
    //   342	344	1263	java/io/IOException
    //   404	411	1263	java/io/IOException
    //   418	425	1263	java/io/IOException
    //   432	439	1263	java/io/IOException
    //   446	450	1263	java/io/IOException
    //   457	472	1263	java/io/IOException
    //   479	487	1263	java/io/IOException
    //   494	502	1263	java/io/IOException
    //   509	519	1263	java/io/IOException
    //   526	535	1263	java/io/IOException
    //   542	551	1263	java/io/IOException
    //   558	566	1263	java/io/IOException
    //   573	604	1263	java/io/IOException
    //   612	620	1263	java/io/IOException
    //   627	634	1263	java/io/IOException
    //   641	649	1263	java/io/IOException
    //   656	663	1263	java/io/IOException
    //   670	678	1263	java/io/IOException
    //   685	692	1263	java/io/IOException
    //   705	713	1263	java/io/IOException
    //   720	731	1263	java/io/IOException
    //   738	745	1263	java/io/IOException
    //   752	759	1263	java/io/IOException
    //   767	776	1263	java/io/IOException
    //   783	791	1263	java/io/IOException
    //   798	807	1263	java/io/IOException
    //   814	835	1263	java/io/IOException
    //   1192	1198	1263	java/io/IOException
    //   1205	1214	1263	java/io/IOException
    //   1222	1228	1263	java/io/IOException
    //   1235	1244	1263	java/io/IOException
    //   1256	1259	1263	java/io/IOException
    //   1160	1164	1385	java/io/IOException
    //   1380	1384	1385	java/io/IOException
    //   1396	1401	1404	java/io/IOException
    //   457	472	1413	java/lang/OutOfMemoryError
    //   612	620	1417	java/lang/OutOfMemoryError
    //   627	634	1417	java/lang/OutOfMemoryError
    //   641	649	1417	java/lang/OutOfMemoryError
    //   656	663	1417	java/lang/OutOfMemoryError
    //   670	678	1417	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: new 376	javax/crypto/spec/SecretKeySpec
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 378
    //   8: invokespecial 381	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   11: astore_0
    //   12: ldc_w 378
    //   15: invokestatic 397	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_1
    //   21: aload_0
    //   22: invokevirtual 402	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 407	javax/crypto/Cipher:doFinal	([B)[B
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 409	javax/crypto/BadPaddingException:printStackTrace	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 410	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 403	java/security/InvalidKeyException:printStackTrace	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: goto +11 -> 66
    //   58: astore_0
    //   59: goto +13 -> 72
    //   62: astore_0
    //   63: goto +15 -> 78
    //   66: aload_0
    //   67: invokevirtual 408	java/lang/OutOfMemoryError:printStackTrace	()V
    //   70: aconst_null
    //   71: areturn
    //   72: aload_0
    //   73: invokevirtual 398	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   76: aconst_null
    //   77: areturn
    //   78: aload_0
    //   79: invokevirtual 363	java/security/NoSuchAlgorithmException:printStackTrace	()V
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
  
  /* Error */
  private String c(String paramString)
  {
    // Byte code:
    //   0: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 26
    //   8: iconst_2
    //   9: ldc_w 550
    //   12: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +47 -> 66
    //   22: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +39 -> 64
    //   28: new 81	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   35: astore 5
    //   37: aload 5
    //   39: ldc_w 552
    //   42: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 26
    //   55: iconst_2
    //   56: aload 5
    //   58: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aconst_null
    //   65: areturn
    //   66: invokestatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   69: lstore_2
    //   70: new 422	java/net/URL
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 424	java/net/URL:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 427	java/net/URL:getHost	()Ljava/lang/String;
    //   81: astore 7
    //   83: invokestatic 557	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/BaseInnerDns;
    //   86: aload 7
    //   88: sipush 1008
    //   91: invokevirtual 563	com/tencent/mobileqq/transfile/dns/BaseInnerDns:reqDns	(Ljava/lang/String;I)Ljava/lang/String;
    //   94: astore 8
    //   96: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +57 -> 156
    //   102: new 81	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   109: astore 5
    //   111: aload 5
    //   113: ldc_w 565
    //   116: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 5
    //   122: aload 7
    //   124: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 5
    //   130: ldc_w 567
    //   133: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 5
    //   139: aload 8
    //   141: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 26
    //   147: iconst_2
    //   148: aload 5
    //   150: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload 8
    //   158: ifnonnull +177 -> 335
    //   161: aload 7
    //   163: invokestatic 433	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   166: invokevirtual 436	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   169: astore 5
    //   171: goto +11 -> 182
    //   174: ldc_w 302
    //   177: astore 5
    //   179: goto -8 -> 171
    //   182: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +39 -> 224
    //   188: new 81	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   195: astore 6
    //   197: aload 6
    //   199: ldc_w 569
    //   202: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 6
    //   208: aload_1
    //   209: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: ldc 26
    //   215: iconst_2
    //   216: aload 6
    //   218: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: invokestatic 277	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   227: aload_1
    //   228: ldc_w 438
    //   231: aconst_null
    //   232: aconst_null
    //   233: aconst_null
    //   234: invokestatic 444	com/tencent/biz/common/util/HttpUtil:openUrlForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   237: astore 6
    //   239: aload_0
    //   240: iconst_1
    //   241: lload_2
    //   242: iconst_0
    //   243: aload 7
    //   245: aload 5
    //   247: ldc_w 446
    //   250: ldc 250
    //   252: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload 6
    //   257: areturn
    //   258: astore 6
    //   260: goto +5 -> 265
    //   263: astore 6
    //   265: aload 6
    //   267: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   270: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +40 -> 313
    //   276: new 81	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   283: astore 8
    //   285: aload 8
    //   287: ldc_w 571
    //   290: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 8
    //   296: aload 6
    //   298: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: ldc 26
    //   304: iconst_2
    //   305: aload 8
    //   307: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: iconst_0
    //   315: lload_2
    //   316: iconst_1
    //   317: aload 7
    //   319: aload 5
    //   321: ldc_w 446
    //   324: aload 6
    //   326: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   329: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload 6
    //   334: athrow
    //   335: aload_1
    //   336: aload 7
    //   338: aload 8
    //   340: invokevirtual 578	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   343: astore 5
    //   345: new 580	android/os/Bundle
    //   348: dup
    //   349: invokespecial 581	android/os/Bundle:<init>	()V
    //   352: astore 6
    //   354: aload 6
    //   356: ldc_w 583
    //   359: aload 7
    //   361: invokevirtual 586	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: istore 4
    //   369: iload 4
    //   371: ifeq +48 -> 419
    //   374: new 81	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   381: astore 9
    //   383: aload 9
    //   385: ldc_w 588
    //   388: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 9
    //   394: aload 5
    //   396: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc 26
    //   402: iconst_2
    //   403: aload 9
    //   405: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: goto +8 -> 419
    //   414: astore 6
    //   416: goto +60 -> 476
    //   419: invokestatic 277	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   422: astore 9
    //   424: aload 9
    //   426: aload 5
    //   428: ldc_w 438
    //   431: aconst_null
    //   432: aload 6
    //   434: aload 7
    //   436: invokestatic 444	com/tencent/biz/common/util/HttpUtil:openUrlForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   439: astore 5
    //   441: aload_0
    //   442: iconst_1
    //   443: lload_2
    //   444: iconst_2
    //   445: aload 7
    //   447: aload 8
    //   449: ldc 250
    //   451: ldc_w 446
    //   454: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload 5
    //   459: areturn
    //   460: astore 5
    //   462: goto +10 -> 472
    //   465: astore 5
    //   467: goto +5 -> 472
    //   470: astore 5
    //   472: aload 5
    //   474: astore 6
    //   476: aload 6
    //   478: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   481: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +40 -> 524
    //   487: new 81	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   494: astore 5
    //   496: aload 5
    //   498: ldc_w 590
    //   501: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 5
    //   507: aload 6
    //   509: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: ldc 26
    //   515: iconst_2
    //   516: aload 5
    //   518: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +39 -> 566
    //   530: new 81	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   537: astore 5
    //   539: aload 5
    //   541: ldc_w 592
    //   544: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 5
    //   550: aload_1
    //   551: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: ldc 26
    //   557: iconst_2
    //   558: aload 5
    //   560: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: invokestatic 277	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   569: astore 5
    //   571: aload 5
    //   573: aload_1
    //   574: ldc_w 438
    //   577: aconst_null
    //   578: aconst_null
    //   579: aconst_null
    //   580: invokestatic 444	com/tencent/biz/common/util/HttpUtil:openUrlForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;
    //   583: astore 5
    //   585: invokestatic 557	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/BaseInnerDns;
    //   588: aload 7
    //   590: aload 8
    //   592: sipush 1008
    //   595: invokevirtual 596	com/tencent/mobileqq/transfile/dns/BaseInnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   598: aload 6
    //   600: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   603: astore 9
    //   605: aload_0
    //   606: iconst_1
    //   607: lload_2
    //   608: iconst_3
    //   609: aload 7
    //   611: aload 8
    //   613: aload 9
    //   615: ldc 250
    //   617: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload 5
    //   622: areturn
    //   623: astore 5
    //   625: goto +10 -> 635
    //   628: astore 5
    //   630: goto +5 -> 635
    //   633: astore 5
    //   635: aload 5
    //   637: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   640: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   643: ifeq +40 -> 683
    //   646: new 81	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   653: astore 9
    //   655: aload 9
    //   657: ldc_w 598
    //   660: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 9
    //   666: aload 5
    //   668: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: ldc 26
    //   674: iconst_2
    //   675: aload 9
    //   677: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: aload_0
    //   684: iconst_0
    //   685: lload_2
    //   686: iconst_4
    //   687: aload 7
    //   689: aload 8
    //   691: aload 6
    //   693: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   696: aload 5
    //   698: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   701: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload 5
    //   706: athrow
    //   707: astore 5
    //   709: aload 5
    //   711: invokevirtual 599	java/net/MalformedURLException:printStackTrace	()V
    //   714: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq +39 -> 756
    //   720: new 81	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   727: astore 5
    //   729: aload 5
    //   731: ldc_w 601
    //   734: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload 5
    //   740: aload_1
    //   741: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: ldc 26
    //   747: iconst_2
    //   748: aload 5
    //   750: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: aconst_null
    //   757: areturn
    //   758: astore 5
    //   760: goto -586 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	this	PreloadManager
    //   0	763	1	paramString	String
    //   69	617	2	l	long
    //   367	3	4	bool	boolean
    //   35	423	5	localObject1	Object
    //   460	1	5	localIOException1	IOException
    //   465	1	5	localIOException2	IOException
    //   470	3	5	localIOException3	IOException
    //   494	127	5	localObject2	Object
    //   623	1	5	localIOException4	IOException
    //   628	1	5	localIOException5	IOException
    //   633	72	5	localIOException6	IOException
    //   707	3	5	localMalformedURLException	MalformedURLException
    //   727	22	5	localStringBuilder	StringBuilder
    //   758	1	5	localUnknownHostException	UnknownHostException
    //   195	61	6	localObject3	Object
    //   258	1	6	localIOException7	IOException
    //   263	70	6	localIOException8	IOException
    //   352	3	6	localBundle	android.os.Bundle
    //   414	19	6	localIOException9	IOException
    //   474	218	6	localIOException10	IOException
    //   81	607	7	str	String
    //   94	596	8	localObject4	Object
    //   381	295	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   239	255	258	java/io/IOException
    //   182	224	263	java/io/IOException
    //   224	239	263	java/io/IOException
    //   374	411	414	java/io/IOException
    //   441	457	460	java/io/IOException
    //   424	441	465	java/io/IOException
    //   364	369	470	java/io/IOException
    //   419	424	470	java/io/IOException
    //   605	620	623	java/io/IOException
    //   571	605	628	java/io/IOException
    //   524	566	633	java/io/IOException
    //   566	571	633	java/io/IOException
    //   70	156	707	java/net/MalformedURLException
    //   161	171	707	java/net/MalformedURLException
    //   182	224	707	java/net/MalformedURLException
    //   224	239	707	java/net/MalformedURLException
    //   239	255	707	java/net/MalformedURLException
    //   265	313	707	java/net/MalformedURLException
    //   313	335	707	java/net/MalformedURLException
    //   335	364	707	java/net/MalformedURLException
    //   364	369	707	java/net/MalformedURLException
    //   374	411	707	java/net/MalformedURLException
    //   419	424	707	java/net/MalformedURLException
    //   424	441	707	java/net/MalformedURLException
    //   441	457	707	java/net/MalformedURLException
    //   476	524	707	java/net/MalformedURLException
    //   524	566	707	java/net/MalformedURLException
    //   566	571	707	java/net/MalformedURLException
    //   571	605	707	java/net/MalformedURLException
    //   605	620	707	java/net/MalformedURLException
    //   635	683	707	java/net/MalformedURLException
    //   683	707	707	java/net/MalformedURLException
    //   161	171	758	java/net/UnknownHostException
  }
  
  private boolean c()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int i = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyIpConnectReportSwitch();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
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
  
  private byte[] c(String paramString)
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
      return d(paramString);
    }
    if (c()) {}
    try
    {
      localObject1 = new URL(paramString).getHost();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label104:
      label123:
      break label104;
    }
    Object localObject1 = "";
    try
    {
      String str = InetAddress.getByName((String)localObject1).getHostAddress();
      localObject2 = str;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      long l;
      break label123;
    }
    l = NetConnInfoCenter.getServerTimeMillis();
    try
    {
      paramString = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
      a(true, l, 0, (String)localObject1, (String)localObject2, "-1", "0");
      return paramString;
    }
    catch (IOException paramString)
    {
      a(false, l, 1, (String)localObject1, (String)localObject2, "-1", paramString.getMessage());
      throw paramString;
    }
    return HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  /* Error */
  private byte[] d(String paramString)
  {
    // Byte code:
    //   0: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 26
    //   8: iconst_2
    //   9: ldc_w 624
    //   12: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +47 -> 66
    //   22: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +39 -> 64
    //   28: new 81	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   35: astore 5
    //   37: aload 5
    //   39: ldc_w 626
    //   42: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 26
    //   55: iconst_2
    //   56: aload 5
    //   58: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aconst_null
    //   65: areturn
    //   66: invokestatic 271	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   69: lstore_2
    //   70: new 422	java/net/URL
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 424	java/net/URL:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 427	java/net/URL:getHost	()Ljava/lang/String;
    //   81: astore 7
    //   83: invokestatic 557	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/BaseInnerDns;
    //   86: aload 7
    //   88: sipush 1009
    //   91: invokevirtual 563	com/tencent/mobileqq/transfile/dns/BaseInnerDns:reqDns	(Ljava/lang/String;I)Ljava/lang/String;
    //   94: astore 8
    //   96: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +57 -> 156
    //   102: new 81	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   109: astore 5
    //   111: aload 5
    //   113: ldc_w 628
    //   116: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 5
    //   122: aload 7
    //   124: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 5
    //   130: ldc_w 567
    //   133: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 5
    //   139: aload 8
    //   141: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 26
    //   147: iconst_2
    //   148: aload 5
    //   150: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload 8
    //   158: ifnonnull +177 -> 335
    //   161: aload 7
    //   163: invokestatic 433	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   166: invokevirtual 436	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   169: astore 5
    //   171: goto +11 -> 182
    //   174: ldc_w 302
    //   177: astore 5
    //   179: goto -8 -> 171
    //   182: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +39 -> 224
    //   188: new 81	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   195: astore 6
    //   197: aload 6
    //   199: ldc_w 630
    //   202: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 6
    //   208: aload_1
    //   209: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: ldc 26
    //   215: iconst_2
    //   216: aload 6
    //   218: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: invokestatic 277	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   227: aload_1
    //   228: ldc_w 438
    //   231: aconst_null
    //   232: aconst_null
    //   233: aconst_null
    //   234: invokestatic 622	com/tencent/biz/common/util/HttpUtil:openUrlForByteForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)[B
    //   237: astore 6
    //   239: aload_0
    //   240: iconst_1
    //   241: lload_2
    //   242: iconst_0
    //   243: aload 7
    //   245: aload 5
    //   247: ldc_w 446
    //   250: ldc 250
    //   252: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload 6
    //   257: areturn
    //   258: astore 6
    //   260: goto +5 -> 265
    //   263: astore 6
    //   265: aload 6
    //   267: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   270: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +40 -> 313
    //   276: new 81	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   283: astore 8
    //   285: aload 8
    //   287: ldc_w 632
    //   290: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 8
    //   296: aload 6
    //   298: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: ldc 26
    //   304: iconst_2
    //   305: aload 8
    //   307: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: iconst_0
    //   315: lload_2
    //   316: iconst_1
    //   317: aload 7
    //   319: aload 5
    //   321: ldc_w 446
    //   324: aload 6
    //   326: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   329: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload 6
    //   334: athrow
    //   335: aload_1
    //   336: aload 7
    //   338: aload 8
    //   340: invokevirtual 578	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   343: astore 5
    //   345: new 580	android/os/Bundle
    //   348: dup
    //   349: invokespecial 581	android/os/Bundle:<init>	()V
    //   352: astore 6
    //   354: aload 6
    //   356: ldc_w 583
    //   359: aload 7
    //   361: invokevirtual 586	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: istore 4
    //   369: iload 4
    //   371: ifeq +48 -> 419
    //   374: new 81	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   381: astore 9
    //   383: aload 9
    //   385: ldc_w 634
    //   388: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 9
    //   394: aload 5
    //   396: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc 26
    //   402: iconst_2
    //   403: aload 9
    //   405: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: goto +8 -> 419
    //   414: astore 6
    //   416: goto +60 -> 476
    //   419: invokestatic 277	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   422: astore 9
    //   424: aload 9
    //   426: aload 5
    //   428: ldc_w 438
    //   431: aconst_null
    //   432: aload 6
    //   434: aload 7
    //   436: invokestatic 622	com/tencent/biz/common/util/HttpUtil:openUrlForByteForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)[B
    //   439: astore 5
    //   441: aload_0
    //   442: iconst_1
    //   443: lload_2
    //   444: iconst_2
    //   445: aload 7
    //   447: aload 8
    //   449: ldc 250
    //   451: ldc_w 446
    //   454: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload 5
    //   459: areturn
    //   460: astore 5
    //   462: goto +10 -> 472
    //   465: astore 5
    //   467: goto +5 -> 472
    //   470: astore 5
    //   472: aload 5
    //   474: astore 6
    //   476: aload 6
    //   478: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   481: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +40 -> 524
    //   487: new 81	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   494: astore 5
    //   496: aload 5
    //   498: ldc_w 636
    //   501: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 5
    //   507: aload 6
    //   509: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: ldc 26
    //   515: iconst_2
    //   516: aload 5
    //   518: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +39 -> 566
    //   530: new 81	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   537: astore 5
    //   539: aload 5
    //   541: ldc_w 638
    //   544: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload 5
    //   550: aload_1
    //   551: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: ldc 26
    //   557: iconst_2
    //   558: aload 5
    //   560: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: invokestatic 277	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   569: astore 5
    //   571: aload 5
    //   573: aload_1
    //   574: ldc_w 438
    //   577: aconst_null
    //   578: aconst_null
    //   579: aconst_null
    //   580: invokestatic 622	com/tencent/biz/common/util/HttpUtil:openUrlForByteForPubAccount	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)[B
    //   583: astore 5
    //   585: invokestatic 557	com/tencent/mobileqq/transfile/dns/InnerDns:getInstance	()Lcom/tencent/mobileqq/transfile/dns/BaseInnerDns;
    //   588: aload 7
    //   590: aload 8
    //   592: sipush 1009
    //   595: invokevirtual 596	com/tencent/mobileqq/transfile/dns/BaseInnerDns:reportBadIp	(Ljava/lang/String;Ljava/lang/String;I)V
    //   598: aload 6
    //   600: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   603: astore 9
    //   605: aload_0
    //   606: iconst_1
    //   607: lload_2
    //   608: iconst_3
    //   609: aload 7
    //   611: aload 8
    //   613: aload 9
    //   615: ldc 250
    //   617: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   620: aload 5
    //   622: areturn
    //   623: astore 5
    //   625: goto +10 -> 635
    //   628: astore 5
    //   630: goto +5 -> 635
    //   633: astore 5
    //   635: aload 5
    //   637: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   640: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   643: ifeq +40 -> 683
    //   646: new 81	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   653: astore 9
    //   655: aload 9
    //   657: ldc_w 640
    //   660: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 9
    //   666: aload 5
    //   668: invokevirtual 574	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: ldc 26
    //   674: iconst_2
    //   675: aload 9
    //   677: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: aload_0
    //   684: iconst_0
    //   685: lload_2
    //   686: iconst_4
    //   687: aload 7
    //   689: aload 8
    //   691: aload 6
    //   693: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   696: aload 5
    //   698: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   701: invokespecial 448	com/tencent/biz/pubaccount/util/PreloadManager:a	(ZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload 5
    //   706: athrow
    //   707: astore 5
    //   709: aload 5
    //   711: invokevirtual 599	java/net/MalformedURLException:printStackTrace	()V
    //   714: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq +39 -> 756
    //   720: new 81	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   727: astore 5
    //   729: aload 5
    //   731: ldc_w 642
    //   734: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload 5
    //   740: aload_1
    //   741: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: ldc 26
    //   747: iconst_2
    //   748: aload 5
    //   750: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: aconst_null
    //   757: areturn
    //   758: astore 5
    //   760: goto -586 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	this	PreloadManager
    //   0	763	1	paramString	String
    //   69	617	2	l	long
    //   367	3	4	bool	boolean
    //   35	423	5	localObject1	Object
    //   460	1	5	localIOException1	IOException
    //   465	1	5	localIOException2	IOException
    //   470	3	5	localIOException3	IOException
    //   494	127	5	localObject2	Object
    //   623	1	5	localIOException4	IOException
    //   628	1	5	localIOException5	IOException
    //   633	72	5	localIOException6	IOException
    //   707	3	5	localMalformedURLException	MalformedURLException
    //   727	22	5	localStringBuilder	StringBuilder
    //   758	1	5	localUnknownHostException	UnknownHostException
    //   195	61	6	localObject3	Object
    //   258	1	6	localIOException7	IOException
    //   263	70	6	localIOException8	IOException
    //   352	3	6	localBundle	android.os.Bundle
    //   414	19	6	localIOException9	IOException
    //   474	218	6	localIOException10	IOException
    //   81	607	7	str	String
    //   94	596	8	localObject4	Object
    //   381	295	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   239	255	258	java/io/IOException
    //   182	224	263	java/io/IOException
    //   224	239	263	java/io/IOException
    //   374	411	414	java/io/IOException
    //   441	457	460	java/io/IOException
    //   424	441	465	java/io/IOException
    //   364	369	470	java/io/IOException
    //   419	424	470	java/io/IOException
    //   605	620	623	java/io/IOException
    //   571	605	628	java/io/IOException
    //   524	566	633	java/io/IOException
    //   566	571	633	java/io/IOException
    //   70	156	707	java/net/MalformedURLException
    //   161	171	707	java/net/MalformedURLException
    //   182	224	707	java/net/MalformedURLException
    //   224	239	707	java/net/MalformedURLException
    //   239	255	707	java/net/MalformedURLException
    //   265	313	707	java/net/MalformedURLException
    //   313	335	707	java/net/MalformedURLException
    //   335	364	707	java/net/MalformedURLException
    //   364	369	707	java/net/MalformedURLException
    //   374	411	707	java/net/MalformedURLException
    //   419	424	707	java/net/MalformedURLException
    //   424	441	707	java/net/MalformedURLException
    //   441	457	707	java/net/MalformedURLException
    //   476	524	707	java/net/MalformedURLException
    //   524	566	707	java/net/MalformedURLException
    //   566	571	707	java/net/MalformedURLException
    //   571	605	707	java/net/MalformedURLException
    //   605	620	707	java/net/MalformedURLException
    //   635	683	707	java/net/MalformedURLException
    //   683	707	707	java/net/MalformedURLException
    //   161	171	758	java/net/UnknownHostException
  }
  
  public ArrayList<PreloadManager.ImgStruct> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (paramString != null)
      {
        Collections.sort(paramString, new PreloadManager.ImgStructComparator());
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          PreloadManager.ImgStruct localImgStruct = (PreloadManager.ImgStruct)paramString.next();
          if (a(localImgStruct.jdField_a_of_type_JavaLangString) == 0) {
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
    int i = 0;
    int j = 0;
    while (i < paramString.length())
    {
      if ((paramString.charAt(i) != ';') && (i != paramString.length() - 1)) {}
      int k;
      do
      {
        i += 1;
        break;
        if (i == paramString.length() - 1) {
          k = paramString.length();
        } else {
          k = i;
        }
      } while (k <= j);
      Object localObject2 = paramString.substring(j, k);
      Object localObject1 = localObject2;
      if (paramBoolean1) {
        localObject1 = a((String)localObject2, paramBoolean2);
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
      j = k + 1;
      i = j;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("add Task url:");
      ((StringBuilder)???).append(paramString);
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(paramString);
        if (!this.jdField_a_of_type_Boolean) {
          a();
        }
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ThreadManager.executeOnFileThread(new PreloadManager.ReadFileThread(this, paramString1, paramString2));
  }
  
  public boolean a()
  {
    return false;
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 456	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_1
    //   6: invokestatic 79	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 9
    //   17: aconst_null
    //   18: astore 6
    //   20: aload 6
    //   22: astore 7
    //   24: new 94	java/io/File
    //   27: dup
    //   28: getstatic 99	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE	Ljava/lang/String;
    //   31: invokespecial 520	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 11
    //   36: aload 6
    //   38: astore 7
    //   40: aload 11
    //   42: invokevirtual 106	java/io/File:exists	()Z
    //   45: ifne +17 -> 62
    //   48: aload 6
    //   50: astore 7
    //   52: aload 11
    //   54: invokevirtual 523	java/io/File:mkdirs	()Z
    //   57: ifne +5 -> 62
    //   60: iconst_0
    //   61: ireturn
    //   62: aload 6
    //   64: astore 7
    //   66: new 81	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   73: astore 12
    //   75: aload 6
    //   77: astore 7
    //   79: aload 12
    //   81: aload 10
    //   83: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 6
    //   89: astore 7
    //   91: aload 12
    //   93: ldc 88
    //   95: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 6
    //   101: astore 7
    //   103: new 94	java/io/File
    //   106: dup
    //   107: aload 11
    //   109: aload 12
    //   111: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 530	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   117: astore 12
    //   119: aload 6
    //   121: astore 7
    //   123: new 527	java/io/FileOutputStream
    //   126: dup
    //   127: aload 12
    //   129: invokespecial 533	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore 6
    //   134: lload 4
    //   136: lstore_2
    //   137: aload_0
    //   138: aload_1
    //   139: invokespecial 721	com/tencent/biz/pubaccount/util/PreloadManager:c	(Ljava/lang/String;)[B
    //   142: astore 7
    //   144: aload 7
    //   146: ifnull +220 -> 366
    //   149: lload 4
    //   151: lstore_2
    //   152: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +75 -> 230
    //   158: lload 4
    //   160: lstore_2
    //   161: new 81	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   168: astore 8
    //   170: lload 4
    //   172: lstore_2
    //   173: aload 8
    //   175: ldc_w 723
    //   178: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: lload 4
    //   184: lstore_2
    //   185: aload 8
    //   187: aload_1
    //   188: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: lload 4
    //   194: lstore_2
    //   195: aload 8
    //   197: ldc_w 725
    //   200: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: lload 4
    //   206: lstore_2
    //   207: aload 8
    //   209: invokestatic 456	java/lang/System:currentTimeMillis	()J
    //   212: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: lload 4
    //   218: lstore_2
    //   219: ldc 26
    //   221: iconst_2
    //   222: aload 8
    //   224: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: lload 4
    //   232: lstore_2
    //   233: aload 6
    //   235: aload 7
    //   237: invokevirtual 542	java/io/FileOutputStream:write	([B)V
    //   240: lload 4
    //   242: lstore_2
    //   243: aload 12
    //   245: new 94	java/io/File
    //   248: dup
    //   249: aload 11
    //   251: aload 10
    //   253: invokespecial 530	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   256: invokevirtual 546	java/io/File:renameTo	(Ljava/io/File;)Z
    //   259: pop
    //   260: lload 4
    //   262: lstore_2
    //   263: invokestatic 456	java/lang/System:currentTimeMillis	()J
    //   266: lload 4
    //   268: lsub
    //   269: lstore 4
    //   271: lload 4
    //   273: lstore_2
    //   274: ldc_w 505
    //   277: invokestatic 245	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   280: checkcast 505	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   283: astore_1
    //   284: lload 4
    //   286: lstore_2
    //   287: new 81	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   294: astore 7
    //   296: lload 4
    //   298: lstore_2
    //   299: aload 7
    //   301: ldc_w 302
    //   304: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: lload 4
    //   310: lstore_2
    //   311: aload 7
    //   313: lload 4
    //   315: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: lload 4
    //   321: lstore_2
    //   322: aload_1
    //   323: aconst_null
    //   324: ldc_w 302
    //   327: ldc_w 727
    //   330: ldc_w 727
    //   333: iconst_0
    //   334: iconst_0
    //   335: ldc 231
    //   337: aload 7
    //   339: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: ldc_w 509
    //   345: ldc 250
    //   347: invokeinterface 513 11 0
    //   352: aload 6
    //   354: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   357: iconst_1
    //   358: ireturn
    //   359: astore_1
    //   360: aload_1
    //   361: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   364: iconst_1
    //   365: ireturn
    //   366: lload 4
    //   368: lstore_2
    //   369: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +15 -> 387
    //   375: lload 4
    //   377: lstore_2
    //   378: ldc 26
    //   380: iconst_2
    //   381: ldc_w 729
    //   384: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: lload 4
    //   389: lstore_2
    //   390: invokestatic 456	java/lang/System:currentTimeMillis	()J
    //   393: lload 4
    //   395: lsub
    //   396: lstore 4
    //   398: lload 4
    //   400: lstore_2
    //   401: ldc_w 505
    //   404: invokestatic 245	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   407: checkcast 505	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   410: astore_1
    //   411: lload 4
    //   413: lstore_2
    //   414: new 81	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   421: astore 7
    //   423: lload 4
    //   425: lstore_2
    //   426: aload 7
    //   428: ldc_w 302
    //   431: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: lload 4
    //   437: lstore_2
    //   438: aload 7
    //   440: lload 4
    //   442: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: lload 4
    //   448: lstore_2
    //   449: aload_1
    //   450: aconst_null
    //   451: ldc_w 302
    //   454: ldc_w 727
    //   457: ldc_w 727
    //   460: iconst_0
    //   461: iconst_0
    //   462: ldc 250
    //   464: aload 7
    //   466: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: ldc_w 509
    //   472: ldc 250
    //   474: invokeinterface 513 11 0
    //   479: aload 6
    //   481: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   484: iconst_0
    //   485: ireturn
    //   486: astore_1
    //   487: aload_1
    //   488: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   491: iconst_0
    //   492: ireturn
    //   493: astore_1
    //   494: goto +193 -> 687
    //   497: astore 7
    //   499: aload 6
    //   501: astore_1
    //   502: aload 7
    //   504: astore 6
    //   506: goto +31 -> 537
    //   509: goto +46 -> 555
    //   512: astore 7
    //   514: aload 6
    //   516: astore_1
    //   517: aload 7
    //   519: astore 6
    //   521: goto +61 -> 582
    //   524: astore_1
    //   525: aload 7
    //   527: astore 6
    //   529: goto +158 -> 687
    //   532: astore 6
    //   534: aload 8
    //   536: astore_1
    //   537: aload_1
    //   538: astore 7
    //   540: aload 6
    //   542: invokevirtual 730	java/lang/IllegalArgumentException:printStackTrace	()V
    //   545: aload_1
    //   546: ifnull +139 -> 685
    //   549: aload_1
    //   550: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   553: iconst_0
    //   554: ireturn
    //   555: aload 6
    //   557: ifnull +128 -> 685
    //   560: aload 6
    //   562: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   565: iconst_0
    //   566: ireturn
    //   567: astore_1
    //   568: aload_1
    //   569: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   572: iconst_0
    //   573: ireturn
    //   574: astore 6
    //   576: aload 9
    //   578: astore_1
    //   579: lload 4
    //   581: lstore_2
    //   582: aload_1
    //   583: astore 7
    //   585: invokestatic 456	java/lang/System:currentTimeMillis	()J
    //   588: lstore 4
    //   590: aload_1
    //   591: astore 7
    //   593: ldc_w 505
    //   596: invokestatic 245	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   599: checkcast 505	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   602: astore 8
    //   604: aload_1
    //   605: astore 7
    //   607: new 81	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   614: astore 9
    //   616: aload_1
    //   617: astore 7
    //   619: aload 9
    //   621: ldc_w 302
    //   624: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_1
    //   629: astore 7
    //   631: aload 9
    //   633: lload 4
    //   635: lload_2
    //   636: lsub
    //   637: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload_1
    //   642: astore 7
    //   644: aload 8
    //   646: aconst_null
    //   647: ldc_w 302
    //   650: ldc_w 727
    //   653: ldc_w 727
    //   656: iconst_0
    //   657: iconst_0
    //   658: ldc 250
    //   660: aload 9
    //   662: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: aload 6
    //   667: invokevirtual 451	java/io/IOException:getMessage	()Ljava/lang/String;
    //   670: ldc 250
    //   672: invokeinterface 513 11 0
    //   677: aload_1
    //   678: ifnull +7 -> 685
    //   681: aload_1
    //   682: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   685: iconst_0
    //   686: ireturn
    //   687: aload 6
    //   689: ifnull +18 -> 707
    //   692: aload 6
    //   694: invokevirtual 538	java/io/FileOutputStream:close	()V
    //   697: goto +10 -> 707
    //   700: astore 6
    //   702: aload 6
    //   704: invokevirtual 539	java/io/IOException:printStackTrace	()V
    //   707: aload_1
    //   708: athrow
    //   709: astore_1
    //   710: goto +7 -> 717
    //   713: astore_1
    //   714: goto -205 -> 509
    //   717: aconst_null
    //   718: astore 6
    //   720: goto -165 -> 555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	this	PreloadManager
    //   0	723	1	paramString	String
    //   136	500	2	l1	long
    //   3	631	4	l2	long
    //   18	510	6	localObject1	Object
    //   532	29	6	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   574	119	6	localIOException1	IOException
    //   700	3	6	localIOException2	IOException
    //   718	1	6	localObject2	Object
    //   22	443	7	localObject3	Object
    //   497	6	7	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   512	14	7	localIOException3	IOException
    //   538	105	7	str1	String
    //   12	633	8	localObject4	Object
    //   15	646	9	localStringBuilder	StringBuilder
    //   9	243	10	str2	String
    //   34	216	11	localFile	File
    //   73	171	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   352	357	359	java/io/IOException
    //   479	484	486	java/io/IOException
    //   137	144	493	finally
    //   152	158	493	finally
    //   161	170	493	finally
    //   173	182	493	finally
    //   185	192	493	finally
    //   195	204	493	finally
    //   207	216	493	finally
    //   219	230	493	finally
    //   233	240	493	finally
    //   243	260	493	finally
    //   263	271	493	finally
    //   274	284	493	finally
    //   287	296	493	finally
    //   299	308	493	finally
    //   311	319	493	finally
    //   322	352	493	finally
    //   369	375	493	finally
    //   378	387	493	finally
    //   390	398	493	finally
    //   401	411	493	finally
    //   414	423	493	finally
    //   426	435	493	finally
    //   438	446	493	finally
    //   449	479	493	finally
    //   137	144	497	java/lang/IllegalArgumentException
    //   152	158	497	java/lang/IllegalArgumentException
    //   161	170	497	java/lang/IllegalArgumentException
    //   173	182	497	java/lang/IllegalArgumentException
    //   185	192	497	java/lang/IllegalArgumentException
    //   195	204	497	java/lang/IllegalArgumentException
    //   207	216	497	java/lang/IllegalArgumentException
    //   219	230	497	java/lang/IllegalArgumentException
    //   233	240	497	java/lang/IllegalArgumentException
    //   243	260	497	java/lang/IllegalArgumentException
    //   263	271	497	java/lang/IllegalArgumentException
    //   274	284	497	java/lang/IllegalArgumentException
    //   287	296	497	java/lang/IllegalArgumentException
    //   299	308	497	java/lang/IllegalArgumentException
    //   311	319	497	java/lang/IllegalArgumentException
    //   322	352	497	java/lang/IllegalArgumentException
    //   369	375	497	java/lang/IllegalArgumentException
    //   378	387	497	java/lang/IllegalArgumentException
    //   390	398	497	java/lang/IllegalArgumentException
    //   401	411	497	java/lang/IllegalArgumentException
    //   414	423	497	java/lang/IllegalArgumentException
    //   426	435	497	java/lang/IllegalArgumentException
    //   438	446	497	java/lang/IllegalArgumentException
    //   449	479	497	java/lang/IllegalArgumentException
    //   137	144	512	java/io/IOException
    //   152	158	512	java/io/IOException
    //   161	170	512	java/io/IOException
    //   173	182	512	java/io/IOException
    //   185	192	512	java/io/IOException
    //   195	204	512	java/io/IOException
    //   207	216	512	java/io/IOException
    //   219	230	512	java/io/IOException
    //   233	240	512	java/io/IOException
    //   243	260	512	java/io/IOException
    //   263	271	512	java/io/IOException
    //   274	284	512	java/io/IOException
    //   287	296	512	java/io/IOException
    //   299	308	512	java/io/IOException
    //   311	319	512	java/io/IOException
    //   322	352	512	java/io/IOException
    //   369	375	512	java/io/IOException
    //   378	387	512	java/io/IOException
    //   390	398	512	java/io/IOException
    //   401	411	512	java/io/IOException
    //   414	423	512	java/io/IOException
    //   426	435	512	java/io/IOException
    //   438	446	512	java/io/IOException
    //   449	479	512	java/io/IOException
    //   24	36	524	finally
    //   40	48	524	finally
    //   52	60	524	finally
    //   66	75	524	finally
    //   79	87	524	finally
    //   91	99	524	finally
    //   103	119	524	finally
    //   123	134	524	finally
    //   540	545	524	finally
    //   585	590	524	finally
    //   593	604	524	finally
    //   607	616	524	finally
    //   619	628	524	finally
    //   631	641	524	finally
    //   644	677	524	finally
    //   24	36	532	java/lang/IllegalArgumentException
    //   40	48	532	java/lang/IllegalArgumentException
    //   52	60	532	java/lang/IllegalArgumentException
    //   66	75	532	java/lang/IllegalArgumentException
    //   79	87	532	java/lang/IllegalArgumentException
    //   91	99	532	java/lang/IllegalArgumentException
    //   103	119	532	java/lang/IllegalArgumentException
    //   123	134	532	java/lang/IllegalArgumentException
    //   549	553	567	java/io/IOException
    //   560	565	567	java/io/IOException
    //   681	685	567	java/io/IOException
    //   24	36	574	java/io/IOException
    //   40	48	574	java/io/IOException
    //   52	60	574	java/io/IOException
    //   66	75	574	java/io/IOException
    //   79	87	574	java/io/IOException
    //   91	99	574	java/io/IOException
    //   103	119	574	java/io/IOException
    //   123	134	574	java/io/IOException
    //   692	697	700	java/io/IOException
    //   24	36	709	java/lang/OutOfMemoryError
    //   40	48	709	java/lang/OutOfMemoryError
    //   52	60	709	java/lang/OutOfMemoryError
    //   66	75	709	java/lang/OutOfMemoryError
    //   79	87	709	java/lang/OutOfMemoryError
    //   91	99	709	java/lang/OutOfMemoryError
    //   103	119	709	java/lang/OutOfMemoryError
    //   123	134	709	java/lang/OutOfMemoryError
    //   137	144	713	java/lang/OutOfMemoryError
    //   152	158	713	java/lang/OutOfMemoryError
    //   161	170	713	java/lang/OutOfMemoryError
    //   173	182	713	java/lang/OutOfMemoryError
    //   185	192	713	java/lang/OutOfMemoryError
    //   195	204	713	java/lang/OutOfMemoryError
    //   207	216	713	java/lang/OutOfMemoryError
    //   219	230	713	java/lang/OutOfMemoryError
    //   233	240	713	java/lang/OutOfMemoryError
    //   243	260	713	java/lang/OutOfMemoryError
    //   263	271	713	java/lang/OutOfMemoryError
    //   274	284	713	java/lang/OutOfMemoryError
    //   287	296	713	java/lang/OutOfMemoryError
    //   299	308	713	java/lang/OutOfMemoryError
    //   311	319	713	java/lang/OutOfMemoryError
    //   322	352	713	java/lang/OutOfMemoryError
    //   369	375	713	java/lang/OutOfMemoryError
    //   378	387	713	java/lang/OutOfMemoryError
    //   390	398	713	java/lang/OutOfMemoryError
    //   401	411	713	java/lang/OutOfMemoryError
    //   414	423	713	java/lang/OutOfMemoryError
    //   426	435	713	java/lang/OutOfMemoryError
    //   438	446	713	java/lang/OutOfMemoryError
    //   449	479	713	java/lang/OutOfMemoryError
  }
  
  public void b()
  {
    ThreadManager.post(new PreloadManager.1(this), 5, null, false);
  }
  
  public boolean b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("kandian_feeds_image_preload", false);
  }
  
  public byte[] b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (byte[])this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
  }
  
  public void c()
  {
    ThreadManager.executeOnNetWorkThread(new PreloadManager.PreloadThread(this));
  }
  
  public void d()
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
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager
 * JD-Core Version:    0.7.0.1
 */