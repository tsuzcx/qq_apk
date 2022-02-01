import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.8.1;

public class bozb
  implements bovy
{
  public bozb(DoodleLayout paramDoodleLayout) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_Bozd != null) {
      this.a.jdField_a_of_type_Bozd.a(1, paramInt);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (DoodleLayout.b(this.a)) {
      return;
    }
    this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a(bovv parambovv)
  {
    boolean bool = false;
    if (DoodleLayout.a(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "onEditFaceItem mIsRecording");
      }
    }
    while (((DoodleLayout.b(this.a)) && (!DoodleLayout.c(this.a))) || (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView == null)) {
      return false;
    }
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.setVisibility(0);
    DoodleLayout.b(this.a);
    if (parambovv.h == 3) {
      this.a.post(new DoodleLayout.8.1(this));
    }
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(parambovv);
    parambovv.k = true;
    SegmentKeeper localSegmentKeeper = parambovv.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper;
    if (!this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a()) {
      bool = true;
    }
    localSegmentKeeper.lockData(bool);
    if ((parambovv.h == 1) || (parambovv.h == 3)) {
      parambovv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView);
    }
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozb
 * JD-Core Version:    0.7.0.1
 */