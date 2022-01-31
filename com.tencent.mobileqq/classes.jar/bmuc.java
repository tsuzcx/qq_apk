import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.ArrayList;

public class bmuc
  implements bmst
{
  private bmuc(DoodleLayout paramDoodleLayout) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.a.a().c(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoodleLayout", 2, "onEditTextOffsetChange centerX:" + paramInt1 + " centerY:" + paramInt2);
    }
    this.a.a().b(paramInt1, paramInt2);
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    bmqw localbmqw = this.a.a();
    if (paramBoolean1) {
      if ((paramDynamicTextItem == null) || (paramDynamicTextItem.b()) || ((paramDynamicTextItem.a(0)) && (paramDynamicTextItem.c() == 0) && (!paramBoolean2)))
      {
        localbmqw.a(paramDynamicTextItem);
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
      if (paramInt != 0)
      {
        localbmqw.g();
        DoodleLayout.d(this.a.b);
      }
      DoodleLayout.a(this.a, null);
      if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView.b(true);
      }
      this.a.f();
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "raymondguo count " + localbmqw.b() + ", items:" + localbmqw.jdField_a_of_type_JavaUtilArrayList.size());
      }
      return;
      localbmqw.b(paramDynamicTextItem);
      paramInt = 1;
      continue;
      if (paramInt == 0)
      {
        localbmqw.e();
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
    bmqw localbmqw = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DoodleLayout", 2, "onSoftKeyboardStateChange show:" + paramBoolean);
    }
    if (paramBoolean)
    {
      localbmqw.a(true);
      if (DoodleLayout.a(this.a) != null)
      {
        DoodleLayout.a(this.a).a();
        DoodleLayout.a(this.a, null);
      }
      return;
    }
    DoodleLayout.a(this.a, null);
    localbmqw.a(false);
    if (this.a.d == 3)
    {
      this.a.b(0);
      this.a.c(0);
    }
    this.a.jdField_a_of_type_Bmub.q();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.a.d == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoodleLayout", 2, "onPanelChanged old:" + paramInt1 + " new:" + paramInt2);
      }
      this.a.a(3, new Integer(paramInt2));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView != null) && (!paramBoolean)) {
      DoodleLayout.b(this.a);
    }
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
      this.a.setTrackerState(this.a.a().jdField_a_of_type_Bmqz, 0);
      return;
      DoodleLayout.a(this.a, new bmud(this, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuc
 * JD-Core Version:    0.7.0.1
 */