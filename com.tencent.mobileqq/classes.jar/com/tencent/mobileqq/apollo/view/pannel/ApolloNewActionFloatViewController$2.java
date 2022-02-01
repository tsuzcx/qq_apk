package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloNewActionFloatViewController$2
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$2(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, Bundle paramBundle, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if ((ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController) != null) && (ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController).a != null))
    {
      Object localObject1 = null;
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("activityUrl");
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData.url;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloNewActionFloatViewController", 2, new Object[] { "[realshowNewActionFloatView] btn click, activityUrl=", localObject2 });
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new Intent(ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController).a, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController).a.startActivity((Intent)localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController.a();
      ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloNewActionFloatViewController, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData, "action_flame_clickgain");
      ApolloTianshuReportUtil.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloNewActionFloatViewController.2
 * JD-Core Version:    0.7.0.1
 */