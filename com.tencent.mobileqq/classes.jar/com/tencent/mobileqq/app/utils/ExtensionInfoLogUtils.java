package com.tencent.mobileqq.app.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ExtensionInfoLogUtils
{
  public static void a(String paramString1, String paramString2, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo != null) && (!TextUtils.isEmpty(paramString1)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(MobileQQ.getShortUinStr(paramExtensionInfo.uin));
      localStringBuilder.append(", intimate_type:");
      localStringBuilder.append(paramExtensionInfo.intimate_type);
      localStringBuilder.append(", hiddenChatSwitch:");
      localStringBuilder.append(paramExtensionInfo.hiddenChatSwitch);
      localStringBuilder.append(", isSharingLocation:");
      localStringBuilder.append(paramExtensionInfo.isSharingLocation);
      QLog.i(paramString1, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.ExtensionInfoLogUtils
 * JD-Core Version:    0.7.0.1
 */