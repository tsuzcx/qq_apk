package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import rkp;
import rkq;

public class AgeSelectionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public static int a(String paramString)
  {
    return Arrays.asList(NearbyProfileUtil.c).indexOf(paramString);
  }
  
  private void a()
  {
    this.g = (this.jdField_a_of_type_Int - (this.d + 1897));
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, this.e + 1, this.f + 1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, this.jdField_b_of_type_Int, this.c);
    if (localCalendar1.after(localCalendar2)) {
      this.g -= 1;
    }
    if (this.g < 0) {
      this.g = 0;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.g + "岁");
    this.jdField_a_of_type_JavaLangString = Utils.a(this.e + 1, this.f + 1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130970373, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new rkq(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131362805);
      ((DispatchActionMoveScrollView)localObject).a = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new rkp(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.d);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.e);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.f);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970179);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369433));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369435));
    findViewById(2131369432).setOnClickListener(this);
    findViewById(2131369434).setOnClickListener(this);
    setTitle("选择出生日期");
    setLeftViewName(2131432414);
    paramBundle = Calendar.getInstance();
    paramBundle.setTimeInMillis(System.currentTimeMillis());
    this.jdField_a_of_type_Int = paramBundle.get(1);
    this.jdField_b_of_type_Int = (paramBundle.get(2) + 1);
    this.c = paramBundle.get(5);
    int i = getIntent().getIntExtra("param_birthday", 0);
    if (i == 0)
    {
      this.d = 93;
      this.e = 0;
    }
    for (this.f = 0;; this.f = ((i & 0xFF) - 1))
    {
      a();
      b();
      return true;
      this.d = (((0xFFFF0000 & i) >>> 16) - 1897);
      this.e = (((0xFF00 & i) >>> 8) - 1);
    }
  }
  
  protected boolean onBackEvent()
  {
    this.d = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0);
    this.e = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
    this.f = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
    a();
    Intent localIntent = new Intent();
    localIntent.putExtra("param_age", this.g);
    localIntent.putExtra("param_constellation_id", a(this.jdField_a_of_type_JavaLangString));
    localIntent.putExtra("param_constellation", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("param_year", (short)(this.d + 1897));
    localIntent.putExtra("param_month", (byte)(this.e + 1));
    localIntent.putExtra("param_day", (byte)(this.f + 1));
    setResult(-1, localIntent);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131369433: 
    default: 
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity
 * JD-Core Version:    0.7.0.1
 */