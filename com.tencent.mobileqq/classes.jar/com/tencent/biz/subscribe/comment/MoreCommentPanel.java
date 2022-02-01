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
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = false;
  
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
    try
    {
      LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562642, this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371485));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371483));
      if (this.jdField_a_of_type_Boolean)
      {
        setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166900));
        setBackgroundResource(2130849494);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165329));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849492);
        return;
      }
      setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165878));
      setBackgroundResource(2130849493);
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
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.MoreCommentPanel
 * JD-Core Version:    0.7.0.1
 */