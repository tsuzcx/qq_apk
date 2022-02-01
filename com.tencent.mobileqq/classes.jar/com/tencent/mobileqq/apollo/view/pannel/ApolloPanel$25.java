package com.tencent.mobileqq.apollo.view.pannel;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.ApolloPanelManager.PanelClickCallback;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ApolloPanel$25
  implements ApolloPanelManager.PanelClickCallback
{
  ApolloPanel$25(ApolloPanel paramApolloPanel) {}
  
  public void a()
  {
    ApolloPanel.a(this.a).c();
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ApolloPanel.a(this.a).setText(String.valueOf(paramInt));
    if (ApolloPanel.b(this.a).getVisibility() == 0)
    {
      if ((!paramBoolean2) || (paramInt >= 5)) {
        break label110;
      }
      ApolloPanel.b(this.a).setVisibility(8);
      if (!paramBoolean1) {
        break label94;
      }
      ApolloPanel.b(this.a).setVisibility(0);
      ThreadManager.getUIHandler().removeCallbacks(ApolloPanel.a(this.a));
    }
    label94:
    label110:
    do
    {
      ThreadManager.getUIHandler().postDelayed(ApolloPanel.a(this.a), 5000L);
      do
      {
        return;
      } while (paramInt <= 0);
      ApolloPanel.b(this.a).setVisibility(0);
      return;
      ApolloPanel.b(this.a).setVisibility(0);
    } while ((paramInt != 0) || (!paramBoolean1));
    ApolloPanel.b(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.25
 * JD-Core Version:    0.7.0.1
 */