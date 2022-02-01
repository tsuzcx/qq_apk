package com.tencent.imcore.message.decoder;

import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import mqq.app.AppRuntime;

public class DeviceFileMsgDecoder
  implements IMessageDecoder
{
  private boolean a(Message paramMessage)
  {
    return (paramMessage.msgtype == -4500) || (paramMessage.msgtype == -4502) || (paramMessage.msgtype == -4503) || (paramMessage.msgtype == -4501) || (paramMessage.msgtype == -4509);
  }
  
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if ((a(paramMessage)) && (paramMessage.msgData != null))
    {
      paramIMessageManager = null;
      int i = paramMessage.msgtype;
      if (i != -5001)
      {
        if (i != -4509) {
          switch (i)
          {
          default: 
            break;
          case -4500: 
            paramIMessageManager = new MessageForDeviceFile();
            break;
          case -4501: 
            paramIMessageManager = new MessageForDevPtt();
            break;
          case -4502: 
            paramIMessageManager = new MessageForDeviceSingleStruct();
            break;
          case -4503: 
            paramIMessageManager = new MessageForDevShortVideo();
            break;
          }
        } else {
          paramIMessageManager = new MessageForDevLittleVideo();
        }
      }
      else {
        paramIMessageManager = new MessageForNewGrayTips();
      }
      if (paramIMessageManager != null)
      {
        paramIMessageManager.msgData = paramMessage.msgData;
        paramIMessageManager.parse();
        paramMessage.msg = paramIMessageManager.msg;
        if (paramMessage.msgtype == -4501)
        {
          paramMessage.msg = ((MessageForDevPtt)paramIMessageManager).getSummary();
          return;
        }
        if (paramMessage.msgtype == -4503)
        {
          paramMessage.msg = ((MessageForDevShortVideo)paramIMessageManager).getSummary();
          return;
        }
        if (paramMessage.msgtype == -4509) {
          paramMessage.msg = ((MessageForDevLittleVideo)paramIMessageManager).getSummary();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.DeviceFileMsgDecoder
 * JD-Core Version:    0.7.0.1
 */