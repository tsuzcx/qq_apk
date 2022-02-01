package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextSttListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.SttResultBean;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class VoiceTextSttQueryController$1
  extends TransProcessorHandler
{
  VoiceTextSttQueryController$1(VoiceTextSttQueryController paramVoiceTextSttQueryController) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg != null) && (localFileMsg.fileType == 327696))
    {
      if (localFileMsg.commandId != 68) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1004)
      {
        if (i != 2005)
        {
          if (i != 2002)
          {
            if (i != 2003) {
              return;
            }
            if (localFileMsg.pttSliceText != null) {
              this.a.a(new SttResultBean(localFileMsg.pttSliceText, true), localFileMsg.pttSlicePos);
            }
            VoiceTextSttQueryController.a(this.a).set(VoiceTextSttQueryController.a(this.a).get() - 1);
            if (VoiceTextSttQueryController.a(this.a).get() == 0)
            {
              VoiceTextSttQueryController.a(this.a).clear();
              if (VoiceTextSttQueryController.a(this.a) != null) {
                VoiceTextSttQueryController.a(this.a).d();
              }
              VoiceTextSttQueryController.a(this.a).removeHandle(VoiceTextSttQueryController.a(this.a));
              ReportUtils.a(1, 0);
            }
          }
          else if ((!StringUtil.a(localFileMsg.pttSliceText)) && (VoiceTextSttQueryController.a(this.a).get() > 0))
          {
            this.a.a(new SttResultBean(localFileMsg.pttSliceText, false), localFileMsg.pttSlicePos);
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("pttTransProcessorHandler recieve error:");
            paramMessage.append(localFileMsg.errorCode);
            QLog.d("VoiceTextEdtiController", 2, paramMessage.toString());
          }
          if (VoiceTextSttQueryController.a(this.a) != null) {
            VoiceTextSttQueryController.a(this.a).a(localFileMsg.errorCode);
          }
          ReportUtils.a(0, localFileMsg.errorCode);
          this.a.a();
        }
      }
      else if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("pttTransProcessorHandler STATUS_SEND_CANCEL unFinishSegSize=");
        paramMessage.append(VoiceTextSttQueryController.a(this.a).get());
        paramMessage.append(" pos=");
        paramMessage.append(localFileMsg.pttSlicePos);
        QLog.d("VoiceTextEdtiController", 2, paramMessage.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttQueryController.1
 * JD-Core Version:    0.7.0.1
 */