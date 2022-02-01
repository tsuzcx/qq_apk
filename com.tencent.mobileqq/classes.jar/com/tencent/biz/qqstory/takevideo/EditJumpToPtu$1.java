package com.tencent.biz.qqstory.takevideo;

import xvv;
import xwo;
import xwp;
import xwz;
import xzd;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(xwo paramxwo) {}
  
  public void run()
  {
    xwo.a(this.this$0, xwz.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(xwo.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_Xwp.sendEmptyMessage(1);
      return;
    }
    xwo.a(this.this$0, null);
    xvv.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.jdField_a_of_type_Xzd.a(0);
    this.this$0.jdField_a_of_type_Xwp.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */