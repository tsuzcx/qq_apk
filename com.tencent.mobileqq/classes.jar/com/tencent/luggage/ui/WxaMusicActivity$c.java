package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.luggage.wxa.gz.e;
import com.tencent.luggage.wxa.gz.e.a;
import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.ql.d;
import com.tencent.luggage.wxa.qy.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaMusicActivity$DefaultMusicLogic;", "Lcom/tencent/luggage/ui/WxaMusicActivity$IMusicLogic;", "mContext", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getMContext", "()Landroid/app/Activity;", "close", "", "jumpToWxa", "next", "play", "pre", "sendMusicPlayerEvent", "action", "", "isMusicPlayer", "", "stop", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public class WxaMusicActivity$c
  implements WxaMusicActivity.e
{
  @NotNull
  private final Activity a;
  
  public WxaMusicActivity$c(@NotNull Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a()
  {
    this.a.finish();
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    e locale = new e();
    locale.a.a = paramInt;
    locale.a.e = "";
    e.a locala = locale.a;
    i locali = i.f();
    Intrinsics.checkExpressionValueIsNotNull(locali, "MusicPlayerManager.Instance()");
    locala.b = locali.d();
    locale.a.h = "not from app brand appid";
    locale.a.f = paramBoolean;
    com.tencent.luggage.wxa.qy.a.a.a((b)locale, Looper.getMainLooper());
  }
  
  public void b()
  {
    Toast.makeText((Context)this.a, (CharSequence)"not support", 0).show();
  }
  
  public void c()
  {
    Object localObject = i.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
    localObject = ((i)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance().musicPlayer");
    if (((d)localObject).B())
    {
      localObject = i.f();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
      ((i)localObject).a().s();
    }
  }
  
  public void d() {}
  
  public void e()
  {
    i.f().a(true);
    Object localObject = i.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
    localObject = ((i)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance().musicPlayer");
    a(13, ((d)localObject).c());
  }
  
  public void f()
  {
    i.f().a(true);
    Object localObject = i.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
    localObject = ((i)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance().musicPlayer");
    a(14, ((d)localObject).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaMusicActivity.c
 * JD-Core Version:    0.7.0.1
 */