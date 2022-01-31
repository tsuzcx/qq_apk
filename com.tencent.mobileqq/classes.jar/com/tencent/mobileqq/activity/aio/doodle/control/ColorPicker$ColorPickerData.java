package com.tencent.mobileqq.activity.aio.doodle.control;

public class ColorPicker$ColorPickerData
  extends RDBaseItemData
{
  public int a;
  public int b;
  public int c;
  
  public ColorPicker$ColorPickerData(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof ColorPickerData));
      paramObject = (ColorPickerData)paramObject;
    } while ((this.a != paramObject.a) || (this.c != paramObject.c) || (this.b != paramObject.b));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker.ColorPickerData
 * JD-Core Version:    0.7.0.1
 */