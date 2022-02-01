package com.tencent.av.wtogether.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

public class WatchTogetherPlayRatioHelper
  implements View.OnClickListener, View.OnTouchListener
{
  private static final int[] a = { 2131446238, 2131446240, 2131446239, 2131446237, 2131446236 };
  private static final float[] b = { 0.5F, 1.0F, 1.25F, 1.5F, 2.0F };
  private static final TextView[] c = new TextView[a.length];
  private int d = -1;
  private int e;
  private int f;
  private View g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private WatchTogetherMediaPlayerProxy m;
  private WatchTogetherPlayRatioHelper.OnSelectRatioClickListener n;
  
  public WatchTogetherPlayRatioHelper(View paramView)
  {
    this.g = paramView;
    c();
    d();
    e();
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = this.f;
    Drawable localDrawable = this.g.getResources().getDrawable(2130843332);
    float f1;
    if (paramBoolean)
    {
      f1 = 24.0F;
      localDrawable = this.g.getResources().getDrawable(2130843331);
      i1 = this.e;
    }
    else
    {
      f1 = 17.0F;
    }
    TextView[] arrayOfTextView = c;
    int i3 = arrayOfTextView.length;
    int i2 = 0;
    while (i2 < i3)
    {
      TextView localTextView = arrayOfTextView[i2];
      localTextView.getPaint().setFakeBoldText(paramBoolean);
      localTextView.setTextSize(f1);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable.getConstantState().newDrawable());
      localTextView.setCompoundDrawablePadding(i1);
      i2 += 1;
    }
    f();
  }
  
  private void b(int paramInt)
  {
    int i1 = 0;
    while (i1 < a.length)
    {
      TextView localTextView = c[i1];
      GradientDrawable localGradientDrawable = (GradientDrawable)localTextView.getCompoundDrawables()[3];
      if (i1 == paramInt)
      {
        localTextView.setTextColor(this.g.getResources().getColor(2131166801));
        localGradientDrawable.setColor(this.g.getResources().getColor(2131166800));
      }
      else
      {
        localTextView.setTextColor(-1);
        localGradientDrawable.setColor(0);
      }
      i1 += 1;
    }
  }
  
  private void c()
  {
    this.h = ((TextView)this.g.findViewById(2131446238));
    c[0] = this.h;
    this.i = ((TextView)this.g.findViewById(2131446240));
    c[1] = this.i;
    this.j = ((TextView)this.g.findViewById(2131446239));
    c[2] = this.j;
    this.k = ((TextView)this.g.findViewById(2131446237));
    c[3] = this.k;
    this.l = ((TextView)this.g.findViewById(2131446236));
    c[4] = this.l;
    a(false);
    b(this.d);
  }
  
  private void d()
  {
    this.e = this.g.getResources().getDimensionPixelSize(2131298711);
    this.f = this.g.getResources().getDimensionPixelSize(2131298712);
  }
  
  private void e()
  {
    int i1 = 0;
    while (i1 < a.length)
    {
      TextView localTextView = c[i1];
      localTextView.setOnClickListener(this);
      localTextView.setOnTouchListener(this);
      i1 += 1;
    }
  }
  
  private void f()
  {
    Object localObject = this.m;
    if ((localObject != null) && (((WatchTogetherMediaPlayerProxy)localObject).f()))
    {
      float f1 = this.m.g();
      int i1 = 0;
      for (;;)
      {
        localObject = b;
        if (i1 >= localObject.length) {
          break;
        }
        if (f1 == localObject[i1])
        {
          b(i1);
          return;
        }
        i1 += 1;
      }
    }
    b(-1);
  }
  
  public void a()
  {
    f();
    this.g.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.g.getLayoutParams();
    if (paramInt == 2)
    {
      paramInt = (int)(ImmersiveUtils.getScreenWidth() * 0.2998501F);
      a(true);
    }
    else
    {
      paramInt = AIOUtils.b(100.0F, this.g.getResources());
      a(false);
    }
    paramInt /= 2;
    localMarginLayoutParams.leftMargin = paramInt;
    localMarginLayoutParams.rightMargin = paramInt;
    if (this.g.isShown()) {
      this.g.requestLayout();
    }
  }
  
  public void a(WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy)
  {
    this.m = paramWatchTogetherMediaPlayerProxy;
  }
  
  public void a(WatchTogetherPlayRatioHelper.OnSelectRatioClickListener paramOnSelectRatioClickListener)
  {
    this.n = paramOnSelectRatioClickListener;
  }
  
  public void b()
  {
    this.g.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.d = 0;
      break;
    case 2131446240: 
      this.d = 1;
      paramView = this.m;
      if (paramView != null) {
        paramView.a(b[1]);
      }
      break;
    case 2131446239: 
      this.d = 2;
      paramView = this.m;
      if (paramView != null) {
        paramView.a(b[2]);
      }
      break;
    case 2131446238: 
      this.d = 0;
      paramView = this.m;
      if (paramView != null) {
        paramView.a(b[0]);
      }
      break;
    case 2131446237: 
      this.d = 3;
      paramView = this.m;
      if (paramView != null) {
        paramView.a(b[3]);
      }
      break;
    case 2131446236: 
      this.d = 4;
      paramView = this.m;
      if (paramView != null) {
        paramView.a(b[4]);
      }
      break;
    }
    b(this.d);
    paramView = this.n;
    if (paramView != null) {
      paramView.c();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherPlayRatioHelper
 * JD-Core Version:    0.7.0.1
 */