package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import uja;
import uje;
import urk;

public class FeedManager$2
  implements Runnable
{
  public FeedManager$2(uje paramuje) {}
  
  public void run()
  {
    if (uje.a(this.this$0) == 0L)
    {
      urk.d("Q.qqstory.home.position", "cache in use");
      return;
    }
    this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.this$0.jdField_a_of_type_Uja != null) {
      this.this$0.jdField_a_of_type_Uja.a();
    }
    urk.d("Q.qqstory.home.position", "release cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.2
 * JD-Core Version:    0.7.0.1
 */