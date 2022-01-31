package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import ayog;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import rpj;
import rpk;
import rpq;

public class ImageManager$1
  implements Runnable
{
  public ImageManager$1(rpj paramrpj, rpk paramrpk, RunningJob paramRunningJob) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (ayog.a(this.jdField_a_of_type_Rpk.a.toString()) == null))
    {
      this.this$0.b.put(this.jdField_a_of_type_Rpk, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
      if (QLog.isColorLevel()) {
        rpq.a(rpj.jdField_a_of_type_JavaLangString, "loadImage request:" + this.jdField_a_of_type_Rpk + " add to pending queue", true);
      }
      return;
    }
    synchronized (rpj.b())
    {
      this.this$0.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Rpk, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
      this.this$0.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager.1
 * JD-Core Version:    0.7.0.1
 */