package com.tencent.gdtad.basics.motivebrowsing;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"}, k=3, mv={1, 1, 16})
final class GdtMotiveBrowsingDialog$handleMotiveBrowsingData$1<T>
  implements ValueCallback<String>
{
  public static final 1 a = new 1();
  
  public final void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMotiveBrowsingData EVENT_CALL_BACK_JS callback ");
    localStringBuilder.append(paramString);
    QLog.i("GdtMotiveBrowsingDialog", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog.handleMotiveBrowsingData.1
 * JD-Core Version:    0.7.0.1
 */