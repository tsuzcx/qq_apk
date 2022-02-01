package com.tencent.mobileqq.activity.aio.upcoming;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.widget.ActionSheet;
import java.util.Calendar;
import java.util.Date;

public class UpcomingTimeSelector
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected long e;
  UpcomingTimeSelector.TimeAdapter f = new UpcomingTimeSelector.TimeAdapter(this);
  protected Context g;
  private TimeSelectView h;
  private ActionSheet i;
  private UpcomingTimeSelector.IOnTimeSelected j;
  private int k;
  
  UpcomingTimeSelector(Context paramContext)
  {
    this.g = paramContext;
    this.h = ((TimeSelectView)LayoutInflater.from(paramContext).inflate(2131627483, null));
    this.h.a(this.f);
    this.i = ActionSheet.createMenuSheet(paramContext);
    this.i.setCloseAutoRead(true);
    this.i.setActionContentView(this.h, null);
    this.h.setPickListener(new UpcomingTimeSelector.1(this));
    b();
  }
  
  private int a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.a);
    localCalendar.set(6, this.b);
    localCalendar.set(11, this.c);
    localCalendar.set(12, this.d);
    long l = (paramLong - localCalendar.getTimeInMillis()) / 86400000L;
    localCalendar.setTime(new Date(paramLong));
    if (l < 0L) {
      return 0;
    }
    if (l == 0L) {
      return 1;
    }
    if (l <= 7L) {
      return 2;
    }
    if (localCalendar.get(1) == this.a) {
      return 3;
    }
    return 4;
  }
  
  private void b()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(l));
    this.a = localCalendar.get(1);
    this.b = localCalendar.get(6);
    this.c = localCalendar.get(11);
    this.d = localCalendar.get(12);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.h.setSelection(paramInt1, paramInt2);
    if (paramInt1 == 0)
    {
      this.h.a(1);
      return;
    }
    this.h.a(0);
  }
  
  private void b(int paramInt, Calendar paramCalendar)
  {
    int m = this.h.b(1);
    if ((paramInt == 0) && (this.c < 23))
    {
      c(m, paramCalendar);
      return;
    }
    paramCalendar.set(12, 0);
    paramCalendar.set(11, m);
  }
  
  private void c()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(l));
    if (this.c < 23)
    {
      localCalendar.add(12, 30);
    }
    else
    {
      localCalendar.add(6, 1);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
    }
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.e = localCalendar.getTimeInMillis();
    b(0, 0);
    b(1, 0);
  }
  
  private void c(int paramInt, Calendar paramCalendar)
  {
    if (paramInt == 0)
    {
      paramCalendar.add(12, 30);
      return;
    }
    if (paramInt <= 3)
    {
      paramCalendar.add(11, paramInt);
      return;
    }
    paramCalendar.add(11, paramInt);
    paramCalendar.set(12, 0);
  }
  
  protected int a()
  {
    int m = this.c;
    if (m >= 20) {
      return 4;
    }
    return 24 - m;
  }
  
  protected String a(int paramInt, Calendar paramCalendar)
  {
    int m = paramCalendar.get(1);
    int n = this.a;
    Object localObject = "";
    if (m != n)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramCalendar.get(1));
      ((StringBuilder)localObject).append(this.g.getString(2131918206));
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramCalendar.get(2) + 1);
    localStringBuilder.append(this.g.getString(2131891839));
    localStringBuilder.append(paramCalendar.get(5));
    localStringBuilder.append(this.g.getString(2131888405));
    localObject = localStringBuilder.toString();
    m = paramInt;
    if (this.c >= 23) {
      m = paramInt + 1;
    }
    if (m == 0) {
      return this.g.getString(2131917319);
    }
    if (m == 1)
    {
      paramCalendar = new StringBuilder();
      paramCalendar.append((String)localObject);
      paramCalendar.append(" ");
      paramCalendar.append(this.g.getString(2131917321));
      return paramCalendar.toString();
    }
    if (m == 2)
    {
      paramCalendar = new StringBuilder();
      paramCalendar.append((String)localObject);
      paramCalendar.append(" ");
      paramCalendar.append(this.g.getString(2131886430));
      return paramCalendar.toString();
    }
    if (m <= 7)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(DateUtils.a(paramCalendar.get(7)));
      return localStringBuilder.toString();
    }
    return localObject;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
    b();
    c();
    this.i.show();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.a);
    localCalendar.set(6, this.b);
    localCalendar.set(11, this.c);
    localCalendar.set(12, this.d);
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1)
      {
        if (this.c < 23) {
          paramInt1 = this.h.b(0);
        } else {
          paramInt1 = this.h.b(0) + 1;
        }
        localCalendar.add(6, paramInt1);
        if ((this.h.b(0) == 0) && (this.c < 23))
        {
          c(paramInt2, localCalendar);
        }
        else
        {
          localCalendar.set(12, 0);
          localCalendar.set(11, paramInt2);
        }
      }
    }
    else
    {
      if (this.c < 23) {
        paramInt1 = paramInt2;
      } else {
        paramInt1 = paramInt2 + 1;
      }
      localCalendar.add(6, paramInt1);
      b(paramInt2, localCalendar);
    }
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.e = localCalendar.getTimeInMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("year: ");
      localStringBuilder.append(localCalendar.get(1));
      localStringBuilder.append("\nmonth: ");
      localStringBuilder.append(localCalendar.get(2));
      localStringBuilder.append("\nday: ");
      localStringBuilder.append(localCalendar.get(5));
      localStringBuilder.append("\ntimeStamp: ");
      localStringBuilder.append(this.e);
      QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, localStringBuilder.toString());
    }
  }
  
  void a(UpcomingTimeSelector.IOnTimeSelected paramIOnTimeSelected)
  {
    this.j = paramIOnTimeSelected;
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 0) {
      return String.format(this.g.getString(2131886606), new Object[] { Integer.valueOf(30) });
    }
    if ((paramInt > 0) && (paramInt <= 3)) {
      return String.format(this.g.getString(2131886603), new Object[] { Integer.valueOf(paramInt) });
    }
    if ((paramInt > 3) && (paramInt < a()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c + paramInt);
      localStringBuilder.append(this.g.getString(2131892240));
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpcomingTimeSelector
 * JD-Core Version:    0.7.0.1
 */