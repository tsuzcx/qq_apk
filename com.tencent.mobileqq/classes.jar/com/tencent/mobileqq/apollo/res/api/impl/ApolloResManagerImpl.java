package com.tencent.mobileqq.apollo.res.api.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler.OnQueryBaseInfoListener;
import com.tencent.mobileqq.apollo.listener.Download403Callback;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.model.ApolloActionPackageData;
import com.tencent.mobileqq.apollo.model.ApolloActionTag;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.model.ApolloDressInfo;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.model.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloUserDressInfoListener;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Service(process={"all"})
public class ApolloResManagerImpl
  implements IApolloResManager
{
  public static final String ERRMSG_APOLLO_BASE_INFO_IS_NULL = "apolloBaseInfo is null";
  public static final String ERRMSG_APOLLO_STATUS_NOT_OPEN = "apolloStatus not open";
  public static final String ERRMSG_DOWNLOAD_ERROR = "download error";
  public static final String ERRMSG_DRESS_3D_DATA_IS_NULL = "dress3DData is null";
  public static final String ERRMSG_DRESS_ID_ILLEGAL = "dressId illegal ";
  public static final String ERRMSG_EXCEPTION = "exception";
  public static final String ERRMSG_PARAMETER_ERROR = "parameter error";
  public static final String ERRMSG_SUCCESS = "success";
  public static final String ERRMSG_VAS_EXTENSION_HANDLER_IS_NULL = "VasExtensionHandler is null";
  public static final int ERROR_CODE_APOLLO_BASE_INFO_IS_NULL = -5005;
  public static final int ERROR_CODE_APOLLO_STATUS_NOT_OPEN = -5006;
  public static final int ERROR_CODE_DOWNLOAD_ERROR = -5003;
  public static final int ERROR_CODE_DRESS_3D_DATA_IS_NULL = -5007;
  public static final int ERROR_CODE_DRESS_ID_ILLEGAL = -5002;
  public static final int ERROR_CODE_EXCEPTION = -5008;
  public static final int ERROR_CODE_PARAMETER_ERROR = -5001;
  public static final int ERROR_CODE_SUCCESS = 0;
  public static final int ERROR_CODE_VAS_EXTENSION_HANDLER_IS_NULL = -5004;
  public static final String TAG = "[cmshow]cm_res";
  private static AtomicBoolean sIsChecking = new AtomicBoolean(false);
  DownloadListener jsonListener = new ApolloResManagerImpl.11(this);
  private DownloadListener listener = new ApolloResManagerImpl.10(this);
  private AppInterface mApp;
  private ApolloExtensionHandler.OnQueryBaseInfoListener mBaseInfoListener;
  private AtomicBoolean mIsJsonParsing = new AtomicBoolean(false);
  ApolloListenerManager mListenerManager;
  private DownloadListener preDownloadListener = new ApolloResManagerImpl.8(this);
  
  private void addApolloActionTask(List<String> paramList, Map<String, File> paramMap, List<ApolloActionData> paramList1, Bundle paramBundle)
  {
    if ((paramList1 != null) && (paramList1.size() > 0) && (paramList != null))
    {
      if (paramMap == null) {
        return;
      }
      int i = 0;
      while (i < paramList1.size())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)paramList1.get(i);
        String str1 = CMGetResPathUtil.a(localApolloActionData, 1);
        Object localObject = CMGetResPathUtil.a(localApolloActionData, 0);
        String str2 = CMGetResPathUtil.a(localApolloActionData, 5);
        String str3 = CMGetResPathUtil.a(localApolloActionData, 4);
        if (FileUtil.b((String)localObject))
        {
          localObject = new DownloadTask(str1, new File((String)localObject));
          Bundle localBundle = new Bundle();
          localBundle.putSerializable(str1, localApolloActionData);
          ((DownloadTask)localObject).c = str1;
          ((DownloadTask)localObject).a(localBundle);
          this.listener.onDoneFile((DownloadTask)localObject);
        }
        else
        {
          paramList.add(str1);
          paramMap.put(str1, new File((String)localObject));
          if (paramBundle != null) {
            paramBundle.putSerializable(str1, localApolloActionData);
          }
        }
        if (!CMResUtil.a(localApolloActionData.actionId, localApolloActionData.personNum))
        {
          paramList.add(str2);
          paramMap.put(str2, new File(str3));
          if (paramBundle != null) {
            paramBundle.putSerializable(str2, localApolloActionData);
          }
        }
        i += 1;
      }
    }
  }
  
  private void checkActionVersion(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return;
    }
    Object localObject = new File(CMGetResPathUtil.a(paramApolloActionData, 7));
    if (!((File)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkActionVersion configFile not exists for ");
      ((StringBuilder)localObject).append(paramApolloActionData);
      QLog.e("[cmshow]cm_res", 1, ((StringBuilder)localObject).toString());
      return;
    }
    try
    {
      localObject = FileUtils.readFileContent((File)localObject);
      if (new JSONObject((String)localObject).optLong("version") < paramApolloActionData.version)
      {
        boolean bool = FileUtil.c(CMGetResPathUtil.a(paramApolloActionData, 6));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramApolloActionData.actionId);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramApolloActionData.actionName);
        URLDrawable.removeMemoryCacheByUrl(new URL("apollo_pic", null, ((StringBuilder)localObject).toString()).toString());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("del old action res id:");
          ((StringBuilder)localObject).append(paramApolloActionData.actionId);
          ((StringBuilder)localObject).append(", ret: ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        optActionConfigJson((String)localObject, paramApolloActionData);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkActionVersion failed for ");
      localStringBuilder.append(paramApolloActionData);
      QLog.e("[cmshow]cm_res", 1, localStringBuilder.toString(), localException);
    }
  }
  
  private void checkDefaultRes()
  {
    ApolloResManagerImpl.1 local1 = new ApolloResManagerImpl.1(this);
    if (!sIsChecking.getAndSet(true)) {
      ThreadManager.post(local1, 8, null, false);
    }
  }
  
  private boolean checkPackageAction(int paramInt, List<ApolloActionData> paramList)
  {
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        if (((ApolloActionData)paramList.get(i)).actionId == paramInt) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void checkPackageRedDots(ApolloActionPackage paramApolloActionPackage, List<ApolloActionData> paramList)
  {
    AppInterface localAppInterface = this.mApp;
    if (paramApolloActionPackage != null)
    {
      if (localAppInterface == null) {
        return;
      }
      if (paramList == null) {}
    }
    label512:
    label517:
    label520:
    for (;;)
    {
      try
      {
        if (paramList.size() == 0) {
          return;
        }
        localObject1 = localAppInterface.getApp();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("apollo_sp");
        ((StringBuilder)localObject2).append(localAppInterface.getCurrentUin());
        localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString(String.format("key_new_action_info_%s", new Object[] { String.valueOf(paramApolloActionPackage.packageId) }), "");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (!QLog.isColorLevel()) {
            break label511;
          }
          QLog.d("[cmshow]cm_res", 2, "checkPackageRedDots, no new action info");
          return;
        }
        localObject2 = new JSONObject((String)localObject1);
        j = ((JSONObject)localObject2).getInt("actionId");
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label512;
        }
        if (((ApolloActionData)paramList.next()).actionId != j) {
          continue;
        }
        i = 1;
        if (i == 0)
        {
          QLog.d("[cmshow]cm_res", 1, new Object[] { "checkPackageRedDots, new action, pkdId=", Integer.valueOf(paramApolloActionPackage.packageId), ", actionId=", Integer.valueOf(j) });
          return;
        }
        l1 = ((JSONObject)localObject2).getLong("startTime");
        l2 = ((JSONObject)localObject2).getLong("interval");
        paramList = ((ApolloDaoManagerServiceImpl)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findPackageById(paramApolloActionPackage.packageId);
        if (paramList == null) {
          break label520;
        }
        if (l1 != paramList.redStartTime) {
          break label517;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]cm_res", 2, new Object[] { "checkPackageRedDots", " have not new red push" });
        }
        paramApolloActionPackage.isUpdate = paramList.isUpdate;
        paramApolloActionPackage.redFlowId = paramList.redFlowId;
        paramApolloActionPackage.redStartTime = paramList.redStartTime;
        paramApolloActionPackage.redInterval = paramList.redInterval;
        return;
      }
      catch (Exception paramApolloActionPackage)
      {
        Object localObject1;
        Object localObject2;
        int j;
        long l1;
        long l2;
        QLog.e("[cmshow]cm_res", 1, "checkPackageRedDots Exception:", paramApolloActionPackage);
      }
      paramApolloActionPackage.isUpdate = true;
      paramApolloActionPackage.redFlowId = j;
      paramApolloActionPackage.redStartTime = l1;
      paramApolloActionPackage.redInterval = l2;
      ((ApolloManagerServiceImpl)localAppInterface.getRuntimeService(IApolloManagerService.class, "all")).saveRedAppearTime(paramApolloActionPackage.packageId);
      paramList = new ArrayList();
      localObject2 = new ApolloActionData();
      ((ApolloActionData)localObject2).actionId = j;
      paramList.add(localObject2);
      ((ApolloResManagerImpl)localAppInterface.getRuntimeService(IApolloResManager.class, "all")).downloadResAndPanel(paramList, "apollo_key");
      if (QLog.isColorLevel())
      {
        QLog.d("[cmshow]cm_res", 2, new Object[] { "checkPackageRedDots", " push red:", Integer.valueOf(paramApolloActionPackage.packageId), " newActionInfoStr:", localObject1 });
        return;
      }
      return;
      label511:
      return;
      int i = 0;
      continue;
    }
  }
  
  /* Error */
  private void copyFilesFassets(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +55 -> 58
    //   6: new 256	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: ldc_w 503
    //   20: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: aload_2
    //   27: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 5
    //   33: ldc_w 505
    //   36: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 5
    //   42: aload_3
    //   43: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 59
    //   49: iconst_2
    //   50: aload 5
    //   52: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aconst_null
    //   59: astore 7
    //   61: aconst_null
    //   62: astore 6
    //   64: new 200	java/io/File
    //   67: dup
    //   68: ldc_w 507
    //   71: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: invokevirtual 510	java/io/File:mkdirs	()Z
    //   77: pop
    //   78: aload_1
    //   79: invokevirtual 516	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   82: aload_2
    //   83: invokevirtual 522	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   86: astore 5
    //   88: new 524	java/io/FileOutputStream
    //   91: dup
    //   92: new 200	java/io/File
    //   95: dup
    //   96: aload_3
    //   97: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: invokespecial 527	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: astore_2
    //   104: sipush 4096
    //   107: newarray byte
    //   109: astore_1
    //   110: aload 5
    //   112: aload_1
    //   113: invokevirtual 533	java/io/InputStream:read	([B)I
    //   116: istore 4
    //   118: iload 4
    //   120: iconst_m1
    //   121: if_icmpeq +14 -> 135
    //   124: aload_2
    //   125: aload_1
    //   126: iconst_0
    //   127: iload 4
    //   129: invokevirtual 537	java/io/FileOutputStream:write	([BII)V
    //   132: goto -22 -> 110
    //   135: aload_2
    //   136: invokevirtual 540	java/io/FileOutputStream:flush	()V
    //   139: aload 5
    //   141: ifnull +11 -> 152
    //   144: aload 5
    //   146: invokevirtual 543	java/io/InputStream:close	()V
    //   149: goto +3 -> 152
    //   152: aload_2
    //   153: invokevirtual 544	java/io/FileOutputStream:close	()V
    //   156: return
    //   157: new 256	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   164: astore_2
    //   165: goto +119 -> 284
    //   168: astore_1
    //   169: aload_2
    //   170: astore_3
    //   171: goto +10 -> 181
    //   174: astore_3
    //   175: goto +20 -> 195
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_3
    //   181: aload 5
    //   183: astore_2
    //   184: aload_3
    //   185: astore 5
    //   187: aload_1
    //   188: astore_3
    //   189: goto +129 -> 318
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_2
    //   195: aload 5
    //   197: astore_1
    //   198: goto +19 -> 217
    //   201: astore_3
    //   202: aconst_null
    //   203: astore 5
    //   205: aload 7
    //   207: astore_2
    //   208: goto +110 -> 318
    //   211: astore_3
    //   212: aconst_null
    //   213: astore_2
    //   214: aload 6
    //   216: astore_1
    //   217: new 256	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   224: astore 5
    //   226: aload 5
    //   228: ldc_w 546
    //   231: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 5
    //   237: aload_3
    //   238: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: ldc 59
    //   247: iconst_1
    //   248: aload 5
    //   250: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload_1
    //   257: ifnull +10 -> 267
    //   260: aload_1
    //   261: invokevirtual 543	java/io/InputStream:close	()V
    //   264: goto +3 -> 267
    //   267: aload_2
    //   268: ifnull +43 -> 311
    //   271: aload_2
    //   272: invokevirtual 544	java/io/FileOutputStream:close	()V
    //   275: return
    //   276: new 256	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   283: astore_2
    //   284: aload_2
    //   285: ldc_w 551
    //   288: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_2
    //   293: aload_1
    //   294: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc 59
    //   303: iconst_1
    //   304: aload_2
    //   305: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: return
    //   312: astore_3
    //   313: aload_2
    //   314: astore 5
    //   316: aload_1
    //   317: astore_2
    //   318: aload_2
    //   319: ifnull +10 -> 329
    //   322: aload_2
    //   323: invokevirtual 543	java/io/InputStream:close	()V
    //   326: goto +3 -> 329
    //   329: aload 5
    //   331: ifnull +46 -> 377
    //   334: aload 5
    //   336: invokevirtual 544	java/io/FileOutputStream:close	()V
    //   339: goto +38 -> 377
    //   342: new 256	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   349: astore_1
    //   350: aload_1
    //   351: ldc_w 551
    //   354: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload_1
    //   359: aload_2
    //   360: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   363: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: ldc 59
    //   369: iconst_1
    //   370: aload_1
    //   371: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: goto +5 -> 382
    //   380: aload_3
    //   381: athrow
    //   382: goto -2 -> 380
    //   385: astore_1
    //   386: goto -229 -> 157
    //   389: astore_1
    //   390: goto -114 -> 276
    //   393: astore_2
    //   394: goto -52 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	ApolloResManagerImpl
    //   0	397	1	paramContext	android.content.Context
    //   0	397	2	paramString1	String
    //   0	397	3	paramString2	String
    //   116	12	4	i	int
    //   13	322	5	localObject1	Object
    //   62	153	6	localObject2	Object
    //   59	147	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   104	110	168	finally
    //   110	118	168	finally
    //   124	132	168	finally
    //   135	139	168	finally
    //   104	110	174	java/lang/Exception
    //   110	118	174	java/lang/Exception
    //   124	132	174	java/lang/Exception
    //   135	139	174	java/lang/Exception
    //   88	104	178	finally
    //   88	104	192	java/lang/Exception
    //   64	88	201	finally
    //   64	88	211	java/lang/Exception
    //   217	256	312	finally
    //   144	149	385	java/lang/Exception
    //   152	156	385	java/lang/Exception
    //   260	264	389	java/lang/Exception
    //   271	275	389	java/lang/Exception
    //   322	326	393	java/lang/Exception
    //   334	339	393	java/lang/Exception
  }
  
  private void doPreDownloadResDone(ApolloPreDownloadData paramApolloPreDownloadData, String paramString1, String paramString2)
  {
    if ((paramApolloPreDownloadData != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        File localFile = new File(paramString1);
        if (!localFile.exists()) {
          return;
        }
        String str = MD5FileUtil.a(localFile);
        if ((str != null) && (!str.equalsIgnoreCase(paramApolloPreDownloadData.md5)))
        {
          QLog.e("[cmshow]cm_res", 1, "preDownloadListener md5 not match!");
          localFile.delete();
          return;
        }
        FileUtils.uncompressZip(paramString1, paramString2, false);
        if (TextUtils.isEmpty(paramApolloPreDownloadData.zipDir)) {
          localFile.delete();
        }
        paramString2 = (ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all");
        paramApolloPreDownloadData.status = 1;
        paramString2.updatePreDownloadRes(paramApolloPreDownloadData);
        VipUtils.a(this.mApp, "cmshow", "Apollo", "pre_download_res", 0, 0, new String[] { paramApolloPreDownloadData.reportId });
        return;
      }
      catch (Exception paramApolloPreDownloadData)
      {
        paramString2 = new StringBuilder();
        paramString2.append("preDownloadListener fail zip file: ");
        paramString2.append(paramString1);
        QLog.e("[cmshow]cm_res", 1, paramString2.toString(), paramApolloPreDownloadData);
        return;
      }
    }
    QLog.e("[cmshow]cm_res", 1, "preDownloadListener err param");
  }
  
  private void downloadActionIfNotExist(int paramInt1, int paramInt2)
  {
    AppInterface localAppInterface = this.mApp;
    if ((!CMResUtil.a(paramInt1, paramInt2)) && (localAppInterface != null))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start download action:");
        ((StringBuilder)localObject1).append(paramInt1);
        QLog.i("[cmshow]ApolloPet", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = new ApolloActionData();
      ((ApolloActionData)localObject2).actionId = paramInt1;
      Object localObject1 = CMGetResPathUtil.a((ApolloActionData)localObject2, 5);
      localObject2 = CMGetResPathUtil.a((ApolloActionData)localObject2, 4);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadSpecialAction(localAppInterface, (String)localObject2, (String)localObject1);
    }
  }
  
  private AtomicInteger getDownloadCount(List<Integer> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    if ((paramBoolean1) || (paramList.size() > 0)) {
      localAtomicInteger.getAndIncrement();
    }
    if (paramBoolean2) {
      localAtomicInteger.getAndIncrement();
    }
    return localAtomicInteger;
  }
  
  private DownloaderInterface getDownloader()
  {
    return ((DownloaderFactory)this.mApp.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(3);
  }
  
  private int[] getDressArray(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int[] arrayOfInt = new int[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
        i += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  @NotNull
  private ApolloExtensionHandler.OnQueryBaseInfoListener getOnQueryBaseInfoListener(String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener, AppInterface paramAppInterface)
  {
    return new ApolloResManagerImpl.3(this, paramString, paramAppInterface, paramApolloUserDressInfoListener);
  }
  
  private void handleBaseInfoListener(AppInterface paramAppInterface, String paramString, ApolloBaseInfo paramApolloBaseInfo, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    if (paramApolloBaseInfo == null)
    {
      QLog.d("[cmshow]cm_res", 1, "handleBaseInfoListener  apolloBaseInfo is null");
      paramApolloUserDressInfoListener.a(null, "apolloBaseInfo is null", -5005);
      return;
    }
    if ((paramApolloBaseInfo.apolloStatus != 0) && (paramApolloBaseInfo.apolloStatus != 2))
    {
      handleParseApolloBaseInfo(paramApolloBaseInfo, paramString, paramApolloUserDressInfoListener, paramAppInterface, true);
      return;
    }
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("apolloStatus not open");
    paramAppInterface.append(paramApolloBaseInfo.apolloStatus);
    paramApolloUserDressInfoListener.a(null, paramAppInterface.toString(), -5006);
  }
  
  private void handleCallbackGetUserDressInfo(ApolloBaseInfo paramApolloBaseInfo, ApolloDress paramApolloDress, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    try
    {
      ApolloDressInfo localApolloDressInfo = new ApolloDressInfo();
      localApolloDressInfo.setUin(paramString);
      localApolloDressInfo.setDressMap(paramApolloBaseInfo.getApolloDress3D().dressMap);
      paramApolloDress = MD5Utils.toMD5(paramApolloDress.faceData);
      paramString = new StringBuilder();
      paramString.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/");
      paramString.append(paramApolloDress);
      paramString.append(File.separator);
      paramString.append("face.json");
      localApolloDressInfo.setFaceJson(new JSONObject(FileUtils.readFileToString(new File(paramString.toString()))));
      paramApolloDress = new StringBuilder();
      paramApolloDress.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
      paramApolloDress.append(paramApolloBaseInfo.getApolloDress3D().roleId);
      localApolloDressInfo.setRoleDir(paramApolloDress.toString());
      paramApolloUserDressInfoListener.a(localApolloDressInfo, "success", 0);
      return;
    }
    catch (Throwable paramApolloBaseInfo)
    {
      QLog.e("[cmshow]cm_res", 1, "getApolloUserDressInfo error ,", paramApolloBaseInfo);
      paramApolloUserDressInfoListener.a(null, "exception", -5008);
    }
  }
  
  private boolean handleParseApolloBaseInfo(ApolloBaseInfo paramApolloBaseInfo, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener, AppInterface paramAppInterface, boolean paramBoolean)
  {
    ApolloDress localApolloDress = paramApolloBaseInfo.getApolloDress3D();
    if (localApolloDress == null)
    {
      if ((paramBoolean) && (paramApolloUserDressInfoListener != null)) {
        paramApolloUserDressInfoListener.a(null, "dress3DData is null", -5007);
      }
      QLog.e("[cmshow]cm_res", 1, "handleParseApolloBaseInfo dress3DData is null");
      return false;
    }
    paramBoolean = needDownloadRoleRes(localApolloDress);
    ArrayList localArrayList = needDownloadDressList(localApolloDress);
    boolean bool = needDownloadFaceRes(localApolloDress);
    if ((!paramBoolean) && (!bool) && (localArrayList.size() == 0))
    {
      handleCallbackGetUserDressInfo(paramApolloBaseInfo, localApolloDress, paramString, paramApolloUserDressInfoListener);
      return true;
    }
    paramApolloBaseInfo = getDownloadCount(localArrayList, paramBoolean, bool);
    AtomicInteger localAtomicInteger1 = new AtomicInteger(0);
    AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
    if ((!paramBoolean) && (localArrayList.size() <= 0)) {
      break label198;
    }
    ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(paramAppInterface, paramString, new ApolloResManagerImpl.4(this, localAtomicInteger2, localAtomicInteger1, paramAppInterface, paramApolloBaseInfo, paramString, paramApolloUserDressInfoListener), localApolloDress.roleId, getDressArray(localArrayList), -1, -1, false);
    label198:
    if (bool) {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).checkDownloadFaceData(paramAppInterface, localApolloDress.faceData, new ApolloResManagerImpl.5(this, localAtomicInteger2, localAtomicInteger1, paramAppInterface, paramApolloBaseInfo, paramString, paramApolloUserDressInfoListener));
    }
    return true;
  }
  
  private void handleShouldCallBack(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, IApolloDaoManagerService paramIApolloDaoManagerService, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    if (paramAtomicInteger1.get() == paramAtomicInteger2.get())
    {
      if (paramAtomicInteger3.get() == paramAtomicInteger1.get())
      {
        paramAtomicInteger1 = paramIApolloDaoManagerService.getApolloBaseInfo(paramString);
        handleCallbackGetUserDressInfo(paramAtomicInteger1, paramAtomicInteger1.getApolloDress3D(), paramString, paramApolloUserDressInfoListener);
        return;
      }
      paramApolloUserDressInfoListener.a(null, "download error", -5003);
    }
  }
  
  private boolean isTest3DAction(ApolloActionData paramApolloActionData)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_test", 0);
    return false;
  }
  
  private ArrayList<Integer> needDownloadDressList(ApolloDress paramApolloDress)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramApolloDress.dressMap != null) && (!paramApolloDress.dressMap.isEmpty()))
    {
      paramApolloDress = paramApolloDress.dressMap.entrySet().iterator();
      JSONArray localJSONArray = new JSONArray();
      while (paramApolloDress.hasNext())
      {
        ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)paramApolloDress.next()).getValue();
        localJSONArray.put(String.valueOf(localDress.id));
        if (!CMResUtil.a(localDress.id)) {
          localArrayList.add(Integer.valueOf(localDress.id));
        }
      }
    }
    return localArrayList;
  }
  
  private boolean needDownloadFaceRes(ApolloDress paramApolloDress)
  {
    return (!TextUtils.isEmpty(paramApolloDress.faceData)) && (!CMResUtil.a(paramApolloDress.faceData));
  }
  
  private boolean needDownloadRoleRes(ApolloDress paramApolloDress)
  {
    return (paramApolloDress.roleId > 0) && (!CMResUtil.b(paramApolloDress.roleId));
  }
  
  private boolean optActionConfigJson(String paramString, ApolloActionData paramApolloActionData)
  {
    int j = 0;
    if (paramString != null) {
      if (paramApolloActionData == null) {
        return false;
      }
    }
    for (;;)
    {
      boolean bool3;
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        bool1 = paramString.has("audio");
        if (bool1) {
          try
          {
            paramApolloActionData.hasSound = paramString.optJSONObject("audio").optBoolean("hasSound");
            bool3 = true;
          }
          catch (Exception paramString)
          {
            bool3 = true;
            break label604;
          }
        } else {
          bool3 = false;
        }
        bool1 = bool3;
        try
        {
          if (paramString.has("vibrate")) {
            bool1 = true;
          }
          bool3 = bool1;
          Object localObject = paramString.optJSONArray("vibrate");
          if (localObject != null)
          {
            bool3 = bool1;
            StringBuilder localStringBuilder = new StringBuilder(50);
            i = 0;
            bool3 = bool1;
            if (i < ((JSONArray)localObject).length())
            {
              bool3 = bool1;
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              if (localJSONObject == null) {
                break label623;
              }
              bool3 = bool1;
              int k = localJSONObject.optInt("time");
              bool3 = bool1;
              int m = localJSONObject.optInt("duration");
              bool3 = bool1;
              localStringBuilder.append(k);
              bool3 = bool1;
              localStringBuilder.append(",");
              bool3 = bool1;
              localStringBuilder.append(m);
              bool3 = bool1;
              if (i >= ((JSONArray)localObject).length() - 1) {
                break label623;
              }
              bool3 = bool1;
              localStringBuilder.append(",");
              break label623;
            }
            bool3 = bool1;
            paramApolloActionData.vibrate = localStringBuilder.toString();
          }
          boolean bool2 = bool1;
          bool3 = bool1;
          if (paramString.has("bubbleText")) {
            bool2 = true;
          }
          bool3 = bool2;
          paramString = paramString.optJSONArray("bubbleText");
          if (paramString != null)
          {
            bool3 = bool2;
            localObject = new StringBuilder(50);
            i = j;
            bool3 = bool2;
            if (i < paramString.length())
            {
              bool3 = bool2;
              ((StringBuilder)localObject).append(paramString.getString(i));
              bool3 = bool2;
              if (i >= paramString.length() - 1) {
                break label630;
              }
              bool3 = bool2;
              ((StringBuilder)localObject).append("@$");
              break label630;
            }
            bool3 = bool2;
            paramApolloActionData.bubbleText = ((StringBuilder)localObject).toString();
          }
          bool3 = bool2;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break label618;
          }
          bool3 = bool2;
          if (!paramApolloActionData.hasSound)
          {
            bool3 = bool2;
            if (TextUtils.isEmpty(paramApolloActionData.vibrate))
            {
              bool3 = bool2;
              bool1 = bool2;
              if (TextUtils.isEmpty(paramApolloActionData.bubbleText)) {
                break label618;
              }
            }
          }
          bool3 = bool2;
          paramString = new StringBuilder();
          bool3 = bool2;
          paramString.append("action id ");
          bool3 = bool2;
          paramString.append(paramApolloActionData.actionId);
          bool3 = bool2;
          paramString.append(", name: ");
          bool3 = bool2;
          paramString.append(paramApolloActionData.actionName);
          bool3 = bool2;
          paramString.append(", hasSound: ");
          bool3 = bool2;
          paramString.append(paramApolloActionData.hasSound);
          bool3 = bool2;
          paramString.append(", vibrate=");
          bool3 = bool2;
          paramString.append(paramApolloActionData.vibrate);
          bool3 = bool2;
          paramString.append(", bubbleText =");
          bool3 = bool2;
          paramString.append(paramApolloActionData.bubbleText);
          bool3 = bool2;
          QLog.d("[cmshow]cm_res", 2, paramString.toString());
          return bool2;
        }
        catch (Exception paramString) {}
        QLog.e("[cmshow]cm_res", 1, "parse action config.json error", paramString);
      }
      catch (Exception paramString)
      {
        bool3 = false;
      }
      label604:
      boolean bool1 = bool3;
      label618:
      return bool1;
      return false;
      label623:
      i += 1;
      continue;
      label630:
      i += 1;
    }
  }
  
  private void parseActionConfigJson(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) && (!FileUtils.fileExists(CMGetResPathUtil.a(paramApolloActionData, 7)))) {
      return;
    }
    if (optActionConfigJson(FileUtils.readFileContent(new File(CMGetResPathUtil.a(paramApolloActionData, 7))), paramApolloActionData))
    {
      AppInterface localAppInterface = this.mApp;
      if (localAppInterface != null) {
        ((ApolloDaoManagerServiceImpl)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).updateAction(paramApolloActionData);
      }
    }
  }
  
  private void parseActionInfo(List<ApolloActionData> paramList, List<ApolloActionPackage> paramList1, List<ApolloActionPackageData> paramList2, List<ApolloActionTag> paramList3, JSONObject paramJSONObject)
  {
    Object localObject10 = this;
    Object localObject2 = "limitFree";
    Object localObject8 = "icon";
    Object localObject1 = "[cmshow]cm_res";
    Object localObject3 = localObject1;
    for (;;)
    {
      Object localObject5;
      Object localObject4;
      int i;
      int j;
      int k;
      try
      {
        Object localObject11 = new ArrayList();
        localObject5 = "name";
        localObject4 = "use";
        if (paramJSONObject == null) {
          break label2908;
        }
        localObject3 = localObject1;
        if (!paramJSONObject.has("data")) {
          break label2908;
        }
        localObject3 = localObject1;
        Object localObject9 = paramJSONObject.getJSONArray("data");
        if (localObject9 == null) {
          break label2908;
        }
        localObject3 = localObject1;
        i = ((JSONArray)localObject9).length();
        j = 0;
        localObject3 = localObject1;
        localObject6 = localObject4;
        localObject7 = localObject5;
        Object localObject13;
        Object localObject12;
        if (j < i)
        {
          localObject3 = localObject1;
          localObject13 = ((JSONArray)localObject9).getJSONObject(j);
          if (localObject13 == null) {
            break label2899;
          }
          localObject3 = localObject1;
          localObject12 = new ApolloActionData();
          localObject3 = localObject1;
          ((ApolloActionData)localObject12).actionId = ((JSONObject)localObject13).getInt("id");
          localObject3 = localObject1;
          ((ApolloActionData)localObject12).sessionType = ((JSONObject)localObject13).optInt((String)localObject4);
          localObject3 = localObject1;
          ((ApolloActionData)localObject12).actionName = ((JSONObject)localObject13).getString((String)localObject5);
          localObject3 = localObject1;
          ((ApolloActionData)localObject12).vipLevel = ((JSONObject)localObject13).optInt("vipLevel");
          localObject6 = localObject1;
          localObject3 = localObject6;
        }
        try
        {
          ((ApolloActionData)localObject12).feeType = ((JSONObject)localObject13).optInt("feeType", 1);
          localObject3 = localObject6;
          if (((JSONObject)localObject13).has((String)localObject8))
          {
            localObject3 = localObject6;
            ((ApolloActionData)localObject12).icon = ((JSONObject)localObject13).getInt((String)localObject8);
          }
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).iconUrl = ((JSONObject)localObject13).optString("iconUrl");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).personNum = ((JSONObject)localObject13).getInt("type");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).anmiName = ((JSONObject)localObject13).optString("animationName");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).isShow = ((JSONObject)localObject13).optInt("isShow");
          localObject3 = localObject6;
          if (((ApolloResManagerImpl)localObject10).isTest3DAction((ApolloActionData)localObject12))
          {
            localObject3 = localObject6;
            ((ApolloActionData)localObject12).isForPlayerAction = 1;
          }
          else
          {
            localObject3 = localObject6;
            ((ApolloActionData)localObject12).isForPlayerAction = ((JSONObject)localObject13).optInt("isForPlayerAction");
          }
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).textImg = ((JSONObject)localObject13).optString("textImg");
          localObject3 = localObject6;
          if (!((JSONObject)localObject13).has((String)localObject2)) {
            break label2866;
          }
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).limitFree = ((JSONObject)localObject13).getInt((String)localObject2);
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).limitStart = ((JSONObject)localObject13).getLong("begin");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).limitEnd = ((JSONObject)localObject13).getLong("end");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).startTime = ((JSONObject)localObject13).optLong("startTime");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).endTime = ((JSONObject)localObject13).optLong("endTime");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).url = ((JSONObject)localObject13).optString("activeUrl");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).version = ((JSONObject)localObject13).getLong("version");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).actionMoveDis = ((float)((JSONObject)localObject13).optDouble("actionDis", 0.0D));
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).peerMoveDis = ((float)((JSONObject)localObject13).optDouble("actionPeerDis", 0.0D));
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).compoundType = ((JSONObject)localObject13).optInt("actionSubType");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).playArea = ((JSONObject)localObject13).optInt("posType");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).actionType = ((JSONObject)localObject13).optInt("actionType");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).slaveActionId = ((JSONObject)localObject13).optInt("slaveActionId");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).currencyType = ((JSONObject)localObject13).optInt("currencyType");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).currencyNum = ((JSONObject)localObject13).optInt("currencyNum");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).description = ((JSONObject)localObject13).optString("description");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).extraWording = ((JSONObject)localObject13).optString("extraWording");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).minVer = ((JSONObject)localObject13).optString("minVer");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).maxVer = ((JSONObject)localObject13).optString("maxVer");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).gameId = ((JSONObject)localObject13).optInt("gameId");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).gameName = ((JSONObject)localObject13).optString("gameName");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).activeValue = ((JSONObject)localObject13).optInt("activeValue");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).soundURL = ((JSONObject)localObject13).optString("soundURL");
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).soundType = ((JSONObject)localObject13).optInt("soundType");
          localObject3 = localObject6;
          localObject7 = ((JSONObject)localObject13).optJSONArray("pkIds");
          localObject3 = localObject6;
          JSONArray localJSONArray = ((JSONObject)localObject13).optJSONArray("pk3DIds");
          if (localObject7 == null) {
            break label2878;
          }
          localObject3 = localObject6;
          int m = ((JSONArray)localObject7).length();
          localObject3 = localObject6;
          StringBuilder localStringBuilder = new StringBuilder();
          k = 0;
          if (k < m)
          {
            localObject3 = localObject6;
            localStringBuilder.append(String.valueOf(((JSONArray)localObject7).get(k)));
            if (k == m - 1) {
              break label2869;
            }
            localObject3 = localObject6;
            localStringBuilder.append(",");
            break label2869;
          }
          localObject3 = localObject6;
          ((ApolloActionData)localObject12).pkIds = localStringBuilder.toString();
          localObject7 = localObject2;
          if (localJSONArray != null)
          {
            localObject3 = localObject6;
            m = localJSONArray.length();
            localObject3 = localObject6;
            localObject2 = new StringBuilder();
            k = 0;
            if (k < m)
            {
              localObject3 = localObject6;
              ((StringBuilder)localObject2).append(String.valueOf(localJSONArray.get(k)));
              if (k == m - 1) {
                break label2881;
              }
              localObject3 = localObject6;
              ((StringBuilder)localObject2).append(",");
              break label2881;
            }
            localObject3 = localObject6;
            ((ApolloActionData)localObject12).pk3DIds = ((StringBuilder)localObject2).toString();
          }
          localObject3 = localObject6;
          localObject2 = ((JSONObject)localObject13).optJSONArray("keywords");
          if (localObject2 != null)
          {
            localObject3 = localObject6;
            m = ((JSONArray)localObject2).length();
            localObject3 = localObject6;
            localObject13 = new StringBuilder();
            k = 0;
            if (k < m)
            {
              localObject3 = localObject6;
              ((StringBuilder)localObject13).append(String.valueOf(((JSONArray)localObject2).get(k)));
              if (k == m - 1) {
                break label2890;
              }
              localObject3 = localObject6;
              ((StringBuilder)localObject13).append(",");
              break label2890;
            }
            localObject3 = localObject6;
            ((ApolloActionData)localObject12).keywords = ((StringBuilder)localObject13).toString();
          }
          localObject3 = localObject6;
          localObject2 = (ApolloManagerServiceImpl)((ApolloResManagerImpl)localObject10).mApp.getRuntimeService(IApolloManagerService.class, "all");
          localObject3 = localObject6;
          if (((ApolloManagerServiceImpl)localObject2).mUserActionId != null)
          {
            localObject3 = localObject6;
            if (((ApolloManagerServiceImpl)localObject2).mUserActionId.containsKey(Integer.valueOf(((ApolloActionData)localObject12).actionId)))
            {
              localObject3 = localObject6;
              if (((ApolloActionData)localObject12).isShow == 0)
              {
                localObject3 = localObject6;
                ((ApolloActionData)localObject12).isShow = 1;
              }
              localObject3 = localObject6;
              ApolloUtilImpl.updateObtainedAction((ApolloActionData)localObject12, (Bundle)((ApolloManagerServiceImpl)localObject2).mUserActionId.get(Integer.valueOf(((ApolloActionData)localObject12).actionId)));
            }
          }
          localObject3 = localObject6;
          ((ApolloResManagerImpl)localObject10).checkActionVersion((ApolloActionData)localObject12);
          localObject3 = localObject6;
          paramList.add(localObject12);
          localObject3 = localObject6;
          localObject2 = localObject7;
          if (((ApolloActionData)localObject12).feeType != 6) {
            break label2899;
          }
          localObject3 = localObject6;
          ((List)localObject11).add(localObject12);
          localObject2 = localObject7;
        }
        catch (Exception paramList)
        {
          break label2833;
        }
        localObject1 = localObject3;
        localObject2 = localObject6;
        localObject4 = localObject7;
        localObject3 = localObject1;
        if (((ApolloResManagerImpl)localObject10).mApp == null) {
          return;
        }
        localObject3 = localObject1;
        localObject9 = new ArrayList();
        localObject5 = localObject1;
        if (paramJSONObject != null)
        {
          localObject5 = localObject1;
          localObject3 = localObject1;
          if (paramJSONObject.has("packageInfo"))
          {
            localObject3 = localObject1;
            localObject6 = paramJSONObject.getJSONArray("packageInfo");
            localObject5 = localObject1;
            if (localObject6 != null)
            {
              i = 0;
              localObject5 = localObject1;
              localObject3 = localObject1;
              if (i < ((JSONArray)localObject6).length())
              {
                localObject3 = localObject1;
                localObject7 = ((JSONArray)localObject6).getJSONObject(i);
                if (localObject7 == null) {
                  break label2926;
                }
                localObject3 = localObject1;
                localObject10 = new ApolloActionPackage();
                localObject3 = localObject1;
                ((ApolloActionPackage)localObject10).packageId = ((JSONObject)localObject7).getInt("packageId");
                localObject3 = localObject1;
                ((ApolloActionPackage)localObject10).version = ((JSONObject)localObject7).optInt("version");
                localObject3 = localObject1;
                ((ApolloActionPackage)localObject10).startVersion = ((JSONObject)localObject7).optString("startVersion");
                localObject3 = localObject1;
                ((ApolloActionPackage)localObject10).endVersion = ((JSONObject)localObject7).optString("endVersion");
                localObject3 = localObject1;
                ((ApolloActionPackage)localObject10).type = ((JSONObject)localObject7).optInt("type");
                localObject3 = localObject1;
                ((ApolloActionPackage)localObject10).sessionType = ((JSONObject)localObject7).optInt((String)localObject2);
                localObject3 = localObject1;
                ((ApolloActionPackage)localObject10).name = ((JSONObject)localObject7).optString((String)localObject4);
                localObject3 = localObject1;
                ((ApolloActionPackage)localObject10).mIconUnselectedUrl = ((JSONObject)localObject7).optString("apImg");
                localObject3 = localObject1;
                ((ApolloActionPackage)localObject10).mIconSelectedUrl = ((JSONObject)localObject7).optString("apcImg");
                localObject3 = localObject1;
                if (!ApolloUtilImpl.verifyActionPackageVersion((ApolloActionPackage)localObject10, "8.7.0"))
                {
                  localObject3 = localObject1;
                  localObject5 = new StringBuilder();
                  localObject3 = localObject1;
                  ((StringBuilder)localObject5).append("version not correct packageId=");
                  localObject3 = localObject1;
                  ((StringBuilder)localObject5).append(((ApolloActionPackage)localObject10).packageId);
                  localObject3 = localObject1;
                  localObject7 = ((StringBuilder)localObject5).toString();
                  localObject5 = localObject1;
                  localObject3 = localObject5;
                }
              }
            }
          }
        }
        try
        {
          QLog.w((String)localObject5, 1, (String)localObject7);
        }
        catch (Exception paramList)
        {
          break label2833;
        }
        localObject5 = localObject1;
        localObject3 = localObject5;
        checkPackageRedDots((ApolloActionPackage)localObject10, paramList);
        localObject3 = localObject5;
        if (QLog.isColorLevel())
        {
          localObject3 = localObject5;
          localObject8 = new StringBuilder();
          localObject3 = localObject5;
          ((StringBuilder)localObject8).append("ActionPackage pid = ");
          localObject3 = localObject5;
          ((StringBuilder)localObject8).append(((ApolloActionPackage)localObject10).packageId);
          localObject3 = localObject5;
          ((StringBuilder)localObject8).append(" actionPackage.isUpdate = ");
          localObject3 = localObject5;
          ((StringBuilder)localObject8).append(((ApolloActionPackage)localObject10).isUpdate);
          localObject3 = localObject5;
          QLog.d((String)localObject5, 2, ((StringBuilder)localObject8).toString());
        }
        localObject3 = localObject5;
        paramList1.add(localObject10);
        localObject3 = localObject5;
        if (!QLog.isColorLevel()) {
          break label2923;
        }
        localObject3 = localObject5;
        localObject8 = new StringBuilder();
        localObject3 = localObject5;
        ((StringBuilder)localObject8).append("add actionPackage pid=");
        localObject3 = localObject5;
        ((StringBuilder)localObject8).append(((ApolloActionPackage)localObject10).packageId);
        localObject3 = localObject5;
        QLog.d((String)localObject5, 2, ((StringBuilder)localObject8).toString());
        localObject3 = localObject5;
        localObject8 = ((JSONObject)localObject7).optJSONArray("actionSet");
        if (localObject8 != null)
        {
          localObject3 = localObject5;
          if (((JSONArray)localObject8).length() > 0)
          {
            localObject3 = localObject5;
            localObject11 = new StringBuilder();
            localObject7 = localObject2;
            j = 0;
            localObject2 = localObject8;
            localObject3 = localObject5;
            if (j < ((JSONArray)localObject2).length())
            {
              localObject3 = localObject5;
              localObject12 = ((JSONArray)localObject2).getJSONObject(j);
              localObject3 = localObject5;
              localObject8 = new ApolloActionPackageData();
              localObject3 = localObject5;
              ((ApolloActionPackageData)localObject8).packageId = ((ApolloActionPackage)localObject10).packageId;
              localObject3 = localObject5;
              ((ApolloActionPackageData)localObject8).acitonId = ((JSONObject)localObject12).optInt("actionId");
              localObject3 = localObject5;
              ((ApolloActionPackageData)localObject8).text = ((JSONObject)localObject12).optString("text");
              localObject3 = localObject5;
              ((ApolloActionPackageData)localObject8).textType = ((JSONObject)localObject12).optInt("textType");
              localObject3 = localObject5;
              if (checkPackageAction(((ApolloActionPackageData)localObject8).acitonId, paramList))
              {
                localObject3 = localObject5;
                paramList2.add(localObject8);
                localObject3 = localObject5;
                if (((ApolloActionPackageData)localObject8).packageId == 5)
                {
                  localObject3 = localObject5;
                  ((List)localObject9).add(Integer.valueOf(((ApolloActionPackageData)localObject8).acitonId));
                }
              }
              else
              {
                localObject3 = localObject5;
                if (QLog.isColorLevel())
                {
                  localObject3 = localObject5;
                  localObject12 = new StringBuilder();
                  localObject3 = localObject5;
                  ((StringBuilder)localObject12).append("action list has not packageAction id=");
                  localObject3 = localObject5;
                  ((StringBuilder)localObject12).append(((ApolloActionPackageData)localObject8).acitonId);
                  localObject3 = localObject5;
                  QLog.d((String)localObject5, 2, ((StringBuilder)localObject12).toString());
                }
              }
              localObject3 = localObject5;
              ((StringBuilder)localObject11).append(((ApolloActionPackageData)localObject8).acitonId);
              localObject3 = localObject5;
              ((StringBuilder)localObject11).append(" ");
              j += 1;
              continue;
            }
            localObject8 = localObject4;
            localObject3 = localObject5;
            localObject4 = localObject8;
            localObject2 = localObject7;
            if (!QLog.isColorLevel()) {
              break label2926;
            }
            localObject3 = localObject5;
            QLog.d((String)localObject5, 2, new Object[] { "addActionPackageData packageId=", Integer.valueOf(((ApolloActionPackage)localObject10).packageId), " actionId=[", ((StringBuilder)localObject11).toString(), "]" });
            localObject4 = localObject8;
            localObject2 = localObject7;
            break label2926;
          }
        }
        localObject7 = localObject2;
        localObject8 = localObject4;
        localObject3 = localObject5;
        localObject4 = localObject8;
        localObject2 = localObject7;
        if (((ApolloActionPackage)localObject10).type == 2) {
          break label2926;
        }
        localObject3 = localObject5;
        localObject4 = localObject8;
        localObject2 = localObject7;
        if (((ApolloActionPackage)localObject10).packageId == 8) {
          break label2926;
        }
        localObject3 = localObject5;
        localObject4 = localObject8;
        localObject2 = localObject7;
        if (((ApolloActionPackage)localObject10).packageId == 10) {
          break label2926;
        }
        localObject3 = localObject5;
        localObject4 = localObject8;
        localObject2 = localObject7;
        if (((ApolloActionPackage)localObject10).packageId == 302) {
          break label2926;
        }
        localObject3 = localObject5;
        paramList1.remove(localObject10);
        localObject4 = localObject8;
        localObject2 = localObject7;
        break label2926;
        localObject3 = localObject5;
        if (QLog.isColorLevel())
        {
          localObject3 = localObject5;
          QLog.d((String)localObject5, 2, new Object[] { "[parseActionInfo] world action list=", localObject9 });
        }
        localObject3 = localObject5;
        if ((((List)localObject9).size() > 0) && (paramList != null))
        {
          localObject3 = localObject5;
          if (paramList.size() > 0)
          {
            localObject3 = localObject5;
            paramList = paramList.iterator();
            localObject3 = localObject5;
            if (paramList.hasNext())
            {
              localObject3 = localObject5;
              paramList1 = (ApolloActionData)paramList.next();
              localObject3 = localObject5;
              if (((List)localObject9).contains(Integer.valueOf(paramList1.actionId)))
              {
                localObject3 = localObject5;
                paramList1.hasExtraAction = true;
                continue;
              }
              localObject3 = localObject5;
              paramList1.hasExtraAction = false;
              continue;
            }
          }
        }
        if (paramJSONObject != null)
        {
          localObject3 = localObject5;
          if (paramJSONObject.has("actionTag"))
          {
            localObject3 = localObject5;
            paramList = paramJSONObject.getJSONArray("actionTag");
            if (paramList != null)
            {
              i = 0;
              localObject3 = localObject5;
              if (i < paramList.length())
              {
                localObject3 = localObject5;
                paramJSONObject = paramList.getJSONObject(i);
                if (paramJSONObject == null) {
                  break label2935;
                }
                localObject3 = localObject5;
                paramList1 = paramJSONObject.optJSONArray("actionList");
                localObject3 = localObject5;
                paramList2 = paramJSONObject.getString("tagName");
                localObject3 = localObject5;
                k = paramJSONObject.getInt("packageId");
                j = 0;
                localObject3 = localObject5;
                if (j >= paramList1.length()) {
                  break label2935;
                }
                localObject3 = localObject5;
                paramJSONObject = new ApolloActionTag();
                localObject3 = localObject5;
                paramJSONObject.tagName = paramList2;
                localObject3 = localObject5;
                paramJSONObject.packageId = k;
                localObject3 = localObject5;
                paramJSONObject.actionId = paramList1.getInt(j);
                localObject3 = localObject5;
                paramList3.add(paramJSONObject);
                j += 1;
                continue;
              }
            }
          }
        }
        localObject3 = localObject5;
        if (!QLog.isColorLevel()) {
          break label2865;
        }
        localObject3 = localObject5;
        QLog.d((String)localObject5, 2, new Object[] { "[parseActionInfo] apolloActionTagList = ", paramList3 });
        return;
      }
      catch (Exception paramList) {}
      label2833:
      paramList1 = new StringBuilder();
      paramList1.append("parse ActionInfo error:");
      paramList1.append(paramList);
      QLog.e(localObject3, 1, paramList1.toString());
      label2865:
      return;
      label2866:
      continue;
      label2869:
      k += 1;
      continue;
      label2878:
      continue;
      label2881:
      k += 1;
      continue;
      label2890:
      k += 1;
      continue;
      label2899:
      j += 1;
      continue;
      label2908:
      localObject3 = localObject1;
      Object localObject6 = localObject4;
      Object localObject7 = localObject5;
      continue;
      label2923:
      continue;
      label2926:
      i += 1;
      continue;
      label2935:
      i += 1;
    }
  }
  
  private void parseWhiteFaceIdMapping(JSONObject paramJSONObject, List<ApolloWhiteFaceID> paramList)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("IDMap");
        if (paramJSONObject != null) {
          break label114;
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        JSONObject localJSONObject;
        ApolloWhiteFaceID localApolloWhiteFaceID;
        QLog.e("[cmshow]cm_res", 1, "parseWhiteFaceIdMapping:", paramJSONObject);
      }
      if (i < paramJSONObject.length())
      {
        localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null)
        {
          localApolloWhiteFaceID = new ApolloWhiteFaceID();
          localApolloWhiteFaceID.terminalId = localJSONObject.optInt("terminalID");
          localApolloWhiteFaceID.action2d = localJSONObject.optInt("action2D");
          localApolloWhiteFaceID.action3d = localJSONObject.optInt("action3D");
          paramList.add(localApolloWhiteFaceID);
        }
        i += 1;
      }
      else
      {
        return;
        label114:
        i = 0;
      }
    }
  }
  
  /* Error */
  private boolean unzipInnerRsc()
  {
    // Byte code:
    //   0: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: new 200	java/io/File
    //   7: dup
    //   8: getstatic 1219	com/tencent/mobileqq/apollo/utils/ApolloConstant:a	Ljava/lang/String;
    //   11: ldc_w 1221
    //   14: invokespecial 1224	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: invokevirtual 1227	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokestatic 1230	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   23: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   26: lstore 4
    //   28: aload_0
    //   29: invokestatic 775	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   32: invokevirtual 1234	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   35: ldc_w 1236
    //   38: ldc_w 1238
    //   41: invokespecial 1240	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:copyFilesFassets	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   47: lstore 6
    //   49: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +43 -> 95
    //   55: new 256	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   62: astore 8
    //   64: aload 8
    //   66: ldc_w 1242
    //   69: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 8
    //   75: lload 6
    //   77: lload 4
    //   79: lsub
    //   80: invokevirtual 1245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: ldc 59
    //   86: iconst_2
    //   87: aload 8
    //   89: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: new 200	java/io/File
    //   98: dup
    //   99: getstatic 1219	com/tencent/mobileqq/apollo/utils/ApolloConstant:a	Ljava/lang/String;
    //   102: ldc_w 1247
    //   105: invokespecial 1224	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: invokevirtual 510	java/io/File:mkdirs	()Z
    //   111: pop
    //   112: invokestatic 775	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   115: invokevirtual 1234	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   118: astore 8
    //   120: new 256	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   127: astore 9
    //   129: aload 9
    //   131: getstatic 1219	com/tencent/mobileqq/apollo/utils/ApolloConstant:a	Ljava/lang/String;
    //   134: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 9
    //   140: ldc_w 1249
    //   143: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 8
    //   149: ldc_w 1238
    //   152: aload 9
    //   154: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 1254	com/tencent/mobileqq/vas/LzmaUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I
    //   160: istore_1
    //   161: ldc_w 1238
    //   164: invokestatic 1257	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   167: pop
    //   168: iload_1
    //   169: ifne +60 -> 229
    //   172: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +52 -> 227
    //   178: new 256	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   185: astore 8
    //   187: aload 8
    //   189: ldc_w 1259
    //   192: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 8
    //   198: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   201: lload_2
    //   202: lsub
    //   203: invokevirtual 1245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 8
    //   209: ldc_w 1261
    //   212: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc 59
    //   218: iconst_2
    //   219: aload 8
    //   221: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iconst_1
    //   228: ireturn
    //   229: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +52 -> 284
    //   235: new 256	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   242: astore 8
    //   244: aload 8
    //   246: ldc_w 1259
    //   249: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 8
    //   255: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   258: lload_2
    //   259: lsub
    //   260: invokevirtual 1245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 8
    //   266: ldc_w 1261
    //   269: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: ldc 59
    //   275: iconst_2
    //   276: aload 8
    //   278: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: iconst_0
    //   285: ireturn
    //   286: astore 8
    //   288: goto +102 -> 390
    //   291: astore 8
    //   293: new 256	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   300: astore 9
    //   302: aload 9
    //   304: ldc_w 546
    //   307: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 9
    //   313: aload 8
    //   315: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: ldc 59
    //   324: iconst_1
    //   325: aload 9
    //   327: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +52 -> 388
    //   339: new 256	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   346: astore 8
    //   348: aload 8
    //   350: ldc_w 1259
    //   353: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 8
    //   359: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   362: lload_2
    //   363: lsub
    //   364: invokevirtual 1245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 8
    //   370: ldc_w 1261
    //   373: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: ldc 59
    //   379: iconst_2
    //   380: aload 8
    //   382: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: iconst_0
    //   389: ireturn
    //   390: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +52 -> 445
    //   396: new 256	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   403: astore 9
    //   405: aload 9
    //   407: ldc_w 1259
    //   410: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 9
    //   416: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   419: lload_2
    //   420: lsub
    //   421: invokevirtual 1245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 9
    //   427: ldc_w 1261
    //   430: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: ldc 59
    //   436: iconst_2
    //   437: aload 9
    //   439: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload 8
    //   447: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	ApolloResManagerImpl
    //   160	9	1	i	int
    //   3	417	2	l1	long
    //   26	52	4	l2	long
    //   47	29	6	l3	long
    //   62	215	8	localObject1	Object
    //   286	1	8	localObject2	Object
    //   291	23	8	localException	Exception
    //   346	100	8	localStringBuilder1	StringBuilder
    //   127	311	9	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   23	95	286	finally
    //   95	168	286	finally
    //   293	333	286	finally
    //   23	95	291	java/lang/Exception
    //   95	168	291	java/lang/Exception
  }
  
  public void addDownLoadListener(IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener != null) {}
    try
    {
      if (this.mListenerManager != null) {
        this.mListenerManager.a(paramIResDownloadListener);
      }
    }
    finally {}
  }
  
  public void checkApolloPanelJsonCfg(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkApolloPanelJsonCfg begin...");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",task:");
      localStringBuilder.append(paramInt);
      QLog.d("[cmshow]cm_res", 2, localStringBuilder.toString());
    }
    if ((!paramBoolean) && (((paramInt & 0x1) != 1) || (FileUtil.b("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"))))
    {
      ApolloUtilImpl.checkJsonParse(this.mApp);
      return;
    }
    downloadJson(paramInt);
    paramString = new StringBuilder();
    paramString.append("checkApolloPanelJsonCfg download json  forceDownload is: ");
    paramString.append(paramBoolean);
    QLog.d("[cmshow]cm_res", 1, paramString.toString());
  }
  
  public void checkCompat2DActionRsc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]cm_res", 2, "[checkCompat2DActionRsc]");
    }
    Object localObject = this.mApp;
    if (localObject == null) {
      return;
    }
    localObject = (ApolloDaoManagerServiceImpl)((AppRuntime)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)localObject).findActionById(1450);
    if (localApolloActionData != null) {
      downloadActionIfNotExist(localApolloActionData.actionId, localApolloActionData.personNum);
    }
    localObject = ((ApolloDaoManagerServiceImpl)localObject).findActionById(1454);
    if (localObject != null) {
      downloadActionIfNotExist(((ApolloActionData)localObject).actionId, ((ApolloActionData)localObject).personNum);
    }
  }
  
  public void checkPanelActionRes(int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloResManagerImpl.9(this, paramBoolean, paramInt), 5, null, false);
  }
  
  public void checkResForGuidePanel()
  {
    Object localObject1 = this.mApp;
    if (localObject1 == null) {
      return;
    }
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject2 = localApolloDaoManagerServiceImpl.getActionByPackageId(400);
    localObject1 = localObject2;
    if (localApolloDaoManagerServiceImpl.getActionInfoById(3000059) != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject2 = new ApolloActionData();
      ((ApolloActionData)localObject2).actionId = 3000059;
      ((List)localObject1).add(localObject2);
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      downloadResAndPanel((List)localObject1, "apollo_key");
    }
  }
  
  public boolean downloadApolloRes(ApolloActionData paramApolloActionData, int paramInt, IResDownloadListener paramIResDownloadListener)
  {
    if (paramApolloActionData == null) {
      return false;
    }
    if (Utils.a())
    {
      if (Utils.b() < 1048576L)
      {
        paramIResDownloadListener = new StringBuilder();
        paramIResDownloadListener.append("1sdcardcheck,sdcard full .return. aid=");
        paramIResDownloadListener.append(paramApolloActionData.actionId);
        QLog.e("[cmshow]cm_res", 1, paramIResDownloadListener.toString());
        return false;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start download action res actionId:");
        ((StringBuilder)localObject1).append(paramApolloActionData.actionId);
        QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2;
      int i;
      if ((paramInt & 0x1) == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start download action panelpic aid=");
          ((StringBuilder)localObject1).append(paramApolloActionData.actionId);
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = CMGetResPathUtil.a(paramApolloActionData, 1);
        localObject2 = CMGetResPathUtil.a(paramApolloActionData, 0);
        if (!FileUtils.fileExists((String)localObject2))
        {
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject1).f = "apollo_res";
          ((DownloadTask)localObject1).b = 1;
          ((DownloadTask)localObject1).n = true;
          ((DownloadTask)localObject1).q = true;
          ((DownloadTask)localObject1).r = true;
          i = DownloaderFactory.a((DownloadTask)localObject1, this.mApp);
          if (i != 0) {
            return false;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ret:");
            ((StringBuilder)localObject1).append(i);
            QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start download action gif aid=");
          ((StringBuilder)localObject1).append(paramApolloActionData.actionId);
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = CMGetResPathUtil.a(paramApolloActionData, 3);
        localObject2 = CMGetResPathUtil.a(paramApolloActionData, 2);
        if (!FileUtils.fileExists((String)localObject2))
        {
          localObject1 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject1).f = "apollo_res";
          ((DownloadTask)localObject1).n = true;
          i = DownloaderFactory.a((DownloadTask)localObject1, this.mApp);
          if (i != 0) {
            return false;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("ret:");
            ((StringBuilder)localObject1).append(i);
            QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
      if ((paramInt & 0x4) == 4)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("start download action zip actionId:");
          ((StringBuilder)localObject1).append(paramApolloActionData.actionId);
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = CMGetResPathUtil.a(paramApolloActionData, 5);
        localObject2 = CMGetResPathUtil.a(paramApolloActionData, 4);
        boolean bool2 = CMResUtil.a(paramApolloActionData.actionId, paramApolloActionData.personNum);
        boolean bool1 = bool2;
        if (paramApolloActionData.isForPlayerAction == 1) {
          bool1 = bool2 & CMResUtil.b(paramApolloActionData.actionId, paramApolloActionData.personNum);
        }
        if (!bool1)
        {
          Object localObject3 = new DownloadTask((String)localObject1, new File((String)localObject2));
          ((DownloadTask)localObject3).f = "apollo_res";
          ((DownloadTask)localObject3).b = 1;
          ((DownloadTask)localObject3).n = true;
          ((DownloadTask)localObject3).q = true;
          ((DownloadTask)localObject3).r = true;
          paramInt = DownloaderFactory.a((DownloadTask)localObject3, this.mApp);
          if (paramInt == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("download actionId:");
          ((StringBuilder)localObject3).append(paramApolloActionData.actionId);
          ((StringBuilder)localObject3).append(", url:");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(", success:");
          ((StringBuilder)localObject3).append(bool1);
          ((StringBuilder)localObject3).append(", ret:");
          ((StringBuilder)localObject3).append(paramInt);
          QLog.d("[cmshow]cm_res", 1, ((StringBuilder)localObject3).toString());
          if (!bool1) {
            return false;
          }
          try
          {
            FileUtils.uncompressZip((String)localObject2, CMGetResPathUtil.a(paramApolloActionData, 6), false);
            FileUtils.deleteFile((String)localObject2);
            parseActionConfigJson(paramApolloActionData);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("uncompresszip error");
              ((StringBuilder)localObject2).append(localException.toString());
              QLog.e("[cmshow]cm_res", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
      }
      if (paramIResDownloadListener != null)
      {
        if (!CMResUtil.a(paramApolloActionData.actionId, paramApolloActionData.personNum))
        {
          if (QLog.isColorLevel()) {
            QLog.e("[cmshow]cm_res", 2, "download finished, but rsc NOT complete.");
          }
          return false;
        }
        paramIResDownloadListener.b(paramApolloActionData);
      }
      return true;
    }
    paramIResDownloadListener = new StringBuilder();
    paramIResDownloadListener.append("1sdcardcheck,has sdcard FALSE .return. aid=");
    paramIResDownloadListener.append(paramApolloActionData.actionId);
    QLog.e("[cmshow]cm_res", 1, paramIResDownloadListener.toString());
    return false;
  }
  
  public void downloadFileBy304(String paramString1, String paramString2, Download403Callback paramDownload403Callback)
  {
    AppInterface localAppInterface = this.mApp;
    if ((localAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      DownloaderInterface localDownloaderInterface = getDownloader();
      if (localDownloaderInterface == null) {
        return;
      }
      if (localDownloaderInterface.getTask(paramString1) != null) {
        return;
      }
      File localFile = new File(paramString2);
      paramString2 = new DownloadTask(paramString1, localFile);
      if (localFile.exists())
      {
        SharedPreferences localSharedPreferences = localAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_lastModifiedTime");
        paramString2.i = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
        long l = localSharedPreferences.getLong(paramString1, 0L);
        if (localFile.lastModified() != l) {
          paramString2.m = true;
        }
      }
      paramString2.p = true;
      paramString2.j = true;
      paramString2.n = true;
      paramString2.s = false;
      paramString2.f = "apollo_res";
      paramString2.r = true;
      paramString2.q = true;
      paramString1 = new Bundle();
      localDownloaderInterface.startDownload(paramString2, new ApolloResManagerImpl.Download403Listener(localAppInterface, paramDownload403Callback), paramString1);
    }
  }
  
  public void downloadJson(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[downloadJson], task:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject1 = new Bundle();
    int i = paramInt & 0x1;
    if (i == 1)
    {
      ((List)localObject2).add("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json");
      ((List)localObject3).add("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json");
      localHashMap.put("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"));
      ((Bundle)localObject1).putInt("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json", 1);
    }
    if (getDownloader() == null) {
      return;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("apollo_json_task");
    ((StringBuilder)localObject3).append(System.currentTimeMillis());
    localObject2 = new DownloadTask((List)localObject2, localHashMap, ((StringBuilder)localObject3).toString());
    ((DownloadTask)localObject2).p = true;
    ((DownloadTask)localObject2).j = false;
    ((DownloadTask)localObject2).n = true;
    ((DownloadTask)localObject2).s = false;
    ((DownloadTask)localObject2).f = "apollo_res";
    ((DownloadTask)localObject2).r = true;
    ((DownloadTask)localObject2).q = true;
    getDownloader().startDownload((DownloadTask)localObject2, this.jsonListener, (Bundle)localObject1);
    if (i == 1) {
      VipUtils.a(this.mApp, "cmshow", "Apollo", "json_download_begin", 0, 0, new String[0]);
    }
    if ((paramInt & 0x2) == 2) {
      VipUtils.a(this.mApp, "cmshow", "Apollo", "json_download_begin", 1, 0, new String[0]);
    }
  }
  
  public void downloadResAndPanel(List<ApolloActionData> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Bundle localBundle = new Bundle();
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      addApolloActionTask(localArrayList, localHashMap, paramList, localBundle);
      if (localBundle.size() == 0) {
        return;
      }
      paramList = new DownloadTask(localArrayList, localHashMap, paramString);
      paramList.n = true;
      paramList.f = "apollo_res";
      paramList.p = true;
      paramList.s = false;
      paramList.r = true;
      paramList.q = true;
      if (localArrayList.size() == 0)
      {
        QLog.e("[cmshow]cm_res", 1, "downloadResAndPanel taskUrl.size() == 0");
        return;
      }
      if (getDownloader() == null) {
        return;
      }
      VipUtils.a(this.mApp, "cmshow", "Apollo", "action_download_begin", 0, 0, new String[0]);
      getDownloader().startDownload(paramList, this.listener, localBundle);
    }
  }
  
  public void getApolloDressInfo(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList, IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener)
  {
    if (((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.size() == 0) || (paramApolloDressInfoListener == null)) && (paramApolloDressInfoListener != null)) {
      paramApolloDressInfoListener.a(null, "parameter error", -5001);
    }
    ThreadManager.getSubThreadHandler().post(new ApolloResManagerImpl.6(this, paramArrayList, paramApolloDressInfoListener, paramQQAppInterface));
  }
  
  public void getApolloRoleInfo(QQAppInterface paramQQAppInterface, int paramInt, IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getApolloRoleInfo roleId : ");
    localStringBuilder.append(paramInt);
    QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
    if (((paramQQAppInterface == null) || (paramInt < 0) || (paramApolloRoleInfoListener == null)) && (paramApolloRoleInfoListener != null)) {
      paramApolloRoleInfoListener.a(null, "parameter error", -5001);
    }
    ThreadManager.getSubThreadHandler().post(new ApolloResManagerImpl.7(this, paramInt, paramApolloRoleInfoListener, paramQQAppInterface));
  }
  
  public void getApolloUserDressInfo(String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" getApolloUserDressInfo requestUin : ");
    localStringBuilder.append(paramString);
    QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramApolloUserDressInfoListener != null))
    {
      ThreadManager.getSubThreadHandler().post(new ApolloResManagerImpl.2(this, paramString, paramApolloUserDressInfoListener));
      return;
    }
    if (paramApolloUserDressInfoListener != null) {
      paramApolloUserDressInfoListener.a(null, "parameter error", -5001);
    }
  }
  
  public void notifyJsonDone()
  {
    ApolloListenerManager localApolloListenerManager = this.mListenerManager;
    if (localApolloListenerManager != null) {
      localApolloListenerManager.a(Boolean.valueOf(true));
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    if (ApolloHardWareTester.a(this.mApp.getApp()))
    {
      this.mListenerManager = new ApolloListenerManager();
      checkDefaultRes();
    }
  }
  
  public void onDestroy()
  {
    sIsChecking.set(false);
  }
  
  /* Error */
  public boolean parseActionPanelJSon()
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 11
    //   3: ldc_w 1104
    //   6: astore 18
    //   8: aload 11
    //   10: getfield 87	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:mIsJsonParsing	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   13: invokevirtual 1517	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   16: istore 5
    //   18: ldc 59
    //   20: astore 8
    //   22: iload 5
    //   24: iconst_1
    //   25: if_icmpne +20 -> 45
    //   28: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +12 -> 43
    //   34: ldc 59
    //   36: iconst_2
    //   37: ldc_w 1519
    //   40: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: iconst_1
    //   44: ireturn
    //   45: aload 11
    //   47: getfield 87	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:mIsJsonParsing	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   50: iconst_1
    //   51: invokevirtual 1514	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   54: aload 11
    //   56: getfield 128	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   59: astore 17
    //   61: new 484	java/util/ArrayList
    //   64: dup
    //   65: invokespecial 485	java/util/ArrayList:<init>	()V
    //   68: astore 15
    //   70: new 484	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 485	java/util/ArrayList:<init>	()V
    //   77: astore 14
    //   79: new 484	java/util/ArrayList
    //   82: dup
    //   83: invokespecial 485	java/util/ArrayList:<init>	()V
    //   86: astore 21
    //   88: new 484	java/util/ArrayList
    //   91: dup
    //   92: invokespecial 485	java/util/ArrayList:<init>	()V
    //   95: astore 16
    //   97: new 484	java/util/ArrayList
    //   100: dup
    //   101: invokespecial 485	java/util/ArrayList:<init>	()V
    //   104: astore 22
    //   106: new 200	java/io/File
    //   109: dup
    //   110: ldc_w 1277
    //   113: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokestatic 716	com/tencent/mobileqq/utils/FileUtils:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   119: astore 12
    //   121: goto +48 -> 169
    //   124: astore 9
    //   126: new 256	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   133: astore 10
    //   135: aload 10
    //   137: ldc_w 1521
    //   140: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 10
    //   146: aload 9
    //   148: invokevirtual 1522	java/lang/Throwable:toString	()Ljava/lang/String;
    //   151: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: ldc 59
    //   157: iconst_1
    //   158: aload 10
    //   160: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aconst_null
    //   167: astore 12
    //   169: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +64 -> 236
    //   175: new 256	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   182: astore 9
    //   184: aload 9
    //   186: ldc_w 1524
    //   189: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 12
    //   195: ifnonnull +8 -> 203
    //   198: iconst_0
    //   199: istore_1
    //   200: goto +9 -> 209
    //   203: aload 12
    //   205: invokevirtual 1525	java/lang/String:length	()I
    //   208: istore_1
    //   209: aload 9
    //   211: iload_1
    //   212: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 9
    //   218: ldc_w 1527
    //   221: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 59
    //   227: iconst_2
    //   228: aload 9
    //   230: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 12
    //   238: invokestatic 406	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   241: ifeq +14 -> 255
    //   244: aload 11
    //   246: getfield 87	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:mIsJsonParsing	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   249: iconst_0
    //   250: invokevirtual 1514	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   253: iconst_0
    //   254: ireturn
    //   255: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   258: lstore 6
    //   260: aload 17
    //   262: ldc_w 476
    //   265: ldc_w 448
    //   268: invokevirtual 578	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   271: checkcast 478	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl
    //   274: astore 20
    //   276: aload 8
    //   278: astore 9
    //   280: aload 8
    //   282: astore 10
    //   284: aload 20
    //   286: getfield 1060	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mUserActionId	Ljava/util/HashMap;
    //   289: astore 13
    //   291: aload 13
    //   293: ifnull +38 -> 331
    //   296: aload 8
    //   298: astore 10
    //   300: aload 20
    //   302: getfield 1060	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mUserActionId	Ljava/util/HashMap;
    //   305: invokevirtual 1528	java/util/HashMap:size	()I
    //   308: istore_1
    //   309: iload_1
    //   310: ifle +21 -> 331
    //   313: iconst_1
    //   314: istore_1
    //   315: goto +18 -> 333
    //   318: astore 10
    //   320: aload 11
    //   322: astore 8
    //   324: ldc 59
    //   326: astore 9
    //   328: goto +1125 -> 1453
    //   331: iconst_0
    //   332: istore_1
    //   333: aload 8
    //   335: astore 9
    //   337: aload 8
    //   339: astore 10
    //   341: new 284	org/json/JSONObject
    //   344: dup
    //   345: aload 12
    //   347: invokespecial 285	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   350: astore 23
    //   352: aload 8
    //   354: astore 9
    //   356: aload 8
    //   358: astore 10
    //   360: aload 23
    //   362: ldc_w 1530
    //   365: invokevirtual 896	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   368: astore 19
    //   370: ldc_w 448
    //   373: astore 13
    //   375: iconst_0
    //   376: istore_2
    //   377: aload 18
    //   379: astore 12
    //   381: aload 17
    //   383: astore 11
    //   385: aload 19
    //   387: astore 17
    //   389: aload 8
    //   391: astore 9
    //   393: aload 8
    //   395: astore 10
    //   397: aload 17
    //   399: invokevirtual 840	org/json/JSONArray:length	()I
    //   402: istore_3
    //   403: iload_2
    //   404: iload_3
    //   405: if_icmpge +167 -> 572
    //   408: aload 17
    //   410: iload_2
    //   411: invokevirtual 859	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   414: astore 10
    //   416: aload 23
    //   418: aload 10
    //   420: invokevirtual 823	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   423: astore 9
    //   425: ldc_w 1532
    //   428: aload 10
    //   430: invokevirtual 1535	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: istore 5
    //   435: iload 5
    //   437: ifeq +20 -> 457
    //   440: aload_0
    //   441: aload 15
    //   443: aload 14
    //   445: aload 21
    //   447: aload 22
    //   449: aload 9
    //   451: invokespecial 1537	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:parseActionInfo	(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lorg/json/JSONObject;)V
    //   454: goto +12 -> 466
    //   457: ldc_w 1539
    //   460: aload 10
    //   462: invokevirtual 1535	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   465: pop
    //   466: aload 8
    //   468: astore 9
    //   470: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +43 -> 516
    //   476: new 256	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   483: astore 18
    //   485: aload 18
    //   487: ldc_w 1541
    //   490: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload 18
    //   496: aload 10
    //   498: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 9
    //   504: iconst_2
    //   505: aload 18
    //   507: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: goto +3 -> 516
    //   516: iload_2
    //   517: iconst_1
    //   518: iadd
    //   519: istore_2
    //   520: aload 9
    //   522: astore 8
    //   524: goto -135 -> 389
    //   527: astore 10
    //   529: goto +5 -> 534
    //   532: astore 10
    //   534: aload_0
    //   535: astore 9
    //   537: aload 8
    //   539: astore 11
    //   541: aload 9
    //   543: astore 8
    //   545: aload 11
    //   547: astore 9
    //   549: goto +904 -> 1453
    //   552: astore 9
    //   554: aload 8
    //   556: astore 10
    //   558: aload_0
    //   559: astore 8
    //   561: aload 9
    //   563: astore 11
    //   565: aload 10
    //   567: astore 9
    //   569: goto +790 -> 1359
    //   572: aload 8
    //   574: astore 9
    //   576: aload 23
    //   578: ldc_w 1543
    //   581: invokevirtual 823	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   584: pop
    //   585: aload 23
    //   587: ldc_w 1545
    //   590: invokevirtual 819	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   593: istore 5
    //   595: iload 5
    //   597: ifeq +82 -> 679
    //   600: aload 9
    //   602: iconst_1
    //   603: ldc_w 1547
    //   606: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aload 23
    //   611: ldc_w 1545
    //   614: invokevirtual 823	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   617: astore 10
    //   619: aload 10
    //   621: ldc_w 1532
    //   624: invokevirtual 819	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   627: ifeq +23 -> 650
    //   630: aload_0
    //   631: aload 15
    //   633: aload 14
    //   635: aload 21
    //   637: aload 22
    //   639: aload 10
    //   641: ldc_w 1532
    //   644: invokevirtual 823	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   647: invokespecial 1537	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:parseActionInfo	(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lorg/json/JSONObject;)V
    //   650: aload 10
    //   652: ldc_w 1549
    //   655: invokevirtual 819	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   658: pop
    //   659: aload 10
    //   661: ldc_w 1543
    //   664: invokevirtual 819	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   667: ifeq +12 -> 679
    //   670: aload 10
    //   672: ldc_w 1543
    //   675: invokevirtual 823	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   678: pop
    //   679: aload 23
    //   681: ldc_w 1551
    //   684: invokevirtual 819	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   687: ifeq +834 -> 1521
    //   690: aload 23
    //   692: ldc_w 1551
    //   695: invokevirtual 823	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   698: astore 10
    //   700: aload_0
    //   701: aload 10
    //   703: aload 16
    //   705: invokespecial 1553	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:parseWhiteFaceIdMapping	(Lorg/json/JSONObject;Ljava/util/List;)V
    //   708: goto +3 -> 711
    //   711: aload_0
    //   712: astore 10
    //   714: aload 11
    //   716: ldc_w 447
    //   719: aload 13
    //   721: invokevirtual 578	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   724: checkcast 454	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl
    //   727: astore 13
    //   729: aload 13
    //   731: iconst_0
    //   732: aload 16
    //   734: invokevirtual 1557	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveWhiteFaceIdMapping	(ZLjava/util/List;)V
    //   737: aload 13
    //   739: invokevirtual 1560	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removeAllAction	()V
    //   742: aload 13
    //   744: aload 15
    //   746: invokevirtual 1564	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveAction	(Ljava/util/List;)V
    //   749: aload 13
    //   751: iconst_1
    //   752: invokevirtual 1567	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removePackageInfo	(I)V
    //   755: aload 13
    //   757: aload 14
    //   759: invokevirtual 1570	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:savePackageInfo	(Ljava/util/List;)V
    //   762: aload 13
    //   764: invokevirtual 1573	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removeAllPackageData	()V
    //   767: aload 13
    //   769: aload 21
    //   771: invokevirtual 1576	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveActionPackageInfo	(Ljava/util/List;)V
    //   774: aload 13
    //   776: invokevirtual 1579	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:removeAllActionTag	()V
    //   779: aload 13
    //   781: aload 22
    //   783: invokevirtual 1582	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:saveActionTag	(Ljava/util/List;)V
    //   786: iload_1
    //   787: ifne +49 -> 836
    //   790: getstatic 1585	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:sFirstOpenPanel	Z
    //   793: ifne +43 -> 836
    //   796: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   799: ifeq +12 -> 811
    //   802: aload 9
    //   804: iconst_1
    //   805: ldc_w 1587
    //   808: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   811: aload 11
    //   813: getstatic 1592	com/tencent/mobileqq/app/BusinessHandlerFactory:APOLLO_EXTENSION_HANDLER	Ljava/lang/String;
    //   816: invokevirtual 1596	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   819: checkcast 1598	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler
    //   822: aload 11
    //   824: invokevirtual 1599	com/tencent/common/app/AppInterface:getCurrentUin	()Ljava/lang/String;
    //   827: ldc2_w 1600
    //   830: ldc_w 1603
    //   833: invokevirtual 1606	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:a	(Ljava/lang/String;JLjava/lang/String;)V
    //   836: aload 10
    //   838: getfield 1265	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:mListenerManager	Lcom/tencent/mobileqq/apollo/utils/ApolloListenerManager;
    //   841: iconst_1
    //   842: invokestatic 1497	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   845: invokevirtual 1500	com/tencent/mobileqq/apollo/utils/ApolloListenerManager:a	(Ljava/lang/Boolean;)V
    //   848: aload_0
    //   849: invokevirtual 1608	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:checkResForGuidePanel	()V
    //   852: aload 11
    //   854: ifnull +279 -> 1133
    //   857: aload 11
    //   859: invokevirtual 1609	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   862: aload 11
    //   864: invokevirtual 1612	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   867: iconst_0
    //   868: invokevirtual 1389	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   871: invokeinterface 1616 1 0
    //   876: astore 13
    //   878: new 256	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   885: astore 14
    //   887: aload 14
    //   889: ldc_w 1618
    //   892: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload 14
    //   898: aload 11
    //   900: invokevirtual 1612	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   903: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: aload 13
    //   909: aload 14
    //   911: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: iconst_1
    //   915: invokeinterface 1624 3 0
    //   920: invokeinterface 1627 1 0
    //   925: pop
    //   926: aload 11
    //   928: invokevirtual 1609	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   931: ldc_w 366
    //   934: iconst_0
    //   935: invokevirtual 1389	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   938: astore 13
    //   940: new 256	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   947: astore 14
    //   949: aload 14
    //   951: aload 12
    //   953: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload 14
    //   959: aload 11
    //   961: invokevirtual 1612	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   964: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: aload 13
    //   970: aload 14
    //   972: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: iconst_0
    //   976: invokeinterface 1631 3 0
    //   981: ifne +59 -> 1040
    //   984: aload 13
    //   986: invokeinterface 1616 1 0
    //   991: astore 14
    //   993: new 256	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   1000: astore 15
    //   1002: aload 15
    //   1004: aload 12
    //   1006: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: pop
    //   1010: aload 15
    //   1012: aload 11
    //   1014: invokevirtual 1612	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1017: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload 14
    //   1023: aload 15
    //   1025: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: iconst_1
    //   1029: invokeinterface 1624 3 0
    //   1034: invokeinterface 1627 1 0
    //   1039: pop
    //   1040: aload 23
    //   1042: ldc_w 1633
    //   1045: invokevirtual 291	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   1048: ldc2_w 1634
    //   1051: ldiv
    //   1052: l2i
    //   1053: istore_1
    //   1054: aload 13
    //   1056: invokeinterface 1616 1 0
    //   1061: astore 12
    //   1063: new 256	java/lang/StringBuilder
    //   1066: dup
    //   1067: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   1070: astore 14
    //   1072: aload 14
    //   1074: ldc_w 1637
    //   1077: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: pop
    //   1081: aload 14
    //   1083: aload 11
    //   1085: invokevirtual 1612	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1088: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload 12
    //   1094: aload 14
    //   1096: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1099: iload_1
    //   1100: invokeinterface 1640 3 0
    //   1105: invokeinterface 1627 1 0
    //   1110: pop
    //   1111: aload 13
    //   1113: invokeinterface 1616 1 0
    //   1118: ldc_w 1637
    //   1121: iload_1
    //   1122: invokeinterface 1640 3 0
    //   1127: invokeinterface 1627 1 0
    //   1132: pop
    //   1133: aload 23
    //   1135: ldc_w 1642
    //   1138: invokevirtual 836	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1141: astore 12
    //   1143: aload 12
    //   1145: ifnull +118 -> 1263
    //   1148: aload 11
    //   1150: ifnull +113 -> 1263
    //   1153: aload 11
    //   1155: invokevirtual 1609	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1158: ldc_w 1644
    //   1161: iconst_0
    //   1162: invokevirtual 1389	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1165: invokeinterface 1616 1 0
    //   1170: ldc_w 1646
    //   1173: aload 12
    //   1175: invokevirtual 1647	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1178: invokeinterface 1651 3 0
    //   1183: invokeinterface 1627 1 0
    //   1188: pop
    //   1189: aload 20
    //   1191: aload 12
    //   1193: invokevirtual 1647	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1196: putfield 1654	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:mPetConfig	Ljava/lang/String;
    //   1199: aload 12
    //   1201: invokevirtual 840	org/json/JSONArray:length	()I
    //   1204: istore_2
    //   1205: iconst_0
    //   1206: istore_1
    //   1207: iload_1
    //   1208: iload_2
    //   1209: if_icmpge +54 -> 1263
    //   1212: aload 12
    //   1214: iload_1
    //   1215: invokevirtual 844	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1218: astore 13
    //   1220: aload 13
    //   1222: ldc_w 1656
    //   1225: iconst_0
    //   1226: invokevirtual 911	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1229: istore_3
    //   1230: aload 13
    //   1232: ldc_w 1658
    //   1235: iconst_0
    //   1236: invokevirtual 911	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1239: istore 4
    //   1241: aload 10
    //   1243: iload_3
    //   1244: iconst_0
    //   1245: invokespecial 1295	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:downloadActionIfNotExist	(II)V
    //   1248: aload 10
    //   1250: iload 4
    //   1252: iconst_0
    //   1253: invokespecial 1295	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:downloadActionIfNotExist	(II)V
    //   1256: iload_1
    //   1257: iconst_1
    //   1258: iadd
    //   1259: istore_1
    //   1260: goto -53 -> 1207
    //   1263: aload 11
    //   1265: ifnull +7 -> 1272
    //   1268: aload_0
    //   1269: invokevirtual 1660	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:checkCompat2DActionRsc	()V
    //   1272: aload 10
    //   1274: getfield 87	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:mIsJsonParsing	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1277: iconst_0
    //   1278: invokevirtual 1514	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1281: new 256	java/lang/StringBuilder
    //   1284: dup
    //   1285: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   1288: astore 8
    //   1290: aload 8
    //   1292: ldc_w 1662
    //   1295: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: pop
    //   1299: aload 8
    //   1301: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   1304: lload 6
    //   1306: lsub
    //   1307: invokevirtual 1245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1310: pop
    //   1311: goto +106 -> 1417
    //   1314: astore 10
    //   1316: goto -782 -> 534
    //   1319: astore 10
    //   1321: goto +10 -> 1331
    //   1324: astore 9
    //   1326: goto -772 -> 554
    //   1329: astore 10
    //   1331: aload_0
    //   1332: astore 8
    //   1334: goto +13 -> 1347
    //   1337: astore 9
    //   1339: goto -785 -> 554
    //   1342: astore 10
    //   1344: aload_0
    //   1345: astore 8
    //   1347: goto +106 -> 1453
    //   1350: astore 11
    //   1352: aload_0
    //   1353: astore 8
    //   1355: aload 10
    //   1357: astore 9
    //   1359: aload 9
    //   1361: iconst_1
    //   1362: ldc_w 1664
    //   1365: aload 11
    //   1367: invokestatic 339	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1370: aload 8
    //   1372: getfield 87	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:mIsJsonParsing	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1375: iconst_0
    //   1376: invokevirtual 1514	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1379: new 256	java/lang/StringBuilder
    //   1382: dup
    //   1383: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   1386: astore 11
    //   1388: aload 11
    //   1390: ldc_w 1662
    //   1393: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 11
    //   1399: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   1402: lload 6
    //   1404: lsub
    //   1405: invokevirtual 1245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload 8
    //   1411: astore 10
    //   1413: aload 11
    //   1415: astore 8
    //   1417: aload 8
    //   1419: ldc_w 1666
    //   1422: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: pop
    //   1426: aload 9
    //   1428: iconst_1
    //   1429: aload 8
    //   1431: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1434: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1437: aload 10
    //   1439: getfield 87	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:mIsJsonParsing	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1442: iconst_0
    //   1443: invokevirtual 1514	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1446: iconst_1
    //   1447: ireturn
    //   1448: astore 10
    //   1450: goto -103 -> 1347
    //   1453: aload 8
    //   1455: getfield 87	com/tencent/mobileqq/apollo/res/api/impl/ApolloResManagerImpl:mIsJsonParsing	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1458: iconst_0
    //   1459: invokevirtual 1514	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1462: new 256	java/lang/StringBuilder
    //   1465: dup
    //   1466: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   1469: astore 8
    //   1471: aload 8
    //   1473: ldc_w 1662
    //   1476: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: pop
    //   1480: aload 8
    //   1482: invokestatic 1215	java/lang/System:currentTimeMillis	()J
    //   1485: lload 6
    //   1487: lsub
    //   1488: invokevirtual 1245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1491: pop
    //   1492: aload 8
    //   1494: ldc_w 1666
    //   1497: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: pop
    //   1501: aload 9
    //   1503: iconst_1
    //   1504: aload 8
    //   1506: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1509: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1512: goto +6 -> 1518
    //   1515: aload 10
    //   1517: athrow
    //   1518: goto -3 -> 1515
    //   1521: goto -810 -> 711
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1524	0	this	ApolloResManagerImpl
    //   199	1061	1	i	int
    //   376	834	2	j	int
    //   402	842	3	k	int
    //   1239	12	4	m	int
    //   16	580	5	bool	boolean
    //   258	1228	6	l	long
    //   20	1485	8	localObject1	Object
    //   124	23	9	localThrowable	Throwable
    //   182	366	9	localObject2	Object
    //   552	10	9	localException1	Exception
    //   567	236	9	localObject3	Object
    //   1324	1	9	localException2	Exception
    //   1337	1	9	localException3	Exception
    //   1357	145	9	localObject4	Object
    //   133	166	10	localObject5	Object
    //   318	1	10	localObject6	Object
    //   339	158	10	localObject7	Object
    //   527	1	10	localObject8	Object
    //   532	1	10	localObject9	Object
    //   556	717	10	localObject10	Object
    //   1314	1	10	localObject11	Object
    //   1319	1	10	localObject12	Object
    //   1329	1	10	localObject13	Object
    //   1342	14	10	localObject14	Object
    //   1411	27	10	localObject15	Object
    //   1448	68	10	localObject16	Object
    //   1	1263	11	localObject17	Object
    //   1350	16	11	localException4	Exception
    //   1386	28	11	localStringBuilder	StringBuilder
    //   119	1094	12	localObject18	Object
    //   289	942	13	localObject19	Object
    //   77	1018	14	localObject20	Object
    //   68	956	15	localObject21	Object
    //   95	638	16	localArrayList1	ArrayList
    //   59	350	17	localObject22	Object
    //   6	500	18	localObject23	Object
    //   368	18	19	localJSONArray	JSONArray
    //   274	916	20	localApolloManagerServiceImpl	ApolloManagerServiceImpl
    //   86	684	21	localArrayList2	ArrayList
    //   104	678	22	localArrayList3	ArrayList
    //   350	784	23	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   106	121	124	java/lang/Throwable
    //   300	309	318	finally
    //   440	454	527	finally
    //   457	466	527	finally
    //   470	513	527	finally
    //   600	650	527	finally
    //   650	679	527	finally
    //   408	435	532	finally
    //   408	435	552	java/lang/Exception
    //   729	737	1314	finally
    //   700	708	1319	finally
    //   714	729	1319	finally
    //   737	786	1319	finally
    //   790	811	1319	finally
    //   811	836	1319	finally
    //   836	852	1319	finally
    //   857	1040	1319	finally
    //   1040	1133	1319	finally
    //   1133	1143	1319	finally
    //   1153	1205	1319	finally
    //   1212	1256	1319	finally
    //   1268	1272	1319	finally
    //   700	708	1324	java/lang/Exception
    //   714	729	1324	java/lang/Exception
    //   729	737	1324	java/lang/Exception
    //   737	786	1324	java/lang/Exception
    //   790	811	1324	java/lang/Exception
    //   811	836	1324	java/lang/Exception
    //   836	852	1324	java/lang/Exception
    //   857	1040	1324	java/lang/Exception
    //   1040	1133	1324	java/lang/Exception
    //   1133	1143	1324	java/lang/Exception
    //   1153	1205	1324	java/lang/Exception
    //   1212	1256	1324	java/lang/Exception
    //   1268	1272	1324	java/lang/Exception
    //   576	595	1329	finally
    //   679	700	1329	finally
    //   440	454	1337	java/lang/Exception
    //   457	466	1337	java/lang/Exception
    //   470	513	1337	java/lang/Exception
    //   576	595	1337	java/lang/Exception
    //   600	650	1337	java/lang/Exception
    //   650	679	1337	java/lang/Exception
    //   679	700	1337	java/lang/Exception
    //   284	291	1342	finally
    //   341	352	1342	finally
    //   360	370	1342	finally
    //   397	403	1342	finally
    //   284	291	1350	java/lang/Exception
    //   300	309	1350	java/lang/Exception
    //   341	352	1350	java/lang/Exception
    //   360	370	1350	java/lang/Exception
    //   397	403	1350	java/lang/Exception
    //   1359	1370	1448	finally
  }
  
  public void removeAllListener()
  {
    ApolloListenerManager localApolloListenerManager = this.mListenerManager;
    if (localApolloListenerManager != null) {
      localApolloListenerManager.a();
    }
  }
  
  public void removeDownLoadListener(IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener != null)
    {
      ApolloListenerManager localApolloListenerManager = this.mListenerManager;
      if (localApolloListenerManager != null) {
        localApolloListenerManager.b(paramIResDownloadListener);
      }
    }
  }
  
  public void updateAndDownloadPreRes(Map<String, ApolloPreDownloadData> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      try
      {
        ArrayList localArrayList = new ArrayList();
        HashMap localHashMap = new HashMap();
        Bundle localBundle = new Bundle();
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all");
        Map localMap = localApolloDaoManagerServiceImpl.getPreDownloadRes();
        Iterator localIterator = paramMap.values().iterator();
        while (localIterator.hasNext())
        {
          ApolloPreDownloadData localApolloPreDownloadData = (ApolloPreDownloadData)localIterator.next();
          if ((!TextUtils.isEmpty(localApolloPreDownloadData.resId)) && (!TextUtils.isEmpty(localApolloPreDownloadData.dir)) && (!TextUtils.isEmpty(localApolloPreDownloadData.md5)) && ((localApolloPreDownloadData.endTime <= 0L) || (localApolloPreDownloadData.endTime >= NetConnInfoCenter.getServerTime())))
          {
            Object localObject = (ApolloPreDownloadData)localMap.get(localApolloPreDownloadData.resId);
            if ((localObject != null) && (((ApolloPreDownloadData)localObject).status != 0) && (localApolloPreDownloadData.version <= ((ApolloPreDownloadData)localObject).version))
            {
              localApolloPreDownloadData.status = 1;
            }
            else
            {
              localStringBuilder2.append(localApolloPreDownloadData.reportId);
              localStringBuilder2.append(",ver:");
              localStringBuilder2.append(localApolloPreDownloadData.version);
              localStringBuilder2.append(" | ");
              localArrayList.add(localApolloPreDownloadData.url);
              if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(CMResUtil.c(localApolloPreDownloadData.dirType));
                ((StringBuilder)localObject).append(localApolloPreDownloadData.zipDir);
              }
              for (;;)
              {
                localObject = ((StringBuilder)localObject).toString();
                break;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/pre_download/");
                ((StringBuilder)localObject).append(localApolloPreDownloadData.resId);
                ((StringBuilder)localObject).append(".zip");
              }
              localHashMap.put(localApolloPreDownloadData.url, new File((String)localObject));
              localBundle.putSerializable(localApolloPreDownloadData.url, localApolloPreDownloadData);
            }
          }
          else
          {
            localStringBuilder1.append(localApolloPreDownloadData.reportId);
            localStringBuilder1.append(",");
          }
        }
        localApolloDaoManagerServiceImpl.savePreDownloadRes(paramMap, true);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]cm_res", 2, new Object[] { "updateAndDownloadPreRes valid download:", localStringBuilder2.toString(), "\ninvalid config:", localStringBuilder1.toString() });
        }
        if (localArrayList.size() > 0)
        {
          paramMap = new DownloadTask(localArrayList, localHashMap, "apollo_preDownload");
          paramMap.n = true;
          paramMap.f = "apollo_res";
          paramMap.p = true;
          paramMap.s = false;
          paramMap.r = true;
          paramMap.q = true;
          paramMap.b = 0;
          if (getDownloader() != null)
          {
            getDownloader().startDownload(paramMap, this.preDownloadListener, localBundle);
            return;
          }
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("[cmshow]cm_res", 1, "updateAndDownloadPreRes e:", paramMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl
 * JD-Core Version:    0.7.0.1
 */