package com.tencent.mobileqq.ark;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkAdapterItemForTextMsg$2
  implements View.OnClickListener
{
  ArkAdapterItemForTextMsg$2(ArkAdapterItemForTextMsg paramArkAdapterItemForTextMsg, ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter) {}
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqArkArkAdapterItemForTextMsg.a.mArkContainer.getAppName();
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(str, new ArkAdapterItemForTextMsg.2.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg.2
 * JD-Core Version:    0.7.0.1
 */