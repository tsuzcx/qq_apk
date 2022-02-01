package com.tencent.mobileqq.activity.aio.tips;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

class LightalkBlueTipsBar$3
  implements Runnable
{
  LightalkBlueTipsBar$3(LightalkBlueTipsBar paramLightalkBlueTipsBar) {}
  
  public void run()
  {
    Object localObject = LightalkBlueTipsBar.a(this.this$0).getPreferences();
    if (((SharedPreferences)localObject).getInt("LT_tip_show_times" + LightalkBlueTipsBar.a(this.this$0).getCurrentAccountUin(), 5) != 5)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("LT_tip_show_times" + LightalkBlueTipsBar.a(this.this$0).getCurrentAccountUin(), 5);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.3
 * JD-Core Version:    0.7.0.1
 */