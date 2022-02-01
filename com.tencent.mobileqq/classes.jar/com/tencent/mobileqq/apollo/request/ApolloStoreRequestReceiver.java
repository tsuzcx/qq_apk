package com.tencent.mobileqq.apollo.request;

import android.content.Intent;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/ApolloStoreRequestReceiver;", "", "()V", "handleReportApolloStoreStabilityResp", "", "params", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams;", "handleSetZanCount", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloStoreRequestReceiver
{
  public static final ApolloStoreRequestReceiver.Companion a = new ApolloStoreRequestReceiver.Companion(null);
  
  @RequestRoute(a="apollo_dc_report.service_monit")
  private final void handleReportApolloStoreStabilityResp(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject = paramApolloRequestReceiveParams.c;
    if (localObject != null)
    {
      Intent localIntent = paramApolloRequestReceiveParams.b;
      if (localIntent != null)
      {
        paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.d;
        if (paramApolloRequestReceiveParams != null)
        {
          if ((localIntent != null) && (paramApolloRequestReceiveParams != null) && (localObject != null) && (((FromServiceMsg)localObject).isSuccess()))
          {
            try
            {
              localObject = new WebSSOAgent.UniSsoServerRsp();
              ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(paramApolloRequestReceiveParams);
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]ApolloStoreRequestReceiver_apollo_store_stability_", 2, new Object[] { "[handleReportApolloStoreStabilityResp] ret=", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject).ret.get()) });
              }
              if (((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() != 0L)
              {
                QLog.e("[cmshow]ApolloStoreRequestReceiver_apollo_store_stability_", 1, new Object[] { "[handleReportApolloStoreStabilityResp] failed ret:", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject).ret.get()) });
                return;
              }
            }
            catch (Exception paramApolloRequestReceiveParams)
            {
              QLog.e("[cmshow]ApolloStoreRequestReceiver_apollo_store_stability_", 1, "[handleReportApolloStoreStabilityResp] exception=", (Throwable)paramApolloRequestReceiveParams);
            }
            return;
          }
          QLog.e("[cmshow]ApolloStoreRequestReceiver_apollo_store_stability_", 1, "[handleReportApolloStoreStabilityResp] failed");
        }
      }
    }
  }
  
  @RequestRoute(a="apollo_extend.zan")
  public final void handleSetZanCount(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject1 = paramApolloRequestReceiveParams.c;
    if (localObject1 != null)
    {
      Object localObject2 = paramApolloRequestReceiveParams.d;
      if (localObject2 != null)
      {
        paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.e;
        if (paramApolloRequestReceiveParams != null)
        {
          if ((localObject2 != null) && (((FromServiceMsg)localObject1).isSuccess())) {
            try
            {
              localObject1 = new WebSSOAgent.UniSsoServerRsp();
              ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom((byte[])localObject2);
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handleSetZanCount ret: ");
                ((StringBuilder)localObject2).append(((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get());
                QLog.d("[cmshow]ApolloStoreRequestReceiver", 2, ((StringBuilder)localObject2).toString());
              }
              if (0L == ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get())
              {
                paramApolloRequestReceiveParams.notifyUI(7, true, Integer.valueOf(new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get()).getJSONObject("data").optInt("zancount")));
                return;
              }
              paramApolloRequestReceiveParams.notifyUI(7, false, Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get()));
              return;
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.e("[cmshow]ApolloStoreRequestReceiver", 2, "handleChangeApolloStatus failed ", (Throwable)localException);
              }
              paramApolloRequestReceiveParams.notifyUI(7, false, Integer.valueOf(-1));
              return;
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleChangeApolloStatus fail ret: ");
          ((StringBuilder)localObject2).append(localException.getResultCode());
          QLog.e("[cmshow]ApolloStoreRequestReceiver", 2, ((StringBuilder)localObject2).toString());
          paramApolloRequestReceiveParams.notifyUI(7, false, Integer.valueOf(localException.getResultCode()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.request.ApolloStoreRequestReceiver
 * JD-Core Version:    0.7.0.1
 */