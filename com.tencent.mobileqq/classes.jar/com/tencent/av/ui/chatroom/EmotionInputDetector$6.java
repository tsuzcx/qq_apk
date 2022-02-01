package com.tencent.av.ui.chatroom;

import android.view.MotionEvent;

class EmotionInputDetector$6
  implements VideoChatRoomListView.OnDispatchTouchEventResponseListener
{
  EmotionInputDetector$6(EmotionInputDetector paramEmotionInputDetector) {}
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.a.g()) {
        this.a.h();
      } else if (this.a.f()) {
        this.a.c();
      } else if (EmotionInputDetector.e(this.a) != null) {
        EmotionInputDetector.e(this.a).a(paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.EmotionInputDetector.6
 * JD-Core Version:    0.7.0.1
 */