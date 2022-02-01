package com.tencent.mobileqq.activity.qwallet;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class PublicQuickPayManager$1
  extends ResultReceiver
{
  PublicQuickPayManager$1(PublicQuickPayManager paramPublicQuickPayManager, Handler paramHandler, PublicQuickPayManager.QQWalletPayCompletionImp paramQQWalletPayCompletionImp, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    paramInt = -2;
    Object localObject = paramBundle.getString("result");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (localObject != null) {
          paramInt = ((JSONObject)localObject).optInt("resultCode", -2);
        }
        if ((paramInt == -3) || (paramInt == -4) || (paramInt == -6)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPublicQuickPayManager.a();
        }
        PublicQuickPayManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPublicQuickPayManager, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPublicQuickPayManager$QQWalletPayCompletionImp, paramInt, paramBundle.getString("retmsg"), paramBundle.getString("payTime"), this.jdField_a_of_type_JavaLangString);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      paramInt = -2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager.1
 * JD-Core Version:    0.7.0.1
 */