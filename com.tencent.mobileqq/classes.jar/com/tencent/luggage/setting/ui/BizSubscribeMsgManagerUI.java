package com.tencent.luggage.setting.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.luggage.ui.WmpfPresentationActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.luggage.wxa.eg.a.a;
import com.tencent.luggage.wxa.eh.c;
import com.tencent.luggage.wxa.ei.b.a;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/ui/BizSubscribeMsgManagerUI;", "Lcom/tencent/mm/ui/BaseActivity;", "Lcom/tencent/luggage/util/LuggageActivityHelper$ILuggageActivityHelper;", "()V", "bizUsername", "", "mAdapter", "Lcom/tencent/luggage/setting/adapter/SubscribeMsgListAdapter;", "mAppId", "mDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "mInitializingInflater", "", "mInitializingResources", "mOverrideInflater", "Landroid/view/LayoutInflater;", "mOverrideResources", "Landroid/content/res/Resources;", "mSwitchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "mThemeWrapper", "Landroid/view/ContextThemeWrapper;", "nickname", "presenter", "Lcom/tencent/luggage/setting/presenter/BaseSubscribeMsgSettingPagePresenter;", "rootView", "Landroid/view/View;", "applyData", "", "switch", "items", "", "exampleTitle", "dismiss", "getLayoutId", "", "getResources", "getSystemService", "", "name", "initAdapter", "initData", "initPresenter", "initThemeWrapper", "initViews", "loadData", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "showSubscribeMsgList", "show", "updateResult", "result", "Lcom/tencent/luggage/setting/entity/SubscribeMsgSettingData;", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class BizSubscribeMsgManagerUI
  extends BaseActivity
  implements LuggageActivityHelper.ILuggageActivityHelper
{
  public static final BizSubscribeMsgManagerUI.a a = new BizSubscribeMsgManagerUI.a(null);
  private String b = "";
  private String c = "";
  private String d = "";
  private com.tencent.luggage.wxa.eg.a e;
  private ArrayList<d> f = new ArrayList();
  private View g;
  private MMSwitchBtn h;
  private com.tencent.luggage.wxa.ei.a i;
  private ContextThemeWrapper j;
  private boolean k;
  private Resources l;
  private boolean m;
  private LayoutInflater n;
  
  private final void a(c paramc)
  {
    o.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo updateResult %d, isOpened: %b", new Object[] { Integer.valueOf(paramc.c().size()), Boolean.valueOf(paramc.b()) });
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = (RecyclerView)((View)localObject).findViewById(2131446579);
    if (localObject != null)
    {
      int i1;
      if ((true ^ ((Collection)paramc.c()).isEmpty())) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((RecyclerView)localObject).setVisibility(i1);
    }
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = (LinearLayout)((View)localObject).findViewById(2131446585);
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    a(paramc.b(), paramc.c(), paramc.d());
  }
  
  private final void a(boolean paramBoolean)
  {
    Object localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject1 = ((View)localObject1).findViewById(2131446579);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "rootView.findViewById<Re…(R.id.subscribe_msg_list)");
    localObject1 = (RecyclerView)localObject1;
    int i1;
    if (((((Collection)this.f).isEmpty() ^ true)) && (paramBoolean)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((RecyclerView)localObject1).setVisibility(i1);
    localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131446582);
    if ((((Collection)this.f).isEmpty() ^ true))
    {
      Intrinsics.checkExpressionValueIsNotNull(localTextView, "nickNameTv");
      localTextView.setVisibility(0);
      if (paramBoolean) {
        i1 = 2131887573;
      } else {
        i1 = 2131887571;
      }
      localObject1 = getString(i1);
      Object localObject2 = StringCompanionObject.INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "showTips");
      localObject2 = new Object[1];
      localObject2[0] = this.c;
      localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject1);
      int i2 = localTextView.getPaddingLeft();
      if (paramBoolean)
      {
        localObject1 = getResources();
        i1 = 2131296369;
      }
      else
      {
        localObject1 = getResources();
        i1 = 2131296404;
      }
      localTextView.setPadding(i2, ((Resources)localObject1).getDimensionPixelSize(i1), localTextView.getPaddingRight(), localTextView.getPaddingBottom());
    }
    else
    {
      Intrinsics.checkExpressionValueIsNotNull(localTextView, "nickNameTv");
      localTextView.setVisibility(8);
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      ((com.tencent.luggage.wxa.eg.a)localObject1).notifyDataSetChanged();
    }
  }
  
  private final void a(boolean paramBoolean, List<d> paramList, String paramString)
  {
    MMSwitchBtn localMMSwitchBtn = this.h;
    if (localMMSwitchBtn != null) {
      localMMSwitchBtn.setCheck(paramBoolean);
    }
    this.f.clear();
    this.f.addAll((Collection)paramList);
    paramList = this.e;
    if (paramList != null) {
      paramList.a(this.f);
    }
    paramList = this.e;
    if (paramList != null) {
      paramList.a(paramString);
    }
    a(paramBoolean);
  }
  
  private final void b()
  {
    String str = getIntent().getStringExtra("key_biz_presenter_class");
    if (str == null) {
      str = "";
    }
    int i1;
    if (((CharSequence)str).length() == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      try
      {
        this.i = ((com.tencent.luggage.wxa.ei.a)Class.forName(str).newInstance());
        return;
      }
      catch (Exception localException)
      {
        throw ((Throwable)new Exception("create presenter instance fail!", (Throwable)localException));
      }
    }
    throw ((Throwable)new Exception("Presenter ClassName is empty"));
  }
  
  private final void c()
  {
    String str = getIntent().getStringExtra("key_biz_username");
    if (str == null) {
      str = "";
    }
    this.b = str;
    str = getIntent().getStringExtra("key_biz_nickname");
    if (str == null) {
      str = "";
    }
    this.c = str;
    str = getIntent().getStringExtra("key_biz_app_id");
    if (str == null) {
      str = "";
    }
    this.d = str;
    o.e("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo SubscribeMsgManager username: %s, nickname: %s", new Object[] { this.b, this.c });
    d();
  }
  
  private final void d()
  {
    com.tencent.luggage.wxa.ei.a locala = this.i;
    if (locala != null) {
      locala.a(this.b, this.d, (b.a)new BizSubscribeMsgManagerUI.d(this));
    }
  }
  
  private final void e()
  {
    this.e = new com.tencent.luggage.wxa.eg.a((Context)this, (a.a)new BizSubscribeMsgManagerUI.b(this));
  }
  
  private final void f()
  {
    Object localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = (RecyclerView)((View)localObject).findViewById(2131446579);
    ((RecyclerView)localObject).setAdapter((RecyclerView.Adapter)this.e);
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(((RecyclerView)localObject).getContext(), 1, false));
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = ((View)localObject).findViewById(2131446580);
    if (localObject != null)
    {
      this.h = ((MMSwitchBtn)localObject);
      localObject = this.h;
      if (localObject != null) {
        ((MMSwitchBtn)localObject).setSwitchListener((MMSwitchBtn.ISwitch)new BizSubscribeMsgManagerUI.c(this));
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMSwitchBtn");
  }
  
  private final void g()
  {
    if (this.j != null) {
      return;
    }
    Context localContext = ((com.tencent.mm.ui.base.e)com.tencent.luggage.wxa.ba.e.a(com.tencent.mm.ui.base.e.class)).a((Context)this);
    if (localContext != null)
    {
      this.j = ((ContextThemeWrapper)localContext);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.ui.base.ScreenAdaptiveContextThemeWrapper");
  }
  
  public final void a()
  {
    Object localObject = this.i;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.ei.a)localObject).g((Activity)this);
    }
    localObject = WmpfPresentationActivityHelper.a;
    Activity localActivity = (Activity)this;
    ((WmpfPresentationActivityHelper)localObject).a(localActivity);
    WmpfPresentationActivityHelper.a.b(localActivity);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2131624017;
  }
  
  @NotNull
  public Resources getResources()
  {
    if (this.k)
    {
      localObject = super.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "super.getResources()");
      return localObject;
    }
    Object localObject = this.l;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return localObject;
    }
    this.k = true;
    g();
    localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    this.l = ((ContextThemeWrapper)localObject).getResources();
    this.k = false;
    localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return localObject;
  }
  
  @Nullable
  public Object getSystemService(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    if (Intrinsics.areEqual("layout_inflater", paramString))
    {
      if (this.m) {
        return super.getSystemService(paramString);
      }
      paramString = this.n;
      if (paramString != null) {
        return paramString;
      }
      this.m = true;
      g();
      this.n = LayoutInflater.from((Context)this.j);
      this.m = false;
      return this.n;
    }
    return super.getSystemService(paramString);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    a();
  }
  
  public void onConfigurationChanged(@Nullable Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Resources localResources1 = this.l;
    if (localResources1 != null)
    {
      if (localResources1 == null) {
        Intrinsics.throwNpe();
      }
      Resources localResources2 = this.l;
      if (localResources2 == null) {
        Intrinsics.throwNpe();
      }
      localResources1.updateConfiguration(paramConfiguration, localResources2.getDisplayMetrics());
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i1 = getIntent().getIntExtra("key_display_id", 0);
    paramBundle = getWindow();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "window");
    paramBundle = paramBundle.getDecorView().findViewById(16908290);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "window.decorView.findVie…ew>(android.R.id.content)");
    paramBundle = paramBundle.getParent();
    if (paramBundle != null)
    {
      this.g = ((View)paramBundle);
      if (i1 != 0)
      {
        paramBundle = this.g;
        if (paramBundle == null) {
          Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        if ((paramBundle instanceof ViewGroup))
        {
          paramBundle = WmpfPresentationActivityHelper.a;
          Activity localActivity = (Activity)this;
          View localView = this.g;
          if (localView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
          }
          if (localView != null) {
            paramBundle.a(localActivity, (ViewGroup)localView, i1, true);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
          }
        }
      }
      else
      {
        WmpfPresentationActivityHelper.a.a((Activity)this, null, i1, false);
      }
      b();
      paramBundle = this.i;
      if (paramBundle != null) {
        paramBundle.f((Activity)this);
      }
      setTitle(2131887572);
      e();
      f();
      c();
      setBackBtn((MenuItem.OnMenuItemClickListener)new BizSubscribeMsgManagerUI.e(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  protected void onDestroy()
  {
    com.tencent.luggage.wxa.ei.a locala = this.i;
    if (locala != null) {
      locala.d((Activity)this);
    }
    super.onDestroy();
    o.d("MicroMsg.BizSubscribeMsgManagerUI", "alvinluo onDestroy");
  }
  
  protected void onPause()
  {
    com.tencent.luggage.wxa.ei.a locala = this.i;
    if (locala != null) {
      locala.a((Activity)this);
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.luggage.wxa.ei.a locala = this.i;
    if (locala != null) {
      locala.b((Activity)this);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    com.tencent.luggage.wxa.ei.a locala = this.i;
    if (locala != null) {
      locala.c((Activity)this);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    com.tencent.luggage.wxa.ei.a locala = this.i;
    if (locala != null) {
      locala.e((Activity)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.BizSubscribeMsgManagerUI
 * JD-Core Version:    0.7.0.1
 */