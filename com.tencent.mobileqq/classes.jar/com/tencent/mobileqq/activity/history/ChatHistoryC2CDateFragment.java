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
  private static String B = "Q.history.C2CDateFragment";
  MessageRoamManager.MessageRoamListener A = new ChatHistoryC2CDateFragment.3(this);
  private MessageRecordEntityManager C;
  private QSlowTableManager D;
  private MessageRoamManager E;
  private String F;
  private int G;
  private String H;
  private String I;
  private CalendarDay J;
  public QQAppInterface s;
  public DatePickerView t;
  public ChatHistoryC2CDateFragment.ChatHistoryDatePickerController u;
  public CalendarDay v;
  public CalendarDay w;
  public CalendarDay x;
  public HashMap<String, Boolean> y = new HashMap();
  boolean z = false;
  
  private MessageRecord a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = CalendarDay.dayToTimeMillis(paramInt1, paramInt2, paramInt3) / 1000L;
    long l2 = 86400L + l1;
    Object localObject1 = UinTypeUtil.a();
    localObject1 = String.format("select * from %s m where m.time>=%s and m.time<%s and m.isValid=1 and m.msgtype %s limit 1", new Object[] { this.I, Long.valueOf(l1), Long.valueOf(l2), localObject1 });
    Object localObject2 = this.x;
    if ((localObject2 != null) && (l2 * 1000L < ((CalendarDay)localObject2).getTimeInMillis()))
    {
      localObject2 = this.D;
      if (localObject2 != null)
      {
        localObject2 = ((QSlowTableManager)localObject2).b((String)localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label206;
        }
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break label206;
        }
        localObject1 = B;
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
      localObject2 = this.C;
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
  
  private void a(int paramInt1, int paramInt2, Boolean paramBoolean)
  {
    HashMap localHashMap = this.y;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localHashMap.put(localStringBuilder.toString(), paramBoolean);
  }
  
  private void a(Calendar paramCalendar)
  {
    this.w = new CalendarDay(System.currentTimeMillis());
    this.v = new CalendarDay(paramCalendar.getTimeInMillis());
    paramCalendar = new CalendarDay(this.w.year, this.w.month, 1);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramCalendar.getTimeInMillis());
    paramCalendar = Calendar.getInstance();
    paramCalendar.setTimeInMillis(this.w.getTimeInMillis());
    BitSet localBitSet = ((MessageRoamManager)getBaseActivity().app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).b(localCalendar, paramCalendar);
    localCalendar = (Calendar)localCalendar.clone();
    ArrayList localArrayList = new ArrayList(31);
    int i = 0;
    for (;;)
    {
      if ((!localCalendar.before(paramCalendar)) && (!localCalendar.equals(paramCalendar)))
      {
        if (localArrayList.size() > 0) {
          this.t.a(this.w.year, this.w.month, localArrayList);
        }
        a(this.w.year, this.w.month, Boolean.valueOf(true));
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
  
  private boolean c(int paramInt1, int paramInt2)
  {
    Object localObject = this.y;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localObject = (Boolean)((HashMap)localObject).get(localStringBuilder.toString());
    return (localObject != null) && (((Boolean)localObject).booleanValue());
  }
  
  private void v()
  {
    this.I = MessageRecord.getTableName(this.F, 0);
    this.C = ((MessageRecordEntityManager)this.s.getEntityManagerFactory().b());
    MessageRecord localMessageRecord = this.s.getMessageProxy(0).f(this.F, 0);
    Message localMessage = this.s.getMessageFacade().e(this.F, 0);
    this.D = ((QSlowTableManager)getBaseActivity().app.getManager(QQManagerFactory.SLOW_TABLE_MANAGER));
    long l = this.D.d(this.I);
    if (localMessageRecord != null) {
      this.x = new CalendarDay(localMessageRecord.time * 1000L);
    }
    if ((localMessageRecord != null) && (localMessageRecord.time != 0L))
    {
      if ((l != 0L) && (l < localMessageRecord.time)) {
        this.v = new CalendarDay(l * 1000L);
      } else {
        this.v = this.x;
      }
    }
    else {
      this.v = new CalendarDay(System.currentTimeMillis());
    }
    if ((localMessage != null) && (localMessage.time != 0L))
    {
      this.w = new CalendarDay(localMessage.time * 1000L);
      return;
    }
    this.w = new CalendarDay(System.currentTimeMillis());
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
      this.s = ((QQAppInterface)localObject);
      this.E = ((MessageRoamManager)this.s.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER));
      this.F = paramBundle.getString("uin");
      if (this.F == null)
      {
        QLog.e(B, 1, "Uin is null");
        return;
      }
      this.G = paramBundle.getInt("uintype");
      this.H = paramBundle.getString("uinname");
      a();
      this.t = ((DatePickerView)this.f.findViewById(2131440287));
      paramBundle = B;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("firstMessage : ");
      ((StringBuilder)localObject).append(this.v);
      ((StringBuilder)localObject).append(" lastMssage : ");
      ((StringBuilder)localObject).append(this.w);
      QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
      this.u = new ChatHistoryC2CDateFragment.ChatHistoryDatePickerController(this, this.v, this.w);
      this.t.setController(this.u);
      return;
    }
    QLog.e(B, 1, "app is null");
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  boolean a()
  {
    CalendarDay localCalendarDay1 = this.v;
    CalendarDay localCalendarDay2 = this.w;
    Calendar localCalendar = this.E.f();
    if ((localCalendar != null) && (this.E.a()))
    {
      this.w = new CalendarDay(System.currentTimeMillis());
      this.v = new CalendarDay(localCalendar.getTimeInMillis());
      this.z = true;
    }
    else
    {
      v();
      this.z = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(B, 2, new Object[] { "initStartEndDate ", this.v.toString(), " ", this.w.toString() });
    }
    if (localCalendarDay1 != null)
    {
      if (localCalendarDay2 == null) {
        return true;
      }
      return (localCalendarDay1 != null) && (localCalendarDay1.getTimeInMillis() != this.v.getTimeInMillis()) && (localCalendarDay2 != null) && (localCalendarDay2.getTimeInMillis() != this.w.getTimeInMillis());
    }
    return true;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = B;
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
  
  protected void d() {}
  
  public void i()
  {
    super.i();
    this.E.a(this.A);
    boolean bool = a();
    if (bool)
    {
      this.y.clear();
      this.u.a(this.v, this.w);
    }
    if (this.z) {
      a(this.E.f());
    } else {
      b(this.w.year, this.w.month);
    }
    if (bool)
    {
      this.t.getAdapter().notifyDataSetChanged();
      DatePickerView localDatePickerView = this.t;
      localDatePickerView.scrollToPosition(localDatePickerView.getAdapter().getItemCount() - 1);
    }
    ReportController.b(this.s, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 6, 0, "", "", "", "");
  }
  
  public void j()
  {
    super.j();
    this.E.b(this.A);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626670, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.f = paramView;
    a(getBaseActivity().getIntent().getExtras());
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment
 * JD-Core Version:    0.7.0.1
 */