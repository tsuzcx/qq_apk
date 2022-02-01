package com.tencent.biz.TroopRedpoint;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

final class TroopRedTouchHandler$4
  implements Runnable
{
  TroopRedTouchHandler$4(QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    Object localObject = this.a.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localStringBuilder.append("RedTouchExManager_GetTime");
    localObject = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_get_time", System.currentTimeMillis() / 1000L);
      ((SharedPreferences.Editor)localObject).putLong("interval_time", this.b);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.4
 * JD-Core Version:    0.7.0.1
 */