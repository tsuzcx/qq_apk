package com.tencent.biz.qqstory.boundaries.implement.staticmethods;

import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;

public class StaticMethods$QQStoryAutoPlayView
{
  public static boolean a(QQStoryAutoPlayView paramQQStoryAutoPlayView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      paramMotionEvent = new ScaleAnimation(1.0F, 0.95F, 1.0F, 0.95F, 1, 0.5F, 1, 0.5F);
      paramMotionEvent.setDuration(100L);
      paramMotionEvent.setFillAfter(true);
      paramQQStoryAutoPlayView.startAnimation(paramMotionEvent);
    }
    for (;;)
    {
      return true;
      if ((i == 3) || (i == 1))
      {
        paramMotionEvent = new ScaleAnimation(0.95F, 1.0F, 0.95F, 1.0F, 1, 0.5F, 1, 0.5F);
        paramMotionEvent.setDuration(100L);
        paramMotionEvent.setFillAfter(true);
        paramQQStoryAutoPlayView.startAnimation(paramMotionEvent);
        if (i == 1) {
          paramQQStoryAutoPlayView.performClick();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.implement.staticmethods.StaticMethods.QQStoryAutoPlayView
 * JD-Core Version:    0.7.0.1
 */