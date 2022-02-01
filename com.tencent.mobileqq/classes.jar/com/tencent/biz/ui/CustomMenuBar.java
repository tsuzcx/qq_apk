package com.tencent.biz.ui;

import aakh;
import aaki;
import aakj;
import aakk;
import aakl;
import aako;
import aakp;
import aakr;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.List;
import nwn;

public class CustomMenuBar
  extends LinearLayout
{
  protected int a;
  public aakl a;
  public aakr a;
  public Handler a;
  public View a;
  protected ImageView a;
  protected LinearLayout a;
  public Runnable a;
  protected List<aako> a;
  public boolean a;
  private int b;
  public boolean b;
  
  public CustomMenuBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @SuppressLint({"NewApi"})
  public CustomMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new CustomMenuBar.5(this);
    super.setFocusable(true);
    super.setOrientation(0);
    super.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849854);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getText(2131696162));
    if (a()) {
      setBackgroundColor(paramContext.getResources().getColor(2131167176));
    }
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramAttributeSet.leftMargin = 0;
    paramAttributeSet.rightMargin = DisplayUtil.dip2px(paramContext, 7.0F);
    paramAttributeSet.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAttributeSet);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramContext = (HorizontalScrollView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559183, null);
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext.setOverScrollMode(2);
    }
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    super.addView(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131366835));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
  }
  
  public static boolean a()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    return (str != null) && (str.equals("1000"));
  }
  
  View a(aako paramaako, String paramString)
  {
    String str = paramaako.b();
    Object localObject = paramaako.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2131559184, null);
    ImageView localImageView2;
    TextView localTextView;
    ImageView localImageView1;
    if (a())
    {
      localView.setBackgroundResource(2130841802);
      localImageView2 = (ImageView)localView.findViewById(2131370901);
      localTextView = (TextView)localView.findViewById(2131370913);
      localImageView1 = (ImageView)localView.findViewById(2131378240);
      if (localObject == null) {
        break label216;
      }
      localImageView2.setImageDrawable((Drawable)localObject);
      label93:
      if (str == null) {
        break label236;
      }
      if (nwn.a(str) <= 10) {
        break label226;
      }
      localTextView.setText(nwn.a(str, 10, "..."));
    }
    int j;
    int i;
    for (;;)
    {
      localObject = paramaako.c();
      j = paramaako.a();
      if (!paramaako.a()) {
        break label342;
      }
      localImageView1.setVisibility(0);
      localImageView1.setImageResource(2130843311);
      localObject = new aakp(super.getContext());
      i = 0;
      while (i < paramaako.b())
      {
        ((aakp)localObject).a(paramaako.a(i));
        i += 1;
      }
      localView.setBackgroundResource(2130839715);
      localView.findViewById(2131370920).setVisibility(8);
      break;
      label216:
      localImageView2.setVisibility(8);
      break label93;
      label226:
      localTextView.setText(str);
      continue;
      label236:
      localTextView.setVisibility(8);
    }
    ((aakp)localObject).a(new aakh(this, localImageView1, localTextView));
    ((aakp)localObject).a(this.jdField_a_of_type_Aakl);
    localView.setOnTouchListener(new aaki(this, localImageView1));
    localView.setOnClickListener(new aakj(this, localImageView1, localTextView, (aakp)localObject, paramString, j, str));
    for (;;)
    {
      i = this.b;
      this.b = (i + 1);
      if (i == 0) {
        localView.findViewById(2131370920).setVisibility(8);
      }
      return localView;
      label342:
      localView.setOnClickListener(new aakk(this, (String)localObject, j));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.performClick();
  }
  
  public void a(aako paramaako, String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localLayoutParams.gravity = 17;
    paramString = a(paramaako, paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramaako);
    paramString.setFocusable(true);
    paramString.setClickable(true);
    paramString.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramString);
  }
  
  public void b()
  {
    this.b = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aakr == null) {
      return;
    }
    this.jdField_a_of_type_Aakr.b();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Aakr != null) {
      this.jdField_a_of_type_Aakr.b();
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
  
  public void setOnMenuItemClickListener(aakl paramaakl)
  {
    this.jdField_a_of_type_Aakl = paramaakl;
  }
  
  public void setSwitchIconDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar
 * JD-Core Version:    0.7.0.1
 */