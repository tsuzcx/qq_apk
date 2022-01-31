package com.tencent.gdtad.views.canvas.components.form.textbox;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormError;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemData;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;

public class GdtCanvasFormItemTextBoxData
  extends GdtCanvasFormItemData
{
  public GdtCanvasTextData content = new GdtCanvasTextData();
  public int lines = 1;
  public String regex;
  public int regexType = -2147483648;
  
  public String getResult()
  {
    if (TextUtils.isEmpty(this.content.text)) {
      return "";
    }
    return this.content.text;
  }
  
  public boolean isValid()
  {
    return super.isValid();
  }
  
  public GdtCanvasFormError validate()
  {
    if (!isValid())
    {
      GdtLog.d("GdtCanvasFormItemTextBoxData", "validate error");
      return new GdtCanvasFormError(3, -1, null);
    }
    if ((this.required) && (TextUtils.isEmpty(getResult()))) {
      return new GdtCanvasFormError(5, -1, this.title.text);
    }
    if ((!TextUtils.isEmpty(this.regex)) && (!TextUtils.isEmpty(getResult())) && (!getResult().matches(this.regex))) {
      return new GdtCanvasFormError(6, -1, this.title.text);
    }
    return new GdtCanvasFormError(2, -1, this.title.text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.textbox.GdtCanvasFormItemTextBoxData
 * JD-Core Version:    0.7.0.1
 */