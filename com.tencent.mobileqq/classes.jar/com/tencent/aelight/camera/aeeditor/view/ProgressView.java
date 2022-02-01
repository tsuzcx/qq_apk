package com.tencent.aelight.camera.aeeditor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressView
  extends FrameLayout
{
  private ProgressBar a;
  private TextView b;
  
  public ProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131625585, this);
    this.a = ((ProgressBar)findViewById(2131440190));
    this.b = ((TextView)findViewById(2131440191));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.ProgressView
 * JD-Core Version:    0.7.0.1
 */