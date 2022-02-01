package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXNontaxPay$Resp
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
    this.wxOrderId = paramBundle.getString("_wxapi_nontax_pay_order_id");
  }
  
  public final int getType()
  {
    return 21;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    paramBundle.putString("_wxapi_nontax_pay_order_id", this.wxOrderId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Resp
 * JD-Core Version:    0.7.0.1
 */