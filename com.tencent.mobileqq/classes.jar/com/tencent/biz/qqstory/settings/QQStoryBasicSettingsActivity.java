package com.tencent.biz.qqstory.settings;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import nra;

public class QQStoryBasicSettingsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public int a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public QQStoryHandler a;
  public QQStoryManager a;
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new nra(this);
  public QQProgressNotifier a;
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
    View localView = View.inflate(this, 2130970656, null);
    ((TextView)localView.findViewById(2131363378)).setText(paramString);
    ((TextView)localView.findViewById(2131364119)).setText("");
    paramString = (ImageView)localView.findViewById(2131363443);
    paramString.setVisibility(4);
    paramString.setBackgroundResource(2130838490);
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  void a()
  {
    Object localObject = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject).setBackgroundResource(2130838214);
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setPadding(0, AIOUtils.a(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setText("日迹自动播放");
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131558774), 0, getResources().getDimensionPixelSize(2131558774), getResources().getDimensionPixelSize(2131558772));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setTextColor(getResources().getColor(2131492891));
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    localObject = a(0, "移动流量和WiFi");
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject;
    ((View)localObject).setBackgroundResource(2130838635);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = a(1, "仅WiFi");
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130838633);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = a(2, "关闭");
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130838630);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2130970578);
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
    {
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[i];
      ImageView localImageView = (ImageView)localView.findViewById(2131363443);
      TextView localTextView = (TextView)localView.findViewById(2131363378);
      if (i != paramInt)
      {
        localImageView.setVisibility(4);
        localView.setContentDescription(localTextView.getText() + " 未选中");
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setVisibility(0);
        localView.setContentDescription(localTextView.getText() + " 已选中");
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager = ((QQStoryManager)this.app.getManager(180));
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.a(98));
    a();
    int i = a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a());
    this.b = i;
    this.jdField_a_of_type_Int = i;
    a(this.jdField_a_of_type_Int);
    super.setTitle("日迹自动播放");
    this.app.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    if (!NetworkUtil.g(this))
    {
      QQToast.a(this, 1, 2131433009, 0).b(getTitleBarHeight());
      super.startTitleProgress();
      return true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.d();
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
    if (!NetworkUtil.g(this))
    {
      QQToast.a(this, 1, 2131433009, 0).b(getTitleBarHeight());
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    this.b = this.jdField_a_of_type_Int;
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131433007, 0);
      a(i);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.c(3);
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.c(1);
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.c(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity
 * JD-Core Version:    0.7.0.1
 */