package com.tencent.mobileqq.activity.aio.core;

import ahfn;
import android.os.Message;
import bbtj;
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
  BaseChatPie$67(BaseChatPie paramBaseChatPie, bbtj parambbtj) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.this$0.app.getMessageFacade().getMsgItemByUniseq(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, ahfn.a);
    Object localObject;
    Message localMessage;
    if ((localMessageRecord instanceof MessageForRichState))
    {
      localObject = new HashMap();
      ((Map)localObject).put("chatMessage", localMessageRecord);
      ((Map)localObject).put("sigZanInfo", this.val$zanInfo);
      this.this$0.uiHandler.removeMessages(267387138);
      localMessage = this.this$0.uiHandler.obtainMessage(267387138);
      localMessage.obj = localObject;
    }
    try
    {
      localObject = new JSONObject(localMessageRecord.msg);
      ((JSONObject)localObject).put("count", this.val$zanInfo.b);
      ((JSONObject)localObject).put("zanfalg", this.val$zanInfo.c);
      this.this$0.app.getMessageFacade().updateMsgContentByUniseq(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, localMessageRecord.uniseq, ((JSONObject)localObject).toString());
      label186:
      this.this$0.uiHandler.sendMessageDelayed(localMessage, 1000L);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label186;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.67
 * JD-Core Version:    0.7.0.1
 */