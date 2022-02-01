package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport;
import java.util.concurrent.ThreadPoolExecutor;

class ImageManager$1
  implements Runnable
{
  ImageManager$1(ImageManager paramImageManager, ImageRequest paramImageRequest, RunningJob paramRunningJob) {}
  
  public void run()
  {
    RIJImageOptReport.a(3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest);
    this.this$0.a.execute(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager.1
 * JD-Core Version:    0.7.0.1
 */