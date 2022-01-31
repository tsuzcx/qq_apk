package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import uwa;
import uwm;
import wvn;

public class MessageNotifySegment$1
  implements Runnable
{
  public MessageNotifySegment$1(wvn paramwvn, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    uwm localuwm = (uwm)uwa.a(2);
    String str = localuwm.b(Long.toString(wvn.a(this.this$0)), true);
    ThreadManager.getUIHandler().post(new MessageNotifySegment.1.1(this, str, localuwm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1
 * JD-Core Version:    0.7.0.1
 */