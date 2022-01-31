package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;
import sui;
import suy;

public class StorySingleFileDownloader$4
  implements Runnable
{
  public StorySingleFileDownloader$4(suy paramsuy, sui paramsui, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!suy.a(this.this$0).containsKey(this.jdField_a_of_type_Sui.a)) {
      return;
    }
    suy.a(this.this$0).remove(this.jdField_a_of_type_Sui.a);
    suy.a(this.this$0, this.jdField_a_of_type_Sui, this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */