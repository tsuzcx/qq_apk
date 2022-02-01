package com.tencent.luggage.wxa.pv;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;

public class a$a
  implements a
{
  private View a;
  private int b;
  private boolean c;
  
  public a$a(@NonNull Context paramContext)
  {
    this.a = new a.a.1(this, paramContext);
  }
  
  private int i()
  {
    return this.a.getHeight();
  }
  
  private int j()
  {
    return this.a.getMeasuredHeight();
  }
  
  public void a(b paramb) {}
  
  public boolean a()
  {
    int i = this.b;
    boolean bool2 = false;
    o.e("Luggage.IKeyboardPanel.DefaultPanelImpl", "[scrollUp] isRealHeightSettled, mForcePanelHeight %d, height %d, measuredHeight %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i()), Integer.valueOf(j()) });
    i = this.b;
    boolean bool1 = bool2;
    if (i > 0)
    {
      bool1 = bool2;
      if (i == j()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt > 0) && (this.b != paramInt))
    {
      this.b = paramInt;
      return true;
    }
    return false;
  }
  
  public View b()
  {
    return this.a;
  }
  
  public void c()
  {
    this.a.setVisibility(0);
  }
  
  public void d()
  {
    this.a.setVisibility(4);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public boolean h()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return this.a.isInLayout();
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pv.a.a
 * JD-Core Version:    0.7.0.1
 */