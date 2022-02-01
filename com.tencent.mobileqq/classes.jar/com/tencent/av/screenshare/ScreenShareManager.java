package com.tencent.av.screenshare;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ReqGroupVideo.MsgScreenShareAnswer;
import com.tencent.av.ReqGroupVideo.MsgScreenShareAsk;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.BusinessHandlerFactory;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import mqq.util.WeakReference;

public class ScreenShareManager
  extends BusinessManager
  implements Handler.Callback
{
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private WeakReference<AVActivity> jdField_a_of_type_MqqUtilWeakReference = null;
  
  public ScreenShareManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void a(String paramString, long paramLong)
  {
    paramString = new ScreenShareManager.3(this, paramString);
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(paramString, paramLong);
  }
  
  public void a() {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 1;
    QLog.i("ScreenShareManager", 2, "onReceivePushMsg");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("ScreenShareManager", 2, "onReceivePushMsg, param illegal.");
      }
    }
    for (;;)
    {
      return;
      int j = 0;
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.arg1 = paramInt;
      Object localObject;
      if (paramInt == 5)
      {
        localObject = new ReqGroupVideo.MsgScreenShareAsk();
        try
        {
          ((ReqGroupVideo.MsgScreenShareAsk)localObject).mergeFrom(paramArrayOfByte);
          localMessage.obj = localObject;
          paramInt = i;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ScreenShareManager", 2, "onReceivePushMsg MsgScreenShareAsk", paramArrayOfByte);
            }
            paramInt = 0;
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ScreenShareManager", 2, "onReceivePushMsg MsgScreenShareAsk", paramArrayOfByte);
            }
            paramInt = 0;
          }
        }
        i = paramInt;
      }
      while (i != 0)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
        return;
        i = j;
        if (paramInt == 6)
        {
          localObject = new ReqGroupVideo.MsgScreenShareAnswer();
          try
          {
            ((ReqGroupVideo.MsgScreenShareAnswer)localObject).mergeFrom(paramArrayOfByte);
            localMessage.obj = localObject;
            i = 1;
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            i = j;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("ScreenShareManager", 2, "onReceivePushMsg MsgScreenShareAnswer", paramArrayOfByte);
            i = j;
          }
          catch (Throwable paramArrayOfByte)
          {
            i = j;
          }
          if (QLog.isColorLevel())
          {
            QLog.i("ScreenShareManager", 2, "onReceivePushMsg MsgScreenShareAnswer", paramArrayOfByte);
            i = j;
          }
        }
      }
    }
  }
  
  public void a(AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVActivity);
  }
  
  public void a(String paramString1, String paramString2)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    ScreenShareCtrl localScreenShareCtrl = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    AVActivity localAVActivity;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      localAVActivity = (AVActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((localAVActivity != null) && (!localAVActivity.isFinishing()) && (!localAVActivity.isDestroyed())) {}
    }
    else
    {
      return;
    }
    DialogUtil.a(localAVActivity, 230, localBaseApplication.getString(2131718840), paramString1, 2131718839, 2131718837, new ScreenShareManager.1(this, localScreenShareCtrl, paramString2), new ScreenShareManager.2(this, paramString2)).show();
    ReportController.b(null, "dc00898", "", "", "0X800B8A8", "0X800B8A8", 0, 0, paramString2, "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    ((ScreenShareHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.f)).a(paramBoolean);
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public void b()
  {
    ((ScreenShareHandler)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getBusinessHandler(BusinessHandlerFactory.f)).a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (paramMessage.obj != null)
      {
        QLog.i("ScreenShareManager", 1, "handleMessage msgtype:" + paramMessage.arg1);
        if (paramMessage.arg1 == 5)
        {
          paramMessage = (ReqGroupVideo.MsgScreenShareAsk)paramMessage.obj;
          a(paramMessage.ask_wording.get().toStringUtf8(), String.valueOf(paramMessage.from_uin.get()));
        }
        while (QLog.isDevelopLevel())
        {
          QLog.i("ScreenShareManager", 4, "onQavPushMsg");
          return true;
          if ((paramMessage.arg1 == 6) && (!((ReqGroupVideo.MsgScreenShareAnswer)paramMessage.obj).is_accept.get())) {
            a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().e + BaseApplicationImpl.getContext().getString(2131718841), 0L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareManager
 * JD-Core Version:    0.7.0.1
 */