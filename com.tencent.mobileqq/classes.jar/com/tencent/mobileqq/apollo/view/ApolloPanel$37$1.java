package com.tencent.mobileqq.apollo.view;

import amhq;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import angd;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

public class ApolloPanel$37$1
  implements Runnable
{
  public ApolloPanel$37$1(angd paramangd) {}
  
  public void run()
  {
    ApolloPanel.a(this.a.a).setVisibility(0);
    this.a.a.b.setVisibility(0);
    ApolloPanel.a(this.a.a).setVisibility(8);
    boolean bool1 = amhq.a;
    boolean bool2 = ApolloPanel.d(this.a.a);
    QLog.d("ApolloPanel", 1, new Object[] { "updateView, show=", Boolean.valueOf(bool1), ", has3dQualification=", Boolean.valueOf(bool2) });
    if ((bool1) && (bool2))
    {
      ApolloPanel.a(this.a.a).setVisibility(0);
      ApolloPanel.b(this.a.a).setVisibility(0);
    }
    for (;;)
    {
      if (ApolloPanel.a(this.a.a).getVisibility() == 0) {
        ApolloPanel.a(this.a.a).setOnClickListener(this.a.a);
      }
      return;
      ApolloPanel.a(this.a.a).setVisibility(8);
      ApolloPanel.b(this.a.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.37.1
 * JD-Core Version:    0.7.0.1
 */