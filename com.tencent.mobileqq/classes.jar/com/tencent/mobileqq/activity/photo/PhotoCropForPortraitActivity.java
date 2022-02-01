package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
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
    boolean bool = true;
    Object localObject = (RelativeLayout)findViewById(2131363785);
    if (localObject == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131559677, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = AIOUtils.a(20.0F, getResources());
    ((RelativeLayout)localObject).addView(localViewGroup, localLayoutParams);
    int i = SharedPreUtils.af(this, getCurrentAccountUin());
    if (i == -1)
    {
      try
      {
        this.i = 1;
        localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.headCfg.name(), "24|3500|1|0");
        if (QLog.isColorLevel()) {
          QLog.i("PhotoCropActivity", 2, "initSyncQZoneUI, " + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length <= 2) {
          break label258;
        }
        i = Integer.parseInt(localObject[2]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PhotoCropActivity", 2, "initSyncQZoneUI error", localException);
          }
          i = 1;
        }
      }
      if (i < 0) {
        break label266;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131378792));
      if (i != 0) {}
      for (;;)
      {
        this.d = bool;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.d);
        localViewGroup.setOnClickListener(new PhotoCropForPortraitActivity.3(this));
        return;
        this.i = 3;
        label258:
        break;
        bool = false;
      }
      label266:
      i = 1;
    }
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
    if ((Build.VERSION.SDK_INT < 11) || ((Build.MODEL.equals("M040")) && (Build.VERSION.SDK_INT == 16))) {}
    for (;;)
    {
      if (getIntent().getBooleanExtra("open_chat_from_avator", false))
      {
        this.c = ((Button)super.findViewById(2131367679));
        this.c.setVisibility(0);
        this.c.setOnClickListener(new PhotoCropForPortraitActivity.1(this));
      }
      return bool;
      getWindow().setFlags(16777216, 16777216);
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
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity
 * JD-Core Version:    0.7.0.1
 */