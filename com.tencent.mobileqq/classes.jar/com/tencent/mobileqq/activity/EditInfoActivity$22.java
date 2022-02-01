package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class EditInfoActivity$22
  implements IApolloExtensionObserver
{
  EditInfoActivity$22(EditInfoActivity paramEditInfoActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentUin(), "group_nickname", "set", "", 1, 0, 0, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ColorNick", 2, "onSetColorNick. clear saved colorNick");
      }
      this.a.c(true);
      paramString = (TroopMemberInfoHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
      try
      {
        paramString.a(Long.parseLong(this.a.e), Long.parseLong(this.a.f));
        return;
      }
      catch (Exception paramString)
      {
        this.a.b(false);
        return;
      }
    }
    this.a.b(false);
    String str;
    if (paramInt == 1282)
    {
      VasWebviewUtil.reportCommercialDrainage(this.a.app.getCurrentUin(), "group_nickname", "group_nickname_9", "", 1, 0, 0, "", "", "");
      paramString = HardCodeUtil.a(2131703666);
      str = HardCodeUtil.a(2131703660);
      try
      {
        DialogUtil.a(this.a, 230, paramString, str, HardCodeUtil.a(2131703653), HardCodeUtil.a(2131703657), new EditInfoActivity.22.1(this), new EditInfoActivity.22.2(this)).show();
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("EditInfoActivity", 1, "onSetColorNick", paramString);
        return;
      }
    }
    if (1283 == paramInt)
    {
      QQToast.a(this.a, 1, HardCodeUtil.a(2131703656), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (1793 == paramInt)
    {
      EditInfoActivity localEditInfoActivity = this.a;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.a.getString(2131693400);
      }
      QQToast.a(localEditInfoActivity, 1, str, 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a, 1, 2131694234, 0).b(this.a.getTitleBarHeight());
    this.a.a.postDelayed(new EditInfoActivity.22.3(this), 1500L);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 27)
    {
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 1)) {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      }
    }
    else
    {
      return;
    }
    a(paramBoolean, 0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.22
 * JD-Core Version:    0.7.0.1
 */