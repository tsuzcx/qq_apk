import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bber
{
  private static volatile bber a;
  
  public static bber a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bber();
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
      localChatMessage = ((bben)paramQQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(l);
      if (localChatMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReplyMsgSender", 2, "sendReplyMessage chatMessage is null");
    return;
    a(paramQQAppInterface, localChatMessage, paramSessionInfo, 0, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", 0), true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList1, admo paramadmo, MessageRecord paramMessageRecord, String paramString2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList2)
  {
    MessageForReplyText localMessageForReplyText = new MessageForReplyText();
    localMessageForReplyText.msg = paramString1;
    localMessageForReplyText.istroop = paramSessionInfo.curType;
    localMessageForReplyText.msgtype = -1049;
    localMessageForReplyText.atInfoList = paramArrayList1;
    localMessageForReplyText.mSourceMsgInfo = paramadmo.a;
    localMessageForReplyText.setSourceMessageRecord(paramMessageRecord);
    localMessageForReplyText.isBarrageMsg = paramadmo.jdField_d_of_type_Boolean;
    localMessageForReplyText.barrageTimeLocation = paramadmo.b;
    localMessageForReplyText.barrageSourceMsgType = paramadmo.jdField_d_of_type_Int;
    if ((!TextUtils.isEmpty(paramString2)) && (paramArrayList2 != null) && (!paramArrayList2.isEmpty()))
    {
      localMessageForReplyText.saveExtInfoToExtStr("sens_reply_special_msg", paramString2);
      localMessageForReplyText.saveExtInfoToExtStr("sens_reply_special_at_list", bgcz.a(paramArrayList2));
    }
    int i = 2;
    if (!TextUtils.isEmpty(paramadmo.a.mSourceMsgTroopName)) {
      i = 0;
    }
    a(paramQQAppInterface, localMessageForReplyText, paramSessionInfo, i, 0, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    new ArrayList(1).add(paramChatMessage);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramChatMessage);
    paramChatMessage = new axiu();
    paramChatMessage.jdField_a_of_type_Int = paramInt1;
    paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    paramChatMessage.jdField_a_of_type_JavaUtilList = localArrayList;
    paramChatMessage.jdField_a_of_type_JavaUtilMap = null;
    paramChatMessage.g = paramInt2;
    paramChatMessage.b = 8;
    paramChatMessage.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = new MessageForStructing();
    paramChatMessage.jdField_a_of_type_Boolean = paramBoolean;
    new bbeq(paramQQAppInterface).e(paramChatMessage);
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
      paramMessageForMixedMsg = new axiu();
      paramMessageForMixedMsg.jdField_a_of_type_Int = 0;
      paramMessageForMixedMsg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      paramMessageForMixedMsg.jdField_a_of_type_JavaUtilList = localArrayList;
      paramMessageForMixedMsg.jdField_a_of_type_JavaUtilMap = null;
      paramMessageForMixedMsg.b = 9;
      paramMessageForMixedMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = new MessageForStructing();
      new bbeo(paramQQAppInterface).e(paramMessageForMixedMsg);
      return;
    }
    ((awyg)paramQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(paramSessionInfo, paramMessageForMixedMsg, false, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bber
 * JD-Core Version:    0.7.0.1
 */