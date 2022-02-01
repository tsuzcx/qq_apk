package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.MessageRoamManager.MessageRoamListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.DatePickerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class ChatHistoryC2CDateFragment
  extends ChatHistoryBaseFragment
{
  private static String b = "Q.history.C2CDateFragment";
  private int jdField_a_of_type_Int;
  public ChatHistoryC2CDateFragment.ChatHistoryDatePickerController a;
  MessageRoamManager.MessageRoamListener jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager$MessageRoamListener = new ChatHistoryC2CDateFragment.3(this);
  private MessageRoamManager jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
  private MessageRecordEntityManager jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
  private QSlowTableManager jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager;
  public CalendarDay a;
  public DatePickerView a;
  public HashMap<String, Boolean> a;
  public QQAppInterface b;
  public CalendarDay b;
  public CalendarDay c;
  private String c;
  private CalendarDay jdField_d_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  private String e;
  
  public ChatHistoryC2CDateFragment()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private MessageRecord a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = CalendarDay.dayToTimeMillis(paramInt1, paramInt2, paramInt3) / 1000L;
    long l2 = 86400L + l1;
    Object localObject1 = UinTypeUtil.a();
    localObject1 = String.format("select * from %s m where m.time>=%s and m.time<%s and m.isValid=1 and m.msgtype %s limit 1", new Object[] { this.e, Long.valueOf(l1), Long.valueOf(l2), localObject1 });
    Object localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
    if ((localObject2 != null) && (l2 * 1000L < ((CalendarDay)localObject2).getTimeInMillis()))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager;
      if (localObject2 != null)
      {
        localObject2 = ((QSlowTableManager)localObject2).a((String)localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label206;
        }
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break label206;
        }
        localObject1 = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("slowtable data:");
        localStringBuilder.append(localObject2);
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
        localObject1 = localObject2;
        break label206;
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
      if (localObject2 != null)
      {
        localObject1 = ((MessageRecordEntityManager)localObject2).rawQuery(MessageRecord.class, (String)localObject1, null);
        break label206;
      }
    }
    localObject1 = null;
    label206:
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      return (MessageRecord)((List)localObject1).get(0);
    }
    return null;
  }
  
  private void a()
  {
    this.e = MessageRecord.getTableName(this.jdField_c_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = ((MessageRecordEntityManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().a());
    MessageRecord localMessageRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(0).b(this.jdField_c_of_type_JavaLangString, 0);
    Message localMessage = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_c_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager = ((QSlowTableManager)getBaseActivity().app.getManager(QQManagerFactory.SLOW_TABLE_MANAGER));
    long l = this.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager.b(this.e);
    if (localMessageRecord != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(localMessageRecord.time * 1000L);
    }
    if ((localMessageRecord != null) && (localMessageRecord.time != 0L))
    {
      if ((l != 0L) && (l < localMessageRecord.time)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(l * 1000L);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
    }
    if ((localMessage != null) && (localMessage.time != 0L))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(localMessage.time * 1000L);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
  }
  
  private void a(int paramInt1, int paramInt2, Boolean paramBoolean)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localHashMap.put(localStringBuilder.toString(), paramBoolean);
  }
  
  private void a(Calendar paramCalendar)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(paramCalendar.getTimeInMillis());
    paramCalendar = new CalendarDay(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month, 1);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramCalendar.getTimeInMillis());
    paramCalendar = Calendar.getInstance();
    paramCalendar.setTimeInMillis(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis());
    BitSet localBitSet = ((MessageRoamManager)getBaseActivity().app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).b(localCalendar, paramCalendar);
    localCalendar = (Calendar)localCalendar.clone();
    ArrayList localArrayList = new ArrayList(31);
    int i = 0;
    for (;;)
    {
      if ((!localCalendar.before(paramCalendar)) && (!localCalendar.equals(paramCalendar)))
      {
        if (localArrayList.size() > 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.a(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month, localArrayList);
        }
        a(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month, Boolean.valueOf(true));
        return;
      }
      if (localBitSet.get(i))
      {
        MessageRecord localMessageRecord = new MessageRecord();
        localMessageRecord.time = (localCalendar.getTimeInMillis() / 1000L);
        localArrayList.add(localMessageRecord);
      }
      localCalendar.add(5, 1);
      i += 1;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localObject = (Boolean)((HashMap)localObject).get(localStringBuilder.toString());
    return (localObject != null) && (((Boolean)localObject).booleanValue());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryC2CDateFragment.1(this, paramInt1, paramInt2), 8, null, false);
  }
  
  protected void a(Bundle paramBundle)
  {
    BaseActivity localBaseActivity = getBaseActivity();
    Object localObject;
    if (localBaseActivity == null) {
      localObject = null;
    } else {
      localObject = localBaseActivity.getAppInterface();
    }
    if ((localObject instanceof QQAppInterface))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager = ((MessageRoamManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER));
      this.jdField_c_of_type_JavaLangString = paramBundle.getString("uin");
      if (this.jdField_c_of_type_JavaLangString == null)
      {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "Uin is null");
        return;
      }
      this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
      this.jdField_d_of_type_JavaLangString = paramBundle.getString("uinname");
      a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView = ((DatePickerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372740));
      paramBundle = jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("firstMessage : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
      ((StringBuilder)localObject).append(" lastMssage : ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
      QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment$ChatHistoryDatePickerController = new ChatHistoryC2CDateFragment.ChatHistoryDatePickerController(this, this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.setController(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment$ChatHistoryDatePickerController);
      return;
    }
    QLog.e(jdField_b_of_type_JavaLangString, 1, "app is null");
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  boolean a()
  {
    CalendarDay localCalendarDay1 = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
    CalendarDay localCalendarDay2 = this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
    Calendar localCalendar = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
    if ((localCalendar != null) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a()))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(localCalendar.getTimeInMillis());
      this.jdField_d_of_type_Boolean = true;
    }
    else
    {
      a();
      this.jdField_d_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, new Object[] { "initStartEndDate ", this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.toString(), " ", this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.toString() });
    }
    if (localCalendarDay1 != null)
    {
      if (localCalendarDay2 == null) {
        return true;
      }
      return (localCalendarDay1 != null) && (localCalendarDay1.getTimeInMillis() != this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis()) && (localCalendarDay2 != null) && (localCalendarDay2.getTimeInMillis() != this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis());
    }
    return true;
  }
  
  protected void b() {}
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryLocalMessageInMonth:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryC2CDateFragment.2(this, paramInt1, paramInt2), 8, null, false);
  }
  
  protected void c() {}
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager$MessageRoamListener);
    boolean bool = a();
    if (bool)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CDateFragment$ChatHistoryDatePickerController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
    }
    if (this.jdField_d_of_type_Boolean) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b());
    } else {
      b(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.getAdapter().notifyDataSetChanged();
      DatePickerView localDatePickerView = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView;
      localDatePickerView.scrollToPosition(localDatePickerView.getAdapter().getItemCount() - 1);
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 6, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager$MessageRoamListener);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560625, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a(getBaseActivity().getIntent().getExtras());
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment
 * JD-Core Version:    0.7.0.1
 */