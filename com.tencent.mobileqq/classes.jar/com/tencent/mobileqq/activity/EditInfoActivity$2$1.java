package com.tencent.mobileqq.activity;

import QC.UniCheckRsp;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.AuthRequest.AuthListener;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickAuthRequest;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import java.util.ArrayList;

class EditInfoActivity$2$1
  implements AuthRequest.AuthListener
{
  EditInfoActivity$2$1(EditInfoActivity.2 param2, int paramInt) {}
  
  public void a(boolean paramBoolean, UniCheckRsp paramUniCheckRsp)
  {
    if ((!paramBoolean) && (paramUniCheckRsp != null) && (paramUniCheckRsp.uniBusinessItemList != null) && (paramUniCheckRsp.uniBusinessItemList.size() == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$2.a.j = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$2.a.b(false);
      TroopNickAuthRequest.a(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$2.a.getBaseContext());
      return;
    }
    ((IApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$2.a.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$2.a.e, ((ColorClearableEditText)this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$2.a.a).a(), this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityEditInfoActivity$2.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.2.1
 * JD-Core Version:    0.7.0.1
 */