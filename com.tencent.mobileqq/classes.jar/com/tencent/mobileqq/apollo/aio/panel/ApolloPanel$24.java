package com.tencent.mobileqq.apollo.aio.panel;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ApolloPanel$24
  implements ApolloPanelManager.PanelClickCallback
{
  ApolloPanel$24(ApolloPanel paramApolloPanel) {}
  
  public void a()
  {
    ApolloPanel.a(this.a).c();
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ApolloPanel.a(this.a).setText(String.valueOf(paramInt));
    if (ApolloPanel.b(this.a).getVisibility() == 0) {
      if ((paramBoolean2) && (paramInt < 5))
      {
        ApolloPanel.b(this.a).setVisibility(8);
        if (paramBoolean1)
        {
          ApolloPanel.b(this.a).setVisibility(0);
          ThreadManager.getUIHandler().removeCallbacks(ApolloPanel.a(this.a));
          ThreadManager.getUIHandler().postDelayed(ApolloPanel.a(this.a), 5000L);
          return;
        }
        if (paramInt > 0) {
          ApolloPanel.b(this.a).setVisibility(0);
        }
      }
      else
      {
        ApolloPanel.b(this.a).setVisibility(0);
        if ((paramInt == 0) && (paramBoolean1)) {
          ApolloPanel.b(this.a).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.24
 * JD-Core Version:    0.7.0.1
 */