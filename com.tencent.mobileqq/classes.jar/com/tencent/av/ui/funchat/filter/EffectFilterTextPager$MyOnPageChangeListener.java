package com.tencent.av.ui.funchat.filter;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class EffectFilterTextPager$MyOnPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private WeakReference<EffectFilterTextPager.OnEffectFilterChangeListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  public EffectFilterTextPager$MyOnPageChangeListener(EffectFilterTextPager paramEffectFilterTextPager, EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnEffectFilterChangeListener);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("EffectFilterTextPager", 1, "onPageScrollStateChanged, arg0[" + paramInt + "], seq[" + l + "]");
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.a(1300);
      if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w("EffectFilterTextPager", 1, "onPageSelected, pos[" + paramInt + "], mProgramingPos[" + EffectFilterTextPager.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager) + "], seq[" + l + "]");
    }
    if ((EffectFilterTextPager.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager) != paramInt) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      FilterItem localFilterItem = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(paramInt);
      if (localFilterItem != null) {
        ((EffectFilterTextPager.OnEffectFilterChangeListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(l, paramInt, localFilterItem.getId());
      }
      EffectFilterTextPager.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager.MyOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */