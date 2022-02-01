package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;

class ApolloPanel$29$2$1
  implements Runnable
{
  ApolloPanel$29$2$1(ApolloPanel.29.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.a)
    {
      QQToast.makeText(this.b.a.a.getContext(), 1, "开启厘米秀失败！", 0).show(0);
      if ((ApolloPanel.g(this.b.a.a) != null) && (ApolloPanel.o(this.b.a.a) != null))
      {
        VipUtils.a(ApolloPanel.g(this.b.a.a).d, "cmshow", "Apollo", "openshow_tips_fail", ApolloPanel.o(this.b.a.a).b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloPanel.g(this.b.a.a).F()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        ApolloPanel.a(this.b.a.a, "panel_tips", "fail");
      }
      return;
    }
    QQToast.makeText(this.b.a.a.getContext(), 2, "开启厘米秀成功！", 0).show(0);
    ApolloPanel.O(this.b.a.a);
    this.b.a.a.i();
    if ((ApolloPanel.g(this.b.a.a) != null) && (ApolloPanel.o(this.b.a.a) != null))
    {
      VipUtils.a(ApolloPanel.g(this.b.a.a).d, "cmshow", "Apollo", "openshow_tips_suc", ApolloPanel.o(this.b.a.a).b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloPanel.g(this.b.a.a).F()), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      ApolloPanel.a(this.b.a.a, "panel_tips", "success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.29.2.1
 * JD-Core Version:    0.7.0.1
 */