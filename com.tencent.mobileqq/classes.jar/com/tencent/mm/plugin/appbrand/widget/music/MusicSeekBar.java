package com.tencent.mm.plugin.appbrand.widget.music;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class MusicSeekBar
  extends FrameLayout
{
  ValueAnimator a;
  boolean b = false;
  boolean c = false;
  a d;
  Drawable e;
  private Context f;
  private TextView g;
  private TextView h;
  private SeekBar i;
  private MusicSeekBar.a j;
  
  public MusicSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MusicSeekBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f = paramContext;
    a();
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    long l1 = paramInt / 60000;
    long l2 = Math.floor(paramInt % 60000 / 1000L);
    if (l1 < 10L) {
      localStringBuilder1.append("0");
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(l1);
    localStringBuilder2.append(":");
    localStringBuilder1.append(localStringBuilder2.toString());
    if (l2 < 10L) {
      localStringBuilder1.append("0");
    }
    localStringBuilder1.append(l2);
    return localStringBuilder1.toString();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.f).inflate(2131625494, this);
    this.g = ((TextView)localView.findViewById(2131431531));
    this.h = ((TextView)localView.findViewById(2131432552));
    this.i = ((SeekBar)localView.findViewById(2131445502));
    this.g.setText("00:00");
    this.h.setText("--:--");
    this.d = new a(getResources().getDrawable(2130842198));
    this.e = getResources().getDrawable(2130842200);
    this.i.setOnSeekBarChangeListener(new MusicSeekBar.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a == null)
    {
      this.a = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.a.setTarget(this.i);
      this.a.setRepeatCount(100);
      this.a.setDuration(5000L);
      this.a.setInterpolator(new LinearInterpolator());
      this.a.addUpdateListener(new MusicSeekBar.2(this));
    }
    this.c = paramBoolean;
    if (paramBoolean)
    {
      this.a.start();
      return;
    }
    this.a.cancel();
    this.i.setThumb(this.e);
  }
  
  public void setColor(int paramInt)
  {
    this.g.setTextColor(paramInt);
    this.h.setTextColor(paramInt);
    this.i.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.i.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.e.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.d.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.h.setText(a(paramInt));
    this.i.setMax(paramInt);
  }
  
  public void setOnSeekBarChange(MusicSeekBar.a parama)
  {
    this.j = parama;
  }
  
  public void setProgress(int paramInt)
  {
    if (!this.c)
    {
      if (this.b) {
        return;
      }
      this.g.setText(a(paramInt));
      this.i.setProgress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */