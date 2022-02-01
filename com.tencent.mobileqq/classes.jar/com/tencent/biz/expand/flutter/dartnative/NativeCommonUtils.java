package com.tencent.biz.expand.flutter.dartnative;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/flutter/dartnative/NativeCommonUtils;", "Lcom/tencent/biz/expand/flutter/dartnative/DartNativeBase;", "()V", "getServerTime", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class NativeCommonUtils
  extends DartNativeBase
{
  public final long getServerTime()
  {
    return NetConnInfoCenter.getServerTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.dartnative.NativeCommonUtils
 * JD-Core Version:    0.7.0.1
 */