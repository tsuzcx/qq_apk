package com.tencent.mobileqq.activity;

import aadg;
import adnu;
import android.os.Message;
import avcq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseChatPie$75$3
  implements Runnable
{
  public BaseChatPie$75$3(aadg paramaadg, avcq paramavcq) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_Aadg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aadg.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aadg.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, adnu.a);
    Object localObject;
    Message localMessage;
    if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForRichState)))
    {
      localObject = new HashMap();
      ((Map)localObject).put("chatMessage", localMessageRecord);
      ((Map)localObject).put("sigZanInfo", this.jdField_a_of_type_Avcq);
      this.jdField_a_of_type_Aadg.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(267387138);
      localMessage = this.jdField_a_of_type_Aadg.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(267387138);
      localMessage.obj = localObject;
    }
    try
    {
      localObject = new JSONObject(localMessageRecord.msg);
      ((JSONObject)localObject).put("count", this.jdField_a_of_type_Avcq.b);
      ((JSONObject)localObject).put("zanfalg", this.jdField_a_of_type_Avcq.c);
      this.jdField_a_of_type_Aadg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aadg.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aadg.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageRecord.uniseq, ((JSONObject)localObject).toString());
      label214:
      this.jdField_a_of_type_Aadg.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label214;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.75.3
 * JD-Core Version:    0.7.0.1
 */