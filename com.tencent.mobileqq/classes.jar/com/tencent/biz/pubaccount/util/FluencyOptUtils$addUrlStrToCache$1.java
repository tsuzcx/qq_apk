package com.tencent.biz.pubaccount.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import uro;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class FluencyOptUtils$addUrlStrToCache$1
  implements Runnable
{
  public FluencyOptUtils$addUrlStrToCache$1(String paramString) {}
  
  public final void run()
  {
    try
    {
      URL localURL = new URL(this.a);
      uro.a(uro.a).put(this.a, localURL);
      return;
    }
    catch (MalformedURLException localMalformedURLException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.FluencyOptUtils.addUrlStrToCache.1
 * JD-Core Version:    0.7.0.1
 */