package com.tencent.mobileqq.ark.share.core;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessorCallback;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class ArkAsyncShareMsgManager$1
  implements IArkMessagePreprocessorCallback
{
  ArkAsyncShareMsgManager$1(ArkAsyncShareMsgManager paramArkAsyncShareMsgManager) {}
  
  public void a(boolean paramBoolean, JSONObject paramJSONObject, Object paramObject)
  {
    Object localObject1 = (AppRuntime)ArkAsyncShareMsgManager.a(this.a).get();
    if ((localObject1 != null) && (paramObject != null) && ((paramObject instanceof Bundle)))
    {
      Object localObject3 = (Bundle)paramObject;
      long l = ((Bundle)localObject3).getLong("key_process_message_uniseq");
      paramObject = ((Bundle)localObject3).getString("key_process_message_friend_uin");
      int i = ((Bundle)localObject3).getInt("key_process_message_uin_type");
      synchronized (ArkAsyncShareMsgManager.a(this.a))
      {
        if ((Bundle)ArkAsyncShareMsgManager.a(this.a).get(Long.valueOf(l)) != null)
        {
          ArkAsyncShareMsgManager.a(this.a).remove(Long.valueOf(l));
          ArkAsyncShareMsgManager.a(this.a).removeMessages(1, localObject3);
          if (!(localObject1 instanceof QQAppInterface))
          {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.sArkMsgPrepCallback.failed should in main process, uniseq=", Long.valueOf(l) });
            return;
          }
          localObject1 = (QQAppInterface)localObject1;
          paramObject = ((QQAppInterface)localObject1).getMessageFacade().b(paramObject, i, l);
          if (!(paramObject instanceof MessageForArkApp))
          {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.sArkMsgPrepCallback find ArkMsg failed!");
            return;
          }
          ??? = (MessageForArkApp)paramObject;
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.sArkMsgPrepCallback  uniseq=", Long.valueOf(l), ", processState=", Integer.valueOf(((MessageForArkApp)???).getProcessState()), ", success=", Boolean.valueOf(paramBoolean), String.format(" ,msg=%h", new Object[] { ??? }), ", this=", ((MessageForArkApp)???).getBaseInfoString(), ", msgJson=", paramJSONObject });
          }
          if (((MessageForArkApp)???).ark_app_message != null)
          {
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("appid", ((MessageForArkApp)???).ark_app_message.appName);
            if (paramBoolean) {
              paramObject = "1";
            } else {
              paramObject = "2";
            }
            ((HashMap)localObject3).put("result", paramObject);
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAsyncShareCallback", true, 0L, 0L, (HashMap)localObject3, null);
          }
          if (paramBoolean)
          {
            ((MessageForArkApp)???).updateArkAppMetaData(paramJSONObject);
            ((MessageForArkApp)???).updateProcessStateAndExtraFlag(1002);
            ((MessageForArkApp)???).saveMsgData((QQAppInterface)localObject1);
            ((MessageForArkApp)???).saveMsgExtStrAndFlag((QQAppInterface)localObject1);
            ((QQAppInterface)localObject1).getMessageFacade().b((MessageRecord)???, null);
            return;
          }
          ((MessageForArkApp)???).updateProcessStateAndExtraFlag(1003);
          ((MessageForArkApp)???).saveMsgData((QQAppInterface)localObject1);
          ((MessageForArkApp)???).saveMsgExtStrAndFlag((QQAppInterface)localObject1);
          ((QQAppInterface)localObject1).getMsgCache().a(((MessageForArkApp)???).frienduin, ((MessageForArkApp)???).istroop, ((MessageForArkApp)???).uniseq);
          ArkAsyncShareMsgManager.a(this.a, (QQAppInterface)localObject1, (MessageForArkApp)???);
          return;
        }
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.sArkMsgPrepCallback.failed for msg callback timeout uniseq=", Long.valueOf(l) });
        return;
      }
    }
    QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.sArkMsgPrepCallback invalid param app=", localObject1, ",userData=", paramObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager.1
 * JD-Core Version:    0.7.0.1
 */