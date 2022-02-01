package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public final class WXLaunchWxaRedirectingPage$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.WXLaunchWxaRedirectingPage.Req";
  public String callbackActivity;
  public String invokeTicket;
  
  public boolean checkArgs()
  {
    return TextUtils.isEmpty(this.invokeTicket) ^ true;
  }
  
  public void fromArray(String[] paramArrayOfString)
  {
    this.invokeTicket = paramArrayOfString[0];
    this.callbackActivity = paramArrayOfString[1];
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.invokeTicket = paramBundle.getString("_launch_wx_wxa_redirecting_page_invoke_ticket");
    this.callbackActivity = paramBundle.getString("_launch_wx_wxa_redirecting_page_callback_activity");
  }
  
  public int getType()
  {
    return 30;
  }
  
  public String[] toArray()
  {
    return new String[] { this.invokeTicket, this.callbackActivity };
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wx_wxa_redirecting_page_invoke_ticket", this.invokeTicket);
    paramBundle.putString("_launch_wx_wxa_redirecting_page_callback_activity", this.callbackActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req
 * JD-Core Version:    0.7.0.1
 */