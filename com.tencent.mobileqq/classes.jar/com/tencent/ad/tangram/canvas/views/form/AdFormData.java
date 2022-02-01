package com.tencent.ad.tangram.canvas.views.form;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.canvas.views.xijing.a;
import com.tencent.ad.tangram.log.AdLog;
import java.io.Serializable;

@Keep
public class AdFormData
  implements Serializable
{
  private static final String TAG = "AdFormData";
  public int backgroundColor = 0;
  public a button = new a();
  public int buttonHeight;
  public long formId = -2147483648L;
  public int padding = 0;
  public AdFormTableData table = new AdFormTableData();
  public AdTextData title;
  public String tokenForUpload;
  
  public AdFormItemData getItem(int paramInt)
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
  
  public AdFormError validate()
  {
    if (!isValid())
    {
      AdLog.e("AdFormData", "validate error");
      return new AdFormError(3, -1, null);
    }
    return this.table.validate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.AdFormData
 * JD-Core Version:    0.7.0.1
 */