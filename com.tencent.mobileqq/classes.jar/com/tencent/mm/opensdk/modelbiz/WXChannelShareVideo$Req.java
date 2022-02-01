package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelShareVideo$Req
  extends BaseReq
{
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.WXChannelShareVideo.Req";
  public String extData;
  public String title;
  public String url;
  public String videoPath;
  
  public boolean checkArgs()
  {
    String str;
    if (b.b(this.videoPath)) {
      str = "videoPath is null";
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXChannelShareVideo.Req", str);
      return false;
      if (this.title.length() > 1024)
      {
        str = "title.length too long";
      }
      else
      {
        if (this.url.length() <= 1024) {
          break;
        }
        str = "url.length too long";
      }
    }
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.videoPath = paramBundle.getString("_wxapi_finder_share_video_path");
    this.title = paramBundle.getString("_wxapi_finder_share_video_title");
    this.url = paramBundle.getString("_wxapi_finder_share_video_url");
    this.extData = paramBundle.getString("_wxapi_finder_share_video_extData");
  }
  
  public int getType()
  {
    return 33;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_finder_share_video_path", this.videoPath);
    paramBundle.putString("_wxapi_finder_share_video_title", this.title);
    paramBundle.putString("_wxapi_finder_share_video_url", this.url);
    paramBundle.putString("_wxapi_finder_share_video_extData", this.extData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo.Req
 * JD-Core Version:    0.7.0.1
 */