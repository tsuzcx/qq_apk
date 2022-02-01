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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramObject instanceof ColorPickerData))
    {
      paramObject = (ColorPickerData)paramObject;
      bool1 = bool2;
      if (this.a == paramObject.a)
      {
        bool1 = bool2;
        if (this.c == paramObject.c)
        {
          bool1 = bool2;
          if (this.b == paramObject.b) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker.ColorPickerData
 * JD-Core Version:    0.7.0.1
 */