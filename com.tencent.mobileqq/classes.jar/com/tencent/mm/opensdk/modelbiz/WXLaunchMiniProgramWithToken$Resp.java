package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXLaunchMiniProgramWithToken$Resp
  extends BaseResp
{
  public static final int ERR_INVALID_TOKEN = -1000;
  public String extMsg;
  
  public WXLaunchMiniProgramWithToken$Resp() {}
  
  public WXLaunchMiniProgramWithToken$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.extMsg = paramBundle.getString("_launch_wxminiprogram_ext_msg");
  }
  
  public int getType()
  {
    return 29;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Resp
 * JD-Core Version:    0.7.0.1
 */