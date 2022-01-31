package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXInvoiceAuthInsert
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXInvoiceAuthInsert.Req";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String url;
    
    public final boolean checkArgs()
    {
      if (d.h(this.url))
      {
        Log.i("MicroMsg.SDK.WXInvoiceAuthInsert.Req", "url should not be empty");
        return false;
      }
      if (this.url.length() > 10240)
      {
        Log.e("MicroMsg.SDK.WXInvoiceAuthInsert.Req", "url must be in 10k");
        return false;
      }
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.url = paramBundle.getString("_wxapi_invoice_auth_insert_req_url");
    }
    
    public final int getType()
    {
      return 20;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      paramBundle.putString("_wxapi_invoice_auth_insert_req_url", this.url);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public String wxOrderId;
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.wxOrderId = paramBundle.getString("_wxapi_invoice_auth_insert_order_id");
    }
    
    public final int getType()
    {
      return 20;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      paramBundle.putString("_wxapi_invoice_auth_insert_order_id", this.wxOrderId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert
 * JD-Core Version:    0.7.0.1
 */