package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import abxq;
import abxr;
import abxs;
import abxt;
import ajxj;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoes;
import bbkp;
import bcqf;
import bfpc;
import bfpp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RecentLoginDevActivity
  extends IphoneTitleBarActivity
{
  private ajxj jdField_a_of_type_Ajxj = new abxt(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new abxq(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bcqf jdField_a_of_type_Bcqf;
  private bfpc jdField_a_of_type_Bfpc;
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
      str = getResources().getString(2131694494);
    }
    this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(this, null));
    paramString1 = getString(2131694486, new Object[] { str });
    this.jdField_a_of_type_Bfpc.a(paramString1);
    this.jdField_a_of_type_Bfpc.a(getResources().getString(2131694484), 3);
    this.jdField_a_of_type_Bfpc.c(2131690596);
    this.jdField_a_of_type_Bfpc.a(new abxs(this, paramString2, paramArrayList, paramInt));
    this.jdField_a_of_type_Bfpc.show();
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
    View localView = getLayoutInflater().inflate(2131559201, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131368344);
    ((ImageView)localView.findViewById(2131367799)).setVisibility(0);
    label130:
    Object localObject;
    TextView localTextView;
    if (j == 1)
    {
      localRelativeLayout.setBackgroundResource(2130839169);
      ((TextView)localView.findViewById(2131368845)).setVisibility(8);
      localObject = (TextView)localView.findViewById(2131370647);
      localTextView = (TextView)localView.findViewById(2131368086);
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label386;
      }
      ((TextView)localObject).setText(2131694494);
    }
    for (;;)
    {
      localObject = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject).append(bbkp.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd  HH:mm"));
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
      localRelativeLayout.setOnClickListener(new abxr(this, localRelativeLayout, i));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      break;
      if (i == 0)
      {
        localRelativeLayout.setBackgroundResource(2130839185);
        break label130;
      }
      if (i == j - 1)
      {
        localRelativeLayout.setBackgroundResource(2130839176);
        break label130;
      }
      localRelativeLayout.setBackgroundResource(2130839179);
      break label130;
      label386:
      ((TextView)localObject).setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RecentLoginDevActivity.6(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131560731);
    setTitle(2131694493);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367529));
    try
    {
      this.jdField_a_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "packName = " + this.jdField_a_of_type_JavaLangString);
      }
      addObserver(this.jdField_a_of_type_Ajxj);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate begin to getRecentLoginDevList");
      }
      bool = aoes.a().b(this.app, this.jdField_a_of_type_JavaLangString, 0L);
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
    removeObserver(this.jdField_a_of_type_Ajxj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity
 * JD-Core Version:    0.7.0.1
 */