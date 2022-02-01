package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.profile.diy.VipProfileDiyCardConfig;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;

public class GetSelfPendantId
  extends AsyncStep
{
  private String a()
  {
    if ((this.a.a.getAccount() != null) && (this.a.a.isLogin())) {
      return this.a.a.getAccount();
    }
    return "0";
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetSelfPendantId", 2, "doStep");
    }
    IndividuationUrlHelper.a(this.a.a);
    PraiseConfigHelper.a(this.a.a);
    VipProfileDiyCardConfig.a(this.a.a);
    IApolloExtensionHandler localIApolloExtensionHandler = (IApolloExtensionHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    localIApolloExtensionHandler.a(new String[] { a() }, new int[] { 27201, 27025, 40530, 20059, 27041, 27217, 27225, 27224, 42122, 42121, 27234, 27235, 27236, 27238, 45000, 42334, 27373, 27241 });
    localIApolloExtensionHandler.a(new String[] { a() }, new int[] { 27375, 42417, 42489 }, 22);
    this.a.a.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfPendantId
 * JD-Core Version:    0.7.0.1
 */