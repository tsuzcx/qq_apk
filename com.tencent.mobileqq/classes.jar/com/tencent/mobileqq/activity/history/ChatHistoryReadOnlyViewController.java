package com.tencent.mobileqq.activity.history;

import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.FadeIconImageView;

public class ChatHistoryReadOnlyViewController
  extends ChatHistoryCommonViewController
{
  public static final int[] e = { 2131887738 };
  public static final int[] f = { 2131430552 };
  
  public ChatHistoryReadOnlyViewController(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  public void c()
  {
    super.c();
    this.n.setVisibility(8);
    this.o.setVisibility(8);
  }
  
  protected int[] k()
  {
    return f;
  }
  
  protected int[] l()
  {
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryReadOnlyViewController
 * JD-Core Version:    0.7.0.1
 */