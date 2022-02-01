package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.MoveToAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.util.DisplayUtil;

class FriendShipWaveView$2$1
  implements Action.OnActionEndListener
{
  FriendShipWaveView$2$1(FriendShipWaveView.2 param2) {}
  
  public void a()
  {
    int i = this.a.a.b / 2;
    int j = (int)(this.a.a.c - DisplayUtil.a(this.a.a.d, 178.0F) - this.a.a.e.c / 2.0F);
    int k = (int)(this.a.a.c - DisplayUtil.a(this.a.a.d, 200.0F) - this.a.a.e.c / 2.0F);
    float f1 = i;
    float f2 = j;
    float f3 = k;
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new MoveToAction(450, f1, f2, f1, f3), new MoveToAction(450, f1, f3, f1, f2) });
    localSequenceAction.i = true;
    this.a.a.e.a(new Action[] { localSequenceAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView.2.1
 * JD-Core Version:    0.7.0.1
 */