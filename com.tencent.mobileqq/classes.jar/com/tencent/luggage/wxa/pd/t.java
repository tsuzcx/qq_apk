package com.tencent.luggage.wxa.pd;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.luggage.wxa.qz.o;

@TargetApi(3)
public class t
  extends OrientationEventListener
{
  private t.a a = t.a.a;
  private int b = 45;
  private t.b c;
  
  public t(Context paramContext, t.b paramb)
  {
    super(paramContext);
    this.c = paramb;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 90))
    {
      this.b = paramInt;
      return;
    }
    this.b = 45;
  }
  
  public void disable()
  {
    super.disable();
    this.a = t.a.a;
  }
  
  public void enable()
  {
    super.enable();
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    t.a locala2 = this.a;
    t.a locala1;
    if (((paramInt >= 360 - this.b) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.b + 0)))
    {
      locala1 = t.a.b;
    }
    else
    {
      int i = this.b;
      if ((paramInt >= 270 - i) && (paramInt <= i + 270))
      {
        locala1 = t.a.c;
      }
      else
      {
        i = this.b;
        if ((paramInt >= 180 - i) && (paramInt <= i + 180))
        {
          locala1 = t.a.d;
        }
        else
        {
          i = this.b;
          locala1 = locala2;
          if (paramInt >= 90 - i)
          {
            locala1 = locala2;
            if (paramInt <= i + 90) {
              locala1 = t.a.e;
            }
          }
        }
      }
    }
    locala2 = this.a;
    if (locala1 != locala2)
    {
      if ((this.c != null) && (locala2 != t.a.a)) {
        this.c.a(this.a, locala1);
      }
      this.a = locala1;
    }
    o.d("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged: %d", new Object[] { Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.t
 * JD-Core Version:    0.7.0.1
 */