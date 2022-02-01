package com.tencent.biz.pubaccount.weishi_new.profile.toolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/toolbar/WSProfileToolbarController;", "Landroid/view/View$OnClickListener;", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "<set-?>", "", "isToolbarIconBlack", "()Z", "isToolbarTextShown", "ivBack", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "ivDetail", "ivFeedback", "ivShare", "onToolbarItemClickListener", "Lcom/tencent/biz/pubaccount/weishi_new/profile/toolbar/WSProfileToolbarItemClickListener;", "getOnToolbarItemClickListener", "()Lcom/tencent/biz/pubaccount/weishi_new/profile/toolbar/WSProfileToolbarItemClickListener;", "setOnToolbarItemClickListener", "(Lcom/tencent/biz/pubaccount/weishi_new/profile/toolbar/WSProfileToolbarItemClickListener;)V", "toolbar", "toolbarTextAnimator", "Landroid/view/ViewPropertyAnimator;", "tvTitle", "Landroid/widget/TextView;", "adjustTitlePadding", "", "rightIconSpace", "", "calRightIconSpace", "cancelAnimation", "animator", "changeToolbarIcon", "isBlack", "getToolbarMeasuredHeight", "getViewHorizontalSpace", "view", "onClick", "v", "preMeasure", "setShowDetailBtn", "show", "setShowFeedbackBtn", "setTitle", "title", "", "setToolbarBgAlpha", "offset", "setToolbarElementChange", "setToolbarStatusBarIconChange", "setToolbarTextAlpha", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfileToolbarController
  implements View.OnClickListener
{
  public static final WSProfileToolbarController.Companion a = new WSProfileToolbarController.Companion(null);
  private static final float l = ScreenUtil.dip2px(112.0F) - ImmersiveUtils.getStatusBarHeight((Context)BaseApplicationImpl.getContext());
  private static final float m = l * 0.6F;
  private static final int n = ScreenUtil.dip2px(160.0F);
  private final View b;
  private ImageView c;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ViewPropertyAnimator h;
  private boolean i;
  @Nullable
  private WSProfileToolbarItemClickListener j;
  private boolean k;
  
  public WSProfileToolbarController(@NotNull View paramView)
  {
    this.b = paramView.findViewById(1929707579);
    this.c = ((ImageView)paramView.findViewById(1929707549));
    this.d = ((TextView)paramView.findViewById(1929707609));
    this.e = ((ImageView)paramView.findViewById(1929707552));
    this.f = ((ImageView)paramView.findViewById(1929707551));
    this.g = ((ImageView)paramView.findViewById(1929707550));
    paramView = this.c;
    Object localObject = (View.OnClickListener)this;
    paramView.setOnClickListener((View.OnClickListener)localObject);
    this.f.setOnClickListener((View.OnClickListener)localObject);
    this.e.setOnClickListener((View.OnClickListener)localObject);
    this.g.setOnClickListener((View.OnClickListener)localObject);
    paramView = this.b;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "toolbar");
    int i1 = paramView.getPaddingLeft();
    localObject = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "toolbar");
    int i2 = ((View)localObject).getPaddingTop();
    localObject = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "toolbar");
    int i3 = ImmersiveUtils.getStatusBarHeight(((View)localObject).getContext());
    localObject = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "toolbar");
    int i4 = ((View)localObject).getPaddingRight();
    localObject = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "toolbar");
    paramView.setPadding(i1, i2 + i3, i4, ((View)localObject).getPaddingBottom());
    c(0);
    paramView = this.d;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "tvTitle");
    paramView.setAlpha(0.0F);
    this.d.setHorizontallyScrolling(false);
    c(false);
  }
  
  private final int a(View paramView)
  {
    if (paramView == null) {
      return 0;
    }
    Object localObject = paramView.getLayoutParams();
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      return paramView.getWidth() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
  }
  
  private final void a(ViewPropertyAnimator paramViewPropertyAnimator)
  {
    if (paramViewPropertyAnimator != null) {
      paramViewPropertyAnimator.cancel();
    }
  }
  
  private final void b(int paramInt)
  {
    Object localObject = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "toolbar");
    paramInt = ((View)localObject).getWidth() - paramInt * 2;
    localObject = this.d;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tvTitle");
    localObject = ((TextView)localObject).getPaint();
    TextView localTextView = this.d;
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "tvTitle");
    int i1 = (int)((TextPaint)localObject).measureText(localTextView.getText().toString());
    float f1;
    if (i1 <= paramInt)
    {
      localObject = this.b;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "toolbar");
      f1 = (((View)localObject).getWidth() - i1) / 2.0F;
      localObject = this.c;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ivBack");
      paramInt = ((ImageView)localObject).getWidth();
    }
    else
    {
      localObject = this.b;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "toolbar");
      f1 = (((View)localObject).getWidth() - paramInt) / 2.0F;
      localObject = this.c;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ivBack");
      paramInt = ((ImageView)localObject).getWidth();
    }
    float f2 = paramInt;
    localObject = this.d;
    paramInt = (int)(f1 - f2);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tvTitle");
    i1 = ((TextView)localObject).getPaddingTop();
    localTextView = this.d;
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "tvTitle");
    int i2 = localTextView.getPaddingRight();
    localTextView = this.d;
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "tvTitle");
    ((TextView)localObject).setPadding(paramInt, i1, i2, localTextView.getPaddingBottom());
  }
  
  private final void c(int paramInt)
  {
    float f2 = paramInt;
    float f3 = l;
    float f1 = 1.0F;
    if (f2 < f3) {
      f1 = f2 * 1.0F / f3;
    }
    Object localObject = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "toolbar");
    localObject = ((View)localObject).getBackground();
    if (localObject != null)
    {
      localObject = ((Drawable)localObject).mutate();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.mutate()");
      ((Drawable)localObject).setAlpha((int)(f1 * 'ÿ'));
    }
  }
  
  private final void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setImageResource(2130844283);
      this.e.setImageResource(1929642006);
      this.f.setImageResource(1929641990);
      this.g.setImageResource(2130841270);
      return;
    }
    this.c.setImageResource(2130844284);
    this.e.setImageResource(1929642007);
    this.f.setImageResource(1929641991);
    this.g.setImageResource(1929641988);
  }
  
  private final int d()
  {
    Object localObject = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "toolbar");
    int i2 = ((View)localObject).getPaddingRight();
    localObject = this.g;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ivDetail");
    int i1 = i2;
    if (((ImageView)localObject).getVisibility() == 0) {
      i1 = i2 + a((View)this.g);
    }
    localObject = this.f;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ivFeedback");
    i2 = i1;
    if (((ImageView)localObject).getVisibility() == 0) {
      i2 = i1 + a((View)this.f);
    }
    localObject = this.e;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ivShare");
    i1 = i2;
    if (((ImageView)localObject).getVisibility() == 0) {
      i1 = i2 + a((View)this.e);
    }
    return i1;
  }
  
  private final void d(int paramInt)
  {
    boolean bool;
    if ((paramInt <= n) && (this.i))
    {
      bool = false;
    }
    else
    {
      if ((paramInt <= n) || (this.i)) {
        return;
      }
      bool = true;
    }
    a(this.h);
    this.i = bool;
    ViewPropertyAnimator localViewPropertyAnimator = this.d.animate();
    float f1;
    if (bool) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    localViewPropertyAnimator = localViewPropertyAnimator.alpha(f1).setDuration(200L);
    localViewPropertyAnimator.start();
    this.h = localViewPropertyAnimator;
  }
  
  private final void e(int paramInt)
  {
    float f1 = paramInt;
    boolean bool;
    if ((f1 <= m) && (this.k))
    {
      bool = false;
    }
    else
    {
      if ((f1 <= m) || (this.k)) {
        return;
      }
      bool = true;
    }
    this.k = bool;
    c(bool);
  }
  
  public final void a(int paramInt)
  {
    c(paramInt);
    e(paramInt);
    d(paramInt);
  }
  
  public final void a(@Nullable WSProfileToolbarItemClickListener paramWSProfileToolbarItemClickListener)
  {
    this.j = paramWSProfileToolbarItemClickListener;
  }
  
  public final void a(@Nullable String paramString)
  {
    TextView localTextView = this.d;
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "tvTitle");
    localTextView.setText((CharSequence)paramString);
    this.d.post((Runnable)new WSProfileToolbarController.setTitle.1(this));
  }
  
  public final void a(boolean paramBoolean)
  {
    ImageView localImageView = this.f;
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "ivFeedback");
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  public final boolean a()
  {
    return this.k;
  }
  
  public final void b()
  {
    this.b.measure(0, 0);
  }
  
  public final void b(boolean paramBoolean)
  {
    ImageView localImageView = this.g;
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "ivDetail");
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  public final int c()
  {
    View localView = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localView, "toolbar");
    return localView.getMeasuredHeight();
  }
  
  public void onClick(@Nullable View paramView)
  {
    if (Intrinsics.areEqual(paramView, this.c))
    {
      paramView = this.j;
      if (paramView != null) {
        paramView.a();
      }
    }
    else if (Intrinsics.areEqual(paramView, this.e))
    {
      paramView = this.j;
      if (paramView != null) {
        paramView.b();
      }
    }
    else if (Intrinsics.areEqual(paramView, this.f))
    {
      paramView = this.j;
      if (paramView != null) {
        paramView.c();
      }
    }
    else if (Intrinsics.areEqual(paramView, this.g))
    {
      paramView = this.j;
      if (paramView != null) {
        paramView.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.toolbar.WSProfileToolbarController
 * JD-Core Version:    0.7.0.1
 */