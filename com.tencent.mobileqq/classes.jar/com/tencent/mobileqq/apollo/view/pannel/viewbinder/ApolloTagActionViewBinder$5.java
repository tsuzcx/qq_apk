package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ApolloTagActionViewBinder$5
  extends ApolloExtensionObserverImpl
{
  ApolloTagActionViewBinder$5(ApolloTagActionViewBinder paramApolloTagActionViewBinder) {}
  
  public void b(int paramInt, List<Integer> paramList)
  {
    QLog.d("ApolloActionWithTagsViewBinder", 1, "[onGetApolloActionUsedList]  actionIdList :" + paramList + " pkgId : " + paramInt);
    ArrayList localArrayList;
    try
    {
      if (this.a.d == paramInt)
      {
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label190;
        }
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramInt = ((Integer)paramList.next()).intValue();
          Iterator localIterator = ApolloTagActionViewBinder.d(this.a).iterator();
          while (localIterator.hasNext())
          {
            ApolloInfo localApolloInfo = (ApolloInfo)localIterator.next();
            if ((localApolloInfo != null) && (paramInt == localApolloInfo.mAction.actionId)) {
              localArrayList.add(localApolloInfo);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("ApolloActionWithTagsViewBinder", 1, paramList, new Object[0]);
    }
    ThreadManagerV2.getUIHandlerV2().post(new ApolloTagActionViewBinder.5.1(this, localArrayList));
    return;
    label190:
    if (ApolloTagActionViewBinder.a(this.a) == null)
    {
      paramList = new TextView(this.a.jdField_a_of_type_AndroidContentContext);
      paramList.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      if (this.a.d != 9) {
        break label364;
      }
      paramList.setText(2131690160);
    }
    for (;;)
    {
      paramList.setTextSize(14.0F);
      paramList.setTextColor(Color.parseColor("#B0B3BF"));
      paramList.setGravity(17);
      paramList.setHeight(this.a.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.getHeight() - ApolloTagActionViewBinder.a(this.a).getHeight());
      ApolloTagActionViewBinder.a(this.a, paramList);
      ApolloTagActionViewBinder.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListView.addHeaderView(ApolloTagActionViewBinder.a(this.a));
      paramList = new ArrayList();
      this.a.b(paramList);
      this.a.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelListAdapter.notifyDataSetChanged();
      QLog.d("ApolloActionWithTagsViewBinder", 1, "[onGetApolloActionUsedList] ActionUsedList is empty.");
      return;
      label364:
      paramList.setText(2131690159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.5
 * JD-Core Version:    0.7.0.1
 */