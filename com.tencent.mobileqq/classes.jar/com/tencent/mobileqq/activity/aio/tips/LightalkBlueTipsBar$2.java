package com.tencent.mobileqq.activity.aio.tips;

import aenl;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class LightalkBlueTipsBar$2
  implements Runnable
{
  public LightalkBlueTipsBar$2(aenl paramaenl) {}
  
  public void run()
  {
    Object localObject = aenl.a(this.this$0).getPreferences();
    int i = ((SharedPreferences)localObject).getInt("LT_tip_show_times" + aenl.a(this.this$0).getCurrentAccountUin(), 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("LT_tip_show_times" + aenl.a(this.this$0).getCurrentAccountUin(), i + 1);
    ((SharedPreferences.Editor)localObject).commit();
    if (QLog.isColorLevel()) {
      QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : commit =====> tipsum = " + (i + 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.2
 * JD-Core Version:    0.7.0.1
 */