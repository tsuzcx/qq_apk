package com.tencent.biz.qqstory.storyHome.model;

import java.util.ArrayList;
import uvt;
import uvx;
import ved;

public class FeedManager$2
  implements Runnable
{
  public FeedManager$2(uvx paramuvx) {}
  
  public void run()
  {
    if (uvx.a(this.this$0) == 0L)
    {
      ved.d("Q.qqstory.home.position", "cache in use");
      return;
    }
    this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.this$0.jdField_a_of_type_Uvt != null) {
      this.this$0.jdField_a_of_type_Uvt.a();
    }
    ved.d("Q.qqstory.home.position", "release cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.2
 * JD-Core Version:    0.7.0.1
 */