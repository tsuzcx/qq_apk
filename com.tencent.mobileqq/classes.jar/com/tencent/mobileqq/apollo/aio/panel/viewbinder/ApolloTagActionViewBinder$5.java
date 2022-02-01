package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListView;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ApolloTagActionViewBinder$5
  extends ApolloExtensionObserver
{
  ApolloTagActionViewBinder$5(ApolloTagActionViewBinder paramApolloTagActionViewBinder) {}
  
  protected void a(int paramInt, List<Integer> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onGetApolloActionUsedList]  actionIdList :");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(" pkgId : ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("[cmshow]ApolloActionWithTagsViewBinder", 1, ((StringBuilder)localObject).toString());
    try
    {
      if (this.a.n != paramInt) {
        return;
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        localObject = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramInt = ((Integer)paramList.next()).intValue();
          Iterator localIterator = ApolloTagActionViewBinder.e(this.a).iterator();
          while (localIterator.hasNext())
          {
            ApolloInfo localApolloInfo = (ApolloInfo)localIterator.next();
            if ((localApolloInfo != null) && (paramInt == localApolloInfo.mAction.actionId)) {
              ((List)localObject).add(localApolloInfo);
            }
          }
        }
        ThreadManagerV2.getUIHandlerV2().post(new ApolloTagActionViewBinder.5.1(this, (List)localObject));
        return;
      }
      if (ApolloTagActionViewBinder.h(this.a) == null)
      {
        paramList = new TextView(this.a.i);
        paramList.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        if (this.a.n == 9) {
          paramList.setText(2131886732);
        } else {
          paramList.setText(2131886731);
        }
        paramList.setTextSize(14.0F);
        paramList.setTextColor(Color.parseColor("#B0B3BF"));
        paramList.setGravity(17);
        paramList.setHeight(this.a.r.getHeight() - ApolloTagActionViewBinder.i(this.a).getHeight());
        ApolloTagActionViewBinder.a(this.a, paramList);
      }
      ApolloTagActionViewBinder.h(this.a).setVisibility(0);
      this.a.r.addHeaderView(ApolloTagActionViewBinder.h(this.a));
      paramList = new ArrayList();
      ApolloTagActionViewBinder.b(this.a, paramList);
      QLog.d("[cmshow]ApolloActionWithTagsViewBinder", 1, "[onGetApolloActionUsedList] ActionUsedList is empty.");
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("[cmshow]ApolloActionWithTagsViewBinder", 1, paramList, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.5
 * JD-Core Version:    0.7.0.1
 */