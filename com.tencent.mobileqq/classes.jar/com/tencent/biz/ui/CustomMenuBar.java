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
  protected int a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  protected View a;
  protected ImageView a;
  protected LinearLayout a;
  protected CustomMenuBar.OnMenuItemClickListener a;
  protected PopupWindows a;
  Runnable jdField_a_of_type_JavaLangRunnable = new CustomMenuBar.5(this);
  protected List<MenuItem> a;
  protected boolean a;
  private int b;
  protected boolean b;
  
  public CustomMenuBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public CustomMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizUiPopupWindows = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    super.setFocusable(true);
    super.setOrientation(0);
    super.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850179);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getText(2131696432));
    if (a()) {
      setBackgroundColor(paramContext.getResources().getColor(2131167208));
    }
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramAttributeSet.leftMargin = 0;
    paramAttributeSet.rightMargin = DisplayUtil.a(paramContext, 7.0F);
    paramAttributeSet.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAttributeSet);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramContext = (HorizontalScrollView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559095, null);
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext.setOverScrollMode(2);
    }
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    super.addView(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131366871));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
  }
  
  public static boolean a()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    return (str != null) && (str.equals("1000"));
  }
  
  View a(MenuItem paramMenuItem, String paramString)
  {
    String str = paramMenuItem.b();
    Object localObject = paramMenuItem.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2131559096, null);
    if (a())
    {
      localView.setBackgroundResource(2130841837);
    }
    else
    {
      localView.setBackgroundResource(2130839665);
      localView.findViewById(2131370823).setVisibility(8);
    }
    ImageView localImageView2 = (ImageView)localView.findViewById(2131370804);
    TextView localTextView = (TextView)localView.findViewById(2131370816);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131378059);
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
    localObject = paramMenuItem.c();
    int j = paramMenuItem.a();
    if (paramMenuItem.a())
    {
      i = 0;
      localImageView1.setVisibility(0);
      localImageView1.setImageResource(2130843394);
      localObject = new PopupMenu(super.getContext());
      while (i < paramMenuItem.b())
      {
        ((PopupMenu)localObject).a(paramMenuItem.a(i));
        i += 1;
      }
      ((PopupMenu)localObject).a(new CustomMenuBar.1(this, localImageView1, localTextView));
      ((PopupMenu)localObject).a(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener);
      localView.setOnTouchListener(new CustomMenuBar.2(this, localImageView1));
      localView.setOnClickListener(new CustomMenuBar.3(this, localImageView1, localTextView, (PopupMenu)localObject, paramString, j, str));
    }
    else
    {
      localView.setOnClickListener(new CustomMenuBar.4(this, (String)localObject, j));
    }
    int i = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = (i + 1);
    if (i == 0) {
      localView.findViewById(2131370823).setVisibility(8);
    }
    return localView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.performClick();
  }
  
  public void a(MenuItem paramMenuItem, String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localLayoutParams.gravity = 17;
    paramString = a(paramMenuItem, paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramMenuItem);
    paramString.setFocusable(true);
    paramString.setClickable(true);
    paramString.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramString);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void c()
  {
    PopupWindows localPopupWindows = this.jdField_a_of_type_ComTencentBizUiPopupWindows;
    if (localPopupWindows == null) {
      return;
    }
    localPopupWindows.b();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    paramConfiguration = this.jdField_a_of_type_ComTencentBizUiPopupWindows;
    if (paramConfiguration != null) {
      paramConfiguration.b();
    }
  }
  
  public void setCoverView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setMenuType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOnBackClickListner(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setSwitchIconDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar
 * JD-Core Version:    0.7.0.1
 */