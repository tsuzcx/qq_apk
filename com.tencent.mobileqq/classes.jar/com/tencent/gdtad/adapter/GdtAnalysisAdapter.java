package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.analysis.AdAnalysisAdapter;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;

public class GdtAnalysisAdapter
  implements AdAnalysisAdapter
{
  public String getAppVersion()
  {
    return GdtVersionUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtAnalysisAdapter
 * JD-Core Version:    0.7.0.1
 */