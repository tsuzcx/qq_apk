package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;

class EditVideoPermission$1
  implements Runnable
{
  EditVideoPermission$1(EditVideoPermission paramEditVideoPermission) {}
  
  public void run()
  {
    if (EditVideoPermission.a(this.this$0))
    {
      SLog.b("Q.qqstory.publish.edit.EditVideoPermission", "PermissionSettingActivity launch failed, change state to IDLE");
      this.this$0.a.a(0);
      EditVideoPermission.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPermission.1
 * JD-Core Version:    0.7.0.1
 */