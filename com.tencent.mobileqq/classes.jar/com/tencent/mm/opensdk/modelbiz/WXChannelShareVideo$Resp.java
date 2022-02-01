package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class WXChannelShareVideo$Resp
  extends BaseResp
{
  public String extMsg;
  
  public WXChannelShareVideo$Resp() {}
  
  public WXChannelShareVideo$Resp(Bundle paramBundle)
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
    this.extMsg = paramBundle.getString("_wxapi_finder_extMsg");
  }
  
  public int getType()
  {
    return 33;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_finder_extMsg", this.extMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo.Resp
 * JD-Core Version:    0.7.0.1
 */