package com.tencent.mobileqq.apollo.view;

import aknx;
import akok;
import almx;
import alnc;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;

public class ApolloPanel$35$1
  implements Runnable
{
  public ApolloPanel$35$1(almx paramalmx) {}
  
  public void run()
  {
    this.a.a.b.setVisibility(8);
    ApolloPanel.a(this.a.a).setVisibility(8);
    if (akok.a)
    {
      ApolloPanel.a(this.a.a).setVisibility(0);
      ApolloPanel.b(this.a.a).setVisibility(0);
      aknx.a(101, String.valueOf(akok.b), akok.j);
    }
    while (ApolloPanel.a(this.a.a).getVisibility() == 0)
    {
      ApolloPanel.a(this.a.a).setVisibility(0);
      if (ApolloPanel.a(this.a.a) == null) {
        ApolloPanel.a(this.a.a, new alnc(this.a.a));
      }
      ApolloPanel.a(this.a.a).setOnClickListener(ApolloPanel.a(this.a.a));
      ApolloPanel.a(this.a.a).a();
      return;
      ApolloPanel.a(this.a.a).setVisibility(8);
      ApolloPanel.b(this.a.a).setVisibility(8);
    }
    ApolloPanel.a(this.a.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.35.1
 * JD-Core Version:    0.7.0.1
 */