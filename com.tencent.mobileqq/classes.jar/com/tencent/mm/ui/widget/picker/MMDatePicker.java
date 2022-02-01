package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.mm.ui.g;
import java.util.Calendar;
import java.util.Locale;

public class MMDatePicker
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private BottomSheetDialog a;
  private View b;
  private Context c;
  private int d;
  private BottomSheetBehavior e;
  private Button f;
  private Button g;
  private Button h;
  private LinearLayout i;
  private LinearLayout j;
  private CustomDatePickerNew k;
  private MMDatePicker.OnResultListener l;
  
  public MMDatePicker(Context paramContext)
  {
    this.c = paramContext;
    a();
  }
  
  private void a()
  {
    this.a = new BottomSheetDialog(this.c);
    this.b = View.inflate(this.c, 2131624675, null);
    this.i = ((LinearLayout)this.b.findViewById(2131431614));
    this.j = ((LinearLayout)this.b.findViewById(2131431617));
    this.k = new CustomDatePickerNew(this.c);
    this.i.removeAllViews();
    this.i.setGravity(17);
    this.i.addView(this.k.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.f = ((Button)this.b.findViewById(2131439547));
    this.f.setOnClickListener(new MMDatePicker.1(this));
    this.g = ((Button)this.b.findViewById(2131430281));
    this.g.setOnClickListener(new MMDatePicker.2(this));
    this.h = ((Button)this.b.findViewById(2131430032));
    this.h.setOnClickListener(new MMDatePicker.3(this));
    this.a.setContentView(this.b);
    this.a.setOnCancelListener(new MMDatePicker.4(this));
    this.d = g.a(this.c, 420);
    this.e = BottomSheetBehavior.b((View)this.b.getParent());
    BottomSheetBehavior localBottomSheetBehavior = this.e;
    if (localBottomSheetBehavior != null)
    {
      localBottomSheetBehavior.a(this.d);
      this.e.b(false);
    }
    this.a.setOnDismissListener(new MMDatePicker.5(this));
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    MMDatePicker.OnResultListener localOnResultListener = this.l;
    if (localOnResultListener != null) {
      localOnResultListener.onResult(paramBoolean, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public String getCurrentValue()
  {
    CustomDatePickerNew localCustomDatePickerNew = this.k;
    if (localCustomDatePickerNew != null) {
      return localCustomDatePickerNew.currentValue();
    }
    return null;
  }
  
  public int getDay()
  {
    CustomDatePickerNew localCustomDatePickerNew = this.k;
    if (localCustomDatePickerNew != null) {
      return localCustomDatePickerNew.getDayOfMonth();
    }
    return 0;
  }
  
  public int getMonth()
  {
    CustomDatePickerNew localCustomDatePickerNew = this.k;
    if (localCustomDatePickerNew != null) {
      return localCustomDatePickerNew.getMonth();
    }
    return 0;
  }
  
  public int getYear()
  {
    CustomDatePickerNew localCustomDatePickerNew = this.k;
    if (localCustomDatePickerNew != null) {
      return localCustomDatePickerNew.getYear();
    }
    return 0;
  }
  
  public void hide()
  {
    BottomSheetDialog localBottomSheetDialog = this.a;
    if (localBottomSheetDialog != null) {
      localBottomSheetDialog.dismiss();
    }
  }
  
  public void onGlobalLayout() {}
  
  public void setHeaderView(View paramView)
  {
    LinearLayout localLinearLayout = this.j;
    if (localLinearLayout != null)
    {
      if (paramView == null)
      {
        localLinearLayout.setVisibility(8);
        return;
      }
      localLinearLayout.setVisibility(0);
      this.j.removeAllViews();
      this.j.setGravity(17);
      this.j.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
    }
  }
  
  public void setInitDate(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      if (paramInt3 < 0) {
        return;
      }
      CustomDatePickerNew localCustomDatePickerNew = this.k;
      if (localCustomDatePickerNew != null) {
        localCustomDatePickerNew.init(paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    CustomDatePickerNew localCustomDatePickerNew = this.k;
    if (localCustomDatePickerNew != null) {
      localCustomDatePickerNew.setLongTermYear(paramBoolean);
    }
  }
  
  public void setMaxDate(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      if (paramInt3 < 0) {
        return;
      }
      Calendar localCalendar = Calendar.getInstance(Locale.US);
      localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
      CustomDatePickerNew localCustomDatePickerNew = this.k;
      if (localCustomDatePickerNew != null) {
        localCustomDatePickerNew.setMaxDate(Long.valueOf(localCalendar.getTimeInMillis()));
      }
    }
  }
  
  public void setMinDate(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      if (paramInt3 < 0) {
        return;
      }
      Calendar localCalendar = Calendar.getInstance(Locale.US);
      localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
      CustomDatePickerNew localCustomDatePickerNew = this.k;
      if (localCustomDatePickerNew != null) {
        localCustomDatePickerNew.setMinDate(Long.valueOf(localCalendar.getTimeInMillis()));
      }
    }
  }
  
  public void setOnResultListener(MMDatePicker.OnResultListener paramOnResultListener)
  {
    this.l = paramOnResultListener;
  }
  
  public void setPickersEnable(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    CustomDatePickerNew localCustomDatePickerNew = this.k;
    if (localCustomDatePickerNew != null) {
      localCustomDatePickerNew.setPickersEnable(paramBoolean1, paramBoolean2, paramBoolean3);
    }
  }
  
  public void setRightBtnText(CharSequence paramCharSequence)
  {
    Button localButton = this.f;
    if (localButton != null) {
      localButton.setText(paramCharSequence);
    }
  }
  
  public void setSingleBtnText(CharSequence paramCharSequence)
  {
    Button localButton = this.h;
    if (localButton != null) {
      localButton.setText(paramCharSequence);
    }
  }
  
  public void show()
  {
    if (this.a != null)
    {
      CustomDatePickerNew localCustomDatePickerNew = this.k;
      if (localCustomDatePickerNew != null) {
        localCustomDatePickerNew.onShow();
      }
      this.a.show();
    }
  }
  
  public void showSingleBtn(boolean paramBoolean)
  {
    Button localButton;
    if (paramBoolean)
    {
      localButton = this.h;
      if (localButton != null) {
        localButton.setVisibility(0);
      }
      localButton = this.f;
      if (localButton != null) {
        localButton.setVisibility(8);
      }
      localButton = this.g;
      if (localButton != null) {
        localButton.setVisibility(8);
      }
    }
    else
    {
      localButton = this.h;
      if (localButton != null) {
        localButton.setVisibility(8);
      }
      localButton = this.f;
      if (localButton != null) {
        localButton.setVisibility(0);
      }
      localButton = this.g;
      if (localButton != null) {
        localButton.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMDatePicker
 * JD-Core Version:    0.7.0.1
 */