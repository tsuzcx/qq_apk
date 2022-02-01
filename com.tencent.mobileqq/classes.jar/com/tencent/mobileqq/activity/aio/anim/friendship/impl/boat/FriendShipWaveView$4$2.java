package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.RotateAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;

class FriendShipWaveView$4$2
  implements Action.OnActionEndListener
{
  FriendShipWaveView$4$2(FriendShipWaveView.4 param4) {}
  
  public void a()
  {
    RotateAction localRotateAction = new RotateAction(3000, 360, 0);
    localRotateAction.a = true;
    this.a.a.e.a(new Action[] { localRotateAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView.4.2
 * JD-Core Version:    0.7.0.1
 */