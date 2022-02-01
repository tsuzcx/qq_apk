package com.tencent.mobileqq.activity.qwallet.preload;

import akbf;
import java.lang.ref.WeakReference;

class PreloadResource$1
  extends PreloadResource.PreloadTimerTask
{
  PreloadResource$1(PreloadResource paramPreloadResource, WeakReference paramWeakReference, PreloadModule paramPreloadModule) {}
  
  public void a()
  {
    PreloadManager localPreloadManager = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((PreloadManager.a(localPreloadManager)) && (localPreloadManager.a(this.this$0))) {
      localPreloadManager.a(new akbf(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadResource.1
 * JD-Core Version:    0.7.0.1
 */