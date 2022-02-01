package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.log.AEQLog;

class LyricWithBuoyView$3
  implements View.OnClickListener
{
  LyricWithBuoyView$3(LyricWithBuoyView paramLyricWithBuoyView) {}
  
  public void onClick(View paramView)
  {
    AEQLog.a("LyricWithBuoyView", "LyricWithBuoyView onClick()");
    if (LyricWithBuoyView.a(this.a) != null)
    {
      LyricWithBuoyView.a(this.a).a();
      return;
    }
    AEQLog.a("LyricWithBuoyView", "onClick() mOnLyricWithBuoyViewOperationListener == null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricWithBuoyView.3
 * JD-Core Version:    0.7.0.1
 */