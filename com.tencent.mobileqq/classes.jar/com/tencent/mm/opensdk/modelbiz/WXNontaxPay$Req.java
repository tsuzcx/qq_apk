package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class WXNontaxPay$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.WXNontaxPay.Req";
  private static final int URL_LENGTH_LIMIT = 10240;
  public String url;
  
  public final boolean checkArgs()
  {
    if (d.b(this.url))
    {
      Log.i("MicroMsg.SDK.WXNontaxPay.Req", "url should not be empty");
      return false;
    }
    if (this.url.length() > 10240)
    {
      Log.e("MicroMsg.SDK.WXNontaxPay.Req", "url must be in 10k");
      return false;
    }
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.url = paramBundle.getString("_wxapi_nontax_pay_req_url");
  }
  
  public final int getType()
  {
    return 21;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    paramBundle.putString("_wxapi_nontax_pay_req_url", this.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Req
 * JD-Core Version:    0.7.0.1
 */