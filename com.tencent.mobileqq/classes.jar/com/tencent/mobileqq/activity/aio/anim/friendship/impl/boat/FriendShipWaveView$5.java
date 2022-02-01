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
    this.a.h.a = 255;
    localSequenceAction.a = true;
    this.a.h.a(new Action[] { localSequenceAction });
    this.a.l = new Sprite();
    this.a.l.a(FriendShipWaveView.d(this.a));
    this.a.l.g = 30.0F;
    this.a.l.a(this.a.e.c - DisplayUtil.a(this.a.a, 25.0F), this.a.e.d - DisplayUtil.a(this.a.a, 25.0F));
    localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(600, 0.0F, 0.6F), new ScaleAction(600, 0.6F, 0.0F) });
    localSequenceAction.a = true;
    this.a.a(this.a.l);
    this.a.l.a(new Action[] { localSequenceAction });
    this.a.i = new Sprite();
    this.a.i.a(FriendShipWaveView.d(this.a));
    this.a.i.a(this.a.e.c + DisplayUtil.a(this.a.a, 20.0F), this.a.e.d - DisplayUtil.a(this.a.a, 10.0F));
    localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(500, 0.0F, 1.2F), new ScaleAction(500, 1.2F, 0.0F) });
    localSequenceAction.a = true;
    this.a.a(this.a.i);
    this.a.i.a(new Action[] { localSequenceAction });
    this.a.j = new Sprite();
    this.a.j.a(FriendShipWaveView.d(this.a));
    this.a.j.a(this.a.f.c + DisplayUtil.a(this.a.a, 13.0F), this.a.f.d + DisplayUtil.a(this.a.a, 13.0F));
    localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(500, 0.2F, 0.6F), new ScaleAction(500, 0.6F, 0.2F) });
    localSequenceAction.a = true;
    this.a.a(this.a.j);
    this.a.j.a(new Action[] { localSequenceAction });
    this.a.k = new Sprite();
    this.a.k.a(FriendShipWaveView.d(this.a));
    this.a.k.a(this.a.g.c - DisplayUtil.a(this.a.a, 10.0F), this.a.g.d - DisplayUtil.a(this.a.a, 3.0F));
    localSequenceAction = new SequenceAction(new Action[] { new ScaleAction(400, 0.0F, 0.6F), new ScaleAction(400, 0.6F, 0.0F) });
    localSequenceAction.a = true;
    this.a.a(this.a.k);
    this.a.k.a(new Action[] { localSequenceAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView.5
 * JD-Core Version:    0.7.0.1
 */