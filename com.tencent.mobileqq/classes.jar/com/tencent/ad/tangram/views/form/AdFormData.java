package com.tencent.ad.tangram.views.form;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.form.framework.d;
import com.tencent.ad.tangram.views.form.framework.g;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import com.tencent.ad.tangram.views.xijing.a;
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
  public g table = new g();
  public AdTextData title;
  public String tokenForUpload;
  
  public d getItem(int paramInt)
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
    if ((this.formId != -2147483648L) && (this.padding >= 0))
    {
      Object localObject = this.title;
      if ((localObject == null) || ((((AdTextData)localObject).isValid()) && (!TextUtils.isEmpty(this.title.text))))
      {
        localObject = this.table;
        if ((localObject != null) && (((g)localObject).isValid()))
        {
          localObject = this.button;
          if ((localObject != null) && (((a)localObject).isValid()) && (this.buttonHeight > 0)) {
            return true;
          }
        }
      }
    }
    return false;
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
 * Qualified Name:     com.tencent.ad.tangram.views.form.AdFormData
 * JD-Core Version:    0.7.0.1
 */