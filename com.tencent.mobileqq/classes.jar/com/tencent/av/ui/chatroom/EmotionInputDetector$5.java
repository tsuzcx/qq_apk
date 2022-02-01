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
    if ((EmotionInputDetector.a(this.a) != null) && (EmotionInputDetector.a(this.a).isShown())) {
      this.a.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      EmotionInputDetector.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.EmotionInputDetector.5
 * JD-Core Version:    0.7.0.1
 */