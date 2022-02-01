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
    this.jdField_a_of_type_Int = ApolloLinearLayout.b(this.this$0);
  }
  
  public void run()
  {
    Object localObject1 = ApolloLinearLayout.a(this.this$0);
    if ((localObject1 != null) && (this.jdField_a_of_type_Int == ApolloLinearLayout.a(this.this$0)) && (ApolloLinearLayout.a(this.this$0) != null))
    {
      ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)ApolloLinearLayout.a(this.this$0).getTag();
      if ((localViewHolder != null) && (localViewHolder.a != null))
      {
        if (localViewHolder.a.mAction == null) {
          return;
        }
        this.this$0.b = true;
        ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
        ApolloLinearLayout.a(this.this$0, 2);
        if ((localViewHolder.a != null) && (localViewHolder.a.mType != 1) && (localViewHolder.a.mAction != null))
        {
          localObject1 = this.this$0;
          ((ApolloLinearLayout)localObject1).a(ApolloLinearLayout.a((ApolloLinearLayout)localObject1), localViewHolder.a);
          if ((ApolloLinearLayout.a(this.this$0) != null) && (ApolloLinearLayout.a(this.this$0) != null))
          {
            localObject1 = ApolloLinearLayout.a(this.this$0).a;
            String str = ApolloLinearLayout.a(this.this$0).jdField_a_of_type_JavaLangString;
            int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloLinearLayout.a(this.this$0).jdField_a_of_type_Int);
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localViewHolder.a.mAction.actionId);
            localObject2 = ((StringBuilder)localObject2).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(localViewHolder.a.mPackageId);
            VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "long_press_icon", str, i, 0, new String[] { localObject2, localStringBuilder.toString(), "", String.valueOf(System.currentTimeMillis() / 1000L) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */