package com.tencent.mobileqq.activity;

import adrc;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import azmj;
import bdee;
import bhim;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mzy;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class RiskInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private List<RiskInfoItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  
  private void a()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(bhim.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    a("ALL", getResources().getString(2131717632));
    mzy.a(this.app, new adrc(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      FormSimpleItem localFormSimpleItem;
      if (localObject != null)
      {
        localFormSimpleItem = (FormSimpleItem)((View)localObject).findViewById(2131375800);
        if (localFormSimpleItem != null)
        {
          localObject = (RiskInfoItem)localFormSimpleItem.getTag(2017021601);
          if (((RiskInfoItem)localObject).jdField_b_of_type_Int != 0) {
            break label103;
          }
        }
      }
      label103:
      for (localObject = ((RiskInfoItem)localObject).d;; localObject = String.format("%d", new Object[] { Integer.valueOf(((RiskInfoItem)localObject).jdField_b_of_type_Int) }))
      {
        if ((paramString1.equalsIgnoreCase("ALL")) || (paramString1.equalsIgnoreCase((String)localObject))) {
          localFormSimpleItem.setRightText(paramString2);
        }
        i += 1;
        break;
      }
    }
  }
  
  private void a(List<RiskInfoItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    int j = paramList.size();
    int i = 0;
    label47:
    RiskInfoItem localRiskInfoItem;
    if (i < j)
    {
      localRiskInfoItem = (RiskInfoItem)paramList.get(i);
      if (localRiskInfoItem != null) {
        break label76;
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label76:
      View localView = getLayoutInflater().inflate(2131561657, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131375801);
      FormSimpleItem localFormSimpleItem = (FormSimpleItem)localView.findViewById(2131375800);
      localFormSimpleItem.setLeftText(localRiskInfoItem.jdField_a_of_type_JavaLangString);
      localFormSimpleItem.setRightText(localRiskInfoItem.jdField_b_of_type_JavaLangString);
      ((TextView)localView.findViewById(2131375794)).setText(localRiskInfoItem.c);
      String str = localRiskInfoItem.d;
      localLinearLayout.setTag(2017021601, localRiskInfoItem);
      localFormSimpleItem.setTag(2017021601, localRiskInfoItem);
      localFormSimpleItem.setClickable(true);
      localFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    }
  }
  
  private void a(Map<String, RiskInfoItem> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RiskInfoItem localRiskInfoItem = (RiskInfoItem)localIterator.next();
        String str1 = String.format("%d", new Object[] { Integer.valueOf(localRiskInfoItem.jdField_b_of_type_Int) });
        if (localRiskInfoItem.jdField_b_of_type_Int == 0) {
          str1 = localRiskInfoItem.d;
        }
        if (paramMap.get(str1) != null)
        {
          a(str1, localRiskInfoItem.jdField_b_of_type_JavaLangString);
        }
        else
        {
          String str3 = localRiskInfoItem.e;
          String str2 = str3;
          if (TextUtils.isEmpty(str3)) {
            str2 = getResources().getString(2131692160);
          }
          a(str1, str2);
          if (localRiskInfoItem.d.equalsIgnoreCase("devlock")) {
            this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
          }
        }
      }
    }
    a("ALL", "");
  }
  
  protected void a(String paramString)
  {
    QLog.d("RiskInfoDetails", 1, String.format("jump: %s", new Object[] { paramString }));
    if (paramString.equalsIgnoreCase("devlock"))
    {
      try
      {
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
        {
          if (bdee.d(this)) {
            return;
          }
          QQToast.a(this, getString(2131692397), 0).b(getTitleBarHeight());
          return;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          this.app.sendWirelessMeibaoReq(1);
          paramString = new Intent(this, AuthDevActivity.class);
          paramString.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramString.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          paramString.putExtra("auth_dev_open", true);
          startActivityForResult(paramString, 0);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      this.app.sendWirelessMeibaoReq(1);
      if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
      {
        paramString = new Intent(this, AuthDevOpenUgActivity.class);
        paramString.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult(paramString, 0);
        return;
      }
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
      {
        paramString = new Intent(this, AuthDevOpenUgActivity.class);
        paramString.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult(paramString, 0);
        return;
      }
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1)
      {
        paramString = new Intent(this, AuthDevActivity.class);
        paramString.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramString.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        paramString.putExtra("auth_dev_open", false);
        startActivityForResult(paramString, 0);
      }
    }
    else
    {
      if (paramString.equalsIgnoreCase("phonebind")) {
        try
        {
          paramString = new Intent(this, PhoneUnityBindInfoActivity.class);
          paramString.putExtra("kSrouce", 18);
          startActivityForResult(paramString, 2001);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      if (paramString.equalsIgnoreCase("pickproof")) {
        try
        {
          startActivityForResult(new Intent(this, SecurityPickproofActivity.class), 0);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      if (paramString.equalsIgnoreCase("qpimprotect")) {
        try
        {
          startActivityForResult(new Intent(this, SecurityProtectActivity.class), 0);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      if (paramString.startsWith("http")) {
        for (;;)
        {
          String str;
          try
          {
            str = this.app.getCurrentAccountUin();
            Intent localIntent = new Intent(this, QQBrowserActivity.class);
            localIntent.putExtra("uin", str);
            if (paramString.indexOf("?") == -1)
            {
              paramString = paramString + "?uin=" + str;
              localIntent.putExtra("url", paramString);
              startActivityForResult(localIntent, 0);
              return;
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
          paramString = paramString + "&uin=" + str;
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    a();
  }
  
  public void onClick(View paramView)
  {
    paramView = (RiskInfoItem)paramView.getTag(2017021601);
    QLog.d("RiskInfoDetails", 1, String.format("set jump: %s", new Object[] { paramView.d }));
    a(paramView.d);
    azmj.b(this.app, "dc00899", "Safe_RiskInfo", "", paramView.jdField_a_of_type_JavaLangString, paramView.d, paramView.jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131561656);
    setTitle(2131717629);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131373915));
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaUtilList = paramBundle.getParcelableArrayList("data");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)paramBundle.get("DevlockInfo"));
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskInfoActivity
 * JD-Core Version:    0.7.0.1
 */