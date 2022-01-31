package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class ShowMessageFromWX$Req
  extends BaseReq
{
  public String country;
  public String lang;
  public WXMediaMessage message;
  
  public ShowMessageFromWX$Req() {}
  
  public ShowMessageFromWX$Req(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    if (this.message == null) {
      return false;
    }
    return this.message.checkArgs();
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.lang = paramBundle.getString("_wxapi_showmessage_req_lang");
    this.country = paramBundle.getString("_wxapi_showmessage_req_country");
    this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
  }
  
  public int getType()
  {
    return 4;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    Bundle localBundle = WXMediaMessage.Builder.toBundle(this.message);
    super.toBundle(localBundle);
    paramBundle.putString("_wxapi_showmessage_req_lang", this.lang);
    paramBundle.putString("_wxapi_showmessage_req_country", this.country);
    paramBundle.putAll(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req
 * JD-Core Version:    0.7.0.1
 */