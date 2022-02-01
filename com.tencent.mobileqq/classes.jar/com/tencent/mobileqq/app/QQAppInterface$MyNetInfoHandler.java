package com.tencent.mobileqq.app;

import android.os.Message;
import aqxc;
import ashb;
import avif;
import ayeh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import nrz;
import pay;

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
    avif.a("Network", "onNetMobile2None()");
    if ((mApp == null) || (mApp.get() == null)) {}
    do
    {
      return;
      MqqHandler localMqqHandler = ((QQAppInterface)mApp.get()).getHandler(ashb.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)mApp.get()).getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, QQAppInterface.access$800((QQAppInterface)mApp.get()).getString(2131692035)).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)mApp.get()).getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(28, null).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
      ((QQAppInterface)mApp.get()).getHttpCommunicatort().setCouncurrentNumber(1);
      QQHeadDownloadHandler.clearIpList();
    } while (QQAppInterface.access$900((QQAppInterface)mApp.get()) == null);
    QQAppInterface.access$1000((QQAppInterface)mApp.get()).onNetMobile2None();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    onNetChange4RawPhoto(2, "onNetMobile2Wifi");
    avif.a("Network", "onNetMobile2Wifi()");
    if ((mApp == null) || (mApp.get() == null)) {}
    do
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)mApp.get();
      MqqHandler localMqqHandler = localQQAppInterface.getHandler(ashb.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, null).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
      localQQAppInterface.getHttpCommunicatort().setCouncurrentNumber(1);
      QQHeadDownloadHandler.clearIpList();
      if (QQAppInterface.access$600(localQQAppInterface) != null) {
        QQAppInterface.access$700(localQQAppInterface).onNetMobile2Wifi(paramString);
      }
      localQQAppInterface.tryReuploadQfavItems();
      paramString = (aqxc)localQQAppInterface.getManager(77);
      if (paramString != null) {
        paramString.a();
      }
      pay.a(localQQAppInterface);
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
    avif.a("Network", "onNetNone2Mobile()");
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
    localQQAppInterface.getHttpCommunicatort().setCouncurrentNumber(2);
    QQHeadDownloadHandler.clearIpList();
    if (QQAppInterface.access$000(localQQAppInterface) != null) {
      QQAppInterface.access$100(localQQAppInterface).onNetNone2Mobile(paramString);
    }
    paramString = (aqxc)localQQAppInterface.getManager(77);
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
    nrz.a().b();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    onNetChange4RawPhoto(2, "onNetNone2Wifi");
    avif.a("Network", "onNetNone2Wifi()");
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
      localQQAppInterface.getHttpCommunicatort().setCouncurrentNumber(1);
      QQHeadDownloadHandler.clearIpList();
      if (QQAppInterface.access$400(localQQAppInterface) != null) {
        QQAppInterface.access$500(localQQAppInterface).onNetNone2Wifi(paramString);
      }
      localQQAppInterface.tryReuploadQfavItems();
      paramString = (aqxc)localQQAppInterface.getManager(77);
      if (paramString != null) {
        paramString.a();
      }
      pay.a(localQQAppInterface);
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
    Object localObject = ayeh.a();
    if (localObject != null) {
      ((ayeh)localObject).b();
    }
    avif.a("Network", "onNetWifi2Mobile()");
    if ((mApp == null) || (mApp.get() == null)) {
      return;
    }
    localObject = (QQAppInterface)mApp.get();
    MqqHandler localMqqHandler = ((QQAppInterface)localObject).getHandler(ashb.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = ((QQAppInterface)localObject).getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10003, null).sendToTarget();
    }
    FMTSrvAddrProvider.getInstance().clear();
    SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
    ((QQAppInterface)localObject).getHttpCommunicatort().setCouncurrentNumber(2);
    QQHeadDownloadHandler.clearIpList();
    if (QQAppInterface.access$200((QQAppInterface)localObject) != null) {
      QQAppInterface.access$300((QQAppInterface)localObject).onNetWifi2Mobile(paramString);
    }
    paramString = (aqxc)((QQAppInterface)localObject).getManager(77);
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
    nrz.a().b();
  }
  
  public void onNetWifi2None()
  {
    onNetChange4RawPhoto(3, "onNetWifi2None");
    avif.a("Network", "onNetWifi2None()");
    if ((mApp == null) || (mApp.get() == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)mApp.get();
      MqqHandler localMqqHandler = localQQAppInterface.getHandler(ashb.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, QQAppInterface.access$1100(localQQAppInterface).getString(2131692035)).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(28, null).sendToTarget();
      }
      FMTSrvAddrProvider.getInstance().clear();
      SosoSrvAddrProvider.getInstance().clearSpAndBrocast();
      localQQAppInterface.getHttpCommunicatort().setCouncurrentNumber(1);
      QQHeadDownloadHandler.clearIpList();
    } while (QQAppInterface.access$1200(localQQAppInterface) == null);
    QQAppInterface.access$1300(localQQAppInterface).onNetWifi2None();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.MyNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */