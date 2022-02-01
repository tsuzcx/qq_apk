package com.tencent.avgame.gameroom.overlay;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class ScoreValueUpdater
  implements Runnable
{
  private TextView a;
  private long b;
  private long c;
  private Handler d;
  private long e = 10L;
  
  public ScoreValueUpdater(TextView paramTextView, long paramLong1, long paramLong2)
  {
    this.a = paramTextView;
    this.d = new Handler(Looper.getMainLooper());
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  public void a()
  {
    long l1 = this.b;
    long l2 = this.c;
    if (l1 > l2) {
      return;
    }
    l1 = l2 - l1;
    if (l1 > this.e * 75L) {
      this.e = ((l1 + 75L - 1L) / 75L);
    }
    this.a.setText(String.valueOf(this.b));
    this.d.postDelayed(this, 40L);
  }
  
  public void run()
  {
    this.b += this.e;
    long l1 = this.b;
    long l2 = this.c;
    if (l1 >= l2)
    {
      this.a.setText(String.valueOf(l2));
      this.d.removeCallbacks(this);
      return;
    }
    this.a.setText(String.valueOf(l1));
    this.d.postDelayed(this, 40L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.ScoreValueUpdater
 * JD-Core Version:    0.7.0.1
 */