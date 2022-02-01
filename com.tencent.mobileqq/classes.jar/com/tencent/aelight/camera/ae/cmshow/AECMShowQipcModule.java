package com.tencent.aelight.camera.ae.cmshow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.cmshow.config.AECMShowConfigManager;
import com.tencent.aelight.camera.ae.download.AEResManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.cmsshow.api.CMJoyEssentialDownloadCallback;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AECMShowQipcModule
  extends QIPCModule
{
  private List<AEResInfo> a = new ArrayList();
  
  private AECMShowQipcModule(String paramString)
  {
    super(paramString);
    this.a.add(AEResInfo.AE_RES_BASE_PACKAGE);
    this.a.add(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    this.a.add(AEResInfo.LIGHT_RES_BUNDLE_ACE3D);
    this.a.add(AEResInfo.LIGHT_RES_BUNDLE_3DMM);
  }
  
  public static AECMShowQipcModule a()
  {
    return AECMShowQipcModule.InstanceHolder.a;
  }
  
  private String a()
  {
    return "https://d3g.qq.com/sngapp/app/update/20210112192445_5344/CrossEngine.jar";
  }
  
  private void a() {}
  
  private void a(int paramInt)
  {
    QLog.d("AECMShowQipcModule", 1, " handleDownloadAERes ");
    AECMShowQipcModule.CmShowAEDownloadCallBack localCmShowAEDownloadCallBack = new AECMShowQipcModule.CmShowAEDownloadCallBack(this, paramInt);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      AEResInfo localAEResInfo = (AEResInfo)localIterator.next();
      StringBuilder localStringBuilder;
      if (AEResUtil.b(localAEResInfo))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleDownloadAERes], resInfo=");
        localStringBuilder.append(localAEResInfo);
        localStringBuilder.append(" local file exists");
        AEQLog.b("AECMShowQipcModule", localStringBuilder.toString());
        localCmShowAEDownloadCallBack.onAEDownloadFinish(localAEResInfo, "", true, 0);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleDownloadAERes], resInfo=");
        localStringBuilder.append(localAEResInfo);
        localStringBuilder.append(" start download");
        AEQLog.b("AECMShowQipcModule", localStringBuilder.toString());
        AEResManager.a().a(localAEResInfo, localCmShowAEDownloadCallBack, false);
      }
    }
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("key_resource_id_list"))) {
      paramBundle = paramBundle.getStringArrayList("key_resource_id_list");
    } else {
      paramBundle = null;
    }
    if (CollectionUtils.isEmpty(paramBundle))
    {
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    AECMShowResourceManager.a().a(paramBundle, new AECMShowQipcModule.2(this, paramInt));
  }
  
  public static void a(@Nullable EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("AECMShowQipcModule", "action_download_ae_res", null, paramEIPCResultCallback);
  }
  
  public static void a(@NonNull ArrayList<String> paramArrayList, @Nullable CMJoyEssentialDownloadCallback paramCMJoyEssentialDownloadCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key_resource_id_list", paramArrayList);
    QIPCClientHelper.getInstance().callServer("AECMShowQipcModule", "action_download_essential_resource", localBundle, new AECMShowQipcModule.1(paramCMJoyEssentialDownloadCallback));
  }
  
  private boolean a()
  {
    return false;
  }
  
  private String b()
  {
    return "https://bucket-kila-1257758378.cos.ap-guangzhou.myqcloud.com/CECmShowEngineRes.zip";
  }
  
  private void b() {}
  
  private void b(int paramInt)
  {
    int i = AECMShowConfigManager.a().a();
    int j = AECMShowConfigManager.a().b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_CMSHOW_IMG_MAX_LENGTH", Integer.valueOf(i));
    localHashMap.put("KEY_CMSHOW_IMG_QUALITY", Integer.valueOf(j));
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_request_image_param", localHashMap);
    callbackResult(paramInt, EIPCResult.createSuccessResult(localBundle));
  }
  
  public static void b(@Nullable EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("AECMShowQipcModule", "action_get_request_image_param", null, paramEIPCResultCallback);
  }
  
  private boolean b()
  {
    return false;
  }
  
  private void c(int paramInt)
  {
    ThreadManagerV2.excute(new AECMShowQipcModule.3(this, paramInt), 16, null, false);
  }
  
  private void d(int paramInt)
  {
    if (a())
    {
      AEQLog.b("AECMShowQipcModule", "[doDownloadCrossEngineLibrary] CrossEngine libs exists, no need to update");
      callbackResult(paramInt, EIPCResult.createSuccessResult(null));
      return;
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    Object localObject2 = (QQAppInterface)localObject1;
    localObject1 = (DownloaderFactory)((QQAppInterface)localObject2).getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    if (localObject1 == null)
    {
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    localObject1 = ((DownloaderFactory)localObject1).a(3);
    if (localObject1 == null)
    {
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(((QQAppInterface)localObject2).getApplication()))
    {
      AEQLog.d("AECMShowQipcModule", "[doDownloadCrossEngineLibrary] network not available, download libs failed.");
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    localObject2 = new File(ApolloConstant.i, "libs.zip");
    if (((File)localObject2).getParentFile().exists()) {
      FileUtils.deleteDirectory(ApolloConstant.i);
    }
    ((File)localObject2).getParentFile().mkdirs();
    DownloadTask localDownloadTask = new DownloadTask(a(), (File)localObject2);
    localDownloadTask.p = true;
    localDownloadTask.n = true;
    localDownloadTask.f = "apollo_res";
    localDownloadTask.b = 1;
    localDownloadTask.q = true;
    localDownloadTask.r = true;
    ((DownloaderInterface)localObject1).startDownload(localDownloadTask, new AECMShowQipcModule.4(this, (File)localObject2, paramInt), null);
  }
  
  private void e(int paramInt)
  {
    ThreadManagerV2.excute(new AECMShowQipcModule.5(this, paramInt), 16, null, false);
  }
  
  private void f(int paramInt)
  {
    if (b())
    {
      AEQLog.b("AECMShowQipcModule", "[doDownloadCrossEngineAssets] CrossEngine assets exists, no need to update");
      callbackResult(paramInt, EIPCResult.createSuccessResult(null));
      return;
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    Object localObject2 = (QQAppInterface)localObject1;
    localObject1 = (DownloaderFactory)((QQAppInterface)localObject2).getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    if (localObject1 == null)
    {
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    localObject1 = ((DownloaderFactory)localObject1).a(3);
    if (localObject1 == null)
    {
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(((QQAppInterface)localObject2).getApplication()))
    {
      AEQLog.d("AECMShowQipcModule", "[doDownloadCrossEngineAssets] network not available, download assets failed.");
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    localObject2 = new File(ApolloConstant.j, "assets.zip");
    if (((File)localObject2).getParentFile().exists()) {
      FileUtils.deleteDirectory(ApolloConstant.j);
    }
    ((File)localObject2).getParentFile().mkdirs();
    DownloadTask localDownloadTask = new DownloadTask(b(), (File)localObject2);
    localDownloadTask.p = true;
    localDownloadTask.n = true;
    localDownloadTask.f = "apollo_res";
    localDownloadTask.b = 1;
    localDownloadTask.q = true;
    localDownloadTask.r = true;
    ((DownloaderInterface)localObject1).startDownload(localDownloadTask, new AECMShowQipcModule.6(this, (File)localObject2, paramInt), null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_download_essential_resource".equals(paramString)) {
      a(paramBundle, paramInt);
    } else if ("action_download_ae_res".equals(paramString)) {
      a(paramInt);
    } else if ("action_get_request_image_param".equals(paramString)) {
      b(paramInt);
    } else if ("action_download_crossengine_assets".equals(paramString)) {
      e(paramInt);
    } else if ("action_download_crossengine_lib".equals(paramString)) {
      c(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowQipcModule
 * JD-Core Version:    0.7.0.1
 */