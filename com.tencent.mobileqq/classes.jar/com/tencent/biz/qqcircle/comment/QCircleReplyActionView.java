package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QCircleReplyActionView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  
  public QCircleReplyActionView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public QCircleReplyActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleReplyActionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560522, this, true);
    this.a = ((TextView)localView.findViewById(2131378834));
    this.b = ((TextView)localView.findViewById(2131378807));
  }
  
  public TextView a()
  {
    return this.a;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleReplyActionView
 * JD-Core Version:    0.7.0.1
 */