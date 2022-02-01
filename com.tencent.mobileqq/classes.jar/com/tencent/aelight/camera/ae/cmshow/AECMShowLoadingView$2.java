package com.tencent.aelight.camera.ae.cmshow;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

class AECMShowLoadingView$2
  implements PAGView.PAGViewListener
{
  AECMShowLoadingView$2(AECMShowLoadingView paramAECMShowLoadingView) {}
  
  private String a()
  {
    if (!TextUtils.isEmpty(AECMShowLoadingView.a(this.a))) {
      return AECMShowLoadingView.a(this.a);
    }
    return this.a.getContext().getString(2064515310);
  }
  
  public void onAnimationCancel(PAGView paramPAGView)
  {
    if (AECMShowLoadingView.a(this.a) != null) {
      AECMShowLoadingView.a(this.a).setText(a());
    }
  }
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    if (AECMShowLoadingView.a(this.a) != null) {
      AECMShowLoadingView.a(this.a).setText(a());
    }
  }
  
  public void onAnimationRepeat(PAGView paramPAGView) {}
  
  public void onAnimationStart(PAGView paramPAGView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowLoadingView.2
 * JD-Core Version:    0.7.0.1
 */