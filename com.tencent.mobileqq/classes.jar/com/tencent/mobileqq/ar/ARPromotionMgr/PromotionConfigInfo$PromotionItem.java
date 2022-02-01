package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class PromotionConfigInfo$PromotionItem
{
  long a;
  long b;
  public boolean c = false;
  public long d = 0L;
  public String e;
  public String f;
  HashMap<Integer, String> g = new HashMap();
  private ArCloudConfigInfo h = null;
  private final TreeMap<Integer, PromotionConfigInfo.ZipItem> i = new TreeMap();
  
  public ArCloudConfigInfo a()
  {
    return this.h;
  }
  
  public String a(int paramInt)
  {
    return (String)this.g.get(Integer.valueOf(paramInt));
  }
  
  public TreeMap<Integer, PromotionConfigInfo.ZipItem> b()
  {
    return this.i;
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("id[");
    ((StringBuilder)localObject1).append(this.e);
    ((StringBuilder)localObject1).append("], recoglizeMask[");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject2 = this.i.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PromotionConfigInfo.ZipItem localZipItem = (PromotionConfigInfo.ZipItem)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\n");
        localStringBuilder.append(localZipItem);
        localObject1 = localStringBuilder.toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", begin[");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append("], end[");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("], title[");
      ((StringBuilder)localObject2).append(this.f);
      ((StringBuilder)localObject2).append("], tips[");
      ((StringBuilder)localObject2).append(this.g.size());
      ((StringBuilder)localObject2).append("]");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem
 * JD-Core Version:    0.7.0.1
 */