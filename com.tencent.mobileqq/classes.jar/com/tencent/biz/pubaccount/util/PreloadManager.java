package com.tencent.biz.pubaccount.util;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
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
import mus;
import mut;
import muu;
import muv;
import org.json.JSONArray;
import org.json.JSONException;

public class PreloadManager
{
  private static PreloadManager jdField_a_of_type_ComTencentBizPubaccountUtilPreloadManager;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(30);
  public Object a;
  public final String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  public volatile boolean a;
  public Object b;
  private List b;
  public volatile boolean b;
  public Object c;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  private PreloadManager()
  {
    this.jdField_a_of_type_JavaLangString = "ReadInJoyArticleDetailPreloadManager";
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_JavaLangObject = new Object();
  }
  
  public static int a(String paramString)
  {
    Object localObject = MD5Utils.d(paramString);
    paramString = (String)localObject + ".temp";
    localObject = new File(AppConstants.co, (String)localObject);
    paramString = new File(AppConstants.co, paramString);
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
  
  private ArrayList a(String paramString, boolean paramBoolean)
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
    if (PublicAccountConfigUtil.m) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_enableIpConnect", str);
      localHashMap.put("param_connType", String.valueOf(paramInt));
      localHashMap.put("param_host", paramString1);
      localHashMap.put("param_ipAddr", paramString2);
      localHashMap.put("param_ipConnResult", paramString3);
      localHashMap.put("param_hostConnResult", paramString4);
      paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
      StatisticCollector.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyIpConnect", paramBoolean, paramLong, 0L, localHashMap, "");
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
    //   6: new 363	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_0
    //   11: ldc_w 365
    //   14: invokespecial 368	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   17: astore_2
    //   18: ldc_w 365
    //   21: invokestatic 386	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   24: astore_0
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_2
    //   28: invokevirtual 390	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 394	javax/crypto/Cipher:doFinal	([B)[B
    //   36: astore_0
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 369	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   44: aconst_null
    //   45: astore_0
    //   46: goto -21 -> 25
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 395	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   54: aconst_null
    //   55: astore_0
    //   56: goto -31 -> 25
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 396	java/security/InvalidKeyException:printStackTrace	()V
    //   64: goto -33 -> 31
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 397	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 398	javax/crypto/BadPaddingException:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 399	java/lang/OutOfMemoryError:printStackTrace	()V
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
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithCondition:" + PublicAccountConfigUtil.m);
    }
    if (PublicAccountConfigUtil.m) {
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
              paramString = HttpUtil.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
    return HttpUtil.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 7
    //   6: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   9: lstore_2
    //   10: aload 9
    //   12: astore 8
    //   14: aload_1
    //   15: invokestatic 446	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 10
    //   20: aload 10
    //   22: ifnonnull +22 -> 44
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 448	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: return
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   43: return
    //   44: aload 9
    //   46: astore 8
    //   48: invokestatic 276	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   51: invokevirtual 280	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   54: checkcast 452	com/tencent/mobileqq/app/QQAppInterface
    //   57: invokevirtual 454	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   60: astore 12
    //   62: aload 9
    //   64: astore 8
    //   66: new 80	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   73: getstatic 457	com/tencent/mobileqq/app/AppConstants:cn	Ljava/lang/String;
    //   76: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 10
    //   81: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 11
    //   89: aload 9
    //   91: astore 8
    //   93: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +45 -> 141
    //   99: aload 9
    //   101: astore 8
    //   103: ldc_w 459
    //   106: iconst_2
    //   107: new 80	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 461
    //   117: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 11
    //   122: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 463
    //   128: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_1
    //   132: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 466	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 9
    //   143: astore 8
    //   145: aload 11
    //   147: invokestatic 470	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   150: ifeq +55 -> 205
    //   153: aload 9
    //   155: astore 8
    //   157: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +16 -> 176
    //   163: aload 9
    //   165: astore 8
    //   167: ldc 26
    //   169: iconst_2
    //   170: ldc_w 472
    //   173: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 9
    //   178: astore 8
    //   180: aload_0
    //   181: aload_1
    //   182: aload 12
    //   184: invokevirtual 474	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iconst_0
    //   188: ifeq -151 -> 37
    //   191: new 448	java/lang/NullPointerException
    //   194: dup
    //   195: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   204: return
    //   205: aload 9
    //   207: astore 8
    //   209: aload_0
    //   210: aload_1
    //   211: invokespecial 476	com/tencent/biz/pubaccount/util/PreloadManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 13
    //   216: aload 13
    //   218: ifnonnull +21 -> 239
    //   221: iconst_0
    //   222: ifeq -185 -> 37
    //   225: new 448	java/lang/NullPointerException
    //   228: dup
    //   229: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   232: athrow
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   238: return
    //   239: aload 9
    //   241: astore 8
    //   243: aload_0
    //   244: aload_0
    //   245: aload 13
    //   247: aload_1
    //   248: ldc 140
    //   250: invokevirtual 138	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   253: invokespecial 146	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;Z)Ljava/util/ArrayList;
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
    //   284: invokevirtual 233	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: ldc 26
    //   290: iconst_2
    //   291: new 80	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 478
    //   301: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 10
    //   306: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_1
    //   316: monitorexit
    //   317: aload 9
    //   319: astore 8
    //   321: aload_0
    //   322: getfield 480	com/tencent/biz/pubaccount/util/PreloadManager:jdField_b_of_type_Boolean	Z
    //   325: ifne +33 -> 358
    //   328: aload 9
    //   330: astore 8
    //   332: invokestatic 485	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   335: iconst_1
    //   336: if_icmpne +22 -> 358
    //   339: aload 9
    //   341: astore 8
    //   343: aload_0
    //   344: invokevirtual 487	com/tencent/biz/pubaccount/util/PreloadManager:b	()Z
    //   347: ifeq +11 -> 358
    //   350: aload 9
    //   352: astore 8
    //   354: aload_0
    //   355: invokevirtual 489	com/tencent/biz/pubaccount/util/PreloadManager:d	()V
    //   358: aload 9
    //   360: astore 8
    //   362: aload_0
    //   363: getfield 53	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   366: aload 10
    //   368: aload 13
    //   370: invokevirtual 492	java/lang/String:getBytes	()[B
    //   373: invokevirtual 493	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: pop
    //   377: aload 9
    //   379: astore 8
    //   381: aload 13
    //   383: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   386: ifeq +223 -> 609
    //   389: aload 9
    //   391: astore 8
    //   393: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   396: lstore 4
    //   398: lload 4
    //   400: lload_2
    //   401: lsub
    //   402: lstore_2
    //   403: aload 9
    //   405: astore 8
    //   407: aconst_null
    //   408: ldc_w 289
    //   411: ldc_w 495
    //   414: ldc_w 495
    //   417: iconst_0
    //   418: iconst_0
    //   419: ldc_w 322
    //   422: new 80	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 289
    //   432: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: lload_2
    //   436: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   439: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: ldc_w 497
    //   445: ldc_w 289
    //   448: invokestatic 502	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   451: iconst_0
    //   452: ifeq -415 -> 37
    //   455: new 448	java/lang/NullPointerException
    //   458: dup
    //   459: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   462: athrow
    //   463: astore_1
    //   464: aload_1
    //   465: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   468: return
    //   469: astore 10
    //   471: aload_1
    //   472: monitorexit
    //   473: aload 9
    //   475: astore 8
    //   477: aload 10
    //   479: athrow
    //   480: astore_1
    //   481: aload 7
    //   483: astore 8
    //   485: aload_1
    //   486: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   489: aload 7
    //   491: astore 8
    //   493: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   496: lstore 4
    //   498: aload 7
    //   500: astore 8
    //   502: aconst_null
    //   503: ldc_w 289
    //   506: ldc_w 495
    //   509: ldc_w 495
    //   512: iconst_0
    //   513: iconst_0
    //   514: ldc_w 322
    //   517: new 80	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 289
    //   527: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: lload 4
    //   532: lload_2
    //   533: lsub
    //   534: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   537: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: aload_1
    //   541: invokevirtual 439	java/io/IOException:getMessage	()Ljava/lang/String;
    //   544: ldc_w 289
    //   547: invokestatic 502	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   550: aload 7
    //   552: ifnull -515 -> 37
    //   555: aload 7
    //   557: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   560: return
    //   561: astore_1
    //   562: aload_1
    //   563: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   566: return
    //   567: astore_1
    //   568: aload 9
    //   570: astore 8
    //   572: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +16 -> 591
    //   578: aload 9
    //   580: astore 8
    //   582: ldc 26
    //   584: iconst_2
    //   585: ldc_w 509
    //   588: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: iconst_0
    //   592: ifeq -555 -> 37
    //   595: new 448	java/lang/NullPointerException
    //   598: dup
    //   599: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   602: athrow
    //   603: astore_1
    //   604: aload_1
    //   605: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   608: return
    //   609: aload 9
    //   611: astore 8
    //   613: new 80	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   620: aload 13
    //   622: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc_w 511
    //   628: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 10
    //   633: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokevirtual 492	java/lang/String:getBytes	()[B
    //   642: astore_1
    //   643: aload 9
    //   645: astore 8
    //   647: aload 12
    //   649: invokestatic 513	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)[B
    //   652: astore 12
    //   654: aload 12
    //   656: ifnonnull +63 -> 719
    //   659: iconst_0
    //   660: ifeq -623 -> 37
    //   663: new 448	java/lang/NullPointerException
    //   666: dup
    //   667: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   670: athrow
    //   671: astore_1
    //   672: aload_1
    //   673: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   676: return
    //   677: astore_1
    //   678: aload 9
    //   680: astore 8
    //   682: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq +16 -> 701
    //   688: aload 9
    //   690: astore 8
    //   692: ldc 26
    //   694: iconst_2
    //   695: ldc_w 509
    //   698: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: iconst_0
    //   702: ifeq -665 -> 37
    //   705: new 448	java/lang/NullPointerException
    //   708: dup
    //   709: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   712: athrow
    //   713: astore_1
    //   714: aload_1
    //   715: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   718: return
    //   719: aload_1
    //   720: ifnonnull +21 -> 741
    //   723: iconst_0
    //   724: ifeq -687 -> 37
    //   727: new 448	java/lang/NullPointerException
    //   730: dup
    //   731: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   734: athrow
    //   735: astore_1
    //   736: aload_1
    //   737: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   740: return
    //   741: aload 9
    //   743: astore 8
    //   745: aload 12
    //   747: aload_1
    //   748: invokestatic 515	com/tencent/biz/pubaccount/util/PreloadManager:b	([B[B)[B
    //   751: astore 12
    //   753: aload 9
    //   755: astore 8
    //   757: new 93	java/io/File
    //   760: dup
    //   761: getstatic 457	com/tencent/mobileqq/app/AppConstants:cn	Ljava/lang/String;
    //   764: invokespecial 516	java/io/File:<init>	(Ljava/lang/String;)V
    //   767: astore_1
    //   768: aload 9
    //   770: astore 8
    //   772: aload_1
    //   773: invokevirtual 105	java/io/File:exists	()Z
    //   776: ifne +36 -> 812
    //   779: aload 9
    //   781: astore 8
    //   783: aload_1
    //   784: invokevirtual 519	java/io/File:mkdirs	()Z
    //   787: istore 6
    //   789: iload 6
    //   791: ifne +21 -> 812
    //   794: iconst_0
    //   795: ifeq -758 -> 37
    //   798: new 448	java/lang/NullPointerException
    //   801: dup
    //   802: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   805: athrow
    //   806: astore_1
    //   807: aload_1
    //   808: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   811: return
    //   812: aload 9
    //   814: astore 8
    //   816: new 504	java/io/FileOutputStream
    //   819: dup
    //   820: new 93	java/io/File
    //   823: dup
    //   824: aload_1
    //   825: new 80	java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   832: aload 10
    //   834: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: ldc_w 521
    //   840: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokespecial 524	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   849: invokespecial 527	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   852: astore_1
    //   853: aload 12
    //   855: ifnonnull +99 -> 954
    //   858: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   861: ifeq +12 -> 873
    //   864: ldc 26
    //   866: iconst_2
    //   867: ldc_w 529
    //   870: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   876: lstore 4
    //   878: lload 4
    //   880: lload_2
    //   881: lsub
    //   882: lstore 4
    //   884: lload 4
    //   886: lstore_2
    //   887: aconst_null
    //   888: ldc_w 289
    //   891: ldc_w 495
    //   894: ldc_w 495
    //   897: iconst_0
    //   898: iconst_0
    //   899: ldc_w 322
    //   902: new 80	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   909: ldc_w 289
    //   912: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: lload 4
    //   917: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   920: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: ldc_w 497
    //   926: ldc_w 289
    //   929: invokestatic 502	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   932: lload 4
    //   934: lstore_2
    //   935: aload_1
    //   936: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   939: aload_1
    //   940: ifnull -903 -> 37
    //   943: aload_1
    //   944: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   947: return
    //   948: astore_1
    //   949: aload_1
    //   950: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   953: return
    //   954: aload_1
    //   955: aload 12
    //   957: invokevirtual 532	java/io/FileOutputStream:write	([B)V
    //   960: aload_1
    //   961: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   964: new 93	java/io/File
    //   967: dup
    //   968: new 80	java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   975: getstatic 457	com/tencent/mobileqq/app/AppConstants:cn	Ljava/lang/String;
    //   978: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: aload 10
    //   983: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: ldc_w 521
    //   989: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: invokespecial 516	java/io/File:<init>	(Ljava/lang/String;)V
    //   998: new 93	java/io/File
    //   1001: dup
    //   1002: aload 11
    //   1004: invokespecial 516	java/io/File:<init>	(Ljava/lang/String;)V
    //   1007: invokevirtual 536	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1010: pop
    //   1011: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   1014: lstore 4
    //   1016: lload 4
    //   1018: lload_2
    //   1019: lsub
    //   1020: lstore 4
    //   1022: lload 4
    //   1024: lstore_2
    //   1025: aconst_null
    //   1026: ldc_w 289
    //   1029: ldc_w 495
    //   1032: ldc_w 495
    //   1035: iconst_0
    //   1036: iconst_0
    //   1037: ldc 229
    //   1039: new 80	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 289
    //   1049: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: lload 4
    //   1054: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: ldc_w 497
    //   1063: ldc_w 289
    //   1066: invokestatic 502	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1069: aload_1
    //   1070: ifnull -1033 -> 37
    //   1073: aload_1
    //   1074: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   1077: return
    //   1078: astore_1
    //   1079: aload_1
    //   1080: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   1083: return
    //   1084: astore_1
    //   1085: aload 8
    //   1087: astore 7
    //   1089: aload 7
    //   1091: ifnull +8 -> 1099
    //   1094: aload 7
    //   1096: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   1099: aload_1
    //   1100: athrow
    //   1101: astore 7
    //   1103: aload 7
    //   1105: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   1108: goto -9 -> 1099
    //   1111: astore 8
    //   1113: aload_1
    //   1114: astore 7
    //   1116: aload 8
    //   1118: astore_1
    //   1119: goto -30 -> 1089
    //   1122: astore_1
    //   1123: goto -642 -> 481
    //   1126: astore 8
    //   1128: aload_1
    //   1129: astore 7
    //   1131: aload 8
    //   1133: astore_1
    //   1134: goto -653 -> 481
    //   1137: astore 8
    //   1139: aload_1
    //   1140: astore 7
    //   1142: aload 8
    //   1144: astore_1
    //   1145: goto -664 -> 481
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1148	0	this	PreloadManager
    //   0	1148	1	paramString	String
    //   9	1016	2	l1	long
    //   396	657	4	l2	long
    //   787	3	6	bool	boolean
    //   4	1091	7	localObject1	Object
    //   1101	3	7	localIOException1	IOException
    //   1114	27	7	str1	String
    //   12	1074	8	localObject2	Object
    //   1111	6	8	localObject3	Object
    //   1126	6	8	localIOException2	IOException
    //   1137	6	8	localIOException3	IOException
    //   1	812	9	localObject4	Object
    //   18	349	10	str2	String
    //   469	513	10	str3	String
    //   87	916	11	str4	String
    //   60	896	12	localObject5	Object
    //   214	407	13	str5	String
    // Exception table:
    //   from	to	target	type
    //   29	37	38	java/io/IOException
    //   191	199	199	java/io/IOException
    //   225	233	233	java/io/IOException
    //   455	463	463	java/io/IOException
    //   274	317	469	finally
    //   471	473	469	finally
    //   14	20	480	java/io/IOException
    //   48	62	480	java/io/IOException
    //   66	89	480	java/io/IOException
    //   93	99	480	java/io/IOException
    //   103	141	480	java/io/IOException
    //   145	153	480	java/io/IOException
    //   157	163	480	java/io/IOException
    //   167	176	480	java/io/IOException
    //   180	187	480	java/io/IOException
    //   209	216	480	java/io/IOException
    //   243	259	480	java/io/IOException
    //   263	268	480	java/io/IOException
    //   272	274	480	java/io/IOException
    //   321	328	480	java/io/IOException
    //   332	339	480	java/io/IOException
    //   343	350	480	java/io/IOException
    //   354	358	480	java/io/IOException
    //   362	377	480	java/io/IOException
    //   381	389	480	java/io/IOException
    //   393	398	480	java/io/IOException
    //   477	480	480	java/io/IOException
    //   572	578	480	java/io/IOException
    //   582	591	480	java/io/IOException
    //   613	643	480	java/io/IOException
    //   647	654	480	java/io/IOException
    //   682	688	480	java/io/IOException
    //   692	701	480	java/io/IOException
    //   745	753	480	java/io/IOException
    //   757	768	480	java/io/IOException
    //   772	779	480	java/io/IOException
    //   783	789	480	java/io/IOException
    //   816	853	480	java/io/IOException
    //   555	560	561	java/io/IOException
    //   362	377	567	java/lang/OutOfMemoryError
    //   595	603	603	java/io/IOException
    //   663	671	671	java/io/IOException
    //   613	643	677	java/lang/OutOfMemoryError
    //   705	713	713	java/io/IOException
    //   727	735	735	java/io/IOException
    //   798	806	806	java/io/IOException
    //   943	947	948	java/io/IOException
    //   1073	1077	1078	java/io/IOException
    //   14	20	1084	finally
    //   48	62	1084	finally
    //   66	89	1084	finally
    //   93	99	1084	finally
    //   103	141	1084	finally
    //   145	153	1084	finally
    //   157	163	1084	finally
    //   167	176	1084	finally
    //   180	187	1084	finally
    //   209	216	1084	finally
    //   243	259	1084	finally
    //   263	268	1084	finally
    //   272	274	1084	finally
    //   321	328	1084	finally
    //   332	339	1084	finally
    //   343	350	1084	finally
    //   354	358	1084	finally
    //   362	377	1084	finally
    //   381	389	1084	finally
    //   393	398	1084	finally
    //   407	451	1084	finally
    //   477	480	1084	finally
    //   485	489	1084	finally
    //   493	498	1084	finally
    //   502	550	1084	finally
    //   572	578	1084	finally
    //   582	591	1084	finally
    //   613	643	1084	finally
    //   647	654	1084	finally
    //   682	688	1084	finally
    //   692	701	1084	finally
    //   745	753	1084	finally
    //   757	768	1084	finally
    //   772	779	1084	finally
    //   783	789	1084	finally
    //   816	853	1084	finally
    //   1094	1099	1101	java/io/IOException
    //   858	873	1111	finally
    //   873	878	1111	finally
    //   887	932	1111	finally
    //   935	939	1111	finally
    //   954	1016	1111	finally
    //   1025	1069	1111	finally
    //   407	451	1122	java/io/IOException
    //   858	873	1126	java/io/IOException
    //   873	878	1126	java/io/IOException
    //   954	1016	1126	java/io/IOException
    //   887	932	1137	java/io/IOException
    //   935	939	1137	java/io/IOException
    //   1025	1069	1137	java/io/IOException
  }
  
  /* Error */
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: new 363	javax/crypto/spec/SecretKeySpec
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 365
    //   8: invokespecial 368	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   11: astore_0
    //   12: ldc_w 365
    //   15: invokestatic 386	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_1
    //   21: aload_0
    //   22: invokevirtual 390	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 394	javax/crypto/Cipher:doFinal	([B)[B
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 397	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 396	java/security/InvalidKeyException:printStackTrace	()V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 369	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 398	javax/crypto/BadPaddingException:printStackTrace	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 395	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 399	java/lang/OutOfMemoryError:printStackTrace	()V
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
      String str1 = InnerDns.a().a(str3, 1008);
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
              String str4 = HttpUtil.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
      str5 = HttpUtil.a(BaseApplication.getContext(), str5, "GET", null, (Bundle)localObject, str3);
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
        localObject = HttpUtil.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
        InnerDns.a().a(str3, localMalformedURLException, 1008);
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
    switch (PublicAccountConfigUtil.jdField_a_of_type_Int)
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
        if (!TextUtils.isEmpty(PublicAccountConfigUtil.k))
        {
          bool1 = bool2;
          if (str.endsWith(PublicAccountConfigUtil.k)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private byte[] c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithCondition:" + PublicAccountConfigUtil.m);
    }
    if (PublicAccountConfigUtil.m) {
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
              paramString = HttpUtil.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
    return HttpUtil.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
      String str1 = InnerDns.a().a(str3, 1009);
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
              byte[] arrayOfByte = HttpUtil.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
      localObject1 = HttpUtil.a(BaseApplication.getContext(), (String)localObject1, "GET", null, (Bundle)localObject2, str3);
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
        localObject2 = HttpUtil.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
        InnerDns.a().a(str3, localMalformedURLException, 1009);
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
  
  public ArrayList a(String paramString)
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
  
  public List a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
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
    ThreadManager.executeOnFileThread(new muv(this, paramString1, paramString2));
  }
  
  public boolean a()
  {
    boolean bool = false;
    int i;
    if (NetworkState.isNetSupport())
    {
      i = NetworkState.getNetworkType();
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0);
      this.jdField_c_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload", false);
      this.d = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_wifi", false);
      this.e = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_4G", false);
      this.f = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_3G", false);
      this.g = ((SharedPreferences)localObject).getBoolean("kandian_feeds_preload_2G", false);
      if (!this.jdField_c_of_type_Boolean) {
        break label214;
      }
      if ((i == 1) && (this.d)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      if ((i == 2) && (this.f))
      {
        bool = true;
      }
      else if ((i == 3) && (this.g))
      {
        bool = true;
      }
      else if ((i == 4) && (this.e))
      {
        bool = true;
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "canloadFile no network");
          return false;
        }
      }
      else
      {
        label214:
        bool = false;
      }
    }
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
    ThreadManager.post(new mus(this), 5, null, false);
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
    //   0: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_1
    //   5: invokestatic 78	com/tencent/open/base/MD5Utils:d	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 11
    //   10: new 93	java/io/File
    //   13: dup
    //   14: getstatic 98	com/tencent/mobileqq/app/AppConstants:co	Ljava/lang/String;
    //   17: invokespecial 516	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 12
    //   22: aload 12
    //   24: invokevirtual 105	java/io/File:exists	()Z
    //   27: ifne +41 -> 68
    //   30: aload 12
    //   32: invokevirtual 519	java/io/File:mkdirs	()Z
    //   35: istore 6
    //   37: iload 6
    //   39: ifne +29 -> 68
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 448	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 449	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: iconst_0
    //   55: istore 6
    //   57: iload 6
    //   59: ireturn
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   65: goto -11 -> 54
    //   68: new 93	java/io/File
    //   71: dup
    //   72: aload 12
    //   74: new 80	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   81: aload 11
    //   83: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 87
    //   88: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 524	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   97: astore 10
    //   99: new 504	java/io/FileOutputStream
    //   102: dup
    //   103: aload 10
    //   105: invokespecial 527	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   108: astore 7
    //   110: aload 7
    //   112: astore 8
    //   114: aload_0
    //   115: aload_1
    //   116: invokespecial 778	com/tencent/biz/pubaccount/util/PreloadManager:c	(Ljava/lang/String;)[B
    //   119: astore 9
    //   121: aload 9
    //   123: ifnull +175 -> 298
    //   126: aload 7
    //   128: astore 8
    //   130: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +45 -> 178
    //   136: aload 7
    //   138: astore 8
    //   140: ldc 26
    //   142: iconst_2
    //   143: new 80	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 780
    //   153: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 782
    //   163: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   169: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   172: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload 7
    //   180: astore 8
    //   182: aload 7
    //   184: aload 9
    //   186: invokevirtual 532	java/io/FileOutputStream:write	([B)V
    //   189: aload 7
    //   191: astore 8
    //   193: aload 10
    //   195: new 93	java/io/File
    //   198: dup
    //   199: aload 12
    //   201: aload 11
    //   203: invokespecial 524	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   206: invokevirtual 536	java/io/File:renameTo	(Ljava/io/File;)Z
    //   209: pop
    //   210: aload 7
    //   212: astore 8
    //   214: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   217: lstore 4
    //   219: lload 4
    //   221: lload_2
    //   222: lsub
    //   223: lstore 4
    //   225: aload 7
    //   227: astore 8
    //   229: lload 4
    //   231: lstore_2
    //   232: aconst_null
    //   233: ldc_w 289
    //   236: ldc_w 784
    //   239: ldc_w 784
    //   242: iconst_0
    //   243: iconst_0
    //   244: ldc 229
    //   246: new 80	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 289
    //   256: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: lload 4
    //   261: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: ldc_w 497
    //   270: ldc_w 322
    //   273: invokestatic 502	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   276: iconst_1
    //   277: istore 6
    //   279: aload 7
    //   281: ifnull -224 -> 57
    //   284: aload 7
    //   286: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   289: iconst_1
    //   290: ireturn
    //   291: astore_1
    //   292: aload_1
    //   293: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   296: iconst_1
    //   297: ireturn
    //   298: aload 7
    //   300: astore 8
    //   302: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +16 -> 321
    //   308: aload 7
    //   310: astore 8
    //   312: ldc 26
    //   314: iconst_2
    //   315: ldc_w 786
    //   318: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload 7
    //   323: astore 8
    //   325: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   328: lstore 4
    //   330: lload 4
    //   332: lload_2
    //   333: lsub
    //   334: lstore 4
    //   336: aload 7
    //   338: astore 8
    //   340: lload 4
    //   342: lstore_2
    //   343: aconst_null
    //   344: ldc_w 289
    //   347: ldc_w 784
    //   350: ldc_w 784
    //   353: iconst_0
    //   354: iconst_0
    //   355: ldc_w 322
    //   358: new 80	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 289
    //   368: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: lload 4
    //   373: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   376: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: ldc_w 497
    //   382: ldc_w 322
    //   385: invokestatic 502	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload 7
    //   390: ifnull +8 -> 398
    //   393: aload 7
    //   395: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   398: iconst_0
    //   399: ireturn
    //   400: astore_1
    //   401: aload_1
    //   402: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   405: goto -7 -> 398
    //   408: astore_1
    //   409: aconst_null
    //   410: astore 7
    //   412: aload 7
    //   414: astore 8
    //   416: invokestatic 444	java/lang/System:currentTimeMillis	()J
    //   419: lstore 4
    //   421: aload 7
    //   423: astore 8
    //   425: aconst_null
    //   426: ldc_w 289
    //   429: ldc_w 784
    //   432: ldc_w 784
    //   435: iconst_0
    //   436: iconst_0
    //   437: ldc_w 322
    //   440: new 80	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 289
    //   450: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: lload 4
    //   455: lload_2
    //   456: lsub
    //   457: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   460: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: aload_1
    //   464: invokevirtual 439	java/io/IOException:getMessage	()Ljava/lang/String;
    //   467: ldc_w 322
    //   470: invokestatic 502	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   473: aload 7
    //   475: ifnull +8 -> 483
    //   478: aload 7
    //   480: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   483: iconst_0
    //   484: ireturn
    //   485: astore_1
    //   486: aload_1
    //   487: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   490: goto -7 -> 483
    //   493: astore_1
    //   494: aconst_null
    //   495: astore 7
    //   497: aload 7
    //   499: ifnull -16 -> 483
    //   502: aload 7
    //   504: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   507: goto -24 -> 483
    //   510: astore_1
    //   511: aload_1
    //   512: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   515: goto -32 -> 483
    //   518: astore_1
    //   519: aconst_null
    //   520: astore 7
    //   522: aload 7
    //   524: astore 8
    //   526: aload_1
    //   527: invokevirtual 787	java/lang/IllegalArgumentException:printStackTrace	()V
    //   530: aload 7
    //   532: ifnull -49 -> 483
    //   535: aload 7
    //   537: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   540: goto -57 -> 483
    //   543: astore_1
    //   544: aload_1
    //   545: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   548: goto -65 -> 483
    //   551: astore_1
    //   552: aconst_null
    //   553: astore 8
    //   555: aload 8
    //   557: ifnull +8 -> 565
    //   560: aload 8
    //   562: invokevirtual 507	java/io/FileOutputStream:close	()V
    //   565: aload_1
    //   566: athrow
    //   567: astore 7
    //   569: aload 7
    //   571: invokevirtual 450	java/io/IOException:printStackTrace	()V
    //   574: goto -9 -> 565
    //   577: astore_1
    //   578: goto -23 -> 555
    //   581: astore_1
    //   582: goto -60 -> 522
    //   585: astore_1
    //   586: goto -89 -> 497
    //   589: astore_1
    //   590: goto -178 -> 412
    //   593: astore_1
    //   594: goto -182 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	PreloadManager
    //   0	597	1	paramString	String
    //   3	453	2	l1	long
    //   217	237	4	l2	long
    //   35	243	6	bool	boolean
    //   108	428	7	localFileOutputStream1	java.io.FileOutputStream
    //   567	3	7	localIOException	IOException
    //   112	449	8	localFileOutputStream2	java.io.FileOutputStream
    //   119	66	9	arrayOfByte	byte[]
    //   97	97	10	localFile1	File
    //   8	194	11	str	String
    //   20	180	12	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   46	54	60	java/io/IOException
    //   284	289	291	java/io/IOException
    //   393	398	400	java/io/IOException
    //   10	37	408	java/io/IOException
    //   68	110	408	java/io/IOException
    //   478	483	485	java/io/IOException
    //   10	37	493	java/lang/OutOfMemoryError
    //   68	110	493	java/lang/OutOfMemoryError
    //   502	507	510	java/io/IOException
    //   10	37	518	java/lang/IllegalArgumentException
    //   68	110	518	java/lang/IllegalArgumentException
    //   535	540	543	java/io/IOException
    //   10	37	551	finally
    //   68	110	551	finally
    //   560	565	567	java/io/IOException
    //   114	121	577	finally
    //   130	136	577	finally
    //   140	178	577	finally
    //   182	189	577	finally
    //   193	210	577	finally
    //   214	219	577	finally
    //   232	276	577	finally
    //   302	308	577	finally
    //   312	321	577	finally
    //   325	330	577	finally
    //   343	388	577	finally
    //   416	421	577	finally
    //   425	473	577	finally
    //   526	530	577	finally
    //   114	121	581	java/lang/IllegalArgumentException
    //   130	136	581	java/lang/IllegalArgumentException
    //   140	178	581	java/lang/IllegalArgumentException
    //   182	189	581	java/lang/IllegalArgumentException
    //   193	210	581	java/lang/IllegalArgumentException
    //   214	219	581	java/lang/IllegalArgumentException
    //   232	276	581	java/lang/IllegalArgumentException
    //   302	308	581	java/lang/IllegalArgumentException
    //   312	321	581	java/lang/IllegalArgumentException
    //   325	330	581	java/lang/IllegalArgumentException
    //   343	388	581	java/lang/IllegalArgumentException
    //   114	121	585	java/lang/OutOfMemoryError
    //   130	136	585	java/lang/OutOfMemoryError
    //   140	178	585	java/lang/OutOfMemoryError
    //   182	189	585	java/lang/OutOfMemoryError
    //   193	210	585	java/lang/OutOfMemoryError
    //   214	219	585	java/lang/OutOfMemoryError
    //   232	276	585	java/lang/OutOfMemoryError
    //   302	308	585	java/lang/OutOfMemoryError
    //   312	321	585	java/lang/OutOfMemoryError
    //   325	330	585	java/lang/OutOfMemoryError
    //   343	388	585	java/lang/OutOfMemoryError
    //   114	121	589	java/io/IOException
    //   130	136	589	java/io/IOException
    //   140	178	589	java/io/IOException
    //   182	189	589	java/io/IOException
    //   193	210	589	java/io/IOException
    //   214	219	589	java/io/IOException
    //   302	308	589	java/io/IOException
    //   312	321	589	java/io/IOException
    //   325	330	589	java/io/IOException
    //   232	276	593	java/io/IOException
    //   343	388	593	java/io/IOException
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
    ThreadManager.executeOnNetWorkThread(new muu(this));
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
    ThreadManager.executeOnNetWorkThread(new mut(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager
 * JD-Core Version:    0.7.0.1
 */