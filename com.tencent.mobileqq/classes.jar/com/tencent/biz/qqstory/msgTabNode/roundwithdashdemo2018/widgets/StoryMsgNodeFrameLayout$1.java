package com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets;

import android.os.Handler;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.widget.MessageProgressView;
import wmf;

class StoryMsgNodeFrameLayout$1
  implements Runnable
{
  StoryMsgNodeFrameLayout$1(StoryMsgNodeFrameLayout paramStoryMsgNodeFrameLayout) {}
  
  public void run()
  {
    int i = wmf.a().a();
    if (i >= 0)
    {
      this.this$0.a.setAnimProgress(i, QQStoryContext.a().b());
      if (i < 100) {
        StoryMsgNodeFrameLayout.a(this.this$0).postDelayed(StoryMsgNodeFrameLayout.a(this.this$0), 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout.1
 * JD-Core Version:    0.7.0.1
 */