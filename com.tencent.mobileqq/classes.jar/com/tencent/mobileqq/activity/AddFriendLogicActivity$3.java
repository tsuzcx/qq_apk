package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AddFriendLogicActivity$3
  extends FriendObserver
{
  AddFriendLogicActivity$3(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [uin:%s, isSuc:%s, type:%s, status:%s]", new Object[] { Utils.i(String.valueOf(paramLong)), Boolean.valueOf(paramBoolean), Integer.valueOf(AddFriendLogicActivity.e(this.a)), Integer.valueOf(paramInt) }));
    }
    if ((AddFriendLogicActivity.e(this.a) == 1) && (String.valueOf(paramLong).equals(AddFriendLogicActivity.f(this.a))))
    {
      if ((paramBoolean) && (paramInt != 0))
      {
        AddFriendLogicActivity.a(this.a, false);
        AddFriendLogicActivity.a(this.a, paramInt);
        AntiFraudConfigFileUtil.a().a(this.a.app, "SecWarningCfg");
        try
        {
          AddFriendLogicActivity.a(this.a, DialogUtil.a(this.a, 230, "", "", this.a.f, this.a.g));
          AddFriendLogicActivity.g(this.a);
          Window localWindow = AddFriendLogicActivity.h(this.a).getWindow();
          if (localWindow != null)
          {
            WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
            if ((QLog.isColorLevel()) && (localLayoutParams != null)) {
              QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [%s, %s, %s]", new Object[] { Float.valueOf(localLayoutParams.dimAmount), Integer.valueOf(localLayoutParams.flags), Integer.valueOf(localLayoutParams.flags & 0x2) }));
            }
            localWindow.setDimAmount(0.5F);
            localWindow.addFlags(2);
          }
          AddFriendLogicActivity.h(this.a).setOnDismissListener(this.a.h);
          AddFriendLogicActivity.h(this.a).show();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        ReportController.b(this.a.app, "P_CliOper", "Safe_AntiFraud", this.a.app.getCurrentAccountUin(), "AlertDialog", "Display", 0, AddFriendLogicActivity.i(this.a), "", "", "", "");
        return;
      }
      AddFriendLogicActivity.b(this.a);
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((AddFriendLogicActivity.c(this.a) == 3024) && (AddFriendLogicActivity.d(this.a) == 0))
    {
      paramString = this.a.app.getApplication();
      int i;
      if (paramBoolean1) {
        i = 2131916262;
      } else {
        i = 2131915702;
      }
      QQToast.makeText(paramString, i, 0).show(this.a.getTitleBarHeight());
      this.a.finish();
    }
  }
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("uin");
    if (!AddFriendLogicActivity.f(this.a).equals(localObject)) {
      return;
    }
    int i = paramBundle.getInt("random_key");
    if ((i != 0) && (i != AddFriendLogicActivity.j(this.a))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format("onUpdateAddFriendSetting [uin:%s, key:%s, isSuc:%s]", new Object[] { Utils.i((String)localObject), Integer.valueOf(i), Boolean.valueOf(paramBoolean) }));
    }
    AddFriendLogicActivity.a(this.a, false);
    ArrayList localArrayList;
    Boolean localBoolean;
    long l;
    if (paramBoolean)
    {
      i = paramBundle.getInt("friend_setting");
      localArrayList = paramBundle.getStringArrayList("user_question");
      localBoolean = Boolean.valueOf(paramBundle.getBoolean("contact_bothway"));
      l = paramBundle.getLong("query_friend_uin");
    }
    try
    {
      paramBundle = Long.toString(l);
    }
    catch (Exception paramBundle)
    {
      label146:
      break label146;
    }
    paramBundle = null;
    if ((localBoolean.booleanValue()) && (i != 0))
    {
      if (AddFriendLogicActivity.c(this.a) == 3006) {
        this.a.getIntent().putExtra("sub_source_id", 2);
      }
      this.a.a(i, localBoolean.booleanValue(), localArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.c(this.a));
      return;
    }
    if ((i != 0) && (i != 1)) {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          if (i != 101)
          {
            AddFriendLogicActivity.a(this.a, -1, HardCodeUtil.a(2131898119));
            QQToast.makeText(this.a.app.getApplication(), 2131915700, 0).show(this.a.getTitleBarHeight());
            this.a.finish();
            return;
          }
          if (AddFriendLogicActivity.e(this.a) == 1) {
            ThreadManager.post(new AddFriendLogicActivity.3.1(this, (String)localObject), 8, null, true);
          } else if (AddFriendLogicActivity.e(this.a) == 2) {
            ((IPhoneContactService)this.a.app.getRuntimeService(IPhoneContactService.class)).onFriendListChanged();
          }
          if ((this.a.getIntent().getBooleanExtra("webim_qd_ext", false)) && (!TextUtils.isEmpty(paramBundle)))
          {
            paramBundle = new AllInOne(paramBundle, 1);
            localObject = new Intent(this.a, QidianProfileCardActivity.class);
            ((Intent)localObject).putExtra("AllInOne", paramBundle);
            ((Intent)localObject).addFlags(536870912);
            this.a.startActivity((Intent)localObject);
            this.a.setResult(-1);
            this.a.finish();
            return;
          }
          if ((!TextUtils.isEmpty(paramBundle)) && (!"0".equals(paramBundle)))
          {
            paramBundle = new AllInOne(paramBundle, 1);
            paramBundle.profileEntryType = 115;
            localObject = ProfileUtils.getIntent(this.a, paramBundle);
            ((Intent)localObject).putExtra("AllInOne", paramBundle);
            ((Intent)localObject).putExtra("src_name", AddFriendLogicActivity.l(this.a));
            ((Intent)localObject).putExtra("source_id", this.a.getIntent().getIntExtra("source_id", 3999));
            ((Intent)localObject).putExtra("extra", this.a.getIntent().getStringExtra("extra"));
            ((Intent)localObject).addFlags(536870912);
            ((Intent)localObject).addFlags(268435456);
            AddFriendLogicActivity.d = true;
            this.a.startActivity((Intent)localObject);
            this.a.setResult(-1);
            this.a.finish();
            return;
          }
          AddFriendLogicActivity.a(this.a, -1, HardCodeUtil.a(2131898118));
          QQToast.makeText(this.a.app.getApplication(), HardCodeUtil.a(2131898115), 0).show(this.a.getTitleBarHeight());
          this.a.setResult(-1);
          this.a.finish();
        }
      }
      else
      {
        paramBundle = this.a;
        AddFriendLogicActivity.a(paramBundle, -1, paramBundle.getString(2131915651));
        AddFriendLogicActivity.k(this.a);
        return;
      }
    }
    this.a.a(i, localBoolean.booleanValue(), localArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.c(this.a));
    return;
    AddFriendLogicActivity.a(this.a, -1, HardCodeUtil.a(2131898122));
    QQToast.makeText(this.a.app.getApplication(), 2131915700, 0).show(this.a.getTitleBarHeight());
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity.3
 * JD-Core Version:    0.7.0.1
 */