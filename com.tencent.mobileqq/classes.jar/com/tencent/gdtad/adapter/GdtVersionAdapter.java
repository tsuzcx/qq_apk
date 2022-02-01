package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.version.AdVersionAdapter;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;

public class GdtVersionAdapter
  implements AdVersionAdapter
{
  public String getAppVersion()
  {
    return GdtVersionUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtVersionAdapter
 * JD-Core Version:    0.7.0.1
 */