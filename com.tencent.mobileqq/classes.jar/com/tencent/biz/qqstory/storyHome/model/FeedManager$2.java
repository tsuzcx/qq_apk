package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import ycg;
import yck;
import ykq;

public class FeedManager$2
  implements Runnable
{
  public FeedManager$2(yck paramyck) {}
  
  public void run()
  {
    if (yck.a(this.this$0) == 0L)
    {
      ykq.d("Q.qqstory.home.position", "cache in use");
      return;
    }
    this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.this$0.jdField_a_of_type_Ycg != null) {
      this.this$0.jdField_a_of_type_Ycg.a();
    }
    ykq.d("Q.qqstory.home.position", "release cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.2
 * JD-Core Version:    0.7.0.1
 */