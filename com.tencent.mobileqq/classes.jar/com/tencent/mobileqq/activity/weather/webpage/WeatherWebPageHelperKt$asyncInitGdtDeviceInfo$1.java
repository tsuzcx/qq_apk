package com.tencent.mobileqq.activity.weather.webpage;

import amfb;
import bhcu;
import bmkk;
import bmkl;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class WeatherWebPageHelperKt$asyncInitGdtDeviceInfo$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    Object localObject = bmkk.a.a().a("a03996");
    if (localObject != null)
    {
      Charset localCharset = Charsets.UTF_8;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      localObject = ((String)localObject).getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).getBytes(charset)");
    }
    for (localObject = bhcu.encodeToString((byte[])localObject, 2);; localObject = null)
    {
      amfb.a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("WeatherWebPageHelper", 2, "gdt device info for weather 2.0 updated:" + amfb.b());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.asyncInitGdtDeviceInfo.1
 * JD-Core Version:    0.7.0.1
 */