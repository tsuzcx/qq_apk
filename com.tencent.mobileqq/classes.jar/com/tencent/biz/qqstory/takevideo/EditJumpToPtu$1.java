package com.tencent.biz.qqstory.takevideo;

import wsv;
import wto;
import wtp;
import wtz;
import wwe;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(wto paramwto) {}
  
  public void run()
  {
    wto.a(this.this$0, wtz.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(wto.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_Wtp.sendEmptyMessage(1);
      return;
    }
    wto.a(this.this$0, null);
    wsv.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.jdField_a_of_type_Wwe.a(0);
    this.this$0.jdField_a_of_type_Wtp.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */