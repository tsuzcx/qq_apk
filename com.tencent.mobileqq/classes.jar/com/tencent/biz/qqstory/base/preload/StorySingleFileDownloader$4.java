package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;
import wkq;
import wlg;

public class StorySingleFileDownloader$4
  implements Runnable
{
  public StorySingleFileDownloader$4(wlg paramwlg, wkq paramwkq, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!wlg.a(this.this$0).containsKey(this.jdField_a_of_type_Wkq.a)) {
      return;
    }
    wlg.a(this.this$0).remove(this.jdField_a_of_type_Wkq.a);
    wlg.a(this.this$0, this.jdField_a_of_type_Wkq, this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */