package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.NumberWheelView;
import com.tencent.mobileqq.app.utils.TimeWheelPanel;
import com.tencent.mobileqq.app.utils.TimeWheelPanel.ScrollStateListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.VerticalGallery;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class NotifyPushSettingActivity$TimePickDialog
  extends ReportDialog
  implements DialogInterface.OnCancelListener, DialogInterface.OnShowListener, View.OnClickListener, TimeWheelPanel.ScrollStateListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TimeWheelPanel jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel;
  private FormSwitchSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  private TextView c;
  
  public NotifyPushSettingActivity$TimePickDialog(Context paramContext, QQAppInterface paramQQAppInterface, FormSwitchSimpleItem paramFormSwitchSimpleItem, TextView paramTextView, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    super(paramContext, 2131755695);
    requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = paramFormSwitchSimpleItem;
    this.c = paramTextView;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = paramOnCheckedChangeListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131560983, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    paramContext = getWindow();
    paramQQAppInterface = paramContext.getAttributes();
    paramQQAppInterface.width = -1;
    paramQQAppInterface.height = -2;
    paramQQAppInterface.gravity = 81;
    paramContext.setAttributes(paramQQAppInterface);
    paramContext.setWindowAnimations(2131755696);
    paramContext.setFlags(16777216, 16777216);
    setCancelable(true);
    setCanceledOnTouchOutside(true);
    a();
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, false);
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    boolean bool = DateFormat.is24HourFormat(BaseApplication.getContext());
    paramLong = System.currentTimeMillis() + paramLong;
    if ((!bool) && (!paramBoolean))
    {
      String str = new SimpleDateFormat("hh:mm").format(new Date(paramLong));
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(paramLong);
      if (((Calendar)localObject).get(9) == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131707656));
        ((StringBuilder)localObject).append(str);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131707664));
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    return new SimpleDateFormat("HH:mm").format(new Date(paramLong));
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel = ((TimeWheelPanel)((View)localObject).findViewById(2131372307));
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a(0, 24, 60, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a(true);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setViewVisibility(0, 8);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setViewVisibility(3, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setScrollerStateListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364275));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365095));
    this.b.setTextColor(getContext().getResources().getColor(2131167097));
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    this.b.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
    this.b.setFocusable(true);
    this.b.setEnabled(false);
    this.b.setTextColor(getContext().getResources().getColor(2131167287));
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      localObject = HardCodeUtil.a(2131707655);
      String str = HardCodeUtil.a(2131707654);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
      this.b.setContentDescription(str);
    }
    a(null, null);
    setOnCancelListener(this);
  }
  
  public void a(long paramLong)
  {
    long l = paramLong;
    if ((int)paramLong % 86400 % 3600 % 60 != 0) {
      l = paramLong + 60L;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel;
    int i = (int)l;
    ((TimeWheelPanel)localObject1).a = (i / 86400);
    i %= 86400;
    ((TimeWheelPanel)localObject1).b = (i / 3600);
    ((TimeWheelPanel)localObject1).c = (i % 3600 / 60);
    ((TimeWheelPanel)localObject1).setValues(true);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707652));
    ((StringBuilder)localObject1).append(a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131707652));
    ((StringBuilder)localObject2).append(a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000, true));
    localObject2 = ((StringBuilder)localObject2).toString();
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setEndTime((String)localObject1, (String)localObject2);
  }
  
  public void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery)
  {
    if (paramNumberWheelView != null) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() == 0)
    {
      this.b.setEnabled(false);
      this.b.setTextColor(getContext().getResources().getColor(2131167287));
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      this.b.setEnabled(true);
      this.b.setTextColor(getContext().getResources().getColor(2131167361));
    }
    paramNumberWheelView = new StringBuilder();
    paramNumberWheelView.append(HardCodeUtil.a(2131707652));
    paramNumberWheelView.append(a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000));
    paramNumberWheelView = paramNumberWheelView.toString();
    paramVerticalGallery = new StringBuilder();
    paramVerticalGallery.append(HardCodeUtil.a(2131707652));
    paramVerticalGallery.append(a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000, true));
    paramVerticalGallery = paramVerticalGallery.toString();
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setEndTime(paramNumberWheelView, paramVerticalGallery);
  }
  
  public void a(AtomicBoolean paramAtomicBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = paramAtomicBoolean;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a(0, 24, 60, 0);
    a(null, null);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364275)
    {
      if (i == 2131365095)
      {
        dismiss();
        long l1 = this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() / 60;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131707652));
        ((StringBuilder)localObject).append(a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000));
        localObject = ((StringBuilder)localObject).toString();
        this.c.setText((CharSequence)localObject);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        long l2 = NetConnInfoCenter.getServerTime();
        long l3 = this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a();
        ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a((int)(l2 + l3), "", "not_disturb_from_notify_push_setting_activity");
        this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a(0, 24, 60, 0);
        a(null, null);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l1);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 1, localStringBuilder.toString(), "0", "", "");
      }
    }
    else
    {
      dismiss();
      onCancel(null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.TimePickDialog
 * JD-Core Version:    0.7.0.1
 */