package com.tencent.biz.tribe;

import bdll;
import bhnv;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class TribeVideoPlugin$TechReportRunnable
  implements Runnable
{
  private WeakReference<TribeVideoPlugin> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  TribeVideoPlugin$TechReportRunnable(TribeVideoPlugin paramTribeVideoPlugin, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTribeVideoPlugin);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    TribeVideoPlugin localTribeVideoPlugin = (TribeVideoPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localTribeVideoPlugin == null) || (TribeVideoPlugin.a(localTribeVideoPlugin) == null)) {
      return;
    }
    String str = ((BaseActivity)TribeVideoPlugin.a(localTribeVideoPlugin)).getCurrentAccountUin();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      bdll.b(null, "dc00899", "BizTechReport", str, "tribe_video", "play", 0, 0, Integer.toString(i), Integer.toString(bhnv.b(TribeVideoPlugin.a(localTribeVideoPlugin))), "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin.TechReportRunnable
 * JD-Core Version:    0.7.0.1
 */