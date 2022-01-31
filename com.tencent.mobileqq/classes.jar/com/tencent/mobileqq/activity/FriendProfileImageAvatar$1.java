package com.tencent.mobileqq.activity;

import aawl;
import aawp;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

public class FriendProfileImageAvatar$1
  implements Runnable
{
  public FriendProfileImageAvatar$1(aawl paramaawl, aawp paramaawp) {}
  
  public void run()
  {
    localatmp = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (localatmp != null) {}
    try
    {
      Setting localSetting = (Setting)localatmp.a(Setting.class, this.a.d);
      if ((localSetting != null) && ((localSetting.headImgTimestamp != 0L) || (localSetting.updateTimestamp != 0L)))
      {
        localSetting.headImgTimestamp = 0L;
        localSetting.updateTimestamp = 0L;
        localatmp.a(localSetting);
        this.this$0.a.a(localSetting);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localatmp.a();
      }
    }
    finally
    {
      localatmp.a();
    }
    this.this$0.a.e(this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.1
 * JD-Core Version:    0.7.0.1
 */