package com.tencent.mobileqq.activity.qwallet;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.mobileqq.activity.qwallet.widget.ValueSelector;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import wxi;

public class PriceSettingDialog
  extends Dialog
  implements View.OnClickListener, View.OnFocusChangeListener
{
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PriceSettingDialog.OnPriceSelectedListener jdField_a_of_type_ComTencentMobileqqActivityQwalletPriceSettingDialog$OnPriceSelectedListener;
  private ValueSelector jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector;
  private Long jdField_a_of_type_JavaLangLong;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private PriceSettingDialog.OnPriceSelectedListener jdField_b_of_type_ComTencentMobileqqActivityQwalletPriceSettingDialog$OnPriceSelectedListener = new wxi(this);
  String jdField_b_of_type_JavaLangString;
  private View c;
  
  public PriceSettingDialog(Context paramContext, int paramInt, Intent paramIntent, PriceSettingDialog.OnPriceSelectedListener paramOnPriceSelectedListener)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPriceSettingDialog$OnPriceSelectedListener = paramOnPriceSelectedListener;
  }
  
  private void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(this.jdField_a_of_type_AndroidContentIntent.getLongExtra("goldmsg_min_value_", 0L));
    if (this.jdField_a_of_type_JavaLangLong == null) {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(1L);
    }
    this.jdField_a_of_type_Long = QWalletSetting.a(((AppRuntime)localObject).getAccount(), "money_max", 20000L);
    localObject = getContext().getResources();
    this.jdField_b_of_type_JavaLangString = String.format(((Resources)localObject).getString(2131432283), new Object[] { NumAnim.formatNumber(this.jdField_a_of_type_JavaLangLong.longValue() / 100.0D, false) });
    this.jdField_a_of_type_JavaLangString = String.format(((Resources)localObject).getString(2131432284), new Object[] { NumAnim.formatNumber(this.jdField_a_of_type_Long / 100.0D, false) });
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPriceSettingDialog$OnPriceSelectedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPriceSettingDialog$OnPriceSelectedListener.a(paramLong);
    }
    onBackPressed();
  }
  
  public static void a(Context paramContext, Intent paramIntent, PriceSettingDialog.OnPriceSelectedListener paramOnPriceSelectedListener)
  {
    paramIntent = new PriceSettingDialog(paramContext, 2131624485, paramIntent, paramOnPriceSelectedListener);
    paramIntent.setContentView(LayoutInflater.from(paramContext).inflate(2130969015, null));
    paramContext = paramIntent.getWindow();
    paramContext.setLayout(-1, -2);
    paramContext.setGravity(80);
    paramContext.setWindowAnimations(2131624478);
    paramContext.setSoftInputMode(16);
    paramIntent.show();
    paramIntent.setCanceledOnTouchOutside(true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362822);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131364707);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector = ((ValueSelector)findViewById(2131364709));
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getContext().getResources().getColor(2131494034));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.setRange(this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_a_of_type_Long);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    localObject = QWalletSetting.a(getContext(), ((AppRuntime)localObject).getAccount(), "money_array", Long.class);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.setValueSelectListener(this.jdField_b_of_type_ComTencentMobileqqActivityQwalletPriceSettingDialog$OnPriceSelectedListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.setFocusChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.setValueAndDisplay((ArrayList)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364710));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = findViewById(2131364706);
    this.c.setOnClickListener(this);
    this.c.setContentDescription(getContext().getString(2131432327));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364710: 
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.checkIsInputEmpty())
        {
          QQToast.a(getContext(), 2131432271, 0).a();
          return;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetValueSelector.checkAndQueryInputValue();
      } while (paramView == null);
      a(paramView.longValue());
      return;
    }
    onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    b();
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PriceSettingDialog
 * JD-Core Version:    0.7.0.1
 */