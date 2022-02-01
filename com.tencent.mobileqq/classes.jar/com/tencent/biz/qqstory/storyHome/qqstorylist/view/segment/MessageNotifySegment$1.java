package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import wjs;
import wke;
import yiz;

public class MessageNotifySegment$1
  implements Runnable
{
  public MessageNotifySegment$1(yiz paramyiz, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void run()
  {
    wke localwke = (wke)wjs.a(2);
    String str = localwke.b(Long.toString(yiz.a(this.this$0)), true);
    ThreadManager.getUIHandler().post(new MessageNotifySegment.1.1(this, str, localwke));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.MessageNotifySegment.1
 * JD-Core Version:    0.7.0.1
 */