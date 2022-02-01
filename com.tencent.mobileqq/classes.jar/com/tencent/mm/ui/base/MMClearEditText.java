package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.luggage.wxa.rg.b;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.g;

public class MMClearEditText
  extends EditText
{
  public String a = "";
  public boolean b = false;
  Drawable c = g.c(getContext(), 2131034852);
  int d = 0;
  private View.OnFocusChangeListener e = null;
  private View.OnTouchListener f = new MMClearEditText.3(this);
  private boolean g = false;
  
  public MMClearEditText(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    if ((!getText().toString().equals("")) && (isFocused()))
    {
      b();
      return;
    }
    c();
  }
  
  private void a(Context paramContext)
  {
    if (this.c == null) {
      this.c = g.c(getContext(), 2131034852);
    }
    paramContext = this.c;
    paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), this.c.getIntrinsicHeight());
    f.b("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.c.getIntrinsicWidth()), Integer.valueOf(this.c.getIntrinsicHeight()) });
    a();
    setHeight(this.c.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131296392) * 5);
    setOnTouchListener(this.f);
    addTextChangedListener(new MMClearEditText.1(this));
    super.setOnFocusChangeListener(new MMClearEditText.2(this));
  }
  
  private void b()
  {
    if (!this.g) {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.c, getCompoundDrawables()[3]);
    }
  }
  
  private void c()
  {
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
  }
  
  public void a(String paramString)
  {
    int i = getSelectionStart();
    setText(b.a(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
    }
    else
    {
      setSelection(i);
    }
  }
  
  public View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.f;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    if (!this.b) {
      paramParcelable = View.BaseSavedState.EMPTY_STATE;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    boolean bool = super.onTextContextMenuItem(paramInt);
    String str;
    if (paramInt == 16908322)
    {
      this.d = 0;
      str = getText().toString();
    }
    try
    {
      a(str);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      label32:
      StringBuilder localStringBuilder;
      break label32;
    }
    f.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.d) });
    paramInt = this.d;
    if (paramInt < 3)
    {
      this.d = (paramInt + 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(str);
      a(localStringBuilder.toString());
      return bool;
    }
    f.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix", new Object[0]);
    return bool;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.e = paramOnFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */