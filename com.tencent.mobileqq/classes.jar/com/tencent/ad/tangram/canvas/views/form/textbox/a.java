package com.tencent.ad.tangram.canvas.views.form.textbox;

import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.form.AdFormError;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.log.AdLog;

public final class a
  extends AdFormItemData
{
  private static final String TAG = "AdFormItemTextBoxData";
  public AdTextData content = new AdTextData();
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
  
  public AdFormError validate()
  {
    if (!isValid())
    {
      AdLog.e("AdFormItemTextBoxData", "validate error");
      return new AdFormError(3, -1, null);
    }
    if ((this.required) && (TextUtils.isEmpty(getResult()))) {
      return new AdFormError(5, -1, this.title.text);
    }
    if ((!TextUtils.isEmpty(this.regex)) && (!TextUtils.isEmpty(getResult())) && (!getResult().matches(this.regex))) {
      return new AdFormError(6, -1, this.title.text);
    }
    return new AdFormError(2, -1, this.title.text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.textbox.a
 * JD-Core Version:    0.7.0.1
 */