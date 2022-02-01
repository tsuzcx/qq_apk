package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;
import tmz;

public class ReadInJoyArticleBottomVideoView$WeakReferenceRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<tmz> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ReadInJoyArticleBottomVideoView$WeakReferenceRunnable(tmz paramtmz, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramtmz);
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
    ((tmz)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    return;
    ((tmz)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
    return;
    ((tmz)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c();
    return;
    ((tmz)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d();
    return;
    ((tmz)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView.WeakReferenceRunnable
 * JD-Core Version:    0.7.0.1
 */