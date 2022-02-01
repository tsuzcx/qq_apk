package com.tencent.mobileqq.activity;

import Override;
import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import aetb;
import aetc;
import aetd;
import aete;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvi;
import asll;
import bhid;
import bisl;
import bkzi;
import bkzz;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class RecentLoginDevActivity
  extends IphoneTitleBarActivity
{
  private Handler jdField_a_of_type_AndroidOsHandler = new aetb(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private anvi jdField_a_of_type_Anvi = new aete(this);
  private bisl jdField_a_of_type_Bisl;
  private bkzi jdField_a_of_type_Bkzi;
  private String jdField_a_of_type_JavaLangString = "";
  private List<SvcDevLoginInfo> jdField_a_of_type_JavaUtilList;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RecentLoginDevActivity.5(this));
  }
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131694210);
    }
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
    paramString1 = getString(2131694203, new Object[] { str });
    this.jdField_a_of_type_Bkzi.a(paramString1);
    this.jdField_a_of_type_Bkzi.a(getResources().getString(2131694202), 3);
    this.jdField_a_of_type_Bkzi.c(2131690697);
    this.jdField_a_of_type_Bkzi.a(new aetd(this, paramString2, paramArrayList, paramInt));
    this.jdField_a_of_type_Bkzi.show();
  }
  
  private void a(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    int j;
    int i;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null) {
          break label76;
        }
        i += 1;
      }
    }
    label76:
    View localView = getLayoutInflater().inflate(2131559380, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131369110);
    ((ImageView)localView.findViewById(2131368524)).setVisibility(0);
    label130:
    Object localObject;
    TextView localTextView;
    if (j == 1)
    {
      localRelativeLayout.setBackgroundResource(2130839496);
      ((TextView)localView.findViewById(2131369723)).setVisibility(8);
      localObject = (TextView)localView.findViewById(2131371803);
      localTextView = (TextView)localView.findViewById(2131368819);
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label386;
      }
      ((TextView)localObject).setText(2131694210);
    }
    for (;;)
    {
      localObject = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject).append(bhid.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd  HH:mm"));
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation))
      {
        ((StringBuffer)localObject).append(" ");
        ((StringBuffer)localObject).append(localSvcDevLoginInfo.strLoginLocation);
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
      {
        ((StringBuffer)localObject).append(" ");
        ((StringBuffer)localObject).append(localSvcDevLoginInfo.strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject).length() > 0) {
        localTextView.setText(((StringBuffer)localObject).toString());
      }
      localRelativeLayout.setClickable(true);
      localRelativeLayout.setTag(localSvcDevLoginInfo);
      localRelativeLayout.setOnClickListener(new aetc(this, localRelativeLayout, i));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      break;
      if (i == 0)
      {
        localRelativeLayout.setBackgroundResource(2130839512);
        break label130;
      }
      if (i == j - 1)
      {
        localRelativeLayout.setBackgroundResource(2130839503);
        break label130;
      }
      localRelativeLayout.setBackgroundResource(2130839506);
      break label130;
      label386:
      ((TextView)localObject).setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RecentLoginDevActivity.6(this));
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
    super.setContentView(2131561102);
    setTitle(2131694209);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368222));
    try
    {
      this.jdField_a_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "packName = " + this.jdField_a_of_type_JavaLangString);
      }
      addObserver(this.jdField_a_of_type_Anvi);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate begin to getRecentLoginDevList");
      }
      bool = asll.a().b(this.app, this.jdField_a_of_type_JavaLangString, 0L);
      if (bool)
      {
        a();
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      boolean bool;
      do
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate getRecentLoginDevList failed ret=" + bool);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
    removeObserver(this.jdField_a_of_type_Anvi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity
 * JD-Core Version:    0.7.0.1
 */