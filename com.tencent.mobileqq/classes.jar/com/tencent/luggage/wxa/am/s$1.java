package com.tencent.luggage.wxa.am;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ao.o;
import com.tencent.luggage.wxa.ao.x;

final class s$1
  implements o<String>
{
  public boolean a(String paramString)
  {
    paramString = x.d(paramString);
    return (!TextUtils.isEmpty(paramString)) && ((!paramString.contains("text")) || (paramString.contains("text/vtt"))) && (!paramString.contains("html")) && (!paramString.contains("xml"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.s.1
 * JD-Core Version:    0.7.0.1
 */