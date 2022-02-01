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
      FriendShipViewManager.a(this.b, this.a.f());
      this.a.a();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("director.prepare not ready, cannot play anim, type = ");
    localStringBuilder.append(this.a.f());
    QLog.e("FriendShipViewManager", 1, localStringBuilder.toString());
    FriendShipViewManager.a(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipViewManager.1
 * JD-Core Version:    0.7.0.1
 */