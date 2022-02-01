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
    ScaleAction localScaleAction = new ScaleAction(500, 0.0F, 1.0F);
    this.a.d.jdField_a_of_type_Int = 255;
    this.a.d.a(new Action[] { localScaleAction });
    localScaleAction.a(new FriendShipWaveView.4.1(this));
    this.a.e = new Sprite();
    this.a.e.a(FriendShipWaveView.a(this.a));
    this.a.e.a(this.a.jdField_a_of_type_Int / 2 + DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 120.0F), this.a.b.d + 30.0F);
    this.a.a(this.a.e);
    localScaleAction = new ScaleAction(500, 0.0F, 1.0F);
    this.a.e.a(new Action[] { localScaleAction });
    localScaleAction.a(new FriendShipWaveView.4.2(this));
    this.a.f = new Sprite();
    this.a.f.a(FriendShipWaveView.b(this.a));
    this.a.f.a(this.a.jdField_a_of_type_Int / 2 - DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 142.0F), this.a.c.d - 50.0F);
    this.a.a(this.a.f);
    localScaleAction = new ScaleAction(500, 0.0F, 1.0F);
    this.a.f.a(new Action[] { localScaleAction });
    localScaleAction.a(new FriendShipWaveView.4.3(this));
    this.a.g = new Sprite();
    this.a.g.a(FriendShipWaveView.c(this.a));
    this.a.g.a(this.a.jdField_a_of_type_Int / 2 + DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 140.0F), this.a.c.d);
    this.a.a(this.a.g);
    localScaleAction = new ScaleAction(500, 0.0F, 1.0F);
    this.a.g.a(new Action[] { localScaleAction });
    localScaleAction.a(new FriendShipWaveView.4.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView.4
 * JD-Core Version:    0.7.0.1
 */