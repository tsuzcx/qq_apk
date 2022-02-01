package com.tencent.av.ManageConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AVTestforEncDecConfig$TestInfo
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public ArrayList<Integer> d = null;
  public int e = 0;
  public String f = null;
  public int g = 0;
  public HashMap<String, AVTestforEncDecConfig.Sample> h;
  public boolean i = false;
  public long j = 0L;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("TestInfo{");
    localStringBuffer.append("taskId='");
    localStringBuffer.append(this.a);
    localStringBuffer.append('\'');
    localStringBuffer.append(", codec=");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", min_sdk=");
    localStringBuffer.append(this.c);
    localStringBuffer.append(", async_min_sdk=");
    localStringBuffer.append(this.e);
    localStringBuffer.append(", min_version=");
    localStringBuffer.append(this.f);
    localStringBuffer.append(", test_ver=");
    localStringBuffer.append(this.g);
    if (this.d != null)
    {
      localStringBuffer.append(", disable_sdks=");
      localStringBuffer.append(Arrays.toString(this.d.toArray()));
    }
    Object localObject1 = this.h;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (AVTestforEncDecConfig.Sample)((Map.Entry)localObject2).getValue();
        localStringBuffer.append(", codecKey=");
        localStringBuffer.append(str);
        localStringBuffer.append(", codecValue=");
        localStringBuffer.append(localObject2);
      }
    }
    localStringBuffer.append(", upload = ");
    localStringBuffer.append(this.i);
    localStringBuffer.append(", expdate = ");
    localStringBuffer.append(this.j);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ManageConfig.AVTestforEncDecConfig.TestInfo
 * JD-Core Version:    0.7.0.1
 */