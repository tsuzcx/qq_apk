package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.IPInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IPConfigStrategy$IPConfig
{
  private int failCount = -1;
  public ArrayList<IPInfo> ipInfos = new ArrayList();
  
  public void appendIP(IPInfo paramIPInfo)
  {
    if (paramIPInfo == null) {
      return;
    }
    this.ipInfos.add(paramIPInfo);
  }
  
  public int getCurrFailCount()
  {
    return this.failCount;
  }
  
  public int getFailCount()
  {
    if (this.failCount < 0) {
      initStrarIndex();
    }
    return this.failCount;
  }
  
  public void initFailCount(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    IPInfo localIPInfo;
    int j;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        localIterator = this.ipInfos.iterator();
        i = -1;
      }
      localIPInfo = (IPInfo)localIterator.next();
      j = i + 1;
      int i = j;
    } while (!paramString.endsWith(localIPInfo.ip));
    this.failCount = j;
  }
  
  public void initStrarIndex()
  {
    if ((this.ipInfos == null) || (this.ipInfos.size() <= 0)) {
      return;
    }
    this.failCount = (Math.abs(new Random(System.currentTimeMillis()).nextInt()) % this.ipInfos.size());
  }
  
  public void setFailCount(int paramInt)
  {
    this.failCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.IPConfigStrategy.IPConfig
 * JD-Core Version:    0.7.0.1
 */