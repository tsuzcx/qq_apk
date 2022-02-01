package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXPreloadMiniProgram$Resp
  extends BaseResp
{
  public String extMsg;
  
  public WXPreloadMiniProgram$Resp() {}
  
  public WXPreloadMiniProgram$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.extMsg = paramBundle.getString("_launch_wxminiprogram_ext_msg");
  }
  
  public final int getType()
  {
    return 28;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Resp
 * JD-Core Version:    0.7.0.1
 */