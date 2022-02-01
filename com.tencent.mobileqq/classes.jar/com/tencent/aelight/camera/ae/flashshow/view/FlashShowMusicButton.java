package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowMusicButton;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeButton", "Landroid/view/View;", "closeIconSize", "currentState", "musicIcon", "musicIconSize", "progressView", "Landroid/widget/ProgressBar;", "textColor", "textHorizontalMargin", "textSize", "textView", "Landroid/widget/TextView;", "applyMusicStateInner", "", "state", "musicTitle", "", "initProgress", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setCloseButtonListener", "listener", "Landroid/view/View$OnClickListener;", "setMusicOff", "setMusicOn", "title", "showIcon", "show", "", "toPx", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowMusicButton
  extends LinearLayout
{
  public static final FlashShowMusicButton.Companion a = new FlashShowMusicButton.Companion(null);
  private final View b;
  private final TextView c;
  private final View d;
  private ProgressBar e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private int k;
  
  public FlashShowMusicButton(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlashShowMusicButton(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlashShowMusicButton(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    setGravity(17);
    this.f = a(16);
    this.g = a(12);
    this.h = Color.parseColor("#FFFFFF");
    this.i = a(6);
    this.j = a(16);
    a();
    paramAttributeSet = new ImageView(getContext());
    paramAttributeSet.setImageResource(2063925552);
    paramInt = this.f;
    paramContext = new LinearLayout.LayoutParams(paramInt, paramInt);
    paramAttributeSet = (View)paramAttributeSet;
    addView(paramAttributeSet, (ViewGroup.LayoutParams)paramContext);
    this.b = paramAttributeSet;
    paramContext = new TextView(getContext());
    paramContext.setTextSize(0, paramContext.getTextSize());
    paramContext.setTextColor(this.h);
    paramContext.setMaxWidth(a(92));
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramInt = this.i;
    paramAttributeSet.leftMargin = paramInt;
    paramAttributeSet.rightMargin = paramInt;
    addView((View)paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.c = paramContext;
    paramAttributeSet = new ImageView(getContext());
    paramAttributeSet.setImageResource(2063925551);
    paramInt = this.j;
    paramContext = new LinearLayout.LayoutParams(paramInt, paramInt);
    paramAttributeSet = (View)paramAttributeSet;
    addView(paramAttributeSet, (ViewGroup.LayoutParams)paramContext);
    this.d = paramAttributeSet;
    a(this, 0, null, 2, null);
  }
  
  private final int a(int paramInt)
  {
    float f1 = paramInt;
    Resources localResources = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "resources");
    return (int)TypedValue.applyDimension(1, f1, localResources.getDisplayMetrics());
  }
  
  private final void a()
  {
    ProgressBar localProgressBar = new ProgressBar(getContext());
    int m = DisplayUtil.a(localProgressBar.getContext(), 16.0F);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, m);
    addView((View)localProgressBar, (ViewGroup.LayoutParams)localLayoutParams);
    localProgressBar.setVisibility(8);
    this.e = localProgressBar;
  }
  
  private final void a(int paramInt, String paramString)
  {
    int m = 0;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    View localView = this.d;
    if (!bool) {
      m = 8;
    }
    localView.setVisibility(m);
    this.c.setText((CharSequence)paramString);
    this.c.setSelected(bool);
    this.k = paramInt;
    requestLayout();
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      localProgressBar = this.e;
      if (localProgressBar == null) {
        Intrinsics.throwUninitializedPropertyAccessException("progressView");
      }
      localProgressBar.setVisibility(8);
      return;
    }
    this.b.setVisibility(8);
    ProgressBar localProgressBar = this.e;
    if (localProgressBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("progressView");
    }
    localProgressBar.setVisibility(0);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setCloseButtonListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public final void setMusicOff()
  {
    if (this.k != 0) {
      a(this, 0, null, 2, null);
    }
  }
  
  public final void setMusicOn(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "title");
    if (this.k == 1)
    {
      CharSequence localCharSequence = this.c.getText();
      if (localCharSequence == null) {
        localCharSequence = (CharSequence)"";
      }
      if (!(Intrinsics.areEqual(localCharSequence, paramString) ^ true)) {}
    }
    else
    {
      a(true);
      a(1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.FlashShowMusicButton
 * JD-Core Version:    0.7.0.1
 */