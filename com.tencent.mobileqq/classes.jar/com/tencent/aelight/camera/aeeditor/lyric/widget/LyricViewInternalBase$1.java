package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class LyricViewInternalBase$1
  extends Handler
{
  LyricViewInternalBase$1(LyricViewInternalBase paramLyricViewInternalBase, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = new StringBuilder();
    paramMessage.append("mRefreshHandler -> handleMessage begin, mState:");
    paramMessage.append(this.a.l);
    Log.d("ModuleLyricViewInternal", paramMessage.toString());
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewInternalBase.1
 * JD-Core Version:    0.7.0.1
 */