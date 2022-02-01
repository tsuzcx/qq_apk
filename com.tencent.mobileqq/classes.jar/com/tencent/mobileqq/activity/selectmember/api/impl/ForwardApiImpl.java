package com.tencent.mobileqq.activity.selectmember.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.activity.selectmember.api.IForwardApi;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;

public class ForwardApiImpl
  implements IForwardApi
{
  public void startGameSdkCallback(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    ForwardSdkShareOption.a(paramActivity, paramBoolean, paramString1, paramLong, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.api.impl.ForwardApiImpl
 * JD-Core Version:    0.7.0.1
 */