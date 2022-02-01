package com.tencent.biz.qqstory.takevideo;

import ykq;
import ylh;
import yli;
import yls;
import ynw;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(ylh paramylh) {}
  
  public void run()
  {
    ylh.a(this.this$0, yls.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(ylh.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_Yli.sendEmptyMessage(1);
      return;
    }
    ylh.a(this.this$0, null);
    ykq.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.jdField_a_of_type_Ynw.a(0);
    this.this$0.jdField_a_of_type_Yli.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */