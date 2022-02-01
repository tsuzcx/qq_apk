package com.tencent.avgame.gameroom.seat;

import android.os.Handler.Callback;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.image.ApngImage;
import com.tencent.qphone.base.util.QLog;

class PkSeatView$4
  implements Handler.Callback
{
  PkSeatView$4(PkSeatView paramPkSeatView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      PkSeatView.b(this.a).c();
      PkSeatView.a(this.a).c();
      PkSeatView.b(this.a).setVisibility(8);
      PkSeatView.c(this.a).setVisibility(8);
      PkSeatView.b(this.a).d();
      PkSeatView.a(this.a).d();
      QLog.d("PkSeatView", 1, "STOP_CHEER_MSG to resetToLoadingView");
      PkSeatView.b(this.a).a(this.a.a, false);
      return true;
    }
    ApngImage.pauseAll();
    PkSeatView.a(this.a).setImageBitmap(AVGameUtil.a("avgame_pk_logo_static@2x.png"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkSeatView.4
 * JD-Core Version:    0.7.0.1
 */