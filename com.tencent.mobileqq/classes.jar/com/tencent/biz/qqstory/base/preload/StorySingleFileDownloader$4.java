package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;
import uja;
import ujq;

public class StorySingleFileDownloader$4
  implements Runnable
{
  public StorySingleFileDownloader$4(ujq paramujq, uja paramuja, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!ujq.a(this.this$0).containsKey(this.jdField_a_of_type_Uja.a)) {
      return;
    }
    ujq.a(this.this$0).remove(this.jdField_a_of_type_Uja.a);
    ujq.a(this.this$0, this.jdField_a_of_type_Uja, this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */