package com.tencent.av.ui.funchat.filter;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.utils.AudioHelper;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrollStateChanged, arg0[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("EffectFilterTextPager", 1, localStringBuilder.toString());
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
    Object localObject;
    if (AudioHelper.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected, pos[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], mProgramingPos[");
      ((StringBuilder)localObject).append(EffectFilterTextPager.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager));
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("EffectFilterTextPager", 1, ((StringBuilder)localObject).toString());
    }
    if (EffectFilterTextPager.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager) != paramInt)
    {
      localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(paramInt);
        if (localObject != null) {
          ((EffectFilterTextPager.OnEffectFilterChangeListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(l, paramInt, ((FilterItem)localObject).getId());
        }
        EffectFilterTextPager.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager, -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager.MyOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */