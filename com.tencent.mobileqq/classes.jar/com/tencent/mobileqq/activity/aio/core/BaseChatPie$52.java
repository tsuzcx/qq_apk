package com.tencent.mobileqq.activity.aio.core;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class BaseChatPie$52
  implements Runnable
{
  BaseChatPie$52(BaseChatPie paramBaseChatPie, RichStatus.SigZanInfo paramSigZanInfo) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, RichStatItemBuilder.a);
    Object localObject;
    Message localMessage;
    if ((localMessageRecord instanceof MessageForRichState))
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
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageRecord.uniseq, ((JSONObject)localObject).toString());
      label186:
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label186;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.52
 * JD-Core Version:    0.7.0.1
 */