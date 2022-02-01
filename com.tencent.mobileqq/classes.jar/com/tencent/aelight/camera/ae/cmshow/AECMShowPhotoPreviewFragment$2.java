package com.tencent.aelight.camera.ae.cmshow;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.Pair;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.List;

class AECMShowPhotoPreviewFragment$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int b = 0;
  
  AECMShowPhotoPreviewFragment$2(AECMShowPhotoPreviewFragment paramAECMShowPhotoPreviewFragment) {}
  
  public void onGlobalLayout()
  {
    this.b += 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onGlobalLayout] called, invokeCount=");
    ((StringBuilder)localObject).append(this.b);
    AEQLog.a("AECMShowPhotoPreviewFragment", ((StringBuilder)localObject).toString());
    if (this.b >= 2)
    {
      localObject = AECMShowPhotoPreviewFragment.c(this.a).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        if (Build.VERSION.SDK_INT >= 16) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
        } else {
          ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
        }
      }
      if (AECMShowPhotoPreviewFragment.d(this.a)) {
        return;
      }
      AECMShowPhotoPreviewFragment.a(this.a, true);
      localObject = this.a;
      localObject = AECMShowPhotoPreviewFragment.a((AECMShowPhotoPreviewFragment)localObject, AECMShowPhotoPreviewFragment.e((AECMShowPhotoPreviewFragment)localObject), AECMShowPhotoPreviewFragment.f(this.a));
      if ((localObject != null) && (((DynamicTextItem.Pair)localObject).a != null) && (((Boolean)((DynamicTextItem.Pair)localObject).a).booleanValue()))
      {
        AECMShowPhotoPreviewFragment.a(this.a, (List)((DynamicTextItem.Pair)localObject).b);
        return;
      }
      AECMShowPhotoPreviewFragment.g(this.a).setEnabled(true);
      AECMShowPhotoPreviewFragment.g(this.a).setText(2064187408);
      AECMShowPhotoPreviewFragment.h(this.a).setVisibility(0);
      AECMShowPhotoPreviewFragment.i(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowPhotoPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */