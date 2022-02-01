package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

class ChatHistoryBaseFragment$ProgressView
  extends FrameLayout
{
  private ProgressBar a;
  private TextView b;
  
  public ChatHistoryBaseFragment$ProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ChatHistoryBaseFragment$ProgressView(Context paramContext, AttributeSet paramAttributeSet)
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
  
  public void a(CharSequence paramCharSequence)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment.ProgressView
 * JD-Core Version:    0.7.0.1
 */