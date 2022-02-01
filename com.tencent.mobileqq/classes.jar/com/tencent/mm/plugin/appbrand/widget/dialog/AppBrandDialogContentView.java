package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.pd.w;

public class AppBrandDialogContentView
  extends FrameLayout
{
  private final int[] a = { 0, 0 };
  
  public AppBrandDialogContentView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandDialogContentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppBrandDialogContentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = getContext();
    if ((!w.a((Context)localObject)) && (((Context)localObject).getResources().getConfiguration().orientation != 2))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    this.a[0] = View.MeasureSpec.getSize(paramInt1);
    this.a[1] = View.MeasureSpec.getSize(paramInt2);
    m.a(getContext(), this.a, getContext().getResources().getDisplayMetrics());
    localObject = this.a;
    setMeasuredDimension(localObject[0], localObject[1]);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.a[0], View.MeasureSpec.getMode(paramInt1)), View.MeasureSpec.makeMeasureSpec(this.a[1], View.MeasureSpec.getMode(paramInt2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandDialogContentView
 * JD-Core Version:    0.7.0.1
 */