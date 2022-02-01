package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class PokeMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((paramMessage.msgtype == -5012) && (paramMessage.msgData != null)) {
      try
      {
        paramMessage.msg = new JSONObject(new String(paramMessage.msgData)).getString("msg");
        return;
      }
      catch (JSONException paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.PokeMsgDecoder
 * JD-Core Version:    0.7.0.1
 */