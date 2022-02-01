package com.tencent.mobileqq.addfriend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AddFriendCheckFragment$8
  extends FriendObserver
{
  AddFriendCheckFragment$8(AddFriendCheckFragment paramAddFriendCheckFragment) {}
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (AddFriendCheckFragment.b(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [uin:%s, isSuc:%s, type:%s, status:%s]", new Object[] { Utils.i(String.valueOf(paramLong)), Boolean.valueOf(paramBoolean), Integer.valueOf(AddFriendCheckFragment.k(this.a)), Integer.valueOf(paramInt) }));
    }
    if ((AddFriendCheckFragment.k(this.a) == 1) && (String.valueOf(paramLong).equals(AddFriendCheckFragment.g(this.a))))
    {
      if ((paramBoolean) && (paramInt != 0))
      {
        AddFriendCheckFragment.a(this.a, false);
        AddFriendCheckFragment.a(this.a, paramInt);
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).checkUpdate(AddFriendCheckFragment.f(this.a), "SecWarningCfg");
        try
        {
          AddFriendCheckFragment.a(this.a, DialogUtil.a(this.a.getActivity(), 230, "", "", this.a.d, this.a.e));
          AddFriendCheckFragment.m(this.a);
          Window localWindow = AddFriendCheckFragment.n(this.a).getWindow();
          if (localWindow != null)
          {
            WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
            if ((QLog.isColorLevel()) && (localLayoutParams != null)) {
              QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [%s, %s, %s]", new Object[] { Float.valueOf(localLayoutParams.dimAmount), Integer.valueOf(localLayoutParams.flags), Integer.valueOf(localLayoutParams.flags & 0x2) }));
            }
            localWindow.setDimAmount(0.5F);
            localWindow.addFlags(2);
          }
          AddFriendCheckFragment.n(this.a).show();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        ReportController.b(AddFriendCheckFragment.f(this.a), "P_CliOper", "Safe_AntiFraud", AddFriendCheckFragment.f(this.a).getCurrentAccountUin(), "AlertDialog", "Display", 0, AddFriendCheckFragment.e(this.a), "", "", "", "");
        return;
      }
      AddFriendCheckFragment.c(this.a);
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (AddFriendCheckFragment.b(this.a)) {
      return;
    }
    if ((AddFriendCheckFragment.i(this.a) == 3024) && (AddFriendCheckFragment.o(this.a) == 0))
    {
      paramString = BaseApplication.getContext();
      int i;
      if (paramBoolean1) {
        i = 2131916262;
      } else {
        i = 2131915702;
      }
      QQToast.makeText(paramString, i, 0).show(this.a.getQBaseActivity().getTitleBarHeight());
      this.a.getActivity().finish();
    }
  }
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
  {
    if (AddFriendCheckFragment.b(this.a)) {
      return;
    }
    Object localObject = paramBundle.getString("uin");
    if (!AddFriendCheckFragment.g(this.a).equals(localObject)) {
      return;
    }
    int i = paramBundle.getInt("random_key");
    if ((i != 0) && (i != AddFriendCheckFragment.h(this.a))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format("onUpdateAddFriendSetting [uin:%s, key:%s, isSuc:%s]", new Object[] { Utils.i((String)localObject), Integer.valueOf(i), Boolean.valueOf(paramBoolean) }));
    }
    AddFriendCheckFragment.a(this.a, false);
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
      label161:
      break label161;
    }
    paramBundle = null;
    if ((localBoolean.booleanValue()) && (i != 0))
    {
      if (AddFriendCheckFragment.i(this.a) == 3006) {
        this.a.getActivity().getIntent().putExtra("sub_source_id", 2);
      }
      this.a.a(i, localBoolean.booleanValue(), localArrayList, AddFriendCheckFragment.i(this.a));
      return;
    }
    if ((i != 0) && (i != 1)) {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          if (i != 101)
          {
            AddFriendCheckFragment.a(this.a, -1, HardCodeUtil.a(2131915700));
            QQToast.makeText(BaseApplication.getContext(), 2131915700, 0).show(this.a.getQBaseActivity().getTitleBarHeight());
            this.a.getActivity().finish();
            return;
          }
          if (AddFriendCheckFragment.k(this.a) == 1) {
            ThreadManager.post(new AddFriendCheckFragment.8.1(this, (String)localObject), 8, null, true);
          } else if (AddFriendCheckFragment.k(this.a) == 2) {
            ((IPhoneContactService)AddFriendCheckFragment.f(this.a).getRuntimeService(IPhoneContactService.class, "")).onFriendListChanged();
          }
          if ((this.a.getActivity().getIntent().getBooleanExtra("webim_qd_ext", false)) && (!TextUtils.isEmpty(paramBundle)))
          {
            ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).jumpToQidianProfile(paramBundle, this.a.getActivity());
            this.a.getActivity().setResult(-1);
            this.a.getActivity().finish();
            return;
          }
          if ((!TextUtils.isEmpty(paramBundle)) && (!"0".equals(paramBundle)))
          {
            localObject = this.a;
            ((AddFriendCheckFragment)localObject).a(paramBundle, AddFriendCheckFragment.l((AddFriendCheckFragment)localObject), this.a.getActivity());
            AddFriendCheckFragment.a(true);
            this.a.getActivity().setResult(-1);
            this.a.getActivity().finish();
            return;
          }
          paramBundle = this.a;
          AddFriendCheckFragment.a(paramBundle, -1, paramBundle.getString(2131886641));
          QQToast.makeText(BaseApplication.getContext(), this.a.getString(2131886641), 0).show(this.a.getQBaseActivity().getTitleBarHeight());
          this.a.getActivity().setResult(-1);
          this.a.getActivity().finish();
        }
      }
      else
      {
        paramBundle = this.a;
        AddFriendCheckFragment.a(paramBundle, -1, paramBundle.getString(2131915651));
        AddFriendCheckFragment.j(this.a);
        return;
      }
    }
    this.a.a(i, localBoolean.booleanValue(), localArrayList, AddFriendCheckFragment.i(this.a));
    return;
    AddFriendCheckFragment.a(this.a, -1, HardCodeUtil.a(2131915700));
    QQToast.makeText(BaseApplication.getContext(), 2131915700, 0).show(this.a.getQBaseActivity().getTitleBarHeight());
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.8
 * JD-Core Version:    0.7.0.1
 */