package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.SubString;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.List;

public class PopupMenu
  extends PopupWindows
{
  protected CustomMenuBar.OnMenuItemClickListener a;
  private ImageView g;
  private LayoutInflater h;
  private ViewGroup i;
  private List<MenuItem> j = new ArrayList();
  private int k;
  private int l;
  
  public PopupMenu(Context paramContext)
  {
    super(paramContext);
    this.h = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    a(2131624759);
    this.l = 4;
    this.k = 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = this.g.getMeasuredWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
    if (paramInt3 > paramInt1)
    {
      if (paramInt3 > paramInt2 * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 - m / 2);
        return;
      }
      if (paramInt3 > (paramInt4 - paramInt2) * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 + paramInt3 - paramInt4 - m / 2);
        return;
      }
      localLayoutParams.addRule(14);
      return;
    }
    localLayoutParams.addRule(14);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.l != 4) {
      return;
    }
    this.c.setAnimationStyle(2131951662);
  }
  
  public void a(int paramInt)
  {
    this.d = ((ViewGroup)this.h.inflate(paramInt, null));
    this.i = ((ViewGroup)this.d.findViewById(2131438110));
    this.g = ((ImageView)this.d.findViewById(2131428782));
    this.d.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    super.b(this.d);
  }
  
  public void a(View paramView)
  {
    a();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    this.d.measure(-2, -2);
    int m = this.d.getMeasuredWidth();
    int n = this.d.getMeasuredHeight();
    int i1 = this.f.getDefaultDisplay().getWidth();
    int i2 = arrayOfInt[0];
    int i3 = (paramView.getWidth() - m) / 2;
    int i4 = localRect.top;
    a(paramView.getWidth(), localRect.centerX(), m, i1);
    a(i1, localRect.centerX(), true);
    this.c.showAtLocation(paramView, 0, i2 + i3, i4 - n - 10);
  }
  
  public void a(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.a = paramOnMenuItemClickListener;
  }
  
  public void a(MenuItem paramMenuItem)
  {
    this.j.add(paramMenuItem);
    String str = paramMenuItem.d();
    Drawable localDrawable = paramMenuItem.c();
    if (this.k != 0)
    {
      localObject1 = new ImageView(this.b);
      ((ImageView)localObject1).setBackgroundResource(2130840136);
      localObject2 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      ((LinearLayout.LayoutParams)localObject2).setMargins(AIOUtils.b(15.0F, ((ImageView)localObject1).getResources()), 0, AIOUtils.b(15.0F, ((ImageView)localObject1).getResources()), 0);
      this.i.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    Object localObject1 = this.h.inflate(2131624758, null);
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131438117);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131438139);
    if (localDrawable != null) {
      ((ImageView)localObject2).setImageDrawable(localDrawable);
    } else {
      ((ImageView)localObject2).setVisibility(8);
    }
    if (str != null)
    {
      if (SubString.a(str) > 18) {
        localTextView.setText(SubString.a(str, 18, "..."));
      } else {
        localTextView.setText(str);
      }
    }
    else {
      localTextView.setVisibility(8);
    }
    ((View)localObject1).setOnClickListener(new PopupMenu.1(this, paramMenuItem.e(), paramMenuItem.a()));
    ((View)localObject1).setFocusable(true);
    ((View)localObject1).setClickable(true);
    paramMenuItem = new LinearLayout.LayoutParams(-1, -2, 1.0F);
    paramMenuItem.gravity = 17;
    ((View)localObject1).setLayoutParams(paramMenuItem);
    this.i.addView((View)localObject1);
    this.k += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.PopupMenu
 * JD-Core Version:    0.7.0.1
 */