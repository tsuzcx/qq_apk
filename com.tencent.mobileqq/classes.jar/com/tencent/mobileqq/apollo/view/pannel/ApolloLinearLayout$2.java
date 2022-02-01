package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
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
  extends ApolloExtensionObserverImpl
{
  ApolloLinearLayout$2(ApolloLinearLayout paramApolloLinearLayout) {}
  
  public void d(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    label610:
    for (;;)
    {
      return;
      Object localObject = new ApolloActionData();
      paramObject = (HashMap)paramObject;
      String str = (String)paramObject.get("optFrom");
      if ((!TextUtils.isEmpty(str)) && ("actionPanel".equals(str)))
      {
        int i = Integer.parseInt((String)paramObject.get("id"));
        ((ApolloActionData)localObject).actionId = i;
        localObject = this.a.a((ApolloActionData)localObject);
        if (localObject != null)
        {
          ((ImageView)((View)localObject).findViewById(2131379428)).setVisibility(8);
          ((View)localObject).setClickable(true);
          if (this.a.b.incrementAndGet() == this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
          {
            this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
            this.a.b.set(0);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl);
          }
          if (paramBoolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloLinearLayout", 2, "action auth success actionid=" + i);
            }
            paramObject.put("APOLLO_POP_TYPE", "toast");
            paramObject.put("tips", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690116));
            ((ApolloExtensionHandlerImpl)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 128, "obtained action");
          }
          for (;;)
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
              break label610;
            }
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
            if (localObject == null) {
              break;
            }
            VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_show", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, new String[] { "" + i, "0" });
            localObject = ((MqqHandler)localObject).obtainMessage(45);
            ((Message)localObject).obj = paramObject;
            ((Message)localObject).sendToTarget();
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloLinearLayout", 2, "action auth fail actionid=" + i);
            }
            paramObject.put("APOLLO_POP_TYPE", "dialog");
            paramObject.put("feeType", String.valueOf(6));
            paramObject.put("title", HardCodeUtil.a(2131700539));
            if (TextUtils.isEmpty((String)paramObject.get("content"))) {
              paramObject.put("content", HardCodeUtil.a(2131700538));
            }
            paramObject.put("rightString", HardCodeUtil.a(2131700540));
            paramObject.put("isActionBack", "true");
            paramObject.put("actionId", "" + i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout.2
 * JD-Core Version:    0.7.0.1
 */