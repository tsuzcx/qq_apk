package com.tencent.mm.ui.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import com.tencent.mm.ui.h;

public class CustomSheetDialog
  extends AppCompatDialog
{
  private Context a;
  private FrameLayout b;
  
  public CustomSheetDialog(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public CustomSheetDialog(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, a(paramInt));
    this.a = paramContext;
    supportRequestWindowFeature(1);
  }
  
  protected CustomSheetDialog(@NonNull Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    supportRequestWindowFeature(1);
  }
  
  private static int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 2131951988;
    }
    return i;
  }
  
  private View a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject1 = getWindow();
    if (b())
    {
      ((Window)localObject1).setGravity(5);
      ((Window)localObject1).setWindowAnimations(2131952307);
    }
    else
    {
      ((Window)localObject1).setGravity(80);
      ((Window)localObject1).setWindowAnimations(2131951930);
    }
    ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
    Object localObject2 = ((Window)localObject1).getAttributes();
    if (b())
    {
      ((WindowManager.LayoutParams)localObject2).width = -2;
      ((WindowManager.LayoutParams)localObject2).height = -1;
    }
    else
    {
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -2;
    }
    ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    localObject2 = (ViewGroup)LayoutInflater.from(this.a).inflate(2131625293, null);
    View localView = ((ViewGroup)localObject2).findViewById(2131447799);
    localObject1 = paramView;
    if (paramInt != 0)
    {
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = getLayoutInflater().inflate(paramInt, (ViewGroup)localObject2, false);
      }
    }
    if (b()) {
      this.b = ((FrameLayout)((ViewGroup)localObject2).findViewById(2131438135));
    } else {
      this.b = ((FrameLayout)((ViewGroup)localObject2).findViewById(2131438133));
    }
    d();
    this.b.setVisibility(0);
    if (paramLayoutParams == null) {
      this.b.addView((View)localObject1);
    } else {
      this.b.addView((View)localObject1, paramLayoutParams);
    }
    if (a()) {
      localView.setOnClickListener(new CustomSheetDialog.1(this));
    }
    return localObject2;
  }
  
  private boolean a()
  {
    if (Build.VERSION.SDK_INT < 11) {
      return true;
    }
    TypedValue localTypedValue = new TypedValue();
    if (getContext().getTheme().resolveAttribute(16843611, localTypedValue, true)) {
      return localTypedValue.data != 0;
    }
    return false;
  }
  
  private boolean b()
  {
    return this.a.getResources().getConfiguration().orientation == 2;
  }
  
  @SuppressLint({"WrongConstant"})
  private int c()
  {
    return getWindow().getWindowManager().getDefaultDisplay().getRotation();
  }
  
  private void d()
  {
    int i;
    if ((h.d(this.a)) && (Build.VERSION.SDK_INT < 30)) {
      i = h.g(this.a);
    } else {
      i = 0;
    }
    Object localObject;
    if (b())
    {
      localObject = this.b;
      if (localObject != null)
      {
        localObject = (CoordinatorLayout.LayoutParams)((FrameLayout)localObject).getLayoutParams();
        if (c() == 1) {
          ((CoordinatorLayout.LayoutParams)localObject).setMargins(0, 0, i, 0);
        } else if (c() == 3) {
          ((CoordinatorLayout.LayoutParams)localObject).setMargins(i, 0, 0, 0);
        }
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      localObject = this.b;
      if (localObject != null)
      {
        localObject = (CoordinatorLayout.LayoutParams)((FrameLayout)localObject).getLayoutParams();
        ((CoordinatorLayout.LayoutParams)localObject).setMargins(0, 0, 0, i);
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    d();
  }
  
  public void setContentView(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.CustomSheetDialog
 * JD-Core Version:    0.7.0.1
 */