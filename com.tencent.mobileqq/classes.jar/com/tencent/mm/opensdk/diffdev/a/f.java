package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

final class f
  extends AsyncTask<Void, Void, f.a>
{
  private OAuthListener k;
  private String n;
  private int t;
  private String url;
  
  public f(String paramString, OAuthListener paramOAuthListener)
  {
    this.n = paramString;
    this.k = paramOAuthListener;
    this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.f
 * JD-Core Version:    0.7.0.1
 */