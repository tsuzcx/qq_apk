package com.tencent.mobileqq.activity.pendant;

import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AvatarPendantActivity$29$1
  implements Runnable
{
  AvatarPendantActivity$29$1(AvatarPendantActivity.29 param29, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    AvatarPendantActivity.k(this.c.b).setVisibility(8);
    AvatarPendantActivity.j(this.c.b).setEnabled(true);
    if (this.a)
    {
      QQToast.makeText(this.c.b, 2, 2131917774, 0).show(this.c.b.getTitleBarHeight());
      AvatarPendantActivity.l(this.c.b);
      int i = ((IApolloManagerService)this.c.b.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.c.b.app.getCurrentUin());
      ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("avatarQQPage", "successSet", "expose", new DtReportParamsBuilder().a(((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(this.c.b.app)).f(String.valueOf(this.c.a.getActionId())).f(i).a());
      return;
    }
    QQToast.makeText(this.c.b, 1, 2131916287, 0).show(this.c.b.getTitleBarHeight());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnProcessFinishListener avatar video process error! actionId: ");
    localStringBuilder.append(this.b);
    QLog.e("AvatarPendantActivity", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.29.1
 * JD-Core Version:    0.7.0.1
 */