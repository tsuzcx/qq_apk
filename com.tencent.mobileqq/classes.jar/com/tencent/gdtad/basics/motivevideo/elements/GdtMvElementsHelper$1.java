package com.tencent.gdtad.basics.motivevideo.elements;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class GdtMvElementsHelper$1
  implements ValueCallback<String>
{
  GdtMvElementsHelper$1(GdtMvElementsHelper paramGdtMvElementsHelper) {}
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callJs onReceiveValue ");
    localStringBuilder.append(paramString);
    QLog.i("GdtMvElementsHelper", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsHelper.1
 * JD-Core Version:    0.7.0.1
 */