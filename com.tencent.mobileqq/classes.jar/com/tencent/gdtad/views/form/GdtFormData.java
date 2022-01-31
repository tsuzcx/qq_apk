package com.tencent.gdtad.views.form;

import android.text.TextUtils;
import com.tencent.gdtad.views.form.framework.GdtFormItemData;
import com.tencent.gdtad.views.form.framework.GdtFormTableData;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.io.Serializable;
import yxs;
import zai;

public class GdtFormData
  implements Serializable
{
  public int backgroundColor = 0;
  public GdtButtonData button = new GdtButtonData();
  public int buttonHeight;
  public long formId = -2147483648L;
  public int padding;
  public GdtFormTableData table = new GdtFormTableData();
  public GdtTextData title;
  public String tokenForUpload;
  
  public GdtFormItemData getItem(int paramInt)
  {
    if (isValid()) {
      return this.table.getItem(paramInt);
    }
    return null;
  }
  
  public int getSize()
  {
    if (isValid()) {
      return this.table.getSize();
    }
    return 0;
  }
  
  public boolean isValid()
  {
    return (this.formId != -2147483648L) && (this.padding >= 0) && ((this.title == null) || ((this.title.isValid()) && (!TextUtils.isEmpty(this.title.text)))) && (this.table != null) && (this.table.isValid()) && (this.button != null) && (this.button.isValid()) && (this.buttonHeight > 0);
  }
  
  public zai validate()
  {
    if (!isValid())
    {
      yxs.d("GdtFormData", "validate error");
      return new zai(3, -1, null);
    }
    return this.table.validate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.GdtFormData
 * JD-Core Version:    0.7.0.1
 */