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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramObject instanceof GifTemplatePickerData))
    {
      paramObject = (GifTemplatePickerData)paramObject;
      bool1 = bool2;
      if (this.b == paramObject.b)
      {
        bool1 = bool2;
        if (this.a == paramObject.a) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker.GifTemplatePickerData
 * JD-Core Version:    0.7.0.1
 */