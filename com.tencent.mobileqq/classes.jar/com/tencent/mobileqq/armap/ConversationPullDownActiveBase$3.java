package com.tencent.mobileqq.armap;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class ConversationPullDownActiveBase$3
  extends AnimateUtils.AnimationAdapter
{
  ConversationPullDownActiveBase$3(ConversationPullDownActiveBase paramConversationPullDownActiveBase) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationPullDownActiveBase.3
 * JD-Core Version:    0.7.0.1
 */