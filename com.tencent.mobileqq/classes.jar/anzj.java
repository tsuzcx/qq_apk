import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.EditTextDialogEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;

public class anzj
  implements EditTextDialog.EditTextDialogEventListener
{
  private anzj(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    this.a.q();
  }
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(3, paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoodleLayout", 2, "onEditTextOffsetChange centerX:" + paramInt1 + " centerY:" + paramInt2);
    }
    this.a.a().b(paramInt1, paramInt2);
    this.a.p();
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, boolean paramBoolean, int paramInt)
  {
    TextLayer localTextLayer = this.a.a();
    if (paramBoolean) {
      if ((paramDynamicTextItem == null) || (paramDynamicTextItem.b()) || ((paramDynamicTextItem.a(0)) && (paramDynamicTextItem.c() == 0)))
      {
        localTextLayer.a(paramDynamicTextItem);
        if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(null);
        }
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (this.a.a() != null) {
        this.a.a().i();
      }
      if (paramDynamicTextItem != null) {
        paramDynamicTextItem.b();
      }
      if ((DoodleLayout.a(this.a) != null) && (paramInt != 0)) {
        DoodleLayout.a(this.a).c(false);
      }
      if (paramInt != 0) {
        localTextLayer.g();
      }
      DoodleLayout.a(this.a, null);
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
      return;
      localTextLayer.b(paramDynamicTextItem);
      paramInt = 1;
      continue;
      if (paramInt == 0)
      {
        localTextLayer.d();
        if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
          this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.a.a(null);
        }
        paramInt = 0;
      }
      else
      {
        paramInt = 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextLayer localTextLayer = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DoodleLayout", 2, "onSoftKeyboardStateChange show:" + paramBoolean);
    }
    if (paramBoolean)
    {
      localTextLayer.a(true);
      if (DoodleLayout.a(this.a) != null)
      {
        DoodleLayout.a(this.a).a();
        DoodleLayout.a(this.a, null);
      }
      return;
    }
    DoodleLayout.a(this.a, null);
    localTextLayer.a(false);
    if (this.a.b == 3)
    {
      this.a.b(0);
      this.a.c(0);
    }
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.m();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.a.b == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoodleLayout", 2, "onPanelChanged old:" + paramInt1 + " new:" + paramInt2);
      }
      this.a.a(3, new Integer(paramInt2));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.a.a().c()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoodleLayout", 2, "onDialogLayout needAnim:" + paramBoolean + " y:" + this.a.a().o);
      }
      if (DoodleLayout.a(this.a) != null) {
        DoodleLayout.a(this.a).c(true);
      }
      this.a.a().b(paramBoolean);
    }
    for (;;)
    {
      this.a.setTrackerState(this.a.a().a, 0);
      return;
      DoodleLayout.a(this.a, new anzk(this, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anzj
 * JD-Core Version:    0.7.0.1
 */