package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import wth;
import wtt;
import yst;

public class MessageNotifySegment$1
  implements Runnable
{
  public MessageNotifySegment$1(yst paramyst, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    wtt localwtt = (wtt)wth.a(2);
    String str = localwtt.b(Long.toString(yst.a(this.this$0)), true);
    ThreadManager.getUIHandler().post(new MessageNotifySegment.1.1(this, str, localwtt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1
 * JD-Core Version:    0.7.0.1
 */