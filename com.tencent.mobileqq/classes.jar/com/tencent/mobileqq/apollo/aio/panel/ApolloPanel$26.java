package com.tencent.mobileqq.apollo.aio.panel;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class ApolloPanel$26
  extends ApolloExtensionObserver
{
  ApolloPanel$26(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData, int paramInt) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[showNewActionFloatView] onAuthResponse, result=", Boolean.valueOf(paramBoolean), ", data=", paramObject });
    }
    if (!(paramObject instanceof HashMap))
    {
      QLog.e("[cmshow]ApolloPanel", 1, "[showNewActionFloatView] data is empty! ");
      return;
    }
    paramObject = (HashMap)paramObject;
    Object localObject = (String)paramObject.get("optFrom");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!"newActionFloatView".equals(localObject)) {
        return;
      }
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel).a.removeObserver(this);
      if (paramBoolean)
      {
        ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, 0, 21, this.jdField_a_of_type_Int, null);
        return;
      }
      localObject = new Bundle();
      paramObject = (String)paramObject.get("url");
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanel", 2, new Object[] { "[showNewActionFloatView] onAuthResponse, activityUrl=", paramObject });
      }
      ((Bundle)localObject).putString("activityUrl", paramObject);
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioPanelApolloPanel, this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, 1, 22, this.jdField_a_of_type_Int, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.26
 * JD-Core Version:    0.7.0.1
 */