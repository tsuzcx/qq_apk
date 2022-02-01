package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.z;
import com.tencent.luggage.wxa.oo.c.a;
import com.tencent.luggage.wxa.oo.c.d;
import com.tencent.luggage.wxa.oo.c.d.a;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.phonenumber.k;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "context", "Landroid/content/Context;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "_position", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mRootWrapperFrameLayout", "Landroid/widget/FrameLayout;", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "changeListHeightByRotation", "", "rotation", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getContentView", "getDialogHeight", "getLastPointerDownTouchEvent", "getPosition", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "", "getSelectedItem", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setNegativeButtonText", "cancelWording", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setPosition", "position", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "Companion", "Listener", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class f
  extends ReportDialog
  implements com.tencent.luggage.wxa.oo.c, i
{
  public static final f.a b = new f.a(null);
  @Nullable
  private String A;
  @Nullable
  private String B;
  @Nullable
  private String C;
  private MotionEvent D;
  private FrameLayout E;
  private int F;
  private final com.tencent.luggage.wxa.oq.c G;
  private final View c;
  private ImageView d;
  private TextView e;
  private Button f;
  private Button g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private TextView k;
  private LinearLayout l;
  private MaxHeightRecyclerView m;
  private TextView n;
  private View o;
  private View p;
  private DialogInterface.OnShowListener q;
  private DialogInterface.OnDismissListener r;
  private l s;
  private c.d t;
  private n u;
  private String v;
  private final List<n.a> w;
  @Nullable
  private n.b x;
  @Nullable
  private String y;
  @Nullable
  private String z;
  
  public f(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.oq.c paramc, @NotNull c.d paramd)
  {
    super(paramContext);
    this.G = paramc;
    paramc = View.inflate(paramContext, 2131624225, null);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "View.inflate(context, R.…and_request_dialog, null)");
    this.c = paramc;
    this.t = paramd;
    this.v = "";
    this.w = ((List)new ArrayList());
    paramc = this.c.findViewById(2131444677);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_icon)");
    this.d = ((ImageView)paramc);
    paramc = this.c.findViewById(2131444693);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_name)");
    this.e = ((TextView)paramc);
    paramc = this.c.findViewById(2131444670);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_cancel)");
    this.g = ((Button)paramc);
    paramc = this.c.findViewById(2131444694);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_ok)");
    this.f = ((Button)paramc);
    paramc = this.c.findViewById(2131444673);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_desc)");
    this.h = ((TextView)paramc);
    paramc = this.c.findViewById(2131446024);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.i = ((TextView)paramc);
    paramc = this.c.findViewById(2131444672);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_content)");
    this.l = ((LinearLayout)paramc);
    paramc = this.c.findViewById(2131444696);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_right_icon)");
    this.j = ((ImageView)paramc);
    paramc = this.c.findViewById(2131444669);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_apply_wording)");
    this.k = ((TextView)paramc);
    paramc = this.c.findViewById(2131444695);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_recyclerview)");
    this.m = ((MaxHeightRecyclerView)paramc);
    this.m.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(paramContext));
    this.u = new n(this.w);
    this.u.a(a());
    this.m.setAdapter((RecyclerView.Adapter)this.u);
    paramContext = this.c.findViewById(2131444691);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.p = paramContext;
    paramContext = this.c.findViewById(2131430162);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.o = paramContext;
    paramContext = this.c.findViewById(2131444674);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.n = ((TextView)paramContext);
    this.f.setOnClickListener((View.OnClickListener)new f.1(this));
    this.g.setOnClickListener((View.OnClickListener)new f.2(this));
    this.m.setItemAnimator((RecyclerView.ItemAnimator)null);
    this.F = 2;
  }
  
  private final ArrayList<String> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)this.v))
    {
      localArrayList.add(this.v);
      return localArrayList;
    }
    Object localObject = this.u.c();
    if (((List)localObject).size() == 1)
    {
      localObject = (n.a)((List)localObject).get(0);
      if (localObject != null)
      {
        localObject = ((n.a)localObject).c();
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      return localArrayList;
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      n.a locala = (n.a)((Iterator)localObject).next();
      if ((locala != null) && (locala.e() == paramBoolean) && (locala.c() != null)) {
        localArrayList.add(locala.c());
      }
    }
    return localArrayList;
  }
  
  private final void c(int paramInt)
  {
    double d1;
    if ((paramInt != 1) && (paramInt != 3)) {
      d1 = 2.5D;
    } else {
      d1 = 1.5D;
    }
    this.m.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new f.b(this, d1));
    this.m.invalidate();
  }
  
  private final n.a d()
  {
    Iterator localIterator = this.u.c().iterator();
    while (localIterator.hasNext())
    {
      n.a locala = (n.a)localIterator.next();
      if ((locala != null) && (locala.e() == true)) {
        return locala;
      }
    }
    return null;
  }
  
  private final int j()
  {
    return this.c.getMeasuredHeight();
  }
  
  @NotNull
  public com.tencent.luggage.wxa.on.f a(@NotNull b paramb, @Nullable String paramString, @Nullable z paramz)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "this.context");
    int i1 = j();
    com.tencent.luggage.wxa.oq.c localc = paramb.y();
    Intrinsics.checkExpressionValueIsNotNull(localc, "component.windowAndroid");
    paramString = new k(paramz, paramString, localContext, i1, localc);
    paramb = paramb.y();
    Intrinsics.checkExpressionValueIsNotNull(paramb, "component.windowAndroid");
    if (paramb.f()) {
      paramString.b(1);
    }
    return (com.tencent.luggage.wxa.on.f)paramString;
  }
  
  @Nullable
  public n.b a()
  {
    return this.x;
  }
  
  public void a(int paramInt)
  {
    m localm = m.a;
    Context localContext = getContentView().getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "contentView.context");
    localm.a(localContext, getContentView(), this.o, paramInt, this.G);
    c(paramInt);
  }
  
  public void a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    b(this.F);
    b(paramb).a((i)this);
  }
  
  public void a(@Nullable l paraml)
  {
    b(this.F);
    Object localObject = this.q;
    if (localObject != null) {
      ((DialogInterface.OnShowListener)localObject).onShow((DialogInterface)this);
    }
    this.s = paraml;
    localObject = getContext().getSystemService("window");
    paraml = (l)localObject;
    if (!(localObject instanceof WindowManager)) {
      paraml = null;
    }
    paraml = (WindowManager)paraml;
    if (paraml != null)
    {
      localObject = m.a;
      Context localContext = getContentView().getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "contentView.context");
      View localView1 = getContentView();
      View localView2 = this.o;
      Display localDisplay = paraml.getDefaultDisplay();
      Intrinsics.checkExpressionValueIsNotNull(localDisplay, "it.defaultDisplay");
      ((m)localObject).a(localContext, localView1, localView2, localDisplay.getRotation(), this.G);
      paraml = paraml.getDefaultDisplay();
      Intrinsics.checkExpressionValueIsNotNull(paraml, "it.defaultDisplay");
      c(paraml.getRotation());
    }
  }
  
  public void a(@Nullable String paramString)
  {
    this.y = paramString;
    TextView localTextView = this.e;
    if (paramString == null) {
      paramString = "";
    }
    localTextView.setText((CharSequence)paramString);
  }
  
  public void a(@Nullable List<n.a> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.w.clear();
      this.w.addAll((Collection)paramList);
      this.u.notifyDataSetChanged();
      this.l.setVisibility(0);
      this.i.setVisibility(8);
      this.p.setVisibility(8);
    }
  }
  
  @NotNull
  public l b(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "$this$findPromptViewContainer");
    return c.a.a(this, paramb);
  }
  
  @Nullable
  public String b()
  {
    return this.C;
  }
  
  public final void b(int paramInt)
  {
    this.F = paramInt;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      this.c.setBackground(ContextCompat.getDrawable(getContext(), 2130838717));
      return;
    }
    this.c.setBackground(ContextCompat.getDrawable(getContext(), 2130838718));
  }
  
  public void b(@Nullable String paramString)
  {
    this.z = paramString;
    this.h.setText((CharSequence)paramString);
  }
  
  public void c()
  {
    DialogInterface.OnDismissListener localOnDismissListener = this.r;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss((DialogInterface)this);
    }
  }
  
  public void c(@Nullable String paramString)
  {
    this.A = paramString;
    if (paramString != null)
    {
      this.i.setVisibility(0);
      this.i.setText((CharSequence)paramString);
    }
  }
  
  public void d(@Nullable String paramString)
  {
    this.B = paramString;
    this.k.setText((CharSequence)paramString);
  }
  
  public void dismiss()
  {
    super.dismiss();
    c();
  }
  
  public void e()
  {
    c.d.a.a(this.t, 3, new ArrayList(), 0, 4, null);
  }
  
  public void e(@Nullable String paramString)
  {
    this.C = paramString;
    AppBrandSimpleImageLoader.instance().attach(this.d, b(), 2130842125, (AppBrandSimpleImageLoader.h)WxaIconTransformation.INSTANCE);
  }
  
  public void f(@Nullable String paramString)
  {
    if (paramString != null) {
      this.g.setText((CharSequence)paramString);
    }
  }
  
  public boolean f()
  {
    return false;
  }
  
  public void g(@Nullable String paramString)
  {
    if (paramString != null) {
      this.f.setText((CharSequence)paramString);
    }
  }
  
  public boolean g()
  {
    return true;
  }
  
  @NotNull
  public View getContentView()
  {
    if (((f)this).E == null)
    {
      this.E = ((FrameLayout)new f.c(this, getContext()));
      localObject = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      FrameLayout localFrameLayout = this.E;
      if (localFrameLayout == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRootWrapperFrameLayout");
      }
      localFrameLayout.addView(this.c, (ViewGroup.LayoutParams)localObject);
    }
    Object localObject = this.E;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootWrapperFrameLayout");
    }
    return (View)localObject;
  }
  
  public int h()
  {
    return this.F;
  }
  
  public void h(@Nullable String paramString)
  {
    paramString = (CharSequence)paramString;
    if (TextUtils.isEmpty(paramString))
    {
      this.n.setText((CharSequence)"");
      this.n.setVisibility(4);
      return;
    }
    this.n.setText(paramString);
    this.n.setVisibility(0);
  }
  
  public void i(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "scope");
    this.v = paramString;
  }
  
  public boolean i()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f
 * JD-Core Version:    0.7.0.1
 */