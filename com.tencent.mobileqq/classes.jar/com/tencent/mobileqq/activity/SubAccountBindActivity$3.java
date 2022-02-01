package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountProtocServiceImpl;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
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
    Object localObject1 = paramView.findViewById(2131364592);
    if ((localObject1 == null) || (((View)localObject1).getVisibility() != 0))
    {
      int i = ((Integer)paramView.getTag()).intValue();
      localObject1 = (SimpleAccount)SubAccountBindActivity.access$000(this.a).get(i);
      Object localObject2 = (SubAccountServiceImpl)this.a.app.getRuntimeService(ISubAccountService.class, null);
      if (((SubAccountServiceImpl)localObject2).isSubAccountUin(((SimpleAccount)localObject1).getUin()))
      {
        localObject1 = this.a;
        ((SubAccountBindActivity)localObject1).showQQToastSuccess(((SubAccountBindActivity)localObject1).getString(2131719305));
        SubAccountAssistantForward.a(this.a.app);
        this.a.setTitle("");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra(((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getTabIndex(), FrameControllerUtil.a);
        ((Intent)localObject1).setFlags(67108864);
        RouteUtils.a(this.a, (Intent)localObject1, "/base/start/splash");
        this.a.startActivity((Intent)localObject1);
        this.a.finish();
      }
      else if (((SubAccountServiceImpl)localObject2).getBindedNumber() >= 2)
      {
        SubAccountControllUtil.a(this.a.app, this.a);
      }
      else if (!((SimpleAccount)localObject1).isLogined())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onSelectAccountClick.onClick:add account");
        }
        localObject2 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject2).putExtra("subuin", ((SimpleAccount)localObject1).getUin());
        ((Intent)localObject2).putExtra("fromWhere", this.a.fromWhere);
        this.a.startActivity((Intent)localObject2);
      }
      else if (this.a.isNetConnToast())
      {
        localObject2 = ((SubAccountServiceImpl)localObject2).getA2(((SimpleAccount)localObject1).getUin());
        this.a.showJuhua(2131719307);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = new SubAccountBindActivity.3.1(this, (SimpleAccount)localObject1);
          this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), ((SimpleAccount)localObject1).getUin(), (SubAccountObserver)localObject2);
        }
        else
        {
          SubAccountProtocServiceImpl localSubAccountProtocServiceImpl = (SubAccountProtocServiceImpl)this.a.app.getRuntimeService(ISubAccountProtocService.class, "");
          if (localSubAccountProtocServiceImpl != null) {
            localSubAccountProtocServiceImpl.bindAccount(((SimpleAccount)localObject1).getUin(), (String)localObject2, this.a.fromWhere);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.3
 * JD-Core Version:    0.7.0.1
 */