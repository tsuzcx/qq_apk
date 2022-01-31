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
import bdaq;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;
import ndp;
import yxc;
import yxd;
import yxe;
import yxf;
import yxg;
import yxj;
import yxk;
import yxm;

public class CustomMenuBar
  extends LinearLayout
{
  protected int a;
  public Handler a;
  public View a;
  protected ImageView a;
  protected LinearLayout a;
  public Runnable a;
  protected List<yxj> a;
  public yxg a;
  public yxm a;
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849282);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getText(2131696905));
    if (a()) {
      setBackgroundColor(paramContext.getResources().getColor(2131167045));
    }
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramAttributeSet.leftMargin = 0;
    paramAttributeSet.rightMargin = bdaq.a(paramContext, 7.0F);
    paramAttributeSet.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAttributeSet);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramContext = (HorizontalScrollView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559078, null);
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext.setOverScrollMode(2);
    }
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    super.addView(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131366387));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
  }
  
  public static boolean a()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    return (str != null) && (str.equals("1000"));
  }
  
  View a(yxj paramyxj, String paramString)
  {
    String str = paramyxj.a();
    Object localObject = paramyxj.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2131559079, null);
    ImageView localImageView2;
    TextView localTextView;
    ImageView localImageView1;
    if (a())
    {
      localView.setBackgroundResource(2130841431);
      localImageView2 = (ImageView)localView.findViewById(2131370203);
      localTextView = (TextView)localView.findViewById(2131370216);
      localImageView1 = (ImageView)localView.findViewById(2131377216);
      if (localObject == null) {
        break label216;
      }
      localImageView2.setImageDrawable((Drawable)localObject);
      label93:
      if (str == null) {
        break label236;
      }
      if (ndp.a(str) <= 10) {
        break label226;
      }
      localTextView.setText(ndp.a(str, 10, "..."));
    }
    int j;
    int i;
    for (;;)
    {
      localObject = paramyxj.b();
      j = paramyxj.a();
      if (!paramyxj.a()) {
        break label342;
      }
      localImageView1.setVisibility(0);
      localImageView1.setImageResource(2130842853);
      localObject = new yxk(super.getContext());
      i = 0;
      while (i < paramyxj.b())
      {
        ((yxk)localObject).a(paramyxj.a(i));
        i += 1;
      }
      localView.setBackgroundResource(2130839474);
      localView.findViewById(2131370223).setVisibility(8);
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
    ((yxk)localObject).a(new yxc(this, localImageView1, localTextView));
    ((yxk)localObject).a(this.jdField_a_of_type_Yxg);
    localView.setOnTouchListener(new yxd(this, localImageView1));
    localView.setOnClickListener(new yxe(this, localImageView1, localTextView, (yxk)localObject, paramString, j, str));
    for (;;)
    {
      i = this.b;
      this.b = (i + 1);
      if (i == 0) {
        localView.findViewById(2131370223).setVisibility(8);
      }
      return localView;
      label342:
      localView.setOnClickListener(new yxf(this, (String)localObject, j));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.performClick();
  }
  
  public void a(yxj paramyxj, String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localLayoutParams.gravity = 17;
    paramString = a(paramyxj, paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramyxj);
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
    if (this.jdField_a_of_type_Yxm == null) {
      return;
    }
    this.jdField_a_of_type_Yxm.b();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Yxm != null) {
      this.jdField_a_of_type_Yxm.b();
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
  
  public void setOnMenuItemClickListener(yxg paramyxg)
  {
    this.jdField_a_of_type_Yxg = paramyxg;
  }
  
  public void setSwitchIconDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar
 * JD-Core Version:    0.7.0.1
 */