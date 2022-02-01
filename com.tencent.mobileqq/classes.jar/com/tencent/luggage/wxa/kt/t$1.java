package com.tencent.luggage.wxa.kt;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.luggage.wxa.qz.o;

class t$1
  extends ScrollView
{
  t$1(t paramt, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (t.a(this.a) != null) {
      t.a(this.a).a(this.a, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (i != 1) && (i == 2) && (!t.b(this.a)))
    {
      o.b("MicroMsg.WxaScrollView", "can not move");
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.t.1
 * JD-Core Version:    0.7.0.1
 */