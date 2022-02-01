package com.tencent.ad.tangram.views.canvas.components.pictures;

import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ad.tangram.views.canvas.components.picture.a;

class b$a
  implements View.OnTouchListener
{
  private a canvasPictureComponentData;
  private final GestureDetector gestureDetector = new GestureDetector(this.listener);
  private GestureDetector.OnGestureListener listener = new b.a.1(this);
  
  public b$a(b paramb, a parama)
  {
    this.canvasPictureComponentData = parama;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.gestureDetector.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.pictures.b.a
 * JD-Core Version:    0.7.0.1
 */