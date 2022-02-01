package com.tencent.luggage.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView;
import com.tencent.mm.plugin.appbrand.ui.WxaDefaultIcon;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@SuppressLint({"ViewConstructor"})
public class a
  extends com.tencent.luggage.wxa.rh.b
  implements com.tencent.mm.plugin.appbrand.ui.d, com.tencent.mm.plugin.appbrand.ui.f
{
  @Nullable
  private com.tencent.luggage.wxa.iu.d a;
  private Function0<Unit> c;
  private ImageView d;
  private TextView e;
  private AppBrandCircleProgressView f;
  private ViewGroup g;
  private TextView h;
  
  public a(@NonNull Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f1 = getContext().getResources().getDimension(2131300077);; f1 = getContext().getResources().getDimension(2131300078)) {
      return (int)f1;
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    if ((getContext() instanceof MutableContextWrapper))
    {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
      a(-1, true);
    }
  }
  
  private void a(@NonNull Configuration paramConfiguration)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (!(((com.tencent.luggage.wxa.iu.d)localObject).W() instanceof n)) {
      return;
    }
    localObject = ((n)this.a.W()).u();
    int i;
    if (paramConfiguration.orientation == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (localObject != null) && (Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()) && (((Activity)localObject).getRequestedOrientation() == 1)) {
      return;
    }
    if (localObject != null)
    {
      paramConfiguration = ((Activity)localObject).getWindow();
      View localView = paramConfiguration.getDecorView();
      if (i != 0)
      {
        paramConfiguration.addFlags(1024);
        localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x4 | 0x100);
      }
      else
      {
        paramConfiguration.clearFlags(1024);
        localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFB);
      }
    }
    if (((com.tencent.luggage.wxa.do.a)this.a.b(com.tencent.luggage.wxa.do.a.class)).b) {
      com.tencent.mm.plugin.appbrand.ui.c.a((Context)localObject, true);
    }
  }
  
  private void b()
  {
    setVisibility(0);
    setBackgroundColor(-1);
    this.d.setAlpha(1.0F);
    this.d.setScaleX(1.0F);
    this.d.setScaleY(1.0F);
    this.e.setAlpha(1.0F);
    this.e.setTextColor(getResources().getColor(2131165564));
    this.f.setAlpha(1.0F);
  }
  
  private void d()
  {
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131629706, this);
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
    this.g = ((ViewGroup)findViewById(2131428542));
    this.h = ((TextView)findViewById(2131450220));
    this.h.setVisibility(8);
    LayoutInflater.from(getContext()).inflate(2131624208, this.g);
    this.e.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.b.a(getContext());
    this.e.requestLayout();
    a(-1, true);
    e();
  }
  
  private void e()
  {
    a.2 local2 = new a.2(this);
    AppBrandOptionButton localAppBrandOptionButton = (AppBrandOptionButton)this.g.findViewById(2131427573);
    localAppBrandOptionButton.a();
    localAppBrandOptionButton.setColor(-16777216);
    localAppBrandOptionButton = (AppBrandOptionButton)this.g.findViewById(2131427572);
    localAppBrandOptionButton.a();
    localAppBrandOptionButton.setColor(-16777216);
    localAppBrandOptionButton.setOnClickListener(local2);
  }
  
  private void f()
  {
    this.f.a();
  }
  
  private boolean g()
  {
    com.tencent.luggage.wxa.iu.d locald = this.a;
    return (locald != null) && ((locald instanceof com.tencent.luggage.wxa.ed.d)) && (((com.tencent.luggage.wxa.ed.d)locald).w());
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.iu.d paramd)
  {
    this.a = paramd;
    this.c = null;
    if (paramd.ah() == null) {
      paramd = paramd.ag();
    } else {
      paramd = paramd.ah();
    }
    a(paramd);
    b();
    paramd = (ImageView)findViewById(2131450221);
    boolean bool = ((com.tencent.luggage.wxa.do.c)this.a.B()).g();
    if (bool)
    {
      this.h.setVisibility(0);
      paramd.setImageResource(2130853696);
    }
    else
    {
      this.h.setVisibility(8);
      paramd.setImageResource(2130853697);
    }
    ((ViewGroup.MarginLayoutParams)paramd.getLayoutParams()).bottomMargin = a(bool);
  }
  
  public void a(String paramString1, String paramString2)
  {
    AppBrandSimpleImageLoader.instance().attach(this.d, paramString1, null, WxaIconTransformation.INSTANCE);
    this.e.setText(paramString2);
  }
  
  public void a(@NotNull Function0<Unit> paramFunction0)
  {
    this.c = paramFunction0;
  }
  
  public void b(@Nullable Function0<Unit> paramFunction0)
  {
    post(new a.1(this, paramFunction0));
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
    f();
    try
    {
      a(getContext().getResources().getConfiguration());
      localObject = this.a;
      if (localObject == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (!(((com.tencent.luggage.wxa.iu.d)localObject).W() instanceof n)) {
            return;
          }
          Object localObject = ((n)this.a.W()).u();
          if (localObject == null) {
            return;
          }
          boolean bool = com.tencent.luggage.wxa.or.f.a((Activity)localObject).e();
          if (bool) {}
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
    }
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
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.f.b();
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    if ((!ViewCompat.isAttachedToWindow(this)) && (g()))
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
    if ((!ViewCompat.isAttachedToWindow(this)) && (g()))
    {
      t.a(paramRunnable, paramLong);
      return true;
    }
    return super.postDelayed(paramRunnable, paramLong);
  }
  
  public void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.a
 * JD-Core Version:    0.7.0.1
 */