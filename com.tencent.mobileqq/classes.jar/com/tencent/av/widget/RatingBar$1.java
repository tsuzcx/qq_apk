package com.tencent.av.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RatingBar$1
  implements View.OnClickListener
{
  RatingBar$1(RatingBar paramRatingBar) {}
  
  public void onClick(View paramView)
  {
    if (RatingBar.a(this.a))
    {
      RatingBar localRatingBar = this.a;
      RatingBar.a(localRatingBar, localRatingBar.indexOfChild(paramView) + 1);
      localRatingBar = this.a;
      localRatingBar.setStar(RatingBar.a(localRatingBar), true);
      if (RatingBar.a(this.a) != null) {
        RatingBar.a(this.a).a(RatingBar.a(this.a), RatingBar.a(this.a));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.RatingBar.1
 * JD-Core Version:    0.7.0.1
 */