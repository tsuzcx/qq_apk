package com.tencent.mobileqq.activity.aio.helper;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
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

class SignatureHelper$2
  implements Runnable
{
  SignatureHelper$2(SignatureHelper paramSignatureHelper, RichStatus.SigZanInfo paramSigZanInfo) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = SignatureHelper.a(this.this$0).a();
    SessionInfo localSessionInfo = SignatureHelper.a(this.this$0).a();
    MessageRecord localMessageRecord = localQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, RichStatItemBuilder.a);
    Object localObject;
    MqqHandler localMqqHandler;
    Message localMessage;
    if ((localMessageRecord instanceof MessageForRichState))
    {
      localObject = new HashMap();
      ((Map)localObject).put("chatMessage", localMessageRecord);
      ((Map)localObject).put("sigZanInfo", this.a);
      localMqqHandler = SignatureHelper.a(this.this$0).a();
      localMqqHandler.removeMessages(267387138);
      localMessage = localMqqHandler.obtainMessage(267387138);
      localMessage.obj = localObject;
    }
    try
    {
      localObject = new JSONObject(localMessageRecord.msg);
      ((JSONObject)localObject).put("count", this.a.b);
      ((JSONObject)localObject).put("zanfalg", this.a.c);
      localQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, localMessageRecord.uniseq, ((JSONObject)localObject).toString());
      label189:
      localMqqHandler.sendMessageDelayed(localMessage, 1000L);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label189;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.SignatureHelper.2
 * JD-Core Version:    0.7.0.1
 */