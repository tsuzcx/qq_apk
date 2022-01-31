package com.tencent.intervideo.nowproxy.common.util;

import android.content.Context;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;

public class ToastUtil
{
  public static void show(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    SdkBaseAbilityImpl.getsInstance().showToast(paramContext, paramCharSequence, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.util.ToastUtil
 * JD-Core Version:    0.7.0.1
 */