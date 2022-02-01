package com.tencent.luggage.wxa.ng;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.p;
import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.nf.b;
import com.tencent.mm.ui.h;
import com.tencent.mm.ui.widget.dialog.CustomSheetDialog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "customStyle", "", "videoCastHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "videoCastDeviceManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "isSearchForSwitch", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;Z)V", "backKeyEventObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1;", "curLandscape", "curRotation", "", "deviceClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "", "helpClickListener", "Lkotlin/Function0;", "getHelpClickListener", "()Lkotlin/jvm/functions/Function0;", "setHelpClickListener", "(Lkotlin/jvm/functions/Function0;)V", "hideNavigationFullScreen", "hideStatusBar", "isLandscape", "()Z", "isShowing", "mAnchorView", "Landroid/view/View;", "mBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mContext", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "maxBottomSheetHeight", "newLandscapeMaxWidth", "newLandscapeStyle", "onHide", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "devicesCount", "getOnHide", "()Lkotlin/jvm/functions/Function1;", "setOnHide", "(Lkotlin/jvm/functions/Function1;)V", "recycleViewAdapter", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "rootView", "rotation", "getRotation", "()I", "selectDeviceCancelAction", "getVideoCastDeviceManager", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "getVideoCastHandler", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "hadRecentDevices", "initView", "notifyChange", "onBottomSheetSelected", "function", "onGlobalLayout", "setBottomSheetParams", "tryHide", "tryShow", "updateBottomSheet", "pos", "Companion", "RecycleViewAdapter", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static final g.a a = new g.a(null);
  private Dialog b;
  private Context c;
  private View d;
  private g.b e;
  private int f;
  private BottomSheetBehavior<?> g;
  private boolean h;
  private int i;
  private View j;
  private ViewTreeObserver k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int o;
  private Function2<? super c, ? super Integer, Unit> p;
  private Function0<Unit> q;
  @NotNull
  private Function1<? super Integer, Unit> r;
  @Nullable
  private Function0<Unit> s;
  private final g.c t;
  @NotNull
  private final b u;
  @NotNull
  private final j v;
  private final boolean w;
  
  public g(@NotNull Context paramContext, boolean paramBoolean1, @NotNull b paramb, @NotNull j paramj, boolean paramBoolean2)
  {
    this.u = paramb;
    this.v = paramj;
    this.w = paramBoolean2;
    this.c = paramContext;
    this.m = true;
    this.n = paramBoolean1;
    this.r = ((Function1)g.h.a);
    this.t = new g.c(this);
    paramContext = this.c;
    if ((paramContext instanceof Activity)) {
      if (paramContext != null)
      {
        paramContext = ((Activity)paramContext).getWindow();
        Intrinsics.checkExpressionValueIsNotNull(paramContext, "(mContext as Activity).window");
        paramContext = paramContext.getDecorView();
        if (paramContext != null) {
          this.j = ((ViewGroup)paramContext).findViewById(16908290);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
    }
    a(this.c);
    this.u.c().a(4, -1, (p)this.t);
  }
  
  private final void a(Context paramContext)
  {
    if (this.n)
    {
      if (paramContext == null) {
        Intrinsics.throwNpe();
      }
      localObject = (Dialog)new CustomSheetDialog(paramContext);
    }
    else
    {
      if (paramContext == null) {
        Intrinsics.throwNpe();
      }
      localObject = (Dialog)new BottomSheetDialog(paramContext);
    }
    this.b = ((Dialog)localObject);
    paramContext = View.inflate(paramContext, 2131625238, null);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "View.inflate(context, R.…video_cast_devices, null)");
    this.d = paramContext;
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramContext.findViewById(2131448524).setOnClickListener((View.OnClickListener)new g.d(this));
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramContext = (RecyclerView)paramContext.findViewById(2131429692);
    paramContext.setHasFixedSize(true);
    Object localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    ((View)localObject).findViewById(2131436321).setOnClickListener((View.OnClickListener)new g.e(this));
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = (ImageView)((View)localObject).findViewById(2131436320);
    Context localContext;
    if (k.a.a())
    {
      localContext = this.c;
      if (localContext == null) {
        Intrinsics.throwNpe();
      }
      ((ImageView)localObject).setImageDrawable(ContextCompat.getDrawable(localContext, 2130837673));
    }
    else
    {
      localContext = this.c;
      if (localContext == null) {
        Intrinsics.throwNpe();
      }
      ((ImageView)localObject).setImageDrawable(ContextCompat.getDrawable(localContext, 2130837668));
    }
    this.h = k();
    int i1 = com.tencent.mm.ui.g.b(this.c, 2131296962);
    double d1;
    int i2;
    if (this.h)
    {
      d1 = i1;
      Double.isNaN(d1);
      i1 = (int)(d1 * 4.5D);
      i2 = com.tencent.mm.ui.g.b(this.c, 2131296955);
    }
    else
    {
      d1 = i1;
      Double.isNaN(d1);
      i1 = (int)(d1 * 6.5D);
      i2 = com.tencent.mm.ui.g.b(this.c, 2131296955);
    }
    this.f = (i1 + i2);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRecyclerView");
    paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.c));
    paramContext.setFocusable(false);
    this.e = new g.b(this);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("recycleViewAdapter");
    }
    paramContext.setAdapter((RecyclerView.Adapter)localObject);
    paramContext.setOverScrollMode(1);
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
    }
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    paramContext.setContentView((View)localObject);
    if (!this.n)
    {
      paramContext = this.d;
      if (paramContext == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      paramContext = paramContext.getParent();
      if (paramContext != null)
      {
        this.g = BottomSheetBehavior.b((View)paramContext);
        paramContext = this.g;
        if (paramContext == null) {
          Intrinsics.throwNpe();
        }
        paramContext.a(this.f);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
      }
    }
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
    }
    paramContext.setOnCancelListener((DialogInterface.OnCancelListener)new g.f(this));
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
    }
    paramContext.setOnDismissListener((DialogInterface.OnDismissListener)new g.g(this));
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
    }
    paramContext.setCancelable(false);
  }
  
  @SuppressLint({"WrongConstant"})
  private final int j()
  {
    Object localObject = this.c;
    if ((localObject instanceof Activity))
    {
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getWindow();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(mContext as Activity).window");
        localObject = ((Window)localObject).getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(mContext as Activity).window.windowManager");
        localObject = ((WindowManager)localObject).getDefaultDisplay();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(mContext as Activity).w…dowManager.defaultDisplay");
        return ((Display)localObject).getRotation();
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
    return 0;
  }
  
  private final boolean k()
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((Context)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mContext!!.resources");
    return ((Resources)localObject).getConfiguration().orientation == 2;
  }
  
  private final void l()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 != null)
    {
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      if (this.n)
      {
        double d1 = com.tencent.mm.ui.g.b(this.c, 2131296962);
        Double.isNaN(d1);
        this.f = ((int)(d1 * 6.5D));
      }
      ((FrameLayout.LayoutParams)localObject1).height = this.f;
      if ((this.h) && (this.j != null))
      {
        localObject2 = new Rect();
        View localView = this.j;
        if (localView == null) {
          Intrinsics.throwNpe();
        }
        localView.getWindowVisibleDisplayFrame((Rect)localObject2);
        if (this.n)
        {
          ((FrameLayout.LayoutParams)localObject1).width = ((int)(((Rect)localObject2).right * 1.0F * 4 / 10));
          int i1 = this.o;
          if (i1 != 0) {
            ((FrameLayout.LayoutParams)localObject1).width = i1;
          }
          if (h.f(this.c)) {
            ((FrameLayout.LayoutParams)localObject1).height = (((Rect)localObject2).bottom - h.b(this.c));
          } else {
            ((FrameLayout.LayoutParams)localObject1).height = ((Rect)localObject2).bottom;
          }
        }
        else
        {
          ((FrameLayout.LayoutParams)localObject1).width = ((Rect)localObject2).right;
        }
      }
      Object localObject2 = this.d;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
  }
  
  private final boolean m()
  {
    return ((Collection)this.v.c()).isEmpty() ^ true;
  }
  
  @NotNull
  public final Function1<Integer, Unit> a()
  {
    return this.r;
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.s = paramFunction0;
  }
  
  public final void a(@NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "<set-?>");
    this.r = paramFunction1;
  }
  
  public final void a(@Nullable Function2<? super c, ? super Integer, Unit> paramFunction2)
  {
    this.p = paramFunction2;
  }
  
  @Nullable
  public final Function0<Unit> b()
  {
    return this.s;
  }
  
  public final boolean c()
  {
    if (((g)this).b != null)
    {
      Dialog localDialog = this.b;
      if (localDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
      }
      if (localDialog.isShowing()) {
        return true;
      }
    }
    return false;
  }
  
  public final void d()
  {
    this.h = k();
    this.i = j();
    if (((g)this).b != null)
    {
      l();
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        }
        localObject = ((Dialog)localObject).getWindow();
        if (localObject != null) {
          ((Window)localObject).addFlags(-2147483648);
        }
      }
      if (this.l)
      {
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        }
        localObject = ((Dialog)localObject).getWindow();
        if (localObject != null) {
          ((Window)localObject).addFlags(1024);
        }
      }
      boolean bool = this.m;
      int i1 = 0;
      if (bool)
      {
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        }
        localObject = ((Dialog)localObject).getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(8, 8);
        }
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        }
        localObject = ((Dialog)localObject).getWindow();
        if (localObject != null) {
          ((Window)localObject).addFlags(131200);
        }
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        }
        localObject = ((Dialog)localObject).getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null) {
            ((View)localObject).setSystemUiVisibility(6);
          }
        }
      }
      else
      {
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        }
        localObject = ((Dialog)localObject).getWindow();
        if (localObject != null) {
          ((Window)localObject).clearFlags(8);
        }
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        }
        localObject = ((Dialog)localObject).getWindow();
        if (localObject != null) {
          ((Window)localObject).clearFlags(131072);
        }
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        }
        localObject = ((Dialog)localObject).getWindow();
        if (localObject != null) {
          ((Window)localObject).clearFlags(128);
        }
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        }
        localObject = ((Dialog)localObject).getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null) {
            ((View)localObject).setSystemUiVisibility(0);
          }
        }
      }
      Object localObject = this.g;
      if ((localObject != null) && (localObject != null)) {
        ((BottomSheetBehavior)localObject).b(false);
      }
      if (this.j != null)
      {
        if (this.k == null) {
          i1 = 1;
        }
        localObject = this.j;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        this.k = ((View)localObject).getViewTreeObserver();
        if (i1 != 0)
        {
          localObject = this.k;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      localObject = this.c;
      if ((localObject instanceof Activity)) {
        if (localObject != null)
        {
          if (!((Activity)localObject).isFinishing())
          {
            localObject = this.b;
            if (localObject == null) {
              Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
            }
            ((Dialog)localObject).show();
          }
        }
        else {
          throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
      }
    }
  }
  
  public final void e()
  {
    if (!c()) {
      return;
    }
    if (((g)this).b != null)
    {
      g.b localb = this.e;
      if (localb == null) {
        Intrinsics.throwUninitializedPropertyAccessException("recycleViewAdapter");
      }
      localb.notifyDataSetChanged();
    }
  }
  
  public final void f()
  {
    if (((g)this).b != null)
    {
      Object localObject = this.g;
      if (localObject != null)
      {
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((BottomSheetBehavior)localObject).b(true);
      }
      localObject = this.c;
      if (localObject != null) {
        if (localObject != null)
        {
          if (!((Activity)localObject).isFinishing())
          {
            localObject = this.b;
            if (localObject == null) {
              Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
            }
            ((Dialog)localObject).dismiss();
          }
        }
        else {
          throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        }
      }
    }
    this.u.c().a((p)this.t);
  }
  
  @NotNull
  public final b g()
  {
    return this.u;
  }
  
  @NotNull
  public final j h()
  {
    return this.v;
  }
  
  public final boolean i()
  {
    return this.w;
  }
  
  public void onGlobalLayout()
  {
    if (c())
    {
      View localView = this.j;
      if ((localView != null) && ((localView.isShown()) || (localView.getVisibility() == 0)))
      {
        if ((c()) && ((this.h != k()) || (this.i != j()))) {
          f();
        }
      }
      else {
        f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g
 * JD-Core Version:    0.7.0.1
 */