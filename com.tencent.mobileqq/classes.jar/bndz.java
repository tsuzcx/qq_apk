import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoLimitRegion.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;

public class bndz
  extends bnec
{
  private StoryGuideLineView a;
  
  public bndz(@NonNull bnee parambnee)
  {
    super(parambnee);
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
      this.jdField_a_of_type_Bnee.a().c();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView = ((StoryGuideLineView)a(2131372279));
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
    if (paramBoolean4) {
      if ((this.jdField_a_of_type_Bnee instanceof bnss))
      {
        StoryGuideLineView localStoryGuideLineView = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
        if (!((bnss)this.jdField_a_of_type_Bnee).q)
        {
          paramBoolean3 = true;
          localStoryGuideLineView.a(paramBoolean3);
          label50:
          if (!paramBoolean2) {
            break label99;
          }
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.b();
        }
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        break label109;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.d();
      return;
      paramBoolean3 = false;
      break;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a(true);
      break label50;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.a();
      break label50;
      label99:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.c();
    }
    label109:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.e();
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof bnea)))
      {
        bnea localbnea = (bnea)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showLimitView : left : " + localbnea.d + " right : " + localbnea.c + " top : " + localbnea.a + " bottom : " + localbnea.b);
        }
        if (localbnea.e) {
          a(localbnea.d, localbnea.c, localbnea.a, localbnea.b);
        } else {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.f();
        }
      }
    }
  }
  
  public void aG_()
  {
    super.aG_();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndz
 * JD-Core Version:    0.7.0.1
 */