package com.tencent.mobileqq.apollo.aio.panel;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ApolloPanel$19
  implements ApolloPanelManager.PanelClickCallback
{
  ApolloPanel$19(ApolloPanel paramApolloPanel) {}
  
  public void a()
  {
    ApolloPanel.E(this.a).c();
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ApolloPanel.z(this.a).setText(String.valueOf(paramInt));
    if (ApolloPanel.A(this.a).getVisibility() != 0) {
      return;
    }
    if ((paramBoolean2) && (paramInt < 5))
    {
      ApolloPanel.B(this.a).setVisibility(8);
      if (paramBoolean1)
      {
        ApolloPanel.C(this.a).setVisibility(0);
        ThreadManager.getUIHandler().removeCallbacks(ApolloPanel.D(this.a));
        ThreadManager.getUIHandler().postDelayed(ApolloPanel.D(this.a), 5000L);
        return;
      }
      if (paramInt > 0) {
        ApolloPanel.B(this.a).setVisibility(0);
      }
    }
    else
    {
      ApolloPanel.B(this.a).setVisibility(0);
      if ((paramInt == 0) && (paramBoolean1)) {
        ApolloPanel.C(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.19
 * JD-Core Version:    0.7.0.1
 */