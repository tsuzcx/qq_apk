package com.tencent.biz.qqcircle.utils;

import android.app.Application;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.qcircle.application.QCircleApplication;

public class QCircleTextUtils
{
  public static SpannableString a(long paramLong)
  {
    String str = QCirclePluginUtil.b(paramLong);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(QCirclePluginUtil.c(paramLong));
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(ImmersiveUtils.a(4.0F)), str.length(), str.length() + 1, 34);
    return localObject;
  }
  
  public static String a(String paramString)
  {
    return a(paramString, QCircleApplication.APP.getResources().getString(2131914013));
  }
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > paramInt)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, paramInt));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    paramString1 = paramString1.split("-");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = paramString1[i];
      if ((!TextUtils.isEmpty(localCharSequence)) && (!localCharSequence.equals(paramString2)))
      {
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localStringBuilder.append("·");
        }
        localStringBuilder.append(localCharSequence);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return TextUtils.equals(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleTextUtils
 * JD-Core Version:    0.7.0.1
 */