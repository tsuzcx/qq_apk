package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.utils.MsgUtils;

public class TempMsgBoxCallback
  implements ITempMsgBoxCallback
{
  public int a(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, Message paramMessage)
  {
    return QCallFacade.a((QQAppInterface)paramAppInterface, paramString, paramInt1, paramInt2, null).a();
  }
  
  public void a(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    MsgUtils.a(paramContext, paramBaseQQAppInterface, paramMessage, paramInt, paramMsgSummary, paramBoolean1, paramBoolean2);
  }
  
  public boolean a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    paramAppInterface = (TempMsgManager)paramAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
    short s;
    if (paramInt != 1000)
    {
      if (paramInt != 1024)
      {
        if (paramInt != 1005)
        {
          if (paramInt != 1006) {
            return false;
          }
          s = -23310;
        }
        else
        {
          s = -23309;
        }
      }
      else {
        s = -20457;
      }
    }
    else {
      s = -23308;
    }
    return paramAppInterface.b(s);
  }
  
  public String b(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, Message paramMessage)
  {
    return QCallFacade.a((QQAppInterface)paramAppInterface, paramString, paramInt1, paramInt2, null).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxCallback
 * JD-Core Version:    0.7.0.1
 */