package com.tencent.avgame.gameroom.seat;

import android.os.Handler.Callback;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.image.ApngImage;
import com.tencent.qphone.base.util.QLog;

class PkSeatView$4
  implements Handler.Callback
{
  PkSeatView$4(PkSeatView paramPkSeatView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      ApngImage.pauseAll();
      PkSeatView.a(this.a).setImageBitmap(AVGameUtils.a("avgame_pk_logo_static@2x.png"));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkSeatView.4
 * JD-Core Version:    0.7.0.1
 */