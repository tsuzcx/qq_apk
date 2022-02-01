package com.tencent.luggage.wxa.pp;

import android.os.Looper;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pt.b;
import com.tencent.luggage.wxa.qz.s;

public final class aa
  implements View.OnFocusChangeListener
{
  private final s a;
  private boolean b = false;
  private b c;
  private final Runnable d = new aa.1(this);
  
  public aa(@NonNull EditText paramEditText)
  {
    this.b = paramEditText.isFocused();
    paramEditText.setOnFocusChangeListener(this);
    this.a = new s(Looper.getMainLooper());
  }
  
  public Editable a(Editable paramEditable)
  {
    paramEditable.setSpan(new aa.2(this), 0, paramEditable.length(), 18);
    paramEditable.setSpan(new aa.3(this), 0, paramEditable.length(), 18);
    return paramEditable;
  }
  
  void a()
  {
    this.a.b(this.d);
    if (this.b) {
      this.d.run();
    }
  }
  
  public void a(b paramb)
  {
    this.c = paramb;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (!paramBoolean) {
      this.a.b(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.aa
 * JD-Core Version:    0.7.0.1
 */