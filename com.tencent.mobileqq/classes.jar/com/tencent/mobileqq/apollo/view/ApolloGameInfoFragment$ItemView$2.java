package com.tencent.mobileqq.apollo.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloGameInfoFragment$ItemView$2
  implements View.OnClickListener
{
  ApolloGameInfoFragment$ItemView$2(ApolloGameInfoFragment.ItemView paramItemView) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(ApolloGameInfoFragment.ItemView.a(this.a))) && (!ApolloGameInfoFragment.ItemView.a(this.a).equals("0")))
    {
      QQAppInterface localQQAppInterface = this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      int i = this.a.a.jdField_a_of_type_Int;
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData != null)
      {
        localObject = Integer.toString(this.a.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.gameId);
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_fuwuhao", i, 0, new String[] { localObject });
        localObject = new ActivityURIRequest(this.a.a.getActivity(), "/pubaccount/detail");
        ((ActivityURIRequest)localObject).extra().putString("uin", ApolloGameInfoFragment.ItemView.a(this.a));
        ((ActivityURIRequest)localObject).extra().putInt("uintype", 1008);
        QRoute.startUri((URIRequest)localObject, null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = "";
      break;
      QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[setPubAccountInfo] uin is null or = 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment.ItemView.2
 * JD-Core Version:    0.7.0.1
 */