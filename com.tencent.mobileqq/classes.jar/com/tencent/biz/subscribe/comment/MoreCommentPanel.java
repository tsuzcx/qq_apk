package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MoreCommentPanel
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  
  public MoreCommentPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public MoreCommentPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562441, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370715));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370713));
    if (this.jdField_a_of_type_Boolean)
    {
      setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166762));
      setBackgroundResource(2130848644);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165311));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848642);
      return;
    }
    setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165796));
    setBackgroundResource(2130848643);
  }
  
  public void setHintText(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.MoreCommentPanel
 * JD-Core Version:    0.7.0.1
 */