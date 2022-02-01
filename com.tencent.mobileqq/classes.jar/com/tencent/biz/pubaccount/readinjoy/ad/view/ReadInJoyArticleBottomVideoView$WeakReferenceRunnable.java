package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;
import ono;

public class ReadInJoyArticleBottomVideoView$WeakReferenceRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<ono> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ReadInJoyArticleBottomVideoView$WeakReferenceRunnable(ono paramono, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramono);
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
    ((ono)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    return;
    ((ono)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
    return;
    ((ono)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c();
    return;
    ((ono)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d();
    return;
    ((ono)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView.WeakReferenceRunnable
 * JD-Core Version:    0.7.0.1
 */