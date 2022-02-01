package com.tencent.mobileqq.activity.bless;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.AudioUtil;

public class CountDownView
  extends ImageView
{
  private static final int[] a = { 2130838974, 2130838973, 2130838972 };
  private int b = 0;
  private boolean c = false;
  private CountDownView.CountDownFinishedListener d;
  private Runnable e = new CountDownView.1(this);
  
  public CountDownView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    AudioUtil.b();
    AudioUtil.a(2131230818, 1, null, null);
  }
  
  public void a()
  {
    setImageResource(a[0]);
    this.c = false;
    Handler localHandler = getHandler();
    if (localHandler != null) {
      localHandler.removeCallbacks(this.e);
    }
    this.b = 0;
    setVisibility(4);
  }
  
  public void setListener(CountDownView.CountDownFinishedListener paramCountDownFinishedListener)
  {
    this.d = paramCountDownFinishedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.CountDownView
 * JD-Core Version:    0.7.0.1
 */