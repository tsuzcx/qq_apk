package com.tencent.mobileqq.activity.qwallet.preload;

import java.lang.ref.WeakReference;

class PreloadManager$5
  implements Runnable
{
  PreloadManager$5(PreloadManager paramPreloadManager, WeakReference paramWeakReference, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      PreloadManager localPreloadManager = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localPreloadManager != null) && (!localPreloadManager.jdField_a_of_type_Boolean)) {
        localPreloadManager.a(this.jdField_a_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.5
 * JD-Core Version:    0.7.0.1
 */