package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public final class WXPreloadMiniProgramEnvironment$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.WXPreloadMiniProgramEnvironment.Req";
  public String extData = "";
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public int getType()
  {
    return 32;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_preload_wxminiprogram_environment_extData", this.extData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgramEnvironment.Req
 * JD-Core Version:    0.7.0.1
 */