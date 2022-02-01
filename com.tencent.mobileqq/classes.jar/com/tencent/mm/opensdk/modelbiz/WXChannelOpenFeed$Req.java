package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelOpenFeed$Req
  extends BaseReq
{
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.WXChannelOpenFeed.Req";
  public String feedID;
  public String nonceID;
  public boolean notGetReleatedList;
  
  public boolean checkArgs()
  {
    String str;
    if (b.b(this.feedID)) {
      str = "feedID is null";
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXChannelOpenFeed.Req", str);
      return false;
      if (b.b(this.nonceID))
      {
        str = "nonceID is null";
      }
      else if (this.feedID.length() > 1024)
      {
        str = "feedID.length too long!";
      }
      else
      {
        if (this.nonceID.length() <= 1024) {
          break;
        }
        str = "nonceID.length too long!";
      }
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.feedID = paramBundle.getString("_wxapi_finder_feedID");
    this.nonceID = paramBundle.getString("_wxapi_finder_nonceID");
    this.notGetReleatedList = paramBundle.getBoolean("_wxapi_finder_notGetReleatedList");
  }
  
  public int getType()
  {
    return 36;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_finder_feedID", this.feedID);
    paramBundle.putString("_wxapi_finder_nonceID", this.nonceID);
    paramBundle.putBoolean("_wxapi_finder_notGetReleatedList", this.notGetReleatedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelOpenFeed.Req
 * JD-Core Version:    0.7.0.1
 */