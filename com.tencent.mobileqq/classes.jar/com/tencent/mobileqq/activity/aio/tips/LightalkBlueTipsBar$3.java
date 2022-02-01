package com.tencent.mobileqq.activity.aio.tips;

import ails;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

public class LightalkBlueTipsBar$3
  implements Runnable
{
  public LightalkBlueTipsBar$3(ails paramails) {}
  
  public void run()
  {
    Object localObject = ails.a(this.this$0).getPreferences();
    if (((SharedPreferences)localObject).getInt("LT_tip_show_times" + ails.a(this.this$0).getCurrentAccountUin(), 5) != 5)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("LT_tip_show_times" + ails.a(this.this$0).getCurrentAccountUin(), 5);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar.3
 * JD-Core Version:    0.7.0.1
 */