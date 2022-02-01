package com.tencent.luggage.wxa.ek;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.setting.ui.WxaSettingActivity;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.weui.base.preference.IPreferenceScreen;
import com.tencent.weui.base.preference.c;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/ui/dialog/WxaSettingDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "hostActivity", "Lcom/tencent/luggage/setting/ui/WxaSettingActivity;", "overrideContext", "Landroid/content/Context;", "menuViewSize", "", "(Lcom/tencent/luggage/setting/ui/WxaSettingActivity;Landroid/content/Context;[I)V", "BackBtn", "Lkotlin/Function0;", "", "getBackBtn", "()Lkotlin/jvm/functions/Function0;", "setBackBtn", "(Lkotlin/jvm/functions/Function0;)V", "CloseBtn", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "backToMenu", "getCloseBtn", "()Lkotlin/jvm/functions/Function1;", "setCloseBtn", "(Lkotlin/jvm/functions/Function1;)V", "DismissListener", "getDismissListener", "setDismissListener", "ShowListener", "getShowListener", "setShowListener", "adapter", "Lcom/tencent/weui/base/preference/WeUIPreferenceAdapter;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "dirty", "isRefreshing", "mActivity", "mBackIv", "Landroid/view/View;", "mCloseIv", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mListView", "Landroid/widget/ListView;", "mRootView", "Landroid/widget/FrameLayout;", "mTitleTv", "Landroid/widget/TextView;", "onCancel", "getOnCancel", "setOnCancel", "preferenceScreen", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "getPreferenceScreen", "()Lcom/tencent/weui/base/preference/IPreferenceScreen;", "value", "", "titleText", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "autoRefresh", "createAdapter", "sp", "dismiss", "getContentHeight", "", "getContentView", "getDefaultSharedPreferences", "getDialogHeight", "getPosition", "hideLoading", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onDismiss", "onPreferenceTreeClick", "screen", "pref", "Landroid/preference/Preference;", "onPreferenceTreeLongClick", "view", "onResume", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "releaseUI", "setContentVisible", "visible", "setDialogHeight", "height", "setEmptyTipsVisibility", "wording", "showLoading", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  extends ReportDialog
  implements i
{
  public static final a.c a = new a.c(null);
  private final FrameLayout b;
  private l c;
  private final WxaSettingActivity d;
  private View e;
  private TextView f;
  private View g;
  private ListView h;
  private SharedPreferences i;
  private c j;
  @NotNull
  private Function0<Unit> k;
  @NotNull
  private Function0<Unit> l;
  @NotNull
  private Function1<? super Boolean, Unit> m;
  @NotNull
  private Function0<Unit> n;
  @NotNull
  private Function0<Unit> o;
  @Nullable
  private String p;
  private boolean q;
  private boolean r;
  private final int[] s;
  
  public a(@NotNull WxaSettingActivity paramWxaSettingActivity, @NotNull Context paramContext, @Nullable int[] paramArrayOfInt)
  {
    super(paramContext);
    this.s = paramArrayOfInt;
    paramContext = View.inflate(paramContext, 2131624713, null);
    if (paramContext != null)
    {
      this.b = ((FrameLayout)paramContext);
      this.d = paramWxaSettingActivity;
      this.k = ((Function0)a.f.a);
      this.l = ((Function0)a.a.a);
      this.m = ((Function1)a.b.a);
      this.n = ((Function0)a.d.a);
      this.o = ((Function0)a.e.a);
      paramWxaSettingActivity = getContext();
      paramContext = new StringBuilder();
      paramArrayOfInt = getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "context");
      paramContext.append(paramArrayOfInt.getPackageName());
      paramContext.append("_preferences");
      this.i = paramWxaSettingActivity.getSharedPreferences(paramContext.toString(), 0);
      this.j = a(this.i);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
  }
  
  private final int a(int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfInt[1];
    paramArrayOfInt = this.b.findViewById(2131440593);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "mRootView.findViewById<V…ference_tips_banner_view)");
    return i1 - paramArrayOfInt.getLayoutParams().height;
  }
  
  private final c a(SharedPreferences paramSharedPreferences)
  {
    return new c(getContext(), paramSharedPreferences);
  }
  
  private final void p()
  {
    ListView localListView = this.h;
    if (localListView != null) {
      localListView.setAdapter((ListAdapter)null);
    }
  }
  
  @NotNull
  public final Function0<Unit> a()
  {
    return this.l;
  }
  
  public void a(int paramInt) {}
  
  public void a(@Nullable l paraml)
  {
    this.c = paraml;
    paraml = this.s;
    int i2 = 0;
    if (paraml == null)
    {
      paraml = new RelativeLayout.LayoutParams(-1, -2);
    }
    else
    {
      this.b.setMinimumHeight(paraml[1]);
      paraml = new RelativeLayout.LayoutParams(this.s[0], -2);
    }
    paraml.addRule(13);
    this.b.setLayoutParams((ViewGroup.LayoutParams)paraml);
    paraml = this.c;
    if (paraml != null) {
      paraml.a((j)new a.g(this));
    }
    this.e = this.b.findViewById(2131440588);
    this.f = ((TextView)this.b.findViewById(2131440590));
    this.g = this.b.findViewById(2131440589);
    this.h = ((ListView)this.b.findViewById(16908298));
    paraml = this.e;
    if (paraml != null) {
      paraml.setOnClickListener((View.OnClickListener)new a.h(this));
    }
    paraml = this.f;
    if (paraml != null)
    {
      CharSequence localCharSequence = paraml.getText();
      int i1;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 != 0)
      {
        localCharSequence = (CharSequence)this.p;
        if (localCharSequence != null)
        {
          i1 = i2;
          if (localCharSequence.length() != 0) {}
        }
        else
        {
          i1 = 1;
        }
        if (i1 == 0) {
          paraml.setText((CharSequence)this.p);
        }
      }
    }
    paraml = this.g;
    if (paraml != null) {
      paraml.setOnClickListener((View.OnClickListener)new a.i(this));
    }
    paraml = this.j;
    if (paraml == null) {
      Intrinsics.throwNpe();
    }
    paraml.a((Preference.OnPreferenceChangeListener)new a.j(this));
    paraml = this.h;
    if (paraml == null) {
      Intrinsics.throwNpe();
    }
    paraml.setAdapter((ListAdapter)this.j);
    paraml = this.h;
    if (paraml == null) {
      Intrinsics.throwNpe();
    }
    paraml.setOnItemClickListener((AdapterView.OnItemClickListener)new a.k(this));
    paraml = this.h;
    if (paraml == null) {
      Intrinsics.throwNpe();
    }
    paraml.setOnItemLongClickListener((AdapterView.OnItemLongClickListener)new a.l(this));
    paraml = this.h;
    if (paraml == null) {
      Intrinsics.throwNpe();
    }
    paraml.setOnScrollListener((AbsListView.OnScrollListener)new a.m(this));
  }
  
  public final void a(@Nullable String paramString)
  {
    this.p = paramString;
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.l = paramFunction0;
  }
  
  public final void a(@NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "<set-?>");
    this.m = paramFunction1;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b.post((Runnable)new a.n(this, paramBoolean));
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    TextView localTextView = (TextView)this.b.findViewById(2131448743);
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localTextView.setVisibility(i1);
    localTextView.setText((CharSequence)paramString);
    paramString = this.s;
    if (paramString != null) {
      localTextView.setMinHeight(a(paramString));
    }
  }
  
  public final boolean a(@Nullable IPreferenceScreen paramIPreferenceScreen, @Nullable Preference paramPreference)
  {
    return this.d.onPreferenceTreeClick(paramIPreferenceScreen, paramPreference);
  }
  
  public final boolean a(@Nullable IPreferenceScreen paramIPreferenceScreen, @NotNull Preference paramPreference, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramPreference, "pref");
    return false;
  }
  
  @NotNull
  public final Function1<Boolean, Unit> b()
  {
    return this.m;
  }
  
  public final void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.n = paramFunction0;
  }
  
  @NotNull
  public final Function0<Unit> c()
  {
    return this.n;
  }
  
  public void d()
  {
    e();
  }
  
  public void dismiss()
  {
    super.dismiss();
    d();
  }
  
  public void e()
  {
    p();
    this.k.invoke();
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean g()
  {
    return true;
  }
  
  @NotNull
  public View getContentView()
  {
    return (View)this.b;
  }
  
  public int h()
  {
    return 1;
  }
  
  public boolean i()
  {
    return false;
  }
  
  @Nullable
  public final IPreferenceScreen j()
  {
    return (IPreferenceScreen)this.j;
  }
  
  public final boolean k()
  {
    return true;
  }
  
  public final void l()
  {
    if (k())
    {
      c localc = this.j;
      if (localc != null) {
        localc.notifyDataSetChanged();
      }
    }
  }
  
  @Nullable
  public final SharedPreferences m()
  {
    return this.i;
  }
  
  public final void n()
  {
    View localView = this.b.findViewById(2131450323);
    localView.setVisibility(0);
    Object localObject = this.b.findViewById(16908298);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mRootView.findViewById<View>(android.R.id.list)");
    ((View)localObject).setVisibility(8);
    if (this.s != null)
    {
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = a(this.s);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public final void o()
  {
    View localView = this.b.findViewById(2131450323);
    Intrinsics.checkExpressionValueIsNotNull(localView, "mRootView.findViewById<V…wxa_setting_loading_area)");
    localView.setVisibility(8);
    localView = this.b.findViewById(16908298);
    Intrinsics.checkExpressionValueIsNotNull(localView, "mRootView.findViewById<View>(android.R.id.list)");
    localView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ek.a
 * JD-Core Version:    0.7.0.1
 */