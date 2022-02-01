package com.sina.weibo.sdk.b;

import android.content.Context;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.a;
import com.sina.weibo.sdk.net.b;
import com.sina.weibo.sdk.net.d;
import com.sina.weibo.sdk.net.e.a;
import com.sina.weibo.sdk.net.f;

public final class e
  extends c<Void, Void, String>
{
  private Context af;
  private com.sina.weibo.sdk.net.c<String> ah;
  private Throwable ai;
  private String aj;
  private String ak;
  private String appKey;
  
  public e(Context paramContext, String paramString1, String paramString2, String paramString3, com.sina.weibo.sdk.net.c<String> paramc)
  {
    this.af = paramContext;
    this.aj = paramString1;
    this.appKey = paramString2;
    this.ak = paramString3;
    this.ah = paramc;
  }
  
  private String d(String paramString)
  {
    return HttpManager.a(this.af, getAid(), this.ak, this.appKey, paramString);
  }
  
  private String getAid()
  {
    return com.sina.weibo.sdk.c.e.f(this.af, this.appKey);
  }
  
  private String q()
  {
    try
    {
      Object localObject = String.valueOf(System.currentTimeMillis() / 1000L);
      e.a locala = new e.a();
      locala.url = "https://service.weibo.com/share/mobilesdk_uppic.php";
      localObject = locala.a("aid", getAid()).a("oauth_timestamp", localObject).a("oauth_sign", d((String)localObject)).b("appKey", this.appKey).b("aid", getAid()).b("oauth_timestamp", localObject).b("oauth_sign", d((String)localObject)).b("img", this.aj).i();
      localObject = new b().a((d)localObject).j();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.ai = localThrowable;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.b.e
 * JD-Core Version:    0.7.0.1
 */