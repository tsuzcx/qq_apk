package com.tencent.aelight.camera.ae.flashshow;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.richmedia.Size;

class AEFlashShowCameraUnit$6
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int b = 0;
  
  AEFlashShowCameraUnit$6(AEFlashShowCameraUnit paramAEFlashShowCameraUnit) {}
  
  public void onGlobalLayout()
  {
    int i = this.b + 1;
    this.b = i;
    if (i > 1)
    {
      localObject = AEFlashShowCameraUnit.h(this.a).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        if (Build.VERSION.SDK_INT >= 16) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
        } else {
          ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
        }
      }
    }
    AEPreviewSizeUtil.a(new Size(AEFlashShowCameraUnit.i(this.a).getMeasuredWidth(), AEFlashShowCameraUnit.j(this.a).getMeasuredHeight()));
    Object localObject = AEFlashShowCameraUnit.k(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mMaxPreviewSize set: ");
    localStringBuilder.append(AEPreviewSizeUtil.a());
    AEQLog.b((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.6
 * JD-Core Version:    0.7.0.1
 */