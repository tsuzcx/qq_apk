package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.SubAccountObserver;

class SubAccountBindActivity$3
  implements View.OnClickListener
{
  SubAccountBindActivity$3(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.findViewById(2131364705);
    if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      localObject1 = (SimpleAccount)SubAccountBindActivity.a(this.a).get(i);
      Object localObject2 = (SubAccountManager)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (((SubAccountManager)localObject2).a(((SimpleAccount)localObject1).getUin()))
      {
        this.a.c(this.a.getString(2131719586));
        SubAccountAssistantForward.a(this.a.app);
        this.a.setTitle("");
        localObject1 = new Intent(this.a, SplashActivity.class);
        ((Intent)localObject1).putExtra("tab_index", FrameControllerUtil.a);
        ((Intent)localObject1).setFlags(67108864);
        this.a.startActivity((Intent)localObject1);
        this.a.finish();
      }
      else if (((SubAccountManager)localObject2).a() >= 2)
      {
        SubAccountControll.a(this.a.app, this.a);
      }
      else if (!((SimpleAccount)localObject1).isLogined())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onSelectAccountClick.onClick:add account");
        }
        localObject2 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject2).putExtra("subuin", ((SimpleAccount)localObject1).getUin());
        ((Intent)localObject2).putExtra("fromWhere", this.a.b);
        this.a.startActivity((Intent)localObject2);
      }
      else if (this.a.c())
      {
        localObject2 = ((SubAccountManager)localObject2).a(((SimpleAccount)localObject1).getUin());
        this.a.a(2131719588);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new SubAccountBindActivity.3.1(this, (SimpleAccount)localObject1);
          this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), ((SimpleAccount)localObject1).getUin(), (SubAccountObserver)localObject2);
        }
        else
        {
          SubAccountProtocManager localSubAccountProtocManager = (SubAccountProtocManager)this.a.app.getManager(QQManagerFactory.MGR_SUB_ACNT);
          if (localSubAccountProtocManager != null) {
            localSubAccountProtocManager.a(((SimpleAccount)localObject1).getUin(), (String)localObject2, this.a.b);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.3
 * JD-Core Version:    0.7.0.1
 */