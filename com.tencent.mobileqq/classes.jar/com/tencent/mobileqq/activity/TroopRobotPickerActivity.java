package com.tencent.mobileqq.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopRobotPickerActivity
  extends BaseActivity
{
  public static String a = "TroopRobotPickerActivity";
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "provn", "city", "area", "" };
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TroopRobotPickerActivity.RobotPickerData jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  String jdField_b_of_type_JavaLangString;
  JSONObject jdField_b_of_type_OrgJsonJSONObject;
  
  private int a(ArrayList<? extends BaseAddress> paramArrayList, String paramString)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((BaseAddress)paramArrayList.get(i)).code.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
    if (i == 3) {
      b();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(this);
    Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131361999);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).a = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(this).inflate(2131561132, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new TroopRobotPickerActivity.WebPickerViewAdapter(this, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(-1118221);
    if (i == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2);
    }
    else if (i == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex);
    }
    else
    {
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
      {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(i, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[i]);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131377144));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name;
      } else {
        localObject = "中国";
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new TroopRobotPickerActivity.1(this));
      if (AppSetting.d)
      {
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131715526));
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(HardCodeUtil.a(2131715528));
        localTextView.setContentDescription(localStringBuilder.toString());
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    ((IphonePickerView)localObject).setPickListener(new TroopRobotPickerActivity.WebIphonePickListener(this, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData, (IphonePickerView)localObject, this.jdField_a_of_type_ComTencentWidgetActionSheet));
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new TroopRobotPickerActivity.WebOnDismissListener(this, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData));
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, localThrowable.getMessage());
      }
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      String str = this.jdField_b_of_type_OrgJsonJSONObject.optString("countryCode");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "1";
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)localObject2;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramString);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
    ((TroopRobotPickerActivity.RobotPickerData)localObject1).mLocationCountry = paramString;
    if (((TroopRobotPickerActivity.RobotPickerData)localObject1).mLocationCountry != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
      paramString.mLocationColumCount = paramString.mLocationCountry.getColumnNember();
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
      paramString.mLocationListArray = new Object[paramString.mLocationColumCount];
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
      paramString.mLocationArray = new BaseAddress[paramString.mLocationColumCount];
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
      paramString.mLocationIndexArray = new int[paramString.mLocationColumCount];
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount == 0) {
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry;
      int k = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        if (!"0".equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[i]))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[j] = paramString.getDataList();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray;
          localObject1 = (BaseAddress)paramString.dataMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[i]);
          localObject2[j] = localObject1;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[j] = a((ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[j], this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[i]);
          j += 1;
          paramString = (String)localObject1;
          if (localObject1 == null) {
            return;
          }
        }
        i += 1;
      }
      if (j < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[j] = paramString.getDataList();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[j] = ((BaseAddress)paramString.dataMap.get(Integer.valueOf(0)));
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[j] = 0;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initLocationData|mLocationColumCount : ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount);
      ((StringBuilder)localObject2).append(", mLocationCountry.name : ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry == null) {
        paramString = "null";
      } else {
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name;
      }
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void b()
  {
    a("");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 111))
    {
      Object localObject1 = paramIntent.getStringExtra("key_country_code");
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnActivityResult | codes = ");
        localStringBuilder.append((String)localObject1);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode)))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData;
        ((TroopRobotPickerActivity.RobotPickerData)localObject2).mLocationCountyCode = ((String)localObject1);
        ((TroopRobotPickerActivity.RobotPickerData)localObject2).mLocationCountry = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(((TroopRobotPickerActivity.RobotPickerData)localObject2).mLocationCountyCode);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry != null)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.getColumnNember();
          if ((i > 0) && (i <= 3))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
            localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
            if ((localObject1 != null) && (((ActionSheet)localObject1).isShowing()))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
                this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561132, null));
              }
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new TroopRobotPickerActivity.WebPickerViewAdapter(this, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData));
              i = 0;
              while (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
              {
                this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(i);
                this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(i, 0);
                i += 1;
              }
            }
            localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
            if (localObject1 != null)
            {
              ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name);
              if (AppSetting.d)
              {
                localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715536));
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name);
                ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715539));
                ((TextView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
              }
            }
          }
          else
          {
            a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
            localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
            if ((localObject1 != null) && (((ActionSheet)localObject1).isShowing())) {
              this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
            }
          }
        }
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this);
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(HardCodeUtil.a(2131715533));
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData = new TroopRobotPickerActivity.RobotPickerData();
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(getIntent().getStringExtra("json"));
      this.jdField_b_of_type_OrgJsonJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.getJSONObject("selected");
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("callback");
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    paramBundle = this.jdField_a_of_type_OrgJsonJSONObject;
    if ((paramBundle != null) && (this.jdField_b_of_type_JavaLangString != null))
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType = paramBundle.optInt("type");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 0)
        {
          finish();
          QQToast.a(this, HardCodeUtil.a(2131715532), 1).a();
          return false;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex = this.jdField_b_of_type_OrgJsonJSONObject.optInt("sex");
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1 = this.jdField_b_of_type_OrgJsonJSONObject.optInt("ageStart");
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2 = this.jdField_b_of_type_OrgJsonJSONObject.optInt("ageEnd");
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray = new String[3];
          int i = 0;
          while (i < 3)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[i] = this.jdField_b_of_type_OrgJsonJSONObject.optString(jdField_a_of_type_ArrayOfJavaLangString[i]);
            i += 1;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode = this.jdField_b_of_type_OrgJsonJSONObject.optString("country");
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 3)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(new TroopRobotPickerActivity.2(this));
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
        paramBundle.a(paramBundle.a(), true);
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType != -1) {
        a();
      }
      return false;
    }
    finish();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("");
      paramBundle.append(jdField_a_of_type_JavaLangString);
      QLog.e(paramBundle.toString(), 2, "webData is null!");
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ConditionSearchManager localConditionSearchManager = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
    if (localConditionSearchManager != null) {
      localConditionSearchManager.b(this);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ConditionSearchManager localConditionSearchManager = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
    if (localConditionSearchManager != null) {
      localConditionSearchManager.a(this);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity
 * JD-Core Version:    0.7.0.1
 */