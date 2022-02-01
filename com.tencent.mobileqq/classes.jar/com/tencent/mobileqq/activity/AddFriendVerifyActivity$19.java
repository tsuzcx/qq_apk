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
  
  public void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramBoolean)
    {
      int i = this.a.getIntent().getExtras().getShort("group_option", (short)2);
      if (i == 4) {
        if (paramTroopInfo != null)
        {
          paramString = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
          paramString.putExtra("uin", paramTroopInfo.troopuin);
          paramString.putExtra("uintype", 1);
          paramString.putExtra("uinname", paramTroopInfo.getTroopDisplayName());
          this.a.startActivity(paramString);
        }
      }
      while ((TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.a.app.getAccount())) || (i != 1)) {
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
      return;
    }
    this.a.setResult(-1);
    if ((this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) && (AddFriendVerifyActivity.a(this.a) != null))
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    this.a.finish();
  }
  
  public void onOIDB0X88D_10_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong), this.a.jdField_a_of_type_JavaLangString)) {}
    label252:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break label252;
          }
          long l = paramTroopInfo.dwGroupClassExt;
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = " + paramBoolean + ", troopuin = " + paramLong + ", nFlag = " + paramInt1 + ", troopInfo = " + paramTroopInfo + ", dwGroupClassExt = " + l + ", onResult = " + paramInt2 + ", strErrorMsg = " + paramString);
          }
          if ((l != 10009L) && (l != 10010L) && (l != 10011L) && (l != 10012L) && (!paramTroopInfo.isHomeworkTroop())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret: 不需要显示城市、星座、性别这一交友信息~");
        return;
        paramTroopInfo = AddFriendVerifyActivity.b(this.a);
      } while (TextUtils.isEmpty(paramTroopInfo));
      paramTroopInfo = this.a.getString(2131697539, new Object[] { this.a.app.getCurrentNickname() }) + paramTroopInfo;
      this.a.d(paramTroopInfo);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("zivonchen", 2, "AddFriendVerifyActivity onOIDB0X88D_10_Ret isSuccess = " + paramBoolean + ", troopuin = " + paramLong + ", nFlag = " + paramInt1 + ", troopInfo = " + paramTroopInfo + ", onResult = " + paramInt2 + ", strErrorMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.19
 * JD-Core Version:    0.7.0.1
 */