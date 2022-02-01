package com.tencent.mobileqq.activity.history;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryC2CAllFragment$1
  implements Handler.Callback
{
  ChatHistoryC2CAllFragment$1(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.C2CAllFragment", 2, new Object[] { "handleMessage ", Integer.valueOf(paramMessage.what) });
    }
    int i = paramMessage.what;
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3) && (i != 4))
    {
      if (i == 11) {
        break label473;
      }
      if (i != 33) {
        if (i == 34) {}
      }
    }
    switch (i)
    {
    default: 
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            return true;
          }
          this.a.e(paramMessage);
          return true;
        case 41: 
          ChatHistoryC2CAllFragment.c(this.a, paramMessage);
          return true;
        case 40: 
          ChatHistoryC2CAllFragment.b(this.a, paramMessage);
          return true;
        }
        ChatHistoryC2CAllFragment.a(this.a, paramMessage);
        return true;
      case 29: 
        ChatHistoryC2CAllFragment.d(this.a, paramMessage);
        return true;
      case 26: 
        ChatHistoryC2CAllFragment.a(this.a);
        return true;
      case 24: 
      case 25: 
        this.a.b(paramMessage);
        return true;
      case 22: 
      case 23: 
        this.a.a(paramMessage);
        return true;
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
        this.a.f(paramMessage);
        return true;
      case 14: 
      case 15: 
        this.a.c(paramMessage);
        return true;
      case 13: 
        if (paramMessage.obj != null)
        {
          ChatHistoryC2CAllFragment localChatHistoryC2CAllFragment = this.a;
          BaseApplication localBaseApplication = localChatHistoryC2CAllFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          if (((Boolean)paramMessage.obj).booleanValue() == true) {
            i = 2131692093;
          } else {
            i = 2131692092;
          }
          localChatHistoryC2CAllFragment.c(localBaseApplication.getString(i));
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.C2CAllFragment", 2, "handle_get_roam_msg_auth_mode notify UI");
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.f())
          {
            this.a.c(false);
            return true;
          }
          this.a.u();
          return true;
        }
        break;
      case 27: 
      case 28: 
        this.a.d(paramMessage);
        return true;
      }
      break;
    case 8: 
    case 9: 
      this.a.g(paramMessage);
    }
    label473:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.1
 * JD-Core Version:    0.7.0.1
 */