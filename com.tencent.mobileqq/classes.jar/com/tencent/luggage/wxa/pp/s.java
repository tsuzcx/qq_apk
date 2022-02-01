package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.pu.b;

public final class s
  extends r
  implements b
{
  private InputConnection a;
  
  public s(Context paramContext)
  {
    super(paramContext);
    super.setKeyListener(new s.1(this));
  }
  
  public void clearFocus()
  {
    o();
  }
  
  public void e()
  {
    if (!ViewCompat.isAttachedToWindow(this)) {
      return;
    }
    v localv = getInputPanel();
    if (localv != null) {
      localv.setInputEditText(this);
    }
  }
  
  public InputConnection f()
  {
    InputConnection localInputConnection = super.onCreateInputConnection(new EditorInfo());
    this.a = localInputConnection;
    return localInputConnection;
  }
  
  public v getInputPanel()
  {
    return v.a(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return null;
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    return a(paramInt, paramRect);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    int i = 0;
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (paramArrayOfInputFilter == null) {
      arrayOfInputFilter = new InputFilter[0];
    }
    paramArrayOfInputFilter = new InputFilter[arrayOfInputFilter.length + 1];
    while (i < arrayOfInputFilter.length)
    {
      paramArrayOfInputFilter[i] = arrayOfInputFilter[i];
      i += 1;
    }
    paramArrayOfInputFilter[i] = new InputFilter.AllCaps();
    super.setFilters(paramArrayOfInputFilter);
  }
  
  public void setPasswordMode(boolean paramBoolean)
  {
    l();
    int i = getInputType() | 0x2;
    if (paramBoolean) {
      i |= 0x10;
    } else {
      i &= 0xFFFFFFEF;
    }
    setInputType(i);
    super.setPasswordMode(paramBoolean);
    m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.s
 * JD-Core Version:    0.7.0.1
 */