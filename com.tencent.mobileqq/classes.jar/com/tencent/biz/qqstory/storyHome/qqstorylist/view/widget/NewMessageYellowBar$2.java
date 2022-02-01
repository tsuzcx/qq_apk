package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.widget.TextView;
import java.util.Locale;

class NewMessageYellowBar$2
  implements Runnable
{
  NewMessageYellowBar$2(NewMessageYellowBar paramNewMessageYellowBar, int paramInt) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.getDefault(), "%d个小视频更新", new Object[] { Integer.valueOf(this.a) }));
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.this$0.jdField_a_of_type_AndroidViewAnimationAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar.2
 * JD-Core Version:    0.7.0.1
 */