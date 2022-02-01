package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class FriendProfileImageAvatar$1
  implements Runnable
{
  FriendProfileImageAvatar$1(FriendProfileImageAvatar paramFriendProfileImageAvatar, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.l.getEntityManagerFactory().createEntityManager();
    if (localObject1 != null) {}
    try
    {
      try
      {
        Setting localSetting = (Setting)((EntityManager)localObject1).find(Setting.class, this.a.g);
        if ((localSetting != null) && ((localSetting.headImgTimestamp != 0L) || (localSetting.updateTimestamp != 0L)))
        {
          localSetting.headImgTimestamp = 0L;
          localSetting.updateTimestamp = 0L;
          ((EntityManager)localObject1).update(localSetting);
          this.this$0.l.updateSettingTableCache(localSetting);
        }
      }
      finally
      {
        ((EntityManager)localObject1).close();
      }
    }
    catch (Exception localException)
    {
      label94:
      break label94;
    }
    ((EntityManager)localObject1).close();
    localObject1 = this.this$0;
    FriendProfileImageAvatar.a((FriendProfileImageAvatar)localObject1, ((FriendProfileImageAvatar)localObject1).h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.1
 * JD-Core Version:    0.7.0.1
 */