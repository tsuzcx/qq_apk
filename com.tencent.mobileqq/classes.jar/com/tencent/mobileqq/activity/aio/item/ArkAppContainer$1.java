package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.base.DefaultApplicationCallback;

final class ArkAppContainer$1
  extends DefaultApplicationCallback
{
  protected boolean a(String paramString)
  {
    if (!super.a(paramString)) {
      return false;
    }
    return ArkAppCenterUtil.a() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer.1
 * JD-Core Version:    0.7.0.1
 */