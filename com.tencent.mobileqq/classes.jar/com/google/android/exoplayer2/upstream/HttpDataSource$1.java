package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;

final class HttpDataSource$1
  implements Predicate<String>
{
  public boolean evaluate(String paramString)
  {
    paramString = Util.toLowerInvariant(paramString);
    return (!TextUtils.isEmpty(paramString)) && ((!paramString.contains("text")) || (paramString.contains("text/vtt"))) && (!paramString.contains("html")) && (!paramString.contains("xml"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.HttpDataSource.1
 * JD-Core Version:    0.7.0.1
 */