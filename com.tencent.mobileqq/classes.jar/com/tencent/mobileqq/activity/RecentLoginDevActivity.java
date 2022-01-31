package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
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
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import toc;
import tod;
import toe;
import tof;
import tog;
import toh;

public class RecentLoginDevActivity
  extends IphoneTitleBarActivity
{
  private Handler jdField_a_of_type_AndroidOsHandler = new toc(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tof(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tog(this));
  }
  
  private void a(String paramString1, ArrayList paramArrayList, String paramString2, int paramInt)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131436507);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    paramString1 = getString(2131436505, new Object[] { str });
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString1);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131436506), 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new toe(this, paramString2, paramArrayList, paramInt));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void a(List paramList)
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
    View localView = getLayoutInflater().inflate(2130969060, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131362749);
    ((ImageView)localView.findViewById(2131362767)).setVisibility(0);
    label130:
    Object localObject;
    TextView localTextView;
    if (j == 1)
    {
      localRelativeLayout.setBackgroundResource(2130838623);
      ((TextView)localView.findViewById(2131364921)).setVisibility(8);
      localObject = (TextView)localView.findViewById(2131362754);
      localTextView = (TextView)localView.findViewById(2131364119);
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label386;
      }
      ((TextView)localObject).setText(2131436507);
    }
    for (;;)
    {
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
      localRelativeLayout.setOnClickListener(new tod(this, localRelativeLayout, i));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      break;
      if (i == 0)
      {
        localRelativeLayout.setBackgroundResource(2130838635);
        break label130;
      }
      if (i == j - 1)
      {
        localRelativeLayout.setBackgroundResource(2130838630);
        break label130;
      }
      localRelativeLayout.setBackgroundResource(2130838633);
      break label130;
      label386:
      ((TextView)localObject).setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new toh(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130970322);
    setTitle(2131436510);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370063));
    try
    {
      this.jdField_a_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "packName = " + this.jdField_a_of_type_JavaLangString);
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate begin to getRecentLoginDevList");
      }
      bool = EquipmentLockImpl.a().b(this.app, this.jdField_a_of_type_JavaLangString, 0L);
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
  
  protected void onDestroy()
  {
    super.onDestroy();
    b();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity
 * JD-Core Version:    0.7.0.1
 */