package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;
import nng;

public class ReadInJoyArticleBottomVideoView$WeakReferenceRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<nng> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ReadInJoyArticleBottomVideoView$WeakReferenceRunnable(nng paramnng, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramnng);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    do
    {
      return;
      switch (this.jdField_a_of_type_Int)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e("ReadInJoyArticleBottomVideoView", 0, "WeakReferenceRunnable run type is error mType: " + this.jdField_a_of_type_Int);
    return;
    ((nng)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    return;
    ((nng)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
    return;
    ((nng)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c();
    return;
    ((nng)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d();
    return;
    ((nng)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView.WeakReferenceRunnable
 * JD-Core Version:    0.7.0.1
 */