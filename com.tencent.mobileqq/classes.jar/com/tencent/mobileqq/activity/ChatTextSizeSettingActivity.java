package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ChatTextSizeSettingActivity
  extends IphoneTitleBarActivity
{
  private static int jdField_b_of_type_Int = 0;
  int jdField_a_of_type_Int = 0;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ChatTextSizeSettingActivity.1(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ArrayList<ViewGroup> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ViewGroup c;
  private ViewGroup d;
  
  public static int a()
  {
    return b() + 2;
  }
  
  public static int a(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    paramContext.getResources().getDimensionPixelSize(2131296474);
    switch (i)
    {
    default: 
      return paramContext.getResources().getDimensionPixelSize(2131296474);
    case 1: 
      return paramContext.getResources().getDimensionPixelSize(2131296473);
    case 2: 
      return paramContext.getResources().getDimensionPixelSize(2131296472);
    }
    return paramContext.getResources().getDimensionPixelSize(2131296471);
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
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296474);
    }
    for (;;)
    {
      jdField_b_of_type_Int = (int)(f / BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
      return jdField_b_of_type_Int;
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296473);
      continue;
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296472);
      continue;
      f = BaseApplicationImpl.getContext().getResources().getDimension(2131296471);
    }
  }
  
  void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (ImageView)((ViewGroup)this.jdField_a_of_type_JavaUtilArrayList.get(i)).findViewById(2131379234);
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131558949);
    setTitle(getString(2131694965));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131379237));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131379236));
    this.c = ((ViewGroup)findViewById(2131379235));
    this.d = ((ViewGroup)findViewById(2131379233));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.d);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296474)));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296473)));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296472)));
    this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296471)));
    this.jdField_a_of_type_Int = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatTextSizeSettingActivity
 * JD-Core Version:    0.7.0.1
 */