package com.tencent.biz.qqstory.utils;

class PollWidgetUtils$WidgetWrapper$1
  implements PollWidgetUtils.OnSelectedChangedListener
{
  PollWidgetUtils$WidgetWrapper$1(PollWidgetUtils.WidgetWrapper paramWidgetWrapper) {}
  
  public void a(PollWidgetUtils.WidgetElement paramWidgetElement, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      PollWidgetUtils.WidgetElement[] arrayOfWidgetElement = this.a.d();
      j = arrayOfWidgetElement.length;
      i = 0;
      while (i < j)
      {
        PollWidgetUtils.WidgetElement localWidgetElement = arrayOfWidgetElement[i];
        if (localWidgetElement != paramWidgetElement) {
          localWidgetElement.a(false);
        }
        i += 1;
      }
    }
    paramWidgetElement = this.a.d();
    int j = paramWidgetElement.length;
    while (i < j)
    {
      if (paramWidgetElement[i].b()) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper.1
 * JD-Core Version:    0.7.0.1
 */