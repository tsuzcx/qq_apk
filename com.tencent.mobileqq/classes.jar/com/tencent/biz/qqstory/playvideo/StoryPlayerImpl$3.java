package com.tencent.biz.qqstory.playvideo;

import android.media.AudioManager.OnAudioFocusChangeListener;

class StoryPlayerImpl$3
  implements AudioManager.OnAudioFocusChangeListener
{
  StoryPlayerImpl$3(StoryPlayerImpl paramStoryPlayerImpl) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (StoryPlayerImpl.c(this.a))) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.3
 * JD-Core Version:    0.7.0.1
 */