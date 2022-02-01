package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.style;

public class BottomSheetDialog
  extends AppCompatDialog
{
  boolean a;
  boolean b = true;
  private BottomSheetBehavior<FrameLayout> c;
  private FrameLayout d;
  private boolean e = true;
  private boolean f;
  @NonNull
  private BottomSheetBehavior.BottomSheetCallback g = new BottomSheetDialog.4(this);
  
  public BottomSheetDialog(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BottomSheetDialog(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    super(paramContext, a(paramContext, paramInt));
    supportRequestWindowFeature(1);
  }
  
  private static int a(@NonNull Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      if (paramContext.getTheme().resolveAttribute(R.attr.g, localTypedValue, true)) {
        return localTypedValue.resourceId;
      }
      i = R.style.h;
    }
    return i;
  }
  
  private View a(int paramInt, @Nullable View paramView, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    e();
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)this.d.findViewById(R.id.d);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)this.d.findViewById(R.id.e);
    paramView.removeAllViews();
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    } else {
      paramView.addView(localView, paramLayoutParams);
    }
    localCoordinatorLayout.findViewById(R.id.al).setOnClickListener(new BottomSheetDialog.1(this));
    ViewCompat.setAccessibilityDelegate(paramView, new BottomSheetDialog.2(this));
    paramView.setOnTouchListener(new BottomSheetDialog.3(this));
    return this.d;
  }
  
  private FrameLayout e()
  {
    if (this.d == null)
    {
      this.d = ((FrameLayout)View.inflate(getContext(), R.layout.b, null));
      this.c = BottomSheetBehavior.b((FrameLayout)this.d.findViewById(R.id.e));
      this.c.b(this.g);
      this.c.b(this.b);
    }
    return this.d;
  }
  
  @NonNull
  public BottomSheetBehavior<FrameLayout> a()
  {
    if (this.c == null) {
      e();
    }
    return this.c;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  boolean c()
  {
    if (!this.f)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(new int[] { 16843611 });
      this.e = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
      this.f = true;
    }
    return this.e;
  }
  
  public void cancel()
  {
    BottomSheetBehavior localBottomSheetBehavior = a();
    if ((this.a) && (localBottomSheetBehavior.d() != 5))
    {
      localBottomSheetBehavior.d(5);
      return;
    }
    super.cancel();
  }
  
  void d()
  {
    this.c.c(this.g);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle.clearFlags(67108864);
        paramBundle.addFlags(-2147483648);
      }
      paramBundle.setLayout(-1, -1);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    BottomSheetBehavior localBottomSheetBehavior = this.c;
    if ((localBottomSheetBehavior != null) && (localBottomSheetBehavior.d() == 5)) {
      this.c.d(4);
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      BottomSheetBehavior localBottomSheetBehavior = this.c;
      if (localBottomSheetBehavior != null) {
        localBottomSheetBehavior.b(paramBoolean);
      }
    }
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.b)) {
      this.b = true;
    }
    this.e = paramBoolean;
    this.f = true;
  }
  
  public void setContentView(@LayoutRes int paramInt)
  {
    super.setContentView(a(paramInt, null, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(a(0, paramView, null));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(a(0, paramView, paramLayoutParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetDialog
 * JD-Core Version:    0.7.0.1
 */