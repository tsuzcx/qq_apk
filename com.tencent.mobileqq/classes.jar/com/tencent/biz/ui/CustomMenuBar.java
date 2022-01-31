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
import azvv;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;
import mpv;
import wou;
import wov;
import wow;
import wox;
import woy;
import wpb;
import wpc;
import wpe;

public class CustomMenuBar
  extends LinearLayout
{
  protected int a;
  public Handler a;
  public View a;
  protected ImageView a;
  protected LinearLayout a;
  public Runnable a;
  protected List<wpb> a;
  public woy a;
  public wpe a;
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848529);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getText(2131631015));
    if (a()) {
      setBackgroundColor(paramContext.getResources().getColor(2131101397));
    }
    paramAttributeSet = new LinearLayout.LayoutParams(-2, -2);
    paramAttributeSet.leftMargin = 0;
    paramAttributeSet.rightMargin = azvv.a(paramContext, 7.0F);
    paramAttributeSet.gravity = 16;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramAttributeSet);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramContext = (HorizontalScrollView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131493475, null);
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext.setOverScrollMode(2);
    }
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    super.addView(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131300684));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
  }
  
  public static boolean a()
  {
    String str = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    return (str != null) && (str.equals("1000"));
  }
  
  View a(wpb paramwpb, String paramString)
  {
    String str = paramwpb.a();
    Object localObject = paramwpb.a();
    View localView = ((LayoutInflater)super.getContext().getSystemService("layout_inflater")).inflate(2131493476, null);
    ImageView localImageView2;
    TextView localTextView;
    ImageView localImageView1;
    if (a())
    {
      localView.setBackgroundResource(2130841233);
      localImageView2 = (ImageView)localView.findViewById(2131304240);
      localTextView = (TextView)localView.findViewById(2131304253);
      localImageView1 = (ImageView)localView.findViewById(2131310843);
      if (localObject == null) {
        break label216;
      }
      localImageView2.setImageDrawable((Drawable)localObject);
      label93:
      if (str == null) {
        break label236;
      }
      if (mpv.a(str) <= 10) {
        break label226;
      }
      localTextView.setText(mpv.a(str, 10, "..."));
    }
    int j;
    int i;
    for (;;)
    {
      localObject = paramwpb.b();
      j = paramwpb.a();
      if (!paramwpb.a()) {
        break label342;
      }
      localImageView1.setVisibility(0);
      localImageView1.setImageResource(2130842572);
      localObject = new wpc(super.getContext());
      i = 0;
      while (i < paramwpb.b())
      {
        ((wpc)localObject).a(paramwpb.a(i));
        i += 1;
      }
      localView.setBackgroundResource(2130839361);
      localView.findViewById(2131304260).setVisibility(8);
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
    ((wpc)localObject).a(new wou(this, localImageView1, localTextView));
    ((wpc)localObject).a(this.jdField_a_of_type_Woy);
    localView.setOnTouchListener(new wov(this, localImageView1));
    localView.setOnClickListener(new wow(this, localImageView1, localTextView, (wpc)localObject, paramString, j, str));
    for (;;)
    {
      i = this.b;
      this.b = (i + 1);
      if (i == 0) {
        localView.findViewById(2131304260).setVisibility(8);
      }
      return localView;
      label342:
      localView.setOnClickListener(new wox(this, (String)localObject, j));
    }
  }
  
  public void a()
  {
    this.b = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(wpb paramwpb, String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    localLayoutParams.gravity = 17;
    paramString = a(paramwpb, paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramwpb);
    paramString.setFocusable(true);
    paramString.setClickable(true);
    paramString.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wpe == null) {
      return;
    }
    this.jdField_a_of_type_Wpe.b();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Wpe != null) {
      this.jdField_a_of_type_Wpe.b();
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
  
  public void setOnMenuItemClickListener(woy paramwoy)
  {
    this.jdField_a_of_type_Woy = paramwoy;
  }
  
  public void setSwitchIconDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar
 * JD-Core Version:    0.7.0.1
 */