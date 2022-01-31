package com.tencent.gdtad.views.canvas.components.form;

import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.form.GdtFormData;
import yxp;
import zaf;

public class GdtCanvasFormComponentData
  extends GdtCanvasComponentData
{
  public GdtFormData data = new GdtFormData();
  public int index = -2147483648;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.data != null) && (this.index != -2147483648);
  }
  
  public zaf validate()
  {
    if (!isValid())
    {
      yxp.d("GdtCanvasFormComponentData", "validate error");
      return new zaf(3, -1, null);
    }
    return this.data.validate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData
 * JD-Core Version:    0.7.0.1
 */