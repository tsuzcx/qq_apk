package com.tencent.biz.qrcode.activity;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class QRJumpActivity$2
  implements BusinessObserver
{
  QRJumpActivity$2(QRJumpActivity paramQRJumpActivity, String paramString1, String paramString2, Activity paramActivity, String paramString3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = null;
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityQRJumpActivity.isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QRJumpActivity", 2, String.format("JumpUrl onReceive suc=%b ", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("result");
      QLog.i("QRJumpActivity", 2, String.format("JumpUrl onReceive result=%s", new Object[] { paramBundle }));
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramBundle);
        QRActionEntity localQRActionEntity;
        if (((JSONObject)localObject2).getInt("r") == 0) {
          localQRActionEntity = new QRActionEntity(((JSONObject)localObject2).getString("d"));
        }
        boolean bool;
        Bundle localBundle;
        paramBundle = null;
      }
      catch (Exception paramBundle)
      {
        try
        {
          if (((JSONObject)localObject2).has("wpa"))
          {
            paramBoolean = "1".equals(((JSONObject)localObject2).getString("wpa"));
            bool = ((JSONObject)localObject2).has("extvalue");
            paramInt = i;
            if (((JSONObject)localObject2).has("exttype"))
            {
              if ("2".equals(((JSONObject)localObject2).getString("exttype"))) {
                break label353;
              }
              paramInt = i;
              if ("1".equals(((JSONObject)localObject2).getString("exttype"))) {
                break label353;
              }
            }
            paramBundle = new Bundle();
            if (paramBoolean) {}
            try
            {
              paramBundle.putBoolean("issupportwpa", paramBoolean);
              if ((paramInt != 0) && (bool))
              {
                localObject1 = ((JSONObject)localObject2).getString("exttype");
                localObject2 = ((JSONObject)localObject2).getString("extvalue");
                paramBundle.putString("exttype", (String)localObject1);
                paramBundle.putString("extvalue", (String)localObject2);
              }
              paramBundle.putString("authKey", this.jdField_a_of_type_JavaLangString);
              paramBundle.putString("authSig", this.b);
              localObject1 = paramBundle;
              paramBundle = localQRActionEntity;
            }
            catch (Exception localException)
            {
              localBundle = paramBundle;
              paramBundle = localQRActionEntity;
              continue;
            }
            if (localObject1 != null) {
              QRResultHandler.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRJumpActivity.app, this.jdField_a_of_type_AndroidAppActivity, paramBundle, this.c, (Bundle)localObject1);
            }
            this.jdField_a_of_type_AndroidAppActivity.finish();
            return;
            paramBundle = paramBundle;
            paramBundle = null;
            continue;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle = localQRActionEntity;
          continue;
          paramBoolean = false;
          continue;
        }
      }
      continue;
      label353:
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRJumpActivity.2
 * JD-Core Version:    0.7.0.1
 */