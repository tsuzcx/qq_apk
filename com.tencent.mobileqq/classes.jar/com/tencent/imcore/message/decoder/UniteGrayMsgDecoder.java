package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg;
import mqq.app.AppRuntime;

public class UniteGrayMsgDecoder
  implements IMessageDecoder
{
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (MsgProxyUtils.d(paramMessage.msgtype)) {
      if (paramMessage.msgData != null)
      {
        paramIMessageManager = new UniteGrayTip.UniteGrayTipMsg();
        try
        {
          paramIMessageManager.mergeFrom(paramMessage.msgData);
          paramMessage.msg = paramIMessageManager.content.get();
          if ((!paramIMessageManager.graytip_id.has()) || (!MutualMarkUtils.b(paramIMessageManager.graytip_id.get()))) {
            return;
          }
          paramMessage.emoRecentMsg = ReactivePushHelper.a(paramAppRuntime.getApp(), paramMessage.msg);
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        paramIMessageManager = UniteGrayTipUtil.a;
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("MessageForUniteGrayTip, docodeMsg failed, ");
        paramAppRuntime.append(paramMessage.getMessage());
        QLog.e(paramIMessageManager, 2, paramAppRuntime.toString());
      }
      else if (QLog.isColorLevel())
      {
        paramIMessageManager = UniteGrayTipUtil.a;
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("MessageForUniteGrayTip, docodeMsg msgData == null, msg: ");
        paramAppRuntime.append(paramMessage.msg);
        QLog.e(paramIMessageManager, 2, paramAppRuntime.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.UniteGrayMsgDecoder
 * JD-Core Version:    0.7.0.1
 */