package com.tencent.mobileqq.apollo.profilecard;

import SummaryCard.QQApolloInfo;
import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
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
    if (paramRespSummaryCard.stApollo != null)
    {
      IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
      Object localObject = localIApolloDaoManagerService.getApolloBaseInfo(paramString);
      ((ApolloBaseInfo)localObject).apolloVipFlag = ((int)paramRespSummaryCard.stApollo.uVipFlag);
      ((ApolloBaseInfo)localObject).apolloVipLevel = ((int)paramRespSummaryCard.stApollo.uVipLevel);
      ((ApolloBaseInfo)localObject).apolloStatus = ((int)paramRespSummaryCard.stApollo.uUserFlag);
      ((ApolloBaseInfo)localObject).apolloServerTS = paramRespSummaryCard.stApollo.uTimestamp;
      localIApolloDaoManagerService.saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject);
      if (QLog.isColorLevel())
      {
        paramRespSummaryCard = new StringBuilder();
        paramRespSummaryCard.append("summaryCard upadte apolloBaseInfo uin: ");
        paramRespSummaryCard.append(paramString);
        paramRespSummaryCard.append(", apollo vipFlag: ");
        paramRespSummaryCard.append(((ApolloBaseInfo)localObject).apolloVipFlag);
        paramRespSummaryCard.append(", apollo vipLevel: ");
        paramRespSummaryCard.append(((ApolloBaseInfo)localObject).apolloVipLevel);
        paramRespSummaryCard.append(", apollo status: ");
        paramRespSummaryCard.append(((ApolloBaseInfo)localObject).apolloStatus);
        paramRespSummaryCard.append(", apollo svr TS: ");
        paramRespSummaryCard.append(((ApolloBaseInfo)localObject).apolloServerTS);
        paramRespSummaryCard.append(", apollo local TS: ");
        paramRespSummaryCard.append(((ApolloBaseInfo)localObject).apolloLocalTS);
        QLog.d("[cmshow]ApolloProfileBusinessProcessor", 2, paramRespSummaryCard.toString());
      }
      if (((ApolloBaseInfo)localObject).apolloServerTS != ((ApolloBaseInfo)localObject).apolloLocalTS)
      {
        paramRespSummaryCard = (IApolloExtensionHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (paramRespSummaryCard != null)
        {
          try
          {
            localObject = new ArrayList(1);
            ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(paramString)));
            paramRespSummaryCard.a((ArrayList)localObject, "summaryCard");
            if (!QLog.isColorLevel()) {
              return;
            }
            paramRespSummaryCard = new StringBuilder();
            paramRespSummaryCard.append("summaryCard update user apollo dress uin: ");
            paramRespSummaryCard.append(paramString.substring(0, 4));
            QLog.d("[cmshow]ApolloProfileBusinessProcessor", 2, paramRespSummaryCard.toString());
            return;
          }
          catch (Exception paramRespSummaryCard)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          paramString = new StringBuilder();
          paramString.append("summaryCard update user apollo dress uin: ");
          paramString.append(paramRespSummaryCard.getMessage());
          QLog.d("[cmshow]ApolloProfileBusinessProcessor", 2, paramString.toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("[cmshow]ApolloProfileBusinessProcessor", 2, "CardHandle apollo field is null");
    }
  }
  
  public void onGetProfileDetailResponseBegin(Bundle paramBundle)
  {
    super.onGetProfileDetailResponseBegin(paramBundle);
    this.a = null;
  }
  
  public void onGetProfileDetailTLV(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    super.onGetProfileDetailTLV(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    if (paramShort1 != -25019)
    {
      if (paramShort1 != -23537)
      {
        if (paramShort1 != -23533)
        {
          if (paramShort1 != -23306)
          {
            if (paramShort1 != -22556)
            {
              if (paramShort1 != 27059)
              {
                if (paramShort1 != 27206)
                {
                  if (paramShort1 != 27210) {
                    return;
                  }
                  i = paramByteBuffer.getInt();
                  if (String.valueOf(paramLong).equals(this.appRuntime.getCurrentUin())) {
                    this.a.a.updateUserFlag(i, 1);
                  }
                  if ((this.a.a != null) && (this.a.c.apolloAISwitch != i))
                  {
                    this.a.c.apolloAISwitch = i;
                    this.a.d = true;
                  }
                  paramBundle = new StringBuilder();
                  paramBundle.append("handleGetDetalInfo apollo AIFlag: ");
                  paramBundle.append(i);
                  QLog.i("[cmshow]ApolloProfileBusinessProcessor", 1, paramBundle.toString());
                  return;
                }
                paramLong = paramByteBuffer.getInt();
                long l = NetConnInfoCenter.getServerTime();
                if ((paramLong < l) && (this.a.c.apolloSignValidTS != paramLong))
                {
                  this.a.c.apolloLocalSignTs = this.a.c.apolloSignValidTS;
                  this.a.c.apolloSignValidTS = paramLong;
                  this.a.c.apolloSignStr = "";
                  this.a.d = true;
                }
                paramBundle = new StringBuilder();
                paramBundle.append("handleGetDetalInfo apollo Sign TS: ");
                paramBundle.append(paramLong);
                paramBundle.append(", currTS: ");
                paramBundle.append(l);
                QLog.i("[cmshow]ApolloProfileBusinessProcessor", 1, paramBundle.toString());
                return;
              }
              paramLong = paramByteBuffer.getInt();
              if (paramLong != this.a.c.apolloServerTS)
              {
                this.a.c.apolloServerTS = paramLong;
                this.a.d = true;
              }
              paramBundle = new StringBuilder();
              paramBundle.append("handleGetDetalInfo apollo svr TS: ");
              paramBundle.append(paramLong);
              paramBundle.append(",local TS: ");
              paramBundle.append(this.a.c.apolloServerTS);
              QLog.i("[cmshow]ApolloProfileBusinessProcessor", 1, paramBundle.toString());
              return;
            }
            i = paramByteBuffer.getShort();
            if (i != this.a.c.apolloStatus)
            {
              this.a.c.apolloStatus = i;
              this.a.d = true;
              paramBundle = (IApolloExtensionHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
              if (paramBundle != null)
              {
                paramCard = new Pair(this.a.c.uin, Integer.valueOf(i));
                ((BusinessHandler)paramBundle).notifyUI(3, true, paramCard);
              }
            }
            paramBundle = new StringBuilder();
            paramBundle.append("handleGetDetalInfo apollo status flag: ");
            paramBundle.append(i);
            QLog.i("[cmshow]ApolloProfileBusinessProcessor", 1, paramBundle.toString());
            return;
          }
          paramShort1 = paramByteBuffer.getShort();
          if (paramShort1 != this.a.c.cmshow3dFlag)
          {
            this.a.c.cmshow3dFlag = paramShort1;
            this.a.d = true;
          }
          QLog.d("[cmshow]ApolloProfileBusinessProcessor", 1, new Object[] { "handleGetDetalInfo apollo svr cmshow3dFlag: ", Short.valueOf(paramShort1), ", local cmshow3dFlag: ", Integer.valueOf(this.a.c.cmshow3dFlag) });
          return;
        }
        i = paramByteBuffer.getShort();
        if (i != this.a.c.apolloVipFlag)
        {
          this.a.c.apolloVipFlag = i;
          this.a.d = true;
        }
        paramBundle = new StringBuilder();
        paramBundle.append("handleGetDetalInfo apollo vip flag: ");
        paramBundle.append(i);
        QLog.i("[cmshow]ApolloProfileBusinessProcessor", 1, paramBundle.toString());
        return;
      }
      i = paramByteBuffer.getShort();
      if (i != this.a.c.apolloVipLevel)
      {
        this.a.c.apolloVipLevel = i;
        this.a.d = true;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("handleGetDetalInfo apollo vip level: ");
      paramBundle.append(i);
      QLog.i("[cmshow]ApolloProfileBusinessProcessor", 1, paramBundle.toString());
      return;
    }
    int i = paramByteBuffer.getShort();
    if (i != this.a.a.getWhiteListStatus()) {
      this.a.a.updateWhiteList(i);
    }
    paramBundle = new StringBuilder();
    paramBundle.append("handleGetDetalInfo apollo white list: ");
    paramBundle.append(i);
    QLog.i("[cmshow]ApolloProfileBusinessProcessor", 1, paramBundle.toString());
  }
  
  public void onGetProfileDetailTLVBegin(Bundle paramBundle, long paramLong, Card paramCard)
  {
    super.onGetProfileDetailTLVBegin(paramBundle, paramLong, paramCard);
    paramBundle = (IApolloManagerService)this.appRuntime.getRuntimeService(IApolloManagerService.class, "all");
    paramCard = (IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    this.a = new ApolloProfileBusinessProcessor.ProfileApolloInfo(null);
    ApolloProfileBusinessProcessor.ProfileApolloInfo localProfileApolloInfo = this.a;
    localProfileApolloInfo.a = paramBundle;
    localProfileApolloInfo.b = paramCard;
    localProfileApolloInfo.c = paramCard.getApolloBaseInfo(this.appRuntime.getCurrentAccountUin());
  }
  
  public void onGetProfileDetailTLVEnd(Bundle paramBundle, long paramLong, Card paramCard)
  {
    super.onGetProfileDetailTLVEnd(paramBundle, paramLong, paramCard);
    if (this.a.d) {
      this.a.b.saveOrUpdateApolloBaseInfo(this.a.c);
    }
    paramBundle = (IApolloManagerService)this.appRuntime.getRuntimeService(IApolloManagerService.class, "all");
    if (((paramBundle.isApolloSupport(this.appRuntime.getApp())) && (this.a.c.isApolloStatusOpen()) && (this.a.c.apolloLocalTS != this.a.c.apolloServerTS)) || ((paramBundle.getApolloUserStatus() == 2) && (this.a.c.getApolloDress3D() == null)))
    {
      paramBundle = new ArrayList(1);
      paramBundle.add(Long.valueOf(this.a.c.uin));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.ApolloProfileBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */