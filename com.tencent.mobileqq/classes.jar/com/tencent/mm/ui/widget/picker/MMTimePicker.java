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

public class MMTimePicker
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private BottomSheetDialog a;
  private View b;
  private Context c;
  private int d;
  private BottomSheetBehavior e;
  private Button f;
  private Button g;
  private LinearLayout h;
  private CustomTimePickerNew i;
  private MMTimePicker.OnResultListener j;
  
  public MMTimePicker(Context paramContext)
  {
    this.c = paramContext;
    a();
  }
  
  private void a()
  {
    this.a = new BottomSheetDialog(this.c);
    this.b = View.inflate(this.c, 2131629510, null);
    this.h = ((LinearLayout)this.b.findViewById(2131447366));
    this.i = new CustomTimePickerNew(this.c);
    this.h.removeAllViews();
    this.h.setGravity(17);
    this.h.addView(this.i.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.f = ((Button)this.b.findViewById(2131439547));
    this.f.setOnClickListener(new MMTimePicker.1(this));
    this.g = ((Button)this.b.findViewById(2131430281));
    this.g.setOnClickListener(new MMTimePicker.2(this));
    this.a.setContentView(this.b);
    this.d = g.a(this.c, 420);
    this.e = BottomSheetBehavior.b((View)this.b.getParent());
    BottomSheetBehavior localBottomSheetBehavior = this.e;
    if (localBottomSheetBehavior != null)
    {
      localBottomSheetBehavior.a(this.d);
      this.e.b(false);
    }
    this.a.setOnDismissListener(new MMTimePicker.3(this));
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    MMTimePicker.OnResultListener localOnResultListener = this.j;
    if (localOnResultListener != null) {
      localOnResultListener.onResult(paramBoolean, paramObject);
    }
  }
  
  public String getCurrentValue()
  {
    CustomTimePickerNew localCustomTimePickerNew = this.i;
    if (localCustomTimePickerNew != null) {
      return localCustomTimePickerNew.currentValue();
    }
    return "";
  }
  
  public void hide()
  {
    BottomSheetDialog localBottomSheetDialog = this.a;
    if (localBottomSheetDialog != null) {
      localBottomSheetDialog.dismiss();
    }
  }
  
  public void onGlobalLayout() {}
  
  public void setCurrentTime(int paramInt1, int paramInt2)
  {
    CustomTimePickerNew localCustomTimePickerNew = this.i;
    if (localCustomTimePickerNew != null) {
      localCustomTimePickerNew.init(paramInt1, paramInt2);
    }
  }
  
  public void setMaxTime(int paramInt1, int paramInt2)
  {
    CustomTimePickerNew localCustomTimePickerNew = this.i;
    if (localCustomTimePickerNew != null) {
      localCustomTimePickerNew.setMaxTime(paramInt1, paramInt2);
    }
  }
  
  public void setMinTime(int paramInt1, int paramInt2)
  {
    CustomTimePickerNew localCustomTimePickerNew = this.i;
    if (localCustomTimePickerNew != null) {
      localCustomTimePickerNew.setMinTime(paramInt1, paramInt2);
    }
  }
  
  public void setOnResultListener(MMTimePicker.OnResultListener paramOnResultListener)
  {
    this.j = paramOnResultListener;
  }
  
  public void show()
  {
    if (this.a != null)
    {
      CustomTimePickerNew localCustomTimePickerNew = this.i;
      if (localCustomTimePickerNew != null) {
        localCustomTimePickerNew.onShow();
      }
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.MMTimePicker
 * JD-Core Version:    0.7.0.1
 */