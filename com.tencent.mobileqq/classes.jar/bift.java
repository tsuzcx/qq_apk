import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;

public class bift
  extends bifz
{
  private StoryGuideLineView jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
  private boolean jdField_a_of_type_Boolean;
  
  public bift(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  private boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView != null) {
        return true;
      }
      this.jdField_a_of_type_Bigb.a().d();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView = ((StoryGuideLineView)a(2131305599));
      Object localObject1 = "";
      Object localObject2 = awkv.a().a("CMD_GET_CURRENT_NICK_NAME", null);
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getString("VALUE_GET_CURRENT_NICK_NAME");
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setUserName((String)localObject1);
      localObject1 = "";
      localObject2 = awkv.a().a("CMD_GET_CURRENT_USER_HEAD", null);
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getString("VALUE_GET_CURRENT_USER_HEAD");
      }
      try
      {
        localObject1 = SafeBitmapFactory.decodeFile((String)localObject1);
        localObject2 = bacm.c((Bitmap)localObject1, 50, 50);
        BaseApplicationImpl.sImageCache.put("story_user_avatar", localObject2);
        ((Bitmap)localObject1).recycle();
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setUserHead((Bitmap)localObject2);
        return true;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "user Head Path can't read");
          }
        }
      }
      return false;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "makeSureInitLayout error : " + localException2.getMessage());
      }
    }
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
        localObject = this.jdField_a_of_type_Bigb.a();
        vik localvik = this.jdField_a_of_type_Bigb.a();
        if (localObject != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setLinkerObject((bism)localObject);
        }
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setFollow();
        }
        if (localvik != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView.setStoryTag(localvik);
        }
      }
      if ((this.jdField_a_of_type_Bigb instanceof biyt))
      {
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetStoryGuideLineView;
        if (!((biyt)this.jdField_a_of_type_Bigb).r)
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
          if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof bifu))) {
            break;
          }
          bifu localbifu = (bifu)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, "showLimitView : left : " + localbifu.d + " right : " + localbifu.c + " top : " + localbifu.jdField_a_of_type_Boolean + " bottom : " + localbifu.b);
          }
          if (localbifu.e)
          {
            a(localbifu.d, localbifu.c, localbifu.jdField_a_of_type_Boolean, localbifu.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bift
 * JD-Core Version:    0.7.0.1
 */