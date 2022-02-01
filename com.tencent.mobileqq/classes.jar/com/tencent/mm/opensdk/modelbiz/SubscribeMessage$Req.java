package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class SubscribeMessage$Req
  extends BaseReq
{
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
  public String reserved;
  public int scene;
  public String templateID;
  
  public SubscribeMessage$Req() {}
  
  public SubscribeMessage$Req(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    String str = this.templateID;
    if ((str != null) && (str.length() != 0)) {
      if (this.templateID.length() > 1024) {
        str = "checkArgs fail, templateID is too long";
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.SubscribeMessage.Req", str);
      return false;
      str = this.reserved;
      if ((str != null) && (str.length() > 1024))
      {
        str = "checkArgs fail, reserved is too long";
      }
      else
      {
        return true;
        str = "checkArgs fail, templateID is null";
      }
    }
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.scene = paramBundle.getInt("_wxapi_subscribemessage_req_scene");
    this.templateID = paramBundle.getString("_wxapi_subscribemessage_req_templateid");
    this.reserved = paramBundle.getString("_wxapi_subscribemessage_req_reserved");
  }
  
  public int getType()
  {
    return 18;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putInt("_wxapi_subscribemessage_req_scene", this.scene);
    paramBundle.putString("_wxapi_subscribemessage_req_templateid", this.templateID);
    paramBundle.putString("_wxapi_subscribemessage_req_reserved", this.reserved);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Req
 * JD-Core Version:    0.7.0.1
 */