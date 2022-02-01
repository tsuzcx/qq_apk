package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextSttState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class VoiceTextSttProcessController$2
  implements Runnable
{
  VoiceTextSttProcessController$2(VoiceTextSttProcessController paramVoiceTextSttProcessController) {}
  
  public void run()
  {
    VoiceTextSttProcessController.c(this.this$0).j();
    VoiceTextSttProcessController.d(this.this$0).c().a(5);
    QQToast.makeText(VoiceTextSttProcessController.e(this.this$0).getContext(), HardCodeUtil.a(2131913776), 0).show(VoiceTextSttProcessController.e(this.this$0).getContext().getResources().getDimensionPixelSize(2131299920));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController.2
 * JD-Core Version:    0.7.0.1
 */