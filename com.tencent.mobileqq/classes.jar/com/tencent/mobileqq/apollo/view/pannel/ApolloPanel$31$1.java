package com.tencent.mobileqq.apollo.view.pannel;

import amms;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anot;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class ApolloPanel$31$1
  implements Runnable
{
  public ApolloPanel$31$1(anot paramanot) {}
  
  public void run()
  {
    ApolloPanel.a(this.a.a).setVisibility(0);
    this.a.a.b.setVisibility(0);
    ApolloPanel.a(this.a.a).setVisibility(8);
    ApolloPanel.a(this.a.a).setVisibility(8);
    boolean bool1 = amms.a;
    boolean bool2 = ApolloPanel.d(this.a.a);
    QLog.d("ApolloPanel", 1, new Object[] { "updateView, show=", Boolean.valueOf(bool1), ", has3dQualification=", Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      ApolloPanel.b(this.a.a).setVisibility(0);
      ApolloPanel.b(this.a.a).setVisibility(0);
    }
    for (;;)
    {
      if (ApolloPanel.b(this.a.a).getVisibility() == 0) {
        ApolloPanel.b(this.a.a).setOnClickListener(this.a.a);
      }
      return;
      ApolloPanel.b(this.a.a).setVisibility(8);
      ApolloPanel.b(this.a.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.31.1
 * JD-Core Version:    0.7.0.1
 */