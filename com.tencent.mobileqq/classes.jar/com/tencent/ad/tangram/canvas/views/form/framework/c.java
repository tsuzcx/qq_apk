package com.tencent.ad.tangram.canvas.views.form.framework;

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
import com.tencent.ad.tangram.canvas.views.form.textbox.a;
import com.tencent.ad.tangram.canvas.views.form.textbox.b;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

public final class c
  extends TableLayout
{
  private static final String TAG = "AdFormTableView";
  private AdFormTableData data;
  private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
  
  public c(Context paramContext, AdFormTableData paramAdFormTableData, WeakReference<AdFormErrorListener> paramWeakReference)
  {
    super(paramContext);
    init(paramContext, paramAdFormTableData, paramWeakReference);
  }
  
  private Drawable getBackground(int paramInt)
  {
    if ((this.data == null) || (!this.data.isValid()) || (this.data.getSize() != getChildCount()))
    {
      AdLog.e("AdFormTableView", "getBackground error");
      localObject1 = null;
    }
    int i;
    Object localObject2;
    label164:
    do
    {
      return localObject1;
      if (paramInt == -1)
      {
        i = this.data.getSize();
        localObject1 = new Drawable[i];
        j = 0;
      }
      for (;;)
      {
        if (j >= this.data.getSize()) {
          break label164;
        }
        localObject2 = this.data.getItem(j);
        if (localObject2 == null)
        {
          AdLog.e("AdFormTableView", "getBackground error");
          return null;
          i = this.data.getSize() + 1;
          break;
        }
        localObject1[j] = getDrawable(getDrawableRadii(this.data.borderCornerRadius, j, this.data.getSize()), this.data.borderWidth, this.data.borderColor, ((AdFormItemData)localObject2).backgroundColor);
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
        localObject1[(i - 1)] = getDrawable(getDrawableRadii(this.data.borderCornerRadius, paramInt, this.data.getSize()), this.data.borderWidth, this.data.borderColorError, ((AdFormItemData)localObject2).backgroundColor);
      }
      localObject2 = new LayerDrawable((Drawable[])localObject1);
      int j = 0;
      while (j < this.data.getSize())
      {
        localObject1 = getChildAt(j);
        if (localObject1 == null)
        {
          AdLog.e("AdFormTableView", "getBackground error");
          return null;
        }
        ((LayerDrawable)localObject2).setLayerInset(j, 0, ((View)localObject1).getTop() - this.data.borderWidth, 0, getHeight() - ((View)localObject1).getBottom() - this.data.borderWidth);
        j += 1;
      }
      localObject1 = localObject2;
    } while (paramInt == -1);
    Object localObject1 = getChildAt(paramInt);
    if (localObject1 == null)
    {
      AdLog.e("AdFormTableView", "getBackground error");
      return null;
    }
    ((LayerDrawable)localObject2).setLayerInset(i - 1, 0, ((View)localObject1).getTop() - this.data.borderWidth, 0, getHeight() - ((View)localObject1).getBottom() - this.data.borderWidth);
    return localObject2;
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
    if ((paramInt2 < 0) || (paramInt2 >= paramInt3) || (paramInt3 <= 0)) {
      return null;
    }
    if (paramInt3 == 1) {
      return new float[] { paramInt1, paramInt1, paramInt1, paramInt1, paramInt1, paramInt1, paramInt1, paramInt1 };
    }
    if (paramInt2 == 0) {
      return new float[] { paramInt1, paramInt1, paramInt1, paramInt1, 0.0F, 0.0F, 0.0F, 0.0F };
    }
    if (paramInt2 == paramInt3 - 1) {
      return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, paramInt1, paramInt1, paramInt1, paramInt1 };
    }
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private void init(Context paramContext, AdFormTableData paramAdFormTableData, WeakReference<AdFormErrorListener> paramWeakReference)
  {
    if ((paramContext == null) || (paramAdFormTableData == null) || (!paramAdFormTableData.isValid()))
    {
      AdLog.e("AdFormTableView", "init error");
      return;
    }
    this.data = paramAdFormTableData;
    setColumnShrinkable(1, true);
    setColumnStretchable(1, true);
    int i = 0;
    while (i < paramAdFormTableData.getSize())
    {
      Object localObject = paramAdFormTableData.getItem(i);
      b localb = null;
      if ((localObject instanceof a)) {
        localb = new b(paramContext, (a)a.class.cast(localObject), paramWeakReference);
      }
      if (localb == null)
      {
        AdLog.e("AdFormTableView", "init error");
        i += 1;
      }
      else
      {
        localObject = new TableLayout.LayoutParams(-2, -2);
        if (i == paramAdFormTableData.getSize() - 1) {
          ((TableLayout.LayoutParams)localObject).setMargins(paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth);
        }
        for (;;)
        {
          addView(localb, (ViewGroup.LayoutParams)localObject);
          break;
          ((TableLayout.LayoutParams)localObject).setMargins(paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth, paramAdFormTableData.borderWidth, 0);
        }
      }
    }
    resetBackground();
  }
  
  @TargetApi(16)
  private void resetBackground()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      return;
      if ((this.layoutListener != null) && (getViewTreeObserver() != null))
      {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
        this.layoutListener = null;
      }
      this.layoutListener = new c.1(this);
    } while ((this.layoutListener == null) || (getViewTreeObserver() == null));
    getViewTreeObserver().addOnGlobalLayoutListener(this.layoutListener);
  }
  
  public void reset()
  {
    resetBackground();
    if ((this.data == null) || (!this.data.isValid()) || (this.data.getSize() != getChildCount()))
    {
      AdLog.e("AdFormTableView", "reset error");
      return;
    }
    int i = 0;
    label45:
    if (i < getChildCount())
    {
      if ((getChildAt(i) != null) && ((getChildAt(i) instanceof AdFormItemView))) {
        break label86;
      }
      AdLog.e("AdFormTableView", "reset error");
    }
    for (;;)
    {
      i += 1;
      break label45;
      break;
      label86:
      ((AdFormItemView)AdFormItemView.class.cast(getChildAt(i))).reset();
    }
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
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.c
 * JD-Core Version:    0.7.0.1
 */