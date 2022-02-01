package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class SubscribeMiniProgramMsg$Req
  extends BaseReq
{
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
  public String miniProgramAppId;
  
  public SubscribeMiniProgramMsg$Req() {}
  
  public SubscribeMiniProgramMsg$Req(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    if ((this.miniProgramAppId == null) || (this.miniProgramAppId.length() == 0))
    {
      Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, miniProgramAppId is null");
      return false;
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.miniProgramAppId = paramBundle.getString("_wxapi_subscribeminiprogram_req_miniprogramappid");
  }
  
  public int getType()
  {
    return 23;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_subscribeminiprogram_req_miniprogramappid", this.miniProgramAppId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Req
 * JD-Core Version:    0.7.0.1
 */