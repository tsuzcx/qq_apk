package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.h;

public class SnackBar
{
  public static final short LONG_SNACK = 2500;
  public static final short MED_SNACK = 3500;
  public static final short SHORT_SNACK = 1500;
  private SnackContainer a;
  private View b;
  private SnackBar.OnMessageClickListener c;
  private SnackBar.OnVisibilityChangeListener d;
  private Handler e = new Handler();
  private final View.OnClickListener f = new SnackBar.1(this);
  
  public SnackBar(Activity paramActivity, int paramInt)
  {
    Object localObject = paramActivity.findViewById(16908290);
    LayoutInflater localLayoutInflater = (LayoutInflater)paramActivity.getSystemService("layout_inflater");
    localObject = (ViewGroup)localObject;
    localLayoutInflater.inflate(2131629294, (ViewGroup)localObject);
    a((ViewGroup)localObject, localLayoutInflater.inflate(2131629295, (ViewGroup)localObject, false), paramInt, paramActivity);
  }
  
  public SnackBar(Context paramContext, View paramView, int paramInt)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = paramView;
      if ((paramContext instanceof Activity)) {
        localObject = ((Activity)paramContext).findViewById(16908290);
      }
    }
    paramView = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    localObject = (ViewGroup)localObject;
    paramView.inflate(2131629294, (ViewGroup)localObject);
    a((ViewGroup)localObject, paramView.inflate(2131629295, (ViewGroup)localObject, false), paramInt, paramContext);
  }
  
  private SnackBar a(SnackBar.OnMessageClickListener paramOnMessageClickListener)
  {
    this.c = paramOnMessageClickListener;
    return this;
  }
  
  private SnackBar a(SnackBar.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    this.d = paramOnVisibilityChangeListener;
    return this;
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, int paramInt, Context paramContext)
  {
    if (paramViewGroup == null) {
      return;
    }
    this.a = ((SnackContainer)paramViewGroup.findViewById(2131446125));
    if (this.a == null) {
      this.a = new SnackContainer(paramViewGroup);
    }
    this.b = paramView;
    if (paramInt == 36) {
      this.a.setOnTouchListener(new SnackBar.2(this));
    }
    ((TextView)paramView.findViewById(2131446124)).setOnClickListener(this.f);
    boolean bool1 = h.d(paramContext);
    paramInt = h.g(paramContext);
    f.c("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(paramInt) });
    boolean bool2 = a((Activity)paramContext);
    f.c("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", new Object[] { Boolean.valueOf(bool2) });
    if ((bool2) && (bool1))
    {
      paramViewGroup = (LinearLayout)paramView.findViewById(2131446123);
      paramView = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      paramView.bottomMargin = paramInt;
      paramViewGroup.setLayoutParams(paramView);
    }
  }
  
  private void a(Snack paramSnack)
  {
    SnackContainer localSnackContainer = this.a;
    if (localSnackContainer != null) {
      localSnackContainer.showSnack(paramSnack, this.b, this.d);
    }
  }
  
  private boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramActivity = paramActivity.getWindow().getAttributes();
      if (paramActivity.flags == (paramActivity.flags & 0xF7FFFFFF | 0x8000000)) {
        return true;
      }
    }
    return false;
  }
  
  public void clear()
  {
    clear(true);
  }
  
  public void clear(boolean paramBoolean)
  {
    this.a.clearSnacks(paramBoolean);
  }
  
  public View getContainerView()
  {
    return this.b;
  }
  
  public int getHeight()
  {
    View localView = this.b;
    localView.measure(View.MeasureSpec.makeMeasureSpec(localView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.b.getHeight(), -2147483648));
    return this.b.getMeasuredHeight();
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    this.a.restoreState(paramBundle, this.b);
  }
  
  public Bundle onSaveInstanceState()
  {
    return this.a.saveState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackBar
 * JD-Core Version:    0.7.0.1
 */