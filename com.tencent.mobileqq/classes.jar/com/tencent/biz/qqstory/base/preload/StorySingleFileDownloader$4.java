package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.Map;
import shp;
import sif;

public class StorySingleFileDownloader$4
  implements Runnable
{
  public StorySingleFileDownloader$4(sif paramsif, shp paramshp, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if (!sif.a(this.this$0).containsKey(this.jdField_a_of_type_Shp.a)) {
      return;
    }
    sif.a(this.this$0).remove(this.jdField_a_of_type_Shp.a);
    sif.a(this.this$0, this.jdField_a_of_type_Shp, this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4
 * JD-Core Version:    0.7.0.1
 */