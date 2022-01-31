package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import wou;
import woy;
import wxe;

public class FeedManager$2
  implements Runnable
{
  public FeedManager$2(woy paramwoy) {}
  
  public void run()
  {
    if (woy.a(this.this$0) == 0L)
    {
      wxe.d("Q.qqstory.home.position", "cache in use");
      return;
    }
    this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.this$0.jdField_a_of_type_Wou != null) {
      this.this$0.jdField_a_of_type_Wou.a();
    }
    wxe.d("Q.qqstory.home.position", "release cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.2
 * JD-Core Version:    0.7.0.1
 */