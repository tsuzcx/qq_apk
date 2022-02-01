package com.tencent.mobileqq.apollo.view.pannel;

import amms;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anme;
import anmk;
import anou;
import anpe;
import com.tencent.image.URLImageView;

public class ApolloPanel$32$1
  implements Runnable
{
  public ApolloPanel$32$1(anou paramanou) {}
  
  public void run()
  {
    this.a.a.b.setVisibility(8);
    ApolloPanel.b(this.a.a).setVisibility(8);
    if (amms.a)
    {
      ApolloPanel.a(this.a.a).setVisibility(0);
      ApolloPanel.b(this.a.a).setVisibility(0);
      if (anmk.a()) {
        ApolloPanel.a(this.a.a).setVisibility(0);
      }
      anme.a(101, String.valueOf(amms.b), amms.j);
    }
    while (ApolloPanel.a(this.a.a).getVisibility() == 0)
    {
      ApolloPanel.a(this.a.a).setVisibility(0);
      if (this.a.a.a == null) {
        this.a.a.a = new anpe(this.a.a);
      }
      ApolloPanel.a(this.a.a).setOnClickListener(this.a.a.a);
      this.a.a.a.a();
      return;
      ApolloPanel.a(this.a.a).setVisibility(8);
      ApolloPanel.b(this.a.a).setVisibility(8);
    }
    ApolloPanel.a(this.a.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.32.1
 * JD-Core Version:    0.7.0.1
 */