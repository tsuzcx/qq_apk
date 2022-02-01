package com.tencent.mobileqq.activity.aio.anim.friendship.impl.base;

import com.tencent.qphone.base.util.QLog;

class FriendShipViewManager$1
  implements IDirector.OnDirectorPrepared
{
  FriendShipViewManager$1(FriendShipViewManager paramFriendShipViewManager, IDirector paramIDirector) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FriendShipViewManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipViewManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseIDirector.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseIDirector.a();
      return;
    }
    QLog.e("FriendShipViewManager", 1, "director.prepare not ready, cannot play anim, type = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseIDirector.a());
    FriendShipViewManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipViewManager, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipViewManager.1
 * JD-Core Version:    0.7.0.1
 */