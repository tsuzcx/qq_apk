package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import sqg;
import sqs;
import upt;

public class MessageNotifySegment$1
  implements Runnable
{
  public MessageNotifySegment$1(upt paramupt, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    sqs localsqs = (sqs)sqg.a(2);
    String str = localsqs.b(Long.toString(upt.a(this.this$0)), true);
    ThreadManager.getUIHandler().post(new MessageNotifySegment.1.1(this, str, localsqs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1
 * JD-Core Version:    0.7.0.1
 */