package com.tencent.mobileqq.apollo.aio;

import android.text.TextUtils;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import org.json.JSONObject;

class ChatPieApolloViewController$4
  implements Runnable
{
  ChatPieApolloViewController$4(ChatPieApolloViewController paramChatPieApolloViewController, BaseChatPie paramBaseChatPie, String paramString, ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, ApolloManagerServiceImpl paramApolloManagerServiceImpl, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ApolloBaseInfo localApolloBaseInfo;
    if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
      localApolloBaseInfo = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getApolloBaseInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_JavaLangString);
    } else {
      localApolloBaseInfo = null;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl.getApolloBaseInfo(this.jdField_a_of_type_JavaLangString);
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((ApolloBaseInfo)localObject1).getApolloPetDress();
      if ((localObject2 != null) && (((ApolloBaseInfo)localObject1).hasPet) && (((ApolloDress)localObject2).dressMap != null) && (!((ApolloDress)localObject2).dressMap.isEmpty()))
      {
        JSONObject localJSONObject = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getPetInfo(((ApolloDress)localObject2).roleId);
        i = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getPetCategory(localJSONObject);
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145_2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "aiopetShow", String.valueOf(i), String.valueOf(((ApolloDress)localObject2).roleId), "0", new String[] { "0" });
        if (!TextUtils.isEmpty(((ApolloBaseInfo)localObject1).petNick)) {
          ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145_2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "aiopetpaiShow", String.valueOf(i), String.valueOf(((ApolloDress)localObject2).roleId), "0", new String[] { "0" });
        }
      }
    }
    if (localApolloBaseInfo != null)
    {
      localObject1 = localApolloBaseInfo.getApolloPetDress();
      if ((localObject1 != null) && (localApolloBaseInfo.hasPet) && (((ApolloDress)localObject1).dressMap != null) && (!((ApolloDress)localObject1).dressMap.isEmpty()))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getPetInfo(((ApolloDress)localObject1).roleId);
        i = this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getPetCategory((JSONObject)localObject2);
        ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145_2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "aiopetShow", String.valueOf(i), String.valueOf(((ApolloDress)localObject1).roleId), "0", new String[] { "1" });
        if (!TextUtils.isEmpty(localApolloBaseInfo.petNick)) {
          ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDC00145_2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "aiopetpaiShow", String.valueOf(i), String.valueOf(((ApolloDress)localObject1).roleId), "0", new String[] { "1" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController.4
 * JD-Core Version:    0.7.0.1
 */