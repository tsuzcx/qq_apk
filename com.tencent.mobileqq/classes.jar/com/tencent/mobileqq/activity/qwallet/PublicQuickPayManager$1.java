package com.tencent.mobileqq.activity.qwallet;

import agkb;
import agkd;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicQuickPayManager$1
  extends ResultReceiver
{
  public PublicQuickPayManager$1(agkb paramagkb, Handler paramHandler, agkd paramagkd, String paramString)
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
          this.jdField_a_of_type_Agkb.a();
        }
        agkb.a(this.jdField_a_of_type_Agkb, this.jdField_a_of_type_Agkd, paramInt, paramBundle.getString("retmsg"), paramBundle.getString("payTime"), this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager.1
 * JD-Core Version:    0.7.0.1
 */