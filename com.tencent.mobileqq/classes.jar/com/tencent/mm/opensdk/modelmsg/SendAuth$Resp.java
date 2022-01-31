package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class SendAuth$Resp
  extends BaseResp
{
  public static final int ERR_SCOPE_SNSAPI_WXAAPP_INFO_CAN_ONLY_AUTHORIZED_SEPARATELY = -1000;
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
  public boolean authResult = false;
  public String code;
  public String country;
  public String lang;
  public String state;
  public String url;
  
  public SendAuth$Resp() {}
  
  public SendAuth$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    if ((this.state != null) && (this.state.length() > 1024))
    {
      Log.e("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
      return false;
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.code = paramBundle.getString("_wxapi_sendauth_resp_token");
    this.state = paramBundle.getString("_wxapi_sendauth_resp_state");
    this.url = paramBundle.getString("_wxapi_sendauth_resp_url");
    this.lang = paramBundle.getString("_wxapi_sendauth_resp_lang");
    this.country = paramBundle.getString("_wxapi_sendauth_resp_country");
    this.authResult = paramBundle.getBoolean("_wxapi_sendauth_resp_auth_result");
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_sendauth_resp_token", this.code);
    paramBundle.putString("_wxapi_sendauth_resp_state", this.state);
    paramBundle.putString("_wxapi_sendauth_resp_url", this.url);
    paramBundle.putString("_wxapi_sendauth_resp_lang", this.lang);
    paramBundle.putString("_wxapi_sendauth_resp_country", this.country);
    paramBundle.putBoolean("_wxapi_sendauth_resp_auth_result", this.authResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendAuth.Resp
 * JD-Core Version:    0.7.0.1
 */