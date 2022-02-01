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
    this.jdField_a_of_type_Boolean = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694981), "qqsetting_enter_sendmsg_key", false);
    if (this.jdField_a_of_type_Boolean) {
      paramXEditTextEx.setImeOptions(4);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperEnterForSendHelper$EnterForSend == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperEnterForSendHelper$EnterForSend = new EnterForSendHelper.EnterForSend(this, null);
      }
      paramXEditTextEx.setOnEditorActionListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperEnterForSendHelper$EnterForSend);
      paramXEditTextEx.setOnKeyListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperEnterForSendHelper$EnterForSend);
      return;
      paramXEditTextEx.setImeOptions(0);
    }
  }
  
  public String getTag()
  {
    return "EnterForSendHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 21, 9 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 21: 
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.EnterForSendHelper
 * JD-Core Version:    0.7.0.1
 */