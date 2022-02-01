package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ApolloViewBinder$1
  implements AbsListView.OnScrollListener
{
  ApolloViewBinder$1(ApolloViewBinder paramApolloViewBinder) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return;
      }
      ApolloViewBinder.a(this.a, paramAbsListView.getFirstVisiblePosition());
      return;
    }
    int i = paramAbsListView.getFirstVisiblePosition();
    paramInt = -1;
    if (i > ApolloViewBinder.a(this.a)) {
      paramInt = 0;
    } else if (ApolloViewBinder.a(this.a) > i) {
      paramInt = 1;
    }
    if ((paramInt >= 0) && (this.a.m != null))
    {
      VipUtils.a(this.a.j, "cmshow", "Apollo", "slideupdown", "", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.a.m.a), this.a.n, new String[] { String.valueOf(paramInt) });
      if (this.a.n == 9) {
        VipUtils.a(this.a.j, "cmshow", "Apollo", "y_bqtabupdown", "", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.a.m.a), 0, new String[] { "" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder.1
 * JD-Core Version:    0.7.0.1
 */