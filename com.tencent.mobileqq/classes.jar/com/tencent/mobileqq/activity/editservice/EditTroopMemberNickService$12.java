package com.tencent.mobileqq.activity.editservice;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class EditTroopMemberNickService$12
  implements IApolloExtensionObserver
{
  EditTroopMemberNickService$12(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      VasWebviewUtil.a(EditTroopMemberNickService.b(this.a).getCurrentUin(), "group_nickname", "set", "", 1, 0, 0, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, "onSetColorNick. clear saved colorNick");
      }
      this.a.a(true);
      paramString = (ITroopMemberCardHandler)EditTroopMemberNickService.b(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
    }
    try
    {
      paramString.a(Long.parseLong(this.a.j), Long.parseLong(this.a.k));
      return;
    }
    catch (Exception paramString)
    {
      label98:
      String str;
      Context localContext;
      break label98;
    }
    EditTroopMemberNickService.d(this.a).loadingProgress(false);
    return;
    EditTroopMemberNickService.d(this.a).loadingProgress(false);
    if (paramInt == 1282)
    {
      VasWebviewUtil.a(EditTroopMemberNickService.b(this.a).getCurrentUin(), "group_nickname", "group_nickname_9", "", 1, 0, 0, "", "", "");
      paramString = HardCodeUtil.a(2131901741);
      str = HardCodeUtil.a(2131901736);
      try
      {
        DialogUtil.a(EditTroopMemberNickService.f(this.a), 230, paramString, str, HardCodeUtil.a(2131901729), HardCodeUtil.a(2131901733), new EditTroopMemberNickService.12.1(this), new EditTroopMemberNickService.12.2(this)).show();
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("EditTroopMemberNickService", 1, "onSetColorNick", paramString);
        return;
      }
    }
    if (1283 == paramInt)
    {
      QQToast.makeText(EditTroopMemberNickService.f(this.a), 1, HardCodeUtil.a(2131901732), 0).show(EditTroopMemberNickService.g(this.a));
      return;
    }
    if (1793 == paramInt)
    {
      localContext = EditTroopMemberNickService.f(this.a);
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = EditTroopMemberNickService.a(this.a, 2131890904);
      }
      QQToast.makeText(localContext, 1, str, 0).show(EditTroopMemberNickService.g(this.a));
      return;
    }
    QQToast.makeText(EditTroopMemberNickService.f(this.a), 1, 2131891837, 0).show(EditTroopMemberNickService.g(this.a));
    this.a.L.postDelayed(new EditTroopMemberNickService.12.3(this), 1500L);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 27)
    {
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 1))
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
        return;
      }
      a(paramBoolean, 0, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.12
 * JD-Core Version:    0.7.0.1
 */