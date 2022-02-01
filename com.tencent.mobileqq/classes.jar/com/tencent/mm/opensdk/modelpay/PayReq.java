package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;

public class PayReq
  extends BaseReq
{
  private static final int EXTDATA_MAX_LENGTH = 1024;
  private static final String TAG = "MicroMsg.PaySdk.PayReq";
  public String appId;
  public String extData;
  public String nonceStr;
  public PayReq.Options options;
  public String packageValue;
  public String partnerId;
  public String prepayId;
  public String sign;
  public String signType;
  public String timeStamp;
  
  public boolean checkArgs()
  {
    String str = this.appId;
    if ((str != null) && (str.length() != 0))
    {
      str = this.partnerId;
      if ((str != null) && (str.length() != 0))
      {
        str = this.prepayId;
        if ((str != null) && (str.length() != 0))
        {
          str = this.nonceStr;
          if ((str != null) && (str.length() != 0))
          {
            str = this.timeStamp;
            if ((str != null) && (str.length() != 0))
            {
              str = this.packageValue;
              if ((str != null) && (str.length() != 0))
              {
                str = this.sign;
                if ((str != null) && (str.length() != 0))
                {
                  str = this.extData;
                  if ((str != null) && (str.length() > 1024)) {
                    str = "checkArgs fail, extData length too long";
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.PaySdk.PayReq", str);
      return false;
      return true;
      str = "checkArgs fail, invalid sign";
      continue;
      str = "checkArgs fail, invalid packageValue";
      continue;
      str = "checkArgs fail, invalid timeStamp";
      continue;
      str = "checkArgs fail, invalid nonceStr";
      continue;
      str = "checkArgs fail, invalid prepayId";
      continue;
      str = "checkArgs fail, invalid partnerId";
      continue;
      str = "checkArgs fail, invalid appId";
    }
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.appId = a.b(paramBundle, "_wxapi_payreq_appid");
    this.partnerId = a.b(paramBundle, "_wxapi_payreq_partnerid");
    this.prepayId = a.b(paramBundle, "_wxapi_payreq_prepayid");
    this.nonceStr = a.b(paramBundle, "_wxapi_payreq_noncestr");
    this.timeStamp = a.b(paramBundle, "_wxapi_payreq_timestamp");
    this.packageValue = a.b(paramBundle, "_wxapi_payreq_packagevalue");
    this.sign = a.b(paramBundle, "_wxapi_payreq_sign");
    this.extData = a.b(paramBundle, "_wxapi_payreq_extdata");
    this.signType = a.b(paramBundle, "_wxapi_payreq_sign_type");
    this.options = new PayReq.Options();
    this.options.fromBundle(paramBundle);
  }
  
  public int getType()
  {
    return 5;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_payreq_appid", this.appId);
    paramBundle.putString("_wxapi_payreq_partnerid", this.partnerId);
    paramBundle.putString("_wxapi_payreq_prepayid", this.prepayId);
    paramBundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
    paramBundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
    paramBundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
    paramBundle.putString("_wxapi_payreq_sign", this.sign);
    paramBundle.putString("_wxapi_payreq_extdata", this.extData);
    paramBundle.putString("_wxapi_payreq_sign_type", this.signType);
    PayReq.Options localOptions = this.options;
    if (localOptions != null) {
      localOptions.toBundle(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.PayReq
 * JD-Core Version:    0.7.0.1
 */