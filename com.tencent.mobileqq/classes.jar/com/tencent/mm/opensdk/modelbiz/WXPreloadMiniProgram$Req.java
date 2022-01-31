package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class WXPreloadMiniProgram$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.WXPreloadMiniProgram.Req";
  public String extData = "";
  public int miniprogramType = 0;
  public String path = "";
  public String userName;
  
  public final boolean checkArgs()
  {
    if (d.b(this.userName))
    {
      Log.e("MicroMsg.SDK.WXPreloadMiniProgram.Req", "userName is null");
      return false;
    }
    if ((this.miniprogramType < 0) || (this.miniprogramType > 2))
    {
      Log.e("MicroMsg.SDK.WXPreloadMiniProgram.Req", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
      return false;
    }
    return true;
  }
  
  public final int getType()
  {
    return 28;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wxminiprogram_username", this.userName);
    paramBundle.putString("_launch_wxminiprogram_path", this.path);
    paramBundle.putString("_launch_wxminiprogram_extData", this.extData);
    paramBundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Req
 * JD-Core Version:    0.7.0.1
 */