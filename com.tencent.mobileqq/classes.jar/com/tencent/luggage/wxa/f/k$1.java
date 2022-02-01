package com.tencent.luggage.wxa.f;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.OrientationEventListener;

class k$1
  extends OrientationEventListener
{
  private int b = -1;
  
  k$1(k paramk, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt != -1)
    {
      if (this.a.c == null) {
        return;
      }
      paramInt = this.a.c.getRotation();
      if (this.b != paramInt)
      {
        this.b = paramInt;
        this.a.b(k.b.get(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.k.1
 * JD-Core Version:    0.7.0.1
 */