import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aurn
{
  private static volatile aurn a;
  
  public static aurn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aurn();
      }
      return a;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("FORWARD_MSG_UNISEQ", 0L);
    if (l == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgSender", 2, "sendReplyMessage uniseq=0");
      }
    }
    ChatMessage localChatMessage;
    do
    {
      return;
      localChatMessage = ((aurj)paramQQAppInterface.getManager(340)).a(l);
      if (localChatMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReplyMsgSender", 2, "sendReplyMessage chatMessage is null");
    return;
    a(paramQQAppInterface, localChatMessage, paramSessionInfo, 0, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", 0), true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList1, aaes paramaaes, MessageRecord paramMessageRecord, String paramString2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList2)
  {
    MessageForReplyText localMessageForReplyText = new MessageForReplyText();
    localMessageForReplyText.msg = paramString1;
    localMessageForReplyText.msgtype = -1049;
    localMessageForReplyText.atInfoList = paramArrayList1;
    localMessageForReplyText.mSourceMsgInfo = paramaaes.a;
    localMessageForReplyText.setSourceMessageRecord(paramMessageRecord);
    localMessageForReplyText.isBarrageMsg = paramaaes.jdField_d_of_type_Boolean;
    localMessageForReplyText.barrageTimeLocation = paramaaes.b;
    localMessageForReplyText.barrageSourceMsgType = paramaaes.jdField_d_of_type_Int;
    if ((!TextUtils.isEmpty(paramString2)) && (paramArrayList2 != null) && (!paramArrayList2.isEmpty()))
    {
      localMessageForReplyText.saveExtInfoToExtStr("sens_reply_special_msg", paramString2);
      localMessageForReplyText.saveExtInfoToExtStr("sens_reply_special_at_list", azef.a(paramArrayList2));
    }
    int i = 2;
    if (!TextUtils.isEmpty(paramaaes.a.mSourceMsgTroopName)) {
      i = 0;
    }
    a(paramQQAppInterface, localMessageForReplyText, paramSessionInfo, i, 0, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    new ArrayList(1).add(paramChatMessage);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramChatMessage);
    paramChatMessage = new arya();
    paramChatMessage.jdField_a_of_type_Int = paramInt1;
    paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    paramChatMessage.jdField_a_of_type_JavaUtilList = localArrayList;
    paramChatMessage.jdField_a_of_type_JavaUtilMap = null;
    paramChatMessage.g = paramInt2;
    paramChatMessage.b = 8;
    paramChatMessage.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = new MessageForStructing();
    paramChatMessage.jdField_a_of_type_Boolean = paramBoolean;
    new aurm(paramQQAppInterface).e(paramChatMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramMessageForMixedMsg == null) {
      return;
    }
    if (paramMessageForMixedMsg.getReplyMessage(paramQQAppInterface) != null)
    {
      new ArrayList(1).add(paramMessageForMixedMsg);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramMessageForMixedMsg);
      paramMessageForMixedMsg = new arya();
      paramMessageForMixedMsg.jdField_a_of_type_Int = 0;
      paramMessageForMixedMsg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      paramMessageForMixedMsg.jdField_a_of_type_JavaUtilList = localArrayList;
      paramMessageForMixedMsg.jdField_a_of_type_JavaUtilMap = null;
      paramMessageForMixedMsg.b = 9;
      paramMessageForMixedMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = new MessageForStructing();
      new aurk(paramQQAppInterface).e(paramMessageForMixedMsg);
      return;
    }
    ((arno)paramQQAppInterface.getManager(174)).a(paramSessionInfo, paramMessageForMixedMsg, false, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aurn
 * JD-Core Version:    0.7.0.1
 */