package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public final class WXPayInsurance$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.WXPayInsurance.Req";
  private static final int URL_LENGTH_LIMIT = 10240;
  public String url;
  
  public boolean checkArgs()
  {
    if (b.b(this.url))
    {
      Log.i("MicroMsg.SDK.WXPayInsurance.Req", "url should not be empty");
      return false;
    }
    if (this.url.length() > 10240)
    {
      Log.e("MicroMsg.SDK.WXPayInsurance.Req", "url must be in 10k");
      return false;
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.url = paramBundle.getString("_wxapi_pay_insourance_req_url");
  }
  
  public int getType()
  {
    return 22;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    paramBundle.putString("_wxapi_pay_insourance_req_url", this.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Req
 * JD-Core Version:    0.7.0.1
 */