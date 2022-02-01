package com.sina.weibo.sdk.b;

import android.content.Context;
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.net.b;
import com.sina.weibo.sdk.net.e.a;
import com.sina.weibo.sdk.net.f;

public final class d
  extends c<Void, Void, String>
{
  private Context af;
  private ChatObject ag;
  private com.sina.weibo.sdk.net.c<String> ah;
  private Throwable ai;
  
  public d(Context paramContext, ChatObject paramChatObject, com.sina.weibo.sdk.net.c<String> paramc)
  {
    this.af = paramContext;
    this.ag = paramChatObject;
    this.ah = paramc;
  }
  
  private String q()
  {
    Object localObject = com.sina.weibo.sdk.a.a();
    try
    {
      e.a locala = new e.a();
      locala.url = "http://i.open.t.sina.com.cn/mobilesdk/sendmessage.php";
      localObject = locala.b("app_key", ((AuthInfo)localObject).getAppKey()).b("platform", "2").b("android_pack", ((AuthInfo)localObject).getPackageName()).b("android_sign", ((AuthInfo)localObject).getHash()).b("display_name", this.ag.content).b("image_url", this.ag.image_url).b("url", this.ag.url).b("summary", this.ag.summary).i();
      localObject = new b().a((com.sina.weibo.sdk.net.d)localObject).j();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.b.d
 * JD-Core Version:    0.7.0.1
 */