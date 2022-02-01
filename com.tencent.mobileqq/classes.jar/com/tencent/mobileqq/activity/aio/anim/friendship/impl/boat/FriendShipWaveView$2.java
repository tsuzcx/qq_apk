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
    int i = (int)(this.a.b - DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 165.0F) - this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    int j = (int)(this.a.b - DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 200.0F) - this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    int k = (int)(this.a.b - DisplayUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 178.0F) - this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F);
    SequenceAction localSequenceAction = new SequenceAction(new Action[] { new MoveToAction(450, this.a.jdField_a_of_type_Int / 2, (int)(-this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.b / 2.0F), this.a.jdField_a_of_type_Int / 2, i), new MoveToAction(450, this.a.jdField_a_of_type_Int / 2, i, this.a.jdField_a_of_type_Int / 2, j), new MoveToAction(450, this.a.jdField_a_of_type_Int / 2, j, this.a.jdField_a_of_type_Int / 2, k) });
    localSequenceAction.a(new FriendShipWaveView.2.1(this));
    this.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite.a(new Action[] { localSequenceAction });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView.2
 * JD-Core Version:    0.7.0.1
 */