package com.tencent.biz.qqstory.takevideo;

import yuk;
import yxt;
import yyb;

public class EditVideoPermission$1
  implements Runnable
{
  public EditVideoPermission$1(yyb paramyyb) {}
  
  public void run()
  {
    if (yyb.a(this.this$0))
    {
      yuk.b("Q.qqstory.publish.edit.EditVideoPermission", "PermissionSettingActivity launch failed, change state to IDLE");
      this.this$0.a.a(0);
      yyb.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPermission.1
 * JD-Core Version:    0.7.0.1
 */