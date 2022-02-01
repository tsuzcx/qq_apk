package com.tencent.ad.tangram.views.form.framework;

import android.text.TextUtils;
import com.tencent.ad.tangram.views.form.AdFormError;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import java.io.Serializable;

public abstract class d
  implements Serializable
{
  public int backgroundColor = 0;
  public int contentPaddingLeft = 0;
  public int contentPaddingRight = 0;
  public int paddingBottom = 0;
  public int paddingTop = 0;
  public AdTextData placeholder;
  public boolean required;
  public AdTextData title = new AdTextData();
  public int titlePaddingLeft = 0;
  public int titlePaddingRight = 0;
  
  public abstract Object getResult();
  
  public boolean isValid()
  {
    if ((this.paddingTop >= 0) && (this.paddingBottom >= 0))
    {
      AdTextData localAdTextData = this.title;
      if ((localAdTextData != null) && (localAdTextData.isValid()) && (!TextUtils.isEmpty(this.title.text)) && (this.titlePaddingLeft >= 0) && (this.titlePaddingRight >= 0) && (this.contentPaddingLeft >= 0) && (this.contentPaddingRight >= 0))
      {
        localAdTextData = this.placeholder;
        if ((localAdTextData == null) || (localAdTextData.isValid())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public abstract AdFormError validate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.d
 * JD-Core Version:    0.7.0.1
 */