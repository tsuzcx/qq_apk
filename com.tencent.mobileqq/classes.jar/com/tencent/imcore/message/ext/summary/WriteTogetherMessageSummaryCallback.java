package com.tencent.imcore.message.ext.summary;

import android.content.Context;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.core.ExtractMessageSummaryCallback;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class WriteTogetherMessageSummaryCallback
  implements ExtractMessageSummaryCallback
{
  public boolean a(Context paramContext, AppRuntime paramAppRuntime, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((paramAppRuntime instanceof QQAppInterface)) && (paramMessage != null))
    {
      if (paramMsgSummary == null) {
        return false;
      }
      if (paramMessage.msgtype != -7014) {
        return false;
      }
      paramMsgSummary.strPrefix = paramString;
      paramContext = new StringBuilder();
      paramContext.append("[一起写] ");
      paramContext.append(paramMessage.msg);
      paramMsgSummary.strContent = paramContext.toString();
      return true;
    }
    return false;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.summary.WriteTogetherMessageSummaryCallback
 * JD-Core Version:    0.7.0.1
 */