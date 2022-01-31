package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.List;
import mqq.app.AppRuntime;
import xfw;
import xfx;

public class PreloadManagerProxy
  extends PreloadManagerAbs
{
  private static volatile PreloadManagerProxy a;
  
  private PreloadManagerProxy(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    QWalletIPCConnector.a().a();
  }
  
  public static ResultReceiver a(ResultReceiver paramResultReceiver)
  {
    if (paramResultReceiver == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    paramResultReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramResultReceiver;
  }
  
  public static PreloadManagerProxy a(AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManagerProxy == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManagerProxy == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManagerProxy = new PreloadManagerProxy(paramAppRuntime);
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManagerProxy;
    }
    finally {}
  }
  
  private void a(String paramString1, Bundle paramBundle, PreloadManager.DownloadCallback paramDownloadCallback, String paramString2)
  {
    paramBundle.putParcelable("receiver", a(new PreloadManagerProxy.1(this, null, paramDownloadCallback, paramString2)));
    if (paramString1.equals("downloadModule")) {
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadModule", paramBundle, null);
    }
    while (!paramString1.equals("downloadRes")) {
      return;
    }
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "downloadRes", paramBundle, null);
  }
  
  public PreloadResource a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManagerProxy", 2, "getResourceByResID:" + paramString + "|" + localObject1);
      }
      return localObject1;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("res_id", paramString);
      QWalletIPCConnector.a().a();
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getResourceByResID", (Bundle)localObject1);
      localObject1 = localObject2;
      if (localEIPCResult != null)
      {
        localObject1 = localObject2;
        if (localEIPCResult.isSuccess()) {
          localObject1 = (PreloadResource)localEIPCResult.data.getSerializable("res_info");
        }
      }
    }
  }
  
  public void a(String paramString, ResultReceiver paramResultReceiver)
  {
    if (paramResultReceiver == null) {
      return;
    }
    if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString);
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "getFilePathByResID", localBundle, new xfw(this, paramResultReceiver));
      return;
    }
    paramResultReceiver.send(0, null);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, PreloadManager.OnGetPathListener paramOnGetPathListener, boolean paramBoolean)
  {
    if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      localBundle = new Bundle();
      localBundle.putInt("method_type", 1);
      localBundle.putString("url", paramString1);
      localBundle.putString("md5", paramString2);
      localBundle.putLong("md5_time", paramLong);
      localBundle.putBoolean("is_force_unzip", paramBoolean);
      QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", localBundle, new xfx(this, paramOnGetPathListener, paramString1));
    }
    while (paramOnGetPathListener == null)
    {
      Bundle localBundle;
      return;
    }
    paramOnGetPathListener.onResult(1, PreloadManager.PathResult.getFailRes(paramString1));
  }
  
  public void a(String paramString1, String paramString2, PreloadManager.DownloadCallback paramDownloadCallback)
  {
    if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString1);
      localBundle.putString("config_str", paramString2);
      a("downloadModule", localBundle, paramDownloadCallback, paramString1);
    }
  }
  
  public void a(List paramList, PreloadManager.OnGetPathListener paramOnGetPathListener)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("method_type", 2);
    localBundle.putStringArray("url", (String[])paramList.toArray(new String[paramList.size()]));
    localBundle.putParcelable("receiver", a(new PreloadManagerProxy.4(this, null, paramOnGetPathListener)));
    QIPCClientHelper.getInstance().callServer("QWalletIPCModule", "preloadCommon", localBundle, null);
  }
  
  public String b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManagerProxy", 2, "getVideoResPathByID:" + paramString + "|" + (String)localObject1);
      }
      return localObject1;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("mid", paramString);
      QWalletIPCConnector.a().a();
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getVideoResPathByMID", (Bundle)localObject1);
      localObject1 = localObject2;
      if (localEIPCResult != null)
      {
        localObject1 = localObject2;
        if (localEIPCResult.isSuccess()) {
          localObject1 = localEIPCResult.data.getString("path");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy
 * JD-Core Version:    0.7.0.1
 */