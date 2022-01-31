package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.base.ErrorMessage;
import vcs;
import vhn;
import vhu;

public class PlayModeUtils$6$1
  implements Runnable
{
  public PlayModeUtils$6$1(vhn paramvhn, vcs paramvcs, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Vcs != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()))
    {
      this.this$0.a.a(this.jdField_a_of_type_Vcs.b);
      return;
    }
    this.this$0.a.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.6.1
 * JD-Core Version:    0.7.0.1
 */