package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.action.SequenceAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.util.DisplayUtil;

class FriendShipWaveView$5
  implements Action.OnActionEndListener
{
  FriendShipWaveView$5(FriendShipWaveView paramFriendShipWaveView) {}
  
  public void a()
  {
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(400, 0.2F, 1.0F), new ScaleAction(400, 1.0F, 0.2F) });
    this.a.l.i = 255;
    localSequenceAction.i = true;
    this.a.l.a(new Action[] { localSequenceAction });
    this.a.p = new Sprite();
    this.a.p.a(FriendShipWaveView.d(this.a));
    this.a.p.h = 30.0F;
    this.a.p.a(this.a.i.d - DisplayUtil.a(this.a.d, 25.0F), this.a.i.e - DisplayUtil.a(this.a.d, 25.0F));
    localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(600, 0.0F, 0.6F), new ScaleAction(600, 0.6F, 0.0F) });
    localSequenceAction.i = true;
    FriendShipWaveView localFriendShipWaveView = this.a;
    localFriendShipWaveView.a(localFriendShipWaveView.p);
    this.a.p.a(new Action[] { localSequenceAction });
    this.a.m = new Sprite();
    this.a.m.a(FriendShipWaveView.d(this.a));
    this.a.m.a(this.a.i.d + DisplayUtil.a(this.a.d, 20.0F), this.a.i.e - DisplayUtil.a(this.a.d, 10.0F));
    localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(500, 0.0F, 1.2F), new ScaleAction(500, 1.2F, 0.0F) });
    localSequenceAction.i = true;
    localFriendShipWaveView = this.a;
    localFriendShipWaveView.a(localFriendShipWaveView.m);
    this.a.m.a(new Action[] { localSequenceAction });
    this.a.n = new Sprite();
    this.a.n.a(FriendShipWaveView.d(this.a));
    this.a.n.a(this.a.j.d + DisplayUtil.a(this.a.d, 13.0F), this.a.j.e + DisplayUtil.a(this.a.d, 13.0F));
    localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(500, 0.2F, 0.6F), new ScaleAction(500, 0.6F, 0.2F) });
    localSequenceAction.i = true;
    localFriendShipWaveView = this.a;
    localFriendShipWaveView.a(localFriendShipWaveView.n);
    this.a.n.a(new Action[] { localSequenceAction });
    this.a.o = new Sprite();
    this.a.o.a(FriendShipWaveView.d(this.a));
    this.a.o.a(this.a.k.d - DisplayUtil.a(this.a.d, 10.0F), this.a.k.e - DisplayUtil.a(this.a.d, 3.0F));
    localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(400, 0.0F, 0.6F), new ScaleAction(400, 0.6F, 0.0F) });
    localSequenceAction.i = true;
    localFriendShipWaveView = this.a;
    localFriendShipWaveView.a(localFriendShipWaveView.o);
    this.a.o.a(new Action[] { localSequenceAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView.5
 * JD-Core Version:    0.7.0.1
 */