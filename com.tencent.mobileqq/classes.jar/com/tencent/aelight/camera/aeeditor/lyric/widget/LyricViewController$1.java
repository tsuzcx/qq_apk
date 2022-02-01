package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.util.Log;

class LyricViewController$1
  implements LyricViewScroll.LyricViewScrollListener
{
  LyricViewController$1(LyricViewController paramLyricViewController) {}
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScrolling() top => ");
    localStringBuilder.append(paramInt);
    Log.d("ModuleController", localStringBuilder.toString());
    this.a.d(paramInt);
  }
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScrollStop -> top:");
    localStringBuilder.append(paramInt);
    Log.d("ModuleController", localStringBuilder.toString());
    this.a.c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewController.1
 * JD-Core Version:    0.7.0.1
 */