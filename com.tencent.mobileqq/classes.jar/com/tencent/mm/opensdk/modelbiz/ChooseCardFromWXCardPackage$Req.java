package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class ChooseCardFromWXCardPackage$Req
  extends BaseReq
{
  public String appId;
  public String canMultiSelect;
  public String cardId;
  public String cardSign;
  public String cardType;
  public String locationId;
  public String nonceStr;
  public String signType;
  public String timeStamp;
  
  public boolean checkArgs()
  {
    String str = this.appId;
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
        str = this.cardSign;
        if (str != null) {
          return str.length() > 0;
        }
      }
    }
    return false;
  }
  
  public int getType()
  {
    return 16;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
    paramBundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Req
 * JD-Core Version:    0.7.0.1
 */