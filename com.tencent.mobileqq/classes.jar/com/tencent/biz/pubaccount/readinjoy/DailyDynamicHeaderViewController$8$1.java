package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class DailyDynamicHeaderViewController$8$1
  implements ViewBase.OnClickListener
{
  DailyDynamicHeaderViewController$8$1(DailyDynamicHeaderViewController.8 param8) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (paramViewBase.getEventAttachedData() == null)
    {
      QLog.e("DailyHeaderViewController", 1, "[onClick] attach event data is null");
      return;
    }
    DailyDynamicHeaderViewController.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_OrgJsonJSONObject);
    ReadInJoyUtils.a(paramViewBase.getNativeView().getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.8.1
 * JD-Core Version:    0.7.0.1
 */