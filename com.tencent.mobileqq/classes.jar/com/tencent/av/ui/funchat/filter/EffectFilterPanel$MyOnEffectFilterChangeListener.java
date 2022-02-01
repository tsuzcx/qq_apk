package com.tencent.av.ui.funchat.filter;

import android.os.Handler;
import android.widget.ImageView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class EffectFilterPanel$MyOnEffectFilterChangeListener
  implements EffectFilterTextPager.OnEffectFilterChangeListener
{
  EffectFilterTextPager.OnEffectFilterChangeListener a;
  
  EffectFilterPanel$MyOnEffectFilterChangeListener(EffectFilterPanel paramEffectFilterPanel, EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    a(paramOnEffectFilterChangeListener);
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    if (AudioHelper.e())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnItemSelected, id[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], name[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], Visibility[");
      localStringBuilder.append(EffectFilterPanel.a(this.b).getVisibility());
      localStringBuilder.append("], mlistener[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w("EffectFilterPanel", 1, localStringBuilder.toString());
    }
    if (EffectFilterPanel.a(this.b).getVisibility() == 0)
    {
      EffectFilterPanel.c(this.b).removeCallbacks(EffectFilterPanel.b(this.b));
      EffectFilterPanel.a(this.b).clearAnimation();
      EffectFilterPanel.a(this.b).setVisibility(8);
    }
    paramString = (FilterItem)EffectFilterPanel.d(this.b).b(paramString);
    EffectFilterPanel.d(this.b).a(paramLong, paramString);
    if (paramString != null)
    {
      if (!paramString.isUsable()) {
        EffectFilterPanel.d(this.b).b(paramLong, paramString);
      }
      this.b.b();
      if ((paramString.getId() != null) && (paramString.getId().compareToIgnoreCase("MANHUA") == 0))
      {
        EffectFilterPanel.e(this.b).b().f(51, paramString.getId());
        return;
      }
      EffectFilterPanel.e(this.b).b().f(0, paramString.getId());
    }
  }
  
  public void a(EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    this.a = paramOnEffectFilterChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel.MyOnEffectFilterChangeListener
 * JD-Core Version:    0.7.0.1
 */