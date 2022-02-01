package com.tencent.aelight.camera.ae;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.richmedia.Size;

class AEPituCameraUnit$47
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int = 0;
  
  AEPituCameraUnit$47(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    if (i > 1)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b.getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        if (Build.VERSION.SDK_INT >= 16) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
        } else {
          ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
        }
      }
    }
    AEPreviewSizeUtil.a(new Size(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b.getMeasuredWidth(), this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b.getMeasuredHeight()));
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mMaxPreviewSize set: ");
    localStringBuilder.append(AEPreviewSizeUtil.a());
    AEQLog.b((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.47
 * JD-Core Version:    0.7.0.1
 */