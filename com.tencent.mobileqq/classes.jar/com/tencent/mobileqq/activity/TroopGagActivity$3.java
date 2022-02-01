package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopGagActivity$3
  extends TroopObserver
{
  TroopGagActivity$3(TroopGagActivity paramTroopGagActivity) {}
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter.notifyDataSetChanged();
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter.getCount() == 0) {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      } else {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      paramString = this.a;
      paramList = new StringBuilder();
      paramList.append("last_update_time");
      paramList.append(this.a.app.getCurrentAccountUin());
      paramString = paramString.getSharedPreferences(paramList.toString(), 4).edit();
      paramList = new StringBuilder();
      paramList.append("key_last_update_time");
      paramList.append(this.a.jdField_a_of_type_JavaLangString);
      paramString.putLong(paramList.toString(), System.currentTimeMillis()).commit();
    }
    ThreadManager.post(new TroopGagActivity.3.1(this, (TroopGagMgr)this.a.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)), 8, null, false);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onUpdateTroopGetMemberList: isSuccess=");
      paramString.append(paramBoolean);
      QLog.d("TroopGagActivity", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.3
 * JD-Core Version:    0.7.0.1
 */