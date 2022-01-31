package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import baig;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import kvq;

class SmallScreenService$3
  implements Runnable
{
  SmallScreenService$3(SmallScreenService paramSmallScreenService) {}
  
  public void run()
  {
    Object localObject = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = baig.a(((VideoAppInterface)localObject).getApp()).edit();
      if (this.this$0.a.a()) {
        ((SharedPreferences.Editor)localObject).putInt("small_window_position_land", this.this$0.a.a().I);
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService.3
 * JD-Core Version:    0.7.0.1
 */