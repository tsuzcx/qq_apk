package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import awjy;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import java.util.concurrent.atomic.AtomicInteger;

class NewFlowCameraActivity$49
  implements Runnable
{
  NewFlowCameraActivity$49(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() != 4))
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label85;
      }
      if (this.jdField_a_of_type_Boolean) {
        break label54;
      }
      this.this$0.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label54:
    label85:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.b);
        this.this$0.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.this$0.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
      } while (this.jdField_a_of_type_Int != 1);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.this$0.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
      }
    } while ((this.b) || (NewFlowCameraActivity.a(this.this$0)));
    if ((this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!this.this$0.jdField_a_of_type_JavaLangString.equalsIgnoreCase(GestureFilterManager.sGestureType)))
    {
      this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = awjy.a(this.this$0, GestureFilterManager.sGestureType);
      this.this$0.jdField_a_of_type_JavaLangString = GestureFilterManager.sGestureType;
    }
    this.this$0.jdField_d_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.this$0.jdField_d_of_type_AndroidWidgetTextView.setText(GestureFilterManager.sGestureTips);
    this.this$0.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.this$0.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.49
 * JD-Core Version:    0.7.0.1
 */