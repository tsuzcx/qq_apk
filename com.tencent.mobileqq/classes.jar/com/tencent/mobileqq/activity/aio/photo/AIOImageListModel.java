package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.service.message.MessageCache;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class AIOImageListModel
  implements AbstractImageListModel
{
  public static final Object j = new Object();
  public static final Object k = new Object();
  AIORichMediaInfo a;
  AIORichMediaInfo b;
  int c;
  int d;
  int e;
  List<AIORichMediaInfo> f = new ArrayList();
  List<AIORichMediaInfo> g = new ArrayList();
  List<AIORichMediaInfo> h = new ArrayList();
  boolean i = false;
  List<Object> l = new ArrayList();
  int m = 0;
  int n = -1;
  int o;
  boolean p = false;
  boolean q = false;
  boolean r = false;
  boolean s = false;
  AIORichExpandInfo t = new AIORichExpandInfo();
  private Calendar u = null;
  private String v = null;
  
  public AIOImageListModel(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  private void a(int paramInt, String paramString, AIOFilePicData paramAIOFilePicData)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 16)
      {
        if (paramInt != 18)
        {
          if (paramInt != 20) {
            return;
          }
          paramAIOFilePicData.h = true;
          return;
        }
        paramAIOFilePicData.g = true;
        return;
      }
      paramAIOFilePicData.i = true;
      return;
    }
    if (paramInt != 16)
    {
      if (paramInt != 18)
      {
        if (paramInt != 20) {
          return;
        }
        paramAIOFilePicData.e = paramString;
        return;
      }
      paramAIOFilePicData.d = paramString;
      return;
    }
    paramAIOFilePicData.c = paramString;
  }
  
  private void a(int paramInt, String paramString, AIOImageData paramAIOImageData)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            return;
          }
          paramAIOImageData.g = true;
          return;
        }
        paramAIOImageData.f = true;
        return;
      }
      paramAIOImageData.e = true;
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 8) {
            return;
          }
          paramAIOImageData.d = paramString;
          return;
        }
        paramAIOImageData.c = paramString;
        return;
      }
      paramAIOImageData.b = paramString;
      if (!paramAIOImageData.t)
      {
        paramString = new StringBuilder();
        paramString.append(paramAIOImageData.a);
        paramString.append("_hd");
        if (new File(paramString.toString()).exists())
        {
          paramString = new StringBuilder();
          paramString.append(paramAIOImageData.a);
          paramString.append("_hd");
          paramAIOImageData.a = paramString.toString();
        }
      }
    }
    else
    {
      paramAIOImageData.a = paramString;
    }
  }
  
  private void a(int paramInt, String paramString, AIOShortVideoData paramAIOShortVideoData)
  {
    if ("I:E".equals(paramString))
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        paramAIOShortVideoData.f = true;
        return;
      }
      paramAIOShortVideoData.e = true;
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramAIOShortVideoData.b = paramString;
      return;
    }
    paramAIOShortVideoData.a = paramString;
  }
  
  public int a()
  {
    List localList = this.g;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    List localList;
    if (paramBoolean) {
      localList = this.l;
    } else {
      localList = this.g;
    }
    int i1 = 0;
    while (i1 < localList.size())
    {
      Object localObject = localList.get(i1);
      if ((!paramBoolean) || (AIORichMediaInfo.class.isInstance(localObject)))
      {
        localObject = ((AIORichMediaInfo)localObject).a;
        if (AIOImageData.class.isInstance(localObject))
        {
          localObject = (AIOImageData)localObject;
          if ((((AIOImageData)localObject).L == paramLong) && (((AIOImageData)localObject).M == paramInt1))
          {
            a(paramInt2, paramString, (AIOImageData)localObject);
            return i1;
          }
        }
        else if (AIOShortVideoData.class.isInstance(localObject))
        {
          localObject = (AIOShortVideoData)localObject;
          if (((AIOShortVideoData)localObject).L == paramLong)
          {
            a(paramInt2, paramString, (AIOShortVideoData)localObject);
            return i1;
          }
        }
        else if (AIOFilePicData.class.isInstance(localObject))
        {
          localObject = (AIOFilePicData)localObject;
          if (((AIOFilePicData)localObject).L == paramLong)
          {
            a(paramInt2, paramString, (AIOFilePicData)localObject);
            return i1;
          }
        }
        else if ((AIOFileVideoData.class.isInstance(localObject)) && (((AIOFileVideoData)localObject).L == paramLong))
        {
          return i1;
        }
      }
      i1 += 1;
    }
    return -1;
  }
  
  public AIORichMediaInfo a(int paramInt)
  {
    if ((paramInt < this.g.size()) && (paramInt >= 0)) {
      return (AIORichMediaInfo)this.g.get(paramInt);
    }
    return null;
  }
  
  public AIORichMediaInfo a(long paramLong)
  {
    Object localObject3 = null;
    try
    {
      Iterator localIterator = this.g.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AIORichMediaInfo)localIterator.next();
      } while (((AIORichMediaInfo)localObject1).a.L != paramLong);
      if (localObject1 != null)
      {
        this.f.remove(localObject1);
        this.g.remove(localObject1);
        a(true, this.f);
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    int i1 = paramCalendar.get(1);
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(2);
    if ((i1 == i2) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3 + 1) });
  }
  
  public List<AIORichMediaInfo> a(List<AIORichMediaInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.r)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)paramList.next();
        if (!AIOImageProviderService.a(localAIORichMediaInfo.a)) {
          localArrayList.add(localAIORichMediaInfo);
        }
      }
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.f.clear();
    this.g.clear();
    this.c = 0;
    this.b = paramAIORichMediaInfo;
    AIORichMediaInfo localAIORichMediaInfo = this.b;
    localAIORichMediaInfo.i = true;
    this.a = localAIORichMediaInfo;
    this.f.add(paramAIORichMediaInfo);
    this.g.add(paramAIORichMediaInfo);
    a(false, this.f);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.p != paramBoolean)
    {
      this.p = paramBoolean;
      Collections.reverse(this.g);
      this.c = (this.g.size() - 1 - this.c);
    }
  }
  
  public void a(boolean paramBoolean, List<AIORichMediaInfo> paramList)
  {
    int i1 = this.m;
    if (i1 == 0) {
      return;
    }
    if (paramBoolean)
    {
      this.l.clear();
      this.n = -1;
      this.v = null;
    }
    else
    {
      this.t.b(this.l, i1);
    }
    if (this.u == null)
    {
      this.u = Calendar.getInstance();
      this.u.setTimeInMillis(MessageCache.c() * 1000L);
    }
    i1 = paramList.size();
    boolean bool2 = true;
    i1 -= 1;
    for (;;)
    {
      int i3 = 0;
      if (i1 < 0) {
        break;
      }
      localObject = (AIORichMediaInfo)paramList.get(i1);
      String str = a(this.u, ((AIORichMediaInfo)localObject).a.N);
      if (!str.equals(this.v))
      {
        this.v = str;
        int i2 = this.n;
        if (i2 != -1)
        {
          int i4 = i2 % this.m;
          if (i4 > 0)
          {
            i2 = 0;
            while (i2 < this.m - i4)
            {
              this.l.add(k);
              i2 += 1;
            }
          }
        }
        this.n = 0;
        this.l.add(str);
        i2 = i3;
        while (i2 < this.m - 1)
        {
          this.l.add(j);
          i2 += 1;
        }
      }
      this.l.add(localObject);
      this.n += 1;
      i1 -= 1;
    }
    Object localObject = this.t;
    boolean bool1 = bool2;
    if (!paramBoolean) {
      if (paramList.isEmpty()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    ((AIORichExpandInfo)localObject).a(bool1, this.m, this.l);
  }
  
  public boolean a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = paramArrayOfAIORichMediaData.length - 1;
    Object localObject;
    if (i1 >= 0)
    {
      localObject = paramArrayOfAIORichMediaData[i1];
      if ((this.a == null) || (this.b == null))
      {
        localObject = new AIORichMediaInfo((AIORichMediaData)localObject);
        this.b = ((AIORichMediaInfo)localObject);
        this.a = ((AIORichMediaInfo)localObject);
      }
    }
    i1 = 0;
    while (i1 < paramArrayOfAIORichMediaData.length)
    {
      localObject = paramArrayOfAIORichMediaData[i1];
      if (this.i)
      {
        localArrayList.add(new AIORichMediaInfo((AIORichMediaData)localObject));
      }
      else if ((this.a.a.L == ((AIORichMediaData)localObject).L) && (this.a.a.M == ((AIORichMediaData)localObject).M))
      {
        localObject = this.a;
        ((AIORichMediaInfo)localObject).i = true;
        if (localObject == this.b) {
          this.q = true;
        }
        localArrayList.add(this.a);
      }
      else if ((this.b.a.L == ((AIORichMediaData)localObject).L) && (this.b.a.M == ((AIORichMediaData)localObject).M))
      {
        localArrayList.add(this.b);
      }
      else
      {
        localArrayList.add(new AIORichMediaInfo((AIORichMediaData)localObject));
      }
      i1 += 1;
    }
    if (paramInt >= 0) {
      paramInt = paramArrayOfAIORichMediaData.length;
    }
    if (this.i)
    {
      this.h.addAll(0, localArrayList);
      return false;
    }
    if (!this.q) {
      return false;
    }
    this.f = localArrayList;
    this.g = a(localArrayList);
    if (this.p) {
      Collections.reverse(this.g);
    }
    paramArrayOfAIORichMediaData = this.a;
    if (paramArrayOfAIORichMediaData != null) {
      this.c = this.g.indexOf(paramArrayOfAIORichMediaData);
    }
    paramInt = this.c;
    if ((paramInt < 0) || (paramInt >= this.g.size())) {
      this.c = this.f.indexOf(this.a);
    }
    a(true, this.f);
    this.i = true;
    return true;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    this.b = a(paramInt);
    this.o = this.l.indexOf(this.b);
  }
  
  public void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.f.remove(paramAIORichMediaInfo);
    this.g.remove(paramAIORichMediaInfo);
    a(true, this.f);
  }
  
  public AIORichMediaInfo c()
  {
    return this.b;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public AIORichMediaInfo e()
  {
    return this.a;
  }
  
  public void e(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int f()
  {
    List localList = this.f;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public void f(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void g(int paramInt)
  {
    this.o = paramInt;
    Object localObject = h(paramInt);
    if (!AIORichMediaInfo.class.isInstance(localObject)) {
      return;
    }
    this.b = ((AIORichMediaInfo)localObject);
    this.c = this.g.indexOf(this.b);
  }
  
  public boolean g()
  {
    return this.t.a(this.l, this.m);
  }
  
  public Object h(int paramInt)
  {
    return this.l.get(paramInt);
  }
  
  public boolean h()
  {
    if (!this.q) {
      return false;
    }
    int i1 = this.h.size();
    if (i1 > 0)
    {
      this.d += i1;
      this.e += i1;
      this.f.addAll(0, this.h);
      List localList = a(this.h);
      a(false, localList);
      if (this.p)
      {
        Collections.reverse(localList);
        this.g.addAll(localList);
      }
      else
      {
        this.c += localList.size();
        this.g.addAll(0, localList);
      }
      this.h.clear();
      return true;
    }
    return false;
  }
  
  public List<AIORichMediaInfo> i()
  {
    return this.g;
  }
  
  public int j()
  {
    return this.d;
  }
  
  public int k()
  {
    return this.e;
  }
  
  public int l()
  {
    return this.o;
  }
  
  public int m()
  {
    return this.l.size();
  }
  
  public int n()
  {
    return m() + this.t.a();
  }
  
  public void o()
  {
    if ((this.l.size() == 0) && (this.f.size() > 0))
    {
      a(false, this.f);
      this.o = this.l.indexOf(this.b);
    }
  }
  
  public void p()
  {
    a(true, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListModel
 * JD-Core Version:    0.7.0.1
 */