package com.tencent.biz.qqstory.takevideo;

import ved;
import vew;
import vex;
import vfh;
import vhm;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(vew paramvew) {}
  
  public void run()
  {
    vew.a(this.this$0, vfh.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(vew.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_Vex.sendEmptyMessage(1);
      return;
    }
    vew.a(this.this$0, null);
    ved.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.jdField_a_of_type_Vhm.a(0);
    this.this$0.jdField_a_of_type_Vex.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */