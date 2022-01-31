package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

public class WXWebpageObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXWebpageObject";
  public String canvasPageXml;
  public String extInfo;
  public String webpageUrl;
  
  public WXWebpageObject() {}
  
  public WXWebpageObject(String paramString)
  {
    this.webpageUrl = paramString;
  }
  
  public boolean checkArgs()
  {
    if ((this.webpageUrl == null) || (this.webpageUrl.length() == 0) || (this.webpageUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXWebpageObject", "checkArgs fail, webpageUrl is invalid");
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxwebpageobject_extInfo", this.extInfo);
    paramBundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
    paramBundle.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
  }
  
  public int type()
  {
    return 5;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.extInfo = paramBundle.getString("_wxwebpageobject_extInfo");
    this.webpageUrl = paramBundle.getString("_wxwebpageobject_webpageUrl");
    this.canvasPageXml = paramBundle.getString("_wxwebpageobject_canvaspagexml");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXWebpageObject
 * JD-Core Version:    0.7.0.1
 */