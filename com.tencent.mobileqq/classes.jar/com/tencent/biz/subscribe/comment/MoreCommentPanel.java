package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class MoreCommentPanel
  extends RelativeLayout
{
  private Context a;
  private TextView b;
  private ImageView c;
  private boolean d = false;
  
  public MoreCommentPanel(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public MoreCommentPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    try
    {
      LayoutInflater.from(this.a).inflate(2131629073, this);
      this.b = ((TextView)findViewById(2131438860));
      this.c = ((ImageView)findViewById(2131438858));
      if (this.d)
      {
        setBackgroundColor(this.a.getResources().getColor(2131167820));
        setBackgroundResource(2130851178);
        this.b.setTextColor(this.a.getResources().getColor(2131165566));
        this.c.setImageResource(2130851176);
        return;
      }
      setBackgroundColor(this.a.getResources().getColor(2131166521));
      setBackgroundResource(2130851177);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("MoreCommentPanel", 1, "init OOM", localOutOfMemoryError);
      System.gc();
    }
  }
  
  public void setHintText(CharSequence paramCharSequence)
  {
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.MoreCommentPanel
 * JD-Core Version:    0.7.0.1
 */