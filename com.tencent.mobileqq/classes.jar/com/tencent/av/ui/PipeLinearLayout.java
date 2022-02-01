package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class PipeLinearLayout
  extends FrameLayout
{
  private final int[] a = { 2131441188, 2131441189, 2131441190 };
  private final ArrayList<Long> b = new ArrayList();
  private final ArrayList<Long> c = new ArrayList();
  private TextView d;
  private RelativeLayout e;
  private volatile boolean f = false;
  private Handler g;
  private Handler h;
  private Runnable i = new PipeLinearLayout.1(this);
  
  public PipeLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PipeLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PipeLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131625764, this);
    this.g = new Handler(Looper.getMainLooper());
  }
  
  private boolean a(long paramLong)
  {
    return false;
  }
  
  private Bitmap b(long paramLong)
  {
    return null;
  }
  
  private void b()
  {
    int j = 0;
    while ((j < this.a.length) && (j < this.b.size()))
    {
      if (a(((Long)this.b.get(j)).longValue())) {
        this.c.add(this.b.get(j));
      }
      j += 1;
    }
  }
  
  private String getFriendName()
  {
    return "";
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.f = true;
    this.h.removeCallbacks(this.i);
    this.h = null;
  }
  
  public void setHeadView(TextView paramTextView)
  {
    this.d = paramTextView;
    addView(this.d);
  }
  
  public void setMemberList(Long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      this.b.clear();
      this.c.clear();
      int k = paramArrayOfLong.length;
      int j = 0;
      while (j < k)
      {
        Long localLong = paramArrayOfLong[j];
        this.b.add(localLong);
        j += 1;
      }
      this.h.removeCallbacks(this.i);
      this.h.post(this.i);
    }
  }
  
  public void setRelationShipViewParent(RelativeLayout paramRelativeLayout)
  {
    this.e = paramRelativeLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.PipeLinearLayout
 * JD-Core Version:    0.7.0.1
 */