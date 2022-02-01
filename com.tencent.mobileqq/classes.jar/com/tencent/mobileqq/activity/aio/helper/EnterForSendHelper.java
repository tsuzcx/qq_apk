package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.widget.XEditTextEx;

public class EnterForSendHelper
  implements ILifeCycleHelper
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected EnterForSendHelper.EnterForSend a;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  protected boolean a;
  
  public EnterForSendHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
  }
  
  private void a(XEditTextEx paramXEditTextEx)
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    this.jdField_a_of_type_Boolean = SettingCloneUtil.readValue(localBaseActivity, null, localBaseActivity.getString(2131694971), "qqsetting_enter_sendmsg_key", false);
    if (this.jdField_a_of_type_Boolean) {
      paramXEditTextEx.setImeOptions(4);
    } else {
      paramXEditTextEx.setImeOptions(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperEnterForSendHelper$EnterForSend == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperEnterForSendHelper$EnterForSend = new EnterForSendHelper.EnterForSend(this, null);
    }
    paramXEditTextEx.setOnEditorActionListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperEnterForSendHelper$EnterForSend);
    paramXEditTextEx.setOnKeyListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperEnterForSendHelper$EnterForSend);
  }
  
  public String getTag()
  {
    return "EnterForSendHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 10 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 6)
    {
      if (paramInt != 10) {
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.EnterForSendHelper
 * JD-Core Version:    0.7.0.1
 */