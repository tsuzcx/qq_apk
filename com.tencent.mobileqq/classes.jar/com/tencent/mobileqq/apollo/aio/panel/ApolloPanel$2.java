package com.tencent.mobileqq.apollo.aio.panel;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;

class ApolloPanel$2
  implements Runnable
{
  ApolloPanel$2(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if (CmShowWnsUtils.q()) {
      ApolloPanel.a(this.this$0).setVisibility(0);
    } else {
      ApolloPanel.a(this.this$0).setVisibility(8);
    }
    ApolloPanel.d(this.this$0).setVisibility(8);
    if (CmShowWnsUtils.b()) {
      ApolloPanel.b(this.this$0).setVisibility(0);
    }
    ApolloPanel.e(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.2
 * JD-Core Version:    0.7.0.1
 */