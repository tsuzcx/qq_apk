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
  static final String[] k = { "provn", "city", "area", "" };
  ConditionSearchManager b;
  TextView c;
  ActionSheet d;
  IphonePickerView e;
  TroopRobotPickerActivity.RobotPickerData f;
  JSONObject g;
  JSONObject h;
  String i;
  ProgressDialog j;
  
  private int a(ArrayList<? extends BaseAddress> paramArrayList, String paramString)
  {
    int n = paramArrayList.size();
    int m = 0;
    while (m < n)
    {
      if (((BaseAddress)paramArrayList.get(m)).code.equals(paramString)) {
        return m;
      }
      m += 1;
    }
    return 0;
  }
  
  private void a()
  {
    int m = this.f.pickerType;
    if (m == 3) {
      b();
    }
    this.d = ActionSheet.createMenuSheet(this);
    Object localObject = (DispatchActionMoveScrollView)this.d.findViewById(2131427560);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).a = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.e = ((IphonePickerView)LayoutInflater.from(this).inflate(2131627482, null));
    this.e.a(new TroopRobotPickerActivity.WebPickerViewAdapter(this, this.f));
    this.e.setBackgroundColor(-1118221);
    if (m == 2)
    {
      this.e.setSelection(0, this.f.mAgeSelectIndex1);
      this.e.setSelection(1, this.f.mAgeSelectIndex2);
    }
    else if (m == 1)
    {
      this.e.setSelection(0, this.f.mSexIndex);
    }
    else
    {
      m = 0;
      while (m < this.f.mLocationColumCount)
      {
        this.e.setSelection(m, this.f.mLocationIndexArray[m]);
        m += 1;
      }
      this.c = ((TextView)this.e.findViewById(2131445520));
      this.c.setVisibility(0);
      if (this.f.mLocationCountry != null) {
        localObject = this.f.mLocationCountry.name;
      } else {
        localObject = "中国";
      }
      this.c.setText((CharSequence)localObject);
      this.c.setOnClickListener(new TroopRobotPickerActivity.1(this));
      if (AppSetting.e)
      {
        TextView localTextView = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131912999));
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(HardCodeUtil.a(2131913001));
        localTextView.setContentDescription(localStringBuilder.toString());
      }
    }
    localObject = this.e;
    ((IphonePickerView)localObject).setPickListener(new TroopRobotPickerActivity.WebIphonePickListener(this, this.f, (IphonePickerView)localObject, this.d));
    if (Build.VERSION.SDK_INT >= 11) {
      this.d.getWindow().setFlags(16777216, 16777216);
    }
    this.d.setActionContentView(this.e, null);
    this.d.setOnDismissListener(new TroopRobotPickerActivity.WebOnDismissListener(this, this.f));
    try
    {
      this.d.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, localThrowable.getMessage());
      }
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      String str = this.h.optString("countryCode");
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
    paramString = this.b.a(paramString);
    Object localObject1 = this.f;
    ((TroopRobotPickerActivity.RobotPickerData)localObject1).mLocationCountry = paramString;
    if (((TroopRobotPickerActivity.RobotPickerData)localObject1).mLocationCountry != null)
    {
      paramString = this.f;
      paramString.mLocationColumCount = paramString.mLocationCountry.getColumnNember();
      paramString = this.f;
      paramString.mLocationListArray = new Object[paramString.mLocationColumCount];
      paramString = this.f;
      paramString.mLocationArray = new BaseAddress[paramString.mLocationColumCount];
      paramString = this.f;
      paramString.mLocationIndexArray = new int[paramString.mLocationColumCount];
      if (this.f.mLocationColumCount == 0) {
        return;
      }
      paramString = this.f.mLocationCountry;
      int i1 = this.f.mLocationCodeArray.length;
      int m = 0;
      int n = 0;
      while (m < i1)
      {
        if (!"0".equals(this.f.mLocationCodeArray[m]))
        {
          this.f.mLocationListArray[n] = paramString.getDataList();
          localObject2 = this.f.mLocationArray;
          localObject1 = (BaseAddress)paramString.dataMap.get(this.f.mLocationCodeArray[m]);
          localObject2[n] = localObject1;
          this.f.mLocationIndexArray[n] = a((ArrayList)this.f.mLocationListArray[n], this.f.mLocationCodeArray[m]);
          n += 1;
          paramString = (String)localObject1;
          if (localObject1 == null) {
            return;
          }
        }
        m += 1;
      }
      if (n < this.f.mLocationColumCount)
      {
        this.f.mLocationListArray[n] = paramString.getDataList();
        this.f.mLocationArray[n] = ((BaseAddress)paramString.dataMap.get(Integer.valueOf(0)));
        this.f.mLocationIndexArray[n] = 0;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initLocationData|mLocationColumCount : ");
      ((StringBuilder)localObject2).append(this.f.mLocationColumCount);
      ((StringBuilder)localObject2).append(", mLocationCountry.name : ");
      if (this.f.mLocationCountry == null) {
        paramString = "null";
      } else {
        paramString = this.f.mLocationCountry.name;
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
        localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnActivityResult | codes = ");
        localStringBuilder.append((String)localObject1);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.f.mLocationCountyCode)))
      {
        localObject2 = this.f;
        ((TroopRobotPickerActivity.RobotPickerData)localObject2).mLocationCountyCode = ((String)localObject1);
        ((TroopRobotPickerActivity.RobotPickerData)localObject2).mLocationCountry = this.b.a(((TroopRobotPickerActivity.RobotPickerData)localObject2).mLocationCountyCode);
        if (this.f.mLocationCountry != null)
        {
          int m = this.f.mLocationCountry.getColumnNember();
          if ((m > 0) && (m <= 3))
          {
            a(this.f.mLocationCountyCode);
            localObject1 = this.d;
            if ((localObject1 != null) && (((ActionSheet)localObject1).isShowing()))
            {
              if (this.e == null) {
                this.e = ((IphonePickerView)getLayoutInflater().inflate(2131627482, null));
              }
              this.e.a(new TroopRobotPickerActivity.WebPickerViewAdapter(this, this.f));
              m = 0;
              while (m < this.f.mLocationColumCount)
              {
                this.e.a(m);
                this.e.setSelection(m, 0);
                m += 1;
              }
            }
            localObject1 = this.c;
            if (localObject1 != null)
            {
              ((TextView)localObject1).setText(this.f.mLocationCountry.name);
              if (AppSetting.e)
              {
                localObject1 = this.c;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913008));
                ((StringBuilder)localObject2).append(this.f.mLocationCountry.name);
                ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913011));
                ((TextView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
              }
            }
          }
          else
          {
            a(this.f.mLocationCountyCode);
            localObject1 = this.d;
            if ((localObject1 != null) && (((ActionSheet)localObject1).isShowing())) {
              this.d.dismiss();
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
    this.j = new ReportProgressDialog(this);
    this.j.setMessage(HardCodeUtil.a(2131913005));
    this.f = new TroopRobotPickerActivity.RobotPickerData();
    try
    {
      this.g = new JSONObject(getIntent().getStringExtra("json"));
      this.h = this.g.getJSONObject("selected");
      this.i = this.g.optString("callback");
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    paramBundle = this.g;
    if ((paramBundle != null) && (this.i != null))
    {
      try
      {
        this.f.pickerType = paramBundle.optInt("type");
        if (this.f.pickerType == 0)
        {
          finish();
          QQToast.makeText(this, HardCodeUtil.a(2131913004), 1).show();
          return false;
        }
        if (this.f.pickerType == 1)
        {
          this.f.mSexIndex = this.h.optInt("sex");
        }
        else if (this.f.pickerType == 2)
        {
          this.f.mAgeSelectIndex1 = this.h.optInt("ageStart");
          this.f.mAgeSelectIndex2 = this.h.optInt("ageEnd");
          this.f.mCurAgeIndex1 = this.f.mAgeSelectIndex1;
          this.f.mCurAgeIndex2 = this.f.mAgeSelectIndex2;
        }
        else
        {
          this.f.mLocationCodeArray = new String[3];
          int m = 0;
          while (m < 3)
          {
            this.f.mLocationCodeArray[m] = this.h.optString(k[m]);
            m += 1;
          }
          this.f.mLocationCountyCode = this.h.optString("country");
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      this.b = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
      if (this.f.pickerType == 3)
      {
        this.j.show();
        this.b.c(new TroopRobotPickerActivity.2(this));
        paramBundle = this.b;
        paramBundle.a(paramBundle.d(), true);
        return false;
      }
      if (this.f.pickerType != -1) {
        a();
      }
      return false;
    }
    finish();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("");
      paramBundle.append(a);
      QLog.e(paramBundle.toString(), 2, "webData is null!");
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ConditionSearchManager localConditionSearchManager = this.b;
    if (localConditionSearchManager != null) {
      localConditionSearchManager.b(this);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ConditionSearchManager localConditionSearchManager = this.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity
 * JD-Core Version:    0.7.0.1
 */