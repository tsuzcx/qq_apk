package com.tencent.mobileqq.apollo.request;

import android.content.Intent;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloMessageService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.request.annotation.ApolloRequestReceive;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveManager;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mMethodMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveManager$ReceiveMethodHolder;", "Lkotlin/collections/HashMap;", "getRequestReceive", "cmd", "handleApolloRoleAndDress", "", "params", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams;", "handleApolloSetModel", "handleChangeApolloStatus", "loadMethods", "obj", "cls", "Ljava/lang/Class;", "ReceiveMethodHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloRequestReceiveManager
{
  public static final ApolloRequestReceiveManager INSTANCE;
  @NotNull
  private static final String TAG = "ApolloRequestReceiveManager";
  private static final HashMap<String, ApolloRequestReceiveManager.ReceiveMethodHolder> mMethodMap;
  
  static
  {
    ApolloRequestReceiveManager localApolloRequestReceiveManager = new ApolloRequestReceiveManager();
    INSTANCE = localApolloRequestReceiveManager;
    TAG = "ApolloRequestReceiveManager";
    mMethodMap = new HashMap();
    localApolloRequestReceiveManager.loadMethods(localApolloRequestReceiveManager, ApolloRequestReceiveManager.class);
  }
  
  private final void loadMethods(Object paramObject, Class<?> paramClass)
  {
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = paramClass[i];
      Object localObject2;
      if (((Method)localObject1).isAnnotationPresent(ApolloRequestReceive.class))
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "method");
        ((Method)localObject1).setAccessible(true);
        localObject2 = ((Method)localObject1).getAnnotation(ApolloRequestReceive.class);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "method.getAnnotation<Apo…questReceive::class.java)");
        localObject2 = (ApolloRequestReceive)localObject2;
        if (!mMethodMap.containsKey(((ApolloRequestReceive)localObject2).a())) {
          break label91;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label91:
        localObject1 = new ApolloRequestReceiveManager.ReceiveMethodHolder(paramObject, (Method)localObject1);
        ((Map)mMethodMap).put(((ApolloRequestReceive)localObject2).a(), localObject1);
      }
    }
  }
  
  @Nullable
  public final ApolloRequestReceiveManager.ReceiveMethodHolder getRequestReceive(@Nullable String paramString)
  {
    return (ApolloRequestReceiveManager.ReceiveMethodHolder)((Map)mMethodMap).get(paramString);
  }
  
  @NotNull
  public final String getTAG()
  {
    return TAG;
  }
  
  @ApolloRequestReceive(a="apollo_core.save_checkmul")
  public final void handleApolloRoleAndDress(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject = paramApolloRequestReceiveParams.jdField_a_of_type_AndroidContentIntent;
    FromServiceMsg localFromServiceMsg;
    long l;
    if (localObject != null)
    {
      localFromServiceMsg = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
      if (localFromServiceMsg != null)
      {
        QLog.d(TAG, 2, "handleApolloRoleAndDress; isSuccess: " + localFromServiceMsg.isSuccess() + ", ret: " + localFromServiceMsg.getResultCode());
        l = ((Intent)localObject).getLongExtra("index", -1L);
        if (!localFromServiceMsg.isSuccess()) {
          break label294;
        }
      }
    }
    try
    {
      localObject = new WebSSOAgent.UniSsoServerRsp();
      ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte);
      QLog.d(TAG, 1, "handleApolloRoleAndDress ret: " + ((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() + "; errMsg: " + ((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.get());
      if (((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() == 0L)
      {
        paramApolloRequestReceiveParams = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.get());
        QLog.d(TAG, 1, "handleApolloRoleAndDress dataJson : " + paramApolloRequestReceiveParams);
      }
      paramApolloRequestReceiveParams = ApolloRequestCallbackManager.a;
      if (((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() == 0L) {}
      for (boolean bool = true;; bool = false)
      {
        paramApolloRequestReceiveParams.a(l, bool, ((WebSSOAgent.UniSsoServerRsp)localObject).ret.get(), ((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.get());
        return;
      }
      QLog.e(TAG, 1, "handleApolloRoleAndDress fail ret: " + localFromServiceMsg.getResultCode());
    }
    catch (Throwable paramApolloRequestReceiveParams)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "", paramApolloRequestReceiveParams);
      }
      ApolloRequestCallbackManager.a.a(l, false, -1L, "exception");
      return;
    }
    label294:
    ApolloRequestCallbackManager.a.a(l, false, localFromServiceMsg.getResultCode(), localFromServiceMsg.getBusinessFailMsg());
  }
  
  @ApolloRequestReceive(a="apollo_core.set_model")
  public final void handleApolloSetModel(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject1 = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    if (localObject1 != null)
    {
      Object localObject2 = paramApolloRequestReceiveParams.jdField_a_of_type_AndroidContentIntent;
      if (localObject2 != null)
      {
        QQAppInterface localQQAppInterface = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localQQAppInterface != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleApolloSetModel; isSuccess: " + ((FromServiceMsg)localObject1).isSuccess() + ", ret: " + ((FromServiceMsg)localObject1).getResultCode());
          }
          long l = ((Intent)localObject2).getLongExtra("index", -1L);
          if (((FromServiceMsg)localObject1).isSuccess()) {
            for (;;)
            {
              try
              {
                localObject1 = new WebSSOAgent.UniSsoServerRsp();
                ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte);
                QLog.d(ApolloExtensionHandlerImpl.b, 1, "handleApolloSetModel ret: " + ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get());
                int i = ((Intent)localObject2).getIntExtra("model", 1);
                if (((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() == 0L)
                {
                  paramApolloRequestReceiveParams = localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
                  Intrinsics.checkExpressionValueIsNotNull(paramApolloRequestReceiveParams, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
                  paramApolloRequestReceiveParams = (IApolloManagerService)paramApolloRequestReceiveParams;
                  localObject2 = paramApolloRequestReceiveParams.getApolloBaseInfo(localQQAppInterface.getCurrentUin());
                  int j = ((ApolloBaseInfo)localObject2).cmshow3dFlag;
                  if (i != 1) {
                    continue;
                  }
                  ((ApolloBaseInfo)localObject2).cmshow3dFlag |= 0x1;
                  if (((ApolloBaseInfo)localObject2).cmshow3dFlag != j)
                  {
                    paramApolloRequestReceiveParams.saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject2);
                    paramApolloRequestReceiveParams.notify3dFlagUpdate(j, ((ApolloBaseInfo)localObject2).cmshow3dFlag);
                    paramApolloRequestReceiveParams = new ArrayList();
                    paramApolloRequestReceiveParams.add(localQQAppInterface.getCurrentUin());
                    ((IApolloMessageService)localQQAppInterface.getRuntimeService(IApolloMessageService.class, "all")).apolloStatusOrDressChange(3, paramApolloRequestReceiveParams);
                  }
                }
                paramApolloRequestReceiveParams = ApolloRequestCallbackManager.a;
                boolean bool;
                if (((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() == 0L)
                {
                  bool = true;
                  paramApolloRequestReceiveParams.a(l, bool, ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get(), ((WebSSOAgent.UniSsoServerRsp)localObject1).errmsg.get());
                  return;
                  ((ApolloBaseInfo)localObject2).cmshow3dFlag &= 0xFFFFFFFE;
                }
                else
                {
                  bool = false;
                }
              }
              catch (Throwable paramApolloRequestReceiveParams)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(ApolloExtensionHandlerImpl.b, 2, "", paramApolloRequestReceiveParams);
                }
                ApolloRequestCallbackManager.a.a(l, false, -1L, "exception");
                return;
              }
            }
          }
          QLog.e(ApolloExtensionHandlerImpl.b, 1, "handleApolloSetModel fail ret: " + ((FromServiceMsg)localObject1).getResultCode());
          ApolloRequestCallbackManager.a.a(l, false, ((FromServiceMsg)localObject1).getResultCode(), ((FromServiceMsg)localObject1).getBusinessFailMsg());
        }
      }
    }
  }
  
  @ApolloRequestReceive(a="apollo_core.set_status")
  public final void handleChangeApolloStatus(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject1 = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    if (localObject1 != null)
    {
      Intent localIntent = paramApolloRequestReceiveParams.jdField_a_of_type_AndroidContentIntent;
      if (localIntent != null)
      {
        Object localObject2 = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject2 != null)
        {
          ApolloExtensionHandlerImpl localApolloExtensionHandlerImpl = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionHandlerImpl;
          if (localApolloExtensionHandlerImpl != null)
          {
            long l = localIntent.getLongExtra("index", -1L);
            if (((FromServiceMsg)localObject1).isSuccess()) {
              for (;;)
              {
                try
                {
                  localObject1 = new WebSSOAgent.UniSsoServerRsp();
                  ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte);
                  int i = localIntent.getIntExtra("apollo_status", 0);
                  QLog.d(ApolloExtensionHandlerImpl.b, 1, "handleChangeApolloStatus ret: " + ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() + ", apollo status:" + i);
                  paramApolloRequestReceiveParams = new Pair(((QQAppInterface)localObject2).getCurrentUin(), Integer.valueOf(i));
                  if (0L == ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get())
                  {
                    if (i != 0)
                    {
                      localApolloExtensionHandlerImpl.notifyUI(3, true, paramApolloRequestReceiveParams);
                      paramApolloRequestReceiveParams = ((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
                      Intrinsics.checkExpressionValueIsNotNull(paramApolloRequestReceiveParams, "app.getRuntimeService(IA…ava, ProcessConstant.ALL)");
                      paramApolloRequestReceiveParams = (IApolloManagerService)paramApolloRequestReceiveParams;
                      localObject2 = paramApolloRequestReceiveParams.getApolloBaseInfo(((QQAppInterface)localObject2).getCurrentUin());
                      if (localObject2 == null) {
                        break;
                      }
                      ((ApolloBaseInfo)localObject2).apolloStatus = i;
                      paramApolloRequestReceiveParams.saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject2);
                      paramApolloRequestReceiveParams = ApolloRequestCallbackManager.a;
                      if (((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() != 0L) {
                        break label341;
                      }
                      bool = true;
                      paramApolloRequestReceiveParams.a(l, bool, ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get(), ((WebSSOAgent.UniSsoServerRsp)localObject1).errmsg.get());
                      return;
                    }
                    localApolloExtensionHandlerImpl.notifyUI(3, false, paramApolloRequestReceiveParams);
                    continue;
                  }
                  localApolloExtensionHandlerImpl.notifyUI(3, false, paramApolloRequestReceiveParams);
                }
                catch (Exception paramApolloRequestReceiveParams)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e(ApolloExtensionHandlerImpl.b, 2, "handleChangeApolloStatus failed ", (Throwable)paramApolloRequestReceiveParams);
                  }
                  ApolloRequestCallbackManager.a.a(l, false, -1L, "exception");
                  return;
                }
                continue;
                label341:
                boolean bool = false;
              }
            }
            QLog.e(ApolloExtensionHandlerImpl.b, 1, "handleChangeApolloStatus fail ret: " + ((FromServiceMsg)localObject1).getResultCode());
            ApolloRequestCallbackManager.a.a(l, false, ((FromServiceMsg)localObject1).getResultCode(), ((FromServiceMsg)localObject1).getBusinessFailMsg());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.request.ApolloRequestReceiveManager
 * JD-Core Version:    0.7.0.1
 */