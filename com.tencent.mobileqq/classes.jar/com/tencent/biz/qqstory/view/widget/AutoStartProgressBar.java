package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.MessageProgressView;

public class AutoStartProgressBar
  extends MessageProgressView
{
  protected static int a = 50;
  protected static int b = -1;
  protected int c = 100;
  protected String d;
  protected boolean e = false;
  
  public AutoStartProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoStartProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AutoStartProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private double a(int paramInt)
  {
    if (paramInt == b)
    {
      double d1 = this.h;
      Double.isNaN(d1);
      double d2 = this.c;
      Double.isNaN(d2);
      return Math.pow(10.0D - (1.0D - d1 * 1.0D / d2) * 100.0D, 2.5D);
    }
    return 0.0D;
  }
  
  public void a()
  {
    if (!c(this.d))
    {
      this.h = 0;
      this.e = false;
      new AutoStartProgressBar.ProgressThread(this, null).start();
    }
  }
  
  public void b()
  {
    setAnimProgress(100, this.d);
    this.e = true;
  }
  
  public void setKey(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AutoStartProgressBar
 * JD-Core Version:    0.7.0.1
 */