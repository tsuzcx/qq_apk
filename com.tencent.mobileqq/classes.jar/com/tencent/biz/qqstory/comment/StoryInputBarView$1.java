package com.tencent.biz.qqstory.comment;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.InputViewHideListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class StoryInputBarView$1
  implements TextView.OnEditorActionListener
{
  StoryInputBarView$1(StoryInputBarView paramStoryInputBarView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 4)
    {
      String str = paramTextView.getText().toString();
      if (str.length() > 0)
      {
        this.a.setKeyBoardState(false);
        if (this.a.p != null) {
          this.a.p.a(str, this.a.o);
        }
        this.a.c();
        this.a.e.setText("");
        if (StoryInputBarView.a(this.a) != null) {
          StoryInputBarView.a(this.a).a(str, this.a.o);
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onEditorAction vaule=");
          localStringBuilder.append(str);
          QLog.d("Q.qqstory:StoryInputBarView", 2, localStringBuilder.toString());
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = true;
      }
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView.1
 * JD-Core Version:    0.7.0.1
 */