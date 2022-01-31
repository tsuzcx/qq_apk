package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import ayoi;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import rpg;
import rph;
import rpn;

public class ImageManager$1
  implements Runnable
{
  public ImageManager$1(rpg paramrpg, rph paramrph, RunningJob paramRunningJob) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (ayoi.a(this.jdField_a_of_type_Rph.a.toString()) == null))
    {
      this.this$0.b.put(this.jdField_a_of_type_Rph, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
      if (QLog.isColorLevel()) {
        rpn.a(rpg.jdField_a_of_type_JavaLangString, "loadImage request:" + this.jdField_a_of_type_Rph + " add to pending queue", true);
      }
      return;
    }
    synchronized (rpg.b())
    {
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Rph, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
      this.this$0.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager.1
 * JD-Core Version:    0.7.0.1
 */