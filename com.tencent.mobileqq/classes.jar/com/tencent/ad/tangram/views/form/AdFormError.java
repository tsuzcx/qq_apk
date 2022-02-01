package com.tencent.ad.tangram.views.form;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;

@Keep
public class AdFormError
{
  public static final int ERROR_COMMIT = 4;
  public static final int ERROR_DUPLICATE = 7;
  public static final int ERROR_REGEX = 6;
  public static final int ERROR_REQUIRED = 5;
  public static final int ERROR_UNKNOWN = 3;
  public static final int SUCCESS_COMMIT = 1;
  public static final int SUCCESS_EDIT = 2;
  private static final String TAG = "AdFormError";
  public int index = -1;
  public String title;
  public int type = 3;
  
  public AdFormError(int paramInt1, int paramInt2, String paramString)
  {
    this.type = paramInt1;
    this.index = paramInt2;
    this.title = paramString;
  }
  
  public String toString()
  {
    if (TextUtils.isEmpty(this.title))
    {
      AdLog.e("AdFormError", "toString error");
      return null;
    }
    int i = this.type;
    if (i != 5)
    {
      if (i != 6)
      {
        AdLog.e("AdFormError", "toString error");
        return null;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("请填写正确的");
      localStringBuilder.append(this.title);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("请填写");
    localStringBuilder.append(this.title);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.AdFormError
 * JD-Core Version:    0.7.0.1
 */