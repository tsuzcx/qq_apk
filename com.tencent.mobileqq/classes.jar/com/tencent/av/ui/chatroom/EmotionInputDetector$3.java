package com.tencent.av.ui.chatroom;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class EmotionInputDetector$3
  implements View.OnKeyListener
{
  EmotionInputDetector$3(EmotionInputDetector paramEmotionInputDetector) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && ((paramInt == 23) || (paramInt == 66)))
    {
      EmotionInputDetector.b(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.EmotionInputDetector.3
 * JD-Core Version:    0.7.0.1
 */