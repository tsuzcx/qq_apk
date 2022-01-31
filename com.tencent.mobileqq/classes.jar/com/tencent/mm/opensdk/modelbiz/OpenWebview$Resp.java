package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class OpenWebview$Resp
  extends BaseResp
{
  public String result;
  
  public OpenWebview$Resp() {}
  
  public OpenWebview$Resp(Bundle paramBundle)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp
 * JD-Core Version:    0.7.0.1
 */