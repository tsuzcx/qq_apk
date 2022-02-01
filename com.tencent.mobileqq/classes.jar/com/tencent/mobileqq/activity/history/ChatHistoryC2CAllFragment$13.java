package com.tencent.mobileqq.activity.history;

import android.os.Bundle;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ChatHistoryC2CAllFragment$13
  extends TeamWorkObserver
{
  ChatHistoryC2CAllFragment$13(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      localObject = (DocsGrayTipsInfo)paramArrayOfObject[0];
      str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (this.a.a.getApp().getString(2131917112).equals(str))
      {
        paramArrayOfObject = this.a.a.getMessageFacade().a(((DocsGrayTipsInfo)localObject).a, 0, l);
        if ((paramArrayOfObject != null) && ((paramArrayOfObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)paramArrayOfObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.b() != null)) {
            ((MessageForUniteGrayTip)localObject).tipParam.c();
          }
          ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsg(this.a.a, str);
          localObject = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", paramArrayOfObject.uniseq);
          ((Message)localObject).setData(localBundle);
          ((Message)localObject).what = 78;
          ((Message)localObject).arg1 = 0;
          this.a.F.sendMessage((Message)localObject);
        }
      }
      QQToast.makeText(this.a.getBaseActivity(), str, 0).show();
      paramArrayOfObject = TeamWorkConstants.j;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onGetUserAuth  isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" tips =");
      ((StringBuilder)localObject).append(str);
      QLog.i(paramArrayOfObject, 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramArrayOfObject)
    {
      String str = TeamWorkConstants.j;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onGetUserAuth  exception = ");
      ((StringBuilder)localObject).append(paramArrayOfObject.toString());
      QLog.e(str, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      str = TeamWorkConstants.j;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onSetUserAuth  isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i(str, 2, ((StringBuilder)localObject).toString());
      localObject = (DocsGrayTipsInfo)paramArrayOfObject[0];
      str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramBoolean)
      {
        paramArrayOfObject = this.a.a.getMessageFacade().a(((DocsGrayTipsInfo)localObject).a, 0, l);
        if ((paramArrayOfObject != null) && ((paramArrayOfObject instanceof MessageForUniteGrayTip)))
        {
          localObject = (MessageForUniteGrayTip)paramArrayOfObject;
          if ((((MessageForUniteGrayTip)localObject).tipParam != null) && (((MessageForUniteGrayTip)localObject).tipParam.b() != null)) {
            ((MessageForUniteGrayTip)localObject).tipParam.c();
          }
          ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsg(this.a.a, str);
          localObject = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", paramArrayOfObject.uniseq);
          ((Message)localObject).setData(localBundle);
          ((Message)localObject).what = 78;
          ((Message)localObject).arg1 = 0;
          this.a.F.sendMessage((Message)localObject);
        }
      }
      QQToast.makeText(this.a.getBaseActivity(), str, 0).show();
      return;
    }
    catch (Exception paramArrayOfObject)
    {
      String str = TeamWorkConstants.j;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onSetUserAuth  exception  = ");
      ((StringBuilder)localObject).append(paramArrayOfObject.toString());
      QLog.e(str, 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.13
 * JD-Core Version:    0.7.0.1
 */