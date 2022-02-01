package com.tencent.av.ui.chatroom;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class VideoChatRoomUIContoller$2
  extends D8SafeAnimatorListener
{
  VideoChatRoomUIContoller$2(VideoChatRoomUIContoller paramVideoChatRoomUIContoller) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VideoChatRoomUIContoller.a(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.2
 * JD-Core Version:    0.7.0.1
 */