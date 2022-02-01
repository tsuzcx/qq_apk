package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "_position", "", "value", "", "acceptWording", "getAcceptWording", "()Ljava/lang/String;", "setAcceptWording", "(Ljava/lang/String;)V", "appBrandName", "getAppBrandName", "setAppBrandName", "applyWording", "getApplyWording", "setApplyWording", "cancelWording", "getCancelWording", "setCancelWording", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mButtonGroup", "Landroid/view/View;", "mContentLayout", "Landroid/widget/LinearLayout;", "getMContentLayout", "()Landroid/widget/LinearLayout;", "setMContentLayout", "(Landroid/widget/LinearLayout;)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mFuncTv", "getMFuncTv", "()Landroid/widget/TextView;", "setMFuncTv", "(Landroid/widget/TextView;)V", "mIconIv", "Landroid/widget/ImageView;", "mListener", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "setMListener", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;)V", "mLoadingView", "getMLoadingView", "()Landroid/view/View;", "setMLoadingView", "(Landroid/view/View;)V", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "mRequestDescTv", "mRightIconIv", "mRootView", "getMRootView", "setMRootView", "mSimpleDetailDescTv", "requestDesc", "getRequestDesc", "setRequestDesc", "Landroid/graphics/drawable/Drawable;", "rightIcon", "getRightIcon", "()Landroid/graphics/drawable/Drawable;", "setRightIcon", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View$OnClickListener;", "rightIconListener", "getRightIconListener", "()Landroid/view/View$OnClickListener;", "setRightIconListener", "(Landroid/view/View$OnClickListener;)V", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "showRightIcon", "show", "Companion", "Listener", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@RequiresApi(8)
public class a
  extends ReportDialog
  implements i
{
  public static final a.a a = new a.a(null);
  @NotNull
  private View b;
  private ImageView c;
  private TextView d;
  private Button e;
  private Button f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private TextView j;
  @NotNull
  private LinearLayout k;
  @NotNull
  private RecyclerView l;
  @NotNull
  private TextView m;
  private View n;
  @NotNull
  private View o;
  private DialogInterface.OnShowListener p;
  private DialogInterface.OnDismissListener q;
  private l r;
  @Nullable
  private a.b s;
  @Nullable
  private String t;
  @Nullable
  private Drawable u;
  @Nullable
  private String v;
  private int w;
  private final c x;
  
  public a(@NotNull Context paramContext, @NotNull c paramc)
  {
    super(paramContext);
    this.x = paramc;
    paramc = View.inflate(paramContext, 2131624225, null);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "View.inflate(context, R.…and_request_dialog, null)");
    this.b = paramc;
    paramc = this.b.findViewById(2131444677);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_icon)");
    this.c = ((ImageView)paramc);
    paramc = this.b.findViewById(2131444693);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_name)");
    this.d = ((TextView)paramc);
    paramc = this.b.findViewById(2131444670);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_cancel)");
    this.f = ((Button)paramc);
    paramc = this.b.findViewById(2131444694);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_ok)");
    this.e = ((Button)paramc);
    paramc = this.b.findViewById(2131444673);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_desc)");
    this.g = ((TextView)paramc);
    paramc = this.b.findViewById(2131446024);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.simple_detail_desc)");
    this.h = ((TextView)paramc);
    paramc = this.b.findViewById(2131444672);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_content)");
    this.k = ((LinearLayout)paramc);
    paramc = this.b.findViewById(2131444696);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_right_icon)");
    this.i = ((ImageView)paramc);
    paramc = this.b.findViewById(2131444669);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_apply_wording)");
    this.j = ((TextView)paramc);
    paramc = this.b.findViewById(2131444695);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "mRootView.findViewById(R.id.request_recyclerview)");
    this.l = ((RecyclerView)paramc);
    this.l.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(paramContext));
    paramContext = this.b.findViewById(2131444691);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.request_loading)");
    this.o = paramContext;
    paramContext = this.b.findViewById(2131430162);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.button_group)");
    this.n = paramContext;
    paramContext = this.b.findViewById(2131444674);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.request_function)");
    this.m = ((TextView)paramContext);
    this.e.setOnClickListener((View.OnClickListener)new a.1(this));
    this.f.setOnClickListener((View.OnClickListener)new a.2(this));
    this.l.setItemAnimator((RecyclerView.ItemAnimator)null);
    this.w = 2;
  }
  
  @NotNull
  protected final View a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    m localm = m.a;
    Context localContext = this.b.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "mRootView.context");
    localm.a(localContext, this.b, this.n, paramInt, this.x);
  }
  
  public final void a(@Nullable Drawable paramDrawable)
  {
    this.u = paramDrawable;
    this.i.setVisibility(8);
    if (paramDrawable != null)
    {
      this.i.setImageDrawable(this.u);
      this.i.setVisibility(0);
    }
  }
  
  public final void a(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.i.setOnClickListener(paramOnClickListener);
  }
  
  protected final void a(@Nullable a.b paramb)
  {
    this.s = paramb;
  }
  
  public void a(@Nullable l paraml)
  {
    Object localObject1 = this.p;
    if (localObject1 != null) {
      ((DialogInterface.OnShowListener)localObject1).onShow((DialogInterface)this);
    }
    this.r = paraml;
    localObject1 = getContext().getSystemService("window");
    paraml = (l)localObject1;
    if (!(localObject1 instanceof WindowManager)) {
      paraml = null;
    }
    Object localObject2 = (WindowManager)paraml;
    if (localObject2 != null)
    {
      paraml = m.a;
      localObject1 = this.b.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView.context");
      View localView1 = this.b;
      View localView2 = this.n;
      localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.defaultDisplay");
      paraml.a((Context)localObject1, localView1, localView2, ((Display)localObject2).getRotation(), this.x);
    }
  }
  
  public final void a(@Nullable String paramString)
  {
    this.v = paramString;
    TextView localTextView = this.d;
    if (paramString == null) {
      paramString = "";
    }
    localTextView.setText((CharSequence)paramString);
  }
  
  @NotNull
  protected final LinearLayout b()
  {
    return this.k;
  }
  
  public final void b(int paramInt)
  {
    this.w = paramInt;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      this.b.setBackground(ContextCompat.getDrawable(getContext(), 2130838717));
      return;
    }
    this.b.setBackground(ContextCompat.getDrawable(getContext(), 2130838718));
  }
  
  public final void b(@Nullable String paramString)
  {
    this.t = paramString;
    AppBrandSimpleImageLoader.instance().attach(this.c, this.t, 2130842125, (AppBrandSimpleImageLoader.h)WxaIconTransformation.INSTANCE);
  }
  
  public final void b(boolean paramBoolean)
  {
    ImageView localImageView = this.i;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  @NotNull
  protected final RecyclerView c()
  {
    return this.l;
  }
  
  @NotNull
  protected final TextView d()
  {
    return this.m;
  }
  
  public void dismiss()
  {
    super.dismiss();
    l();
  }
  
  public void e()
  {
    a.b localb = this.s;
    if (localb != null) {
      localb.a(3);
    }
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
    return this.b;
  }
  
  public int h()
  {
    return this.w;
  }
  
  public boolean i()
  {
    return false;
  }
  
  @NotNull
  protected final View j()
  {
    return this.o;
  }
  
  @Nullable
  protected final a.b k()
  {
    return this.s;
  }
  
  public void l()
  {
    DialogInterface.OnDismissListener localOnDismissListener = this.q;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss((DialogInterface)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.a
 * JD-Core Version:    0.7.0.1
 */