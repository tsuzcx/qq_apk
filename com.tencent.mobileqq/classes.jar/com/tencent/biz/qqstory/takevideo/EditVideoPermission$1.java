package com.tencent.biz.qqstory.takevideo;

import ykq;
import ynw;
import yoe;

public class EditVideoPermission$1
  implements Runnable
{
  public EditVideoPermission$1(yoe paramyoe) {}
  
  public void run()
  {
    if (yoe.a(this.this$0))
    {
      ykq.b("Q.qqstory.publish.edit.EditVideoPermission", "PermissionSettingActivity launch failed, change state to IDLE");
      this.this$0.a.a(0);
      yoe.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPermission.1
 * JD-Core Version:    0.7.0.1
 */