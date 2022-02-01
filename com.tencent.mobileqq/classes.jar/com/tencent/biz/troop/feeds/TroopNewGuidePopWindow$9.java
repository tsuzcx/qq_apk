package com.tencent.biz.troop.feeds;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotifyAd;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class TroopNewGuidePopWindow$9
  implements HttpWebCgiAsyncTask.Callback
{
  TroopNewGuidePopWindow$9(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("result = ");
      paramBundle.append(paramJSONObject);
      paramBundle.append(", requestCode = ");
      paramBundle.append(paramInt);
      QLog.d("requstTroopNotifyAd", 2, paramBundle.toString());
    }
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONObject("8020205751015455");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optJSONArray("list");
          if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
          {
            paramJSONObject = TroopFeedsDataManager.TroopNotifyAd.a(paramJSONObject.optJSONObject(0));
            if (paramJSONObject != null)
            {
              paramBundle = this.a;
              paramBundle.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd = paramJSONObject;
              paramBundle.d = true;
              if (QLog.isColorLevel())
              {
                paramJSONObject = new StringBuilder();
                paramJSONObject.append("apurl = ");
                paramJSONObject.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd.a);
                paramJSONObject.append(", img = ");
                paramJSONObject.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd.c);
                paramJSONObject.append(", rl = ");
                paramJSONObject.append(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd.b);
                QLog.d("requstTroopNotifyAd", 2, paramJSONObject.toString());
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("TroopTipsPopWindow", 2, "requestTroopNotifyAd result ready -----------");
            }
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
            return;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "requestTroopNotifyAd result null -----------");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.9
 * JD-Core Version:    0.7.0.1
 */