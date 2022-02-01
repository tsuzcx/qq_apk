package com.tencent.mm.ui.widget;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

class ThreeDotsLoadingView$1
  implements Runnable
{
  ThreeDotsLoadingView$1(ThreeDotsLoadingView paramThreeDotsLoadingView) {}
  
  public void run()
  {
    ThreeDotsLoadingView.a(this.a);
    ((AnimationDrawable)ThreeDotsLoadingView.b(this.a).getDrawable()).start();
    ((AnimationDrawable)ThreeDotsLoadingView.c(this.a).getDrawable()).start();
    ((AnimationDrawable)ThreeDotsLoadingView.d(this.a).getDrawable()).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView.1
 * JD-Core Version:    0.7.0.1
 */