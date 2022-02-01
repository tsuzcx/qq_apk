package com.tencent.biz.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.SubString;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class CustomMenuBar
  extends LinearLayout
{
  protected ImageView a;
  protected LinearLayout b;
  protected List<MenuItem> c = new ArrayList();
  protected CustomMenuBar.OnMenuItemClickListener d;
  protected PopupWindows e = null;
  protected boolean f = false;
  protected boolean g = false;
  protected View h;
  protected int i = 0;
  Handler j = new Handler();
  Runnable k = new CustomMenuBar.5(this);
  private int l;
  
  public CustomMenuBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public CustomMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setFocusable(true);
    super.setOrientation(0);
    super.setGravity(16);
    this.a = new ImageView(paramContext);
    this.a.setImageResource(2130851970);
    this.a.setClickable(true);
    this.a.setContentDescription(paramContext.getText(2131894204));
    if (a()) {
      setBackgroundColor(paramContext.getResources().getColor(2131168198));
    }
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramAttributeSet.leftMargin = 0;
    paramAttributeSet.rightMargin = DisplayUtil.a(paramContext, 7.0F);
    paramAttributeSet.gravity = 16;
    this.a.setLayoutParams(paramAttributeSet);
    super.addView(this.a);
    paramContext = (HorizontalScrollView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131624756, null);
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext.setOverScrollMode(2);
    }
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    super.addView(paramContext);
    this.b = ((LinearLayout)paramContext.findViewById(2131433200));
    this.b.setGravity(16);
  }
  
  public static boolean a()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    return (str != null) && (str.equals("1000"));
  }
  
  public void a(MenuItem paramMenuItem, String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localLayoutParams.gravity = 17;
    paramString = b(paramMenuItem, paramString);
    this.c.add(paramMenuItem);
    paramString.setFocusable(true);
    paramString.setClickable(true);
    paramString.setLayoutParams(localLayoutParams);
    this.b.addView(paramString);
  }
  
  View b(MenuItem paramMenuItem, String paramString)
  {
    String str = paramMenuItem.d();
    Object localObject = paramMenuItem.c();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2131624757, null);
    if (a())
    {
      localView.setBackgroundResource(2130842754);
    }
    else
    {
      localView.setBackgroundResource(2130840137);
      localView.findViewById(2131438146).setVisibility(8);
    }
    ImageView localImageView2 = (ImageView)localView.findViewById(2131438117);
    TextView localTextView = (TextView)localView.findViewById(2131438139);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131446559);
    if (localObject != null) {
      localImageView2.setImageDrawable((Drawable)localObject);
    } else {
      localImageView2.setVisibility(8);
    }
    if (str != null)
    {
      if (SubString.a(str) > 10) {
        localTextView.setText(SubString.a(str, 10, "..."));
      } else {
        localTextView.setText(str);
      }
    }
    else {
      localTextView.setVisibility(8);
    }
    localObject = paramMenuItem.e();
    int n = paramMenuItem.a();
    if (paramMenuItem.f())
    {
      m = 0;
      localImageView1.setVisibility(0);
      localImageView1.setImageResource(2130844348);
      localObject = new PopupMenu(super.getContext());
      while (m < paramMenuItem.g())
      {
        ((PopupMenu)localObject).a(paramMenuItem.a(m));
        m += 1;
      }
      ((PopupMenu)localObject).a(new CustomMenuBar.1(this, localImageView1, localTextView));
      ((PopupMenu)localObject).a(this.d);
      localView.setOnTouchListener(new CustomMenuBar.2(this, localImageView1));
      localView.setOnClickListener(new CustomMenuBar.3(this, localImageView1, localTextView, (PopupMenu)localObject, paramString, n, str));
    }
    else
    {
      localView.setOnClickListener(new CustomMenuBar.4(this, (String)localObject, n));
    }
    int m = this.l;
    this.l = (m + 1);
    if (m == 0) {
      localView.findViewById(2131438146).setVisibility(8);
    }
    return localView;
  }
  
  public void b()
  {
    this.a.performClick();
  }
  
  public void c()
  {
    this.l = 0;
    this.b.removeAllViews();
    this.c.clear();
  }
  
  public void d()
  {
    PopupWindows localPopupWindows = this.e;
    if (localPopupWindows == null) {
      return;
    }
    localPopupWindows.b();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    paramConfiguration = this.e;
    if (paramConfiguration != null) {
      paramConfiguration.b();
    }
  }
  
  public void setCoverView(View paramView)
  {
    this.h = paramView;
  }
  
  public void setMenuType(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setOnBackClickListner(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.d = paramOnMenuItemClickListener;
  }
  
  public void setSwitchIconDrawable(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar
 * JD-Core Version:    0.7.0.1
 */