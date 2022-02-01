package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.string;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import java.util.Locale;

class TimePickerTextInputPresenter
  implements TimePickerPresenter, TimePickerView.OnSelectionChange
{
  private final LinearLayout a;
  private final TimeModel b;
  private final TextWatcher c = new TimePickerTextInputPresenter.1(this);
  private final TextWatcher d = new TimePickerTextInputPresenter.2(this);
  private final ChipTextInputComboView e;
  private final ChipTextInputComboView f;
  private final TimePickerTextInputKeyController g;
  private final EditText h;
  private final EditText i;
  private MaterialButtonToggleGroup j;
  
  public TimePickerTextInputPresenter(LinearLayout paramLinearLayout, TimeModel paramTimeModel)
  {
    this.a = paramLinearLayout;
    this.b = paramTimeModel;
    Object localObject = paramLinearLayout.getResources();
    this.e = ((ChipTextInputComboView)paramLinearLayout.findViewById(R.id.u));
    this.f = ((ChipTextInputComboView)paramLinearLayout.findViewById(R.id.r));
    TextView localTextView1 = (TextView)this.e.findViewById(R.id.t);
    TextView localTextView2 = (TextView)this.f.findViewById(R.id.t);
    localTextView1.setText(((Resources)localObject).getString(R.string.q));
    localTextView2.setText(((Resources)localObject).getString(R.string.p));
    this.e.setTag(R.id.aa, Integer.valueOf(12));
    this.f.setTag(R.id.aa, Integer.valueOf(10));
    if (paramTimeModel.a == 0) {
      i();
    }
    localObject = new TimePickerTextInputPresenter.3(this);
    this.f.setOnClickListener((View.OnClickListener)localObject);
    this.e.setOnClickListener((View.OnClickListener)localObject);
    this.f.a(paramTimeModel.c());
    this.e.a(paramTimeModel.b());
    this.h = this.f.a().getEditText();
    this.i = this.e.a().getEditText();
    if (Build.VERSION.SDK_INT < 21)
    {
      int k = MaterialColors.a(paramLinearLayout, R.attr.r);
      a(this.h, k);
      a(this.i, k);
    }
    this.g = new TimePickerTextInputKeyController(this.f, this.e, paramTimeModel);
    this.f.a(new ClickActionDelegate(paramLinearLayout.getContext(), R.string.i));
    this.e.a(new ClickActionDelegate(paramLinearLayout.getContext(), R.string.k));
    a();
  }
  
  private static void a(EditText paramEditText, @ColorInt int paramInt)
  {
    try
    {
      Object localObject = paramEditText.getContext();
      Field localField = TextView.class.getDeclaredField("mCursorDrawableRes");
      localField.setAccessible(true);
      int k = localField.getInt(paramEditText);
      localField = TextView.class.getDeclaredField("mEditor");
      localField.setAccessible(true);
      paramEditText = localField.get(paramEditText);
      localField = paramEditText.getClass().getDeclaredField("mCursorDrawable");
      localField.setAccessible(true);
      localObject = AppCompatResources.getDrawable((Context)localObject, k);
      ((Drawable)localObject).setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
      localField.set(paramEditText, new Drawable[] { localObject, localObject });
      return;
    }
    catch (Throwable paramEditText) {}
  }
  
  private void a(TimeModel paramTimeModel)
  {
    h();
    Locale localLocale = this.a.getResources().getConfiguration().locale;
    String str = String.format(localLocale, "%02d", new Object[] { Integer.valueOf(paramTimeModel.c) });
    paramTimeModel = String.format(localLocale, "%02d", new Object[] { Integer.valueOf(paramTimeModel.a()) });
    this.e.a(str);
    this.f.a(paramTimeModel);
    g();
    j();
  }
  
  private void g()
  {
    this.h.addTextChangedListener(this.d);
    this.i.addTextChangedListener(this.c);
  }
  
  private void h()
  {
    this.h.removeTextChangedListener(this.d);
    this.i.removeTextChangedListener(this.c);
  }
  
  private void i()
  {
    this.j = ((MaterialButtonToggleGroup)this.a.findViewById(R.id.q));
    this.j.a(new TimePickerTextInputPresenter.4(this));
    this.j.setVisibility(0);
    j();
  }
  
  private void j()
  {
    MaterialButtonToggleGroup localMaterialButtonToggleGroup = this.j;
    if (localMaterialButtonToggleGroup == null) {
      return;
    }
    int k;
    if (this.b.e == 0) {
      k = R.id.o;
    } else {
      k = R.id.p;
    }
    localMaterialButtonToggleGroup.a(k);
  }
  
  public void a()
  {
    g();
    a(this.b);
    this.g.a();
  }
  
  public void a(int paramInt)
  {
    this.b.d = paramInt;
    ChipTextInputComboView localChipTextInputComboView = this.e;
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
    localChipTextInputComboView = this.f;
    if (paramInt == 10) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
    j();
  }
  
  public void b()
  {
    a(this.b);
  }
  
  public void c()
  {
    this.a.setVisibility(0);
  }
  
  public void d()
  {
    View localView = this.a.getFocusedChild();
    if (localView == null)
    {
      this.a.setVisibility(8);
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)ContextCompat.getSystemService(this.a.getContext(), InputMethodManager.class);
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    this.a.setVisibility(8);
  }
  
  public void e()
  {
    ChipTextInputComboView localChipTextInputComboView = this.e;
    int k = this.b.d;
    boolean bool2 = true;
    boolean bool1;
    if (k == 12) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
    localChipTextInputComboView = this.f;
    if (this.b.d == 10) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localChipTextInputComboView.setChecked(bool1);
  }
  
  public void f()
  {
    this.e.setChecked(false);
    this.f.setChecked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.TimePickerTextInputPresenter
 * JD-Core Version:    0.7.0.1
 */