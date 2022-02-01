package com.tencent.mobileqq.app.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.open.agent.report.ReportCenter;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.observer.AccountObserver;

final class GetOpenID$1
  extends AccountObserver
{
  GetOpenID$1(String paramString, BaseMessageHandler paramBaseMessageHandler) {}
  
  public void onChangeToken(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap = (RespondCustomSig)paramHashMap.get("login.chgTok");
      if (paramHashMap != null)
      {
        if (paramHashMap.SigList == null) {
          return;
        }
        int i = 0;
        while (i < paramHashMap.SigList.size())
        {
          Object localObject = (CustomSigContent)paramHashMap.SigList.get(i);
          if ((((CustomSigContent)localObject).sResult == 0) && (((CustomSigContent)localObject).ulSigType == 16L))
          {
            localObject = new String(((CustomSigContent)localObject).SigContent);
            OpenID localOpenID = new OpenID();
            localOpenID.appID = this.jdField_a_of_type_JavaLangString;
            localOpenID.openID = ((String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().persistOrReplace(localOpenID);
            ((MessageCache)this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getMsgCache()).a(this.jdField_a_of_type_JavaLangString, localOpenID);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.notifyUI(1, true, localOpenID);
          }
          i += 1;
        }
      }
      return;
    }
    if (paramBoolean) {
      paramHashMap = "0";
    } else {
      paramHashMap = "1";
    }
    ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a().getAccount(), "", this.jdField_a_of_type_JavaLangString, "41", "19", paramHashMap, "", "", "4", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.GetOpenID.1
 * JD-Core Version:    0.7.0.1
 */