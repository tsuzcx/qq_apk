package com.tencent.av.ui.effect.toolbar.oldversion;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.ui.ControlUIObserver;

class FaceToolbar$1
  extends ControlUIObserver
{
  FaceToolbar$1(FaceToolbar paramFaceToolbar) {}
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (!PtuResChecker.b(paramInt)) {
      return;
    }
    VideoAppInterface localVideoAppInterface = FaceToolbar.access$000(this.a);
    if (localVideoAppInterface == null) {
      return;
    }
    localVideoAppInterface.a().postDelayed(new FaceToolbar.1.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.FaceToolbar.1
 * JD-Core Version:    0.7.0.1
 */