package com.tencent.mobileqq.adapter;

import android.content.Context;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;
import java.util.HashMap;

class TroopListAdapter2$1
  extends TroopShowExternalObserver
{
  TroopListAdapter2$1(TroopListAdapter2 paramTroopListAdapter2, TroopActivity paramTroopActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity;
      QQToast.a((Context)localObject, ((TroopActivity)localObject).getString(2131696194), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.getTitleBarHeight());
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
      {
        localObject = (Switch)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {
          ((Switch)localObject).setChecked(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.1
 * JD-Core Version:    0.7.0.1
 */