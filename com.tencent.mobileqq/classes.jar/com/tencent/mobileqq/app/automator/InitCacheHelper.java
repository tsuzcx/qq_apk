package com.tencent.mobileqq.app.automator;

import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor;
import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor.Config;
import com.tencent.qphone.base.util.QLog;

class InitCacheHelper
{
  String a()
  {
    boolean bool = a();
    String str1;
    if (bool) {
      str1 = "[";
    } else {
      str1 = "{";
    }
    String str2;
    if (bool) {
      str2 = "]";
    } else {
      str2 = "}";
    }
    QLog.d("QQInitHandler", 1, new Object[] { "isParall:", Boolean.valueOf(bool), ", prefix: ", str1, ", postfix:", str2 });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(4);
    localStringBuilder.append(",");
    localStringBuilder.append(3);
    localStringBuilder.append(",");
    localStringBuilder.append(5);
    localStringBuilder.append(",");
    localStringBuilder.append(6);
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  boolean a()
  {
    return CommonFunctionPublishConfigProcessor.a().e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.InitCacheHelper
 * JD-Core Version:    0.7.0.1
 */