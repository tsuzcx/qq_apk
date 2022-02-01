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
    int i = this.a.a.jdField_a_of_type_Int / 2;
    int j = (int)(this.a.a.b - DisplayUtil.a(this.a.a.jdField_a_of_type_AndroidContentContext, 178.0F) - this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    int k = (int)(this.a.a.b - DisplayUtil.a(this.a.a.jdField_a_of_type_AndroidContentContext, 200.0F) - this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new MoveToAction(450, i, j, i, k), new MoveToAction(450, i, k, i, j) });
    localSequenceAction.a = true;
    this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { localSequenceAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView.2.1
 * JD-Core Version:    0.7.0.1
 */