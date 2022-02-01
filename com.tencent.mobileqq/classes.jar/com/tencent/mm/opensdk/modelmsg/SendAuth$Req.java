package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class SendAuth$Req
  extends BaseReq
{
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
  public String extData;
  public String scope;
  public String state;
  
  public SendAuth$Req() {}
  
  public SendAuth$Req(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    String str = this.scope;
    if ((str != null) && (str.length() != 0) && (this.scope.length() <= 1024))
    {
      str = this.state;
      if ((str == null) || (str.length() <= 1024)) {}
    }
    for (str = "checkArgs fail, state is invalid";; str = "checkArgs fail, scope is invalid")
    {
      Log.e("MicroMsg.SDK.SendAuth.Req", str);
      return false;
      return true;
    }
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.scope = paramBundle.getString("_wxapi_sendauth_req_scope");
    this.state = paramBundle.getString("_wxapi_sendauth_req_state");
    this.extData = paramBundle.getString("_wxapi_sendauth_req_ext_data");
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_sendauth_req_scope", this.scope);
    paramBundle.putString("_wxapi_sendauth_req_state", this.state);
    paramBundle.putString("_wxapi_sendauth_req_ext_data", this.extData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendAuth.Req
 * JD-Core Version:    0.7.0.1
 */