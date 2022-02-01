import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoLimitRegion.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;

public class bpeh
  extends bpen
{
  private StoryGuideLineView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
  private boolean jdField_a_of_type_Boolean;
  
  public bpeh(@NonNull bpep parambpep)
  {
    super(parambpep);
  }
  
  public static void a(StoryGuideLineView paramStoryGuideLineView)
  {
    ThreadManager.excute(new EditVideoLimitRegion.1(paramStoryGuideLineView), 16, null, true);
  }
  
  private boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView != null) {
        return true;
      }
      this.jdField_a_of_type_Bpep.a().d();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView = ((StoryGuideLineView)a(2131372199));
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView);
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "makeSureInitLayout error : " + localException.getMessage());
      }
    }
    return false;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!b()) {
      return;
    }
    if ((!paramBoolean3) || (paramBoolean4))
    {
      Object localObject;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a())
      {
        localObject = this.jdField_a_of_type_Bpep.a();
        zhp localzhp = this.jdField_a_of_type_Bpep.a();
        if (localObject != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setLinkerObject((bpqt)localObject);
        }
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setFollow();
        }
        if (localzhp != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setStoryTag(localzhp);
        }
      }
      if ((this.jdField_a_of_type_Bpep instanceof bpwv))
      {
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
        if (!((bpwv)this.jdField_a_of_type_Bpep).r)
        {
          paramBoolean3 = true;
          ((StoryGuideLineView)localObject).a(paramBoolean3);
          label124:
          if (!paramBoolean2) {
            break label173;
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.f();
        }
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        break label183;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.h();
      return;
      paramBoolean3 = false;
      break;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a(true);
      break label124;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.e();
      break label124;
      label173:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.g();
    }
    label183:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.i();
  }
  
  protected boolean a(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      bool = super.a(paramMessage);
      do
      {
        do
        {
          return bool;
          if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof bpei))) {
            break;
          }
          bpei localbpei = (bpei)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showLimitView : left : " + localbpei.d + " right : " + localbpei.c + " top : " + localbpei.jdField_a_of_type_Boolean + " bottom : " + localbpei.b);
          }
          if (localbpei.e)
          {
            a(localbpei.d, localbpei.c, localbpei.jdField_a_of_type_Boolean, localbpei.b);
            break;
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.j();
          break;
        } while (!b());
        if (paramMessage.arg1 == 1)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.c();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showLink");
          break;
        }
        if (paramMessage.arg1 != 0) {
          break;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.d();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "hideLink");
        break;
      } while (!b());
      if (paramMessage.arg1 == 1)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showStoryTag");
        }
      }
      else if (paramMessage.arg1 == 3)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.b();
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "hideStoryTag");
          continue;
          if (paramMessage.arg1 == 1)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.c();
            this.jdField_a_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showFollowCapture");
            }
          }
          else if (paramMessage.arg1 == 0)
          {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.d();
            this.jdField_a_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "hideFollowCapture");
            }
          }
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpeh
 * JD-Core Version:    0.7.0.1
 */