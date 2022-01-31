package com.tencent.mobileqq.activity.chathistory;

import aerj;
import ajjy;
import akbj;
import akbm;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import atmq;
import atmx;
import atob;
import awqx;
import bbpi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.DatePickerView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class ChatHistoryByDateFragment
  extends IphoneTitleBarFragment
{
  private static String c;
  private atmx jdField_a_of_type_Atmx;
  private atob jdField_a_of_type_Atob;
  public bbpi a;
  public QQAppInterface a;
  public CalendarDay a;
  public DatePickerView a;
  public String a;
  public HashMap<String, Boolean> a;
  public CalendarDay b;
  public String b;
  public CalendarDay c;
  private String d;
  
  static
  {
    jdField_c_of_type_JavaLangString = "ChatHistoryByDateFragment";
  }
  
  public ChatHistoryByDateFragment()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private MessageRecord a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = CalendarDay.dayToTimeMillis(paramInt1, paramInt2, paramInt3) / 1000L;
    long l2 = 86400L + l1;
    Object localObject = akbm.b();
    localObject = String.format("select * from %s m where m.time>=%s and m.time<%s and m.isValid=1 and m.msgtype %s limit 1", new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(l1), Long.valueOf(l2), localObject });
    List localList;
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay != null) && (l2 * 1000L < this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.getTimeInMillis()))
    {
      localList = this.jdField_a_of_type_Atob.a((String)localObject);
      localObject = localList;
      if (localList != null)
      {
        localObject = localList;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "slowtable data:" + localList);
        }
      }
    }
    for (localObject = localList; (localObject != null) && (((List)localObject).size() > 0); localObject = this.jdField_a_of_type_Atmx.a(MessageRecord.class, (String)localObject, null)) {
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
      QLog.i(jdField_c_of_type_JavaLangString, 2, "queryMessageInMonth:" + paramInt1 + "-" + paramInt2);
    }
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryByDateFragment.1(this, paramInt1, paramInt2), 8, null, false);
  }
  
  public int getContentLayoutId()
  {
    return 2131494736;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    super.setTitle(ajjy.a(2131635878));
    Object localObject = getActivity();
    AppInterface localAppInterface;
    if (localObject == null)
    {
      localAppInterface = null;
      if (!(localAppInterface instanceof QQAppInterface)) {
        break label99;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppInterface);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("troop_uin");
      this.d = paramBundle.getString("uin");
      if ((this.jdField_a_of_type_JavaLangString != null) || (this.d != null)) {
        break label119;
      }
      QLog.e(jdField_c_of_type_JavaLangString, 1, "Uin is null");
    }
    label99:
    do
    {
      return;
      localAppInterface = ((FragmentActivity)localObject).getAppInterface();
      break;
      QLog.e(jdField_c_of_type_JavaLangString, 1, "app is null");
    } while (localObject == null);
    ((FragmentActivity)localObject).finish();
    return;
    label119:
    this.jdField_b_of_type_JavaLangString = MessageRecord.getTableName(this.jdField_a_of_type_JavaLangString, 1);
    this.jdField_a_of_type_Atmx = ((atmx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager());
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).b(this.jdField_a_of_type_JavaLangString, 1);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString, 1);
    this.jdField_a_of_type_Atob = ((atob)localAppInterface.getManager(201));
    long l = this.jdField_a_of_type_Atob.b(this.jdField_b_of_type_JavaLangString);
    if (paramBundle != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(paramBundle.time * 1000L);
    }
    if ((paramBundle == null) || (paramBundle.time == 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());
      if ((localObject != null) && (((MessageRecord)localObject).time != 0L)) {
        break label476;
      }
    }
    label476:
    for (this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(System.currentTimeMillis());; this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = new CalendarDay(((MessageRecord)localObject).time * 1000L))
    {
      QLog.i(jdField_c_of_type_JavaLangString, 1, "firstMessage : " + this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay + " lastMssage : " + this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView = ((DatePickerView)this.mContentView.findViewById(2131305958));
      this.jdField_a_of_type_Bbpi = new aerj(this, this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay);
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerDatePickerView.setController(this.jdField_a_of_type_Bbpi);
      a(this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year, this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_date", "date_exp", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryByDateFragment
 * JD-Core Version:    0.7.0.1
 */