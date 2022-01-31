package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import www;
import wwx;
import wwy;

public class PhotoCropForPortraitActivity
  extends PhotoCropActivity
{
  public CheckBox a;
  public URLImageView a;
  Button c;
  boolean d = true;
  
  private void b()
  {
    boolean bool = true;
    Object localObject = (RelativeLayout)findViewById(2131363109);
    if (localObject == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2130969174, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = AIOUtils.a(20.0F, getResources());
    ((RelativeLayout)localObject).addView(localViewGroup, localLayoutParams);
    int i = SharedPreUtils.ay(this, getCurrentAccountUin());
    if (i == -1)
    {
      try
      {
        this.h = 1;
        localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1");
        if (QLog.isColorLevel()) {
          QLog.i("qqBaseActivity", 2, "initSyncQZoneUI, " + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 2) {
          i = Integer.parseInt(localObject[2]);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("qqBaseActivity", 2, "initSyncQZoneUI error", localException);
          }
          i = 1;
        }
      }
      if (i < 0) {
        break label259;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364444));
      if (i != 0) {}
      for (;;)
      {
        this.jdField_c_of_type_Boolean = bool;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_c_of_type_Boolean);
        localViewGroup.setOnClickListener(new wwy(this));
        return;
        this.h = 3;
        break;
        bool = false;
      }
      label259:
      i = 1;
    }
  }
  
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = (FriendsManager)this.app.getManager(50);
    String str = this.app.getCurrentAccountUin();
    localObject = ((FriendsManager)localObject).a(str);
    if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()) && (this.d)) {
      this.jdField_a_of_type_AndroidOsHandler = new wwx(this, (ExtensionInfo)localObject, str);
    }
    super.a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    b();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.d = getIntent().getBooleanExtra("PhotoConst.IS_WITH_PENDANT", true);
    boolean bool = super.doOnCreate(paramBundle);
    if ((Build.VERSION.SDK_INT < 11) || ((Build.MODEL.equals("M040")) && (Build.VERSION.SDK_INT == 16))) {}
    for (;;)
    {
      if (getIntent().getBooleanExtra("open_chat_from_avator", false))
      {
        this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365508));
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new www(this));
      }
      return bool;
      getWindow().setFlags(16777216, 16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity
 * JD-Core Version:    0.7.0.1
 */