package com.tencent.luggage.wxa.bm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.luggage.wxa.qz.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ViewConstructor"})
class d
  extends AppCompatTextView
{
  private final List<f> a = new ArrayList(4);
  private StringBuilder b = new StringBuilder(100);
  private e.c c = null;
  private v d = new v(Looper.getMainLooper(), new d.1(this), true);
  
  public d(Context paramContext)
  {
    super(paramContext);
    b();
    this.d.a(2000L);
  }
  
  private void b()
  {
    setTextSize(12.0F);
    setTextColor(-65536);
    setFocusable(false);
    setClickable(false);
    setOnClickListener(null);
  }
  
  public void a()
  {
    this.d.c();
  }
  
  @MainThread
  public void a(e.c paramc)
  {
    this.c = paramc;
  }
  
  public void a(List<f> paramList)
  {
    this.b.setLength(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      StringBuilder localStringBuilder = this.b;
      localStringBuilder.append(localf.a);
      localStringBuilder.append("[");
      localStringBuilder.append(localf.b);
      localStringBuilder.append("] ");
    }
    setText(this.b);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.d
 * JD-Core Version:    0.7.0.1
 */