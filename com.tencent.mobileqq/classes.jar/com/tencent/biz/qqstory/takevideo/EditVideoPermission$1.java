package com.tencent.biz.qqstory.takevideo;

import ved;
import vhm;
import vhu;

public class EditVideoPermission$1
  implements Runnable
{
  public EditVideoPermission$1(vhu paramvhu) {}
  
  public void run()
  {
    if (vhu.a(this.this$0))
    {
      ved.b("Q.qqstory.publish.edit.EditVideoPermission", "PermissionSettingActivity launch failed, change state to IDLE");
      this.this$0.a.a(0);
      vhu.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPermission.1
 * JD-Core Version:    0.7.0.1
 */