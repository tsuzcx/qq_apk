import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class ayfl
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131715421);
  }
  
  private static void a(BaseChatPie paramBaseChatPie, long paramLong, String paramString)
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.selfuin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForText.frienduin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    localMessageForText.istroop = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localMessageForText.senderuin = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (paramLong != 0L) {}
    for (;;)
    {
      localMessageForText.time = paramLong;
      localMessageForText.msg = paramString;
      localMessageForText.uniseq = 0L;
      localMessageForText.msgUid = -1L;
      localMessageForText.shmsgseq = 1L;
      localMessageForText.sb = paramString;
      paramBaseChatPie.d(localMessageForText);
      return;
      paramLong = NetConnInfoCenter.getServerTime();
    }
  }
  
  public static final boolean a(BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    paramIntent.getStringExtra("key_aio_reply_time");
    String str = paramIntent.getStringExtra("key_aio_reply_content");
    paramIntent.getIntExtra("key_aio_reply_type", 0);
    return (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static final boolean b(BaseChatPie paramBaseChatPie, Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("key_aio_reply_time");
    String str1 = paramIntent.getStringExtra("key_aio_reply_content");
    int i = paramIntent.getIntExtra("key_aio_reply_type", 0);
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(str2).longValue();
      l1 = l2;
    }
    catch (Exception paramIntent)
    {
      label62:
      break label62;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TopicReplyUtil", 2, String.format("checkAIOReplyNInsert [%s, %d, %s]", new Object[] { paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(l1), str1 }));
    }
    paramIntent = str1;
    if (i == 0) {
      paramIntent = jdField_a_of_type_JavaLangString + str1;
    }
    a(paramBaseChatPie, l1, paramIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfl
 * JD-Core Version:    0.7.0.1
 */