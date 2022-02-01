package com.tencent.biz.qqstory.playvideo;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class StoryPlayerFragment$3
  implements View.OnKeyListener
{
  StoryPlayerFragment$3(StoryPlayerFragment paramStoryPlayerFragment) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (paramKeyEvent.getAction() == 1) {
        this.a.finish();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerFragment.3
 * JD-Core Version:    0.7.0.1
 */