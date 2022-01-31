package com.tencent.mobileqq.activity.richmedia;

import ajpx;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import azir;
import aziv;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class NewFlowCameraActivity$48
  implements Runnable
{
  NewFlowCameraActivity$48(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() != 4))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("PTV.NewFlowCameraActivity", 4, "detect:" + this.jdField_a_of_type_Boolean + ",disable:" + this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b());
      }
      if ((!this.jdField_a_of_type_Boolean) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b())) {
        break label411;
      }
      if (this.jdField_a_of_type_Int != 0) {
        break label208;
      }
      this.this$0.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if ((NewFlowCameraActivity.b(this.this$0) != null) && ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a instanceof CameraFilterGLView)))
      {
        CameraFilterGLView localCameraFilterGLView = (CameraFilterGLView)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a;
        if ((NewFlowCameraActivity.e(this.this$0) != 0) || ((localCameraFilterGLView.a.c) && (ajpx.jdField_a_of_type_Int != 2))) {
          this.this$0.a(true, NewFlowCameraActivity.b(this.this$0), NewFlowCameraActivity.e(this.this$0));
        }
      }
    }
    label208:
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_Boolean) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c()))
      {
        this.this$0.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.this$0.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      if ((this.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_Boolean) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c()) || (NewFlowCameraActivity.a(this.this$0)) || (this.this$0.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        break;
      }
      if ((this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!this.this$0.jdField_a_of_type_JavaLangString.equalsIgnoreCase(GestureFilterManager.sGestureType)))
      {
        this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = aziv.a(this.this$0, GestureFilterManager.sGestureType);
        this.this$0.jdField_a_of_type_JavaLangString = GestureFilterManager.sGestureType;
      }
      this.this$0.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.this$0.jdField_d_of_type_AndroidWidgetTextView.setText(GestureFilterManager.sGestureTips);
      this.this$0.jdField_d_of_type_AndroidViewView.setVisibility(0);
      break;
      if ((this.jdField_a_of_type_Int == 0) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b()))
      {
        this.this$0.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.this$0.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
    } while ((this.jdField_a_of_type_Int != 1) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c()) || (NewFlowCameraActivity.a(this.this$0)) || (this.this$0.jdField_a_of_type_AndroidViewView.getVisibility() == 0));
    label411:
    if ((this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!this.this$0.jdField_a_of_type_JavaLangString.equalsIgnoreCase(GestureFilterManager.sGestureType)))
    {
      this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = aziv.a(this.this$0, GestureFilterManager.sGestureType);
      this.this$0.jdField_a_of_type_JavaLangString = GestureFilterManager.sGestureType;
    }
    this.this$0.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.this$0.jdField_d_of_type_AndroidWidgetTextView.setText(GestureFilterManager.sGestureTips);
    this.this$0.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.48
 * JD-Core Version:    0.7.0.1
 */