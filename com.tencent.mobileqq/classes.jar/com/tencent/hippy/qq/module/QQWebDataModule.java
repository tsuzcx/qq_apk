package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.hippy.VasHippyUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

@HippyNativeModule(name="QQWebDataModule")
public class QQWebDataModule
  extends QQBaseModule
{
  public static final int ACTION_HASH_DELETE = 2;
  public static final int ACTION_HASH_READ = 0;
  public static final int ACTION_HASH_WRITE = 1;
  static final String CLASSNAME = "QQWebDataModule";
  public static final int ERROR_DATA_NOT_EXIST = -11;
  public static final int ERROR_EMPTY_DATA = -8;
  public static final int ERROR_EMPTY_KEY = -7;
  public static final int ERROR_EMPTY_PARAMS = -3;
  public static final int ERROR_EMPTY_PATH = -6;
  public static final int ERROR_EMPTY_URL = -4;
  public static final int ERROR_NO_PERMISSION_TO_DOMAIN = -5;
  public static final int ERROR_NO_SPACE_OR_NO_SDCARD = -9;
  public static final int ERROR_TOO_MANY_DATA = -12;
  public static final int ERROR_WRONG_IMAGE_DATA = -10;
  public static final int ERROR_WRONG_JSON = -2;
  public static final String PUBACCOUNT_DATA_PATH;
  private final String METHOD_DELETE_H5_DATA = "deleteH5Data";
  private final String METHOD_GET_UA = "getDefaultUserAgent";
  private final String METHOD_READ_H5_DATA = "readH5Data";
  private final String METHOD_WRITE_H5_DATA = "writeH5Data";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("pubaccount/");
    PUBACCOUNT_DATA_PATH = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public QQWebDataModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private int checkParams(String paramString1, String paramString2, String paramString3, AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return -6;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return -7;
    }
    if (!((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkDomainPermission(paramString3)) {
      return -5;
    }
    if ((paramAppInterface != null) && (paramAppInterface.isLogin())) {
      return 0;
    }
    return -11;
  }
  
  /* Error */
  private int doFileWrite(String paramString1, File paramFile, String paramString2)
  {
    // Byte code:
    //   0: new 148	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: aload_1
    //   6: invokestatic 153	com/tencent/mobileqq/utils/HexUtil:string2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   9: invokespecial 156	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 159	java/io/File:exists	()Z
    //   17: ifeq +8 -> 25
    //   20: aload_2
    //   21: invokevirtual 162	java/io/File:delete	()Z
    //   24: pop
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_1
    //   30: new 164	java/io/FileWriter
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 167	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   38: astore_2
    //   39: aload_2
    //   40: aload_3
    //   41: invokevirtual 171	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   44: aload_2
    //   45: invokevirtual 174	java/io/FileWriter:close	()V
    //   48: iconst_0
    //   49: ireturn
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   55: bipush 247
    //   57: ireturn
    //   58: astore_1
    //   59: goto +38 -> 97
    //   62: astore_1
    //   63: aload_1
    //   64: astore_3
    //   65: goto +15 -> 80
    //   68: astore_3
    //   69: aload_1
    //   70: astore_2
    //   71: aload_3
    //   72: astore_1
    //   73: goto +24 -> 97
    //   76: astore_3
    //   77: aload 4
    //   79: astore_2
    //   80: aload_2
    //   81: astore_1
    //   82: aload_3
    //   83: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 174	java/io/FileWriter:close	()V
    //   94: bipush 247
    //   96: ireturn
    //   97: aload_2
    //   98: ifnull +15 -> 113
    //   101: aload_2
    //   102: invokevirtual 174	java/io/FileWriter:close	()V
    //   105: goto +8 -> 113
    //   108: astore_2
    //   109: aload_2
    //   110: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	QQWebDataModule
    //   0	115	1	paramString1	String
    //   0	115	2	paramFile	File
    //   0	115	3	paramString2	String
    //   26	52	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/io/IOException
    //   90	94	50	java/io/IOException
    //   39	44	58	finally
    //   39	44	62	java/io/IOException
    //   30	39	68	finally
    //   82	86	68	finally
    //   30	39	76	java/io/IOException
    //   101	105	108	java/io/IOException
  }
  
  private static long getH5DataUsage()
  {
    Object localObject = new File(PUBACCOUNT_DATA_PATH);
    boolean bool = ((File)localObject).exists();
    long l = 0L;
    if (!bool) {
      return 0L;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    while (!localArrayList.isEmpty())
    {
      localObject = (File)localArrayList.remove(0);
      if (((File)localObject).isFile())
      {
        l += ((File)localObject).length();
      }
      else
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null) {
          Collections.addAll(localArrayList, (Object[])localObject);
        }
      }
    }
    return l;
  }
  
  private String hash(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes(StandardCharsets.UTF_8));
      paramString = HexUtil.bytes2HexStr(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label31:
      break label31;
    }
    return "wronghash";
  }
  
  private String operateHash(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    Object localObject1 = getAppInterface();
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    EntityManager localEntityManager = ((AppInterface)localObject1).getEntityManagerFactory(((AppInterface)localObject1).getAccount()).createEntityManager();
    if (paramBoolean) {
      localObject1 = (CouponH5Data)localEntityManager.find(CouponH5Data.class, "mHost = ?", new String[] { paramString1 });
    } else {
      localObject1 = (CouponH5Data)localEntityManager.find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        if (paramInt != 2) {
          break label252;
        }
      }
    }
    else
    {
      if (TextUtils.isEmpty(paramString3))
      {
        paramString1 = localEntityManager.query(CouponH5Data.class, false, "mHost = ? AND mPath = ?", new String[] { paramString1, paramString2 }, null, null, null, null);
        if (paramString1 == null) {
          break label252;
        }
        paramString1 = paramString1.iterator();
        while (paramString1.hasNext()) {
          localEntityManager.remove((CouponH5Data)paramString1.next());
        }
      }
      paramString1 = (String)localObject1;
      if (paramString1 == null) {
        break label252;
      }
      localEntityManager.remove(paramString1);
      break label252;
    }
    Object localObject3 = localObject1;
    if (localObject3 == null)
    {
      paramString1 = new CouponH5Data(paramString1, paramString2, paramString3, paramString4);
      localEntityManager.persist(paramString1);
    }
    else
    {
      localObject3.mData = paramString4;
      localEntityManager.update(localObject3);
      label252:
      paramString1 = (String)localObject1;
    }
    localEntityManager.close();
    paramString2 = localObject2;
    if (paramString1 != null) {
      paramString2 = paramString1.mData;
    }
    return paramString2;
  }
  
  @NotNull
  private File paperFilePath(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PUBACCOUNT_DATA_PATH);
    localStringBuilder.append("/");
    localStringBuilder.append(HexUtil.string2HexString(paramString3));
    paramString3 = new File(localStringBuilder.toString());
    if (!paramString3.exists())
    {
      paramString3.mkdirs();
    }
    else if (paramString3.isFile())
    {
      paramString3.delete();
      paramString3.mkdirs();
    }
    paramString1 = new File(paramString3, paramString1);
    if (!paramString1.exists())
    {
      paramString1.mkdirs();
    }
    else if (paramString1.isFile())
    {
      paramString1.delete();
      paramString1.mkdirs();
    }
    paramString1 = new File(paramString1, HexUtil.string2HexString(paramString2));
    if (!paramString1.exists())
    {
      paramString1.mkdirs();
      return paramString1;
    }
    if (paramString1.isFile())
    {
      paramString1.delete();
      paramString1.mkdirs();
    }
    return paramString1;
  }
  
  /* Error */
  private void readDataFile(Promise paramPromise, HippyMap paramHippyMap, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aload_0
    //   10: monitorenter
    //   11: aload 10
    //   13: astore 8
    //   15: new 325	java/io/FileInputStream
    //   18: dup
    //   19: aload 4
    //   21: invokespecial 326	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore 9
    //   26: aload 4
    //   28: invokevirtual 200	java/io/File:length	()J
    //   31: lstore 6
    //   33: lload 6
    //   35: lconst_0
    //   36: lcmp
    //   37: ifgt +32 -> 69
    //   40: aload_1
    //   41: bipush 245
    //   43: ldc_w 328
    //   46: aload_2
    //   47: invokestatic 334	com/tencent/mobileqq/vas/hippy/VasHippyUtils:a	(ILjava/lang/String;Ljava/lang/Object;)Lcom/tencent/mtt/hippy/common/HippyMap;
    //   50: invokeinterface 340 2 0
    //   55: aload_0
    //   56: monitorexit
    //   57: aload 9
    //   59: invokevirtual 343	java/io/InputStream:close	()V
    //   62: return
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   68: return
    //   69: lload 6
    //   71: l2i
    //   72: istore 5
    //   74: iload 5
    //   76: newarray byte
    //   78: astore 4
    //   80: aload 9
    //   82: aload 4
    //   84: invokevirtual 347	java/io/InputStream:read	([B)I
    //   87: pop
    //   88: new 229	java/lang/String
    //   91: dup
    //   92: aload 4
    //   94: invokespecial 349	java/lang/String:<init>	([B)V
    //   97: astore 8
    //   99: aload 8
    //   101: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifeq +65 -> 169
    //   107: aload_1
    //   108: bipush 245
    //   110: ldc_w 328
    //   113: aload_2
    //   114: invokestatic 334	com/tencent/mobileqq/vas/hippy/VasHippyUtils:a	(ILjava/lang/String;Ljava/lang/Object;)Lcom/tencent/mtt/hippy/common/HippyMap;
    //   117: invokeinterface 340 2 0
    //   122: new 48	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   129: astore_3
    //   130: aload_3
    //   131: ldc_w 351
    //   134: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_3
    //   139: aload 4
    //   141: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 17
    //   147: iconst_1
    //   148: aload_3
    //   149: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: monitorexit
    //   157: aload 9
    //   159: invokevirtual 343	java/io/InputStream:close	()V
    //   162: return
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   168: return
    //   169: aload 8
    //   171: aload_3
    //   172: invokestatic 366	com/tencent/util/ThreeDes:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   175: astore_3
    //   176: aload_3
    //   177: ifnonnull +32 -> 209
    //   180: aload_1
    //   181: bipush 245
    //   183: ldc_w 328
    //   186: aload_2
    //   187: invokestatic 334	com/tencent/mobileqq/vas/hippy/VasHippyUtils:a	(ILjava/lang/String;Ljava/lang/Object;)Lcom/tencent/mtt/hippy/common/HippyMap;
    //   190: invokeinterface 340 2 0
    //   195: aload_0
    //   196: monitorexit
    //   197: aload 9
    //   199: invokevirtual 343	java/io/InputStream:close	()V
    //   202: return
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   208: return
    //   209: aload_2
    //   210: ldc_w 368
    //   213: aload_3
    //   214: invokevirtual 374	com/tencent/mtt/hippy/common/HippyMap:pushString	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_1
    //   218: iconst_0
    //   219: ldc_w 328
    //   222: aload_2
    //   223: invokestatic 334	com/tencent/mobileqq/vas/hippy/VasHippyUtils:a	(ILjava/lang/String;Ljava/lang/Object;)Lcom/tencent/mtt/hippy/common/HippyMap;
    //   226: invokeinterface 340 2 0
    //   231: aload_0
    //   232: monitorexit
    //   233: aload 9
    //   235: invokevirtual 343	java/io/InputStream:close	()V
    //   238: return
    //   239: astore 4
    //   241: aload 9
    //   243: astore_3
    //   244: goto +8 -> 252
    //   247: astore 4
    //   249: aload 8
    //   251: astore_3
    //   252: aload_3
    //   253: astore 8
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_3
    //   258: astore 8
    //   260: aload_3
    //   261: astore 9
    //   263: aload 4
    //   265: athrow
    //   266: astore_1
    //   267: goto +39 -> 306
    //   270: aload 9
    //   272: astore 8
    //   274: aload_1
    //   275: bipush 247
    //   277: ldc_w 328
    //   280: aload_2
    //   281: invokestatic 334	com/tencent/mobileqq/vas/hippy/VasHippyUtils:a	(ILjava/lang/String;Ljava/lang/Object;)Lcom/tencent/mtt/hippy/common/HippyMap;
    //   284: invokeinterface 340 2 0
    //   289: aload 9
    //   291: ifnull +14 -> 305
    //   294: aload 9
    //   296: invokevirtual 343	java/io/InputStream:close	()V
    //   299: return
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   305: return
    //   306: aload 8
    //   308: ifnull +16 -> 324
    //   311: aload 8
    //   313: invokevirtual 343	java/io/InputStream:close	()V
    //   316: goto +8 -> 324
    //   319: astore_2
    //   320: aload_2
    //   321: invokevirtual 177	java/io/IOException:printStackTrace	()V
    //   324: aload_1
    //   325: athrow
    //   326: astore_3
    //   327: goto -57 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	QQWebDataModule
    //   0	330	1	paramPromise	Promise
    //   0	330	2	paramHippyMap	HippyMap
    //   0	330	3	paramString	String
    //   0	330	4	paramFile	File
    //   72	3	5	i	int
    //   31	39	6	l	long
    //   1	311	8	localObject1	Object
    //   4	291	9	localObject2	Object
    //   7	5	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   57	62	63	java/io/IOException
    //   157	162	163	java/io/IOException
    //   197	202	203	java/io/IOException
    //   26	33	239	finally
    //   40	57	239	finally
    //   74	157	239	finally
    //   169	176	239	finally
    //   180	197	239	finally
    //   209	233	239	finally
    //   15	26	247	finally
    //   255	257	247	finally
    //   9	11	266	finally
    //   263	266	266	finally
    //   274	289	266	finally
    //   233	238	300	java/io/IOException
    //   294	299	300	java/io/IOException
    //   311	316	319	java/io/IOException
    //   9	11	326	java/io/IOException
    //   263	266	326	java/io/IOException
  }
  
  @HippyMethod(name="deleteH5Data")
  public void deleteH5Data(HippyMap paramHippyMap, Promise paramPromise)
  {
    Object localObject = paramHippyMap.getString("callId");
    String str1 = paramHippyMap.getString("host");
    String str2 = paramHippyMap.getString("path");
    String str3 = paramHippyMap.getString("key");
    int i = paramHippyMap.getInt("delAllHostData");
    AppInterface localAppInterface = getAppInterface();
    paramHippyMap = (HippyMap)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramHippyMap = "";
    }
    localObject = new HippyMap();
    ((HippyMap)localObject).pushString("callId", paramHippyMap);
    int j = checkParams(str2, str3, str1, localAppInterface);
    if (j != 0)
    {
      paramPromise.resolve(VasHippyUtils.a(j, "", localObject));
      return;
    }
    ThreadManager.excute(new QQWebDataModule.3(this, str1, str2, str3, i, localAppInterface.getCurrentAccountUin(), paramPromise, (HippyMap)localObject), 64, null, false);
  }
  
  @HippyMethod(name="getDefaultUserAgent")
  public void getDefaultUserAgent(Promise paramPromise)
  {
    paramPromise.resolve(SwiftWebViewUtils.a(SwiftWebViewUtils.c(""), "", false));
  }
  
  @HippyMethod(name="readH5Data")
  public void readH5Data(HippyMap paramHippyMap, Promise paramPromise)
  {
    Object localObject = paramHippyMap.getString("callId");
    String str1 = paramHippyMap.getString("host");
    String str2 = paramHippyMap.getString("path");
    String str3 = paramHippyMap.getString("key");
    AppInterface localAppInterface = getAppInterface();
    paramHippyMap = (HippyMap)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramHippyMap = "";
    }
    localObject = new HippyMap();
    ((HippyMap)localObject).pushString("callId", paramHippyMap);
    paramHippyMap = localAppInterface.getCurrentAccountUin();
    int i = checkParams(str2, str3, str1, localAppInterface);
    if (i != 0)
    {
      paramPromise.resolve(VasHippyUtils.a(i, "", localObject));
      return;
    }
    ThreadManager.excute(new QQWebDataModule.1(this, str1, str2, str3, paramPromise, (HippyMap)localObject, paramHippyMap), 64, null, false);
  }
  
  @HippyMethod(name="writeH5Data")
  public void writeH5Data(HippyMap paramHippyMap, Promise paramPromise)
  {
    Object localObject = paramHippyMap.getString("callId");
    String str1 = paramHippyMap.getString("host");
    String str2 = paramHippyMap.getString("path");
    String str3 = paramHippyMap.getString("key");
    String str4 = paramHippyMap.getString("data");
    AppInterface localAppInterface = getAppInterface();
    paramHippyMap = (HippyMap)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramHippyMap = "";
    }
    localObject = new HippyMap();
    ((HippyMap)localObject).pushString("callId", paramHippyMap);
    paramHippyMap = localAppInterface.getCurrentAccountUin();
    int i = checkParams(str2, str3, str1, localAppInterface);
    if (TextUtils.isEmpty(str4)) {
      i = -8;
    }
    if (getH5DataUsage() > 52428800L) {
      i = -12;
    }
    if (i != 0)
    {
      paramPromise.resolve(VasHippyUtils.a(i, "", localObject));
      return;
    }
    ThreadManager.excute(new QQWebDataModule.2(this, str1, str2, str3, hash(str4), paramHippyMap, str4, paramPromise, (HippyMap)localObject), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQWebDataModule
 * JD-Core Version:    0.7.0.1
 */