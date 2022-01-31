package com.tencent.ad.tangram.canvas.views.canvas.components.form;

import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.log.AdLog;

public class a
  extends AdCanvasComponentData
{
  private static final String TAG = "AdCanvasFormComponentData";
  public AdFormData data = new AdFormData();
  public int index = -2147483648;
  
  public boolean isValid()
  {
    return (super.isValid()) && (this.data != null) && (this.index != -2147483648);
  }
  
  public AdFormError validate()
  {
    if (!isValid())
    {
      AdLog.e("AdCanvasFormComponentData", "validate error");
      return new AdFormError(3, -1, null);
    }
    return this.data.validate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.form.a
 * JD-Core Version:    0.7.0.1
 */