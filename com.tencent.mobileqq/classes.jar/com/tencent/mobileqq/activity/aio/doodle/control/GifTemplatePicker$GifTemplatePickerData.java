package com.tencent.mobileqq.activity.aio.doodle.control;

public class GifTemplatePicker$GifTemplatePickerData
  extends RDBaseItemData
{
  public int a;
  public int b;
  
  public GifTemplatePicker$GifTemplatePickerData(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof GifTemplatePickerData));
      paramObject = (GifTemplatePickerData)paramObject;
    } while ((this.b != paramObject.b) || (this.a != paramObject.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker.GifTemplatePickerData
 * JD-Core Version:    0.7.0.1
 */