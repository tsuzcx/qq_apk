package com.tencent.mobileqq.apollo.api.push.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ApolloPushControlProcessor
  extends AbsProfileCommonProcessor
{
  long a;
  
  public ApolloPushControlProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    long l1 = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asIntBuffer().get();
    paramByteStringMicro = paramIApolloManagerService.getApolloBaseInfo(String.valueOf(this.a));
    long l2 = NetConnInfoCenter.getServerTime();
    if ((l1 > l2) && (paramByteStringMicro.apolloSignValidTS != l1))
    {
      paramByteStringMicro.apolloLocalSignTs = paramByteStringMicro.apolloSignValidTS;
      paramByteStringMicro.apolloSignValidTS = l1;
      paramByteStringMicro.apolloSignStr = "";
      paramIApolloManagerService.saveOrUpdateApolloBaseInfo(paramByteStringMicro);
    }
    QLog.i("ApolloPushControlProcessor", 1, "handleGetDetalInfo apollo push sign uin: " + this.a + ", valid TS: " + l1 + ", currTS: " + l2);
  }
  
  private void a(ByteStringMicro paramByteStringMicro)
  {
    if (!(this.appRuntime instanceof AppInterface)) {
      QLog.e("ApolloPushControlProcessor", 1, "[handleModProfile_40517] error! appRuntime is not AppInterface");
    }
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = (AppInterface)this.appRuntime;
    } while (this.a != localAppInterface.getLongAccountUin());
    int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    paramByteStringMicro = (IApolloManagerService)localAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (i != paramByteStringMicro.getWhiteListStatus(localAppInterface))
    {
      paramByteStringMicro.updateWhiteList(i);
      if (i == 1)
      {
        paramByteStringMicro = paramByteStringMicro.getApolloBaseInfo(localAppInterface.getCurrentUin());
        if ((paramByteStringMicro.isApolloStatusOpen()) && (paramByteStringMicro.apolloLocalTS != paramByteStringMicro.apolloServerTS))
        {
          paramByteStringMicro = (IApolloExtensionHandler)localAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
          if (paramByteStringMicro != null) {
            paramByteStringMicro.a("whiteList");
          }
        }
      }
    }
    QLog.i("ApolloPushControlProcessor", 1, "handleGetDetalInfo apollo push white list: " + i);
  }
  
  private void b(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    if (!(this.appRuntime instanceof QQAppInterface)) {
      QLog.e("ApolloPushControlProcessor", 1, "[handleModProfile_27059] error! appRuntime is not QQAppInterface");
    }
    for (;;)
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)this.appRuntime;
      int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asIntBuffer().get();
      paramByteStringMicro = String.valueOf(this.a);
      if (!TextUtils.isEmpty(paramByteStringMicro))
      {
        Object localObject = paramIApolloManagerService.getApolloBaseInfo(paramByteStringMicro);
        if (paramByteStringMicro.equals(localQQAppInterface.getCurrentUin())) {
          ((IApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new long[] { this.a });
        }
        QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "apollo push uin: " + new StringBuilder().append(this.a).append("temp").toString().substring(0, 4) + ", timeStamp: " + i, ", local server:", Long.valueOf(((ApolloBaseInfo)localObject).apolloServerTS) });
        if (((ApolloBaseInfo)localObject).apolloServerTS != i)
        {
          ((ApolloBaseInfo)localObject).apolloServerTS = i;
          paramIApolloManagerService.saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject);
        }
        localObject = localQQAppInterface.getMessageFacade();
        if ((localObject != null) && (((QQMessageFacade)localObject).a()) && (!TextUtils.isEmpty(((QQMessageFacade)localObject).a())) && (((QQMessageFacade)localObject).a() == 0) && (((QQMessageFacade)localObject).a().equals(paramByteStringMicro))) {}
        for (i = 1; ((paramByteStringMicro.equals(localQQAppInterface.getCurrentUin())) && (paramIApolloManagerService.getApolloUserStatus(localQQAppInterface) == 2)) || (i != 0); i = 0)
        {
          paramIApolloManagerService = (IApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
          paramByteStringMicro = new ArrayList();
          paramByteStringMicro.add(Long.valueOf(this.a));
          paramIApolloManagerService.a(paramByteStringMicro, "online_push");
          return;
        }
      }
    }
  }
  
  private void c(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    if (!(this.appRuntime instanceof AppInterface))
    {
      QLog.e("ApolloPushControlProcessor", 1, "[handleModProfile_42980] error! appRuntime is not AppInterface");
      return;
    }
    AppInterface localAppInterface = (AppInterface)this.appRuntime;
    int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    paramByteStringMicro = paramIApolloManagerService.getApolloBaseInfo(String.valueOf(this.a));
    if ((QLog.isColorLevel()) || (this.a == localAppInterface.getLongAccountUin())) {
      QLog.d("Q.msg.BaseMessageProcessor", 1, "apollo push uin: " + this.a + ", apollo status: " + i);
    }
    if (paramByteStringMicro.apolloStatus != i)
    {
      paramByteStringMicro.apolloStatus = i;
      paramIApolloManagerService.saveOrUpdateApolloBaseInfo(paramByteStringMicro);
      if ((this.a == this.appRuntime.getLongAccountUin()) && (paramByteStringMicro.isApolloStatusOpen()) && (paramByteStringMicro.apolloLocalTS != paramByteStringMicro.apolloServerTS))
      {
        paramIApolloManagerService = (IApolloExtensionHandler)localAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (paramIApolloManagerService != null) {
          paramIApolloManagerService.a("statusChange");
        }
      }
    }
    paramIApolloManagerService = String.valueOf(this.a);
    if (this.a == localAppInterface.getLongAccountUin())
    {
      paramIApolloManagerService = new Pair(paramIApolloManagerService, Integer.valueOf(i));
      localAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER).notifyUI(3, true, paramIApolloManagerService);
      return;
    }
    paramByteStringMicro = new ArrayList();
    paramByteStringMicro.add(paramIApolloManagerService);
    ((IApolloMessageService)localAppInterface.getRuntimeService(IApolloMessageService.class, "all")).apolloStatusOrDressChange(i, paramByteStringMicro);
  }
  
  private void d(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    paramByteStringMicro = paramIApolloManagerService.getApolloBaseInfo(String.valueOf(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + this.a + ", avip level: " + i);
    }
    if (paramByteStringMicro.apolloVipLevel != i)
    {
      paramByteStringMicro.apolloVipLevel = i;
      paramIApolloManagerService.saveOrUpdateApolloBaseInfo(paramByteStringMicro);
    }
  }
  
  private void e(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    paramByteStringMicro = paramIApolloManagerService.getApolloBaseInfo(String.valueOf(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + this.a + ", avip flag: " + i);
    }
    if (paramByteStringMicro.apolloVipFlag != i)
    {
      paramByteStringMicro.apolloVipFlag = i;
      paramIApolloManagerService.saveOrUpdateApolloBaseInfo(paramByteStringMicro);
    }
  }
  
  private void f(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    if (!(this.appRuntime instanceof QQAppInterface))
    {
      QLog.e("ApolloPushControlProcessor", 1, "[handleModProfile_42980] error! appRuntime is not QQAppInterface");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.appRuntime;
    paramByteStringMicro = paramByteStringMicro.toByteArray();
    if (paramByteStringMicro.length == 1) {}
    for (int i = paramByteStringMicro[0];; i = ByteBuffer.wrap(paramByteStringMicro).asShortBuffer().get())
    {
      paramByteStringMicro = String.valueOf(this.a);
      ApolloBaseInfo localApolloBaseInfo = paramIApolloManagerService.getApolloBaseInfo(paramByteStringMicro);
      QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "cmshow_online_push,  uin: ", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramByteStringMicro), ", cmshow3dFlag: ", Integer.valueOf(i), ", local=", Integer.valueOf(localApolloBaseInfo.cmshow3dFlag) });
      if (localApolloBaseInfo.cmshow3dFlag != i)
      {
        int j = localApolloBaseInfo.cmshow3dFlag;
        localApolloBaseInfo.cmshow3dFlag = i;
        paramIApolloManagerService.saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
        if (localQQAppInterface.getCurrentAccountUin().equals(String.valueOf(this.a))) {
          paramIApolloManagerService.notify3dFlagUpdate(j, i);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramByteStringMicro);
        ((IApolloMessageService)localQQAppInterface.getRuntimeService(IApolloMessageService.class, "all")).apolloStatusOrDressChange(3, localArrayList);
      }
      if (((i & 0x1) != 1) || (localApolloBaseInfo.getApolloDress3D() != null)) {
        break;
      }
      paramIApolloManagerService.addToBulkPullMap("" + this.a, 4096);
      return;
    }
  }
  
  private void g(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asIntBuffer().get();
    if (paramIApolloManagerService != null)
    {
      paramByteStringMicro = paramIApolloManagerService.getApolloBaseInfo(this.appRuntime.getCurrentUin());
      if ((paramByteStringMicro != null) && (i != paramByteStringMicro.apolloAISwitch))
      {
        paramByteStringMicro.apolloAISwitch = i;
        if ((this.appRuntime != null) && (String.valueOf(this.a).equals(this.appRuntime.getCurrentUin()))) {
          paramIApolloManagerService.updateUserFlag(i, 2);
        }
        paramIApolloManagerService.saveOrUpdateApolloBaseInfo(paramByteStringMicro);
      }
    }
    QLog.i("ApolloPushControlProcessor", 1, "handleGetDetalInfo apollo aiSwitch  push: " + i);
  }
  
  public String getProcessorKey()
  {
    return "ApolloPushControlProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return (paramInt == 27392) || (paramInt == 42003) || (paramInt == 41999) || (paramInt == 42980) || (paramInt == 27059) || (paramInt == 40517) || (paramInt == 27210) || (paramInt == 42230);
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.appRuntime.getRuntimeService(IApolloManagerService.class, "all");
    switch (paramInt)
    {
    default: 
    case 27392: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPushControlProcessor", 2, "get apollo head update push.");
        }
      } while (!(this.appRuntime instanceof QQAppInterface));
      ((IQQAvatarHandlerService)this.appRuntime.getRuntimeService(IQQAvatarHandlerService.class, "")).getApolloHead(this.appRuntime.getCurrentAccountUin());
      return;
    case 42003: 
      e(localIApolloManagerService, paramByteStringMicro);
      return;
    case 41999: 
      d(localIApolloManagerService, paramByteStringMicro);
      return;
    case 42980: 
      c(localIApolloManagerService, paramByteStringMicro);
      return;
    case 27059: 
      b(localIApolloManagerService, paramByteStringMicro);
      return;
    case 40517: 
      a(paramByteStringMicro);
      return;
    case 27206: 
      a(localIApolloManagerService, paramByteStringMicro);
      return;
    case 27210: 
      g(localIApolloManagerService, paramByteStringMicro);
      return;
    }
    f(localIApolloManagerService, paramByteStringMicro);
  }
  
  public void onProcessProfileModifyPushBegin(long paramLong)
  {
    super.onProcessProfileModifyPushBegin(paramLong);
    this.a = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.push.impl.ApolloPushControlProcessor
 * JD-Core Version:    0.7.0.1
 */