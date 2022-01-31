package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.soso.SosoInterface;
import rcb;
import rcc;

public class SensorModule
  extends DoraemonAPIModule
{
  public boolean a(int paramInt, String paramString, APIParam paramAPIParam, @NonNull APICallback paramAPICallback)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 3: 
      SosoInterface.a(new rcc(paramAPICallback, DoraemonUtil.a(paramAPIParam, "allowCacheTime", Integer.valueOf(10)).intValue() * 1000L));
    }
    for (;;)
    {
      return true;
      SosoInterface.a(new rcb(paramAPICallback, DoraemonUtil.a(paramAPIParam, "allowCacheTime", Integer.valueOf(10)).intValue() * 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.SensorModule
 * JD-Core Version:    0.7.0.1
 */