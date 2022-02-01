package com.tencent.mobileqq.apollo.script;

import ancc;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
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
      if (SpriteUIHandler.a(this.this$0).a() == null) {
        return;
      }
      XPanelContainer localXPanelContainer = (XPanelContainer)SpriteUIHandler.a(this.this$0).a().getAIORootView().findViewById(2131376947);
      if (1 == this.a)
      {
        if (localXPanelContainer.a() != 21) {
          return;
        }
        SpriteUIHandler.a(this.this$0).a().hidePanel();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, localException, new Object[0]);
      return;
    }
    if (2 == this.a)
    {
      BaseChatPie localBaseChatPie = SpriteUIHandler.a(this.this$0).a();
      if (localBaseChatPie != null)
      {
        ApolloPanel localApolloPanel = localBaseChatPie.mApolloPanel;
        if ((localApolloPanel != null) && (localApolloPanel.a() == 7))
        {
          localBaseChatPie.showApolloStatusPanel(0);
          return;
        }
      }
      localException.a(21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.4
 * JD-Core Version:    0.7.0.1
 */