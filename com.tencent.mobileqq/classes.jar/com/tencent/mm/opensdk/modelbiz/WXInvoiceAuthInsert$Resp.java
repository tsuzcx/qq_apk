package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXInvoiceAuthInsert$Resp
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Resp
 * JD-Core Version:    0.7.0.1
 */