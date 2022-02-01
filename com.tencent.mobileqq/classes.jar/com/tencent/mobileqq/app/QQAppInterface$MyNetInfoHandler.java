package com.tencent.mobileqq.app;

import android.os.Message;
import com.tencent.biz.now.NowVideoController;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.aio.NetStateTipsObserver;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.troop.soso.SosoSrvAddrProvider;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.ReportLog;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("type:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",logmsg:");
      localStringBuilder.append(paramString);
      QLog.d("raw_photo", 2, localStringBuilder.toString());
    }
    paramString = mApp;
    if (paramString != null)
    {
      if (paramString.get() == null) {
        return;
      }
      if (1 == paramInt)
      {
        ((QQAppInterface)mApp.get()).onX2Mobile();
        return;
      }
      if (2 == paramInt) {
        ((QQAppInterface)mApp.get()).onX2Wifi();
      }
    }
  }
  
  public void onNetMobile2None()
  {
    onNetChange4RawPhoto(3, "onNetMobile2None");
    ReportLog.a("Network", "onNetMobile2None()");
    Object localObject = mApp;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = ((QQAppInterface)mApp.get()).getHandler(FileManagerNotifyCenter.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10001, null).sendToTarget();
      }
      localObject = ((QQAppInterface)mApp.get()).getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10003, QQAppInterface.access$900((QQAppInterface)mApp.get()).getString(2131889169)).sendToTarget();
      }
      ((QQAppInterface)mApp.get()).notifyObservers(NetStateTipsObserver.class, 1, true, null);
      localObject = ((QQAppInterface)mApp.get()).getHandler(ChatHistoryC2CAllFragment.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(28, null).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.a().b();
      ((HttpCommunicator)((IHttpEngineService)((QQAppInterface)mApp.get()).getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(1);
      if (QQAppInterface.access$1000((QQAppInterface)mApp.get()) != null) {
        QQAppInterface.access$1100((QQAppInterface)mApp.get()).onNetMobile2None();
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    onNetChange4RawPhoto(2, "onNetMobile2Wifi");
    ReportLog.a("Network", "onNetMobile2Wifi()");
    Object localObject = mApp;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
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
      ((QQAppInterface)localObject).notifyObservers(NetStateTipsObserver.class, 1, true, null);
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.a().b();
      ((HttpCommunicator)((IHttpEngineService)((QQAppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(1);
      if (QQAppInterface.access$700((QQAppInterface)localObject) != null) {
        QQAppInterface.access$800((QQAppInterface)localObject).onNetMobile2Wifi(paramString);
      }
      ((QQAppInterface)localObject).tryReuploadQfavItems();
      paramString = (IEarlyDownloadService)((QQAppInterface)localObject).getRuntimeService(IEarlyDownloadService.class, "");
      if (paramString != null) {
        paramString.onNetChanged();
      }
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).handNet2Wifi();
      paramString = ((QQAppInterface)localObject).getHandler(ShortVideoPlayActivity.class);
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onNetMobile2Wifi");
        }
        paramString.obtainMessage(5).sendToTarget();
      }
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    onNetChange4RawPhoto(1, "onNetNone2Mobile");
    ReportLog.a("Network", "onNetNone2Mobile()");
    Object localObject = mApp;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (QQAppInterface)mApp.get();
      MqqHandler localMqqHandler = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, null).sendToTarget();
      }
      QQAppInterface.access$000((QQAppInterface)localObject);
      ((QQAppInterface)localObject).notifyObservers(NetStateTipsObserver.class, 1, true, null);
      localMqqHandler = ((QQAppInterface)localObject).getHandler(ChatHistory.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(6, null).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)localObject).getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(27).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.a().b();
      ((HttpCommunicator)((IHttpEngineService)((QQAppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(2);
      if (QQAppInterface.access$100((QQAppInterface)localObject) != null) {
        QQAppInterface.access$200((QQAppInterface)localObject).onNetNone2Mobile(paramString);
      }
      paramString = (IEarlyDownloadService)((QQAppInterface)localObject).getRuntimeService(IEarlyDownloadService.class, "");
      if (paramString != null) {
        paramString.onNetChanged();
      }
      paramString = ((QQAppInterface)localObject).getHandler(ShortVideoPlayActivity.class);
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Mobile");
        }
        paramString.obtainMessage(4).sendToTarget();
      }
      NowVideoController.a().c();
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    onNetChange4RawPhoto(2, "onNetNone2Wifi");
    ReportLog.a("Network", "onNetNone2Wifi()");
    Object localObject = mApp;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (QQAppInterface)mApp.get();
      MqqHandler localMqqHandler = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, null).sendToTarget();
      }
      QQAppInterface.access$000((QQAppInterface)localObject);
      ((QQAppInterface)localObject).notifyObservers(NetStateTipsObserver.class, 1, true, null);
      localMqqHandler = ((QQAppInterface)localObject).getHandler(ChatHistory.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(6, null).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)localObject).getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(27).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.a().b();
      ((HttpCommunicator)((IHttpEngineService)((QQAppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(1);
      if (QQAppInterface.access$500((QQAppInterface)localObject) != null) {
        QQAppInterface.access$600((QQAppInterface)localObject).onNetNone2Wifi(paramString);
      }
      ((QQAppInterface)localObject).tryReuploadQfavItems();
      paramString = (IEarlyDownloadService)((QQAppInterface)localObject).getRuntimeService(IEarlyDownloadService.class, "");
      if (paramString != null) {
        paramString.onNetChanged();
      }
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).handNet2Wifi();
      paramString = ((QQAppInterface)localObject).getHandler(ShortVideoPlayActivity.class);
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Wifi");
        }
        paramString.obtainMessage(5).sendToTarget();
      }
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    onNetChange4RawPhoto(1, "onNetWifi2Mobile");
    Object localObject = PresendPicMgrService.e();
    if (localObject != null) {
      ((PresendPicMgrService)localObject).f();
    }
    ReportLog.a("Network", "onNetWifi2Mobile()");
    localObject = mApp;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
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
      ((QQAppInterface)localObject).notifyObservers(NetStateTipsObserver.class, 1, true, null);
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.a().b();
      ((HttpCommunicator)((IHttpEngineService)((QQAppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(2);
      if (QQAppInterface.access$300((QQAppInterface)localObject) != null) {
        QQAppInterface.access$400((QQAppInterface)localObject).onNetWifi2Mobile(paramString);
      }
      paramString = (IEarlyDownloadService)((QQAppInterface)localObject).getRuntimeService(IEarlyDownloadService.class, "");
      if (paramString != null) {
        paramString.onNetChanged();
      }
      paramString = ((QQAppInterface)localObject).getHandler(ShortVideoPlayActivity.class);
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onNetWifi2Mobile");
        }
        paramString.obtainMessage(4).sendToTarget();
      }
      NowVideoController.a().c();
    }
  }
  
  public void onNetWifi2None()
  {
    onNetChange4RawPhoto(3, "onNetWifi2None");
    ReportLog.a("Network", "onNetWifi2None()");
    Object localObject = mApp;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (QQAppInterface)mApp.get();
      MqqHandler localMqqHandler = ((QQAppInterface)localObject).getHandler(FileManagerNotifyCenter.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, QQAppInterface.access$1200((QQAppInterface)localObject).getString(2131889169)).sendToTarget();
      }
      ((QQAppInterface)localObject).notifyObservers(NetStateTipsObserver.class, 1, true, null);
      localMqqHandler = ((QQAppInterface)localObject).getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(28, null).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.a().b();
      ((HttpCommunicator)((IHttpEngineService)((QQAppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).setCouncurrentNumber(1);
      if (QQAppInterface.access$1300((QQAppInterface)localObject) != null) {
        QQAppInterface.access$1400((QQAppInterface)localObject).onNetWifi2None();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.MyNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */