package com.tencent.mobileqq.activity.qwallet.preload;

import bead;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.TimerTask;

class PreloadManager$4
  extends TimerTask
{
  PreloadManager$4(PreloadManager paramPreloadManager, WeakReference paramWeakReference, List paramList, bead parambead) {}
  
  public void run()
  {
    PreloadManager localPreloadManager = (PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadManager.a(localPreloadManager)) {
      PreloadManager.a(localPreloadManager, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bead);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.4
 * JD-Core Version:    0.7.0.1
 */