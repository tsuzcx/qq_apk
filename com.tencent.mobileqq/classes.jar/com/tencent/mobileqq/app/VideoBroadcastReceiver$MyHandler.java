package com.tencent.mobileqq.app;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class VideoBroadcastReceiver$MyHandler
  extends MqqHandler
{
  WeakReference<VideoBroadcastReceiver> a;
  
  public VideoBroadcastReceiver$MyHandler(Looper paramLooper, VideoBroadcastReceiver paramVideoBroadcastReceiver)
  {
    super(paramLooper);
    this.a = new WeakReference(paramVideoBroadcastReceiver);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    Object localObject3 = (VideoBroadcastReceiver)((WeakReference)localObject1).get();
    if (localObject3 == null) {
      return;
    }
    if (VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject3) == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject3).get();
    if (localQQAppInterface == null) {
      return;
    }
    int i = paramMessage.what;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    if (i != 0)
    {
      localObject2 = null;
      localObject1 = null;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            paramMessage = (Intent)((Object[])(Object[])paramMessage.obj)[0];
            localQQAppInterface.getApp().startActivity(paramMessage);
            return;
          }
          paramMessage = (QQCustomDialog)((Object[])(Object[])paramMessage.obj)[0];
          if (paramMessage.isShowing()) {
            paramMessage.dismiss();
          }
        }
        else
        {
          localObject2 = (Object[])paramMessage.obj;
          paramMessage = (Message)localObject1;
          if ((localObject2[0] instanceof QQCustomDialog)) {
            paramMessage = (QQCustomDialog)localObject2[0];
          }
          i = ((Integer)localObject2[1]).intValue();
          int j = ((Integer)localObject2[2]).intValue();
          localObject1 = (String)localObject2[3];
          localObject4 = (String)localObject2[4];
          localObject5 = (String)localObject2[5];
          localObject2 = (String)localObject2[6];
          if ((paramMessage != null) && (paramMessage.isShowing()))
          {
            paramMessage.dismiss();
            if (i == 3000)
            {
              VideoMsgTools.a(localQQAppInterface, i, j, false, (String)localObject1, (String)localObject4, false, null, false, new Object[0]);
              VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject3, 8, i, (String)localObject1, (String)localObject5, (String)localObject2);
            }
            DataReport.e(localQQAppInterface.isBackgroundPause);
          }
        }
      }
      else
      {
        localObject1 = (Object[])paramMessage.obj;
        paramMessage = (Message)localObject2;
        if ((localObject1[0] instanceof QQCustomDialog)) {
          paramMessage = (QQCustomDialog)localObject1[0];
        }
        i = ((Integer)localObject1[1]).intValue();
        boolean bool1 = ((Boolean)localObject1[2]).booleanValue();
        localObject2 = (String)localObject1[3];
        localObject3 = (String)localObject1[4];
        boolean bool2 = ((Boolean)localObject1[5]).booleanValue();
        if ((paramMessage != null) && (paramMessage.isShowing()))
        {
          paramMessage.dismiss();
          VideoMsgTools.a(localQQAppInterface, i, 10, bool1 ^ true, (String)localObject2, (String)localObject3, bool2, null, true, new Object[0]);
          DataReport.c(localQQAppInterface.isBackgroundPause, bool1);
        }
      }
    }
    else
    {
      localObject2 = (Object[])paramMessage.obj;
      i = ((Integer)localObject2[0]).intValue();
      localObject5 = (String)localObject2[1];
      paramMessage = (String)localObject2[2];
      localObject4 = (String)localObject2[3];
      localObject1 = (Context)localObject2[4];
      localObject2 = (String)localObject2[5];
      localObject3 = new SessionInfo();
      ((SessionInfo)localObject3).jdField_a_of_type_Int = i;
      ((SessionInfo)localObject3).d = ((String)localObject5);
      if (i == 1006)
      {
        ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = paramMessage;
        paramMessage = ((IPhoneContactService)localQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
        if (paramMessage != null)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramMessage.nationCode);
          ((StringBuilder)localObject4).append(paramMessage.mobileNo);
          ((SessionInfo)localObject3).e = ((StringBuilder)localObject4).toString();
        }
      }
      else if (i == 1000)
      {
        localObject5 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramMessage);
        if (localObject5 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = VideoBroadcastReceiver.jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("findTroopInfo fail ,uin : ");
            ((StringBuilder)localObject2).append(paramMessage);
            QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          return;
        }
        ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
        ((SessionInfo)localObject3).b = ((TroopInfo)localObject5).troopcode;
        ((SessionInfo)localObject3).c = ((TroopInfo)localObject5).troopuin;
      }
      else if (i == 1004)
      {
        ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
        ((SessionInfo)localObject3).b = paramMessage;
      }
      else
      {
        ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
      }
      ChatActivityFacade.b(localQQAppInterface, (Context)localObject1, (SessionInfo)localObject3, (String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.VideoBroadcastReceiver.MyHandler
 * JD-Core Version:    0.7.0.1
 */