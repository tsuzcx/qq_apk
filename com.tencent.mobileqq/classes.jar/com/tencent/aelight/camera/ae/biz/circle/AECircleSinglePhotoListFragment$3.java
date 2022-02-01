package com.tencent.aelight.camera.ae.biz.circle;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AECircleSinglePhotoListFragment$3
  implements Runnable
{
  AECircleSinglePhotoListFragment$3(AECircleSinglePhotoListFragment paramAECircleSinglePhotoListFragment) {}
  
  public void run()
  {
    View localView = this.this$0.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(AECircleSinglePhotoListFragment.a(this.this$0).a.c);
    if (localView != null) {
      localView = localView.findViewById(2064122496);
    } else {
      localView = null;
    }
    if (localView != null)
    {
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView.a(AECircleSinglePhotoListFragment.a(this.this$0).a.jdField_a_of_type_JavaLangString);
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView.b(AECircleSinglePhotoListFragment.a(this.this$0).a.e);
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView.setWidth(-2);
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView.setHeight(-2);
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView.setFocusable(false);
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView.a(localView, 2, AECircleSinglePhotoListFragment.a(this.this$0).a.d, AECircleSinglePhotoListFragment.a(this.this$0).a.f, AECircleSinglePhotoListFragment.a(this.this$0).a.g);
      AECircleSinglePhotoListFragment.a(this.this$0).a.jdField_a_of_type_Boolean = true;
      ThreadManager.getUIHandler().postDelayed(AECircleSinglePhotoListFragment.a(this.this$0), 4000L);
      return;
    }
    QLog.d("AECircleSinglePhotoList", 2, "showPopupGuideBubbleView, photoCheckBox == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleSinglePhotoListFragment.3
 * JD-Core Version:    0.7.0.1
 */