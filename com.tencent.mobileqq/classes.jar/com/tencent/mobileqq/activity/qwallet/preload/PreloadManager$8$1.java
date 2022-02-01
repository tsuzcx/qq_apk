package com.tencent.mobileqq.activity.qwallet.preload;

import aldk;
import aldn;
import java.lang.ref.WeakReference;

public class PreloadManager$8$1
  implements Runnable
{
  public PreloadManager$8$1(aldk paramaldk, WeakReference paramWeakReference, aldn paramaldn) {}
  
  public void run()
  {
    PreloadManager localPreloadManager = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a(localPreloadManager)) {
      this.jdField_a_of_type_Aldn.a(localPreloadManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.8.1
 * JD-Core Version:    0.7.0.1
 */