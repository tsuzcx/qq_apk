package com.tencent.mobileqq.activity.editservice;

import QC.UniCheckRsp;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.AuthRequest.AuthListener;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickAuthRequest;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import java.util.ArrayList;

class EditTroopMemberNickService$15
  implements AuthRequest.AuthListener
{
  EditTroopMemberNickService$15(EditTroopMemberNickService paramEditTroopMemberNickService, int paramInt) {}
  
  public void a(boolean paramBoolean, UniCheckRsp paramUniCheckRsp)
  {
    if ((!paramBoolean) && (paramUniCheckRsp != null) && (paramUniCheckRsp.uniBusinessItemList != null) && (paramUniCheckRsp.uniBusinessItemList.size() == 1))
    {
      paramUniCheckRsp = this.b;
      paramUniCheckRsp.m = false;
      EditTroopMemberNickService.d(paramUniCheckRsp).loadingProgress(false);
      TroopNickAuthRequest.a(EditTroopMemberNickService.f(this.b));
      return;
    }
    ((IApolloExtensionHandler)EditTroopMemberNickService.b(this.b).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.b.j, ((ColorClearableEditText)this.b.a).getParagraphs(), this.a);
    this.b.m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.15
 * JD-Core Version:    0.7.0.1
 */