package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgsvc.msg_svc.TransSvrInfo;
import qqcircle.QQCirclePrivateMsgAIO.PrivateMsgTransSvrInfo;

class QCircleChatPie$1
  extends MessageObserver
{
  QCircleChatPie$1(QCircleChatPie paramQCircleChatPie) {}
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((!paramList.isSendFromLocal()) && (!(paramList instanceof MessageForUniteGrayTip)) && (paramList.frienduin != null) && (paramList.frienduin.equals(this.a.ah.b)))
      {
        QCircleChatPie.a(this.a);
        QCircleChatPie.a(this.a, paramList);
      }
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendResult, isSucc:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" uniseq:");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (paramString.equals(this.a.ah.b))
      {
        paramString = this.a;
        paramString.as = true;
        paramString.a(262144, null, paramLong);
        if ((paramBoolean) && (!((FriendsManager)this.a.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.a.ah.b))) {
          QCircleChatPie.a(this.a);
        }
      }
    }
  }
  
  protected void onSendResultWithTransInfo(boolean paramBoolean, msg_svc.TransSvrInfo paramTransSvrInfo)
  {
    if ((paramBoolean) && (paramTransSvrInfo != null) && (paramTransSvrInfo.bytes_trans_info.has()))
    {
      byte[] arrayOfByte = paramTransSvrInfo.bytes_trans_info.get().toByteArray();
      if (arrayOfByte.length > 0)
      {
        paramTransSvrInfo = new QQCirclePrivateMsgAIO.PrivateMsgTransSvrInfo();
        try
        {
          paramTransSvrInfo.mergeFrom(arrayOfByte);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          String str = this.a.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(",exception:");
          localStringBuilder.append(localInvalidProtocolBufferMicroException.toString());
          QLog.e(str, 1, new Object[] { "onSendResultWithTransInfo isSuc:", Boolean.valueOf(paramBoolean), localStringBuilder.toString() });
        }
        int i = paramTransSvrInfo.int32_ret_code.get();
        paramTransSvrInfo = paramTransSvrInfo.str_err_msg.get();
        QLog.d(this.a.c, 2, new Object[] { "onSendResultWithTransInfo isSuc:", Boolean.valueOf(paramBoolean), ",retCode:", Integer.valueOf(i), ",tips:", paramTransSvrInfo });
        if ((i == 0) && (!TextUtils.isEmpty(paramTransSvrInfo)))
        {
          QQToast.makeText(this.a.e, 0, paramTransSvrInfo, 0).show();
          QLog.d(this.a.c, 2, new Object[] { "onSendResultWithTransInfo Show Toast,tips:", paramTransSvrInfo });
        }
      }
    }
    else
    {
      QLog.d(this.a.c, 1, new Object[] { "onSendResultWithTransInfo isSuc:", Boolean.valueOf(paramBoolean), ",transSvrInfo is empty!" });
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
        paramString2 = new StringBuilder();
        paramString2.append("onUpdateSendMsgError uin ");
        paramString2.append(paramString1);
        paramString2.append(" type ");
        paramString2.append(paramInt1);
        paramString2.append(" uniseq ");
        paramString2.append(paramLong2);
        paramString2.append(" errorCode ");
        paramString2.append(paramInt2);
        QLog.d(paramSendMessageHandler, 2, paramString2.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.1
 * JD-Core Version:    0.7.0.1
 */