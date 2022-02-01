package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QavMenuBaseView
  extends RelativeLayout
{
  protected String g;
  protected VideoAppInterface h = null;
  protected QavPanel i = null;
  
  public QavMenuBaseView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavMenuBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavMenuBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], onBegin[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, panel[");
      localStringBuilder.append(paramQavPanel);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    this.i = paramQavPanel;
    if (paramQavPanel != null) {
      this.h = paramQavPanel.U;
    }
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.g, 4, "refreshUI");
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    this.i = null;
    this.h = null;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHide, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], onBegin[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavMenuBaseView
 * JD-Core Version:    0.7.0.1
 */