package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class AddFriendVerifyActivity$19
  extends TroopObserver
{
  AddFriendVerifyActivity$19(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramBoolean)
    {
      int i = this.a.getIntent().getExtras().getShort("group_option", (short)2);
      if (i == 4)
      {
        if (paramTroopInfo != null)
        {
          paramString = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
          paramString.putExtra("uin", paramTroopInfo.troopuin);
          paramString.putExtra("uintype", 1);
          paramString.putExtra("uinname", paramTroopInfo.getTroopDisplayName());
          this.a.startActivity(paramString);
        }
      }
      else if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
      {
        if (TextUtils.isEmpty(this.a.app.getAccount())) {
          return;
        }
        if (i != 1) {
          return;
        }
        if (paramTroopInfo != null)
        {
          paramString = this.a.app.getProxyManager();
          RecentUser localRecentUser = paramString.a().a(paramTroopInfo.troopuin, 1);
          localRecentUser.displayName = paramTroopInfo.troopname;
          localRecentUser.msgData = null;
          localRecentUser.msg = null;
          localRecentUser.msgType = 0;
          long l = NetConnInfoCenter.getServerTime();
          if (localRecentUser.lastmsgtime < l) {
            localRecentUser.lastmsgtime = l;
          }
          paramString.a().b(localRecentUser);
          this.a.setResult(-1);
        }
        this.a.finish();
      }
    }
    else
    {
      this.a.setResult(-1);
      if ((this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) && (AddFriendVerifyActivity.a(this.a) != null))
      {
        this.a.getWindow().setSoftInputMode(2);
        this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.a).clearFocus();
      }
      this.a.finish();
    }
  }
  
  protected void onOIDB0X88D_10_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong), this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      long l = paramTroopInfo.dwGroupClassExt;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", troopuin = ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", nFlag = ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", troopInfo = ");
        ((StringBuilder)localObject).append(paramTroopInfo);
        ((StringBuilder)localObject).append(", dwGroupClassExt = ");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(", onResult = ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", strErrorMsg = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
      }
      if ((l != 10009L) && (l != 10010L) && (l != 10011L) && (l != 10012L) && (!paramTroopInfo.isHomeworkTroop()))
      {
        paramTroopInfo = AddFriendVerifyActivity.b(this.a);
        if (!TextUtils.isEmpty(paramTroopInfo))
        {
          paramString = new StringBuilder();
          localObject = this.a;
          paramString.append(((AddFriendVerifyActivity)localObject).getString(2131697545, new Object[] { ((AddFriendVerifyActivity)localObject).app.getCurrentNickname() }));
          paramString.append(paramTroopInfo);
          paramTroopInfo = paramString.toString();
          this.a.d(paramTroopInfo);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret: 不需要显示城市、星座、性别这一交友信息~");
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", troopuin = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", nFlag = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", troopInfo = ");
      ((StringBuilder)localObject).append(paramTroopInfo);
      ((StringBuilder)localObject).append(", onResult = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", strErrorMsg = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.19
 * JD-Core Version:    0.7.0.1
 */