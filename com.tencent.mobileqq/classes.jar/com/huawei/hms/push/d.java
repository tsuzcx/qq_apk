package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.support.log.HMSLog;

public class d
{
  public static ErrorEnum a(Context paramContext)
  {
    if (TextUtils.isEmpty(BaseUtils.getLocalToken(paramContext, null)))
    {
      if (AutoInitHelper.isAutoInitEnabled(paramContext))
      {
        HMSLog.e("TokenUtil", "Token not exist, try auto init");
        AutoInitHelper.doAutoInit(paramContext);
        return ErrorEnum.ERROR_AUTO_INITIALIZING;
      }
      HMSLog.e("TokenUtil", "Token not exist");
      return ErrorEnum.ERROR_NO_TOKEN;
    }
    return ErrorEnum.SUCCESS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.d
 * JD-Core Version:    0.7.0.1
 */