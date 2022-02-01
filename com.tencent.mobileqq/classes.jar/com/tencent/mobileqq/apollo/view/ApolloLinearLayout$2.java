package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

class ApolloLinearLayout$2
  extends ApolloExtensionObserver
{
  ApolloLinearLayout$2(ApolloLinearLayout paramApolloLinearLayout) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((ApolloLinearLayout.a(this.a) != null) && (ApolloLinearLayout.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (ApolloLinearLayout.a(this.a) == null) {
        return;
      }
      Object localObject1 = new ApolloActionData();
      paramObject = (HashMap)paramObject;
      Object localObject2 = (String)paramObject.get("optFrom");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!"actionPanel".equals(localObject2)) {
          return;
        }
        int i = Integer.parseInt((String)paramObject.get("id"));
        ((ApolloActionData)localObject1).actionId = i;
        localObject1 = this.a.a((ApolloActionData)localObject1);
        if (localObject1 == null) {
          return;
        }
        ((ImageView)((View)localObject1).findViewById(2131378780)).setVisibility(8);
        ((View)localObject1).setClickable(true);
        if (ApolloLinearLayout.a(this.a).incrementAndGet() == ApolloLinearLayout.b(this.a).get())
        {
          ApolloLinearLayout.b(this.a).set(0);
          ApolloLinearLayout.a(this.a).set(0);
          ApolloLinearLayout.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.a);
        }
        if (paramBoolean)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("action auth success actionid=");
            ((StringBuilder)localObject1).append(i);
            QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject1).toString());
          }
          paramObject.put("APOLLO_POP_TYPE", "toast");
          paramObject.put("tips", ApolloLinearLayout.a(this.a).jdField_a_of_type_AndroidContentContext.getString(2131690033));
          ((ApolloExtensionHandler)ApolloLinearLayout.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(ApolloLinearLayout.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 128L, "obtained action");
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("action auth fail actionid=");
            ((StringBuilder)localObject1).append(i);
            QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject1).toString());
          }
          paramObject.put("APOLLO_POP_TYPE", "dialog");
          paramObject.put("feeType", String.valueOf(6));
          paramObject.put("title", HardCodeUtil.a(2131700680));
          if (TextUtils.isEmpty((String)paramObject.get("content"))) {
            paramObject.put("content", HardCodeUtil.a(2131700679));
          }
          paramObject.put("rightString", HardCodeUtil.a(2131700681));
          paramObject.put("isActionBack", "true");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(i);
          paramObject.put("actionId", ((StringBuilder)localObject1).toString());
        }
        if ((ApolloLinearLayout.a(this.a) != null) && (ApolloLinearLayout.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          localObject1 = ApolloLinearLayout.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
          if (localObject1 != null)
          {
            localObject2 = ApolloLinearLayout.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            int j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(ApolloLinearLayout.a(this.a).a);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(i);
            VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "activity_alert_show", j, 0, new String[] { localStringBuilder.toString(), "0" });
            localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
            ((Message)localObject1).obj = paramObject;
            ((Message)localObject1).sendToTarget();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout.2
 * JD-Core Version:    0.7.0.1
 */