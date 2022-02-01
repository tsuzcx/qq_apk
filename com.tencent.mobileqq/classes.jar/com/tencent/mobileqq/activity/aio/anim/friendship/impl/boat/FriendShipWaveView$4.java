package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.action.ScaleAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.util.DisplayUtil;

class FriendShipWaveView$4
  implements Action.OnActionEndListener
{
  FriendShipWaveView$4(FriendShipWaveView paramFriendShipWaveView) {}
  
  public void a()
  {
    Object localObject = new ScaleAction(500, 0.0F, 1.0F);
    this.a.h.i = 255;
    this.a.h.a(new Action[] { localObject });
    ((ScaleAction)localObject).a(new FriendShipWaveView.4.1(this));
    this.a.i = new Sprite();
    this.a.i.a(FriendShipWaveView.a(this.a));
    this.a.i.a(this.a.b / 2 + DisplayUtil.a(this.a.d, 120.0F), this.a.f.e + 30.0F);
    localObject = this.a;
    ((FriendShipWaveView)localObject).a(((FriendShipWaveView)localObject).i);
    localObject = new ScaleAction(500, 0.0F, 1.0F);
    this.a.i.a(new Action[] { localObject });
    ((ScaleAction)localObject).a(new FriendShipWaveView.4.2(this));
    this.a.j = new Sprite();
    this.a.j.a(FriendShipWaveView.b(this.a));
    this.a.j.a(this.a.b / 2 - DisplayUtil.a(this.a.d, 142.0F), this.a.g.e - 50.0F);
    localObject = this.a;
    ((FriendShipWaveView)localObject).a(((FriendShipWaveView)localObject).j);
    localObject = new ScaleAction(500, 0.0F, 1.0F);
    this.a.j.a(new Action[] { localObject });
    ((ScaleAction)localObject).a(new FriendShipWaveView.4.3(this));
    this.a.k = new Sprite();
    this.a.k.a(FriendShipWaveView.c(this.a));
    this.a.k.a(this.a.b / 2 + DisplayUtil.a(this.a.d, 140.0F), this.a.g.e);
    localObject = this.a;
    ((FriendShipWaveView)localObject).a(((FriendShipWaveView)localObject).k);
    localObject = new ScaleAction(500, 0.0F, 1.0F);
    this.a.k.a(new Action[] { localObject });
    ((ScaleAction)localObject).a(new FriendShipWaveView.4.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView.4
 * JD-Core Version:    0.7.0.1
 */