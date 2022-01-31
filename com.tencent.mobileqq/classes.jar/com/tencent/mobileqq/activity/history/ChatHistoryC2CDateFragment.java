package com.tencent.mobileqq.activity.history;

import aflb;
import afld;
import ajmp;
import ajmr;
import akbj;
import akbm;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import atmq;
import atmx;
import atob;
import awqx;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.DatePickerView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class ChatHistoryC2CDateFragment
  extends ChatHistoryBaseFragment
{
  private static String b;
  private int jdField_a_of_type_Int;
  public afld a;
  private ajmp jdField_a_of_type_Ajmp;
  ajmr jdField_a_of_type_Ajmr = new aflb(this);
  private atmx jdField_a_of_type_Atmx;
  private atob jdField_a_of_type_Atob;
  public CalendarDay a;
  public DatePickerView a;
  public HashMap<String, Boolean> a;
  public QQAppInterface b;
  public CalendarDay b;
  public CalendarDay c;
  private String c;
  private CalendarDay jdField_d_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  private String e;
  
  static
  {
    jdField_b_of_type_JavaLangString = "Q.history.C2CDateFragment";
  }
  
  public ChatHistoryC2CDateFragment()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_Boolean = false;
  }
  
  private MessageRecord a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = CalendarDay.dayToTimeMillis(paramInt1, paramInt2, paramInt3) / 1000L;
    long l2 = l1 + 86400L;
    Object localObject1 = null;
    Object localObject2 = akbm.b();
    localObject2 = String.format("select * from %s m where m.time>=%s and m.time<%s and m.isValid=1 and m.msgtype %s limit 1", new Object[] { this.e, Long.valueOf(l1), Long.valueOf(l2), localObject2 });
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay != null) && (1000L * l2 < this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis())) {
      if (this.jdField_a_of_type_Atob != null)
      {
        localObject2 = this.jdField_a_of_type_Atob.a((String)localObject2);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "slowtable data:" + localObject2);
            localObject1 = localObject2;
          }
        }
      }
    }
    while ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      return (MessageRecord)((List)localObject1).get(0);
      if (this.jdField_a_of_type_Atmx != null) {
        localObject1 = this.jdField_a_of_type_Atmx.a(MessageRecord.class, (String)localObject2, null);
      }
    }
    return null;
  }
  
  private void a()
  {
    this.e = MessageRecord.getTableName(this.jdField_c_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Atmx = ((atmx)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager());
    MessageRecord localMessageRecord = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b(this.jdField_c_of_type_JavaLangString, 0);
    QQMessageFacade.Message localMessage = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_c_of_type_JavaLangString, 0);
    this.jdField_a_of_type_Atob = ((atob)getActivity().app.getManager(201));
    long l = this.jdField_a_of_type_Atob.b(this.e);
    if (localMessageRecord != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(localMessageRecord.time * 1000L);
    }
    if ((localMessageRecord == null) || (localMessageRecord.time == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
    }
    while ((localMessage == null) || (localMessage.time == 0L))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
      return;
      if ((l != 0L) && (l < localMessageRecord.time)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(l * 1000L);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(localMessage.time * 1000L);
  }
  
  private void a(int paramInt1, int paramInt2, Boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt1 + "-" + paramInt2, paramBoolean);
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
    BitSet localBitSet = ((ajmp)getActivity().app.getManager(92)).b(localCalendar, paramCalendar);
    int i = 0;
    localCalendar = (Calendar)localCalendar.clone();
    ArrayList localArrayList = new ArrayList(31);
    while ((localCalendar.before(paramCalendar)) || (localCalendar.equals(paramCalendar)))
    {
      if (localBitSet.get(i))
      {
        MessageRecord localMessageRecord = new MessageRecord();
        localMessageRecord.time = (localCalendar.getTimeInMillis() / 1000L);
        localArrayList.add(localMessageRecord);
      }
      localCalendar.add(5, 1);
      i += 1;
    }
    if (localArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.a(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month, localArrayList);
    }
    a(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month, Boolean.valueOf(true));
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramInt1 + "-" + paramInt2);
    return (localBoolean != null) && (localBoolean.booleanValue());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryC2CDateFragment.1(this, paramInt1, paramInt2), 8, null, false);
  }
  
  protected void a(Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    AppInterface localAppInterface;
    if (localFragmentActivity == null)
    {
      localAppInterface = null;
      if (!(localAppInterface instanceof QQAppInterface)) {
        break label79;
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppInterface);
      this.jdField_a_of_type_Ajmp = ((ajmp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92));
      this.jdField_c_of_type_JavaLangString = paramBundle.getString("uin");
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label98;
      }
      QLog.e(jdField_b_of_type_JavaLangString, 1, "Uin is null");
    }
    label79:
    do
    {
      return;
      localAppInterface = localFragmentActivity.getAppInterface();
      break;
      QLog.e(jdField_b_of_type_JavaLangString, 1, "app is null");
    } while (localFragmentActivity == null);
    localFragmentActivity.finish();
    return;
    label98:
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("uinname");
    a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView = ((DatePickerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305958));
    QLog.i(jdField_b_of_type_JavaLangString, 1, "firstMessage : " + this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay + " lastMssage : " + this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
    this.jdField_a_of_type_Afld = new afld(this, this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.setController(this.jdField_a_of_type_Afld);
  }
  
  boolean a()
  {
    CalendarDay localCalendarDay1 = this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
    CalendarDay localCalendarDay2 = this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
    Calendar localCalendar = this.jdField_a_of_type_Ajmp.b();
    if ((localCalendar != null) && (this.jdField_a_of_type_Ajmp.a()))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(localCalendar.getTimeInMillis());
      this.jdField_d_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, new Object[] { "initStartEndDate ", this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.toString(), " ", this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.toString() });
      }
      if ((localCalendarDay1 != null) && (localCalendarDay2 != null)) {
        break label137;
      }
    }
    label137:
    while ((localCalendarDay1 != null) && (localCalendarDay1.getTimeInMillis() != this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis()) && (localCalendarDay2 != null) && (localCalendarDay2.getTimeInMillis() != this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis()))
    {
      return true;
      a();
      this.jdField_d_of_type_Boolean = false;
      break;
    }
    return false;
  }
  
  protected void b() {}
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "queryLocalMessageInMonth:" + paramInt1 + "-" + paramInt2);
    }
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryC2CDateFragment.2(this, paramInt1, paramInt2), 8, null, false);
  }
  
  protected void c() {}
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Ajmp.a(this.jdField_a_of_type_Ajmr);
    boolean bool = a();
    if (bool)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_Afld.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
    }
    if (this.jdField_d_of_type_Boolean) {
      a(this.jdField_a_of_type_Ajmp.b());
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.getAdapter().notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.scrollToPosition(this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.getAdapter().getItemCount() - 1);
      }
      awqx.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 6, 0, "", "", "", "");
      return;
      b(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month);
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_Ajmp.b(this.jdField_a_of_type_Ajmr);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131494736, paramViewGroup, false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(getActivity().getIntent().getExtras());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment
 * JD-Core Version:    0.7.0.1
 */