package com.tencent.av.ui.funchat.record;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class QavRecordUtils
{
  public static int a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseMaxRecordTime ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", def=");
    localStringBuilder.append(paramInt);
    QLog.i("QavRecordUtils", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    int i = paramString.lastIndexOf("#");
    if (i >= 0)
    {
      if (i == paramString.length() - 1) {
        return paramInt;
      }
      paramString = paramString.substring(i + 1);
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString) {}
    return paramInt;
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordUtils
 * JD-Core Version:    0.7.0.1
 */