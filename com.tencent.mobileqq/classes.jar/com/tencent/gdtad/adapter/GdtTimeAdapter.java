package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.net.AdTimeAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public final class GdtTimeAdapter
  implements AdTimeAdapter
{
  public long getServerTimeMillis()
  {
    return NetConnInfoCenter.getServerTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtTimeAdapter
 * JD-Core Version:    0.7.0.1
 */