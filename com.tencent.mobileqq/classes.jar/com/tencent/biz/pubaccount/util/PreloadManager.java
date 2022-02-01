package com.tencent.biz.pubaccount.util;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import antf;
import bdmc;
import bjtz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.dns.InnerDns;
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
import nnr;
import org.json.JSONArray;
import org.json.JSONException;
import txy;
import txz;
import tyi;

public class PreloadManager
{
  private static PreloadManager jdField_a_of_type_ComTencentBizPubaccountUtilPreloadManager;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MQLruCache<String, byte[]> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(30);
  public Object a;
  public final String a;
  ArrayList<txy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile HashMap<String, ArrayList<txy>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
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
    Object localObject = bjtz.d(paramString);
    paramString = (String)localObject + ".temp";
    localObject = new File(antf.cL, (String)localObject);
    paramString = new File(antf.cL, paramString);
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
  
  private ArrayList<txy> a(String paramString, boolean paramBoolean)
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
          txy localtxy;
          if ((j == 0) || (j < i) || (j > i))
          {
            i = 0;
            while (i < ((List)localObject).size())
            {
              localtxy = new txy();
              localtxy.jdField_a_of_type_JavaLangString = ((String)((List)localObject).get(i));
              localtxy.jdField_a_of_type_Int = 0;
              localArrayList.add(localtxy);
              i += 1;
            }
            break;
          }
          i = 0;
          while (i < ((List)localObject).size())
          {
            localtxy = new txy();
            localtxy.jdField_a_of_type_JavaLangString = ((String)((List)localObject).get(i));
            try
            {
              localtxy.jdField_a_of_type_Int = Integer.parseInt((String)localList.get(i));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                localtxy.jdField_a_of_type_Int = 0;
                localNumberFormatException.printStackTrace();
                localArrayList.add(localtxy);
              }
            }
            finally
            {
              localArrayList.add(localtxy);
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
    if (tyi.m) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_enableIpConnect", str);
      localHashMap.put("param_connType", String.valueOf(paramInt));
      localHashMap.put("param_host", paramString1);
      localHashMap.put("param_ipAddr", paramString2);
      localHashMap.put("param_ipConnResult", paramString3);
      localHashMap.put("param_hostConnResult", paramString4);
      paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
      bdmc.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyIpConnect", paramBoolean, paramLong, 0L, localHashMap, "");
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
    //   6: new 366	javax/crypto/spec/SecretKeySpec
    //   9: dup
    //   10: aload_0
    //   11: ldc_w 368
    //   14: invokespecial 371	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   17: astore_2
    //   18: ldc_w 368
    //   21: invokestatic 389	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   24: astore_0
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_2
    //   28: invokevirtual 393	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 397	javax/crypto/Cipher:doFinal	([B)[B
    //   36: astore_0
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 372	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   44: aconst_null
    //   45: astore_0
    //   46: goto -21 -> 25
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 398	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   54: aconst_null
    //   55: astore_0
    //   56: goto -31 -> 25
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 399	java/security/InvalidKeyException:printStackTrace	()V
    //   64: goto -33 -> 31
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 400	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 401	javax/crypto/BadPaddingException:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 402	java/lang/OutOfMemoryError:printStackTrace	()V
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
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadHtmlWithCondition:" + tyi.m);
    }
    if (tyi.m) {
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
              paramString = nnr.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
    return nnr.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 7
    //   6: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   9: lstore_2
    //   10: aload 9
    //   12: astore 8
    //   14: aload_1
    //   15: invokestatic 449	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 10
    //   20: aload 10
    //   22: ifnonnull +22 -> 44
    //   25: iconst_0
    //   26: ifeq +11 -> 37
    //   29: new 451	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: return
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   43: return
    //   44: aload 9
    //   46: astore 8
    //   48: invokestatic 279	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   51: invokevirtual 283	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   54: checkcast 455	com/tencent/mobileqq/app/QQAppInterface
    //   57: invokevirtual 457	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   60: astore 12
    //   62: aload 9
    //   64: astore 8
    //   66: new 81	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   73: getstatic 460	antf:cK	Ljava/lang/String;
    //   76: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 10
    //   81: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 11
    //   89: aload 9
    //   91: astore 8
    //   93: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +45 -> 141
    //   99: aload 9
    //   101: astore 8
    //   103: ldc_w 462
    //   106: iconst_2
    //   107: new 81	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 464
    //   117: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 11
    //   122: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 466
    //   128: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_1
    //   132: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 469	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 9
    //   143: astore 8
    //   145: aload 11
    //   147: invokestatic 473	bhmi:b	(Ljava/lang/String;)Z
    //   150: ifeq +55 -> 205
    //   153: aload 9
    //   155: astore 8
    //   157: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +16 -> 176
    //   163: aload 9
    //   165: astore 8
    //   167: ldc 26
    //   169: iconst_2
    //   170: ldc_w 475
    //   173: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 9
    //   178: astore 8
    //   180: aload_0
    //   181: aload_1
    //   182: aload 12
    //   184: invokevirtual 477	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iconst_0
    //   188: ifeq -151 -> 37
    //   191: new 451	java/lang/NullPointerException
    //   194: dup
    //   195: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   204: return
    //   205: aload 9
    //   207: astore 8
    //   209: aload_0
    //   210: aload_1
    //   211: invokespecial 479	com/tencent/biz/pubaccount/util/PreloadManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 13
    //   216: aload 13
    //   218: ifnonnull +21 -> 239
    //   221: iconst_0
    //   222: ifeq -185 -> 37
    //   225: new 451	java/lang/NullPointerException
    //   228: dup
    //   229: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   232: athrow
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 453	java/io/IOException:printStackTrace	()V
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
    //   284: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: ldc 26
    //   290: iconst_2
    //   291: new 81	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 481
    //   301: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 10
    //   306: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_1
    //   316: monitorexit
    //   317: aload 9
    //   319: astore 8
    //   321: aload_0
    //   322: getfield 483	com/tencent/biz/pubaccount/util/PreloadManager:jdField_b_of_type_Boolean	Z
    //   325: ifne +33 -> 358
    //   328: aload 9
    //   330: astore 8
    //   332: invokestatic 488	cooperation/qzone/util/NetworkState:getNetworkType	()I
    //   335: iconst_1
    //   336: if_icmpne +22 -> 358
    //   339: aload 9
    //   341: astore 8
    //   343: aload_0
    //   344: invokevirtual 490	com/tencent/biz/pubaccount/util/PreloadManager:b	()Z
    //   347: ifeq +11 -> 358
    //   350: aload 9
    //   352: astore 8
    //   354: aload_0
    //   355: invokevirtual 492	com/tencent/biz/pubaccount/util/PreloadManager:d	()V
    //   358: aload 9
    //   360: astore 8
    //   362: aload_0
    //   363: getfield 53	com/tencent/biz/pubaccount/util/PreloadManager:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   366: aload 10
    //   368: aload 13
    //   370: invokevirtual 495	java/lang/String:getBytes	()[B
    //   373: invokevirtual 496	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: pop
    //   377: aload 9
    //   379: astore 8
    //   381: aload 13
    //   383: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   386: ifeq +223 -> 609
    //   389: aload 9
    //   391: astore 8
    //   393: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   396: lstore 4
    //   398: lload 4
    //   400: lload_2
    //   401: lsub
    //   402: lstore_2
    //   403: aload 9
    //   405: astore 8
    //   407: aconst_null
    //   408: ldc_w 292
    //   411: ldc_w 498
    //   414: ldc_w 498
    //   417: iconst_0
    //   418: iconst_0
    //   419: ldc_w 325
    //   422: new 81	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 292
    //   432: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: lload_2
    //   436: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   439: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: ldc_w 500
    //   445: ldc_w 292
    //   448: invokestatic 505	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   451: iconst_0
    //   452: ifeq -415 -> 37
    //   455: new 451	java/lang/NullPointerException
    //   458: dup
    //   459: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   462: athrow
    //   463: astore_1
    //   464: aload_1
    //   465: invokevirtual 453	java/io/IOException:printStackTrace	()V
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
    //   486: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   489: aload 7
    //   491: astore 8
    //   493: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   496: lstore 4
    //   498: aload 7
    //   500: astore 8
    //   502: aconst_null
    //   503: ldc_w 292
    //   506: ldc_w 498
    //   509: ldc_w 498
    //   512: iconst_0
    //   513: iconst_0
    //   514: ldc_w 325
    //   517: new 81	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 292
    //   527: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: lload 4
    //   532: lload_2
    //   533: lsub
    //   534: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   537: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: aload_1
    //   541: invokevirtual 442	java/io/IOException:getMessage	()Ljava/lang/String;
    //   544: ldc_w 292
    //   547: invokestatic 505	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   550: aload 7
    //   552: ifnull -515 -> 37
    //   555: aload 7
    //   557: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   560: return
    //   561: astore_1
    //   562: aload_1
    //   563: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   566: return
    //   567: astore_1
    //   568: aload 9
    //   570: astore 8
    //   572: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +16 -> 591
    //   578: aload 9
    //   580: astore 8
    //   582: ldc 26
    //   584: iconst_2
    //   585: ldc_w 512
    //   588: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: iconst_0
    //   592: ifeq -555 -> 37
    //   595: new 451	java/lang/NullPointerException
    //   598: dup
    //   599: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   602: athrow
    //   603: astore_1
    //   604: aload_1
    //   605: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   608: return
    //   609: aload 9
    //   611: astore 8
    //   613: new 81	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   620: aload 13
    //   622: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc_w 514
    //   628: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 10
    //   633: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokevirtual 495	java/lang/String:getBytes	()[B
    //   642: astore_1
    //   643: aload 9
    //   645: astore 8
    //   647: aload 12
    //   649: invokestatic 516	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)[B
    //   652: astore 12
    //   654: aload 12
    //   656: ifnonnull +63 -> 719
    //   659: iconst_0
    //   660: ifeq -623 -> 37
    //   663: new 451	java/lang/NullPointerException
    //   666: dup
    //   667: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   670: athrow
    //   671: astore_1
    //   672: aload_1
    //   673: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   676: return
    //   677: astore_1
    //   678: aload 9
    //   680: astore 8
    //   682: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq +16 -> 701
    //   688: aload 9
    //   690: astore 8
    //   692: ldc 26
    //   694: iconst_2
    //   695: ldc_w 512
    //   698: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: iconst_0
    //   702: ifeq -665 -> 37
    //   705: new 451	java/lang/NullPointerException
    //   708: dup
    //   709: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   712: athrow
    //   713: astore_1
    //   714: aload_1
    //   715: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   718: return
    //   719: aload_1
    //   720: ifnonnull +21 -> 741
    //   723: iconst_0
    //   724: ifeq -687 -> 37
    //   727: new 451	java/lang/NullPointerException
    //   730: dup
    //   731: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   734: athrow
    //   735: astore_1
    //   736: aload_1
    //   737: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   740: return
    //   741: aload 9
    //   743: astore 8
    //   745: aload 12
    //   747: aload_1
    //   748: invokestatic 518	com/tencent/biz/pubaccount/util/PreloadManager:b	([B[B)[B
    //   751: astore 12
    //   753: aload 9
    //   755: astore 8
    //   757: new 94	java/io/File
    //   760: dup
    //   761: getstatic 460	antf:cK	Ljava/lang/String;
    //   764: invokespecial 519	java/io/File:<init>	(Ljava/lang/String;)V
    //   767: astore_1
    //   768: aload 9
    //   770: astore 8
    //   772: aload_1
    //   773: invokevirtual 106	java/io/File:exists	()Z
    //   776: ifne +36 -> 812
    //   779: aload 9
    //   781: astore 8
    //   783: aload_1
    //   784: invokevirtual 522	java/io/File:mkdirs	()Z
    //   787: istore 6
    //   789: iload 6
    //   791: ifne +21 -> 812
    //   794: iconst_0
    //   795: ifeq -758 -> 37
    //   798: new 451	java/lang/NullPointerException
    //   801: dup
    //   802: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   805: athrow
    //   806: astore_1
    //   807: aload_1
    //   808: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   811: return
    //   812: aload 9
    //   814: astore 8
    //   816: new 507	java/io/FileOutputStream
    //   819: dup
    //   820: new 94	java/io/File
    //   823: dup
    //   824: aload_1
    //   825: new 81	java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   832: aload 10
    //   834: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: ldc_w 524
    //   840: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokespecial 527	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   849: invokespecial 530	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   852: astore_1
    //   853: aload 12
    //   855: ifnonnull +99 -> 954
    //   858: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   861: ifeq +12 -> 873
    //   864: ldc 26
    //   866: iconst_2
    //   867: ldc_w 532
    //   870: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   876: lstore 4
    //   878: lload 4
    //   880: lload_2
    //   881: lsub
    //   882: lstore 4
    //   884: lload 4
    //   886: lstore_2
    //   887: aconst_null
    //   888: ldc_w 292
    //   891: ldc_w 498
    //   894: ldc_w 498
    //   897: iconst_0
    //   898: iconst_0
    //   899: ldc_w 325
    //   902: new 81	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   909: ldc_w 292
    //   912: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: lload 4
    //   917: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   920: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: ldc_w 500
    //   926: ldc_w 292
    //   929: invokestatic 505	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   932: lload 4
    //   934: lstore_2
    //   935: aload_1
    //   936: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   939: aload_1
    //   940: ifnull -903 -> 37
    //   943: aload_1
    //   944: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   947: return
    //   948: astore_1
    //   949: aload_1
    //   950: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   953: return
    //   954: aload_1
    //   955: aload 12
    //   957: invokevirtual 535	java/io/FileOutputStream:write	([B)V
    //   960: aload_1
    //   961: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   964: new 94	java/io/File
    //   967: dup
    //   968: new 81	java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   975: getstatic 460	antf:cK	Ljava/lang/String;
    //   978: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: aload 10
    //   983: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: ldc_w 524
    //   989: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: invokespecial 519	java/io/File:<init>	(Ljava/lang/String;)V
    //   998: new 94	java/io/File
    //   1001: dup
    //   1002: aload 11
    //   1004: invokespecial 519	java/io/File:<init>	(Ljava/lang/String;)V
    //   1007: invokevirtual 539	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1010: pop
    //   1011: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   1014: lstore 4
    //   1016: lload 4
    //   1018: lload_2
    //   1019: lsub
    //   1020: lstore 4
    //   1022: lload 4
    //   1024: lstore_2
    //   1025: aconst_null
    //   1026: ldc_w 292
    //   1029: ldc_w 498
    //   1032: ldc_w 498
    //   1035: iconst_0
    //   1036: iconst_0
    //   1037: ldc 232
    //   1039: new 81	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 292
    //   1049: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: lload 4
    //   1054: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: ldc_w 500
    //   1063: ldc_w 292
    //   1066: invokestatic 505	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1069: aload_1
    //   1070: ifnull -1033 -> 37
    //   1073: aload_1
    //   1074: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   1077: return
    //   1078: astore_1
    //   1079: aload_1
    //   1080: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   1083: return
    //   1084: astore_1
    //   1085: aload 8
    //   1087: astore 7
    //   1089: aload 7
    //   1091: ifnull +8 -> 1099
    //   1094: aload 7
    //   1096: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   1099: aload_1
    //   1100: athrow
    //   1101: astore 7
    //   1103: aload 7
    //   1105: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   1108: goto -9 -> 1099
    //   1111: astore 8
    //   1113: aload_1
    //   1114: astore 7
    //   1116: aload 8
    //   1118: astore_1
    //   1119: goto -30 -> 1089
    //   1122: astore_1
    //   1123: goto -642 -> 481
    //   1126: astore 7
    //   1128: aload_1
    //   1129: astore 8
    //   1131: aload 7
    //   1133: astore_1
    //   1134: aload 8
    //   1136: astore 7
    //   1138: goto -657 -> 481
    //   1141: astore 8
    //   1143: aload_1
    //   1144: astore 7
    //   1146: aload 8
    //   1148: astore_1
    //   1149: goto -668 -> 481
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1152	0	this	PreloadManager
    //   0	1152	1	paramString	String
    //   9	1016	2	l1	long
    //   396	657	4	l2	long
    //   787	3	6	bool	boolean
    //   4	1091	7	localObject1	Object
    //   1101	3	7	localIOException1	IOException
    //   1114	1	7	str1	String
    //   1126	6	7	localIOException2	IOException
    //   1136	9	7	localObject2	Object
    //   12	1074	8	localObject3	Object
    //   1111	6	8	localObject4	Object
    //   1129	6	8	str2	String
    //   1141	6	8	localIOException3	IOException
    //   1	812	9	localObject5	Object
    //   18	349	10	str3	String
    //   469	513	10	str4	String
    //   87	916	11	str5	String
    //   60	896	12	localObject6	Object
    //   214	407	13	str6	String
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
    //   887	932	1141	java/io/IOException
    //   935	939	1141	java/io/IOException
    //   1025	1069	1141	java/io/IOException
  }
  
  /* Error */
  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: new 366	javax/crypto/spec/SecretKeySpec
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 368
    //   8: invokespecial 371	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   11: astore_0
    //   12: ldc_w 368
    //   15: invokestatic 389	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_1
    //   21: aload_0
    //   22: invokevirtual 393	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 397	javax/crypto/Cipher:doFinal	([B)[B
    //   30: astore_0
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: aload_0
    //   35: invokevirtual 400	javax/crypto/IllegalBlockSizeException:printStackTrace	()V
    //   38: aconst_null
    //   39: areturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 399	java/security/InvalidKeyException:printStackTrace	()V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 372	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 401	javax/crypto/BadPaddingException:printStackTrace	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 398	javax/crypto/NoSuchPaddingException:printStackTrace	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 402	java/lang/OutOfMemoryError:printStackTrace	()V
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
              String str4 = nnr.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
      str5 = nnr.a(BaseApplication.getContext(), str5, "GET", null, (Bundle)localObject, str3);
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
        localObject = nnr.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
    switch (tyi.b)
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
        if (!TextUtils.isEmpty(tyi.i))
        {
          bool1 = bool2;
          if (str.endsWith(tyi.i)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private byte[] c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyArticleDetailPreloadManager", 2, "downloadImageWithCondition:" + tyi.m);
    }
    if (tyi.m) {
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
              paramString = nnr.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
    return nnr.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
              byte[] arrayOfByte = nnr.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
      localObject1 = nnr.a(BaseApplication.getContext(), (String)localObject1, "GET", null, (Bundle)localObject2, str3);
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
        localObject2 = nnr.a(BaseApplication.getContext(), paramString, "GET", null, null, null);
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
  
  public ArrayList<txy> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (paramString == null) {
        break label97;
      }
      Collections.sort(paramString, new txz());
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        txy localtxy = (txy)paramString.next();
        if (a(localtxy.jdField_a_of_type_JavaLangString) == 0) {
          localArrayList.add(localtxy);
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
    //   0: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_1
    //   5: invokestatic 79	bjtz:d	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 9
    //   10: new 94	java/io/File
    //   13: dup
    //   14: getstatic 99	antf:cL	Ljava/lang/String;
    //   17: invokespecial 519	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 10
    //   22: aload 10
    //   24: invokevirtual 106	java/io/File:exists	()Z
    //   27: ifne +37 -> 64
    //   30: aload 10
    //   32: invokevirtual 522	java/io/File:mkdirs	()Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifne +27 -> 64
    //   40: iconst_0
    //   41: ifeq +11 -> 52
    //   44: new 451	java/lang/NullPointerException
    //   47: dup
    //   48: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   51: athrow
    //   52: iconst_0
    //   53: istore_2
    //   54: iload_2
    //   55: ireturn
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   61: goto -9 -> 52
    //   64: new 94	java/io/File
    //   67: dup
    //   68: aload 10
    //   70: new 81	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   77: aload 9
    //   79: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 88
    //   84: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 527	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: astore 12
    //   95: new 507	java/io/FileOutputStream
    //   98: dup
    //   99: aload 12
    //   101: invokespecial 530	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: astore 7
    //   106: aload 7
    //   108: astore 8
    //   110: aload_0
    //   111: aload_1
    //   112: invokespecial 760	com/tencent/biz/pubaccount/util/PreloadManager:c	(Ljava/lang/String;)[B
    //   115: astore 11
    //   117: aload 11
    //   119: ifnull +174 -> 293
    //   122: aload 7
    //   124: astore 8
    //   126: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +45 -> 174
    //   132: aload 7
    //   134: astore 8
    //   136: ldc 26
    //   138: iconst_2
    //   139: new 81	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 762
    //   149: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 764
    //   159: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   165: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   168: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload 7
    //   176: astore 8
    //   178: aload 7
    //   180: aload 11
    //   182: invokevirtual 535	java/io/FileOutputStream:write	([B)V
    //   185: aload 7
    //   187: astore 8
    //   189: aload 12
    //   191: new 94	java/io/File
    //   194: dup
    //   195: aload 10
    //   197: aload 9
    //   199: invokespecial 527	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   202: invokevirtual 539	java/io/File:renameTo	(Ljava/io/File;)Z
    //   205: pop
    //   206: aload 7
    //   208: astore 8
    //   210: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   213: lstore 5
    //   215: lload 5
    //   217: lload_3
    //   218: lsub
    //   219: lstore 5
    //   221: aload 7
    //   223: astore 8
    //   225: lload 5
    //   227: lstore_3
    //   228: aconst_null
    //   229: ldc_w 292
    //   232: ldc_w 766
    //   235: ldc_w 766
    //   238: iconst_0
    //   239: iconst_0
    //   240: ldc 232
    //   242: new 81	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 292
    //   252: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: lload 5
    //   257: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: ldc_w 500
    //   266: ldc_w 325
    //   269: invokestatic 505	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   272: iconst_1
    //   273: istore_2
    //   274: aload 7
    //   276: ifnull -222 -> 54
    //   279: aload 7
    //   281: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   284: iconst_1
    //   285: ireturn
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   291: iconst_1
    //   292: ireturn
    //   293: aload 7
    //   295: astore 8
    //   297: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +16 -> 316
    //   303: aload 7
    //   305: astore 8
    //   307: ldc 26
    //   309: iconst_2
    //   310: ldc_w 768
    //   313: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload 7
    //   318: astore 8
    //   320: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   323: lstore 5
    //   325: lload 5
    //   327: lload_3
    //   328: lsub
    //   329: lstore 5
    //   331: aload 7
    //   333: astore 8
    //   335: lload 5
    //   337: lstore_3
    //   338: aconst_null
    //   339: ldc_w 292
    //   342: ldc_w 766
    //   345: ldc_w 766
    //   348: iconst_0
    //   349: iconst_0
    //   350: ldc_w 325
    //   353: new 81	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 292
    //   363: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: lload 5
    //   368: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   371: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: ldc_w 500
    //   377: ldc_w 325
    //   380: invokestatic 505	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 7
    //   385: ifnull +8 -> 393
    //   388: aload 7
    //   390: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   393: iconst_0
    //   394: ireturn
    //   395: astore_1
    //   396: aload_1
    //   397: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   400: goto -7 -> 393
    //   403: astore_1
    //   404: aconst_null
    //   405: astore 7
    //   407: aload 7
    //   409: astore 8
    //   411: invokestatic 447	java/lang/System:currentTimeMillis	()J
    //   414: lstore 5
    //   416: aload 7
    //   418: astore 8
    //   420: aconst_null
    //   421: ldc_w 292
    //   424: ldc_w 766
    //   427: ldc_w 766
    //   430: iconst_0
    //   431: iconst_0
    //   432: ldc_w 325
    //   435: new 81	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 292
    //   445: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: lload 5
    //   450: lload_3
    //   451: lsub
    //   452: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   455: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: aload_1
    //   459: invokevirtual 442	java/io/IOException:getMessage	()Ljava/lang/String;
    //   462: ldc_w 325
    //   465: invokestatic 505	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   468: aload 7
    //   470: ifnull +8 -> 478
    //   473: aload 7
    //   475: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   478: iconst_0
    //   479: ireturn
    //   480: astore_1
    //   481: aload_1
    //   482: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   485: goto -7 -> 478
    //   488: astore_1
    //   489: aconst_null
    //   490: astore 7
    //   492: aload 7
    //   494: ifnull -16 -> 478
    //   497: aload 7
    //   499: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   502: goto -24 -> 478
    //   505: astore_1
    //   506: aload_1
    //   507: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   510: goto -32 -> 478
    //   513: astore_1
    //   514: aconst_null
    //   515: astore 7
    //   517: aload 7
    //   519: astore 8
    //   521: aload_1
    //   522: invokevirtual 769	java/lang/IllegalArgumentException:printStackTrace	()V
    //   525: aload 7
    //   527: ifnull -49 -> 478
    //   530: aload 7
    //   532: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   535: goto -57 -> 478
    //   538: astore_1
    //   539: aload_1
    //   540: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   543: goto -65 -> 478
    //   546: astore_1
    //   547: aconst_null
    //   548: astore 8
    //   550: aload 8
    //   552: ifnull +8 -> 560
    //   555: aload 8
    //   557: invokevirtual 510	java/io/FileOutputStream:close	()V
    //   560: aload_1
    //   561: athrow
    //   562: astore 7
    //   564: aload 7
    //   566: invokevirtual 453	java/io/IOException:printStackTrace	()V
    //   569: goto -9 -> 560
    //   572: astore_1
    //   573: goto -23 -> 550
    //   576: astore_1
    //   577: goto -60 -> 517
    //   580: astore_1
    //   581: goto -89 -> 492
    //   584: astore_1
    //   585: goto -178 -> 407
    //   588: astore_1
    //   589: goto -182 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	this	PreloadManager
    //   0	592	1	paramString	String
    //   35	239	2	bool	boolean
    //   3	448	3	l1	long
    //   213	236	5	l2	long
    //   104	427	7	localFileOutputStream1	java.io.FileOutputStream
    //   562	3	7	localIOException	IOException
    //   108	448	8	localFileOutputStream2	java.io.FileOutputStream
    //   8	190	9	str	String
    //   20	176	10	localFile1	File
    //   115	66	11	arrayOfByte	byte[]
    //   93	97	12	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   44	52	56	java/io/IOException
    //   279	284	286	java/io/IOException
    //   388	393	395	java/io/IOException
    //   10	36	403	java/io/IOException
    //   64	106	403	java/io/IOException
    //   473	478	480	java/io/IOException
    //   10	36	488	java/lang/OutOfMemoryError
    //   64	106	488	java/lang/OutOfMemoryError
    //   497	502	505	java/io/IOException
    //   10	36	513	java/lang/IllegalArgumentException
    //   64	106	513	java/lang/IllegalArgumentException
    //   530	535	538	java/io/IOException
    //   10	36	546	finally
    //   64	106	546	finally
    //   555	560	562	java/io/IOException
    //   110	117	572	finally
    //   126	132	572	finally
    //   136	174	572	finally
    //   178	185	572	finally
    //   189	206	572	finally
    //   210	215	572	finally
    //   228	272	572	finally
    //   297	303	572	finally
    //   307	316	572	finally
    //   320	325	572	finally
    //   338	383	572	finally
    //   411	416	572	finally
    //   420	468	572	finally
    //   521	525	572	finally
    //   110	117	576	java/lang/IllegalArgumentException
    //   126	132	576	java/lang/IllegalArgumentException
    //   136	174	576	java/lang/IllegalArgumentException
    //   178	185	576	java/lang/IllegalArgumentException
    //   189	206	576	java/lang/IllegalArgumentException
    //   210	215	576	java/lang/IllegalArgumentException
    //   228	272	576	java/lang/IllegalArgumentException
    //   297	303	576	java/lang/IllegalArgumentException
    //   307	316	576	java/lang/IllegalArgumentException
    //   320	325	576	java/lang/IllegalArgumentException
    //   338	383	576	java/lang/IllegalArgumentException
    //   110	117	580	java/lang/OutOfMemoryError
    //   126	132	580	java/lang/OutOfMemoryError
    //   136	174	580	java/lang/OutOfMemoryError
    //   178	185	580	java/lang/OutOfMemoryError
    //   189	206	580	java/lang/OutOfMemoryError
    //   210	215	580	java/lang/OutOfMemoryError
    //   228	272	580	java/lang/OutOfMemoryError
    //   297	303	580	java/lang/OutOfMemoryError
    //   307	316	580	java/lang/OutOfMemoryError
    //   320	325	580	java/lang/OutOfMemoryError
    //   338	383	580	java/lang/OutOfMemoryError
    //   110	117	584	java/io/IOException
    //   126	132	584	java/io/IOException
    //   136	174	584	java/io/IOException
    //   178	185	584	java/io/IOException
    //   189	206	584	java/io/IOException
    //   210	215	584	java/io/IOException
    //   297	303	584	java/io/IOException
    //   307	316	584	java/io/IOException
    //   320	325	584	java/io/IOException
    //   228	272	588	java/io/IOException
    //   338	383	588	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PreloadManager
 * JD-Core Version:    0.7.0.1
 */