package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ServiceAccountFolderActivityNew$4
  implements RadioGroup.OnCheckedChangeListener
{
  ServiceAccountFolderActivityNew$4(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    ServiceAccountFolderActivityNew.a(this.a, true);
    if (ServiceAccountFolderActivityNew.f(this.a).getId() == paramInt) {
      ServiceAccountFolderActivityNew.g(this.a).setCurrentItem(0);
    } else if (ServiceAccountFolderActivityNew.h(this.a).getId() == paramInt) {
      ServiceAccountFolderActivityNew.g(this.a).setCurrentItem(1);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew.4
 * JD-Core Version:    0.7.0.1
 */