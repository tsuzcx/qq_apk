package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.DatePickerController;
import com.tencent.mobileqq.widget.datepicker.DatePickerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.List;

public class ChatHistoryTroopDateFragment
  extends ChatHistoryBaseFragment
{
  private static String d = "ChatHistoryTroopDateFragment";
  private MessageRecordEntityManager jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
  private QSlowTableManager jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager;
  public CalendarDay a;
  public DatePickerController a;
  public DatePickerView a;
  public HashMap<String, Boolean> a;
  public QQAppInterface b;
  public CalendarDay b;
  public String b;
  public CalendarDay c;
  public String c;
  private String e;
  
  public ChatHistoryTroopDateFragment()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private MessageRecord a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = CalendarDay.dayToTimeMillis(paramInt1, paramInt2, paramInt3) / 1000L;
    long l2 = 86400L + l1;
    Object localObject = UinTypeUtil.a();
    localObject = String.format("select * from %s m where m.time>=%s and m.time<%s and m.isValid=1 and m.msgtype %s limit 1", new Object[] { this.jdField_c_of_type_JavaLangString, Long.valueOf(l1), Long.valueOf(l2), localObject });
    List localList;
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay != null) && (l2 * 1000L < this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis()))
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager.a((String)localObject);
      localObject = localList;
      if (localList != null)
      {
        localObject = localList;
        if (QLog.isColorLevel()) {
          QLog.d(d, 2, "slowtable data:" + localList);
        }
      }
    }
    for (localObject = localList; (localObject != null) && (((List)localObject).size() > 0); localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager.rawQuery(MessageRecord.class, (String)localObject, null)) {
      return (MessageRecord)((List)localObject).get(0);
    }
    return null;
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str1;
    if (paramInt2 < 10)
    {
      str1 = "0" + paramInt2;
      if (paramInt3 >= 10) {
        break label113;
      }
    }
    label113:
    for (String str2 = "0" + paramInt3;; str2 = paramInt3 + "")
    {
      return paramInt1 + "-" + str1 + "-" + str2;
      str1 = paramInt2 + "";
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, Boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "-" + paramInt2, paramBoolean);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramInt1 + "-" + paramInt2);
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(d, 2, "queryMessageInMonth:" + paramInt1 + "-" + paramInt2);
    }
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryTroopDateFragment.1(this, paramInt1, paramInt2), 8, null, false);
  }
  
  protected void a(Bundle paramBundle)
  {
    Object localObject = getActivity();
    AppInterface localAppInterface;
    if (localObject == null)
    {
      localAppInterface = null;
      if (!(localAppInterface instanceof QQAppInterface)) {
        break label85;
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppInterface);
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_uin");
      this.e = paramBundle.getString("uin");
      if ((this.jdField_b_of_type_JavaLangString != null) || (this.e != null)) {
        break label105;
      }
      QLog.e(d, 1, "Uin is null");
    }
    label85:
    do
    {
      return;
      localAppInterface = ((FragmentActivity)localObject).getAppInterface();
      break;
      QLog.e(d, 1, "app is null");
    } while (localObject == null);
    ((FragmentActivity)localObject).finish();
    return;
    label105:
    this.jdField_c_of_type_JavaLangString = MessageRecord.getTableName(this.jdField_b_of_type_JavaLangString, 1);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = ((MessageRecordEntityManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().a());
    paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1).b(this.jdField_b_of_type_JavaLangString, 1);
    localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_b_of_type_JavaLangString, 1);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager = ((QSlowTableManager)localAppInterface.getManager(QQManagerFactory.SLOW_TABLE_MANAGER));
    long l = this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager.b(this.jdField_c_of_type_JavaLangString);
    if (paramBundle != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(paramBundle.time * 1000L);
    }
    if ((paramBundle == null) || (paramBundle.time == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
      if ((localObject != null) && (((MessageRecord)localObject).time != 0L)) {
        break label462;
      }
    }
    label462:
    for (this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());; this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(((MessageRecord)localObject).time * 1000L))
    {
      QLog.i(d, 1, "firstMessage : " + this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay + " lastMssage : " + this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView = ((DatePickerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373162));
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController = new ChatHistoryTroopDateFragment.ChatHistoryDatePickerController(this, this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerController);
      a(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_date", "date_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      return;
      if ((l != 0L) && (l < paramBundle.time))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(l * 1000L);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
      break;
    }
  }
  
  protected void b() {}
  
  protected void c() {}
  
  public void e()
  {
    super.e();
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 6, 0, "", "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560737, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new Intent();
    this.jdField_b_of_type_JavaLangString = a();
    paramView.putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
    a(paramView.getExtras());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopDateFragment
 * JD-Core Version:    0.7.0.1
 */