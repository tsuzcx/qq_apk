package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.ip.b;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AppBrandTimePickerV2
  implements com.tencent.luggage.wxa.lo.c<String>
{
  private Context context;
  private int currentHour;
  private int currentMinute;
  private int mMaxTimeHour = -1;
  private int mMaxTimeMinute = -1;
  private int mMinTimeHour = -1;
  private int mMinTimeMinute = -1;
  private View mView;
  private com.tencent.luggage.wxa.it.c pvTime;
  
  AppBrandTimePickerV2(Context paramContext)
  {
    this.pvTime = new com.tencent.luggage.wxa.it.c(paramContext);
    this.context = paramContext;
  }
  
  private void configPadding(List<WheelView> paramList)
  {
    if (paramList.size() == 1)
    {
      ((WheelView)paramList.get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131296336), 0, this.context.getResources().getDimensionPixelSize(2131296336));
      return;
    }
    if (paramList.size() == 2)
    {
      ((WheelView)paramList.get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131296336), this.context.getResources().getDimensionPixelSize(2131296336), this.context.getResources().getDimensionPixelSize(2131296336));
      ((WheelView)paramList.get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131296336), this.context.getResources().getDimensionPixelSize(2131296336), 0, this.context.getResources().getDimensionPixelSize(2131296336));
      return;
    }
    if (paramList.size() == 3)
    {
      ((WheelView)paramList.get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131296336), this.context.getResources().getDimensionPixelSize(2131296317), this.context.getResources().getDimensionPixelSize(2131296336));
      ((WheelView)paramList.get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131296317), this.context.getResources().getDimensionPixelSize(2131296336), this.context.getResources().getDimensionPixelSize(2131296317), this.context.getResources().getDimensionPixelSize(2131296336));
      ((WheelView)paramList.get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131296317), this.context.getResources().getDimensionPixelSize(2131296336), 0, this.context.getResources().getDimensionPixelSize(2131296336));
    }
  }
  
  private void getTimeString(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    this.currentHour = localCalendar.get(11);
    this.currentMinute = localCalendar.get(12);
  }
  
  public String currentValue()
  {
    this.pvTime.i();
    return String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(this.currentHour), Integer.valueOf(this.currentMinute) });
  }
  
  public View getView()
  {
    if (this.mView == null) {
      this.mView = this.pvTime.j();
    }
    return this.mView;
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(11, paramInt1);
    ((Calendar)localObject).set(12, paramInt2);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(11, this.mMinTimeHour);
    localCalendar1.set(12, this.mMinTimeMinute);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(11, this.mMaxTimeHour);
    localCalendar2.set(12, this.mMaxTimeMinute);
    new b(this.context, new AppBrandTimePickerV2.1(this)).a(new boolean[] { 0, 0, 0, 1, 1, 0 }).a((Calendar)localObject).a(localCalendar1, localCalendar2).a(false).a(ContextCompat.getColor(this.context, 2131165199)).a(this.pvTime);
    this.pvTime.a(this.context.getResources().getDimensionPixelSize(2131296955));
    this.pvTime.b(this.context.getResources().getDimensionPixelSize(2131298211));
    this.pvTime.a(0, this.context.getResources().getDimensionPixelSize(2131296336), 0, this.context.getResources().getDimensionPixelSize(2131296336));
    localObject = this.pvTime.k().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).b(ContextCompat.getColor(this.context, 2131165207)).a(this.context.getResources().getDimensionPixelSize(2131296336)).setBackgroundColor(ContextCompat.getColor(this.context, 2131165193));
    }
    configPadding(this.pvTime.k());
  }
  
  public boolean isNewPicker()
  {
    return true;
  }
  
  public void onAttach(d paramd) {}
  
  public void onDetach(d paramd) {}
  
  public void onHide(d paramd) {}
  
  public void onShow(d paramd) {}
  
  public void setMaxTime(int paramInt1, int paramInt2)
  {
    this.mMaxTimeHour = paramInt1;
    this.mMaxTimeMinute = paramInt2;
  }
  
  public void setMinTime(int paramInt1, int paramInt2)
  {
    this.mMinTimeHour = paramInt1;
    this.mMinTimeMinute = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePickerV2
 * JD-Core Version:    0.7.0.1
 */