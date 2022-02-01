package com.tencent.luggage.wxa.qa;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class a$4
  implements Runnable
{
  a$4(a parama, TextView paramTextView1, ImageView paramImageView1, TextView paramTextView2, RelativeLayout paramRelativeLayout, ImageView paramImageView2) {}
  
  public void run()
  {
    int i = this.a.getMeasuredWidth() - this.b.getMeasuredWidth() >> 1;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((i > 0) && (this.b.getVisibility() != 8))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      int j = this.f.getResources().getDimensionPixelSize(2131296781) - i;
      if (localLayoutParams.leftMargin != j)
      {
        localLayoutParams.leftMargin = j;
        this.d.updateViewLayout(this.c, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
      i = this.f.getResources().getDimensionPixelSize(2131296782) - i;
      if (localLayoutParams.leftMargin != i)
      {
        localLayoutParams.leftMargin = i;
        this.d.updateViewLayout(this.e, localLayoutParams);
      }
    }
    else
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      i = this.f.getResources().getDimensionPixelSize(2131296781);
      if (localLayoutParams.leftMargin != i)
      {
        localLayoutParams.leftMargin = i;
        this.d.updateViewLayout(this.c, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
      i = this.f.getResources().getDimensionPixelSize(2131296782);
      if (localLayoutParams.leftMargin != i)
      {
        localLayoutParams.leftMargin = i;
        this.d.updateViewLayout(this.e, localLayoutParams);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.a.4
 * JD-Core Version:    0.7.0.1
 */