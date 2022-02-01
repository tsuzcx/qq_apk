package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class CmShowModule$15
  implements Runnable
{
  CmShowModule$15(CmShowModule paramCmShowModule, JSONArray paramJSONArray, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      JSONObject localJSONObject2;
      int j;
      MessageRecord localMessageRecord;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        int k = this.jdField_a_of_type_OrgJsonJSONArray.length();
        int i = 0;
        if (i >= k) {
          break label445;
        }
        localJSONObject1 = new JSONObject();
        Object localObject = this.jdField_a_of_type_OrgJsonJSONArray.getString(i);
        localJSONObject1.put("uin", localObject);
        localJSONObject1.put("unreadMsgCount", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a((String)localObject, 1036));
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("text", "");
        localJSONObject2.put("timestamp", 0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((String)localObject, 1036, null, 5);
        j = ((List)localObject).size() - 1;
        if (j >= 0)
        {
          localMessageRecord = (MessageRecord)((List)localObject).get(j);
          if ((!(localMessageRecord instanceof ChatMessage)) || ((localMessageRecord instanceof MessageForCmGameTips)) || ((localMessageRecord instanceof MessageForGrayTips)) || ((localMessageRecord instanceof MessageForUniteGrayTip))) {
            break label499;
          }
          if (localMessageRecord != null)
          {
            if (TextUtils.isEmpty(localMessageRecord.msg)) {
              ((ChatMessage)localMessageRecord).parse();
            }
            if (!(localMessageRecord instanceof MessageForApollo)) {
              continue;
            }
            localJSONObject2.put("text", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getMsgTranDec(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForApollo)localMessageRecord));
            localJSONObject2.put("timestamp", localMessageRecord.time);
          }
        }
        localJSONObject1.put("latestMsg", localJSONObject2);
        localJSONArray.put(localJSONObject1);
        i += 1;
        continue;
        if ((localMessageRecord instanceof MessageForPic))
        {
          localJSONObject2.put("text", HardCodeUtil.a(2131706689));
          localJSONObject2.put("timestamp", localMessageRecord.time);
          continue;
        }
        if (TextUtils.isEmpty(localMessageRecord.msg)) {
          break label416;
        }
      }
      catch (Exception localException)
      {
        localBundle.putString("result", "");
        this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      localJSONObject2.put("text", new QQText(localMessageRecord.msg, 3).toPlainText());
      localJSONObject2.put("timestamp", localMessageRecord.time);
      continue;
      label416:
      localJSONObject2.put("text", HardCodeUtil.a(2131706693));
      localJSONObject2.put("timestamp", localMessageRecord.time);
      continue;
      label445:
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("friendMsgList", localException);
      localBundle.putString("result", localJSONObject1.toString());
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      label499:
      j -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.15
 * JD-Core Version:    0.7.0.1
 */