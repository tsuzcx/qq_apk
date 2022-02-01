package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.ip.b;
import com.tencent.luggage.wxa.it.c;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CustomDatePickerNew
  extends FrameLayout
{
  private View a = null;
  private c b;
  private Context c;
  private Date d;
  private Date e;
  private int f;
  private int g;
  private int h;
  private boolean i = true;
  private boolean j = true;
  private boolean k = true;
  private int l;
  private int m;
  private int n;
  private boolean o = false;
  
  public CustomDatePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131952936));
    this.c = paramContext;
    this.b = new c(paramContext);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131952936), paramAttributeSet);
    this.c = paramContext;
    this.b = new c(paramContext);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    this.b = new c(paramContext);
  }
  
  private void a(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    this.f = localCalendar.get(1);
    this.g = (localCalendar.get(2) + 1);
    this.h = localCalendar.get(5);
  }
  
  private void a(List<WheelView> paramList)
  {
    if (paramList.size() == 1)
    {
      ((WheelView)paramList.get(0)).setPadding(0, this.c.getResources().getDimensionPixelSize(2131296336), 0, this.c.getResources().getDimensionPixelSize(2131296336));
      return;
    }
    if (paramList.size() == 2)
    {
      ((WheelView)paramList.get(0)).setPadding(0, this.c.getResources().getDimensionPixelSize(2131296336), this.c.getResources().getDimensionPixelSize(2131296336), this.c.getResources().getDimensionPixelSize(2131296336));
      ((WheelView)paramList.get(1)).setPadding(this.c.getResources().getDimensionPixelSize(2131296336), this.c.getResources().getDimensionPixelSize(2131296336), 0, this.c.getResources().getDimensionPixelSize(2131296336));
      return;
    }
    if (paramList.size() == 3)
    {
      ((WheelView)paramList.get(0)).setPadding(0, this.c.getResources().getDimensionPixelSize(2131296336), this.c.getResources().getDimensionPixelSize(2131296317), this.c.getResources().getDimensionPixelSize(2131296336));
      ((WheelView)paramList.get(1)).setPadding(this.c.getResources().getDimensionPixelSize(2131296317), this.c.getResources().getDimensionPixelSize(2131296336), this.c.getResources().getDimensionPixelSize(2131296317), this.c.getResources().getDimensionPixelSize(2131296336));
      ((WheelView)paramList.get(2)).setPadding(this.c.getResources().getDimensionPixelSize(2131296317), this.c.getResources().getDimensionPixelSize(2131296336), 0, this.c.getResources().getDimensionPixelSize(2131296336));
    }
  }
  
  public String currentValue()
  {
    this.b.i();
    if (this.i) {
      return String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h) });
    }
    if (this.j) {
      return String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(this.f), Integer.valueOf(this.g) });
    }
    return String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(this.f) });
  }
  
  public int getDayOfMonth()
  {
    c localc = this.b;
    if (localc != null) {
      localc.i();
    }
    return this.h;
  }
  
  public int getMonth()
  {
    c localc = this.b;
    if (localc != null) {
      localc.i();
    }
    return this.g;
  }
  
  public View getView()
  {
    if (this.a == null) {
      this.a = this.b.j();
    }
    return this.a;
  }
  
  public int getYear()
  {
    c localc = this.b;
    if (localc != null) {
      localc.i();
    }
    return this.f;
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3)
  {
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramInt3;
    if (this.a == null) {
      this.a = this.b.j();
    }
  }
  
  public void onShow()
  {
    if (this.o) {
      this.l += 1;
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(this.l, this.m - 1, this.n);
    Object localObject2 = Calendar.getInstance();
    if (this.d == null) {
      this.d = new Date(((Calendar)localObject1).getTimeInMillis());
    }
    ((Calendar)localObject2).setTime(this.d);
    Calendar localCalendar1 = Calendar.getInstance();
    if (this.e == null)
    {
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.set(this.l + 100, this.m - 1, this.n);
      this.e = new Date(localCalendar2.getTimeInMillis());
    }
    localCalendar1.setTime(this.e);
    this.b.c(this.o);
    new b(this.c, new CustomDatePickerNew.2(this)).a(new CustomDatePickerNew.1(this)).a(false).a(new boolean[] { this.k, this.j, this.i, false, false, false }).a((Calendar)localObject1).a((Calendar)localObject2, localCalendar1).b(this.c.getResources().getDimensionPixelSize(2131296339)).a(this.b);
    this.b.a(this.c.getResources().getDimensionPixelSize(2131296955));
    this.b.b(this.c.getResources().getDimensionPixelSize(2131296339));
    this.b.d(this.o);
    this.b.c(ContextCompat.getColor(this.c, 2131165199));
    this.b.a(0, this.c.getResources().getDimensionPixelSize(2131296336), 0, this.c.getResources().getDimensionPixelSize(2131296336));
    localObject1 = this.b.k().iterator();
    int i1 = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WheelView)((Iterator)localObject1).next();
      if ((this.o) && (this.l == 2) && (i1 > 0)) {
        ((WheelView)localObject2).b(0).a(this.c.getResources().getDimensionPixelSize(2131296336)).setBackgroundColor(ContextCompat.getColor(this.c, 2131165193));
      } else {
        ((WheelView)localObject2).b(ContextCompat.getColor(this.c, 2131165207)).a(this.c.getResources().getDimensionPixelSize(2131296336)).setBackgroundColor(ContextCompat.getColor(this.c, 2131165193));
      }
      i1 += 1;
    }
    a(this.b.k());
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setMaxDate(Long paramLong)
  {
    this.e = new Date(paramLong.longValue());
  }
  
  public void setMinDate(Long paramLong)
  {
    this.d = new Date(paramLong.longValue());
  }
  
  public void setPickersEnable(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.i = paramBoolean3;
    this.j = paramBoolean2;
    this.k = paramBoolean1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePickerNew
 * JD-Core Version:    0.7.0.1
 */