package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXPayInsurance$Resp
  extends BaseResp
{
  public String wxOrderId;
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.wxOrderId = paramBundle.getString("_wxapi_pay_insourance_order_id");
  }
  
  public int getType()
  {
    return 22;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    paramBundle.putString("_wxapi_pay_insourance_order_id", this.wxOrderId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Resp
 * JD-Core Version:    0.7.0.1
 */