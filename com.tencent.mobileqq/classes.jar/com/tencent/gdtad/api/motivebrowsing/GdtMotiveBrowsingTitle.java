package com.tencent.gdtad.api.motivebrowsing;

import abnl;
import abnm;
import abnn;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awhf;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingTitle;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "countDownContainer", "Landroid/widget/LinearLayout;", "imgClose", "Landroid/view/View;", "tvBrowsing", "Landroid/widget/TextView;", "createBackGround", "Landroid/graphics/drawable/Drawable;", "createBrowsingString", "", "kotlin.jvm.PlatformType", "second", "createCloseIcon", "", "createCountDownContainer", "initViewWithLeftSecond", "setOnCloseClickListener", "onClick", "Lkotlin/Function0;", "Companion", "GdtMotiveBrowsingCenterFixWidthSpan", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingTitle
  extends RelativeLayout
{
  public static final abnl a;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  static
  {
    jdField_a_of_type_Abnl = new abnl(null);
  }
  
  public GdtMotiveBrowsingTitle(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GdtMotiveBrowsingTitle(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GdtMotiveBrowsingTitle(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ImmersiveUtils.a(true, ((Activity)paramContext).getWindow());
    int i = AIOUtils.dp2px(63.0F, getResources());
    paramInt = i;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      int j = ImmersiveUtils.getStatusBarHeight(paramContext);
      paramInt = i + j;
      i = AIOUtils.dp2px(15.0F, getResources());
      setPadding(i, j + i, i, i);
    }
    setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, paramInt));
    setBackgroundColor(-1);
    a();
    b();
  }
  
  private final Drawable a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.dp2px(18.0F, getResources()));
    localGradientDrawable.setStroke(AIOUtils.dp2px(1.0F, getResources()), Color.parseColor("#E5E5E5"));
    return (Drawable)localGradientDrawable;
  }
  
  private final CharSequence a(int paramInt)
  {
    if (paramInt > 0)
    {
      abnm localabnm = new abnm(AIOUtils.dp2px(23.0F, getResources()));
      String str = String.valueOf(paramInt);
      SpannableString localSpannableString = new SpannableString((CharSequence)getResources().getString(2131692645, new Object[] { str }));
      localSpannableString.setSpan(localabnm, 2, str.length() + 2, 17);
      return (CharSequence)localSpannableString;
    }
    return (CharSequence)getResources().getString(2131692647);
  }
  
  private final void a()
  {
    int i = AIOUtils.dp2px(16.0F, getResources());
    Object localObject1 = new RelativeLayout.LayoutParams(-2, AIOUtils.dp2px(33.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    awhf.a((View)localObject2, a());
    localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).setPadding(i, 0, i, 0);
    localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).setOrientation(0);
    localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).setGravity(16);
    localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setText((CharSequence)getResources().getString(2131692648));
    ((TextView)localObject1).setId(2131367467);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setTextSize(1, 14.0F);
    localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).addView((View)localObject1);
    localObject1 = new View(getContext());
    i = AIOUtils.dp2px(1.0F, getResources());
    int j = AIOUtils.dp2px(20.0F, getResources());
    int k = AIOUtils.dp2px(10.0F, getResources());
    localObject2 = new RelativeLayout.LayoutParams(i, j);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = k;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = k;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((View)localObject1).setBackgroundColor(Color.parseColor("#E5E5E5"));
    localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject2).addView((View)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject1).setId(2131367466);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject1).setTextColor(-16777216);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject1).setTextSize(1, 14.0F);
    localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject1).setVisibility(8);
    localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    addView((View)localObject1);
  }
  
  private final void b()
  {
    int i = AIOUtils.dp2px(33.0F, getResources());
    Object localObject1 = new RelativeLayout.LayoutParams(i, i);
    Object localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    this.jdField_a_of_type_AndroidViewView = ((View)new GdtMotiveBrowsingImage((Context)localObject2));
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    localObject2 = this.jdField_a_of_type_AndroidViewView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("imgClose");
    }
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("imgClose");
    }
    addView((View)localObject1);
  }
  
  public final void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("countDownContainer");
    }
    ((LinearLayout)localObject).setVisibility(0);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject).setVisibility(0);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvBrowsing");
    }
    ((TextView)localObject).setText(a(paramInt));
  }
  
  public final void setOnCloseClickListener(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "onClick");
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("imgClose");
    }
    localView.setOnClickListener((View.OnClickListener)new abnn(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingTitle
 * JD-Core Version:    0.7.0.1
 */