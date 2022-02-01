package com.tencent.mobileqq.apollo.api.res.impl;

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
import com.tencent.mobileqq.apollo.api.res.ICmShowRscCacheManager;
import com.tencent.mobileqq.apollo.api.res.ICmShowRscUpdateHandler;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.vip.DownloaderFactory;
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
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "RscContentUpdateHandler sJsonContentUpdateInterval:" + sJsonContentUpdateInterval);
  }
  
  private static boolean checkZipMd5(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult, String paramString)
  {
    if (paramContentUpdateCheckResult == null) {}
    do
    {
      return false;
      if (TextUtils.isEmpty(paramContentUpdateCheckResult.jdField_d_of_type_JavaLangString)) {
        return true;
      }
    } while ((paramString == null) || (!paramString.equalsIgnoreCase(paramContentUpdateCheckResult.jdField_d_of_type_JavaLangString)));
    return true;
  }
  
  private void downloadAllZip(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip result:" + paramContentUpdateCheckResult);
    }
    if ((this.mAppRef == null) || (paramContentUpdateCheckResult == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (AppInterface)this.mAppRef.get();
        } while (localObject == null);
        localObject = (DownloaderFactory)((AppInterface)localObject).getManager(QQManagerFactory.DOWNLOADER_FACTORY);
      } while (localObject == null);
      localObject = ((DownloaderFactory)localObject).a(3);
    } while (localObject == null);
    if (TextUtils.isEmpty(paramContentUpdateCheckResult.jdField_b_of_type_JavaLangString))
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip result.mDownloadFileUrl is empty result:" + paramContentUpdateCheckResult);
      return;
    }
    File localFile = new File(paramContentUpdateCheckResult.c());
    localFile.getParentFile().mkdirs();
    if (localFile.exists()) {
      localFile.delete();
    }
    DownloadTask localDownloadTask = new DownloadTask(paramContentUpdateCheckResult.jdField_b_of_type_JavaLangString, localFile);
    localDownloadTask.p = true;
    localDownloadTask.n = true;
    localDownloadTask.f = "apollo_res";
    localDownloadTask.jdField_b_of_type_Int = 1;
    localDownloadTask.q = true;
    localDownloadTask.r = true;
    localDownloadTask.jdField_a_of_type_JavaLangString = (paramContentUpdateCheckResult.jdField_b_of_type_JavaLangString + "_" + paramContentUpdateCheckResult.jdField_a_of_type_JavaLangString);
    ((DownloaderInterface)localObject).a(localDownloadTask, new CmShowRscUpdateHandlerImpl.4(this, localFile, paramContentUpdateCheckResult), null);
  }
  
  private void downloadZipAndPatch(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch result:" + paramContentUpdateCheckResult);
    }
    if (paramContentUpdateCheckResult == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (AppInterface)this.mAppRef.get();
        } while (localObject == null);
        localObject = (DownloaderFactory)((AppInterface)localObject).getManager(QQManagerFactory.DOWNLOADER_FACTORY);
      } while (localObject == null);
      localObject = ((DownloaderFactory)localObject).a(3);
    } while (localObject == null);
    if (TextUtils.isEmpty(paramContentUpdateCheckResult.c))
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch result.mDownloadPatchFileUrl is empty result:" + paramContentUpdateCheckResult);
      return;
    }
    File localFile = new File(paramContentUpdateCheckResult.d());
    localFile.getParentFile().mkdirs();
    if (localFile.exists()) {
      localFile.delete();
    }
    DownloadTask localDownloadTask = new DownloadTask(paramContentUpdateCheckResult.c, localFile);
    localDownloadTask.p = true;
    localDownloadTask.n = true;
    localDownloadTask.f = "apollo_res";
    localDownloadTask.jdField_b_of_type_Int = 1;
    localDownloadTask.q = true;
    localDownloadTask.r = true;
    localDownloadTask.jdField_a_of_type_JavaLangString = (paramContentUpdateCheckResult.jdField_b_of_type_JavaLangString + "_" + paramContentUpdateCheckResult.jdField_a_of_type_JavaLangString);
    ((DownloaderInterface)localObject).a(localDownloadTask, new CmShowRscUpdateHandlerImpl.3(this, localFile, paramContentUpdateCheckResult), null);
  }
  
  private static boolean needUnzip(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    if (paramContentUpdateCheckResult == null) {}
    while ((TextUtils.isEmpty(paramContentUpdateCheckResult.jdField_e_of_type_JavaLangString)) || (!paramContentUpdateCheckResult.jdField_e_of_type_JavaLangString.endsWith(".zip"))) {
      return false;
    }
    return true;
  }
  
  private void onContentCheckFailed(int paramInt)
  {
    WeakReference localWeakReference = (WeakReference)this.mCheckContentListeners.get(paramInt);
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((CmShowRscUpdateHandlerImpl.OnCheckContentListener)localWeakReference.get()).a(false, null);
      this.mCheckContentListeners.remove(paramInt);
    }
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckFailed requestId:" + paramInt);
  }
  
  private void onContentCheckSuccess(int paramInt, CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult)
  {
    if (paramContentUpdateCheckResult == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "onContentCheckSuccess result" + paramContentUpdateCheckResult);
    }
    if ((paramContentUpdateCheckResult.jdField_a_of_type_Int == 100) && (paramContentUpdateCheckResult.jdField_a_of_type_Long == 1L))
    {
      if (1 == BaseApplicationImpl.sProcessId) {
        break label306;
      }
      if ("all_room3D".equals(paramContentUpdateCheckResult.jdField_a_of_type_JavaLangString)) {
        ((ICmShowRscCacheManager)QRoute.api(ICmShowRscCacheManager.class)).onRoomZipUpdated();
      }
    }
    else
    {
      label89:
      saveContentVersion(paramContentUpdateCheckResult, paramContentUpdateCheckResult.jdField_b_of_type_Int);
      if (paramContentUpdateCheckResult.jdField_b_of_type_Boolean)
      {
        if (paramContentUpdateCheckResult.jdField_d_of_type_Int <= 0) {
          break label437;
        }
        if (sJsonContentUpdateInterval == paramContentUpdateCheckResult.jdField_d_of_type_Int) {
          break label399;
        }
        sJsonContentUpdateInterval = paramContentUpdateCheckResult.jdField_d_of_type_Int;
        this.mSharedPreferences.edit().putInt("json_content_update_interval", paramContentUpdateCheckResult.jdField_d_of_type_Int).commit();
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess interval != result.mCheckServerInterval:" + paramContentUpdateCheckResult.jdField_d_of_type_Int);
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (this.mAllCheckList != null)
        {
          this.mAllCheckList.remove(paramContentUpdateCheckResult);
          if (this.mAllCheckList.isEmpty())
          {
            this.mSharedPreferences.edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
            QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess save lastCheckContentUpdateTS");
          }
        }
        Object localObject = (WeakReference)this.mCheckContentListeners.get(paramInt);
        if ((localObject == null) || (((WeakReference)localObject).get() == null)) {
          break;
        }
        ((CmShowRscUpdateHandlerImpl.OnCheckContentListener)((WeakReference)localObject).get()).a(true, paramContentUpdateCheckResult);
        this.mCheckContentListeners.remove(paramInt);
        return;
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "check update from QQ process");
        break label89;
        label306:
        if (!CmGameUtil.a(BaseApplicationImpl.getContext())) {
          break label89;
        }
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
        ((Intent)localObject).putExtra("action_apollo_cmshow_content_update", true);
        ((Intent)localObject).putExtra("key_content_update_zip_name", "all_room3D");
        ((Intent)localObject).setPackage(BaseApplicationImpl.getContext().getPackageName());
        try
        {
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "send sendBroadcast contentUpdate");
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
        }
        catch (Throwable localThrowable)
        {
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, localThrowable, new Object[0]);
        }
      }
      break label89;
      label399:
      if (QLog.isColorLevel())
      {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "onContentCheckSuccess interval == result.mCheckServerInterval:" + paramContentUpdateCheckResult.jdField_d_of_type_Int);
        continue;
        label437:
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess result.mCheckServerInterval <= 0" + paramContentUpdateCheckResult.jdField_d_of_type_Int);
      }
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
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource checkResults:" + paramList.size());
      }
      if (paramList.isEmpty()) {}
      for (;;)
      {
        return;
        Object localObject = (AppInterface)this.mAppRef.get();
        if (localObject != null)
        {
          localObject = (DownloaderFactory)((AppInterface)localObject).getManager(QQManagerFactory.DOWNLOADER_FACTORY);
          if ((localObject != null) && (((DownloaderFactory)localObject).a(3) != null))
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult localContentUpdateCheckResult = (CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult)paramList.next();
              if (localContentUpdateCheckResult != null)
              {
                localObject = new File(localContentUpdateCheckResult.c());
                ((File)localObject).getParentFile().mkdirs();
                if (((File)localObject).exists()) {
                  ((File)localObject).delete();
                }
                String str1 = localContentUpdateCheckResult.e();
                if ((localContentUpdateCheckResult.jdField_a_of_type_Boolean) && (!new File(str1).exists()))
                {
                  localContentUpdateCheckResult.jdField_a_of_type_Boolean = false;
                  QLog.e("rscContent_CmShowRscUpdateHandler", 1, "updateResource old version File no exist :" + str1);
                }
                if (localContentUpdateCheckResult.jdField_a_of_type_Boolean)
                {
                  if (localContentUpdateCheckResult.jdField_a_of_type_ArrayOfByte != null)
                  {
                    String str2 = localContentUpdateCheckResult.d();
                    if (FileUtils.a(localContentUpdateCheckResult.jdField_a_of_type_ArrayOfByte, str2))
                    {
                      if (BspatchUtil.a(str1, str2, ((File)localObject).getAbsolutePath()))
                      {
                        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "BspatchUtil.patch success path:" + ((File)localObject).getAbsolutePath());
                        try
                        {
                          str1 = MD5Utils.encodeFileHexStr(((File)localObject).getAbsolutePath());
                          if (QLog.isColorLevel()) {
                            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " updateResource onDone dstMd5:" + str1 + " result.mMd5:" + localContentUpdateCheckResult.jdField_d_of_type_JavaLangString);
                          }
                          if (!checkZipMd5(localContentUpdateCheckResult, str1)) {
                            break label641;
                          }
                          if (needUnzip(localContentUpdateCheckResult))
                          {
                            ZipUtils.unZipFile((File)localObject, ((File)localObject).getParent() + File.separator);
                            if (QLog.isColorLevel()) {
                              QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile ok file dstpath:" + ((File)localObject).getAbsolutePath());
                            }
                            onContentCheckSuccess(localContentUpdateCheckResult.jdField_e_of_type_Int, localContentUpdateCheckResult);
                          }
                        }
                        catch (Exception localException)
                        {
                          for (;;)
                          {
                            ((File)localObject).delete();
                            if (QLog.isColorLevel()) {
                              QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile file error path->" + ((File)localObject).getAbsolutePath() + localException.getMessage());
                            }
                            onContentCheckFailed(paramInt);
                            break;
                            boolean bool = FileUtils.d(((File)localObject).getAbsolutePath(), localException.b() + localException.jdField_e_of_type_JavaLangString);
                            QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
                          }
                        }
                        catch (OutOfMemoryError localOutOfMemoryError)
                        {
                          ((File)localObject).delete();
                        }
                        if (QLog.isColorLevel())
                        {
                          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile file error path->" + ((File)localObject).getAbsolutePath() + localOutOfMemoryError.getMessage());
                          continue;
                          label641:
                          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
                          downloadAllZip(localOutOfMemoryError);
                        }
                      }
                      else
                      {
                        QLog.e("rscContent_CmShowRscUpdateHandler", 1, "BspatchUtil.patch failed path:" + ((File)localObject).getAbsolutePath());
                        downloadAllZip(localOutOfMemoryError);
                      }
                    }
                    else {
                      downloadAllZip(localOutOfMemoryError);
                    }
                  }
                  else
                  {
                    downloadZipAndPatch(localOutOfMemoryError);
                  }
                }
                else {
                  downloadAllZip(localOutOfMemoryError);
                }
              }
            }
          }
        }
      }
    }
    onContentCheckSuccess(paramInt, null);
  }
  
  public void addChecListener(int paramInt, CmShowRscUpdateHandlerImpl.OnCheckContentListener paramOnCheckContentListener)
  {
    synchronized (this.mCheckContentListeners)
    {
      this.mCheckContentListeners.put(paramInt, new WeakReference(paramOnCheckContentListener));
      return;
    }
  }
  
  public void checkCmShowContentUpdate(AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "checkCmShowContentUpdate forceCheck:" + paramBoolean);
    if (paramAppInterface == null) {}
    do
    {
      return;
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
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "checkCmShowContentUpdate in sJsonContentUpdateInterval:" + sJsonContentUpdateInterval);
          return;
        }
      }
      this.mAppRef = new WeakReference(paramAppInterface);
      Object localObject1 = new CmShowContentUpdate.STContUpdReq();
      ((CmShowContentUpdate.STContUpdReq)localObject1).app_id.set(1);
      Object localObject2 = new ArrayList();
      Object localObject3 = new CmShowContentUpdate.STContInfo();
      ((CmShowContentUpdate.STContInfo)localObject3).biz_id.set(100);
      ((CmShowContentUpdate.STContInfo)localObject3).item_id.set(1L);
      ((CmShowContentUpdate.STContInfo)localObject3).name.set(ByteStringMicro.copyFromUtf8("all_room3D"));
      ((CmShowContentUpdate.STContInfo)localObject3).ver.set(getContentVersion(100, 1L, "all_room3D"));
      ((List)localObject2).add(localObject3);
      ((CmShowContentUpdate.STContUpdReq)localObject1).cont_list.set((List)localObject2);
      try
      {
        localObject3 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("8.5.5");
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
      catch (Exception paramAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.e("rscContent_CmShowRscUpdateHandler", 2, "OpenPandora failed ", paramAppInterface);
  }
  
  public void checkUpdateAsync(AppInterface paramAppInterface)
  {
    ThreadManagerV2.excute(new CmShowRscUpdateHandlerImpl.1(this, paramAppInterface), 16, null, false);
  }
  
  public int getContentVersion(int paramInt, long paramLong, String paramString)
  {
    return this.mSharedPreferences.getInt(paramInt + "_" + paramLong + "_" + paramString, 0);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    for (;;)
    {
      return;
      paramInt = paramBundle.getInt("extra_result_code");
      Object localObject = paramBundle.getString("extra_cmd");
      str = paramBundle.getString("extra_callbackid");
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "isSuccess:" + paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "svrRet:" + paramInt + " cmd:" + (String)localObject + " requestIdStr:" + str);
      }
      if (!paramBoolean) {
        break label280;
      }
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom(arrayOfByte);
        long l = paramBundle.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "retCode:" + l + " isSuccess:" + paramBoolean + " cmd:" + (String)localObject);
        }
        if ("cmshowar_content_update.check".equals(localObject)) {
          if (l == 0L)
          {
            localObject = new CmShowContentUpdate.STContUpdRsp();
            ((CmShowContentUpdate.STContUpdRsp)localObject).mergeFrom(paramBundle.pbRsqData.get().toByteArray());
            onGetJsonDone(ApolloUtilImpl.parseToInt(str), (CmShowContentUpdate.STContUpdRsp)localObject, true);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("rscContent_CmShowRscUpdateHandler", 1, paramBundle, new Object[0]);
        return;
      }
    }
    onContentCheckFailed(ApolloUtilImpl.parseToInt(str));
    return;
    label280:
    onContentCheckFailed(ApolloUtilImpl.parseToInt(str));
  }
  
  public void removeCheckLisntener(int paramInt)
  {
    synchronized (this.mCheckContentListeners)
    {
      this.mCheckContentListeners.remove(paramInt);
      return;
    }
  }
  
  public void saveContentVersion(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.mSharedPreferences.edit().putInt(paramInt1 + "_" + paramLong + "_" + paramString, paramInt2).commit();
  }
  
  public void saveContentVersion(CmShowRscUpdateHandlerImpl.ContentUpdateCheckResult paramContentUpdateCheckResult, int paramInt)
  {
    if (paramContentUpdateCheckResult != null)
    {
      this.mSharedPreferences.edit().putInt(paramContentUpdateCheckResult.a(), paramInt).commit();
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "saveContentVersion version:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.CmShowRscUpdateHandlerImpl
 * JD-Core Version:    0.7.0.1
 */