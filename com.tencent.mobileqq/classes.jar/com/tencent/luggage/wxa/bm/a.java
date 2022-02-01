package com.tencent.luggage.wxa.bm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatButton;

class a
  extends AppCompatButton
{
  private RectF a;
  private boolean b;
  private float c;
  private float d;
  
  public a(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    setGravity(17);
    setText("vConsole");
    setTextColor(-1);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(13.0F * f);
    setPadding(i, (int)(4.0F * f), i, (int)(f * 6.0F));
    setBackgroundDrawable(new a.a(this, null));
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = this.a;
    if (localRectF == null) {
      return false;
    }
    return localRectF.contains(paramFloat1, paramFloat2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i == 2) && ((this.b) || (!a(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))))
        {
          setX(getX() + (paramMotionEvent.getRawX() - this.c));
          setY(getY() + (paramMotionEvent.getRawY() - this.d));
          requestLayout();
          this.b = true;
        }
      }
      else if ((!this.b) && (a(paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
        performClick();
      }
    }
    else
    {
      this.a = new RectF(getX(), getY(), getX() + getWidth(), getY() + getHeight());
      this.b = false;
    }
    this.c = paramMotionEvent.getRawX();
    this.d = paramMotionEvent.getRawY();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.a
 * JD-Core Version:    0.7.0.1
 */