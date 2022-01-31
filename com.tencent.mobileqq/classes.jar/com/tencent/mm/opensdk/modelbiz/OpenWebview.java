package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.net.URLEncoder;

public class OpenWebview
{
  public static class Req
    extends BaseReq
  {
    private static final int MAX_URL_LENGHT = 10240;
    public String url;
    
    public boolean checkArgs()
    {
      if ((this.url == null) || (this.url.length() < 0)) {}
      while (this.url.length() > 10240) {
        return false;
      }
      return true;
    }
    
    public int getType()
    {
      return 12;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_jump_to_webview_url", URLEncoder.encode(this.url));
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String result;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
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
      this.result = paramBundle.getString("_wxapi_open_webview_result");
    }
    
    public int getType()
    {
      return 12;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_open_webview_result", this.result);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.OpenWebview
 * JD-Core Version:    0.7.0.1
 */