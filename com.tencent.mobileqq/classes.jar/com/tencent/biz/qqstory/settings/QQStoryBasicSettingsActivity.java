package com.tencent.biz.qqstory.settings;

import Override;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import biso;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import vzh;
import vzu;
import vzv;
import vzx;
import xqg;

public class QQStoryBasicSettingsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public biso a;
  public vzu a;
  public vzv a;
  vzx jdField_a_of_type_Vzx = new xqg(this);
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  public int b = this.jdField_a_of_type_Int;
  
  public QQStoryBasicSettingsActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 1001: 
    default: 
      return 0;
    case 3: 
      return 2;
    }
    return 1;
  }
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561585, null);
    ((TextView)localView.findViewById(2131379001)).setText(paramString);
    ((TextView)localView.findViewById(2131368819)).setText("");
    paramString = (ImageView)localView.findViewById(2131362985);
    paramString.setVisibility(4);
    paramString.setBackgroundResource(2130839346);
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  void a()
  {
    Object localObject = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject).setBackgroundResource(2130838911);
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setPadding(0, AIOUtils.dp2px(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setText(vzh.a + anvx.a(2131710261));
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131298444), 0, getResources().getDimensionPixelSize(2131298444), getResources().getDimensionPixelSize(2131298441));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setTextColor(getResources().getColor(2131165566));
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    localObject = a(0, "移动流量和WiFi");
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject;
    ((View)localObject).setBackgroundResource(2130839512);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = a(1, "仅WiFi");
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130839506);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = a(2, anvx.a(2131710259));
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130839503);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Biso = new biso(this, 2131561447);
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
    {
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[i];
      ImageView localImageView = (ImageView)localView.findViewById(2131362985);
      TextView localTextView = (TextView)localView.findViewById(2131379001);
      if (i != paramInt)
      {
        localImageView.setVisibility(4);
        localView.setContentDescription(localTextView.getText() + anvx.a(2131710257));
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setVisibility(0);
        localView.setContentDescription(localTextView.getText() + anvx.a(2131710262));
      }
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1001;
    case 2: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Vzv = ((vzv)this.app.getManager(QQManagerFactory.QQSTORY_MANAGER));
    this.jdField_a_of_type_Vzu = ((vzu)this.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER));
    a();
    int i = a(this.jdField_a_of_type_Vzv.a());
    this.b = i;
    this.jdField_a_of_type_Int = i;
    a(this.jdField_a_of_type_Int);
    super.setTitle(vzh.a + anvx.a(2131710266));
    this.app.addObserver(this.jdField_a_of_type_Vzx);
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131692125, 0).b(getTitleBarHeight());
      super.startTitleProgress();
      return true;
    }
    this.jdField_a_of_type_Vzu.d();
    super.startTitleProgress();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Vzx);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131692125, 0).b(getTitleBarHeight());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    this.b = this.jdField_a_of_type_Int;
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Biso.b(0, 2131718013, 0);
      a(i);
      break;
      this.jdField_a_of_type_Vzu.d(3);
      continue;
      this.jdField_a_of_type_Vzu.d(1);
      continue;
      this.jdField_a_of_type_Vzu.d(2);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity
 * JD-Core Version:    0.7.0.1
 */