package com.tencent.mobileqq.activity;

import abgi;
import abgm;
import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

public class FriendProfileImageAvatar$1
  implements Runnable
{
  public FriendProfileImageAvatar$1(abgi paramabgi, abgm paramabgm) {}
  
  public void run()
  {
    localaukn = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (localaukn != null) {}
    try
    {
      Setting localSetting = (Setting)localaukn.a(Setting.class, this.a.d);
      if ((localSetting != null) && ((localSetting.headImgTimestamp != 0L) || (localSetting.updateTimestamp != 0L)))
      {
        localSetting.headImgTimestamp = 0L;
        localSetting.updateTimestamp = 0L;
        localaukn.a(localSetting);
        this.this$0.a.a(localSetting);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localaukn.a();
      }
    }
    finally
    {
      localaukn.a();
    }
    this.this$0.a.e(this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.1
 * JD-Core Version:    0.7.0.1
 */