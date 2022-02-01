package com.tencent.ad.tangram.views.form.framework;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.textbox.a;
import com.tencent.ad.tangram.views.form.textbox.b;
import java.lang.ref.WeakReference;

public final class h
  extends TableLayout
{
  private static final String TAG = "AdFormTableView";
  private g data;
  private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
  
  public h(Context paramContext, g paramg, WeakReference<c> paramWeakReference)
  {
    super(paramContext);
    init(paramContext, paramg, paramWeakReference);
  }
  
  private Drawable getBackground(int paramInt)
  {
    Object localObject1 = this.data;
    if ((localObject1 != null) && (((g)localObject1).isValid()) && (this.data.getSize() == getChildCount()))
    {
      int i;
      if (paramInt == -1) {
        i = this.data.getSize();
      } else {
        i = this.data.getSize() + 1;
      }
      localObject1 = new Drawable[i];
      int k = 0;
      int j = 0;
      Object localObject2;
      while (j < this.data.getSize())
      {
        localObject2 = this.data.getItem(j);
        if (localObject2 == null)
        {
          AdLog.e("AdFormTableView", "getBackground error");
          return null;
        }
        localObject1[j] = getDrawable(getDrawableRadii(this.data.borderCornerRadius, j, this.data.getSize()), this.data.borderWidth, this.data.borderColor, ((d)localObject2).backgroundColor);
        j += 1;
      }
      if (paramInt != -1)
      {
        localObject2 = this.data.getItem(paramInt);
        if (localObject2 == null)
        {
          AdLog.e("AdFormTableView", "getBackground error");
          return null;
        }
        localObject1[(i - 1)] = getDrawable(getDrawableRadii(this.data.borderCornerRadius, paramInt, this.data.getSize()), this.data.borderWidth, this.data.borderColorError, ((d)localObject2).backgroundColor);
      }
      localObject1 = new LayerDrawable((Drawable[])localObject1);
      j = k;
      while (j < this.data.getSize())
      {
        localObject2 = getChildAt(j);
        if (localObject2 == null)
        {
          AdLog.e("AdFormTableView", "getBackground error");
          return null;
        }
        ((LayerDrawable)localObject1).setLayerInset(j, 0, ((View)localObject2).getTop() - this.data.borderWidth, 0, getHeight() - ((View)localObject2).getBottom() - this.data.borderWidth);
        j += 1;
      }
      if (paramInt != -1)
      {
        localObject2 = getChildAt(paramInt);
        if (localObject2 == null)
        {
          AdLog.e("AdFormTableView", "getBackground error");
          return null;
        }
        ((LayerDrawable)localObject1).setLayerInset(i - 1, 0, ((View)localObject2).getTop() - this.data.borderWidth, 0, getHeight() - ((View)localObject2).getBottom() - this.data.borderWidth);
      }
      return localObject1;
    }
    AdLog.e("AdFormTableView", "getBackground error");
    return null;
  }
  
  private static Drawable getDrawable(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadii(paramArrayOfFloat);
    localGradientDrawable.setStroke(paramInt1, paramInt2);
    localGradientDrawable.setColor(paramInt3);
    return localGradientDrawable;
  }
  
  private static float[] getDrawableRadii(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 >= 0) && (paramInt2 < paramInt3) && (paramInt3 > 0))
    {
      float f;
      if (paramInt3 == 1)
      {
        f = paramInt1;
        return new float[] { f, f, f, f, f, f, f, f };
      }
      if (paramInt2 == 0)
      {
        f = paramInt1;
        return new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F };
      }
      if (paramInt2 == paramInt3 - 1)
      {
        f = paramInt1;
        return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f };
      }
      return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    }
    return null;
  }
  
  private void init(Context paramContext, g paramg, WeakReference<c> paramWeakReference)
  {
    if ((paramContext != null) && (paramg != null) && (paramg.isValid()))
    {
      this.data = paramg;
      setColumnShrinkable(1, true);
      setColumnStretchable(1, true);
      int i = 0;
      while (i < paramg.getSize())
      {
        Object localObject = paramg.getItem(i);
        b localb = null;
        if ((localObject instanceof a)) {
          localb = new b(paramContext, (a)a.class.cast(localObject), paramWeakReference);
        }
        if (localb == null)
        {
          AdLog.e("AdFormTableView", "init error");
        }
        else
        {
          localObject = new TableLayout.LayoutParams(-2, -2);
          if (i == paramg.getSize() - 1) {
            ((TableLayout.LayoutParams)localObject).setMargins(paramg.borderWidth, paramg.borderWidth, paramg.borderWidth, paramg.borderWidth);
          } else {
            ((TableLayout.LayoutParams)localObject).setMargins(paramg.borderWidth, paramg.borderWidth, paramg.borderWidth, 0);
          }
          addView(localb, (ViewGroup.LayoutParams)localObject);
        }
        i += 1;
      }
      resetBackground();
      return;
    }
    AdLog.e("AdFormTableView", "init error");
  }
  
  @TargetApi(16)
  private void resetBackground()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    if ((this.layoutListener != null) && (getViewTreeObserver() != null))
    {
      getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
      this.layoutListener = null;
    }
    this.layoutListener = new h.1(this);
    if ((this.layoutListener != null) && (getViewTreeObserver() != null)) {
      getViewTreeObserver().addOnGlobalLayoutListener(this.layoutListener);
    }
  }
  
  public void reset()
  {
    resetBackground();
    g localg = this.data;
    if ((localg != null) && (localg.isValid()) && (this.data.getSize() == getChildCount()))
    {
      int i = 0;
      while (i < getChildCount())
      {
        if ((getChildAt(i) != null) && ((getChildAt(i) instanceof e))) {
          ((e)e.class.cast(getChildAt(i))).reset();
        } else {
          AdLog.e("AdFormTableView", "reset error");
        }
        i += 1;
      }
      return;
    }
    AdLog.e("AdFormTableView", "reset error");
  }
  
  @TargetApi(16)
  public void showError(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(getBackground(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.h
 * JD-Core Version:    0.7.0.1
 */