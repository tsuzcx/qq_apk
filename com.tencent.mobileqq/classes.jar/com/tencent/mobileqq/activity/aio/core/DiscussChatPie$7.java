package com.tencent.mobileqq.activity.aio.core;

import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DiscussChatPie$7
  extends MessageObserver
{
  DiscussChatPie$7(DiscussChatPie paramDiscussChatPie) {}
  
  private void a(String paramString)
  {
    try
    {
      if (!this.a.f.isFinishing())
      {
        DialogUtil.a(this.a.f, 230, HardCodeUtil.a(2131901449), this.a.f.getString(2131916240), new DiscussChatPie.7.3(this, paramString), null).show();
        return;
      }
    }
    catch (Throwable paramString)
    {
      String str = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ERR!! send_discussion_msg_failed_not_member:");
      localStringBuilder.append(paramString.getMessage());
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (DiscussChatPie.a(this.a, paramBoolean1, paramList)) {
      return;
    }
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgSend", 4, "delay 100ms, starting upadte ui");
    }
    this.a.j(131072);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramString.equals(this.a.ah.b))
      {
        paramString = this.a;
        paramString.as = true;
        paramString.a(262144, paramMsgSendCostParams, paramLong);
      }
    }
  }
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.j(65536);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.a.ah.b)) && (paramInt1 == this.a.ah.a))
    {
      if (QLog.isColorLevel())
      {
        paramSendMessageHandler = this.a.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateSendMsgError uin ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" type ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" uniseq ");
        localStringBuilder.append(paramLong2);
        QLog.d(paramSendMessageHandler, 2, localStringBuilder.toString());
      }
      if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
      {
        paramSendMessageHandler = this.a.d.getMessageFacade().a(paramString1, paramInt1, paramLong2);
        if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
          MultiMsgManager.a().a(this.a.d, paramString1, paramInt1, paramLong2, false);
        }
      }
      if (paramInt1 == 3000) {
        switch (paramInt2)
        {
        default: 
          if (paramInt2 > 100) {
            QQToast.makeText(this.a.f, paramString2, 0).show(this.a.f.getTitleBarHeight());
          }
          break;
        case 104: 
          if (Looper.myLooper() != Looper.getMainLooper()) {
            this.a.f.runOnUiThread(new DiscussChatPie.7.2(this, paramString1));
          } else {
            a(paramString1);
          }
          break;
        case 103: 
          DialogUtil.a(this.a.f, 230, HardCodeUtil.a(2131901448), this.a.f.getString(2131888756), new DiscussChatPie.7.1(this, paramString1), null).show();
          break;
        case 102: 
          QQToast.makeText(this.a.f, 2131916241, 1).show(this.a.f.getTitleBarHeight());
          break;
        case 101: 
          QQToast.makeText(this.a.f, 2131916239, 1).show(this.a.f.getTitleBarHeight());
        }
      }
      this.a.j(196608);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramSendMessageHandler = this.a.c;
      paramString2 = new StringBuilder();
      paramString2.append("onUpdateSendMsgError exception uin ");
      paramString2.append(paramString1);
      paramString2.append(" type ");
      paramString2.append(paramInt1);
      paramString2.append(" uniseq ");
      paramString2.append(paramLong2);
      QLog.d(paramSendMessageHandler, 2, paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.7
 * JD-Core Version:    0.7.0.1
 */