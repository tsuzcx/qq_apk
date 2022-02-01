package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FraudTipsBar$2
  implements View.OnClickListener
{
  FraudTipsBar$2(FraudTipsBar paramFraudTipsBar, int paramInt) {}
  
  public void onClick(View paramView)
  {
    FraudTipsBar.a(this.b, 2);
    FraudTipsBar.a(this.b).c();
    ReportController.b(FraudTipsBar.c(this.b), "P_CliOper", "Safe_AntiFraud", FraudTipsBar.d(this.b).b, "banner", "userclick", this.a, 0, "", "", "", "");
    Object localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerURL", 146, this.a);
    if (localObject1 != null) {
      localObject1 = ((Bundle)localObject1).getString("BannerURL");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "https://jubao.qq.com/cn/jubao?appname=KQQ&subapp=$SUBAPP$&jubaotype=uin&system=$SYSTEM$&eviluin=$EVILUIN$&impeachuin=$USERUIN$";
    }
    if (this.a == 1) {
      localObject1 = ((String)localObject2).replace("$SUBAPP$", "notice");
    } else {
      localObject1 = ((String)localObject2).replace("$SUBAPP$", "tips");
    }
    localObject1 = ((String)localObject1).replace("$SYSTEM$", "android").replace("$EVILUIN$", FraudTipsBar.d(this.b).b).replace("$USERUIN$", FraudTipsBar.c(this.b).getAccount());
    localObject2 = BaseActivity.sTopActivity;
    Intent localIntent = new Intent((Context)localObject2, QQBrowserDelegationActivity.class);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("url", (String)localObject1);
    ((Context)localObject2).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FraudTipsBar.2
 * JD-Core Version:    0.7.0.1
 */