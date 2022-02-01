package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;

class SmallScreenService$3
  implements Runnable
{
  SmallScreenService$3(SmallScreenService paramSmallScreenService) {}
  
  public void run()
  {
    Object localObject = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = SharedPreUtils.B(((VideoAppInterface)localObject).getApp()).edit();
      if (this.this$0.v.g()) {
        ((SharedPreferences.Editor)localObject).putInt("small_window_position_land", this.this$0.v.k().bB);
      }
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService.3
 * JD-Core Version:    0.7.0.1
 */