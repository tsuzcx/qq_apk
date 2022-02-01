package com.dataline.util.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.TextView;

public class WaitTextView
  extends TextView
{
  private Handler a;
  private String b;
  private int c = 0;
  private WaitTextView.RefreshListener d;
  private Runnable e = new WaitTextView.1(this);
  
  public WaitTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WaitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    int i = this.c;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.b);
          localStringBuilder.append("...");
          setText(localStringBuilder.toString());
          this.c = 0;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(".. ");
        setText(localStringBuilder.toString());
        this.c += 1;
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(".  ");
      setText(localStringBuilder.toString());
      this.c += 1;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("   ");
    setText(localStringBuilder.toString());
    this.c += 1;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      this.a = new Handler(Looper.getMainLooper());
      this.a.postDelayed(this.e, 500L);
    }
  }
  
  public void b()
  {
    Handler localHandler = this.a;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.e);
      this.a = null;
    }
  }
  
  public void setRefreshListener(WaitTextView.RefreshListener paramRefreshListener)
  {
    this.d = paramRefreshListener;
  }
  
  public void setWaitText(String paramString)
  {
    this.b = paramString;
    this.c = 0;
    paramString = new StringBuilder();
    paramString.append(this.b);
    paramString.append("   ");
    setText(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.widget.WaitTextView
 * JD-Core Version:    0.7.0.1
 */