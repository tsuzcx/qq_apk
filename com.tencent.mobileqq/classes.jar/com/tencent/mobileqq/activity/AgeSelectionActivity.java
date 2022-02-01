package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class AgeSelectionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  BirthdayPickHelper jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @Nullable
  private String jdField_b_of_type_JavaLangString;
  int c;
  int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public static int a(String paramString)
  {
    return Arrays.asList(NearbyProfileUtil.c).indexOf(paramString);
  }
  
  private void a()
  {
    a(this.jdField_b_of_type_Int, this.c, this.d);
    Intent localIntent = new Intent();
    localIntent.putExtra("param_age", this.h);
    localIntent.putExtra("param_constellation_id", a(this.jdField_a_of_type_JavaLangString));
    localIntent.putExtra("param_constellation", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("param_year", (short)this.jdField_b_of_type_Int);
    localIntent.putExtra("param_month", (byte)this.c);
    localIntent.putExtra("param_day", (byte)this.d);
    setResult(-1, localIntent);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = (this.e - paramInt1);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(1, paramInt2, paramInt3);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.f, this.g);
    if (((Calendar)localObject1).after(localObject2)) {
      this.h -= 1;
    }
    if (this.h < 0) {
      this.h = 0;
    }
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.h);
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700240));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    this.jdField_a_of_type_JavaLangString = Utils.a(paramInt2, paramInt3);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  private boolean a()
  {
    return ("VAL_FROM_STATUS_MSG_TAB".equals(this.jdField_b_of_type_JavaLangString)) || ("VAL_FROM_STATUS_SETTING".equals(this.jdField_b_of_type_JavaLangString));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper = new BirthdayPickHelper(getBaseContext(), this.jdField_a_of_type_Int, false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setCloseAutoRead(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper.a(), null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131361999);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBirthdayPickHelper.a(new AgeSelectionActivity.2(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {}
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560920);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("param_launch_from");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362294));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365099));
    findViewById(2131362298).setOnClickListener(this);
    findViewById(2131365102).setOnClickListener(this);
    setTitle(HardCodeUtil.a(2131700237));
    setLeftViewName(2131690529);
    if (a()) {
      setRightButton(2131692486, new AgeSelectionActivity.1(this));
    }
    this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.e = this.jdField_a_of_type_JavaUtilCalendar.get(1);
    this.f = (this.jdField_a_of_type_JavaUtilCalendar.get(2) + 1);
    this.g = this.jdField_a_of_type_JavaUtilCalendar.get(5);
    if (QLog.isColorLevel()) {
      QLog.d("AgeSelectionActivity", 2, String.format("doOnCreate date : %s-%s-%s ", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g) }));
    }
    this.jdField_a_of_type_Int = getIntent().getIntExtra("param_birthday", 0);
    this.jdField_b_of_type_Int = 2000;
    this.c = 1;
    this.d = 1;
    int i = this.jdField_a_of_type_Int;
    if (i > 0)
    {
      this.jdField_b_of_type_Int = ((0xFFFF0000 & i) >>> 16);
      this.c = ((0xFF00 & i) >>> 8);
      this.d = (i & 0xFF);
    }
    a(this.jdField_b_of_type_Int, this.c, this.d);
    b();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    if (!a()) {
      a();
    } else if ("VAL_FROM_STATUS_MSG_TAB".equals(this.jdField_b_of_type_JavaLangString)) {
      ReportHelperKt.a("0X800AF46");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == 2131362298) || (i == 2131365102)) {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity
 * JD-Core Version:    0.7.0.1
 */