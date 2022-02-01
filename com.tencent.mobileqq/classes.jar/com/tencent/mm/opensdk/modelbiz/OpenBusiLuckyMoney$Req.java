package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class OpenBusiLuckyMoney$Req
  extends BaseReq
{
  private static final int MAX_URL_LENGHT = 10240;
  public String appId;
  public String nonceStr;
  public String packageExt;
  public String signType;
  public String signature;
  public String timeStamp;
  
  public boolean checkArgs()
  {
    String str = this.appId;
    if (str != null)
    {
      if (str.length() <= 0) {
        return false;
      }
      str = this.timeStamp;
      if (str != null)
      {
        if (str.length() <= 0) {
          return false;
        }
        str = this.nonceStr;
        if (str != null)
        {
          if (str.length() <= 0) {
            return false;
          }
          str = this.signType;
          if (str != null)
          {
            if (str.length() <= 0) {
              return false;
            }
            str = this.signature;
            if (str != null) {
              return str.length() > 0;
            }
          }
        }
      }
    }
    return false;
  }
  
  public int getType()
  {
    return 13;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
    paramBundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
    paramBundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
    paramBundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
    paramBundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
    paramBundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.OpenBusiLuckyMoney.Req
 * JD-Core Version:    0.7.0.1
 */