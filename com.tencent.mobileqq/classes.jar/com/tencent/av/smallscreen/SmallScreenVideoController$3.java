package com.tencent.av.smallscreen;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GInviteTimeOutHelper;

class SmallScreenVideoController$3
  extends GAudioUIObserver
{
  SmallScreenVideoController$3(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  protected void a(long paramLong, int paramInt)
  {
    if (this.b.t != null) {
      this.b.t.f(paramInt);
    }
    GInviteTimeOutHelper.a().b();
    Handler localHandler = this.b.r.a();
    if (localHandler != null) {
      localHandler.postDelayed(new SmallScreenVideoController.3.1(this), 1500L);
    }
  }
  
  protected void g()
  {
    if (this.b.t != null) {
      this.b.t.f(0);
    }
    Handler localHandler = this.b.r.a();
    if (localHandler != null) {
      localHandler.postDelayed(new SmallScreenVideoController.3.2(this, this.b.s.k().aQ, this.b.s.k().aN), 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.3
 * JD-Core Version:    0.7.0.1
 */