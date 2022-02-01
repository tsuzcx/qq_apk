package com.tencent.mobileqq.apollo.view;

import amsx;
import amtk;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import anrz;
import ansf;
import com.tencent.image.URLImageView;

public class ApolloPanel$38$1
  implements Runnable
{
  public ApolloPanel$38$1(anrz paramanrz) {}
  
  public void run()
  {
    this.a.a.b.setVisibility(8);
    ApolloPanel.a(this.a.a).setVisibility(8);
    if (amtk.a)
    {
      ApolloPanel.a(this.a.a).setVisibility(0);
      ApolloPanel.b(this.a.a).setVisibility(0);
      amsx.a(101, String.valueOf(amtk.b), amtk.j);
    }
    while (ApolloPanel.a(this.a.a).getVisibility() == 0)
    {
      ApolloPanel.a(this.a.a).setVisibility(0);
      if (this.a.a.a == null) {
        this.a.a.a = new ansf(this.a.a);
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
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.38.1
 * JD-Core Version:    0.7.0.1
 */