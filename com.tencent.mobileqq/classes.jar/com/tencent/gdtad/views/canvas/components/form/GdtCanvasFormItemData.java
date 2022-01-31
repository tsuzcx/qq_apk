package com.tencent.gdtad.views.canvas.components.form;

import android.text.TextUtils;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasTextData;
import java.io.Serializable;

public abstract class GdtCanvasFormItemData
  implements Serializable
{
  public int backgroundColor = 0;
  public int contentPaddingLeft;
  public int contentPaddingRight;
  public int paddingBottom;
  public int paddingTop;
  public GdtCanvasTextData placeholder = new GdtCanvasTextData();
  public boolean required;
  public GdtCanvasTextData title = new GdtCanvasTextData();
  public int titlePaddingLeft;
  public int titlePaddingRight;
  
  public abstract Object getResult();
  
  public boolean isValid()
  {
    return (this.paddingTop >= 0) && (this.paddingBottom >= 0) && (this.title != null) && (this.title.isValid()) && (!TextUtils.isEmpty(this.title.text)) && (this.titlePaddingLeft >= 0) && (this.titlePaddingRight >= 0) && (this.contentPaddingLeft >= 0) && (this.contentPaddingRight >= 0) && ((this.placeholder == null) || (this.placeholder.isValid()));
  }
  
  public abstract GdtCanvasFormError validate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormItemData
 * JD-Core Version:    0.7.0.1
 */