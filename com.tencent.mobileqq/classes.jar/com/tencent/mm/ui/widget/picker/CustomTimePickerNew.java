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

public class CustomTimePickerNew
  extends FrameLayout
{
  private View a = null;
  private c b;
  private Context c;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j;
  private int k;
  
  public CustomTimePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131952936));
    this.c = paramContext;
    this.b = new c(paramContext);
  }
  
  public CustomTimePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131952936), paramAttributeSet);
    this.c = paramContext;
    this.b = new c(paramContext);
  }
  
  public CustomTimePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    this.b = new c(paramContext);
  }
  
  private void a(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    this.j = localCalendar.get(11);
    this.k = localCalendar.get(12);
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
    return String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(this.j), Integer.valueOf(this.k) });
  }
  
  public View getView()
  {
    if (this.a == null) {
      this.a = this.b.j();
    }
    return this.a;
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public void onShow()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(11, this.h);
    ((Calendar)localObject).set(12, this.i);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(11, this.d);
    localCalendar1.set(12, this.e);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(11, this.f);
    localCalendar2.set(12, this.g);
    new b(this.c, new CustomTimePickerNew.1(this)).a(new boolean[] { 0, 0, 0, 1, 1, 0 }).a((Calendar)localObject).a(localCalendar1, localCalendar2).a(false).a(ContextCompat.getColor(this.c, 2131165199)).a(this.b);
    this.b.a(this.c.getResources().getDimensionPixelSize(2131296955));
    this.b.b(this.c.getResources().getDimensionPixelSize(2131296339));
    this.b.a(0, this.c.getResources().getDimensionPixelSize(2131296336), 0, this.c.getResources().getDimensionPixelSize(2131296336));
    localObject = this.b.k().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).b(ContextCompat.getColor(this.c, 2131165207)).a(this.c.getResources().getDimensionPixelSize(2131296336)).setBackgroundColor(ContextCompat.getColor(this.c, 2131165193));
    }
    a(this.b.k());
  }
  
  public void setMaxTime(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public void setMinTime(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePickerNew
 * JD-Core Version:    0.7.0.1
 */