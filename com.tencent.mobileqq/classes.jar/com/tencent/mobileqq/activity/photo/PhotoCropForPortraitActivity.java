package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhotoCropForPortraitActivity
  extends PhotoCropActivity
{
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  Button c;
  boolean e = true;
  
  private void d()
  {
    Object localObject1 = (RelativeLayout)findViewById(2131363715);
    if (localObject1 == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131559555, null);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.b(20.0F, getResources());
    ((RelativeLayout)localObject1).addView(localViewGroup, (ViewGroup.LayoutParams)localObject2);
    int i = SharedPreUtils.ac(this, getCurrentAccountUin());
    boolean bool = true;
    if (i == -1) {
      try
      {
        this.i = 1;
        localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), "24|3500|1|0");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("initSyncQZoneUI, ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("PhotoCropActivity", 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = ((String)localObject1).split("\\|");
        if (localObject1.length <= 2) {
          break label221;
        }
        i = Integer.parseInt(localObject1[2]);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoCropActivity", 2, "initSyncQZoneUI error", localException);
        }
        i = 1;
      }
    } else {
      this.i = 3;
    }
    label221:
    if (i < 0) {
      i = 1;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131378181));
    if (i == 0) {
      bool = false;
    }
    this.d = bool;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.d);
    localViewGroup.setOnClickListener(new PhotoCropForPortraitActivity.3(this));
  }
  
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    String str = this.app.getCurrentAccountUin();
    localObject = ((FriendsManager)localObject).a(str);
    if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()) && (this.e)) {
      this.jdField_a_of_type_AndroidOsHandler = new PhotoCropForPortraitActivity.2(this, (ExtensionInfo)localObject, str);
    }
    super.a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (100 == this.jdField_a_of_type_Int) {
      d();
    }
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
    this.e = getIntent().getBooleanExtra("PhotoConst.IS_WITH_PENDANT", true);
    boolean bool = super.doOnCreate(paramBundle);
    if ((Build.VERSION.SDK_INT >= 11) && ((!Build.MODEL.equals("M040")) || (Build.VERSION.SDK_INT != 16))) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (getIntent().getBooleanExtra("open_chat_from_avator", false))
    {
      this.c = ((Button)super.findViewById(2131367433));
      this.c.setVisibility(0);
      this.c.setOnClickListener(new PhotoCropForPortraitActivity.1(this));
    }
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity
 * JD-Core Version:    0.7.0.1
 */