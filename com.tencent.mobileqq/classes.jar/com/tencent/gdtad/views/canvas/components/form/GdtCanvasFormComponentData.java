package com.tencent.gdtad.views.canvas.components.form;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasButtonData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;

public class GdtCanvasFormComponentData
  extends GdtCanvasComponentData
{
  public int backgroundColor = 0;
  public GdtCanvasButtonData button = new GdtCanvasButtonData();
  public int buttonHeight;
  public long formId = -2147483648L;
  public int padding;
  public GdtCanvasFormTableData table = new GdtCanvasFormTableData();
  public GdtCanvasTextData title;
  public String tokenForUpload;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.formId != -2147483648L) && (this.padding >= 0) && ((this.title == null) || ((this.title.isValid()) && (!TextUtils.isEmpty(this.title.text)))) && (this.table != null) && (this.table.isValid()) && (this.button != null) && (this.button.isValid()) && (this.buttonHeight > 0);
  }
  
  public GdtCanvasFormError validate()
  {
    if (!isValid())
    {
      GdtLog.d("GdtCanvasFormComponentData", "validate error");
      return new GdtCanvasFormError(3, -1, null);
    }
    return this.table.validate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData
 * JD-Core Version:    0.7.0.1
 */