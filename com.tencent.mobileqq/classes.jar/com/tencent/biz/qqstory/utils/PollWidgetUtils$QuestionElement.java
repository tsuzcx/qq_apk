package com.tencent.biz.qqstory.utils;

import android.view.View;
import android.widget.TextView;

public class PollWidgetUtils$QuestionElement
  extends PollWidgetUtils.WidgetElement
{
  TextView a;
  
  public PollWidgetUtils$QuestionElement(PollWidgetUtils.WidgetWrapper paramWidgetWrapper, View paramView)
  {
    super(paramWidgetWrapper, paramView);
    this.a = ((TextView)paramView.findViewById(2131369073));
    this.a.setMaxLines(1);
    this.a.setSingleLine();
  }
  
  public CharSequence a()
  {
    return this.a.getText();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    this.a.setText(paramCharSequence);
    paramCharSequence = PollWidgetUtils.a(this.a, 1);
    this.a.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setBackgroundResource(2130841930);
      return;
    }
    this.a.setBackgroundResource(0);
  }
  
  public CharSequence b()
  {
    return this.a.getHint();
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.a.setHint(paramCharSequence);
    this.a.setGravity(17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.QuestionElement
 * JD-Core Version:    0.7.0.1
 */