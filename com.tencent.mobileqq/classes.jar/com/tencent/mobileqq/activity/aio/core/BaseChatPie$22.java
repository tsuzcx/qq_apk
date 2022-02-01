package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import java.util.Map;

class BaseChatPie$22
  extends RoamSettingObserver
{
  BaseChatPie$22(BaseChatPie paramBaseChatPie) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      BaseChatPie.a(this.a, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.22
 * JD-Core Version:    0.7.0.1
 */