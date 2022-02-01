package com.tencent.mobileqq.activity;

import ahqk;
import android.os.Message;
import bbsz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class BaseChatPie$67
  implements Runnable
{
  BaseChatPie$67(BaseChatPie paramBaseChatPie, bbsz parambbsz) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ahqk.a);
    Object localObject;
    Message localMessage;
    if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForRichState)))
    {
      localObject = new HashMap();
      ((Map)localObject).put("chatMessage", localMessageRecord);
      ((Map)localObject).put("sigZanInfo", this.a);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.removeMessages(267387138);
      localMessage = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(267387138);
      localMessage.obj = localObject;
    }
    try
    {
      localObject = new JSONObject(localMessageRecord.msg);
      ((JSONObject)localObject).put("count", this.a.b);
      ((JSONObject)localObject).put("zanfalg", this.a.c);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageRecord.uniseq, ((JSONObject)localObject).toString());
      label190:
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label190;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.67
 * JD-Core Version:    0.7.0.1
 */