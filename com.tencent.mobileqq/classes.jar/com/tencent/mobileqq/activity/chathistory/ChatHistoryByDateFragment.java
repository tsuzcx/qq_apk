package com.tencent.mobileqq.activity.chathistory;

import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.DatePickerController;
import com.tencent.mobileqq.widget.datepicker.DatePickerView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class ChatHistoryByDateFragment
  extends IphoneTitleBarFragment
{
  private static String j = "ChatHistoryByDateFragment";
  public String a;
  public QQAppInterface b;
  public DatePickerView c;
  public DatePickerController d;
  public CalendarDay e;
  public CalendarDay f;
  public CalendarDay g;
  public String h;
  public HashMap<String, Boolean> i = new HashMap();
  private MessageRecordEntityManager k;
  private QSlowTableManager l;
  private String m;
  
  private MessageRecord a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = CalendarDay.dayToTimeMillis(paramInt1, paramInt2, paramInt3) / 1000L;
    long l2 = 86400L + l1;
    Object localObject1 = UinTypeUtil.a();
    localObject1 = String.format("select * from %s m where m.time>=%s and m.time<%s and m.isValid=1 and m.msgtype %s limit 1", new Object[] { this.h, Long.valueOf(l1), Long.valueOf(l2), localObject1 });
    Object localObject2 = this.g;
    if ((localObject2 != null) && (l2 * 1000L < ((CalendarDay)localObject2).getTimeInMillis()))
    {
      localObject2 = this.l.b((String)localObject1);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = j;
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
      localObject1 = this.k.rawQuery(MessageRecord.class, (String)localObject1, null);
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      return (MessageRecord)((List)localObject1).get(0);
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, Boolean paramBoolean)
  {
    HashMap localHashMap = this.i;
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
    Object localObject = this.i;
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
      String str = j;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryMessageInMonth:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2, Boolean.valueOf(true));
    ThreadManager.post(new ChatHistoryByDateFragment.1(this, paramInt1, paramInt2), 8, null, false);
  }
  
  protected int getContentLayoutId()
  {
    return 2131626670;
  }
  
  protected void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    super.setTitle(HardCodeUtil.a(2131899902));
    Object localObject2 = getBaseActivity();
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((BaseActivity)localObject2).getAppInterface();
    }
    if ((localObject1 instanceof QQAppInterface))
    {
      this.b = ((QQAppInterface)localObject1);
      this.a = paramBundle.getString("troop_uin");
      this.m = paramBundle.getString("uin");
      if ((this.a == null) && (this.m == null))
      {
        QLog.e(j, 1, "Uin is null");
        return;
      }
      this.h = MessageRecord.getTableName(this.a, 1);
      this.k = ((MessageRecordEntityManager)this.b.getEntityManagerFactory().b());
      paramBundle = this.b.getMessageProxy(1).f(this.a, 1);
      localObject2 = this.b.getMessageFacade().e(this.a, 1);
      this.l = ((QSlowTableManager)((AppInterface)localObject1).getManager(QQManagerFactory.SLOW_TABLE_MANAGER));
      long l1 = this.l.d(this.h);
      if (paramBundle != null) {
        this.g = new CalendarDay(paramBundle.time * 1000L);
      }
      if ((paramBundle != null) && (paramBundle.time != 0L))
      {
        if ((l1 != 0L) && (l1 < paramBundle.time)) {
          this.e = new CalendarDay(l1 * 1000L);
        } else {
          this.e = this.g;
        }
      }
      else {
        this.e = new CalendarDay(System.currentTimeMillis());
      }
      if ((localObject2 != null) && (((MessageRecord)localObject2).time != 0L)) {
        this.f = new CalendarDay(((MessageRecord)localObject2).time * 1000L);
      } else {
        this.f = new CalendarDay(System.currentTimeMillis());
      }
      paramBundle = j;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("firstMessage : ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(" lastMssage : ");
      ((StringBuilder)localObject1).append(this.f);
      QLog.i(paramBundle, 1, ((StringBuilder)localObject1).toString());
      this.c = ((DatePickerView)this.mContentView.findViewById(2131440287));
      this.d = new ChatHistoryByDateFragment.ChatHistoryDatePickerController(this, this.e, this.f);
      this.c.setController(this.d);
      a(this.f.year, this.f.month);
      ReportController.b(this.b, "dc00899", "Grp_chatRecord", "", "chatRecor_date", "date_exp", 0, 0, this.a, "", "", "");
      return;
    }
    QLog.e(j, 1, "app is null");
    if (localObject2 != null) {
      ((BaseActivity)localObject2).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.ChatHistoryByDateFragment
 * JD-Core Version:    0.7.0.1
 */