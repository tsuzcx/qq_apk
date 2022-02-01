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
  
  private boolean c()
  {
    try
    {
      if (this.a != null) {
        return true;
      }
      this.t.N().l();
      this.a = ((StoryGuideLineView)d(2131439874));
      a(this.a);
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
    if (!c()) {
      return;
    }
    if (paramBoolean4)
    {
      if ((this.t instanceof QzEditVideoPartManager)) {
        this.a.a(true ^ ((QzEditVideoPartManager)this.t).A);
      } else {
        this.a.a(true);
      }
    }
    else {
      this.a.a();
    }
    if (paramBoolean2) {
      this.a.b();
    } else {
      this.a.c();
    }
    if (paramBoolean1)
    {
      this.a.d();
      return;
    }
    this.a.e();
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
        this.a.f();
      }
    }
    return super.a(paramMessage);
  }
  
  public void f()
  {
    super.f();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoLimitRegion
 * JD-Core Version:    0.7.0.1
 */