package com.tencent.mobileqq.apollo.script;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

class SpriteUIHandler$4
  implements Runnable
{
  SpriteUIHandler$4(SpriteUIHandler paramSpriteUIHandler, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (SpriteUIHandler.c(this.this$0).l() == null) {
        return;
      }
      XPanelContainer localXPanelContainer = (XPanelContainer)SpriteUIHandler.c(this.this$0).m().aW().findViewById(2131445137);
      if (1 == this.a)
      {
        if (localXPanelContainer.getCurrentPanel() == 21) {
          SpriteUIHandler.c(this.this$0).m().aw();
        }
      }
      else if (2 == this.a)
      {
        localXPanelContainer.a(21);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow][scripted]SpriteUIHandler", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.4
 * JD-Core Version:    0.7.0.1
 */