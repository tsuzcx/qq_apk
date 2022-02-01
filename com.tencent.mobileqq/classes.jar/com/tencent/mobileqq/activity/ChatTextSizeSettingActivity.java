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
  private static int b;
  int a = 0;
  private ViewGroup c;
  private ViewGroup d;
  private ViewGroup e;
  private ViewGroup f;
  private ArrayList<ViewGroup> g = new ArrayList();
  private ArrayList<Integer> h = new ArrayList();
  private View.OnClickListener i = new ChatTextSizeSettingActivity.1(this);
  
  public static int a()
  {
    return b() + 2;
  }
  
  public static int a(Context paramContext)
  {
    int j = paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    paramContext.getResources().getDimensionPixelSize(2131296687);
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          return paramContext.getResources().getDimensionPixelSize(2131296687);
        }
        return paramContext.getResources().getDimensionPixelSize(2131296684);
      }
      return paramContext.getResources().getDimensionPixelSize(2131296685);
    }
    return paramContext.getResources().getDimensionPixelSize(2131296686);
  }
  
  public static int b()
  {
    int j = b;
    if (j != 0) {
      return j;
    }
    j = BaseApplicationImpl.getContext().getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    float f1;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          f1 = BaseApplicationImpl.getContext().getResources().getDimension(2131296687);
        } else {
          f1 = BaseApplicationImpl.getContext().getResources().getDimension(2131296684);
        }
      }
      else {
        f1 = BaseApplicationImpl.getContext().getResources().getDimension(2131296685);
      }
    }
    else {
      f1 = BaseApplicationImpl.getContext().getResources().getDimension(2131296686);
    }
    b = (int)(f1 / BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    return b;
  }
  
  void a(int paramInt)
  {
    int j = 0;
    while (j < this.g.size())
    {
      localObject = (ImageView)((ViewGroup)this.g.get(j)).findViewById(2131447225);
      if (j == paramInt) {
        ((ImageView)localObject).setVisibility(0);
      } else {
        ((ImageView)localObject).setVisibility(4);
      }
      j += 1;
    }
    Object localObject = getSharedPreferences("setting_text_size", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("chat_text_size_type", paramInt);
    ((SharedPreferences.Editor)localObject).commit();
    b = 0;
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131624467);
    setTitle(getString(2131892682));
    this.c = ((ViewGroup)findViewById(2131447228));
    this.d = ((ViewGroup)findViewById(2131447227));
    this.e = ((ViewGroup)findViewById(2131447226));
    this.f = ((ViewGroup)findViewById(2131447224));
    this.g.add(this.c);
    this.g.add(this.d);
    this.g.add(this.e);
    this.g.add(this.f);
    this.c.setOnClickListener(this.i);
    this.d.setOnClickListener(this.i);
    this.e.setOnClickListener(this.i);
    this.f.setOnClickListener(this.i);
    this.h.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296687)));
    this.h.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296686)));
    this.h.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296685)));
    this.h.add(Integer.valueOf(getResources().getDimensionPixelSize(2131296684)));
    this.a = getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatTextSizeSettingActivity
 * JD-Core Version:    0.7.0.1
 */