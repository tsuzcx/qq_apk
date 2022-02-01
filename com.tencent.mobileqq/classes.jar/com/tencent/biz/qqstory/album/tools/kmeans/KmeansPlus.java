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
    int j = 0;
    String[] arrayOfString = new String[paramArrayOfLong.length];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (List)paramList.next();
      arrayOfString[i] = ("k=" + i + ":");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        List localList = (List)((Iterator)localObject).next();
        arrayOfString[i] = (arrayOfString[i] + "+" + String.valueOf(localList.size()));
      }
      i += 1;
    }
    paramArrayOfLong = Arrays.toString(paramArrayOfLong);
    SLog.d("Q.qqstory.recommendAlbum.logic.StoryScanManager.K_means", "kmeans run k=" + paramList1.size() + " sse : " + paramArrayOfLong + " temp=" + Arrays.toString(arrayOfString));
    paramList1 = "(k=" + paramList1.size() + " " + paramArrayOfLong + ");";
    paramArrayOfLong = (String)((StoryConfigManager)SuperManager.a(10)).b("key_album_debug_sse", "");
    if (!TextUtils.isEmpty(paramArrayOfLong))
    {
      arrayOfString = paramArrayOfLong.split(";");
      paramArrayOfLong = "";
      i = j;
      for (;;)
      {
        paramList = paramArrayOfLong;
        if (i < arrayOfString.length)
        {
          paramArrayOfLong = arrayOfString[i] + paramArrayOfLong;
          if (i == 8) {
            paramList = paramArrayOfLong;
          }
        }
        else
        {
          return paramList1 + paramList;
        }
        i += 1;
      }
    }
    return paramList1;
  }
  
  private List<T> a(List<List<T>> paramList)
  {
    if ((paramList == null) || (paramList.size() < 2)) {
      return this.a;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      if (((List)paramList.get(i)).size() > 0) {
        localArrayList.add(a((List)paramList.get(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        SLog.e("Q.qqstory.recommendAlbum.logic.StoryScanManager.kmeans", "点位置相同时，有空的堆出现");
      }
    }
    return localArrayList;
  }
  
  private List<List<T>> a(List<T> paramList1, List<T> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList2 == null) || (paramList2.size() < 2))
    {
      localArrayList.add(paramList1);
      return localArrayList;
    }
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
      i = 0;
      int k = 0;
      long l2;
      for (long l1 = -1L; i < paramList2.size(); l1 = l2)
      {
        long l3 = a(localObject, paramList2.get(i));
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
      }
      ((List)localArrayList.get(k)).add(localObject);
      j += 1;
    }
    return localArrayList;
  }
  
  private boolean a(List<T> paramList1, List<T> paramList2)
  {
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label57;
      }
      if (!a(paramList1.get(i), paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label57:
    return true;
  }
  
  private T b(List<T> paramList)
  {
    int j = 0;
    long l2 = -1L;
    int i = 0;
    long l1;
    int k;
    label30:
    long l4;
    if (i < this.b.size())
    {
      l1 = -1L;
      k = 0;
      if (k >= paramList.size()) {
        break label153;
      }
      l4 = a(paramList.get(k), this.b.get(i));
      if (l4 == 0L) {
        l1 = -1L;
      }
    }
    label153:
    for (;;)
    {
      long l3 = l2;
      if (l1 > l2)
      {
        j = i;
        l3 = l1;
      }
      i += 1;
      l2 = l3;
      break;
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
      break label30;
      return this.b.get(j);
    }
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
    long l;
    if (paramInt1 < 50)
    {
      this.c = a(this.b, this.a);
      paramList = a(this.c);
      if (!a(this.a, paramList)) {}
    }
    else
    {
      l = 0L;
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 >= this.c.size()) {
        break label155;
      }
      paramList = (List)this.c.get(paramInt1);
      Object localObject = this.a.get(paramInt1);
      int i = 0;
      for (;;)
      {
        if (i < paramList.size())
        {
          l += a(localObject, paramList.get(i));
          i += 1;
          continue;
          this.a = paramList;
          paramInt1 += 1;
          break;
        }
      }
      paramInt1 += 1;
    }
    label155:
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
    if (this.b == null) {}
    this.b = paramList;
    int i = Math.min(Math.min(this.b.size() - 2, 20), a());
    if (i > 0) {}
    ArrayList localArrayList;
    int j;
    for (;;)
    {
      paramList = new long[i];
      localArrayList = new ArrayList(i);
      j = 0;
      while (j < i)
      {
        localArrayList.add(a(j + 1, paramList, j));
        j += 1;
      }
      i = 1;
    }
    int i1 = (paramList.length - 1) / 2;
    int i2 = 1;
    int n = 0;
    int k = 0;
    if (k < paramList.length)
    {
      int m;
      if (k == 0)
      {
        j = i1;
        i = i2;
        m = n;
      }
      for (;;)
      {
        k += 1;
        n = m;
        i2 = i;
        i1 = j;
        break;
        if (a(paramList[(k - 1)] - paramList[k]))
        {
          m = n;
          i = i2;
          j = i1;
          if (n != 0) {}
        }
        else
        {
          double d = (paramList[(k - 1)] - paramList[k]) / paramList[(k - 1)];
          if (((d < a()) || (a(paramList[(k - 1)] - paramList[k]))) && (i2 != 0))
          {
            j = k - 1;
            i = 0;
            m = 1;
          }
          else
          {
            m = n;
            i = i2;
            j = i1;
            if (d > a())
            {
              i = 1;
              j = k - 1;
              m = n;
            }
          }
        }
      }
    }
    this.c = ((List)localArrayList.get(i1));
    paramList = a(paramList, localArrayList, this.c);
    if (paramArrayOfString != null) {
      paramArrayOfString[0] = paramList;
    }
    return this.c;
  }
  
  public void a(List<T> paramList)
  {
    if (this.b == null) {}
    this.b = paramList;
  }
  
  protected boolean a(long paramLong)
  {
    return false;
  }
  
  protected abstract boolean a(T paramT1, T paramT2);
  
  protected int b()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.kmeans.KmeansPlus
 * JD-Core Version:    0.7.0.1
 */