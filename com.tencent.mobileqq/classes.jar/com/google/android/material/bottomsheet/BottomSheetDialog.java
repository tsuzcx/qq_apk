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
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  @NonNull
  private BottomSheetBehavior.BottomSheetCallback jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$BottomSheetCallback = new BottomSheetDialog.4(this);
  private BottomSheetBehavior<FrameLayout> jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior;
  boolean jdField_a_of_type_Boolean;
  boolean b = true;
  private boolean c = true;
  private boolean d;
  
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
      if (paramContext.getTheme().resolveAttribute(R.attr.e, localTypedValue, true)) {
        return localTypedValue.resourceId;
      }
      i = R.style.g;
    }
    return i;
  }
  
  private View a(int paramInt, @Nullable View paramView, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    a();
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(R.id.d);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(R.id.e);
    paramView.removeAllViews();
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    } else {
      paramView.addView(localView, paramLayoutParams);
    }
    localCoordinatorLayout.findViewById(R.id.al).setOnClickListener(new BottomSheetDialog.1(this));
    ViewCompat.setAccessibilityDelegate(paramView, new BottomSheetDialog.2(this));
    paramView.setOnTouchListener(new BottomSheetDialog.3(this));
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  private FrameLayout a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)View.inflate(getContext(), R.layout.b, null));
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior = BottomSheetBehavior.a((FrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(R.id.e));
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$BottomSheetCallback);
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior.b(this.b);
    }
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  @NonNull
  public BottomSheetBehavior<FrameLayout> a()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior == null) {
      a();
    }
    return this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior.b(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior$BottomSheetCallback);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  boolean b()
  {
    if (!this.d)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(new int[] { 16843611 });
      this.c = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
      this.d = true;
    }
    return this.c;
  }
  
  public void cancel()
  {
    BottomSheetBehavior localBottomSheetBehavior = a();
    if ((this.jdField_a_of_type_Boolean) && (localBottomSheetBehavior.b() != 5))
    {
      localBottomSheetBehavior.d(5);
      return;
    }
    super.cancel();
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
    BottomSheetBehavior localBottomSheetBehavior = this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior;
    if ((localBottomSheetBehavior != null) && (localBottomSheetBehavior.b() == 5)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior.d(4);
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      BottomSheetBehavior localBottomSheetBehavior = this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior;
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
    this.c = paramBoolean;
    this.d = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetDialog
 * JD-Core Version:    0.7.0.1
 */