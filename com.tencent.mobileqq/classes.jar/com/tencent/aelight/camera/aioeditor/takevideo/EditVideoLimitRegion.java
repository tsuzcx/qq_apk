package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class EditVideoLimitRegion
  extends EditVideoPart
{
  private StoryGuideLineView a;
  
  public EditVideoLimitRegion(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static void a(StoryGuideLineView paramStoryGuideLineView)
  {
    ThreadManager.excute(new EditVideoLimitRegion.1(paramStoryGuideLineView), 16, null, true);
  }
  
  private boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView != null) {
        return true;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().g();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView = ((StoryGuideLineView)a(2131372358));
      a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView);
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("makeSureInitLayout error : ");
        localStringBuilder.append(localException.getMessage());
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!b()) {
      return;
    }
    if (paramBoolean4)
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager instanceof QzEditVideoPartManager)) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.a(true ^ ((QzEditVideoPartManager)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager).m);
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.a(true);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.a();
    }
    if (paramBoolean2) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.b();
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.c();
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.d();
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.e();
  }
  
  protected boolean a(Message paramMessage)
  {
    if ((paramMessage.what == 15) && (paramMessage.obj != null) && ((paramMessage.obj instanceof EditVideoLimitRegion.LimitMessage)))
    {
      EditVideoLimitRegion.LimitMessage localLimitMessage = (EditVideoLimitRegion.LimitMessage)paramMessage.obj;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showLimitView : left : ");
        localStringBuilder.append(localLimitMessage.d);
        localStringBuilder.append(" right : ");
        localStringBuilder.append(localLimitMessage.c);
        localStringBuilder.append(" top : ");
        localStringBuilder.append(localLimitMessage.a);
        localStringBuilder.append(" bottom : ");
        localStringBuilder.append(localLimitMessage.b);
        QLog.d("Q.qqstory.publish.edit.StoryDoodle", 2, localStringBuilder.toString());
      }
      if (localLimitMessage.e) {
        a(localLimitMessage.d, localLimitMessage.c, localLimitMessage.a, localLimitMessage.b);
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.f();
      }
    }
    return super.a(paramMessage);
  }
  
  public void d()
  {
    super.d();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoLimitRegion
 * JD-Core Version:    0.7.0.1
 */