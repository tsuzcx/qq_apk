package com.tencent.mobileqq.apollo.view;

import aifs;
import ajcu;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;

public class ApolloPanel$34$1
  implements Runnable
{
  public ApolloPanel$34$1(ajcu paramajcu) {}
  
  public void run()
  {
    ApolloPanel.a(this.a.a).setVisibility(0);
    this.a.a.b.setVisibility(0);
    ApolloPanel.a(this.a.a).setVisibility(8);
    if ((aifs.a) && (ApolloPanel.d(this.a.a)))
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
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.34.1
 * JD-Core Version:    0.7.0.1
 */