package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
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
  
  public void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.p();
      }
    }
  }
  
  public void onMessageRecordAdded(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((!paramList.isSendFromLocal()) && (!(paramList instanceof MessageForUniteGrayTip)) && (paramList.frienduin != null) && (paramList.frienduin.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        QCircleChatPie.a(this.a);
        QCircleChatPie.a(this.a, paramList);
      }
    }
  }
  
  public void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ChatActivityUtils.b();
      if (paramBoolean) {
        this.a.p();
      }
    }
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onSendResult, isSucc:" + paramBoolean + " uin:" + paramString + " uniseq:" + paramLong);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      do
      {
        return;
      } while (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      this.a.q = true;
      this.a.a(262144, null, paramLong);
    } while ((!paramBoolean) || (((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    QCircleChatPie.a(this.a);
  }
  
  public void onSendResultWithTransInfo(boolean paramBoolean, msg_svc.TransSvrInfo paramTransSvrInfo)
  {
    if ((paramBoolean) && (paramTransSvrInfo != null) && (paramTransSvrInfo.bytes_trans_info.has()))
    {
      byte[] arrayOfByte = paramTransSvrInfo.bytes_trans_info.get().toByteArray();
      if (arrayOfByte.length > 0) {
        paramTransSvrInfo = new QQCirclePrivateMsgAIO.PrivateMsgTransSvrInfo();
      }
      try
      {
        paramTransSvrInfo.mergeFrom(arrayOfByte);
        int i = paramTransSvrInfo.int32_ret_code.get();
        paramTransSvrInfo = paramTransSvrInfo.str_err_msg.get();
        QLog.d(this.a.b, 2, new Object[] { "onSendResultWithTransInfo isSuc:", Boolean.valueOf(paramBoolean), ",retCode:", Integer.valueOf(i), ",tips:", paramTransSvrInfo });
        if ((i == 0) && (!TextUtils.isEmpty(paramTransSvrInfo)))
        {
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 0, paramTransSvrInfo, 0).a();
          QLog.d(this.a.b, 2, new Object[] { "onSendResultWithTransInfo Show Toast,tips:", paramTransSvrInfo });
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          QLog.e(this.a.b, 1, new Object[] { "onSendResultWithTransInfo isSuc:", Boolean.valueOf(paramBoolean), ",exception:" + localInvalidProtocolBufferMicroException.toString() });
        }
      }
    }
    QLog.d(this.a.b, 1, new Object[] { "onSendResultWithTransInfo isSuc:", Boolean.valueOf(paramBoolean), ",transSvrInfo is empty!" });
  }
  
  public void onUpdateMsgContent(boolean paramBoolean, String paramString)
  {
    this.a.g(65536);
  }
  
  public void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2);
    }
    this.a.g(196608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.1
 * JD-Core Version:    0.7.0.1
 */