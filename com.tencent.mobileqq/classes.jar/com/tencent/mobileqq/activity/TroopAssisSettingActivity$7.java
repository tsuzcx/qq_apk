package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class TroopAssisSettingActivity$7
  extends RoamSettingObserver
{
  TroopAssisSettingActivity$7(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter == null) {
        return;
      }
      if ((paramBoolean) && (paramMap != null))
      {
        paramString = paramMap.keySet().iterator();
        while (paramString.hasNext())
        {
          String str = (String)paramString.next();
          Integer localInteger = (Integer)paramMap.get(str);
          if (localInteger != null) {
            this.a.jdField_a_of_type_JavaUtilMap.put(str, localInteger);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.a(this.a.jdField_a_of_type_JavaUtilMap);
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
        this.a.b();
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
      this.a.b();
      QQToast.a(this.a.app.getApp(), 1, this.a.getString(2131719975), 0).b(this.a.getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.a.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.a.app, this.a.jdField_a_of_type_JavaUtilList);
      if (this.a.jdField_a_of_type_JavaUtilMap == null) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.a(this.a.jdField_a_of_type_JavaUtilMap);
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */