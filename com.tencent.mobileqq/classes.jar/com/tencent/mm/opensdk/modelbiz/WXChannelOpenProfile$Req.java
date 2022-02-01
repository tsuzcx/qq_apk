package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelOpenProfile$Req
  extends BaseReq
{
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.WXChannelOpenProfile.Req";
  public String userName;
  
  public boolean checkArgs()
  {
    if (b.b(this.userName)) {}
    for (String str = "userName is null";; str = "userName.length too long")
    {
      Log.e("MicroMsg.SDK.WXChannelOpenProfile.Req", str);
      return false;
      if (this.userName.length() <= 1024) {
        break;
      }
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.userName = paramBundle.getString("_wxapi_finder_userName");
  }
  
  public int getType()
  {
    return 34;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_finder_userName", this.userName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelOpenProfile.Req
 * JD-Core Version:    0.7.0.1
 */