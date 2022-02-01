package com.tencent.mobileqq.apollo.api.profilecard.impl;

import SummaryCard.QQApolloInfo;
import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ApolloProfileBusinessProcessor
  extends AbsProfileBusinessProcessor
{
  private ApolloProfileBusinessProcessor.ProfileApolloInfo a;
  
  public ApolloProfileBusinessProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(RespSummaryCard paramRespSummaryCard, String paramString)
  {
    Object localObject = (IApolloManagerService)this.appRuntime.getRuntimeService(IApolloManagerService.class, "all");
    if (paramRespSummaryCard.stApollo != null)
    {
      localApolloBaseInfo = ((IApolloManagerService)localObject).getApolloBaseInfo(paramString);
      localApolloBaseInfo.apolloVipFlag = ((int)paramRespSummaryCard.stApollo.uVipFlag);
      localApolloBaseInfo.apolloVipLevel = ((int)paramRespSummaryCard.stApollo.uVipLevel);
      localApolloBaseInfo.apolloStatus = ((int)paramRespSummaryCard.stApollo.uUserFlag);
      localApolloBaseInfo.apolloServerTS = paramRespSummaryCard.stApollo.uTimestamp;
      ((IApolloManagerService)localObject).saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloProfileBusinessProcessor", 2, "summaryCard upadte apolloBaseInfo uin: " + paramString + ", apollo vipFlag: " + localApolloBaseInfo.apolloVipFlag + ", apollo vipLevel: " + localApolloBaseInfo.apolloVipLevel + ", apollo status: " + localApolloBaseInfo.apolloStatus + ", apollo svr TS: " + localApolloBaseInfo.apolloServerTS + ", apollo local TS: " + localApolloBaseInfo.apolloLocalTS);
      }
      if (localApolloBaseInfo.apolloServerTS != localApolloBaseInfo.apolloLocalTS)
      {
        paramRespSummaryCard = (IApolloExtensionHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (paramRespSummaryCard == null) {}
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        ApolloBaseInfo localApolloBaseInfo;
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(paramString)));
        paramRespSummaryCard.a((ArrayList)localObject, "summaryCard");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloProfileBusinessProcessor", 2, "summaryCard update user apollo dress uin: " + paramString.substring(0, 4));
        }
        return;
      }
      catch (Exception paramRespSummaryCard)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ApolloProfileBusinessProcessor", 2, "summaryCard update user apollo dress uin: " + paramRespSummaryCard.getMessage());
        return;
      }
    }
    QLog.e("ApolloProfileBusinessProcessor", 2, "CardHandle apollo field is null");
  }
  
  public void onGetProfileDetailResponseBegin(Bundle paramBundle)
  {
    super.onGetProfileDetailResponseBegin(paramBundle);
    this.a = null;
  }
  
  public void onGetProfileDetailTLV(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    super.onGetProfileDetailTLV(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    switch (paramShort1)
    {
    default: 
      return;
    case -23533: 
      i = paramByteBuffer.getShort();
      if (i != this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloVipFlag)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloVipFlag = i;
        this.a.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloProfileBusinessProcessor", 1, "handleGetDetalInfo apollo vip flag: " + i);
      return;
    case -23537: 
      i = paramByteBuffer.getShort();
      if (i != this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloVipLevel)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloVipLevel = i;
        this.a.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloProfileBusinessProcessor", 1, "handleGetDetalInfo apollo vip level: " + i);
      return;
    case -22556: 
      i = paramByteBuffer.getShort();
      if (i != this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloStatus)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloStatus = i;
        this.a.jdField_a_of_type_Boolean = true;
        paramBundle = (IApolloExtensionHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (paramBundle != null)
        {
          paramCard = new Pair(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.uin, Integer.valueOf(i));
          ((BusinessHandler)paramBundle).notifyUI(3, true, paramCard);
        }
      }
      QLog.i("ApolloProfileBusinessProcessor", 1, "handleGetDetalInfo apollo status flag: " + i);
      return;
    case 27059: 
      paramLong = paramByteBuffer.getInt();
      if (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloServerTS)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloServerTS = paramLong;
        this.a.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloProfileBusinessProcessor", 1, "handleGetDetalInfo apollo svr TS: " + paramLong + ",local TS: " + this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloServerTS);
      return;
    case -23306: 
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 != this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.cmshow3dFlag)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.cmshow3dFlag = paramShort1;
        this.a.jdField_a_of_type_Boolean = true;
      }
      QLog.d("ApolloProfileBusinessProcessor", 1, new Object[] { "handleGetDetalInfo apollo svr cmshow3dFlag: ", Short.valueOf(paramShort1), ", local cmshow3dFlag: ", Integer.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.cmshow3dFlag) });
      return;
    case 27206: 
      paramLong = paramByteBuffer.getInt();
      long l = NetConnInfoCenter.getServerTime();
      if ((paramLong < l) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloSignValidTS != paramLong))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloLocalSignTs = this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloSignValidTS;
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloSignValidTS = paramLong;
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloSignStr = "";
        this.a.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloProfileBusinessProcessor", 1, "handleGetDetalInfo apollo Sign TS: " + paramLong + ", currTS: " + l);
      return;
    case -25019: 
      i = paramByteBuffer.getShort();
      if (i != this.a.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService.getWhiteListStatus((AppInterface)this.appRuntime)) {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService.updateWhiteList(i);
      }
      QLog.i("ApolloProfileBusinessProcessor", 1, "handleGetDetalInfo apollo white list: " + i);
      return;
    }
    int i = paramByteBuffer.getInt();
    if (String.valueOf(paramLong).equals(this.appRuntime.getCurrentUin())) {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService.updateUserFlag(i, 1);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService != null) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloAISwitch != i))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloAISwitch = i;
      this.a.jdField_a_of_type_Boolean = true;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService.setGetPlusStatus(true);
    }
    QLog.i("ApolloProfileBusinessProcessor", 1, "handleGetDetalInfo apollo AIFlag: " + i);
  }
  
  public void onGetProfileDetailTLVBegin(Bundle paramBundle, long paramLong, Card paramCard)
  {
    super.onGetProfileDetailTLVBegin(paramBundle, paramLong, paramCard);
    paramBundle = (IApolloManagerService)this.appRuntime.getRuntimeService(IApolloManagerService.class, "all");
    this.a = new ApolloProfileBusinessProcessor.ProfileApolloInfo(null);
    this.a.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService = paramBundle;
    this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo = paramBundle.getApolloBaseInfo(this.appRuntime.getCurrentAccountUin());
  }
  
  public void onGetProfileDetailTLVEnd(Bundle paramBundle, long paramLong, Card paramCard)
  {
    super.onGetProfileDetailTLVEnd(paramBundle, paramLong, paramCard);
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService.saveOrUpdateApolloBaseInfo(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo);
    }
    paramBundle = (IApolloManagerService)this.appRuntime.getRuntimeService(IApolloManagerService.class, "all");
    if (((paramBundle.isApolloFuncOpen(this.appRuntime.getApp())) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.isApolloStatusOpen()) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloLocalTS != this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.apolloServerTS)) || ((paramBundle.getApolloUserStatus((QQAppInterface)this.appRuntime) == 2) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.getApolloDress3D() == null)))
    {
      paramBundle = new ArrayList(1);
      paramBundle.add(Long.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBaseInfo.uin));
      paramCard = (IApolloExtensionHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      if (paramCard != null) {
        paramCard.a(paramBundle, "card");
      }
    }
  }
  
  public void onProcessProfileCard(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard)
  {
    super.onProcessProfileCard(paramBundle, paramCard, paramRespHead, paramRespSummaryCard);
    a(paramRespSummaryCard, String.valueOf(paramBundle.getLong("targetUin")));
  }
  
  public void onRequestProfileCard(Bundle paramBundle, ArrayList<BusinessReqBuffer> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    super.onRequestProfileCard(paramBundle, paramArrayList, paramArrayList1);
    paramArrayList1.add(Integer.valueOf(27236));
    paramArrayList1.add(Integer.valueOf(27238));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.profilecard.impl.ApolloProfileBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */