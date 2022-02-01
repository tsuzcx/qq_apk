package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;
import wbk;
import wca;

public class StorySingleFileDownloader$4
  implements Runnable
{
  public StorySingleFileDownloader$4(wca paramwca, wbk paramwbk, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!wca.a(this.this$0).containsKey(this.jdField_a_of_type_Wbk.a)) {
      return;
    }
    wca.a(this.this$0).remove(this.jdField_a_of_type_Wbk.a);
    wca.a(this.this$0, this.jdField_a_of_type_Wbk, this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */