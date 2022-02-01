package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
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
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;

public class RecentLoginDevActivity
  extends IphoneTitleBarActivity
{
  private String a = "";
  private List<SvcDevLoginInfo> b = null;
  private Handler c = new RecentLoginDevActivity.1(this);
  private QQProgressDialog d;
  private LinearLayout e = null;
  private ActionSheet f = null;
  private FriendListObserver g = new RecentLoginDevActivity.4(this);
  
  private void a()
  {
    this.c.post(new RecentLoginDevActivity.5(this));
  }
  
  private void a(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131892057);
    }
    this.f = ((ActionSheet)ActionSheetHelper.b(this, null));
    paramString1 = getString(2131892050, new Object[] { str });
    this.f.setMainTitle(paramString1);
    this.f.addButton(getResources().getString(2131892049), 3);
    this.f.addCancelButton(2131887648);
    this.f.setOnButtonClickListener(new RecentLoginDevActivity.3(this, paramString2, paramArrayList, paramInt));
    this.f.show();
  }
  
  private void a(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.e.removeAllViews();
      this.e.setVisibility(0);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null)
        {
          View localView = getLayoutInflater().inflate(2131625270, this.e, false);
          RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131436054);
          ((ImageView)localView.findViewById(2131435388)).setVisibility(0);
          if (j == 1) {
            localRelativeLayout.setBackgroundResource(2130839622);
          } else if (i == 0) {
            localRelativeLayout.setBackgroundResource(2130839638);
          } else if (i == j - 1) {
            localRelativeLayout.setBackgroundResource(2130839629);
          } else {
            localRelativeLayout.setBackgroundResource(2130839632);
          }
          ((TextView)localView.findViewById(2131436788)).setVisibility(8);
          Object localObject = (TextView)localView.findViewById(2131439121);
          TextView localTextView = (TextView)localView.findViewById(2131435692);
          if (TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
            ((TextView)localObject).setText(2131892057);
          } else {
            ((TextView)localObject).setText(localSvcDevLoginInfo.strDeviceName);
          }
          localObject = new StringBuffer();
          if (localSvcDevLoginInfo.iLoginTime > 0L) {
            ((StringBuffer)localObject).append(TimeFormatterUtils.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd  HH:mm"));
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
          localRelativeLayout.setOnClickListener(new RecentLoginDevActivity.2(this, localRelativeLayout, i));
          this.e.addView(localView);
        }
        i += 1;
      }
      return;
    }
    this.e.setVisibility(8);
  }
  
  private void b()
  {
    this.c.post(new RecentLoginDevActivity.6(this));
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
    super.setContentView(2131627395);
    setTitle(2131892056);
    this.e = ((LinearLayout)findViewById(2131435057));
    try
    {
      this.a = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("packName = ");
      paramBundle.append(this.a);
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, paramBundle.toString());
    }
    addObserver(this.g);
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate begin to getRecentLoginDevList");
    }
    boolean bool = EquipmentLockImpl.a().b(this.app, this.a, 0L);
    if (bool)
    {
      a();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate getRecentLoginDevList failed ret=");
      paramBundle.append(bool);
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, paramBundle.toString());
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b();
    removeObserver(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity
 * JD-Core Version:    0.7.0.1
 */