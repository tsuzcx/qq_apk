package com.tencent.imcore.message.decoder;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class MarketFaceMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msgtype == -2007)
    {
      paramIMessageManager = null;
      try
      {
        MarkFaceMessage localMarkFaceMessage = (MarkFaceMessage)MessagePkgUtils.a(paramMessage.msgData);
        paramIMessageManager = localMarkFaceMessage;
      }
      catch (Exception localException)
      {
        QLog.e("Q.msg.BaseMessageManager", 1, "parse MarkFaceMessage: ", localException);
      }
      if ((paramIMessageManager != null) && (!TextUtils.isEmpty(paramIMessageManager.faceName)))
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("[");
        paramAppRuntime.append(paramIMessageManager.faceName);
        paramAppRuntime.append("]");
        paramMessage.msg = paramAppRuntime.toString();
        return;
      }
      paramMessage.msg = paramAppRuntime.getApp().getString(2131888889);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.MarketFaceMsgDecoder
 * JD-Core Version:    0.7.0.1
 */