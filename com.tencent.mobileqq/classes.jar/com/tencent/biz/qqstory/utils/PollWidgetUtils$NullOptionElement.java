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
  
  public int a()
  {
    SLog.e("NullOptionElement", "getOptionIndex() on %d", new Object[] { Integer.valueOf(this.a) });
    return this.a;
  }
  
  public CharSequence a()
  {
    SLog.e("NullOptionElement", "getText() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
  
  public void a(CharSequence paramCharSequence)
  {
    SLog.e("NullOptionElement", "setText() on %d", new Object[] { Integer.valueOf(this.a) });
  }
  
  public void a(boolean paramBoolean) {}
  
  public CharSequence b()
  {
    SLog.e("NullOptionElement", "getHint() on %d", new Object[] { Integer.valueOf(this.a) });
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.NullOptionElement
 * JD-Core Version:    0.7.0.1
 */