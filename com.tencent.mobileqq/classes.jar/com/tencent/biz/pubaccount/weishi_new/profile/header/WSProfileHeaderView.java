package com.tencent.biz.pubaccount.weishi_new.profile.header;

import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/header/WSProfileHeaderView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mAvatarView", "Landroid/widget/ImageView;", "mCoverPlaceholderDrawable", "Landroid/graphics/drawable/ColorDrawable;", "getMCoverPlaceholderDrawable", "()Landroid/graphics/drawable/ColorDrawable;", "mCoverPlaceholderDrawable$delegate", "Lkotlin/Lazy;", "mIvCover", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "mPresenter", "Lcom/tencent/biz/pubaccount/weishi_new/profile/header/AbsWSHeaderPresenter;", "mRightBigBtnView", "Landroid/widget/TextView;", "mRightSmallBtnView", "mTagContainerView", "Landroid/view/View;", "mTvFansCnt", "mTvFollowCnt", "mTvLocation", "mTvNick", "mTvReceivePraiseCnt", "mTvSex", "mTvSignature", "getTagBgDrawable", "Landroid/graphics/drawable/Drawable;", "colorId", "", "getTagIconDrawable", "drawableId", "inflateLayout", "", "initView", "loadCover", "onClick", "v", "reset", "setData", "person", "LUserGrowth/stSimpleMetaPerson;", "setPresenter", "presenter", "updateFollowBtnStatus", "newFollowStatus", "updateHeaderFansCnt", "newFansCnt", "updateHeaderFollowCnt", "newFollowCnt", "updateHeaderReceiveLikeCnt", "newReceiveLikeCnt", "updateLocation", "updateRightBigBtnView", "updateSex", "updateTagContainerVisibility", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfileHeaderView
  extends FrameLayout
  implements View.OnClickListener
{
  private ImageView a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private KandianUrlImageView k;
  private View l;
  private AbsWSHeaderPresenter m;
  private final Lazy n = LazyKt.lazy((Function0)new WSProfileHeaderView.mCoverPlaceholderDrawable.2(this));
  
  public WSProfileHeaderView(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WSProfileHeaderView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
    c();
  }
  
  private final void b()
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(1929773078, null, false);
    if (localObject != null)
    {
      localObject = (ViewGroup)localObject;
      int i2 = ((ViewGroup)localObject).getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = ((ViewGroup)localObject).getChildAt(0);
        ((ViewGroup)localObject).removeView(localView);
        addView(localView);
        i1 += 1;
      }
      return;
    }
    localObject = new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private final void c()
  {
    Object localObject1 = findViewById(1929707545);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.iv_profile_header_avatar)");
    this.a = ((ImageView)localObject1);
    localObject1 = findViewById(1929707547);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.iv_pro…e_header_right_small_btn)");
    this.b = ((ImageView)localObject1);
    localObject1 = findViewById(1929707606);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.tv_profile_header_right_big_btn)");
    this.c = ((TextView)localObject1);
    localObject1 = findViewById(1929707604);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.tv_profile_header_nick)");
    this.d = ((TextView)localObject1);
    localObject1 = findViewById(1929707607);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.tv_profile_header_sex)");
    this.e = ((TextView)localObject1);
    localObject1 = findViewById(1929707603);
    Object localObject2 = (TextView)localObject1;
    ((TextView)localObject2).setBackgroundDrawable(e(1929510922));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById<TextView>(R…_tag_bg_color))\n        }");
    this.f = ((TextView)localObject2);
    localObject1 = findViewById(1929707608);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.tv_profile_header_signature)");
    this.g = ((TextView)localObject1);
    localObject1 = findViewById(1929707602);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.tv_profile_header_follow_cnt)");
    this.h = ((TextView)localObject1);
    localObject1 = findViewById(1929707601);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.tv_profile_header_fans_cnt)");
    this.i = ((TextView)localObject1);
    localObject1 = findViewById(1929707605);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.tv_pro…eader_receive_praise_cnt)");
    this.j = ((TextView)localObject1);
    localObject1 = findViewById(1929707546);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.iv_profile_header_cover)");
    this.k = ((KandianUrlImageView)localObject1);
    localObject1 = findViewById(1929707554);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.ll_profile_header_tag_container)");
    this.l = ((View)localObject1);
    localObject2 = this.b;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRightSmallBtnView");
    }
    localObject1 = (View.OnClickListener)this;
    ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRightBigBtnView");
    }
    ((TextView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    localObject2 = this.h;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvFollowCnt");
    }
    ((TextView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    localObject2 = this.i;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvFansCnt");
    }
    ((TextView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    localObject2 = this.j;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvReceivePraiseCnt");
    }
    ((TextView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
  }
  
  private final void d()
  {
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvSex");
    }
    int i1 = ((TextView)localObject).getVisibility();
    int i2 = 0;
    if (i1 != 0)
    {
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTvLocation");
      }
      if (((TextView)localObject).getVisibility() != 0)
      {
        i1 = 0;
        break label58;
      }
    }
    i1 = 1;
    label58:
    localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTagContainerView");
    }
    if (i1 != 0) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((View)localObject).setVisibility(i1);
  }
  
  private final Drawable e(int paramInt)
  {
    GradientDrawable localGradientDrawable = WeishiUIUtil.a(getResources().getColor(paramInt), WeishiUIUtil.h);
    Intrinsics.checkExpressionValueIsNotNull(localGradientDrawable, "WeishiUIUtil.createRound…IUtil.PIX_10DP.toFloat())");
    return (Drawable)localGradientDrawable;
  }
  
  private final void e()
  {
    Object localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    int i1;
    if (((AbsWSHeaderPresenter)localObject).q()) {
      i1 = 1929510913;
    } else {
      i1 = 1929510923;
    }
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = WeishiUIUtil.a(((Context)localObject).getResources().getColor(i1), WeishiUIUtil.k);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "WeishiUIUtil.createRound…IUtil.PIX_15DP.toFloat())");
    TextView localTextView = this.c;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRightBigBtnView");
    }
    AbsWSHeaderPresenter localAbsWSHeaderPresenter = this.m;
    if (localAbsWSHeaderPresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    localTextView.setText((CharSequence)localAbsWSHeaderPresenter.j());
    localAbsWSHeaderPresenter = this.m;
    if (localAbsWSHeaderPresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    localTextView.setTextSize(localAbsWSHeaderPresenter.k());
    localTextView.setBackgroundDrawable((Drawable)localObject);
  }
  
  private final Drawable f(int paramInt)
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    ((Drawable)localObject).setBounds(0, 0, WeishiUIUtil.j, WeishiUIUtil.j);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getDra…IUtil.PIX_14DP)\n        }");
    return localObject;
  }
  
  private final void f()
  {
    TextView localTextView = this.e;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvSex");
    }
    AbsWSHeaderPresenter localAbsWSHeaderPresenter = this.m;
    if (localAbsWSHeaderPresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    int i1;
    int i2;
    int i3;
    int i4;
    if (localAbsWSHeaderPresenter.r())
    {
      i1 = 1929838622;
      i2 = 1929641998;
      i3 = 1929510925;
      i4 = 1929510927;
    }
    else
    {
      localAbsWSHeaderPresenter = this.m;
      if (localAbsWSHeaderPresenter == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
      }
      if (!localAbsWSHeaderPresenter.s()) {
        break label166;
      }
      i2 = 1929641992;
      i1 = 1929838616;
      i3 = 1929510924;
      i4 = 1929510926;
    }
    localTextView.setVisibility(0);
    localTextView.setText((CharSequence)localTextView.getContext().getString(i1));
    localTextView.setCompoundDrawables(f(i2), null, null, null);
    localTextView.setTextColor(localTextView.getResources().getColor(i3));
    localTextView.setBackgroundDrawable(e(i4));
    return;
    label166:
    localTextView.setVisibility(8);
  }
  
  private final void g()
  {
    TextView localTextView = this.f;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvLocation");
    }
    Object localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    localObject = (CharSequence)((AbsWSHeaderPresenter)localObject).e();
    localTextView.setText((CharSequence)localObject);
    int i1;
    if (StringsKt.isBlank((CharSequence)localObject)) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localTextView.setVisibility(i1);
    localTextView.setCompoundDrawables(f(1929641996), null, null, null);
  }
  
  private final ColorDrawable getMCoverPlaceholderDrawable()
  {
    return (ColorDrawable)this.n.getValue();
  }
  
  private final void h()
  {
    Object localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    if (StringsKt.isBlank((CharSequence)((AbsWSHeaderPresenter)localObject).d()))
    {
      localObject = this.k;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
      }
      ((KandianUrlImageView)localObject).setImageDrawable((Drawable)getMCoverPlaceholderDrawable());
      return;
    }
    localObject = WSPicLoader.a();
    KandianUrlImageView localKandianUrlImageView = this.k;
    if (localKandianUrlImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
    }
    AbsWSHeaderPresenter localAbsWSHeaderPresenter = this.m;
    if (localAbsWSHeaderPresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    ((WSPicLoader)localObject).a(localKandianUrlImageView, localAbsWSHeaderPresenter.d(), (Drawable)getMCoverPlaceholderDrawable(), (IPublicAccountImageDownListener)new WSProfileHeaderView.loadCover.1(this));
  }
  
  public final void a()
  {
    setData(null);
  }
  
  public final void a(int paramInt)
  {
    e();
  }
  
  public final void b(int paramInt)
  {
    TextView localTextView = this.j;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvReceivePraiseCnt");
    }
    AbsWSHeaderPresenter localAbsWSHeaderPresenter = this.m;
    if (localAbsWSHeaderPresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    localTextView.setText(localAbsWSHeaderPresenter.i());
  }
  
  public final void c(int paramInt)
  {
    TextView localTextView = this.i;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvFansCnt");
    }
    AbsWSHeaderPresenter localAbsWSHeaderPresenter = this.m;
    if (localAbsWSHeaderPresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    localTextView.setText(localAbsWSHeaderPresenter.h());
  }
  
  public final void d(int paramInt)
  {
    TextView localTextView = this.h;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvFollowCnt");
    }
    AbsWSHeaderPresenter localAbsWSHeaderPresenter = this.m;
    if (localAbsWSHeaderPresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    localTextView.setText(localAbsWSHeaderPresenter.g());
  }
  
  public void onClick(@Nullable View paramView)
  {
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRightSmallBtnView");
    }
    if (Intrinsics.areEqual(paramView, localObject))
    {
      paramView = this.m;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
      }
      paramView.m();
      return;
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRightBigBtnView");
    }
    if (Intrinsics.areEqual(paramView, localObject))
    {
      paramView = this.m;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
      }
      paramView.n();
      return;
    }
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvFollowCnt");
    }
    if (Intrinsics.areEqual(paramView, localObject))
    {
      paramView = this.m;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
      }
      paramView.t();
      return;
    }
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvFansCnt");
    }
    if (Intrinsics.areEqual(paramView, localObject))
    {
      paramView = this.m;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
      }
      paramView.u();
      return;
    }
    localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvReceivePraiseCnt");
    }
    if (Intrinsics.areEqual(paramView, localObject))
    {
      paramView = this.m;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
      }
      paramView.v();
    }
  }
  
  public final void setData(@Nullable stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    Object localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    ((AbsWSHeaderPresenter)localObject).a(paramstSimpleMetaPerson);
    localObject = WSPicLoader.a();
    Context localContext = getContext();
    ImageView localImageView = this.a;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
    }
    if (paramstSimpleMetaPerson != null) {
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.avatar;
    } else {
      paramstSimpleMetaPerson = null;
    }
    ((WSPicLoader)localObject).a(localContext, localImageView, paramstSimpleMetaPerson);
    paramstSimpleMetaPerson = this.d;
    if (paramstSimpleMetaPerson == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvNick");
    }
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    paramstSimpleMetaPerson.setText((CharSequence)((AbsWSHeaderPresenter)localObject).c());
    paramstSimpleMetaPerson = this.b;
    if (paramstSimpleMetaPerson == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRightSmallBtnView");
    }
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    paramstSimpleMetaPerson.setImageResource(((AbsWSHeaderPresenter)localObject).l());
    e();
    f();
    g();
    d();
    h();
    paramstSimpleMetaPerson = this.g;
    if (paramstSimpleMetaPerson == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvSignature");
    }
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    paramstSimpleMetaPerson.setText((CharSequence)((AbsWSHeaderPresenter)localObject).f());
    paramstSimpleMetaPerson = this.h;
    if (paramstSimpleMetaPerson == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvFollowCnt");
    }
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    paramstSimpleMetaPerson.setText(((AbsWSHeaderPresenter)localObject).g());
    paramstSimpleMetaPerson = this.i;
    if (paramstSimpleMetaPerson == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvFansCnt");
    }
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    paramstSimpleMetaPerson.setText(((AbsWSHeaderPresenter)localObject).h());
    paramstSimpleMetaPerson = this.j;
    if (paramstSimpleMetaPerson == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTvReceivePraiseCnt");
    }
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    }
    paramstSimpleMetaPerson.setText(((AbsWSHeaderPresenter)localObject).i());
  }
  
  public final void setPresenter(@NotNull AbsWSHeaderPresenter paramAbsWSHeaderPresenter)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsWSHeaderPresenter, "presenter");
    this.m = paramAbsWSHeaderPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.header.WSProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */