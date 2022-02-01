package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AbsVideoInfoWidget$ProgressView
  extends FrameLayout
{
  private ProgressBar a;
  private TextView b;
  
  public AbsVideoInfoWidget$ProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AbsVideoInfoWidget$ProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131628218, this);
    this.a = ((ProgressBar)findViewById(2131440726));
    this.b = ((TextView)findViewById(2131447062));
  }
  
  public void setProgressText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.b.setVisibility(0);
      this.b.setText(paramCharSequence);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.ProgressView
 * JD-Core Version:    0.7.0.1
 */