package com.tencent.mobileqq.activity.qwallet.preload;

import ahbo;
import ahbq;
import java.lang.ref.WeakReference;

public class PreloadManager$8$1
  implements Runnable
{
  public PreloadManager$8$1(ahbo paramahbo, WeakReference paramWeakReference, ahbq paramahbq) {}
  
  public void run()
  {
    PreloadManager localPreloadManager = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a(localPreloadManager)) {
      this.jdField_a_of_type_Ahbq.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.handleFlowConfig(localPreloadManager, this.jdField_a_of_type_Ahbq.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule, this.jdField_a_of_type_Ahbq.jdField_a_of_type_Bbwf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.8.1
 * JD-Core Version:    0.7.0.1
 */