package com.tencent.av.ui.chatroom;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmotionInputDetector$5
  implements View.OnClickListener
{
  EmotionInputDetector$5(EmotionInputDetector paramEmotionInputDetector) {}
  
  public void onClick(View paramView)
  {
    if ((EmotionInputDetector.c(this.a) != null) && (EmotionInputDetector.c(this.a).isShown())) {
      this.a.c();
    } else {
      EmotionInputDetector.d(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.EmotionInputDetector.5
 * JD-Core Version:    0.7.0.1
 */