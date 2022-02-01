package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public final class WXLaunchMiniProgramWithToken$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req";
  public String token;
  
  public boolean checkArgs()
  {
    if (b.b(this.token))
    {
      Log.e("MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req", "token is null");
      return false;
    }
    return true;
  }
  
  public int getType()
  {
    return 29;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wxminiprogram_token", this.token);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Req
 * JD-Core Version:    0.7.0.1
 */