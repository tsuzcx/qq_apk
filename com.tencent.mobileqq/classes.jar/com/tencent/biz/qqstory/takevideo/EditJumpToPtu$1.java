package com.tencent.biz.qqstory.takevideo;

import veg;
import vez;
import vfa;
import vfk;
import vhp;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(vez paramvez) {}
  
  public void run()
  {
    vez.a(this.this$0, vfk.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(vez.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_Vfa.sendEmptyMessage(1);
      return;
    }
    vez.a(this.this$0, null);
    veg.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.jdField_a_of_type_Vhp.a(0);
    this.this$0.jdField_a_of_type_Vfa.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */