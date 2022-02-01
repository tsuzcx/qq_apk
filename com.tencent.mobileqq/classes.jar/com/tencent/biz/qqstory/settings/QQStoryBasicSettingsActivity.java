package com.tencent.biz.qqstory.settings;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQStoryBasicSettingsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a = 0;
  public int b = this.a;
  QQStoryManager c;
  QQStoryHandler d;
  ViewGroup e;
  View f;
  View[] g = new View[3];
  protected QQProgressNotifier h;
  QQStoryObserver i = new QQStoryBasicSettingsActivity.1(this);
  
  int a(int paramInt)
  {
    int j = 0;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return 0;
        }
        return 2;
      }
      j = 1;
    }
    return j;
  }
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131627906, null);
    ((TextView)localView.findViewById(2131447463)).setText(paramString);
    ((TextView)localView.findViewById(2131435692)).setText("");
    paramString = (ImageView)localView.findViewById(2131428774);
    paramString.setVisibility(4);
    paramString.setBackgroundResource(2130839459);
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  void a()
  {
    Object localObject1 = new LinearLayout(this);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject1).setBackgroundResource(2130838958);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setPadding(0, AIOUtils.b(20.0F, getResources()), 0, 0);
    this.e = ((ViewGroup)localObject1);
    localObject1 = new TextView(this);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(QQStoryConstant.a);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131908434));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    ((TextView)localObject1).setPadding(getResources().getDimensionPixelSize(2131299241), 0, getResources().getDimensionPixelSize(2131299241), getResources().getDimensionPixelSize(2131299236));
    ((TextView)localObject1).setTextSize(14.0F);
    ((TextView)localObject1).setTextColor(getResources().getColor(2131165882));
    this.e.addView((View)localObject1);
    localObject1 = a(0, "移动流量和WiFi");
    this.e.addView((View)localObject1);
    this.g[0] = localObject1;
    ((View)localObject1).setBackgroundResource(2130839638);
    this.f = ((View)localObject1);
    localObject1 = a(1, "仅WiFi");
    this.g[1] = localObject1;
    this.e.addView((View)localObject1);
    ((View)localObject1).setBackgroundResource(2130839632);
    this.f = ((View)localObject1);
    localObject1 = a(2, HardCodeUtil.a(2131908432));
    this.g[2] = localObject1;
    this.e.addView((View)localObject1);
    ((View)localObject1).setBackgroundResource(2130839629);
    this.f = ((View)localObject1);
    super.setContentView(this.e);
    this.h = new QQProgressNotifier(this, 2131627752);
  }
  
  int b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 1001;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public void c(int paramInt)
  {
    int j = 0;
    for (;;)
    {
      Object localObject1 = this.g;
      if (j >= localObject1.length) {
        break;
      }
      localObject1 = localObject1[j];
      Object localObject2 = (ImageView)((View)localObject1).findViewById(2131428774);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131447463);
      if (j != paramInt)
      {
        ((ImageView)localObject2).setVisibility(4);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localTextView.getText());
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131908430));
        ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      }
      else
      {
        ((ImageView)localObject2).setVisibility(0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localTextView.getText());
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131908435));
        ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      }
      j += 1;
    }
    this.a = paramInt;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.c = ((QQStoryManager)this.app.getManager(QQManagerFactory.QQSTORY_MANAGER));
    this.d = ((QQStoryHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER));
    a();
    int j = a(this.c.a());
    this.b = j;
    this.a = j;
    c(this.a);
    paramBundle = new StringBuilder();
    paramBundle.append(QQStoryConstant.a);
    paramBundle.append(HardCodeUtil.a(2131908439));
    super.setTitle(paramBundle.toString());
    this.app.addObserver(this.i);
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.makeText(this, 1, 2131889169, 0).show(getTitleBarHeight());
      super.startTitleProgress();
      return true;
    }
    this.d.a();
    super.startTitleProgress();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.removeObserver(this.i);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.makeText(this, 1, 2131889169, 0).show(getTitleBarHeight());
    }
    else
    {
      int j = ((Integer)paramView.getTag()).intValue();
      this.b = this.a;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j == 2) {
            this.d.d(3);
          }
        }
        else {
          this.d.d(2);
        }
      }
      else {
        this.d.d(1);
      }
      this.h.b(0, 2131915649, 0);
      c(j);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity
 * JD-Core Version:    0.7.0.1
 */