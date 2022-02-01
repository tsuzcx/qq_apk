package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyIMAXAdFragment$5
  implements URLDrawable.URLDrawableListener
{
  ReadInjoyIMAXAdFragment$5(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment, int paramInt1, int paramInt2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadProgressed =");
      paramURLDrawable.append(paramInt);
      QLog.d("ReadInjoyIMAXAdFragment", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (ReadInjoyIMAXAdFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment)) {
      return;
    }
    ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment.5
 * JD-Core Version:    0.7.0.1
 */