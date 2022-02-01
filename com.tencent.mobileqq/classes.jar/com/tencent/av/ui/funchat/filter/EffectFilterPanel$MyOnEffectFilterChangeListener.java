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
  EffectFilterTextPager.OnEffectFilterChangeListener jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$OnEffectFilterChangeListener;
  
  EffectFilterPanel$MyOnEffectFilterChangeListener(EffectFilterPanel paramEffectFilterPanel, EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    a(paramOnEffectFilterChangeListener);
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    if (AudioHelper.b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnItemSelected, id[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], name[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], Visibility[");
      localStringBuilder.append(EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).getVisibility());
      localStringBuilder.append("], mlistener[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$OnEffectFilterChangeListener);
      localStringBuilder.append("]");
      QLog.w("EffectFilterPanel", 1, localStringBuilder.toString());
    }
    if (EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).getVisibility() == 0)
    {
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).removeCallbacks(EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel));
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).clearAnimation();
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).setVisibility(8);
    }
    paramString = (FilterItem)EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a(paramString);
    EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a(paramLong, paramString);
    if (paramString != null)
    {
      if (!paramString.isUsable()) {
        EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a(paramLong, paramString);
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.b();
      if ((paramString.getId() != null) && (paramString.getId().compareToIgnoreCase("MANHUA") == 0))
      {
        EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a().e(51, paramString.getId());
        return;
      }
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a().e(0, paramString.getId());
    }
  }
  
  public void a(EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$OnEffectFilterChangeListener = paramOnEffectFilterChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel.MyOnEffectFilterChangeListener
 * JD-Core Version:    0.7.0.1
 */