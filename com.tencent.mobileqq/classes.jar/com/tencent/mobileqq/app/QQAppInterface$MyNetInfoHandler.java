package com.tencent.mobileqq.app;

import android.os.Message;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class QQAppInterface$MyNetInfoHandler
  implements INetInfoHandler
{
  private static WeakReference<QQAppInterface> mApp;
  
  public QQAppInterface$MyNetInfoHandler(QQAppInterface paramQQAppInterface)
  {
    mApp = new WeakReference(paramQQAppInterface);
  }
  
  private void onNetChange4RawPhoto(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "type:" + paramInt + ",logmsg:" + paramString);
    }
    if ((mApp == null) || (mApp.get() == null)) {}
    do
    {
      return;
      if (1 == paramInt)
      {
        ((QQAppInterface)mApp.get()).onX2Mobile();
        return;
      }
    } while (2 != paramInt);
    ((QQAppInterface)mApp.get()).onX2Wifi();
  }
  
  public void onNetMobile2None()
  {
    onNetChange4RawPhoto(3, "onNetMobile2None");
    ReportLog.a("Network", "onNetMobile2None()");
    if ((mApp == null) || (mApp.get() == null)) {}
    do
    {
      return;
      MqqHandler localMqqHandler = ((QQAppInterface)mApp.get()).getHandler(FileManagerNotifyCenter.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)mApp.get()).getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, QQAppInterface.access$800((QQAppInterface)mApp.get()).getString(2131692257)).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)mApp.get()).getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(28, null).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
      ((HttpCommunicator)((IHttpEngineService)((QQAppInterface)mApp.get()).getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(1);
    } while (QQAppInterface.access$900((QQAppInterface)mApp.get()) == null);
    QQAppInterface.access$1000((QQAppInterface)mApp.get()).onNetMobile2None();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    onNetChange4RawPhoto(2, "onNetMobile2Wifi");
    ReportLog.a("Network", "onNetMobile2Wifi()");
    if ((mApp == null) || (mApp.get() == null)) {}
    do
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)mApp.get();
      MqqHandler localMqqHandler = localQQAppInterface.getHandler(FileManagerNotifyCenter.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, null).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
      ((HttpCommunicator)((IHttpEngineService)localQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(1);
      if (QQAppInterface.access$600(localQQAppInterface) != null) {
        QQAppInterface.access$700(localQQAppInterface).onNetMobile2Wifi(paramString);
      }
      localQQAppInterface.tryReuploadQfavItems();
      paramString = (EarlyDownloadManager)localQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      if (paramString != null) {
        paramString.a();
      }
      ReadInJoyUtils.a(localQQAppInterface);
      paramString = localQQAppInterface.getHandler(ShortVideoPlayActivity.class);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onNetMobile2Wifi");
    }
    paramString.obtainMessage(5).sendToTarget();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    onNetChange4RawPhoto(1, "onNetNone2Mobile");
    ReportLog.a("Network", "onNetNone2Mobile()");
    if ((mApp == null) || (mApp.get() == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)mApp.get();
    MqqHandler localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10003, null).sendToTarget();
    }
    localMqqHandler = localQQAppInterface.getHandler(ChatHistory.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(6, null).sendToTarget();
    }
    localMqqHandler = localQQAppInterface.getHandler(ChatHistoryC2CAllFragment.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(27).sendToTarget();
    }
    FMTSrvAddrProvider.getInstance().clear();
    SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
    ((HttpCommunicator)((IHttpEngineService)localQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(2);
    if (QQAppInterface.access$000(localQQAppInterface) != null) {
      QQAppInterface.access$100(localQQAppInterface).onNetNone2Mobile(paramString);
    }
    paramString = (EarlyDownloadManager)localQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
    if (paramString != null) {
      paramString.a();
    }
    paramString = localQQAppInterface.getHandler(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Mobile");
      }
      paramString.obtainMessage(4).sendToTarget();
    }
    NowVideoController.a().b();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    onNetChange4RawPhoto(2, "onNetNone2Wifi");
    ReportLog.a("Network", "onNetNone2Wifi()");
    if ((mApp == null) || (mApp.get() == null)) {}
    do
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)mApp.get();
      MqqHandler localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(ChatHistory.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(6, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(27).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
      ((HttpCommunicator)((IHttpEngineService)localQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(1);
      if (QQAppInterface.access$400(localQQAppInterface) != null) {
        QQAppInterface.access$500(localQQAppInterface).onNetNone2Wifi(paramString);
      }
      localQQAppInterface.tryReuploadQfavItems();
      paramString = (EarlyDownloadManager)localQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      if (paramString != null) {
        paramString.a();
      }
      ReadInJoyUtils.a(localQQAppInterface);
      paramString = localQQAppInterface.getHandler(ShortVideoPlayActivity.class);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Wifi");
    }
    paramString.obtainMessage(5).sendToTarget();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    onNetChange4RawPhoto(1, "onNetWifi2Mobile");
    Object localObject = PresendPicMgrService.a();
    if (localObject != null) {
      ((PresendPicMgrService)localObject).b();
    }
    ReportLog.a("Network", "onNetWifi2Mobile()");
    if ((mApp == null) || (mApp.get() == null)) {
      return;
    }
    localObject = (QQAppInterface)mApp.get();
    MqqHandler localMqqHandler = ((QQAppInterface)localObject).getHandler(FileManagerNotifyCenter.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = ((QQAppInterface)localObject).getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10003, null).sendToTarget();
    }
    FMTSrvAddrProvider.getInstance().clear();
    SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
    ((HttpCommunicator)((IHttpEngineService)((QQAppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(2);
    if (QQAppInterface.access$200((QQAppInterface)localObject) != null) {
      QQAppInterface.access$300((QQAppInterface)localObject).onNetWifi2Mobile(paramString);
    }
    paramString = (EarlyDownloadManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
    if (paramString != null) {
      paramString.a();
    }
    paramString = ((QQAppInterface)localObject).getHandler(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetWifi2Mobile");
      }
      paramString.obtainMessage(4).sendToTarget();
    }
    NowVideoController.a().b();
  }
  
  public void onNetWifi2None()
  {
    onNetChange4RawPhoto(3, "onNetWifi2None");
    ReportLog.a("Network", "onNetWifi2None()");
    if ((mApp == null) || (mApp.get() == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)mApp.get();
      MqqHandler localMqqHandler = localQQAppInterface.getHandler(FileManagerNotifyCenter.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, QQAppInterface.access$1100(localQQAppInterface).getString(2131692257)).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(28, null).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
      ((HttpCommunicator)((IHttpEngineService)localQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(1);
    } while (QQAppInterface.access$1200(localQQAppInterface) == null);
    QQAppInterface.access$1300(localQQAppInterface).onNetWifi2None();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.MyNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */