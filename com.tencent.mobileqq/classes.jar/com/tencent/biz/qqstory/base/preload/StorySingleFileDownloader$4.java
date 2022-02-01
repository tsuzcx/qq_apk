package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;
import wgv;
import whl;

public class StorySingleFileDownloader$4
  implements Runnable
{
  public StorySingleFileDownloader$4(whl paramwhl, wgv paramwgv, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!whl.a(this.this$0).containsKey(this.jdField_a_of_type_Wgv.a)) {
      return;
    }
    whl.a(this.this$0).remove(this.jdField_a_of_type_Wgv.a);
    whl.a(this.this$0, this.jdField_a_of_type_Wgv, this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */