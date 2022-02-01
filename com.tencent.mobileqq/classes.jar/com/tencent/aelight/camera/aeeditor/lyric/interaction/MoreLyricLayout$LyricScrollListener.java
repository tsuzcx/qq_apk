package com.tencent.aelight.camera.aeeditor.lyric.interaction;

import android.widget.TextView;
import com.tencent.aelight.camera.aeeditor.lyric.widget.LyricScrollHelper.LyricScrollListener;
import com.tencent.aelight.camera.aeeditor.lyric.widget.LyricWithBuoyView;
import com.tencent.aelight.camera.log.AEQLog;

class MoreLyricLayout$LyricScrollListener
  implements LyricScrollHelper.LyricScrollListener
{
  private MoreLyricLayout$LyricScrollListener(MoreLyricLayout paramMoreLyricLayout) {}
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScroll() position => ");
    localStringBuilder.append(paramLong);
    AEQLog.a("MoreLyricLayout", localStringBuilder.toString());
    MoreLyricLayout.b(this.a);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    MoreLyricLayout.a(this.a, paramLong1);
    String str = LyricWithBuoyView.a((int)paramLong1);
    TextView localTextView;
    if (MoreLyricLayout.c(this.a) != null) {
      localTextView = MoreLyricLayout.c(this.a).getMusicCurrentTime();
    } else {
      localTextView = null;
    }
    if (localTextView != null) {
      localTextView.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.MoreLyricLayout.LyricScrollListener
 * JD-Core Version:    0.7.0.1
 */