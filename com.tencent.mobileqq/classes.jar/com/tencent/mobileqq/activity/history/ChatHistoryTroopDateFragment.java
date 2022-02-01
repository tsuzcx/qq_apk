package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.List;

public class ChatHistoryTroopDateFragment
  extends ChatHistoryBaseFragment
{
  private static String B = "ChatHistoryTroopDateFragment";
  public HashMap<String, Boolean> A = new HashMap();
  private MessageRecordEntityManager C;
  private QSlowTableManager D;
  private String E;
  public String s;
  public QQAppInterface t;
  public DatePickerView u;
  public DatePickerController v;
  public CalendarDay w;
  public CalendarDay x;
  public CalendarDay y;
  public String z;
  
  private MessageRecord a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = CalendarDay.dayToTimeMillis(paramInt1, paramInt2, paramInt3) / 1000L;
    long l2 = 86400L + l1;
    Object localObject1 = UinTypeUtil.a();
    localObject1 = String.format("select * from %s m where m.time>=%s and m.time<%s and m.isValid=1 and m.msgtype %s limit 1", new Object[] { this.z, Long.valueOf(l1), Long.valueOf(l2), localObject1 });
    Object localObject2 = this.y;
    if ((localObject2 != null) && (l2 * 1000L < ((CalendarDay)localObject2).getTimeInMillis()))
    {
      localObject2 = this.D.b((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = B;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("slowtable data:");
          localStringBuilder.append(localObject2);
          QLog.d((String)localObject1, 2, localStringBuilder.toString());
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject1 = this.C.rawQuery(MessageRecord.class, (String)localObject1, null);
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      return (MessageRecord)((List)localObject1).get(0);
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, Boolean paramBoolean)
  {
    HashMap localHashMap = this.A;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localHashMap.put(localStringBuilder.toString(), paramBoolean);
  }
  
  private String b(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramInt2 < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt2);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("");
    }
    String str = ((StringBuilder)localObject).toString();
    if (paramInt3 < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt3);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(str);
    localStringBuilder.append("-");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    Object localObject = this.A;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localObject = (Boolean)((HashMap)localObject).get(localStringBuilder.toString());
    return (localObject != null) && (((Boolean)localObject).booleanValue());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = B;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessageInMonth:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryTroopDateFragment.1(this, paramInt1, paramInt2), 8, null, false);
  }
  
  protected void a(Bundle paramBundle)
  {
    Object localObject2 = getBaseActivity();
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((BaseActivity)localObject2).getAppInterface();
    }
    if ((localObject1 instanceof QQAppInterface))
    {
      this.t = ((QQAppInterface)localObject1);
      this.s = paramBundle.getString("troop_uin");
      this.E = paramBundle.getString("uin");
      if ((this.s == null) && (this.E == null))
      {
        QLog.e(B, 1, "Uin is null");
        return;
      }
      this.z = MessageRecord.getTableName(this.s, 1);
      this.C = ((MessageRecordEntityManager)this.t.getEntityManagerFactory().b());
      paramBundle = this.t.getMessageProxy(1).f(this.s, 1);
      localObject2 = this.t.getMessageFacade().e(this.s, 1);
      this.D = ((QSlowTableManager)((AppInterface)localObject1).getManager(QQManagerFactory.SLOW_TABLE_MANAGER));
      long l = this.D.d(this.z);
      if (paramBundle != null) {
        this.y = new CalendarDay(paramBundle.time * 1000L);
      }
      if ((paramBundle != null) && (paramBundle.time != 0L))
      {
        if ((l != 0L) && (l < paramBundle.time)) {
          this.w = new CalendarDay(l * 1000L);
        } else {
          this.w = this.y;
        }
      }
      else {
        this.w = new CalendarDay(System.currentTimeMillis());
      }
      if ((localObject2 != null) && (((MessageRecord)localObject2).time != 0L)) {
        this.x = new CalendarDay(((MessageRecord)localObject2).time * 1000L);
      } else {
        this.x = new CalendarDay(System.currentTimeMillis());
      }
      paramBundle = B;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("firstMessage : ");
      ((StringBuilder)localObject1).append(this.w);
      ((StringBuilder)localObject1).append(" lastMssage : ");
      ((StringBuilder)localObject1).append(this.x);
      QLog.i(paramBundle, 1, ((StringBuilder)localObject1).toString());
      this.u = ((DatePickerView)this.f.findViewById(2131440287));
      this.v = new ChatHistoryTroopDateFragment.ChatHistoryDatePickerController(this, this.w, this.x);
      this.u.setController(this.v);
      a(this.x.year, this.x.month);
      ReportController.b(this.t, "dc00899", "Grp_chatRecord", "", "chatRecor_date", "date_exp", 0, 0, this.s, "", "", "");
      return;
    }
    QLog.e(B, 1, "app is null");
    if (localObject2 != null) {
      ((BaseActivity)localObject2).finish();
    }
  }
  
  protected void c() {}
  
  protected void d() {}
  
  public void i()
  {
    super.i();
    ReportController.b(this.t, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 6, 0, "", "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626670, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new Intent();
    this.s = g();
    paramView.putExtra("troop_uin", this.s);
    a(paramView.getExtras());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopDateFragment
 * JD-Core Version:    0.7.0.1
 */