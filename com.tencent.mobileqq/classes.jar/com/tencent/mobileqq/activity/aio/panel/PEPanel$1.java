package com.tencent.mobileqq.activity.aio.panel;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.animation.TranslateAnimation;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;

class PEPanel$1
  implements Handler.Callback
{
  PEPanel$1(PEPanel paramPEPanel) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return false;
    }
    PEPanel.a(this.a).setVisibility(0);
    paramMessage = new TranslateAnimation(0.0F, 0.0F, XPanelContainer.a, 0.0F);
    paramMessage.setDuration(200L);
    PEPanel.a(this.a).startAnimation(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PEPanel.1
 * JD-Core Version:    0.7.0.1
 */