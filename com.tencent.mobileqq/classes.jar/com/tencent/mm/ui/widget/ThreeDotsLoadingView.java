package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private static int a = -16777216;
  private int b = a;
  private boolean c = false;
  private boolean d = false;
  private ViewGroup e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private final Runnable i = new ThreeDotsLoadingView.1(this);
  
  public ThreeDotsLoadingView(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public ThreeDotsLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ThreeDotsLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public ThreeDotsLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private AnimationDrawable a(int paramInt, float[] paramArrayOfFloat)
  {
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnimationDrawable hash:");
    localStringBuilder.append(localAnimationDrawable.hashCode());
    o.d("ThreeDotsLoadingView", localStringBuilder.toString());
    int j = 0;
    localAnimationDrawable.setOneShot(false);
    int k = paramArrayOfFloat.length;
    while (j < k)
    {
      localAnimationDrawable.addFrame(a(paramInt, paramArrayOfFloat[j]), 300);
      j += 1;
    }
    return localAnimationDrawable;
  }
  
  private Drawable a(int paramInt, float paramFloat)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setIntrinsicHeight(32);
    localShapeDrawable.setIntrinsicWidth(32);
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setAlpha((int)(paramFloat * 255.0F));
    return localShapeDrawable;
  }
  
  private void a()
  {
    this.f.setImageDrawable(a(this.b, 0.5F));
    this.g.setImageDrawable(a(this.b, 0.4F));
    this.h.setImageDrawable(a(this.b, 0.3F));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.e = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131625233, this, true));
    a = paramContext.getResources().getColor(2131165569);
    this.b = a;
    this.f = ((ImageView)this.e.findViewById(2131437639));
    this.g = ((ImageView)this.e.findViewById(2131437640));
    this.h = ((ImageView)this.e.findViewById(2131437641));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThreeDotsLoadingView);
      this.b = paramContext.getColor(R.styleable.ThreeDotsLoadingView_dotColor, a);
      paramContext.recycle();
    }
    a();
  }
  
  private void b()
  {
    this.f.setImageDrawable(a(this.b, new float[] { 0.4F, 0.3F, 0.5F }));
    this.g.setImageDrawable(a(this.b, new float[] { 0.5F, 0.4F, 0.3F }));
    this.h.setImageDrawable(a(this.b, new float[] { 0.3F, 0.5F, 0.4F }));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.d)
    {
      this.d = false;
      startLoadingAnimation();
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    this.f.setAlpha(paramFloat);
    this.g.setAlpha(paramFloat);
    this.h.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(paramFloat * 255.0F));
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if ((8 == paramInt) || (4 == paramInt)) {
      stopLoadingAnimation();
    }
    super.setVisibility(paramInt);
  }
  
  public void startLoadingAnimation()
  {
    if (!ViewCompat.isAttachedToWindow(this))
    {
      this.d = true;
      return;
    }
    if (this.c) {
      return;
    }
    this.c = true;
    a();
    postDelayed(this.i, 300L);
  }
  
  public void stopLoadingAnimation()
  {
    this.d = false;
    if (!this.c) {
      return;
    }
    this.c = false;
    removeCallbacks(this.i);
    if ((this.f.getDrawable() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.f.getDrawable()).stop();
      ((AnimationDrawable)this.g.getDrawable()).stop();
      ((AnimationDrawable)this.h.getDrawable()).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */