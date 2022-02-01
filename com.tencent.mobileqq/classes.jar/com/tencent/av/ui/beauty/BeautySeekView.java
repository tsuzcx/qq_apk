package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class BeautySeekView
  extends RelativeLayout
{
  public boolean a = false;
  Runnable b = new BeautySeekView.2(this);
  SeekBar.OnSeekBarChangeListener c = new BeautySeekView.3(this);
  private TextView d = null;
  private SeekBar e = null;
  private TextView f;
  private View g = null;
  private int h = 0;
  private Drawable i;
  private int j = 0;
  private Handler k;
  private BeautySeekView.ActionListener l = null;
  private String m;
  private int n = 0;
  private boolean o = true;
  private int p = 0;
  
  public BeautySeekView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BeautySeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BeautySeekView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    this.p = ((SeekBar)localObject).getMeasuredWidth();
    int i1 = this.e.getPaddingLeft();
    int i2 = this.e.getPaddingRight();
    int i3 = this.e.getLeft();
    int i4 = i3 + i1 + (int)(this.n / 100.0F * (this.p - i1 - i2));
    localObject = (ViewGroup.MarginLayoutParams)this.g.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i4;
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.i("BeautySeekView", 4, String.format("updateMarker, pl: %s, pr: %s, w: %s, ml: %s, m: %s, left: %s, flag: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(this.p), Integer.valueOf(i3), Integer.valueOf(this.n), Integer.valueOf(i4), Boolean.valueOf(this.o) }));
    }
  }
  
  private void a(Context paramContext)
  {
    this.k = new Handler(Looper.getMainLooper());
    paramContext = inflate(paramContext, 2131625789, this);
    this.g = paramContext.findViewById(2131441259);
    this.g.setBackgroundResource(2130842928);
    this.e = ((SeekBar)paramContext.findViewById(2131441199));
    this.d = ((TextView)paramContext.findViewById(2131441198));
    this.f = ((TextView)paramContext.findViewById(2131441200));
    this.i = getResources().getDrawable(2130842936);
    this.f.setVisibility(4);
    paramContext = this.e;
    if (paramContext != null)
    {
      paramContext.setMax(100);
      this.e.setOnSeekBarChangeListener(this.c);
      this.e.getViewTreeObserver().addOnGlobalLayoutListener(new BeautySeekView.1(this));
    }
    this.j = AIOUtils.b(24.0F, getResources());
    if ((AudioHelper.a(0) == 1) && (this.e != null))
    {
      setBackgroundColor(-270080262);
      this.f.setBackgroundColor(-16777216);
      this.e.setBackgroundColor(-536871168);
      setBackgroundColor(536870656);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    Object localObject;
    if (this.n == 50)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt - 50);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.f.setText((CharSequence)localObject);
    int i1 = this.f.getWidth();
    int i2 = this.e.getWidth() - this.e.getPaddingLeft() - this.e.getPaddingRight();
    int i3 = ((RelativeLayout.LayoutParams)this.e.getLayoutParams()).leftMargin + this.e.getPaddingLeft();
    float f1 = paramInt * 1.0F / Math.abs(this.e.getMax());
    int i4 = (int)(i2 * f1 + (0.5F - f1) * this.i.getIntrinsicWidth() - i1 / 2.0F);
    ((RelativeLayout.LayoutParams)this.f.getLayoutParams()).leftMargin = (i4 + i3);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTip, progress[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], seekBarLeft[");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append("], tipWidth[");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("], thumbWidth[");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append("], seekWidth[");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append("]");
      QLog.w("BeautySeekView", 2, ((StringBuilder)localObject).toString());
    }
    this.f.requestLayout();
  }
  
  private void c(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    View localView = this.g;
    if (localView != null)
    {
      int i1;
      if (paramInt > this.n) {
        i1 = 2130842929;
      } else {
        i1 = 2130842928;
      }
      localView.setBackgroundResource(i1);
    }
    if (paramInt == 0) {
      this.i = getResources().getDrawable(2130842932);
    } else if (paramInt <= 30) {
      this.i = getResources().getDrawable(2130842934);
    } else if (paramInt <= 60) {
      this.i = getResources().getDrawable(2130842935);
    } else {
      this.i = getResources().getDrawable(2130842933);
    }
    this.e.setThumb(this.i);
  }
  
  public void a(int paramInt)
  {
    SeekBar localSeekBar = this.e;
    if (localSeekBar != null) {
      localSeekBar.setProgress(paramInt);
    }
    c(paramInt);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.m = paramString2;
    paramString2 = this.d;
    if (paramString2 != null) {
      paramString2.setText(paramString1);
    }
    if (this.n != paramInt2)
    {
      this.n = paramInt2;
      this.o = true;
      a();
    }
    a(paramInt1);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.o)
    {
      SeekBar localSeekBar = this.e;
      if ((localSeekBar != null) && (localSeekBar.getMeasuredWidth() != this.p))
      {
        this.o = false;
        a();
      }
    }
  }
  
  public void setBeautySeekActionListener(BeautySeekView.ActionListener paramActionListener)
  {
    this.l = paramActionListener;
  }
  
  public void setMarginRight(int paramInt)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((SeekBar)localObject).getLayoutParams();
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMarginRight pre[");
        localStringBuilder.append(((ViewGroup.MarginLayoutParams)localObject).leftMargin);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.i("BeautySeekView", 4, localStringBuilder.toString());
      }
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt;
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.o = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautySeekView
 * JD-Core Version:    0.7.0.1
 */