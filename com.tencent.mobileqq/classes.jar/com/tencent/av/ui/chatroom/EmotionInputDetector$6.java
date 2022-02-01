package com.tencent.av.ui.chatroom;

import android.view.MotionEvent;

class EmotionInputDetector$6
  implements VideoChatRoomListView.OnDispatchTouchEventResponseListener
{
  EmotionInputDetector$6(EmotionInputDetector paramEmotionInputDetector) {}
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.a.c()) {
        break label23;
      }
      this.a.c();
    }
    for (;;)
    {
      return false;
      label23:
      if (this.a.b()) {
        this.a.b();
      } else if (EmotionInputDetector.a(this.a) != null) {
        EmotionInputDetector.a(this.a).a(paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.EmotionInputDetector.6
 * JD-Core Version:    0.7.0.1
 */