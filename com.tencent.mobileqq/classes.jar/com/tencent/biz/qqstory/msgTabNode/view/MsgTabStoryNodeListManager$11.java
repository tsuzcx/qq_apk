package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import uwn;

public class MsgTabStoryNodeListManager$11
  implements Runnable
{
  public MsgTabStoryNodeListManager$11(uwn paramuwn) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Int == 0)
    {
      if (uwn.a(this.this$0)) {
        this.this$0.jdField_a_of_type_JavaLangRunnable = null;
      }
      return;
    }
    ThreadManager.getUIHandler().post(this.this$0.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.11
 * JD-Core Version:    0.7.0.1
 */