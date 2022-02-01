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
    List localList = ProfileLabelEditorActivity.a(this.this$0, this.this$0.app.getCurrentAccountUin());
    ThreadManager.getUIHandler().post(new ProfileLabelEditorActivity.3.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.3
 * JD-Core Version:    0.7.0.1
 */