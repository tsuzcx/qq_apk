package com.tencent.biz.pubaccount.readinjoy.webarticle;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJWebResourceUtil$preloadResource$runnable$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    String str1 = RIJWebResourceUtil.a(RIJWebResourceUtil.a);
    Iterator localIterator = RIJWebResourceUtil.a(RIJWebResourceUtil.a).iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(str2, "url");
      int i = StringsKt.lastIndexOf$default((CharSequence)str2, '/', 0, false, 6, null);
      int j = str2.length();
      if (str2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      str2 = str2.substring(i + 1, j);
      Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      String str3 = str1 + '/' + str2;
      QLog.i("RIJWebResourceUtil", 1, "[preloadResource] fileName = " + str2 + ", filePath = " + str3);
      RIJWebResourceUtil.a(RIJWebResourceUtil.a, str3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebResourceUtil.preloadResource.runnable.1
 * JD-Core Version:    0.7.0.1
 */