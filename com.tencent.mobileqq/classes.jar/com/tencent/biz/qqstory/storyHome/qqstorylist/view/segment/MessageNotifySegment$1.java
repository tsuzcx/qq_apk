package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tcz;
import tdl;
import vcm;

public class MessageNotifySegment$1
  implements Runnable
{
  public MessageNotifySegment$1(vcm paramvcm, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    tdl localtdl = (tdl)tcz.a(2);
    String str = localtdl.b(Long.toString(vcm.a(this.this$0)), true);
    ThreadManager.getUIHandler().post(new MessageNotifySegment.1.1(this, str, localtdl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1
 * JD-Core Version:    0.7.0.1
 */