package com.tencent.gdtad.views.form.framework;

import android.text.TextUtils;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.io.Serializable;
import zai;

public abstract class GdtFormItemData
  implements Serializable
{
  public int backgroundColor = 0;
  public int contentPaddingLeft;
  public int contentPaddingRight;
  public int paddingBottom;
  public int paddingTop;
  public GdtTextData placeholder;
  public boolean required;
  public GdtTextData title = new GdtTextData();
  public int titlePaddingLeft;
  public int titlePaddingRight;
  
  public abstract Object getResult();
  
  public boolean isValid()
  {
    return (this.paddingTop >= 0) && (this.paddingBottom >= 0) && (this.title != null) && (this.title.isValid()) && (!TextUtils.isEmpty(this.title.text)) && (this.titlePaddingLeft >= 0) && (this.titlePaddingRight >= 0) && (this.contentPaddingLeft >= 0) && (this.contentPaddingRight >= 0) && ((this.placeholder == null) || (this.placeholder.isValid()));
  }
  
  public abstract zai validate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.framework.GdtFormItemData
 * JD-Core Version:    0.7.0.1
 */