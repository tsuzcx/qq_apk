package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.a;

public class PayReq$Options
{
  public static final int INVALID_FLAGS = -1;
  public String callbackClassName;
  public int callbackFlags = -1;
  
  public void fromBundle(Bundle paramBundle)
  {
    this.callbackClassName = a.b(paramBundle, "_wxapi_payoptions_callback_classname");
    this.callbackFlags = a.a(paramBundle, "_wxapi_payoptions_callback_flags");
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