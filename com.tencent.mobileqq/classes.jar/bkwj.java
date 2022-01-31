import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr.DragViewIcon;

public class bkwj
  extends AnimatorListenerAdapter
{
  public bkwj(DragAnimationMgr paramDragAnimationMgr, DragAnimationMgr.DragViewIcon paramDragViewIcon) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.b = false;
    DragAnimationMgr.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr);
    if (DragAnimationMgr.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr) != null) {
      DragAnimationMgr.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr).b();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr$DragViewIcon.b = false;
    DragAnimationMgr.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr);
    if (DragAnimationMgr.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr) != null) {
      DragAnimationMgr.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkwj
 * JD-Core Version:    0.7.0.1
 */