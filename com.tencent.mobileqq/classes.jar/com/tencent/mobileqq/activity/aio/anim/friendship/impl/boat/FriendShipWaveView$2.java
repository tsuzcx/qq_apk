package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.MoveToAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.util.DisplayUtil;

class FriendShipWaveView$2
  implements Action.OnActionEndListener
{
  FriendShipWaveView$2(FriendShipWaveView paramFriendShipWaveView) {}
  
  public void a()
  {
    int i = (int)(this.a.c - DisplayUtil.a(this.a.d, 165.0F) - this.a.e.c / 2.0F);
    int j = (int)(this.a.c - DisplayUtil.a(this.a.d, 200.0F) - this.a.e.c / 2.0F);
    int k = (int)(this.a.c - DisplayUtil.a(this.a.d, 178.0F) - this.a.e.c / 2.0F);
    float f2 = this.a.b / 2;
    float f3 = (int)(-this.a.e.c / 2.0F);
    float f4 = this.a.b / 2;
    float f1 = i;
    Object localObject = new MoveToAction(450, f2, f3, f4, f1);
    f2 = this.a.b / 2;
    f3 = this.a.b / 2;
    f4 = j;
    localObject = new SequenceAction(new Action[] { localObject, new MoveToAction(450, f2, f1, f3, f4), new MoveToAction(450, this.a.b / 2, f4, this.a.b / 2, k) });
    ((SequenceAction)localObject).a(new FriendShipWaveView.2.1(this));
    this.a.e.a(new Action[] { localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView.2
 * JD-Core Version:    0.7.0.1
 */