import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aoev
  implements INetInfoHandler
{
  private static WeakReference<QQAppInterface> a;
  
  public aoev(QQAppInterface paramQQAppInterface)
  {
    a = new WeakReference(paramQQAppInterface);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "type:" + paramInt + ",logmsg:" + paramString);
    }
    if ((a == null) || (a.get() == null)) {}
    do
    {
      return;
      if (1 == paramInt)
      {
        ((QQAppInterface)a.get()).G();
        return;
      }
    } while (2 != paramInt);
    ((QQAppInterface)a.get()).H();
  }
  
  public void onNetMobile2None()
  {
    a(3, "onNetMobile2None");
    awuz.a("Network", "onNetMobile2None()");
    if ((a == null) || (a.get() == null)) {}
    do
    {
      return;
      MqqHandler localMqqHandler = ((QQAppInterface)a.get()).getHandler(atur.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)a.get()).getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, QQAppInterface.a((QQAppInterface)a.get()).getString(2131691989)).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)a.get()).getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(28, null).sendToTarget();
      }
      besx.a().a();
      bexr.a().a();
      ((QQAppInterface)a.get()).getHttpCommunicatort().a(1);
      QQHeadDownloadHandler.b();
    } while (QQAppInterface.i((QQAppInterface)a.get()) == null);
    QQAppInterface.j((QQAppInterface)a.get()).onNetMobile2None();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    a(2, "onNetMobile2Wifi");
    awuz.a("Network", "onNetMobile2Wifi()");
    if ((a == null) || (a.get() == null)) {}
    do
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
      MqqHandler localMqqHandler = localQQAppInterface.getHandler(atur.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, null).sendToTarget();
      }
      besx.a().a();
      bexr.a().a();
      localQQAppInterface.getHttpCommunicatort().a(1);
      QQHeadDownloadHandler.b();
      if (QQAppInterface.g(localQQAppInterface) != null) {
        QQAppInterface.h(localQQAppInterface).onNetMobile2Wifi(paramString);
      }
      localQQAppInterface.a();
      paramString = (asde)localQQAppInterface.getManager(77);
      if (paramString != null) {
        paramString.a();
      }
      ozs.a(localQQAppInterface);
      paramString = localQQAppInterface.getHandler(ShortVideoPlayActivity.class);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onNetMobile2Wifi");
    }
    paramString.obtainMessage(5).sendToTarget();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    a(1, "onNetNone2Mobile");
    awuz.a("Network", "onNetNone2Mobile()");
    if ((a == null) || (a.get() == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
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
    besx.a().a();
    bexr.a().a();
    localQQAppInterface.getHttpCommunicatort().a(2);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.a(localQQAppInterface) != null) {
      QQAppInterface.b(localQQAppInterface).onNetNone2Mobile(paramString);
    }
    paramString = (asde)localQQAppInterface.getManager(77);
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
    nqq.a().b();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a(2, "onNetNone2Wifi");
    awuz.a("Network", "onNetNone2Wifi()");
    if ((a == null) || (a.get() == null)) {}
    do
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
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
      besx.a().a();
      bexr.a().a();
      localQQAppInterface.getHttpCommunicatort().a(1);
      QQHeadDownloadHandler.b();
      if (QQAppInterface.e(localQQAppInterface) != null) {
        QQAppInterface.f(localQQAppInterface).onNetNone2Wifi(paramString);
      }
      localQQAppInterface.a();
      paramString = (asde)localQQAppInterface.getManager(77);
      if (paramString != null) {
        paramString.a();
      }
      ozs.a(localQQAppInterface);
      paramString = localQQAppInterface.getHandler(ShortVideoPlayActivity.class);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Wifi");
    }
    paramString.obtainMessage(5).sendToTarget();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    a(1, "onNetWifi2Mobile");
    Object localObject = azqz.a();
    if (localObject != null) {
      ((azqz)localObject).b();
    }
    awuz.a("Network", "onNetWifi2Mobile()");
    if ((a == null) || (a.get() == null)) {
      return;
    }
    localObject = (QQAppInterface)a.get();
    MqqHandler localMqqHandler = ((QQAppInterface)localObject).getHandler(atur.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = ((QQAppInterface)localObject).getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10003, null).sendToTarget();
    }
    besx.a().a();
    bexr.a().a();
    ((QQAppInterface)localObject).getHttpCommunicatort().a(2);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.c((QQAppInterface)localObject) != null) {
      QQAppInterface.d((QQAppInterface)localObject).onNetWifi2Mobile(paramString);
    }
    paramString = (asde)((QQAppInterface)localObject).getManager(77);
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
    nqq.a().b();
  }
  
  public void onNetWifi2None()
  {
    a(3, "onNetWifi2None");
    awuz.a("Network", "onNetWifi2None()");
    if ((a == null) || (a.get() == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)a.get();
      MqqHandler localMqqHandler = localQQAppInterface.getHandler(atur.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, QQAppInterface.b(localQQAppInterface).getString(2131691989)).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(28, null).sendToTarget();
      }
      besx.a().a();
      bexr.a().a();
      localQQAppInterface.getHttpCommunicatort().a(1);
      QQHeadDownloadHandler.b();
    } while (QQAppInterface.k(localQQAppInterface) == null);
    QQAppInterface.l(localQQAppInterface).onNetWifi2None();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoev
 * JD-Core Version:    0.7.0.1
 */