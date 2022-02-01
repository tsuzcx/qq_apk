package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class DiscussChatPie$4
  extends TroopMngObserver
{
  DiscussChatPie$4(DiscussChatPie paramDiscussChatPie) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1)
  {
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()))
      {
        DiscussChatPie.a(this.a);
        return;
      }
      if (!paramBoolean1.booleanValue())
      {
        paramString1 = BaseActivity.sTopActivity;
        if (paramString1 != null) {
          DialogUtil.a(paramString1, 230, paramString1.getString(2131689903), null, null, paramString1.getString(2131719065), new DiscussChatPie.4.1(this, paramString1), null).show();
        }
      }
    }
    else
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramInt, 0).b(this.a.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.4
 * JD-Core Version:    0.7.0.1
 */