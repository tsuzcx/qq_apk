package com.tencent.gdtad.api.motivevideo;

import abnz;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class GdtMVCellingStyleController$2
  implements Runnable
{
  public GdtMVCellingStyleController$2(abnz paramabnz, double paramDouble) {}
  
  public void run()
  {
    int i = abnz.a(this.this$0).getWidth();
    QLog.i("GdtMVCellingStyleController", 1, "setVideoHeightByRatio " + i);
    if (abnz.a(this.this$0).getWidth() > 0) {
      this.this$0.d((int)(i * this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMVCellingStyleController.2
 * JD-Core Version:    0.7.0.1
 */