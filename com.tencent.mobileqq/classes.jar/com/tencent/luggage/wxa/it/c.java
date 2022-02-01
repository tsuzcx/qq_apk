package com.tencent.luggage.wxa.it;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class c
  extends a
  implements View.OnClickListener
{
  private e d;
  private Context e;
  private String f = "TimePickerView";
  private boolean g = false;
  
  public c(Context paramContext)
  {
    super(paramContext);
    this.d = new e(paramContext);
    this.e = paramContext;
  }
  
  private void a(Context paramContext)
  {
    g();
    a();
    b();
    LayoutInflater.from(paramContext).inflate(2131625447, this.a);
    TextView localTextView = (TextView)a(2131448241);
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131445218);
    Button localButton1 = (Button)a(2131429784);
    Button localButton2 = (Button)a(2131429763);
    localButton1.setTag("submit");
    localButton2.setTag("cancel");
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    String str;
    if (TextUtils.isEmpty(this.b.F)) {
      str = paramContext.getResources().getString(2131892621);
    } else {
      str = this.b.F;
    }
    localButton1.setText(str);
    if (TextUtils.isEmpty(this.b.G)) {
      paramContext = paramContext.getResources().getString(2131892615);
    } else {
      paramContext = this.b.G;
    }
    localButton2.setText(paramContext);
    if (TextUtils.isEmpty(this.b.H)) {
      paramContext = "";
    } else {
      paramContext = this.b.H;
    }
    localTextView.setText(paramContext);
    localButton1.setTextColor(this.b.I);
    localButton2.setTextColor(this.b.J);
    localTextView.setTextColor(this.b.K);
    localRelativeLayout.setBackgroundColor(this.b.M);
    localButton1.setTextSize(this.b.N);
    localButton2.setTextSize(this.b.N);
    localTextView.setTextSize(this.b.O);
    l();
  }
  
  private void l()
  {
    this.d.a(null, this.b.j, this.b.D);
    if (this.b.c != null) {
      this.d.a(new c.1(this));
    }
    if ((this.b.n != 0) && (this.b.o != 0) && (this.b.n <= this.b.o)) {
      m();
    }
    if ((this.b.l != null) && (this.b.m != null))
    {
      if (this.b.l.getTimeInMillis() > this.b.m.getTimeInMillis())
      {
        com.tencent.mm.ui.f.e(this.f, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
        this.b.l = null;
      }
    }
    else if (this.b.l != null)
    {
      if (this.b.l.get(1) < 1900)
      {
        com.tencent.mm.ui.f.e(this.f, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
        this.b.l = null;
      }
    }
    else if ((this.b.m != null) && (this.b.m.get(1) > 2100))
    {
      com.tencent.mm.ui.f.e(this.f, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
      this.b.l = null;
    }
    n();
    p();
    if (this.e.getResources().getConfiguration().locale.getLanguage().endsWith("zh")) {
      this.d.a(this.b.p, this.b.q, this.b.r, this.b.s, this.b.t, this.b.u);
    }
    this.d.b(this.b.v, this.b.w, this.b.x, this.b.y, this.b.z, this.b.A);
    b(this.b.T);
    this.d.c(this.b.P);
    this.d.a(this.b.W);
    this.d.c(this.b.h);
    this.d.a(this.b.R);
    this.d.d(this.b.U);
    this.d.d(this.b.X);
  }
  
  private void m()
  {
    this.d.a(this.b.n);
    this.d.b(this.b.o);
  }
  
  private void n()
  {
    this.d.a(this.b.l, this.b.m);
    o();
  }
  
  private void o()
  {
    if (this.g) {
      return;
    }
    if ((this.b.l != null) && (this.b.m != null))
    {
      if ((this.b.k != null) && (this.b.k.getTimeInMillis() >= this.b.l.getTimeInMillis()))
      {
        if (this.b.k.getTimeInMillis() > this.b.m.getTimeInMillis()) {
          this.b.k = this.b.m;
        }
      }
      else {
        this.b.k = this.b.l;
      }
    }
    else
    {
      if (this.b.l != null)
      {
        this.b.k = this.b.l;
        return;
      }
      if (this.b.m != null) {
        this.b.k = this.b.m;
      }
    }
  }
  
  private void p()
  {
    int i1;
    int n;
    int m;
    int k;
    int j;
    int i;
    if (this.b.k == null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(System.currentTimeMillis());
      i1 = localCalendar.get(1);
      n = localCalendar.get(2);
      m = localCalendar.get(5);
      k = localCalendar.get(11);
      j = localCalendar.get(12);
      i = localCalendar.get(13);
    }
    else
    {
      i1 = this.b.k.get(1);
      n = this.b.k.get(2);
      m = this.b.k.get(5);
      k = this.b.k.get(11);
      j = this.b.k.get(12);
      i = this.b.k.get(13);
    }
    this.d.a(i1, n, m, k, j, i);
  }
  
  public void a(float paramFloat)
  {
    e locale = this.d;
    if (locale != null) {
      locale.b(paramFloat);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(com.tencent.luggage.wxa.iq.a parama)
  {
    this.b = parama;
    a(parama.E);
  }
  
  public void b(int paramInt)
  {
    this.d.d(paramInt);
  }
  
  public void c(int paramInt)
  {
    this.d.c(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
    e locale = this.d;
    if (locale != null) {
      locale.a(paramBoolean);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    e locale = this.d;
    if (locale != null) {
      locale.b(paramBoolean);
    }
  }
  
  public boolean h()
  {
    return this.b.S;
  }
  
  public void i()
  {
    if (this.b.b != null) {
      try
      {
        Date localDate = e.a.parse(this.d.b());
        this.b.b.onTimeSelect(localDate);
        return;
      }
      catch (ParseException localParseException)
      {
        com.tencent.mm.ui.f.a(this.f, localParseException, "", new Object[0]);
      }
    }
  }
  
  public View j()
  {
    if (this.d.c() == null)
    {
      View localView = LayoutInflater.from(this.e).inflate(2131625447, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131447398);
      ((ViewGroup)localView).removeView(localLinearLayout);
      localLinearLayout.setBackgroundColor(-1);
      this.d.a(localLinearLayout);
    }
    return this.d.c();
  }
  
  public List<WheelView> k()
  {
    return this.d.a();
  }
  
  public void onClick(View paramView)
  {
    if (((String)paramView.getTag()).equals("submit")) {
      i();
    }
    e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.c
 * JD-Core Version:    0.7.0.1
 */