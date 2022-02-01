package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import wpm;
import wpy;
import yoy;

public class MessageNotifySegment$1
  implements Runnable
{
  public MessageNotifySegment$1(yoy paramyoy, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    wpy localwpy = (wpy)wpm.a(2);
    String str = localwpy.b(Long.toString(yoy.a(this.this$0)), true);
    ThreadManager.getUIHandler().post(new MessageNotifySegment.1.1(this, str, localwpy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1
 * JD-Core Version:    0.7.0.1
 */