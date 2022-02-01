package com.tencent.biz.qqstory.takevideo;

import yqp;
import yri;
import yrj;
import yrt;
import yty;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(yri paramyri) {}
  
  public void run()
  {
    yri.a(this.this$0, yrt.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(yri.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_Yrj.sendEmptyMessage(1);
      return;
    }
    yri.a(this.this$0, null);
    yqp.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.jdField_a_of_type_Yty.a(0);
    this.this$0.jdField_a_of_type_Yrj.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */