package com.tencent.biz.qqstory.album.tools.kmeans;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class KmeansPlus<T>
{
  private List<T> a;
  private List<T> b;
  private List<List<T>> c;
  
  private String a(long[] paramArrayOfLong, List<List<List<T>>> paramList, List<List<T>> paramList1)
  {
    Object localObject1 = new String[paramArrayOfLong.length];
    paramList = paramList.iterator();
    int j = 0;
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject2 = (List)paramList.next();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("k=");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(":");
      localObject1[i] = ((StringBuilder)localObject3).toString();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (List)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject1[i]);
        localStringBuilder.append("+");
        localStringBuilder.append(String.valueOf(((List)localObject3).size()));
        localObject1[i] = localStringBuilder.toString();
      }
      i += 1;
    }
    paramArrayOfLong = Arrays.toString(paramArrayOfLong);
    paramList = new StringBuilder();
    paramList.append("kmeans run k=");
    paramList.append(paramList1.size());
    paramList.append(" sse : ");
    paramList.append(paramArrayOfLong);
    paramList.append(" temp=");
    paramList.append(Arrays.toString((Object[])localObject1));
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.K_means", paramList.toString());
    paramList = new StringBuilder();
    paramList.append("(k=");
    paramList.append(paramList1.size());
    paramList.append(" ");
    paramList.append(paramArrayOfLong);
    paramList.append(");");
    paramList1 = paramList.toString();
    paramArrayOfLong = (StoryConfigManager)SuperManager.a(10);
    paramList = "";
    localObject1 = (String)paramArrayOfLong.b("key_album_debug_sse", "");
    paramArrayOfLong = paramList1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split(";");
      paramArrayOfLong = paramList;
      i = j;
      for (;;)
      {
        paramList = paramArrayOfLong;
        if (i >= localObject1.length) {
          break;
        }
        paramList = new StringBuilder();
        paramList.append(localObject1[i]);
        paramList.append(paramArrayOfLong);
        paramArrayOfLong = paramList.toString();
        if (i == 8)
        {
          paramList = paramArrayOfLong;
          break;
        }
        i += 1;
      }
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append(paramList1);
      paramArrayOfLong.append(paramList);
      paramArrayOfLong = paramArrayOfLong.toString();
    }
    return paramArrayOfLong;
  }
  
  private List<T> a(List<List<T>> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 2))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        if (((List)paramList.get(i)).size() > 0) {
          localArrayList.add(a((List)paramList.get(i)));
        } else {
          SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.kmeans", "点位置相同时，有空的堆出现");
        }
        i += 1;
      }
      return localArrayList;
    }
    return this.a;
  }
  
  private List<List<T>> a(List<T> paramList1, List<T> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList2 != null) && (paramList2.size() >= 2))
    {
      int j = paramList2.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new ArrayList());
        i += 1;
      }
      j = 0;
      while (j < paramList1.size())
      {
        Object localObject = paramList1.get(j);
        long l1 = -1L;
        i = 0;
        int k = 0;
        while (i < paramList2.size())
        {
          long l3 = a(localObject, paramList2.get(i));
          long l2;
          if (l1 != -1L)
          {
            l2 = l1;
            if (l1 <= l3) {}
          }
          else
          {
            k = i;
            l2 = l3;
          }
          i += 1;
          l1 = l2;
        }
        ((List)localArrayList.get(k)).add(localObject);
        j += 1;
      }
      return localArrayList;
    }
    localArrayList.add(paramList1);
    return localArrayList;
  }
  
  private boolean a(List<T> paramList1, List<T> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      if (!a(paramList1.get(i), paramList2.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private T b(List<T> paramList)
  {
    long l2 = -1L;
    int i = 0;
    int j = 0;
    while (i < this.b.size())
    {
      long l1 = -1L;
      int k = 0;
      while (k < paramList.size())
      {
        long l4 = a(paramList.get(k), this.b.get(i));
        if (l4 == 0L)
        {
          l1 = -1L;
          break;
        }
        if (l1 >= 0L)
        {
          l3 = l1;
          if (l4 >= l1) {}
        }
        else
        {
          l3 = l4;
        }
        k += 1;
        l1 = l3;
      }
      long l3 = l2;
      if (l1 > l2)
      {
        j = i;
        l3 = l1;
      }
      i += 1;
      l2 = l3;
    }
    return this.b.get(j);
  }
  
  protected abstract double a();
  
  protected int a()
  {
    return 100;
  }
  
  protected abstract long a(T paramT1, T paramT2);
  
  protected abstract T a(List<T> paramList);
  
  public List<List<T>> a(int paramInt1, List<T> paramList, long[] paramArrayOfLong, int paramInt2)
  {
    this.a = paramList;
    paramInt1 = 0;
    while (paramInt1 < 50)
    {
      this.c = a(this.b, this.a);
      paramList = a(this.c);
      if (a(this.a, paramList)) {
        break;
      }
      this.a = paramList;
      paramInt1 += 1;
    }
    long l = 0L;
    paramInt1 = 0;
    while (paramInt1 < this.c.size())
    {
      paramList = (List)this.c.get(paramInt1);
      Object localObject = this.a.get(paramInt1);
      int i = 0;
      while (i < paramList.size())
      {
        l += a(localObject, paramList.get(i));
        i += 1;
      }
      paramInt1 += 1;
    }
    if (paramArrayOfLong != null) {
      paramArrayOfLong[paramInt2] = l;
    }
    return this.c;
  }
  
  public List<List<T>> a(int paramInt1, long[] paramArrayOfLong, int paramInt2)
  {
    this.a = new ArrayList();
    this.a.add(this.b.get(0));
    int i = 1;
    while (i < paramInt1)
    {
      Object localObject = b(this.a);
      this.a.add(localObject);
      i += 1;
    }
    this.c = a(paramInt1, this.a, paramArrayOfLong, paramInt2);
    return this.c;
  }
  
  public List<List<T>> a(List<T> paramList, String[] paramArrayOfString)
  {
    Object localObject = this.b;
    this.b = paramList;
    int i = Math.min(Math.min(this.b.size() - 2, 20), a());
    if (i <= 0) {
      i = 1;
    }
    paramList = new long[i];
    localObject = new ArrayList(i);
    for (int j = 0; j < i; j = k)
    {
      k = j + 1;
      ((List)localObject).add(a(k, paramList, j));
    }
    i = (paramList.length - 1) / 2;
    int k = 0;
    int m = 0;
    j = 1;
    while (k < paramList.length)
    {
      int n;
      if (k == 0)
      {
        n = m;
      }
      else
      {
        int i1 = k - 1;
        if ((a(paramList[i1] - paramList[k])) && (m != 0))
        {
          n = m;
        }
        else
        {
          double d1 = paramList[i1] - paramList[k];
          double d2 = paramList[i1];
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
          if (((d1 < a()) || (a(paramList[i1] - paramList[k]))) && (j != 0))
          {
            i = i1;
            n = 1;
            j = 0;
          }
          else
          {
            n = m;
            if (d1 > a())
            {
              i = i1;
              j = 1;
              n = m;
            }
          }
        }
      }
      k += 1;
      m = n;
    }
    this.c = ((List)((List)localObject).get(i));
    paramList = a(paramList, (List)localObject, this.c);
    if (paramArrayOfString != null) {
      paramArrayOfString[0] = paramList;
    }
    return this.c;
  }
  
  public void a(List<T> paramList)
  {
    List localList = this.b;
    this.b = paramList;
  }
  
  protected boolean a(long paramLong)
  {
    return false;
  }
  
  protected abstract boolean a(T paramT1, T paramT2);
  
  protected int b()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.kmeans.KmeansPlus
 * JD-Core Version:    0.7.0.1
 */