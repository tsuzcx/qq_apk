package com.tencent.biz.qqstory.takevideo;

import yuk;
import yvd;
import yve;
import yvo;
import yxt;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(yvd paramyvd) {}
  
  public void run()
  {
    yvd.a(this.this$0, yvo.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(yvd.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_Yve.sendEmptyMessage(1);
      return;
    }
    yvd.a(this.this$0, null);
    yuk.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.jdField_a_of_type_Yxt.a(0);
    this.this$0.jdField_a_of_type_Yve.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */