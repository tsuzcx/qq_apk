package com.tencent.mobileqq.apollo.store;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloPandora;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class ApolloBoxEnterView$3
  implements Runnable
{
  ApolloBoxEnterView$3(ApolloBoxEnterView paramApolloBoxEnterView, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject2;
    label636:
    do
    {
      try
      {
        if (ApolloBoxEnterView.a(this.this$0) == null) {
          return;
        }
        localQQAppInterface = (QQAppInterface)ApolloBoxEnterView.a(this.this$0).get();
        if (localQQAppInterface == null) {
          return;
        }
        localObject2 = this.a.getByteArray("extra_data");
        str = this.a.getString("extra_callbackid");
        localObject1 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom((byte[])localObject2);
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleQueryPandora ret: ");
          ((StringBuilder)localObject2).append(((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get());
          ((StringBuilder)localObject2).append(", msg: ");
          ((StringBuilder)localObject2).append(((WebSSOAgent.UniSsoServerRsp)localObject1).errmsg.get());
          QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject2).toString());
        }
        if (0L != ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get()) {
          break label636;
        }
        localObject2 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get()).optJSONObject("data");
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("handleQueryPandora ret: ");
        ((StringBuilder)localObject3).append(((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get());
        ((StringBuilder)localObject3).append(", dataObj: ");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject3).toString());
      }
      catch (Exception localException)
      {
        QQAppInterface localQQAppInterface;
        String str;
        Object localObject1;
        Object localObject3;
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl;
        if (!QLog.isColorLevel()) {
          break label636;
        }
        QLog.e("[cmshow]ApolloBoxEnterView", 2, "handleQueryPandora failed ", localException);
      }
      localObject3 = ((JSONObject)localObject2).optJSONObject("drawerData");
      if (localObject3 == null) {
        return;
      }
      localObject1 = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("");
      localObject2 = localApolloDaoManagerServiceImpl.getApolloPandora(((StringBuilder)localObject1).toString(), true);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ApolloPandora();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("");
        ((ApolloPandora)localObject1).uin = ((StringBuilder)localObject2).toString();
      }
      ((ApolloPandora)localObject1).checkPoint = ((JSONObject)localObject3).optLong("checkpoint");
      ((ApolloPandora)localObject1).queryInterval = ((JSONObject)localObject3).optInt("queryInterval");
      ((ApolloPandora)localObject1).updateTime = System.currentTimeMillis();
      ((ApolloPandora)localObject1).mBoxTipUrl = ((JSONObject)localObject3).optString("iconUrl");
      if ((QLog.isColorLevel()) && (TextUtils.isEmpty(((ApolloPandora)localObject1).mBoxTipUrl))) {
        ((ApolloPandora)localObject1).mBoxTipUrl = "https://cmshow.gtimg.cn/client/zip/box_gif_2016_11_13.zip";
      }
      ((ApolloPandora)localObject1).boxType = ((short)((JSONObject)localObject3).optInt("objType"));
      ((ApolloPandora)localObject1).boxSubType = ((short)((JSONObject)localObject3).optInt("objSubType"));
      if (!TextUtils.isEmpty(((ApolloPandora)localObject1).mBoxTipUrl))
      {
        ((ApolloPandora)localObject1).canSteal = 1;
        ((ApolloPandora)localObject1).hadStolen = 0;
      }
      else
      {
        ((ApolloPandora)localObject1).canSteal = 0;
      }
      localApolloDaoManagerServiceImpl.saveOrUpdateApolloPandora((ApolloPandora)localObject1);
      if ((ApolloBoxEnterView.a(this.this$0) != null) && (ApolloBoxEnterView.a(this.this$0).equals(String.valueOf(str))))
      {
        ApolloBoxEnterView.a(this.this$0, (ApolloPandora)localObject1);
        ApolloBoxEnterView.a(this.this$0).sendEmptyMessage(255);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleQueryPandora canSteal: ");
        ((StringBuilder)localObject2).append(((ApolloPandora)localObject1).canSteal);
        ((StringBuilder)localObject2).append(", hadStolen: ");
        ((StringBuilder)localObject2).append(((ApolloPandora)localObject1).hadStolen);
        ((StringBuilder)localObject2).append(",boxType:");
        ((StringBuilder)localObject2).append(((ApolloPandora)localObject1).boxType);
        ((StringBuilder)localObject2).append(", checkPoint: ");
        ((StringBuilder)localObject2).append(TimeFormatterUtils.a(localQQAppInterface.getApp(), ((ApolloPandora)localObject1).checkPoint * 1000L));
        QLog.d("[cmshow]ApolloBoxEnterView", 2, ((StringBuilder)localObject2).toString());
        return;
      }
      return;
    } while (localObject2 != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBoxEnterView.3
 * JD-Core Version:    0.7.0.1
 */