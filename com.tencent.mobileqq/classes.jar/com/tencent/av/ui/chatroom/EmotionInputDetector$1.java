package com.tencent.av.ui.chatroom;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmotionInputDetector$1
  implements View.OnClickListener
{
  EmotionInputDetector$1(EmotionInputDetector paramEmotionInputDetector) {}
  
  public void onClick(View paramView)
  {
    EmotionInputDetector.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.EmotionInputDetector.1
 * JD-Core Version:    0.7.0.1
 */