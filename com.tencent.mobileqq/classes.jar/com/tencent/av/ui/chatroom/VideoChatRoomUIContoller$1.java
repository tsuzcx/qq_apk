package com.tencent.av.ui.chatroom;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class VideoChatRoomUIContoller$1
  implements Animation.AnimationListener
{
  VideoChatRoomUIContoller$1(VideoChatRoomUIContoller paramVideoChatRoomUIContoller) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (VideoChatRoomUIContoller.a(this.a) != null) {
      VideoChatRoomUIContoller.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.1
 * JD-Core Version:    0.7.0.1
 */