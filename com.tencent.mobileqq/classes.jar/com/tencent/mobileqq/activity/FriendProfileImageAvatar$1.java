package com.tencent.mobileqq.activity;

import aeqv;
import aeqz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.persistence.EntityManager;

public class FriendProfileImageAvatar$1
  implements Runnable
{
  public FriendProfileImageAvatar$1(aeqv paramaeqv, aeqz paramaeqz) {}
  
  public void run()
  {
    localEntityManager = this.this$0.a.a().createEntityManager();
    if (localEntityManager != null) {}
    try
    {
      Setting localSetting = (Setting)localEntityManager.find(Setting.class, this.a.d);
      if ((localSetting != null) && ((localSetting.headImgTimestamp != 0L) || (localSetting.updateTimestamp != 0L)))
      {
        localSetting.headImgTimestamp = 0L;
        localSetting.updateTimestamp = 0L;
        localEntityManager.update(localSetting);
        this.this$0.a.a(localSetting);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localEntityManager.close();
      }
    }
    finally
    {
      localEntityManager.close();
    }
    this.this$0.a.e(this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.1
 * JD-Core Version:    0.7.0.1
 */