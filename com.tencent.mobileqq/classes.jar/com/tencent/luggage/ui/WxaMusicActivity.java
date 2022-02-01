package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.ql.d;
import com.tencent.luggage.wxa.ql.d.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaMusicActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mMusicView", "Lcom/tencent/luggage/ui/WxaMusicActivity$IMuiscView;", "musicPlayerListener", "com/tencent/luggage/ui/WxaMusicActivity$musicPlayerListener$1", "Lcom/tencent/luggage/ui/WxaMusicActivity$musicPlayerListener$1;", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "updateMusicHandler", "com/tencent/luggage/ui/WxaMusicActivity$updateMusicHandler$1", "Lcom/tencent/luggage/ui/WxaMusicActivity$updateMusicHandler$1;", "createMusicLogic", "Lcom/tencent/luggage/ui/WxaMusicActivity$IMusicLogic;", "createMusicView", "musicView", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "uglyJudgeBackgroundMusicIsStop", "", "updateOperationView", "updateProgress", "updateWxaInfo", "Companion", "DefaultMuiscView", "DefaultMusicLogic", "IMuiscView", "IMusicLogic", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public class WxaMusicActivity
  extends AppCompatActivity
{
  public static final WxaMusicActivity.a a = new WxaMusicActivity.a(null);
  private static final String f = "Luggage.WxaMusicActivity";
  private static final int g = Color.parseColor("#FAFAFA");
  private WxaMusicActivity.d b;
  private final WxaMusicActivity.f c = new WxaMusicActivity.f(this);
  private final WxaMusicActivity.h d = new WxaMusicActivity.h(this, Looper.getMainLooper());
  private final d.a e = (d.a)new WxaMusicActivity.g(this);
  
  private final WxaMusicActivity.d d()
  {
    if (this.b == null) {
      this.b = a();
    }
    WxaMusicActivity.d locald = this.b;
    if (locald == null) {
      Intrinsics.throwNpe();
    }
    return locald;
  }
  
  private final void e()
  {
    boolean bool = f();
    String str1 = "";
    if (bool)
    {
      d().d();
      d().c("");
      return;
    }
    Object localObject = i.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
    e locale = ((i)localObject).d();
    WxaMusicActivity.d locald = d();
    localObject = str1;
    if (locale != null)
    {
      String str2 = locale.e;
      localObject = str1;
      if (str2 != null) {
        localObject = str2;
      }
    }
    locald.c((String)localObject);
    if (locale == null)
    {
      d().d();
      return;
    }
    localObject = i.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
    localObject = ((i)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance().musicPlayer");
    if (((d)localObject).t())
    {
      d().g();
      return;
    }
    d().f();
  }
  
  private final boolean f()
  {
    Object localObject = i.f();
    if (localObject != null)
    {
      localObject = ((i)localObject).a();
      if (localObject != null)
      {
        localObject = ((d)localObject).d();
        if (localObject != null)
        {
          localObject = ((com.tencent.luggage.wxa.ig.c)localObject).b;
          if (localObject != null) {
            break label43;
          }
        }
      }
    }
    localObject = "stop";
    label43:
    return Intrinsics.areEqual(localObject, "stop");
  }
  
  private final void g()
  {
    Object localObject = com.tencent.luggage.wxa.nr.b.b();
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.nr.b)localObject).c();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    int i;
    if (((CharSequence)localObject).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (!f()))
    {
      localObject = com.tencent.luggage.wxa.do.b.b().a((String)localObject);
      WxaMusicActivity.d locald = d();
      String str = ((com.tencent.luggage.wxa.do.c)localObject).E;
      Intrinsics.checkExpressionValueIsNotNull(str, "brandName");
      locald.b(str);
      locald = d();
      localObject = ((com.tencent.luggage.wxa.do.c)localObject).F;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "iconUrl");
      locald.a((String)localObject);
      return;
    }
    d().a("");
    d().b("");
  }
  
  private final void h()
  {
    Object localObject = i.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
    localObject = ((i)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance().musicPlayer");
    int i = ((d)localObject).H();
    localObject = i.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
    localObject = ((i)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance().musicPlayer");
    int j = ((d)localObject).I();
    if ((i > 0) && (j > 0)) {
      d().a(i, j);
    }
  }
  
  @NotNull
  protected WxaMusicActivity.d a()
  {
    return (WxaMusicActivity.d)new WxaMusicActivity.b((Context)this, b());
  }
  
  @NotNull
  protected WxaMusicActivity.e b()
  {
    return (WxaMusicActivity.e)new WxaMusicActivity.c((Activity)this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onConfigurationChanged(@NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Resources localResources = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "this.resources");
    if (localResources.getConfiguration().orientation == 2)
    {
      d().h();
    }
    else
    {
      localResources = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localResources, "this.resources");
      if (localResources.getConfiguration().orientation == 1) {
        d().i();
      }
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(d().a((Context)this));
    d().a();
    paramBundle = getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "resources");
    int i = paramBundle.getConfiguration().orientation;
    if (2 == i)
    {
      d().h();
      return;
    }
    if (1 == i) {
      d().i();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = i.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
    localObject = ((i)localObject).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance().musicPlayer");
    if (!((d)localObject).t())
    {
      localObject = i.f();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "MusicPlayerManager.Instance()");
      ((i)localObject).a().G();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    i locali = i.f();
    Intrinsics.checkExpressionValueIsNotNull(locali, "MusicPlayerManager.Instance()");
    locali.a().a(null);
    this.c.d();
  }
  
  protected void onResume()
  {
    super.onResume();
    i locali = i.f();
    Intrinsics.checkExpressionValueIsNotNull(locali, "MusicPlayerManager.Instance()");
    locali.a().a(this.e);
    this.c.c();
    h();
    e();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaMusicActivity
 * JD-Core Version:    0.7.0.1
 */