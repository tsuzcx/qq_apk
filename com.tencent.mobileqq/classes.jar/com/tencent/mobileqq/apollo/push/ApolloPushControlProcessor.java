package com.tencent.mobileqq.apollo.push;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;

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
    paramIApolloManagerService = (IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    paramByteStringMicro = paramIApolloManagerService.getApolloBaseInfo(String.valueOf(this.a));
    long l2 = NetConnInfoCenter.getServerTime();
    if ((l1 > l2) && (paramByteStringMicro.apolloSignValidTS != l1))
    {
      paramByteStringMicro.apolloLocalSignTs = paramByteStringMicro.apolloSignValidTS;
      paramByteStringMicro.apolloSignValidTS = l1;
      paramByteStringMicro.apolloSignStr = "";
      paramIApolloManagerService.saveOrUpdateApolloBaseInfo(paramByteStringMicro);
    }
    paramIApolloManagerService = new StringBuilder();
    paramIApolloManagerService.append("handleGetDetalInfo apollo push sign uin: ");
    paramIApolloManagerService.append(this.a);
    paramIApolloManagerService.append(", valid TS: ");
    paramIApolloManagerService.append(l1);
    paramIApolloManagerService.append(", currTS: ");
    paramIApolloManagerService.append(l2);
    QLog.i("[cmshow]ApolloPushControlProcessor", 1, paramIApolloManagerService.toString());
  }
  
  private void a(ByteStringMicro paramByteStringMicro)
  {
    if (!(this.appRuntime instanceof AppInterface))
    {
      QLog.e("[cmshow]ApolloPushControlProcessor", 1, "[handleModProfile_40517] error! appRuntime is not AppInterface");
      return;
    }
    AppInterface localAppInterface = (AppInterface)this.appRuntime;
    if (this.a == localAppInterface.getLongAccountUin())
    {
      int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
      paramByteStringMicro = (IApolloManagerService)localAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if (i != paramByteStringMicro.getWhiteListStatus())
      {
        paramByteStringMicro.updateWhiteList(i);
        if (i == 1)
        {
          paramByteStringMicro = ((IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(localAppInterface.getCurrentUin());
          if ((paramByteStringMicro.isApolloStatusOpen()) && (paramByteStringMicro.apolloLocalTS != paramByteStringMicro.apolloServerTS))
          {
            paramByteStringMicro = (IApolloExtensionHandler)localAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
            if (paramByteStringMicro != null) {
              paramByteStringMicro.a("whiteList");
            }
          }
        }
      }
      paramByteStringMicro = new StringBuilder();
      paramByteStringMicro.append("handleGetDetalInfo apollo push white list: ");
      paramByteStringMicro.append(i);
      QLog.i("[cmshow]ApolloPushControlProcessor", 1, paramByteStringMicro.toString());
    }
  }
  
  private void b(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    boolean bool = this.appRuntime instanceof QQAppInterface;
    int i = 1;
    if (!bool)
    {
      QLog.e("[cmshow]ApolloPushControlProcessor", 1, "[handleModProfile_27059] error! appRuntime is not QQAppInterface");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.appRuntime;
    int j = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asIntBuffer().get();
    paramByteStringMicro = String.valueOf(this.a);
    if (TextUtils.isEmpty(paramByteStringMicro)) {
      return;
    }
    Object localObject = (IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)localObject).getApolloBaseInfo(paramByteStringMicro);
    if (paramByteStringMicro.equals(localQQAppInterface.getCurrentUin())) {
      ((IApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new long[] { this.a });
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("apollo push uin: ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.a);
    localStringBuilder2.append("temp");
    localStringBuilder1.append(localStringBuilder2.toString().substring(0, 4));
    localStringBuilder1.append(", timeStamp: ");
    localStringBuilder1.append(j);
    QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { localStringBuilder1.toString(), ", local server:", Long.valueOf(localApolloBaseInfo.apolloServerTS) });
    long l1 = localApolloBaseInfo.apolloServerTS;
    long l2 = j;
    if (l1 != l2)
    {
      localApolloBaseInfo.apolloServerTS = l2;
      ((IApolloDaoManagerService)localObject).saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
    }
    localObject = localQQAppInterface.getMessageFacade();
    if ((localObject == null) || (!((QQMessageFacade)localObject).n()) || (TextUtils.isEmpty(((QQMessageFacade)localObject).l())) || (!CmShowAioMatcherImpl.judgeSupported(((QQMessageFacade)localObject).m(), 1)) || (!((QQMessageFacade)localObject).l().equals(paramByteStringMicro))) {
      i = 0;
    }
    if (((paramByteStringMicro.equals(localQQAppInterface.getCurrentUin())) && (paramIApolloManagerService.getApolloUserStatus() == 2)) || (i != 0))
    {
      paramIApolloManagerService = (IApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      paramByteStringMicro = new ArrayList();
      paramByteStringMicro.add(Long.valueOf(this.a));
      paramIApolloManagerService.a(paramByteStringMicro, "online_push");
    }
  }
  
  private void c(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    if (!(this.appRuntime instanceof AppInterface))
    {
      QLog.e("[cmshow]ApolloPushControlProcessor", 1, "[handleModProfile_42980] error! appRuntime is not AppInterface");
      return;
    }
    paramIApolloManagerService = (AppInterface)this.appRuntime;
    int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    paramByteStringMicro = (IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject = paramByteStringMicro.getApolloBaseInfo(String.valueOf(this.a));
    if ((QLog.isColorLevel()) || (this.a == paramIApolloManagerService.getLongAccountUin()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo push uin: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", apollo status: ");
      localStringBuilder.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 1, localStringBuilder.toString());
    }
    if (((ApolloBaseInfo)localObject).apolloStatus != i)
    {
      ((ApolloBaseInfo)localObject).apolloStatus = i;
      paramByteStringMicro.saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject);
      if ((this.a == this.appRuntime.getLongAccountUin()) && (((ApolloBaseInfo)localObject).isApolloStatusOpen()) && (((ApolloBaseInfo)localObject).apolloLocalTS != ((ApolloBaseInfo)localObject).apolloServerTS))
      {
        paramByteStringMicro = (IApolloExtensionHandler)paramIApolloManagerService.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (paramByteStringMicro != null) {
          paramByteStringMicro.a("statusChange");
        }
      }
    }
    paramByteStringMicro = String.valueOf(this.a);
    if (this.a == paramIApolloManagerService.getLongAccountUin())
    {
      paramByteStringMicro = new Pair(paramByteStringMicro, Integer.valueOf(i));
      paramIApolloManagerService.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER).notifyUI(3, true, paramByteStringMicro);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramByteStringMicro);
    ((IApolloMessageService)paramIApolloManagerService.getRuntimeService(IApolloMessageService.class, "all")).apolloStatusOrDressChange(i, (ArrayList)localObject);
  }
  
  private void d(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    paramIApolloManagerService = (IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    paramByteStringMicro = paramIApolloManagerService.getApolloBaseInfo(String.valueOf(this.a));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo push uin: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", avip level: ");
      localStringBuilder.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
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
    paramIApolloManagerService = (IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    paramByteStringMicro = paramIApolloManagerService.getApolloBaseInfo(String.valueOf(this.a));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo push uin: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", avip flag: ");
      localStringBuilder.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
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
      QLog.e("[cmshow]ApolloPushControlProcessor", 1, "[handleModProfile_42980] error! appRuntime is not QQAppInterface");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.appRuntime;
    paramByteStringMicro = paramByteStringMicro.toByteArray();
    int i;
    if (paramByteStringMicro.length == 1) {
      i = paramByteStringMicro[0];
    } else {
      i = ByteBuffer.wrap(paramByteStringMicro).asShortBuffer().get();
    }
    paramByteStringMicro = String.valueOf(this.a);
    Object localObject = (IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)localObject).getApolloBaseInfo(paramByteStringMicro);
    QLog.d("Q.msg.BaseMessageProcessor", 1, new Object[] { "cmshow_online_push,  uin: ", LogUtil.wrapLogUin(paramByteStringMicro), ", cmshow3dFlag: ", Integer.valueOf(i), ", local=", Integer.valueOf(localApolloBaseInfo.cmshow3dFlag) });
    if (localApolloBaseInfo.cmshow3dFlag != i)
    {
      int j = localApolloBaseInfo.cmshow3dFlag;
      localApolloBaseInfo.cmshow3dFlag = i;
      ((IApolloDaoManagerService)localObject).saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
      if (localQQAppInterface.getCurrentAccountUin().equals(String.valueOf(this.a))) {
        paramIApolloManagerService.notify3dFlagUpdate(j, i);
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramByteStringMicro);
      ((IApolloMessageService)localQQAppInterface.getRuntimeService(IApolloMessageService.class, "all")).apolloStatusOrDressChange(3, (ArrayList)localObject);
    }
    if (((i & 0x1) == 1) && (localApolloBaseInfo.getApolloDress3D() == null))
    {
      paramByteStringMicro = new StringBuilder();
      paramByteStringMicro.append("");
      paramByteStringMicro.append(this.a);
      paramIApolloManagerService.addToBulkPullMap(paramByteStringMicro.toString(), 4096);
    }
  }
  
  private void g(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    int j = (i & 0x4) >> 2;
    Object localObject = String.valueOf(this.a);
    paramByteStringMicro = ((IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo((String)localObject);
    paramByteStringMicro.apolloDrawerStatus = (i & 0x1);
    paramByteStringMicro.apolloCardStatus = ((i & 0x2) >> 1);
    paramByteStringMicro.apolloAIOStatus = j;
    boolean bool = QLog.isColorLevel();
    i = 0;
    if (bool)
    {
      localObject = LogUtil.wrapLogUin((String)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramByteStringMicro.apolloDrawerStatus);
      localStringBuilder.append(";");
      localStringBuilder.append(paramByteStringMicro.apolloCardStatus);
      localStringBuilder.append(";");
      localStringBuilder.append(paramByteStringMicro.apolloAIOStatus);
      localStringBuilder.append(";");
      QLog.d("[cmshow]ApolloPushControlProcessor", 2, new Object[] { "cmshow_setting_online_push,  uin: ", localObject, ",local=", localStringBuilder.toString() });
    }
    localObject = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    if (j != 1) {
      i = 1;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sprite_hide_key");
    localStringBuilder.append(this.a);
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i).commit();
    paramIApolloManagerService.saveOrUpdateApolloBaseInfo(paramByteStringMicro);
  }
  
  private void h(IApolloManagerService paramIApolloManagerService, ByteStringMicro paramByteStringMicro)
  {
    int i = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asIntBuffer().get();
    if (paramIApolloManagerService != null)
    {
      paramByteStringMicro = (IApolloDaoManagerService)this.appRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
      ApolloBaseInfo localApolloBaseInfo = paramByteStringMicro.getApolloBaseInfo(this.appRuntime.getCurrentUin());
      if ((localApolloBaseInfo != null) && (i != localApolloBaseInfo.apolloAISwitch))
      {
        localApolloBaseInfo.apolloAISwitch = i;
        if ((this.appRuntime != null) && (String.valueOf(this.a).equals(this.appRuntime.getCurrentUin()))) {
          paramIApolloManagerService.updateUserFlag(i, 2);
        }
        paramByteStringMicro.saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
      }
    }
    paramIApolloManagerService = new StringBuilder();
    paramIApolloManagerService.append("handleGetDetalInfo apollo aiSwitch  push: ");
    paramIApolloManagerService.append(i);
    QLog.i("[cmshow]ApolloPushControlProcessor", 1, paramIApolloManagerService.toString());
  }
  
  public String getProcessorKey()
  {
    return "[cmshow]ApolloPushControlProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return (paramInt == 27392) || (paramInt == 42003) || (paramInt == 41999) || (paramInt == 42980) || (paramInt == 27059) || (paramInt == 40517) || (paramInt == 27210) || (paramInt == 42230);
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onProcessProfileModifyPush : ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("[cmshow]ApolloPushControlProcessor", 2, ((StringBuilder)localObject).toString());
    localObject = (IApolloManagerService)this.appRuntime.getRuntimeService(IApolloManagerService.class, "all");
    switch (paramInt)
    {
    default: 
    case 45082: 
      g((IApolloManagerService)localObject, paramByteStringMicro);
      return;
    case 42980: 
      c((IApolloManagerService)localObject, paramByteStringMicro);
      return;
    case 42230: 
      f((IApolloManagerService)localObject, paramByteStringMicro);
      return;
    case 42003: 
      e((IApolloManagerService)localObject, paramByteStringMicro);
      return;
    case 41999: 
      d((IApolloManagerService)localObject, paramByteStringMicro);
      return;
    case 40517: 
      a(paramByteStringMicro);
      return;
    case 27392: 
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPushControlProcessor", 2, "get apollo head update push.");
      }
      if ((this.appRuntime instanceof QQAppInterface))
      {
        ((IQQAvatarHandlerService)this.appRuntime.getRuntimeService(IQQAvatarHandlerService.class, "")).getApolloHead(this.appRuntime.getCurrentAccountUin());
        return;
      }
      break;
    case 27210: 
      h((IApolloManagerService)localObject, paramByteStringMicro);
      return;
    case 27206: 
      a((IApolloManagerService)localObject, paramByteStringMicro);
      return;
    case 27059: 
      b((IApolloManagerService)localObject, paramByteStringMicro);
    }
  }
  
  public void onProcessProfileModifyPushBegin(long paramLong)
  {
    super.onProcessProfileModifyPushBegin(paramLong);
    this.a = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.push.ApolloPushControlProcessor
 * JD-Core Version:    0.7.0.1
 */