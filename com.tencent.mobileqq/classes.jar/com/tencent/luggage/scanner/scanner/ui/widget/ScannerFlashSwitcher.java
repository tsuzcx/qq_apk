package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;

public class ScannerFlashSwitcher
  extends LinearLayout
{
  private ImageView a;
  private TextView b;
  private boolean c = false;
  private boolean d;
  private boolean e;
  
  public ScannerFlashSwitcher(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public ScannerFlashSwitcher(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  public ScannerFlashSwitcher(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void g()
  {
    LayoutInflater.from(getContext()).inflate(2131625230, this, true);
    this.a = ((ImageView)findViewById(2131433406));
    this.b = ((TextView)findViewById(2131433323));
    this.c = true;
  }
  
  public void a()
  {
    o.d("Luggage.ScannerFlashSwitcher", "show, isFirstShow: %s", new Object[] { Boolean.valueOf(this.c) });
    this.e = true;
    if (this.c)
    {
      this.a.setAlpha(0.0F);
      this.b.setAlpha(0.0F);
      setVisibility(0);
      this.b.animate().alpha(1.0F).setListener(null).setDuration(500L);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.addUpdateListener(new ScannerFlashSwitcher.1(this));
      localValueAnimator.setRepeatCount(3);
      localValueAnimator.setRepeatMode(2);
      localValueAnimator.setDuration(500L);
      localValueAnimator.addListener(new ScannerFlashSwitcher.2(this));
      localValueAnimator.start();
      this.c = false;
    }
    else
    {
      setVisibility(0);
      this.b.animate().alpha(1.0F).setDuration(500L).setListener(null).start();
      this.a.animate().alpha(1.0F).setDuration(500L).setListener(null).start();
    }
    setEnabled(true);
  }
  
  public void b()
  {
    o.d("Luggage.ScannerFlashSwitcher", "hide");
    setEnabled(false);
    this.e = false;
    this.a.animate().alpha(0.0F).setDuration(500L);
    this.b.animate().alpha(0.0F).setDuration(500L).setListener(new ScannerFlashSwitcher.3(this));
    this.d = false;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e()
  {
    o.d("Luggage.ScannerFlashSwitcher", "openFlashStatus");
    this.d = true;
    this.a.setImageResource(2130851680);
    this.b.setText(2131915904);
  }
  
  public void f()
  {
    o.d("Luggage.ScannerFlashSwitcher", "closeFlashStatus");
    this.d = false;
    this.a.setImageResource(2130851679);
    this.b.setText(2131915905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.ScannerFlashSwitcher
 * JD-Core Version:    0.7.0.1
 */