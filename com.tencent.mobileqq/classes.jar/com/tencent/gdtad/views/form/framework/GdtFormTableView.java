package com.tencent.gdtad.views.form.framework;

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
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView;
import java.lang.ref.WeakReference;
import yxs;
import zan;
import zar;

public class GdtFormTableView
  extends TableLayout
{
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  private GdtFormTableData jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData;
  
  public GdtFormTableView(Context paramContext, GdtFormTableData paramGdtFormTableData, WeakReference<zan> paramWeakReference)
  {
    super(paramContext);
    a(paramContext, paramGdtFormTableData, paramWeakReference);
  }
  
  private Drawable a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.isValid()) || (this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getSize() != getChildCount()))
    {
      yxs.d("GdtFormTableView", "getBackground error");
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
        i = this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getSize();
        localObject1 = new Drawable[i];
        j = 0;
      }
      for (;;)
      {
        if (j >= this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getSize()) {
          break label164;
        }
        localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getItem(j);
        if (localObject2 == null)
        {
          yxs.d("GdtFormTableView", "getBackground error");
          return null;
          i = this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getSize() + 1;
          break;
        }
        localObject1[j] = a(a(this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderCornerRadius, j, this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getSize()), this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderWidth, this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderColor, ((GdtFormItemData)localObject2).backgroundColor);
        j += 1;
      }
      if (paramInt != -1)
      {
        localObject2 = this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getItem(paramInt);
        if (localObject2 == null)
        {
          yxs.d("GdtFormTableView", "getBackground error");
          return null;
        }
        localObject1[(i - 1)] = a(a(this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderCornerRadius, paramInt, this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getSize()), this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderWidth, this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderColorError, ((GdtFormItemData)localObject2).backgroundColor);
      }
      localObject2 = new LayerDrawable((Drawable[])localObject1);
      int j = 0;
      while (j < this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getSize())
      {
        localObject1 = getChildAt(j);
        if (localObject1 == null)
        {
          yxs.d("GdtFormTableView", "getBackground error");
          return null;
        }
        ((LayerDrawable)localObject2).setLayerInset(j, 0, ((View)localObject1).getTop() - this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderWidth, 0, getHeight() - ((View)localObject1).getBottom() - this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderWidth);
        j += 1;
      }
      localObject1 = localObject2;
    } while (paramInt == -1);
    Object localObject1 = getChildAt(paramInt);
    if (localObject1 == null)
    {
      yxs.d("GdtFormTableView", "getBackground error");
      return null;
    }
    ((LayerDrawable)localObject2).setLayerInset(i - 1, 0, ((View)localObject1).getTop() - this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderWidth, 0, getHeight() - ((View)localObject1).getBottom() - this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.borderWidth);
    return localObject2;
  }
  
  private static Drawable a(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadii(paramArrayOfFloat);
    localGradientDrawable.setStroke(paramInt1, paramInt2);
    localGradientDrawable.setColor(paramInt3);
    return localGradientDrawable;
  }
  
  private void a(Context paramContext, GdtFormTableData paramGdtFormTableData, WeakReference<zan> paramWeakReference)
  {
    if ((paramContext == null) || (paramGdtFormTableData == null) || (!paramGdtFormTableData.isValid()))
    {
      yxs.d("GdtFormTableView", "init error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData = paramGdtFormTableData;
    setColumnShrinkable(1, true);
    setColumnStretchable(1, true);
    int i = 0;
    while (i < paramGdtFormTableData.getSize())
    {
      Object localObject = paramGdtFormTableData.getItem(i);
      GdtFormItemTextBoxView localGdtFormItemTextBoxView = null;
      if ((localObject instanceof GdtFormItemTextBoxData)) {
        localGdtFormItemTextBoxView = new GdtFormItemTextBoxView(paramContext, (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject), paramWeakReference);
      }
      if (localGdtFormItemTextBoxView == null)
      {
        yxs.d("GdtFormTableView", "init error");
        i += 1;
      }
      else
      {
        localObject = new TableLayout.LayoutParams(-2, -2);
        if (i == paramGdtFormTableData.getSize() - 1) {
          ((TableLayout.LayoutParams)localObject).setMargins(paramGdtFormTableData.borderWidth, paramGdtFormTableData.borderWidth, paramGdtFormTableData.borderWidth, paramGdtFormTableData.borderWidth);
        }
        for (;;)
        {
          addView(localGdtFormItemTextBoxView, (ViewGroup.LayoutParams)localObject);
          break;
          ((TableLayout.LayoutParams)localObject).setMargins(paramGdtFormTableData.borderWidth, paramGdtFormTableData.borderWidth, paramGdtFormTableData.borderWidth, 0);
        }
      }
    }
    b();
  }
  
  private static float[] a(int paramInt1, int paramInt2, int paramInt3)
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
  
  @TargetApi(16)
  private void b()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener != null) && (getViewTreeObserver() != null))
      {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
        this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
      }
      this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new zar(this);
    } while ((this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null) || (getViewTreeObserver() == null));
    getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  public void a()
  {
    b();
    if ((this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData == null) || (!this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.isValid()) || (this.jdField_a_of_type_ComTencentGdtadViewsFormFrameworkGdtFormTableData.getSize() != getChildCount()))
    {
      yxs.d("GdtFormTableView", "reset error");
      return;
    }
    int i = 0;
    label45:
    if (i < getChildCount())
    {
      if ((getChildAt(i) != null) && ((getChildAt(i) instanceof GdtFormItemView))) {
        break label86;
      }
      yxs.d("GdtFormTableView", "reset error");
    }
    for (;;)
    {
      i += 1;
      break label45;
      break;
      label86:
      ((GdtFormItemView)GdtFormItemView.class.cast(getChildAt(i))).a();
    }
  }
  
  @TargetApi(16)
  public void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(a(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormTableView
 * JD-Core Version:    0.7.0.1
 */