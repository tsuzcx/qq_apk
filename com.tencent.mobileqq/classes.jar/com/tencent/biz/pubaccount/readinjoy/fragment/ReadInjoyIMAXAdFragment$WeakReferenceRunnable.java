package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadInjoyIMAXAdFragment$WeakReferenceRunnable
  implements Runnable
{
  private WeakReference<ReadInjoyIMAXAdFragment> a;
  private int b;
  
  protected ReadInjoyIMAXAdFragment$WeakReferenceRunnable(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment, int paramInt)
  {
    this.a = new WeakReference(paramReadInjoyIMAXAdFragment);
    this.b = paramInt;
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      int i = this.b;
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
                  ((StringBuilder)localObject).append(this.b);
                  QLog.e("ReadInjoyIMAXAdFragment", 2, ((StringBuilder)localObject).toString());
                }
              }
              else {
                ((ReadInjoyIMAXAdFragment)this.a.get()).i();
              }
            }
            else {
              ((ReadInjoyIMAXAdFragment)this.a.get()).h();
            }
          }
          else {
            ((ReadInjoyIMAXAdFragment)this.a.get()).g();
          }
        }
        else {
          ((ReadInjoyIMAXAdFragment)this.a.get()).f();
        }
      }
      else {
        ((ReadInjoyIMAXAdFragment)this.a.get()).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.WeakReferenceRunnable
 * JD-Core Version:    0.7.0.1
 */