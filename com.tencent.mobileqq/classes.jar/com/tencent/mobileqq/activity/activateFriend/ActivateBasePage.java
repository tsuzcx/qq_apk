package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class ActivateBasePage
  extends RelativeLayout
{
  public static float j = 2.364865F;
  LayoutInflater a;
  View b = null;
  TextView c;
  TextView d;
  TextView e;
  Button f;
  TextView g;
  TextView h;
  ActivateFriendGrid i;
  
  public ActivateBasePage(Context paramContext)
  {
    super(paramContext);
    this.a = LayoutInflater.from(paramContext);
    a();
    paramContext = this.i;
    if (paramContext != null) {
      paramContext.setTextScrolling(false);
    }
  }
  
  public ActivateBasePage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = LayoutInflater.from(paramContext);
  }
  
  public abstract void a();
  
  protected void a(View paramView)
  {
    int k = (int)((int)(getResources().getDisplayMetrics().widthPixels - getResources().getDisplayMetrics().density * 16.0F) / j);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = k;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void b()
  {
    ActivateFriendGrid localActivateFriendGrid = this.i;
    if (localActivateFriendGrid != null) {
      localActivateFriendGrid.b();
    }
  }
  
  public void c() {}
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
 * JD-Core Version:    0.7.0.1
 */