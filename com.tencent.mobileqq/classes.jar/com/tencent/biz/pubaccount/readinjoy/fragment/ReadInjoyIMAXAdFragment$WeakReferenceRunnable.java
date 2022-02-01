package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadInjoyIMAXAdFragment$WeakReferenceRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private WeakReference<ReadInjoyIMAXAdFragment> jdField_a_of_type_JavaLangRefWeakReference;
  
  protected ReadInjoyIMAXAdFragment$WeakReferenceRunnable(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadInjoyIMAXAdFragment);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      int i = this.jdField_a_of_type_Int;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("WeakReferenceRunnable run type is error mType: ");
                  ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
                  QLog.e("ReadInjoyIMAXAdFragment", 2, ((StringBuilder)localObject).toString());
                }
              }
              else {
                ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).h();
              }
            }
            else {
              ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g();
            }
          }
          else {
            ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).f();
          }
        }
        else {
          ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
        }
      }
      else {
        ((ReadInjoyIMAXAdFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.WeakReferenceRunnable
 * JD-Core Version:    0.7.0.1
 */