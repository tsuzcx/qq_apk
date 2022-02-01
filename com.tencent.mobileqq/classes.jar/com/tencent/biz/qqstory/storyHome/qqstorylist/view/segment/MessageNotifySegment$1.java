package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MessageNotifySegment$1
  implements Runnable
{
  MessageNotifySegment$1(MessageNotifySegment paramMessageNotifySegment, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    String str = localUserManager.b(Long.toString(MessageNotifySegment.a(this.this$0)), true);
    ThreadManager.getUIHandler().post(new MessageNotifySegment.1.1(this, str, localUserManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1
 * JD-Core Version:    0.7.0.1
 */