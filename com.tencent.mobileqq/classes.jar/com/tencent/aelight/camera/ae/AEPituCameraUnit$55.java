package com.tencent.aelight.camera.ae;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.richmedia.Size;

class AEPituCameraUnit$55
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int b = 0;
  
  AEPituCameraUnit$55(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onGlobalLayout()
  {
    int i = this.b + 1;
    this.b = i;
    if (i > 1)
    {
      localObject = this.a.af.getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        if (Build.VERSION.SDK_INT >= 16) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
        } else {
          ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
        }
      }
    }
    AEPreviewSizeUtil.a(new Size(this.a.af.getMeasuredWidth(), this.a.af.getMeasuredHeight()));
    Object localObject = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mMaxPreviewSize set: ");
    localStringBuilder.append(AEPreviewSizeUtil.a());
    AEQLog.b((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.55
 * JD-Core Version:    0.7.0.1
 */