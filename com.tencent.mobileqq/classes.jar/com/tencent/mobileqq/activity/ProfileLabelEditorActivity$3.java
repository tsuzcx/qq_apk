package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ProfileLabelEditorActivity$3
  implements Runnable
{
  ProfileLabelEditorActivity$3(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = ProfileLabelEditorActivity.a((ProfileLabelEditorActivity)localObject, ((ProfileLabelEditorActivity)localObject).app.getCurrentAccountUin());
    ThreadManager.getUIHandler().post(new ProfileLabelEditorActivity.3.1(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.3
 * JD-Core Version:    0.7.0.1
 */