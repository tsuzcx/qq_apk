package com.tencent.mobileqq.apollo.aio.panel;

import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.HorizontalListView;
import java.util.Iterator;
import java.util.List;

class ApolloPanel$11
  implements Runnable
{
  ApolloPanel$11(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((ApolloPanel.s(this.this$0) != null) && (ApolloPanel.t(this.this$0) != null))
    {
      if (ApolloPanel.u(this.this$0) == null) {
        return;
      }
      ApolloPanel.s(this.this$0).a(this.a);
      int i;
      if ((ApolloPanel.o(this.this$0) != null) && (ApolloPanel.o(this.this$0).a == 1036)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        ApolloPanel.t(this.this$0).setVisibility(8);
      } else {
        ApolloPanel.t(this.this$0).setVisibility(0);
      }
      ApolloPanel.u(this.this$0).setVisibility(0);
      ApolloPanel.s(this.this$0).notifyDataSetChanged();
      if (ApolloPanel.g(this.this$0) != null)
      {
        if (ApolloPanel.g(this.this$0).ah == null) {
          return;
        }
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)localIterator.next();
          if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate)) {
            VipUtils.a(ApolloPanel.g(this.this$0).d, "cmshow", "Apollo", "tabreddot", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloPanel.o(this.this$0).a), 0, new String[] { String.valueOf(localApolloActionPackage.packageId) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.11
 * JD-Core Version:    0.7.0.1
 */