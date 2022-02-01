package com.tencent.biz.qqstory.utils;

import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;

public class PollWidgetUtils$NullOptionElement
  extends PollWidgetUtils.OptionElement
{
  public int a;
  
  public PollWidgetUtils$NullOptionElement(PollWidgetUtils.WidgetWrapper paramWidgetWrapper, View paramView, int paramInt)
  {
    super(paramWidgetWrapper, paramView);
    this.a = paramInt;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    SLog.e("NullOptionElement", "setText() on %d", new Object[] { Integer.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.NullOptionElement
 * JD-Core Version:    0.7.0.1
 */