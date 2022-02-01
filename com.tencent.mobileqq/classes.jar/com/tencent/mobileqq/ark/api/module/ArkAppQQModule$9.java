package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ArkHelper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class ArkAppQQModule$9
  implements Runnable
{
  ArkAppQQModule$9(ArkAppQQModule paramArkAppQQModule, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public void run()
  {
    Object localObject1;
    if (this.a.equals("fullscreen"))
    {
      ArkAppDataReport.a(null, ArkAppQQModule.e(this.this$0), "FullScreenOrH5Show", 0, 0, 0L, 0L, 0L, "", "");
      localObject1 = ArkAppQQModuleBase.f();
      if ((localObject1 instanceof BaseActivity))
      {
        localObject1 = (BaseActivity)localObject1;
        ArkAppDataReport.a(null, ArkAppQQModule.f(this.this$0), "FullScreenOrH5ShowForAI", 0, 0, 0L, 0L, 0L, "", "");
        ArkFullScreenAppActivity.a((Context)localObject1, ArkAppQQModule.g(this.this$0), this.b, "0.0.0.1", this.c, ArkAppCenterUtil.d(), null, 0);
      }
    }
    else
    {
      Object localObject2;
      Object localObject3;
      if (this.a.equals("input"))
      {
        localObject1 = ArkAppQQModuleBase.f();
        if ((localObject1 instanceof BaseActivity))
        {
          localObject1 = ((BaseActivity)localObject1).getChatFragment();
          if (localObject1 != null)
          {
            localObject1 = ((ChatFragment)localObject1).k();
            if (localObject1 != null)
            {
              localObject1 = ((ArkHelper)((BaseChatPie)localObject1).q(110)).e();
              if (localObject1 != null)
              {
                localObject2 = new ArrayList();
                localObject3 = new ArkAiInfo();
                ((ArkAiInfo)localObject3).a = ArkAppQQModule.h(this.this$0);
                ((ArkAiInfo)localObject3).d = ArkAppQQModule.i(this.this$0);
                ((ArkAiInfo)localObject3).e = this.c;
                ((ArkAiInfo)localObject3).b = this.b;
                ((List)localObject2).add(localObject3);
                ((ArkRecommendController)localObject1).a((List)localObject2, 0);
              }
            }
          }
        }
      }
      else if (this.a.equals("popup"))
      {
        localObject1 = ArkAppQQModuleBase.f();
        if ((localObject1 instanceof BaseActivity))
        {
          localObject2 = QQCustomArkDialog.AppInfo.a(ArkAppQQModule.j(this.this$0), this.b, "0.0.0.1", this.c, ArkAppCenterUtil.d(), null, null);
          if (ArkAppQQModule.k(this.this$0) != null)
          {
            localObject3 = (QQCustomDialog)ArkAppQQModule.k(this.this$0).get();
            if ((localObject3 != null) && (((QQCustomDialog)localObject3).isShowing())) {
              ((QQCustomDialog)localObject3).dismiss();
            }
          }
          localObject1 = DialogUtils.b((Context)localObject1, null, (Bundle)localObject2);
          ((QQCustomDialog)localObject1).setNegativeButton(2131887648, null);
          ((QQCustomDialog)localObject1).setPositiveButton(2131892267, null);
          ArkAppQQModule.a(this.this$0, new WeakReference(localObject1));
          ((QQCustomDialog)localObject1).show();
          ArkAppDataReport.a(null, "ShowView", ArkAppQQModule.l(this.this$0), null, ArkAppDataReport.i, 0, 0);
        }
      }
      else if (this.a.equals("card"))
      {
        localObject1 = ark.arkGetContainer(this.d);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("OpenView card container=");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("ArkOpenView", 1, ((StringBuilder)localObject2).toString());
        if (localObject1 != null)
        {
          localObject1 = (ArkAppContainer)ArkAppContainer.a((ark.Container)localObject1).get();
          if (localObject1 != null) {
            ((ArkAppContainer)localObject1).a(this.b, this.c);
          }
        }
      }
      else if (this.a.equals("bottom_card"))
      {
        localObject1 = ArkAppQQModuleBase.f();
        if ((localObject1 instanceof BaseActivity)) {
          ArkFullScreenAppActivity.a((BaseActivity)localObject1, "com.tencent.cmgame.intent", "GameCard", this.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.9
 * JD-Core Version:    0.7.0.1
 */