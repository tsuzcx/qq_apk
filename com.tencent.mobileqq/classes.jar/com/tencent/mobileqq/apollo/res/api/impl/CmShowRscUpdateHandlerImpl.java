package com.tencent.mobileqq.apollo.res.api.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscUpdateHandler;
import com.tencent.mobileqq.apollo.utils.ApolloResDownloaderUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.BspatchUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContInfo;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdReq;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class CmShowRscUpdateHandlerImpl
  implements ICmShowRscUpdateHandler, BusinessObserver
{
  public static final int CONTENT_UPDATE_APPID = 1;
  public static final String CONTENT_UPDATE_CMD = "cmshowar_content_update.check";
  public static final int CONTENT_UPDATE_JSON_BUZID = 100;
  public static final long CONTENT_UPDATE_JSON_ITEMID = 1L;
  public static final String CONTENT_UPDATE_ROOM3D_FILE_NAME = "all_room3D.json";
  private static final String JSON_CONTENT_UPDATE_INTERVAL = "json_content_update_interval";
  private static final String LAST_JSON_CONTENT_UPDATE_TS = "last_json_content_update_ts";
  private static final String SP_NAME = "cmshow_rsc_update_sp";
  private static final String TAG = "rscContent_CmShowRscUpdateHandler";
  private static int sJsonContentUpdateInterval = 180;
  private List<CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult> mAllCheckList;
  private WeakReference<AppInterface> mAppRef;
  private final SparseArray<WeakReference<CmShowRscUpdateHandlerImpl.OnCheckContentListener>> mCheckContentListeners = new SparseArray();
  private final SharedPreferences mSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("cmshow_rsc_update_sp", 4);
  
  public CmShowRscUpdateHandlerImpl()
  {
    int i = this.mSharedPreferences.getInt("json_content_update_interval", 0);
    if (i >= 10) {
      sJsonContentUpdateInterval = i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RscContentUpdateHandler sJsonContentUpdateInterval:");
    localStringBuilder.append(sJsonContentUpdateInterval);
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, localStringBuilder.toString());
  }
  
  private static boolean checkZipMd5(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult, String paramString)
  {
    if (paramContentUpdateCheckResult == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramContentUpdateCheckResult.k)) {
      return true;
    }
    return (paramString != null) && (paramString.equalsIgnoreCase(paramContentUpdateCheckResult.k));
  }
  
  private void downloadAllZip(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadAllZip result:");
      ((StringBuilder)localObject).append(paramContentUpdateCheckResult);
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mAppRef;
    if (localObject != null)
    {
      if (paramContentUpdateCheckResult == null) {
        return;
      }
      localObject = (AppInterface)((WeakReference)localObject).get();
      if (localObject == null) {
        return;
      }
      localObject = ApolloResDownloaderUtil.a((AppRuntime)localObject);
      if (localObject == null) {
        return;
      }
      if (TextUtils.isEmpty(paramContentUpdateCheckResult.f))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadAllZip result.mDownloadFileUrl is empty result:");
        ((StringBuilder)localObject).append(paramContentUpdateCheckResult);
        QLog.e("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
        return;
      }
      File localFile = new File(paramContentUpdateCheckResult.c());
      localFile.getParentFile().mkdirs();
      if (localFile.exists()) {
        localFile.delete();
      }
      DownloadTask localDownloadTask = new DownloadTask(paramContentUpdateCheckResult.f, localFile);
      localDownloadTask.N = true;
      localDownloadTask.J = true;
      localDownloadTask.L = "apollo_res";
      localDownloadTask.e = 1;
      localDownloadTask.P = true;
      localDownloadTask.Q = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContentUpdateCheckResult.f);
      localStringBuilder.append("_");
      localStringBuilder.append(paramContentUpdateCheckResult.c);
      localDownloadTask.b = localStringBuilder.toString();
      ((DownloaderInterface)localObject).startDownload(localDownloadTask, new CmShowRscUpdateHandlerImpl.4(this, localFile, paramContentUpdateCheckResult), null);
    }
  }
  
  private void downloadZipAndPatch(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadZipAndPatch result:");
      ((StringBuilder)localObject).append(paramContentUpdateCheckResult);
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramContentUpdateCheckResult == null) {
      return;
    }
    Object localObject = (AppInterface)this.mAppRef.get();
    if (localObject == null) {
      return;
    }
    localObject = ApolloResDownloaderUtil.a((AppRuntime)localObject);
    if (localObject == null) {
      return;
    }
    if (TextUtils.isEmpty(paramContentUpdateCheckResult.j))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadZipAndPatch result.mDownloadPatchFileUrl is empty result:");
      ((StringBuilder)localObject).append(paramContentUpdateCheckResult);
      QLog.e("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject).toString());
      return;
    }
    File localFile = new File(paramContentUpdateCheckResult.d());
    localFile.getParentFile().mkdirs();
    if (localFile.exists()) {
      localFile.delete();
    }
    DownloadTask localDownloadTask = new DownloadTask(paramContentUpdateCheckResult.j, localFile);
    localDownloadTask.N = true;
    localDownloadTask.J = true;
    localDownloadTask.L = "apollo_res";
    localDownloadTask.e = 1;
    localDownloadTask.P = true;
    localDownloadTask.Q = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContentUpdateCheckResult.f);
    localStringBuilder.append("_");
    localStringBuilder.append(paramContentUpdateCheckResult.c);
    localDownloadTask.b = localStringBuilder.toString();
    ((DownloaderInterface)localObject).startDownload(localDownloadTask, new CmShowRscUpdateHandlerImpl.3(this, localFile, paramContentUpdateCheckResult), null);
  }
  
  private static boolean needUnzip(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    if (paramContentUpdateCheckResult == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramContentUpdateCheckResult.l)) {
      return false;
    }
    return paramContentUpdateCheckResult.l.endsWith(".zip");
  }
  
  private void onContentCheckFailed(int paramInt)
  {
    Object localObject = (WeakReference)this.mCheckContentListeners.get(paramInt);
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      ((CmShowRscUpdateHandlerImpl.OnCheckContentListener)((WeakReference)localObject).get()).a(false, null);
      this.mCheckContentListeners.remove(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onContentCheckFailed requestId:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject).toString());
  }
  
  private void onContentCheckSuccess(int paramInt, CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    if (paramContentUpdateCheckResult == null) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onContentCheckSuccess result");
      ((StringBuilder)localObject1).append(paramContentUpdateCheckResult);
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramContentUpdateCheckResult.a == 100) && (paramContentUpdateCheckResult.b == 1L)) {
      if (1 != BaseApplicationImpl.sProcessId)
      {
        if ("all_room3D".equals(paramContentUpdateCheckResult.c)) {
          ((ICmShowRscCacheManager)QRoute.api(ICmShowRscCacheManager.class)).onRoomZipUpdated();
        } else {
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "check update from QQ process");
        }
      }
      else if (CmGameUtil.a(BaseApplicationImpl.getContext()))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
        ((Intent)localObject1).putExtra("action_apollo_cmshow_content_update", true);
        ((Intent)localObject1).putExtra("key_content_update_zip_name", "all_room3D");
        ((Intent)localObject1).setPackage(BaseApplicationImpl.getContext().getPackageName());
        try
        {
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "send sendBroadcast contentUpdate");
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
        }
        catch (Throwable localThrowable)
        {
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, localThrowable, new Object[0]);
        }
      }
    }
    saveContentVersion(paramContentUpdateCheckResult, paramContentUpdateCheckResult.d);
    if (paramContentUpdateCheckResult.n) {
      if (paramContentUpdateCheckResult.o > 0)
      {
        if (sJsonContentUpdateInterval != paramContentUpdateCheckResult.o)
        {
          sJsonContentUpdateInterval = paramContentUpdateCheckResult.o;
          this.mSharedPreferences.edit().putInt("json_content_update_interval", paramContentUpdateCheckResult.o).commit();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onContentCheckSuccess interval != result.mCheckServerInterval:");
          ((StringBuilder)localObject2).append(paramContentUpdateCheckResult.o);
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject2).toString());
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onContentCheckSuccess interval == result.mCheckServerInterval:");
          ((StringBuilder)localObject2).append(paramContentUpdateCheckResult.o);
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onContentCheckSuccess result.mCheckServerInterval <= 0");
        ((StringBuilder)localObject2).append(paramContentUpdateCheckResult.o);
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject2).toString());
      }
    }
    Object localObject2 = this.mAllCheckList;
    if (localObject2 != null)
    {
      ((List)localObject2).remove(paramContentUpdateCheckResult);
      if (this.mAllCheckList.isEmpty())
      {
        this.mSharedPreferences.edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess save lastCheckContentUpdateTS");
      }
    }
    localObject2 = (WeakReference)this.mCheckContentListeners.get(paramInt);
    if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
    {
      ((CmShowRscUpdateHandlerImpl.OnCheckContentListener)((WeakReference)localObject2).get()).a(true, paramContentUpdateCheckResult);
      this.mCheckContentListeners.remove(paramInt);
    }
  }
  
  private void onGetJsonDone(int paramInt, CmShowContentUpdate.STContUpdRsp paramSTContUpdRsp, boolean paramBoolean)
  {
    if (paramSTContUpdRsp != null) {
      ThreadManager.post(new CmShowRscUpdateHandlerImpl.2(this, paramSTContUpdRsp, paramBoolean, paramInt), 5, null, false);
    }
  }
  
  private void updateResource(int paramInt, List<CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult> paramList)
  {
    if (paramList == null)
    {
      onContentCheckSuccess(paramInt, null);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateResource checkResults:");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramList.isEmpty()) {
      return;
    }
    Object localObject1 = (AppInterface)this.mAppRef.get();
    if (localObject1 == null) {
      return;
    }
    if (ApolloResDownloaderUtil.a((AppRuntime)localObject1) == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult localContentUpdateCheckResult = (CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)paramList.next();
      if (localContentUpdateCheckResult != null)
      {
        localObject1 = new File(localContentUpdateCheckResult.c());
        ((File)localObject1).getParentFile().mkdirs();
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        Object localObject2 = localContentUpdateCheckResult.e();
        Object localObject3;
        if ((localContentUpdateCheckResult.g) && (!new File((String)localObject2).exists()))
        {
          localContentUpdateCheckResult.g = false;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateResource old version File no exist :");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject3).toString());
        }
        if (!localContentUpdateCheckResult.g)
        {
          downloadAllZip(localContentUpdateCheckResult);
        }
        else if (localContentUpdateCheckResult.h == null)
        {
          downloadZipAndPatch(localContentUpdateCheckResult);
        }
        else
        {
          localObject3 = localContentUpdateCheckResult.d();
          if (!FileUtils.writeFile(localContentUpdateCheckResult.h, (String)localObject3))
          {
            downloadAllZip(localContentUpdateCheckResult);
          }
          else if (!BspatchUtil.a((String)localObject2, (String)localObject3, ((File)localObject1).getAbsolutePath()))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("BspatchUtil.patch failed path:");
            ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
            QLog.e("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject2).toString());
            downloadAllZip(localContentUpdateCheckResult);
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("BspatchUtil.patch success path:");
            ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject2).toString());
            localObject2 = MD5Utils.encodeFileHexStr(((File)localObject1).getAbsolutePath());
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(" updateResource onDone dstMd5:");
              ((StringBuilder)localObject3).append((String)localObject2);
              ((StringBuilder)localObject3).append(" result.mMd5:");
              ((StringBuilder)localObject3).append(localContentUpdateCheckResult.k);
              QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject3).toString());
            }
            if (!checkZipMd5(localContentUpdateCheckResult, (String)localObject2))
            {
              QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
              downloadAllZip(localContentUpdateCheckResult);
            }
            else
            {
              try
              {
                if (needUnzip(localContentUpdateCheckResult))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(((File)localObject1).getParent());
                  ((StringBuilder)localObject2).append(File.separator);
                  ZipUtils.unZipFile((File)localObject1, ((StringBuilder)localObject2).toString());
                  if (QLog.isColorLevel())
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("updateResource unZipFile ok file dstpath:");
                    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
                    QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject2).toString());
                  }
                }
                else
                {
                  localObject2 = ((File)localObject1).getAbsolutePath();
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append(localContentUpdateCheckResult.b());
                  ((StringBuilder)localObject3).append(localContentUpdateCheckResult.l);
                  boolean bool = FileUtils.copyFile((String)localObject2, ((StringBuilder)localObject3).toString());
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("downloadAllZip no need unzip copy:");
                  ((StringBuilder)localObject2).append(bool);
                  QLog.i("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject2).toString());
                }
                onContentCheckSuccess(localContentUpdateCheckResult.p, localContentUpdateCheckResult);
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                ((File)localObject1).delete();
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("updateResource unZipFile file error path->");
                ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
                ((StringBuilder)localObject2).append(localOutOfMemoryError.getMessage());
                QLog.d("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject2).toString());
              }
              catch (Exception localException)
              {
                ((File)localObject1).delete();
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("updateResource unZipFile file error path->");
                ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
                ((StringBuilder)localObject2).append(localException.getMessage());
                QLog.d("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject2).toString());
                onContentCheckFailed(paramInt);
              }
            }
          }
        }
      }
    }
  }
  
  public void addCheckListener(int paramInt, CmShowRscUpdateHandlerImpl.OnCheckContentListener paramOnCheckContentListener)
  {
    synchronized (this.mCheckContentListeners)
    {
      this.mCheckContentListeners.put(paramInt, new WeakReference(paramOnCheckContentListener));
      return;
    }
  }
  
  public void checkCmShowContentUpdate(AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkCmShowContentUpdate forceCheck:");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject1).toString());
    if (paramAppInterface == null) {
      return;
    }
    if (!CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult.a(100, 1L, "all_room3D", "all_room3D.json"))
    {
      saveContentVersion(100, 1L, "all_room3D", 0);
      paramBoolean = true;
    }
    if (!paramBoolean)
    {
      long l = this.mSharedPreferences.getLong("last_json_content_update_ts", 0L);
      if (System.currentTimeMillis() - l < sJsonContentUpdateInterval * 1000)
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("checkCmShowContentUpdate in sJsonContentUpdateInterval:");
        paramAppInterface.append(sJsonContentUpdateInterval);
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, paramAppInterface.toString());
        return;
      }
    }
    this.mAppRef = new WeakReference(paramAppInterface);
    localObject1 = new CmShowContentUpdate.STContUpdReq();
    ((CmShowContentUpdate.STContUpdReq)localObject1).app_id.set(1);
    Object localObject2 = new CmShowContentUpdate.STContInfo();
    ((CmShowContentUpdate.STContInfo)localObject2).biz_id.set(100);
    ((CmShowContentUpdate.STContInfo)localObject2).item_id.set(1L);
    ((CmShowContentUpdate.STContInfo)localObject2).name.set(ByteStringMicro.copyFromUtf8("all_room3D"));
    ((CmShowContentUpdate.STContInfo)localObject2).ver.set(getContentVersion(100, 1L, "all_room3D"));
    Object localObject3 = new ArrayList();
    ((List)localObject3).add(localObject2);
    ((CmShowContentUpdate.STContUpdReq)localObject1).cont_list.set((List)localObject3);
    try
    {
      localObject3 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("8.8.17");
      localObject2 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject2).comm.set((MessageMicro)localObject3);
      ((WebSSOAgent.UniSsoServerReq)localObject2).pbReqData.set(ByteStringMicro.copyFrom(((CmShowContentUpdate.STContUpdReq)localObject1).toByteArray()));
      localObject1 = new NewIntent(BaseApplicationImpl.getContext(), WebSSOAgentServlet.class);
      ((NewIntent)localObject1).putExtra("extra_cmd", "cmshowar_content_update.check");
      ((NewIntent)localObject1).putExtra("extra_data", ((WebSSOAgent.UniSsoServerReq)localObject2).toByteArray());
      ((NewIntent)localObject1).putExtra("extra_callbackid", String.valueOf(paramInt));
      ((NewIntent)localObject1).setObserver(this);
      paramAppInterface.startServlet((NewIntent)localObject1);
      return;
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("rscContent_CmShowRscUpdateHandler", 2, "OpenPandora failed ", paramAppInterface);
      }
    }
  }
  
  public void checkUpdateAsync(AppInterface paramAppInterface)
  {
    ThreadManagerV2.excute(new CmShowRscUpdateHandlerImpl.1(this, paramAppInterface), 16, null, false);
  }
  
  public int getContentVersion(int paramInt, long paramLong, String paramString)
  {
    SharedPreferences localSharedPreferences = this.mSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramInt = paramBundle.getInt("extra_result_code");
    Object localObject1 = paramBundle.getString("extra_cmd");
    String str = paramBundle.getString("extra_callbackid");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isSuccess:");
    ((StringBuilder)localObject2).append(paramBoolean);
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, ((StringBuilder)localObject2).toString());
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("svrRet:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" cmd:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" requestIdStr:");
      ((StringBuilder)localObject2).append(str);
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramBoolean) {
      try
      {
        localObject2 = paramBundle.getByteArray("extra_data");
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom((byte[])localObject2);
        long l = paramBundle.ret.get();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("retCode:");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(" isSuccess:");
          ((StringBuilder)localObject2).append(paramBoolean);
          ((StringBuilder)localObject2).append(" cmd:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, ((StringBuilder)localObject2).toString());
        }
        if (!"cmshowar_content_update.check".equals(localObject1)) {
          return;
        }
        if (l == 0L)
        {
          localObject1 = new CmShowContentUpdate.STContUpdRsp();
          ((CmShowContentUpdate.STContUpdRsp)localObject1).mergeFrom(paramBundle.pbRsqData.get().toByteArray());
          onGetJsonDone(ApolloUtilImpl.parseToInt(str), (CmShowContentUpdate.STContUpdRsp)localObject1, true);
          return;
        }
        onContentCheckFailed(ApolloUtilImpl.parseToInt(str));
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("rscContent_CmShowRscUpdateHandler", 1, paramBundle, new Object[0]);
        return;
      }
    } else {
      onContentCheckFailed(ApolloUtilImpl.parseToInt(str));
    }
  }
  
  public void removeCheckListener(int paramInt)
  {
    synchronized (this.mCheckContentListeners)
    {
      this.mCheckContentListeners.remove(paramInt);
      return;
    }
  }
  
  public void saveContentVersion(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localEditor.putInt(localStringBuilder.toString(), paramInt2).commit();
  }
  
  public void saveContentVersion(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult, int paramInt)
  {
    if (paramContentUpdateCheckResult != null)
    {
      this.mSharedPreferences.edit().putInt(paramContentUpdateCheckResult.a(), paramInt).commit();
      paramContentUpdateCheckResult = new StringBuilder();
      paramContentUpdateCheckResult.append("saveContentVersion version:");
      paramContentUpdateCheckResult.append(paramInt);
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, paramContentUpdateCheckResult.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.CmShowRscUpdateHandlerImpl
 * JD-Core Version:    0.7.0.1
 */