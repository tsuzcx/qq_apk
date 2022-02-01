package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.luggage.wxa.pu.a;
import com.tencent.luggage.wxa.pu.b;

public final class w
  extends a
{
  private int a = 0;
  private final SparseIntArray b = new w.1(this);
  private InputConnection c;
  private b d;
  
  public w(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void b()
  {
    w.2 local2 = new w.2(this);
    int i = 0;
    while (i < this.b.size())
    {
      findViewById(this.b.valueAt(i)).setOnClickListener(local2);
      i += 1;
    }
    findViewById(2131447011).setOnClickListener(local2);
    findViewById(2131447010).setOnClickListener(null);
    findViewById(2131447010).setOnTouchListener(new w.3(this));
  }
  
  private boolean c()
  {
    InputConnection localInputConnection = this.c;
    if (localInputConnection != null)
    {
      if ((TextUtils.isEmpty(localInputConnection.getTextBeforeCursor(1, 0)) ^ true))
      {
        this.c.deleteSurroundingText(1, 0);
        return true;
      }
      this.c.sendKeyEvent(new KeyEvent(0, 67));
      this.c.sendKeyEvent(new KeyEvent(1, 67));
      return true;
    }
    return false;
  }
  
  public void a(b paramb)
  {
    if (this.d == paramb) {
      return;
    }
    if (paramb == null)
    {
      this.c = null;
      return;
    }
    boolean bool = paramb instanceof View;
    Object localObject;
    if (bool)
    {
      localObject = ae.a.a(((View)paramb).getContext());
      if (localObject != null) {
        ((ae)localObject).i();
      }
    }
    if ((paramb instanceof EditText))
    {
      localObject = (EditText)paramb;
      ak.a.b((EditText)localObject);
      ak.a.a((EditText)localObject);
    }
    if (bool) {
      ((View)paramb).requestFocus();
    }
    this.c = paramb.f();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setInputEditText(null);
  }
  
  public void setXMode(int paramInt)
  {
    super.setXMode(paramInt);
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.w
 * JD-Core Version:    0.7.0.1
 */