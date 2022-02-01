package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ApolloNewActionFloatViewController$2
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$2(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, Bundle paramBundle, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if ((ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController) != null) && (ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController).a != null))
    {
      paramView = null;
      Object localObject = this.jdField_a_of_type_AndroidOsBundle;
      if (localObject != null) {
        paramView = ((Bundle)localObject).getString("activityUrl");
      }
      localObject = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.url;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloNewActionFloatViewController", 2, new Object[] { "[realshowNewActionFloatView] btn click, activityUrl=", localObject });
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramView = new Intent(ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController).a, QQBrowserActivity.class);
        paramView.putExtra("url", (String)localObject);
        ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController).a.startActivity(paramView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController.a();
      ApolloNewActionFloatViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloNewActionFloatViewController, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, "action_flame_clickgain");
      ApolloTianshuReportUtil.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController.2
 * JD-Core Version:    0.7.0.1
 */