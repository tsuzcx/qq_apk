package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.ip.b;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AppBrandDatePickerV2
  implements com.tencent.luggage.wxa.lo.c<String>
{
  private View a = null;
  private com.tencent.luggage.wxa.it.c b;
  private Context c;
  private Date d;
  private Date e;
  private int f;
  private int g;
  private int h;
  private boolean i;
  private boolean j;
  
  @Keep
  AppBrandDatePickerV2(Context paramContext)
  {
    this.c = paramContext;
    this.b = new com.tencent.luggage.wxa.it.c(paramContext);
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
  
  public String a()
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.i = paramBoolean3;
    this.j = paramBoolean2;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramInt1, paramInt2 - 1, paramInt3);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(this.d);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(this.e);
    new b(this.c, new AppBrandDatePickerV2.2(this)).a(new AppBrandDatePickerV2.1(this)).a(false).a(new boolean[] { paramBoolean1, paramBoolean2, paramBoolean3, false, false, false }).a((Calendar)localObject).a(localCalendar1, localCalendar2).b(this.c.getResources().getDimensionPixelSize(2131298211)).a(this.b);
    this.b.a(this.c.getResources().getDimensionPixelSize(2131296955));
    this.b.b(this.c.getResources().getDimensionPixelSize(2131298211));
    this.b.c(ContextCompat.getColor(this.c, 2131165199));
    this.b.a(0, this.c.getResources().getDimensionPixelSize(2131296336), 0, this.c.getResources().getDimensionPixelSize(2131296336));
    localObject = this.b.k().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).b(ContextCompat.getColor(this.c, 2131165207)).a(this.c.getResources().getDimensionPixelSize(2131296336)).setBackgroundColor(ContextCompat.getColor(this.c, 2131165193));
    }
    a(this.b.k());
  }
  
  public void a(Long paramLong)
  {
    this.e = new Date(paramLong.longValue());
  }
  
  public void b(Long paramLong)
  {
    this.d = new Date(paramLong.longValue());
  }
  
  public View getView()
  {
    if (this.a == null) {
      this.a = this.b.j();
    }
    return this.a;
  }
  
  public void onAttach(d paramd) {}
  
  public void onDetach(d paramd) {}
  
  public void onHide(d paramd) {}
  
  public void onShow(d paramd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandDatePickerV2
 * JD-Core Version:    0.7.0.1
 */