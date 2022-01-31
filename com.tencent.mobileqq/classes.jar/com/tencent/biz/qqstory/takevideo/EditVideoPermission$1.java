package com.tencent.biz.qqstory.takevideo;

import wxe;
import xan;
import xav;

public class EditVideoPermission$1
  implements Runnable
{
  public EditVideoPermission$1(xav paramxav) {}
  
  public void run()
  {
    if (xav.a(this.this$0))
    {
      wxe.b("Q.qqstory.publish.edit.EditVideoPermission", "PermissionSettingActivity launch failed, change state to IDLE");
      this.this$0.a.a(0);
      xav.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPermission.1
 * JD-Core Version:    0.7.0.1
 */