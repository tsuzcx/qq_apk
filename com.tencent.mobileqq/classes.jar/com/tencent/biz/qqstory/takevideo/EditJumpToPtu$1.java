package com.tencent.biz.qqstory.takevideo;

import wxe;
import wxx;
import wxy;
import wyi;
import xan;

public class EditJumpToPtu$1
  implements Runnable
{
  public EditJumpToPtu$1(wxx paramwxx) {}
  
  public void run()
  {
    wxx.a(this.this$0, wyi.a + "qq_pic_Jump_" + System.currentTimeMillis() + ".png");
    if (this.this$0.a(wxx.a(this.this$0)))
    {
      this.this$0.jdField_a_of_type_Wxy.sendEmptyMessage(1);
      return;
    }
    wxx.a(this.this$0, null);
    wxe.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.jdField_a_of_type_Xan.a(0);
    this.this$0.jdField_a_of_type_Wxy.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */