package com.sina.weibo.sdk.a;

import com.sina.weibo.sdk.c.c;
import com.weibo.ssosdk.VisitorLoginListener;
import com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo;

final class a$1
  implements VisitorLoginListener
{
  a$1(a parama) {}
  
  public final void handler(WeiboSsoSdk.VisitorLoginInfo paramVisitorLoginInfo)
  {
    try
    {
      this.d.c = paramVisitorLoginInfo.getAid();
      return;
    }
    catch (Exception paramVisitorLoginInfo)
    {
      c.b("AidManager", paramVisitorLoginInfo.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.a.a.1
 * JD-Core Version:    0.7.0.1
 */