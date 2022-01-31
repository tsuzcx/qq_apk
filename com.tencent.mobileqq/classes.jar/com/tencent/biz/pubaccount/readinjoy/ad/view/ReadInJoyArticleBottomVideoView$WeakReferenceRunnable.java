package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;
import oby;

public class ReadInJoyArticleBottomVideoView$WeakReferenceRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<oby> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ReadInJoyArticleBottomVideoView$WeakReferenceRunnable(oby paramoby, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramoby);
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
    ((oby)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    return;
    ((oby)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
    return;
    ((oby)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c();
    return;
    ((oby)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d();
    return;
    ((oby)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView.WeakReferenceRunnable
 * JD-Core Version:    0.7.0.1
 */