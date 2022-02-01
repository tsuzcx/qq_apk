package com.tencent.av.smallscreen;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoController$MyVideoObserver$2
  implements Runnable
{
  SmallScreenVideoController$MyVideoObserver$2(SmallScreenVideoController.MyVideoObserver paramMyVideoObserver, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = SharedPreUtils.B(this.c.b.c);
    if (!((SharedPreferences)localObject).getBoolean("kick_out_self", false)) {
      if ((this.c.b.g != 1) && (this.c.b.g != 2))
      {
        if ((this.c.b.g != 3) && (this.c.b.g != 4))
        {
          if ((this.c.b.g == 0) && (this.c.b.n) && ((this.c.b.h == 1) || (this.c.b.h == 2)))
          {
            this.c.b.o = this.b;
            this.c.b.d();
          }
        }
        else
        {
          localObject = this.c.b.s;
          String str = null;
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = this.c.b.s.k();
          }
          if (localObject == null) {
            localObject = str;
          } else {
            localObject = String.valueOf(((SessionInfo)localObject).aN);
          }
          if (localObject != null)
          {
            str = this.a;
            if ((str != null) && (((String)localObject).equals(str)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SmallScreenVideoController", 2, "[random room owner] onDestroyUI finish");
              }
              this.c.b.o = this.b;
              this.c.b.d();
            }
          }
        }
      }
      else
      {
        if ((this.c.b.k != null) && (this.a != null) && (this.c.b.k.equals(this.a)))
        {
          this.c.b.o = this.b;
          this.c.b.d();
        }
        if (this.c.b.u != null)
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putInt("video_position", this.c.b.u.ac());
          ((SharedPreferences.Editor)localObject).commit();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.2
 * JD-Core Version:    0.7.0.1
 */