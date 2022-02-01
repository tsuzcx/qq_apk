import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.ArrayList;

public class bnjm
  implements bnig
{
  private bnjm(DoodleLayout paramDoodleLayout) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.a.a().b(paramInt);
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
    bngn localbngn = this.a.a();
    if (paramBoolean1) {
      if ((paramDynamicTextItem == null) || (paramDynamicTextItem.b()) || ((paramDynamicTextItem.a(0)) && (paramDynamicTextItem.c() == 0) && (!paramBoolean2)))
      {
        localbngn.a(paramDynamicTextItem);
        if (this.a.a != null) {
          this.a.a.a.a(null);
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
        DoodleLayout.a(this.a).b(false);
      }
      if (paramInt != 0)
      {
        localbngn.g();
        DoodleLayout.c(this.a.b);
      }
      DoodleLayout.a(this.a, null);
      if (this.a.a != null) {
        this.a.a.a(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "raymondguo count " + localbngn.b() + ", items:" + localbngn.jdField_a_of_type_JavaUtilArrayList.size());
      }
      return;
      localbngn.b(paramDynamicTextItem);
      paramInt = 1;
      continue;
      if (paramInt == 0)
      {
        localbngn.e();
        if (this.a.a != null) {
          this.a.a.a.a(null);
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
    bngn localbngn = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("DoodleLayout", 2, "onSoftKeyboardStateChange show:" + paramBoolean);
    }
    if (paramBoolean)
    {
      localbngn.a(true);
      if (DoodleLayout.a(this.a) != null)
      {
        DoodleLayout.a(this.a).a();
        DoodleLayout.a(this.a, null);
      }
    }
    do
    {
      return;
      DoodleLayout.a(this.a, null);
      localbngn.a(false);
    } while (this.a.d != 3);
    this.a.a(0);
    this.a.b(0);
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
    if ((this.a.a != null) && (!paramBoolean)) {
      DoodleLayout.b(this.a);
    }
    if ((!paramBoolean) || (this.a.a().c()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoodleLayout", 2, "onDialogLayout needAnim:" + paramBoolean + " y:" + this.a.a().o);
      }
      if (DoodleLayout.a(this.a) != null) {
        DoodleLayout.a(this.a).b(true);
      }
      this.a.a().b(paramBoolean);
    }
    for (;;)
    {
      this.a.setTrackerState(this.a.a().jdField_a_of_type_Bngq, 0);
      return;
      DoodleLayout.a(this.a, new bnjn(this, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjm
 * JD-Core Version:    0.7.0.1
 */