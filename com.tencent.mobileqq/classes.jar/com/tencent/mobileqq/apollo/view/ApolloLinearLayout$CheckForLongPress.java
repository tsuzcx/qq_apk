package com.tencent.mobileqq.apollo.view;

import android.view.View;
import android.view.ViewParent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;

class ApolloLinearLayout$CheckForLongPress
  implements Runnable
{
  private int a;
  
  ApolloLinearLayout$CheckForLongPress(ApolloLinearLayout paramApolloLinearLayout) {}
  
  public void a()
  {
    this.a = ApolloLinearLayout.f(this.this$0);
  }
  
  public void run()
  {
    Object localObject1 = ApolloLinearLayout.a(this.this$0);
    if ((localObject1 != null) && (this.a == ApolloLinearLayout.b(this.this$0)) && (ApolloLinearLayout.c(this.this$0) != null))
    {
      ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)ApolloLinearLayout.c(this.this$0).getTag();
      if ((localViewHolder != null) && (localViewHolder.j != null))
      {
        if (localViewHolder.j.mAction == null) {
          return;
        }
        this.this$0.h = true;
        ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
        ApolloLinearLayout.a(this.this$0, 2);
        if ((localViewHolder.j != null) && (localViewHolder.j.mType != 1) && (localViewHolder.j.mAction != null))
        {
          localObject1 = this.this$0;
          ((ApolloLinearLayout)localObject1).a(ApolloLinearLayout.c((ApolloLinearLayout)localObject1), localViewHolder.j);
          if ((ApolloLinearLayout.d(this.this$0) != null) && (ApolloLinearLayout.e(this.this$0) != null))
          {
            localObject1 = ApolloLinearLayout.d(this.this$0).d;
            String str = ApolloLinearLayout.e(this.this$0).b;
            int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloLinearLayout.e(this.this$0).a);
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localViewHolder.j.mAction.actionId);
            localObject2 = ((StringBuilder)localObject2).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(localViewHolder.j.mPackageId);
            VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "long_press_icon", str, i, 0, new String[] { localObject2, localStringBuilder.toString(), "", String.valueOf(System.currentTimeMillis() / 1000L) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */