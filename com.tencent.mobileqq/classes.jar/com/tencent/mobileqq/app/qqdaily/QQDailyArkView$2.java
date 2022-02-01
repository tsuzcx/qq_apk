package com.tencent.mobileqq.app.qqdaily;

import android.view.View;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QQDailyArkView$2
  implements WrappedArkView.OnArkViewLoadListener
{
  QQDailyArkView$2(QQDailyArkView paramQQDailyArkView) {}
  
  public void a()
  {
    if (QQDailyArkView.a(this.a) == null) {
      return;
    }
    QQDailyArkView.b(this.a);
    QQDailyArkView.a(this.a).setVisibility(0);
    View localView = QQDailyArkView.a(this.a).findViewById(2131370360);
    QQDailyArkView localQQDailyArkView = this.a;
    QQDailyArkView.a(localQQDailyArkView, QQDailyArkView.a(localQQDailyArkView), 0);
    this.a.requestLayout();
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, ArkViewModel paramArkViewModel)
  {
    if (QQDailyArkView.a(this.a) == null) {
      return;
    }
    if ((paramArkViewModel != null) && (paramArkViewModel.GetAppScriptType() == 2) && (!((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isJSCLibExist()))
    {
      QLog.i("QQDailyArkView", 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
      a();
      return;
    }
    paramString = QQDailyArkView.a(this.a);
    if (paramBoolean) {
      paramString.setOnClickListener(new QQDailyArkView.2.1(this, paramArkViewModel));
    } else {
      paramString.setOnClickListener(null);
    }
    QQDailyArkView.b(this.a);
    paramString.setVisibility(0);
    paramArkViewModel = paramString.findViewById(2131370360);
    QQDailyArkView.a(this.a, paramString, 0);
    this.a.requestLayout();
    if (paramArkViewModel != null) {
      paramArkViewModel.setVisibility(4);
    }
  }
  
  public void b()
  {
    if (QQDailyArkView.a(this.a) == null) {
      return;
    }
    QQDailyArkView.a(this.a).setVisibility(8);
    QQDailyArkView localQQDailyArkView = this.a;
    QQDailyArkView.a(localQQDailyArkView, QQDailyArkView.a(localQQDailyArkView), 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyArkView.2
 * JD-Core Version:    0.7.0.1
 */