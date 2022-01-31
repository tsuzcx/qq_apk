package com.tencent.mobileqq.activity;

import acmd;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class ChatTextSizeSettingActivity
  extends IphoneTitleBarActivity
{
  private static int jdField_b_of_type_Int;
  public int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new acmd(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ArrayList<ViewGroup> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ViewGroup c;
  private ViewGroup d;
  
  public ChatTextSizeSettingActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static int a()
  {
    return b() + 2;
  }
  
  public static int a(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    paramContext.getResources().getDimensionPixelSize(2131296367);
    switch (i)
    {
    default: 
      return paramContext.getResources().getDimensionPixelSize(2131296367);
    case 1: 
      return paramContext.getResources().getDimensionPixelSize(2131296366);
    case 2: 
      return paramContext.getResources().getDimensionPixelSize(2131296365);
    }
    return paramContext.getResources().getDimensionPixelSize(2131296364);
  }
  
  public static int b()
  {
    if (jdField_b_of_type_Int != 0) {
      return jdField_b_of_type_Int;
    }
    float f;
    switch (BaseApplicationImpl.getContext().getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296367);
    }
    for (;;)
    {
      jdField_b_of_type_Int = (int)(f / BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
      return jdField_b_of_type_Int;
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296366);
      continue;
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296365);
      continue;
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296364);
    }
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (ImageView)((ViewGroup)this.jdField_a_of_type_JavaUtilArrayList.get(i)).findViewById(2131377692);
      if (i == paramInt) {
        ((ImageView)localObject).setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)localObject).setVisibility(4);
      }
    }
    Object localObject = getSharedPreferences("setting_text_size", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("chat_text_size_type", paramInt);
    ((SharedPreferences.Editor)localObject).commit();
    jdField_b_of_type_Int = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131558803);
    setTitle(getString(2131695409));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377695));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377694));
    this.c = ((ViewGroup)findViewById(2131377693));
    this.d = ((ViewGroup)findViewById(2131377691));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296367)));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296366)));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296365)));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296364)));
    this.jdField_a_of_type_Int = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatTextSizeSettingActivity
 * JD-Core Version:    0.7.0.1
 */