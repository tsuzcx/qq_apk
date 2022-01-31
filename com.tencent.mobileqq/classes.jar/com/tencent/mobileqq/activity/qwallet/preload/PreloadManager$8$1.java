package com.tencent.mobileqq.activity.qwallet.preload;

import aivr;
import aivt;
import java.lang.ref.WeakReference;

public class PreloadManager$8$1
  implements Runnable
{
  public PreloadManager$8$1(aivr paramaivr, WeakReference paramWeakReference, aivt paramaivt) {}
  
  public void run()
  {
    PreloadManager localPreloadManager = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a(localPreloadManager)) {
      this.jdField_a_of_type_Aivt.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.handleFlowConfig(localPreloadManager, this.jdField_a_of_type_Aivt.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule, this.jdField_a_of_type_Aivt.jdField_a_of_type_Bdvu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.8.1
 * JD-Core Version:    0.7.0.1
 */