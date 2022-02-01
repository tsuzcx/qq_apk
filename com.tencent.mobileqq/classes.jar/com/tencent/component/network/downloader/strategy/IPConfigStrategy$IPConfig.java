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
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = -1;
    Iterator localIterator = this.ipInfos.iterator();
    while (localIterator.hasNext())
    {
      IPInfo localIPInfo = (IPInfo)localIterator.next();
      int j = i + 1;
      i = j;
      if (paramString.endsWith(localIPInfo.ip)) {
        this.failCount = j;
      }
    }
  }
  
  public void initStrarIndex()
  {
    ArrayList localArrayList = this.ipInfos;
    if (localArrayList != null)
    {
      if (localArrayList.size() <= 0) {
        return;
      }
      this.failCount = (Math.abs(new Random(System.currentTimeMillis()).nextInt()) % this.ipInfos.size());
    }
  }
  
  public void setFailCount(int paramInt)
  {
    this.failCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.IPConfigStrategy.IPConfig
 * JD-Core Version:    0.7.0.1
 */