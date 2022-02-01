package com.tencent.biz.qqstory.storyHome;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryInputBarView;

class QQStoryMainController$4
  implements Runnable
{
  QQStoryMainController$4(QQStoryMainController paramQQStoryMainController) {}
  
  public void run()
  {
    if (QQStoryMainController.a(this.this$0)) {
      return;
    }
    QQStoryMainController localQQStoryMainController = this.this$0;
    localQQStoryMainController.f = localQQStoryMainController.h();
    this.this$0.f.setInputViewHideListener(this.this$0.b);
    this.this$0.l.a(this.this$0.d, this.this$0.a(), this.this$0.b);
    localQQStoryMainController = this.this$0;
    QQStoryMainController.a(localQQStoryMainController, localQQStoryMainController.i.c());
    localQQStoryMainController = this.this$0;
    QQStoryMainController.a(localQQStoryMainController, localQQStoryMainController.i.d());
    QQStoryMainController.b(this.this$0).setVisibility(8);
    QQStoryMainController.c(this.this$0).setVisibility(8);
    QQStoryMainController.a(this.this$0.a, "mainHallConfig", QQStoryMainController.b(this.this$0), QQStoryMainController.c(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.4
 * JD-Core Version:    0.7.0.1
 */