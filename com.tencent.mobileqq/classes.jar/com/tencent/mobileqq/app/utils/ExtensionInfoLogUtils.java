package com.tencent.mobileqq.app.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ExtensionInfoLogUtils
{
  public static void a(String paramString1, String paramString2, ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo != null) && (!TextUtils.isEmpty(paramString1))) {
      QLog.i(paramString1, 1, paramString2 + MobileQQ.getShortUinStr(paramExtensionInfo.uin) + ", intimate_type:" + paramExtensionInfo.intimate_type + ", hiddenChatSwitch:" + paramExtensionInfo.hiddenChatSwitch + ", isSharingLocation:" + paramExtensionInfo.isSharingLocation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.ExtensionInfoLogUtils
 * JD-Core Version:    0.7.0.1
 */