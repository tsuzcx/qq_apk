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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("director.prepare not ready, cannot play anim, type = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseIDirector.a());
    QLog.e("FriendShipViewManager", 1, localStringBuilder.toString());
    FriendShipViewManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBaseFriendShipViewManager, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipViewManager.1
 * JD-Core Version:    0.7.0.1
 */