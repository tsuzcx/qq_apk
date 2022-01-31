package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ReadInjoyIMAXAdFragment$WeakReferenceRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<ReadInjoyIMAXAdFragment> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ReadInjoyIMAXAdFragment$WeakReferenceRunnable(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadInjoyIMAXAdFragment);
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
    QLog.e("ReadInjoyIMAXAdFragment", 2, "WeakReferenceRunnable run type is error mType: " + this.jdField_a_of_type_Int);
    return;
    ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d();
    return;
    ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
    return;
    ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).f();
    return;
    ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g();
    return;
    ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.WeakReferenceRunnable
 * JD-Core Version:    0.7.0.1
 */