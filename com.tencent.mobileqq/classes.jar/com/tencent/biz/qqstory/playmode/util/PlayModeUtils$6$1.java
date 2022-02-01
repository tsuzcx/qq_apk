package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.base.ErrorMessage;
import xei;
import xjd;
import xjk;

public class PlayModeUtils$6$1
  implements Runnable
{
  public PlayModeUtils$6$1(xjd paramxjd, xei paramxei, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Xei != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
    {
      this.this$0.a.a(this.jdField_a_of_type_Xei.b);
      return;
    }
    this.this$0.a.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.6.1
 * JD-Core Version:    0.7.0.1
 */