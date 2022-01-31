package com.tencent.biz.qqstory.takevideo;

import urk;
import usd;
import use;
import uso;
import uut;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(usd paramusd) {}
  
  public void run()
  {
    usd.a(this.this$0, uso.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(usd.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_Use.sendEmptyMessage(1);
      return;
    }
    usd.a(this.this$0, null);
    urk.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.jdField_a_of_type_Uut.a(0);
    this.this$0.jdField_a_of_type_Use.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */