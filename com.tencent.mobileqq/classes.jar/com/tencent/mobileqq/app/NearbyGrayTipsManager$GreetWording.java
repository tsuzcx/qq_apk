package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;

public class NearbyGrayTipsManager$GreetWording
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long createTime;
  public int id;
  public int lastIndex;
  public List<String> list;
  
  public NearbyGrayTipsManager$GreetWording()
  {
    this(0);
    if (QLog.isDevelopLevel()) {
      QLog.i("nearby_aio_operation_gray_tips", 4, "GreetWording");
    }
  }
  
  public NearbyGrayTipsManager$GreetWording(int paramInt)
  {
    this.id = paramInt;
    this.createTime = 0L;
    this.list = new ArrayList(20);
    this.lastIndex = -1;
  }
  
  public static String getPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NearbyGrayTipsManager.a());
    localStringBuilder.append(GreetWording.class.getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public String getWording(Random paramRandom)
  {
    synchronized (this.list)
    {
      int k = this.list.size();
      if (k > 0)
      {
        int j = paramRandom.nextInt(k);
        int i = j;
        if (j == this.lastIndex) {
          i = (this.lastIndex + 1) % k;
        }
        this.lastIndex = i;
        paramRandom = (String)this.list.get(i);
      }
      else
      {
        paramRandom = "";
      }
      return paramRandom;
    }
  }
  
  public void saveWording(long paramLong, List<String> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject2 = null;
      synchronized (this.list)
      {
        Object localObject1;
        if (this.list.size() != 0)
        {
          localObject1 = localObject2;
          if (this.createTime >= paramLong) {}
        }
        else
        {
          this.createTime = paramLong;
          this.list.clear();
          this.list.addAll(paramList);
          localObject1 = localObject2;
          if (paramBoolean)
          {
            localObject1 = new GreetWording(this.id);
            ((GreetWording)localObject1).createTime = this.createTime;
            ((GreetWording)localObject1).lastIndex = this.lastIndex;
            ((GreetWording)localObject1).list.addAll(paramList);
          }
        }
        if ((paramBoolean) && (localObject1 != null)) {
          ThreadManager.getFileThreadHandler().post(new NearbyGrayTipsManager.GreetWording.1(this, (GreetWording)localObject1));
        }
        return;
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('[');
    localStringBuffer.append(this.id);
    localStringBuffer.append(',');
    localStringBuffer.append(this.createTime);
    localStringBuffer.append(',');
    localStringBuffer.append(this.lastIndex);
    localStringBuffer.append(',');
    if (this.list.size() == 0)
    {
      localStringBuffer.append("size is 0");
    }
    else
    {
      localStringBuffer.append("size = ");
      localStringBuffer.append(this.list.size());
      localStringBuffer.append('(');
      Iterator localIterator = this.list.iterator();
      while (localIterator.hasNext())
      {
        localStringBuffer.append((String)localIterator.next());
        localStringBuffer.append(',');
      }
      localStringBuffer.append(')');
    }
    localStringBuffer.append(']');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.GreetWording
 * JD-Core Version:    0.7.0.1
 */