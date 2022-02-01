package com.tencent.biz.pubaccount.util;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;

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
    Object localObject = MD5Utils.toMD5(paramString);
    paramString = (String)localObject + ".temp";
    localObject = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE, (String)localObject);
    paramString = new File(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE, paramString);
    if (((File)localObject).exists()) {
      return 2;
    }
    if (paramString.exists()) {
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
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString.startsWith("http:"));
      str = paramString;
    } while (paramString.startsWith("https"));
    if (paramBoolean) {
      return "https:" + paramString;
    }
    return "http:" + paramString;
  }
  
  private ArrayList<PreloadManager.ImgStruct> a(String paramString, boolean paramBoolean)
  {
    String str = null;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    new ArrayList();
    new ArrayList();
    ArrayList localArrayList = new ArrayList();
    paramString = Pattern.compile("<head>[.\\s\\S\\w]*?</head>").matcher(paramString);
    Matcher localMatcher;
    Object localObject;
    if (paramString.find())
    {
      localMatcher = Pattern.compile("<meta[.\\s\\S\\w]*?/>").matcher(paramString.group());
      paramString = null;
      while (localMatcher.find())
      {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, localMatcher.group());
        if (Pattern.compile("itemprop[\\s]*=[\\s]*\"[\\s]*prefetch-images[\\s]*\"").matcher(localMatcher.group()).find())
        {
          localObject = Pattern.compile("content[\\s]*=[\\s]*\"(.*?)\"").matcher(localMatcher.group());
          if (!((Matcher)localObject).find()) {
            break label414;
          }
          paramString = ((Matcher)localObject).group(1);
        }
      }
    }
    label414:
    for (;;)
    {
      localObject = Pattern.compile("priority[\\s]*=[\\s]*\"(.*?)\"").matcher(localMatcher.group());
      if (((Matcher)localObject).find()) {
        str = ((Matcher)localObject).group(1);
      }
      for (;;)
      {
        if (paramString != null)
        {
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          localObject = a(paramString, true, paramBoolean);
          List localList = a(str, false, paramBoolean);
          int i = ((List)localObject).size();
          int j = localList.size();
          PreloadManager.ImgStruct localImgStruct;
          if ((j == 0) || (j < i) || (j > i))
          {
            i = 0;
            while (i < ((List)localObject).size())
            {
              localImgStruct = new PreloadManager.ImgStruct();
              localImgStruct.jdField_a_of_type_JavaLangString = ((String)((List)localObject).get(i));
              localImgStruct.jdField_a_of_type_Int = 0;
              localArrayList.add(localImgStruct);
              i += 1;
            }
            break;
          }
          i = 0;
          while (i < ((List)localObject).size())
          {
            localImgStruct = new PreloadManager.ImgStruct();
            localImgStruct.jdField_a_of_type_JavaLangString = ((String)((List)localObject).get(i));
            try
            {
              localImgStruct.jdField_a_of_type_Int = Integer.parseInt((String)localList.get(i));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                localImgStruct.jdField_a_of_type_Int = 0;
                localNumberFormatException.printStackTrace();
                localArrayList.add(localImgStruct);
              }
            }
            finally
            {
              localArrayList.add(localImgStruct);
            }
            i += 1;
            continue;
            return localArrayList;
          }
        }
        break;
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!c()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_dataSource", "1");
    if (PublicAccountConfigUtilImpl.readInJoyIpConnect) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_enableIpConnect", str);
      localHashMap.put("param_connType", String.valueOf(paramInt));
      localHashMap.put("param_host", paramString1);
      localHashMap.put("param_ipAddr", paramString2);
      localHashMap.put("param_ipConnResult", paramString3);
      localHashMap.put("param_hostConnResult", paramString4);
      paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyIpConnect", paramBoolean, paramLong, 0L, localHashMap, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "doStatisticReport-->success:" + paramBoolean + ", costTime:" + paramLong + ", param_dataSource:1, param_enableIpConnect:" + str + ", param_connType:" + paramInt + ", param_host:" + paramString1 + ", param_ipAddr:" + paramString2 + ", param_ipConnResult:" + paramString3 + ", param_hostConnResult:" + paramString4);
      return;
    }
  }
  
  public static byte[] a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = new SecureRandom();
    byte[] arrayOfByte = new byte[32];
    ((SecureRandom)localObject2).nextBytes(arrayOfByte);
    localObject2 = new PBEKeySpec(paramString.toCharArray(), arrayOfByte, 1000, 256);
    try
    {
      paramString = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    }
    catch (NoSuchAlgorithmException paramString)
    {
      try
      {
        for (;;)
        {
          paramString = paramString.generateSecret((KeySpec)localObject2).getEncoded();
          return new SecretKeySpec(paramString, "AES").getEncoded();
          paramString = paramString;
          paramString.printStackTrace();
          paramString = null;
        }
      }
      catch (InvalidKeySpecException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localObject1;
        }
      }
    }
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 368	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_0
    //   11: ldc_w 370
    //   14: invokespecial 373	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   17: astore_2
    //   18: ldc_w 370
    //   21: invokestatic 391	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   24: astore_0
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_2
    //   28: invokevirtual 395	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 399	javax/crypto/Cipher:doFinal	([B)[B
    //   36: astore_0
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 374	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   44: aconst_null
    //   45: astore_0
    //   46: goto -21 -> 25
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 400	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   54: aconst_null
    //   55: astore_0
    //   56: goto -31 -> 25
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 401	java/security/InvalidKeyException:printStackTrace	()V
    //   64: goto -33 -> 31
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 402	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 403	javax/crypto/BadPaddingException:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 404	java/lang/OutOfMemoryError:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramArrayOfByte1	byte[]
    //   0	88	1	paramArrayOfByte2	byte[]
    //   17	11	2	localSecretKeySpec	SecretKeySpec
    //   59	2	2	localInvalidKeyException	java.security.InvalidKeyException
    // Exception table:
    //   from	to	target	type
    //   18	25	39	java/security/NoSuchAlgorithmException
    //   18	25	49	javax/crypto/NoSuchPaddingException
    //   25	31	59	java/security/InvalidKeyException
    //   31	37	67	javax/crypto/IllegalBlockSizeException
    //   31	37	74	javax/crypto/BadPaddingException
    //   31	37	81	java/lang/OutOfMemoryError
  }
  
  private String b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithCondition:" + PublicAccountConfigUtilImpl.readInJoyIpConnect);
    }
    if (PublicAccountConfigUtilImpl.readInJoyIpConnect) {
      return c(paramString);
    }
    long l;
    if (c()) {
      try
      {
        str1 = new URL(paramString).getHost();
      }
      catch (MalformedURLException localMalformedURLException)
      {
        try
        {
          for (;;)
          {
            String str1;
            String str3 = InetAddress.getByName(str1).getHostAddress();
            l = NetConnInfoCenter.getServerTimeMillis();
            try
            {
              paramString = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
              a(true, l, 0, str1, str3, "-1", "0");
              return paramString;
            }
            catch (IOException paramString)
            {
              String str2;
              String str4;
              a(false, l, 1, str2, str4, "-1", paramString.getMessage());
              throw paramString;
            }
            localMalformedURLException = localMalformedURLException;
            str2 = "";
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            str4 = "";
          }
        }
      }
    }
    return HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aconst_null
    //   5: astore 9
    //   7: aconst_null
    //   8: astore 7
    //   10: aload 9
    //   12: astore 8
    //   14: aload_1
    //   15: invokestatic 452	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 10
    //   20: aload 10
    //   22: ifnonnull +22 -> 44
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 454	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: return
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   43: return
    //   44: aload 9
    //   46: astore 8
    //   48: invokestatic 281	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   51: invokevirtual 285	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   54: checkcast 458	com/tencent/mobileqq/app/QQAppInterface
    //   57: invokevirtual 461	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   60: astore 12
    //   62: aload 9
    //   64: astore 8
    //   66: new 81	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   73: getstatic 464	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   76: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 10
    //   81: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 11
    //   89: aload 9
    //   91: astore 8
    //   93: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +45 -> 141
    //   99: aload 9
    //   101: astore 8
    //   103: ldc_w 466
    //   106: iconst_2
    //   107: new 81	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 468
    //   117: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 11
    //   122: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 470
    //   128: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_1
    //   132: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 473	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 9
    //   143: astore 8
    //   145: aload 11
    //   147: invokestatic 477	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   150: ifeq +55 -> 205
    //   153: aload 9
    //   155: astore 8
    //   157: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +16 -> 176
    //   163: aload 9
    //   165: astore 8
    //   167: ldc 26
    //   169: iconst_2
    //   170: ldc_w 479
    //   173: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 9
    //   178: astore 8
    //   180: aload_0
    //   181: aload_1
    //   182: aload 12
    //   184: invokevirtual 481	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iconst_0
    //   188: ifeq -151 -> 37
    //   191: new 454	java/lang/NullPointerException
    //   194: dup
    //   195: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   204: return
    //   205: aload 9
    //   207: astore 8
    //   209: aload_0
    //   210: aload_1
    //   211: invokespecial 483	com/tencent/biz/pubaccount/util/PreloadManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 13
    //   216: aload 13
    //   218: ifnonnull +21 -> 239
    //   221: iconst_0
    //   222: ifeq -185 -> 37
    //   225: new 454	java/lang/NullPointerException
    //   228: dup
    //   229: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   232: athrow
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   238: return
    //   239: aload 9
    //   241: astore 8
    //   243: aload_0
    //   244: aload_0
    //   245: aload 13
    //   247: aload_1
    //   248: ldc 141
    //   250: invokevirtual 139	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   253: invokespecial 147	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;Z)Ljava/util/ArrayList;
    //   256: putfield 42	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   259: aload 9
    //   261: astore 8
    //   263: aload_0
    //   264: getfield 37	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   267: astore_1
    //   268: aload 9
    //   270: astore 8
    //   272: aload_1
    //   273: monitorenter
    //   274: aload_0
    //   275: getfield 58	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   278: aload 10
    //   280: aload_0
    //   281: getfield 42	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   284: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: ldc 26
    //   290: iconst_2
    //   291: new 81	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 485
    //   301: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 10
    //   306: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_1
    //   316: monitorexit
    //   317: aload 9
    //   319: astore 8
    //   321: aload_0
    //   322: getfield 487	com/tencent/biz/pubaccount/util/PreloadManager:jdField_b_of_type_Boolean	Z
    //   325: ifne +33 -> 358
    //   328: aload 9
    //   330: astore 8
    //   332: invokestatic 492	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   335: iconst_1
    //   336: if_icmpne +22 -> 358
    //   339: aload 9
    //   341: astore 8
    //   343: aload_0
    //   344: invokevirtual 494	com/tencent/biz/pubaccount/util/PreloadManager:b	()Z
    //   347: ifeq +11 -> 358
    //   350: aload 9
    //   352: astore 8
    //   354: aload_0
    //   355: invokevirtual 496	com/tencent/biz/pubaccount/util/PreloadManager:d	()V
    //   358: aload 9
    //   360: astore 8
    //   362: aload_0
    //   363: getfield 53	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   366: aload 10
    //   368: aload 13
    //   370: invokevirtual 499	java/lang/String:getBytes	()[B
    //   373: invokevirtual 500	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: pop
    //   377: aload 9
    //   379: astore 8
    //   381: aload 13
    //   383: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   386: ifeq +245 -> 631
    //   389: aload 9
    //   391: astore 8
    //   393: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   396: lstore 4
    //   398: lload 4
    //   400: lload_2
    //   401: lsub
    //   402: lstore_2
    //   403: aload 9
    //   405: astore 8
    //   407: ldc_w 502
    //   410: invokestatic 508	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   413: checkcast 502	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   416: aconst_null
    //   417: ldc_w 294
    //   420: ldc_w 510
    //   423: ldc_w 510
    //   426: iconst_0
    //   427: iconst_0
    //   428: ldc_w 328
    //   431: new 81	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 294
    //   441: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: lload_2
    //   445: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: ldc_w 512
    //   454: ldc_w 294
    //   457: invokeinterface 516 11 0
    //   462: iconst_0
    //   463: ifeq -426 -> 37
    //   466: new 454	java/lang/NullPointerException
    //   469: dup
    //   470: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   473: athrow
    //   474: astore_1
    //   475: aload_1
    //   476: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   479: return
    //   480: astore 10
    //   482: aload_1
    //   483: monitorexit
    //   484: aload 9
    //   486: astore 8
    //   488: aload 10
    //   490: athrow
    //   491: astore_1
    //   492: aload 7
    //   494: astore 8
    //   496: aload_1
    //   497: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   500: aload 7
    //   502: astore 8
    //   504: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   507: lstore 4
    //   509: aload 7
    //   511: astore 8
    //   513: ldc_w 502
    //   516: invokestatic 508	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   519: checkcast 502	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   522: aconst_null
    //   523: ldc_w 294
    //   526: ldc_w 510
    //   529: ldc_w 510
    //   532: iconst_0
    //   533: iconst_0
    //   534: ldc_w 328
    //   537: new 81	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   544: ldc_w 294
    //   547: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: lload 4
    //   552: lload_2
    //   553: lsub
    //   554: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   557: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: aload_1
    //   561: invokevirtual 445	java/io/IOException:getMessage	()Ljava/lang/String;
    //   564: ldc_w 294
    //   567: invokeinterface 516 11 0
    //   572: aload 7
    //   574: ifnull -537 -> 37
    //   577: aload 7
    //   579: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   582: return
    //   583: astore_1
    //   584: aload_1
    //   585: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   588: return
    //   589: astore_1
    //   590: aload 9
    //   592: astore 8
    //   594: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +16 -> 613
    //   600: aload 9
    //   602: astore 8
    //   604: ldc 26
    //   606: iconst_2
    //   607: ldc_w 523
    //   610: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: iconst_0
    //   614: ifeq -577 -> 37
    //   617: new 454	java/lang/NullPointerException
    //   620: dup
    //   621: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   624: athrow
    //   625: astore_1
    //   626: aload_1
    //   627: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   630: return
    //   631: aload 9
    //   633: astore 8
    //   635: new 81	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   642: aload 13
    //   644: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: ldc_w 525
    //   650: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: aload 10
    //   655: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokevirtual 499	java/lang/String:getBytes	()[B
    //   664: astore_1
    //   665: aload 9
    //   667: astore 8
    //   669: aload 12
    //   671: invokestatic 527	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)[B
    //   674: astore 12
    //   676: aload 12
    //   678: ifnonnull +63 -> 741
    //   681: iconst_0
    //   682: ifeq -645 -> 37
    //   685: new 454	java/lang/NullPointerException
    //   688: dup
    //   689: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   692: athrow
    //   693: astore_1
    //   694: aload_1
    //   695: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   698: return
    //   699: astore_1
    //   700: aload 9
    //   702: astore 8
    //   704: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq +16 -> 723
    //   710: aload 9
    //   712: astore 8
    //   714: ldc 26
    //   716: iconst_2
    //   717: ldc_w 523
    //   720: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   723: iconst_0
    //   724: ifeq -687 -> 37
    //   727: new 454	java/lang/NullPointerException
    //   730: dup
    //   731: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   734: athrow
    //   735: astore_1
    //   736: aload_1
    //   737: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   740: return
    //   741: aload_1
    //   742: ifnonnull +21 -> 763
    //   745: iconst_0
    //   746: ifeq -709 -> 37
    //   749: new 454	java/lang/NullPointerException
    //   752: dup
    //   753: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   756: athrow
    //   757: astore_1
    //   758: aload_1
    //   759: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   762: return
    //   763: aload 9
    //   765: astore 8
    //   767: aload 12
    //   769: aload_1
    //   770: invokestatic 529	com/tencent/biz/pubaccount/util/PreloadManager:b	([B[B)[B
    //   773: astore 12
    //   775: aload 9
    //   777: astore 8
    //   779: new 94	java/io/File
    //   782: dup
    //   783: getstatic 464	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   786: invokespecial 530	java/io/File:<init>	(Ljava/lang/String;)V
    //   789: astore_1
    //   790: aload 9
    //   792: astore 8
    //   794: aload_1
    //   795: invokevirtual 106	java/io/File:exists	()Z
    //   798: ifne +36 -> 834
    //   801: aload 9
    //   803: astore 8
    //   805: aload_1
    //   806: invokevirtual 533	java/io/File:mkdirs	()Z
    //   809: istore 6
    //   811: iload 6
    //   813: ifne +21 -> 834
    //   816: iconst_0
    //   817: ifeq -780 -> 37
    //   820: new 454	java/lang/NullPointerException
    //   823: dup
    //   824: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   827: athrow
    //   828: astore_1
    //   829: aload_1
    //   830: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   833: return
    //   834: aload 9
    //   836: astore 8
    //   838: new 518	java/io/FileOutputStream
    //   841: dup
    //   842: new 94	java/io/File
    //   845: dup
    //   846: aload_1
    //   847: new 81	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   854: aload 10
    //   856: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: ldc_w 535
    //   862: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokespecial 538	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   871: invokespecial 541	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   874: astore_1
    //   875: aload 12
    //   877: ifnonnull +110 -> 987
    //   880: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   883: ifeq +12 -> 895
    //   886: ldc 26
    //   888: iconst_2
    //   889: ldc_w 543
    //   892: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   895: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   898: lstore 4
    //   900: lload 4
    //   902: lload_2
    //   903: lsub
    //   904: lstore 4
    //   906: lload 4
    //   908: lstore_2
    //   909: ldc_w 502
    //   912: invokestatic 508	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   915: checkcast 502	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   918: aconst_null
    //   919: ldc_w 294
    //   922: ldc_w 510
    //   925: ldc_w 510
    //   928: iconst_0
    //   929: iconst_0
    //   930: ldc_w 328
    //   933: new 81	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   940: ldc_w 294
    //   943: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: lload 4
    //   948: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   951: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: ldc_w 512
    //   957: ldc_w 294
    //   960: invokeinterface 516 11 0
    //   965: lload 4
    //   967: lstore_2
    //   968: aload_1
    //   969: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   972: aload_1
    //   973: ifnull -936 -> 37
    //   976: aload_1
    //   977: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   980: return
    //   981: astore_1
    //   982: aload_1
    //   983: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   986: return
    //   987: aload_1
    //   988: aload 12
    //   990: invokevirtual 546	java/io/FileOutputStream:write	([B)V
    //   993: aload_1
    //   994: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   997: new 94	java/io/File
    //   1000: dup
    //   1001: new 81	java/lang/StringBuilder
    //   1004: dup
    //   1005: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1008: getstatic 464	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD	Ljava/lang/String;
    //   1011: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: aload 10
    //   1016: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: ldc_w 535
    //   1022: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: invokespecial 530	java/io/File:<init>	(Ljava/lang/String;)V
    //   1031: new 94	java/io/File
    //   1034: dup
    //   1035: aload 11
    //   1037: invokespecial 530	java/io/File:<init>	(Ljava/lang/String;)V
    //   1040: invokevirtual 550	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1043: pop
    //   1044: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   1047: lstore 4
    //   1049: lload 4
    //   1051: lload_2
    //   1052: lsub
    //   1053: lstore 4
    //   1055: lload 4
    //   1057: lstore_2
    //   1058: ldc_w 502
    //   1061: invokestatic 508	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1064: checkcast 502	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   1067: aconst_null
    //   1068: ldc_w 294
    //   1071: ldc_w 510
    //   1074: ldc_w 510
    //   1077: iconst_0
    //   1078: iconst_0
    //   1079: ldc 233
    //   1081: new 81	java/lang/StringBuilder
    //   1084: dup
    //   1085: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1088: ldc_w 294
    //   1091: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: lload 4
    //   1096: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: ldc_w 512
    //   1105: ldc_w 294
    //   1108: invokeinterface 516 11 0
    //   1113: aload_1
    //   1114: ifnull -1077 -> 37
    //   1117: aload_1
    //   1118: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   1121: return
    //   1122: astore_1
    //   1123: aload_1
    //   1124: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   1127: return
    //   1128: astore_1
    //   1129: aload 8
    //   1131: ifnull +8 -> 1139
    //   1134: aload 8
    //   1136: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   1139: aload_1
    //   1140: athrow
    //   1141: astore 7
    //   1143: aload 7
    //   1145: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   1148: goto -9 -> 1139
    //   1151: astore 7
    //   1153: aload_1
    //   1154: astore 8
    //   1156: aload 7
    //   1158: astore_1
    //   1159: goto -30 -> 1129
    //   1162: astore_1
    //   1163: goto -671 -> 492
    //   1166: astore 7
    //   1168: aload_1
    //   1169: astore 8
    //   1171: aload 7
    //   1173: astore_1
    //   1174: aload 8
    //   1176: astore 7
    //   1178: goto -686 -> 492
    //   1181: astore 7
    //   1183: aload_1
    //   1184: astore 8
    //   1186: aload 7
    //   1188: astore_1
    //   1189: aload 8
    //   1191: astore 7
    //   1193: goto -701 -> 492
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1196	0	this	PreloadManager
    //   0	1196	1	paramString	String
    //   3	1055	2	l1	long
    //   396	699	4	l2	long
    //   809	3	6	bool	boolean
    //   8	570	7	localObject1	Object
    //   1141	3	7	localIOException1	IOException
    //   1151	6	7	localObject2	Object
    //   1166	6	7	localIOException2	IOException
    //   1176	1	7	localObject3	Object
    //   1181	6	7	localIOException3	IOException
    //   1191	1	7	localObject4	Object
    //   12	1178	8	localObject5	Object
    //   5	830	9	localObject6	Object
    //   18	349	10	str1	String
    //   480	535	10	str2	String
    //   87	949	11	str3	String
    //   60	929	12	localObject7	Object
    //   214	429	13	str4	String
    // Exception table:
    //   from	to	target	type
    //   29	37	38	java/io/IOException
    //   191	199	199	java/io/IOException
    //   225	233	233	java/io/IOException
    //   466	474	474	java/io/IOException
    //   274	317	480	finally
    //   482	484	480	finally
    //   14	20	491	java/io/IOException
    //   48	62	491	java/io/IOException
    //   66	89	491	java/io/IOException
    //   93	99	491	java/io/IOException
    //   103	141	491	java/io/IOException
    //   145	153	491	java/io/IOException
    //   157	163	491	java/io/IOException
    //   167	176	491	java/io/IOException
    //   180	187	491	java/io/IOException
    //   209	216	491	java/io/IOException
    //   243	259	491	java/io/IOException
    //   263	268	491	java/io/IOException
    //   272	274	491	java/io/IOException
    //   321	328	491	java/io/IOException
    //   332	339	491	java/io/IOException
    //   343	350	491	java/io/IOException
    //   354	358	491	java/io/IOException
    //   362	377	491	java/io/IOException
    //   381	389	491	java/io/IOException
    //   393	398	491	java/io/IOException
    //   488	491	491	java/io/IOException
    //   594	600	491	java/io/IOException
    //   604	613	491	java/io/IOException
    //   635	665	491	java/io/IOException
    //   669	676	491	java/io/IOException
    //   704	710	491	java/io/IOException
    //   714	723	491	java/io/IOException
    //   767	775	491	java/io/IOException
    //   779	790	491	java/io/IOException
    //   794	801	491	java/io/IOException
    //   805	811	491	java/io/IOException
    //   838	875	491	java/io/IOException
    //   577	582	583	java/io/IOException
    //   362	377	589	java/lang/OutOfMemoryError
    //   617	625	625	java/io/IOException
    //   685	693	693	java/io/IOException
    //   635	665	699	java/lang/OutOfMemoryError
    //   727	735	735	java/io/IOException
    //   749	757	757	java/io/IOException
    //   820	828	828	java/io/IOException
    //   976	980	981	java/io/IOException
    //   1117	1121	1122	java/io/IOException
    //   14	20	1128	finally
    //   48	62	1128	finally
    //   66	89	1128	finally
    //   93	99	1128	finally
    //   103	141	1128	finally
    //   145	153	1128	finally
    //   157	163	1128	finally
    //   167	176	1128	finally
    //   180	187	1128	finally
    //   209	216	1128	finally
    //   243	259	1128	finally
    //   263	268	1128	finally
    //   272	274	1128	finally
    //   321	328	1128	finally
    //   332	339	1128	finally
    //   343	350	1128	finally
    //   354	358	1128	finally
    //   362	377	1128	finally
    //   381	389	1128	finally
    //   393	398	1128	finally
    //   407	462	1128	finally
    //   488	491	1128	finally
    //   496	500	1128	finally
    //   504	509	1128	finally
    //   513	572	1128	finally
    //   594	600	1128	finally
    //   604	613	1128	finally
    //   635	665	1128	finally
    //   669	676	1128	finally
    //   704	710	1128	finally
    //   714	723	1128	finally
    //   767	775	1128	finally
    //   779	790	1128	finally
    //   794	801	1128	finally
    //   805	811	1128	finally
    //   838	875	1128	finally
    //   1134	1139	1141	java/io/IOException
    //   880	895	1151	finally
    //   895	900	1151	finally
    //   909	965	1151	finally
    //   968	972	1151	finally
    //   987	1049	1151	finally
    //   1058	1113	1151	finally
    //   407	462	1162	java/io/IOException
    //   880	895	1166	java/io/IOException
    //   895	900	1166	java/io/IOException
    //   987	1049	1166	java/io/IOException
    //   909	965	1181	java/io/IOException
    //   968	972	1181	java/io/IOException
    //   1058	1113	1181	java/io/IOException
  }
  
  /* Error */
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: new 368	javax/crypto/spec/SecretKeySpec
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 370
    //   8: invokespecial 373	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   11: astore_0
    //   12: ldc_w 370
    //   15: invokestatic 391	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_1
    //   21: aload_0
    //   22: invokevirtual 395	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 399	javax/crypto/Cipher:doFinal	([B)[B
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 402	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 401	java/security/InvalidKeyException:printStackTrace	()V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 374	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 403	javax/crypto/BadPaddingException:printStackTrace	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 400	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 404	java/lang/OutOfMemoryError:printStackTrace	()V
    //   73: aconst_null
    //   74: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramArrayOfByte1	byte[]
    //   0	75	1	paramArrayOfByte2	byte[]
    //   18	8	2	localCipher	javax.crypto.Cipher
    // Exception table:
    //   from	to	target	type
    //   25	31	33	javax/crypto/IllegalBlockSizeException
    //   19	25	40	java/security/InvalidKeyException
    //   25	31	40	java/security/InvalidKeyException
    //   34	38	40	java/security/InvalidKeyException
    //   55	59	40	java/security/InvalidKeyException
    //   12	19	47	java/security/NoSuchAlgorithmException
    //   19	25	47	java/security/NoSuchAlgorithmException
    //   25	31	47	java/security/NoSuchAlgorithmException
    //   34	38	47	java/security/NoSuchAlgorithmException
    //   41	45	47	java/security/NoSuchAlgorithmException
    //   55	59	47	java/security/NoSuchAlgorithmException
    //   25	31	54	javax/crypto/BadPaddingException
    //   12	19	61	javax/crypto/NoSuchPaddingException
    //   19	25	61	javax/crypto/NoSuchPaddingException
    //   25	31	61	javax/crypto/NoSuchPaddingException
    //   34	38	61	javax/crypto/NoSuchPaddingException
    //   41	45	61	javax/crypto/NoSuchPaddingException
    //   55	59	61	javax/crypto/NoSuchPaddingException
    //   12	19	68	java/lang/OutOfMemoryError
    //   19	25	68	java/lang/OutOfMemoryError
    //   25	31	68	java/lang/OutOfMemoryError
    //   34	38	68	java/lang/OutOfMemoryError
    //   41	45	68	java/lang/OutOfMemoryError
    //   55	59	68	java/lang/OutOfMemoryError
  }
  
  private String c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "begin downloadHtmlWithIpConnect!");
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect empty url:" + paramString);
      }
      return null;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    String str3;
    try
    {
      str3 = new URL(paramString).getHost();
      String str1 = InnerDns.getInstance().reqDns(str3, 1008);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect host:" + str3 + ", ip:" + str1);
      }
      if (str1 == null) {
        try
        {
          str1 = InetAddress.getByName(str3).getHostAddress();
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            try
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect direct download html with host:" + paramString);
              }
              String str4 = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
              a(true, l, 0, str3, str1, "-1", "0");
              return str4;
            }
            catch (IOException localIOException1)
            {
              String str2;
              localIOException1.printStackTrace();
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect direct download html error:" + localIOException1);
              a(false, l, 1, str3, str2, "-1", localIOException1.getMessage());
              throw localIOException1;
            }
            localUnknownHostException = localUnknownHostException;
            str2 = "";
          }
        }
      }
      str5 = paramString.replaceFirst(str3, localMalformedURLException);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect illegal url:" + paramString);
      }
      return null;
    }
    String str5;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("Host", str3);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect download html with ip:" + str5);
      }
      str5 = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), str5, "GET", null, (Bundle)localObject, str3);
      a(true, l, 2, str3, localMalformedURLException, "0", "-1");
      return str5;
    }
    catch (IOException localIOException2)
    {
      localIOException2.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect download html with ip error:" + localIOException2);
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect retry direct download html with host:" + paramString);
        }
        localObject = HttpUtil.openUrlForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
        InnerDns.getInstance().reportBadIp(str3, localMalformedURLException, 1008);
        a(true, l, 3, str3, localMalformedURLException, localIOException2.getMessage(), "0");
        return localObject;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithIpConnect retry direct download html error:" + localIOException3);
        }
        a(false, l, 4, str3, localMalformedURLException, localIOException2.getMessage(), localIOException3.getMessage());
        throw localIOException3;
      }
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    boolean bool1 = bool2;
    switch (PublicAccountConfigUtilImpl.readInJoyIpConnectReportSwitch)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "shouldDoStatisticReport->uin:" + str + ", result:" + bool1);
      }
      return bool1;
      bool1 = true;
      continue;
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(PublicAccountConfigUtilImpl.readInJoyIpConnectReportTail))
        {
          bool1 = bool2;
          if (str.endsWith(PublicAccountConfigUtilImpl.readInJoyIpConnectReportTail)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private byte[] c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithCondition:" + PublicAccountConfigUtilImpl.readInJoyIpConnect);
    }
    if (PublicAccountConfigUtilImpl.readInJoyIpConnect) {
      return d(paramString);
    }
    long l;
    if (c()) {
      try
      {
        str1 = new URL(paramString).getHost();
      }
      catch (MalformedURLException localMalformedURLException)
      {
        try
        {
          for (;;)
          {
            String str1;
            String str3 = InetAddress.getByName(str1).getHostAddress();
            l = NetConnInfoCenter.getServerTimeMillis();
            try
            {
              paramString = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
              a(true, l, 0, str1, str3, "-1", "0");
              return paramString;
            }
            catch (IOException paramString)
            {
              String str2;
              String str4;
              a(false, l, 1, str2, str4, "-1", paramString.getMessage());
              throw paramString;
            }
            localMalformedURLException = localMalformedURLException;
            str2 = "";
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            str4 = "";
          }
        }
      }
    }
    return HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  private byte[] d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "begin downloadImageWithIpConnect!");
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect empty url:" + paramString);
      }
      return null;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    String str3;
    try
    {
      str3 = new URL(paramString).getHost();
      String str1 = InnerDns.getInstance().reqDns(str3, 1009);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect host:" + str3 + ", ip:" + str1);
      }
      if (str1 == null) {
        try
        {
          str1 = InetAddress.getByName(str3).getHostAddress();
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            try
            {
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect direct download image with host:" + paramString);
              }
              byte[] arrayOfByte = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
              a(true, l, 0, str3, str1, "-1", "0");
              return arrayOfByte;
            }
            catch (IOException localIOException1)
            {
              String str2;
              localIOException1.printStackTrace();
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect direct download image error:" + localIOException1);
              a(false, l, 1, str3, str2, "-1", localIOException1.getMessage());
              throw localIOException1;
            }
            localUnknownHostException = localUnknownHostException;
            str2 = "";
          }
        }
      }
      localObject1 = paramString.replaceFirst(str3, localMalformedURLException);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect illegal url:" + paramString);
      }
      return null;
    }
    Object localObject1;
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("Host", str3);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect download image with ip:" + (String)localObject1);
      }
      localObject1 = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), (String)localObject1, "GET", null, (Bundle)localObject2, str3);
      a(true, l, 2, str3, localMalformedURLException, "0", "-1");
      return localObject1;
    }
    catch (IOException localIOException2)
    {
      localIOException2.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect download image with ip error:" + localIOException2);
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect retry direct download image with host:" + paramString);
        }
        localObject2 = HttpUtil.openUrlForByteForPubAccount(BaseApplication.getContext(), paramString, "GET", null, null, null);
        InnerDns.getInstance().reportBadIp(str3, localMalformedURLException, 1009);
        a(true, l, 3, str3, localMalformedURLException, localIOException2.getMessage(), "0");
        return localObject2;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithIpConnect retry direct download image error:" + localIOException3);
        }
        a(false, l, 4, str3, localMalformedURLException, localIOException2.getMessage(), localIOException3.getMessage());
        throw localIOException3;
      }
    }
  }
  
  public ArrayList<PreloadManager.ImgStruct> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (paramString == null) {
        break label97;
      }
      Collections.sort(paramString, new PreloadManager.ImgStructComparator());
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        PreloadManager.ImgStruct localImgStruct = (PreloadManager.ImgStruct)paramString.next();
        if (a(localImgStruct.jdField_a_of_type_JavaLangString) == 0) {
          localArrayList.add(localImgStruct);
        }
      }
    }
    return localArrayList;
    label97:
    return null;
  }
  
  public List<String> a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    int j = 0;
    while (i < paramString.length()) {
      if ((paramString.charAt(i) == ';') || (i == paramString.length() - 1))
      {
        if (i == paramString.length() - 1) {}
        for (int k = paramString.length();; k = i)
        {
          if (k <= j) {
            break label175;
          }
          String str2 = paramString.substring(j, k);
          String str1 = str2;
          if (paramBoolean1) {
            str1 = a(str2, paramBoolean2);
          }
          if (str1 != null)
          {
            localArrayList.add(str1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "预下载图片url = " + str1);
            }
          }
          i = k + 1;
          j = i;
          break;
        }
        label175:
        i += 1;
      }
      else
      {
        i += 1;
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "add Task url:" + paramString);
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
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != null)
    {
      localObject1 = (AppInterface)((AppRuntime)localObject1).getAppRuntime("modular_web");
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + ((AppInterface)localObject1).getCurrentAccountUin(), 0).getString("kandian_feeds_fling_LToR_host", "");
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONArray((String)localObject1);
          if (localObject1 != null)
          {
            int i = 0;
            while (i < ((JSONArray)localObject1).length())
            {
              Object localObject2 = ((JSONArray)localObject1).get(i);
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "kandian_feeds_fling_LToR_host canFlingLToRHost:" + localObject2);
              }
              boolean bool = paramString.equals(localObject2);
              if (bool) {
                return true;
              }
              i += 1;
            }
          }
        }
        return false;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    ThreadManager.post(new PreloadManager.1(this), 5, null, false);
  }
  
  public boolean b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return BaseApplicationImpl.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + localQQAppInterface.getCurrentAccountUin(), 0).getBoolean("kandian_feeds_image_preload", false);
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_1
    //   5: invokestatic 79	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 9
    //   10: new 94	java/io/File
    //   13: dup
    //   14: getstatic 99	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD_IMAGE	Ljava/lang/String;
    //   17: invokespecial 530	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 12
    //   22: aload 12
    //   24: invokevirtual 106	java/io/File:exists	()Z
    //   27: ifne +40 -> 67
    //   30: aload 12
    //   32: invokevirtual 533	java/io/File:mkdirs	()Z
    //   35: istore 6
    //   37: iload 6
    //   39: ifne +28 -> 67
    //   42: iconst_0
    //   43: istore 6
    //   45: iconst_0
    //   46: ifeq +11 -> 57
    //   49: new 454	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 455	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: iload 6
    //   59: ireturn
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   65: iconst_0
    //   66: ireturn
    //   67: new 94	java/io/File
    //   70: dup
    //   71: aload 12
    //   73: new 81	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   80: aload 9
    //   82: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 88
    //   87: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 538	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   96: astore 11
    //   98: new 518	java/io/FileOutputStream
    //   101: dup
    //   102: aload 11
    //   104: invokespecial 541	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   107: astore 7
    //   109: aload 7
    //   111: astore 8
    //   113: aload_0
    //   114: aload_1
    //   115: invokespecial 776	com/tencent/biz/pubaccount/util/PreloadManager:c	(Ljava/lang/String;)[B
    //   118: astore 10
    //   120: aload 10
    //   122: ifnull +186 -> 308
    //   125: aload 7
    //   127: astore 8
    //   129: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +45 -> 177
    //   135: aload 7
    //   137: astore 8
    //   139: ldc 26
    //   141: iconst_2
    //   142: new 81	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 778
    //   152: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc_w 780
    //   162: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   168: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   171: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 7
    //   179: astore 8
    //   181: aload 7
    //   183: aload 10
    //   185: invokevirtual 546	java/io/FileOutputStream:write	([B)V
    //   188: aload 7
    //   190: astore 8
    //   192: aload 11
    //   194: new 94	java/io/File
    //   197: dup
    //   198: aload 12
    //   200: aload 9
    //   202: invokespecial 538	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   205: invokevirtual 550	java/io/File:renameTo	(Ljava/io/File;)Z
    //   208: pop
    //   209: aload 7
    //   211: astore 8
    //   213: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   216: lstore 4
    //   218: lload 4
    //   220: lload_2
    //   221: lsub
    //   222: lstore 4
    //   224: aload 7
    //   226: astore 8
    //   228: lload 4
    //   230: lstore_2
    //   231: ldc_w 502
    //   234: invokestatic 508	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   237: checkcast 502	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   240: aconst_null
    //   241: ldc_w 294
    //   244: ldc_w 782
    //   247: ldc_w 782
    //   250: iconst_0
    //   251: iconst_0
    //   252: ldc 233
    //   254: new 81	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 294
    //   264: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: lload 4
    //   269: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   272: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: ldc_w 512
    //   278: ldc_w 328
    //   281: invokeinterface 516 11 0
    //   286: iconst_1
    //   287: istore 6
    //   289: aload 7
    //   291: ifnull -234 -> 57
    //   294: aload 7
    //   296: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   299: iconst_1
    //   300: ireturn
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   306: iconst_1
    //   307: ireturn
    //   308: aload 7
    //   310: astore 8
    //   312: invokestatic 301	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +16 -> 331
    //   318: aload 7
    //   320: astore 8
    //   322: ldc 26
    //   324: iconst_2
    //   325: ldc_w 784
    //   328: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload 7
    //   333: astore 8
    //   335: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   338: lstore 4
    //   340: lload 4
    //   342: lload_2
    //   343: lsub
    //   344: lstore 4
    //   346: aload 7
    //   348: astore 8
    //   350: lload 4
    //   352: lstore_2
    //   353: ldc_w 502
    //   356: invokestatic 508	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   359: checkcast 502	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   362: aconst_null
    //   363: ldc_w 294
    //   366: ldc_w 782
    //   369: ldc_w 782
    //   372: iconst_0
    //   373: iconst_0
    //   374: ldc_w 328
    //   377: new 81	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 294
    //   387: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: lload 4
    //   392: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   395: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: ldc_w 512
    //   401: ldc_w 328
    //   404: invokeinterface 516 11 0
    //   409: iconst_0
    //   410: istore 6
    //   412: aload 7
    //   414: ifnull -357 -> 57
    //   417: aload 7
    //   419: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   422: iconst_0
    //   423: ireturn
    //   424: astore_1
    //   425: aload_1
    //   426: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   429: iconst_0
    //   430: ireturn
    //   431: astore_1
    //   432: aconst_null
    //   433: astore 7
    //   435: aload 7
    //   437: astore 8
    //   439: invokestatic 450	java/lang/System:currentTimeMillis	()J
    //   442: lstore 4
    //   444: aload 7
    //   446: astore 8
    //   448: ldc_w 502
    //   451: invokestatic 508	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   454: checkcast 502	com/tencent/biz/pubaccount/api/IPublicAccountReportUtils
    //   457: aconst_null
    //   458: ldc_w 294
    //   461: ldc_w 782
    //   464: ldc_w 782
    //   467: iconst_0
    //   468: iconst_0
    //   469: ldc_w 328
    //   472: new 81	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 294
    //   482: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: lload 4
    //   487: lload_2
    //   488: lsub
    //   489: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   492: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: aload_1
    //   496: invokevirtual 445	java/io/IOException:getMessage	()Ljava/lang/String;
    //   499: ldc_w 328
    //   502: invokeinterface 516 11 0
    //   507: aload 7
    //   509: ifnull +8 -> 517
    //   512: aload 7
    //   514: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   517: iconst_0
    //   518: ireturn
    //   519: astore_1
    //   520: aload_1
    //   521: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   524: goto -7 -> 517
    //   527: astore_1
    //   528: aconst_null
    //   529: astore 7
    //   531: aload 7
    //   533: ifnull -16 -> 517
    //   536: aload 7
    //   538: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   541: goto -24 -> 517
    //   544: astore_1
    //   545: aload_1
    //   546: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   549: goto -32 -> 517
    //   552: astore_1
    //   553: aconst_null
    //   554: astore 7
    //   556: aload 7
    //   558: astore 8
    //   560: aload_1
    //   561: invokevirtual 785	java/lang/IllegalArgumentException:printStackTrace	()V
    //   564: aload 7
    //   566: ifnull -49 -> 517
    //   569: aload 7
    //   571: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   574: goto -57 -> 517
    //   577: astore_1
    //   578: aload_1
    //   579: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   582: goto -65 -> 517
    //   585: astore_1
    //   586: aconst_null
    //   587: astore 8
    //   589: aload 8
    //   591: ifnull +8 -> 599
    //   594: aload 8
    //   596: invokevirtual 521	java/io/FileOutputStream:close	()V
    //   599: aload_1
    //   600: athrow
    //   601: astore 7
    //   603: aload 7
    //   605: invokevirtual 456	java/io/IOException:printStackTrace	()V
    //   608: goto -9 -> 599
    //   611: astore_1
    //   612: goto -23 -> 589
    //   615: astore_1
    //   616: goto -60 -> 556
    //   619: astore_1
    //   620: goto -89 -> 531
    //   623: astore_1
    //   624: goto -189 -> 435
    //   627: astore_1
    //   628: goto -193 -> 435
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	PreloadManager
    //   0	631	1	paramString	String
    //   3	485	2	l1	long
    //   216	270	4	l2	long
    //   35	376	6	bool	boolean
    //   107	463	7	localFileOutputStream1	java.io.FileOutputStream
    //   601	3	7	localIOException	IOException
    //   111	484	8	localFileOutputStream2	java.io.FileOutputStream
    //   8	193	9	str	String
    //   118	66	10	arrayOfByte	byte[]
    //   96	97	11	localFile1	File
    //   20	179	12	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   49	57	60	java/io/IOException
    //   294	299	301	java/io/IOException
    //   417	422	424	java/io/IOException
    //   10	37	431	java/io/IOException
    //   67	109	431	java/io/IOException
    //   512	517	519	java/io/IOException
    //   10	37	527	java/lang/OutOfMemoryError
    //   67	109	527	java/lang/OutOfMemoryError
    //   536	541	544	java/io/IOException
    //   10	37	552	java/lang/IllegalArgumentException
    //   67	109	552	java/lang/IllegalArgumentException
    //   569	574	577	java/io/IOException
    //   10	37	585	finally
    //   67	109	585	finally
    //   594	599	601	java/io/IOException
    //   113	120	611	finally
    //   129	135	611	finally
    //   139	177	611	finally
    //   181	188	611	finally
    //   192	209	611	finally
    //   213	218	611	finally
    //   231	286	611	finally
    //   312	318	611	finally
    //   322	331	611	finally
    //   335	340	611	finally
    //   353	409	611	finally
    //   439	444	611	finally
    //   448	507	611	finally
    //   560	564	611	finally
    //   113	120	615	java/lang/IllegalArgumentException
    //   129	135	615	java/lang/IllegalArgumentException
    //   139	177	615	java/lang/IllegalArgumentException
    //   181	188	615	java/lang/IllegalArgumentException
    //   192	209	615	java/lang/IllegalArgumentException
    //   213	218	615	java/lang/IllegalArgumentException
    //   231	286	615	java/lang/IllegalArgumentException
    //   312	318	615	java/lang/IllegalArgumentException
    //   322	331	615	java/lang/IllegalArgumentException
    //   335	340	615	java/lang/IllegalArgumentException
    //   353	409	615	java/lang/IllegalArgumentException
    //   113	120	619	java/lang/OutOfMemoryError
    //   129	135	619	java/lang/OutOfMemoryError
    //   139	177	619	java/lang/OutOfMemoryError
    //   181	188	619	java/lang/OutOfMemoryError
    //   192	209	619	java/lang/OutOfMemoryError
    //   213	218	619	java/lang/OutOfMemoryError
    //   231	286	619	java/lang/OutOfMemoryError
    //   312	318	619	java/lang/OutOfMemoryError
    //   322	331	619	java/lang/OutOfMemoryError
    //   335	340	619	java/lang/OutOfMemoryError
    //   353	409	619	java/lang/OutOfMemoryError
    //   113	120	623	java/io/IOException
    //   129	135	623	java/io/IOException
    //   139	177	623	java/io/IOException
    //   181	188	623	java/io/IOException
    //   192	209	623	java/io/IOException
    //   213	218	623	java/io/IOException
    //   312	318	623	java/io/IOException
    //   322	331	623	java/io/IOException
    //   335	340	623	java/io/IOException
    //   231	286	627	java/io/IOException
    //   353	409	627	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager
 * JD-Core Version:    0.7.0.1
 */