package com.tencent.mobileqq.apollo.view.pannel;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.api.impl.model.App3DConfig;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$1
  implements Runnable
{
  ApolloPanel$1(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    ApolloPanel.a(this.this$0).setVisibility(0);
    ApolloPanel.a(this.this$0).setVisibility(8);
    boolean bool1 = App3DConfig.a;
    boolean bool2 = ApolloPanel.a(this.this$0);
    QLog.d("ApolloPanel", 1, new Object[] { "updateView, show=", Boolean.valueOf(bool1), ", has3dQualification=", Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      ApolloPanel.a(this.this$0).setVisibility(0);
      ApolloPanel.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      if (ApolloPanel.a(this.this$0).getVisibility() == 0) {
        ApolloPanel.a(this.this$0).setOnClickListener(this.this$0);
      }
      return;
      ApolloPanel.a(this.this$0).setVisibility(8);
      ApolloPanel.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.1
 * JD-Core Version:    0.7.0.1
 */