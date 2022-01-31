package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import java.util.List;
import oqz;

public class VideoArticleModule$1
  implements Runnable
{
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (List localList = oqz.a(this.this$0, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean); this.this$0.a == null; localList = this.jdField_a_of_type_JavaUtilList) {
      return;
    }
    this.this$0.a.post(new VideoArticleModule.1.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.1
 * JD-Core Version:    0.7.0.1
 */