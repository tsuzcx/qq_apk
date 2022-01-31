package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;

public final class d
  extends AsyncTask<Void, Void, d.a>
{
  private static String h = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
  private String appId;
  private String i;
  private String j;
  private OAuthListener k;
  private f l;
  private String scope;
  private String signature;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    this.appId = paramString1;
    this.scope = paramString2;
    this.i = paramString3;
    this.j = paramString4;
    this.signature = paramString5;
    this.k = paramOAuthListener;
  }
  
  public final boolean a()
  {
    Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
    if (this.l == null) {
      return cancel(true);
    }
    return this.l.cancel(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.d
 * JD-Core Version:    0.7.0.1
 */