package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import baqn;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import pdz;
import sff;
import sfg;
import sfm;

public class ImageManager$1
  implements Runnable
{
  public ImageManager$1(sff paramsff, sfg paramsfg, RunningJob paramRunningJob) {}
  
  public void run()
  {
    pdz.a(3, this.jdField_a_of_type_Sfg);
    if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (baqn.a(this.jdField_a_of_type_Sfg.a.toString()) == null))
    {
      this.this$0.b.put(this.jdField_a_of_type_Sfg, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
      if (QLog.isColorLevel()) {
        sfm.a(sff.jdField_a_of_type_JavaLangString, "loadImage request:" + this.jdField_a_of_type_Sfg + " add to pending queue", true);
      }
      return;
    }
    synchronized (sff.b())
    {
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Sfg, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
      this.this$0.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager.1
 * JD-Core Version:    0.7.0.1
 */