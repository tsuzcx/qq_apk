package com.tencent.mobileqq.activity.aio.tips;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class LightalkBlueTipsBar$2
  implements Runnable
{
  LightalkBlueTipsBar$2(LightalkBlueTipsBar paramLightalkBlueTipsBar) {}
  
  public void run()
  {
    Object localObject1 = LightalkBlueTipsBar.a(this.this$0).getPreferences();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("LT_tip_show_times");
    ((StringBuilder)localObject2).append(LightalkBlueTipsBar.a(this.this$0).getCurrentAccountUin());
    int i = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
    localObject1 = ((SharedPreferences)localObject1).edit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("LT_tip_show_times");
    ((StringBuilder)localObject2).append(LightalkBlueTipsBar.a(this.this$0).getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    i += 1;
    ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, i);
    ((SharedPreferences.Editor)localObject1).commit();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onAIOEvent() : commit =====> tipsum = ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("LightalkBlueTipsBar", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.2
 * JD-Core Version:    0.7.0.1
 */