package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class TroopBlockDialogHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  protected QQCustomDialog a;
  
  public TroopBlockDialogHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  protected void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject == null) {
      return;
    }
    if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    if (TroopBlockUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject))
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = TroopBlockUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, new TroopBlockDialogHelper.1(this, (String)localObject));
      return;
    }
    a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject instanceof TroopChatPie)) {
      ((TroopChatPie)localObject).aw();
    }
  }
  
  public String getTag()
  {
    return "TroopBlockDialogHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15, 7 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt != 15) {
        return;
      }
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopBlockDialogHelper
 * JD-Core Version:    0.7.0.1
 */