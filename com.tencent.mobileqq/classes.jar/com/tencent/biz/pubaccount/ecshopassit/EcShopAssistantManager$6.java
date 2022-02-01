package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean.PromotionConfBean;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class EcShopAssistantManager$6
  implements Runnable
{
  EcShopAssistantManager$6(QQAppInterface paramQQAppInterface, Context paramContext, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    for (;;)
    {
      MessageRecord localMessageRecord;
      int i;
      try
      {
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b("3046055438", 1008);
        SharedPreferences localSharedPreferences = EcShopAssistantManager.a();
        if (localSharedPreferences.getLong("LAST_MSG_SEQ_RAIN", 0L) == localMessageRecord.uniseq) {
          return;
        }
        if ((localMessageRecord instanceof MessageForStructing))
        {
          Object localObject1 = (MessageForStructing)localMessageRecord;
          if (!(((MessageForStructing)localObject1).structingMsg instanceof StructMsgForGeneralShare)) {
            break;
          }
          localObject1 = ((StructMsgForGeneralShare)((MessageForStructing)localObject1).structingMsg).getStructMsgItemLists();
          if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
            break;
          }
          localObject1 = ((AbsStructMsgElement)((List)localObject1).get(0)).X;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject1 = new JSONObject((String)localObject1);
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((JSONObject)localObject1).optJSONObject("ext");
          if (localObject1 == null) {
            break label389;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("exp_map");
          if (localObject1 == null) {
            break label389;
          }
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label389;
          }
          Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          int j = ((JSONObject)localObject3).optInt("key");
          localObject3 = ((JSONObject)localObject3).optString("value");
          if ((j != EcShopAssistantManager.e) || (!"1".equals(localObject3))) {
            break label382;
          }
          i = 1;
          if (i == 0) {
            break;
          }
          localObject1 = EcshopConfProcessor.a();
          if ((localObject1 == null) || (!EcShopAssistantManager.a(((EcshopConfBean)localObject1).a, localMessageRecord))) {
            break;
          }
          localObject1 = PreloadStaticApi.a(((EcshopConfBean)localObject1).a.d);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          localObject3 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject3).inPurgeable = true;
          ((BitmapFactory.Options)localObject3).inSampleSize = 2;
          EcShopAssistantManager.a(BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject3), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          localObject1 = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject1).putLong("LAST_MSG_SEQ_RAIN", localMessageRecord.uniseq);
          ((SharedPreferences.Editor)localObject1).apply();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("EcShopAssistantManager", 1, localException, new Object[0]);
        return;
      }
      if ((localMessageRecord instanceof MessageForArkApp))
      {
        localObject2 = ((MessageForArkApp)localMessageRecord).ark_app_message;
        if (localObject2 != null)
        {
          localObject2 = ((ArkAppMessage)localObject2).metaList;
          if (!StringUtil.a((String)localObject2))
          {
            localObject2 = new JSONObject((String)localObject2).optJSONObject("gdt");
            if (localObject2 != null)
            {
              localObject2 = ((JSONObject)localObject2).optJSONObject("adInfo");
              continue;
              label382:
              i += 1;
              continue;
              label389:
              i = 0;
              continue;
            }
          }
        }
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager.6
 * JD-Core Version:    0.7.0.1
 */