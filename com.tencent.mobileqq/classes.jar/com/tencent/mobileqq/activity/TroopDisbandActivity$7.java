package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;

class TroopDisbandActivity$7
  extends TroopMngObserver
{
  TroopDisbandActivity$7(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 9)
    {
      Object localObject = this.a;
      ((TroopDisbandActivity)localObject).b &= 0xFFFFFFFE;
      if (paramInt2 == 8)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
        }
        localObject = DialogUtil.a(this.a, 230);
        ((QQCustomDialog)localObject).setTitle(this.a.getString(2131696130));
        ((QQCustomDialog)localObject).setMessage(this.a.getString(2131696131));
        ((QQCustomDialog)localObject).setNegativeButton(this.a.getString(2131696162), new TroopDisbandActivity.7.1(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).setPositiveButton(this.a.getString(2131719065), new TroopDisbandActivity.7.2(this, (QQCustomDialog)localObject));
        ((QQCustomDialog)localObject).show();
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null)
      {
        localObject = this.a;
        ((TroopDisbandActivity)localObject).jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier((Activity)localObject);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692085, 1500);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (!Utils.a(paramString, this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (paramInt1 == 9)
    {
      paramString = this.a;
      paramString.b &= 0xFFFFFFFE;
      if (paramInt2 == 0)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
        }
        paramString = new Intent();
        paramString.putExtra("isNeedFinish", true);
        paramString.putExtra("fin_tip_msg", this.a.getString(2131692089));
        this.a.setResult(-1, paramString);
        this.a.finish();
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null)
      {
        paramString = this.a;
        paramString.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(paramString);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692085, 1500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.7
 * JD-Core Version:    0.7.0.1
 */