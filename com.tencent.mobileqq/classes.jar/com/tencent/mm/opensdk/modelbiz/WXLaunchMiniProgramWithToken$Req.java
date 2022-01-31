package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class WXLaunchMiniProgramWithToken$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req";
  public String token;
  
  public final boolean checkArgs()
  {
    if (d.b(this.token))
    {
      Log.e("MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req", "token is null");
      return false;
    }
    return true;
  }
  
  public final int getType()
  {
    return 29;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wxminiprogram_token", this.token);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Req
 * JD-Core Version:    0.7.0.1
 */