package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@SuppressLint({"ViewConstructor"})
public class AppBrandUILoadingSplash
  extends com.tencent.luggage.wxa.rh.b
  implements d, f, g
{
  protected boolean a = false;
  @Nullable
  private com.tencent.luggage.wxa.iu.d c;
  private ImageView d;
  private TextView e;
  private AppBrandCircleProgressView f;
  private ViewGroup g;
  private Function0<Unit> h;
  private Boolean i;
  private ViewStub j;
  private ViewStub k;
  private boolean l = true;
  private AppBrandUILoadingSplash.a m;
  
  @Keep
  public AppBrandUILoadingSplash(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public AppBrandUILoadingSplash(Context paramContext, @Nullable com.tencent.luggage.wxa.iu.d paramd)
  {
    super(paramContext);
    this.c = paramd;
    b();
  }
  
  private void b()
  {
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131624209, this);
    this.d = ((ImageView)findViewById(2131428539));
    this.d.setImageDrawable(WxaDefaultIcon.get());
    this.e = ((TextView)findViewById(2131428541));
    this.f = ((AppBrandCircleProgressView)findViewById(2131428526));
    this.f.setCircleColor(ContextCompat.getColor(getContext(), 2131165199));
    this.f.setDotWidth(getResources().getDimensionPixelSize(2131296776));
    this.f.setDotColor(ContextCompat.getColor(getContext(), 2131165243));
    this.f.setCircleStrokeWidth(getResources().getDimensionPixelSize(2131296775));
    this.f.setProgressColor(ContextCompat.getColor(getContext(), 2131165243));
    this.f.setProgressWidth(getResources().getDimensionPixelSize(2131296777));
    if (r.h()) {
      this.f.setTransitionTimingMs(2147483647);
    }
    this.g = ((ViewGroup)findViewById(2131428542));
    this.j = ((ViewStub)findViewById(2131429672));
    this.k = ((ViewStub)findViewById(2131436833));
    com.tencent.luggage.wxa.ef.d.a("AppBrandUILoadingSplash setupRightButton", new AppBrandUILoadingSplash.1(this));
    this.e.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.b.a(getContext());
    e();
  }
  
  private boolean d()
  {
    if (this.i == null) {
      this.i = Boolean.valueOf(k.a.a());
    }
    return this.i.booleanValue();
  }
  
  private void e()
  {
    View.OnClickListener localOnClickListener = a();
    AppBrandOptionButton localAppBrandOptionButton = (AppBrandOptionButton)this.g.findViewById(2131427573);
    View localView = this.g.findViewById(2131427569);
    int n;
    if (d()) {
      n = 2130838668;
    } else {
      n = 2130838669;
    }
    localView.setBackgroundResource(n);
    localAppBrandOptionButton.a();
    boolean bool = d();
    int i1 = -1;
    if (bool) {
      n = -1;
    } else {
      n = -16777216;
    }
    localAppBrandOptionButton.setColor(n);
    localAppBrandOptionButton = (AppBrandOptionButton)this.g.findViewById(2131427572);
    localAppBrandOptionButton.a();
    if (d()) {
      n = i1;
    } else {
      n = -16777216;
    }
    localAppBrandOptionButton.setColor(n);
    localAppBrandOptionButton.setOnClickListener(localOnClickListener);
  }
  
  private boolean f()
  {
    com.tencent.luggage.wxa.iu.d locald = this.c;
    return (locald != null) && ((locald instanceof com.tencent.luggage.wxa.ed.d)) && (((com.tencent.luggage.wxa.ed.d)locald).w());
  }
  
  protected View.OnClickListener a()
  {
    return new AppBrandUILoadingSplash.4(this);
  }
  
  protected void a(@NonNull Configuration paramConfiguration)
  {
    Object localObject = this.c;
    int n;
    if ((localObject != null) && ((((com.tencent.luggage.wxa.iu.d)localObject).W() instanceof n))) {
      n = 1;
    } else {
      n = 0;
    }
    if (n == 0) {
      return;
    }
    localObject = ((n)this.c.W()).u();
    if (paramConfiguration.orientation == 2) {
      n = 1;
    } else {
      n = 0;
    }
    if ((n != 0) && (localObject != null) && (Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()) && (((Activity)localObject).getRequestedOrientation() == 1)) {
      return;
    }
    if (localObject != null)
    {
      paramConfiguration = ((Activity)localObject).getWindow();
      localObject = paramConfiguration.getDecorView();
      if (n != 0)
      {
        paramConfiguration.addFlags(1024);
        ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100);
        return;
      }
      c.a(paramConfiguration, false);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    AppBrandSimpleImageLoader.instance().attach(this.d, paramString1, null, WxaIconTransformation.INSTANCE);
    this.e.setText(paramString2);
  }
  
  public void a(@NotNull Function0<Unit> paramFunction0)
  {
    this.h = paramFunction0;
  }
  
  public void b(@Nullable Function0<Unit> paramFunction0)
  {
    this.a = true;
    o.d("MicroMsg.AppBrandUILoadingSplash", "animateHide mCanShowHideAnimation[%b]", new Object[] { Boolean.valueOf(this.l) });
    if (!this.l)
    {
      o.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, start hide without animation");
      ViewParent localViewParent = getParent();
      if (!(localViewParent instanceof ViewGroup))
      {
        o.d("MicroMsg.AppBrandUILoadingSplash", "animateHide, wrong ViewGroup");
        return;
      }
      post(new AppBrandUILoadingSplash.2(this, localViewParent, paramFunction0));
      return;
    }
    post(new AppBrandUILoadingSplash.3(this, paramFunction0));
  }
  
  public View getView()
  {
    return this;
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(getResources().getColor(2131165190), d() ^ true);
    this.f.a();
    try
    {
      a(getContext().getResources().getConfiguration());
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      a(paramConfiguration);
      return;
    }
    catch (Exception paramConfiguration) {}
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    if ((!ViewCompat.isAttachedToWindow(this)) && (f()))
    {
      t.a(paramRunnable);
      return true;
    }
    return super.post(paramRunnable);
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return false;
    }
    if ((!ViewCompat.isAttachedToWindow(this)) && (f()))
    {
      t.a(paramRunnable, paramLong);
      return true;
    }
    return super.postDelayed(paramRunnable, paramLong);
  }
  
  public void setCanShowHideAnimation(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setLabelInjector(AppBrandUILoadingSplash.a parama)
  {
    this.m = parama;
    parama = this.m;
    if (parama != null)
    {
      parama.a(this.k);
      this.m.b(this.j);
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.f.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash
 * JD-Core Version:    0.7.0.1
 */