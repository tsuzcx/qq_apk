package com.tencent.mobileqq.activity;

import acxe;
import acxi;
import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

public class FriendProfileImageAvatar$1
  implements Runnable
{
  public FriendProfileImageAvatar$1(acxe paramacxe, acxi paramacxi) {}
  
  public void run()
  {
    localawbw = this.this$0.a.getEntityManagerFactory().createEntityManager();
    if (localawbw != null) {}
    try
    {
      Setting localSetting = (Setting)localawbw.a(Setting.class, this.a.d);
      if ((localSetting != null) && ((localSetting.headImgTimestamp != 0L) || (localSetting.updateTimestamp != 0L)))
      {
        localSetting.headImgTimestamp = 0L;
        localSetting.updateTimestamp = 0L;
        localawbw.a(localSetting);
        this.this$0.a.a(localSetting);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localawbw.a();
      }
    }
    finally
    {
      localawbw.a();
    }
    this.this$0.a.e(this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.1
 * JD-Core Version:    0.7.0.1
 */