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
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  QQStoryHandler jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
  QQStoryManager jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new QQStoryBasicSettingsActivity.1(this);
  protected QQProgressNotifier a;
  View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  public int b = this.jdField_a_of_type_Int;
  
  public QQStoryBasicSettingsActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  int a(int paramInt)
  {
    int i = 0;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return 0;
        }
        return 2;
      }
      i = 1;
    }
    return i;
  }
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2131561545, null);
    ((TextView)localView.findViewById(2131378784)).setText(paramString);
    ((TextView)localView.findViewById(2131368773)).setText("");
    paramString = (ImageView)localView.findViewById(2131362975);
    paramString.setVisibility(4);
    paramString.setBackgroundResource(2130839279);
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  void a()
  {
    Object localObject1 = new LinearLayout(this);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject1).setBackgroundResource(2130838739);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setPadding(0, AIOUtils.b(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject1);
    localObject1 = new TextView(this);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(QQStoryConstant.a);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131710754));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    ((TextView)localObject1).setPadding(getResources().getDimensionPixelSize(2131298527), 0, getResources().getDimensionPixelSize(2131298527), getResources().getDimensionPixelSize(2131298522));
    ((TextView)localObject1).setTextSize(14.0F);
    ((TextView)localObject1).setTextColor(getResources().getColor(2131165542));
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1);
    localObject1 = a(0, "移动流量和WiFi");
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject1;
    ((View)localObject1).setBackgroundResource(2130839449);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    localObject1 = a(1, "仅WiFi");
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject1;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1);
    ((View)localObject1).setBackgroundResource(2130839443);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    localObject1 = a(2, HardCodeUtil.a(2131710752));
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject1;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1);
    ((View)localObject1).setBackgroundResource(2130839440);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2131561396);
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
      if (i >= localObject1.length) {
        break;
      }
      localObject1 = localObject1[i];
      Object localObject2 = (ImageView)((View)localObject1).findViewById(2131362975);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131378784);
      if (i != paramInt)
      {
        ((ImageView)localObject2).setVisibility(4);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localTextView.getText());
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131710750));
        ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      }
      else
      {
        ((ImageView)localObject2).setVisibility(0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localTextView.getText());
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131710755));
        ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = paramInt;
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
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager = ((QQStoryManager)this.app.getManager(QQManagerFactory.QQSTORY_MANAGER));
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER));
    a();
    int i = a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a());
    this.b = i;
    this.jdField_a_of_type_Int = i;
    a(this.jdField_a_of_type_Int);
    paramBundle = new StringBuilder();
    paramBundle.append(QQStoryConstant.a);
    paramBundle.append(HardCodeUtil.a(2131710759));
    super.setTitle(paramBundle.toString());
    this.app.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131692183, 0).b(getTitleBarHeight());
      super.startTitleProgress();
      return true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a();
    super.startTitleProgress();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131692183, 0).b(getTitleBarHeight());
    }
    else
    {
      int i = ((Integer)paramView.getTag()).intValue();
      this.b = this.jdField_a_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.d(3);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.d(2);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.d(1);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131718170, 0);
      a(i);
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