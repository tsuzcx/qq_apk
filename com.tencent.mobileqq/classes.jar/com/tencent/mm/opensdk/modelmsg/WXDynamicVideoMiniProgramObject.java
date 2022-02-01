package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXDynamicVideoMiniProgramObject
  extends WXMiniProgramObject
{
  private static final String TAG = "MicroMsg.SDK.WXDynamicVideoMiniProgramObject";
  public String appThumbUrl;
  public String videoSource;
  
  public boolean checkArgs()
  {
    String str;
    if (b.b(this.webpageUrl)) {
      str = "webPageUrl is null";
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.WXDynamicVideoMiniProgramObject", str);
      return false;
      if (b.b(this.userName))
      {
        str = "userName is null";
      }
      else
      {
        int i = this.miniprogramType;
        if ((i >= 0) && (i <= 2)) {
          return true;
        }
        str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxminiprogram_username", this.userName);
    paramBundle.putString("_wxminiprogram_path", this.path);
    paramBundle.putString("_wxminiprogram_videoSource", this.videoSource);
    paramBundle.putString("_wxminiprogram_appThumbUrl", this.appThumbUrl);
    paramBundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
    paramBundle.putInt("_wxminiprogram_type", this.miniprogramType);
    paramBundle.putInt("_wxminiprogram_disableforward", this.disableforward);
  }
  
  public int type()
  {
    return 46;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.webpageUrl = paramBundle.getString("_wxminiprogram_webpageurl");
    this.userName = paramBundle.getString("_wxminiprogram_username");
    this.path = paramBundle.getString("_wxminiprogram_path");
    this.videoSource = paramBundle.getString("_wxminiprogram_videoSource");
    this.appThumbUrl = paramBundle.getString("_wxminiprogram_appThumbUrl");
    this.withShareTicket = paramBundle.getBoolean("_wxminiprogram_withsharetiket");
    this.miniprogramType = paramBundle.getInt("_wxminiprogram_type");
    this.disableforward = paramBundle.getInt("_wxminiprogram_disableforward");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject
 * JD-Core Version:    0.7.0.1
 */