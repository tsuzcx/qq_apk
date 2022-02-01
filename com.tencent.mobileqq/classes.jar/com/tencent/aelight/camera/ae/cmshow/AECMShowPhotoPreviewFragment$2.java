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
  private int jdField_a_of_type_Int = 0;
  
  AECMShowPhotoPreviewFragment$2(AECMShowPhotoPreviewFragment paramAECMShowPhotoPreviewFragment) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_Int += 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onGlobalLayout] called, invokeCount=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    AEQLog.a("AECMShowPhotoPreviewFragment", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int >= 2)
    {
      localObject = AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        if (Build.VERSION.SDK_INT >= 16) {
          ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
        } else {
          ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
        }
      }
      if (AECMShowPhotoPreviewFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment)) {
        return;
      }
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment, true);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment;
      localObject = AECMShowPhotoPreviewFragment.a((AECMShowPhotoPreviewFragment)localObject, AECMShowPhotoPreviewFragment.a((AECMShowPhotoPreviewFragment)localObject), AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment));
      if ((localObject != null) && (((DynamicTextItem.Pair)localObject).a != null) && (((Boolean)((DynamicTextItem.Pair)localObject).a).booleanValue()))
      {
        AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment, (List)((DynamicTextItem.Pair)localObject).b);
        return;
      }
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment).setEnabled(true);
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment).setText(2064515083);
      AECMShowPhotoPreviewFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment).setVisibility(0);
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowPhotoPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */