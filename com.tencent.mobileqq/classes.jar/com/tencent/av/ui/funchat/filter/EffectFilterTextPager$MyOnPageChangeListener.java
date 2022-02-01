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
  private WeakReference<EffectFilterTextPager.OnEffectFilterChangeListener> b;
  
  public EffectFilterTextPager$MyOnPageChangeListener(EffectFilterTextPager paramEffectFilterTextPager, EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    this.b = new WeakReference(paramOnEffectFilterChangeListener);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    long l = AudioHelper.c();
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
      this.a.a(1300);
      if (this.a.h != null) {
        this.a.h.a(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l = AudioHelper.c();
    Object localObject;
    if (AudioHelper.e())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected, pos[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], mProgramingPos[");
      ((StringBuilder)localObject).append(EffectFilterTextPager.a(this.a));
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("EffectFilterTextPager", 1, ((StringBuilder)localObject).toString());
    }
    if (EffectFilterTextPager.a(this.a) != paramInt)
    {
      localObject = this.b;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = this.a.d.a(paramInt);
        if (localObject != null) {
          ((EffectFilterTextPager.OnEffectFilterChangeListener)this.b.get()).a(l, paramInt, ((FilterItem)localObject).getId());
        }
        EffectFilterTextPager.a(this.a, -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager.MyOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */