package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import yif;
import yij;
import yqp;

public class FeedManager$2
  implements Runnable
{
  public FeedManager$2(yij paramyij) {}
  
  public void run()
  {
    if (yij.a(this.this$0) == 0L)
    {
      yqp.d("Q.qqstory.home.position", "cache in use");
      return;
    }
    this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.this$0.jdField_a_of_type_Yif != null) {
      this.this$0.jdField_a_of_type_Yif.a();
    }
    yqp.d("Q.qqstory.home.position", "release cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.2
 * JD-Core Version:    0.7.0.1
 */