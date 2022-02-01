package com.tencent.mm.ui.widget.textview;

class SelectableTextHelper$ImageSpanInfo
{
  int a;
  int b;
  
  SelectableTextHelper$ImageSpanInfo(SelectableTextHelper paramSelectableTextHelper) {}
  
  boolean a(int paramInt)
  {
    return (paramInt >= this.a) && (paramInt < this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" end: ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.ImageSpanInfo
 * JD-Core Version:    0.7.0.1
 */