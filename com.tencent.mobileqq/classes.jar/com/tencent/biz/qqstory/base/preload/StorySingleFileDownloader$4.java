package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;
import unj;
import unz;

public class StorySingleFileDownloader$4
  implements Runnable
{
  public StorySingleFileDownloader$4(unz paramunz, unj paramunj, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!unz.a(this.this$0).containsKey(this.jdField_a_of_type_Unj.a)) {
      return;
    }
    unz.a(this.this$0).remove(this.jdField_a_of_type_Unj.a);
    unz.a(this.this$0, this.jdField_a_of_type_Unj, this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */