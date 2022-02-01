package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lo.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.ArrayList;
import java.util.List;

public final class AppBrandMultiOptionsPickerV2
  extends LinearLayout
  implements c<int[]>
{
  private List<AppBrandOptionsPickerV3> a;
  private boolean b;
  private boolean c;
  private d d;
  
  @Keep
  public AppBrandMultiOptionsPickerV2(Context paramContext)
  {
    super(paramContext);
    setOrientation(0);
    this.a = new ArrayList();
  }
  
  @Nullable
  private AppBrandOptionsPickerV3 a(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    return (AppBrandOptionsPickerV3)this.a.get(paramInt);
  }
  
  private void a(int paramInt, AppBrandMultiOptionsPickerV2.a[] paramArrayOfa)
  {
    if (paramInt <= 0) {
      return;
    }
    int i = 0;
    while (i < paramInt)
    {
      AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3 = b(AppBrandMultiOptionsPickerV2.a.b(paramArrayOfa[i]));
      this.a.add(localAppBrandOptionsPickerV3);
      addView(localAppBrandOptionsPickerV3.e(), new LinearLayout.LayoutParams(-1, -2, 1.0F));
      i += 1;
    }
    b();
  }
  
  private AppBrandOptionsPickerV3 b(int paramInt)
  {
    AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3 = new AppBrandOptionsPickerV3(getContext());
    localAppBrandOptionsPickerV3.a(paramInt);
    localAppBrandOptionsPickerV3.a();
    localAppBrandOptionsPickerV3.a(getContext().getResources().getDimensionPixelSize(2131296955));
    localAppBrandOptionsPickerV3.c(getContext().getResources().getDimensionPixelSize(2131298211));
    return localAppBrandOptionsPickerV3;
  }
  
  private void b()
  {
    if (this.a.size() == 1)
    {
      ((AppBrandOptionsPickerV3)this.a.get(0)).e().setPadding(0, getContext().getResources().getDimensionPixelSize(2131296336), 0, getContext().getResources().getDimensionPixelSize(2131296336));
      return;
    }
    if (this.a.size() == 2)
    {
      ((AppBrandOptionsPickerV3)this.a.get(0)).e().setPadding(0, getContext().getResources().getDimensionPixelSize(2131296336), getContext().getResources().getDimensionPixelSize(2131296336), getContext().getResources().getDimensionPixelSize(2131296336));
      ((AppBrandOptionsPickerV3)this.a.get(1)).e().setPadding(getContext().getResources().getDimensionPixelSize(2131296336), getContext().getResources().getDimensionPixelSize(2131296336), 0, getContext().getResources().getDimensionPixelSize(2131296336));
      return;
    }
    if (this.a.size() == 3)
    {
      ((AppBrandOptionsPickerV3)this.a.get(0)).e().setPadding(0, getContext().getResources().getDimensionPixelSize(2131296336), getContext().getResources().getDimensionPixelSize(2131296317), getContext().getResources().getDimensionPixelSize(2131296336));
      ((AppBrandOptionsPickerV3)this.a.get(1)).e().setPadding(getContext().getResources().getDimensionPixelSize(2131296317), getContext().getResources().getDimensionPixelSize(2131296336), getContext().getResources().getDimensionPixelSize(2131296317), getContext().getResources().getDimensionPixelSize(2131296336));
      ((AppBrandOptionsPickerV3)this.a.get(2)).e().setPadding(getContext().getResources().getDimensionPixelSize(2131296317), getContext().getResources().getDimensionPixelSize(2131296336), 0, getContext().getResources().getDimensionPixelSize(2131296336));
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    int i = getPickersCount() - 1;
    while (paramInt > 0)
    {
      removeViewAt(i);
      i -= 1;
      paramInt -= 1;
    }
    b();
  }
  
  private int getPickersCount()
  {
    return getChildCount();
  }
  
  public void a(int paramInt, AppBrandMultiOptionsPickerV2.a parama)
  {
    if (paramInt < 0) {
      return;
    }
    if (paramInt >= getPickersCount()) {
      return;
    }
    if (parama == null) {
      return;
    }
    setLayoutFrozen(true);
    a(paramInt).a(AppBrandMultiOptionsPickerV2.a.a(parama));
    if (!af.a(AppBrandMultiOptionsPickerV2.a.a(parama))) {
      a(paramInt).b(AppBrandMultiOptionsPickerV2.a.b(parama));
    }
    setLayoutFrozen(false);
  }
  
  public void a(AppBrandMultiOptionsPickerV2.a[] paramArrayOfa)
  {
    if (paramArrayOfa != null)
    {
      if (paramArrayOfa.length <= 0) {
        return;
      }
      int i = getPickersCount();
      setLayoutFrozen(true);
      if (i < paramArrayOfa.length) {
        a(paramArrayOfa.length - i, paramArrayOfa);
      } else if (i > paramArrayOfa.length) {
        c(i - paramArrayOfa.length);
      }
      i = 0;
      while (i < paramArrayOfa.length)
      {
        AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3 = a(i);
        AppBrandMultiOptionsPickerV2.a locala = paramArrayOfa[i];
        localAppBrandOptionsPickerV3.a(AppBrandMultiOptionsPickerV2.a.a(locala));
        localAppBrandOptionsPickerV3.a(AppBrandMultiOptionsPickerV2.a.b(locala));
        localAppBrandOptionsPickerV3.a(new AppBrandMultiOptionsPickerV2.1(this, i));
        i += 1;
      }
      setWeightSum(getPickersCount());
      setLayoutFrozen(false);
    }
  }
  
  public int[] a()
  {
    int j = getPickersCount();
    int i = 0;
    if (j <= 0) {
      return new int[0];
    }
    int[] arrayOfInt = new int[j];
    while (i < j)
    {
      arrayOfInt[i] = a(i).b();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void onAttach(d paramd)
  {
    this.d = paramd;
  }
  
  public void onDetach(d paramd)
  {
    this.d = null;
  }
  
  public void onHide(d paramd) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onShow(d paramd)
  {
    this.d = paramd;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void requestLayout()
  {
    if (this.b)
    {
      this.c = true;
      return;
    }
    super.requestLayout();
  }
  
  void setLayoutFrozen(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      if (paramBoolean)
      {
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        return;
      }
      if (this.c) {
        requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2
 * JD-Core Version:    0.7.0.1
 */