package com.tencent.gdtad.views.form.textbox;

import android.text.TextUtils;
import com.tencent.gdtad.views.form.framework.GdtFormItemData;
import com.tencent.gdtad.views.xijing.GdtTextData;
import yxs;
import zai;

public class GdtFormItemTextBoxData
  extends GdtFormItemData
{
  public GdtTextData content = new GdtTextData();
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
  
  public zai validate()
  {
    if (!isValid())
    {
      yxs.d("GdtFormItemTextBoxData", "validate error");
      return new zai(3, -1, null);
    }
    if ((this.required) && (TextUtils.isEmpty(getResult()))) {
      return new zai(5, -1, this.title.text);
    }
    if ((!TextUtils.isEmpty(this.regex)) && (!TextUtils.isEmpty(getResult())) && (!getResult().matches(this.regex))) {
      return new zai(6, -1, this.title.text);
    }
    return new zai(2, -1, this.title.text);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData
 * JD-Core Version:    0.7.0.1
 */