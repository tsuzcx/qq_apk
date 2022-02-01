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
import org.json.JSONObject;

class ArkAsyncShareMsgManager$1
  implements IArkMessagePreprocessorCallback
{
  ArkAsyncShareMsgManager$1(ArkAsyncShareMsgManager paramArkAsyncShareMsgManager) {}
  
  public void a(boolean paramBoolean, JSONObject paramJSONObject, Object arg3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ArkAsyncShareMsgManager.a(this.a).get();
    if ((localQQAppInterface == null) || (??? == null) || (!(??? instanceof Bundle)))
    {
      QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.sArkMsgPrepCallback invalid param app=", localQQAppInterface, ",userData=", ??? });
      return;
    }
    Object localObject1 = (Bundle)???;
    long l = ((Bundle)localObject1).getLong("key_process_message_uniseq");
    Object localObject2 = ((Bundle)localObject1).getString("key_process_message_friend_uin");
    int i = ((Bundle)localObject1).getInt("key_process_message_uin_type");
    synchronized (ArkAsyncShareMsgManager.a(this.a))
    {
      if ((Bundle)ArkAsyncShareMsgManager.a(this.a).get(Long.valueOf(l)) != null)
      {
        ArkAsyncShareMsgManager.a(this.a).remove(Long.valueOf(l));
        ArkAsyncShareMsgManager.a(this.a).removeMessages(1, localObject1);
        ??? = localQQAppInterface.getMessageFacade().b((String)localObject2, i, l);
        if ((??? == null) || (!(??? instanceof MessageForArkApp))) {
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.sArkMsgPrepCallback find ArkMsg failed!");
        }
      }
      else
      {
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.sArkMsgPrepCallback.failed for msg callback timeout uniseq=", Long.valueOf(l) });
        return;
      }
    }
    localObject1 = (MessageForArkApp)???;
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.sArkMsgPrepCallback  uniseq=", Long.valueOf(l), ", processState=", Integer.valueOf(((MessageForArkApp)localObject1).getProcessState()), ", success=", Boolean.valueOf(paramBoolean), String.format(" ,msg=%h", new Object[] { localObject1 }), ", this=", ((MessageForArkApp)localObject1).getBaseInfoString(), ", msgJson=", paramJSONObject });
    }
    if (((MessageForArkApp)localObject1).ark_app_message != null)
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("appid", ((MessageForArkApp)localObject1).ark_app_message.appName);
      if (!paramBoolean) {
        break label441;
      }
    }
    label441:
    for (??? = "1";; ??? = "2")
    {
      ((HashMap)localObject2).put("result", ???);
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAsyncShareCallback", true, 0L, 0L, (HashMap)localObject2, null);
      if (!paramBoolean) {
        break;
      }
      ((MessageForArkApp)localObject1).updateArkAppMetaData(paramJSONObject);
      ((MessageForArkApp)localObject1).updateProcessStateAndExtraFlag(1002);
      ((MessageForArkApp)localObject1).saveMsgData(localQQAppInterface);
      ((MessageForArkApp)localObject1).saveMsgExtStrAndFlag(localQQAppInterface);
      localQQAppInterface.getMessageFacade().b((MessageRecord)localObject1, null);
      return;
    }
    ((MessageForArkApp)localObject1).updateProcessStateAndExtraFlag(1003);
    ((MessageForArkApp)localObject1).saveMsgData(localQQAppInterface);
    ((MessageForArkApp)localObject1).saveMsgExtStrAndFlag(localQQAppInterface);
    localQQAppInterface.getMsgCache().a(((MessageForArkApp)localObject1).frienduin, ((MessageForArkApp)localObject1).istroop, ((MessageForArkApp)localObject1).uniseq);
    ArkAsyncShareMsgManager.a(this.a, localQQAppInterface, (MessageForArkApp)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager.1
 * JD-Core Version:    0.7.0.1
 */