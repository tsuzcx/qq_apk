package com.tencent.mobileqq.activity.aio.helper;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

public class StrangerOnlineStatusHelper
  extends OnlineStatusHelper
{
  public StrangerOnlineStatusHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 1025) || (!((StrangerQidianHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(61)).a(true))) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1006))
    {
      Object localObject = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryContactByCodeNumber(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
      if (((localObject == null) || (OnlineStatusUtils.a(((PhoneContact)localObject).detalStatusFlag, ((PhoneContact)localObject).iTermType) == 0)) && (a().getVisibility() == 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
        if (((TipsManager)localObject).a() == 5)
        {
          FriendHotTipsBar.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
          ((TipsManager)localObject).a();
        }
      }
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1006) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "StrangerOnlineStatusHelper";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StrangerOnlineStatusHelper
 * JD-Core Version:    0.7.0.1
 */