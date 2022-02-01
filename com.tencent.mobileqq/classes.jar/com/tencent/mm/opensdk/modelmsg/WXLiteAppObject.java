package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXLiteAppObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXLiteAppObject";
  public String path;
  public String query;
  public String userName;
  public String webpageUrl;
  
  public boolean checkArgs()
  {
    if (b.b(this.userName))
    {
      Log.e("MicroMsg.SDK.WXLiteAppObject", "userName is null");
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxliteapp_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxliteapp_username", this.userName);
    paramBundle.putString("_wxliteapp_path", this.path);
    paramBundle.putString("_wxliteapp_query", this.query);
  }
  
  public int type()
  {
    return 68;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.webpageUrl = paramBundle.getString("_wxliteapp_webpageurl");
    this.userName = paramBundle.getString("_wxliteapp_username");
    this.path = paramBundle.getString("_wxliteapp_path");
    this.query = paramBundle.getString("_wxliteapp_query");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXLiteAppObject
 * JD-Core Version:    0.7.0.1
 */