package com.tencent.av.wtogether.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.widget.ListView;

public abstract class QBaseContentView
  extends RelativeLayout
{
  protected QBaseActivity a;
  protected BaseQQAppInterface b;
  View c;
  
  public QBaseContentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QBaseContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QBaseContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = ((QBaseActivity)paramContext);
    this.b = ((BaseQQAppInterface)this.a.getAppRuntime());
  }
  
  public abstract void a();
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract ListView getScrollableView();
  
  protected void setContentView(int paramInt)
  {
    this.c = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.view.QBaseContentView
 * JD-Core Version:    0.7.0.1
 */