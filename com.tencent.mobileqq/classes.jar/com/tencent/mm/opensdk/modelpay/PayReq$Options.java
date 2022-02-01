package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class PayReq$Options
{
  public static final int INVALID_FLAGS = -1;
  public String callbackClassName;
  public int callbackFlags = -1;
  
  public void fromBundle(Bundle paramBundle)
  {
    this.callbackClassName = a.a(paramBundle, "_wxapi_payoptions_callback_classname");
    int i = -1;
    if (paramBundle != null) {
      try
      {
        int j = paramBundle.getInt("_wxapi_payoptions_callback_flags", -1);
        i = j;
      }
      catch (Exception paramBundle)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIntExtra exception:");
        localStringBuilder.append(paramBundle.getMessage());
        Log.e("MicroMsg.IntentUtil", localStringBuilder.toString());
      }
    }
    this.callbackFlags = i;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
    paramBundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.PayReq.Options
 * JD-Core Version:    0.7.0.1
 */